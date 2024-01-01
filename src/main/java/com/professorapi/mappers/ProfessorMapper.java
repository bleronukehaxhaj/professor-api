package com.professorapi.mappers;

import com.professorapi.dtos.ProfessorDto;
import com.professorapi.models.Professor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ProfessorMapper {

    public Professor toEntity(ProfessorDto dto) {
        Professor event = new Professor();
        event.setId(dto.getId());
        event.setBiography(dto.getBiography());
        event.setDepartment(dto.getDepartment());
        event.setEmail(dto.getEmail());
        event.setGender(dto.getGender());
        event.setFirstName(dto.getFirstName());
        event.setLastName(dto.getLastName());
        event.setSalary(dto.getSalary());
        event.setPhoneNumber(dto.getPhoneNumber());
        event.setOfficeAddress(dto.getOfficeAddress());
        event.setCreatedDate(LocalDateTime.now());
        event.setDateOfBirth(dto.getDateOfBirth());
        event.setLastUpdatedDate(LocalDateTime.now());
        return event;
    }

    public ProfessorDto toDto(Professor event) {
        ProfessorDto dto = new ProfessorDto();
        dto.setId(event.getId());
        dto.setFirstName(event.getFirstName());
        dto.setLastName(event.getLastName());
        dto.setBiography(event.getBiography());
        dto.setEmail(event.getEmail());
        dto.setDepartment(event.getDepartment());
        dto.setPhoneNumber(event.getPhoneNumber());
        dto.setSalary(event.getSalary());
        dto.setDateOfBirth(event.getDateOfBirth());
        dto.setGender(event.getGender());
        dto.setOfficeAddress(event.getOfficeAddress());
        return dto;
    }
}
