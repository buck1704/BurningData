/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author 05032002
 */
public class chuyenmanhinh_bean {
    private String check_chuyen;
    private JPanel panel_chuyen;
    private JLabel label_chuyen;

    public chuyenmanhinh_bean(String check_chuyen, JPanel panel_chuyen, JLabel label_chuyen) {
        this.check_chuyen = check_chuyen;
        this.panel_chuyen = panel_chuyen;
        this.label_chuyen = label_chuyen;
    }

    public chuyenmanhinh_bean() {
    }

    public String getCheck_chuyen() {
        return check_chuyen;
    }

    public void setCheck_chuyen(String check_chuyen) {
        this.check_chuyen = check_chuyen;
    }

    public JPanel getPanel_chuyen() {
        return panel_chuyen;
    }

    public void setPanel_chuyen(JPanel panel_chuyen) {
        this.panel_chuyen = panel_chuyen;
    }

    public JLabel getLabel_chuyen() {
        return label_chuyen;
    }

    public void setLabel_chuyen(JLabel label_chuyen) {
        this.label_chuyen = label_chuyen;
    }

    
}
