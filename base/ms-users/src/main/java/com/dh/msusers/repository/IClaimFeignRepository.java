package com.dh.msusers.repository;

import com.dh.msusers.model.Claim;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "claim-service", url = "http://localhost:8083/")
public interface IClaimFeignRepository {

    @GetMapping("/{userId}")
    List<Claim> getClaims(@PathVariable String userId);

}
