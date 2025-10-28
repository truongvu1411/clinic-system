package com.clinic.clinicsystem.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DoctorCreateRequest {
    String name;
    String specialization;
    String phone;
    String email;
    String gender;
    String address;
    int experience;
    String description;
    String imageUrl;
}
