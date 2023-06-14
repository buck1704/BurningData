package model;


public class tbl_DoiMatKhau {
    String TaiKhoan, MatKhauCu, MatKhauMoi;
    public String getTaiKhoan;
    public tbl_DoiMatKhau(){}

    public tbl_DoiMatKhau(String TaiKhoan, String MatKhauCu, String MatKhauMoi) {
        this.TaiKhoan = TaiKhoan;
        this.MatKhauCu = MatKhauCu;
        this.MatKhauMoi = MatKhauMoi;
    }

    public String getTaiKhoan() {
        return TaiKhoan;
    }

    public void setTaiKhoan(String TaiKhoan) {
        this.TaiKhoan = TaiKhoan;
    }

    public String getMatKhauCu() {
        return MatKhauCu;
    }

    public void setMatKhauCu(String MatKhauCu) {
        this.MatKhauCu = MatKhauCu;
    }

    public String getMatKhauMoi() {
        return MatKhauMoi;
    }

    public void setMatKhauMoi(String MatKhauMoi) {
        this.MatKhauMoi = MatKhauMoi;
    }

 

    
 
}