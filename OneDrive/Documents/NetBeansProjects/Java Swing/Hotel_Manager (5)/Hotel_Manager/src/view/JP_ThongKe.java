package view;

import controller.DoanhThuController;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.TongDoanhThuModel;
import model.tbl_DichVu;
import model.tbl_HangHoa;
import model.tbl_Phong;

public class JP_ThongKe extends javax.swing.JPanel {
    
    DefaultTableModel tbl_TongDoanhThu, tbl_Phong, tbl_HangHoa, tbl_DichVu;
    ArrayList<TongDoanhThuModel> arrTongDoanhThu = new ArrayList<>();
    ArrayList<tbl_Phong> arrDoanhThuPhong = new ArrayList<>();
    ArrayList<tbl_HangHoa> arrDoanhThuSanPham = new ArrayList<>();
    ArrayList<tbl_DichVu> arrDoanhThuDichVu = new ArrayList<>();
    
    String SXPhong_ThuTu = "DESC", SXTHEOTHANG = "1", SXSanPham_ThuTu = "DESC", SXDichVu_ThuTu = "DESC";
    public JP_ThongKe() throws IOException {
        initComponents();
        TongDoanhThu();
        rdb_thang1.setSelected(true);
        rdb_sp_thang1.setSelected(true);
        rdb_dv_thang1.setSelected(true);
        rdb_sxDoanhThuPhongMax.setSelected(true);
        rdb_sxDoanhThuDichVuMax.setSelected(true);
        rdb_sxDoanhThuSanPhamMax.setSelected(true);
        DoanhThuPhong(SXTHEOTHANG, SXPhong_ThuTu);
        DoanhThuSanPham(SXTHEOTHANG, SXSanPham_ThuTu);
        DoanhThuDichVu(SXTHEOTHANG, SXDichVu_ThuTu);
    }
    
    public void TongDoanhThu() throws IOException {
        double sldv = 0, dtdv = 0, slsp = 0, dtsp = 0, slp = 0, dtp = 0, tonggianhap = 0, tongdt = 0;
        tbl_TongDoanhThu = (DefaultTableModel) tb_TongDoanhThu.getModel();
        arrTongDoanhThu = DoanhThuController.TongDoanhThuTheoThang();
        tbl_TongDoanhThu.setRowCount(0);
        arrTongDoanhThu.forEach((KQ) -> {
            tbl_TongDoanhThu.addRow(new Object[]{KQ.getThang(), KQ.getSoluongdichvu(), KQ.getDoanhthudichvu(), KQ.getSoluongsanpham(), KQ.getDoanhthusanpham(),
                KQ.getSoluongphong(), KQ.getDoanhthuphong(), KQ.getTonggianhap(), KQ.getTongdoanhthu()});
        });

        for (int row = 0; row < tb_TongDoanhThu.getRowCount(); row++) {
            for (int col = 1; col <= 8; col++) { // Tính tổng từ cột 2 đến cột 9
                double value = Double.parseDouble(tb_TongDoanhThu.getValueAt(row, col).toString());
                switch (col) {
                    case 1:
                        sldv += value;
                        break;
                    case 2:
                        dtdv += value;
                        break;
                    case 3:
                        slsp += value;
                        break;
                    case 4:
                        dtsp += value;
                        break;
                    case 5:
                        slp += value;
                        break;
                    case 6:
                        dtp += value;
                        break;
                    case 7:
                        tonggianhap += value;
                        break;
                    case 8:
                        tongdt += value;
                        break;
                }
            }
        }
        DecimalFormat decimalFormat = new DecimalFormat("#,###.##");
        lb_sldv.setText(decimalFormat.format(sldv));
        lb_dtdv.setText(decimalFormat.format(dtdv));
        lb_slsp.setText(decimalFormat.format(slsp));
        lb_dtsp.setText(decimalFormat.format(dtsp));
        lb_tongphong.setText(decimalFormat.format(slp));
        lb_dtphong.setText(decimalFormat.format(dtp));
        lb_tonggianhap.setText(decimalFormat.format(tonggianhap));
        lb_tongdoanhthu.setText(decimalFormat.format(tongdt));
    }
    
    public void DoanhThuPhong(String Thang, String kieuSX) throws IOException {
        double sum = 0;
        tbl_Phong = (DefaultTableModel) tb_phong.getModel();
        arrDoanhThuPhong = DoanhThuController.DoanhThuPhongTheoThang(Thang, kieuSX);
        tbl_Phong.setRowCount(0);
        arrDoanhThuPhong.forEach((KQ) -> {
            tbl_Phong.addRow(new Object[]{KQ.getMaPhong(), KQ.getLoaiPhong(), KQ.getGiaPhong(), KQ.getLuotDat(), KQ.getTongDoanhThuPhong()});
        });
        for (int row = 0; row < tb_phong.getRowCount(); row++) {
            double value = Double.parseDouble(tb_phong.getValueAt(row, 4).toString());
            sum += value;
        }
        DecimalFormat decimalFormat = new DecimalFormat("#,###.##");
        lb_phong_tongdoanhthu.setText(decimalFormat.format(sum));
    }
    
    public void DoanhThuSanPham(String Thang, String kieuSX) throws IOException {
        double sum = 0;
        tbl_HangHoa = (DefaultTableModel) tb_sanpham.getModel();
        arrDoanhThuSanPham = DoanhThuController.DoanhThuSanPhamTheoThang(Thang, kieuSX);
        tbl_HangHoa.setRowCount(0);
        arrDoanhThuSanPham.forEach((KQ) -> {
            tbl_HangHoa.addRow(new Object[]{KQ.getMahang(), KQ.getTenhang(), KQ.getLoaihang(), KQ.getLuongtieuthu(), 
                KQ.getTongdoanhthu(), KQ.getLoinhuan()});
        });
        for (int row = 0; row < tb_sanpham.getRowCount(); row++) {
            double value = Double.parseDouble(tb_sanpham.getValueAt(row, 5).toString());
            sum += value;
        }
        DecimalFormat decimalFormat = new DecimalFormat("#,###.##");
        lb_sanpham_tongdoanhthu.setText(decimalFormat.format(sum));
    }
    
