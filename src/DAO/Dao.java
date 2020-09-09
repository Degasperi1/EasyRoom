/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author evand
 */
public class Dao<T> {

    final static Logger logger = Logger.getLogger(Dao.class);

    //1 - Criar um objeto de retorno com o int e a mensagem de erro
    //2 - retornar um array de string contendo ambos
    public Integer save(T object) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Integer cod = null;
        try {
            Transaction transacao = sessao.beginTransaction();
            cod = (Integer) sessao.save(object);
            transacao.commit();
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
            Dao.logger.error("Erro no registro: " + hibEx.toString());
            //Dao.logger.warn("Erro no registro: " + hibEx.toString());
        } finally {
            sessao.close();
        }
        return cod;
    }

    //session update não precisa retornar o int pois já está sendo enviado o objeto com ele, atualizado!
    public String update(T object) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        String retorno = null;
        try {
            Transaction transacao = sessao.beginTransaction();
            sessao.update(object);
            transacao.commit();
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
            retorno = hibEx.toString();
            Dao.logger.error("Erro na atualização: " + hibEx.toString());
        } finally {
            sessao.close();
        }
        return retorno;
    }
}
