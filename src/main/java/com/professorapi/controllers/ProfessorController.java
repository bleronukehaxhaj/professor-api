package com.professorapi.controllers;

import com.professorapi.dtos.ProfessorDto;
import com.professorapi.services.ProfessorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professors")
@CrossOrigin(origins = "*")
public class ProfessorController {
    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping
    public ResponseEntity<List<ProfessorDto>> getAllProfessors() {
        return ResponseEntity.ok(professorService.getAllProfessor());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProfessorById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(professorService.getProfessorById(id));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<String> createProfessor(@RequestBody ProfessorDto professorDto) {
        professorService.createProfessor(professorDto);
        return ResponseEntity.ok("Professor created successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProfessor(@PathVariable Long id, @RequestBody ProfessorDto updatedProfessor) {
        try {
            professorService.updateProfessor(id, updatedProfessor);
            return ResponseEntity.ok("Event updated successfully");
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProfessor(@PathVariable Long id) {
        try {
            professorService.deleteProfessorById(id);
            return ResponseEntity.ok("Event deleted successfully");
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }

    }
}
