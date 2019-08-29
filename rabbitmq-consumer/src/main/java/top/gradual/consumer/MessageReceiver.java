package top.gradual.consumer;

import java.util.Map;

import com.rabbitmq.client.Channel;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import top.gradual.domain.Message;

/**
 * @Description: 信息接收
 * @Author: gradual
 * @Date: 2019-08-29 17:42
 */
@Slf4j
@Component
public class MessageReceiver {

    @RabbitListener(
            bindings = @QueueBinding(
                    //监听的队列
                    value = @Queue(value = "message-queue", durable = "true"),
                    //监听的exchange
                    exchange = @Exchange(name = "rabbitmq-demo-exchange", durable = "true", type = "topic"),
                    //监听的Routing Key
                    key = "rabbitmq-demo-message"
            )
    )
    //指定该方法处理消息
    @RabbitHandler
    public void receiverMessage(@Payload Message message,   //消息内容对象
                                @Headers Map<String, Object> headers, //头
                                Channel channel) throws Exception {
        //消费者操作
        log.info("收到消息: {}", message);

        //手动签收调用ACK回送
        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        channel.basicAck(deliveryTag, false);
    }
}
