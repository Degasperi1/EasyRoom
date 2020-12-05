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
public class ReservaQuartoDAO extends Dao<ReservaQuarto> {

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
    
    public boolean saveD(ReservaQuarto object) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Integer cod = null;
        Transaction transacao = null;
        try {
            transacao = sessao.beginTransaction();
            sessao.save(object);
            transacao.commit();
            return true;
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
            transacao.rollback();
            Dao.logger.error("Erro no registro: " + hibEx.toString());
            //Dao.logger.warn("Erro no registro: " + hibEx.toString());
        } finally {
            sessao.close();
        }
        return false;
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
