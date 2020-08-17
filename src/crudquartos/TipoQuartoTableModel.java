/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudquartos;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TipoQuartoTableModel extends AbstractTableModel {

    private List<TipoQuarto> dados = new ArrayList();
    private String[] colunas = {"ID", "Descrição", "Capacidade", "Cômodos", "Banheiros", "Valor reserva"};

    public TipoQuartoTableModel() {
        updateData("");
    }

    public void updateData(String busca) {
        if (busca.equals("")) {
            this.dados = new TipoQuartoDAO().findAll();
            this.fireTableDataChanged();
        } else {
            this.dados = new TipoQuartoDAO().findAllByDescription(busca);
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
                return dados.get(linha).getId_tipo_quarto();
            case 1:
                return dados.get(linha).getDs_tipo_quarto();
            case 2:
                return dados.get(linha).getNr_capacidade();
            case 3:
                return dados.get(linha).getNr_comodo();
            case 4:
                return dados.get(linha).getNr_banheiro();
            case 5:
                //return dados.get(linha).getVl_reserva();
                NumberFormat formatter = new DecimalFormat("###,###,##0.00");
                String s = formatter.format(dados.get(linha).getVl_reserva());
                return s;
        }

        return null;
    }

}
