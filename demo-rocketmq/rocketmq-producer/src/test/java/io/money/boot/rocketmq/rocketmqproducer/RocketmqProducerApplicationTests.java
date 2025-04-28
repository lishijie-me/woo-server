package io.money.boot.rocketmq.rocketmqproducer;

import io.money.boot.rocketmq.producer.MyProducer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RocketmqProducerApplicationTests {

    @Autowired
    private MyProducer producer;

    private final String topic = "my-money-topic";

    @Test
    void contextLoads() {
    }

    @Test
    void send() {
        String msg = "hello rocketmq message";
        producer.sendMessage(topic, msg);
        System.out.println("消息发送成功！");
    }

    /**
     * 同步发送消息
     * */
    @Test
    void sendSyncMessage() {
        String msg = "hello rocketmq synchronous message";
        producer.sendSyncMessage(topic, msg);
        System.out.println("消息发送成功！");
    }

    /**
     * 异步发送消息
     * */
    @Test
    void sendAsyncMessage() {
        String msg = "hello rocketmq asynchronous message";
        producer.sendAsyncMessage(topic, msg);
        System.out.println("消息发送成功！");
    }

    /**
     * 单向发送消息
     * */
    @Test
    void sendOneWayMessage() {
        String msg = "hello rocketmq one-way message";
        producer.sendOneWayMessage(topic, msg);
        System.out.println("消息发送成功！");
    }
}
