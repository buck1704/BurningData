
package view;

import control.Data_PhieuDangKy;
import control.Data_QuanLy;
import control.Data_QuanLyKhachSan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import model.tbl_KhachHang;
import model.tbl_PhieuDangKy;
import model.tbl_Phong;

public class JP_PhieuDangKy extends javax.swing.JPanel {
    DefaultTableModel tbl_KhachHang, tbl_Phong, tbl_PhieuDangKy;
    List<tbl_PhieuDangKy> arrPhieuDangKy = new ArrayList<>();
    List<tbl_KhachHang> arrKhachHang = new ArrayList<>();
    List<tbl_Phong> arrPhong = new ArrayList<>();

    private static boolean ktThem;
    private static String macu, sTimMaPhieu, sPhanLoaiTimKiem, sTimKhachHang;
    private static String makh, tenkh, diachi, gioitinh, cmnd, sodt;
    private static String maPhong, loaiPhong, giaPhong, ngayDen, ngayDi, tinhTrang, moTa;
    private static String maNhanVien, maPhieuDk, tinhTien;
    public static String laymanhanvien;
    
    public JP_PhieuDangKy() throws IOException {
        initComponents();
        LayNguonKH();
        LayNguonPhong();
        LayNguonInfo();
        LayNguon_Info_CBOPhong();
        LayNguon_Info_CBOKhachHang();
        sTimMaPhieu="";
        txt_ticket_manhanvien.setText(JP_PhieuDangKy.laymanhanvien);
    }
    
    public void LayNguonInfo() throws IOException {
        // Thiết lập độ rộng của cột
        tbl_PhieuDangKy = (DefaultTableModel) tb_phieudangky.getModel();
        tb_phieudangky.getColumnModel().getColumn(0).setPreferredWidth(50);           
        tb_phieudangky.getColumnModel().getColumn(1).setPreferredWidth(50);
        tb_phieudangky.getColumnModel().getColumn(2).setPreferredWidth(90);
        tb_phieudangky.getColumnModel().getColumn(3).setPreferredWidth(60);
        tb_phieudangky.getColumnModel().getColumn(4).setPreferredWidth(60);
        tb_phieudangky.getColumnModel().getColumn(5).setPreferredWidth(40);
        tb_phieudangky.getColumnModel().getColumn(6).setPreferredWidth(60);
        tb_phieudangky.getColumnModel().getColumn(7).setPreferredWidth(50);
        // Căn giữa cột
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        TableColumnModel columnModel = tb_phieudangky.getColumnModel();
        columnModel.getColumn(0).setCellRenderer(centerRenderer);
        columnModel.getColumn(1).setCellRenderer(centerRenderer);
        columnModel.getColumn(5).setCellRenderer(centerRenderer);
        columnModel.getColumn(6).setCellRenderer(centerRenderer);
        columnModel.getColumn(7).setCellRenderer(centerRenderer);
        arrPhieuDangKy = Data_PhieuDangKy.NguonPhieuDK(sTimMaPhieu);
        tbl_PhieuDangKy.setRowCount(0);
        arrPhieuDangKy.forEach((KQ) -> {
        tbl_PhieuDangKy.addRow(new Object[]{KQ.getMaPhieuDK(), KQ.getMaKhachHang(), KQ.getTenKhachHang(), KQ.getNgayDen(), KQ.getNgayDi(), KQ.getMaPhong(), KQ.getThanhTien(), KQ.getMaNhanVien()});
        });
    }
    
    public void LayNguonKH() throws IOException {
        // Thiết lập độ rộng của cột
        tbl_KhachHang = (DefaultTableModel) tb_info_khachhang.getModel();
        tb_info_khachhang.getColumnModel().getColumn(0).setPreferredWidth(50);           
        tb_info_khachhang.getColumnModel().getColumn(1).setPreferredWidth(90);
        tb_info_khachhang.getColumnModel().getColumn(2).setPreferredWidth(80);
        // Căn giữa cột
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        TableColumnModel columnModel = tb_info_khachhang.getColumnModel();
        columnModel.getColumn(0).setCellRenderer(centerRenderer);
        columnModel.getColumn(1).setCellRenderer(centerRenderer);
        columnModel.getColumn(2).setCellRenderer(centerRenderer);

        arrKhachHang = Data_PhieuDangKy.NguonKhachHang(sPhanLoaiTimKiem, sTimKhachHang);
        tbl_KhachHang.setRowCount(0);
        arrKhachHang.forEach((KQ) -> {
            tbl_KhachHang.addRow(new Object[]{KQ.getMakh(), KQ.getTenkh(), KQ.getSodt()});
        });
    }

