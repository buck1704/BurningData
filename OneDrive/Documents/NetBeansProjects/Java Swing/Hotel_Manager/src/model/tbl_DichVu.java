package model;

public class tbl_DichVu {
    String Madichvu, Tendichvu, Giadichvu, SoLanSuDung, DoanhThu;
    
    public tbl_DichVu(){
        
    }

    public tbl_DichVu(String Madichvu, String Tendichvu, String Giadichvu) {
        this.Madichvu = Madichvu;
        this.Tendichvu = Tendichvu;
        this.Giadichvu = Giadichvu;
    }

    public tbl_DichVu(String Madichvu, String Tendichvu, String SoLanSuDung, String DoanhThu) {
        this.Madichvu = Madichvu;
        this.Tendichvu = Tendichvu;
        this.SoLanSuDung = SoLanSuDung;
        this.DoanhThu = DoanhThu;
    }

    public String getSoLanSuDung() {
        return SoLanSuDung;
    }

    public void setSoLanSuDung(String SoLanSuDung) {
        this.SoLanSuDung = SoLanSuDung;
    }

    public String getDoanhThu() {
        return DoanhThu;
    }

    public void setDoanhThu(String DoanhThu) {
        this.DoanhThu = DoanhThu;
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
