/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;
import com.sun.jdi.IntegerValue;
import control.Data_HangHoa;
import control.Data_DatPhong;
import control.Data_PhieuDV;
import control.Data_QuanLy;
import java.awt.Color;
import java.awt.Component;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
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

public class JP_SuaPhieuDatPhong extends javax.swing.JPanel {
    DefaultTableModel tbl_PhieuDatPhong;
           
     Locale locale = new Locale("vi","VN");
     NumberFormat format = NumberFormat.getCurrencyInstance(locale);
     DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance(locale);
     char decimalSeparator = symbols.getDecimalSeparator();
     
    List<tbl_PhieuDatPhong> arrPhieuDatPhong = new ArrayList<>();
    
    private static boolean ktThem;
    
    private static String  mapdp,sTimMaDatPhong,maphongcu;
    
    private static String MaPhieuDK, MaKhachHang, MaPhong, NgayDen, NgayDi ,MaNhanVien ,ThanhTien;
    
  
    public JP_SuaPhieuDatPhong() throws IOException {
        initComponents();
        LayNguonPhieuDatPhong();
        sTimMaDatPhong = "";
        KhoaMo(false);
    }
    public void LayNguonPhieuDatPhong() throws IOException {
        tbl_PhieuDatPhong = (DefaultTableModel)  tb_phieudatphong.getModel();
        tb_phieudatphong.getColumnModel().getColumn(0).setPreferredWidth(50);           
        tb_phieudatphong.getColumnModel().getColumn(1).setPreferredWidth(90);
        tb_phieudatphong.getColumnModel().getColumn(2).setPreferredWidth(90);
        tb_phieudatphong.getColumnModel().getColumn(3).setPreferredWidth(50);
        tb_phieudatphong.getColumnModel().getColumn(4).setPreferredWidth(50);
        tb_phieudatphong.getColumnModel().getColumn(5).setPreferredWidth(50);
        tb_phieudatphong.getColumnModel().getColumn(6).setPreferredWidth(50);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer(){};
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        TableColumnModel columnModel = tb_phieudatphong.getColumnModel();
        columnModel.getColumn(0).setCellRenderer(centerRenderer);
        columnModel.getColumn(1).setCellRenderer(centerRenderer);
        columnModel.getColumn(2).setCellRenderer(centerRenderer);
        columnModel.getColumn(3).setCellRenderer(centerRenderer);
        columnModel.getColumn(4).setCellRenderer(centerRenderer);
        columnModel.getColumn(5).setCellRenderer(centerRenderer);
        columnModel.getColumn(6).setCellRenderer(centerRenderer);
        
        arrPhieuDatPhong = Data_DatPhong.NguonPhieuDatPhong(sTimMaDatPhong);
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

        txt_madatphong = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btn_timkiemmadatphong = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_ticket_makh = new javax.swing.JLabel();
        txt_ngayden = new com.toedter.calendar.JDateChooser();
        txt_maphong = new javax.swing.JTextField();
        txt_ngaydi = new com.toedter.calendar.JDateChooser();
        btn_suamaphong = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txt_ticket_madatphong = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_phieudatphong = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txt_thanhtien = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_manhanvien = new javax.swing.JLabel();
        btn_xacnhan = new javax.swing.JButton();

        txt_madatphong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_madatphongActionPerformed(evt);
            }
        });

        jLabel1.setText("Mã Đặt Phòng:");

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

        jLabel2.setText("Mã Khách Hàng: ");

        jLabel4.setText("Mã Phòng:");

        jLabel5.setText("Ngày Đến:");

        jLabel6.setText("Ngày Đi:");

        txt_ticket_makh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_ticket_makh.setText("Mã KH");
        txt_ticket_makh.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

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

        jLabel9.setText("Mã Đặt Phòng: ");

        txt_ticket_madatphong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_ticket_madatphong.setText("Mã Đặt Phòng");
        txt_ticket_madatphong.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

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
        tb_phieudatphong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_phieudatphongMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_phieudatphong);

        jLabel3.setText("Thành Tiền:");

        txt_thanhtien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_thanhtien.setText("Thành Tiền");

        jLabel7.setText("Mã Nhân Viên:");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_ticket_makh, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_ticket_madatphong, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txt_thanhtien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_ngaydi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                                    .addComponent(txt_ngayden, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                                    .addComponent(txt_maphong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_suamaphong, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_manhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(btn_xacnhan)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_madatphong, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_timkiemmadatphong)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_madatphong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_timkiemmadatphong))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txt_ticket_madatphong))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_ticket_makh))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txt_maphong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_suamaphong))
                                .addGap(35, 35, 35)
                                .addComponent(jLabel5))
                            .addComponent(txt_ngayden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_ngaydi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txt_manhanvien))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_thanhtien))
                        .addGap(18, 18, 18)
                        .addComponent(btn_xacnhan))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_madatphongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_madatphongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_madatphongActionPerformed

    private void btn_timkiemmadatphongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timkiemmadatphongActionPerformed
        // TODO add your handling code here:
       
      
    }//GEN-LAST:event_btn_timkiemmadatphongActionPerformed

    private void tb_phieudatphongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_phieudatphongMouseClicked
        try {
            // TODO add your handling code here:
            
            int index = tb_phieudatphong.getSelectedRow();
            TableModel model = tb_phieudatphong.getModel();
            MaPhieuDK= model.getValueAt(index, 0).toString();
            MaKhachHang= model.getValueAt(index, 1).toString();
            MaPhong = model.getValueAt(index, 2).toString();
            NgayDen = model.getValueAt(index, 3).toString();
            NgayDi = model.getValueAt(index, 4).toString();
            MaNhanVien= model.getValueAt(index, 5).toString();
            ThanhTien= model.getValueAt(index, 6).toString();

            
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

    private void btn_timkiemmadatphongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_timkiemmadatphongMouseClicked
        // TODO add your handling code here:
         sTimMaDatPhong = txt_madatphong.getText();
        try{
            LayNguonPhieuDatPhong();
        }catch(IOException ex){
            Logger.getLogger(JP_KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_timkiemmadatphongMouseClicked

    private void btn_suamaphongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_suamaphongMouseClicked
        
       
    }//GEN-LAST:event_btn_suamaphongMouseClicked

    private void btn_xacnhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xacnhanActionPerformed
        MaPhieuDK= txt_ticket_madatphong.getText();
        MaKhachHang= txt_ticket_makh.getText();
        MaPhong= txt_maphong.getText();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String ngayDen = sdf.format(txt_ngayden.getDate());
        String ngayDi = sdf.format(txt_ngaydi.getDate());
        MaNhanVien=txt_manhanvien.getText();
        ThanhTien=txt_thanhtien.getText();
        
        tbl_PhieuDatPhong cn = new tbl_PhieuDatPhong(MaPhieuDK,MaKhachHang,ngayDen,ngayDi,MaPhong,ThanhTien,MaNhanVien);
        if (ktThem == false) {
            Data_DatPhong.CapNhatPhieuDatPhong(cn,mapdp, maphongcu);
        }
        try {
            LayNguonPhieuDatPhong();
        } catch (IOException ex) {
            Logger.getLogger(Data_DatPhong.class.getName()).log(Level.SEVERE, null, ex);
        }
        KhoaMo(false);
    }//GEN-LAST:event_btn_xacnhanActionPerformed

    private void btn_xacnhanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_xacnhanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_xacnhanMouseClicked

    private void btn_suamaphongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suamaphongActionPerformed
        // TODO add your handling code here:
         if (txt_ticket_madatphong.getText().length() <= 0) {
            return;
        } 
        mapdp=txt_ticket_madatphong.getText();
        maphongcu=txt_maphong.getText();
        ktThem = false;
        KhoaMo(true);
    }//GEN-LAST:event_btn_suamaphongActionPerformed


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
