package org.launchcode.techjobs.persistent.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Skill extends AbstractEntity {


    // In the model class Skill, add a field for a longer description of the skill, named description, with public accessor methods.
    //  Some hiring managers like to have more information available about the nature of a given programming language or framework.

    // FIELDS
    @NotBlank
    @Size(max = 500)
    private String description;

    @ManyToMany(mappedBy="skills" )
    private List<Job> jobs;

    // GETTERS AND SETTERS
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    // As with Employer, give this class the @Entity annotation and be sure it contains a no-arg constructor.
    public Skill() {}
}