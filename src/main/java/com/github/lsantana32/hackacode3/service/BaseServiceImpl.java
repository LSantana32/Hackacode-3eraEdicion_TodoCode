package com.github.lsantana32.hackacode3.service;

import com.github.lsantana32.hackacode3.Setter.DoctorSetter;
import com.github.lsantana32.hackacode3.Setter.PatientSetter;
import com.github.lsantana32.hackacode3.dao.CustomRepository;
import com.github.lsantana32.hackacode3.entity.Doctor;
import com.github.lsantana32.hackacode3.entity.Patient;
import com.github.lsantana32.hackacode3.parse.IterableToList;
import com.github.lsantana32.hackacode3.validator.Doc_PatientValidator;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

public abstract class BaseServiceImpl<T> implements BaseService<T> {
    protected final CustomRepository<T> repository;

    protected BaseServiceImpl(CustomRepository<T> repository) {
        this.repository = repository;
    }

    @Override
    public void register(String dni, T entity) {
        Doc_PatientValidator.validateInformation(entity);
        Doc_PatientValidator.validateNotExistenceByDni(dni, entity, repository);
        repository.save(entity);
    }

    @Override
    public Optional<T> getById(long id) {
        Doc_PatientValidator.validateExistenceById(id, repository);
        return repository.findById(id);
    }

    @Override
    public void delete(long id) {
        Doc_PatientValidator.validateExistenceById(id, repository);
        repository.deleteById(id);
    }

    @Override
    public void update(long id, T entityNew) {
        Doc_PatientValidator.validateInformation(entityNew);
        Doc_PatientValidator.validateExistenceById(id, repository);
        T entity = findById(id);
        setAccordingToEntity(entity, entityNew);
        repository.save(entity);
    }

    private void setAccordingToEntity(T entity, T entityNew) {
        if (entity instanceof Patient){
            PatientSetter.setPatient((Patient) entity, (Patient) entityNew);
        } else if (entity instanceof Doctor){
            DoctorSetter.setDoctor((Doctor) entity, (Doctor) entityNew);
        } else {
            throw new IllegalArgumentException("Entity not found");
        }
    }

    @Override
    public List<T> getAll() {
        return IterableToList.convert(repository.findAll());
    }

    private T findById(long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Id %s not found".formatted(id)));
    }
}