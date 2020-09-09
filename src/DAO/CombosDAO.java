package DAO;

import Utils.ComboItens;
import Utils.HibernateUtil;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import org.hibernate.Session;

/**
 *
 * @author pretto
 */
public class CombosDAO {

    ResultSet resultado = null;

    public void popularCombo(String tabela, JComboBox combo) {

        ComboItens item = new ComboItens();
        item.setCodigo(0);
        item.setDescricao("Selecione");
        combo.addItem(item);

        //adiciona os demais itens à combo
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            List<Object> itens = sessao.createQuery("from " + tabela + " where ie_situacao = 'A' ORDER BY ds_tipo_quarto").list();
            for (Object i : itens) {
                combo.addItem(i);
            }
        } catch (Exception e) {
            System.out.println("Erro ao popular Combo = " + e.toString());
        }
    }

    public void definirItemCombo(JComboBox combo, Object item) {
        DefaultComboBoxModel model = (DefaultComboBoxModel) combo.getModel();
        for (int i = 1; i < model.getSize(); i++) {
            Object obj = model.getElementAt(i);
            if (obj.toString().equals(item.toString())) {
                model.setSelectedItem(item);
                return;
            }
        }
    }

}
