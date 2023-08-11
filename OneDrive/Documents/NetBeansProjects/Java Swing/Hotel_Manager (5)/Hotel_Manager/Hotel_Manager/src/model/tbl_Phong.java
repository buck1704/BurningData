/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class tbl_Phong {

    public static void setRowCount(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    String MaPhong, LoaiPhong, SoGiuong, SoPhong, GiaPhong, TinhTrang, MoTa, Tang;

    public tbl_Phong(){}

    public tbl_Phong(String MaPhong, String LoaiPhong,String SoGiuong, String SoPhong, String GiaPhong, String TinhTrang, String MoTa) {
        this.MaPhong = MaPhong;
        this.LoaiPhong = LoaiPhong;
        this.SoGiuong = SoGiuong;
        this.SoPhong = SoPhong;
        this.GiaPhong = GiaPhong;
        this.TinhTrang = TinhTrang;
        this.MoTa = MoTa;
    }

    public String getMaPhong() {
        return MaPhong;
    }

    public void setMaPhong(String MaPhong) {
        this.MaPhong = MaPhong;
    }

    public String getLoaiPhong() {
        return LoaiPhong;
    }

    public void setLoaiPhong(String LoaiPhong) {
        this.LoaiPhong = LoaiPhong;
    }

    public String getGiaPhong() {
        return GiaPhong;
    }

    public void setGiaPhong(String GiaPhong) {
        this.GiaPhong = GiaPhong;
    }

    public String getTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(String TinhTrang) {
        this.TinhTrang = TinhTrang;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }
    public String getSoGiuong() {
        return SoGiuong;
    }

    public void setSoGiuong(String SoGiuong) {
        this.SoGiuong = SoGiuong;
    }

    public String getSoPhong() {
        return SoPhong;
    }

    public void setSoPhong(String SoPhong) {
        this.SoPhong = SoPhong;
    }

    public String getTang() {
        return Tang;
    }

    public void setTang(String Tang) {
        this.Tang = Tang;
    }
    
}
