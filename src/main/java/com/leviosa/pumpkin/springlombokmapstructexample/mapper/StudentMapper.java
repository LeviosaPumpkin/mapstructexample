package com.leviosa.pumpkin.springlombokmapstructexample.mapper;

import com.leviosa.pumpkin.springlombokmapstructexample.domain.Student;
import com.leviosa.pumpkin.springlombokmapstructexample.dto.StudentDto;
import com.leviosa.pumpkin.springlombokmapstructexample.dto.StudentDtoWithDifferentNames;
import com.leviosa.pumpkin.springlombokmapstructexample.dto.StudentDtoWithDifferntTypes;

import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentDto toDto(Student student);

    @Mappings({
        @Mapping(target = "studentId", source = "student.id"),
        @Mapping(target = "firstname", source = "student.firstname"),
        @Mapping(target = "lastname", source = "student.lastname")
    })
    StudentDtoWithDifferentNames toDtoWithDifferentNames(Student student);

    @Mappings({
        @Mapping(target = "id", source = "student.id"),
        @Mapping(target = "firstname", source = "student.firstname"),
        @Mapping(target = "lastname", source = "student.lastname"),
        @Mapping(target = "dateOfBirth", source = "student.dateOfBirth", dateFormat = "dd-MM-yyyy")
    })
    StudentDtoWithDifferntTypes toDtoWithDifferntTypes(Student student);
}