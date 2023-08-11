/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class tbl_PhieuDatPhong {
    String MaPhieuDK, MaKhachHang, TenKhachHang, NgayDen, NgayDi, MaPhong, ThanhTien, MaNhanVien;
    public tbl_PhieuDatPhong(){}
    public tbl_PhieuDatPhong(String MaPhieuDK, String MaKhachHang, String TenKhachHang, String NgayDen, String NgayDi, String MaPhong, String ThanhTien, String MaNhanVien) {
        this.MaPhieuDK = MaPhieuDK;
        this.MaKhachHang = MaKhachHang;
        this.TenKhachHang = TenKhachHang;
        this.NgayDen = NgayDen;
        this.NgayDi = NgayDi;
        this.MaPhong = MaPhong;
        this.ThanhTien = ThanhTien;
        this.MaNhanVien = MaNhanVien;
    }

    public tbl_PhieuDatPhong(String MaPhieuDK, String MaKhachHang, String NgayDen, String NgayDi, String MaPhong, String ThanhTien, String MaNhanVien) {
        this.MaPhieuDK = MaPhieuDK;
        this.MaKhachHang = MaKhachHang;
        this.NgayDen = NgayDen;
        this.NgayDi = NgayDi;
        this.MaPhong = MaPhong;
        this.ThanhTien = ThanhTien;
        this.MaNhanVien = MaNhanVien;
    }
    
    

    public String getMaPhieuDK() {
        return MaPhieuDK;
    }

    public void setMaPhieuDK(String MaPhieuDK) {
        this.MaPhieuDK = MaPhieuDK;
    }

    public String getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(String MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }

    public String getTenKhachHang() {
        return TenKhachHang;
    }

    public void setTenKhachHang(String TenKhachHang) {
        this.TenKhachHang = TenKhachHang;
    }

    public String getNgayDen() {
        return NgayDen;
    }

    public void setNgayDen(String NgayDen) {
        this.NgayDen = NgayDen;
    }

    public String getNgayDi() {
        return NgayDi;
    }

    public void setNgayDi(String NgayDi) {
        this.NgayDi = NgayDi;
    }

    public String getMaPhong() {
        return MaPhong;
    }

    public void setMaPhong(String MaPhong) {
        this.MaPhong = MaPhong;
    }

    public String getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(String ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    
}
