package view;

import com.sun.jdi.IntegerValue;
import control.Data_HangHoa;
import control.Data_DatPhong;
import control.Data_QuanLy;
import java.awt.Color;
import java.awt.Component;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import model.tbl_CTPhieuDV;
import model.tbl_CTPhieuSP;
import model.tbl_DichVu;
import model.tbl_HangHoa;
import model.tbl_HoaDon;
import model.tbl_KhachHang;
import model.tbl_PhieuDatPhong;
import model.tbl_Phong;
import model.tbl_PhieuBonus;

public class JP_DatPhong extends javax.swing.JPanel {

    DefaultTableModel tbl_KhachHang_b1, tbl_Phong_b1, tbl_DichVu_b2, tbl_SanPham_b2, tbl_ChotDichVu, tbl_ChotSanPham;
     Locale locale = new Locale("vi","VN");
     NumberFormat format = NumberFormat.getCurrencyInstance(locale);
     DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance(locale);
     char decimalSeparator = symbols.getDecimalSeparator();
        
    List<tbl_KhachHang> arrKhachHang_b1 = new ArrayList<>();
    List<tbl_Phong> arrPhong_b1 = new ArrayList<>();
    List<tbl_DichVu> arrDichVu_b2 = new ArrayList<>();
    List<tbl_DichVu> arrChotDichVu_b2 = new ArrayList<>();
    List<tbl_HangHoa> arrSanPham_b2 = new ArrayList<>();

    private static String sTimMaPhieu, sTimKhachHang, sPhanLoaiTimKiem;
    private static String makh, tenkh, sodt, diachi, gioitinh, cmnd, maPhong, loaiPhong, giaPhong, maPhieuDk, maNhanVien, tinhTien;
    private static String b2_madv, b2_tendv, b2_giadv, b2_masp, b2_tensp, b2_soluongsp, b2_giasp, b2_tongphieu, b2_tiencoc = "0";
    private static int socot = 1;
    public static String laymanhanvien;

    public JP_DatPhong() throws IOException {
        initComponents();
        Buoc1_LayNguonPhong();
        Buoc1_LayNguonKH();
        Buoc2_LayNguonDV();
        Buoc2_LayNguonSP();
        sTimMaPhieu = "";
        txt_ticket_manhanvien.setText(JP_DatPhong.laymanhanvien);
        lb_b2_tonggiadv.setText("0");
        lb_b2_tonggiasp.setText("0");
    }

