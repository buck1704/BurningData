package container;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class Table_ChuyenMau extends DefaultTableCellRenderer {
    private Color mauBackGround;
    private int cot, viTri;
    private String giaTri;

    // Constructor của lớp MyTableCellRenderer
    public Table_ChuyenMau(Color mauBackGround, int cot, String giaTri, int viTri) {
        this.mauBackGround = mauBackGround;
        this.cot = cot;
        this.giaTri = giaTri;
        setHorizontalAlignment(viTri); // căn giữa nội dung trong ô
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (column == this.cot) {
            if (giaTri.equals(value)) {
                setBackground(mauBackGround);
                setHorizontalAlignment(viTri);
            } else {
                setBackground(table.getBackground());
                setHorizontalAlignment(viTri);
            }
        } else {
            setBackground(table.getBackground());
            setHorizontalAlignment(viTri);
        }

        return cellComponent;
    }
}