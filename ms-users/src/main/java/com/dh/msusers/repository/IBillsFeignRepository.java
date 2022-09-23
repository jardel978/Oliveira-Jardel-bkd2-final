package com.dh.msusers.repository;

import com.dh.msusers.model.Bills;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ms-bills", url = "lb://ms-bill")
public interface IBillsFeignRepository {

    @GetMapping("/bills/find-all/{customerBill}")
    List<Bills> getBills(@PathVariable String customerBill);

}
