package io.money.boot.rocketmq.producer;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author lishijie-me
 * @date 2025/4/24 星期四 22:05:37
 * @description MyProducer
 */
@Component
public class MyProducer {
    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    public void sendMessage(String topic, String msg) {
        rocketMQTemplate.convertAndSend(topic, msg);
    }
}
