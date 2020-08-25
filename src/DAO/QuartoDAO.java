/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidade.Quarto;
import Utils.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author evand
 */
public class QuartoDAO extends Dao<Quarto> {

    public Quarto findById(int id) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transacao = sessao.beginTransaction();
            Quarto retorno = (Quarto) sessao.get(Quarto.class, id);
            return retorno;
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }
    
    public List<Quarto> findAllByDescription(String criteria) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Quarto> quartos = null;
        try {
            org.hibernate.Query q = sessao.createQuery("from Quarto q WHERE nr_quarto LIKE '%" + criteria + "%' AND ie_situacao = 'A' ORDER BY nr_quarto");
            quartos = q.list();
            return quartos;
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }

    public List<Quarto> findAll() {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Quarto> produtos = null;
        try {
            org.hibernate.Query q = sessao.createQuery("from Quarto q WHERE ie_situacao = 'A' ORDER BY nr_quarto");
            produtos = q.list();
            return produtos;
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }
}
