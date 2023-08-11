/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model_quanlykhachsan;

public class tbl_DichVu {
    String Madichvu, Tendichvu, Giadichvu;
    
    public tbl_DichVu(){
        
    }

    public tbl_DichVu(String Madichvu, String Tendichvu, String Giadichvu) {
        this.Madichvu = Madichvu;
        this.Tendichvu = Tendichvu;
        this.Giadichvu = Giadichvu;
    }

    public String getMadichvu() {
        return Madichvu;
    }

    public void setMadichvu(String Madichvu) {
        this.Madichvu = Madichvu;
    }

    public String getTendichvu() {
        return Tendichvu;
    }

    public void setTendichvu(String Tendichvu) {
        this.Tendichvu = Tendichvu;
    }

    public String getGiadichvu() {
        return Giadichvu;
    }

    public void setGiadichvu(String Giadichvu) {
        this.Giadichvu = Giadichvu;
    }
    
}
