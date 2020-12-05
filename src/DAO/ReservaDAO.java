package DAO;

import Entidade.PessoaFisica;
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
            org.hibernate.Query q = sessao.createQuery("from Reserva q WHERE entidade LIKE '%" + criteria + "%' ORDER BY id");
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

    public List<Reserva> findAll(PessoaFisica p) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Reserva> reservas = null;
        try {
            org.hibernate.Query q = sessao.createQuery(""
                    + "FROM\n"
                    + "	pessoa_fisica a,\n"
                    + "	reserva b, \n"
                    + "	reserva_quarto c,\n"
                    + "	quarto d,\n"
                    + "	tipo_quarto e,\n"
                    + "	entidade f\n"
                    + "WHERE\n"
                    + "	a.id_entidade = b.id_entidade\n"
                    + "	AND a.id_entidade = f.id_entidade\n"
                    + "	AND b.id_reserva = c.id_reserva\n"
                    + "	AND c.id_quarto = d.id_quarto\n"
                    + "	AND d.id_tipo_quarto = e.id_tipo_quarto\n"
                    + "ORDER BY\n"
                    + "	1");
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
