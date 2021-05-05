package com.leviosa.pumpkin.springlombokmapstructexample;

import com.leviosa.pumpkin.springlombokmapstructexample.domain.Student;
import com.leviosa.pumpkin.springlombokmapstructexample.dto.StudentDto;
import com.leviosa.pumpkin.springlombokmapstructexample.dto.StudentDtoWithDifferentNames;
import com.leviosa.pumpkin.springlombokmapstructexample.dto.StudentDtoWithDifferntTypes;
import com.leviosa.pumpkin.springlombokmapstructexample.mapper.StudentMapper;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

import java.util.Date;

@SpringBootTest
class SpringlombokmapstructexampleApplicationTests {
	@Autowired
      private StudentMapper studentMapper;
      
	@Test
	void testStudentMapper() {
            Student student = Student
            .builder()
		.id(1L)
            .firstname("Fahd")
            .lastname("BOUDALI")
            .build();
      
            final StudentDto studentDto = studentMapper.toDto(student);
            assertThat(studentDto.getFirstname()).isEqualTo(student.getFirstname());
            assertThat(studentDto.getLastname()).isEqualTo(student.getLastname());
      }

      @Test
      void testStudentWithDifferentNamesMapper() {
            Student student = Student
            .builder()
		.id(2L)
            .firstname("John")
            .lastname("SNOW")
            .build();
      
            final StudentDtoWithDifferentNames studentDto = studentMapper.toDtoWithDifferentNames(student);
            assertThat(studentDto.getStudentId()).isEqualTo(student.getId());
            assertThat(studentDto.getFirstname()).isEqualTo(student.getFirstname());
            assertThat(studentDto.getLastname()).isEqualTo(student.getLastname());
      }

      @Test
      void testStudentWithDifferentTypesMapper() {
            Student student = Student
            .builder()
		.id(2L)
            .firstname("John")
            .lastname("SNOW")
            .dateOfBirth(new Date())
            .build();
      
            final StudentDtoWithDifferntTypes studentDto = studentMapper.toDtoWithDifferntTypes(student);
            assertThat(studentDto.getId()).isEqualTo(student.getId().intValue());
            assertThat(studentDto.getFirstname()).isEqualTo(student.getFirstname());
            assertThat(studentDto.getLastname()).isEqualTo(student.getLastname());
            assertThat(studentDto.getDateOfBirth()).isEqualTo(DateFormatUtils.format(student.getDateOfBirth(), "dd-MM-yyyy"));
      }
}
