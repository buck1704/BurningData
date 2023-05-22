package model;

public class tbl_PhieuBonus {
    String maphieubonus, maphieudatphong, tongtien;

    public tbl_PhieuBonus() {
    }

    public tbl_PhieuBonus(String maphieubonus, String maphieudatphong, String tongtien) {
        this.maphieubonus = maphieubonus;
        this.maphieudatphong = maphieudatphong;
        this.tongtien = tongtien;
    }

    public String getMaphieubonus() {
        return maphieubonus;
    }

    public void setMaphieubonus(String maphieubonus) {
        this.maphieubonus = maphieubonus;
    }

    public String getMaphieudatphong() {
        return maphieudatphong;
    }

    public void setMaphieudatphong(String maphieudatphong) {
        this.maphieudatphong = maphieudatphong;
    }

    public String getTongtien() {
        return tongtien;
    }

    public void setTongtien(String tongtien) {
        this.tongtien = tongtien;
    }

    
    
    
}
