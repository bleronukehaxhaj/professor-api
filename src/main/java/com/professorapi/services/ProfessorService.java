package com.professorapi.services;

import com.professorapi.dtos.ProfessorDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProfessorService {
    void createProfessor(ProfessorDto professorDto);

    void updateProfessor(long id, ProfessorDto updateProfessorDto);

    void deleteProfessorById(long id);

    ProfessorDto getProfessorById(long id);

    List<ProfessorDto> getAllProfessor();
}
