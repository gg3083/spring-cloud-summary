package com.gg.user.oauth;

import com.gg.user.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;

@Slf4j
public class DomainUserDetailsService implements UserDetailsService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String password = "123456";
//        String password = passwordEncoder.encode("123456");
         User user =  User.builder()
                 .name(username)
                 .role("ROLE_ADMIN")
                 .password(password)
                 .token("token")
                 .build();
        log.info("当前用户 {} 需要登录",user.toString());
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return  new org.springframework.security.core.userdetails.User(user.getName(),user.getPassword(),authorities);
    }
}
