/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Utils.HibernateUtil;
import java.util.List;
import org.apache.log4j.Logger;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author evand
 */
public class Dao<T> {

    final static Logger logger = Logger.getLogger(Dao.class);

    public void save(T object) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transacao = sessao.beginTransaction();
            sessao.save(object);
            transacao.commit();
            JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso.", "SUCESSO!", JOptionPane.INFORMATION_MESSAGE);
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
            Dao.logger.error("Erro no registro: " + hibEx.toString());
            //Dao.logger.warn("Erro no registro: " + hibEx.toString());
            JOptionPane.showMessageDialog(null, "Problemas ao inserir.\nMensagem técnica: " + hibEx.toString(), "Erro!", JOptionPane.ERROR_MESSAGE);
        } finally {
            sessao.close();
        }
    }

    public void update(T object) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transacao = sessao.beginTransaction();
            sessao.update(object);
            transacao.commit();
            JOptionPane.showMessageDialog(null, "Atualização efetuada com sucesso.", "SUCESSO!", JOptionPane.INFORMATION_MESSAGE);
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
            Dao.logger.error("Erro no registro: " + hibEx.toString());
            //Dao.logger.warn("Erro no registro: " + hibEx.toString());
            JOptionPane.showMessageDialog(null, "Problemas ao atualizar.\nMensagem técnica: " + hibEx.toString(), "Erro!", JOptionPane.ERROR_MESSAGE);
        } finally {
            sessao.close();
        }
    }

    public void delete(T object) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transacao = sessao.beginTransaction();
            sessao.update(object);
            transacao.commit();
            JOptionPane.showMessageDialog(null, "Exclusão efetuada com sucesso.", "SUCESSO!", JOptionPane.INFORMATION_MESSAGE);
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
            Dao.logger.error("Erro no registro: " + hibEx.toString());
            //Dao.logger.warn("Erro no registro: " + hibEx.toString());
            JOptionPane.showMessageDialog(null, "Problemas ao excluir.\nMensagem técnica: " + hibEx.toString(), "Erro!", JOptionPane.ERROR_MESSAGE);
        } finally {
            sessao.close();
        }
    }
}
