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
     */
     @PostMapping
        public ResponseEntity<String> registerDoctorAppointment(@RequestBody DoctorAppointment doctorAppointment) {
            try {
                doctorAppointmentService.register(doctorAppointment);
                return ResponseEntity.ok("Doctor appointment registered successfully");
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Error: " + e.getMessage());
            }
        }

}
