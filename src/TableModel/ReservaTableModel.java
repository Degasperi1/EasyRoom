/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TableModel;

import DAO.PessoaFisicaDAO;
import DAO.ReservaDAO;
import Entidade.PessoaFisica;
import Entidade.Reserva;
import Utils.Formatacao;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author evand
 */
public class ReservaTableModel extends AbstractTableModel {

    private List<Reserva> dados = new ArrayList<>();
    private String[] colunas = {"ID", "Nome", "Quarto", "TipoQuarto",
        "Dt. Inicial", "Dt. Final", "Valor Total"
    };
    private PessoaFisica pf;

    public void setPf(PessoaFisica pf) {
        this.pf = pf;
    }

    public ReservaTableModel() {
        updateData("");
    }

    public void updateData(String busca) {
        if (busca.equals("")) {
            this.dados = new ReservaDAO().findAll();
            this.fireTableDataChanged();
        } else {
            this.dados = new ReservaDAO().findAllByDescription(busca);
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
                return new PessoaFisicaDAO().findByEntityId(pf.getId()).getNome();
            case 2:
                return dados.get(linha).getCpf();
            case 3:
                return dados.get(linha).getRg();
            case 4:
                return Formatacao.ajustaDataDMA(dados.get(linha).getDataNascimento().toString());
            case 5:
                return dados.get(linha).getIdEntidade().getId();
        }

        return null;
    }
}
