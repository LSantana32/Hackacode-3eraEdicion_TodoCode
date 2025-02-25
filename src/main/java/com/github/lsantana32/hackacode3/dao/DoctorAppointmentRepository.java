package com.github.lsantana32.hackacode3.dao;

import com.github.lsantana32.hackacode3.entity.DoctorAppointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorAppointmentRepository extends CrudRepository<DoctorAppointment, Long> {

}
