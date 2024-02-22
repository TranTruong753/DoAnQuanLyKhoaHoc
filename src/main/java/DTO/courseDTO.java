/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Admin
 */
public class courseDTO {
    private int courseId ;
    private String title ;
    private int credits ;
    private int departmentId;

    public courseDTO() {
    }

    public courseDTO(int courseId, String title, int credits, int departmentId) {
        this.courseId = courseId;
        this.title = title;
        this.credits = credits;
        this.departmentId = departmentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final courseDTO other = (courseDTO) obj;
        return this.courseId == other.courseId;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + this.courseId;
        return hash;
    }
    
    
}
