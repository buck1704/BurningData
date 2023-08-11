/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import control.Data_QuanLy;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.tbl_ChucVu;
import model.tbl_NhanVien;
import control.Data_QuanLyKhachSan;

public class JP_NhanVien extends javax.swing.JPanel {

    DefaultTableModel model;
    List<tbl_NhanVien> list = new ArrayList<>();
    private static boolean ktThem;
    private static String macu;
    private static String manv, tennv, macv, gioitinh, ngaysinh, sdt, diachi, taikhoan, matkhau;
    private static String timkiem;

    public JP_NhanVien() {
        initComponents();
        LoadDataArrayListToTable();
        timkiem = "";
    }

    public void LoadDataArrayListToTable() {
        list = Data_QuanLy.LoadDataToArrayNhanVien(timkiem);
        model = (DefaultTableModel) tb_nhanvien.getModel();
        model.setRowCount(0);
        for (tbl_NhanVien nv : list) {
            model.addRow(new Object[]{nv.getManv(), nv.getTennv(), nv.getMacv(), nv.getGioitinh(), nv.getNgaysinh(), nv.getSdt(), nv.getDiachi(), nv.getTendn(), nv.getPasswword()});
        }
        LoadComBoBox();
    }

    public void LoadComBoBox() {
        try {
            List<tbl_ChucVu> chucvu = Data_QuanLy.NguonChucVu();
            for (tbl_ChucVu o : chucvu) {
                cbmacv.addItem(o.getMaChucVu());
            }
        } catch (IOException ex) {
            Logger.getLogger(JP_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void KhoaMo(boolean b) {
//        txtmanv.setEditable(b);
//        txttennv.setEditable(b);
//        cbmacv.setEditable(b);
//        rbnam.setEnabled(!b);
//        rbnu.setEnabled(!b);
//        txtsdt.setEditable(b);
//        txtngaysinh.setEnabled(b);
//        txtdiachi.setEditable(b);
//        txttaikhoan.setEditable(b);
//        txtmatkhau.setEditable(b);
        bt_them.setEnabled(!b);
        bt_sua.setEnabled(!b);
        bt_xoa.setEnabled(!b);
//        bt_ghi.setEnabled(b);
//        bt_khong.setEnabled(b);
//        bt_ketthuc.setEnabled(!b);

    }

    public void refresh(boolean b) {
        txtmanv.setEditable(b);
        txttennv.setEditable(b);
        cbmacv.setEditable(b);
        rbnam.setEnabled(!b);
        rbnu.setEnabled(!b);
        txtsdt.setEditable(b);
        txtngaysinh.setEnabled(b);
        txtdiachi.setEditable(b);
        txttaikhoan.setEditable(b);
        txtmatkhau.setEditable(b);
        bt_them.setEnabled(b);
        bt_sua.setEnabled(b);
        bt_xoa.setEnabled(b);
        bt_ghi.setEnabled(b);
        bt_khong.setEnabled(b);

    }

    public void XoaTrang() {
        txtmanv.setText("");
        txttennv.setText("");
        cbmacv.setSelectedIndex(0);
        rbnu.setSelected(true);
        rbnam.setSelected(false);

        txtsdt.setText("");
        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();
        txtngaysinh.setDate(currentDate);
        txtdiachi.setText("");
        txttaikhoan.setText("");
        txtmatkhau.setText("");
        txttimkiem.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lb1 = new javax.swing.JLabel();
        txtmanv = new javax.swing.JTextField();
        lb2 = new javax.swing.JLabel();
        txttennv = new javax.swing.JTextField();
        lb3 = new javax.swing.JLabel();
        lb4 = new javax.swing.JLabel();
        lb5 = new javax.swing.JLabel();
        lb6 = new javax.swing.JLabel();
        txtsdt = new javax.swing.JTextField();
        lb7 = new javax.swing.JLabel();
        txtdiachi = new javax.swing.JTextField();
        rbnam = new javax.swing.JRadioButton();
        rbnu = new javax.swing.JRadioButton();
        cbmacv = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txttaikhoan = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtmatkhau = new javax.swing.JTextField();
        txtngaysinh = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        bt_them = new javax.swing.JButton();
        bt_sua = new javax.swing.JButton();
        bt_xoa = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        bt_ghi = new javax.swing.JButton();
        bt_khong = new javax.swing.JButton();
        bt_lammoi = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_nhanvien = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txttimkiem = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1140, 780));
        setPreferredSize(new java.awt.Dimension(1140, 780));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Chi Tiết", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Montserrat", 0, 11))); // NOI18N

        lb1.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        lb1.setText("Mã Nhân Viên");

        txtmanv.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N

        lb2.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        lb2.setText("Tên Nhân Viên:");

        txttennv.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N

        lb3.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        lb3.setText("Mã Chức Vụ:");

        lb4.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        lb4.setText("Giới Tính:");

        lb5.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        lb5.setText("Ngày Sinh:");

        lb6.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        lb6.setText("Số ĐT:");

        txtsdt.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N

        lb7.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        lb7.setText("Địa Chỉ:");

        txtdiachi.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N

        rbnam.setBackground(new java.awt.Color(255, 255, 255));
        rbnam.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        rbnam.setText("Nam");
        rbnam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnamActionPerformed(evt);
            }
        });

        rbnu.setBackground(new java.awt.Color(255, 255, 255));
        rbnu.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        rbnu.setText("Nữ");

        cbmacv.setBackground(new java.awt.Color(255, 255, 255));
        cbmacv.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel2.setText("Tài Khoản");

        txttaikhoan.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel3.setText("Mật Khẩu");

        txtmatkhau.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N

        txtngaysinh.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txttaikhoan, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lb7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtngaysinh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                        .addComponent(txtsdt, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lb6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lb5, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lb3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lb1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtdiachi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtmatkhau, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lb2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                        .addComponent(txttennv, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtmanv, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(lb4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(46, 46, 46)
                            .addComponent(rbnam)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rbnu))
                        .addComponent(cbmacv, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb1)
                .addGap(0, 0, 0)
                .addComponent(txtmanv, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb2)
                .addGap(0, 0, 0)
                .addComponent(txttennv, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb3)
                .addGap(4, 4, 4)
                .addComponent(cbmacv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb4)
                    .addComponent(rbnam)
                    .addComponent(rbnu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(0, 0, 0)
                .addComponent(txttaikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb5)
                .addGap(0, 0, 0)
                .addComponent(txtngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb6)
                .addGap(0, 0, 0)
                .addComponent(txtsdt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(lb7)
                .addGap(0, 0, 0)
                .addComponent(txtdiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(0, 0, 0)
                .addComponent(txtmatkhau, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cập Nhật", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Montserrat", 0, 11))); // NOI18N

        bt_them.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        bt_them.setText("Thêm ");
        bt_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_themActionPerformed(evt);
            }
        });

        bt_sua.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        bt_sua.setText("Sửa ");
        bt_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_suaActionPerformed(evt);
            }
        });

        bt_xoa.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        bt_xoa.setText("Xóa");
        bt_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_xoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(bt_them)
                .addGap(38, 38, 38)
                .addComponent(bt_sua)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_xoa)
                .addGap(25, 25, 25))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_them)
                    .addComponent(bt_sua)
                    .addComponent(bt_xoa))
                .addGap(21, 21, 21))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Điều Khiển", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Montserrat", 0, 11))); // NOI18N

        bt_ghi.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        bt_ghi.setText("Ghi");
        bt_ghi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ghiActionPerformed(evt);
            }
        });

        bt_khong.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        bt_khong.setText("Không");
        bt_khong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_khongActionPerformed(evt);
            }
        });

        bt_lammoi.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        bt_lammoi.setText("Làm Mới");
        bt_lammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_lammoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(bt_ghi)
                .addGap(36, 36, 36)
                .addComponent(bt_khong)
                .addGap(40, 40, 40)
                .addComponent(bt_lammoi)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_ghi)
                    .addComponent(bt_khong)
                    .addComponent(bt_lammoi))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        tb_nhanvien.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        tb_nhanvien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Nhân Viên", "Tên Nhân Viên", "Mã Chức Vụ", "Giới Tính", "Ngày Sinh", "Số ĐT", "Địa Chỉ", "Tài Khoản", "Mật Khẩu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_nhanvien.setRowHeight(25);
        tb_nhanvien.setRowMargin(5);
        tb_nhanvien.setSelectionBackground(new java.awt.Color(255, 255, 255));
        tb_nhanvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_nhanvienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_nhanvien);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(190, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1)
                .addGap(28, 28, 28))
        );

        jPanel8.setBackground(new java.awt.Color(76, 41, 211));
        jPanel8.setMinimumSize(new java.awt.Dimension(1140, 70));

        jLabel1.setFont(new java.awt.Font("Century Schoolbook", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Employee manager");

        txttimkiem.setBackground(new java.awt.Color(123, 156, 225));
        txttimkiem.setBorder(null);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search_25px.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(392, 392, 392)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(143, 143, 143)
                .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bt_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_themActionPerformed
        // TODO add your handling code here:
        ktThem = true;
        macu = "";
        KhoaMo(true);
        txtmanv.requestFocus();
    }//GEN-LAST:event_bt_themActionPerformed

    private void bt_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_suaActionPerformed
        // TODO add your handling code here:
        if (txtmanv.getText().length() <= 0) {
            return;
        }
        macu = txtmanv.getText();
        ktThem = false;
        KhoaMo(true);
        txtmanv.requestFocus();

    }//GEN-LAST:event_bt_suaActionPerformed

    private void bt_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_xoaActionPerformed
        // TODO add your handling code here:
        if (txtmanv.getText().length() <= 0) {
            JOptionPane.showConfirmDialog(this, "Hãy nhập thông tin cần xoá!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        macu = txtmanv.getText();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getManv().equals(macu)) {
                int kq = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa khumg?", "Thông Báo", JOptionPane.YES_NO_OPTION);
                if (kq == JOptionPane.YES_OPTION) {
                    Data_QuanLy.XoaNhanVien(macu);
                    LoadDataArrayListToTable();
                } else {
                    JOptionPane.showConfirmDialog(this, "Không tìm thấy kết quả!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    txtmanv.requestFocus();
                }
            }
        }
        XoaTrang();
    }//GEN-LAST:event_bt_xoaActionPerformed

    private void bt_ghiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ghiActionPerformed
        // TODO add your handling code here:
        if (txtmanv.getText().length() <= 0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập mã nhân viên ", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            txtmanv.requestFocus();
            return;
        }
        if (Data_QuanLyKhachSan.KiemTraTrungMa("NhanVien", "MaNhanVien", txtmanv.getText(), ktThem, macu) == true) {
            JOptionPane.showMessageDialog(this, "Mã nhân viên đã tồn tại", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            txtmanv.requestFocus();
            return;
        }
        manv = txtmanv.getText();
        tennv = txttennv.getText();
        macv = (String) cbmacv.getSelectedItem();
        String gt;
        if (rbnam.isSelected()) {
            gt = "0";
        } else {
            gt = "1";
        }
        sdt = txtsdt.getText();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(txtngaysinh.getDate());

        diachi = txtdiachi.getText();
        taikhoan = txttaikhoan.getText();
        matkhau = txtmatkhau.getText();

        tbl_NhanVien nv = new tbl_NhanVien(manv, tennv, macv, gt, date, sdt, diachi, taikhoan, matkhau);
        if (ktThem == true) {
            Data_QuanLy.ThemNV(nv);
            JOptionPane.showMessageDialog(this, "Thêm mới thành công ");
        } else {
            Data_QuanLy.CapNhapNhanVien(nv, macu);
            JOptionPane.showMessageDialog(this, "Cập nhập thành công");
        }
        LoadDataArrayListToTable();
        KhoaMo(false);
    }//GEN-LAST:event_bt_ghiActionPerformed

    private void bt_khongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_khongActionPerformed
        // TODO add your handling code here:

        refresh(true);
    }//GEN-LAST:event_bt_khongActionPerformed

    private void bt_lammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_lammoiActionPerformed
        // TODO add your handling code here:
        XoaTrang();
    }//GEN-LAST:event_bt_lammoiActionPerformed

    private void tb_nhanvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_nhanvienMouseClicked
        // TODO add your handling code here:
        int index = tb_nhanvien.getSelectedRow();
        TableModel model = tb_nhanvien.getModel();
        manv = model.getValueAt(index, 0).toString();
        tennv = model.getValueAt(index, 1).toString();
        macv = model.getValueAt(index, 2).toString();
        gioitinh = model.getValueAt(index, 3).toString();
        Date date;
        try {

            date = new SimpleDateFormat("yyyy-MM-dd").parse(model.getValueAt(index, 4).toString());
            txtngaysinh.setDate(date);
        } catch (ParseException ex) {
            Logger.getLogger(JP_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        sdt = model.getValueAt(index, 5).toString();
        diachi = model.getValueAt(index, 6).toString();
        taikhoan = model.getValueAt(index, 7).toString();
        matkhau = model.getValueAt(index, 8).toString();

        txtmanv.setText(manv);
        txttennv.setText(tennv);
        txtsdt.setText(sdt);
        txtdiachi.setText(diachi);
        txttaikhoan.setText(taikhoan);
        txtmatkhau.setText(matkhau);

        if (gioitinh.equalsIgnoreCase("1")) {
            rbnam.setSelected(true);
            rbnu.setSelected(false);
        } else {
            rbnu.setSelected(true);
            rbnam.setSelected(false);
        }
        int i = 0;
        while (true) {
            String machucvu = cbmacv.getItemAt(i);
            if (machucvu.equalsIgnoreCase(macv)) {
                cbmacv.setSelectedIndex(i);
                break;
            }
            i++;

        }
    }//GEN-LAST:event_tb_nhanvienMouseClicked

    private void rbnamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbnamActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        timkiem = txttimkiem.getText();
        LoadDataArrayListToTable();
    }//GEN-LAST:event_jLabel8MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_ghi;
    private javax.swing.JButton bt_khong;
    private javax.swing.JButton bt_lammoi;
    private javax.swing.JButton bt_sua;
    private javax.swing.JButton bt_them;
    private javax.swing.JButton bt_xoa;
    private javax.swing.JComboBox<String> cbmacv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lb3;
    private javax.swing.JLabel lb4;
    private javax.swing.JLabel lb5;
    private javax.swing.JLabel lb6;
    private javax.swing.JLabel lb7;
    private javax.swing.JRadioButton rbnam;
    private javax.swing.JRadioButton rbnu;
    private javax.swing.JTable tb_nhanvien;
    private javax.swing.JTextField txtdiachi;
    private javax.swing.JTextField txtmanv;
    private javax.swing.JTextField txtmatkhau;
    private com.toedter.calendar.JDateChooser txtngaysinh;
    private javax.swing.JTextField txtsdt;
    private javax.swing.JTextField txttaikhoan;
    private javax.swing.JTextField txttennv;
    private javax.swing.JTextField txttimkiem;
    // End of variables declaration//GEN-END:variables
}
