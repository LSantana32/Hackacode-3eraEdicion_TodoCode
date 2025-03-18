package com.github.lsantana32.hackacode3.service;

import com.github.lsantana32.hackacode3.Setter.ServicePackageSetter;
import com.github.lsantana32.hackacode3.dao.DoctorAppointmentRepository;
import com.github.lsantana32.hackacode3.entity.DoctorAppointment;
import com.github.lsantana32.hackacode3.entity.Patient;
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
    private PatientPersonService patientPersonService;

    @Autowired
    public DoctorAppointmentService(DoctorAppointmentRepository doctorAppointmentRepository, ServicePackageService servicePackageService, PatientPersonService patientPersonService) {
        this.doctorAppointmentRepository = doctorAppointmentRepository;
        this.servicePackageService = servicePackageService;
        this.patientPersonService = patientPersonService;
    }
    public void register(DoctorAppointment doctorAppointment) {
        doctorAppointment.setPrice(servicePackagePrice(doctorAppointment) * discountOfMedicalInsurance(doctorAppointment.getPatient().getId()));
        DoctorAppointmentValidator.validateFields(doctorAppointment, "servicePackage");
        doctorAppointmentRepository.save(doctorAppointment);
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

    public Double servicePackagePrice (DoctorAppointment doctorAppointment) {
        return servicePackageService.getPriceFromPackage(doctorAppointment.getServicePackage());
    }

    public Double discountOfMedicalInsurance (Long idPatient) {
        Patient patient = patientPersonService.getById(idPatient).get();
        return (patient.getMedicalInsurance())?0.80 : 1;
    }
}
