
package model;

public class tbl_CTPhieuSP {
    String MaCTSP, MaPhieuSanPham, MaHang, SoLuong, ThanhTien;

    public tbl_CTPhieuSP() {
    }

    public tbl_CTPhieuSP(String MaCTSP, String MaPhieuSanPham, String MaHang, String SoLuong, String ThanhTien) {
        this.MaCTSP = MaCTSP;
        this.MaPhieuSanPham = MaPhieuSanPham;
        this.MaHang = MaHang;
        this.SoLuong = SoLuong;
        this.ThanhTien = ThanhTien;
    }

    public String getMaCTSP() {
        return MaCTSP;
    }

    public void setMaCTSP(String MaCTSP) {
        this.MaCTSP = MaCTSP;
    }

    public String getMaPhieuSanPham() {
        return MaPhieuSanPham;
    }

    public void setMaPhieuSanPham(String MaPhieuSanPham) {
        this.MaPhieuSanPham = MaPhieuSanPham;
    }

    public String getMaHang() {
        return MaHang;
    }

    public void setMaHang(String MaHang) {
        this.MaHang = MaHang;
    }

    public String getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(String SoLuong) {
        this.SoLuong = SoLuong;
    }

    public String getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(String ThanhTien) {
        this.ThanhTien = ThanhTien;
    }
    
    
    
}
