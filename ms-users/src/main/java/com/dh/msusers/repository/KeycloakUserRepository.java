package com.dh.msusers.repository;

import com.dh.msusers.model.User;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class KeycloakUserRepository implements IUserRepository {

    @Autowired
    private Keycloak keycloak;

    @Value("${dh.keycloak.realm}")
    private String realm;

    private User fromRepresentation(UserRepresentation userRepresentation) {
        return User.builder()
                .id(userRepresentation.getId())
                .name(userRepresentation.getFirstName() + " " + userRepresentation.getLastName())
                .dni(userRepresentation.getAttributes().get("dni").get(0))
                .email(userRepresentation.getEmail()).build();
    }

    @Override
    public User findById(String id) {
        UserResource userResource = keycloak
                .realm(realm)
                .users().get(id);

        UserRepresentation userRepresentation = userResource.toRepresentation();
        return fromRepresentation(userRepresentation);
    }

}
