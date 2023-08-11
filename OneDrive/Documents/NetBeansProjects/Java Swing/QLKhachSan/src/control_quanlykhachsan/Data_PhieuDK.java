/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control_quanlykhachsan;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model_quanlykhachsan.QLKhachSan;
import model_quanlykhachsan.tbl_KhachHang;
import model_quanlykhachsan.tbl_PhieuDangKy;
import model_quanlykhachsan.tbl_Phong;

/**
 *
 * @author 05032002
 */
public class Data_PhieuDK {
    private static Connection conn = null;
    private static String sql,sql2;
    
    public static List<tbl_PhieuDangKy> NguonPhieuDK(String sMaKT) throws IOException {
        List<tbl_PhieuDangKy> arrPhieuDky = new ArrayList<>();
        Statement state = null;
        try {
            java.sql.Connection conn = DriverManager.getConnection(QLKhachSan.dbURL);
            // Thực hiện truy vấn và lấy kết quả trả về
            sql = "Select PhieuDangKy.MaPhieuDangKy, PhieuDangKy.MaKhachHang, KhachHang.TenKhachHang, PhieuDangKy.NgayDen, PhieuDangKy.NgayDi, PhieuDangKy.MaPhong, PhieuDangKy.ThanhTienP, NhanVien.MaNhanVien \n" +
                        "From PhieuDangKy, KhachHang, NhanVien\n" +
                        "WHERE PhieuDangKy.MaKhachHang = KhachHang.MaKhachHang and PhieuDangKy.MaNhanVien = NhanVien.MaNhanVien";
            if (sMaKT != null && !sMaKT.equals("")) {
                sql = sql + " and PhieuDangKy.MaPhieuDangKy ='" + sMaKT + "'";
            }
            state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            // Xử lý kết quả trả về
            while (rs.next()) {
                tbl_PhieuDangKy bp = new tbl_PhieuDangKy();
                bp.setMaPhieuDK(rs.getString("MaPhieuDangKy"));
                bp.setMaKhachHang(rs.getString("MaKhachHang"));
                bp.setTenKhachHang(rs.getString("TenKhachHang"));
                bp.setNgayDen(rs.getString("NgayDen"));
                bp.setNgayDi(rs.getString("NgayDi"));
                bp.setMaPhong(rs.getString("MaPhong"));
                bp.setThanhTien(rs.getString("ThanhTienP"));
                bp.setMaNhanVien(rs.getString("MaNhanVien"));
                arrPhieuDky.add(bp);
            }
            state.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return arrPhieuDky;
    }
    public static List<tbl_Phong> NguonCBOPhieuDK_Phong() throws IOException {
        List<tbl_Phong> arrNguonCBOPhieuDK_Phong = new ArrayList<>();
        Statement state = null;
        try {
            java.sql.Connection conn = DriverManager.getConnection(QLKhachSan.dbURL);
            // Thực hiện truy vấn và lấy kết quả trả về
            sql = "SELECT * FROM `phong`";
            state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            // Xử lý kết quả trả về
            while (rs.next()) {
                tbl_Phong bp = new tbl_Phong();
                bp.setMaPhong(rs.getString("MaPhong"));
                arrNguonCBOPhieuDK_Phong.add(bp);
            }
            state.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        return arrNguonCBOPhieuDK_Phong;
    }
    public static List<tbl_KhachHang> NguonCBOPhieuDK_KhachHang() throws IOException {
        List<tbl_KhachHang> arrNguonCBOPhieuDK_KhachHang = new ArrayList<>();
        Statement state = null;
        try {
            java.sql.Connection conn = DriverManager.getConnection(QLKhachSan.dbURL);
            // Thực hiện truy vấn và lấy kết quả trả về
            sql = "SELECT * FROM `khachhang`";
            state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            // Xử lý kết quả trả về
            while (rs.next()) {
                tbl_KhachHang bp = new tbl_KhachHang();
                bp.setMakh(rs.getString("MaKhachHang"));
                arrNguonCBOPhieuDK_KhachHang.add(bp);
            }
            state.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        return arrNguonCBOPhieuDK_KhachHang;
    }
    
    public static String NguonHienThiTenKhachHang(String idcheck) throws IOException {
        Statement state = null;
        String tenkhachhang = "";
        try {
            java.sql.Connection conn = DriverManager.getConnection(QLKhachSan.dbURL);
            sql = "Select TenKhachHang From KhachHang Where MaKhachHang = '" + idcheck + "' order by MaKhachHang";
            state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            // Xử lý kết quả trả về
            if (rs.next()) {
                
                tenkhachhang = (rs.getString("TenKhachHang"));
            }
            else {
                tenkhachhang = "";
            }
            state.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        return tenkhachhang;
    }
    
    public static void ThemPhieuDk(tbl_PhieuDangKy bp) {
        conn = null;
        PreparedStatement state = null;
        try {
            java.sql.Connection conn = DriverManager.getConnection(QLKhachSan.dbURL);
            sql = "INSERT INTO PhieuDangKy VALUES(?, ?, ?, ?, ?, ?, ?)";
            state = conn.prepareStatement(sql);
            state.setString(1, bp.getMaPhieuDK());
            state.setString(2, bp.getMaKhachHang());
            state.setString(3, bp.getMaNhanVien());
            state.setString(4, bp.getNgayDen());
            state.setString(5, bp.getNgayDi());
            state.setString(6, bp.getMaPhong());
            state.setString(7, bp.getThanhTien());
            state.execute();
            state.close();
            conn.close();
        } catch (SQLException ex) {
        } 
    }
    public static void CapNhatPhieuDk(tbl_PhieuDangKy bp, String maphieudk) {
        conn = null;
        PreparedStatement state = null;
        try {
            java.sql.Connection conn = DriverManager.getConnection(QLKhachSan.dbURL);
            sql = "UPDATE PhieuDangKy SET MaPhieuDangKy = ?, MaKhachHang = ?, MaNhanVien = ?, NgayDen = ?, NgayDi = ?, MaPhong = ?, ThanhTienP = ? "
                    + "WHERE MaPhieuDangKy = ?";
            state = conn.prepareStatement(sql);
            state.setString(1, bp.getMaPhieuDK());
            state.setString(2, bp.getMaKhachHang());
            state.setString(3, bp.getMaNhanVien());
            state.setString(4, bp.getNgayDen());
            state.setString(5, bp.getNgayDi());
            state.setString(6, bp.getMaPhong());
            state.setString(7, bp.getThanhTien());
            state.setString(8, maphieudk);
            state.execute();
            state.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public static void XoaPhieuDk( String maphieudk) {
        conn = null;
        PreparedStatement state = null;
        try {
            java.sql.Connection conn = DriverManager.getConnection(QLKhachSan.dbURL);
            sql = "DELETE FROM PhieuDangKy  WHERE MaPhieuDangKy = ?";
            state = conn.prepareStatement(sql);
            state.setString(1, maphieudk);
            state.execute();
            state.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
    }
    public static int LayMaPhong(String maphong) {
        int giaPhong = 0;
        conn = null;
        PreparedStatement statement = null;
        try {
            conn = DriverManager.getConnection(QLKhachSan.dbURL);
            String sql = "SELECT GiaPhong FROM Phong WHERE MaPhong = ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, maphong);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                giaPhong = rs.getInt("GiaPhong");
            }
            statement.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return giaPhong;
    }
    
    public static List<tbl_Phong> NguonPhong(String sPhanLoai, String sMaKT) throws IOException {
        List<tbl_Phong> arrPhong = new ArrayList<>();
        Statement state = null;
        try {
            conn = DriverManager.getConnection(QLKhachSan.dbURL);
            // Thực hiện truy vấn và lấy kết quả trả về
            sql = "Select MaPhong, LoaiPhong, LEFT(MaPhong,1) as Tang, TinhTrang From Phong";
            if(sMaKT != null && !sMaKT.equals("")){
                sql = sql + " Where " + sPhanLoai + " Like '%" + sMaKT + "%'";
            }
            sql = sql + " Order by MaPhong";
            state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            // Xử lý kết quả trả về
            while (rs.next()) {
                tbl_Phong bp = new tbl_Phong();
                bp.setMaPhong(rs.getString("MaPhong"));
                bp.setLoaiPhong(rs.getString("LoaiPhong"));
                bp.setTang(rs.getString("Tang"));
                bp.setTinhTrang(rs.getString("TinhTrang"));
                if(rs.getString("TinhTrang").equals("0")){
                    bp.setTinhTrang("Trống");
                } else {
                    bp.setTinhTrang("Đầy");
                }
                arrPhong.add(bp);
            }
            state.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return arrPhong;
    }
    
    public static List<tbl_KhachHang> NguonKhachHang(String sPhanLoai, String sMaKT) throws IOException {
        List<tbl_KhachHang> arrKhachHang = new ArrayList<>();
        Statement state = null;
        try {
            conn = DriverManager.getConnection(QLKhachSan.dbURL);
            // Thực hiện truy vấn và lấy kết quả trả về
            sql = "Select * From KhachHang";
            if(sMaKT != null && !sMaKT.equals("")){
                sql = sql + " Where " + sPhanLoai + " Like '%" + sMaKT + "%'";
            }
            sql = sql + " order by MaKhachHang DESC";
            state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            // Xử lý kết quả trả về
            while (rs.next()) {
                tbl_KhachHang bp = new tbl_KhachHang();
                bp.setMakh(rs.getString("MaKhachHang"));
                bp.setTenkh(rs.getString("TenKhachHang"));
                bp.setDiachi(rs.getString("diachi"));
                bp.setGioitinh(rs.getString("gioitinh"));
                bp.setCmnd(rs.getString("cmnd"));
                bp.setSodt(rs.getString("SDT"));
                arrKhachHang.add(bp);
            }
            state.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        return arrKhachHang;
    }
    
    public static String NguonTruyVanDuLieu(String sTenCotGT, String sTenBang, String sTenCotDK, String sDieuKien) throws IOException {
        String ketqua = "";
        Statement state = null;
        try {
            conn = DriverManager.getConnection(QLKhachSan.dbURL);
            // Thực hiện truy vấn và lấy kết quả trả về
            sql = "Select " + sTenCotGT +" From "+ sTenBang +" Where " + sTenCotDK + " = '"+ sDieuKien + "'";
            state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            // Xử lý kết quả trả về
            while (rs.next()) {
                ketqua = rs.getString(sTenCotGT);
            }
            state.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ketqua;
    }
    
    // kiem tra trung ma
    public static boolean KiemTra(String tenbang, String tentruong, String manhap) throws SQLException {
        conn = null;
        Statement state = null;
        boolean kq = false;
        conn = DriverManager.getConnection(QLKhachSan.dbURL);
        sql = "Select * From " + tenbang + " Where " + tentruong + " = '" + manhap + "'";
        state = conn.createStatement();
        ResultSet rs = state.executeQuery(sql);
        if (rs.next()) {
            state.close();
            conn.close();
            kq = true;
        } else {
            state.close();
            conn.close();
            kq = false;
        }
        return kq;
    }
}
