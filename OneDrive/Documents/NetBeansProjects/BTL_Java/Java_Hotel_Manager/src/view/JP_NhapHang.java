package view;

import control.Data_HangHoa;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.tbl_HangHoa;
import model.tbl_Nhacungcap;
import model.tbl_NhapHang;

public class JP_NhapHang extends javax.swing.JPanel {

    private static String manhap, masp, nhacungcap, dvt, loaihang, ngaynhap, gianhap,timkiem, m;
    private static int soluong ;
    private static boolean ktThem, ktxoa;
    private static String mcsp, mcncc, mcnh;
    DefaultTableModel model;
    List<tbl_NhapHang> list;
    
    
    public JP_NhapHang() {
        initComponents();
        ppmasp.add(panelmasp);
        ppncc.add(panelncc);
        updateDateTimeLabel();
        LoadJListMaSP();
        LoadJListNCC();
        LoadArrayNhapHangListToTable();
        LoadArrayListToTable();
    }

    public void LoadJListMaSP() {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        List<tbl_HangHoa> hh = Data_HangHoa.LoadDataHangHoaToArrayList(m);
        masp = txtmasp.getText().toLowerCase();
        for (tbl_HangHoa o : hh) {
            if (o.getTenhang().toLowerCase().contains(masp.toLowerCase())) {
                listModel.addElement(o.getMahang() + "-" + o.getTenhang());
            }
        }
        jlistmasp.setModel(listModel);

    }

    public void LoadJListNCC() {
        DefaultListModel<String> listncc = new DefaultListModel<>();
        List<tbl_Nhacungcap> ncc = Data_HangHoa.LoadDatanccToArrayList();
        nhacungcap = txtncc.getText().toLowerCase();
        for (tbl_Nhacungcap o : ncc) {
            if (o.getTenct().toLowerCase().contains(nhacungcap)) {
                listncc.addElement(o.getMact() + "-" + o.getTenct());
            }
        }
        jlistncc.setModel(listncc);
    }

    public void KhoaMo(boolean b) {
//        txtmasp.setEditable(b);
//        txttensp.setEditable(b);
//        txtmact.setEditable(b);
//        txtloaihang.setEditable(b);
//        txtsoluong.setEditable(b);
//        txtgianhap.setEditable(b);
//        txtgiaban.setEditable(b);
//        cbdvt.setEditable(b);

        btnhaphang.setEnabled(!b);
        btsua.setEnabled(!b);
        btxoa.setEnabled(!b);
//        btghi.setEnabled(b);
//        btkhong.setEnabled(b);
//        btketthuc.setEnabled(!b);

    }
    
     public void refresh(boolean b) {
        txtmasp.setEditable(b);
        txtncc.setEditable(b);
        txtsoluong.setEditable(b);
        txtloaihang.setEditable(b);
        txtmanhap.setEditable(b);
        cbdvt.setEditable(b);
        txtgianhap.setEnabled(!b);
      
        btnhaphang.setEnabled(b);
        btsua.setEnabled(b);
        btxoa.setEnabled(b);
        btghi.setEnabled(b);
        btkhong.setEnabled(b);
    }
    public void XoaTrang() {
        txtmasp.setText("");
        txtncc.setText("");
        cbdvt.setSelectedIndex(0);
        txtgianhap.setText("");
        txtsoluong.setText("");
        txtloaihang.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ppncc = new javax.swing.JPopupMenu();
        panelmasp = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jlistmasp = new javax.swing.JList<>();
        ppmasp = new javax.swing.JPopupMenu();
        panelncc = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jlistncc = new javax.swing.JList<>();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtmanhap = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtmasp = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtncc = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtloaihang = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtsoluong = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbdvt = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtgianhap = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txttimkiem = new javax.swing.JTextField();
        bttimkiem = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnhaphang = new javax.swing.JButton();
        btsua = new javax.swing.JButton();
        btxoa = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btghi = new javax.swing.JButton();
        btkhong = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtngaynhap = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbnhaphang = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbhanghoa = new javax.swing.JTable();

        jlistmasp.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jlistmasp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlistmaspMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jlistmasp);

