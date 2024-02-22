/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class personDTO {
    private int personID;
    private String lastname;
    private String firstname;
    private Date hireDate;
    private Date enrollmentDate;

    public personDTO() {
    }

    public personDTO(int personID, String lastname, String firstname, Date hireDate, Date enrollmentDate) {
        this.personID = personID;
        this.lastname = lastname;
        this.firstname = firstname;
        this.hireDate = hireDate;
        this.enrollmentDate = enrollmentDate;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.personID;
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
        final personDTO other = (personDTO) obj;
        return this.personID == other.personID;
    }

    @Override
    public String toString() {
        return "personDTO{" + "personID=" + personID + ", lastname=" + lastname + ", firstname=" + firstname + ", hireDate=" + hireDate + ", enrollmentDate=" + enrollmentDate + '}';
    }
    
    
    
    
}
