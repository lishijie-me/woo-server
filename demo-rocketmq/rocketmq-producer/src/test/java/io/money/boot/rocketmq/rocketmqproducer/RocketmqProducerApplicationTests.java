package io.money.boot.rocketmq.rocketmqproducer;

import io.money.boot.rocketmq.producer.MyProducer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RocketmqProducerApplicationTests {

    @Autowired
    private MyProducer producer;

    @Test
    void contextLoads() {
    }

    @Test
    void send() {
        String topic = "my-money-topic";
        String msg = "hello rocketmq message";
        producer.sendMessage(topic, msg);
        System.out.println("消息发送成功！");

    }
}
