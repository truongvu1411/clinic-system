package com.clinic.clinicsystem.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DoctorUpdateRequest {
    String name;
    String specialization;
    String phone;
    String gender;
    String address;
    int experience;
    String description;
}
