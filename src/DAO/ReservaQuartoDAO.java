package DAO;

import Entidade.ReservaQuarto;
import Utils.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Degasperi
 */
public class ReservaQuartoDAO {
    public ReservaQuarto findById(int id) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transacao = sessao.beginTransaction();
            ReservaQuarto retorno = (ReservaQuarto) sessao.get(ReservaQuarto.class, id);
            return retorno;
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }
    
    public List<ReservaQuarto> findAllByDescription(String criteria) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<ReservaQuarto> reservas = null;
        try {
            org.hibernate.Query q = sessao.createQuery("from ReservaQuarto q WHERE id LIKE '%" + criteria + "%' ORDER BY id");
            reservas = q.list();
            return reservas;
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }

    public List<ReservaQuarto> findAll() {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<ReservaQuarto> reservas = null;
        try {
            org.hibernate.Query q = sessao.createQuery("from ReservaQuarto q ORDER BY id");
            reservas = q.list();
            return reservas;
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }
}
