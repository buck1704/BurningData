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
import model.tbl_CTPhieuDV;
import model.tbl_CTPhieuSP;
import model.tbl_DichVu;
import model.tbl_HangHoa;
import model.tbl_HoaDon;
import model.tbl_KhachHang;
import model.tbl_PhieuDatPhong;
import model.tbl_Phong;
import model.tbl_PhieuBonus;

public class Data_DatPhong {

    private static Connection conn = null;
    private static String sql, sql1;

    public static List<tbl_Phong> NguonPhong(String sPhanLoai, String sMaKT) throws IOException {
        List<tbl_Phong> arrPhong = new ArrayList<>();
        Statement state = null;
        try {
            conn = DriverManager.getConnection(Hotel_Manager.dbURL);
            // Thực hiện truy vấn và lấy kết quả trả về
            sql = "Select MaPhong, LoaiPhong, LEFT(MaPhong,1) as Tang, TinhTrang From Phong";
            if (sMaKT != null && !sMaKT.equals("")) {
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
                if (rs.getString("TinhTrang").equals("0")) {
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

    public static List<tbl_KhachHang> NguonKhachHang(String sPhanLoai, String sMaKT) {
        List<tbl_KhachHang> arrKhachHang = new ArrayList<>();
        Statement state = null;
        try {
            conn = DriverManager.getConnection(Hotel_Manager.dbURL);
            // Thực hiện truy vấn và lấy kết quả trả về
            sql = "Select * From KhachHang";
            if (sMaKT != null && !sMaKT.equals("")) {
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

    public static List<tbl_HangHoa> NguonSanPham(String sMaKT) {
        List<tbl_HangHoa> arrHangHoa = new ArrayList<>();
        Statement state = null;
        try {
            conn = DriverManager.getConnection(Hotel_Manager.dbURL);
            state = conn.createStatement();
            sql = "select * from mathang where soluong > 0";
            if (sMaKT != null && !sMaKT.equals("")) {
                sql = sql + " and mahang Like '%" + sMaKT + "%'";
            }
            ResultSet rs = (ResultSet) state.executeQuery(sql);
            while (rs.next()) {
                tbl_HangHoa hh = new tbl_HangHoa();
                hh.setMahang(rs.getString("MaHang"));
                hh.setTenhang(rs.getString("TenHang"));
                hh.setMacongty(rs.getString("MaCongTy"));
                hh.setLoaihang(rs.getString("LoaiHang"));
                hh.setSoluong(rs.getInt("SoLuong"));
                hh.setDonvitinh(rs.getString("Donvitinh"));
                hh.setGianhap(rs.getString("GiaNhap"));
                hh.setGiaban(rs.getString("GiaBan"));

                arrHangHoa.add(hh);
            }
            state.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Data_HangHoa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrHangHoa;

    }

    public static List<tbl_DichVu> NguonDichVu(String sMaKT) {
        List<tbl_DichVu> arrDichVu = new ArrayList<>();
        Statement state = null;
        try {
            java.sql.Connection conn = DriverManager.getConnection(Hotel_Manager.dbURL);
            // Thực hiện truy vấn và lấy kết quả trả về
            sql = "Select * From DichVu ";
            if (sMaKT != null && !sMaKT.equals("")) {
                sql = sql + " Where MaDichVu Like '%" + sMaKT + "%'";
            }
            sql = sql + " Order by MaDichVu";
            state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            // Xử lý kết quả trả về
            while (rs.next()) {
                tbl_DichVu bp = new tbl_DichVu();
                bp.setMadichvu(rs.getString("MaDichVu"));
                bp.setTendichvu(rs.getString("TenDichVu"));
                bp.setGiadichvu(rs.getString("Gia"));
                arrDichVu.add(bp);
            }
            state.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return arrDichVu;
    }
    
    public static List<tbl_PhieuDatPhong> NguonPhieuDatPhong(String sMaKT) throws IOException {
        List<tbl_PhieuDatPhong> arrPhieuDatPhong = new ArrayList<>();
        Statement state = null;
        try {
            conn = DriverManager.getConnection(Hotel_Manager.dbURL);
            // Thực hiện truy vấn và lấy kết quả trả về
            sql = "Select * From phieudatphong";
            if(sMaKT != null && !sMaKT.equals("")){
                sql = sql + " Where MaPhieuDatPhong ='" + sMaKT + "'";
            }
            sql = sql + " order by MaPhieuDatPhong ";
            state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            // Xử lý kết quả trả về
            while (rs.next()) {
                tbl_PhieuDatPhong bp = new tbl_PhieuDatPhong();
                bp.setMaPhieuDK(rs.getString("MaPhieuDatPhong"));
                bp.setMaKhachHang(rs.getString("MaKhachHang"));
                bp.setNgayDen(rs.getString("NgayDen"));
                bp.setNgayDi(rs.getString("NgayDi"));
                bp.setMaPhong(rs.getString("MaPhong"));
                bp.setMaNhanVien(rs.getString("MaNhanVien"));
                bp.setThanhTien(rs.getString("ThanhTienP"));
                arrPhieuDatPhong.add(bp);
            }
            state.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        return arrPhieuDatPhong;
    }

    public static String NguonTruyVanDuLieu(String sTenCotGT, String sTenBang, String sTenCotDK, String sDieuKien) throws IOException {
        String ketqua = "";
        Statement state = null;
        try {
            conn = DriverManager.getConnection(Hotel_Manager.dbURL);
            // Thực hiện truy vấn và lấy kết quả trả về
            sql = "Select " + sTenCotGT + " From " + sTenBang + " Where " + sTenCotDK + " = '" + sDieuKien + "'";
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
        conn = DriverManager.getConnection(Hotel_Manager.dbURL);
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

    public static void ThemKhachHang(tbl_KhachHang bp) throws SQLException {
        conn = null;
        PreparedStatement state = null;
        try {
            java.sql.Connection conn = DriverManager.getConnection(Hotel_Manager.dbURL);
            sql = "INSERT INTO KhachHang (MaKhachHang, TenKhachHang, DiaChi, GioiTinh, CMND, SDT) VALUES(?, ?, ?, ?, ?, ?)";
            state = conn.prepareStatement(sql);
            state.setString(1, bp.getMakh());
            state.setString(2, bp.getTenkh());
            state.setString(3, bp.getDiachi());
            state.setString(4, bp.getGioitinh());
            state.setString(5, bp.getCmnd());
            state.setString(6, bp.getSodt());
            state.execute();
            state.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void ThemPhieuDatPhong(tbl_PhieuDatPhong bp) throws SQLException {
        Connection conn = null;
        PreparedStatement state = null;
        String updateTinhTrang = "UPDATE phong SET TinhTrang='1' WHERE MaPhong = ?";
        try {
            conn = DriverManager.getConnection(Hotel_Manager.dbURL);
            sql = "INSERT INTO phieudatphong VALUES(?, ?, ?, ?, ?, ?, ?)";
            state = conn.prepareStatement(sql);
            state.setString(1, bp.getMaPhieuDK());
            state.setString(2, bp.getMaKhachHang());
            state.setString(3, bp.getMaNhanVien());
            state.setString(4, bp.getNgayDen());
            state.setString(5, bp.getNgayDi());
            state.setString(6, bp.getMaPhong());
            state.setString(7, bp.getThanhTien());
            state.execute();

            PreparedStatement update = conn.prepareStatement(updateTinhTrang);
            update.setString(1, bp.getMaPhong());
            update.executeUpdate();
        } catch (SQLException ex) {
            // Hiển thị thông báo lỗi
            System.out.println("Lỗi khi thêm phiếu đặt phòng: " + ex.getMessage());
        } finally {
            if (state != null) {
                state.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    // Thêm dữ liệu cho cả bảng phieudichvu, phieusanpham;
    public static void ThemPhieuBonus(tbl_PhieuBonus bp, String MaLoaiPhieu, String tenBang, String dinhDangPhieu) throws SQLException {
        conn = null;
        PreparedStatement state = null;
        try {
            java.sql.Connection conn = DriverManager.getConnection(Hotel_Manager.dbURL);
            // Lấy mã chức vụ lớn nhất trong CSDL
            String sql = "SELECT MAX(" + MaLoaiPhieu + ") FROM " + tenBang;
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            // Lấy số thứ tự của mã chức vụ hiện tại
            int index = 0;
            if (rs.next()) {
                String maxId = rs.getString(1);
                if (maxId != null) {
                    index = Integer.parseInt(maxId.substring(3));
                }
            }
            index++;
            String newId = dinhDangPhieu + String.format("%03d", index);
            // Thêm mới vào CSDL với mã phiếu dịch vụ mới
            sql = "INSERT INTO " + tenBang + " VALUES (?, ?, ?)";
            state = conn.prepareStatement(sql);
            state.setString(1, newId);
            state.setString(2, bp.getMaphieudatphong());
            state.setString(3, bp.getTongtien());
            state.execute();
            state.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Lỗi: " + ex.getMessage());
        }
    }

    public static void ThemCTPhieuDichVu(tbl_CTPhieuDV bp) throws SQLException {
        String sql_check = "SELECT MAX(MaCTDV) FROM ChiTietPhieuDichVu";
        String sql_checkMa = "SELECT MAX(MaPhieuDichVu) FROM PhieuDichVu";
        sql = "INSERT INTO ChiTietPhieuDichVu  VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(Hotel_Manager.dbURL); Statement statement = conn.createStatement(); ResultSet rs = statement.executeQuery(sql_check); Statement statement1 = conn.createStatement(); ResultSet rs1 = statement1.executeQuery(sql_checkMa); PreparedStatement state = conn.prepareStatement(sql)) {

            // Lấy số thứ tự của mã hiện tại
            int index = 1;
            if (rs.next()) {
                String maxId = rs.getString(1);
                if (maxId != null) {
                    index = Integer.parseInt(maxId.substring(1)) + 1;
                }
            }
            // Lấy mã phiếu dịch vụ cuối cùng trong CSDL
            String maphieudichvu = null;
            if (rs1.next()) {
                maphieudichvu = rs1.getString(1);
            }
            // Thêm mới vào CSDL với mã mới
            state.setString(1, String.format("%03d", index));
            state.setString(2, maphieudichvu);
            state.setString(3, bp.getMaDichVu());
            state.setString(4, bp.getThanhTien());
            state.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void ThemCTPhieuSanPham(tbl_CTPhieuSP bp) throws SQLException {
        String maxMaCTSP = "SELECT MAX(MaCTSP) FROM ChiTietPhieuSanPham";
        String maxMaPhieuSP = "SELECT MAX(MaPhieuSanPham) FROM PhieuSanPham";
        String updateSoLuong = "UPDATE mathang SET SoLuong = SoLuong - ? WHERE MaHang = ?";
        sql = "INSERT INTO ChiTietPhieuSanPham VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(Hotel_Manager.dbURL); PreparedStatement getMaxMaCTSP = conn.prepareStatement(maxMaCTSP); PreparedStatement getMaxMaPhieuSP = conn.prepareStatement(maxMaPhieuSP); PreparedStatement updateSoLuongMH = conn.prepareStatement(updateSoLuong); PreparedStatement insertdata = conn.prepareStatement(sql)) {
            int index = 0;
            ResultSet rs = getMaxMaCTSP.executeQuery();
            if (rs.next()) {
                String maxId = rs.getString(1);
                if (maxId != null) {
                    index = Integer.parseInt(maxId.substring(1));
                }
            }
            index++;
            rs.close();
            rs = getMaxMaPhieuSP.executeQuery();
            String maphieusanpham = null;
            if (rs.next()) {
                maphieusanpham = rs.getString(1);
            }
            insertdata.setString(1, String.format("%03d", index));
            insertdata.setString(2, maphieusanpham);
            insertdata.setString(3, bp.getMaHang());
            insertdata.setString(4, bp.getSoLuong());
            insertdata.setString(5, bp.getThanhTien());
            insertdata.executeUpdate();

            updateSoLuongMH.setString(1, bp.getSoLuong());
            updateSoLuongMH.setString(2, bp.getMaHang());
            updateSoLuongMH.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Lỗi: " + ex.getMessage());

        }
    }

    public static void ThemHoaDon(tbl_HoaDon bp) throws SQLException {
        String maxIdHoaDon = "SELECT MAX(MaHoaDon) FROM HoaDon";
        String maxIdPhieuDV = "SELECT MAX(MaPhieuDichVu) FROM PhieuDichVu";
        String maxIdPhieuSP = "SELECT MAX(MaPhieuSanPham) FROM PhieuSanPham";
        sql = "INSERT INTO hoadon(MaHoaDon, MaPhieuDatPhong, MaPhieuDichVu, MaPhieuSanPham, NgayLap, TongTien, TienCoc) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(Hotel_Manager.dbURL); PreparedStatement getMaxIdHoaDon = conn.prepareStatement(maxIdHoaDon); PreparedStatement getMaxIdPhieuDV = conn.prepareStatement(maxIdPhieuDV); PreparedStatement getMaxIdPhieuSP = conn.prepareStatement(maxIdPhieuSP); PreparedStatement insertdata = conn.prepareStatement(sql)) {
            // Lấy phiếu hoá đơn lớn nhất sau đấy để insert tự tăng 1 đơn vị
            int indexHD = 0;
            ResultSet rs = getMaxIdHoaDon.executeQuery();
            if (rs.next()) {
                String maxId = rs.getString(1);
                if (maxId != null && !maxId.isEmpty()) {
                    indexHD = Integer.parseInt(maxId.substring(2));
                }
            }
            indexHD++;
            String newId = "HD" + String.format("%03d", indexHD);
            rs.close();
            // Lấy ra phiếu dịch vụ mới thêm trước đó
            rs = getMaxIdPhieuDV.executeQuery();
            String maphieudichvu = null;
            if (rs.next()) {
                maphieudichvu = rs.getString(1);
            }
            rs.close();

            rs = getMaxIdPhieuSP.executeQuery();
            String maphieusanpham = null;
            if (rs.next()) {
                maphieusanpham = rs.getString(1);
            }
            insertdata.setString(1, newId);
            insertdata.setString(2, bp.getMaPhieuDatPhong());
            insertdata.setString(3, maphieudichvu);
            insertdata.setString(4, maphieusanpham);
            insertdata.setString(5, bp.getNgayLap());
            insertdata.setString(6, bp.getTongTien());
            insertdata.setString(7, bp.getTienCoc());
            insertdata.execute();
            insertdata.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void XoaPhieuDatPhong(String maPhong) throws SQLException {
        conn = null;
        PreparedStatement state = null;
        try {
            java.sql.Connection conn = DriverManager.getConnection(Hotel_Manager.dbURL);
            sql = "DELETE FROM phong WHERE maphong = ?";
            state = conn.prepareStatement(sql);
            state.setString(1, maPhong);
            state.execute();
            state.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void CapNhatPhieuDatPhong(tbl_PhieuDatPhong bp, String mapdp, String maphongcu) {
    conn = null;
        PreparedStatement state = null;
        try {
            java.sql.Connection conn = DriverManager.getConnection(Hotel_Manager.dbURL);
            sql = "UPDATE Phong SET TinhTrang = CASE " +
                                "WHEN MaPhong = ? THEN 0 " +
                                "WHEN MaPhong = ? THEN 1 " +
                                "ELSE TinhTrang END";
            state = conn.prepareStatement(sql);
            state.setString(1, maphongcu);
            state.setString(2, bp.getMaPhong());
            
            state.execute();
            
            sql1="UPDATE PhieuDatPhong SET MaPhong = ?, ThanhTienP=? WHERE MaPhieuDatPhong = ? AND MaPhong = ?";
            state = conn.prepareStatement(sql1);
            state.setString(1, bp.getMaPhong());
            state.setString(2, bp.getThanhTien());
            state.setString(3, mapdp);
            state.setString(4, maphongcu);
            state.execute();
            state.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
    }
    
    public static void CapNhatPhong(tbl_Phong bp, String maphong) {
        conn = null;
        PreparedStatement state = null;
        try {
            java.sql.Connection conn = DriverManager.getConnection(Hotel_Manager.dbURL);
            sql = "UPDATE phong SET MaPhong = ?, LoaiPhong = ?,SoGiuong = ?, SoPhong = ?, GiaPhong = ?, TinhTrang = ?, MoTa = ? WHERE MaPhong = ?";
            state = conn.prepareStatement(sql);
            state.setString(1, bp.getMaPhong());
            state.setString(2, bp.getLoaiPhong());
            state.setString(3, bp.getSoGiuong());
            state.setString(4, bp.getSoPhong());
            state.setString(5, bp.getGiaPhong());
            state.setString(6, bp.getTinhTrang());
            state.setString(7, bp.getMoTa());
            state.setString(8, maphong);
            state.execute();
            state.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
    }
    
}
