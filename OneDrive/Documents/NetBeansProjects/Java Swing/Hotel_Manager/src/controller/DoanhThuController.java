package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.TongDoanhThuModel;
import model.Hotel_Manager;
import model.tbl_DichVu;
import model.tbl_HangHoa;
import model.tbl_Phong;

public class DoanhThuController {
    private static Connection conn = null;
    private static String sql;
    
    public static ArrayList<TongDoanhThuModel> TongDoanhThuTheoThang() throws IOException {
        ArrayList<TongDoanhThuModel> arrDoanhThuTheoThang = new ArrayList<>();
        Statement state = null;
        try {
            conn = DriverManager.getConnection(Hotel_Manager.dbURL);
            // Thực hiện truy vấn và lấy kết quả trả về
            sql = """
                  SELECT 
                  MONTH(hd.NgayLap) AS Thang,
                  SUM(CASE WHEN hd.MaPhieuDichVu IS NOT NULL THEN pd.TongTien ELSE 0 END) AS DoanhThuDichVu,
                  SUM(CASE WHEN hd.MaPhieuSanPham IS NOT NULL THEN sp.TongTien ELSE 0 END) AS DoanhThuSanPham,
                  SUM(CASE WHEN hd.MaPhieuDatPhong IS NOT NULL THEN pdp.ThanhTienP ELSE 0 END) AS DoanhThuPhong,
                  COUNT(ctpd.MaCTDV) AS LuongDichVu,
                  SUM(ctsp.SoLuong) AS LuongSanPham,
                  COUNT(DISTINCT pdp.MaPhong) AS SoLuongPhongDat,
                  SUM(CASE WHEN nh.MaHang IS NOT NULL THEN nh.SoLuong * nh.GiaNhap ELSE 0 END) AS TongGiaNhap,
                  SUM(hd.TongTien - (CASE WHEN nh.MaHang IS NOT NULL THEN nh.SoLuong * nh.GiaNhap ELSE 0 END)) AS TongDoanhThu
                  FROM hoadon hd
                  LEFT JOIN phieudichvu pd ON hd.MaPhieuDichVu = pd.MaPhieuDichVu
                  LEFT JOIN phieusanpham sp ON hd.MaPhieuSanPham = sp.MaPhieuSanPham
                  LEFT JOIN phieudatphong pdp ON hd.MaPhieuDatPhong = pdp.MaPhieuDatPhong
                  LEFT JOIN chitietphieudichvu ctpd ON pd.MaPhieuDichVu = ctpd.MaPhieuDichVu
                  LEFT JOIN chitietphieusanpham ctsp ON sp.MaPhieuSanPham = ctsp.MaPhieuSanPham
                  LEFT JOIN mathang mh ON ctsp.MaHang = mh.MaHang
                  LEFT JOIN nhaphang nh ON MONTH(nh.NgayNhap) = MONTH(hd.NgayLap)
                  GROUP BY MONTH(hd.NgayLap)
                  ORDER BY MONTH(hd.NgayLap)""";
            state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                TongDoanhThuModel bp = new TongDoanhThuModel();
                bp.setThang(rs.getString("Thang"));
                bp.setDoanhthudichvu(rs.getString("DoanhThuDichVu"));
                bp.setDoanhthusanpham(rs.getString("DoanhThuSanPham"));
                bp.setDoanhthuphong(rs.getString("DoanhThuPhong"));
                bp.setSoluongdichvu(rs.getString("LuongDichVu"));
                bp.setSoluongsanpham(rs.getString("LuongSanPham"));
                bp.setSoluongphong(rs.getString("SoLuongPhongDat"));
                bp.setTonggianhap(rs.getString("TongGiaNhap"));
                bp.setTongdoanhthu(rs.getString("TongDoanhThu"));
                arrDoanhThuTheoThang.add(bp);
            }
            state.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return arrDoanhThuTheoThang;
    }
    
