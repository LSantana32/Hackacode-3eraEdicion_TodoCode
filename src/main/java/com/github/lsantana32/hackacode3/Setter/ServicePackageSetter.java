package com.github.lsantana32.hackacode3.Setter;

import com.github.lsantana32.hackacode3.entity.ServicePackage;

public interface ServicePackageSetter {
    static void setServicePackage(ServicePackage servicePackage, ServicePackage newServicePackage){
        servicePackage.setServices(newServicePackage.getServices());
        servicePackage.setPrice(newServicePackage.getPrice());
        servicePackage.setMedicalInsurancePatient(newServicePackage.getMedicalInsurancePatient());
        servicePackage.setDoctorAppointment(newServicePackage.getDoctorAppointment());
    }
}
