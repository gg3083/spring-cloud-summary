package com.example.user;

import com.example.user.model.DBProperties;
import com.example.user.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RestController
@Slf4j
//@EnableResourceServer
public class UserServerApplication implements ApplicationRunner {

    List<User> list = new ArrayList<>();

    @Override
    public void run(ApplicationArguments args) throws Exception {
        for (int i = 0; i < 10; i++) {
            list.add(
                    User.builder().name(i+"").password(i*100+"").build()
            );
        }
        list.forEach(System.out::println);
    }


    public static void main(String[] args) {
        SpringApplication.run(UserServerApplication.class, args);
    }



    @GetMapping("/user/list")
    public List<User> list(){
        return list;
    }

    @PostMapping("/user/login")
    public String login(String username, String password, HttpServletRequest request){
        if (StringUtils.isEmpty(username)){
            return "name不能为kong";
        }
       Optional<User> optionalUser = list.stream().filter(user -> username.equals(user.getName())).findFirst();
       if (optionalUser.isPresent()){
           if (optionalUser.get().getPassword().equals(password)) {
               return "200";
           }
       }
        return "error";
    }

    @GetMapping("/user/get")
    public User get(String name, HttpServletRequest request){
        log.info("name {}",name);
        if (StringUtils.isEmpty(name)){
            return User.builder().name("name empty").build();
        }
       Optional<User> optionalUser = list.stream().filter(user -> name.equals(user.getName())).findFirst();
       if (optionalUser.isPresent()){
           return optionalUser.get();
       }
        return User.builder().name("not found").build();
    }

    @GetMapping("form/token")
    public String tokenTest(){
        log.info("token");
        return "token";
    }

    @Autowired
    DBProperties dbProperties;

    @GetMapping("oauth/get")
    public Object test2(){
        return dbProperties.getDatasource();
    }


    @RequestMapping(value = "/current", method = RequestMethod.GET)
    public Principal getUser(Principal principal) {
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>");
        log.info(principal.toString());
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>");
        return principal;
    }

}
