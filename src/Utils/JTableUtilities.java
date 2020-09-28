/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

/**
 *
 * @author evand
 */
public class JTableUtilities {

    public static void setCellsAlignment(JTable table, int alignment) {
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(alignment);

        TableModel tableModel = table.getModel();

        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++) {
            table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
        }
    }
//Usage:
//JTableUtilities.setCellsAlignment(table, SwingConstants.CENTER);

    public static void setCellsAlignment(JTable table, int alignment, int[] cols) {
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(alignment);

        TableModel tableModel = table.getModel();

        for (int i = 0; i < cols.length; i++) {
            table.getColumnModel().getColumn(cols[i]).setCellRenderer(rightRenderer);
        }
    }

//    public static void resizeColumns(JTable table, float[] columnWidthPercentage) {
//        // Use TableColumnModel.getTotalColumnWidth() if your table is included in a JScrollPane
//        int tW = table.getWidth();
//        TableColumn column;
//        TableColumnModel jTableColumnModel = table.getColumnModel();
//        int cantCols = jTableColumnModel.getColumnCount();
//        for (int i = 0; i < cantCols; i++) {
//            column = jTableColumnModel.getColumn(i);
//            int pWidth = Math.round(columnWidthPercentage[i] * tW);
//            column.setPreferredWidth(pWidth);
//        }
//    }
    public static void setWidthAsPercentages(JTable table,
            double... percentages) {
        final double factor = 10000;

        TableColumnModel model = table.getColumnModel();
        for (int columnIndex = 0; columnIndex < percentages.length; columnIndex++) {
            TableColumn column = model.getColumn(columnIndex);
            column.setPreferredWidth((int) (percentages[columnIndex] * factor));
        }
    }
}
