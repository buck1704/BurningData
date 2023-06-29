package controller;

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
import model.tbl_HangHoa;
import model.tbl_Nhaphanphoi;
import model.tbl_NhapHang;
import static model.Hotel_Manager.dbURL;

public class HangHoaController {

    
    public static Connection conn = null;
    public static String sql, sql2;
    public static String slm, sls;

    public static List<tbl_HangHoa> LoadDataHangHoaToArrayList(String kt) {
        List<tbl_HangHoa> list = new ArrayList<>();
        try {
            conn = (Connection) DriverManager.getConnection(dbURL);
            Statement st = (Statement) conn.createStatement();
            sql = " select * from mathang ";
            if (kt != null && !kt.equals("")) {
                sql = sql + "where MaHang like N'%" + kt + "%' or TenHang like N'%" + kt + "%'";

            }
            ResultSet rs = (ResultSet) st.executeQuery(sql);
            while (rs.next()) {
                tbl_HangHoa hh = new tbl_HangHoa();
                hh.setMahang(rs.getString("MaHang"));
                hh.setTenhang(rs.getString("TenHang"));
                hh.setMacongty(rs.getString("MaCongTy"));
                hh.setLoaihang(rs.getString("LoaiHang"));
                hh.setSoluong(rs.getString("SoLuong"));
                hh.setDonvitinh(rs.getString("Donvitinh"));
                hh.setGianhap(rs.getString("GiaNhap"));
                hh.setGiaban(rs.getString("GiaBan"));

                list.add(hh);
            }
            st.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(HangHoaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    public static List<tbl_Nhaphanphoi> LoadDatanccToArrayList() {
        List<tbl_Nhaphanphoi> list = new ArrayList<>();
        try {
            conn = (Connection) DriverManager.getConnection(dbURL);
            Statement st = (Statement) conn.createStatement();
            sql = " select * from nhacungcap ";
            ResultSet rs = (ResultSet) st.executeQuery(sql);
            while (rs.next()) {
                tbl_Nhaphanphoi ncc = new tbl_Nhaphanphoi();
                ncc.setMact(rs.getString("MaCongTy"));
                ncc.setTenct(rs.getString("TenCongTy"));
                ncc.setDiachi(rs.getString("DiaChi"));
                ncc.setEmail(rs.getString("Email"));
                ncc.setDienthoai(rs.getString("DienThoai"));

                list.add(ncc);
            }
            st.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(HangHoaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static void ThemHangHoa(tbl_HangHoa hh) {
        conn = null;
        PreparedStatement state = null;
        try {
            java.sql.Connection conn = DriverManager.getConnection(dbURL);
            sql = "INSERT INTO mathang (MaHang, TenHang, MaCongTy,LoaiHang,SoLuong,DonViTinh,GiaNhap,GiaBan) VALUES (?, ?, ?,?, ?, ?,?,?)";
            state = conn.prepareStatement(sql);
            state.setString(1, hh.getMahang());
            state.setString(2, hh.getTenhang());
            state.setString(3, hh.getMacongty());
            state.setString(4, hh.getLoaihang());
            state.setString(5, hh.getSoluong());
            state.setString(6, hh.getDonvitinh());
            state.setString(7, hh.getGianhap());
            state.setString(8, hh.getGiaban());

            state.execute();
            state.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {

            try {
                if (state != null) {
                    state.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void CapNhapHangHoa(tbl_HangHoa hh, String masp) {
        conn = null;
        PreparedStatement state = null;
        try {
            java.sql.Connection conn = DriverManager.getConnection(dbURL);
            sql = "UPDATE mathang SET MaHang = ?, TenHang = ?,MaCongTy=?,LoaiHang=?, SoLuong = ?,DonViTinh=?, GiaNhap=?, GiaBan=? WHERE MaHang = ?";

            state = conn.prepareStatement(sql);
            state.setString(1, hh.getMahang());
            state.setString(2, hh.getTenhang());
            state.setString(3, hh.getMacongty());
            state.setString(5, hh.getSoluong());
            state.setString(4, hh.getLoaihang());
            state.setString(6, hh.getDonvitinh());
            state.setString(7, hh.getGianhap());
            state.setString(8, hh.getGiaban());
            state.setString(9, masp);
            state.execute();
            state.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {

            try {
                if (state != null) {
                    state.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void XoaHangHoa(String masp) {
        conn = null;
        PreparedStatement state = null;
        try {
            java.sql.Connection conn = DriverManager.getConnection(dbURL);
            sql = "DELETE FROM mathang WHERE MaHang = ?";
            state = conn.prepareStatement(sql);
            state.setString(1, masp);
            state.execute();
            state.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {

            try {
                if (state != null) {
                    state.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static boolean KiemTraTrungMa(String tenbang, String tentruong, String manhap, boolean kt, String macu) {
        conn = null;
        Statement state = null;
        boolean kq = false;
        try {
            conn = (Connection) DriverManager.getConnection(dbURL);
            if (kt == true) {
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
            Logger.getLogger(HangHoaController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HangHoaController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HangHoaController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return kq;
    }

    public static List<tbl_NhapHang> LoadDataNhapHangToArrayList(String kt) {
        List<tbl_NhapHang> list = new ArrayList<>();
        try {
            conn = (Connection) DriverManager.getConnection(dbURL);
            Statement st = (Statement) conn.createStatement();
            sql = " select * from nhaphang ";
             if (kt != null && !kt.equals("")) {
                sql = sql + "where MaNhapHang like N'%" + kt + "%' or MaHang like N'%" + kt + "%'";

            }
            ResultSet rs = (ResultSet) st.executeQuery(sql);
            while (rs.next()) {
                tbl_NhapHang nh = new tbl_NhapHang();
                nh.setMaNhap(rs.getString("MaNhapHang"));
                nh.setMaHang(rs.getString("MaHang"));
                nh.setMaCongTy(rs.getString("MaCongTy"));
                nh.setSoluong(rs.getInt("SoLuong"));
                nh.setDonViTinh(rs.getString("Donvitinh"));
                nh.setLoaiHang(rs.getString("LoaiHang"));
                nh.setGiaNhap(rs.getString("GiaNhap"));
                nh.setNgayNhap(rs.getString("NgayNhap"));

                list.add(nh);
            }
            st.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(HangHoaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    public static void NhapHangHoa(tbl_NhapHang nh) throws SQLException {
        conn = null;
        PreparedStatement state = null;
        try {
            java.sql.Connection conn = DriverManager.getConnection(dbURL);
            sql = "Update mathang Set SoLuong= SoLuong + ? , GiaNhap =? WHERE MaHang = ? and MaCongTy=? ";
            state = conn.prepareStatement(sql);
            state.setInt(1, nh.getSoluong());
            state.setString(2, nh.getGiaNhap());
            state.setString(3, nh.getMaHang());
            state.setString(4, nh.getMaCongTy());
            int rowsUpdated = state.executeUpdate();
            if (rowsUpdated == 0) {
                throw new SQLException("Không tìm thấy sản phẩm để cập nhật");
            }

            sql2 = "INSERT INTO nhaphang (MaNhapHang,MaHang, MaCongTy,SoLuong,LoaiHang,DonViTinh,GiaNhap,NgayNhap) VALUES (?,?, ?, ?,?, ?, ?,?) ";
            state = conn.prepareStatement(sql2);
            state.setString(1, nh.getMaNhap());
            state.setString(2, nh.getMaHang());
            state.setString(3, nh.getMaCongTy());
            state.setInt(4, nh.getSoluong());
            state.setString(5, nh.getLoaiHang());
            state.setString(6, nh.getDonViTinh());
            state.setString(7, nh.getGiaNhap());
            state.setString(8, nh.getNgayNhap());
            state.execute();

            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SQLException("Lỗi khi cập nhật sản phẩm");
        } finally {

            try {
                if (state != null) {
                    state.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void SuaHangHoa(tbl_NhapHang hh, String mcnhap, String mmnhap, String mcsp,String mmsp, String mcty) throws SQLException {
        conn = null;
        PreparedStatement state = null;
        int soluongcu = 0;
        try {
            java.sql.Connection conn = DriverManager.getConnection(dbURL);
            sql = " select * from nhaphang where MaNhapHang=? and MaHang=?";
            state = conn.prepareStatement(sql);
            state.setString(1, mcnhap);
            state.setString(2, mcsp);

            ResultSet rs = (ResultSet) state.executeQuery();
            while (rs.next()) {
                soluongcu = rs.getInt("SoLuong"); 
            }
            if (mcsp==mmsp && mcnhap==mmnhap) {
                    sql2 = "Update mathang Set SoLuong= SoLuong - ? +? , GiaNhap =? WHERE MaHang = ? and MaCongTy=? ";
                    state = conn.prepareStatement(sql2);
                    state.setInt(1, soluongcu);
                    state.setInt(2, hh.getSoluong());
                    state.setString(3, hh.getGiaNhap());
                    state.setString(4, hh.getMaHang());
                    state.setString(5, mcty);
                    int rowsUpdated = state.executeUpdate();
                    if (rowsUpdated == 0) {
                        throw new SQLException("Không tìm thấy sản phẩm để cập nhật");
                    }
              
            }
            else  {

                sql2 = "Update mathang Set SoLuong= SoLuong - ? , GiaNhap =? WHERE MaHang = ? and MaCongTy=?";
                state = conn.prepareStatement(sql2);
                state.setInt(1, soluongcu);
                state.setString(2, hh.getGiaNhap());
                state.setString(3, mcsp);
                state.setString(4, mcty);
                state.executeUpdate();

                sql = "Update mathang Set SoLuong= SoLuong + ? , GiaNhap =? WHERE MaHang = ? and MaCongTy=? ";
                state = conn.prepareStatement(sql);
                state.setInt(1, hh.getSoluong());
                state.setString(2, hh.getGiaNhap());
                state.setString(3, hh.getMaHang());
                state.setString(4, hh.getMaCongTy());
                state.executeUpdate();

            }
            sql = "Update  nhaphang Set MaNhapHang = ?, MaHang=?,MaCongTy=?,SoLuong=?,LoaiHang=?,DonViTinh=? , GiaNhap =?,NgayNhap=? WHERE MaNhapHang = ? ";
            state = conn.prepareStatement(sql);
            state.setString(1, hh.getMaNhap());
            state.setString(2, hh.getMaHang());
            state.setString(3, hh.getMaCongTy());
            state.setInt(4, hh.getSoluong());
            state.setString(5, hh.getLoaiHang());
            state.setString(6, hh.getDonViTinh());
            state.setString(7, hh.getGiaNhap());
            state.setString(8, hh.getNgayNhap());
            state.setString(9, mcnhap);
            state.execute();
        
       } catch (SQLException ex) {
            ex.printStackTrace();
//           throw new SQLException("Lỗi khi cập nhật sản phẩm");
        }

    }
        

    public static void XoaNhapHang(tbl_NhapHang hh, String mcnhap, String mcsp, String mcty) {
        conn = null;
        String maNhapHang = null, maHang = null;
        int soluongcu = 0;
        PreparedStatement state = null;
        try {
            java.sql.Connection conn = DriverManager.getConnection(dbURL);

            sql = " select * from nhaphang where MaNhapHang=? and MaHang=?";
            state = conn.prepareStatement(sql);
            state.setString(1, mcnhap);
            state.setString(2, mcsp);

            ResultSet rs = (ResultSet) state.executeQuery();
            while (rs.next()) {
                maNhapHang = rs.getString("MaNhapHang");
                maHang = rs.getString("MaHang");
                soluongcu = rs.getInt("SoLuong");
            }

            sql = "DELETE FROM nhaphang WHERE MaNhapHang = ?";
            state = conn.prepareStatement(sql);
            state.setString(1, mcnhap);
            state.executeUpdate();

            sql2 = "Update mathang Set SoLuong= SoLuong -? , GiaNhap =? WHERE MaHang = ? and MaCongTy=? ";
            state = conn.prepareStatement(sql2);
            state.setInt(1, soluongcu);
            state.setString(2, hh.getGiaNhap());
            state.setString(3, mcsp);
            state.setString(4, mcty);
            state.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {

            try {
                if (state != null) {
                    state.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    public static String LayGiaBan(String mahang) {
         PreparedStatement state = null;
         String giaban = "";

         try {
             java.sql.Connection conn = DriverManager.getConnection(dbURL);
             String sql = "SELECT GiaBan FROM mathang WHERE MaHang=?";
             state = conn.prepareStatement(sql);
             state.setString(1, mahang);

             ResultSet rs = state.executeQuery();
             while (rs.next()) {
                 giaban = rs.getString("GiaBan");
             }
         } catch (SQLException ex) {
             ex.printStackTrace();
             // throw new SQLException("Lỗi khi cập nhật sản phẩm");
         }

         return giaban;
     }
}
