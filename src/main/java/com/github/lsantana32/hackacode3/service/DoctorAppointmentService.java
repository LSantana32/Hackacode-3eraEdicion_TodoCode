package com.github.lsantana32.hackacode3.service;

import com.github.lsantana32.hackacode3.dao.DoctorAppointmentRepository;
import com.github.lsantana32.hackacode3.entity.DoctorAppointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorAppointmentService {
    private DoctorAppointmentRepository doctorAppointmentRepository;

    @Autowired
    public DoctorAppointmentService(DoctorAppointmentRepository doctorAppointmentRepository) {
        this.doctorAppointmentRepository = doctorAppointmentRepository;
    }
    public void register(DoctorAppointment doctorAppointment) {
    }
}
