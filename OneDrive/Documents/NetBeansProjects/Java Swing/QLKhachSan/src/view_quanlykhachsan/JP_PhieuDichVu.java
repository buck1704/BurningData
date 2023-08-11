/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view_quanlykhachsan;

import bean.chuyenmanhinh_bean;
import com.mysql.cj.x.protobuf.MysqlxNotice.Warning.Level;
import control_quanlykhachsan.Data_PhieuDK;
import control_quanlykhachsan.Data_PhieuDV;
import control_quanlykhachsan.control_chuyenmanhinh;
import java.io.IOException;
import java.lang.System.Logger;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import model_quanlykhachsan.tbl_PhieuDangKy;

public class JP_PhieuDichVu extends javax.swing.JPanel {
    DefaultTableModel tbl_PhieuDangKy;
    List<tbl_PhieuDangKy> arrPhieuDangKy = new ArrayList<>();
    private String sGiaTriTimKiem, sPhanLoaiTimKiem;
    
    public JP_PhieuDichVu() throws IOException {
        initComponents();
        sGiaTriTimKiem = "";
        sPhanLoaiTimKiem = "";
        LayNguonInfo();
        
        control_chuyenmanhinh contronller = new control_chuyenmanhinh(JP_PhieuDangKy_Buoc1);
        List<chuyenmanhinh_bean> listItem = new ArrayList<>();
        listItem.add(new chuyenmanhinh_bean("PhieuDangKy_Buoc2",btn_TiepTuc,lb_TiepTuc));
        contronller.setEvent(listItem);
        tabbed_Phieu.setEnabledAt(2, false);
    }
    public void LayNguonInfo() throws IOException {
        // Thiết lập độ rộng của cột
        tbl_PhieuDangKy = (DefaultTableModel) tb_phieudk.getModel();
        tb_phieudk.getColumnModel().getColumn(0).setPreferredWidth(50);           
        tb_phieudk.getColumnModel().getColumn(1).setPreferredWidth(50);
        tb_phieudk.getColumnModel().getColumn(2).setPreferredWidth(90);
        tb_phieudk.getColumnModel().getColumn(3).setPreferredWidth(60);
        // Căn giữa cột
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        TableColumnModel columnModel = tb_phieudk.getColumnModel();
        columnModel.getColumn(0).setCellRenderer(centerRenderer);
        columnModel.getColumn(1).setCellRenderer(centerRenderer);
        columnModel.getColumn(2).setCellRenderer(centerRenderer);
        columnModel.getColumn(3).setCellRenderer(centerRenderer);
        arrPhieuDangKy = Data_PhieuDV.NguonPhieuDK(sPhanLoaiTimKiem, sGiaTriTimKiem);
        tbl_PhieuDangKy.setRowCount(0);
        arrPhieuDangKy.forEach((KQ) -> {
        tbl_PhieuDangKy.addRow(new Object[]{KQ.getMaPhieuDK(), KQ.getMaKhachHang(),  KQ.getMaPhong(), KQ.getMaNhanVien()});
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel9 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        tabbed_Phieu = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        JP_PhieuDangKy_Buoc1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_phieudk = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cbb_phanloaitimkiem = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        txt_giatritimtiem = new javax.swing.JTextField();
        btn_timkiemduatrenphanloai = new javax.swing.JButton();
        btn_refresh_phong = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txt_maphieudk = new javax.swing.JTextField();
        btn_TiepTuc = new javax.swing.JPanel();
        lb_TiepTuc = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        JP_PhieuDangKy_Buoc2 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();

        jPanel9.setBackground(new java.awt.Color(76, 41, 211));
        jPanel9.setMinimumSize(new java.awt.Dimension(1140, 70));

        jLabel8.setFont(new java.awt.Font("Century Schoolbook", 1, 30)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Room manager");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(376, 376, 376)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(462, 462, 462))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        tabbed_Phieu.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1135, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 684, Short.MAX_VALUE)
        );

        tabbed_Phieu.addTab("Phiếu Dịch Vụ", jPanel1);

        JP_PhieuDangKy_Buoc1.setBackground(new java.awt.Color(255, 255, 255));
        JP_PhieuDangKy_Buoc1.setMinimumSize(new java.awt.Dimension(100, 1));
        JP_PhieuDangKy_Buoc1.setPreferredSize(new java.awt.Dimension(100, 1));

        jPanel3.setBackground(new java.awt.Color(123, 156, 225));
        jPanel3.setPreferredSize(new java.awt.Dimension(260, 30));

        jLabel1.setFont(new java.awt.Font("Montserrat", 3, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Bước 1:");

        jLabel2.setFont(new java.awt.Font("Montserrat", 2, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Chọn Phiếu Đăng Ký");

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setPreferredSize(new java.awt.Dimension(5, 30));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
        );

        tb_phieudk.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tb_phieudk.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        tb_phieudk.setModel(new javax.swing.table.DefaultTableModel(
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
                "Mã Phiếu Đăng Ký", "Mã Khách Hàng", "Phòng", "Người Thêm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_phieudk.setGridColor(new java.awt.Color(0, 0, 0));
        tb_phieudk.setRowHeight(25);
        tb_phieudk.setRowMargin(5);
        tb_phieudk.setSelectionBackground(new java.awt.Color(204, 204, 204));
        tb_phieudk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_phieudkMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_phieudk);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Montserrat Medium", 2, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(76, 41, 211));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Bộ Lọc");

        cbb_phanloaitimkiem.setBackground(new java.awt.Color(255, 255, 255));
        cbb_phanloaitimkiem.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        cbb_phanloaitimkiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã Phiếu", "Mã Khách Hàng", "Phòng", "Mã Nhân Viên" }));

        jLabel15.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel15.setText("Tìm Kiếm:");

        txt_giatritimtiem.setMinimumSize(new java.awt.Dimension(5, 25));
        txt_giatritimtiem.setPreferredSize(new java.awt.Dimension(56, 25));

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

        btn_refresh_phong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_refresh_phong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/refresh_25px.png"))); // NOI18N
        btn_refresh_phong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_refresh_phongMouseClicked(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(76, 41, 211));
        jPanel8.setMinimumSize(new java.awt.Dimension(100, 1));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbb_phanloaitimkiem, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txt_giatritimtiem, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_timkiemduatrenphanloai, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btn_refresh_phong, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel15)
                .addGap(10, 10, 10)
                .addComponent(cbb_phanloaitimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_giatritimtiem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_timkiemduatrenphanloai))
                    .addComponent(btn_refresh_phong, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Montserrat Medium", 2, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(76, 41, 211));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Kết Quả");

        txt_maphieudk.setMinimumSize(new java.awt.Dimension(5, 25));
        txt_maphieudk.setPreferredSize(new java.awt.Dimension(56, 25));
        txt_maphieudk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_maphieudkActionPerformed(evt);
            }
        });

        btn_TiepTuc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(76, 41, 211)));

        lb_TiepTuc.setFont(new java.awt.Font("Montserrat Medium", 1, 12)); // NOI18N
        lb_TiepTuc.setText("Tiếp Tục");
        lb_TiepTuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_TiepTucMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Montserrat Medium", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/next_16px.png"))); // NOI18N

        javax.swing.GroupLayout btn_TiepTucLayout = new javax.swing.GroupLayout(btn_TiepTuc);
        btn_TiepTuc.setLayout(btn_TiepTucLayout);
        btn_TiepTucLayout.setHorizontalGroup(
            btn_TiepTucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_TiepTucLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lb_TiepTuc, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        btn_TiepTucLayout.setVerticalGroup(
            btn_TiepTucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_TiepTuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        jPanel11.setBackground(new java.awt.Color(76, 41, 211));
        jPanel11.setMinimumSize(new java.awt.Dimension(100, 1));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(txt_maphieudk, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_TiepTuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(0, 0, 0)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_TiepTuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_maphieudk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout JP_PhieuDangKy_Buoc1Layout = new javax.swing.GroupLayout(JP_PhieuDangKy_Buoc1);
        JP_PhieuDangKy_Buoc1.setLayout(JP_PhieuDangKy_Buoc1Layout);
        JP_PhieuDangKy_Buoc1Layout.setHorizontalGroup(
            JP_PhieuDangKy_Buoc1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_PhieuDangKy_Buoc1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JP_PhieuDangKy_Buoc1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 724, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_PhieuDangKy_Buoc1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        JP_PhieuDangKy_Buoc1Layout.setVerticalGroup(
            JP_PhieuDangKy_Buoc1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_PhieuDangKy_Buoc1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(JP_PhieuDangKy_Buoc1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JP_PhieuDangKy_Buoc1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(186, 186, 186))
        );

        tabbed_Phieu.addTab("Bước 1: Chọn Phiếu Đăng Ký", JP_PhieuDangKy_Buoc1);

        JP_PhieuDangKy_Buoc2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 339, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 807, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 339, Short.MAX_VALUE)
        );

        jPanel12.setBackground(new java.awt.Color(123, 156, 225));
        jPanel12.setPreferredSize(new java.awt.Dimension(260, 30));

        jLabel5.setFont(new java.awt.Font("Montserrat", 3, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Bước 2:");

        jLabel7.setFont(new java.awt.Font("Montserrat", 2, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Đăng Ký Dịch Vụ");

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
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JP_PhieuDangKy_Buoc2Layout = new javax.swing.GroupLayout(JP_PhieuDangKy_Buoc2);
        JP_PhieuDangKy_Buoc2.setLayout(JP_PhieuDangKy_Buoc2Layout);
        JP_PhieuDangKy_Buoc2Layout.setHorizontalGroup(
            JP_PhieuDangKy_Buoc2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_PhieuDangKy_Buoc2Layout.createSequentialGroup()
                .addGroup(JP_PhieuDangKy_Buoc2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JP_PhieuDangKy_Buoc2Layout.setVerticalGroup(
            JP_PhieuDangKy_Buoc2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_PhieuDangKy_Buoc2Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tabbed_Phieu.addTab("Bước 2: Đăng Ký Dịch Vụ", JP_PhieuDangKy_Buoc2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tabbed_Phieu, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(tabbed_Phieu))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_timkiemduatrenphanloaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_timkiemduatrenphanloaiMouseClicked

    }//GEN-LAST:event_btn_timkiemduatrenphanloaiMouseClicked

    private void btn_timkiemduatrenphanloaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timkiemduatrenphanloaiActionPerformed
        // Lấy vị trí được chọn trong JComboBox
        int selectedIndex = cbb_phanloaitimkiem.getSelectedIndex();
        // Thiết lập sPhanLoaiTimKiem tương ứng với vị trí được chọn
        switch (selectedIndex) {
            case 0:
                sPhanLoaiTimKiem = "MaPhieuDangKy";
                break;
            case 1:
                sPhanLoaiTimKiem = "MaKhachHang";
                break;
            case 2:
                sPhanLoaiTimKiem = "MaPhong";
                break;
            case 3:
                sPhanLoaiTimKiem = "MaNhanVien";
                break;
            default:
                break;
        }
        sGiaTriTimKiem = txt_giatritimtiem.getText();

        try {
            LayNguonInfo();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(JP_PhieuDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btn_timkiemduatrenphanloaiActionPerformed

    private void btn_refresh_phongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_refresh_phongMouseClicked
        txt_giatritimtiem.setText("");
        cbb_phanloaitimkiem.setSelectedItem(0);
        sGiaTriTimKiem = "";
        sPhanLoaiTimKiem = "";
        try {
            LayNguonInfo();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(JP_PhieuDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_refresh_phongMouseClicked

    private void txt_maphieudkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_maphieudkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_maphieudkActionPerformed

    private void tb_phieudkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_phieudkMouseClicked
        int index = tb_phieudk.getSelectedRow();
        TableModel model = tb_phieudk.getModel();
        txt_maphieudk.setText(model.getValueAt(index, 0).toString());
    }//GEN-LAST:event_tb_phieudkMouseClicked

    private void lb_TiepTucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_TiepTucMouseClicked
        tabbed_Phieu.setSelectedIndex(2);
        tabbed_Phieu.setEnabledAt(1, false);
        tabbed_Phieu.setEnabledAt(2, true);
    }//GEN-LAST:event_lb_TiepTucMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JP_PhieuDangKy_Buoc1;
    private javax.swing.JPanel JP_PhieuDangKy_Buoc2;
    private javax.swing.JPanel btn_TiepTuc;
    private javax.swing.JLabel btn_refresh_phong;
    private javax.swing.JButton btn_timkiemduatrenphanloai;
    private javax.swing.JComboBox<String> cbb_phanloaitimkiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
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
    private javax.swing.JLabel lb_TiepTuc;
    private javax.swing.JTabbedPane tabbed_Phieu;
    private javax.swing.JTable tb_phieudk;
    private javax.swing.JTextField txt_giatritimtiem;
    private javax.swing.JTextField txt_maphieudk;
    // End of variables declaration//GEN-END:variables
}
