package control;

import static control.Data_HangHoa.conn;
import static control.Data_HangHoa.sql;
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
import model.Hotel_Manager;
import model.tbl_PhieuTraPhong;


public class Data_TraPhong {
    private static Connection conn = null;
    private static String sql;
    
    public static ArrayList<tbl_PhieuTraPhong> NguonPhong(String sPhanLoai, String sMaKT) throws SQLException  {
        ArrayList<tbl_PhieuTraPhong> arrPhieuTra = new ArrayList<>();
        Statement state = null;
        try {
            conn = (Connection) DriverManager.getConnection(Hotel_Manager.dbURL);
            // Thực hiện truy vấn và lấy kết quả trả về
            sql = "SELECT hd.MaHoaDon, kh.TenKhachHang, pdp.MaPhong, pdp.NgayDen, pdp.NgayDi,\n"
                    + "DATEDIFF(pdp.NgayDi, pdp.NgayDen) AS SoNgayLuTru, pdp.ThanhTienP,\n"
                    + "IFNULL(pd.TongTien, 0) AS GiaDichVu, IFNULL(ps.TongTien, 0) AS GiaSanPham,\n"
                    + "hd.TongTien,\n"
                    + "CASE WHEN hd.TongTien - hd.TienCoc = 0 THEN 'Hoàn Thành'\n"
                    + "ELSE hd.TongTien - hd.TienCoc END AS ConThieu\n"
                    + "FROM hoadon hd\n"
                    + "JOIN phieudatphong pdp ON hd.MaPhieuDatPhong = pdp.MaPhieuDatPhong\n"
                    + "JOIN khachhang kh ON pdp.MaKhachHang = kh.MaKhachHang\n"
                    + "LEFT JOIN phieudichvu pd ON hd.MaPhieuDichVu = pd.MaPhieuDichVu\n"
                    + "LEFT JOIN phieusanpham ps ON hd.MaPhieuSanPham = ps.MaPhieuSanPham";
            if (sMaKT != null && !sMaKT.equals("")) {
                sql = sql + " WHERE " + sPhanLoai + " LIKE '%" + sMaKT + "%' ";
            }

            state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            // Xử lý kết quả trả về
            while (rs.next()) {
                tbl_PhieuTraPhong bp = new tbl_PhieuTraPhong();
                bp.setMahoadon(rs.getString("hd.MaHoaDon"));
                bp.setTenkhachhang(rs.getString("kh.TenKhachHang"));
                bp.setPhong(rs.getString("pdp.MaPhong"));
                bp.setNgayden(rs.getString("pdp.NgayDen"));
                bp.setNgaydi(rs.getString("pdp.NgayDi"));
                bp.setSongayolai(rs.getString("SoNgayLuTru"));
                bp.setGiaphong(rs.getString("pdp.ThanhTienP"));
                bp.setGiadichvu(rs.getString("GiaDichVu"));
                bp.setGiasanpham(rs.getString("GiaSanPham"));
                bp.setTongthanhtoan(rs.getString("hd.TongTien"));
                bp.setTiencoc(rs.getString("ConThieu"));
                arrPhieuTra.add(bp);
            }
            state.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Lỗi: " + ex.getMessage());
        }
        return arrPhieuTra;
    }
    
    public static void CapNhatTinhTrang(String tTruong, String tCotUpdate, String gTriUpdate, String tCotDK, String gTriDK) throws SQLException{
        conn = null;
        PreparedStatement state = null;
        conn = DriverManager.getConnection(Hotel_Manager.dbURL);
        sql = "UPDATE "+ tTruong +" SET "+ tCotUpdate +" = '"+ gTriUpdate +"' WHERE "+ tCotDK + " = '" + gTriDK + "'";
        state = conn.prepareStatement(sql);
        state.execute();
        state.close();
        conn.close();
    }
    
}
