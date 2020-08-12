/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apoio.HibernateUtil;
import entidade.Cidade;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author evand
 */
public class CidadeDAO {
        public void salvar(Cidade c) {
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction transacao = sessao.beginTransaction();            
            if (c.getId_cidade() == 0) { //é INSERT
                sessao.save(c);
            } else { //é UPDATE
                sessao.update(c);
            }
            transacao.commit();
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
    }
}
