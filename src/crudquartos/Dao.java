/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudquartos;

import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author evand
 */
public class Dao<T> {

    public void save(T object) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transacao = sessao.beginTransaction();
            sessao.save(object);
            transacao.commit();
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
            JOptionPane.showMessageDialog(null, "Problemas ao inserir.\nMensagem técnica: "+hibEx.toString(), "Erro!", JOptionPane.ERROR_MESSAGE);
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
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
            JOptionPane.showMessageDialog(null, "Problemas ao atualizar.\nMensagem técnica: "+hibEx.toString(), "Erro!", JOptionPane.ERROR_MESSAGE);
        } finally {
            sessao.close();
        }
    }
}
