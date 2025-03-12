package com.github.lsantana32.hackacode3.service;

import com.github.lsantana32.hackacode3.Setter.ServicePackageSetter;
import com.github.lsantana32.hackacode3.dao.DoctorAppointmentRepository;
import com.github.lsantana32.hackacode3.entity.DoctorAppointment;
import com.github.lsantana32.hackacode3.parse.IterableToList;
import com.github.lsantana32.hackacode3.validator.DoctorAppointmentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.lsantana32.hackacode3.Setter.DoctorAppointmentSetter;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorAppointmentService {
    private DoctorAppointmentRepository doctorAppointmentRepository;
    private ServicePackageService servicePackageService;

    @Autowired
    public DoctorAppointmentService(DoctorAppointmentRepository doctorAppointmentRepository, ServicePackageService servicePackageService) {
        this.doctorAppointmentRepository = doctorAppointmentRepository;
        this.servicePackageService = servicePackageService;
    }
    public void register(DoctorAppointment doctorAppointment) {
        doctorAppointment.setPrice(servicePackageService.getPriceFromPackage(doctorAppointment.getServicePackage()));
        DoctorAppointmentValidator.validateFields(doctorAppointment, "price");
        doctorAppointmentRepository.save(DoctorAppointmentSetter.setPrice(doctorAppointment));
    }

    public void delete(long id) {
        DoctorAppointmentValidator.validateExistenceById(id, doctorAppointmentRepository, DoctorAppointment.class);
        doctorAppointmentRepository.deleteById(id);
    }

    public Optional<DoctorAppointment> getById(long id) {
        DoctorAppointmentValidator.validateExistenceById(id, doctorAppointmentRepository, DoctorAppointment.class);
        return doctorAppointmentRepository.findById(id);
    }

    public List<DoctorAppointment> getAll() {
        return IterableToList.convert(doctorAppointmentRepository.findAll());
    }

    public void update(long id, DoctorAppointment doctorAppointment) {
        DoctorAppointmentValidator.validateFields(doctorAppointment);
        DoctorAppointmentValidator.validateExistenceById(id, doctorAppointmentRepository, DoctorAppointment.class);
        DoctorAppointment doctorAppointmentToUpdate = doctorAppointmentRepository.findById(id).get();
        DoctorAppointmentSetter.set(doctorAppointmentToUpdate, doctorAppointment);
        doctorAppointmentRepository.save(doctorAppointmentToUpdate);
    }
}
