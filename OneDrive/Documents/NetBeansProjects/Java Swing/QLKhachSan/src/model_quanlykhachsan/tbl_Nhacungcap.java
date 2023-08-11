package model_quanlykhachsan;

public class tbl_Nhacungcap {
    String mact,tenct,diachi,email,dienthoai;

    public tbl_Nhacungcap() {
    }

    public tbl_Nhacungcap(String mact, String tenct, String diachi, String email, String dienthoai) {
        this.mact = mact;
        this.tenct = tenct;
        this.diachi = diachi;
        this.email = email;
        this.dienthoai = dienthoai;
    }

    public String getMact() {
        return mact;
    }

    public void setMact(String mact) {
        this.mact = mact;
    }

    public String getTenct() {
        return tenct;
    }

    public void setTenct(String tenct) {
        this.tenct = tenct;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDienthoai() {
        return dienthoai;
    }

    public void setDienthoai(String dienthoai) {
        this.dienthoai = dienthoai;
    }
    
}
