package view;

import controller.DatPhongController;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.tbl_CTPhieuDV;
import model.tbl_CTPhieuSP;
import model.tbl_DichVu;
import model.tbl_HangHoa;
import model.tbl_HoaDon;
import model.tbl_PhieuBonus;

public final class JF_DatPhongB2 extends javax.swing.JFrame {

    DefaultTableModel tbl_DichVu_b2, tbl_SanPham_b2, tbl_ChotDichVu, tbl_ChotSanPham;
    List<tbl_DichVu> arrDichVu_b2 = new ArrayList<>();
    List<tbl_HangHoa> arrSanPham_b2 = new ArrayList<>();
    private String b2_madv, b2_tendv, b2_giadv, b2_masp, b2_tensp, b2_soluongsp, b2_giasp, b2_tongphieu, b2_tiencoc;
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    LocalDate currentDate = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    
    public JF_DatPhongB2() throws IOException {
        initComponents();
        LayNguonDV();
        LayNguonSP();
    }

    public void LayNguonDV() throws IOException {
        tbl_DichVu_b2 = (DefaultTableModel) tb_dichvu.getModel();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        arrDichVu_b2 = DatPhongController.NguonDichVu("");
        tbl_DichVu_b2.setRowCount(0);
        arrDichVu_b2.forEach((KQ) -> {
            tbl_DichVu_b2.addRow(new Object[]{KQ.getMadichvu(), KQ.getTendichvu(), KQ.getGiadichvu()});
        });
    }

    public void LayNguonSP() {
        tbl_SanPham_b2 = (DefaultTableModel) tb_sanpham.getModel();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        arrSanPham_b2 = DatPhongController.NguonSanPham("");
        tbl_SanPham_b2.setRowCount(0);
        arrSanPham_b2.forEach((KQ) -> {
            tbl_SanPham_b2.addRow(new Object[]{KQ.getMahang(), KQ.getTenhang(), KQ.getGiaban(), KQ.getSoluong()});
        });
    }

