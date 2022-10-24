package cmy.monitor.cmykafka.controller;

import cmy.monitor.cmykafka.entity.db.User;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @BelongsProject: cmy-monitor
 * @BelongsPackage: cmy.monitor.cmykafka.controller
 * @Author: 蔡明勇
 * @CreateTime: 2022-09-13  15:55
 * @Description: 生产者控制类
 * @Version: 1.0
 */
@RestController
@RequestMapping("/producer")
@Slf4j
public class ProducerController {

    @Resource
    KafkaTemplate<String,String> kafka;

    @PostMapping("/action")
    public String action(@RequestBody User user){
        String msg = JSON.toJSONString(user);
        log.info("生产者接收到用户操作:"+msg);
        kafka.send("cmy-monitor", msg);
        return "OK";
    }
}
