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

    //PEGA DE ACORDO COM O ERRO
    public void updateData(String criteria, String tipoErro) {
        this.dados = LogUtils.getLogs("src/logs.log", criteria, tipoErro);
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
}
