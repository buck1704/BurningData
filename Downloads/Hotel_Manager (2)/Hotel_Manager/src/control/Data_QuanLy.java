/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Hotel_Manager;
import model.tbl_ChucVu;
import model.tbl_DichVu;
import model.tbl_KhachHang;
import model.tbl_NhanVien;
import model.tbl_Phong;
import model.tbl_DoiMatKhau;

public class Data_QuanLy {
    private static Connection conn = null;
    private static String sql,sql2;
    
    public static List<tbl_ChucVu> NguonChucVu() throws IOException {
        List<tbl_ChucVu> arrBoPhan = new ArrayList<>();
        Statement state = null;
        try {
            java.sql.Connection conn = DriverManager.getConnection(Hotel_Manager.dbURL);
            // Thực hiện truy vấn và lấy kết quả trả về
            sql = "Select * From ChucVu Order by machucvu";
            state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            // Xử lý kết quả trả về
            while (rs.next()) {
                tbl_ChucVu bp = new tbl_ChucVu();
                bp.setMaChucVu(rs.getString("machucvu"));
                bp.setTenChucVu(rs.getString("tenchucvu"));
                bp.setLuongTheoNgay(rs.getString("LuongTheoNgay"));
                arrBoPhan.add(bp);
            }
            state.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        return arrBoPhan;
    }

    public static void ThemBoPhan(tbl_ChucVu bp) {
        conn = null;
        PreparedStatement state = null;
        try {
            java.sql.Connection conn = DriverManager.getConnection(Hotel_Manager.dbURL);
            sql = "INSERT INTO ChucVu (MaChucVu, TenChucVu, LuongTheoNgay) VALUES (?, ?, ?)";
            state = conn.prepareStatement(sql);
            state.setString(1, bp.getMaChucVu());
            state.setString(2, bp.getTenChucVu());
            state.setString(3, bp.getLuongTheoNgay());
            state.execute();
            state.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
    }

    public static void CapNhapBoPhan(tbl_ChucVu bp, String mabophan) {
        conn = null;
        PreparedStatement state = null;
        try {
            java.sql.Connection conn = DriverManager.getConnection(Hotel_Manager.dbURL);
            sql = "UPDATE ChucVu SET machucvu = ?, tenchucvu = ?, LuongTheoNgay = ? WHERE machucvu = ?";
            state = conn.prepareStatement(sql);
            state.setString(1, bp.getMaChucVu());
            state.setString(2, bp.getTenChucVu());
            state.setString(3, bp.getLuongTheoNgay());
            state.setString(4, mabophan);
            state.execute();
            state.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
    }
    public static void XoaNganh( String mabophan) {
        conn = null;
        PreparedStatement state = null;
        try {
            java.sql.Connection conn = DriverManager.getConnection(Hotel_Manager.dbURL);
            sql = "DELETE FROM ChucVu WHERE machucvu = ?";
            state = conn.prepareStatement(sql);
            state.setString(1, mabophan);
            state.execute();
            state.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
    }
    
    public static List<tbl_Phong> NguonPhong() throws IOException {
        List<tbl_Phong> arrPhong = new ArrayList<>();
        Statement state = null;
        try {
            java.sql.Connection conn = DriverManager.getConnection(Hotel_Manager.dbURL);
            // Thực hiện truy vấn và lấy kết quả trả về
            sql = "Select * From Phong Order by MaPhong";
            state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            // Xử lý kết quả trả về
            while (rs.next()) {
                tbl_Phong bp = new tbl_Phong();
                bp.setMaPhong(rs.getString("MaPhong"));
                bp.setLoaiPhong(rs.getString("LoaiPhong"));
                bp.setSoGiuong(rs.getString("SoGiuong"));
                bp.setSoPhong(rs.getString("SoPhong"));
                bp.setGiaPhong(rs.getString("GiaPhong"));
                bp.setTinhTrang(rs.getString("TinhTrang"));
                if(rs.getString("TinhTrang").equals("0")){
                    bp.setTinhTrang("Trống");
                } else {
                    bp.setTinhTrang("Đầy");
                }
                bp.setMoTa(rs.getString("MoTa"));
                arrPhong.add(bp);
            }
            state.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return arrPhong;
    }
    public static void ThemPhong(tbl_Phong bp) {
        conn = null;
        PreparedStatement state = null;
        try {
            java.sql.Connection conn = DriverManager.getConnection(Hotel_Manager.dbURL);
            sql = "INSERT INTO Phong VALUES(?, ?, ?, ?, ?, ?, ?)";
            state = conn.prepareStatement(sql);
            state.setString(1, bp.getMaPhong());
            state.setString(2, bp.getLoaiPhong());
            state.setString(3, bp.getSoGiuong());
            state.setString(4, bp.getSoPhong());
            state.setString(5, bp.getGiaPhong());
            state.setString(6, bp.getTinhTrang());
            state.setString(7, bp.getMoTa());
            state.execute();
        } catch (SQLException ex) {
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
    public static void XoaPhong( String maphong) {
        conn = null;
        PreparedStatement state = null;
        try {
            java.sql.Connection conn = DriverManager.getConnection(Hotel_Manager.dbURL);
            sql = "DELETE FROM Phong WHERE MaPhong = ?";
            state = conn.prepareStatement(sql);
            state.setString(1, maphong);
            state.execute();
            state.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
    }
    
    public static List<tbl_KhachHang> NguonKhachHang(String sMaKT) throws IOException {
        List<tbl_KhachHang> arrKhachHang = new ArrayList<>();
        Statement state = null;
        try {
            java.sql.Connection conn = DriverManager.getConnection(Hotel_Manager.dbURL);
            // Thực hiện truy vấn và lấy kết quả trả về
            sql = "Select * From KhachHang";
            if(sMaKT != null && !sMaKT.equals("")){
                sql = sql + " Where MaKhachHang ='" + sMaKT + "'";
            }
            sql = sql + " order by MaKhachHang";
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
    
    public static void ThemKhachHang(tbl_KhachHang bp) {
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

    public static void CapNhapKhachHang(tbl_KhachHang bp, String macu) {
        conn = null;
        PreparedStatement state = null;
        try {
            java.sql.Connection conn = DriverManager.getConnection(Hotel_Manager.dbURL);
            sql = "UPDATE KhachHang SET MaKhachHang = ?, TenKhachHang = ?, DiaChi = ?, GioiTinh = ?, CMND = ?, SDT = ? WHERE MaKhachHang = ?";
            state = conn.prepareStatement(sql);
            state.setString(1, bp.getMakh());
            state.setString(2, bp.getTenkh());
            state.setString(3, bp.getDiachi());
            state.setString(4, bp.getGioitinh());
            state.setString(5, bp.getCmnd());
            state.setString(6, bp.getSodt());
            state.setString(7, macu);
            state.execute();
            state.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
    }

    public static void XoaKhachHang(String makh) {
        conn = null;
        PreparedStatement state = null;
        try {
            java.sql.Connection conn = DriverManager.getConnection(Hotel_Manager.dbURL);
            sql = "DELETE FROM KhachHang WHERE MaKhachHang = ?";
            state = conn.prepareStatement(sql);
            state.setString(1, makh);
            state.execute();
            state.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
    }
    
    public static  List<tbl_NhanVien> LoadDataToArrayNhanVien(String kt){
        List<tbl_NhanVien> arrnv = new ArrayList<>();
        try{
            conn=DriverManager.getConnection(Hotel_Manager.dbURL);
            Statement st=conn.createStatement();
            String sql="select *from nhanvien,taikhoan where nhanvien.MaNhanVien=taikhoan.MaNhanVien";
           if (kt != null && !kt.equals("")) {
                sql = sql + " and NhanVien.MaNhanVien like N'%" + kt + "%'";
               
            }
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                String manv=rs.getString("MaNhanVien");
                String tennv=rs.getString("TenNhanVien");
                String macv=rs.getString("MaChucVu");
                String gioitinh=rs.getString("Gioitinh");
                String ngaysinh=rs.getString("NgaySinh");
                String sdt=rs.getString("SDT");
                String diachi=rs.getString("DiaChi");
                String tendn=rs.getString("TaiKhoan");
                String pass=rs.getString("MatKhau");
                
                tbl_NhanVien nv= new tbl_NhanVien(manv,tennv,macv,gioitinh,ngaysinh,sdt,diachi,tendn,pass);
                arrnv.add(nv);
            }
            conn.close();
            st.close();
        }
        catch(Exception ex){
            System.out.println(ex);
        }     
        return arrnv;
    }
    
    public static void ThemNV(tbl_NhanVien nv){
        conn = null;
        PreparedStatement pst = null;
        try {
            java.sql.Connection conn = DriverManager.getConnection(Hotel_Manager.dbURL);
            sql = "insert into  nhanvien (MaNhanVien,TenNhanVien,MaChuCVu,GioiTinh,NgaySinh,SDT,DiaChi) values (?,?,?,?,?,?,?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1, nv.getManv());
            pst.setString(2, nv.getTennv());
            pst.setString(3,nv.getMacv());
            pst.setString(4, nv.getGioitinh());
            pst.setString(5,nv.getNgaysinh());
            pst.setString(6, nv.getSdt());
            pst.setString(7, nv.getDiachi());
            pst.execute();
            
            sql2="insert into taikhoan (TaiKhoan,MatKhau,MaNhanVien) values(?,?,?)";
            pst = conn.prepareStatement(sql2);
            pst.setString(1, nv.getTendn());
            pst.setString(2, nv.getPasswword());
            pst.setString(3,nv.getManv());
            pst.execute();
            pst.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
    }
    
    
     public static void CapNhapNhanVien(tbl_NhanVien nv, String mabophan) {
        conn = null;
        PreparedStatement pst = null;
        try {
            java.sql.Connection conn = DriverManager.getConnection(Hotel_Manager.dbURL);
            sql = "UPDATE nhanvien SET MaNhanVien = ?, TenNhanVien = ?, MaChucVu = ?,GioiTinh=? ,NgaySinh=? ,SDT=? ,DiaChi=?  WHERE MaNhanVien = ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, nv.getManv());
            pst.setString(2, nv.getTennv());
            pst.setString(3,nv.getMacv());
            pst.setString(4, nv.getGioitinh());
            pst.setString(5, nv.getNgaysinh());
            pst.setString(6, nv.getSdt());
            pst.setString(7, nv.getDiachi());
            pst.setString(8, mabophan);
            pst.execute();
            
            sql2="Update taikhoan set TaiKhoan=?, MatKhau=? ,MaNhanVien=?  WHERE MaNhanVien = ? ";
            pst = conn.prepareStatement(sql2);
            pst.setString(1, nv.getTendn());
            pst.setString(2, nv.getPasswword());
            pst.setString(3,nv.getManv());
             pst.setString(4, mabophan);
            pst.execute();
            pst.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
    }
     public static void XoaNhanVien( String manv) {
         conn = null;
        PreparedStatement state = null;
        try {
            java.sql.Connection conn = DriverManager.getConnection(Hotel_Manager.dbURL);
             sql2 = "DELETE FROM taikhoan WHERE MaNhanVien = ?";
           
            state = conn.prepareStatement(sql2);
            state.setString(1, manv);
            state.execute();
       
            sql = "DELETE FROM nhanvien WHERE MaNhanVien = ?";
            state = conn.prepareStatement(sql);
            state.setString(1, manv);
            state.execute();
            state.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
    }
    
    public static List<tbl_DichVu> NguonDichVu() throws IOException {
        List<tbl_DichVu> arrDichVu = new ArrayList<>();
        Statement state = null;
        try {
            java.sql.Connection conn = DriverManager.getConnection(Hotel_Manager.dbURL);
            // Thực hiện truy vấn và lấy kết quả trả về
            sql = "Select * From DichVu Order by MaDichVu";
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
    
    public static void ThemDichVu(tbl_DichVu bp) {
        conn = null;
        PreparedStatement state = null;
        try {
            java.sql.Connection conn = DriverManager.getConnection(Hotel_Manager.dbURL);
            sql = "INSERT INTO DichVu (MaDichVu, TenDichVu, Gia) VALUES(?, ?, ?)";
            state = conn.prepareStatement(sql);
            state.setString(1, bp.getMadichvu());
            state.setString(2, bp.getTendichvu());
            state.setString(3, bp.getGiadichvu());
            state.execute();
            state.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public static void CapNhapDichVu(tbl_DichVu bp, String macu) {
        conn = null;
        PreparedStatement state = null;
        try {
            java.sql.Connection conn = DriverManager.getConnection(Hotel_Manager.dbURL);
            sql = "UPDATE DichVu SET MaDichVu = ?, TenDichVu = ?, Gia = ? WHERE MaDichVu = ?";
            state = conn.prepareStatement(sql);
            state.setString(1, bp.getMadichvu());
            state.setString(2, bp.getTendichvu());
            state.setString(3, bp.getGiadichvu());
            state.setString(4, macu);
            state.execute();
            state.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public static void XoaDichVu( String macu) {
        conn = null;
        PreparedStatement state = null;
        try {
            java.sql.Connection conn = DriverManager.getConnection(Hotel_Manager.dbURL);
            sql = "DELETE FROM DichVu WHERE MaDichVu = ?";
            state = conn.prepareStatement(sql);
            state.setString(1, macu);
            state.execute();
            state.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
