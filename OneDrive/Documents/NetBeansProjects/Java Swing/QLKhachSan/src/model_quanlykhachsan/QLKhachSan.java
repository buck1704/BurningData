package model_quanlykhachsan;

import view_quanlykhachsan.JF_DangNhap;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class QLKhachSan {
    public static String sTenDN, sMaNhanVien, sMatKhau;
    public static String dbURL;
    
    public static void main(String[] args) throws ClassNotFoundException {
        try {
            Connection conn = null;
            dbURL = "jdbc:mysql://localhost:3306/quanlykhachsan?user=root&password=";
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL);
            System.out.println("Connect");
            JFrame login = new JF_DangNhap();
            login.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(QLKhachSan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
