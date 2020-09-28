/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidade.Produto;
import Utils.Formatacao;
import Utils.HibernateUtil;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author evand
 */
public class ProdutoDAO extends Dao<Produto> {

    public Produto findById(int id) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transacao = sessao.beginTransaction();
            Produto retorno = (Produto) sessao.get(Produto.class, id);
            return retorno;
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }

    public List<Produto> findAllByDescription(String criteria) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Produto> produtos = null;
        try {
            org.hibernate.Query q = sessao.createQuery("from Produto p WHERE ds_produto LIKE '%" + criteria + "%' AND ie_situacao = 'A' ORDER BY id_produto");
            produtos = q.list();
            return produtos;
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }

    public List<Produto> findAll() {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Produto> produtos = null;
        try {
            org.hibernate.Query q = sessao.createQuery("from Produto p WHERE ie_situacao = 'A' ORDER BY id_produto");
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
