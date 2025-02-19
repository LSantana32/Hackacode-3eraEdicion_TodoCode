package com.github.lsantana32.hackacode3.controller;

import com.github.lsantana32.hackacode3.entity.MedicalService;
import com.github.lsantana32.hackacode3.service.MedicalServiceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medical-service")
public class MedicalServiceController {
    private final MedicalServiceService medicalServiceService;

    public MedicalServiceController(MedicalServiceService medicalServiceService) {
        this.medicalServiceService = medicalServiceService;
    }

    /**
     * Register a new medical service
     * @param medicalService
     */
    @PostMapping
    public ResponseEntity<String> registerMedicalService(@RequestBody MedicalService medicalService) {
        try {
            medicalServiceService.register(medicalService);
            return ResponseEntity.ok("Medical service registered successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    /**
     * Get all medical services
     * @return List of medical services
     */
    @GetMapping
    public ResponseEntity<String> getAllMedicalServices() {
        try {
            return ResponseEntity.ok(medicalServiceService.getAll().toString());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    /**
     * Get a medical service by ID
     * @param id
     * @return Medical service
     */
    @GetMapping("/{id}")
    public ResponseEntity<String> getMedicalService(@PathVariable long id) {
        try {
            return ResponseEntity.ok(medicalServiceService.getById(id).toString());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    /**
     * Update a medical service by ID
     * @param id
     * @param medicalService
     */
    @PostMapping("/{id}")
    public ResponseEntity<String> updateMedicalService(@PathVariable long id, @RequestBody MedicalService medicalService) {
        try {
            medicalServiceService.update(id, medicalService);
            return ResponseEntity.ok("Medical service updated successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    /**
     * Delete a medical service by ID
     * @param id
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMedicalService(@PathVariable long id) {
        try {
            medicalServiceService.delete(id);
            return ResponseEntity.ok("Medical service deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}
