package com.github.lsantana32.hackacode3.controller;

import com.github.lsantana32.hackacode3.entity.DoctorAppointment;
import com.github.lsantana32.hackacode3.service.DoctorAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor-appointment")
public class DoctorAppointmentController {
    private final DoctorAppointmentService doctorAppointmentService;

    @Autowired
    public DoctorAppointmentController(DoctorAppointmentService doctorAppointmentService) {
        this.doctorAppointmentService = doctorAppointmentService;
    }

    /**
     * Register a new doctor appointment
     * @param doctorAppointment
     * keys:
     *   date;
     *   time;
     *   patient;
     *   doctor;
     *   servicePackage;
     *   price paid
     */

    // PONER EL DESCUENTO ADICIONAL DEL SEGURO MEDICO EN CITA MEDICA, SACARLO DE SERVICEPACKAGE Y PONERLO EN DOCTORAPPOINTMENT. GOTY MAAAAL
    @PostMapping
    public ResponseEntity<String> registerDoctorAppointment(@RequestBody DoctorAppointment doctorAppointment) {
        try {
            doctorAppointmentService.register(doctorAppointment);
            return ResponseEntity.ok("Doctor appointment registered successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    /**
     * Delete a doctor appointment by ID
     *
     * @param id
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctorAppointment(@PathVariable long id) {
        try {
            doctorAppointmentService.delete(id);
            return ResponseEntity.ok("Doctor appointment deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    /**
     * Get a doctor appointment by ID
     * @param id
     * return Doctor appointment
     */
    @GetMapping("/{id}")
    public ResponseEntity<String> getDoctorAppointment(@PathVariable long id) {
        try {
            return ResponseEntity.ok(doctorAppointmentService.getById(id).toString());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    /**
     * Get all the doctor appointments
     * @return List of doctor appointments
     */
    @GetMapping
    public ResponseEntity<String> getAllDoctorAppointments() {
        try {
            return ResponseEntity.ok(doctorAppointmentService.getAll().toString());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    /**
     * Update a doctor appointment by ID
     * @param id
     * @param doctorAppointment
     */
    @PostMapping("/{id}")
    public ResponseEntity<String> updateDoctorAppointment(@PathVariable long id, @RequestBody DoctorAppointment doctorAppointment) {
        try {
            doctorAppointmentService.update(id, doctorAppointment);
            return ResponseEntity.ok("Doctor appointment updated successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}