    public void DoanhThuDichVu(String Thang, String kieuSX) throws IOException {
        double sum = 0;
        tbl_DichVu = (DefaultTableModel) tb_dichvu.getModel();
        arrDoanhThuDichVu = DoanhThuController.DoanhThuDichVuTheoThang(Thang, kieuSX);
        tbl_DichVu.setRowCount(0);
        arrDoanhThuDichVu.forEach((KQ) -> {
            tbl_DichVu.addRow(new Object[]{KQ.getMadichvu(), KQ.getTendichvu(), KQ.getSoLanSuDung(), KQ.getDoanhThu()});
        });
        for (int row = 0; row < tb_dichvu.getRowCount(); row++) {
            double value = Double.parseDouble(tb_dichvu.getValueAt(row, 3).toString());
            sum += value;
        }
        DecimalFormat decimalFormat = new DecimalFormat("#,###.##");
        lb_dichvu_tongdoanhthu.setText(decimalFormat.format(sum));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnG_thang = new javax.swing.ButtonGroup();
        btnG_sapxep = new javax.swing.ButtonGroup();
        btnG_sp_thang = new javax.swing.ButtonGroup();
        btnG_sp_sapxep = new javax.swing.ButtonGroup();
        btnG_dv_thang = new javax.swing.ButtonGroup();
        btnG_dv_sapxep = new javax.swing.ButtonGroup();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel22 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        lb_sldv = new javax.swing.JLabel();
        lb_dtdv = new javax.swing.JLabel();
        lb_slsp = new javax.swing.JLabel();
        lb_dtsp = new javax.swing.JLabel();
        lb_tongphong = new javax.swing.JLabel();
        lb_dtphong = new javax.swing.JLabel();
        lb_tonggianhap = new javax.swing.JLabel();
        lb_tongdoanhthu = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_TongDoanhThu = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        rdb_thang1 = new javax.swing.JRadioButton();
        rdb_thang2 = new javax.swing.JRadioButton();
        rdb_thang3 = new javax.swing.JRadioButton();
        rdb_thang4 = new javax.swing.JRadioButton();
        rdb_thang5 = new javax.swing.JRadioButton();
        rdb_thang6 = new javax.swing.JRadioButton();
        rdb_thang7 = new javax.swing.JRadioButton();
        rdb_thang8 = new javax.swing.JRadioButton();
        rdb_thang9 = new javax.swing.JRadioButton();
        rdb_thang10 = new javax.swing.JRadioButton();
        rdb_thang11 = new javax.swing.JRadioButton();
        rdb_thang12 = new javax.swing.JRadioButton();
        jPanel11 = new javax.swing.JPanel();
        rdb_sxDoanhThuPhongMax = new javax.swing.JRadioButton();
        rdb_sxDoanhThuPhongMin = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        lb_phong_tongdoanhthu = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tb_phong = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        rdb_sp_thang1 = new javax.swing.JRadioButton();
        rdb_sp_thang2 = new javax.swing.JRadioButton();
        rdb_sp_thang3 = new javax.swing.JRadioButton();
        rdb_sp_thang4 = new javax.swing.JRadioButton();
        rdb_sp_thang5 = new javax.swing.JRadioButton();
        rdb_sp_thang6 = new javax.swing.JRadioButton();
        rdb_sp_thang7 = new javax.swing.JRadioButton();
        rdb_sp_thang8 = new javax.swing.JRadioButton();
        rdb_sp_thang9 = new javax.swing.JRadioButton();
        rdb_sp_thang10 = new javax.swing.JRadioButton();
        rdb_sp_thang11 = new javax.swing.JRadioButton();
        rdb_sp_thang12 = new javax.swing.JRadioButton();
        jPanel15 = new javax.swing.JPanel();
        rdb_sxDoanhThuSanPhamMax = new javax.swing.JRadioButton();
        rdb_sxDoanhThuSanPhamMin = new javax.swing.JRadioButton();
        jPanel12 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        lb_sanpham_tongdoanhthu = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tb_sanpham = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        rdb_dv_thang1 = new javax.swing.JRadioButton();
        rdb_dv_thang2 = new javax.swing.JRadioButton();
        rdb_dv_thang3 = new javax.swing.JRadioButton();
        rdb_dv_thang4 = new javax.swing.JRadioButton();
        rdb_dv_thang5 = new javax.swing.JRadioButton();
        rdb_dv_thang6 = new javax.swing.JRadioButton();
        rdb_dv_thang7 = new javax.swing.JRadioButton();
        rdb_dv_thang8 = new javax.swing.JRadioButton();
        rdb_dv_thang9 = new javax.swing.JRadioButton();
        rdb_dv_thang10 = new javax.swing.JRadioButton();
        rdb_dv_thang11 = new javax.swing.JRadioButton();
        rdb_dv_thang12 = new javax.swing.JRadioButton();
        jPanel19 = new javax.swing.JPanel();
        rdb_sxDoanhThuDichVuMax = new javax.swing.JRadioButton();
        rdb_sxDoanhThuDichVuMin = new javax.swing.JRadioButton();
        jPanel17 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        lb_dichvu_tongdoanhthu = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tb_dichvu = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1140, 780));
        setLayout(new java.awt.BorderLayout());

        jPanel6.setBackground(new java.awt.Color(76, 41, 211));
        jPanel6.setPreferredSize(new java.awt.Dimension(1140, 70));
        jPanel6.setLayout(new java.awt.BorderLayout());

        jLabel8.setFont(new java.awt.Font("Century Schoolbook", 1, 30)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Room manager");
        jPanel6.add(jLabel8, java.awt.BorderLayout.CENTER);

        add(jPanel6, java.awt.BorderLayout.PAGE_START);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new java.awt.BorderLayout());

        jTabbedPane2.setPreferredSize(new java.awt.Dimension(900, 710));

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setPreferredSize(new java.awt.Dimension(900, 683));
        jPanel22.setLayout(new java.awt.BorderLayout());

        jPanel23.setPreferredSize(new java.awt.Dimension(1211, 30));
        jPanel23.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING, 0, 5));

        jLabel10.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("   Tổng:");
        jLabel10.setPreferredSize(new java.awt.Dimension(110, 15));
        jPanel23.add(jLabel10);

        lb_sldv.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        lb_sldv.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_sldv.setPreferredSize(new java.awt.Dimension(128, 15));
        jPanel23.add(lb_sldv);

        lb_dtdv.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        lb_dtdv.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_dtdv.setPreferredSize(new java.awt.Dimension(126, 15));
        jPanel23.add(lb_dtdv);

        lb_slsp.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        lb_slsp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_slsp.setPreferredSize(new java.awt.Dimension(128, 15));
        jPanel23.add(lb_slsp);

        lb_dtsp.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        lb_dtsp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_dtsp.setPreferredSize(new java.awt.Dimension(128, 15));
        jPanel23.add(lb_dtsp);

        lb_tongphong.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        lb_tongphong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_tongphong.setPreferredSize(new java.awt.Dimension(130, 15));
        jPanel23.add(lb_tongphong);

        lb_dtphong.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        lb_dtphong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_dtphong.setPreferredSize(new java.awt.Dimension(125, 15));
        jPanel23.add(lb_dtphong);

        lb_tonggianhap.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        lb_tonggianhap.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_tonggianhap.setPreferredSize(new java.awt.Dimension(125, 15));
        jPanel23.add(lb_tonggianhap);

        lb_tongdoanhthu.setFont(new java.awt.Font("Montserrat SemiBold", 0, 16)); // NOI18N
        lb_tongdoanhthu.setForeground(new java.awt.Color(255, 0, 0));
        lb_tongdoanhthu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_tongdoanhthu.setPreferredSize(new java.awt.Dimension(125, 15));
        jPanel23.add(lb_tongdoanhthu);

        jPanel22.add(jPanel23, java.awt.BorderLayout.PAGE_END);

        tb_TongDoanhThu.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        tb_TongDoanhThu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Tháng", "Tổng Dịch Vụ", "Doanh Thu Dịch Vụ", "Tổng Sản Phẩm", "Doanh Thu Sản Phẩm", "Tổng Phòng", "Doanh Thu Phòng", "Tổng Giá Nhập", "Tổng Doanh Thu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_TongDoanhThu.setRowHeight(25);
        tb_TongDoanhThu.setRowMargin(2);
        tb_TongDoanhThu.setSelectionBackground(new java.awt.Color(204, 255, 255));
        tb_TongDoanhThu.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane3.setViewportView(tb_TongDoanhThu);
        if (tb_TongDoanhThu.getColumnModel().getColumnCount() > 0) {
            tb_TongDoanhThu.getColumnModel().getColumn(0).setPreferredWidth(35);
            tb_TongDoanhThu.getColumnModel().getColumn(1).setPreferredWidth(35);
            tb_TongDoanhThu.getColumnModel().getColumn(2).setPreferredWidth(50);
            tb_TongDoanhThu.getColumnModel().getColumn(3).setPreferredWidth(35);
            tb_TongDoanhThu.getColumnModel().getColumn(4).setPreferredWidth(50);
            tb_TongDoanhThu.getColumnModel().getColumn(5).setPreferredWidth(35);
            tb_TongDoanhThu.getColumnModel().getColumn(6).setPreferredWidth(50);
            tb_TongDoanhThu.getColumnModel().getColumn(7).setPreferredWidth(50);
            tb_TongDoanhThu.getColumnModel().getColumn(8).setPreferredWidth(75);
        }

        jPanel22.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        jTabbedPane2.addTab("Tổng Doanh Thu", jPanel22);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(280, 683));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Phân Loại Theo Tháng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Montserrat", 2, 12))); // NOI18N
        jPanel5.setPreferredSize(new java.awt.Dimension(260, 380));
        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING, 2, 6));

        rdb_thang1.setBackground(new java.awt.Color(255, 255, 255));
        btnG_thang.add(rdb_thang1);
        rdb_thang1.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        rdb_thang1.setText("Tháng 1");
        rdb_thang1.setMargin(new java.awt.Insets(2, 7, 2, 2));
        rdb_thang1.setPreferredSize(new java.awt.Dimension(180, 23));
        rdb_thang1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_thang1ActionPerformed(evt);
            }
        });
        jPanel5.add(rdb_thang1);

        rdb_thang2.setBackground(new java.awt.Color(255, 255, 255));
        btnG_thang.add(rdb_thang2);
        rdb_thang2.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        rdb_thang2.setText("Tháng 2");
        rdb_thang2.setMargin(new java.awt.Insets(2, 7, 2, 2));
        rdb_thang2.setPreferredSize(new java.awt.Dimension(180, 23));
        rdb_thang2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_thang2ActionPerformed(evt);
            }
        });
        jPanel5.add(rdb_thang2);

        rdb_thang3.setBackground(new java.awt.Color(255, 255, 255));
        btnG_thang.add(rdb_thang3);
        rdb_thang3.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        rdb_thang3.setText("Tháng 3");
        rdb_thang3.setMargin(new java.awt.Insets(2, 7, 2, 2));
        rdb_thang3.setPreferredSize(new java.awt.Dimension(180, 23));
        jPanel5.add(rdb_thang3);

        rdb_thang4.setBackground(new java.awt.Color(255, 255, 255));
        btnG_thang.add(rdb_thang4);
        rdb_thang4.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        rdb_thang4.setText("Tháng 4");
        rdb_thang4.setMargin(new java.awt.Insets(2, 7, 2, 2));
        rdb_thang4.setPreferredSize(new java.awt.Dimension(180, 23));
        rdb_thang4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_thang4ActionPerformed(evt);
            }
        });
        jPanel5.add(rdb_thang4);

        rdb_thang5.setBackground(new java.awt.Color(255, 255, 255));
        btnG_thang.add(rdb_thang5);
        rdb_thang5.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        rdb_thang5.setText("Tháng 5");
        rdb_thang5.setMargin(new java.awt.Insets(2, 7, 2, 2));
        rdb_thang5.setPreferredSize(new java.awt.Dimension(180, 23));
        rdb_thang5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_thang5ActionPerformed(evt);
            }
        });
        jPanel5.add(rdb_thang5);

        rdb_thang6.setBackground(new java.awt.Color(255, 255, 255));
        btnG_thang.add(rdb_thang6);
        rdb_thang6.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        rdb_thang6.setText("Tháng 6");
        rdb_thang6.setMargin(new java.awt.Insets(2, 7, 2, 2));
        rdb_thang6.setPreferredSize(new java.awt.Dimension(180, 23));
        rdb_thang6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_thang6ActionPerformed(evt);
            }
        });
        jPanel5.add(rdb_thang6);

        rdb_thang7.setBackground(new java.awt.Color(255, 255, 255));
        btnG_thang.add(rdb_thang7);
        rdb_thang7.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        rdb_thang7.setText("Tháng 7");
        rdb_thang7.setMargin(new java.awt.Insets(2, 7, 2, 2));
        rdb_thang7.setPreferredSize(new java.awt.Dimension(180, 23));
        rdb_thang7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_thang7ActionPerformed(evt);
            }
        });
        jPanel5.add(rdb_thang7);

        rdb_thang8.setBackground(new java.awt.Color(255, 255, 255));
        btnG_thang.add(rdb_thang8);
        rdb_thang8.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        rdb_thang8.setText("Tháng 8");
        rdb_thang8.setMargin(new java.awt.Insets(2, 7, 2, 2));
        rdb_thang8.setPreferredSize(new java.awt.Dimension(180, 23));
        rdb_thang8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_thang8ActionPerformed(evt);
            }
        });
        jPanel5.add(rdb_thang8);

        rdb_thang9.setBackground(new java.awt.Color(255, 255, 255));
        btnG_thang.add(rdb_thang9);
        rdb_thang9.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        rdb_thang9.setText("Tháng 9");
        rdb_thang9.setMargin(new java.awt.Insets(2, 7, 2, 2));
        rdb_thang9.setPreferredSize(new java.awt.Dimension(180, 23));
        rdb_thang9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_thang9ActionPerformed(evt);
            }
        });
        jPanel5.add(rdb_thang9);

        rdb_thang10.setBackground(new java.awt.Color(255, 255, 255));
        btnG_thang.add(rdb_thang10);
        rdb_thang10.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        rdb_thang10.setText("Tháng 10");
        rdb_thang10.setMargin(new java.awt.Insets(2, 7, 2, 2));
        rdb_thang10.setPreferredSize(new java.awt.Dimension(180, 23));
        rdb_thang10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_thang10ActionPerformed(evt);
            }
        });
        jPanel5.add(rdb_thang10);

        rdb_thang11.setBackground(new java.awt.Color(255, 255, 255));
        btnG_thang.add(rdb_thang11);
        rdb_thang11.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        rdb_thang11.setText("Tháng 11");
        rdb_thang11.setMargin(new java.awt.Insets(2, 7, 2, 2));
        rdb_thang11.setPreferredSize(new java.awt.Dimension(180, 23));
        rdb_thang11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_thang11ActionPerformed(evt);
            }
        });
        jPanel5.add(rdb_thang11);

        rdb_thang12.setBackground(new java.awt.Color(255, 255, 255));
        btnG_thang.add(rdb_thang12);
        rdb_thang12.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        rdb_thang12.setText("Tháng 12");
        rdb_thang12.setMargin(new java.awt.Insets(2, 7, 2, 2));
        rdb_thang12.setPreferredSize(new java.awt.Dimension(180, 23));
        rdb_thang12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_thang12ActionPerformed(evt);
            }
        });
        jPanel5.add(rdb_thang12);

        jPanel3.add(jPanel5);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sắp xếp theo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Montserrat", 2, 12))); // NOI18N
        jPanel11.setPreferredSize(new java.awt.Dimension(260, 200));
        jPanel11.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING, 5, 8));

        rdb_sxDoanhThuPhongMax.setBackground(new java.awt.Color(255, 255, 255));
        btnG_sapxep.add(rdb_sxDoanhThuPhongMax);
        rdb_sxDoanhThuPhongMax.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        rdb_sxDoanhThuPhongMax.setText("Doanh Thu Cao Nhất");
        rdb_sxDoanhThuPhongMax.setPreferredSize(new java.awt.Dimension(200, 23));
        rdb_sxDoanhThuPhongMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_sxDoanhThuPhongMaxActionPerformed(evt);
            }
        });
        jPanel11.add(rdb_sxDoanhThuPhongMax);

        rdb_sxDoanhThuPhongMin.setBackground(new java.awt.Color(255, 255, 255));
        btnG_sapxep.add(rdb_sxDoanhThuPhongMin);
        rdb_sxDoanhThuPhongMin.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        rdb_sxDoanhThuPhongMin.setText("Doanh Thu Thấp Nhất");
        rdb_sxDoanhThuPhongMin.setPreferredSize(new java.awt.Dimension(200, 23));
        rdb_sxDoanhThuPhongMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_sxDoanhThuPhongMinActionPerformed(evt);
            }
        });
        jPanel11.add(rdb_sxDoanhThuPhongMin);

        jPanel3.add(jPanel11);

        jPanel2.add(jPanel3, java.awt.BorderLayout.LINE_START);

        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));
        jPanel24.setPreferredSize(new java.awt.Dimension(1232, 30));

        jLabel13.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("   Tổng:");
        jLabel13.setPreferredSize(new java.awt.Dimension(110, 15));

        lb_phong_tongdoanhthu.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        lb_phong_tongdoanhthu.setForeground(new java.awt.Color(204, 0, 0));
        lb_phong_tongdoanhthu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_phong_tongdoanhthu.setPreferredSize(new java.awt.Dimension(110, 15));

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addContainerGap(1229, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(lb_phong_tongdoanhthu, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_phong_tongdoanhthu, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel24, java.awt.BorderLayout.PAGE_END);

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));
        jPanel25.setLayout(new java.awt.BorderLayout());

        tb_phong.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        tb_phong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Loại Phòng", "Giá Phòng", "Lượt Đặt", "Tổng doanh thu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_phong.setRowHeight(25);
        tb_phong.setRowMargin(2);
        tb_phong.setSelectionBackground(new java.awt.Color(204, 255, 255));
        tb_phong.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane9.setViewportView(tb_phong);
        if (tb_phong.getColumnModel().getColumnCount() > 0) {
            tb_phong.getColumnModel().getColumn(0).setPreferredWidth(35);
            tb_phong.getColumnModel().getColumn(1).setPreferredWidth(50);
            tb_phong.getColumnModel().getColumn(2).setPreferredWidth(50);
            tb_phong.getColumnModel().getColumn(3).setPreferredWidth(50);
            tb_phong.getColumnModel().getColumn(4).setPreferredWidth(75);
        }

        jPanel25.add(jScrollPane9, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel25, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel4, java.awt.BorderLayout.CENTER);

        jTabbedPane2.addTab("Phòng", jPanel2);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setPreferredSize(new java.awt.Dimension(280, 683));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Phân Loại Theo Tháng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Montserrat", 2, 12))); // NOI18N
        jPanel13.setPreferredSize(new java.awt.Dimension(260, 380));
        jPanel13.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING, 2, 6));

        rdb_sp_thang1.setBackground(new java.awt.Color(255, 255, 255));
        btnG_sp_thang.add(rdb_sp_thang1);
        rdb_sp_thang1.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        rdb_sp_thang1.setText("Tháng 1");
        rdb_sp_thang1.setMargin(new java.awt.Insets(2, 7, 2, 2));
        rdb_sp_thang1.setPreferredSize(new java.awt.Dimension(200, 23));
        rdb_sp_thang1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_sp_thang1ActionPerformed(evt);
            }
        });
        jPanel13.add(rdb_sp_thang1);

        rdb_sp_thang2.setBackground(new java.awt.Color(255, 255, 255));
        btnG_sp_thang.add(rdb_sp_thang2);
        rdb_sp_thang2.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        rdb_sp_thang2.setText("Tháng 2");
        rdb_sp_thang2.setMargin(new java.awt.Insets(2, 7, 2, 2));
        rdb_sp_thang2.setPreferredSize(new java.awt.Dimension(200, 23));
        rdb_sp_thang2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_sp_thang2ActionPerformed(evt);
            }
        });
        jPanel13.add(rdb_sp_thang2);

        rdb_sp_thang3.setBackground(new java.awt.Color(255, 255, 255));
        btnG_sp_thang.add(rdb_sp_thang3);
        rdb_sp_thang3.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        rdb_sp_thang3.setText("Tháng 3");
        rdb_sp_thang3.setMargin(new java.awt.Insets(2, 7, 2, 2));
        rdb_sp_thang3.setPreferredSize(new java.awt.Dimension(200, 23));
        rdb_sp_thang3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_sp_thang3ActionPerformed(evt);
            }
        });
        jPanel13.add(rdb_sp_thang3);

        rdb_sp_thang4.setBackground(new java.awt.Color(255, 255, 255));
        btnG_sp_thang.add(rdb_sp_thang4);
        rdb_sp_thang4.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        rdb_sp_thang4.setText("Tháng 4");
        rdb_sp_thang4.setMargin(new java.awt.Insets(2, 7, 2, 2));
        rdb_sp_thang4.setPreferredSize(new java.awt.Dimension(200, 23));
        rdb_sp_thang4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_sp_thang4ActionPerformed(evt);
            }
        });
        jPanel13.add(rdb_sp_thang4);

        rdb_sp_thang5.setBackground(new java.awt.Color(255, 255, 255));
        btnG_sp_thang.add(rdb_sp_thang5);
        rdb_sp_thang5.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        rdb_sp_thang5.setText("Tháng 5");
        rdb_sp_thang5.setMargin(new java.awt.Insets(2, 7, 2, 2));
        rdb_sp_thang5.setPreferredSize(new java.awt.Dimension(200, 23));
        rdb_sp_thang5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_sp_thang5ActionPerformed(evt);
            }
        });
        jPanel13.add(rdb_sp_thang5);

        rdb_sp_thang6.setBackground(new java.awt.Color(255, 255, 255));
        btnG_sp_thang.add(rdb_sp_thang6);
        rdb_sp_thang6.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        rdb_sp_thang6.setText("Tháng 6");
        rdb_sp_thang6.setMargin(new java.awt.Insets(2, 7, 2, 2));
        rdb_sp_thang6.setPreferredSize(new java.awt.Dimension(200, 23));
        rdb_sp_thang6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_sp_thang6ActionPerformed(evt);
            }
        });
        jPanel13.add(rdb_sp_thang6);

        rdb_sp_thang7.setBackground(new java.awt.Color(255, 255, 255));
        btnG_sp_thang.add(rdb_sp_thang7);
        rdb_sp_thang7.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        rdb_sp_thang7.setText("Tháng 7");
        rdb_sp_thang7.setMargin(new java.awt.Insets(2, 7, 2, 2));
        rdb_sp_thang7.setPreferredSize(new java.awt.Dimension(200, 23));
        rdb_sp_thang7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_sp_thang7ActionPerformed(evt);
            }
        });
        jPanel13.add(rdb_sp_thang7);

        rdb_sp_thang8.setBackground(new java.awt.Color(255, 255, 255));
        btnG_sp_thang.add(rdb_sp_thang8);
        rdb_sp_thang8.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        rdb_sp_thang8.setText("Tháng 8");
        rdb_sp_thang8.setMargin(new java.awt.Insets(2, 7, 2, 2));
        rdb_sp_thang8.setPreferredSize(new java.awt.Dimension(200, 23));
        rdb_sp_thang8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_sp_thang8ActionPerformed(evt);
            }
        });
        jPanel13.add(rdb_sp_thang8);

        rdb_sp_thang9.setBackground(new java.awt.Color(255, 255, 255));
        btnG_sp_thang.add(rdb_sp_thang9);
        rdb_sp_thang9.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        rdb_sp_thang9.setText("Tháng 9");
        rdb_sp_thang9.setMargin(new java.awt.Insets(2, 7, 2, 2));
        rdb_sp_thang9.setPreferredSize(new java.awt.Dimension(200, 23));
        rdb_sp_thang9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_sp_thang9ActionPerformed(evt);
            }
        });
        jPanel13.add(rdb_sp_thang9);

        rdb_sp_thang10.setBackground(new java.awt.Color(255, 255, 255));
        btnG_sp_thang.add(rdb_sp_thang10);
        rdb_sp_thang10.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        rdb_sp_thang10.setText("Tháng 10");
        rdb_sp_thang10.setMargin(new java.awt.Insets(2, 7, 2, 2));
        rdb_sp_thang10.setPreferredSize(new java.awt.Dimension(200, 23));
        rdb_sp_thang10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_sp_thang10ActionPerformed(evt);
            }
        });
        jPanel13.add(rdb_sp_thang10);

        rdb_sp_thang11.setBackground(new java.awt.Color(255, 255, 255));
        btnG_sp_thang.add(rdb_sp_thang11);
        rdb_sp_thang11.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        rdb_sp_thang11.setText("Tháng 11");
        rdb_sp_thang11.setMargin(new java.awt.Insets(2, 7, 2, 2));
        rdb_sp_thang11.setPreferredSize(new java.awt.Dimension(200, 23));
        rdb_sp_thang11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_sp_thang11ActionPerformed(evt);
            }
        });
        jPanel13.add(rdb_sp_thang11);

        rdb_sp_thang12.setBackground(new java.awt.Color(255, 255, 255));
        btnG_sp_thang.add(rdb_sp_thang12);
        rdb_sp_thang12.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        rdb_sp_thang12.setText("Tháng 12");
        rdb_sp_thang12.setMargin(new java.awt.Insets(2, 7, 2, 2));
        rdb_sp_thang12.setPreferredSize(new java.awt.Dimension(200, 23));
        rdb_sp_thang12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_sp_thang12ActionPerformed(evt);
            }
        });
        jPanel13.add(rdb_sp_thang12);

        jPanel10.add(jPanel13);

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sắp xếp theo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Montserrat", 0, 12))); // NOI18N
        jPanel15.setPreferredSize(new java.awt.Dimension(260, 200));
        jPanel15.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING, 5, 8));

        rdb_sxDoanhThuSanPhamMax.setBackground(new java.awt.Color(255, 255, 255));
        btnG_sp_sapxep.add(rdb_sxDoanhThuSanPhamMax);
        rdb_sxDoanhThuSanPhamMax.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        rdb_sxDoanhThuSanPhamMax.setText("Lợi Nhuận Cao Nhất");
        rdb_sxDoanhThuSanPhamMax.setPreferredSize(new java.awt.Dimension(200, 23));
        rdb_sxDoanhThuSanPhamMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_sxDoanhThuSanPhamMaxActionPerformed(evt);
            }
        });
        jPanel15.add(rdb_sxDoanhThuSanPhamMax);

        rdb_sxDoanhThuSanPhamMin.setBackground(new java.awt.Color(255, 255, 255));
        btnG_sp_sapxep.add(rdb_sxDoanhThuSanPhamMin);
        rdb_sxDoanhThuSanPhamMin.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        rdb_sxDoanhThuSanPhamMin.setText("Lợi Nhuận Thấp Nhất");
        rdb_sxDoanhThuSanPhamMin.setPreferredSize(new java.awt.Dimension(200, 23));
        rdb_sxDoanhThuSanPhamMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_sxDoanhThuSanPhamMinActionPerformed(evt);
            }
        });
        jPanel15.add(rdb_sxDoanhThuSanPhamMin);

        jPanel10.add(jPanel15);

        jPanel1.add(jPanel10, java.awt.BorderLayout.LINE_START);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setLayout(new java.awt.BorderLayout());

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setPreferredSize(new java.awt.Dimension(896, 30));

        lb_sanpham_tongdoanhthu.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        lb_sanpham_tongdoanhthu.setForeground(new java.awt.Color(204, 0, 0));
        lb_sanpham_tongdoanhthu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_sanpham_tongdoanhthu.setPreferredSize(new java.awt.Dimension(110, 15));

        jLabel12.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("   Tổng:");
        jLabel12.setPreferredSize(new java.awt.Dimension(110, 15));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(1239, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lb_sanpham_tongdoanhthu, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_sanpham_tongdoanhthu, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel12.add(jPanel14, java.awt.BorderLayout.PAGE_END);

        tb_sanpham.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        tb_sanpham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Tên Sản Phẩm", "Loại", "Lượng Tiêu Thụ", "Thành Tiền", "Lợi Nhuận"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_sanpham.setRowHeight(25);
        tb_sanpham.setRowMargin(2);
        tb_sanpham.setSelectionBackground(new java.awt.Color(204, 255, 255));
        tb_sanpham.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane5.setViewportView(tb_sanpham);
        if (tb_sanpham.getColumnModel().getColumnCount() > 0) {
            tb_sanpham.getColumnModel().getColumn(0).setPreferredWidth(35);
            tb_sanpham.getColumnModel().getColumn(1).setPreferredWidth(75);
            tb_sanpham.getColumnModel().getColumn(2).setPreferredWidth(50);
            tb_sanpham.getColumnModel().getColumn(3).setPreferredWidth(150);
            tb_sanpham.getColumnModel().getColumn(4).setPreferredWidth(75);
            tb_sanpham.getColumnModel().getColumn(5).setPreferredWidth(75);
        }

        jPanel12.add(jScrollPane5, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel12, java.awt.BorderLayout.CENTER);

        jTabbedPane2.addTab("Sản Phẩm", jPanel1);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new java.awt.BorderLayout());

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setPreferredSize(new java.awt.Dimension(280, 683));

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Phân Loại Theo Tháng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Montserrat", 2, 12))); // NOI18N
        jPanel18.setPreferredSize(new java.awt.Dimension(260, 380));
        jPanel18.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING, 2, 6));

        rdb_dv_thang1.setBackground(new java.awt.Color(255, 255, 255));
        btnG_dv_thang.add(rdb_dv_thang1);
        rdb_dv_thang1.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        rdb_dv_thang1.setText("Tháng 1");
        rdb_dv_thang1.setMargin(new java.awt.Insets(2, 7, 2, 2));
        rdb_dv_thang1.setPreferredSize(new java.awt.Dimension(180, 23));
        rdb_dv_thang1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_dv_thang1ActionPerformed(evt);
            }
        });
        jPanel18.add(rdb_dv_thang1);

        rdb_dv_thang2.setBackground(new java.awt.Color(255, 255, 255));
        btnG_dv_thang.add(rdb_dv_thang2);
        rdb_dv_thang2.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        rdb_dv_thang2.setText("Tháng 2");
        rdb_dv_thang2.setMargin(new java.awt.Insets(2, 7, 2, 2));
        rdb_dv_thang2.setPreferredSize(new java.awt.Dimension(180, 23));
        rdb_dv_thang2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_dv_thang2ActionPerformed(evt);
            }
        });
        jPanel18.add(rdb_dv_thang2);

        rdb_dv_thang3.setBackground(new java.awt.Color(255, 255, 255));
        btnG_dv_thang.add(rdb_dv_thang3);
        rdb_dv_thang3.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        rdb_dv_thang3.setText("Tháng 3");
        rdb_dv_thang3.setMargin(new java.awt.Insets(2, 7, 2, 2));
        rdb_dv_thang3.setPreferredSize(new java.awt.Dimension(180, 23));
        rdb_dv_thang3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_dv_thang3ActionPerformed(evt);
            }
        });
        jPanel18.add(rdb_dv_thang3);

        rdb_dv_thang4.setBackground(new java.awt.Color(255, 255, 255));
        btnG_dv_thang.add(rdb_dv_thang4);
        rdb_dv_thang4.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        rdb_dv_thang4.setText("Tháng 4");
        rdb_dv_thang4.setMargin(new java.awt.Insets(2, 7, 2, 2));
        rdb_dv_thang4.setPreferredSize(new java.awt.Dimension(180, 23));
        rdb_dv_thang4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_dv_thang4ActionPerformed(evt);
            }
        });
        jPanel18.add(rdb_dv_thang4);

        rdb_dv_thang5.setBackground(new java.awt.Color(255, 255, 255));
        btnG_dv_thang.add(rdb_dv_thang5);
        rdb_dv_thang5.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        rdb_dv_thang5.setText("Tháng 5");
        rdb_dv_thang5.setMargin(new java.awt.Insets(2, 7, 2, 2));
        rdb_dv_thang5.setPreferredSize(new java.awt.Dimension(180, 23));
        rdb_dv_thang5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_dv_thang5ActionPerformed(evt);
            }
        });
        jPanel18.add(rdb_dv_thang5);

        rdb_dv_thang6.setBackground(new java.awt.Color(255, 255, 255));
        btnG_dv_thang.add(rdb_dv_thang6);
        rdb_dv_thang6.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        rdb_dv_thang6.setText("Tháng 6");
        rdb_dv_thang6.setMargin(new java.awt.Insets(2, 7, 2, 2));
        rdb_dv_thang6.setPreferredSize(new java.awt.Dimension(180, 23));
        rdb_dv_thang6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_dv_thang6ActionPerformed(evt);
            }
        });
        jPanel18.add(rdb_dv_thang6);

        rdb_dv_thang7.setBackground(new java.awt.Color(255, 255, 255));
        btnG_dv_thang.add(rdb_dv_thang7);
        rdb_dv_thang7.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        rdb_dv_thang7.setText("Tháng 7");
        rdb_dv_thang7.setMargin(new java.awt.Insets(2, 7, 2, 2));
        rdb_dv_thang7.setPreferredSize(new java.awt.Dimension(180, 23));
        rdb_dv_thang7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_dv_thang7ActionPerformed(evt);
            }
        });
        jPanel18.add(rdb_dv_thang7);

        rdb_dv_thang8.setBackground(new java.awt.Color(255, 255, 255));
        btnG_dv_thang.add(rdb_dv_thang8);
        rdb_dv_thang8.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        rdb_dv_thang8.setText("Tháng 8");
        rdb_dv_thang8.setMargin(new java.awt.Insets(2, 7, 2, 2));
        rdb_dv_thang8.setPreferredSize(new java.awt.Dimension(180, 23));
        rdb_dv_thang8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_dv_thang8ActionPerformed(evt);
            }
        });
        jPanel18.add(rdb_dv_thang8);

        rdb_dv_thang9.setBackground(new java.awt.Color(255, 255, 255));
        btnG_dv_thang.add(rdb_dv_thang9);
        rdb_dv_thang9.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        rdb_dv_thang9.setText("Tháng 9");
        rdb_dv_thang9.setMargin(new java.awt.Insets(2, 7, 2, 2));
        rdb_dv_thang9.setPreferredSize(new java.awt.Dimension(180, 23));
        rdb_dv_thang9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_dv_thang9ActionPerformed(evt);
            }
        });
        jPanel18.add(rdb_dv_thang9);

        rdb_dv_thang10.setBackground(new java.awt.Color(255, 255, 255));
        btnG_dv_thang.add(rdb_dv_thang10);
        rdb_dv_thang10.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        rdb_dv_thang10.setText("Tháng 10");
        rdb_dv_thang10.setMargin(new java.awt.Insets(2, 7, 2, 2));
        rdb_dv_thang10.setPreferredSize(new java.awt.Dimension(180, 23));
        rdb_dv_thang10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_dv_thang10ActionPerformed(evt);
            }
        });
        jPanel18.add(rdb_dv_thang10);

        rdb_dv_thang11.setBackground(new java.awt.Color(255, 255, 255));
        btnG_dv_thang.add(rdb_dv_thang11);
        rdb_dv_thang11.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        rdb_dv_thang11.setText("Tháng 11");
        rdb_dv_thang11.setMargin(new java.awt.Insets(2, 7, 2, 2));
        rdb_dv_thang11.setPreferredSize(new java.awt.Dimension(180, 23));
        rdb_dv_thang11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_dv_thang11ActionPerformed(evt);
            }
        });
        jPanel18.add(rdb_dv_thang11);

        rdb_dv_thang12.setBackground(new java.awt.Color(255, 255, 255));
        btnG_dv_thang.add(rdb_dv_thang12);
        rdb_dv_thang12.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        rdb_dv_thang12.setText("Tháng 12");
        rdb_dv_thang12.setMargin(new java.awt.Insets(2, 7, 2, 2));
        rdb_dv_thang12.setPreferredSize(new java.awt.Dimension(180, 23));
        rdb_dv_thang12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_dv_thang12ActionPerformed(evt);
            }
        });
        jPanel18.add(rdb_dv_thang12);

        jPanel16.add(jPanel18);

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sắp xếp theo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Montserrat", 2, 12))); // NOI18N
        jPanel19.setPreferredSize(new java.awt.Dimension(260, 200));
        jPanel19.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING, 5, 8));

        rdb_sxDoanhThuDichVuMax.setBackground(new java.awt.Color(255, 255, 255));
        btnG_dv_sapxep.add(rdb_sxDoanhThuDichVuMax);
        rdb_sxDoanhThuDichVuMax.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        rdb_sxDoanhThuDichVuMax.setText("Doanh Thu Cao Nhất");
        rdb_sxDoanhThuDichVuMax.setMargin(new java.awt.Insets(2, 7, 2, 2));
        rdb_sxDoanhThuDichVuMax.setPreferredSize(new java.awt.Dimension(200, 23));
        rdb_sxDoanhThuDichVuMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_sxDoanhThuDichVuMaxActionPerformed(evt);
            }
        });
        jPanel19.add(rdb_sxDoanhThuDichVuMax);

        rdb_sxDoanhThuDichVuMin.setBackground(new java.awt.Color(255, 255, 255));
        btnG_dv_sapxep.add(rdb_sxDoanhThuDichVuMin);
        rdb_sxDoanhThuDichVuMin.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        rdb_sxDoanhThuDichVuMin.setText("Doanh Thu Thấp Nhất");
        rdb_sxDoanhThuDichVuMin.setMargin(new java.awt.Insets(2, 7, 2, 2));
        rdb_sxDoanhThuDichVuMin.setPreferredSize(new java.awt.Dimension(200, 23));
        rdb_sxDoanhThuDichVuMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb_sxDoanhThuDichVuMinActionPerformed(evt);
            }
        });
        jPanel19.add(rdb_sxDoanhThuDichVuMin);

        jPanel16.add(jPanel19);

        jPanel9.add(jPanel16, java.awt.BorderLayout.LINE_START);

        jPanel17.setLayout(new java.awt.BorderLayout());

        jPanel20.setPreferredSize(new java.awt.Dimension(931, 30));

        jLabel11.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("   Tổng:");
        jLabel11.setPreferredSize(new java.awt.Dimension(110, 15));

        lb_dichvu_tongdoanhthu.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        lb_dichvu_tongdoanhthu.setForeground(new java.awt.Color(204, 0, 0));
        lb_dichvu_tongdoanhthu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_dichvu_tongdoanhthu.setPreferredSize(new java.awt.Dimension(110, 15));

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap(1229, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(lb_dichvu_tongdoanhthu, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_dichvu_tongdoanhthu, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel17.add(jPanel20, java.awt.BorderLayout.PAGE_END);

        tb_dichvu.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        tb_dichvu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Tên Dịch Vụ", "Số Lượt Sử Dụng", "Doanh Thu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_dichvu.setRowHeight(25);
        tb_dichvu.setRowMargin(2);
        tb_dichvu.setSelectionBackground(new java.awt.Color(204, 255, 255));
        tb_dichvu.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane6.setViewportView(tb_dichvu);
        if (tb_dichvu.getColumnModel().getColumnCount() > 0) {
            tb_dichvu.getColumnModel().getColumn(0).setPreferredWidth(35);
            tb_dichvu.getColumnModel().getColumn(1).setPreferredWidth(75);
            tb_dichvu.getColumnModel().getColumn(2).setPreferredWidth(50);
            tb_dichvu.getColumnModel().getColumn(3).setPreferredWidth(150);
        }

        jPanel17.add(jScrollPane6, java.awt.BorderLayout.CENTER);

        jPanel9.add(jPanel17, java.awt.BorderLayout.CENTER);

        jTabbedPane2.addTab("Dịch Vụ", jPanel9);

        jPanel7.add(jTabbedPane2, java.awt.BorderLayout.PAGE_START);

        add(jPanel7, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void rdb_sxDoanhThuDichVuMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_sxDoanhThuDichVuMinActionPerformed
        SXDichVu_ThuTu = "ASC";
        try {
            DoanhThuDichVu(SXTHEOTHANG, SXDichVu_ThuTu);
        } catch (IOException ex) {
            Logger.getLogger(JP_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rdb_sxDoanhThuDichVuMinActionPerformed

    private void rdb_sxDoanhThuDichVuMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_sxDoanhThuDichVuMaxActionPerformed
        SXDichVu_ThuTu = "DESC";
        try {
            DoanhThuDichVu(SXTHEOTHANG, SXDichVu_ThuTu);
        } catch (IOException ex) {
            Logger.getLogger(JP_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rdb_sxDoanhThuDichVuMaxActionPerformed

    private void rdb_dv_thang6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_dv_thang6ActionPerformed
        SXTHEOTHANG = "6";
        try {
            DoanhThuDichVu(SXTHEOTHANG, SXDichVu_ThuTu);
        } catch (IOException ex) {
            Logger.getLogger(JP_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rdb_dv_thang6ActionPerformed

    private void rdb_dv_thang5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_dv_thang5ActionPerformed
        SXTHEOTHANG = "5";
        try {
            DoanhThuDichVu(SXTHEOTHANG, SXDichVu_ThuTu);
        } catch (IOException ex) {
            Logger.getLogger(JP_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rdb_dv_thang5ActionPerformed

    private void rdb_dv_thang4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_dv_thang4ActionPerformed
        SXTHEOTHANG = "4";
        try {
            DoanhThuDichVu(SXTHEOTHANG, SXDichVu_ThuTu);
        } catch (IOException ex) {
            Logger.getLogger(JP_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rdb_dv_thang4ActionPerformed

    private void rdb_dv_thang3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_dv_thang3ActionPerformed
        SXTHEOTHANG = "3";
        try {
            DoanhThuDichVu(SXTHEOTHANG, SXDichVu_ThuTu);
        } catch (IOException ex) {
            Logger.getLogger(JP_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rdb_dv_thang3ActionPerformed

    private void rdb_dv_thang2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_dv_thang2ActionPerformed
        SXTHEOTHANG = "2";
        try {
            DoanhThuDichVu(SXTHEOTHANG, SXDichVu_ThuTu);
        } catch (IOException ex) {
            Logger.getLogger(JP_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rdb_dv_thang2ActionPerformed

    private void rdb_dv_thang1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_dv_thang1ActionPerformed
        SXTHEOTHANG = "1";
        try {
            DoanhThuDichVu(SXTHEOTHANG, SXDichVu_ThuTu);
        } catch (IOException ex) {
            Logger.getLogger(JP_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rdb_dv_thang1ActionPerformed

    private void rdb_sxDoanhThuSanPhamMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_sxDoanhThuSanPhamMinActionPerformed
        SXSanPham_ThuTu = "ASC";
        try {
            DoanhThuSanPham(SXTHEOTHANG, SXSanPham_ThuTu);
        } catch (IOException ex) {
            Logger.getLogger(JP_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rdb_sxDoanhThuSanPhamMinActionPerformed

    private void rdb_sxDoanhThuSanPhamMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_sxDoanhThuSanPhamMaxActionPerformed
        SXSanPham_ThuTu = "DESC";
        try {
            DoanhThuSanPham(SXTHEOTHANG, SXSanPham_ThuTu);
        } catch (IOException ex) {
            Logger.getLogger(JP_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rdb_sxDoanhThuSanPhamMaxActionPerformed

    private void rdb_sp_thang6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_sp_thang6ActionPerformed
        SXTHEOTHANG = "6";
        try {
            DoanhThuSanPham(SXTHEOTHANG, SXSanPham_ThuTu);
        } catch (IOException ex) {
            Logger.getLogger(JP_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rdb_sp_thang6ActionPerformed

    private void rdb_sp_thang5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_sp_thang5ActionPerformed
        SXTHEOTHANG = "5";
        try {
            DoanhThuSanPham(SXTHEOTHANG, SXSanPham_ThuTu);
        } catch (IOException ex) {
            Logger.getLogger(JP_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rdb_sp_thang5ActionPerformed

    private void rdb_sp_thang4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_sp_thang4ActionPerformed
        SXTHEOTHANG = "4";
        try {
            DoanhThuSanPham(SXTHEOTHANG, SXSanPham_ThuTu);
        } catch (IOException ex) {
            Logger.getLogger(JP_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rdb_sp_thang4ActionPerformed

    private void rdb_sp_thang3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_sp_thang3ActionPerformed
        SXTHEOTHANG = "3";
        try {
            DoanhThuSanPham(SXTHEOTHANG, SXSanPham_ThuTu);
        } catch (IOException ex) {
            Logger.getLogger(JP_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rdb_sp_thang3ActionPerformed

    private void rdb_sp_thang2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_sp_thang2ActionPerformed
        SXTHEOTHANG = "2";
        try {
            DoanhThuSanPham(SXTHEOTHANG, SXSanPham_ThuTu);
        } catch (IOException ex) {
            Logger.getLogger(JP_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rdb_sp_thang2ActionPerformed

    private void rdb_sp_thang1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_sp_thang1ActionPerformed
        SXTHEOTHANG = "1";
        try {
            DoanhThuSanPham(SXTHEOTHANG, SXSanPham_ThuTu);
        } catch (IOException ex) {
            Logger.getLogger(JP_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rdb_sp_thang1ActionPerformed

    private void rdb_sxDoanhThuPhongMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_sxDoanhThuPhongMinActionPerformed
        SXPhong_ThuTu = "ASC";
        try {
            DoanhThuPhong(SXTHEOTHANG, SXPhong_ThuTu);
        } catch (IOException ex) {
            Logger.getLogger(JP_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rdb_sxDoanhThuPhongMinActionPerformed

    private void rdb_sxDoanhThuPhongMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_sxDoanhThuPhongMaxActionPerformed
        SXPhong_ThuTu = "DESC";
        try {
            DoanhThuPhong(SXTHEOTHANG, SXPhong_ThuTu);
        } catch (IOException ex) {
            Logger.getLogger(JP_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rdb_sxDoanhThuPhongMaxActionPerformed

    private void rdb_thang5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_thang5ActionPerformed
        SXTHEOTHANG = "5";
        try {
            DoanhThuPhong(SXTHEOTHANG, SXPhong_ThuTu);
        } catch (IOException ex) {
            Logger.getLogger(JP_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rdb_thang5ActionPerformed

    private void rdb_thang4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_thang4ActionPerformed
        SXTHEOTHANG = "4";
        try {
            DoanhThuPhong(SXTHEOTHANG, SXPhong_ThuTu);
        } catch (IOException ex) {
            Logger.getLogger(JP_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rdb_thang4ActionPerformed

    private void rdb_thang2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_thang2ActionPerformed
        SXTHEOTHANG = "2";
        try {
            DoanhThuPhong(SXTHEOTHANG, SXPhong_ThuTu);
        } catch (IOException ex) {
            Logger.getLogger(JP_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rdb_thang2ActionPerformed

    private void rdb_thang1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_thang1ActionPerformed
        SXTHEOTHANG = "1";

        try {
            DoanhThuPhong(SXTHEOTHANG, SXPhong_ThuTu);
        } catch (IOException ex) {
            Logger.getLogger(JP_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rdb_thang1ActionPerformed

    private void rdb_sp_thang7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_sp_thang7ActionPerformed
        SXTHEOTHANG = "7";
        try {
            DoanhThuSanPham(SXTHEOTHANG, SXSanPham_ThuTu);
        } catch (IOException ex) {
            Logger.getLogger(JP_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rdb_sp_thang7ActionPerformed

    private void rdb_sp_thang8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_sp_thang8ActionPerformed
        SXTHEOTHANG = "8";
        try {
            DoanhThuSanPham(SXTHEOTHANG, SXSanPham_ThuTu);
        } catch (IOException ex) {
            Logger.getLogger(JP_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rdb_sp_thang8ActionPerformed

    private void rdb_sp_thang9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_sp_thang9ActionPerformed
        SXTHEOTHANG = "9";
        try {
            DoanhThuSanPham(SXTHEOTHANG, SXSanPham_ThuTu);
        } catch (IOException ex) {
            Logger.getLogger(JP_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }//GEN-LAST:event_rdb_sp_thang9ActionPerformed

    private void rdb_sp_thang10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_sp_thang10ActionPerformed
        SXTHEOTHANG = "10";
        try {
            DoanhThuSanPham(SXTHEOTHANG, SXSanPham_ThuTu);
        } catch (IOException ex) {
            Logger.getLogger(JP_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_rdb_sp_thang10ActionPerformed

    private void rdb_sp_thang11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_sp_thang11ActionPerformed
        SXTHEOTHANG = "11";
        try {
            DoanhThuSanPham(SXTHEOTHANG, SXSanPham_ThuTu);
        } catch (IOException ex) {
            Logger.getLogger(JP_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rdb_sp_thang11ActionPerformed

    private void rdb_sp_thang12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_sp_thang12ActionPerformed
        SXTHEOTHANG = "12";
        try {
            DoanhThuSanPham(SXTHEOTHANG, SXSanPham_ThuTu);
        } catch (IOException ex) {
            Logger.getLogger(JP_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_rdb_sp_thang12ActionPerformed

    private void rdb_thang6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_thang6ActionPerformed
        SXTHEOTHANG = "6";
        try {
            DoanhThuPhong(SXTHEOTHANG, SXPhong_ThuTu);
        } catch (IOException ex) {
            Logger.getLogger(JP_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rdb_thang6ActionPerformed

    private void rdb_thang7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_thang7ActionPerformed
        SXTHEOTHANG = "7";
        try {
            DoanhThuPhong(SXTHEOTHANG, SXPhong_ThuTu);
        } catch (IOException ex) {
            Logger.getLogger(JP_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rdb_thang7ActionPerformed

    private void rdb_thang8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_thang8ActionPerformed
        SXTHEOTHANG = "8";
        try {
            DoanhThuPhong(SXTHEOTHANG, SXPhong_ThuTu);
        } catch (IOException ex) {
            Logger.getLogger(JP_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rdb_thang8ActionPerformed

    private void rdb_thang9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_thang9ActionPerformed
        SXTHEOTHANG = "9";
        try {
            DoanhThuPhong(SXTHEOTHANG, SXPhong_ThuTu);
        } catch (IOException ex) {
            Logger.getLogger(JP_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rdb_thang9ActionPerformed

    private void rdb_thang10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_thang10ActionPerformed
        SXTHEOTHANG = "10";
        try {
            DoanhThuPhong(SXTHEOTHANG, SXPhong_ThuTu);
        } catch (IOException ex) {
            Logger.getLogger(JP_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rdb_thang10ActionPerformed

    private void rdb_thang11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_thang11ActionPerformed
        SXTHEOTHANG = "11";
        try {
            DoanhThuPhong(SXTHEOTHANG, SXPhong_ThuTu);
        } catch (IOException ex) {
            Logger.getLogger(JP_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rdb_thang11ActionPerformed

    private void rdb_thang12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_thang12ActionPerformed
        SXTHEOTHANG = "12";
        try {
            DoanhThuPhong(SXTHEOTHANG, SXPhong_ThuTu);
        } catch (IOException ex) {
            Logger.getLogger(JP_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rdb_thang12ActionPerformed

    private void rdb_dv_thang7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_dv_thang7ActionPerformed
        SXTHEOTHANG = "7";
        try {
            DoanhThuDichVu(SXTHEOTHANG, SXDichVu_ThuTu);
        } catch (IOException ex) {
            Logger.getLogger(JP_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rdb_dv_thang7ActionPerformed

    private void rdb_dv_thang8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_dv_thang8ActionPerformed
        SXTHEOTHANG = "8";
        try {
            DoanhThuDichVu(SXTHEOTHANG, SXDichVu_ThuTu);
        } catch (IOException ex) {
            Logger.getLogger(JP_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rdb_dv_thang8ActionPerformed

    private void rdb_dv_thang9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_dv_thang9ActionPerformed
        SXTHEOTHANG = "9";
        try {
            DoanhThuDichVu(SXTHEOTHANG, SXDichVu_ThuTu);
        } catch (IOException ex) {
            Logger.getLogger(JP_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rdb_dv_thang9ActionPerformed

    private void rdb_dv_thang10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_dv_thang10ActionPerformed
        SXTHEOTHANG = "10";
        try {
            DoanhThuDichVu(SXTHEOTHANG, SXDichVu_ThuTu);
        } catch (IOException ex) {
            Logger.getLogger(JP_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rdb_dv_thang10ActionPerformed

    private void rdb_dv_thang11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_dv_thang11ActionPerformed
        SXTHEOTHANG = "11";
        try {
            DoanhThuDichVu(SXTHEOTHANG, SXDichVu_ThuTu);
        } catch (IOException ex) {
            Logger.getLogger(JP_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rdb_dv_thang11ActionPerformed

    private void rdb_dv_thang12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb_dv_thang12ActionPerformed
        SXTHEOTHANG = "12";
        try {
            DoanhThuDichVu(SXTHEOTHANG, SXDichVu_ThuTu);
        } catch (IOException ex) {
            Logger.getLogger(JP_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rdb_dv_thang12ActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnG_dv_sapxep;
    private javax.swing.ButtonGroup btnG_dv_thang;
    private javax.swing.ButtonGroup btnG_sapxep;
    private javax.swing.ButtonGroup btnG_sp_sapxep;
    private javax.swing.ButtonGroup btnG_sp_thang;
    private javax.swing.ButtonGroup btnG_thang;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel8;
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
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel lb_dichvu_tongdoanhthu;
    private javax.swing.JLabel lb_dtdv;
    private javax.swing.JLabel lb_dtphong;
    private javax.swing.JLabel lb_dtsp;
    private javax.swing.JLabel lb_phong_tongdoanhthu;
    private javax.swing.JLabel lb_sanpham_tongdoanhthu;
    private javax.swing.JLabel lb_sldv;
    private javax.swing.JLabel lb_slsp;
    private javax.swing.JLabel lb_tongdoanhthu;
    private javax.swing.JLabel lb_tonggianhap;
    private javax.swing.JLabel lb_tongphong;
    private javax.swing.JRadioButton rdb_dv_thang1;
    private javax.swing.JRadioButton rdb_dv_thang10;
    private javax.swing.JRadioButton rdb_dv_thang11;
    private javax.swing.JRadioButton rdb_dv_thang12;
    private javax.swing.JRadioButton rdb_dv_thang2;
    private javax.swing.JRadioButton rdb_dv_thang3;
    private javax.swing.JRadioButton rdb_dv_thang4;
    private javax.swing.JRadioButton rdb_dv_thang5;
    private javax.swing.JRadioButton rdb_dv_thang6;
    private javax.swing.JRadioButton rdb_dv_thang7;
    private javax.swing.JRadioButton rdb_dv_thang8;
    private javax.swing.JRadioButton rdb_dv_thang9;
    private javax.swing.JRadioButton rdb_sp_thang1;
    private javax.swing.JRadioButton rdb_sp_thang10;
    private javax.swing.JRadioButton rdb_sp_thang11;
    private javax.swing.JRadioButton rdb_sp_thang12;
    private javax.swing.JRadioButton rdb_sp_thang2;
    private javax.swing.JRadioButton rdb_sp_thang3;
    private javax.swing.JRadioButton rdb_sp_thang4;
    private javax.swing.JRadioButton rdb_sp_thang5;
    private javax.swing.JRadioButton rdb_sp_thang6;
    private javax.swing.JRadioButton rdb_sp_thang7;
    private javax.swing.JRadioButton rdb_sp_thang8;
    private javax.swing.JRadioButton rdb_sp_thang9;
    private javax.swing.JRadioButton rdb_sxDoanhThuDichVuMax;
    private javax.swing.JRadioButton rdb_sxDoanhThuDichVuMin;
    private javax.swing.JRadioButton rdb_sxDoanhThuPhongMax;
    private javax.swing.JRadioButton rdb_sxDoanhThuPhongMin;
    private javax.swing.JRadioButton rdb_sxDoanhThuSanPhamMax;
    private javax.swing.JRadioButton rdb_sxDoanhThuSanPhamMin;
    private javax.swing.JRadioButton rdb_thang1;
    private javax.swing.JRadioButton rdb_thang10;
    private javax.swing.JRadioButton rdb_thang11;
    private javax.swing.JRadioButton rdb_thang12;
    private javax.swing.JRadioButton rdb_thang2;
    private javax.swing.JRadioButton rdb_thang3;
    private javax.swing.JRadioButton rdb_thang4;
    private javax.swing.JRadioButton rdb_thang5;
    private javax.swing.JRadioButton rdb_thang6;
    private javax.swing.JRadioButton rdb_thang7;
    private javax.swing.JRadioButton rdb_thang8;
    private javax.swing.JRadioButton rdb_thang9;
    private javax.swing.JTable tb_TongDoanhThu;
    private javax.swing.JTable tb_dichvu;
    private javax.swing.JTable tb_phong;
    private javax.swing.JTable tb_sanpham;
    // End of variables declaration//GEN-END:variables
}
