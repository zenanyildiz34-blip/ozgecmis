package org.example.model;

public class Experience {
    private String company;
    private String title;
    private String duration;
    private String description;

    public Experience(String company, String title, String duration, String description) {
        this.company = company;
        this.title = title;
        this.duration = duration;
        this.description = description;
    }

    public String getCompany() {
        return company;
    }

    public String getTitle() {
        return title;
    }

    public String getDuration() {
        return duration;
    }

    public String getDescription() {
        return description;
    }
}