/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TableModel;

import DAO.QuartoDAO;
import Entidade.Quarto;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author evand
 */
public class QuartoTableModel extends AbstractTableModel {

private List<Quarto> dados = new ArrayList<>();
    private String[] colunas = {"ID", "Número", "Andar"};

    public QuartoTableModel() {
        updateData("");
    }

    public void updateData(String busca) {
        if (busca.equals("")) {
            this.dados = new QuartoDAO().findAll();
            this.fireTableDataChanged();
        } else {
            this.dados = new QuartoDAO().findAllByDescription(busca);
            this.fireTableDataChanged();
        }
    }

    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int column) {//retorna o nome da Coluna, o java usa para noemar as colunas também!
        return colunas[column];
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna) {
            case 0:
                return dados.get(linha).getId_quarto();
            case 1:
                return dados.get(linha).getNr_quarto();
            case 2:
                return dados.get(linha).getNr_andar();
        }

        return null;
    }
}
