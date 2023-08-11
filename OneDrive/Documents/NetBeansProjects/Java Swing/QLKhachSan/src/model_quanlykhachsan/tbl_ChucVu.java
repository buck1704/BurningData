package model_quanlykhachsan;


public class tbl_ChucVu {
    String maChucVu, tenChucVu, luongTheoNgay;
    
    public tbl_ChucVu(){}
    
    public tbl_ChucVu(String maChucVu, String tenChucVu, String luongTheoNgay) {
        this.maChucVu = maChucVu;
        this.tenChucVu = tenChucVu;
        this.luongTheoNgay = luongTheoNgay;
    }

    public String getMaChucVu() {
        return maChucVu;
    }
    public void setMaChucVu(String maChucVu) {
        this.maChucVu = maChucVu;
    }
    public String getTenChucVu() {
        return tenChucVu;
    }
    public void setTenChucVu(String tenChucVu) {
        this.tenChucVu = tenChucVu;
    }
    public String getLuongTheoNgay() {
        return luongTheoNgay;
    }
    public void setLuongTheoNgay(String luongTheoNgay) {
        this.luongTheoNgay = luongTheoNgay;
    }

}
