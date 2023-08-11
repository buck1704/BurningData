package model;


public class tbl_HangHoa {
    public String mahang,tenhang,macongty,loaihang,donvitinh,gianhap,giaban;
    int soluong;

    public tbl_HangHoa(String mahang, String tenhang, String macongty, String loaihang, int soluong, String donvitinh, String gianhap, String giaban) {
        this.mahang = mahang;
        this.tenhang = tenhang;
        this.macongty = macongty;
        this.loaihang = loaihang;
        this.soluong = soluong;
        this.donvitinh = donvitinh;
        this.gianhap = gianhap;
        this.giaban = giaban;
    }

    public tbl_HangHoa(String mahang, String gianhap, int soluong) {
        this.mahang = mahang;
        this.gianhap = gianhap;
        this.soluong = soluong;
    }
 
    public String getMahang() {
        return mahang;
    }

    public void setMahang(String mahang) {
        this.mahang = mahang;
    }

    public String getTenhang() {
        return tenhang;
    }

    public void setTenhang(String tenhang) {
        this.tenhang = tenhang;
    }

    public String getMacongty() {
        return macongty;
    }

    public void setMacongty(String macongty) {
        this.macongty = macongty;
    }

    public String getLoaihang() {
        return loaihang;
    }

    public void setLoaihang(String loaihang) {
        this.loaihang = loaihang;
    }

    public String getDonvitinh() {
        return donvitinh;
    }

    public void setDonvitinh(String donvitinh) {
        this.donvitinh = donvitinh;
    }

    public String getGianhap() {
        return gianhap;
    }

    public void setGianhap(String gianhap) {
        this.gianhap = gianhap;
    }

    public String getGiaban() {
        return giaban;
    }

    public void setGiaban(String giaban) {
        this.giaban = giaban;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public tbl_HangHoa() {
    }
    
}
