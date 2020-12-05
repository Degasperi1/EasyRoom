/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Utils.HibernateUtil;
import Entidade.PessoaFisica;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Degasperi
 */
public class PessoaFisicaDAO extends Dao<PessoaFisica> {

    public PessoaFisica findById(int id) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transacao = sessao.beginTransaction();
            PessoaFisica retorno = (PessoaFisica) sessao.get(PessoaFisica.class, id);
            return retorno;
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }

    public PessoaFisica findByEntityId(int id) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        PessoaFisica pessoaFisica = null;
        try {
            org.hibernate.Query q = sessao.createQuery("FROM\n"
                    + "	pessoa_fisica a\n"
                    + "WHERE\n"
                    + "	a.id_entidade = "+id);
            pessoaFisica = (PessoaFisica) q.uniqueResult();
            return pessoaFisica;
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }

    public List<PessoaFisica> findAllByDescription(String criteria) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<PessoaFisica> pessoaFisica = null;
        try {
            org.hibernate.Query q = sessao.createQuery("from PessoaFisica p WHERE nm_pessoa_fisica LIKE '%" + criteria + " %' ORDER BY id_pessoa_fisica");
            pessoaFisica = q.list();
            return pessoaFisica;
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }

    public List<PessoaFisica> findAll() {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<PessoaFisica> pessoaFisica = null;
        try {
            org.hibernate.Query q = sessao.createQuery("from PessoaFisica ORDER BY id_pessoa_fisica");
            pessoaFisica = q.list();
            return pessoaFisica;
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }
}
