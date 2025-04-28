package io.money.boot.rocketmq.producer;

import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * @author lishijie-me
 * {@code @date} 2025/4/24 星期四 22:05:37
 * {@code @description} MyProducer
 */
@Component
public class MyProducer {
    private final RocketMQTemplate rocketMQTemplate;

    public MyProducer(RocketMQTemplate rocketMQTemplate) {
        this.rocketMQTemplate = rocketMQTemplate;
    }

    // 1.同步发送消息
    // 同步发送是指发送方发送一条消息后，会等待服务器返回确认信息后再进行后续操作。这种方式适用于需要可靠性保证的场景。
    public void sendMessage(String topic, String msg) {
        rocketMQTemplate.convertAndSend(topic, msg);
        System.out.printf("同步发送结果: %s\n", msg);
    }

    // 1.同步发送消息
    // 同步发送是指发送方发送一条消息后，会等待服务器返回确认信息后再进行后续操作。这种方式适用于需要可靠性保证的场景。
    public void sendSyncMessage(String topic, String message){
        SendResult sendResult = rocketMQTemplate.syncSend(topic, MessageBuilder.withPayload(message).build());
        System.out.println(sendResult.getMsgId());
        System.out.printf("同步发送结果: %s\n", message);
    }

    // 2.异步发送消息
    // 异步发送是指发送方发送消息后，不等待服务器返回确认信息，而是通过回调接口处理返回结果。这种方式适用于对响应时间要求较高的场景。
    public void sendAsyncMessage(String topic, String message){
        rocketMQTemplate.asyncSend(topic, MessageBuilder.withPayload(message).build(), new SendCallback() {

            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.printf("异步发送成功: %s\n", sendResult);
            }

            @Override
            public void onException(Throwable throwable) {
                System.out.printf("异步发送失败: %s\n", throwable.getMessage());
            }
        });
    }

    // 3.单向发送消息
    // 单向发送是指发送方只负责发送消息，不关心服务器的响应。该方式适用于对可靠性要求不高的场景，如日志收集。
    public void sendOneWayMessage(String topic, String message){
        rocketMQTemplate.sendOneWay(topic, MessageBuilder.withPayload(message).build());
        System.out.println("单向消息发送成功");
    }
}
