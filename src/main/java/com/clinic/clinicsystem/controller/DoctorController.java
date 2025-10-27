package com.clinic.clinicsystem.controller;

import com.clinic.clinicsystem.dto.request.DoctorCreateRequest;
import com.clinic.clinicsystem.dto.request.DoctorSearchRequest;
import com.clinic.clinicsystem.dto.request.DoctorUpdateRequest;
import com.clinic.clinicsystem.dto.response.ApiResponse;
import com.clinic.clinicsystem.dto.response.DoctorResponse;
import com.clinic.clinicsystem.service.DoctorService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DoctorController {
    DoctorService doctorService;

    // Tạo Doctor
    @PostMapping
    ApiResponse<DoctorResponse> createDoctor(@RequestBody DoctorCreateRequest request){
        return ApiResponse.<DoctorResponse>builder()
                .result(doctorService.createDoctor(request))
                .build();
    }

    //xóa Doctor theo email
    @DeleteMapping("/{email}")
    ApiResponse<String> deleteByEmail(@PathVariable("email") String email){
        doctorService.deleteDoctorByEmail(email);
        return ApiResponse.<String>builder() .result("Doctor " + email +" đã bị xóa").build();
    }

    //lấy danh sách tất cả Doctors
    @GetMapping
    ApiResponse<List<DoctorResponse>> getAllDoctors(){
        return ApiResponse.<List<DoctorResponse>>builder()
                .result(doctorService.getAllDoctor())
                .build();
    }


    // update Doctor theo email
    @PutMapping("/{email}")
    ApiResponse<DoctorResponse> updateDoctor(@PathVariable("email") String email, DoctorUpdateRequest request){
        return ApiResponse.<DoctorResponse>builder()
                .result(doctorService.updateDoctor(email, request))
                .build();
    }

    // tìm kiếm Doctor theo từng tiêu chí do khách hàng chọn
    @PostMapping("/search")
    public ApiResponse<List<DoctorResponse>> searchDoctor(@RequestBody DoctorSearchRequest request) {
        List<DoctorResponse> result = doctorService.searchDoctor(request);
        return ApiResponse.<List<DoctorResponse>>builder()
                .message("Search success")
                .result(result)
                .build();
    }
}
