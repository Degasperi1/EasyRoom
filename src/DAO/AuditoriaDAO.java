/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidade.AuditoriaDados;
import Utils.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Compreende métodos de acesso às informações de auditoria.
 *
 * @author evand
 */
public class AuditoriaDAO {

    public List<AuditoriaDados> findAll() {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<AuditoriaDados> lista = null;
        try {
            org.hibernate.Query q = sessao.createQuery("from AuditoriaDados ORDER BY userid");
            lista = q.list();
            return lista;
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }
        public List<AuditoriaDados> findBySQL(String sql) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<AuditoriaDados> lista = null;
        try {
            org.hibernate.Query q = sessao.createQuery(sql);
            lista = q.list();
            return lista;
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }

    public AuditoriaDados findByUserId(int id) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transacao = sessao.beginTransaction();
            AuditoriaDados retorno = (AuditoriaDados) sessao.get(AuditoriaDados.class, id);
            return retorno;
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }

    public List<AuditoriaDados> findAllByTableName(String criteria) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<AuditoriaDados> lista = null;
        try {
            org.hibernate.Query q = sessao.createQuery("from AuditoriaDados a WHERE table_name LIKE '%" + criteria + "%' ORDER BY userid");
            lista = q.list();           //sempre o nome da entidade e o campo(atributo) que tem na entidade, não do banco
            return lista;
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }

    public List<AuditoriaDados> findAllByOperation(String criteria) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<AuditoriaDados> lista = null;
        try {
            org.hibernate.Query q = sessao.createQuery("from AuditoriaDados a WHERE operation = '" + criteria + "' ORDER BY operation");
            lista = q.list();           //sempre o nome da entidade e o campo(atributo) que tem na entidade, não do banco
            return lista;
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }

    public List<AuditoriaDados> findAllByUser(String criteria) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<AuditoriaDados> lista = null;
        try {
            org.hibernate.Query q = sessao.createQuery("from AuditoriaDados a WHERE userid = " + criteria + " ORDER BY userid");
            lista = q.list();           //sempre o nome da entidade e o campo(atributo) que tem na entidade, não do banco
            return lista;
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }

}
