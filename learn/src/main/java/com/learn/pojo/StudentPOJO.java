package com.learn.pojo;

public class StudentPOJO {
    private int studentId;
    private String firstName;
    private String lastName;

    public StudentPOJO() {
    }

    public StudentPOJO(int studentId,String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId=studentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

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
}
