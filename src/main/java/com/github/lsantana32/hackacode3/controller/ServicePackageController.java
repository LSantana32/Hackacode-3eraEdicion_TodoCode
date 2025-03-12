package com.github.lsantana32.hackacode3.controller;

import com.github.lsantana32.hackacode3.entity.ServicePackage;
import com.github.lsantana32.hackacode3.service.ServicePackageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service-package")
public class ServicePackageController {
    private final ServicePackageService servicePackageService;

    public ServicePackageController(ServicePackageService servicePackageService) {
        this.servicePackageService = servicePackageService;
    }

    /**
     * Register a new service package
     * @param servicePackage
     * keys:
     *     services (add from medicalService)
     *     price
     *     medicalInsurancePatient
     *     doctorAppointment (add from doctorAppointment)
     */
    @PostMapping
    public ResponseEntity<String> registerServicePackage(@RequestBody ServicePackage servicePackage) {
        try {
            servicePackageService.register(servicePackage);
            return ResponseEntity.ok("Service package registered successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    /**
     * Get all service packages
     * @return List of service packages
     */
    @GetMapping
    public ResponseEntity<String> getAllServicePackages() {
        try {
            return ResponseEntity.ok(servicePackageService.getAll().toString());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    /**
     * Get a service package by ID
     * @param id
     * @return Service package
     */
    @GetMapping("/{id}")
    public ResponseEntity<String> getServicePackage(@PathVariable long id) {
        try {
            return ResponseEntity.ok(servicePackageService.getById(id).toString());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    /**
     * Update a service package by ID
     * @param id
     * @param servicePackage
     */
    @PostMapping("/{id}")
    public ResponseEntity<String> updateServicePackage(@PathVariable long id, @RequestBody ServicePackage servicePackage) {
        try {
            servicePackageService.update(id, servicePackage);
            return ResponseEntity.ok("Service package updated successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    /**
     * Delete a service package by ID
     * @param id
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteServicePackage(@PathVariable long id) {
        try {
            servicePackageService.delete(id);
            return ResponseEntity.ok("Service package deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }


}
