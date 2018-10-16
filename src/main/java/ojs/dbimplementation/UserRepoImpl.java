package ojs.dbimplementation;

import ojs.db.UserRepository;
import ojs.domain.db.UserRoles;
import ojs.domain.db.Users;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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

        Session session = this.sessionFactory.openSession();
        List<Users> usersList = new ArrayList<Users>();
        Users users = null;
        usersList = session.createQuery("FROM Users ").list();

        for (Users u : usersList) {

            if (u.getUserName().equals(username)) {

                users = u;
                break;

            }

        }

        return users;

    }

    @Override
    public void save(Users users) {

        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
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
