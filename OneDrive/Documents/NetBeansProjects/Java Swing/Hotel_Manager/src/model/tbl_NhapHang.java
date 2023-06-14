package model;

public class tbl_NhapHang {
    public String MaNhap,MaHang,MaCongTy,LoaiHang,DonViTinh,GiaNhap,NgayNhap;
    public int soluong;

    public tbl_NhapHang(String MaNhap, String MaHang, String MaCongTy, int soluong,String LoaiHang, String DonViTinh, String GiaNhap, String NgayNhap) {
        this.MaNhap = MaNhap;
        this.MaHang = MaHang;
        this.MaCongTy = MaCongTy;
        this.soluong = soluong;
        this.LoaiHang = LoaiHang;
        this.DonViTinh = DonViTinh;
        this.GiaNhap = GiaNhap;
        this.NgayNhap = NgayNhap;
      
    }

    public String getMaNhap() {
        return MaNhap;
    }

    public tbl_NhapHang() {
    }

    public void setMaNhap(String MaNhap) {
        this.MaNhap = MaNhap;
    }

    public String getMaHang() {
        return MaHang;
    }

    public void setMaHang(String MaHang) {
        this.MaHang = MaHang;
    }

    public String getMaCongTy() {
        return MaCongTy;
    }

    public void setMaCongTy(String MaCongTy) {
        this.MaCongTy = MaCongTy;
    }

    public String getLoaiHang() {
        return LoaiHang;
    }

    public void setLoaiHang(String LoaiHang) {
        this.LoaiHang = LoaiHang;
    }

    public String getDonViTinh() {
        return DonViTinh;
    }

    public void setDonViTinh(String DonViTinh) {
        this.DonViTinh = DonViTinh;
    }

    public String getGiaNhap() {
        return GiaNhap;
    }

    public void setGiaNhap(String GiaNhap) {
        this.GiaNhap = GiaNhap;
    }

    public String getNgayNhap() {
        return NgayNhap;
    }

    public void setNgayNhap(String NgayNhap) {
        this.NgayNhap = NgayNhap;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
    
}
