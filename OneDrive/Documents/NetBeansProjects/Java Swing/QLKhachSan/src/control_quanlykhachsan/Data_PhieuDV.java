/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control_quanlykhachsan;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model_quanlykhachsan.QLKhachSan;
import model_quanlykhachsan.tbl_PhieuDangKy;


public class Data_PhieuDV {
    private static Connection conn = null;
    private static String sql,sql2;
    
    public static List<tbl_PhieuDangKy> NguonPhieuDK(String sPhanLoai, String sGiaTri) throws IOException {
        List<tbl_PhieuDangKy> arrPhieuDky = new ArrayList<>();
        Statement state = null;
        try {
            java.sql.Connection conn = DriverManager.getConnection(QLKhachSan.dbURL);
            // Thực hiện truy vấn và lấy kết quả trả về
            sql = "Select * From PhieuDangKy";
            if(sGiaTri != null && !sGiaTri.equals("") && sPhanLoai != null && !sPhanLoai.equals("")){
                sql = sql + " Where " + sPhanLoai + " Like '%" + sGiaTri + "%'";
            }
            state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            // Xử lý kết quả trả về
            while (rs.next()) {
                tbl_PhieuDangKy bp = new tbl_PhieuDangKy();
                bp.setMaPhieuDK(rs.getString("MaPhieuDangKy"));
                bp.setMaKhachHang(rs.getString("MaKhachHang"));
                bp.setMaPhong(rs.getString("MaPhong"));
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
}
