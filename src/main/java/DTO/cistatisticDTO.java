/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Administrator
 */
public class cistatisticDTO {
    String PersonID;
    int Quantity;

    public cistatisticDTO() {
    }

    public cistatisticDTO(String PersonID, int Quantity) {
        this.PersonID = PersonID;
        this.Quantity = Quantity;
    }

    public String getPersonID() {
        return PersonID;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setPersonID(String PersonID) {
        this.PersonID = PersonID;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    
    
    
}
