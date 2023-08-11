/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import controller.QuanLyController;
import controller.QuanLyKhachSanController;
import java.io.IOException;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.tbl_ChucVu;
import textfield.SearchOptinEvent;
import textfield.SearchOption;

/**
 *
 * @author 05032002
 */
public class JP_ChucVu extends javax.swing.JPanel {

    DefaultTableModel tbl_ChucVu;
    ArrayList<tbl_ChucVu> arrChucVu = new ArrayList<>();
    private static boolean ktThem;
    private static String macu;
    private static String maChucVu, tenChucVu,luongChucVu;
 
    public JP_ChucVu() throws IOException, SQLException {
        initComponents();
        tbl_ChucVu = (DefaultTableModel) tb_chucvu.getModel();
        LayNguon("", "");
        txt.addEventOptionSelected(new SearchOptinEvent() {
            @Override
            public void optionSelected(SearchOption option, int index) {
                txt.setHint("Search by " + option.getName() + "...");
            }
        });
        txt.addOption(new SearchOption("machucvu", new ImageIcon(getClass().getResource("/textfield/user.png"))));
        txt.addOption(new SearchOption("tenchucvu", new ImageIcon(getClass().getResource("/textfield/tel.png"))));
        txt.addOption(new SearchOption("LuongTheoNgay", new ImageIcon(getClass().getResource("/textfield/email.png"))));
    }

    public void LayNguon(String dk, String gt) throws IOException {
        arrChucVu = QuanLyController.NguonChucVu(dk, gt);
        tbl_ChucVu.setRowCount(0);
        arrChucVu.forEach((KQ) -> {
            tbl_ChucVu.addRow(new Object[]{KQ.getMaChucVu(), KQ.getTenChucVu(), KQ.getLuongTheoNgay()});

        });
    }

    public void KhoaMo(boolean b) {
        txt_machucvu.setEditable(b);
        txt_tenchucvu.setEditable(b);
        txt_luongchucvu.setEditable(b);
        bt_them.setEnabled(!b);
        bt_sua.setEnabled(!b);
        bt_xoa.setEnabled(!b);
        bt_ghi.setEnabled(b);
        bt_khong.setEnabled(b);
        tb_chucvu.setEnabled(!b);
    }
    public void refresh(boolean b) {
        txt_machucvu.setEditable(b);
        txt_tenchucvu.setEditable(b);
        txt_luongchucvu.setEditable(b);
        bt_them.setEnabled(b);
        bt_sua.setEnabled(b);
        bt_xoa.setEnabled(b);
        bt_ghi.setEnabled(b);
        bt_khong.setEnabled(b);
        tb_chucvu.setEnabled(b);
    }
    
    public void XoaTrang() {
        txt_machucvu.setText("");
        txt_tenchucvu.setText("");
        txt_luongchucvu.setText("");
        }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        txt = new textfield.TextFieldSearchOption();
        jPanel2 = new javax.swing.JPanel();
        txt_machucvu = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_tenchucvu = new javax.swing.JTextField();
        txt_luongchucvu = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        bt_them = new javax.swing.JButton();
        bt_sua = new javax.swing.JButton();
        bt_xoa = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        bt_ghi = new javax.swing.JButton();
        bt_khong = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_chucvu = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setFocusable(false);
        setMinimumSize(new java.awt.Dimension(1140, 780));
        setPreferredSize(new java.awt.Dimension(1140, 800));
        setLayout(new java.awt.BorderLayout());

