package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String fullName;
    private String jobTitle;
    private String about;
    private String careerGoal;
    private String phone;
    private String email;
    private String linkedin;
    private String address;
    private String education;
    private String photoPath;

    private List<String> skills;
    private List<String> languages;
    private List<String> certificates;
    private List<String> interests;
    private List<Experience> experiences;

    public Person(String fullName, String jobTitle, String about, String careerGoal,
                  String phone, String email, String linkedin, String address,
                  String education, String photoPath) {
        this.fullName = fullName;
        this.jobTitle = jobTitle;
        this.about = about;
        this.careerGoal = careerGoal;
        this.phone = phone;
        this.email = email;
        this.linkedin = linkedin;
        this.address = address;
        this.education = education;
        this.photoPath = photoPath;

        this.skills = new ArrayList<>();
        this.languages = new ArrayList<>();
        this.certificates = new ArrayList<>();
        this.interests = new ArrayList<>();
        this.experiences = new ArrayList<>();
    }

    public void addSkill(String skill) { this.skills.add(skill); }
    public void addLanguage(String lang) { this.languages.add(lang); }
    public void addCertificate(String cert) { this.certificates.add(cert); }
    public void addInterest(String interest) { this.interests.add(interest); }
    public void addExperience(Experience exp) { this.experiences.add(exp); }

    public String getFullName() { return fullName; }
    public String getJobTitle() { return jobTitle; }
    public String getAbout() { return about; }
    public String getCareerGoal() { return careerGoal; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
    public String getLinkedin() { return linkedin; }
    public String getAddress() { return address; }
    public String getEducation() { return education; }
    public String getPhotoPath() { return photoPath; }
    public List<String> getSkills() { return skills; }
    public List<String> getLanguages() { return languages; }
    public List<String> getCertificates() { return certificates; }
    public List<String> getInterests() { return interests; }
    public List<Experience> getExperiences() { return experiences; }
}