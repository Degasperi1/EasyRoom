/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudquartos;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author evand
 */
public class TipoQuartoDAO extends Dao<TipoQuarto> {

    public TipoQuarto findById(int id) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transacao = sessao.beginTransaction();
            TipoQuarto retorno = (TipoQuarto) sessao.get(TipoQuarto.class, id);
            return retorno;
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }

    public List<TipoQuarto> findAllByDescription(String criteria) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<TipoQuarto> tipoquartos = null;
        try {
            org.hibernate.Query q = sessao.createQuery
        ("from TipoQuarto t WHERE ds_tipo_quarto LIKE '%" + criteria + "%' AND ie_situacao = 'A'");
            tipoquartos = q.list();
            return tipoquartos;
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }

    public List<TipoQuarto> findAll() {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<TipoQuarto> tipoquartos = null;
        try {
            org.hibernate.Query q = sessao.createQuery("from TipoQuarto t WHERE ie_situacao = 'A'");
            tipoquartos = q.list();
            return tipoquartos;
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }
}