    public void Buoc1_LayNguonPhong() throws IOException {
        tbl_Phong_b1 = (DefaultTableModel) tb_find_phong.getModel();
        tb_find_phong.getColumnModel().getColumn(0).setPreferredWidth(60);           // Thiết lập độ rộng của cột 1 ưu tiên là 60 pixel
        tb_find_phong.getColumnModel().getColumn(1).setPreferredWidth(130);
        tb_find_phong.getColumnModel().getColumn(2).setPreferredWidth(50);
        tb_find_phong.getColumnModel().getColumn(3).setPreferredWidth(90);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer(){
            
         public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (value =="Đầy") {
                    c.setBackground(Color.RED);
                } else {
                    c.setBackground(table.getBackground());
                }
                return c;
    }
        };
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        TableColumnModel columnModel = tb_find_phong.getColumnModel();
        columnModel.getColumn(0).setCellRenderer(centerRenderer);
        columnModel.getColumn(1).setCellRenderer(centerRenderer);
        columnModel.getColumn(2).setCellRenderer(centerRenderer);
        columnModel.getColumn(3).setCellRenderer(centerRenderer);
        arrPhong_b1 = Data_DatPhong.NguonPhong(sPhanLoaiTimKiem, sTimKhachHang);
        tbl_Phong_b1.setRowCount(0);
        arrPhong_b1.forEach((KQ) -> {
            tbl_Phong_b1.addRow(new Object[]{KQ.getMaPhong(), KQ.getLoaiPhong(), KQ.getTang(), KQ.getTinhTrang()});
        });
    }

    public void Buoc1_LayNguonKH() throws IOException {
        // Thiết lập độ rộng của cột
        tbl_KhachHang_b1 = (DefaultTableModel) tb_info_khachhang.getModel();
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

        arrKhachHang_b1 = Data_DatPhong.NguonKhachHang(sPhanLoaiTimKiem, sTimKhachHang);
        tbl_KhachHang_b1.setRowCount(0);
        arrKhachHang_b1.forEach((KQ) -> {
            tbl_KhachHang_b1.addRow(new Object[]{KQ.getMakh(), KQ.getTenkh(), KQ.getSodt()});
        });
    }

    public void Buoc2_LayNguonDV() throws IOException {
        tbl_DichVu_b2 = (DefaultTableModel) tb_dichvu.getModel();
        arrDichVu_b2 = Data_DatPhong.NguonDichVu("");
        tbl_DichVu_b2.setRowCount(0);
       
        format.setRoundingMode(RoundingMode.HALF_UP);
        arrDichVu_b2.forEach((KQ) -> {
            String giadvString = KQ.getGiadichvu().replace(",", "");
            double giadichvu = Double.parseDouble(giadvString.replaceAll("[^\\d" + decimalSeparator + "]+", ""));
            String formattedgiadv = format.format(giadichvu);
            tbl_DichVu_b2.addRow(new Object[]{KQ.getMadichvu(), KQ.getTendichvu(), formattedgiadv});
        });
    }

    public void Buoc2_LayNguonSP() {
        tbl_SanPham_b2 = (DefaultTableModel) tb_sanpham.getModel();
        arrSanPham_b2 = Data_DatPhong.NguonSanPham("");
        tbl_SanPham_b2.setRowCount(0);
       
        format.setRoundingMode(RoundingMode.HALF_UP);
        arrSanPham_b2.forEach((KQ) -> {
            String giabanString = KQ.getGiaban().replace(",", "");
            double giaban = Double.parseDouble(giabanString.replaceAll("[^\\d" + decimalSeparator + "]+", ""));
            String formattedgiaban = format.format(giaban);
            tbl_SanPham_b2.addRow(new Object[]{KQ.getMahang(), KQ.getTenhang(), formattedgiaban, KQ.getSoluong()});
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Tabbed_Booking = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
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
        jLabel8 = new javax.swing.JLabel();
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
        btn_kiemtraphong = new javax.swing.JButton();
        lb_ticket_makhachhang = new javax.swing.JLabel();
        txt_ticket_maphong = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
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
        btn_lammoi = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_dichvu = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        txt_b2_timkiemdv = new javax.swing.JTextField();
        btn_b2_timkiemdv = new javax.swing.JLabel();
        btn_b2_refreshdv = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        lb_b2_madv = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        lb_b2_tendv = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        lb_b2_giadv = new javax.swing.JLabel();
        btn_b2_themdv = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tb_sanpham = new javax.swing.JTable();
        jLabel36 = new javax.swing.JLabel();
        txt_timkiemsp = new javax.swing.JTextField();
        btn_timkiemdv = new javax.swing.JLabel();
        btn_refreshsp = new javax.swing.JLabel();
        lb_b2_masp = new javax.swing.JLabel();
        lb_b2_tensp = new javax.swing.JLabel();
        lb_b2_giasp = new javax.swing.JLabel();
        btn_b2_themsp = new javax.swing.JButton();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        txt_b2_soluongsp = new javax.swing.JTextField();
        btn_themsoluong = new javax.swing.JLabel();
        btn_giamsoluong = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tb_chotdichvu = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        tb_chotsanpham = new javax.swing.JTable();
        jLabel33 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        lb_b2_tonggiadv = new javax.swing.JLabel();
        lb_b2_tonggiasp = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        btn_b2_loaibodichvu = new javax.swing.JLabel();
        btn_b2_loaibosanpham = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        lb_b2_tongphieudv = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txt_b2_tiencoc = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(76, 41, 211));
        jPanel6.setMaximumSize(new java.awt.Dimension(1140, 70));
        jPanel6.setMinimumSize(new java.awt.Dimension(1140, 70));

        jLabel1.setFont(new java.awt.Font("Century Schoolbook", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Booking");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(480, 480, 480)
                .addComponent(jLabel1)
                .addGap(529, 529, 529))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setPreferredSize(new java.awt.Dimension(300, 780));

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
        rdb_info_Nam.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        rdb_info_Nam.setLabel("Nam");

        rdb_info_Nu.setBackground(new java.awt.Color(255, 255, 255));
        rdb_info_Nu.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        rdb_info_Nu.setLabel("Nữ");

        rdb_Khac.setBackground(new java.awt.Color(255, 255, 255));
        rdb_Khac.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        rdb_Khac.setText("Khác");
        rdb_Khac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_KhacActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Century Gothic", 2, 24)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Customer Information");

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
        tb_info_khachhang.setRowHeight(20);
        tb_info_khachhang.setRowMargin(5);
        tb_info_khachhang.setSelectionBackground(new java.awt.Color(204, 204, 204));
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
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_info_diachi)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdb_Khac, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(rdb_info_Nam)
                                .addGap(50, 50, 50)
                                .addComponent(rdb_info_Nu))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txt_info_tenkh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                                        .addComponent(txt_info_makh, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(btn_timtheotenkhachhang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(1, 1, 1))
                                .addComponent(btn_timtheomakhachhang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(1, 1, 1)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(txt_info_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(txt_timtheoSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_refresh_KH, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_info_cmnd)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_info_makh, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_timtheomakhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_timtheotenkhachhang)
                    .addComponent(txt_info_tenkh, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(0, 0, 0)
                .addComponent(txt_info_diachi, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(0, 0, 0)
                        .addComponent(txt_info_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_refresh_KH, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_timtheoSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        tb_find_phong.setSelectionBackground(new java.awt.Color(204, 204, 204));
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(cbb_phanloaitimkiem, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_timkiemphong, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_timkiemduatrenphanloai, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(btn_refresh_phong, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_refresh_phong, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_timkiemphong, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbb_phanloaitimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_timkiemduatrenphanloai)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setMaximumSize(new java.awt.Dimension(1000, 1000));
        jPanel5.setMinimumSize(new java.awt.Dimension(272, 425));

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

        btn_kiemtraphong.setFont(new java.awt.Font("Montserrat Medium", 0, 16)); // NOI18N
        btn_kiemtraphong.setLabel("OK");
        btn_kiemtraphong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_kiemtraphongMouseClicked(evt);
            }
        });
        btn_kiemtraphong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kiemtraphongActionPerformed(evt);
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_ticket_checkout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_ticket_maphieu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lb_ticket_tenkhachhang, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                                .addComponent(lb_ticket_makhachhang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_ticket_maphong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(btn_kiemtraphong, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txt_ticket_manhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_ticket_checkin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_ticket_maphieu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_ticket_makhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_ticket_tenkhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txt_ticket_maphong))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel19)
                .addGap(0, 0, 0)
                .addComponent(txt_ticket_checkin, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addGap(0, 0, 0)
                .addComponent(txt_ticket_checkout, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txt_ticket_manhanvien))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(btn_kiemtraphong)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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
        btn_themdulieu.setText("Tiếp Theo");
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

        btn_lammoi.setFont(new java.awt.Font("Montserrat Medium", 0, 16)); // NOI18N
        btn_lammoi.setText("Làm Mới");
        btn_lammoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_lammoiMouseClicked(evt);
            }
        });
        btn_lammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lammoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lb_conclude_NguoiThue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_conclude_loaiphong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_conclude_songay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_conclude_MaPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_conclude_tongtien, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(btn_lammoi, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(btn_themdulieu, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(lb_conclude_MaPhong))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(lb_conclude_NguoiThue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(lb_conclude_loaiphong))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(lb_conclude_songay))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(lb_conclude_tongtien))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_themdulieu)
                    .addComponent(btn_lammoi))
                .addContainerGap(113, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 811, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        Tabbed_Booking.addTab("Bước 1: Đặt Phòng", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));

        tb_dichvu.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        tb_dichvu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã Dịch Vụ", "Tên Dịch Vụ", "Giá Tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_dichvu.setRowMargin(5);
        tb_dichvu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_dichvuMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tb_dichvu);

        jLabel14.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel14.setText("Bộ lọc:");

        btn_b2_timkiemdv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search_dark_26px.png"))); // NOI18N
        btn_b2_timkiemdv.setText("jLabel14");

        btn_b2_refreshdv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/refresh_25px.png"))); // NOI18N
        btn_b2_refreshdv.setText("jLabel14");

        jLabel28.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel28.setText("Mã Dịch Vụ:");

        lb_b2_madv.setFont(new java.awt.Font("Montserrat Medium", 1, 14)); // NOI18N
        lb_b2_madv.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel30.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel30.setText("Tên Dịch Vụ:");

        lb_b2_tendv.setFont(new java.awt.Font("Montserrat Medium", 1, 14)); // NOI18N
        lb_b2_tendv.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel34.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel34.setText("Giá:");

        lb_b2_giadv.setFont(new java.awt.Font("Montserrat Medium", 3, 16)); // NOI18N
        lb_b2_giadv.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        btn_b2_themdv.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        btn_b2_themdv.setText("Thêm");
        btn_b2_themdv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_b2_themdvMouseClicked(evt);
            }
        });
        btn_b2_themdv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_b2_themdvActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(txt_b2_timkiemdv, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(btn_b2_timkiemdv, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_b2_refreshdv, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_b2_tendv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_b2_madv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_b2_giadv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_b2_themdv)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(34, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(6, 6, 6)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_b2_timkiemdv, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_b2_timkiemdv)
                            .addComponent(btn_b2_refreshdv))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_b2_madv, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_b2_tendv, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_b2_giadv, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 195, Short.MAX_VALUE)
                        .addComponent(btn_b2_themdv)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jScrollPane4.setBackground(new java.awt.Color(255, 255, 255));

        tb_sanpham.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        tb_sanpham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã Sản Phẩm", "Sản Phẩm", "Giá", "Còn"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_sanpham.setRowMargin(5);
        tb_sanpham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_sanphamMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tb_sanpham);

        jLabel36.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel36.setText("Bộ lọc:");

        btn_timkiemdv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search_dark_26px.png"))); // NOI18N
        btn_timkiemdv.setText("jLabel14");

        btn_refreshsp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/refresh_25px.png"))); // NOI18N
        btn_refreshsp.setText("jLabel14");

        lb_b2_masp.setFont(new java.awt.Font("Montserrat Medium", 1, 14)); // NOI18N
        lb_b2_masp.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        lb_b2_tensp.setFont(new java.awt.Font("Montserrat Medium", 1, 14)); // NOI18N
        lb_b2_tensp.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        lb_b2_giasp.setFont(new java.awt.Font("Montserrat Medium", 3, 16)); // NOI18N
        lb_b2_giasp.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        btn_b2_themsp.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        btn_b2_themsp.setText("Thêm");
        btn_b2_themsp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_b2_themspMouseClicked(evt);
            }
        });
        btn_b2_themsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_b2_themspActionPerformed(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel42.setText("Giá:");

        jLabel43.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel43.setText("Tên Sản Phẩm:");

        jLabel44.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel44.setText("Mã Sản Phẩm:");

        jLabel45.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel45.setText("Tên Sản Phẩm:");

        txt_b2_soluongsp.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        txt_b2_soluongsp.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_b2_soluongsp.setText("1");
        txt_b2_soluongsp.setPreferredSize(new java.awt.Dimension(24, 24));
        txt_b2_soluongsp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_b2_soluongspFocusLost(evt);
            }
        });

        btn_themsoluong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_themsoluong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/sum_25px.png"))); // NOI18N
        btn_themsoluong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_themsoluongMouseClicked(evt);
            }
        });

        btn_giamsoluong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_giamsoluong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/minus_25px.png"))); // NOI18N
        btn_giamsoluong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_giamsoluongMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel45, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lb_b2_tensp, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lb_b2_masp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(btn_giamsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(txt_b2_soluongsp, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(btn_themsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_b2_giasp, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addComponent(btn_b2_themsp)
                                .addGap(16, 16, 16))))
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                            .addComponent(txt_timkiemsp, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addComponent(btn_timkiemdv, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btn_refreshsp, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addGap(0, 0, 0)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_timkiemsp, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_timkiemdv)
                            .addComponent(btn_refreshsp))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_b2_masp, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_b2_tensp, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn_themsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txt_b2_soluongsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lb_b2_giasp, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btn_giamsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_b2_themsp))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jPanel12.setBackground(new java.awt.Color(123, 156, 225));
        jPanel12.setPreferredSize(new java.awt.Dimension(260, 30));

        jLabel12.setFont(new java.awt.Font("Montserrat", 3, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Bước 2:");

        jLabel13.setFont(new java.awt.Font("Montserrat", 2, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Đăng Ký Dịch Vụ");

        jPanel13.setBackground(new java.awt.Color(204, 204, 204));
        jPanel13.setPreferredSize(new java.awt.Dimension(5, 30));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
        );

        jLabel29.setFont(new java.awt.Font("Montserrat Medium", 0, 24)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Dịch Vụ Đã Chọn");

        jScrollPane6.setBackground(new java.awt.Color(255, 255, 255));

        tb_chotdichvu.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        tb_chotdichvu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Dịch Vụ", "Dịch Vụ", "Giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_chotdichvu.setRowMargin(5);
        tb_chotdichvu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_chotdichvuMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tb_chotdichvu);

        jScrollPane7.setBackground(new java.awt.Color(255, 255, 255));

        tb_chotsanpham.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        tb_chotsanpham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Sản Phẩm", "Tên", "Số Lượng", "Giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_chotsanpham.setRowMargin(5);
        tb_chotsanpham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_chotsanphamMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tb_chotsanpham);

        jLabel33.setFont(new java.awt.Font("Montserrat Medium", 0, 24)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Sản Phẩm Đã Chọn");

        jLabel35.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel35.setText("Tổng dịch vụ:");

        lb_b2_tonggiadv.setFont(new java.awt.Font("Montserrat Medium", 3, 16)); // NOI18N
        lb_b2_tonggiadv.setForeground(new java.awt.Color(255, 0, 0));
        lb_b2_tonggiadv.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_b2_tonggiadv.setText("0");

        lb_b2_tonggiasp.setFont(new java.awt.Font("Montserrat Medium", 3, 16)); // NOI18N
        lb_b2_tonggiasp.setForeground(new java.awt.Color(255, 0, 0));
        lb_b2_tonggiasp.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_b2_tonggiasp.setText("0");

        jLabel37.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel37.setText("Tổng sản phẩm:");

        btn_b2_loaibodichvu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_b2_loaibodichvu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/trash_25px.png"))); // NOI18N
        btn_b2_loaibodichvu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_b2_loaibodichvuMouseClicked(evt);
            }
        });

        btn_b2_loaibosanpham.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_b2_loaibosanpham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/trash_25px.png"))); // NOI18N
        btn_b2_loaibosanpham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_b2_loaibosanphamMouseClicked(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Montserrat Medium", 1, 18)); // NOI18N
        jLabel38.setText("Tổng:");

        lb_b2_tongphieudv.setFont(new java.awt.Font("Montserrat Medium", 3, 20)); // NOI18N
        lb_b2_tongphieudv.setForeground(new java.awt.Color(255, 0, 0));
        lb_b2_tongphieudv.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_b2_tongphieudv.setText("0");

        jButton1.setText("Hoàn Thành");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txt_b2_tiencoc.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N

        jLabel39.setFont(new java.awt.Font("Montserrat Medium", 0, 10)); // NOI18N
        jLabel39.setText("Tiền cọc:");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_b2_loaibosanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 316, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addComponent(txt_b2_tiencoc)
                            .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_b2_loaibodichvu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lb_b2_tonggiasp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_b2_tonggiadv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_b2_tongphieudv, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel29)
                    .addComponent(btn_b2_loaibodichvu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel33)
                    .addComponent(btn_b2_loaibosanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_b2_tonggiadv, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lb_b2_tonggiasp, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_b2_tongphieudv, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel39)
                        .addGap(0, 0, 0)
                        .addComponent(txt_b2_tiencoc, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addContainerGap(34, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );

        Tabbed_Booking.addTab("Bước 2: Chọn Dịch Vụ", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 1139, Short.MAX_VALUE)
            .addComponent(Tabbed_Booking, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Tabbed_Booking))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_info_tenkhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_info_tenkhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_info_tenkhActionPerformed

    private void rdb_KhacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_KhacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdb_KhacActionPerformed

    private void btn_timtheomakhachhangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_timtheomakhachhangMouseClicked
        // TODO add your handling code here:sTimKhachHang = txt_timkiem.getText();
        sPhanLoaiTimKiem = "MaKhachHang";
        sTimKhachHang = txt_info_makh.getText();
        try {
            Buoc1_LayNguonKH();
        } catch (IOException ex) {
            Logger.getLogger(JP_DatPhong.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btn_timtheomakhachhangMouseClicked

    private void tb_info_khachhangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_info_khachhangMouseClicked

        try {
            int index = tb_info_khachhang.getSelectedRow();
            TableModel model = tb_info_khachhang.getModel();
            makh = model.getValueAt(index, 0).toString();
            tenkh = model.getValueAt(index, 1).toString();
            sodt = model.getValueAt(index, 2).toString();

            diachi = Data_DatPhong.NguonTruyVanDuLieu("DiaChi", "KhachHang", "MaKhachHang", makh);
            gioitinh = Data_DatPhong.NguonTruyVanDuLieu("GioiTinh", "KhachHang", "MaKhachHang", makh);
            cmnd = Data_DatPhong.NguonTruyVanDuLieu("CMND", "KhachHang", "MaKhachHang", makh);

            txt_info_makh.setText(makh);
            lb_ticket_makhachhang.setText(makh);
            txt_info_tenkh.setText(tenkh);
            lb_ticket_tenkhachhang.setText(tenkh);
            txt_info_diachi.setText(diachi);
            if (gioitinh.equalsIgnoreCase("Nam")) {
                rdb_info_Nam.setSelected(true);
                rdb_info_Nu.setSelected(false);
                rdb_Khac.setSelected(false);
            } else if (gioitinh.equalsIgnoreCase("Nữ")) {
                rdb_info_Nam.setSelected(false);
                rdb_info_Nu.setSelected(true);
                rdb_Khac.setSelected(false);
            } else {
                rdb_info_Nam.setSelected(false);
                rdb_info_Nu.setSelected(false);
                rdb_Khac.setSelected(true);
            }
            txt_info_cmnd.setText(cmnd);
            txt_info_sdt.setText(sodt);
        } catch (IOException ex) {
            Logger.getLogger(JP_DatPhong.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_tb_info_khachhangMouseClicked

    private void btn_timtheotenkhachhangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_timtheotenkhachhangMouseClicked

        try {
            // TODO add your handling code here:sTimKhachHang = txt_timkiem.getText();
            sPhanLoaiTimKiem = "TenKhachHang";
            sTimKhachHang = txt_info_tenkh.getText();
            Buoc1_LayNguonKH();
        } catch (IOException ex) {
            Logger.getLogger(JP_DatPhong.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btn_timtheotenkhachhangMouseClicked

    private void txt_timtheoSDTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_timtheoSDTMouseClicked

        try {
            // TODO add your handling code here:sTimKhachHang = txt_timkiem.getText();
            sPhanLoaiTimKiem = "SDT";
            sTimKhachHang = txt_info_sdt.getText();
            Buoc1_LayNguonKH();
        } catch (IOException ex) {
            Logger.getLogger(JP_DatPhong.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_txt_timtheoSDTMouseClicked

    private void btn_refresh_KHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_refresh_KHMouseClicked
        try {
            sTimMaPhieu = "";
            Buoc1_LayNguonKH();
        } catch (IOException ex) {
            Logger.getLogger(JP_DatPhong.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btn_refresh_KHMouseClicked

    private void tb_find_phongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_find_phongMouseClicked
        int index = tb_find_phong.getSelectedRow();
        TableModel model = tb_find_phong.getModel();
        maPhong = model.getValueAt(index, 0).toString();
        txt_ticket_maphong.setText(maPhong);
    }//GEN-LAST:event_tb_find_phongMouseClicked

    private void btn_timkiemduatrenphanloaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_timkiemduatrenphanloaiMouseClicked

    }//GEN-LAST:event_btn_timkiemduatrenphanloaiMouseClicked

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
            Buoc1_LayNguonPhong();
        } catch (IOException ex) {
            Logger.getLogger(JP_DatPhong.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btn_timkiemduatrenphanloaiActionPerformed

    private void btn_refresh_phongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_refresh_phongMouseClicked
        txt_timkiemphong.setText("");
        cbb_phanloaitimkiem.setSelectedItem(0);
        sTimMaPhieu = "";

        try {
            Buoc1_LayNguonPhong();
        } catch (IOException ex) {
            Logger.getLogger(JP_DatPhong.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btn_refresh_phongMouseClicked

    private void btn_kiemtraphongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_kiemtraphongMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_kiemtraphongMouseClicked

    private void btn_kiemtraphongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kiemtraphongActionPerformed
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
                int soNgay = (int) ((ngayDi.getTime() - ngayDen.getTime()) / (24 * 60 * 60 * 1000));
                tinhngay =  String.valueOf(soNgay);
                lb_conclude_songay.setText(tinhngay);
                giaPhong = Data_DatPhong.NguonTruyVanDuLieu("GiaPhong", "Phong", "MaPhong", maPhong);
                format.setRoundingMode(RoundingMode.HALF_UP);
                double giaPhong1 = Double.parseDouble(giaPhong.replaceAll("[^\\d" + decimalSeparator + "]+", ""));
                double tongTien = (giaPhong1 * soNgay);
                lb_conclude_tongtien.setText(format.format(tongTien));
            } catch (IOException ex) {
                Logger.getLogger(JP_DatPhong.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            // Xử lý giá trị null ở đây
        }
    }//GEN-LAST:event_btn_kiemtraphongActionPerformed

    private void btn_themdulieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_themdulieuMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_themdulieuMouseClicked

    private void btn_themdulieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themdulieuActionPerformed
        
        try {
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

            format.setRoundingMode(RoundingMode.HALF_UP);
            double tongtien = Double.parseDouble(lb_conclude_tongtien.getText().replaceAll("[^\\d" + decimalSeparator + "]+", ""));
            tinhTien = format.format(tongtien);

//          tinhTien = lb_conclude_tongtien.getText();
            maNhanVien = JP_DatPhong.laymanhanvien;
// Yêu cầu nhập đủ thông tin
            if (maPhieuDk.isEmpty() || makh.isEmpty() || tenkh.isEmpty() || diachi.isEmpty() || gioitinh.isEmpty() || cmnd.isEmpty() || sodt.isEmpty() || maPhong.isEmpty() || tinhTien.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Bạn chưa nhập đầy đủ thông tin.", "Thông Báo", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (Data_DatPhong.KiemTra("PhieuDatPhong", "MaPhieuDatPhong", maPhieuDk)) {
                JOptionPane.showMessageDialog(this, "Mã phiếu đã tồn tại trong cơ sở dữ liệu.", "Thông Báo", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (Data_DatPhong.KiemTra("KhachHang", "MaKhachHang", makh)) {
                tbl_KhachHang cnKH = new tbl_KhachHang(makh, tenkh, diachi, gioitinh, cmnd, sodt);
                Data_QuanLy.CapNhapKhachHang(cnKH, makh);
            } else {
                tbl_KhachHang cnKH = new tbl_KhachHang(makh, tenkh, diachi, gioitinh, cmnd, sodt);
                Data_DatPhong.ThemKhachHang(cnKH);
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
// Kiểm tra ngày đến và ngày đi
            String ngayDen = sdf.format(txt_ticket_checkin.getDate());
            String ngayDi = sdf.format(txt_ticket_checkout.getDate());
// Đặt Phòng
            tbl_PhieuDatPhong cnP = new tbl_PhieuDatPhong(maPhieuDk, makh, ngayDen, ngayDi, maPhong, tinhTien, maNhanVien);
            Data_DatPhong.ThemPhieuDatPhong(cnP);
            JOptionPane.showMessageDialog(this, "Đặt phòng thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
// tự động đóng thông báo sau 5 giây
            Timer timer = new Timer(5000, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.getRootFrame().dispose();
                }
            });
            timer.setRepeats(false);
            timer.start();
            Buoc1_LayNguonKH();
            Buoc1_LayNguonPhong();

            Tabbed_Booking.setSelectedIndex(1);
            Tabbed_Booking.setEnabledAt(0, false);
            Tabbed_Booking.setEnabledAt(1, true);
        } catch (SQLException ex) {
            Logger.getLogger(JP_DatPhong.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JP_DatPhong.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btn_themdulieuActionPerformed

    private void btn_lammoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_lammoiMouseClicked
        try {
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

            Buoc1_LayNguonPhong();
            Buoc1_LayNguonKH();
        } catch (IOException ex) {
            Logger.getLogger(JP_DatPhong.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btn_lammoiMouseClicked

    private void btn_lammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lammoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_lammoiActionPerformed

    private void tb_dichvuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_dichvuMouseClicked
        int index = tb_dichvu.getSelectedRow();
        TableModel model = tb_dichvu.getModel();
        lb_b2_madv.setText(model.getValueAt(index, 0).toString());
        lb_b2_tendv.setText(model.getValueAt(index, 1).toString());
        lb_b2_giadv.setText(model.getValueAt(index, 2).toString());
    }//GEN-LAST:event_tb_dichvuMouseClicked

    private void tb_sanphamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_sanphamMouseClicked
        int index = tb_sanpham.getSelectedRow();
        TableModel model = tb_sanpham.getModel();

        lb_b2_masp.setText(model.getValueAt(index, 0).toString());
        lb_b2_tensp.setText(model.getValueAt(index, 1).toString());
        txt_b2_soluongsp.setText("1");
        lb_b2_giasp.setText(model.getValueAt(index, 2).toString());

    }//GEN-LAST:event_tb_sanphamMouseClicked

    private void tb_chotdichvuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_chotdichvuMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tb_chotdichvuMouseClicked

    private void tb_chotsanphamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_chotsanphamMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tb_chotsanphamMouseClicked

    private void TinhTongGia(DefaultTableModel bang, JLabel lb_cantinh) {
        Double b2_tongTienSP = 0.0;
         format.setRoundingMode(RoundingMode.HALF_UP);
        for (int i = 0; i < bang.getRowCount(); i++) {
            if (bang.getValueAt(i, bang.getColumnCount() - 1) != null) {  
                // Kiểm tra giá trị của cột cuối cùng có khác null không
//                int gia = Integer.parseInt(bang.getValueAt(i, bang.getColumnCount() - 1).toString());
                   String giaTien = bang.getValueAt(i, bang.getColumnCount() - 1).toString();
                   giaTien = giaTien.replaceAll("[^\\d" + decimalSeparator + "]+", "");  // loại bỏ các ký tự không phải số
                   double gia = Double.parseDouble(giaTien);
                    b2_tongTienSP +=gia;
            }
        }
        String tongTienSP = format.format(b2_tongTienSP);
        lb_cantinh.setText(tongTienSP);                      // Chuyển đổi kiểu int sang String

        double giadv = Double.parseDouble(lb_b2_tonggiadv.getText().replaceAll("[^\\d" + decimalSeparator + "]+", ""));
        double giasp = Double.parseDouble(lb_b2_tonggiasp.getText().replaceAll("[^\\d" + decimalSeparator + "]+", ""));
        
        double tong = giadv + giasp;
        String tongphieu = String.valueOf(tong);
        lb_b2_tongphieudv.setText(tongphieu);
    }

    private void btn_b2_themdvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_b2_themdvMouseClicked
        tbl_ChotDichVu = (DefaultTableModel) tb_chotdichvu.getModel();
        b2_madv = lb_b2_madv.getText();
        b2_tendv = lb_b2_tendv.getText();
        b2_giadv = lb_b2_giadv.getText();
        boolean skt = false;
        // Kiểm tra trùng lặp với cột đầu tiên của bảng
        for (int i = 0; i < tbl_ChotDichVu.getRowCount(); i++) {
            if (tbl_ChotDichVu.getValueAt(i, 0).equals(b2_madv)) {
                skt = true;
                break;
            }
        }

        if (skt) {
            JOptionPane.showMessageDialog(this, "Dịch vụ này đã có, không thể thêm mới", "Thông Báo", JOptionPane.ERROR_MESSAGE);
        } else {
            Object[] row = {b2_madv, b2_tendv, b2_giadv};
            tbl_ChotDichVu.addRow(row);
            TinhTongGia(tbl_ChotDichVu, lb_b2_tonggiadv);
        }


    }//GEN-LAST:event_btn_b2_themdvMouseClicked

    private void btn_giamsoluongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_giamsoluongMouseClicked
        b2_soluongsp = txt_b2_soluongsp.getText();
        int soLuong = Integer.parseInt(b2_soluongsp);                           // chuyển đổi sang kiểu int
        if (soLuong > 1) {
            soLuong--;
            txt_b2_soluongsp.setText(String.valueOf(soLuong));

           String gia = tb_sanpham.getValueAt(tb_sanpham.getSelectedRow(), 2).toString();
        double gia1=Double.parseDouble(gia.replaceAll("[^\\d" + decimalSeparator + "]+", ""));
        double tongTien = soLuong * gia1;
        lb_b2_giasp.setText(format.format(tongTien));
        } else {
            JOptionPane.showMessageDialog(this, "Số lượng sản phẩm phải lớn hơn 1", "Thông Báo", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btn_giamsoluongMouseClicked

    private void btn_themsoluongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_themsoluongMouseClicked
        b2_soluongsp = txt_b2_soluongsp.getText();
        int soLuong = Integer.parseInt(b2_soluongsp); // chuyển đổi sang kiểu int
        // Kiểm tra số lượng đã có ở cột số lượng sản phẩm đã mua
        int soLuongTrongKho = Integer.parseInt(tb_sanpham.getValueAt(tb_sanpham.getSelectedRow(), 3).toString());
        if (soLuong > soLuongTrongKho - 1) {
            JOptionPane.showMessageDialog(null, "Số lượng sản phẩm đã đạt tối đa");
            return;
        }
        soLuong++;
        txt_b2_soluongsp.setText(String.valueOf(soLuong));
        // Lấy giá trị từ cột giá trong bảng
        String gia = tb_sanpham.getValueAt(tb_sanpham.getSelectedRow(), 2).toString();
        double gia1=Double.parseDouble(gia.replaceAll("[^\\d" + decimalSeparator + "]+", ""));
        double tongTien = soLuong * gia1;
        lb_b2_giasp.setText(format.format(tongTien));
    }//GEN-LAST:event_btn_themsoluongMouseClicked

    private void txt_b2_soluongspFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_b2_soluongspFocusLost
        int soLuong = Integer.parseInt(txt_b2_soluongsp.getText());
        if (soLuong < 0) {
            txt_b2_soluongsp.setText("1");
        }
        int soLuongTrongKho = Integer.parseInt(tb_sanpham.getValueAt(tb_sanpham.getSelectedRow(), 3).toString());
        if (soLuong > soLuongTrongKho - 1) {
            JOptionPane.showMessageDialog(null, "Số lượng sản phẩm đã đạt tối đa");
            txt_b2_soluongsp.setText(String.valueOf(soLuongTrongKho));
            return;
        }
    }//GEN-LAST:event_txt_b2_soluongspFocusLost

    private void btn_b2_themspMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_b2_themspMouseClicked
        tbl_ChotSanPham = (DefaultTableModel) tb_chotsanpham.getModel();
        b2_masp = lb_b2_masp.getText();
        b2_tensp = lb_b2_tensp.getText();
        b2_soluongsp = txt_b2_soluongsp.getText();
        b2_giasp = lb_b2_giasp.getText();
        
        // Kiểm tra trùng mã sản phẩm
        boolean daCoSanPham = false;
        for (int i = 0; i < tbl_ChotSanPham.getRowCount(); i++) {
            String maSanPham = tbl_ChotSanPham.getValueAt(i, 0).toString();
            if (maSanPham.equals(b2_masp)) {
                // Mã sản phẩm đã tồn tại, cập nhật số lượng và giá sản phẩm
                daCoSanPham = true;
                int soLuongCu = Integer.parseInt(tbl_ChotSanPham.getValueAt(i, 2).toString());
                int soLuongMoi = Integer.parseInt(b2_soluongsp);
                int soLuongTong = soLuongCu + soLuongMoi;
                tbl_ChotSanPham.setValueAt(String.valueOf(soLuongTong), i, 2);
//                int giaCu = Integer.parseInt(tbl_ChotSanPham.getValueAt(i, 3).toString());
//                int giaMoi = Integer.parseInt(b2_giasp);
//                int giaTong = giaCu + giaMoi;
                   String giacu=tbl_ChotSanPham.getValueAt(i, 3).toString();
                   double giaCu=Double.parseDouble(giacu.replaceAll("[^\\d" + decimalSeparator + "]+", ""));
                   double giaMoi=Double.parseDouble(b2_giasp.replaceAll("[^\\d" + decimalSeparator + "]+", ""));
                   double giaTong=giaCu + giaMoi;
                tbl_ChotSanPham.setValueAt(format.format(giaTong), i, 3);
                break;
            }
        }

        if (!daCoSanPham) {
            // Mã sản phẩm chưa tồn tại, thêm mới sản phẩm
            Object[] row = {b2_masp, b2_tensp, b2_soluongsp, b2_giasp};
            tbl_ChotSanPham.addRow(row);
        }
        TinhTongGia(tbl_ChotSanPham, lb_b2_tonggiasp);


    }//GEN-LAST:event_btn_b2_themspMouseClicked

    private void btn_b2_loaibodichvuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_b2_loaibodichvuMouseClicked
        tbl_ChotDichVu = (DefaultTableModel) tb_chotdichvu.getModel();

        int row = tb_chotdichvu.getSelectedRow(); // Lấy số hàng được chọn trong bảng
        if (row != -1) { // Kiểm tra xem hàng có được chọn không
            tbl_ChotDichVu.removeRow(row);
        }

        TinhTongGia(tbl_ChotDichVu, lb_b2_tonggiadv); // tính tổng giá trị của tất cả các hàng trong bảng
    }//GEN-LAST:event_btn_b2_loaibodichvuMouseClicked

    private void btn_b2_loaibosanphamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_b2_loaibosanphamMouseClicked
        tbl_ChotSanPham = (DefaultTableModel) tb_chotsanpham.getModel();

        int row = tb_chotsanpham.getSelectedRow(); // Lấy số hàng được chọn trong bảng
        if (row != -1) { // Kiểm tra xem hàng có được chọn không
            tbl_ChotSanPham.removeRow(row);
        }

        TinhTongGia(tbl_ChotSanPham, lb_b2_tonggiasp); // tính tổng giá trị của tất cả các hàng trong bảng
    }//GEN-LAST:event_btn_b2_loaibosanphamMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            maPhieuDk = txt_ticket_maphieu.getText();
            b2_giadv = lb_b2_giadv.getText();
            b2_giasp = lb_b2_giasp.getText();
            tbl_PhieuBonus cndv = new tbl_PhieuBonus("", maPhieuDk, b2_giadv);
            Data_DatPhong.ThemPhieuBonus(cndv, "MaPhieuDichVu", "PhieuDichVu", "PDV");
            tbl_PhieuBonus cnsp = new tbl_PhieuBonus("", maPhieuDk, b2_giasp);
            Data_DatPhong.ThemPhieuBonus(cnsp, "MaPhieuSanPham", "PhieuSanPham", "PSP");

            for (int i = 0; i < tb_chotdichvu.getRowCount(); i++) {
                b2_madv = tb_chotdichvu.getValueAt(i, 0).toString();
                b2_giadv = tb_chotdichvu.getValueAt(i, 2).toString();
                tbl_CTPhieuDV cnCTPDV = new tbl_CTPhieuDV("", "", b2_madv, b2_giadv);
                Data_DatPhong.ThemCTPhieuDichVu(cnCTPDV);
            }

            for (int i = 0; i < tb_chotsanpham.getRowCount(); i++) {
                b2_masp = tb_chotsanpham.getValueAt(i, 0).toString();
                b2_soluongsp = tb_chotsanpham.getValueAt(i, 2).toString();
                b2_giasp = tb_chotsanpham.getValueAt(i, 3).toString();
                tbl_CTPhieuSP cnCTPSP = new tbl_CTPhieuSP("", "", b2_masp, b2_soluongsp, b2_giasp);
                Data_DatPhong.ThemCTPhieuSanPham(cnCTPSP);
            }
            b2_tongphieu = lb_b2_tongphieudv.getText();
            LocalDate currentDate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String ngayHienTai = currentDate.format(formatter);
            b2_tiencoc = txt_b2_tiencoc.getText();
            tbl_HoaDon cnhd = new tbl_HoaDon("", maPhieuDk, "", "", ngayHienTai, b2_tongphieu, b2_tiencoc);
            Data_DatPhong.ThemHoaDon(cnhd);
        } catch (SQLException ex) {
            Logger.getLogger(JP_DatPhong.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_b2_themdvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_b2_themdvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_b2_themdvActionPerformed

    private void btn_b2_themspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_b2_themspActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_b2_themspActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Tabbed_Booking;
    private javax.swing.JLabel btn_b2_loaibodichvu;
    private javax.swing.JLabel btn_b2_loaibosanpham;
    private javax.swing.JLabel btn_b2_refreshdv;
    private javax.swing.JButton btn_b2_themdv;
    private javax.swing.JButton btn_b2_themsp;
    private javax.swing.JLabel btn_b2_timkiemdv;
    private javax.swing.JLabel btn_giamsoluong;
    private javax.swing.JButton btn_kiemtraphong;
    private javax.swing.JButton btn_lammoi;
    private javax.swing.JLabel btn_refresh_KH;
    private javax.swing.JLabel btn_refresh_phong;
    private javax.swing.JLabel btn_refreshsp;
    private javax.swing.JButton btn_themdulieu;
    private javax.swing.JLabel btn_themsoluong;
    private javax.swing.JButton btn_timkiemduatrenphanloai;
    private javax.swing.JLabel btn_timkiemdv;
    private javax.swing.JLabel btn_timtheomakhachhang;
    private javax.swing.JLabel btn_timtheotenkhachhang;
    private javax.swing.JComboBox<String> cbb_phanloaitimkiem;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
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
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLabel lb_b2_giadv;
    private javax.swing.JLabel lb_b2_giasp;
    private javax.swing.JLabel lb_b2_madv;
    private javax.swing.JLabel lb_b2_masp;
    private javax.swing.JLabel lb_b2_tendv;
    private javax.swing.JLabel lb_b2_tensp;
    private javax.swing.JLabel lb_b2_tonggiadv;
    private javax.swing.JLabel lb_b2_tonggiasp;
    private javax.swing.JLabel lb_b2_tongphieudv;
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
    private javax.swing.JTable tb_chotdichvu;
    private javax.swing.JTable tb_chotsanpham;
    private javax.swing.JTable tb_dichvu;
    private javax.swing.JTable tb_find_phong;
    private javax.swing.JTable tb_info_khachhang;
    private javax.swing.JTable tb_sanpham;
    private javax.swing.JTextField txt_b2_soluongsp;
    private javax.swing.JTextField txt_b2_tiencoc;
    private javax.swing.JTextField txt_b2_timkiemdv;
    private javax.swing.JTextField txt_info_cmnd;
    private javax.swing.JTextField txt_info_diachi;
    private javax.swing.JTextField txt_info_makh;
    private javax.swing.JTextField txt_info_sdt;
    private javax.swing.JTextField txt_info_tenkh;
    private com.toedter.calendar.JDateChooser txt_ticket_checkin;
    private com.toedter.calendar.JDateChooser txt_ticket_checkout;
    private javax.swing.JLabel txt_ticket_manhanvien;
    private javax.swing.JTextField txt_ticket_maphieu;
    private javax.swing.JLabel txt_ticket_maphong;
    private javax.swing.JTextField txt_timkiemphong;
    private javax.swing.JTextField txt_timkiemsp;
    private javax.swing.JLabel txt_timtheoSDT;
    // End of variables declaration//GEN-END:variables

}
