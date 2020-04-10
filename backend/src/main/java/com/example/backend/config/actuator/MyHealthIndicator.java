package com.example.backend.config.actuator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * @author gimi
 */
@Component
@Slf4j
public class MyHealthIndicator implements HealthIndicator {
    /**
     *
     * @return 自定义Health监控
     */
    @Override
    public Health health() {
 
        // 健康检查的逻辑
        log.info("start 自定义Health监控");
        // 检查通过（方式一新建对象）
//        return new Health.Builder().withDetail("usercount", 10) //自定义监控内容
//                .withDetail("userstatus", "up").up().build();
 
        // 检查失败（方式二静态方法）
        return Health.down().withDetail("status", "errorCode")
                .withDetail("message", "服务故障").build();
    }
}