    public static ArrayList<tbl_Phong> DoanhThuPhongTheoThang(String phanloaiThang, String kieuSX) throws IOException {
        ArrayList<tbl_Phong> arrDoanhThuPhongTheoThang = new ArrayList<>();
        Statement state = null;
        try {
            conn = DriverManager.getConnection(Hotel_Manager.dbURL);
            sql = """
                  SELECT
                  p.MaPhong,
                  p.LoaiPhong,
                  p.GiaPhong,
                  COUNT(pd.MaPhieuDatPhong) AS SoLuongPhongDat,
                  ISNULL(SUM(DATEDIFF(DAY, pd.NgayDen, pd.NgayDi) * p.GiaPhong), 0) AS TongDoanhThu
                  FROM phong p
                  LEFT JOIN phieudatphong pd ON p.MaPhong = pd.MaPhong
                  AND YEAR(pd.NgayDen) = 2023
                  AND MONTH(pd.NgayDen) = """ + phanloaiThang +"\n" +
                "GROUP BY p.MaPhong, p.LoaiPhong, p.GiaPhong, DATEDIFF(DAY, pd.NgayDen, pd.NgayDi)\n" +
                "ORDER BY TongDoanhThu " + kieuSX + "";
            state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                tbl_Phong model = new tbl_Phong();
                model.setMaPhong(rs.getString("MaPhong"));
                model.setLoaiPhong(rs.getString("LoaiPhong"));
                model.setGiaPhong(rs.getString("GiaPhong"));
                model.setLuotDat(rs.getString("SoLuongPhongDat"));
                model.setTongDoanhThuPhong(rs.getString("TongDoanhThu"));
                arrDoanhThuPhongTheoThang.add(model);
            }
            state.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return arrDoanhThuPhongTheoThang;
    }
    
    public static ArrayList<tbl_HangHoa> DoanhThuSanPhamTheoThang(String phanloaiThang, String kieuSX) throws IOException {
        ArrayList<tbl_HangHoa> arrDoanhThuSanPhamTheoThang = new ArrayList<>();
        Statement state = null;
        try {
            conn = DriverManager.getConnection(Hotel_Manager.dbURL);
            sql = """
                  SELECT mh.MaHang, mh.TenHang, mh.LoaiHang, SUM(ct.SoLuong) AS TongSoLuong, SUM(ct.ThanhTien) AS ThanhTien, 
                  SUM(ct.ThanhTien) - (SUM(ct.SoLuong) * mh.GiaNhap) AS LoiNhuan
                  FROM hoadon hd 
                  INNER JOIN phieusanpham psp ON hd.MaPhieuSanPham = psp.MaPhieuSanPham
                  INNER JOIN chitietphieusanpham ct ON psp.MaPhieuSanPham = ct.MaPhieuSanPham
                  INNER JOIN mathang mh ON ct.MaHang = mh.MaHang
                  WHERE MONTH(hd.NgayLap) = """+ phanloaiThang +" AND YEAR(hd.NgayLap) = 2023\n" +
                    "GROUP BY mh.MaHang, mh.TenHang, mh.LoaiHang, mh.GiaNhap,mh.GiaBan\n" +
                    "ORDER BY LoiNhuan " + kieuSX;
            state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                tbl_HangHoa model = new tbl_HangHoa();
                model.setMahang(rs.getString("MaHang"));
                model.setTenhang(rs.getString("TenHang"));
                model.setLoaihang(rs.getString("LoaiHang"));
                model.setLuongtieuthu(rs.getString("TongSoLuong"));
                model.setTongdoanhthu(rs.getString("ThanhTien"));
                model.setLoinhuan(rs.getString("LoiNhuan"));
                arrDoanhThuSanPhamTheoThang.add(model);
            }
            state.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return arrDoanhThuSanPhamTheoThang;
    }
    
    public static ArrayList<tbl_DichVu> DoanhThuDichVuTheoThang(String phanloaiThang, String kieuSX) throws IOException {
        ArrayList<tbl_DichVu> arrDoanhThuDichVuTheoThang = new ArrayList<>();
        Statement state = null;
        try {
            conn = DriverManager.getConnection(Hotel_Manager.dbURL);
            sql = """
                  SELECT dv.MaDichVu, dv.TenDichVu, COUNT(DISTINCT pdv.MaPhieuDichVu) AS SoLanSuDung, SUM(ct.ThanhTien) AS DoanhThu
                  FROM phieudichvu pdv
                  INNER JOIN chitietphieudichvu ct ON pdv.MaPhieuDichVu = ct.MaPhieuDichVu
                  INNER JOIN dichvu dv ON ct.MaDichVu = dv.MaDichVu
                  INNER JOIN hoadon hd ON pdv.MaPhieuDatPhong = hd.MaPhieuDatPhong
                  WHERE MONTH(hd.NgayLap) = """ + phanloaiThang + " AND YEAR(hd.NgayLap) = 2023\n" +
                    "GROUP BY dv.MaDichVu, dv.TenDichVu\n" +
                    "ORDER BY DoanhThu " + kieuSX;
            state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                tbl_DichVu model = new tbl_DichVu();
                model.setMadichvu(rs.getString("MaDichVu"));
                model.setTendichvu(rs.getString("TenDichVu"));
                model.setSoLanSuDung(rs.getString("SoLanSuDung"));
                model.setDoanhThu(rs.getString("DoanhThu"));
                arrDoanhThuDichVuTheoThang.add(model);
            }
            state.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return arrDoanhThuDichVuTheoThang;
    }
    
}
