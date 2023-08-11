/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class tbl_HoaDon {
    String MaHoaDon, MaPhieuDatPhong, MaPhieuDichVu, MaPhieuSanPham, NgayLap, TongTien;

    public tbl_HoaDon() {
    }

    public tbl_HoaDon(String MaHoaDon, String MaPhieuDatPhong, String MaPhieuDichVu, String MaPhieuSanPham, String NgayLap, String TongTien) {
        this.MaHoaDon = MaHoaDon;
        this.MaPhieuDatPhong = MaPhieuDatPhong;
        this.MaPhieuDichVu = MaPhieuDichVu;
        this.MaPhieuSanPham = MaPhieuSanPham;
        this.NgayLap = NgayLap;
        this.TongTien = TongTien;
    }

    public String getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(String MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }

    public String getMaPhieuDatPhong() {
        return MaPhieuDatPhong;
    }

    public void setMaPhieuDatPhong(String MaPhieuDatPhong) {
        this.MaPhieuDatPhong = MaPhieuDatPhong;
    }

    public String getMaPhieuDichVu() {
        return MaPhieuDichVu;
    }

    public void setMaPhieuDichVu(String MaPhieuDichVu) {
        this.MaPhieuDichVu = MaPhieuDichVu;
    }

    public String getMaPhieuSanPham() {
        return MaPhieuSanPham;
    }

    public void setMaPhieuSanPham(String MaPhieuSanPham) {
        this.MaPhieuSanPham = MaPhieuSanPham;
    }

    public String getNgayLap() {
        return NgayLap;
    }

    public void setNgayLap(String NgayLap) {
        this.NgayLap = NgayLap;
    }

    public String getTongTien() {
        return TongTien;
    }

    public void setTongTien(String TongTien) {
        this.TongTien = TongTien;
    }
    
    
}
