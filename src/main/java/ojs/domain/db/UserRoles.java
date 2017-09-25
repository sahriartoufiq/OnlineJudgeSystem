package ojs.domain.db;

import javax.persistence.*;

/**
 * Created by sahriar on 12/4/16.
 */
@Entity
@Table(name = "t_user_roles")
public class UserRoles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
  //  @ManyToOne(fetch = FetchType.EAGER)
  //  @JoinColumn(name = "user_name", nullable = false)

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "users_id")
    private Users users;
    @Column(name = "user_roles")
    private String userRoles;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public String getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(String userRoles) {
        this.userRoles = userRoles;
    }
}