package com.possystem.possystem.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.possystem.possystem.dto.DebtDTO;
import com.possystem.possystem.services.DebtService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/debts")
public class DebtController {

    @Autowired
    private DebtService debtService;

    @GetMapping("/list")
    public ResponseEntity<List<DebtDTO>> getAllDebts() {
        List<DebtDTO> debts = debtService.findAll();
        return ResponseEntity.ok().body(debts);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<DebtDTO> getDebtByName(@PathVariable String name) {
        Optional<DebtDTO> debtDTOOptionalByName = debtService.findByName(name);
        if (debtDTOOptionalByName.isPresent()) {
            return ResponseEntity.ok().body(debtDTOOptionalByName.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/create")
    public ResponseEntity<DebtDTO> createDebt(@Valid @RequestBody DebtDTO debtDTO) {
        DebtDTO createDebt = debtService.save(debtDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createDebt);
    }

    @PutMapping("/update/{name}")
    public ResponseEntity<DebtDTO> updateDebt(@PathVariable String name, @Valid @RequestBody DebtDTO debtDTO) {
        Optional<DebtDTO> existingDebtOptional = debtService.findByName(name);
        if (!existingDebtOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        DebtDTO existingDebt = existingDebtOptional.get();
        existingDebt.setName(debtDTO.getName());
        existingDebt.setDescription(debtDTO.getDescription());
        existingDebt.setLeavemoney(debtDTO.getLeavemoney());
        existingDebt.setSubtract(debtDTO.getSubtract());
        existingDebt.setTotal(debtDTO.getTotal());
        DebtDTO updatedDebt = debtService.save(existingDebt);
        return ResponseEntity.ok().body(updatedDebt);
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<Void> deleteDebtByName(@PathVariable String name) {
        debtService.deleteByName(name);
        return ResponseEntity.noContent().build();
    }
}
