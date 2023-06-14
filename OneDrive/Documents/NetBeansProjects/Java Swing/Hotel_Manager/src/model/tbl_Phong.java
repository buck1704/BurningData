package model;

public class tbl_Phong {
    String MaPhong, LoaiPhong, SoGiuong, SoPhong, GiaPhong, TinhTrang, MoTa, Tang, LuotDat, TongDoanhThuPhong;

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

    public tbl_Phong(String MaPhong, String LoaiPhong, String GiaPhong, String LuotDat, String TongDoanhThuPhong) {
        this.MaPhong = MaPhong;
        this.LoaiPhong = LoaiPhong;
        this.GiaPhong = GiaPhong;
        this.LuotDat = LuotDat;
        this.TongDoanhThuPhong = TongDoanhThuPhong;
    }

    public String getLuotDat() {
        return LuotDat;
    }

    public void setLuotDat(String LuotDat) {
        this.LuotDat = LuotDat;
    }

    public String getTongDoanhThuPhong() {
        return TongDoanhThuPhong;
    }

    public void setTongDoanhThuPhong(String TongDoanhThuPhong) {
        this.TongDoanhThuPhong = TongDoanhThuPhong;
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
