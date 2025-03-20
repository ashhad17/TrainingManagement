package com.ust.TrainingManagementApplication.repository;

import com.ust.TrainingManagementApplication.entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Long> {
    List<Training> findByStartDateBetween(LocalDate startDate, LocalDate endDate);
    List<Training> findByStartDate(LocalDate startDate);
    @Query("SELECT t FROM Training t JOIN t.skills s WHERE s IN :skills")
    List<Training> findBySkills(List<String> skills);
    List<Training> findByOrganization(String organization);
}

