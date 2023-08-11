package view;

import controller.DatPhongController;
import controller.QuanLyController;
import java.awt.Color;
import java.awt.Component;
import java.io.IOException;
import java.lang.System.Logger;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import model.tbl_DichVu;
import model.tbl_HangHoa;
import model.tbl_KhachHang;
import model.tbl_Phong;

public class JP_DatPhong1 extends javax.swing.JPanel {

    DefaultTableModel tbl_KhachHang_b1, tbl_Phong_b1;
        
    List<tbl_KhachHang> arrKhachHang_b1 = new ArrayList<>();
    List<tbl_Phong> arrPhong_b1 = new ArrayList<>();

    private String sTimMaPhieu, sTimKhachHang, sPhanLoaiTimKiem;
    public static String makh, tenkh, sodt, diachi, gioitinh, cmnd, maPhong, loaiPhong, giaPhong, maPhieuDk, maNhanVien, tinhTien;
    public static Date ngayDen, ngayDi;
    public static String laymanhanvien;
    public static double soNgay;

    public JP_DatPhong1() throws IOException {
        initComponents();
        Buoc1_LayNguonPhong();
        Buoc1_LayNguonKH();
        sTimMaPhieu = "";
        txt_ticket_manhanvien.setText(JP_DatPhong1.laymanhanvien);
    }

