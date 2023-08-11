package control;
// tại đây sử phương thức để chuyển đổi nội dung trên màn hình khi người dùng nhấp vào các nhãn.
import bean.chuyenmanhinh_bean;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import view.Home_BackUp;
import view.JP_ChucVu;
import view.JP_DatPhong;
import view.JP_DichVu;
import view.JP_HangHoa;
import view.JP_KhachHang;
import view.JP_LoaiHang;
import view.JP_NhanVien;
import view.JP_NhapHang;
import view.JP_PhieuDangKy;
import view.JP_PhieuDangKy;
import view.JP_PhieuDichVu;
import view.JP_Phong;

public class control_chuyenmanhinh {
    private JPanel root;
    private String kindSelected = "";
    private List<chuyenmanhinh_bean> listItem = null;
    
    public control_chuyenmanhinh(JPanel jpnRoot){
        this.root = jpnRoot;
    }
    // nội dung của một JPanel được đặt lại và thay thế bằng một đối tượng "JP_ChucVu". 
    // Các tham số của phương thức "setView" là một JPanel "jpnItem", và một danh sách "listItem" các đối tượng "chuyenmanhinh_bean".
    public void setView(JPanel jpnItem) throws IOException{
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new JP_ChucVu());
        root.validate();
        root.repaint();
    }
    public void setEvent(List<chuyenmanhinh_bean> listItem){
        this.listItem = listItem;
        
        for(chuyenmanhinh_bean item : listItem){
            item.getPanel_chuyen().addMouseListener(new LabelEvent(item.getCheck_chuyen(), item.getPanel_chuyen(), item.getLabel_chuyen()));
        }
    }
    class LabelEvent implements MouseListener{
        private JPanel node;
        private String check;
        private JPanel btnItem;
        private JLabel jlbItem;

        public LabelEvent(String check, JPanel btnItem,JLabel jlbItem) {
            this.check = check;
            this.btnItem = btnItem;
            this.jlbItem = jlbItem;
        }
        
        @Override
        public void mouseClicked(MouseEvent e) {
            switch (check) {
                case "QuanLyChucVu": {
                    try {
                        node = new JP_ChucVu();
                    } catch (IOException ex) {
                        Logger.getLogger(control_chuyenmanhinh.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
                
                case "QuanLyPhong": {
                    try {
                        node = new JP_Phong();
                    } catch (IOException ex) {
                        Logger.getLogger(control_chuyenmanhinh.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
                
                case "QuanLyDichVu": {
                    try {
                        node = new JP_DichVu();
                    } catch (IOException ex) {
                        Logger.getLogger(control_chuyenmanhinh.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
                
                case "QuanLyNhanVien": {
                    node = new JP_NhanVien();
                }
                break;

                case "QuanLyKhachHang": {
                    try {
                        node = new JP_KhachHang();
                    } catch (IOException ex) {
                        Logger.getLogger(control_chuyenmanhinh.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
                
                case "PhieuDatPhong": {
                    try {
                        node = new JP_DatPhong();
                    } catch (IOException ex) {
                        Logger.getLogger(control_chuyenmanhinh.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
                break;
                
                case "Home": {
                    node = new Home_BackUp();
                }
                break;
                
                case "PhieuDichVu": {
                    try {
                        node = new JP_PhieuDichVu();
                    } catch (IOException ex) {
                        Logger.getLogger(control_chuyenmanhinh.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
                
                case "NhapHang": {
                    node = new JP_NhapHang();
                }
                break;
                
                case "KhoHang": {
                    node = new JP_HangHoa();

                }
                break;
                
//                case "HoaDon":
//                {
//                    try {
//                        node = new JP_ChucVu();
//                    } catch (IOException ex) {
//                        Logger.getLogger(control_chuyenmanhinh.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//                    break;

            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
        }
        

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
        
    }
}
