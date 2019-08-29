package top.gradual.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.gradual.domain.Message;

/**
 * @Description: 消息发送器
 * @Author: gradual
 * @Date: 2019-08-29 17:01
 */
@Slf4j
@Component
public class MessageSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(Message message) throws Exception {
        log.info("发送信息: {}", message);
        rabbitTemplate.convertAndSend(
                "rabbitmq-demo-exchange",    //指定exchange
                 "rabbitmq-demo-message",   //指定 Routing Key
                message,
                new CorrelationData(message.getId().toString())
        );
    }
}
