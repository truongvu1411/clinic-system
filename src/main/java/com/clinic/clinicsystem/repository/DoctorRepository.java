package com.clinic.clinicsystem.repository;

import com.clinic.clinicsystem.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Long>, JpaSpecificationExecutor<Doctor> {
    Optional<Doctor> findByEmail(String email);

    Optional<Doctor> findBySpecialization(String specialization);

    void deleteByEmail(String email);
}
