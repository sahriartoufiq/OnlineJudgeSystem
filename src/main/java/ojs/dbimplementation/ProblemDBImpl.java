package ojs.dbimplementation;

import ojs.db.ProblemsDB;
import ojs.domain.db.Problems;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by sahriar on 1/3/17.
 */
@Repository
public class ProblemDBImpl implements ProblemsDB {
    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    public ProblemDBImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public int save(Problems problems) {
        Session session = this.sessionFactory.openSession();
        //JOptionPane.showMessageDialog(null, "before");
        //JOptionPane.showMessageDialog(null, session.toString());
        Transaction tx = session.beginTransaction();
        int id = (int) session.save(problems);
        tx.commit();
        session.close();
        //session.close();
        return id;
    }
}
