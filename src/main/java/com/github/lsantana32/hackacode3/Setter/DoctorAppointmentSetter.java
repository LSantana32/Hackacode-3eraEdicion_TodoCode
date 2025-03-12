package com.github.lsantana32.hackacode3.Setter;

import com.github.lsantana32.hackacode3.entity.DoctorAppointment;

public class DoctorAppointmentSetter extends BaseSetter {
    public static DoctorAppointment setPrice(DoctorAppointment doctorAppointment) {
        doctorAppointment.setPrice(doctorAppointment.getServicePackage().getPrice());
        return doctorAppointment;
    }
}
