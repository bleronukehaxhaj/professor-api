package com.professorapi.services.impl;

import com.professorapi.dtos.ProfessorDto;
import com.professorapi.mappers.ProfessorMapper;
import com.professorapi.models.Professor;
import com.professorapi.repositories.ProfessorRepository;
import com.professorapi.services.ProfessorService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class ProfessorServiceImpl implements ProfessorService {

    private final ProfessorRepository professorRepository;
    private final ProfessorMapper professorMapper;

    public ProfessorServiceImpl(ProfessorRepository professorRepository, ProfessorMapper professorMapper) {
        this.professorRepository = professorRepository;
        this.professorMapper = professorMapper;
    }

    @Override
    public void createProfessor(ProfessorDto professorDto) {
        Professor professor = professorMapper.toEntity(professorDto);
        professorRepository.save(professor);
    }

    @Override
    public void updateProfessor(long id, ProfessorDto dto) {
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor not found with id: " + id));


        professor.setBiography(dto.getBiography());
        professor.setDepartment(dto.getDepartment());
        professor.setEmail(dto.getEmail());
        professor.setGender(dto.getGender());
        professor.setFirstName(dto.getFirstName());
        professor.setLastName(dto.getLastName());
        professor.setSalary(dto.getSalary());
        professor.setPhoneNumber(dto.getPhoneNumber());
        professor.setOfficeAddress(dto.getOfficeAddress());
        professor.setDateOfBirth(dto.getDateOfBirth());
        professor.setLastUpdatedDate(LocalDateTime.now());

        professorRepository.save(professor);
    }

    @Override
    public void deleteProfessorById(long id) {
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor not found with id: " + id));
        professorRepository.deleteById(id);

    }

    @Override
    public ProfessorDto getProfessorById(long id) {
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor not found with id: " + id));
        ProfessorDto professorDto = professorMapper.toDto(professor);
        return professorDto;
    }

    @Override
    public List<ProfessorDto> getAllProfessor() {
        return professorRepository.findAll().stream().map(professorMapper::toDto).toList();
    }
}
