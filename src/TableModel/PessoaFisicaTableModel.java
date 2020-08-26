/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TableModel;

import DAO.PessoaFisicaDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import Entidade.PessoaFisica;

/**
 *
 * @author evand
 */
public class PessoaFisicaTableModel extends AbstractTableModel {

    private List<PessoaFisica> dados = new ArrayList<>();
    private String[] colunas = {"ID","Nome", "CPF", "RG", "Dt. Nascimento"};

    public PessoaFisicaTableModel() {
        updateData("");
    }

    public void updateData(String busca) {
        if (busca.equals("")) {
            this.dados = new PessoaFisicaDAO().findAll();
            this.fireTableDataChanged();
        } else {
            this.dados = new PessoaFisicaDAO().findAllByDescription(busca);
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
                return dados.get(linha).getId();
            case 1:
                return dados.get(linha).getNome();
            case 2:
                return dados.get(linha).getCpf();
            case 3:
                return dados.get(linha).getRg();
            case 4:
                return dados.get(linha).getDataNascimento();
        }

        return null;
    }

//
//    public void addRow(Produto p) {
//        this.dados.add(p);
//        this.fireTableDataChanged();//atualiza a tabela quando houver alteração
//    }
//
//    public void removeRow(int linha) {
//        this.dados.remove(linha);
//        this.fireTableRowsDeleted(linha, linha);// parâmetros ~> (início, fim)
//    }
//    @Override
//    public void setValueAt(Object valor, int linha, int coluna) {
//        switch (coluna) {
//            case 0:
//                dados.get(linha).setId_produto(Integer.parseInt((String) valor));
//                break;
//            case 1:
//                dados.get(linha).setDs_produto((String) valor);
//                break;
//            case 2:
//                dados.get(linha).setVl_venda(Double.parseDouble((String) valor));//valor que vem do Text Field é sempre uma String
//                break;
//        }
//
//        this.fireTableRowsUpdated(linha, linha);
//    }
}
