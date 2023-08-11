package model;

public class TongDoanhThuModel {
    String nam, thang, doanhthudichvu, doanhthusanpham, doanhthuphong, soluongdichvu, soluongsanpham, 
            soluongphong, tonggianhap, tongdoanhthu;

    public TongDoanhThuModel() {
    }

    public TongDoanhThuModel(String nam, String thang, String doanhthudichvu, String doanhthusanpham, String doanhthuphong, String soluongdichvu, String soluongsanpham, String soluongphong, String tonggianhap, String tongdoanhthu) {
        this.nam = nam;
        this.thang = thang;
        this.doanhthudichvu = doanhthudichvu;
        this.doanhthusanpham = doanhthusanpham;
        this.doanhthuphong = doanhthuphong;
        this.soluongdichvu = soluongdichvu;
        this.soluongsanpham = soluongsanpham;
        this.soluongphong = soluongphong;
        this.tonggianhap = tonggianhap;
        this.tongdoanhthu = tongdoanhthu;
    }

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    public String getThang() {
        return thang;
    }

    public void setThang(String thang) {
        this.thang = thang;
    }

    public String getDoanhthudichvu() {
        return doanhthudichvu;
    }

    public void setDoanhthudichvu(String doanhthudichvu) {
        this.doanhthudichvu = doanhthudichvu;
    }

    public String getDoanhthusanpham() {
        return doanhthusanpham;
    }

    public void setDoanhthusanpham(String doanhthusanpham) {
        this.doanhthusanpham = doanhthusanpham;
    }

    public String getDoanhthuphong() {
        return doanhthuphong;
    }

    public void setDoanhthuphong(String doanhthuphong) {
        this.doanhthuphong = doanhthuphong;
    }

    public String getSoluongdichvu() {
        return soluongdichvu;
    }

    public void setSoluongdichvu(String soluongdichvu) {
        this.soluongdichvu = soluongdichvu;
    }

    public String getSoluongsanpham() {
        return soluongsanpham;
    }

    public void setSoluongsanpham(String soluongsanpham) {
        this.soluongsanpham = soluongsanpham;
    }

    public String getSoluongphong() {
        return soluongphong;
    }

    public void setSoluongphong(String soluongphong) {
        this.soluongphong = soluongphong;
    }

    public String getTonggianhap() {
        return tonggianhap;
    }

    public void setTonggianhap(String tonggianhap) {
        this.tonggianhap = tonggianhap;
    }

    public String getTongdoanhthu() {
        return tongdoanhthu;
    }

    public void setTongdoanhthu(String tongdoanhthu) {
        this.tongdoanhthu = tongdoanhthu;
    }

    
}
