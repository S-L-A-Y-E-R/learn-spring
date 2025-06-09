package com.learn.pojo;

import com.learn.customAnnotation.CourseCode;
import jakarta.validation.constraints.*;

public class Name {
    @NotNull(message = "required")
    @Size(min = 1,message = "required")
    private String firstName;

    @NotNull(message = "required")
    @Size(min = 1,message = "required")
    private String lastName;

    @NotNull(message = "required")
    private String country;

    @NotNull(message = "required")
    private String language;

    @Min(value = 0,message = "The value must be between 0 and 10")
    @Max(value = 10,message = "The value must be between 0 and 10")
    @NotNull(message = "required")
    private Integer freePasses;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}",message = "only 5 digits/characters")
    private String postalCode;

    @CourseCode(value = "LOV" , message = "must start with LOV")
    private String courseCode;

    private String os;

    // Getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
