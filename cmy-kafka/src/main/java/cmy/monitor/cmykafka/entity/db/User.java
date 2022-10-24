package cmy.monitor.cmykafka.entity.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @BelongsProject: cmy-monitor
 * @BelongsPackage: cmy.monitor.cmykafka.entity.db
 * @Author: 蔡明勇
 * @CreateTime: 2022-09-13  15:57
 * @Description: 用户类
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private String id;

    private String name;

    //用户的操作，1.添加 2.删除
    private Integer operation;
}
