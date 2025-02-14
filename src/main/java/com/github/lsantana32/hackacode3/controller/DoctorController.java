package com.github.lsantana32.hackacode3.controller;

import com.github.lsantana32.hackacode3.entity.Doctor;
import com.github.lsantana32.hackacode3.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    /**
     * Register a new doctor
     * Endpoint: /api/doctor
     * method: POST
     * example: http://localhost:8080/doctor -H 'Content-Type: application/json' -d '{"name": "John Doe", "dni": "123456789"}'
     * @param doctor
     */
    @PostMapping
    public ResponseEntity<String> registerDoctor(@RequestBody Doctor doctor) {
        try {
            doctorService.register(doctor.getDni(), doctor);
            return ResponseEntity.ok("Doctor registered successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    /**
     * Get a doctor by ID
     * Endpoint: /api/doctor/{id}
     * method: GET
     * example: http://localhost:8080/doctor/1
     * @param id
     * */
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Doctor>> getDoctor(@PathVariable int id) {
        try {
            return ResponseEntity.ok(doctorService.getById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Get all doctors
     * Endpoint: /api/doctor
     * method: GET
     * example: http://localhost:8080/doctor
     */
    @GetMapping
    public ResponseEntity<Iterable<Doctor>> getAllDoctors() {
        try {
            return ResponseEntity.ok(doctorService.getAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    /**
     * Delete a doctor by ID
     * Endpoint: /api/doctor/{id}
     * method: DELETE
     * example: http://localhost:8080/doctor/1
     * @param id
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable int id) {
        try {
            doctorService.delete(id);
            return ResponseEntity.ok("Doctor deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    /**
     * Update a doctor by ID
     * Endpoint: /api/doctor/{id}
     * method: PUT
     * example: http://localhost:8080/doctor/1 -H 'Content-Type: application/json' -d '{"name": "John Doe", "dni": "123456789"}'
     * @param id
     * @param doctor
     */
    @PutMapping("/{id}")
    public ResponseEntity<String> updateDoctor(@PathVariable int id, @RequestBody Doctor doctor) {
        try {
            doctorService.update(id, doctor);
            return ResponseEntity.ok("Doctor updated successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}

