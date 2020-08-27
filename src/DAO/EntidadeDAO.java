/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidade.Entidade;
import Entidade.PessoaFisica;
import Utils.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Degasperi
 */
public class EntidadeDAO extends Dao<Entidade> {
    
    public Entidade findById(int id) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transacao = sessao.beginTransaction();
            Entidade retorno = (Entidade) sessao.get(Entidade.class, id);
            return retorno;
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }

    public List<Entidade> findAllByDescription(String criteria) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Entidade> entidade = null;
        try {
            org.hibernate.Query q = sessao.createQuery("from Entidade e, PessoaFisica p WHERE e.ie_situacao = 'A' "
                    + "AND e.ie_situacao = 'A' "
                    + "AND p.nm_pessoa_fisica LIKE '%" + criteria + " ORDER BY e.id_entidade");
            entidade = q.list();
            return entidade;
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }

    public List<Entidade> findAll() {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Entidade> entidade = null;
        try {
            org.hibernate.Query q = sessao.createQuery("from Entidade WHERE ie_situacao = 'A' ORDER BY id_entidade");
            entidade = q.list();
            return entidade;
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }        
   
}
