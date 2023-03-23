package org.launchcode.techjobs.persistent.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employer extends AbstractEntity {

    // Open the Employer model class. In addition to the fields inherited from AbstractEntity, Employer should have a string field for location.
    //  Add the field for location with validation that ensures it is not empty and has a reasonable length. In addition, add public accessor methods to Employer.

    // FIELDS
    @NotBlank
    @Size(min = 3, max = 100)
    private String location;

    // represents the list of all items in a given job
    @OneToMany
    @JoinColumn(name = "employer_id")
    private List<Job> jobs = new ArrayList<>();


    // GETTERS AND SETTERS
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // Employer is a class that will be mapped to one of our tables. Make sure the class has the @Entity annotation, as well as the no-arg constructor required for Hibernate to create an object.
    // CONSTRUCTORS
    public Employer() {}

}
