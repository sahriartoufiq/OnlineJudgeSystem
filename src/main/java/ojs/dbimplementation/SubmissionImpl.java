package ojs.dbimplementation;

import ojs.db.Submission;
import ojs.domain.db.Submissions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubmissionImpl implements Submission {

    @Autowired
    SessionFactory sessionFactory;

    public SubmissionImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public int save(Submissions submissions) {

        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        int id = (int) session.save(submissions);

        tx.commit();
        session.close();

        return id;

    }

    @Override
    public void update(Submissions submission) {

        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(submission);

        tx.commit();
        session.close();

    }

    @Override
    public List<Submissions> getSubmissions() {

        Session session = this.sessionFactory.openSession();

        return session.createQuery("FROM Submissions ").list();
    }

}
