/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidade.Entidade;
import Utils.HibernateUtil;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;
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

    public HashMap<String, BigInteger> findNumberByCities() {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        HashMap<String, BigInteger> map = new HashMap<>();
        try {
            Iterator results = sessao.createSQLQuery(
                    " select c.ds_cidade as cidade, count(*) as qntd\n"
                    + " from entidade e inner join cidade c\n"
                    + " on e.id_cidade = c.id_cidade\n"
                    + " GROUP BY c.ds_cidade")
                    .list()
                    .iterator();

            while (results.hasNext()) {
                Object[] row = (Object[]) results.next(); // pego a linha inteira
                map.put(String.valueOf(row[0]), (BigInteger) row[1]);
            }
            return map;

        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }

}