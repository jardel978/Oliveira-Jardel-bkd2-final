package com.dh.msusers.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Claim {

    private String id;
    private String motive;
    private String status;
    private String comments;
    private String userId;

}
