package top.gradual.domain;

import java.io.Serializable;

import lombok.Data;

/**
 * @Description: 消息对象
 * @Author: gradual
 * @Date: 2019-08-29 17:04
 */
@Data
public class Message implements Serializable {

    private Long id;

    private String message;
}
