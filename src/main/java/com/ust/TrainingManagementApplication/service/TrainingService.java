package com.ust.TrainingManagementApplication.service;




import com.ust.TrainingManagementApplication.entity.Training;
import com.ust.TrainingManagementApplication.repository.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class TrainingService {

    @Autowired
    private TrainingRepository trainingRepository;

    public Training saveTraining(Training training) {
        Training newTraining = new Training();

        // Explicitly setting each field
        newTraining.setTrainingName(training.getTrainingName());
        newTraining.setSkills(training.getSkills());
        newTraining.setDuration(training.getDuration());
        newTraining.setStartDate(training.getStartDate());
        newTraining.setEndDate(training.getEndDate());
        newTraining.setNoOfBatches(training.getNoOfBatches());
        newTraining.setNoOfStudentsPerBatch(training.getNoOfStudentsPerBatch());
        newTraining.setOrganization(training.getOrganization());
        newTraining.setBudget(training.getBudget());
        newTraining.setEmail(training.getEmail());
        newTraining.setPhone(training.getPhone());
        newTraining.setToc(training.getToc());
        newTraining.setPoc(training.getPoc());
        newTraining.setStudentType(training.getStudentType());
        newTraining.setStatus(training.getStatus());

        // Save and return the newly created training object
        return trainingRepository.save(newTraining);
    }

    public List<Training> getAllTrainings() {
        return trainingRepository.findAll();
    }

    public Training getTrainingById(long id) {
        return trainingRepository.findById(id).orElse(null);
    }

    public void deleteTraining(long id) {
        trainingRepository.deleteById(id);
    }

    public List<Training> findTrainingsByStartDate(LocalDate startDate) {
        return trainingRepository.findByStartDate(startDate);
    }

    public List<Training> findTrainingsByDateRange(LocalDate startDate, LocalDate endDate) {
        return trainingRepository.findByStartDateBetween(startDate, endDate);
    }

    public List<Training> findTrainingsBySkill(List<String> skills) {


        return trainingRepository.findBySkills(skills);
    }

    public List<Training> findTrainingsByOrganization(String organization) {
        return trainingRepository.findByOrganization(organization);
    }
}

