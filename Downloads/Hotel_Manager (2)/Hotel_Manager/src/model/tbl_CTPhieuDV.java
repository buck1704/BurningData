
package model;

public class tbl_CTPhieuDV {
    String MaCTDV, MaPhieuDichVu, MaDichVu, ThanhTien;

    public tbl_CTPhieuDV() {
    }

    public tbl_CTPhieuDV(String MaCTDV, String MaPhieuDichVu, String MaDichVu, String ThanhTien) {
        this.MaCTDV = MaCTDV;
        this.MaPhieuDichVu = MaPhieuDichVu;
        this.MaDichVu = MaDichVu;
        this.ThanhTien = ThanhTien;
    }

    public String getMaCTDV() {
        return MaCTDV;
    }

    public void setMaCTDV(String MaCTDV) {
        this.MaCTDV = MaCTDV;
    }

    public String getMaPhieuDichVu() {
        return MaPhieuDichVu;
    }

    public void setMaPhieuDichVu(String MaPhieuDichVu) {
        this.MaPhieuDichVu = MaPhieuDichVu;
    }

    public String getMaDichVu() {
        return MaDichVu;
    }

    public void setMaDichVu(String MaDichVu) {
        this.MaDichVu = MaDichVu;
    }

    public String getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(String ThanhTien) {
        this.ThanhTien = ThanhTien;
    }
    
    
}
