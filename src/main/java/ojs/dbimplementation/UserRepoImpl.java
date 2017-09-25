package ojs.dbimplementation;

import ojs.db.UserRepository;
import ojs.domain.db.UserRoles;
import ojs.domain.db.Users;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by toufiq on 12/12/16.
 */
@Repository
public class UserRepoImpl implements UserRepository {
    private static final Logger log = Logger.getLogger(UserRepoImpl.class);


    SessionFactory sessionFactory;

    @Autowired
    public UserRepoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Users findByUserName(String username) {
        log.debug("................................................" + username);
        //  boolean k = true;
        Session session = this.sessionFactory.openSession();
        List<Users> usersList = new ArrayList<Users>();


        //    String hql = "FROM Users E WHERE E.userName = :name";
        //  Query query = session.createQuery(hql);
        //query.setParameter("name",username);
        //usersList= query.list();
        // usersList = session.createQuery("from Users where userName=?").setParameter(0, username).list();
        Users users = null;
        usersList = session.createQuery("FROM Users ").list();
        for (Users u : usersList) {
            log.debug("usersName " + u.getUserName());
            if (u.getUserName().equals(username)) {
                users = u;
                break;
            }
        }
        //  Users users= (Users) usersList.get(0);
        log.debug("....................." + users.getUserName() + "..." + users.getPassword());
        // session.close();
        return users;
    }

    @Override
    public void save(Users users) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        // int id= (int) session.save(users);
        Set<UserRoles> s = new HashSet<UserRoles>();
        UserRoles roles = new UserRoles();
        roles.setUserRoles("user");
        roles.setUsers(users);
        s.add(roles);
        users.setUserRolesSet(s);
        session.save(users);
        tx.commit();
        session.close();
    }
}
