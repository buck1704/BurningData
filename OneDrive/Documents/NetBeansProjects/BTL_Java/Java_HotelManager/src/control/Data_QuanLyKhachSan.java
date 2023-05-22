package control;

import model.tbl_PhieuDangKy;
import model.tbl_KhachHang;
import model.tbl_Phong;
import model.tbl_ChucVu;
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
import model.tbl_NhanVien;
import model.tbl_DoiMatKhau;
import model.Hotel_Manager;

public class Data_QuanLyKhachSan {

    private static Connection conn = null;
    private static String sql, sql2;

    // kiem tra trung ma
    public static boolean KiemTraTrungMa(String tenbang, String tentruong, String manhap, boolean ktThem, String macu) {
        conn = null;
        Statement state = null;
        boolean kq = false;
        try {
            conn = (Connection) DriverManager.getConnection(Hotel_Manager.dbURL);
            if (ktThem == true) {
                sql = "Select * From " + tenbang + " Where " + tentruong + " = '" + manhap + "'";
            } else {
                sql = "Select * From " + tenbang + " Where " + tentruong + " = '" + manhap + "' and " + tentruong + " <> '" + macu + "'";
            }
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
        } catch (SQLException ex) {
            Logger.getLogger(Data_QuanLyKhachSan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }
    
    

    public static void DoiMatKhau(tbl_DoiMatKhau bp) {
        boolean success = false;
        Connection conn = null;
        PreparedStatement state = null;
        try {
            conn = DriverManager.getConnection(Hotel_Manager.dbURL);
            String sql = "UPDATE TaiKhoan SET MatKhau = ? WHERE TaiKhoan = ? AND MatKhau = ?";
            state = conn.prepareStatement(sql);
            state.setString(1, bp.getMatKhauMoi());
            state.setString(2, bp.getTaiKhoan());
            state.setString(3, bp.getMatKhauCu());
            int rowsAffected = state.executeUpdate();
            if (rowsAffected > 0) {
                success = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void QuenMatKhau(tbl_NhanVien nv) {
        Connection conn = null;
        PreparedStatement state = null;
        try {
            conn = DriverManager.getConnection(Hotel_Manager.dbURL);
            String sql = "UPDATE TaiKhoan SET MatKhau = ? WHERE TaiKhoan = ? AND MaNhanVien = ?";
            state = conn.prepareStatement(sql);
            state.setString(1, nv.getPasswword());
            state.setString(2, nv.getTendn());
            state.setString(3, nv.getManv());
            state.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static boolean KiemTraDatLaiMatKhau(String manhap1, String manhap2) {
        conn = null;
        Statement state = null;
        boolean kq = false;
        try {
            conn = (Connection) DriverManager.getConnection(Hotel_Manager.dbURL);
            sql = "Select * from NhanVien, TaiKhoan where NhanVien.MaNhanVien=TaiKhoan.MaNhanVien and NhanVien.MaNhanVien= '" + manhap1 + "' and NhanVien.SDT='" + manhap2 + "'";
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
        } catch (SQLException ex) {
            Logger.getLogger(Data_QuanLyKhachSan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }
}
