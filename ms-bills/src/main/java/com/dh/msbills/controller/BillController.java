package com.dh.msbills.controller;

import com.dh.msbills.models.Bill;
import com.dh.msbills.service.BillService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/bills")
@RequiredArgsConstructor
public class BillController {

    @Autowired
    private final BillService service;

    @GetMapping("/find-all/{customerBill}")
    @PreAuthorize("hasAnyAuthority('PROVIDER','READER')")
    public ResponseEntity<List<Bill>> getAll(@PathVariable String customerBill) {
        return ResponseEntity.ok().body(service.getAllBill(customerBill));
    }

    @PostMapping("/save")
    @RolesAllowed({"PROVIDER"})
    public ResponseEntity<?> save(@RequestBody Bill bill) {
        service.save(bill);
        return new ResponseEntity<>("Dados salvos com sucesso", HttpStatus.CREATED);
    }

}
