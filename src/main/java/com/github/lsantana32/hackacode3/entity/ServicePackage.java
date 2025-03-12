package com.github.lsantana32.hackacode3.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "service_packages")
public class ServicePackage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Double price;
    private Boolean medicalInsurancePatient;
    @ManyToMany
    @JoinTable(
            name = "service_packages_services",
            joinColumns = @JoinColumn(name = "service_package_fk"),
            inverseJoinColumns = @JoinColumn(name = "service_fk")
    )
    private List<MedicalService> services;

    public ServicePackage(int id, List<MedicalService> services, boolean medicalInsurancePatient) {
        this.id = id;
        this.services = services;
        this.medicalInsurancePatient = medicalInsurancePatient;
    }

    public ServicePackage() {}

    public double getPrice() {
        return price;
    }

    public void setPrice(Double priceServices) {
        this.price = priceServices * (0.85 - 0.20 * (medicalInsurancePatient ? 1 : 0));
    }

    public void addServices(List<MedicalService> medicalServices) {
        services.addAll(medicalServices);
    }

    public Double getPriceFromServices() {
        return services.stream().mapToDouble(MedicalService::getPrice).sum();
    }
}
