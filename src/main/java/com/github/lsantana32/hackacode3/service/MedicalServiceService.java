package com.github.lsantana32.hackacode3.service;

import com.github.lsantana32.hackacode3.Setter.MedicalServiceSetter;
import com.github.lsantana32.hackacode3.entity.MedicalService;
import com.github.lsantana32.hackacode3.exception.MedicalServiceNotFoundException;
import com.github.lsantana32.hackacode3.parse.IterableToList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.lsantana32.hackacode3.dao.MedicalServiceRepository;
import com.github.lsantana32.hackacode3.validator.MedicalServiceValidator;

import java.util.List;
import java.util.Optional;


@Service
public class MedicalServiceService {
    MedicalServiceRepository medicalServiceRepository;

    @Autowired
    public MedicalServiceService(MedicalServiceRepository medicalServiceRepository) {
        this.medicalServiceRepository = medicalServiceRepository;
    }

    public void register(MedicalService medicalService) {
        MedicalServiceValidator.validateFields(medicalService, "id", "servicePackage");
        MedicalServiceValidator.validateNotExistenceByNameAndType(medicalService.getName(), medicalService.getType(), medicalServiceRepository);
        medicalServiceRepository.save(medicalService);
    }

    public void update(long id, MedicalService medicalServiceNew) {
        MedicalServiceValidator.validateFields(medicalServiceNew, "id", "servicePackage");
        MedicalServiceValidator.validateExistenceById(id, medicalServiceRepository, MedicalService.class);
        //see the commented line below
        //MedicalServiceValidator.validateNotExistenceByNameAndType(medicalServiceNew.getName(), medicalServiceNew.getType(), medicalServiceRepository);
        MedicalService medicalService = findById(id);
        MedicalServiceSetter.set(medicalService, medicalServiceNew);
        medicalServiceRepository.save(medicalService);
    }

    public void delete(long id) {
        MedicalServiceValidator.validateExistenceById(id, medicalServiceRepository, MedicalService.class);
        medicalServiceRepository.deleteById(id);
    }

    public Optional<MedicalService> getById(Long id) {
        MedicalServiceValidator.validateExistenceById(id, medicalServiceRepository, MedicalService.class);
        return medicalServiceRepository.findById(id);
    }

    public List<MedicalService> getAll() {
        return IterableToList.convert(medicalServiceRepository.findAll());
    }

    public MedicalService findById(Long id) {
        return medicalServiceRepository.findById(id).orElseThrow(() -> new MedicalServiceNotFoundException(id));
    }

    public Double getPriceFromServices(List<MedicalService> services) {
        double price=0.0;
        for (MedicalService service : services) {
            price+=findById(service.getId()).getPrice();
        }
        return price;
    }
}
