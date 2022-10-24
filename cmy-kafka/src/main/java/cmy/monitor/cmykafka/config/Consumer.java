package cmy.monitor.cmykafka.config;

import cmy.monitor.cmykafka.entity.db.User;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

/**
 * @BelongsProject: cmy-monitor
 * @BelongsPackage: cmy.monitor.cmykafka.config
 * @Author: 蔡明勇
 * @CreateTime: 2022-09-14  17:29
 * @Description: kafka消费者
 * @Version: 1.0
 */
@Configuration
@Slf4j
public class Consumer {

    @KafkaListener(topics = "cmy-monitor")
    public void consume(String message){
        log.info("消费者接收到消息"+message);
        User user = JSON.parseObject(message, User.class);
    }
}
