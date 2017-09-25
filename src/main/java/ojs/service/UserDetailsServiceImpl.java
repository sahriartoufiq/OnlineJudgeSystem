package ojs.service;

import ojs.db.UserRepository;
import ojs.domain.db.UserRoles;
import ojs.domain.db.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by toufiq on 12/12/16.
 */
@Service("ojsuserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users users = userRepository.findByUserName(username);
        Set<GrantedAuthority> authoritySet = builduserAuthority(users.getUserRolesSet());


        return buildUserForAuthentication(users, authoritySet);
    }

    public Set<GrantedAuthority> builduserAuthority(Set<UserRoles> userRoles) {
        Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();
        for (UserRoles userRole : userRoles) {
            authSet.add(new SimpleGrantedAuthority(userRole.getUserRoles()));
        }
        return authSet;
    }

    public UserDetails buildUserForAuthentication(Users users, Set<GrantedAuthority> authorities) {
        return new User(users.getUserName(), users.getPassword(), authorities);
    }

}
