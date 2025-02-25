package com.github.lsantana32.hackacode3.service;

import com.github.lsantana32.hackacode3.Setter.ServicePackageSetter;
import com.github.lsantana32.hackacode3.dao.ServicePackageRepository;
import com.github.lsantana32.hackacode3.entity.ServicePackage;
import com.github.lsantana32.hackacode3.exception.MedicalServiceNotFoundException;
import com.github.lsantana32.hackacode3.parse.IterableToList;
import com.github.lsantana32.hackacode3.validator.ServicePackageValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ServicePackageService {
    ServicePackageRepository servicePackageRepository;

    @Autowired
    public ServicePackageService(ServicePackageRepository servicePackageRepository) {
        this.servicePackageRepository = servicePackageRepository;
    }

    public void register(ServicePackage servicePackage) {
        ServicePackageValidator.validateFields(servicePackage, "doctorAppointment", "services");
        // i will done the validation field per field later
        servicePackageRepository.save(servicePackage);
    }

    public void update(long id, ServicePackage servicePackageNew) {
        ServicePackageValidator.validateFields(servicePackageNew, "doctorAppointment");
        ServicePackageValidator.validateExistenceById(id, servicePackageRepository, ServicePackage.class);
        // i will done the validation field per field later
        ServicePackage servicePackage = findById(id);
        ServicePackageSetter.setServicePackage(servicePackage, servicePackageNew);
        servicePackageRepository.save(servicePackage);
    }

    public void delete(long id) {
        ServicePackageValidator.validateExistenceById(id, servicePackageRepository, ServicePackage.class);
        servicePackageRepository.deleteById(id);
    }

    public Optional<ServicePackage> getById(Long id) {
        ServicePackageValidator.validateExistenceById(id, servicePackageRepository, ServicePackage.class);
        return servicePackageRepository.findById(id);
    }

    public List<ServicePackage> getAll() {
        return IterableToList.convert(servicePackageRepository.findAll());
    }

    public ServicePackage findById(Long id) {
        return servicePackageRepository.findById(id).orElseThrow(() -> new MedicalServiceNotFoundException(id));
    }
}
