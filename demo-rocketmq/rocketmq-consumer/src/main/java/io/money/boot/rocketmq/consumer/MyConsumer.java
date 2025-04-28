package io.money.boot.rocketmq.consumer;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @author lishijie-me
 * {@code @date} 2025/4/24 星期四 22:24:34
 * {@code @description} MyConsumer
 */
@Component
@RocketMQMessageListener(consumerGroup = "my-consumer-group", topic = "my-money-topic")
public class MyConsumer implements RocketMQListener<String> {
    @Override
    public void onMessage(String message) {
        System.out.println("收到的消息："+message);
    }
}
