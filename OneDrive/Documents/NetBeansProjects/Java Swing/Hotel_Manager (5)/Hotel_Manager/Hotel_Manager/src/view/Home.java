package view;

import bean.chuyenmanhinh_bean;
import control.control_chuyenmanhinh;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Home extends javax.swing.JFrame {
    
    public Home() {
        initComponents();
        Home.this.getRootPane().setBorder(new LineBorder(new Color(76, 41, 211)));
        lblTitle.setText(this.getTitle());
        control_chuyenmanhinh contronller = new control_chuyenmanhinh(jp_ScreenMain);
        List<chuyenmanhinh_bean> listItem = new ArrayList<>();
        listItem.add(new chuyenmanhinh_bean("QuanLyChucVu",btn_qlchucvu,lb_chucvu));
        listItem.add(new chuyenmanhinh_bean("QuanLyPhong",btn_qlphong,lb_phong));
        listItem.add(new chuyenmanhinh_bean("QuanLyDichVu",btn_qldichvu,lb_dichvu));
        listItem.add(new chuyenmanhinh_bean("QuanLyNhanVien",btn_qlnhanvien,lb_nhanvien));
        listItem.add(new chuyenmanhinh_bean("QuanLyKhachHang",btn_qlkhachhang,lb_khachhang));
        listItem.add(new chuyenmanhinh_bean("PhieuDatPhong",btn_phieudatphong,lb_phieudatphong));
        listItem.add(new chuyenmanhinh_bean("SuaPhieuDatPhong",btn_suaphieudatphong,lb_Suaphieudatphong));
        //listItem.add(new chuyenmanhinh_bean("HoaDon",btn_hoadon,lb_hoadon));
        listItem.add(new chuyenmanhinh_bean("KhoHang",btn_khohang,lb_khohang));
        listItem.add(new chuyenmanhinh_bean("NhapHang",btn_nhaphang,lb_nhaphang));
        listItem.add(new chuyenmanhinh_bean("Home",btn_home,lb_home));
        contronller.setEvent(listItem);

        pnlTop.remove(pnlTitle);
        pnlTop.add(pnlTitle, BorderLayout.WEST);
        pnlTop.add(pnlActions, BorderLayout.EAST);

        pnlActions.remove(lblClose);
        pnlActions.remove(lblMaximize);
        pnlActions.remove(lblMinimize);

        pnlActions.add(lblMinimize);
        pnlActions.add(lblMaximize);
        pnlActions.add(lblClose);

        pnlTitle.remove(lblTitle);
        pnlTitle.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 8));
        pnlTitle.add(lblTitle);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTop = new javax.swing.JPanel();
        pnlActions = new javax.swing.JPanel();
        lblMinimize = new javax.swing.JLabel();
        lblMaximize = new javax.swing.JLabel();
        lblClose = new javax.swing.JLabel();
        pnlTitle = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        pnlParent = new javax.swing.JPanel();
        sidepane = new javax.swing.JPanel();
        btn_qlnhanvien = new javax.swing.JPanel();
        ind_nhanvien = new javax.swing.JPanel();
        lb_nhanvien = new javax.swing.JLabel();
        btn_qlphong = new javax.swing.JPanel();
        ind_phong = new javax.swing.JPanel();
        lb_phong = new javax.swing.JLabel();
        btn_qlchucvu = new javax.swing.JPanel();
        ind_chucvu = new javax.swing.JPanel();
        lb_chucvu = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btn_qldichvu = new javax.swing.JPanel();
        ind_dichvu = new javax.swing.JPanel();
        lb_dichvu = new javax.swing.JLabel();
        btn_qlkhachhang = new javax.swing.JPanel();
        ind_khachhang = new javax.swing.JPanel();
        lb_khachhang = new javax.swing.JLabel();
        btn_phieudatphong = new javax.swing.JPanel();
        ind_phieudatphong = new javax.swing.JPanel();
        lb_phieudatphong = new javax.swing.JLabel();
        btn_phieudichvu = new javax.swing.JPanel();
        ind_phieudichvu = new javax.swing.JPanel();
        lb_phieudichvu = new javax.swing.JLabel();
        btn_hoadon = new javax.swing.JPanel();
        ind_hoadon = new javax.swing.JPanel();
        lb_hoadon = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btn_home = new javax.swing.JPanel();
        lb_home = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        btn_nhaphang = new javax.swing.JPanel();
        ind_nhaphang = new javax.swing.JPanel();
        lb_nhaphang = new javax.swing.JLabel();
        btn_khohang = new javax.swing.JPanel();
        ind_khohang = new javax.swing.JPanel();
        lb_khohang = new javax.swing.JLabel();
        btn_suaphieudatphong = new javax.swing.JPanel();
        ind_suaphieudatphong = new javax.swing.JPanel();
        lb_Suaphieudatphong = new javax.swing.JLabel();
        jp_ScreenMain = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(1380, 780));
        setUndecorated(true);
        setResizable(false);

        pnlTop.setBackground(new java.awt.Color(50, 27, 140));
        pnlTop.setMinimumSize(new java.awt.Dimension(1440, 30));
        pnlTop.setPreferredSize(new java.awt.Dimension(1440, 30));
        pnlTop.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlTopMouseDragged(evt);
            }
        });
        pnlTop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlTopMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlTopMousePressed(evt);
            }
        });
        pnlTop.setLayout(new java.awt.BorderLayout());

        pnlActions.setBackground(new java.awt.Color(50, 27, 140));
        pnlActions.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        lblMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_minus_18px_1.png"))); // NOI18N
        lblMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblMinimizeMousePressed(evt);
            }
        });
        pnlActions.add(lblMinimize);

        lblMaximize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_rectangle_stroked_18px.png"))); // NOI18N
        lblMaximize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblMaximizeMousePressed(evt);
            }
        });
        pnlActions.add(lblMaximize);

        lblClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_multiply_18px_1.png"))); // NOI18N
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblCloseMousePressed(evt);
            }
        });
        pnlActions.add(lblClose);

        pnlTop.add(pnlActions, java.awt.BorderLayout.LINE_END);

        pnlTitle.setBackground(new java.awt.Color(50, 27, 140));
        pnlTitle.setPreferredSize(new java.awt.Dimension(200, 30));
        pnlTitle.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 8));

        lblTitle.setForeground(new java.awt.Color(204, 204, 204));
        lblTitle.setText("Steam");
        pnlTitle.add(lblTitle);

        pnlTop.add(pnlTitle, java.awt.BorderLayout.LINE_START);

        pnlParent.setLayout(new java.awt.BorderLayout());

        sidepane.setBackground(new java.awt.Color(76, 41, 211));
        sidepane.setMinimumSize(new java.awt.Dimension(300, 780));
        sidepane.setPreferredSize(new java.awt.Dimension(300, 780));
        sidepane.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                sidepaneMouseDragged(evt);
            }
        });
        sidepane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sidepaneMousePressed(evt);
            }
        });

        btn_qlnhanvien.setBackground(new java.awt.Color(76, 41, 211));
        btn_qlnhanvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_qlnhanvienMousePressed(evt);
            }
        });
        btn_qlnhanvien.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ind_nhanvien.setOpaque(false);
        ind_nhanvien.setPreferredSize(new java.awt.Dimension(4, 40));

        javax.swing.GroupLayout ind_nhanvienLayout = new javax.swing.GroupLayout(ind_nhanvien);
        ind_nhanvien.setLayout(ind_nhanvienLayout);
        ind_nhanvienLayout.setHorizontalGroup(
            ind_nhanvienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        ind_nhanvienLayout.setVerticalGroup(
            ind_nhanvienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        btn_qlnhanvien.add(ind_nhanvien, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        lb_nhanvien.setFont(new java.awt.Font("Montserrat Light", 1, 14)); // NOI18N
        lb_nhanvien.setForeground(new java.awt.Color(255, 255, 255));
        lb_nhanvien.setText("Nhân Viên");
        btn_qlnhanvien.add(lb_nhanvien, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, -2, -1, 30));

        btn_qlphong.setBackground(new java.awt.Color(76, 41, 211));
        btn_qlphong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_qlphongMousePressed(evt);
            }
        });
        btn_qlphong.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ind_phong.setOpaque(false);
        ind_phong.setPreferredSize(new java.awt.Dimension(4, 40));

        javax.swing.GroupLayout ind_phongLayout = new javax.swing.GroupLayout(ind_phong);
        ind_phong.setLayout(ind_phongLayout);
        ind_phongLayout.setHorizontalGroup(
            ind_phongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        ind_phongLayout.setVerticalGroup(
            ind_phongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        btn_qlphong.add(ind_phong, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        lb_phong.setFont(new java.awt.Font("Montserrat Light", 1, 14)); // NOI18N
        lb_phong.setForeground(new java.awt.Color(255, 255, 255));
        lb_phong.setText("Phòng");
        btn_qlphong.add(lb_phong, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, -2, -1, 30));

        btn_qlchucvu.setBackground(new java.awt.Color(76, 41, 211));
        btn_qlchucvu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_qlchucvuMousePressed(evt);
            }
        });
        btn_qlchucvu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ind_chucvu.setOpaque(false);
        ind_chucvu.setPreferredSize(new java.awt.Dimension(4, 40));

        javax.swing.GroupLayout ind_chucvuLayout = new javax.swing.GroupLayout(ind_chucvu);
        ind_chucvu.setLayout(ind_chucvuLayout);
        ind_chucvuLayout.setHorizontalGroup(
            ind_chucvuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        ind_chucvuLayout.setVerticalGroup(
            ind_chucvuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        btn_qlchucvu.add(ind_chucvu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        lb_chucvu.setFont(new java.awt.Font("Montserrat Light", 1, 14)); // NOI18N
        lb_chucvu.setForeground(new java.awt.Color(255, 255, 255));
        lb_chucvu.setText("Chức Vụ");
        btn_qlchucvu.add(lb_chucvu, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, -2, -1, 30));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Manager");

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Bill");

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Warehouse");

        btn_qldichvu.setBackground(new java.awt.Color(76, 41, 211));
        btn_qldichvu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_qldichvuMousePressed(evt);
            }
        });
        btn_qldichvu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ind_dichvu.setOpaque(false);
        ind_dichvu.setPreferredSize(new java.awt.Dimension(4, 40));

        javax.swing.GroupLayout ind_dichvuLayout = new javax.swing.GroupLayout(ind_dichvu);
        ind_dichvu.setLayout(ind_dichvuLayout);
        ind_dichvuLayout.setHorizontalGroup(
            ind_dichvuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        ind_dichvuLayout.setVerticalGroup(
            ind_dichvuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        btn_qldichvu.add(ind_dichvu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        lb_dichvu.setFont(new java.awt.Font("Montserrat Light", 1, 14)); // NOI18N
        lb_dichvu.setForeground(new java.awt.Color(255, 255, 255));
        lb_dichvu.setText("Dịch Vụ");
        btn_qldichvu.add(lb_dichvu, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, -2, -1, 30));

        btn_qlkhachhang.setBackground(new java.awt.Color(76, 41, 211));
        btn_qlkhachhang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_qlkhachhangMousePressed(evt);
            }
        });
        btn_qlkhachhang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ind_khachhang.setOpaque(false);
        ind_khachhang.setPreferredSize(new java.awt.Dimension(4, 40));

        javax.swing.GroupLayout ind_khachhangLayout = new javax.swing.GroupLayout(ind_khachhang);
        ind_khachhang.setLayout(ind_khachhangLayout);
        ind_khachhangLayout.setHorizontalGroup(
            ind_khachhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        ind_khachhangLayout.setVerticalGroup(
            ind_khachhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        btn_qlkhachhang.add(ind_khachhang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        lb_khachhang.setFont(new java.awt.Font("Montserrat Light", 1, 14)); // NOI18N
        lb_khachhang.setForeground(new java.awt.Color(255, 255, 255));
        lb_khachhang.setText("Khách Hàng");
        btn_qlkhachhang.add(lb_khachhang, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, -2, -1, 30));

        btn_phieudatphong.setBackground(new java.awt.Color(76, 41, 211));
        btn_phieudatphong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_phieudatphongMousePressed(evt);
            }
        });
        btn_phieudatphong.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ind_phieudatphong.setOpaque(false);
        ind_phieudatphong.setPreferredSize(new java.awt.Dimension(4, 40));

        javax.swing.GroupLayout ind_phieudatphongLayout = new javax.swing.GroupLayout(ind_phieudatphong);
        ind_phieudatphong.setLayout(ind_phieudatphongLayout);
        ind_phieudatphongLayout.setHorizontalGroup(
            ind_phieudatphongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        ind_phieudatphongLayout.setVerticalGroup(
            ind_phieudatphongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        btn_phieudatphong.add(ind_phieudatphong, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        lb_phieudatphong.setFont(new java.awt.Font("Montserrat Light", 1, 14)); // NOI18N
        lb_phieudatphong.setForeground(new java.awt.Color(255, 255, 255));
        lb_phieudatphong.setText("Phiếu Đặt Phòng");
        btn_phieudatphong.add(lb_phieudatphong, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, -1, 30));

        btn_phieudichvu.setBackground(new java.awt.Color(76, 41, 211));
        btn_phieudichvu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_phieudichvuMousePressed(evt);
            }
        });
        btn_phieudichvu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ind_phieudichvu.setOpaque(false);
        ind_phieudichvu.setPreferredSize(new java.awt.Dimension(4, 40));

        javax.swing.GroupLayout ind_phieudichvuLayout = new javax.swing.GroupLayout(ind_phieudichvu);
        ind_phieudichvu.setLayout(ind_phieudichvuLayout);
        ind_phieudichvuLayout.setHorizontalGroup(
            ind_phieudichvuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        ind_phieudichvuLayout.setVerticalGroup(
            ind_phieudichvuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        btn_phieudichvu.add(ind_phieudichvu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        lb_phieudichvu.setFont(new java.awt.Font("Montserrat Light", 1, 14)); // NOI18N
        lb_phieudichvu.setForeground(new java.awt.Color(255, 255, 255));
        lb_phieudichvu.setText("Phiếu Dịch Vụ");
        btn_phieudichvu.add(lb_phieudichvu, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, -1, 30));

        btn_hoadon.setBackground(new java.awt.Color(76, 41, 211));
        btn_hoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_hoadonMousePressed(evt);
            }
        });
        btn_hoadon.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ind_hoadon.setOpaque(false);
        ind_hoadon.setPreferredSize(new java.awt.Dimension(4, 40));

        javax.swing.GroupLayout ind_hoadonLayout = new javax.swing.GroupLayout(ind_hoadon);
        ind_hoadon.setLayout(ind_hoadonLayout);
        ind_hoadonLayout.setHorizontalGroup(
            ind_hoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        ind_hoadonLayout.setVerticalGroup(
            ind_hoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        btn_hoadon.add(ind_hoadon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        lb_hoadon.setFont(new java.awt.Font("Montserrat Light", 1, 14)); // NOI18N
        lb_hoadon.setForeground(new java.awt.Color(255, 255, 255));
        lb_hoadon.setText("Hoá Đơn");
        btn_hoadon.add(lb_hoadon, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, -1, 30));

        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Statistical");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Logout_20px.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Logout");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("About me");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/about_20px.png"))); // NOI18N

        jPanel2.setPreferredSize(new java.awt.Dimension(300, 2));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Manager_20px.png"))); // NOI18N

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bill_20px.png"))); // NOI18N

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/warehouse_20px.png"))); // NOI18N

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/sta_20px.png"))); // NOI18N

        btn_home.setBackground(new java.awt.Color(76, 41, 211));

        lb_home.setFont(new java.awt.Font("Century Schoolbook", 0, 36)); // NOI18N
        lb_home.setForeground(new java.awt.Color(255, 255, 255));
        lb_home.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_home.setText("Manager");

        jLabel18.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Hotel App");

        javax.swing.GroupLayout btn_homeLayout = new javax.swing.GroupLayout(btn_home);
        btn_home.setLayout(btn_homeLayout);
        btn_homeLayout.setHorizontalGroup(
            btn_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lb_home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btn_homeLayout.setVerticalGroup(
            btn_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_homeLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel18)
                .addGap(0, 0, 0)
                .addComponent(lb_home)
                .addGap(24, 24, 24))
        );

        btn_nhaphang.setBackground(new java.awt.Color(76, 41, 211));
        btn_nhaphang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_nhaphangMousePressed(evt);
            }
        });
        btn_nhaphang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ind_nhaphang.setOpaque(false);
        ind_nhaphang.setPreferredSize(new java.awt.Dimension(4, 40));

        javax.swing.GroupLayout ind_nhaphangLayout = new javax.swing.GroupLayout(ind_nhaphang);
        ind_nhaphang.setLayout(ind_nhaphangLayout);
        ind_nhaphangLayout.setHorizontalGroup(
            ind_nhaphangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        ind_nhaphangLayout.setVerticalGroup(
            ind_nhaphangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        btn_nhaphang.add(ind_nhaphang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        lb_nhaphang.setFont(new java.awt.Font("Montserrat Light", 1, 14)); // NOI18N
        lb_nhaphang.setForeground(new java.awt.Color(255, 255, 255));
        lb_nhaphang.setText("Nhập Hàng");
        btn_nhaphang.add(lb_nhaphang, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, -2, -1, 30));

        btn_khohang.setBackground(new java.awt.Color(76, 41, 211));
        btn_khohang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_khohangMousePressed(evt);
            }
        });
        btn_khohang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ind_khohang.setOpaque(false);
        ind_khohang.setPreferredSize(new java.awt.Dimension(4, 40));

        javax.swing.GroupLayout ind_khohangLayout = new javax.swing.GroupLayout(ind_khohang);
        ind_khohang.setLayout(ind_khohangLayout);
        ind_khohangLayout.setHorizontalGroup(
            ind_khohangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        ind_khohangLayout.setVerticalGroup(
            ind_khohangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        btn_khohang.add(ind_khohang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        lb_khohang.setFont(new java.awt.Font("Montserrat Light", 1, 14)); // NOI18N
        lb_khohang.setForeground(new java.awt.Color(255, 255, 255));
        lb_khohang.setText("Kho Hang");
        btn_khohang.add(lb_khohang, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, -2, -1, 30));

        btn_suaphieudatphong.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ind_suaphieudatphong.setBackground(new java.awt.Color(76, 41, 211));
        ind_suaphieudatphong.setForeground(new java.awt.Color(255, 255, 255));

        lb_Suaphieudatphong.setFont(new java.awt.Font("Montserrat Light", 1, 14)); // NOI18N
        lb_Suaphieudatphong.setForeground(new java.awt.Color(255, 255, 255));
        lb_Suaphieudatphong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_Suaphieudatphong.setText("Sửa Phiếu Đặt Phòng");

        javax.swing.GroupLayout ind_suaphieudatphongLayout = new javax.swing.GroupLayout(ind_suaphieudatphong);
        ind_suaphieudatphong.setLayout(ind_suaphieudatphongLayout);
        ind_suaphieudatphongLayout.setHorizontalGroup(
            ind_suaphieudatphongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ind_suaphieudatphongLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(lb_Suaphieudatphong, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );
        ind_suaphieudatphongLayout.setVerticalGroup(
            ind_suaphieudatphongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ind_suaphieudatphongLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lb_Suaphieudatphong)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_suaphieudatphong.add(ind_suaphieudatphong, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 290, 50));

        javax.swing.GroupLayout sidepaneLayout = new javax.swing.GroupLayout(sidepane);
        sidepane.setLayout(sidepaneLayout);
        sidepaneLayout.setHorizontalGroup(
            sidepaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_qlchucvu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_qlphong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_qldichvu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_qlnhanvien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_qlkhachhang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_phieudatphong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_phieudichvu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_hoadon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
            .addComponent(btn_nhaphang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_khohang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(sidepaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sidepaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sidepaneLayout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(sidepaneLayout.createSequentialGroup()
                        .addGroup(sidepaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(sidepaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(sidepaneLayout.createSequentialGroup()
                                .addGap(124, 124, 124)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(sidepaneLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(sidepaneLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_suaphieudatphong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        sidepaneLayout.setVerticalGroup(
            sidepaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidepaneLayout.createSequentialGroup()
                .addComponent(btn_home, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(sidepaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(btn_qlchucvu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_qlphong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_qldichvu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_qlnhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_qlkhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(sidepaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_phieudatphong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_phieudichvu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_hoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_suaphieudatphong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(sidepaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_nhaphang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_khohang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(sidepaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sidepaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(sidepaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnlParent.add(sidepane, java.awt.BorderLayout.LINE_START);

        jp_ScreenMain.setBackground(new java.awt.Color(255, 255, 255));
        jp_ScreenMain.setMinimumSize(new java.awt.Dimension(1140, 810));
        jp_ScreenMain.setPreferredSize(new java.awt.Dimension(1140, 810));

        jLabel17.setFont(new java.awt.Font("Century Gothic", 1, 55)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("WELLCOME");
        jLabel17.setToolTipText("");

        jLabel16.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("We are happy for your return!");
        jLabel16.setToolTipText("");

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/wellcome in main.gif"))); // NOI18N

        javax.swing.GroupLayout jp_ScreenMainLayout = new javax.swing.GroupLayout(jp_ScreenMain);
        jp_ScreenMain.setLayout(jp_ScreenMainLayout);
        jp_ScreenMainLayout.setHorizontalGroup(
            jp_ScreenMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_ScreenMainLayout.createSequentialGroup()
                .addGap(232, 232, 232)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 713, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(195, 195, 195))
            .addGroup(jp_ScreenMainLayout.createSequentialGroup()
                .addGap(285, 285, 285)
                .addGroup(jp_ScreenMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE))
                .addContainerGap())
        );
        jp_ScreenMainLayout.setVerticalGroup(
            jp_ScreenMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_ScreenMainLayout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlParent.add(jp_ScreenMain, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTop, javax.swing.GroupLayout.PREFERRED_SIZE, 1440, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pnlParent, javax.swing.GroupLayout.PREFERRED_SIZE, 1440, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlParent, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setSize(new java.awt.Dimension(1440, 810));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    int xy, xx;
    private void pnlTopMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlTopMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_pnlTopMouseDragged

    private void pnlTopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlTopMouseClicked
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            if (Home.this.getExtendedState() == MAXIMIZED_BOTH) {
                Home.this.setExtendedState(JFrame.NORMAL);
            } else {
                Home.this.setExtendedState(MAXIMIZED_BOTH);
            }
        }
    }//GEN-LAST:event_pnlTopMouseClicked

    private void pnlTopMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlTopMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_pnlTopMousePressed

    private void btn_qlchucvuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_qlchucvuMousePressed
        setColor(btn_qlchucvu);
        resetColor(btn_qlphong);
        resetColor(btn_qldichvu);
        resetColor(btn_qlkhachhang);
        resetColor(btn_qlnhanvien);
        resetColor(btn_hoadon);
        resetColor(btn_phieudatphong);
        resetColor(btn_phieudichvu);
        resetColor(btn_suaphieudatphong);
        ind_chucvu.setOpaque(true);
        ind_phong.setOpaque(false);
        ind_dichvu.setOpaque(false);
        ind_khachhang.setOpaque(false);
        ind_nhanvien.setOpaque(false);
        ind_hoadon.setOpaque(false);
        ind_phieudatphong.setOpaque(false);
        ind_phieudichvu.setOpaque(false);
        ind_suaphieudatphong.setOpaque(false);
    }//GEN-LAST:event_btn_qlchucvuMousePressed

    private void sidepaneMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sidepaneMouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_sidepaneMouseDragged

    private void sidepaneMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sidepaneMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_sidepaneMousePressed

    private void lblMinimizeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizeMousePressed
        Home.this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_lblMinimizeMousePressed

    private void lblMaximizeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMaximizeMousePressed
        if (Home.this.getExtendedState() == MAXIMIZED_BOTH) {
            Home.this.setExtendedState(JFrame.NORMAL);
        } else {
            Home.this.setExtendedState(MAXIMIZED_BOTH);
        }
    }//GEN-LAST:event_lblMaximizeMousePressed

    private void lblCloseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMousePressed
        System.exit(0);
    }//GEN-LAST:event_lblCloseMousePressed

    private void btn_qlnhanvienMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_qlnhanvienMousePressed
        resetColor(btn_qlchucvu);
        resetColor(btn_qlphong);
        resetColor(btn_qldichvu);
        resetColor(btn_qlkhachhang);
        setColor(btn_qlnhanvien);
        resetColor(btn_hoadon);
        resetColor(btn_phieudatphong);
        resetColor(btn_phieudichvu);
        resetColor(btn_nhaphang);
        resetColor(btn_khohang);
        
        ind_chucvu.setOpaque(false);
        ind_phong.setOpaque(false);
        ind_dichvu.setOpaque(false);
        ind_khachhang.setOpaque(false);
        ind_nhanvien.setOpaque(true);
        ind_hoadon.setOpaque(false);
        ind_phieudatphong.setOpaque(false);
        ind_phieudichvu.setOpaque(false);
        ind_nhaphang.setOpaque(false);
        ind_khohang.setOpaque(false);
    }//GEN-LAST:event_btn_qlnhanvienMousePressed

    private void btn_qlphongMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_qlphongMousePressed
        resetColor(btn_qlchucvu);
        setColor(btn_qlphong);
        resetColor(btn_qldichvu);
        resetColor(btn_qlkhachhang);
        resetColor(btn_qlnhanvien);
        resetColor(btn_hoadon);
        resetColor(btn_phieudatphong);
        resetColor(btn_phieudichvu);
        resetColor(btn_nhaphang);
        resetColor(btn_khohang);
        ind_chucvu.setOpaque(false);
        ind_phong.setOpaque(true);
        ind_dichvu.setOpaque(false);
        ind_khachhang.setOpaque(false);
        ind_nhanvien.setOpaque(false);
        ind_hoadon.setOpaque(false);
        ind_phieudatphong.setOpaque(false);
        ind_phieudichvu.setOpaque(false);
        ind_nhaphang.setOpaque(false);
        ind_khohang.setOpaque(false);
    }//GEN-LAST:event_btn_qlphongMousePressed

    private void btn_qldichvuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_qldichvuMousePressed
        resetColor(btn_qlchucvu);
        resetColor(btn_qlphong);
        setColor(btn_qldichvu);
        resetColor(btn_qlkhachhang);
        resetColor(btn_qlnhanvien);
        resetColor(btn_hoadon);
        resetColor(btn_phieudatphong);
        resetColor(btn_phieudichvu);
        resetColor(btn_nhaphang);
        resetColor(btn_khohang);
        ind_chucvu.setOpaque(false);
        ind_phong.setOpaque(false);
        ind_dichvu.setOpaque(true);
        ind_khachhang.setOpaque(false);
        ind_nhanvien.setOpaque(false);
        ind_hoadon.setOpaque(false);
        ind_phieudatphong.setOpaque(false);
        ind_phieudichvu.setOpaque(false);
        ind_nhaphang.setOpaque(false);
        ind_khohang.setOpaque(false);
    }//GEN-LAST:event_btn_qldichvuMousePressed

    private void btn_qlkhachhangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_qlkhachhangMousePressed
        resetColor(btn_qlchucvu);
        resetColor(btn_qlphong);
        resetColor(btn_qldichvu);
        setColor(btn_qlkhachhang);
        resetColor(btn_qlnhanvien);
        resetColor(btn_hoadon);
        resetColor(btn_phieudatphong);
        resetColor(btn_phieudichvu);
        resetColor(btn_nhaphang);
        resetColor(btn_khohang);
        ind_chucvu.setOpaque(false);
        ind_phong.setOpaque(false);
        ind_dichvu.setOpaque(false);
        ind_khachhang.setOpaque(true);
        ind_nhanvien.setOpaque(false);
        ind_hoadon.setOpaque(false);
        ind_phieudatphong.setOpaque(false);
        ind_phieudichvu.setOpaque(false);
        ind_nhaphang.setOpaque(false);
        ind_khohang.setOpaque(false);
    }//GEN-LAST:event_btn_qlkhachhangMousePressed

    private void btn_phieudatphongMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_phieudatphongMousePressed
        resetColor(btn_qlchucvu);
        resetColor(btn_qlphong);
        resetColor(btn_qldichvu);
        resetColor(btn_qlkhachhang);
        resetColor(btn_qlnhanvien);
        resetColor(btn_hoadon);
        setColor(btn_phieudatphong);
        resetColor(btn_phieudichvu);
        resetColor(btn_nhaphang);
        resetColor(btn_khohang);
        ind_chucvu.setOpaque(false);
        ind_phong.setOpaque(false);
        ind_dichvu.setOpaque(false);
        ind_khachhang.setOpaque(false);
        ind_nhanvien.setOpaque(false);
        ind_hoadon.setOpaque(false);
        ind_phieudatphong.setOpaque(true);
        ind_phieudichvu.setOpaque(false);
        ind_nhaphang.setOpaque(false);
        ind_khohang.setOpaque(false);
    }//GEN-LAST:event_btn_phieudatphongMousePressed

    private void btn_phieudichvuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_phieudichvuMousePressed
        resetColor(btn_qlchucvu);
        resetColor(btn_qlphong);
        resetColor(btn_qldichvu);
        resetColor(btn_qlkhachhang);
        resetColor(btn_qlnhanvien);
        resetColor(btn_hoadon);
        resetColor(btn_phieudatphong);
        setColor(btn_phieudichvu);
        resetColor(btn_nhaphang);
        resetColor(btn_khohang);
        ind_chucvu.setOpaque(false);
        ind_phong.setOpaque(false);
        ind_dichvu.setOpaque(false);
        ind_khachhang.setOpaque(false);
        ind_nhanvien.setOpaque(false);
        ind_hoadon.setOpaque(false);
        ind_phieudatphong.setOpaque(false);
        ind_phieudichvu.setOpaque(true);
        ind_nhaphang.setOpaque(false);
        ind_khohang.setOpaque(false);
    }//GEN-LAST:event_btn_phieudichvuMousePressed

    
    private void btn_suaphieudatphongMousePressed(java.awt.event.MouseEvent evt) {                                               
        resetColor(btn_qlchucvu);
        resetColor(btn_qlphong);
        resetColor(btn_qldichvu);
        resetColor(btn_qlkhachhang);
        resetColor(btn_qlnhanvien);
        resetColor(btn_hoadon);
        setColor(btn_phieudatphong);
        resetColor(btn_phieudichvu);
        resetColor(btn_nhaphang);
        resetColor(btn_khohang);
        ind_chucvu.setOpaque(false);
        ind_phong.setOpaque(false);
        ind_dichvu.setOpaque(false);
        ind_khachhang.setOpaque(false);
        ind_nhanvien.setOpaque(false);
        ind_hoadon.setOpaque(false);
        ind_phieudatphong.setOpaque(true);
        ind_phieudichvu.setOpaque(false);
        ind_nhaphang.setOpaque(false);
        ind_khohang.setOpaque(false);
    }
    private void btn_hoadonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hoadonMousePressed
        resetColor(btn_qlchucvu);
        resetColor(btn_qlphong);
        resetColor(btn_qldichvu);
        resetColor(btn_qlkhachhang);
        resetColor(btn_qlnhanvien);
        setColor(btn_hoadon);
        resetColor(btn_phieudatphong);
        resetColor(btn_phieudichvu);
        resetColor(btn_nhaphang);
        resetColor(btn_khohang);
        ind_chucvu.setOpaque(false);
        ind_phong.setOpaque(false);
        ind_dichvu.setOpaque(false);
        ind_khachhang.setOpaque(false);
        ind_nhanvien.setOpaque(false);
        ind_hoadon.setOpaque(true);
        ind_phieudatphong.setOpaque(false);
        ind_phieudichvu.setOpaque(false);
        ind_nhaphang.setOpaque(false);
        ind_khohang.setOpaque(false);
    }//GEN-LAST:event_btn_hoadonMousePressed

    
    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        JFrame jf_Main = new JF_AboutMe();                                      // Khởi tạo JFrame chính
        jf_Main.setLocationRelativeTo(null);
        jf_Main.setVisible(true);                                               // Hiển thị JFrame chính  
    }//GEN-LAST:event_jLabel5MouseClicked

    private void btn_nhaphangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nhaphangMousePressed
        resetColor(btn_qlchucvu);
        resetColor(btn_qlphong);
        resetColor(btn_qldichvu);
        resetColor(btn_qlkhachhang);
        resetColor(btn_qlnhanvien);
        setColor(btn_nhaphang);
        resetColor(btn_phieudatphong);
        resetColor(btn_phieudichvu);
        resetColor(btn_hoadon);
        resetColor(btn_khohang);
        ind_chucvu.setOpaque(false);
        ind_phong.setOpaque(false);
        ind_dichvu.setOpaque(false);
        ind_khachhang.setOpaque(false);
        ind_nhanvien.setOpaque(false);
        ind_hoadon.setOpaque(false);
        ind_phieudatphong.setOpaque(false);
        ind_phieudichvu.setOpaque(false);
        ind_nhaphang.setOpaque(true);
        ind_khohang.setOpaque(false);
    }//GEN-LAST:event_btn_nhaphangMousePressed

    private void btn_khohangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_khohangMousePressed
        resetColor(btn_qlchucvu);
        resetColor(btn_qlphong);
        resetColor(btn_qldichvu);
        resetColor(btn_qlkhachhang);
        resetColor(btn_qlnhanvien);
        setColor(btn_khohang);
        resetColor(btn_phieudatphong);
        resetColor(btn_phieudichvu);
        resetColor(btn_nhaphang);
        resetColor(btn_hoadon);
        ind_chucvu.setOpaque(false);
        ind_phong.setOpaque(false);
        ind_dichvu.setOpaque(false);
        ind_khachhang.setOpaque(false);
        ind_nhanvien.setOpaque(false);
        ind_hoadon.setOpaque(false);
        ind_phieudatphong.setOpaque(false);
        ind_phieudichvu.setOpaque(false);
        ind_nhaphang.setOpaque(false);
        ind_khohang.setOpaque(true);
    }//GEN-LAST:event_btn_khohangMousePressed

    void setColor(JPanel panel) {
        panel.setBackground(new Color(135, 112, 225));
    }

    void resetColor(JPanel panel) {
        panel.setBackground(new Color(76, 41, 211));
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btn_hoadon;
    private javax.swing.JPanel btn_home;
    private javax.swing.JPanel btn_khohang;
    private javax.swing.JPanel btn_nhaphang;
    private javax.swing.JPanel btn_phieudatphong;
    private javax.swing.JPanel btn_phieudichvu;
    private javax.swing.JPanel btn_qlchucvu;
    private javax.swing.JPanel btn_qldichvu;
    private javax.swing.JPanel btn_qlkhachhang;
    private javax.swing.JPanel btn_qlnhanvien;
    private javax.swing.JPanel btn_qlphong;
    private javax.swing.JPanel btn_suaphieudatphong;
    private javax.swing.JPanel ind_chucvu;
    private javax.swing.JPanel ind_dichvu;
    private javax.swing.JPanel ind_hoadon;
    private javax.swing.JPanel ind_khachhang;
    private javax.swing.JPanel ind_khohang;
    private javax.swing.JPanel ind_nhanvien;
    private javax.swing.JPanel ind_nhaphang;
    private javax.swing.JPanel ind_phieudatphong;
    private javax.swing.JPanel ind_phieudichvu;
    private javax.swing.JPanel ind_phong;
    private javax.swing.JPanel ind_suaphieudatphong;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jp_ScreenMain;
    private javax.swing.JLabel lb_Suaphieudatphong;
    private javax.swing.JLabel lb_chucvu;
    private javax.swing.JLabel lb_dichvu;
    private javax.swing.JLabel lb_hoadon;
    private javax.swing.JLabel lb_home;
    private javax.swing.JLabel lb_khachhang;
    private javax.swing.JLabel lb_khohang;
    private javax.swing.JLabel lb_nhanvien;
    private javax.swing.JLabel lb_nhaphang;
    private javax.swing.JLabel lb_phieudatphong;
    private javax.swing.JLabel lb_phieudichvu;
    private javax.swing.JLabel lb_phong;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblMaximize;
    private javax.swing.JLabel lblMinimize;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlActions;
    private javax.swing.JPanel pnlParent;
    private javax.swing.JPanel pnlTitle;
    private javax.swing.JPanel pnlTop;
    private javax.swing.JPanel sidepane;
    // End of variables declaration//GEN-END:variables
}
