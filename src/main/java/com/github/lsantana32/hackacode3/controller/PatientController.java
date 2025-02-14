package com.github.lsantana32.hackacode3.controller;

import com.github.lsantana32.hackacode3.entity.Patient;
import com.github.lsantana32.hackacode3.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/patient")
public class PatientController {
    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    /**
     * Register a new patient
     * Endpoint: /api/patient
     * method: POST
     * example: http://localhost:8080/patient -H 'Content-Type: application/json' -d '{"name": "John Doe", "dni": "123456789"}'
     * @param patient
     */
    @PostMapping
    public ResponseEntity<String> registerPatient(@RequestBody Patient patient) {
        try {
            patientService.register(patient.getDni(), patient);
            return ResponseEntity.ok("Patient registered successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    /**
     * Get a patient by ID
     * Endpoint: /api/patient/{id}
     * method: GET
     * example: http://localhost:8080/patient/1
     * @param id
     */
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Patient>> getPatient(@PathVariable int id) {
        try {
            return ResponseEntity.ok(patientService.getById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Delete a patient by ID
     * Endpoint: /api/patient/{id}
     * method: DELETE
     * example: http://localhost:8080/patient/1
     * @param id
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable int id) {
        try {
            patientService.delete(id);
            return ResponseEntity.ok("Patient deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    /**
     * Update a patient by ID
     * Endpoint: /api/patient/{id}
     * method: PUT
     * example: http://localhost:8080/patient/1 -H 'Content-Type: application/json' -d '{"name": "John Doe", "dni": "123456789"}'
     * @param id
     * @param patient
     */
    @PutMapping("/{id}")
    public ResponseEntity<String> updatePatient(@PathVariable int id, @RequestBody Patient patient) {
        try {
            patientService.update(id, patient);
            return ResponseEntity.ok("Patient updated successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}
