package top.gradual;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.gradual.domain.Message;
import top.gradual.producer.MessageSender;

/**
 * @Description:
 * @Author: gradual
 * @Date: 2019-08-29 17:16
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProducerApplicationTest {

    @Autowired
    private MessageSender messageSender;


    @Test
    public void testSend() {
        Message message = new Message();
        message.setId(1L);
        message.setMessage("测试消息1");
        try {
            messageSender.sendMessage(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
