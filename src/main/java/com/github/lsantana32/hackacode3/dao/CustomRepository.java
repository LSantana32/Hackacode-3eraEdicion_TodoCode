package com.github.lsantana32.hackacode3.dao;

import com.github.lsantana32.hackacode3.enums.TypeOfMedicalService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CustomRepository<T> extends CrudRepository<T, Long> {
    T findByDni(String dni);
}
