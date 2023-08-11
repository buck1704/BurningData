package view;

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

    public JF_DatPhongB2() throws IOException {
        initComponents();
        Buoc2_LayNguonDV();
        Buoc2_LayNguonSP();

    }

    public void Buoc2_LayNguonDV() throws IOException {
        tbl_DichVu_b2 = (DefaultTableModel) tb_dichvu.getModel();
        arrDichVu_b2 = DatPhongController.NguonDichVu("");
        tbl_DichVu_b2.setRowCount(0);
        arrDichVu_b2.forEach((KQ) -> {
            tbl_DichVu_b2.addRow(new Object[]{KQ.getMadichvu(), KQ.getTendichvu(), KQ.getGiadichvu()});
        });
    }

    public void Buoc2_LayNguonSP() {
        tbl_SanPham_b2 = (DefaultTableModel) tb_sanpham.getModel();
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
        String tongTienSP = String.valueOf(b2_tongTienSP);
        lb_cantinh.setText(tongTienSP);                      // Chuyển đổi kiểu int sang String

        double giadv = Double.parseDouble(lb_b2_tonggiadv.getText());
        double giasp = Double.parseDouble(lb_b2_tonggiasp.getText());

        double tong = giadv + giasp;
        String tongphieu = String.valueOf(tong);
        lb_b2_tongphieudv.setText(tongphieu);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        btn_b2_loaibodichvu = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tb_chotdichvu = new javax.swing.JTable();
        jPanel16 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        lb_b2_tonggiadv = new javax.swing.JLabel();
        lb_b2_tonggiasp = new javax.swing.JLabel();
        lb_b2_tongphieudv = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        txt_b2_tiencoc = new javax.swing.JTextField();
        btn_hoanthanh = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        btn_b2_loaibosanpham = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tb_chotsanpham = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txt_b2_timkiemdv = new javax.swing.JTextField();
        btn_b2_timkiemdv = new javax.swing.JLabel();
        btn_b2_refreshdv = new javax.swing.JLabel();
        lb_b2_madv = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        lb_b2_tendv = new javax.swing.JLabel();
        lb_b2_giadv = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        btn_b2_themdv = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_dichvu = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        txt_timkiemsp = new javax.swing.JTextField();
        btn_timkiemdv = new javax.swing.JLabel();
        btn_refreshsp = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        lb_b2_masp = new javax.swing.JLabel();
        lb_b2_tensp = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        btn_themsoluong = new javax.swing.JLabel();
        txt_b2_soluongsp = new javax.swing.JTextField();
        btn_giamsoluong = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        lb_b2_giasp = new javax.swing.JLabel();
        btn_b2_themsp = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tb_sanpham = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(76, 41, 211));
        jPanel4.setPreferredSize(new java.awt.Dimension(1400, 80));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1329, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel6.setPreferredSize(new java.awt.Dimension(450, 680));
        jPanel6.setLayout(new java.awt.BorderLayout());

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setPreferredSize(new java.awt.Dimension(448, 240));
        jPanel15.setLayout(new java.awt.BorderLayout());

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setPreferredSize(new java.awt.Dimension(448, 25));
        jPanel18.setLayout(new java.awt.BorderLayout());

        btn_b2_loaibodichvu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_b2_loaibodichvu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/trash_25px.png"))); // NOI18N
        btn_b2_loaibodichvu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_b2_loaibodichvuMouseClicked(evt);
            }
        });
        jPanel18.add(btn_b2_loaibodichvu, java.awt.BorderLayout.LINE_END);

        jLabel29.setBackground(new java.awt.Color(255, 255, 255));
        jLabel29.setFont(new java.awt.Font("Montserrat SemiBold", 0, 16)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Dịch Vụ Đã Chọn");
        jPanel18.add(jLabel29, java.awt.BorderLayout.CENTER);

        jPanel15.add(jPanel18, java.awt.BorderLayout.PAGE_START);

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
        tb_chotdichvu.setRowHeight(20);
        tb_chotdichvu.setRowMargin(5);
        tb_chotdichvu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_chotdichvuMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tb_chotdichvu);

        jPanel15.add(jScrollPane6, java.awt.BorderLayout.CENTER);

        jPanel6.add(jPanel15, java.awt.BorderLayout.PAGE_START);

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setPreferredSize(new java.awt.Dimension(448, 200));

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

        lb_b2_tongphieudv.setFont(new java.awt.Font("Montserrat Medium", 3, 20)); // NOI18N
        lb_b2_tongphieudv.setForeground(new java.awt.Color(255, 0, 0));
        lb_b2_tongphieudv.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_b2_tongphieudv.setText("0");

        jLabel37.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel37.setText("Tổng sản phẩm:");

        jLabel38.setFont(new java.awt.Font("Montserrat Medium", 1, 18)); // NOI18N
        jLabel38.setText("Tổng:");

        jLabel39.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        jLabel39.setText("Tiền cọc:");

        txt_b2_tiencoc.setFont(new java.awt.Font("Montserrat SemiBold", 0, 18)); // NOI18N

        btn_hoanthanh.setText("Hoàn Thành");
        btn_hoanthanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hoanthanhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                            .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(120, 120, 120)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_b2_tonggiasp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_b2_tonggiadv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_b2_tongphieudv, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_hoanthanh))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_b2_tiencoc, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_b2_tonggiadv, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_b2_tonggiasp, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_b2_tongphieudv, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jLabel39)
                .addGap(0, 0, 0)
                .addComponent(txt_b2_tiencoc, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_hoanthanh)
                .addGap(18, 18, 18))
        );

        jPanel6.add(jPanel16, java.awt.BorderLayout.PAGE_END);

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setLayout(new java.awt.BorderLayout());

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setPreferredSize(new java.awt.Dimension(448, 30));
        jPanel19.setLayout(new java.awt.BorderLayout());

        btn_b2_loaibosanpham.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_b2_loaibosanpham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/trash_25px.png"))); // NOI18N
        btn_b2_loaibosanpham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_b2_loaibosanphamMouseClicked(evt);
            }
        });
        jPanel19.add(btn_b2_loaibosanpham, java.awt.BorderLayout.LINE_END);

        jLabel33.setFont(new java.awt.Font("Montserrat SemiBold", 0, 16)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Sản Phẩm Đã Chọn");
        jPanel19.add(jLabel33, java.awt.BorderLayout.CENTER);

        jPanel17.add(jPanel19, java.awt.BorderLayout.PAGE_START);

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
        tb_chotsanpham.setRowHeight(20);
        tb_chotsanpham.setRowMargin(5);
        tb_chotsanpham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_chotsanphamMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tb_chotsanpham);

        jPanel17.add(jScrollPane7, java.awt.BorderLayout.CENTER);

        jPanel6.add(jPanel17, java.awt.BorderLayout.CENTER);

        jPanel5.add(jPanel6, java.awt.BorderLayout.LINE_END);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel2.setPreferredSize(new java.awt.Dimension(950, 340));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setPreferredSize(new java.awt.Dimension(300, 338));

        jLabel14.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel14.setText("Bộ lọc:");

        txt_b2_timkiemdv.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N

        btn_b2_timkiemdv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search_dark_26px.png"))); // NOI18N
        btn_b2_timkiemdv.setText("jLabel14");

        btn_b2_refreshdv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/refresh_25px.png"))); // NOI18N
        btn_b2_refreshdv.setText("jLabel14");

        lb_b2_madv.setFont(new java.awt.Font("Montserrat Medium", 1, 14)); // NOI18N
        lb_b2_madv.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel28.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel28.setText("Mã Dịch Vụ:");

        jLabel30.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel30.setText("Tên Dịch Vụ:");

        lb_b2_tendv.setFont(new java.awt.Font("Montserrat Medium", 1, 14)); // NOI18N
        lb_b2_tendv.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        lb_b2_giadv.setFont(new java.awt.Font("Montserrat Medium", 3, 16)); // NOI18N
        lb_b2_giadv.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel34.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel34.setText("Giá:");

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

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_b2_tendv, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                            .addComponent(lb_b2_giadv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_b2_madv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_b2_themdv)
                        .addGap(12, 12, 12))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                            .addComponent(txt_b2_timkiemdv))
                        .addGap(57, 57, 57)
                        .addComponent(btn_b2_timkiemdv, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btn_b2_refreshdv, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel14)
                .addGap(0, 0, 0)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_b2_timkiemdv, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_b2_timkiemdv)
                    .addComponent(btn_b2_refreshdv))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_b2_madv, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_b2_tendv, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_b2_giadv, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_b2_themdv)
                .addGap(118, 118, 118))
        );

        jPanel2.add(jPanel7, java.awt.BorderLayout.LINE_END);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new java.awt.BorderLayout());

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setPreferredSize(new java.awt.Dimension(648, 30));
        jPanel11.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Montserrat SemiBold", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Lựa chọn dịch vụ");
        jPanel11.add(jLabel1, java.awt.BorderLayout.CENTER);

        jPanel8.add(jPanel11, java.awt.BorderLayout.PAGE_START);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setLayout(new java.awt.BorderLayout());

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

        jPanel12.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        jPanel8.add(jPanel12, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel8, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setPreferredSize(new java.awt.Dimension(300, 338));

        txt_timkiemsp.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N

        btn_timkiemdv.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_timkiemdv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search_dark_26px.png"))); // NOI18N

        btn_refreshsp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_refreshsp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/refresh_25px.png"))); // NOI18N

        jLabel36.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel36.setText("Bộ lọc:");

        jLabel44.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel44.setText("Mã Sản Phẩm:");

        lb_b2_masp.setFont(new java.awt.Font("Montserrat SemiBold", 1, 14)); // NOI18N
        lb_b2_masp.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        lb_b2_tensp.setFont(new java.awt.Font("Montserrat SemiBold", 1, 14)); // NOI18N
        lb_b2_tensp.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel43.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel43.setText("Tên Sản Phẩm:");

        btn_themsoluong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_themsoluong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/sum_25px.png"))); // NOI18N
        btn_themsoluong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_themsoluongMouseClicked(evt);
            }
        });

        txt_b2_soluongsp.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        txt_b2_soluongsp.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_b2_soluongsp.setText("1");
        txt_b2_soluongsp.setPreferredSize(new java.awt.Dimension(24, 24));
        txt_b2_soluongsp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_b2_soluongspFocusLost(evt);
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

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel45)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_giamsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_b2_soluongsp, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_themsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_b2_themsp)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_b2_giasp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel43))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lb_b2_masp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lb_b2_tensp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(txt_timkiemsp, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(btn_timkiemdv, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_refreshsp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(19, 19, 19))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel36)
                .addGap(0, 0, 0)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_timkiemsp, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_timkiemdv)
                    .addComponent(btn_refreshsp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_b2_masp, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_b2_tensp, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_themsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_b2_soluongsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_giamsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_b2_giasp, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(btn_b2_themsp)
                .addContainerGap(225, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel9, java.awt.BorderLayout.LINE_END);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new java.awt.BorderLayout());

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setPreferredSize(new java.awt.Dimension(648, 30));
        jPanel13.setLayout(new java.awt.BorderLayout());

        jLabel2.setFont(new java.awt.Font("Montserrat SemiBold", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Lựa chọn sản phẩm");
        jPanel13.add(jLabel2, java.awt.BorderLayout.CENTER);

        jPanel10.add(jPanel13, java.awt.BorderLayout.PAGE_START);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setLayout(new java.awt.BorderLayout());

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

        jPanel14.add(jScrollPane4, java.awt.BorderLayout.CENTER);

        jPanel10.add(jPanel14, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel10, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel5.add(jPanel1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel5, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tb_sanphamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_sanphamMouseClicked
        int index = tb_sanpham.getSelectedRow();
        TableModel model = tb_sanpham.getModel();
        lb_b2_masp.setText(model.getValueAt(index, 0).toString());
        lb_b2_tensp.setText(model.getValueAt(index, 1).toString());
        txt_b2_soluongsp.setText("1");
        lb_b2_giasp.setText(model.getValueAt(index, 2).toString());
    }//GEN-LAST:event_tb_sanphamMouseClicked

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

    private void btn_b2_themdvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_b2_themdvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_b2_themdvActionPerformed

    private void btn_themsoluongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_themsoluongMouseClicked
        b2_soluongsp = txt_b2_soluongsp.getText();
        int soLuong = Integer.parseInt(b2_soluongsp);
        int soLuongTrongKho = Integer.parseInt(tb_sanpham.getValueAt(tb_sanpham.getSelectedRow(), 3).toString());
        if (soLuong > soLuongTrongKho - 1) {
            JOptionPane.showMessageDialog(null, "Số lượng sản phẩm đã đạt tối đa");
            return;
        }
        soLuong++;
        txt_b2_soluongsp.setText(String.valueOf(soLuong));
        // Lấy giá trị từ cột giá trong bảng
        String gia = tb_sanpham.getValueAt(tb_sanpham.getSelectedRow(), 2).toString();
        double giaDouble = Double.parseDouble(gia);
        double tongTien = soLuong * giaDouble;
        lb_b2_giasp.setText(String.valueOf(tongTien));
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

    private void btn_giamsoluongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_giamsoluongMouseClicked
        b2_soluongsp = txt_b2_soluongsp.getText();
        int soLuong = Integer.parseInt(b2_soluongsp);   // chuyển đổi sang kiểu int
        if (soLuong > 1) {
            soLuong--;
            txt_b2_soluongsp.setText(String.valueOf(soLuong));
            String gia = tb_sanpham.getValueAt(tb_sanpham.getSelectedRow(), 2).toString();
            double giaDouble = Double.parseDouble(gia);
            double tongTien = soLuong * giaDouble;
            lb_b2_giasp.setText(String.valueOf(tongTien));
        } else {
            JOptionPane.showMessageDialog(this, "Số lượng sản phẩm phải lớn hơn 1", "Thông Báo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_giamsoluongMouseClicked

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
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_b2_themspActionPerformed

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

    private void tb_chotdichvuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_chotdichvuMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tb_chotdichvuMouseClicked

    private void tb_chotsanphamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_chotsanphamMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tb_chotsanphamMouseClicked

    private void btn_hoanthanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hoanthanhActionPerformed
        try {
            b2_giadv = lb_b2_giadv.getText();
            b2_giasp = lb_b2_giasp.getText();
            if (b2_giadv.isEmpty()) {
                b2_giadv = "0";
            }

            if (b2_giasp.isEmpty()) {
                b2_giasp = "0";
            }
            tbl_PhieuBonus cndv = new tbl_PhieuBonus("", JP_DatPhong1.maPhieuDk, b2_giadv);
            DatPhongController.ThemPhieuBonus(cndv, "MaPhieuDichVu", "PhieuDichVu", "PDV");
            tbl_PhieuBonus cnsp = new tbl_PhieuBonus("", JP_DatPhong1.maPhieuDk, b2_giasp);
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
            double tongphong = Double.parseDouble(JP_DatPhong1.tinhTien);
            double tongsp = Double.parseDouble(lb_b2_tonggiasp.getText());

            b2_tongphieu = String.valueOf(tongphong + tongsp + tongdv);
            LocalDate currentDate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String ngayHienTai = currentDate.format(formatter);
            b2_tiencoc = txt_b2_tiencoc.getText();
            if (b2_tiencoc.isEmpty()) {
                b2_tiencoc = "0";
            }
            tbl_HoaDon cnhd = new tbl_HoaDon("", JP_DatPhong1.maPhieuDk, "", "", ngayHienTai, b2_tongphieu, b2_tiencoc);
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

    private void tb_dichvuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_dichvuMouseClicked
        int index = tb_dichvu.getSelectedRow();
        TableModel model = tb_dichvu.getModel();
        lb_b2_madv.setText(model.getValueAt(index, 0).toString());
        lb_b2_tendv.setText(model.getValueAt(index, 1).toString());
        lb_b2_giadv.setText(model.getValueAt(index, 2).toString());
    }//GEN-LAST:event_tb_dichvuMouseClicked

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
    private javax.swing.JButton btn_b2_themdv;
    private javax.swing.JButton btn_b2_themsp;
    private javax.swing.JLabel btn_b2_timkiemdv;
    private javax.swing.JLabel btn_giamsoluong;
    private javax.swing.JButton btn_hoanthanh;
    private javax.swing.JLabel btn_refreshsp;
    private javax.swing.JLabel btn_themsoluong;
    private javax.swing.JLabel btn_timkiemdv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
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
    private javax.swing.JLabel lb_b2_giadv;
    private javax.swing.JLabel lb_b2_giasp;
    private javax.swing.JLabel lb_b2_madv;
    private javax.swing.JLabel lb_b2_masp;
    private javax.swing.JLabel lb_b2_tendv;
    private javax.swing.JLabel lb_b2_tensp;
    private javax.swing.JLabel lb_b2_tonggiadv;
    private javax.swing.JLabel lb_b2_tonggiasp;
    private javax.swing.JLabel lb_b2_tongphieudv;
    private javax.swing.JTable tb_chotdichvu;
    private javax.swing.JTable tb_chotsanpham;
    private javax.swing.JTable tb_dichvu;
    private javax.swing.JTable tb_sanpham;
    private javax.swing.JTextField txt_b2_soluongsp;
    private javax.swing.JTextField txt_b2_tiencoc;
    private javax.swing.JTextField txt_b2_timkiemdv;
    private javax.swing.JTextField txt_timkiemsp;
    // End of variables declaration//GEN-END:variables
}