        jPanel7.setBackground(new java.awt.Color(76, 41, 211));
        jPanel7.setPreferredSize(new java.awt.Dimension(1140, 70));
        jPanel7.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Century Schoolbook", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Position Management");
        jPanel7.add(jLabel1, java.awt.BorderLayout.CENTER);

        add(jPanel7, java.awt.BorderLayout.PAGE_START);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel8.setPreferredSize(new java.awt.Dimension(400, 700));

        txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(76, 41, 211)));
        txt.setMargin(new java.awt.Insets(0, 10, 0, 0));
        txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtKeyReleased(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Chi Tiết", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Montserrat Medium", 0, 11))); // NOI18N

        txt_machucvu.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel2.setText("Mã Chức Vụ:");

        jLabel3.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel3.setText("Tên Chức Vụ:");

        txt_tenchucvu.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N

        txt_luongchucvu.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel4.setText("Lương theo theo ngày:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_luongchucvu, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                    .addComponent(txt_tenchucvu)
                    .addComponent(txt_machucvu)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(0, 0, 0)
                .addComponent(txt_machucvu, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(0, 0, 0)
                .addComponent(txt_tenchucvu, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(0, 0, 0)
                .addComponent(txt_luongchucvu, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Cập Nhật"), "Cập Nhật", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Montserrat", 0, 11))); // NOI18N
        java.awt.FlowLayout flowLayout2 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 25, 5);
        flowLayout2.setAlignOnBaseline(true);
        jPanel1.setLayout(flowLayout2);

        bt_them.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        bt_them.setText("Thêm");
        bt_them.setPreferredSize(new java.awt.Dimension(75, 25));
        bt_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_themActionPerformed(evt);
            }
        });
        jPanel1.add(bt_them);

        bt_sua.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        bt_sua.setText("Sửa");
        bt_sua.setPreferredSize(new java.awt.Dimension(75, 25));
        bt_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_suaActionPerformed(evt);
            }
        });
        jPanel1.add(bt_sua);

        bt_xoa.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        bt_xoa.setText("Xoá");
        bt_xoa.setPreferredSize(new java.awt.Dimension(75, 25));
        bt_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_xoaActionPerformed(evt);
            }
        });
        jPanel1.add(bt_xoa);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Điều Khiển", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Montserrat", 0, 11))); // NOI18N
        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 50, 5));

        bt_ghi.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        bt_ghi.setText("Ghi");
        bt_ghi.setPreferredSize(new java.awt.Dimension(100, 25));
        bt_ghi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ghiActionPerformed(evt);
            }
        });
        jPanel3.add(bt_ghi);

        bt_khong.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        bt_khong.setText("Không");
        bt_khong.setPreferredSize(new java.awt.Dimension(100, 25));
        bt_khong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_khongActionPerformed(evt);
            }
        });
        jPanel3.add(bt_khong);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(281, Short.MAX_VALUE))
        );

        add(jPanel8, java.awt.BorderLayout.LINE_START);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        tb_chucvu.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        tb_chucvu.setModel(new javax.swing.table.DefaultTableModel(
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
                "Mã Bộ Phận", "Tên Bộ Phận", "Lương"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_chucvu.setRowHeight(25);
        tb_chucvu.setRowMargin(5);
        tb_chucvu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_chucvuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_chucvu);
        if (tb_chucvu.getColumnModel().getColumnCount() > 0) {
            tb_chucvu.getColumnModel().getColumn(0).setPreferredWidth(35);
            tb_chucvu.getColumnModel().getColumn(1).setPreferredWidth(175);
            tb_chucvu.getColumnModel().getColumn(2).setPreferredWidth(50);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel4, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void txtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKeyReleased
        try {
            if (txt.isSelected()) {
                int option = txt.getSelectedIndex();
                String giaTri = txt.getText().trim();
                if (option == 0) {
                    LayNguon("machucvu", giaTri);
                }
                if (option == 1) {
                    LayNguon("tenchucvu", giaTri);
                }
                if (option == 2) {
                    LayNguon("LuongTheoNgay", giaTri);
                }
            }
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(JP_ChucVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtKeyReleased

    private void bt_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_themActionPerformed
        ktThem = true;
        macu = "";
        KhoaMo(true);
        XoaTrang();
        txt_machucvu.requestFocus();
    }//GEN-LAST:event_bt_themActionPerformed

    private void bt_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_suaActionPerformed
        if (txt_machucvu.getText().length() <= 0) {
            return;
        }
        macu = txt_machucvu.getText();
        ktThem = false;
        KhoaMo(true);
        txt_machucvu.requestFocus();
    }//GEN-LAST:event_bt_suaActionPerformed

    private void bt_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_xoaActionPerformed
        if (txt_machucvu.getText().length() <= 0) {
            JOptionPane.showConfirmDialog(this, "Hãy nhập thông tin cần xoá!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        macu = txt_machucvu.getText();
        for (int i = 0; i < arrChucVu.size(); i++) {
            if (arrChucVu.get(i).getMaChucVu().equals(macu)) {
                int kq = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa chuyên ngành này không?", "Thông Báo", JOptionPane.YES_NO_OPTION);
                if (kq == JOptionPane.YES_OPTION) {
                    QuanLyController.XoaNganh(macu);
                    XoaTrang();
                    try {
                        LayNguon("", "");
                    } catch (IOException ex) {

                    }
                }
                return;
            }
        }
    }//GEN-LAST:event_bt_xoaActionPerformed

    private void bt_ghiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ghiActionPerformed
        if (txt_machucvu.getText().length() <= 0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập đủ thông tin.", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            txt_machucvu.requestFocus();
            return;
        }
        if (txt_tenchucvu.getText().length() <= 0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập đủ thông tin.", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            txt_tenchucvu.requestFocus();
            return;
        }
        if (QuanLyKhachSanController.KiemTraTrungMa("ChucVu", "MaChucVu", txt_machucvu.getText(), ktThem, macu) == true) {
            JOptionPane.showMessageDialog(this, "Mã ngành đã tồn tại trong cơ sở dữ liệu.", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            txt_machucvu.requestFocus();
            return;
        }
        maChucVu = txt_machucvu.getText();
        tenChucVu = txt_tenchucvu.getText();
        luongChucVu=txt_luongchucvu.getText();

        tbl_ChucVu cn = new tbl_ChucVu(maChucVu, tenChucVu, luongChucVu);
        if (ktThem == true) {
            QuanLyController.ThemBoPhan(cn);
        } else {
            QuanLyController.CapNhapBoPhan(cn, macu);
        }
        try {
            LayNguon("", "");
        } catch (IOException ex) {

        }
        KhoaMo(false);
    }//GEN-LAST:event_bt_ghiActionPerformed

    private void bt_khongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_khongActionPerformed
        XoaTrang();
        refresh(true);
        ktThem = true;
    }//GEN-LAST:event_bt_khongActionPerformed

    private void tb_chucvuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_chucvuMouseClicked
        int index = tb_chucvu.getSelectedRow();
        TableModel model = tb_chucvu.getModel();
        maChucVu = model.getValueAt(index, 0).toString();
        tenChucVu = model.getValueAt(index, 1).toString();
        luongChucVu = model.getValueAt(index, 2).toString();
        txt_machucvu.setText(maChucVu);
        txt_tenchucvu.setText(tenChucVu);
        txt_luongchucvu.setText(luongChucVu);
    }//GEN-LAST:event_tb_chucvuMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_ghi;
    private javax.swing.JButton bt_khong;
    private javax.swing.JButton bt_sua;
    private javax.swing.JButton bt_them;
    private javax.swing.JButton bt_xoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_chucvu;
    private textfield.TextFieldSearchOption txt;
    private javax.swing.JTextField txt_luongchucvu;
    private javax.swing.JTextField txt_machucvu;
    private javax.swing.JTextField txt_tenchucvu;
    // End of variables declaration//GEN-END:variables
}
