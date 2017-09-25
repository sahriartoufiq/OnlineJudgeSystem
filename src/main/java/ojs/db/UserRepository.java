package ojs.db;

import ojs.domain.db.Users;

/**
 * Created by toufiq on 12/12/16.
 */
public interface UserRepository {

    Users findByUserName(String username);
    void save(Users users);

}
