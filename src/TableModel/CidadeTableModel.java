/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import Entidade.Cidade;
import DAO.CidadeDAO;

/**
 *
 * @author Degasperi
 */
public class CidadeTableModel extends AbstractTableModel {

    private List<Cidade> dados = new ArrayList<>();
    private String[] colunas = {"ID", "Nome", "Estado"};

    public CidadeTableModel() {
        updateData("");
    }

    public void updateData(String busca) {
        if (busca.equals("")) {
            this.dados = new CidadeDAO().findAll();
            this.fireTableDataChanged();
        } else {
            this.dados = new CidadeDAO().findAllByDescription(busca);
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
                return dados.get(linha).getId_cidade();
            case 1:
                return dados.get(linha).getDs_cidade();
            case 2:
                //return dados.get(linha).getVl_venda();
                String s = dados.get(linha).getId_estado().getIe_estado();
                return s;
        }

        return null;
    }

}
