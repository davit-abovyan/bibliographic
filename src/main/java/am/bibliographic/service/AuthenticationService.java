package am.bibliographic.service;

import java.util.Arrays;

import am.bibliographic.dao.impl.UserInfoImpl;
import am.bibliographic.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements UserDetailsService {
    @Autowired
    private UserService user;
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        UserEntity userInfo = user.get(username);
        GrantedAuthority authority = new SimpleGrantedAuthority(userInfo.getRole());
        UserDetails userDetails = (UserDetails)new User(userInfo.getUsername(),
                userInfo.getPassword(), Arrays.asList(authority));
        return userDetails;
    }
}