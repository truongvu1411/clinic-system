package com.clinic.clinicsystem.service;

import com.clinic.clinicsystem.dto.request.DoctorCreateRequest;
import com.clinic.clinicsystem.dto.request.DoctorSearchRequest;
import com.clinic.clinicsystem.dto.request.DoctorUpdateRequest;
import com.clinic.clinicsystem.dto.response.ApiResponse;
import com.clinic.clinicsystem.dto.response.DoctorResponse;
import com.clinic.clinicsystem.entity.Doctor;
import com.clinic.clinicsystem.mapper.DoctorMapper;
import com.clinic.clinicsystem.repository.DoctorRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class DoctorService {
    final private DoctorRepository doctorRepository;
    final private DoctorMapper doctorMapper;

    public DoctorResponse createDoctor(DoctorCreateRequest request) {
        Doctor doctor = doctorMapper.toDoctor(request);
        doctor = doctorRepository.save(doctor);

        return doctorMapper.toDoctorResponse(doctor);
    }

    public DoctorResponse updateDoctor(String email, DoctorUpdateRequest request) {
        Doctor doctor = doctorRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Doctor with phone " + email + " not found"));
        doctor.setName(request.getName());
        doctor.setSpecialization(request.getSpecialization());
        doctor.setPhone(request.getPhone());
        doctor.setGender(request.getGender());
        doctor.setAddress(request.getAddress());
        doctor.setExperience(request.getExperience());
        doctor.setDescription(request.getDescription());

        return doctorMapper.toDoctorResponse(doctorRepository.save(doctor));
    }

    public List<DoctorResponse> getAllDoctor() {
        return doctorRepository.findAll().stream().map(doctorMapper::toDoctorResponse).toList();
    }

    public DoctorResponse getByEmail(String email) {
        Doctor doctor = doctorRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Doctor with phone " + email + " not found"));
        return doctorMapper.toDoctorResponse(doctor);
    }

    @Transactional
    public void deleteDoctorByEmail(String email) {
        doctorRepository.deleteByEmail(email);
    }


    public List<DoctorResponse> searchDoctor(DoctorSearchRequest request){
        if(request.getField() == null || request.getValue() == null){
            return doctorRepository.findAll()
                    .stream().map(doctorMapper::toDoctorResponse)
                    .toList();
        }

        String field = request.getField().toLowerCase();
        String value = request.getValue().toLowerCase();

        List<Doctor> doctors = doctorRepository.findAll().stream()
                .filter(doctor -> {
                    switch (field) {
                        case "name":
                            return doctor.getName() != null && doctor.getName().toLowerCase().contains(value);
                        case "phone":
                            return doctor.getPhone() != null && doctor.getPhone().toLowerCase().contains(value);
                        case "email":
                            return doctor.getEmail() != null && doctor.getEmail().toLowerCase().contains(value);
                        case "specialization":
                            return doctor.getSpecialization() != null && doctor.getSpecialization().toLowerCase().contains(value);
                        case "experience":
                            try {
                                int exp = Integer.parseInt(value);
                                return doctor.getExperience() != null && doctor.getExperience() == exp;
                            } catch (NumberFormatException e) {
                                return false;
                            }
                        default:
                            return false;
                    }
                })
                .toList();

        return doctors.stream()
                .map(doctorMapper::toDoctorResponse)
                .toList();

        }

}
