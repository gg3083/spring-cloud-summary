//package com.gg.backend.config.db;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.serializer.RedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//import java.nio.charset.Charset;
//import java.util.HashMap;
//import java.util.Set;
//
///**
// * @author Gjing
// **/
//@Component
//public class RedisClientString {
//    @Resource
//    private StringRedisTemplate stringRedisTemplate;
//
//    /**
//     * 获取值,key不存在返回null
//     *
//     * get(Object key)
//     */
//    public String get(String key) {
//        RedisSerializer<String> stringSerializer = new StringRedisSerializer(Charset.forName("GBK"));
//        stringRedisTemplate.setKeySerializer(stringSerializer);
//        stringRedisTemplate.setValueSerializer(stringSerializer);
//        stringRedisTemplate.setHashKeySerializer(stringSerializer);
//        stringRedisTemplate.setHashValueSerializer(stringSerializer);
//        return stringRedisTemplate.opsForValue().get(key);
//    }
//
//
//    public HashMap<String,Object> list() {
//        Set<String> set = stringRedisTemplate.keys("*");
//        HashMap<String,Object> map = new HashMap<>();
//        set.forEach(s -> map.put(s,get(s)));
//        return map;
//    }
//
//}
//
