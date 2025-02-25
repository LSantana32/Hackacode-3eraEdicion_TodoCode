package com.github.lsantana32.hackacode3.Setter;

import com.github.lsantana32.hackacode3.entity.MedicalService;

public interface MedicalServiceSetter {
    static void setMedicalService(MedicalService medicalService, MedicalService newMedicalService){
        medicalService.setName(newMedicalService.getName());
        medicalService.setPrice(newMedicalService.getPrice());
        medicalService.setType(newMedicalService.getType());
        medicalService.setDescription(newMedicalService.getDescription());
        medicalService.setServicePackage(newMedicalService.getServicePackage());
    }
}
