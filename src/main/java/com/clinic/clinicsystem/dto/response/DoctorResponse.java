package com.clinic.clinicsystem.dto.response;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DoctorResponse {
    String name;

    String specialization;

    String position;

    String phone;

    String email;

    String gender;

    String address;

    int experience;

    boolean available;

    String imageUrl;

}