    public void LayNguonPhong() throws IOException {
        tbl_Phong = (DefaultTableModel) tb_find_phong.getModel();
        tb_find_phong.getColumnModel().getColumn(0).setPreferredWidth(60);           // Thiết lập độ rộng của cột 1 ưu tiên là 60 pixel
        tb_find_phong.getColumnModel().getColumn(1).setPreferredWidth(130);
        tb_find_phong.getColumnModel().getColumn(2).setPreferredWidth(50);
        tb_find_phong.getColumnModel().getColumn(3).setPreferredWidth(90);
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        TableColumnModel columnModel = tb_find_phong.getColumnModel();
        columnModel.getColumn(0).setCellRenderer(centerRenderer);
        columnModel.getColumn(1).setCellRenderer(centerRenderer);
        columnModel.getColumn(2).setCellRenderer(centerRenderer);
        columnModel.getColumn(3).setCellRenderer(centerRenderer);
        arrPhong = Data_PhieuDangKy.NguonPhong(sPhanLoaiTimKiem, sTimKhachHang);
        tbl_Phong.setRowCount(0);
        arrPhong.forEach((KQ) -> {
            tbl_Phong.addRow(new Object[]{KQ.getMaPhong(), KQ.getLoaiPhong(), KQ.getTang(), KQ.getTinhTrang()});
        });
    }
    
    
    public void LayNguon_Info_CBOPhong() throws IOException {
        arrPhong = Data_PhieuDangKy.NguonCBOPhieuDK_Phong();
        for (int i = 0; i < arrPhong.size(); i++) {
            cbb_maphong.addItem(arrPhong.get(i).getMaPhong());
        }
    }
    public void LayNguon_Info_CBOKhachHang() throws IOException {
        arrKhachHang = Data_PhieuDangKy.NguonCBOPhieuDK_KhachHang();
        for (int i = 0; i < arrKhachHang.size(); i++) {
            cbb_makhachhang.addItem(arrKhachHang.get(i).getMakh());
        }
    }
    public void KhoaMo(boolean b) {
        txt_maphieudangky.setEditable(b);
        cbb_makhachhang.setEditable(b);
        txt_ngayden.setEnabled(b);
        txt_ngaydi.setEnabled(b);
        cbb_maphong.setEditable(b);
        
        txt_timkiem.setEnabled(!b);
        bt_them.setEnabled(!b);
        bt_sua.setEnabled(!b);
        bt_xoa.setEnabled(!b);
        bt_ghi.setEnabled(b);
        bt_khong.setEnabled(b);
        tb_phieudangky.setEnabled(!b);
    }
    public void refresh(boolean b) {
        txt_maphieudangky.setEditable(b);
        cbb_makhachhang.setEditable(b);
        txt_ngayden.setEnabled(b);
        txt_ngaydi.setEnabled(b);
        cbb_maphong.setEditable(b);
        txt_timkiem.setEnabled(b);
        bt_them.setEnabled(b);
        bt_sua.setEnabled(b);
        bt_xoa.setEnabled(b);
        bt_ghi.setEnabled(b);
        bt_khong.setEnabled(b);
        tb_phieudangky.setEnabled(b);
    }
    
    public void XoaTrang() {
        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();

        // Set ngày cho dateChooser
        txt_maphieudangky.setText("");
        txt_TenKH.setText("");
        cbb_makhachhang.setSelectedIndex(0);
        txt_ngayden.setDate(currentDate);
        txt_ngaydi.setDate(currentDate);
        cbb_maphong.setSelectedIndex(0);
        txt_thanhtienp.setText("");
        txt_manhanvien.setText("");
        txt_timkiem.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel9 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txt_timkiem = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txt_maphieudangky = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        cbb_makhachhang = new javax.swing.JComboBox<>();
        txt_TenKH = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txt_thanhtienp = new javax.swing.JLabel();
        txt_manhanvien = new javax.swing.JLabel();
        cbb_maphong = new javax.swing.JComboBox<>();
        txt_ngayden = new com.toedter.calendar.JDateChooser();
        txt_ngaydi = new com.toedter.calendar.JDateChooser();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_phieudangky = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        bt_them = new javax.swing.JButton();
        bt_sua = new javax.swing.JButton();
        bt_xoa = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        bt_ghi = new javax.swing.JButton();
        bt_khong = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_info_makh = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_info_tenkh = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_info_diachi = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_info_cmnd = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_info_sdt = new javax.swing.JTextField();
        rdb_info_Nam = new javax.swing.JRadioButton();
        rdb_info_Nu = new javax.swing.JRadioButton();
        rdb_Khac = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        btn_timtheomakhachhang = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_info_khachhang = new javax.swing.JTable();
        btn_timtheotenkhachhang = new javax.swing.JLabel();
        txt_timtheoSDT = new javax.swing.JLabel();
        btn_refresh_KH = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_find_phong = new javax.swing.JTable();
        txt_timkiemphong = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        cbb_phanloaitimkiem = new javax.swing.JComboBox<>();
        btn_timkiemduatrenphanloai = new javax.swing.JButton();
        btn_refresh_phong = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        lb_ticket_tenkhachhang = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txt_ticket_maphieu = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txt_ticket_checkin = new com.toedter.calendar.JDateChooser();
        jLabel20 = new javax.swing.JLabel();
        txt_ticket_checkout = new com.toedter.calendar.JDateChooser();
        jLabel21 = new javax.swing.JLabel();
        txt_ticket_manhanvien = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        btn_timkiemduatrenphanloai1 = new javax.swing.JButton();
        lb_ticket_makhachhang = new javax.swing.JLabel();
        txt_ticket_maphong = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        lb_conclude_MaPhong = new javax.swing.JLabel();
        lb_conclude_NguoiThue = new javax.swing.JLabel();
        lb_conclude_loaiphong = new javax.swing.JLabel();
        lb_conclude_songay = new javax.swing.JLabel();
        lb_conclude_tongtien = new javax.swing.JLabel();
        btn_themdulieu = new javax.swing.JButton();
        btn_timkiemduatrenphanloai3 = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(1140, 780));
        setPreferredSize(new java.awt.Dimension(1140, 780));

        jPanel9.setBackground(new java.awt.Color(76, 41, 211));
        jPanel9.setMinimumSize(new java.awt.Dimension(1140, 70));

