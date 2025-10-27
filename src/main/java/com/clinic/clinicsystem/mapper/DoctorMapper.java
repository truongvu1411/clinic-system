package com.clinic.clinicsystem.mapper;

import com.clinic.clinicsystem.dto.request.DoctorCreateRequest;
import com.clinic.clinicsystem.dto.response.DoctorResponse;
import com.clinic.clinicsystem.entity.Doctor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DoctorMapper {
    Doctor toDoctor(DoctorCreateRequest request);

    DoctorResponse toDoctorResponse(Doctor doctor);

//    void updateDoctor
}
