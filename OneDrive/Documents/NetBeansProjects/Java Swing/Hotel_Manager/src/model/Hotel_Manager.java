package model;

import view.JF_DangNhap;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Hotel_Manager {
    // Cách 1: sử dụng xampp
//    public static String sTenDN, sMaNhanVien, sMatKhau , sTenNhanVien, sMaChucVu, sGioiTinh, sNgaySinh, sSDT,sDiaChi, sLuong;
//    public static String dbURL;
//    
//    public static void main(String[] args) throws ClassNotFoundException {
//        try {
//            Connection conn = null;
//            dbURL = "jdbc:mysql://localhost:3306/hotel_manager?user=root&password=";
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            conn = DriverManager.getConnection(dbURL);
//            System.out.println("Connect");
//            JFrame login = new JF_DangNhap();
//            login.setVisible(true);
//        } catch (SQLException ex) {
//            Logger.getLogger(Hotel_Manager.class.getName()).log(Level.SEVERE, null, ex);
//        }
//            
//    }
    
 // Cách 2: sử dụng sql server    
    public static String dbURL = "jdbc:sqlserver://localhost; databaseName=hotel_manager; user=sa; password=sa; encrypt = false";
    public static String sTenDN, sMaNhanVien, sMatKhau;
    public static void main(String[] args) {
        JFrame login = new JF_DangNhap();
        login.setVisible(true);
    }
}
    