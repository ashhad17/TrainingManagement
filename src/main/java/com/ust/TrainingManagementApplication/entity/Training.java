package com.ust.TrainingManagementApplication.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.List;

@Entity

@Table(name = "trainin")
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trainingId;

    @NotBlank(message = "Training name is required")
    private String trainingName;

    @ElementCollection
    @NotEmpty(message = "At least one skill is required")
    private List<String> skills;

    @Enumerated(EnumType.STRING)
    private DurationType duration;

    @FutureOrPresent(message = "Start date must be today or in the future")
    private LocalDate startDate;

    @Future(message = "End date must be in the future")
    private LocalDate endDate;

    @Min(value = 1, message = "Number of batches must be at least 1")
    private long noOfBatches;

    @Min(value = 1, message = "Number of students per batch must be at least 1")
    private long noOfStudentsPerBatch;

    @NotBlank(message = "Organization name is required")
    private String organization;

    @Positive(message = "Budget must be positive")
    private double budget;

    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", message = "Invalid email format")
    private String email;

    @Pattern(regexp = "^\\d{10}$", message = "Invalid phone number format")
    private String phone;

    @NotBlank(message = "Table of contents (TOC) link is required")
    private String toc;

    @NotBlank(message = "Point of contact (POC) is required")
    private String poc;

    @Enumerated(EnumType.STRING)
    private StudentType studentType;

    @Enumerated(EnumType.STRING)
    private TrainingStatus status;

    public enum DurationType {
        HOURS, DAYS, MONTHS
    }

    public enum StudentType {
        FRESHER, LATERAL
    }

    public enum TrainingStatus {
        ON_HOLD, IN_PROGRESS, COMPLETED, UPCOMING
    }

    public Training() {
    }

    public Training(Long trainingId, String trainingName, List<String> skills, DurationType duration, LocalDate startDate, LocalDate endDate, long noOfBatches, long noOfStudentsPerBatch, String organization, double budget, String email, String phone, String toc, String poc, StudentType studentType, TrainingStatus status) {
        this.trainingId = trainingId;
        this.trainingName = trainingName;
        this.skills = skills;
        this.duration = duration;
        this.startDate = startDate;
        this.endDate = endDate;
        this.noOfBatches = noOfBatches;
        this.noOfStudentsPerBatch = noOfStudentsPerBatch;
        this.organization = organization;
        this.budget = budget;
        this.email = email;
        this.phone = phone;
        this.toc = toc;
        this.poc = poc;
        this.studentType = studentType;
        this.status = status;
    }

    public Long getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(Long trainingId) {
        this.trainingId = trainingId;
    }

    public String getTrainingName() {
        return trainingName;
    }

    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public DurationType getDuration() {
        return duration;
    }

    public void setDuration(DurationType duration) {
        this.duration = duration;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public long getNoOfBatches() {
        return noOfBatches;
    }

    public void setNoOfBatches(long noOfBatches) {
        this.noOfBatches = noOfBatches;
    }

    public long getNoOfStudentsPerBatch() {
        return noOfStudentsPerBatch;
    }

    public void setNoOfStudentsPerBatch(long noOfStudentsPerBatch) {
        this.noOfStudentsPerBatch = noOfStudentsPerBatch;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getToc() {
        return toc;
    }

    public void setToc(String toc) {
        this.toc = toc;
    }

    public String getPoc() {
        return poc;
    }

    public void setPoc(String poc) {
        this.poc = poc;
    }

    public StudentType getStudentType() {
        return studentType;
    }

    public void setStudentType(StudentType studentType) {
        this.studentType = studentType;
    }

    public TrainingStatus getStatus() {
        return status;
    }

    public void setStatus(TrainingStatus status) {
        this.status = status;
    }
}
