package com.github.aksel.appSchool.controller;

import com.github.aksel.appSchool.dto.trainer.TrainerEntityDto;
import com.github.aksel.appSchool.dto.auth.TrainerRegistrationDto;
import com.github.aksel.appSchool.entity.LessonEntity;
import com.github.aksel.appSchool.entity.TrainerEntity;
import com.github.aksel.appSchool.entity.enums.Status;
import com.github.aksel.appSchool.service.TrainerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/trainer")
@RequiredArgsConstructor
public class TrainerController {

    private final TrainerService trainerService;

    @PostMapping("/add")
    public ResponseEntity<TrainerEntity> createTrainer(@RequestBody TrainerRegistrationDto trainer) {
        return ResponseEntity.ok(trainerService.saveTrainer(trainer));
    }


    @GetMapping("/id/{id}")
    public ResponseEntity<TrainerEntity> findTrainerByID(@PathVariable Long id) {
        return ResponseEntity.ok(trainerService.getTrainerByID(id));
    }
    @GetMapping("/trainer/all")
    public ResponseEntity<List<TrainerEntity>>getAllTrainerEntities(){
        return ResponseEntity.ok(trainerService.getAllTrainerEntities());
    }

    @GetMapping("/status")
    public ResponseEntity<List<TrainerEntityDto>> getTrainerByStatus(@RequestParam Status status) {
        return ResponseEntity.ok(trainerService.getTrainerByStatus(status));
    }

    @GetMapping("/passRate")
    public ResponseEntity<List<TrainerEntityDto>> getTrainerByPassRateFromHighest() {
        return ResponseEntity.ok(trainerService.getTrainersByStudentsPassRate());
    }

    @GetMapping("/identifier")
    public ResponseEntity<TrainerEntityDto> getTrainerByIdentifier(@RequestParam String identifier) {
        return ResponseEntity.ok(trainerService.getTrainerByIdentifier(identifier));
    }

    @GetMapping("/getAllLessonsFromTrainer")
    public ResponseEntity<List<LessonEntity>> getAllTrainerLessonsByTrainerID(Long id) {
        return ResponseEntity.ok(trainerService.getAllTrainerLessonsByTrainerID(id));
    }

    @PatchMapping("/updateTrainer/{id}")
    public ResponseEntity<TrainerEntity> patchTrainer(@PathVariable Long id, @RequestBody Map<String, Object> variables) {
        return ResponseEntity.ok(trainerService.updateTrainer(id, variables));
    }

    @GetMapping("/trainer/email")
    public ResponseEntity<TrainerEntity>getTrainerByEmail(String email) {
        return ResponseEntity.ok(trainerService.getTrainerByEmail(email));
    }
}
