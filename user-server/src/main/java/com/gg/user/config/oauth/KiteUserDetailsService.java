package com.gg.user.config.oauth;

import com.gg.user.entity.UserInfo;
import com.gg.user.service.AuthUserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.JdkSerializationStrategy;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStoreSerializationStrategy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * KiteUserDetailsService
 *
 * @author fengzheng 古时的风筝
 * @date 2019/3/30
 */
@Slf4j
@Component(value = "kiteUserDetailsService")
public class KiteUserDetailsService implements UserDetailsService {


    @Autowired
    private PasswordEncoder passwordEncoder;

    private RedisTokenStoreSerializationStrategy serializationStrategy = new JdkSerializationStrategy();

    @Autowired
    private TokenStore redisTokenStore;

    @Autowired
    private AuthUserInfoService userInfoService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("当前用户{} 尝试登录:" + username);
        UserInfo userInfo = userInfoService.getUserInfoByName(username);
        if ( userInfo == null){
            throw new UsernameNotFoundException("该用户不存在");
        }
        // 默认给ADMIN 此处不做权限管理
        String role = "ROLE_ADMIN";
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role));
        User user = new User(username,userInfo.getPassword(),authorities);
        return user;
    }
}