    public void Buoc1_LayNguonPhong() throws IOException {
        tbl_Phong_b1 = (DefaultTableModel) tb_phong.getModel();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (value == "Đầy") {
                    c.setBackground(Color.RED);
                } else {
                    c.setBackground(table.getBackground());
                }
                return c;
            }
        };
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        TableColumnModel columnModel = tb_phong.getColumnModel();
        columnModel.getColumn(0).setCellRenderer(centerRenderer);
        columnModel.getColumn(1).setCellRenderer(centerRenderer);
        columnModel.getColumn(2).setCellRenderer(centerRenderer);
        columnModel.getColumn(3).setCellRenderer(centerRenderer);
        arrPhong_b1 = DatPhongController.NguonPhong(sPhanLoaiTimKiem, sTimKhachHang);
        
        tbl_Phong_b1.setRowCount(0);
        arrPhong_b1.forEach((KQ) -> {
            tbl_Phong_b1.addRow(new Object[]{KQ.getMaPhong(), KQ.getLoaiPhong(), KQ.getTang(), KQ.getTinhTrang()});
        });
    }
    public void Buoc1_LayNguonKH() throws IOException {
        tbl_KhachHang_b1 = (DefaultTableModel) tb_khachhang.getModel();
        arrKhachHang_b1 = DatPhongController.NguonKhachHang(sPhanLoaiTimKiem, sTimKhachHang);
        tbl_KhachHang_b1.setRowCount(0);
        arrKhachHang_b1.forEach((KQ) -> {
            tbl_KhachHang_b1.addRow(new Object[]{KQ.getMakh(), KQ.getTenkh(), KQ.getSodt()});
        });
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btn_refresh_KH = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_khachhang = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_phong = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        txt_ticket_maphieu = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txt_ticket_maphong = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txt_ticket_checkin = new com.toedter.calendar.JDateChooser();
        jLabel20 = new javax.swing.JLabel();
        txt_ticket_checkout = new com.toedter.calendar.JDateChooser();
        txt_info_makh = new javax.swing.JTextField();
        btn_timtheomakhachhang = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_info_tenkh = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btn_timtheotenkhachhang = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_info_diachi = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        rdb_info_Nam = new javax.swing.JRadioButton();
        rdb_Khac = new javax.swing.JRadioButton();
        rdb_info_Nu = new javax.swing.JRadioButton();
        txt_info_cmnd = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_info_sdt = new javax.swing.JTextField();
        txt_timtheoSDT = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btn_themdulieu = new javax.swing.JButton();
        txt_ticket_manhanvien = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1140, 780));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(76, 41, 211));
        jPanel1.setPreferredSize(new java.awt.Dimension(1140, 70));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Century", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Service management");
        jPanel1.add(jLabel1, java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setPreferredSize(new java.awt.Dimension(750, 710));
        jPanel8.setLayout(new java.awt.BorderLayout());

        jPanel3.setPreferredSize(new java.awt.Dimension(750, 305));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(750, 35));
        jPanel5.setLayout(new java.awt.BorderLayout());

        btn_refresh_KH.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_refresh_KH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/refresh_25px.png"))); // NOI18N
        btn_refresh_KH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_refresh_KHMouseClicked(evt);
            }
        });
        jPanel5.add(btn_refresh_KH, java.awt.BorderLayout.LINE_END);

        jLabel21.setFont(new java.awt.Font("Montserrat Medium", 0, 18)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Lựa chọn khách hàng");
        jPanel5.add(jLabel21, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel5, java.awt.BorderLayout.PAGE_START);

        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tb_khachhang.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        tb_khachhang.setModel(new javax.swing.table.DefaultTableModel(
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
        tb_khachhang.setRowHeight(25);
        tb_khachhang.setRowMargin(5);
        tb_khachhang.setSelectionBackground(new java.awt.Color(204, 204, 204));
        tb_khachhang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_khachhangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_khachhang);

        jPanel3.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel8.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jPanel4.setPreferredSize(new java.awt.Dimension(750, 350));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setPreferredSize(new java.awt.Dimension(750, 35));
        jPanel6.setLayout(new java.awt.BorderLayout());

        jLabel23.setFont(new java.awt.Font("Montserrat Medium", 0, 18)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Lựa chọn phòng");
        jPanel6.add(jLabel23, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel6, java.awt.BorderLayout.PAGE_START);

        tb_phong.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        tb_phong.setModel(new javax.swing.table.DefaultTableModel(
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
        tb_phong.setRowHeight(25);
        tb_phong.setRowMargin(5);
        tb_phong.setSelectionBackground(new java.awt.Color(204, 204, 204));
        tb_phong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_phongMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb_phong);

        jPanel4.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel8.add(jPanel4, java.awt.BorderLayout.CENTER);

        add(jPanel8, java.awt.BorderLayout.LINE_START);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel18.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel18.setText("Mã Phiếu:");

        txt_ticket_maphieu.setMargin(new java.awt.Insets(0, 2, 0, 0));
        txt_ticket_maphieu.setPreferredSize(new java.awt.Dimension(250, 25));

        jLabel22.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel22.setText("Mã Phòng:");

        txt_ticket_maphong.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txt_ticket_maphong.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txt_ticket_maphong.setText("Mã Phòng");

        jLabel19.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel19.setText("Ngày Đến:");

        txt_ticket_checkin.setBackground(new java.awt.Color(255, 255, 255));
        txt_ticket_checkin.setDateFormatString("yyyy, MM, dd");

        jLabel20.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel20.setText("Ngày Đi:");

        txt_ticket_checkout.setBackground(new java.awt.Color(255, 255, 255));
        txt_ticket_checkout.setDateFormatString("yyyy, MM, dd");

        txt_info_makh.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        txt_info_makh.setMargin(new java.awt.Insets(0, 2, 0, 0));

        btn_timtheomakhachhang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_timtheomakhachhang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search_dark_26px.png"))); // NOI18N
        btn_timtheomakhachhang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_timtheomakhachhangMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel2.setText("Mã Khách Hàng:");

        txt_info_tenkh.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        txt_info_tenkh.setMargin(new java.awt.Insets(0, 2, 0, 0));
        txt_info_tenkh.setMinimumSize(new java.awt.Dimension(7, 25));
        txt_info_tenkh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_info_tenkhActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel3.setText("Tên Khách Hàng: ");

        btn_timtheotenkhachhang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_timtheotenkhachhang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search_dark_26px.png"))); // NOI18N
        btn_timtheotenkhachhang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_timtheotenkhachhangMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel4.setText("Địa Chỉ:");

        txt_info_diachi.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        txt_info_diachi.setMargin(new java.awt.Insets(0, 2, 0, 0));

        jLabel5.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel5.setText("Giới Tính:");

        rdb_info_Nam.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdb_info_Nam);
        rdb_info_Nam.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        rdb_info_Nam.setLabel("Nam");

        rdb_Khac.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdb_Khac);
        rdb_Khac.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        rdb_Khac.setText("Khác");
        rdb_Khac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_KhacActionPerformed(evt);
            }
        });

        rdb_info_Nu.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdb_info_Nu);
        rdb_info_Nu.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        rdb_info_Nu.setLabel("Nữ");

        txt_info_cmnd.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        txt_info_cmnd.setMargin(new java.awt.Insets(0, 2, 0, 0));

        jLabel6.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel6.setText("CMND/CCCD:");

        txt_info_sdt.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        txt_info_sdt.setMargin(new java.awt.Insets(0, 2, 0, 0));

        txt_timtheoSDT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_timtheoSDT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search_dark_26px.png"))); // NOI18N
        txt_timtheoSDT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_timtheoSDTMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel7.setText("SĐT:");

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

        txt_ticket_manhanvien.setFont(new java.awt.Font("Montserrat", 3, 12)); // NOI18N
        txt_ticket_manhanvien.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txt_ticket_manhanvien.setText("Hiển mã nhân viên");

        jLabel24.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel24.setText("Người thực hiện:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_ticket_checkout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_ticket_maphieu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_ticket_maphong, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_info_makh, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_info_tenkh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_timtheotenkhachhang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_timtheomakhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_info_diachi, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdb_info_Nam, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rdb_info_Nu, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rdb_Khac, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_info_cmnd, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_info_sdt)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_timtheoSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_ticket_checkin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(txt_ticket_manhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_themdulieu, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addGap(0, 0, 0)
                .addComponent(txt_ticket_maphieu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, 0)
                                .addComponent(txt_info_makh, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn_timtheomakhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, 0)
                                .addComponent(txt_info_tenkh, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn_timtheotenkhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(0, 0, 0)
                        .addComponent(txt_info_diachi, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(rdb_info_Nam)
                            .addComponent(rdb_info_Nu)
                            .addComponent(rdb_Khac)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(0, 0, 0)
                .addComponent(txt_info_cmnd, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, 0)
                        .addComponent(txt_info_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_timtheoSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_ticket_maphong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addGap(0, 0, 0)
                .addComponent(txt_ticket_checkin, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addGap(0, 0, 0)
                .addComponent(txt_ticket_checkout, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_themdulieu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txt_ticket_manhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void tb_khachhangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_khachhangMouseClicked
        try {
            int index = tb_khachhang.getSelectedRow();
            TableModel model = tb_khachhang.getModel();
            makh = model.getValueAt(index, 0).toString();
            tenkh = model.getValueAt(index, 1).toString();
            sodt = model.getValueAt(index, 2).toString();
            diachi = DatPhongController.NguonTruyVanDuLieu("DiaChi", "KhachHang", "MaKhachHang", makh);
            gioitinh = DatPhongController.NguonTruyVanDuLieu("GioiTinh", "KhachHang", "MaKhachHang", makh);
            cmnd = DatPhongController.NguonTruyVanDuLieu("CMND", "KhachHang", "MaKhachHang", makh);
            txt_info_makh.setText(makh);
            txt_info_tenkh.setText(tenkh);
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
            java.util.logging.Logger.getLogger(JP_DatPhong1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_tb_khachhangMouseClicked

    private void tb_phongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_phongMouseClicked
        int index = tb_phong.getSelectedRow();
        TableModel model = tb_phong.getModel();
        maPhong = model.getValueAt(index, 0).toString();
        txt_ticket_maphong.setText(maPhong);
    }//GEN-LAST:event_tb_phongMouseClicked

    private void btn_timtheomakhachhangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_timtheomakhachhangMouseClicked
        try {
            sPhanLoaiTimKiem = "MaKhachHang";
            sTimKhachHang = txt_info_makh.getText();
            Buoc1_LayNguonKH();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(JP_DatPhong1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btn_timtheomakhachhangMouseClicked

    private void txt_info_tenkhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_info_tenkhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_info_tenkhActionPerformed

    private void btn_timtheotenkhachhangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_timtheotenkhachhangMouseClicked
        try {
            sPhanLoaiTimKiem = "TenKhachHang";
            sTimKhachHang = txt_info_tenkh.getText();
            Buoc1_LayNguonKH();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(JP_DatPhong1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btn_timtheotenkhachhangMouseClicked

    private void rdb_KhacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_KhacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdb_KhacActionPerformed

    private void txt_timtheoSDTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_timtheoSDTMouseClicked
        try {
            sPhanLoaiTimKiem = "SDT";
            sTimKhachHang = txt_info_sdt.getText();
            Buoc1_LayNguonKH();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(JP_DatPhong1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_txt_timtheoSDTMouseClicked

    private void btn_refresh_KHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_refresh_KHMouseClicked
        
        try {
            sTimMaPhieu = "";
            Buoc1_LayNguonKH();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(JP_DatPhong1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btn_refresh_KHMouseClicked

    private void btn_themdulieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_themdulieuMouseClicked
    }//GEN-LAST:event_btn_themdulieuMouseClicked

    private void btn_themdulieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themdulieuActionPerformed
        try {
            TableModel modelP = tb_phong.getModel();
            maPhong = modelP.getValueAt(tb_phong.getSelectedRow(), 0).toString();
            loaiPhong = modelP.getValueAt(tb_phong.getSelectedRow(), 1).toString();
            makh = txt_info_makh.getText();
            tenkh = txt_info_tenkh.getText();
            sodt = txt_info_sdt.getText();
            diachi = txt_info_diachi.getText();
            if (rdb_info_Nam.isSelected()) {
                gioitinh = "Nam";
            } else if (rdb_info_Nu.isSelected()) {
                gioitinh = "Nữ";
            } else if (rdb_Khac.isSelected()) {
                gioitinh = "Khác";
            }
            cmnd = txt_info_cmnd.getText();
            maPhieuDk = txt_ticket_maphieu.getText();
            maNhanVien = txt_ticket_manhanvien.getText();
            ngayDen = txt_ticket_checkin.getDate();
            ngayDi = txt_ticket_checkout.getDate();
            if (maPhieuDk.isEmpty() || makh.isEmpty() || tenkh.isEmpty() || diachi.isEmpty() || gioitinh.isEmpty() || cmnd.isEmpty() || sodt.isEmpty() || maPhong.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Bạn chưa nhập đầy đủ thông tin!", "Thông Báo", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (DatPhongController.KiemTra("PhieuDatPhong", "MaPhieuDatPhong", maPhieuDk)) {
                JOptionPane.showMessageDialog(this, "Mã phiếu đã tồn tại trong cơ sở dữ liệu.", "Thông Báo", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (ngayDen == null || ngayDi == null || ngayDen.after(ngayDi)) {
                JOptionPane.showMessageDialog(this, "Ngày đến hoặc ngày đi không hợp lệ", "Thông Báo", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Date ngayHienTai = new Date();
            if (txt_ticket_checkin.getDate().before(ngayHienTai)) {
                JOptionPane.showMessageDialog(this, "Ngày đến phải sau ngày hiện tại.", "Thông Báo", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (ngayDen != null && ngayDi != null) {
                try {
                    soNgay = (double) ((ngayDi.getTime() - ngayDen.getTime()) / (24 * 60 * 60 * 1000));
                    giaPhong = DatPhongController.NguonTruyVanDuLieu("GiaPhong", "Phong", "MaPhong", maPhong);
                    
                    tinhTien = String.valueOf(soNgay * Double.parseDouble(giaPhong));
                } catch (IOException ex) {
                    java.util.logging.Logger.getLogger(JP_DatPhong.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            JFrame dialog = new JDiaLog_DatPhong();
            dialog.setVisible(true);
            dialog.setLocationRelativeTo(null);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Thêm phòng thất bại!!!", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }//GEN-LAST:event_btn_themdulieuActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_refresh_KH;
    private javax.swing.JButton btn_themdulieu;
    private javax.swing.JLabel btn_timtheomakhachhang;
    private javax.swing.JLabel btn_timtheotenkhachhang;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rdb_Khac;
    private javax.swing.JRadioButton rdb_info_Nam;
    private javax.swing.JRadioButton rdb_info_Nu;
    private javax.swing.JTable tb_khachhang;
    private javax.swing.JTable tb_phong;
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
    private javax.swing.JLabel txt_timtheoSDT;
    // End of variables declaration//GEN-END:variables

}
