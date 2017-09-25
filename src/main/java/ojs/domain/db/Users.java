package ojs.domain.db;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by sahriar on 12/5/16.
 */
@Entity
@Table(name = "t_users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;

    @Column(name = "user_name")
    @NotEmpty
    private String userName;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "active")
    private String active ;
    @Column(name = "score")
    private double score;
    @Column(name = "phone")
    private String phone;


    @OneToMany(mappedBy = "users",cascade =CascadeType.ALL)
    private Set<UserRoles> userRolesSet;
    @OneToMany(mappedBy = "users")
    private Set<Problems> problemsSet;

    @OneToMany(fetch=FetchType.LAZY,mappedBy = "users")
    private Set<Submissions> submissionsSet;


  //  @OneToMany(fetch=FetchType.EAGER,mappedBy="users")
//  @OneToMany(orphanRemoval=true)
//  @JoinColumn(name="USER_ID")
//    public Set<UserRoles> getUserRole() {
//        return userRole;
//    }


    public Set<UserRoles> getUserRolesSet() {
        return userRolesSet;
    }

    public void setUserRolesSet(Set<UserRoles> userRolesSet) {
        this.userRolesSet = userRolesSet;
    }

    public Set<Problems> getProblemsSet() {
        return problemsSet;
    }

    public void setProblemsSet(Set<Problems> problemsSet) {
        this.problemsSet = problemsSet;
    }

    public Set<Submissions> getSubmissionsSet() {
        return submissionsSet;
    }

    public void setSubmissionsSet(Set<Submissions> submissionsSet) {
        this.submissionsSet = submissionsSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}