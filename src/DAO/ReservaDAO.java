package DAO;

import Entidade.Reserva;
import Utils.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Degasperi
 */
public class ReservaDAO extends Dao<Reserva> {
    public Reserva findById(int id) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transacao = sessao.beginTransaction();
            Reserva retorno = (Reserva) sessao.get(Reserva.class, id);
            return retorno;
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }
    
    public List<Reserva> findAllByDescription(String criteria) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Reserva> reservas = null;
        try {
            org.hibernate.Query q = sessao.createQuery("from Reserva q WHERE id LIKE '%" + criteria + "%' ORDER BY id");
            reservas = q.list();
            return reservas;
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }

    public List<Reserva> findAll() {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Reserva> reservas = null;
        try {
            org.hibernate.Query q = sessao.createQuery("from Reserva q ORDER BY id");
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
