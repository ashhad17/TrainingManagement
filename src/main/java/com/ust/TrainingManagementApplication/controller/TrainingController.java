package com.ust.TrainingManagementApplication.controller;

import com.ust.TrainingManagementApplication.entity.Training;
import com.ust.TrainingManagementApplication.repository.TrainingRepository;
import com.ust.TrainingManagementApplication.service.TrainingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/training")
public class TrainingController {

    @Autowired
    private TrainingService trainingService;

    @PostMapping
    public ResponseEntity<Training> createTraining(@Valid  @RequestBody Training training) {
        return ResponseEntity.ok(trainingService.saveTraining(training));
    }

    @GetMapping
    public ResponseEntity<List<Training>> getAllTrainings() {
        return ResponseEntity.ok(trainingService.getAllTrainings());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Training> getTrainingById(@PathVariable Long id) {
        return ResponseEntity.ok(trainingService.getTrainingById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTraining(@PathVariable Long id) {
        trainingService.deleteTraining(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/byStartDate")
    public ResponseEntity<List<Training>> getTrainingsByStartDate(@RequestParam LocalDate startDate) {
        return ResponseEntity.ok(trainingService.findTrainingsByStartDate(startDate));
    }

    @GetMapping("/byDateRange")
    public ResponseEntity<List<Training>> getTrainingsByDateRange(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        return ResponseEntity.ok(trainingService.findTrainingsByDateRange(startDate, endDate));
    }

    @GetMapping("/bySkill")
    public ResponseEntity<List<Training>> getTrainingsBySkills(@RequestParam List<String> skills) {
        List<Training> trainings = trainingService.findTrainingsBySkill(skills);
        return ResponseEntity.ok(trainings);
    }

    @GetMapping("/byOrganization")
    public ResponseEntity<List<Training>> getTrainingsByOrganization(@RequestParam String organization) {
        return ResponseEntity.ok(trainingService.findTrainingsByOrganization(organization));
    }
}
