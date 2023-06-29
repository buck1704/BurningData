package view;

import controller.DatPhongController;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.tbl_PhieuDatPhong;

public final class JP_SuaPhieuDatPhong extends javax.swing.JPanel {
    DefaultTableModel tbl_PhieuDatPhong;
    List<tbl_PhieuDatPhong> arrPhieuDatPhong = new ArrayList<>();
    private static boolean ktThem;
    private static String  sTimMaDatPhong, mapdp, maphongcu;
    private static String MaPhieuDK, MaKhachHang, MaPhong, NgayDen, NgayDi ,MaNhanVien ,ThanhTien;
    
//    private static String LoaiPhong, SoGiuong, SoPhong, GiaPhong, TinhTrang, MoTa;
    public JP_SuaPhieuDatPhong() throws IOException {
        initComponents();
        LayNguonPhieuDatPhong();
        sTimMaDatPhong = "";
        KhoaMo(false);
    }

    public void LayNguonPhieuDatPhong() throws IOException {
        tbl_PhieuDatPhong = (DefaultTableModel)  tb_phieudatphong.getModel();
        arrPhieuDatPhong = DatPhongController.NguonPhieuDatPhong(sTimMaDatPhong);
        tbl_PhieuDatPhong.setRowCount(0);
        arrPhieuDatPhong.forEach((KQ) -> {
            tbl_PhieuDatPhong.addRow(new Object[]{KQ.getMaPhieuDK(), KQ.getMaKhachHang(), KQ.getMaPhong(),KQ.getNgayDen(),KQ.getNgayDi(), KQ.getMaNhanVien(), KQ.getThanhTien()});
        });
    }
    
