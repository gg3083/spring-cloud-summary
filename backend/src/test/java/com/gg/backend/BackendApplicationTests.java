package com.gg.backend;

import com.alibaba.fastjson.JSONObject;
import com.gg.backend.controller.UserController;
import com.gg.backend.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@AutoConfigureMockMvc
class BackendApplicationTests {


    @Autowired
    private MockMvc mockMvc;

    @Test
    public void userList(){
//        List<User> users = userMapper.selectAll();
//        users.forEach(System.out::println);
        List<User> dataList = new ArrayList<>();

    }

    public @Test void mockTest() throws Exception {

        /*
         * 1、mockMvc.perform执行一个请求。
         * 2、MockMvcRequestBuilders.get("XXX")构造一个请求。
         * 3、ResultActions.param添加请求传值
         * 4、ResultActions.accept(MediaType.TEXT_HTML_VALUE))设置返回类型
         * 5、ResultActions.andExpect添加执行完成后的断言。
         * 6、ResultActions.andDo添加一个结果处理器，表示要对结果做点什么事情
         *   比如此处使用MockMvcResultHandlers.print()输出整个响应结果信息。
         * 7、ResultActions.andReturn表示执行完成后返回相应的结果。
         */
        mockMvc.perform(MockMvcRequestBuilders
                .post("/user")
                // 设置返回值类型为utf-8，否则默认为ISO-8859-1
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .param("userName", "user1")
                .param("password","pass1")
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("200"))
                .andDo(MockMvcResultHandlers.print());
    }

    public @Test void webClient(){
        String res = WebClient.create().get()
                .uri("http://localhost:8081/user")
                .retrieve()
                .bodyToMono(String.class)
                .block();
        System.err.println(res);
    }

    public @Test void webClient2(){
        WebClient client =  WebClient.create("http://localhost:8081");
        Mono<String> result1Mono = client .get()
                .uri("/db/mysql/list")
                .retrieve()
                .bodyToMono(String.class);
        Mono<String> result2Mono = client .get()
                .uri("/user")
                .retrieve()
                .bodyToMono(String.class);
        Map<String,String>  map = Mono.zip(result1Mono, result2Mono, (result1, result2) -> {
            Map<String, String> arrayList = new HashMap<>();
            arrayList.put("result1", result1);
            arrayList.put("result2", result2);
            return arrayList;
        }).block();
        System.err.println(JSONObject.toJSONString(map));
    }

    @Autowired
    UserController userController;

    public @Test void login(){
//        Object res = userController.login("admin","123456");
//        System.err.println(res);
    }
}
