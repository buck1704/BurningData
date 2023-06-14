package view;
import controller.QuanLyController;
import model.tbl_Phong;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import controller.QuanLyKhachSanController;
import java.awt.Color;
import java.awt.Component;
import java.util.logging.Level;
import java.util.logging.Logger;
public final class JP_Phong extends javax.swing.JPanel {
    
    DefaultTableModel tbl_Phong;
    ArrayList<tbl_Phong> arrPhong = new ArrayList<>();
    private static boolean ktThem;
    private static String macu;
    private static String maPhong, loaiPhong,sogiuong, sophong, giaPhong, tinhTrang, moTa;
    
    public JP_Phong() throws IOException {
        initComponents();
        LayNguon();
    }
    
    public void LayNguon() throws IOException {
        tbl_Phong = (DefaultTableModel) tb_Phong.getModel();
        arrPhong = QuanLyController.NguonPhong();
        tbl_Phong.setRowCount(0);
        arrPhong.forEach((KQ) -> {
            tbl_Phong.addRow(new Object[]{KQ.getMaPhong(), KQ.getLoaiPhong(),KQ.getSoGiuong(), KQ.getSoPhong(), KQ.getGiaPhong(), KQ.getTinhTrang(), KQ.getMoTa()});
        });
    }
    
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (value.equals("Trống")) {
                c.setBackground(new Color( 102, 255, 102));
            } else {
                c.setBackground(table.getBackground());
            }
            return c;
        }
    };
    
    public void KhoaMo(boolean b) {
        txt_maphong.setEditable(b);
        cbb_loaiphong.setEditable(b);
        txt_sogiuong.setEditable(b);
        txt_sophong.setEditable(b);
        txt_giaphong.setEditable(b);
        bt_them.setEnabled(!b);
        bt_sua.setEnabled(!b);
        bt_xoa.setEnabled(!b);
        bt_ghi.setEnabled(b);
        bt_khong.setEnabled(b);
        tb_Phong.setEnabled(!b);
    }

    public void refresh(boolean b) {
        txt_maphong.setEditable(b);
        cbb_loaiphong.setEditable(b);
        txt_sogiuong.setEditable(b);
        txt_sophong.setEditable(b);
        txt_giaphong.setEditable(b);
        rdb_Empty.setSelected(false);
        rdb_Full.setSelected(false);
        bt_them.setEnabled(b);
        bt_sua.setEnabled(b);
        bt_xoa.setEnabled(b);
        bt_ghi.setEnabled(b);
        bt_khong.setEnabled(b);
        tb_Phong.setEnabled(b);
    }

    public void XoaTrang() {
        txt_maphong.setText("");
        cbb_loaiphong.setSelectedIndex(0);
        txt_sogiuong.setText("");
        txt_sophong.setText("");
        txt_giaphong.setText("");
        rdb_Empty.setSelected(false);
        rdb_Full.setSelected(false);
        txt_mota.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        txt_timkiem2 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_maphong = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbb_loaiphong = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txt_sogiuong = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_sophong = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_giaphong = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        rdb_Full = new javax.swing.JRadioButton();
        rdb_Empty = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_mota = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        bt_them = new javax.swing.JButton();
        bt_sua = new javax.swing.JButton();
        bt_xoa = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        bt_ghi = new javax.swing.JButton();
        bt_khong = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_Phong = new javax.swing.JTable();

        setMinimumSize(new java.awt.Dimension(1140, 780));
        setPreferredSize(new java.awt.Dimension(1140, 780));
        setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(76, 41, 211));
        jPanel4.setPreferredSize(new java.awt.Dimension(1140, 70));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel8.setBackground(new java.awt.Color(76, 41, 211));
        jPanel8.setPreferredSize(new java.awt.Dimension(300, 70));
        jPanel8.setRequestFocusEnabled(false);
        jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.TRAILING, 10, 20));

        txt_timkiem2.setBackground(new java.awt.Color(123, 156, 225));
        txt_timkiem2.setBorder(null);
        txt_timkiem2.setPreferredSize(new java.awt.Dimension(200, 20));
        jPanel8.add(txt_timkiem2);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search_25px.png"))); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jPanel8.add(jLabel11);

        jPanel4.add(jPanel8, java.awt.BorderLayout.LINE_END);

        jLabel8.setFont(new java.awt.Font("Century Schoolbook", 1, 30)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Room manager");
        jPanel4.add(jLabel8, java.awt.BorderLayout.CENTER);

        add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setPreferredSize(new java.awt.Dimension(400, 700));
        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 20));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Chi Tiết", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Montserrat", 0, 11))); // NOI18N
        jPanel2.setPreferredSize(new java.awt.Dimension(360, 422));

        jLabel2.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel2.setText("Mã Phòng:");

        txt_maphong.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        txt_maphong.setMargin(new java.awt.Insets(0, 2, 0, 0));
        txt_maphong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_maphongActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel4.setText("Loại Phòng:");

        cbb_loaiphong.setBackground(new java.awt.Color(255, 255, 255));
        cbb_loaiphong.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        cbb_loaiphong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Phòng Thường", "Phòng Cao cấp", "Phòng VIP" }));

        jLabel9.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel9.setText("Số Giường:");

        txt_sogiuong.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel10.setText("Số Phòng:");

        txt_sophong.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel5.setText("Giá Phòng:");

        txt_giaphong.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel7.setText("Tình Trạng:");

        rdb_Full.setBackground(new java.awt.Color(255, 255, 255));
        rdb_Full.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        rdb_Full.setText("Full");
        rdb_Full.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_FullActionPerformed(evt);
            }
        });

        rdb_Empty.setBackground(new java.awt.Color(255, 255, 255));
        rdb_Empty.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        rdb_Empty.setText("Empty");

        jLabel6.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel6.setText("Mô Tả:");

        txt_mota.setColumns(20);
        txt_mota.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        txt_mota.setRows(5);
        jScrollPane2.setViewportView(txt_mota);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdb_Full, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rdb_Empty, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                            .addComponent(txt_giaphong)
                            .addComponent(txt_sophong, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_sogiuong, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_maphong, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbb_loaiphong, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(0, 0, 0)
                .addComponent(txt_maphong, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(0, 0, 0)
                .addComponent(cbb_loaiphong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGap(0, 0, 0)
                .addComponent(txt_sogiuong, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addGap(0, 0, 0)
                .addComponent(txt_sophong, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addGap(0, 0, 0)
                .addComponent(txt_giaphong, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(rdb_Full)
                    .addComponent(rdb_Empty))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.add(jPanel2);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Cập Nhật"), "Cập Nhật", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Montserrat", 0, 11))); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(360, 61));

        bt_them.setBackground(new java.awt.Color(255, 255, 255));
        bt_them.setFont(new java.awt.Font("Montserrat Medium", 1, 12)); // NOI18N
        bt_them.setText("Thêm");
        bt_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_themActionPerformed(evt);
            }
        });

        bt_sua.setBackground(new java.awt.Color(255, 255, 255));
        bt_sua.setFont(new java.awt.Font("Montserrat Medium", 1, 12)); // NOI18N
        bt_sua.setText("Sửa");
        bt_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_suaActionPerformed(evt);
            }
        });

        bt_xoa.setBackground(new java.awt.Color(255, 255, 255));
        bt_xoa.setFont(new java.awt.Font("Montserrat Medium", 1, 12)); // NOI18N
        bt_xoa.setText("Xoá");
        bt_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_xoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(bt_them, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(bt_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(bt_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_them)
                    .addComponent(bt_sua)
                    .addComponent(bt_xoa))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        jPanel7.add(jPanel1);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Điều Khiển", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Montserrat", 0, 11))); // NOI18N
        jPanel3.setPreferredSize(new java.awt.Dimension(360, 60));

        bt_ghi.setBackground(new java.awt.Color(255, 255, 255));
        bt_ghi.setFont(new java.awt.Font("Montserrat Medium", 1, 12)); // NOI18N
        bt_ghi.setText("Ghi");
        bt_ghi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ghiActionPerformed(evt);
            }
        });

        bt_khong.setBackground(new java.awt.Color(255, 255, 255));
        bt_khong.setFont(new java.awt.Font("Montserrat Medium", 1, 12)); // NOI18N
        bt_khong.setText("Không");
        bt_khong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_khongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(bt_ghi, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(bt_khong, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_ghi)
                    .addComponent(bt_khong))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel7.add(jPanel3);

        add(jPanel7, java.awt.BorderLayout.LINE_START);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        tb_Phong.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        tb_Phong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Loại Phòng", "Số Giường", "Số Buồng", "Giá Phòng", "Tình Trạng", "Mô Tả"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_Phong.setGridColor(new java.awt.Color(0, 0, 0));
        tb_Phong.setRowHeight(25);
        tb_Phong.setRowMargin(5);
        tb_Phong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_PhongMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_Phong);
        if (tb_Phong.getColumnModel().getColumnCount() > 0) {
            tb_Phong.getColumnModel().getColumn(0).setPreferredWidth(25);
            tb_Phong.getColumnModel().getColumn(1).setPreferredWidth(75);
            tb_Phong.getColumnModel().getColumn(2).setPreferredWidth(25);
            tb_Phong.getColumnModel().getColumn(3).setPreferredWidth(25);
            tb_Phong.getColumnModel().getColumn(4).setPreferredWidth(25);
            tb_Phong.getColumnModel().getColumn(5).setPreferredWidth(25);
            tb_Phong.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
            tb_Phong.getColumnModel().getColumn(6).setPreferredWidth(200);
        }

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 716, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel10, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked

    }//GEN-LAST:event_jLabel11MouseClicked

    private void txt_maphongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_maphongActionPerformed

    }//GEN-LAST:event_txt_maphongActionPerformed

    private void rdb_FullActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_FullActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdb_FullActionPerformed

    private void bt_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_themActionPerformed
        ktThem = true;
        macu = "";
        KhoaMo(true);
        XoaTrang();
        txt_maphong.requestFocus();
    }//GEN-LAST:event_bt_themActionPerformed

    private void bt_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_suaActionPerformed
        if (txt_maphong.getText().length() <= 0) {
            return;
        }
        macu = txt_maphong.getText();
        ktThem = false;
        KhoaMo(true);
        txt_maphong.requestFocus();
    }//GEN-LAST:event_bt_suaActionPerformed

    private void bt_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_xoaActionPerformed
        if (txt_maphong.getText().length() <= 0) {
            JOptionPane.showConfirmDialog(this, "Hãy nhập thông tin cần xoá!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        macu = txt_maphong.getText();
        for (int i = 0; i < arrPhong.size(); i++) {
            if (arrPhong.get(i).getMaPhong().equals(macu)) {
                int kq = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa Phòng này không?", "Thông Báo", JOptionPane.YES_NO_OPTION);
                if (kq == JOptionPane.YES_OPTION) {
                    QuanLyController.XoaPhong(macu);
                    XoaTrang();
                    try {
                        LayNguon();
                    } catch (IOException ex) {
                        Logger.getLogger(JP_KhachHang.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                return;
            }
        }
    }//GEN-LAST:event_bt_xoaActionPerformed

    private void bt_ghiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ghiActionPerformed
        if (txt_maphong.getText().length() <= 0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập mã phòng.", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            txt_maphong.requestFocus();
            return;
        }
        if (cbb_loaiphong.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn loại phòng.", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            cbb_loaiphong.requestFocus();
            return;
        }
        if (txt_giaphong.getText().length() <= 0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập giá phòng.", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            txt_giaphong.requestFocus();
            return;
        }
        if (!rdb_Empty.isSelected() && !rdb_Full.isSelected()) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn tình trạng hiện tại của phòng.", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (QuanLyKhachSanController.KiemTraTrungMa("Phong", "MaPhong", txt_maphong.getText(), ktThem, macu) == true) {
            JOptionPane.showMessageDialog(this, "Mã ngành đã tồn tại trong cơ sở dữ liệu.", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            txt_maphong.requestFocus();
            return;
        }
        maPhong = txt_maphong.getText();
        loaiPhong = (String) cbb_loaiphong.getSelectedItem();
        giaPhong=txt_giaphong.getText();
        sogiuong = txt_sogiuong.getText();
        sophong = txt_sophong.getText();
        if (rdb_Empty.isSelected()) {
            tinhTrang = "0";
        } else {
            tinhTrang = "1";
        }
        moTa = txt_mota.getText();
        tbl_Phong cn = new tbl_Phong(maPhong, loaiPhong,sogiuong,sophong, giaPhong, tinhTrang, moTa);
        if (ktThem == true) {
            QuanLyController.ThemPhong(cn);
        } else {
            QuanLyController.CapNhatPhong(cn, macu);
        }
        try {
            LayNguon();
        } catch (IOException ex) {
        }
        KhoaMo(false);
    }//GEN-LAST:event_bt_ghiActionPerformed

    private void bt_khongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_khongActionPerformed
        XoaTrang();
        refresh(true);
        ktThem = true;
    }//GEN-LAST:event_bt_khongActionPerformed

    private void tb_PhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_PhongMouseClicked
        int index = tb_Phong.getSelectedRow();
        TableModel model = tb_Phong.getModel();
        maPhong = model.getValueAt(index, 0).toString();
        loaiPhong = model.getValueAt(index, 1).toString();
        sogiuong = model.getValueAt(index, 2).toString();
        sophong = model.getValueAt(index, 3).toString();
        giaPhong = model.getValueAt(index, 4).toString();
        tinhTrang = model.getValueAt(index, 5).toString();
        moTa = model.getValueAt(index, 6).toString();

        txt_maphong.setText(maPhong);
        cbb_loaiphong.setSelectedItem(loaiPhong);
        txt_sogiuong.setText(sogiuong);
        txt_sophong.setText(sophong);
        txt_giaphong.setText(giaPhong);
        if (tinhTrang == "Trống") {
            rdb_Empty.setSelected(true);
            rdb_Full.setSelected(false);
        } else {
            rdb_Empty.setSelected(false);
            rdb_Full.setSelected(true);
        }
        txt_mota.setText(moTa);
    }//GEN-LAST:event_tb_PhongMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_ghi;
    private javax.swing.JButton bt_khong;
    private javax.swing.JButton bt_sua;
    private javax.swing.JButton bt_them;
    private javax.swing.JButton bt_xoa;
    private javax.swing.JComboBox<String> cbb_loaiphong;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rdb_Empty;
    private javax.swing.JRadioButton rdb_Full;
    private javax.swing.JTable tb_Phong;
    private javax.swing.JTextField txt_giaphong;
    private javax.swing.JTextField txt_maphong;
    private javax.swing.JTextArea txt_mota;
    private javax.swing.JTextField txt_sogiuong;
    private javax.swing.JTextField txt_sophong;
    private javax.swing.JTextField txt_timkiem2;
    // End of variables declaration//GEN-END:variables
}