        javax.swing.GroupLayout panelmaspLayout = new javax.swing.GroupLayout(panelmasp);
        panelmasp.setLayout(panelmaspLayout);
        panelmaspLayout.setHorizontalGroup(
            panelmaspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
        );
        panelmaspLayout.setVerticalGroup(
            panelmaspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
        );

        jlistncc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlistnccMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jlistncc);

        javax.swing.GroupLayout panelnccLayout = new javax.swing.GroupLayout(panelncc);
        panelncc.setLayout(panelnccLayout);
        panelnccLayout.setHorizontalGroup(
            panelnccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelnccLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelnccLayout.setVerticalGroup(
            panelnccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelnccLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                .addContainerGap())
        );

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(76, 41, 211));
        jPanel6.setMinimumSize(new java.awt.Dimension(1140, 70));

        jLabel1.setFont(new java.awt.Font("Century Schoolbook", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Service management");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(410, 410, 410)
                .addComponent(jLabel1)
                .addGap(403, 403, 403))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel10.setText("Mã nhập:");

        txtmanhap.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel2.setText("Mã sản phẩm:");

        txtmasp.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        txtmasp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtmaspKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel4.setText("Nhà cung cấp:");

        txtncc.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        txtncc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnccKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel8.setText("Loại Hàng:");

        txtloaihang.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel5.setText("Số lượng:");

        txtsoluong.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel6.setText("Đơn vị tính:");

        cbdvt.setBackground(new java.awt.Color(255, 255, 255));
        cbdvt.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        cbdvt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chai", "Lon", "Chiếc" }));

        jLabel7.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel7.setText("Giá Nhập:");

        txtgianhap.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm Kiếm"));

        jLabel3.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel3.setText("Nhập từ khóa cần tìm");

        txttimkiem.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N

        bttimkiem.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        bttimkiem.setText("Chọn");
        bttimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttimkiemActionPerformed(evt);
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
                        .addGap(6, 6, 6)
                        .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bttimkiem))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cập nhập"));

        btnhaphang.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        btnhaphang.setText("Nhập Hàng");
        btnhaphang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhaphangActionPerformed(evt);
            }
        });

        btsua.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        btsua.setText("Sửa");
        btsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsuaActionPerformed(evt);
            }
        });

        btxoa.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        btxoa.setText("Xóa");
        btxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btxoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnhaphang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btsua)
                .addGap(32, 32, 32)
                .addComponent(btxoa)
                .addGap(16, 16, 16))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnhaphang)
                    .addComponent(btxoa)
                    .addComponent(btsua))
                .addGap(0, 14, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Điều Khiển"));

        btghi.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        btghi.setText("Ghi");
        btghi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btghiActionPerformed(evt);
            }
        });

        btkhong.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        btkhong.setText("Không");
        btkhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btkhongActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        jButton2.setText("Làm mới");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btghi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btkhong)
                .addGap(32, 32, 32)
                .addComponent(jButton2)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btghi)
                    .addComponent(btkhong)
                    .addComponent(jButton2))
                .addGap(0, 14, Short.MAX_VALUE))
        );

        jLabel9.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jLabel9.setText("Ngày Nhập");

        txtngaynhap.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        txtngaynhap.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbdvt, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtngaynhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtgianhap)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtsoluong)
                    .addComponent(txtloaihang)
                    .addComponent(txtncc)
                    .addComponent(txtmasp)
                    .addComponent(txtmanhap))
                .addGap(18, 18, 18))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtmanhap, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtmasp, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtncc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtloaihang, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel6)
                .addGap(1, 1, 1)
                .addComponent(cbdvt, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtgianhap, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtngaynhap, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        tbnhaphang.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        tbnhaphang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Nhập", "Mã sản phẩm", "Nhà Cung Cấp", "Số lượng", "Loại Hàng", "Đơn vị tính", "Giá Nhập", "Ngày nhập"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbnhaphang.setRowHeight(25);
        tbnhaphang.setRowMargin(5);
        tbnhaphang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbnhaphangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbnhaphang);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        tbhanghoa.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        tbhanghoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Hàng", "Tên Hàng", "Mã Công Ty", "Loại Hàng", "Số Lượng", "Đơn Vị Tính", "Giá Nhập", "Giá Bán"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbhanghoa.setRowHeight(25);
        tbhanghoa.setRowMargin(5);
        jScrollPane4.setViewportView(tbhanghoa);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE)
                .addGap(11, 11, 11))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jlistmaspMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlistmaspMouseClicked
        // TODO add your handling code here:
        int selectedIndex = jlistmasp.getSelectedIndex();//llaasy vị trí
        String selectedValue = jlistmasp.getSelectedValue();//lấy giá trị
        String[] values = selectedValue.split("-");//chia chuỗi
        String mact = values[0];
        txtmasp.setText(mact);
    }//GEN-LAST:event_jlistmaspMouseClicked

    private void jlistnccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlistnccMouseClicked
        // TODO add your handling code here:
        int selectedIndex = jlistncc.getSelectedIndex();//llaasy vị trí
        String selectedValue = jlistncc.getSelectedValue();//lấy giá trị
        String[] values = selectedValue.split("-");//chia chuỗi
        String mact = values[0];
        txtncc.setText(mact);
    }//GEN-LAST:event_jlistnccMouseClicked

    private void txtmaspKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmaspKeyReleased
        // TODO add your handling code here:
        ppmasp.show(txtmasp, 0, txtmasp.getHeight());
    }//GEN-LAST:event_txtmaspKeyReleased

    private void txtnccKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnccKeyReleased
        // TODO add your handling code here:
        ppncc.show(txtncc, 0, txtncc.getHeight());
    }//GEN-LAST:event_txtnccKeyReleased

    private void bttimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttimkiemActionPerformed
        // TODO add your handling code here:
        timkiem = txttimkiem.getText();
        LoadArrayNhapHangListToTable();
    }//GEN-LAST:event_bttimkiemActionPerformed

    private void btnhaphangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhaphangActionPerformed
        // TODO add your handling code here:
        ktThem = true;
        mcnh = "";
        KhoaMo(true);
    }//GEN-LAST:event_btnhaphangActionPerformed

    private void btsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsuaActionPerformed
        // TODO add your handling code here:
        if (txtmasp.getText().length() <= 0) {
            return;
        }
        ktThem = false;
        mcnh = txtmanhap.getText();
        mcsp = txtmasp.getText();
        mcncc = txtncc.getText();

        txtmanhap.setEnabled(false);
        KhoaMo(true);
    }//GEN-LAST:event_btsuaActionPerformed

    private void btxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btxoaActionPerformed
        // TODO add your handling code here:
        ktxoa = true;
        mcnh = txtmanhap.getText();
        mcsp = txtmasp.getText();
        mcncc = txtncc.getText();
        KhoaMo(true);
    }//GEN-LAST:event_btxoaActionPerformed

    private void btghiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btghiActionPerformed
        // TODO add your handling code here:
        if (txtmanhap.getText().length() <= 0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập mã nhập hàng.", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            txtmanhap.requestFocus();
            return;
        }
        if (txtmasp.getText().length() <= 0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập mã sản phẩm", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            txtmasp.requestFocus();
            return;
        }
        if (txtncc.getText().length() <= 0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập nhà cung cấp", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            txtncc.requestFocus();
            return;
        }
        if (Data_HangHoa.KiemTraTrungMa("nhaphang", "MaNhapHang", txtmanhap.getText(), ktThem, mcnh) == true) {
            JOptionPane.showMessageDialog(this, "Mã Nhập Hàng đã tồn tại ", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            txtmanhap.requestFocus();
            return;
        }
        if (Data_HangHoa.KiemTraTrungMa("mathang", "MaHang", txtmasp.getText(), ktThem, m) == false) {
            JOptionPane.showMessageDialog(this, "Mã Hàng không tồn tại ", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            txtmasp.requestFocus();
            return;
        }
        if (Data_HangHoa.KiemTraTrungMa("nhacungcap", "MaCongTy", txtncc.getText(), ktThem, m) == false) {
            JOptionPane.showMessageDialog(this, "Mã Công Ty không  tồn tại ", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            txtncc.requestFocus();
            return;
        }
        manhap = txtmanhap.getText();
        masp = txtmasp.getText();
        nhacungcap = txtncc.getText();
        ngaynhap = txtngaynhap.getText();
        loaihang = txtloaihang.getText();
        soluong = Integer.parseInt(txtsoluong.getText());
        dvt = (String) cbdvt.getSelectedItem();
        
        Locale locale = new Locale("vi","VN");
        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance(locale);
        char decimalSeparator = symbols.getDecimalSeparator();
        NumberFormat format = NumberFormat.getCurrencyInstance(locale);
        format.setRoundingMode(RoundingMode.HALF_UP);
        double gianhap1 = Double.parseDouble(txtgianhap.getText().replaceAll("[^\\d" + decimalSeparator + "]+", ""));
        gianhap=format.format(gianhap1) ;
       

        tbl_NhapHang nh = new tbl_NhapHang(manhap, masp, nhacungcap, soluong, loaihang, dvt, gianhap, ngaynhap);

        if (ktThem == true) {
            try {
                Data_HangHoa.NhapHangHoa(nh);
                JOptionPane.showMessageDialog(this, "Nhập hàng thành công");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng Mã công ty cung cấp sản phẩm ", "Thông Báo", JOptionPane.ERROR_MESSAGE);
                return;
            }

        }
        if(ktThem==false &ktxoa==false){
            try {
                Data_HangHoa.SuaHangHoa(nh, mcnh, manhap, mcsp, masp, mcncc);
                JOptionPane.showMessageDialog(this, "Sửa hàng thành công");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng Mã công ty cung cấp sản phẩm ", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            }
        }
        if ( ktxoa == true ) {

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getMaNhap().equals(mcnh)) {
                    int kq = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa đơn nhập này không?", "Thông Báo", JOptionPane.YES_NO_OPTION);
                    if (kq == JOptionPane.YES_OPTION) {
                        Data_HangHoa.XoaNhapHang(nh, mcnh, mcsp, mcncc);
                        XoaTrang();

                    } else {
                        JOptionPane.showConfirmDialog(this, "Không tìm thấy kết quả!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        txtmasp.requestFocus();
                    }
                }
            }
        }
        LoadArrayNhapHangListToTable();
        LoadArrayListToTable();
        KhoaMo(false);
    }//GEN-LAST:event_btghiActionPerformed

    private void btkhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btkhongActionPerformed
        // TODO add your handling code here:
        XoaTrang();
        refresh(true);
        ktThem = true;
    }//GEN-LAST:event_btkhongActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        XoaTrang();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tbnhaphangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbnhaphangMouseClicked
        // TODO add your handling code here:
        int index = tbnhaphang.getSelectedRow();
        TableModel model = tbnhaphang.getModel();
        manhap = model.getValueAt(index, 0).toString();
        masp = model.getValueAt(index, 1).toString();
        nhacungcap = model.getValueAt(index, 2).toString();
        soluong = Integer.parseInt(model.getValueAt(index, 3).toString());
        loaihang = model.getValueAt(index, 4).toString();
        dvt = model.getValueAt(index, 5).toString();
        gianhap = model.getValueAt(index, 6).toString();
        ngaynhap = model.getValueAt(index, 7).toString();

        txtmanhap.setText(manhap);
        txtmasp.setText(masp);
        txtncc.setText(nhacungcap);
        txtloaihang.setText(loaihang);
        txtsoluong.setText(String.valueOf(soluong));
        cbdvt.setSelectedItem(dvt);
        txtgianhap.setText(gianhap);
        txtngaynhap.setText(ngaynhap);
    }//GEN-LAST:event_tbnhaphangMouseClicked

    public void LoadArrayNhapHangListToTable() {
        list = Data_HangHoa.LoadDataNhapHangToArrayList(timkiem);
        model = (DefaultTableModel) tbnhaphang.getModel();
        model.setRowCount(0);
        Locale locale = new Locale("vi","VN");
        NumberFormat format = NumberFormat.getCurrencyInstance(locale);
        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance(locale);
        char decimalSeparator = symbols.getDecimalSeparator();
        for (tbl_NhapHang hh : list) {
             String gianhapString = hh.getGiaNhap().replace(",", "");
            double gianhap = Double.parseDouble(gianhapString.replaceAll("[^\\d" + decimalSeparator + "]+", ""));
            String formattedgianhap = format.format(gianhap);
            model.addRow(new Object[]{hh.getMaNhap(), hh.getMaHang(), hh.getMaCongTy(), hh.getSoluong(), hh.getLoaiHang(), hh.getDonViTinh(), formattedgianhap, hh.getNgayNhap()});
        }
    }

    public void LoadArrayListToTable() {
        List<tbl_HangHoa> list;
        list = Data_HangHoa.LoadDataHangHoaToArrayList(m);
        model = (DefaultTableModel) tbhanghoa.getModel();
        model.setRowCount(0);
         Locale locale = new Locale("vi","VN");
         NumberFormat format = NumberFormat.getCurrencyInstance(locale);
         DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance(locale);
         char decimalSeparator = symbols.getDecimalSeparator();
         format.setRoundingMode(RoundingMode.HALF_UP);
        for (tbl_HangHoa hh : list) {
            String gianhapString = hh.getGianhap().replace(",", "");
             String giabanpString = hh.getGiaban().replace(",", "");
            double gianhap = Double.parseDouble(gianhapString.replaceAll("[^\\d" + decimalSeparator + "]+", ""));
            double giaban = Double.parseDouble(giabanpString.replaceAll("[^\\d" + decimalSeparator + "]+", ""));
            String formattedgianhap = format.format(gianhap);
            String formattedgiaban = format.format(giaban);
            model.addRow(new Object[]{hh.getMahang(), hh.getTenhang(), hh.getMacongty(), hh.getLoaihang(), hh.getSoluong(), hh.getDonvitinh(), formattedgianhap, formattedgiaban});
        }
    }
    
    private void updateDateTimeLabel() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = currentDate.format(formatter);
        txtngaynhap.setText(formattedDate);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btghi;
    private javax.swing.JButton btkhong;
    private javax.swing.JButton btnhaphang;
    private javax.swing.JButton btsua;
    private javax.swing.JButton bttimkiem;
    private javax.swing.JButton btxoa;
    private javax.swing.JComboBox<String> cbdvt;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JList<String> jlistmasp;
    private javax.swing.JList<String> jlistncc;
    private javax.swing.JPanel panelmasp;
    private javax.swing.JPanel panelncc;
    private javax.swing.JPopupMenu ppmasp;
    private javax.swing.JPopupMenu ppncc;
    private javax.swing.JTable tbhanghoa;
    private javax.swing.JTable tbnhaphang;
    private javax.swing.JTextField txtgianhap;
    private javax.swing.JTextField txtloaihang;
    private javax.swing.JTextField txtmanhap;
    private javax.swing.JTextField txtmasp;
    private javax.swing.JTextField txtncc;
    private javax.swing.JLabel txtngaynhap;
    private javax.swing.JTextField txtsoluong;
    private javax.swing.JTextField txttimkiem;
    // End of variables declaration//GEN-END:variables
}
