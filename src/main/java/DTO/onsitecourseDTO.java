/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.sql.Date;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class onsitecourseDTO {
    private int courseID;
    private String location;
    private String days;
    private Date time;

    public onsitecourseDTO() {
    }

    public onsitecourseDTO(int courseID, String location, String days, Date time) {
        this.courseID = courseID;
        this.location = location;
        this.days = days;
        this.time = time;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.courseID;
        return hash;
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
        final onsitecourseDTO other = (onsitecourseDTO) obj;
        return this.courseID == other.courseID;
    }
    
    
}
