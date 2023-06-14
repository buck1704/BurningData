
package container;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class Table_CanGiua extends DefaultTableCellRenderer {
    private int cot, viTri;

    public Table_CanGiua(int cot, int viTri) {
        this.cot = cot;
        setHorizontalAlignment(viTri); // căn giữa nội dung trong ô
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        // kiểm tra xem cột của ô đó có phải là cột được chỉ định hay không
        if (column == this.cot) {
            setHorizontalAlignment(viTri);
        } else {
            setHorizontalAlignment(JLabel.LEFT);
        }
        return cellComponent;
    }
}
