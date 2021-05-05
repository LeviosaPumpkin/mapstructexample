package com.leviosa.pumpkin.springlombokmapstructexample.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDtoWithDifferntTypes {
    private int id;
    private String firstname;
    private String lastname;
    private String dateOfBirth;
}