        jLabel8.setFont(new java.awt.Font("Century Schoolbook", 1, 30)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Room manager");

        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search_25px.png"))); // NOI18N
        jLabel30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel30MouseClicked(evt);
            }
        });

        txt_timkiem.setBackground(new java.awt.Color(123, 156, 225));
        txt_timkiem.setBorder(null);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(376, 376, 376)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(193, 193, 193)
                .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel30)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(21, 21, 21))
        );

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Century", 2, 14)); // NOI18N
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(1140, 710));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1140, 710));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Montserrat", 0, 11))); // NOI18N
        jPanel7.setRequestFocusEnabled(false);

        jLabel13.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel13.setText("Mã Phiếu:");

        txt_maphieudangky.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel14.setText("Mã Khách Hàng:");

        cbb_makhachhang.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        cbb_makhachhang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbb_makhachhangItemStateChanged(evt);
            }
        });

        txt_TenKH.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        txt_TenKH.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txt_TenKH.setText("tenkhachhang");

        jLabel16.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel16.setText("Ngày Đến:");

        jLabel17.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel17.setText("Người thực hiện:");

        jLabel28.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel28.setText("Ngày Đi:");

        jLabel29.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel29.setText("Mã Phòng:");

        txt_thanhtienp.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        txt_thanhtienp.setForeground(new java.awt.Color(255, 0, 0));
        txt_thanhtienp.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txt_thanhtienp.setText("10 tr");

        txt_manhanvien.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        txt_manhanvien.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txt_manhanvien.setText("Hiển mã nhân viên");

        cbb_maphong.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        cbb_maphong.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbb_maphongItemStateChanged(evt);
            }
        });

        txt_ngayden.setDateFormatString("yyyy, MM, dd");

        txt_ngaydi.setDateFormatString("yyyy, MM, dd");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(284, 284, 284))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(283, 283, 283))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_manhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(284, 284, 284))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(284, 284, 284))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addComponent(cbb_maphong, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(52, 52, 52)
                            .addComponent(txt_thanhtienp, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txt_ngayden, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_ngaydi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txt_maphieudangky, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(cbb_makhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_TenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel13)
                .addGap(2, 2, 2)
                .addComponent(txt_maphieudangky, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addGap(0, 0, 0)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbb_makhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_TenKH))
                .addGap(5, 5, 5)
                .addComponent(jLabel16)
                .addGap(0, 0, 0)
                .addComponent(txt_ngayden, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel28)
                .addGap(0, 0, 0)
                .addComponent(txt_ngaydi, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29)
                .addGap(0, 0, 0)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbb_maphong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_thanhtienp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txt_manhanvien))
                .addGap(20, 20, 20))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        tb_phieudangky.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        tb_phieudangky.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Phiếu", "Mã Khách Hàng", "Tên Khách Hàng", "Ngày Đến", "Ngày Đi", "Mã Phòng", "Thành Tiền", "Mã Nhân Viên"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_phieudangky.setRowHeight(25);
        tb_phieudangky.setRowMargin(5);
        tb_phieudangky.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_phieudangkyMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tb_phieudangky);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Cập Nhật"), "Cập Nhật", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Montserrat", 0, 11))); // NOI18N

        bt_them.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        bt_them.setText("Thêm");
        bt_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_themActionPerformed(evt);
            }
        });

        bt_sua.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        bt_sua.setText("Sửa");
        bt_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_suaActionPerformed(evt);
            }
        });

        bt_xoa.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        bt_xoa.setText("Xoá");
        bt_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_xoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(bt_them, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bt_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bt_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_xoa)
                    .addComponent(bt_sua)
                    .addComponent(bt_them))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Cập Nhật"), "Điều Khiển", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Montserrat", 0, 11))); // NOI18N

        bt_ghi.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        bt_ghi.setText("Ghi");
        bt_ghi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ghiActionPerformed(evt);
            }
        });

        bt_khong.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        bt_khong.setText("Refresh");
        bt_khong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_khongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(bt_ghi, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(bt_khong, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_khong)
                    .addComponent(bt_ghi))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Info", jPanel1);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel2.setText("Mã Khách Hàng:");

        txt_info_makh.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        txt_info_makh.setMargin(new java.awt.Insets(0, 2, 0, 0));

        jLabel3.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel3.setText("Tên Khách Hàng: ");

        txt_info_tenkh.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        txt_info_tenkh.setMargin(new java.awt.Insets(0, 2, 0, 0));
        txt_info_tenkh.setMinimumSize(new java.awt.Dimension(7, 25));
        txt_info_tenkh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_info_tenkhActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel4.setText("Địa Chỉ:");

        txt_info_diachi.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        txt_info_diachi.setMargin(new java.awt.Insets(0, 2, 0, 0));

        jLabel5.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel5.setText("Giới Tính:");

        jLabel6.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel6.setText("CMND/CCCD:");

        txt_info_cmnd.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        txt_info_cmnd.setMargin(new java.awt.Insets(0, 2, 0, 0));

        jLabel7.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel7.setText("SĐT:");

        txt_info_sdt.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        txt_info_sdt.setMargin(new java.awt.Insets(0, 2, 0, 0));

        rdb_info_Nam.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdb_info_Nam);
        rdb_info_Nam.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        rdb_info_Nam.setLabel("Nam");

        rdb_info_Nu.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdb_info_Nu);
        rdb_info_Nu.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        rdb_info_Nu.setLabel("Nữ");

        rdb_Khac.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdb_Khac);
        rdb_Khac.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        rdb_Khac.setText("Khác");
        rdb_Khac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_KhacActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Century Gothic", 2, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Customer Information");

        btn_timtheomakhachhang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_timtheomakhachhang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search_dark_26px.png"))); // NOI18N
        btn_timtheomakhachhang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_timtheomakhachhangMouseClicked(evt);
            }
        });

        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tb_info_khachhang.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        tb_info_khachhang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã Khách Hàng", "Tên Khách Hàng", "Số Điện Thoại"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_info_khachhang.setGridColor(new java.awt.Color(0, 0, 0));
        tb_info_khachhang.setRowMargin(5);
        tb_info_khachhang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_info_khachhangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_info_khachhang);

        btn_timtheotenkhachhang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_timtheotenkhachhang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search_dark_26px.png"))); // NOI18N
        btn_timtheotenkhachhang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_timtheotenkhachhangMouseClicked(evt);
            }
        });

        txt_timtheoSDT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search_dark_26px.png"))); // NOI18N
        txt_timtheoSDT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_timtheoSDTMouseClicked(evt);
            }
        });

        btn_refresh_KH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/refresh_25px.png"))); // NOI18N
        btn_refresh_KH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_refresh_KHMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txt_info_diachi)
                        .addGap(21, 21, 21))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addGap(204, 204, 204)
                                        .addComponent(rdb_Khac))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(rdb_info_Nam)
                                        .addGap(50, 50, 50)
                                        .addComponent(rdb_info_Nu))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(6, 6, 6))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(txt_info_makh, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                                                .addComponent(txt_info_tenkh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGap(4, 4, 4)))
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                            .addComponent(btn_timtheotenkhachhang, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                                            .addGap(1, 1, 1))
                                        .addComponent(btn_timtheomakhachhang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addGap(1, 1, 1)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(txt_info_sdt))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txt_timtheoSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btn_refresh_KH, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_info_cmnd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel2)
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_info_makh, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_timtheomakhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_timtheotenkhachhang)
                    .addComponent(txt_info_tenkh, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(0, 0, 0)
                .addComponent(txt_info_diachi, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdb_info_Nam)
                        .addComponent(rdb_info_Nu)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(rdb_Khac, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txt_info_cmnd, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addGap(0, 0, 0)
                        .addComponent(txt_info_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_refresh_KH, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_timtheoSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel9.setFont(new java.awt.Font("Century Gothic", 2, 24)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Find Room");

        tb_find_phong.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        tb_find_phong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã Phòng", "Loại Phòng", "Tầng", "Tình Trạng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_find_phong.setRowHeight(25);
        tb_find_phong.setRowMargin(5);
        tb_find_phong.setSelectionBackground(new java.awt.Color(0, 0, 0));
        tb_find_phong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_find_phongMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb_find_phong);

        txt_timkiemphong.setMinimumSize(new java.awt.Dimension(5, 25));
        txt_timkiemphong.setPreferredSize(new java.awt.Dimension(56, 25));

        jLabel15.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel15.setText("Tìm Kiếm:");

        cbb_phanloaitimkiem.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        cbb_phanloaitimkiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã Phòng", "Loại Phòng", "Tầng" }));

        btn_timkiemduatrenphanloai.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        btn_timkiemduatrenphanloai.setText("Find");
        btn_timkiemduatrenphanloai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_timkiemduatrenphanloaiMouseClicked(evt);
            }
        });
        btn_timkiemduatrenphanloai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timkiemduatrenphanloaiActionPerformed(evt);
            }
        });

        btn_refresh_phong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/refresh_25px.png"))); // NOI18N
        btn_refresh_phong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_refresh_phongMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane2)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(cbb_phanloaitimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_timkiemphong, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btn_timkiemduatrenphanloai, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(4, 4, 4)
                            .addComponent(btn_refresh_phong, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabel15)
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_refresh_phong, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_timkiemphong, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbb_phanloaitimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_timkiemduatrenphanloai)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setMaximumSize(new java.awt.Dimension(1000, 1000));
        jPanel5.setMinimumSize(new java.awt.Dimension(272, 425));
        jPanel5.setPreferredSize(new java.awt.Dimension(272, 425));

        jLabel11.setFont(new java.awt.Font("Century Gothic", 2, 24)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Reservation Ticket");

        lb_ticket_tenkhachhang.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lb_ticket_tenkhachhang.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_ticket_tenkhachhang.setText("Tên khách hàng");

        jLabel18.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel18.setText("Mã Phiếu:");

        txt_ticket_maphieu.setMargin(new java.awt.Insets(0, 2, 0, 0));
        txt_ticket_maphieu.setPreferredSize(new java.awt.Dimension(250, 25));

        jLabel19.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel19.setText("Ngày Đến:");

        txt_ticket_checkin.setDateFormatString("yyyy, MM, dd");

        jLabel20.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel20.setText("Ngày Đi:");

        txt_ticket_checkout.setDateFormatString("yyyy, MM, dd");

        jLabel21.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel21.setText("Người thực hiện:");

        txt_ticket_manhanvien.setFont(new java.awt.Font("Montserrat", 3, 12)); // NOI18N
        txt_ticket_manhanvien.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txt_ticket_manhanvien.setText("Hiển mã nhân viên");

        jLabel22.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel22.setText("Mã Phòng:");

        btn_timkiemduatrenphanloai1.setFont(new java.awt.Font("Montserrat Medium", 0, 16)); // NOI18N
        btn_timkiemduatrenphanloai1.setLabel("OK");
        btn_timkiemduatrenphanloai1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_timkiemduatrenphanloai1MouseClicked(evt);
            }
        });
        btn_timkiemduatrenphanloai1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timkiemduatrenphanloai1ActionPerformed(evt);
            }
        });

        lb_ticket_makhachhang.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lb_ticket_makhachhang.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_ticket_makhachhang.setText("Mã Khách Hàng");

        txt_ticket_maphong.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txt_ticket_maphong.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txt_ticket_maphong.setText("Mã Phòng");

        jLabel31.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel31.setText("Tên KH:");

        jLabel32.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel32.setText("Mã KH:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txt_ticket_checkout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txt_ticket_maphieu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txt_ticket_checkin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(54, 54, 54))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lb_ticket_tenkhachhang, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                                    .addComponent(txt_ticket_maphong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lb_ticket_makhachhang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(btn_timkiemduatrenphanloai1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_ticket_manhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_ticket_maphieu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_ticket_makhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_ticket_tenkhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txt_ticket_maphong))
                .addGap(12, 12, 12)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_ticket_checkin, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_ticket_checkout, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txt_ticket_manhanvien))
                .addGap(18, 18, 18)
                .addComponent(btn_timkiemduatrenphanloai1)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel10.setFont(new java.awt.Font("Century Gothic", 2, 24)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Conclude");

        jLabel23.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel23.setText("Mã Phòng:");

        jLabel24.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel24.setText("Số Ngày Thuê:");

        jLabel25.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel25.setText("Loại Phòng:");

        jLabel26.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel26.setText("Người thuê:");

        jLabel27.setFont(new java.awt.Font("Montserrat", 2, 14)); // NOI18N
        jLabel27.setText("Tổng Tiền:");

        lb_conclude_MaPhong.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        lb_conclude_MaPhong.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_conclude_MaPhong.setText("101");

        lb_conclude_NguoiThue.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        lb_conclude_NguoiThue.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_conclude_NguoiThue.setText("Bá Trường");

        lb_conclude_loaiphong.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        lb_conclude_loaiphong.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_conclude_loaiphong.setText("Cao Cấp");

        lb_conclude_songay.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        lb_conclude_songay.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_conclude_songay.setText("2");

        lb_conclude_tongtien.setFont(new java.awt.Font("Montserrat", 3, 18)); // NOI18N
        lb_conclude_tongtien.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_conclude_tongtien.setText("1000000");

        btn_themdulieu.setFont(new java.awt.Font("Montserrat Medium", 0, 16)); // NOI18N
        btn_themdulieu.setLabel("OK");
        btn_themdulieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_themdulieuMouseClicked(evt);
            }
        });
        btn_themdulieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themdulieuActionPerformed(evt);
            }
        });

        btn_timkiemduatrenphanloai3.setFont(new java.awt.Font("Montserrat Medium", 0, 16)); // NOI18N
        btn_timkiemduatrenphanloai3.setText("Làm Mới");
        btn_timkiemduatrenphanloai3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_timkiemduatrenphanloai3MouseClicked(evt);
            }
        });
        btn_timkiemduatrenphanloai3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timkiemduatrenphanloai3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btn_themdulieu, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_timkiemduatrenphanloai3, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lb_conclude_NguoiThue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_conclude_loaiphong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_conclude_songay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_conclude_MaPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_conclude_tongtien, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))))
                .addContainerGap())
            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(lb_conclude_MaPhong))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(lb_conclude_NguoiThue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(lb_conclude_loaiphong))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(lb_conclude_songay))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(lb_conclude_tongtien))
                .addGap(19, 19, 19)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_themdulieu)
                    .addComponent(btn_timkiemduatrenphanloai3))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        jTabbedPane1.addTab("Booking", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_info_tenkhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_info_tenkhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_info_tenkhActionPerformed

    private void btn_timtheomakhachhangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_timtheomakhachhangMouseClicked
        try {
            // TODO add your handling code here:sTimKhachHang = txt_timkiem.getText();
            sPhanLoaiTimKiem = "MaKhachHang";
            sTimKhachHang = txt_info_makh.getText();
            LayNguonKH();
        } catch (IOException ex) {
            Logger.getLogger(JP_PhieuDangKy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_timtheomakhachhangMouseClicked

    private void btn_timtheotenkhachhangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_timtheotenkhachhangMouseClicked
        try {
            // TODO add your handling code here:sTimKhachHang = txt_timkiem.getText();
            sPhanLoaiTimKiem = "TenKhachHang";
            sTimKhachHang = txt_info_tenkh.getText();
            LayNguonKH();
        } catch (IOException ex) {
            Logger.getLogger(JP_PhieuDangKy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_timtheotenkhachhangMouseClicked

    private void txt_timtheoSDTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_timtheoSDTMouseClicked
        try {
            // TODO add your handling code here:sTimKhachHang = txt_timkiem.getText();
            sPhanLoaiTimKiem = "SDT";
            sTimKhachHang = txt_info_sdt.getText();
            LayNguonKH();
        } catch (IOException ex) {
            Logger.getLogger(JP_PhieuDangKy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txt_timtheoSDTMouseClicked

    private void btn_timkiemduatrenphanloaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timkiemduatrenphanloaiActionPerformed
        // Lấy vị trí được chọn trong JComboBox
        int selectedIndex = cbb_phanloaitimkiem.getSelectedIndex();
        // Thiết lập sPhanLoaiTimKiem tương ứng với vị trí được chọn
        switch (selectedIndex) {
            case 0:
                sPhanLoaiTimKiem = "MaPhong";
                break;
            case 1:
                sPhanLoaiTimKiem = "LoaiPhong";
                break;
            case 2:
                sPhanLoaiTimKiem = "LEFT(MaPhong,1)";
                break;
            default:
                break;
        }
        sTimKhachHang = txt_timkiemphong.getText();
       
        try {
            LayNguonPhong();
        } catch (IOException ex) {
            Logger.getLogger(JP_PhieuDangKy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_timkiemduatrenphanloaiActionPerformed

    private void btn_timkiemduatrenphanloaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_timkiemduatrenphanloaiMouseClicked
        
    }//GEN-LAST:event_btn_timkiemduatrenphanloaiMouseClicked

    private void tb_info_khachhangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_info_khachhangMouseClicked
        int index = tb_info_khachhang.getSelectedRow();
        TableModel model = tb_info_khachhang.getModel();
        makh = model.getValueAt(index, 0).toString();
        tenkh = model.getValueAt(index, 1).toString();
        sodt = model.getValueAt(index, 2).toString();
        try {
            diachi      = Data_PhieuDangKy.NguonTruyVanDuLieu("DiaChi", "KhachHang", "MaKhachHang", makh);
            gioitinh    = Data_PhieuDangKy.NguonTruyVanDuLieu("GioiTinh", "KhachHang", "MaKhachHang", makh);
            cmnd        = Data_PhieuDangKy.NguonTruyVanDuLieu("CMND", "KhachHang", "MaKhachHang", makh);
        } catch (IOException ex) {
            Logger.getLogger(JP_PhieuDangKy.class.getName()).log(Level.SEVERE, null, ex);
        }
        txt_info_makh.setText(makh);
        lb_ticket_makhachhang.setText(makh);
        txt_info_tenkh.setText(tenkh);
        lb_ticket_tenkhachhang.setText(tenkh);
        txt_info_diachi.setText(diachi);
        if(gioitinh.equalsIgnoreCase("Nam") ){
            rdb_info_Nam.setSelected(true);
            rdb_info_Nu.setSelected(false);
            rdb_Khac.setSelected(false);
        }else if(gioitinh.equalsIgnoreCase("Nữ")){
            rdb_info_Nam.setSelected(false);
            rdb_info_Nu.setSelected(true);
            rdb_Khac.setSelected(false);
        }else{
            rdb_info_Nam.setSelected(false);
            rdb_info_Nu.setSelected(false);
            rdb_Khac.setSelected(true);
        }
        txt_info_cmnd.setText(cmnd);
        txt_info_sdt.setText(sodt);
        
    }//GEN-LAST:event_tb_info_khachhangMouseClicked

    private void rdb_KhacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_KhacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdb_KhacActionPerformed

    private void tb_find_phongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_find_phongMouseClicked
        int index = tb_find_phong.getSelectedRow();
        TableModel model = tb_find_phong.getModel();
        maPhong = model.getValueAt(index, 0).toString();
        txt_ticket_maphong.setText(maPhong);
    }//GEN-LAST:event_tb_find_phongMouseClicked

    private void btn_timkiemduatrenphanloai1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_timkiemduatrenphanloai1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_timkiemduatrenphanloai1MouseClicked

    private void btn_timkiemduatrenphanloai1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timkiemduatrenphanloai1ActionPerformed
        String tinhngay;
        int indexP = tb_find_phong.getSelectedRow();
        TableModel modelP = tb_find_phong.getModel();
        
        maPhong = modelP.getValueAt(indexP, 0).toString();
        loaiPhong = modelP.getValueAt(indexP, 1).toString();
        makh = txt_info_makh.getText();
        tenkh = txt_info_tenkh.getText();
        Date ngayDen = txt_ticket_checkin.getDate();
        Date ngayDi = txt_ticket_checkout.getDate();
        if (ngayDen == null || ngayDi == null || ngayDen.after(ngayDi)) {
            JOptionPane.showMessageDialog(this, "Ngày đến hoặc ngày đi không hợp lệ", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Kiểm tra ngày đến phải sau ngày hiện tại
        Date ngayHienTai = new Date();
        if (txt_ticket_checkin.getDate().before(ngayHienTai)) {
            JOptionPane.showMessageDialog(this, "Ngày đến phải sau ngày hiện tại.", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
        lb_conclude_MaPhong.setText(maPhong);
        lb_conclude_loaiphong.setText(loaiPhong);
        lb_ticket_makhachhang.setText(makh);
        lb_ticket_tenkhachhang.setText(tenkh);
        lb_conclude_NguoiThue.setText(tenkh);
        if (ngayDen != null && ngayDi != null) {
            try {
                tinhngay = String.valueOf((ngayDi.getTime() - ngayDen.getTime()) / (24 * 60 * 60 * 1000));
                lb_conclude_songay.setText(tinhngay);
                giaPhong = Data_PhieuDangKy.NguonTruyVanDuLieu("GiaPhong", "Phong", "MaPhong", maPhong);
                lb_conclude_tongtien.setText(String.valueOf((Integer.valueOf(giaPhong)) * (Integer.valueOf(tinhngay))));
            } catch (IOException ex) {
                Logger.getLogger(JP_PhieuDangKy.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            // Xử lý giá trị null ở đây
        }
    }//GEN-LAST:event_btn_timkiemduatrenphanloai1ActionPerformed

    private void btn_themdulieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_themdulieuMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_themdulieuMouseClicked


    private void btn_themdulieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themdulieuActionPerformed
        maPhieuDk = txt_ticket_maphieu.getText();
        makh = txt_info_makh.getText();
        tenkh = txt_info_tenkh.getText();
        diachi = txt_info_diachi.getText();
        gioitinh = "";
        if (rdb_info_Nam.isSelected()) {
            gioitinh = "Nam";
        } else if (rdb_info_Nu.isSelected()) {
            gioitinh = "Nữ";
        } else if (rdb_Khac.isSelected()) {
            gioitinh = "Khác";
        }
        cmnd = txt_info_cmnd.getText();
        sodt = txt_info_sdt.getText();
        maPhong = lb_conclude_MaPhong.getText();
        tinhTien = lb_conclude_tongtien.getText();
        maNhanVien = JP_PhieuDangKy.laymanhanvien;
        // Yêu cầu nhập đủ thông tin
    if (maPhieuDk.isEmpty() || makh.isEmpty() || tenkh.isEmpty() || diachi.isEmpty() || gioitinh.isEmpty() || cmnd.isEmpty() || sodt.isEmpty() || maPhong.isEmpty() || tinhTien.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Bạn chưa nhập đầy đủ thông tin.", "Thông Báo", JOptionPane.ERROR_MESSAGE);
        return;
    }

        try {
            if (Data_PhieuDangKy.KiemTra("PhieuDangKy", "MaPhieuDangKy", maPhieuDk)) {
                JOptionPane.showMessageDialog(this, "Mã phiếu đã tồn tại trong cơ sở dữ liệu.", "Thông Báo", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (Data_PhieuDangKy.KiemTra("KhachHang", "MaKhachHang", makh)) {
                tbl_KhachHang cnKH = new tbl_KhachHang(makh, tenkh, diachi, gioitinh, cmnd, sodt);
                Data_QuanLy.CapNhapKhachHang(cnKH, makh);
            } else {
                tbl_KhachHang cnKH = new tbl_KhachHang(makh, tenkh, diachi, gioitinh, cmnd, sodt);
                Data_QuanLy.ThemKhachHang(cnKH);
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            // Kiểm tra ngày đến và ngày đi
            String ngayDen = sdf.format(txt_ticket_checkin.getDate());
            String ngayDi = sdf.format(txt_ticket_checkout.getDate());
            // Đặt Phòng
            tbl_PhieuDangKy cnP = new tbl_PhieuDangKy(maPhieuDk, makh, ngayDen, ngayDi, maPhong, tinhTien, maNhanVien);
            Data_PhieuDangKy.ThemPhieuDk(cnP);
            JOptionPane.showMessageDialog(this, "Đặt phòng thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            // tự động đóng thông báo sau 5 giây
            Timer timer = new Timer(5000, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.getRootFrame().dispose();
                }
            });
            timer.setRepeats(false);
            timer.start();
            LayNguonKH();
            LayNguonPhong();
            LayNguonInfo();
        } catch (SQLException ex) {
            Logger.getLogger(JP_PhieuDangKy.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JP_PhieuDangKy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_themdulieuActionPerformed

    private void btn_timkiemduatrenphanloai3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_timkiemduatrenphanloai3MouseClicked
        txt_info_makh.setText("");
        txt_info_tenkh.setText("");
        txt_info_diachi.setText("");
        txt_info_sdt.setText("");
        txt_info_cmnd.setText("");
        rdb_info_Nam.setSelected(true);
        
        txt_ticket_maphieu.setText("");
        txt_ticket_maphong.setText("");
        lb_ticket_makhachhang.setText("");
        lb_ticket_tenkhachhang.setText("");
        
        lb_conclude_MaPhong.setText("");
        lb_conclude_NguoiThue.setText("");
        lb_conclude_loaiphong.setText("");
        lb_conclude_songay.setText("");
        lb_conclude_tongtien.setText("");
        
        txt_timkiemphong.setText("");
        cbb_phanloaitimkiem.setSelectedItem(0);
        sTimMaPhieu = "";
        try {
            LayNguonPhong();
            LayNguonKH();
        } catch (IOException ex) {
            Logger.getLogger(JP_PhieuDangKy.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }//GEN-LAST:event_btn_timkiemduatrenphanloai3MouseClicked

    private void btn_timkiemduatrenphanloai3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timkiemduatrenphanloai3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_timkiemduatrenphanloai3ActionPerformed

    private void cbb_makhachhangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbb_makhachhangItemStateChanged
        if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
            makh = (String) cbb_makhachhang.getSelectedItem();
            try {
                tenkh = Data_PhieuDangKy.NguonHienThiTenKhachHang(makh);
                txt_TenKH.setText(tenkh);
            } catch (IOException ex) {
                Logger.getLogger(JP_PhieuDangKy.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_cbb_makhachhangItemStateChanged

    private void cbb_maphongItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbb_maphongItemStateChanged
        if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
            String maPhong = (String) cbb_maphong.getSelectedItem();
            long giaPhong = Data_PhieuDangKy.LayMaPhong(maPhong);
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            Date ngayDen = txt_ngayden.getDate();
            Date ngayDi = txt_ngaydi.getDate();
            if (ngayDen != null && ngayDi != null) {
                String ngayDenStr = sdf.format(ngayDen);
                String ngayDiStr = sdf.format(ngayDi);
                tinhTien = String.valueOf(((ngayDi.getTime() - ngayDen.getTime()) / (1000 * 60 * 60 * 24)) * giaPhong);
                txt_thanhtienp.setText(tinhTien);
            } else {
                // Xử lý giá trị null ở đây
            }
        }
    }//GEN-LAST:event_cbb_maphongItemStateChanged

    private void tb_phieudangkyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_phieudangkyMouseClicked
        try {
            int index = tb_phieudangky.getSelectedRow();
            TableModel model = tb_phieudangky.getModel();
            maPhieuDk = model.getValueAt(index, 0).toString();
            makh = model.getValueAt(index, 1).toString();
            tenkh = model.getValueAt(index, 2).toString();
            ngayDen = model.getValueAt(index, 3).toString();
            ngayDi = model.getValueAt(index, 4).toString();
            maPhong = model.getValueAt(index, 5).toString();
            tinhTien = model.getValueAt(index, 6).toString();
            maNhanVien = model.getValueAt(index, 7).toString();
            
            txt_maphieudangky.setText(maPhieuDk);
            cbb_makhachhang.setSelectedItem(makh);
            txt_TenKH.setText(tenkh);
            Date ngayDen = new SimpleDateFormat("yyyy-MM-dd").parse(model.getValueAt(index, 3).toString());
            txt_ngayden.setDate(ngayDen);
            Date ngayDi = new SimpleDateFormat("yyyy-MM-dd").parse(model.getValueAt(index, 4).toString());
            txt_ngaydi.setDate(ngayDi);
            
            cbb_maphong.setSelectedItem(maPhong);
            txt_thanhtienp.setText(tinhTien);
            txt_manhanvien.setText(maNhanVien);
        } catch (ParseException ex) {
            Logger.getLogger(JP_PhieuDangKy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tb_phieudangkyMouseClicked

    private void bt_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_themActionPerformed
        ktThem = true;
        macu = "";
        KhoaMo(true);
        XoaTrang();
        txt_maphieudangky.requestFocus();
        txt_manhanvien.setText(JP_PhieuDangKy.laymanhanvien);
    }//GEN-LAST:event_bt_themActionPerformed

    private void bt_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_suaActionPerformed
        if (txt_maphieudangky.getText().length() <= 0) {
            return;
        }
        macu = txt_maphieudangky.getText();
        ktThem = false;
        KhoaMo(true);
        txt_maphieudangky.requestFocus();
        txt_manhanvien.setText(JP_PhieuDangKy.laymanhanvien);
    }//GEN-LAST:event_bt_suaActionPerformed

    private void bt_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_xoaActionPerformed
        if (txt_maphieudangky.getText().length() <= 0) {
            JOptionPane.showConfirmDialog(this, "Hãy nhập thông tin cần xoá!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        macu = txt_maphieudangky.getText();
        for (int i = 0; i < arrPhieuDangKy.size(); i++) {
            if (arrPhieuDangKy.get(i).getMaPhieuDK().equals(macu)) {
                int kq = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa chuyên ngành này không?", "Thông Báo", JOptionPane.YES_NO_OPTION);
                if (kq == JOptionPane.YES_OPTION) {
                    Data_PhieuDangKy.XoaPhieuDk(macu);
                    XoaTrang();
                    try {
                        LayNguonInfo();
                    } catch (IOException ex) {
                        Logger.getLogger(JP_ChucVu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                return;
            }
        }
    }//GEN-LAST:event_bt_xoaActionPerformed

    private void bt_ghiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ghiActionPerformed
//        if (txt_maphieudangky.getText().length() <= 0) {
//            JOptionPane.showMessageDialog(this, "Bạn chưa nhập đủ thông tin.", "Thông Báo", JOptionPane.ERROR_MESSAGE);
//            txt_maphieudangky.requestFocus();
//            return;
//        }
//        if (Data_QuanLyKhachSan.KiemTraTrungMa("ChucVu", "MaChucVu", txt_maphieudangky.getText(), ktThem, macu) == true) {
//            JOptionPane.showMessageDialog(this, "Mã ngành đã tồn tại trong cơ sở dữ liệu.", "Thông Báo", JOptionPane.ERROR_MESSAGE);
//            txt_maphieudangky.requestFocus();
//            return;
//        }
//        maPhieuDk = txt_maphieudangky.getText();
//        makh = (String) cbb_makhachhang.getSelectedItem();
//        maNhanVien = JP_PhieuDangKy.laymanhanvien;
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//        String ngayDen=sdf.format(txt_ngayden.getDate());
//        String ngayDi=sdf.format(txt_ngaydi.getDate());
//        maPhong = (String) cbb_maphong.getSelectedItem();
//        tinhTien = txt_thanhtienp.getText();
//        tbl_PhieuDangKy cn = new tbl_PhieuDangKy(maPhieuDk, makh, ngayDen, ngayDi, maPhong, tinhTien, maNhanVien);
//        if (ktThem == true) {
//            Data_Phieu.ThemPhieuDk(cn);
//        } else {
//            Data_Phieu.CapNhatPhieuDk(cn, macu);
//        }
//        try {
//            LayNguonInfo();
//        } catch (IOException ex) {
//            Logger.getLogger(JP_ChucVu.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        KhoaMo(false);
    }//GEN-LAST:event_bt_ghiActionPerformed

    private void bt_khongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_khongActionPerformed
        try {
            XoaTrang();
            refresh(true);
            ktThem = true;
            sTimMaPhieu = "";
            LayNguonInfo();
        } catch (IOException ex) {
            Logger.getLogger(JP_PhieuDangKy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bt_khongActionPerformed

    private void jLabel30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseClicked
        sTimMaPhieu = txt_timkiem.getText();
        try {
            LayNguonInfo();
        } catch (IOException ex) {
            Logger.getLogger(JP_PhieuDangKy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel30MouseClicked

    private void btn_refresh_KHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_refresh_KHMouseClicked
        sTimMaPhieu = "";
        try {
            LayNguonKH();
        } catch (IOException ex) {
            Logger.getLogger(JP_PhieuDangKy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_refresh_KHMouseClicked

    private void btn_refresh_phongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_refresh_phongMouseClicked
        txt_timkiemphong.setText("");
        cbb_phanloaitimkiem.setSelectedItem(0);
        sTimMaPhieu = "";
        try {
            LayNguonPhong();
        } catch (IOException ex) {
            Logger.getLogger(JP_PhieuDangKy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_refresh_phongMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_ghi;
    private javax.swing.JButton bt_khong;
    private javax.swing.JButton bt_sua;
    private javax.swing.JButton bt_them;
    private javax.swing.JButton bt_xoa;
    private javax.swing.JLabel btn_refresh_KH;
    private javax.swing.JLabel btn_refresh_phong;
    private javax.swing.JButton btn_themdulieu;
    private javax.swing.JButton btn_timkiemduatrenphanloai;
    private javax.swing.JButton btn_timkiemduatrenphanloai1;
    private javax.swing.JButton btn_timkiemduatrenphanloai3;
    private javax.swing.JLabel btn_timtheomakhachhang;
    private javax.swing.JLabel btn_timtheotenkhachhang;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbb_makhachhang;
    private javax.swing.JComboBox<String> cbb_maphong;
    private javax.swing.JComboBox<String> cbb_phanloaitimkiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lb_conclude_MaPhong;
    private javax.swing.JLabel lb_conclude_NguoiThue;
    private javax.swing.JLabel lb_conclude_loaiphong;
    private javax.swing.JLabel lb_conclude_songay;
    private javax.swing.JLabel lb_conclude_tongtien;
    private javax.swing.JLabel lb_ticket_makhachhang;
    private javax.swing.JLabel lb_ticket_tenkhachhang;
    private javax.swing.JRadioButton rdb_Khac;
    private javax.swing.JRadioButton rdb_info_Nam;
    private javax.swing.JRadioButton rdb_info_Nu;
    private javax.swing.JTable tb_find_phong;
    private javax.swing.JTable tb_info_khachhang;
    private javax.swing.JTable tb_phieudangky;
    private javax.swing.JLabel txt_TenKH;
    private javax.swing.JTextField txt_info_cmnd;
    private javax.swing.JTextField txt_info_diachi;
    private javax.swing.JTextField txt_info_makh;
    private javax.swing.JTextField txt_info_sdt;
    private javax.swing.JTextField txt_info_tenkh;
    private javax.swing.JLabel txt_manhanvien;
    private javax.swing.JTextField txt_maphieudangky;
    private com.toedter.calendar.JDateChooser txt_ngayden;
    private com.toedter.calendar.JDateChooser txt_ngaydi;
    private javax.swing.JLabel txt_thanhtienp;
    private com.toedter.calendar.JDateChooser txt_ticket_checkin;
    private com.toedter.calendar.JDateChooser txt_ticket_checkout;
    private javax.swing.JLabel txt_ticket_manhanvien;
    private javax.swing.JTextField txt_ticket_maphieu;
    private javax.swing.JLabel txt_ticket_maphong;
    private javax.swing.JTextField txt_timkiem;
    private javax.swing.JTextField txt_timkiemphong;
    private javax.swing.JLabel txt_timtheoSDT;
    // End of variables declaration//GEN-END:variables
}
