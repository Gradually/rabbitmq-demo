package top.gradual;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description: 消息发送器
 * @Author: gradual
 * @Date: 2019-08-29 17:01
 */
@Component
public class MessageSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;


}
