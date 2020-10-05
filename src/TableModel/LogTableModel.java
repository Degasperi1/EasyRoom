package TableModel;

import Utils.LogUtils;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author evandro
 */
public class LogTableModel extends AbstractTableModel {

    private List<LogUtils.LogData> dados = new ArrayList<>();
    private String[] colunas = {"Tipo", "Timestamp", "Mensagem"};

    public LogTableModel() {
        updateData("");
    }

    //PEGA TUDO
    public void updateData(String criteria) {
        this.dados = LogUtils.getLogs("src/logs.log", criteria);
        //ATUALIZA TABELA (TableModel)
        this.fireTableDataChanged();
    }

    public void updateData(String criteria, String tipoErro, String dataInicial, String dataFinal) {
        this.dados = LogUtils.getLogs("src/logs.log", criteria, tipoErro, dataInicial, dataFinal);
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return this.dados.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column]; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna) {
            case 0:
                return dados.get(linha).getType();
            case 1:
                return dados.get(linha).getTimestamp();
            case 2:
                return dados.get(linha).getMessage();
        }
        return null;
    }

    public void removeRow(int linha) {
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);// parâmetros ~> (início, fim)
    }
    
    private void showData() {
        dados.stream().map((dado) -> {
            System.out.println("<><><><><><><><><><><><><><><><><><>");
            return dado;
        }).map((dado) -> {
            System.out.println("Tipo:"+dado.getType()+"|");
            return dado;
        }).map((dado) -> {
            System.out.println("Timestamp:"+dado.getTimestamp()+"|");
            return dado;
        }).map((dado) -> {
            System.out.println("Mensagem:"+dado.getMessage()+"|");
            return dado;
        }).forEachOrdered((_item) -> {
            System.out.println("<><><><><><><><><><><><><><><><><><>");
        });
    }
}
