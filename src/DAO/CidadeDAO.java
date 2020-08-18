/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Utils.HibernateUtil;
import Entidade.Cidade;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Degasperi
 */
public class CidadeDAO extends Dao<Cidade> {
    
    public Cidade findById(int id) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transacao = sessao.beginTransaction();
            Cidade retorno = (Cidade) sessao.get(Cidade.class, id);
            return retorno;
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }

    public List<Cidade> findAllByDescription(String criteria) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Cidade> cidade = null;
        try {
            org.hibernate.Query q = sessao.createQuery("from Cidade p WHERE ds_cidade LIKE '%" + criteria + "%' AND ie_situacao = 'A' ORDER BY id_cidade");
            cidade = q.list();
            return cidade;
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }

    public List<Cidade> findAll() {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Cidade> cidade = null;
        try {
            org.hibernate.Query q = sessao.createQuery("from Cidade WHERE ie_situacao = 'A' ORDER BY id_cidade");
            cidade = q.list();
            return cidade;
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }        
   
}

