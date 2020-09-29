/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TableModel;

import DAO.AuditoriaDAO;
import Entidade.AuditoriaDados;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author evand
 */
public class AuditoriaTableModel extends AbstractTableModel {

    private List<AuditoriaDados> dados = new ArrayList<>();
    private String[] colunas = {"ID User", "Timestamp", "Tabela", "Operação"};

    public AuditoriaTableModel() {
        updateData("");
    }

    public void updateData(String busca) {
        if (busca.equals("")) {
            this.dados = new AuditoriaDAO().findAll();
            this.fireTableDataChanged();
        }
    }
    // BUSCA PERSONALIZADA
    public void updateData(String userid, String operation,
            String table, String dataInicial, String dataFinal) {
        StringBuilder sql = new StringBuilder("from AuditoriaDados WHERE 1=1");
        if (!userid.equals("")) {
            sql.append("AND userid = " + userid);
        } else if (!operation.equals("")) {
            sql.append("AND operation = '" + operation + "'");
        } else if (!table.equals("")) {
            //sql.append("AND table_name = '" + table + "'");
            sql.append("AND table_name LIKE '%" + table + "%'");
        }
        // - Verificar Datas
        if (!dataInicial.equals("") && dataFinal.equals("")) { // event_time_utc > data
            sql.append("AND event_time_utc > '"+dataInicial+"' ");
        }else if (dataInicial.equals("") && !dataFinal.equals("")) { //  event_time_utc < data 
            sql.append("AND event_time_utc < '"+dataFinal+"' ");
        }else if (!dataInicial.equals("") && !dataFinal.equals("")) { // BETWEEN
            sql.append("AND event_time_utc BETWEEN '"+dataInicial+"' AND '"+dataFinal+"' ");
        }

        this.dados = new AuditoriaDAO().findBySQL(sql.toString());
        this.fireTableDataChanged();       
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
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna) {
            case 0:
                return dados.get(linha).getUserid();
            case 1:
                return dados.get(linha).getEvent_time_utc();
            case 2:
                //com o schema do banco onde a tabela está
                //return dados.get(linha).getTable_name();
                
                //sem o schema
                String tbl = dados.get(linha).getTable_name();
                return tbl.substring(tbl.indexOf(".")+1);
            case 3:
                return dados.get(linha).getOperation();

        }

        return null;
    }
}