    private void TinhTongGia(DefaultTableModel bang, JLabel lb_cantinh) {
        Double b2_tongTienSP = 0.0;
        for (int i = 0; i < bang.getRowCount(); i++) {
            if (bang.getValueAt(i, bang.getColumnCount() - 1) != null) {
                String giaTien = bang.getValueAt(i, bang.getColumnCount() - 1).toString();
                double gia = Double.parseDouble(giaTien);
                b2_tongTienSP += gia;
            }
        }
        //String tongTienSP = String.valueOf(b2_tongTienSP);
        lb_cantinh.setText(String.valueOf(b2_tongTienSP));                      // Chuyển đổi kiểu int sang String
        double giadv = Double.parseDouble(lb_b2_tonggiadv.getText());
        double giasp = Double.parseDouble(lb_b2_tonggiasp.getText());
        double tong = giadv + giasp;
        String tongphieu = String.valueOf(tong);
        lb_b2_tongphieudv.setText(tongphieu);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel20 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        btn_b2_loaibodichvu = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tb_chotdichvu = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        txt_b2_tiencoc = new javax.swing.JTextField();
        lb_b2_tonggiadv = new javax.swing.JLabel();
        lb_b2_tonggiasp = new javax.swing.JLabel();
        lb_b2_tongphieudv = new javax.swing.JLabel();
        btn_hoanthanh = new container.Button();
        jPanel8 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        btn_b2_loaibosanpham = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tb_chotsanpham = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_dichvu = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        btn_b2_timkiemdv = new javax.swing.JLabel();
        btn_b2_refreshdv = new javax.swing.JLabel();
        txt_b2_timkiemdv = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        lb_madv = new javax.swing.JLabel();
        lb_tendv = new javax.swing.JLabel();
        lb_giadv = new javax.swing.JLabel();
        btn_themdv = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tb_sanpham = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        btn_refreshsp = new javax.swing.JLabel();
        btn_timkiemdv = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        txt_timkiemsp = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        lb_masp = new javax.swing.JLabel();
        lb_tensp = new javax.swing.JLabel();
        txt_soluongsp = new javax.swing.JTextField();
        btn_themsoluong = new javax.swing.JLabel();
        btn_giamsoluong = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        lb_b2_giasp = new javax.swing.JLabel();
        btn_b2_themsp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel20.setBackground(new java.awt.Color(76, 41, 211));
        jPanel20.setPreferredSize(new java.awt.Dimension(1100, 60));

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1100, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel20, java.awt.BorderLayout.PAGE_START);

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setPreferredSize(new java.awt.Dimension(340, 640));
        jPanel21.setLayout(new java.awt.BorderLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setPreferredSize(new java.awt.Dimension(340, 255));
        jPanel6.setLayout(new java.awt.BorderLayout());

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setPreferredSize(new java.awt.Dimension(340, 30));
        jPanel9.setLayout(new java.awt.BorderLayout());

        btn_b2_loaibodichvu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_b2_loaibodichvu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/trash_25px.png"))); // NOI18N
        btn_b2_loaibodichvu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_b2_loaibodichvuMouseClicked(evt);
            }
        });
        jPanel9.add(btn_b2_loaibodichvu, java.awt.BorderLayout.LINE_END);

        jLabel3.setFont(new java.awt.Font("Montserrat Light", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Dịch Vụ Đã Chọn");
        jPanel9.add(jLabel3, java.awt.BorderLayout.CENTER);

        jPanel6.add(jPanel9, java.awt.BorderLayout.PAGE_START);

        jScrollPane6.setBackground(new java.awt.Color(255, 255, 255));

        tb_chotdichvu.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        tb_chotdichvu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Dịch Vụ", "Giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_chotdichvu.setColumnSelectionAllowed(true);
        tb_chotdichvu.setRowHeight(20);
        tb_chotdichvu.setRowMargin(5);
        tb_chotdichvu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_chotdichvuMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tb_chotdichvu);
        tb_chotdichvu.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tb_chotdichvu.getColumnModel().getColumnCount() > 0) {
            tb_chotdichvu.getColumnModel().getColumn(0).setPreferredWidth(30);
            tb_chotdichvu.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
            tb_chotdichvu.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_chotdichvu.getColumnModel().getColumn(2).setPreferredWidth(20);
        }

        jPanel6.add(jScrollPane6, java.awt.BorderLayout.CENTER);

        jPanel21.add(jPanel6, java.awt.BorderLayout.PAGE_START);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setPreferredSize(new java.awt.Dimension(340, 180));

        jLabel35.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel35.setText("Tổng dịch vụ:");

        jLabel37.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel37.setText("Tổng sản phẩm:");

        jLabel38.setFont(new java.awt.Font("Montserrat Medium", 1, 18)); // NOI18N
        jLabel38.setText("Tổng:");

        jLabel39.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        jLabel39.setText("Tiền cọc:");

        txt_b2_tiencoc.setFont(new java.awt.Font("Montserrat SemiBold", 0, 18)); // NOI18N

        lb_b2_tonggiadv.setFont(new java.awt.Font("Montserrat Medium", 3, 16)); // NOI18N
        lb_b2_tonggiadv.setForeground(new java.awt.Color(255, 0, 0));
        lb_b2_tonggiadv.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_b2_tonggiadv.setText("0");

        lb_b2_tonggiasp.setFont(new java.awt.Font("Montserrat Medium", 3, 16)); // NOI18N
        lb_b2_tonggiasp.setForeground(new java.awt.Color(255, 0, 0));
        lb_b2_tonggiasp.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_b2_tonggiasp.setText("0");

        lb_b2_tongphieudv.setFont(new java.awt.Font("Montserrat Medium", 3, 20)); // NOI18N
        lb_b2_tongphieudv.setForeground(new java.awt.Color(255, 0, 0));
        lb_b2_tongphieudv.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_b2_tongphieudv.setText("0");

        btn_hoanthanh.setText("Hoàn Thành");
        btn_hoanthanh.setBorderColor(new java.awt.Color(0, 0, 255));
        btn_hoanthanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hoanthanhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_b2_tiencoc, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                                    .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lb_b2_tonggiasp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lb_b2_tonggiadv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lb_b2_tongphieudv, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btn_hoanthanh, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(lb_b2_tonggiadv, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_b2_tonggiasp, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_b2_tongphieudv, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jLabel39)
                .addGap(0, 0, 0)
                .addComponent(txt_b2_tiencoc, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(btn_hoanthanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel21.add(jPanel7, java.awt.BorderLayout.PAGE_END);

        jPanel8.setLayout(new java.awt.BorderLayout());

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setPreferredSize(new java.awt.Dimension(340, 30));
        jPanel10.setLayout(new java.awt.BorderLayout());

        btn_b2_loaibosanpham.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_b2_loaibosanpham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/trash_25px.png"))); // NOI18N
        btn_b2_loaibosanpham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_b2_loaibosanphamMouseClicked(evt);
            }
        });
        jPanel10.add(btn_b2_loaibosanpham, java.awt.BorderLayout.LINE_END);

        jLabel4.setFont(new java.awt.Font("Montserrat Light", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Sản Phẩm Đã Chọn");
        jPanel10.add(jLabel4, java.awt.BorderLayout.CENTER);

        jPanel8.add(jPanel10, java.awt.BorderLayout.PAGE_START);

        jScrollPane7.setBackground(new java.awt.Color(255, 255, 255));

        tb_chotsanpham.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        tb_chotsanpham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên", "Số Lượng", "Giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_chotsanpham.setColumnSelectionAllowed(true);
        tb_chotsanpham.setRowHeight(20);
        tb_chotsanpham.setRowMargin(5);
        tb_chotsanpham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_chotsanphamMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tb_chotsanpham);
        tb_chotsanpham.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tb_chotsanpham.getColumnModel().getColumnCount() > 0) {
            tb_chotsanpham.getColumnModel().getColumn(0).setPreferredWidth(30);
            tb_chotsanpham.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_chotsanpham.getColumnModel().getColumn(2).setPreferredWidth(20);
            tb_chotsanpham.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
            tb_chotsanpham.getColumnModel().getColumn(3).setPreferredWidth(20);
            tb_chotsanpham.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        }

        jPanel8.add(jScrollPane7, java.awt.BorderLayout.CENTER);

        jPanel21.add(jPanel8, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel21, java.awt.BorderLayout.LINE_END);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel2.setPreferredSize(new java.awt.Dimension(760, 320));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Montserrat SemiBold", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Lựa chọn dịch vụ");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 30));

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
        tb_dichvu.setRowHeight(22);
        tb_dichvu.setRowMargin(5);
        tb_dichvu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_dichvuMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tb_dichvu);
        if (tb_dichvu.getColumnModel().getColumnCount() > 0) {
            tb_dichvu.getColumnModel().getColumn(0).setPreferredWidth(30);
            tb_dichvu.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
            tb_dichvu.getColumnModel().getColumn(1).setPreferredWidth(150);
            tb_dichvu.getColumnModel().getColumn(2).setPreferredWidth(50);
            tb_dichvu.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        }

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, -1, 290));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        btn_b2_timkiemdv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search_dark_26px.png"))); // NOI18N
        btn_b2_timkiemdv.setText("jLabel14");

        btn_b2_refreshdv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/refresh_25px.png"))); // NOI18N
        btn_b2_refreshdv.setText("jLabel14");

        txt_b2_timkiemdv.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel14.setText("Bộ lọc:");

        jLabel28.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel28.setText("Mã Dịch Vụ:");

        jLabel30.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel30.setText("Tên Dịch Vụ:");

        jLabel34.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel34.setText("Giá:");

        lb_madv.setFont(new java.awt.Font("Montserrat Medium", 1, 14)); // NOI18N
        lb_madv.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        lb_tendv.setFont(new java.awt.Font("Montserrat Medium", 1, 14)); // NOI18N
        lb_tendv.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        lb_giadv.setFont(new java.awt.Font("Montserrat Medium", 3, 16)); // NOI18N
        lb_giadv.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        btn_themdv.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        btn_themdv.setText("Thêm");
        btn_themdv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_themdvMouseClicked(evt);
            }
        });
        btn_themdv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themdvActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txt_b2_timkiemdv, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_b2_timkiemdv, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_b2_refreshdv, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(14, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(lb_tendv, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                                        .addComponent(lb_madv, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(lb_giadv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btn_themdv)))
                        .addGap(23, 23, 23))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel14)
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_b2_timkiemdv, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_b2_timkiemdv)
                    .addComponent(btn_b2_refreshdv))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_madv, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_tendv, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_giadv, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_themdv)
                .addGap(118, 118, 118))
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 290, 300));

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Montserrat SemiBold", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Lựa chọn sản phẩm");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 30));

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
        tb_sanpham.setRowHeight(22);
        tb_sanpham.setRowMargin(5);
        tb_sanpham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_sanphamMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tb_sanpham);
        if (tb_sanpham.getColumnModel().getColumnCount() > 0) {
            tb_sanpham.getColumnModel().getColumn(0).setPreferredWidth(35);
            tb_sanpham.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
            tb_sanpham.getColumnModel().getColumn(1).setPreferredWidth(150);
            tb_sanpham.getColumnModel().getColumn(2).setPreferredWidth(50);
            tb_sanpham.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
            tb_sanpham.getColumnModel().getColumn(3).setPreferredWidth(20);
            tb_sanpham.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        }

        jPanel3.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 34, 450, 330));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        btn_refreshsp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_refreshsp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/refresh_25px.png"))); // NOI18N

        btn_timkiemdv.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_timkiemdv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search_dark_26px.png"))); // NOI18N

        jLabel44.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel44.setText("Mã Sản Phẩm:");

        jLabel36.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel36.setText("Bộ lọc:");

        txt_timkiemsp.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N

        jLabel43.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel43.setText("Tên Sản Phẩm:");

        lb_masp.setFont(new java.awt.Font("Montserrat SemiBold", 1, 14)); // NOI18N
        lb_masp.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        lb_tensp.setFont(new java.awt.Font("Montserrat SemiBold", 1, 14)); // NOI18N
        lb_tensp.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        txt_soluongsp.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        txt_soluongsp.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_soluongsp.setText("1");
        txt_soluongsp.setPreferredSize(new java.awt.Dimension(24, 24));
        txt_soluongsp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_soluongspFocusLost(evt);
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

        jLabel45.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel45.setText("Tên Sản Phẩm:");

        jLabel42.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel42.setText("Giá:");

        lb_b2_giasp.setFont(new java.awt.Font("Montserrat SemiBold", 1, 14)); // NOI18N
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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel45)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_giamsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_soluongsp, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_themsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_b2_giasp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(txt_timkiemsp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_timkiemdv, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_refreshsp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel43))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_tensp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_masp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_b2_themsp)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel36)
                .addGap(0, 0, 0)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_refreshsp, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_timkiemsp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_timkiemdv, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_masp, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_tensp, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_themsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_soluongsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_giamsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_b2_giasp, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_b2_themsp)
                .addContainerGap(142, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 290, 350));

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tb_dichvuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_dichvuMouseClicked
        int index = tb_dichvu.getSelectedRow();
        TableModel model = tb_dichvu.getModel();
        lb_madv.setText(model.getValueAt(index, 0).toString());
        lb_tendv.setText(model.getValueAt(index, 1).toString());
        lb_giadv.setText(model.getValueAt(index, 2).toString());
    }//GEN-LAST:event_tb_dichvuMouseClicked

    private void tb_sanphamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_sanphamMouseClicked
        int index = tb_sanpham.getSelectedRow();
        TableModel model = tb_sanpham.getModel();
        lb_masp.setText(model.getValueAt(index, 0).toString());
        lb_tensp.setText(model.getValueAt(index, 1).toString());
        lb_b2_giasp.setText(model.getValueAt(index, 2).toString());
        txt_soluongsp.setText("1");
    }//GEN-LAST:event_tb_sanphamMouseClicked

    private void btn_themdvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_themdvMouseClicked
        tbl_ChotDichVu = (DefaultTableModel) tb_chotdichvu.getModel();
        b2_madv  = lb_madv.getText();
        b2_tendv = lb_tendv.getText();
        b2_giadv = lb_giadv.getText();
        boolean skiemtra = false;
        // Kiểm tra trùng lặp với cột đầu tiên của bảng
        for (int i = 0; i < tbl_ChotDichVu.getRowCount(); i++) {
            Object value = tbl_ChotDichVu.getValueAt(i, 0);
            if (value != null && value.equals(b2_madv)) {
                skiemtra = true;
                break;
            }
        }
        if (skiemtra) {
            JOptionPane.showMessageDialog(this, "Dịch vụ này đã có, không thể thêm mới", "Thông Báo", JOptionPane.ERROR_MESSAGE);
        } else {
            Object[] row = {b2_madv, b2_tendv, b2_giadv};
            tbl_ChotDichVu.addRow(row);
            TinhTongGia(tbl_ChotDichVu, lb_b2_tonggiadv);
        }
    }//GEN-LAST:event_btn_themdvMouseClicked

    private void btn_themdvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themdvActionPerformed
    }//GEN-LAST:event_btn_themdvActionPerformed

    private void txt_soluongspFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_soluongspFocusLost
        int soLuong = Integer.parseInt(txt_soluongsp.getText());
        if (soLuong < 0) {
            txt_soluongsp.setText("1");
        }
        int soLuongTrongKho = Integer.parseInt(tb_sanpham.getValueAt(tb_sanpham.getSelectedRow(), 3).toString());
        if (soLuong > soLuongTrongKho - 1) {
            JOptionPane.showMessageDialog(null, "Số lượng sản phẩm đã đạt tối đa");
            txt_soluongsp.setText(String.valueOf(soLuongTrongKho));
            return;
        }
    }//GEN-LAST:event_txt_soluongspFocusLost

    private void btn_themsoluongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_themsoluongMouseClicked
        b2_soluongsp = txt_soluongsp.getText();
        int soLuong = Integer.parseInt(b2_soluongsp);
        int soLuongTrongKho = Integer.parseInt(tb_sanpham.getValueAt(tb_sanpham.getSelectedRow(), 3).toString());
        if (soLuong > soLuongTrongKho - 1) {
            JOptionPane.showMessageDialog(null, "Số lượng sản phẩm đã đạt tối đa");
            return;
        }
        soLuong++;
        txt_soluongsp.setText(String.valueOf(soLuong));
        // Lấy giá trị từ cột giá trong bảng
        String gia = tb_sanpham.getValueAt(tb_sanpham.getSelectedRow(), 2).toString();
        // double giaDouble = Double.parseDouble(gia);
        double tongTien = soLuong * Double.parseDouble(gia);
        lb_b2_giasp.setText(String.valueOf(tongTien));
    }//GEN-LAST:event_btn_themsoluongMouseClicked

    private void btn_giamsoluongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_giamsoluongMouseClicked
        b2_soluongsp = txt_soluongsp.getText();
        int soLuong = Integer.parseInt(b2_soluongsp);   // chuyển đổi sang kiểu int
        if (soLuong > 1) {
            soLuong--;
            txt_soluongsp.setText(String.valueOf(soLuong));
            String gia = tb_sanpham.getValueAt(tb_sanpham.getSelectedRow(), 2).toString();
//            double giaDouble = Double.parseDouble(gia);
            double tongTien = soLuong * Double.parseDouble(gia);
            lb_b2_giasp.setText(String.valueOf(tongTien));
        } else {
            JOptionPane.showMessageDialog(this, "Số lượng sản phẩm phải lớn hơn 1", "Thông Báo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_giamsoluongMouseClicked

    private void btn_b2_themspMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_b2_themspMouseClicked
        tbl_ChotSanPham = (DefaultTableModel) tb_chotsanpham.getModel();
        b2_masp = lb_masp.getText();
        b2_tensp = lb_tensp.getText();
        b2_soluongsp = txt_soluongsp.getText();
        b2_giasp = lb_b2_giasp.getText();
        // Kiểm tra trùng mã sản phẩm
        boolean daCoSanPham = false;
        for (int i = 0; i < tbl_ChotSanPham.getRowCount(); i++) {
            Object value = tbl_ChotSanPham.getValueAt(i, 0);
            if (value != null && value.toString().equals(b2_masp)) {
                daCoSanPham = true;
                int soLuongCu = Integer.parseInt(tbl_ChotSanPham.getValueAt(i, 2).toString());
                int soLuongMoi = Integer.parseInt(b2_soluongsp);
                int soLuongTong = soLuongCu + soLuongMoi;
                tbl_ChotSanPham.setValueAt(String.valueOf(soLuongTong), i, 2);
                String giacu = tbl_ChotSanPham.getValueAt(i, 3).toString();
                double giaCu = Double.parseDouble(giacu);
                double giaMoi = Double.parseDouble(b2_giasp);
                double giaTong = giaCu + giaMoi;
                tbl_ChotSanPham.setValueAt(String.valueOf(giaTong), i, 3);
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

    private void btn_b2_themspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_b2_themspActionPerformed
    }//GEN-LAST:event_btn_b2_themspActionPerformed

    private void tb_chotdichvuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_chotdichvuMouseClicked
    }//GEN-LAST:event_tb_chotdichvuMouseClicked

    private void tb_chotsanphamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_chotsanphamMouseClicked
    }//GEN-LAST:event_tb_chotsanphamMouseClicked

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
        int row = tb_chotsanpham.getSelectedRow();
        if (row != -1) {
            tbl_ChotSanPham.removeRow(row);
        }
        TinhTongGia(tbl_ChotSanPham, lb_b2_tonggiasp);
    }//GEN-LAST:event_btn_b2_loaibosanphamMouseClicked

    private void btn_hoanthanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hoanthanhActionPerformed
        try {
            b2_giadv = lb_giadv.getText();
            b2_giasp = lb_b2_giasp.getText();
            if (b2_giadv.isEmpty()) {
                b2_giadv = "0";
            }

            if (b2_giasp.isEmpty()) {
                b2_giasp = "0";
            }
            tbl_PhieuBonus cndv = new tbl_PhieuBonus("", JP_DatPhong.maPhieuDk, b2_giadv);
            DatPhongController.ThemPhieuBonus(cndv, "MaPhieuDichVu", "PhieuDichVu", "PDV");
            tbl_PhieuBonus cnsp = new tbl_PhieuBonus("", JP_DatPhong.maPhieuDk, b2_giasp);
            DatPhongController.ThemPhieuBonus(cnsp, "MaPhieuSanPham", "PhieuSanPham", "PSP");

            for (int i = 0; i < tb_chotdichvu.getRowCount(); i++) {
                b2_madv = tb_chotdichvu.getValueAt(i, 0).toString();
                b2_giadv = tb_chotdichvu.getValueAt(i, 2).toString();
                tbl_CTPhieuDV cnCTPDV = new tbl_CTPhieuDV("", "", b2_madv, b2_giadv);
                DatPhongController.ThemCTPhieuDichVu(cnCTPDV);
            }

            for (int i = 0; i < tb_chotsanpham.getRowCount(); i++) {
                b2_masp = tb_chotsanpham.getValueAt(i, 0).toString();
                b2_soluongsp = tb_chotsanpham.getValueAt(i, 2).toString();
                b2_giasp = tb_chotsanpham.getValueAt(i, 3).toString();
                tbl_CTPhieuSP cnCTPSP = new tbl_CTPhieuSP("", "", b2_masp, b2_soluongsp, b2_giasp);
                DatPhongController.ThemCTPhieuSanPham(cnCTPSP);
            }
            double tongdv = Double.parseDouble(lb_b2_tonggiadv.getText());
            double tongphong = Double.parseDouble(JP_DatPhong.tinhTien);
            double tongsp = Double.parseDouble(lb_b2_tonggiasp.getText());

            b2_tongphieu = String.valueOf(tongphong + tongsp + tongdv);
            
            String ngayHienTai = currentDate.format(formatter);
            b2_tiencoc = txt_b2_tiencoc.getText();
            if (b2_tiencoc.isEmpty()) {
                b2_tiencoc = "0";
            }
            tbl_HoaDon cnhd = new tbl_HoaDon("", JP_DatPhong.maPhieuDk, "", "", ngayHienTai, b2_tongphieu, b2_tiencoc);
            DatPhongController.ThemHoaDon(cnhd);
            JOptionPane.showMessageDialog(this, "Đặt phòng Thành Công!", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
            dispose();
            JFrame jf_Main = new Home();
            jf_Main.setLocationRelativeTo(null);
            jf_Main.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(JF_DatPhongB2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_hoanthanhActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new JF_DatPhongB2().setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(JF_DatPhongB2.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_b2_loaibodichvu;
    private javax.swing.JLabel btn_b2_loaibosanpham;
    private javax.swing.JLabel btn_b2_refreshdv;
    private javax.swing.JButton btn_b2_themsp;
    private javax.swing.JLabel btn_b2_timkiemdv;
    private javax.swing.JLabel btn_giamsoluong;
    private container.Button btn_hoanthanh;
    private javax.swing.JLabel btn_refreshsp;
    private javax.swing.JButton btn_themdv;
    private javax.swing.JLabel btn_themsoluong;
    private javax.swing.JLabel btn_timkiemdv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLabel lb_b2_giasp;
    private javax.swing.JLabel lb_b2_tonggiadv;
    private javax.swing.JLabel lb_b2_tonggiasp;
    private javax.swing.JLabel lb_b2_tongphieudv;
    private javax.swing.JLabel lb_giadv;
    private javax.swing.JLabel lb_madv;
    private javax.swing.JLabel lb_masp;
    private javax.swing.JLabel lb_tendv;
    private javax.swing.JLabel lb_tensp;
    private javax.swing.JTable tb_chotdichvu;
    private javax.swing.JTable tb_chotsanpham;
    private javax.swing.JTable tb_dichvu;
    private javax.swing.JTable tb_sanpham;
    private javax.swing.JTextField txt_b2_tiencoc;
    private javax.swing.JTextField txt_b2_timkiemdv;
    private javax.swing.JTextField txt_soluongsp;
    private javax.swing.JTextField txt_timkiemsp;
    // End of variables declaration//GEN-END:variables
}