   public void KhoaMo(boolean b) {
        txt_maphong.setEditable(b);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txt_madatphong = new javax.swing.JTextField();
        btn_timkiemmadatphong = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txt_ticket_madatphong = new javax.swing.JLabel();
        txt_ticket_makh = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_maphong = new javax.swing.JTextField();
        btn_suamaphong = new javax.swing.JButton();
        txt_ngayden = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_ngaydi = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_thanhtien = new javax.swing.JLabel();
        txt_manhanvien = new javax.swing.JLabel();
        btn_xacnhan = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_phieudatphong = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1140, 780));
        setPreferredSize(new java.awt.Dimension(1140, 780));
        setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(76, 41, 211));
        jPanel4.setPreferredSize(new java.awt.Dimension(1140, 70));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(76, 41, 211));
        jPanel1.setPreferredSize(new java.awt.Dimension(300, 70));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 20));

        txt_madatphong.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        txt_madatphong.setPreferredSize(new java.awt.Dimension(180, 22));
        txt_madatphong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_madatphongActionPerformed(evt);
            }
        });
        jPanel1.add(txt_madatphong);

        btn_timkiemmadatphong.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btn_timkiemmadatphong.setText("Tìm Kiếm ");
        btn_timkiemmadatphong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_timkiemmadatphongMouseClicked(evt);
            }
        });
        btn_timkiemmadatphong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timkiemmadatphongActionPerformed(evt);
            }
        });
        jPanel1.add(btn_timkiemmadatphong);

        jPanel4.add(jPanel1, java.awt.BorderLayout.LINE_END);

        jLabel1.setFont(new java.awt.Font("Century Schoolbook", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Manager Booking");
        jPanel4.add(jLabel1, java.awt.BorderLayout.CENTER);

        add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel5.setPreferredSize(new java.awt.Dimension(400, 710));
        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 10));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(360, 400));

        jLabel9.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel9.setText("Mã Đặt Phòng: ");

        txt_ticket_madatphong.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        txt_ticket_madatphong.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txt_ticket_madatphong.setText("Mã Đặt Phòng");
        txt_ticket_madatphong.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        txt_ticket_makh.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        txt_ticket_makh.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txt_ticket_makh.setText("Mã Khách Hàng");
        txt_ticket_makh.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        jLabel2.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel2.setText("Mã Khách Hàng: ");

        jLabel4.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel4.setText("Mã Phòng:");

        txt_maphong.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        txt_maphong.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        btn_suamaphong.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btn_suamaphong.setText("Sửa");
        btn_suamaphong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_suamaphongMouseClicked(evt);
            }
        });
        btn_suamaphong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suamaphongActionPerformed(evt);
            }
        });

        txt_ngayden.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel5.setText("Ngày Đến:");

        jLabel6.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel6.setText("Ngày Đi:");

        txt_ngaydi.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel7.setText("Mã Nhân Viên:");

        jLabel3.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel3.setText("Thành Tiền:");

        txt_thanhtien.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        txt_thanhtien.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txt_thanhtien.setText("Thành Tiền");

        txt_manhanvien.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        txt_manhanvien.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txt_manhanvien.setText("Mã Nhân Viên");

        btn_xacnhan.setText("Xác Nhận");
        btn_xacnhan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_xacnhanMouseClicked(evt);
            }
        });
        btn_xacnhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xacnhanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_manhanvien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_thanhtien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_ngayden, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_ngaydi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_ticket_makh, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                            .addComponent(txt_maphong, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(btn_suamaphong, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(txt_ticket_madatphong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(btn_xacnhan)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_ticket_madatphong))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_ticket_makh))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txt_maphong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_suamaphong, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txt_ngayden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txt_ngaydi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_manhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(txt_thanhtien, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_xacnhan)
                .addContainerGap(108, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel2);

        add(jPanel5, java.awt.BorderLayout.LINE_START);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        tb_phieudatphong.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        tb_phieudatphong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Đặt Phòng", "Mã Khách Hàng ", "Mã Phòng", "Ngày Đến", "Ngày Đi", "Mã Nhân Viên", "Thành Tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_phieudatphong.setRowHeight(25);
        tb_phieudatphong.setRowMargin(5);
        tb_phieudatphong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_phieudatphongMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_phieudatphong);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 716, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 23, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(jPanel6, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_timkiemmadatphongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_timkiemmadatphongMouseClicked
        sTimMaDatPhong = txt_madatphong.getText();
        try{
            LayNguonPhieuDatPhong();
        }catch(IOException ex){
            Logger.getLogger(JP_KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_timkiemmadatphongMouseClicked

    private void btn_timkiemmadatphongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timkiemmadatphongActionPerformed
    }//GEN-LAST:event_btn_timkiemmadatphongActionPerformed

    private void txt_madatphongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_madatphongActionPerformed
    }//GEN-LAST:event_txt_madatphongActionPerformed

    private void btn_suamaphongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_suamaphongMouseClicked
    }//GEN-LAST:event_btn_suamaphongMouseClicked

    private void btn_suamaphongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suamaphongActionPerformed
        Date ngayDi = txt_ngaydi.getDate();
        if (ngayDi.before(new Date())) {
            JOptionPane.showMessageDialog(this, "Đã quá hạn sửa phòng", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (txt_ticket_madatphong.getText().length() <= 0) {
            return;
        }
        mapdp = txt_ticket_madatphong.getText();
        maphongcu = txt_maphong.getText();
        ktThem = false;
        KhoaMo(true);
    }//GEN-LAST:event_btn_suamaphongActionPerformed

    private void tb_phieudatphongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_phieudatphongMouseClicked
        try {
            int index = tb_phieudatphong.getSelectedRow();
            TableModel model = tb_phieudatphong.getModel();
            MaPhieuDK = model.getValueAt(index, 0).toString();
            MaKhachHang = model.getValueAt(index, 1).toString();
            MaPhong = model.getValueAt(index, 2).toString();
            NgayDen = model.getValueAt(index, 3).toString();
            NgayDi = model.getValueAt(index, 4).toString();
            MaNhanVien = model.getValueAt(index, 5).toString();
            ThanhTien = model.getValueAt(index, 6).toString();

            txt_ticket_madatphong.setText(MaPhieuDK);
            txt_ticket_makh.setText(MaKhachHang);
            txt_maphong.setText(MaPhong);
            Date NgayDen = new SimpleDateFormat("yyyy-MM-dd").parse(model.getValueAt(index, 3).toString());
            txt_ngayden.setDate(NgayDen);
            Date NgayDi = new SimpleDateFormat("yyyy-MM-dd").parse(model.getValueAt(index, 4).toString());
            txt_ngaydi.setDate(NgayDi);
            txt_manhanvien.setText(MaNhanVien);
            txt_thanhtien.setText(ThanhTien);
        } catch (ParseException ex) {
            Logger.getLogger(JP_SuaPhieuDatPhong.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_tb_phieudatphongMouseClicked

    private void btn_xacnhanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_xacnhanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_xacnhanMouseClicked

    private void btn_xacnhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xacnhanActionPerformed
        MaPhieuDK = txt_ticket_madatphong.getText();
        MaKhachHang = txt_ticket_makh.getText();
        MaPhong = txt_maphong.getText();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String ngayDen = sdf.format(txt_ngayden.getDate());
        String ngayDi = sdf.format(txt_ngaydi.getDate());
        MaNhanVien=txt_manhanvien.getText();
        ThanhTien=txt_thanhtien.getText();

        tbl_PhieuDatPhong cn = new tbl_PhieuDatPhong(MaPhieuDK, MaKhachHang, ngayDen, ngayDi, MaPhong, ThanhTien, MaNhanVien);
        if (ktThem == false) {
            DatPhongController.CapNhatPhieuDatPhong(cn, mapdp, maphongcu);
        }
        try {
            LayNguonPhieuDatPhong();
        } catch (IOException ex) {
            Logger.getLogger(DatPhongController.class.getName()).log(Level.SEVERE, null, ex);
        }
        KhoaMo(false);
    }//GEN-LAST:event_btn_xacnhanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_suamaphong;
    private javax.swing.JButton btn_timkiemmadatphong;
    private javax.swing.JButton btn_xacnhan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_phieudatphong;
    private javax.swing.JTextField txt_madatphong;
    private javax.swing.JLabel txt_manhanvien;
    private javax.swing.JTextField txt_maphong;
    private com.toedter.calendar.JDateChooser txt_ngayden;
    private com.toedter.calendar.JDateChooser txt_ngaydi;
    private javax.swing.JLabel txt_thanhtien;
    private javax.swing.JLabel txt_ticket_madatphong;
    private javax.swing.JLabel txt_ticket_makh;
    // End of variables declaration//GEN-END:variables

}
