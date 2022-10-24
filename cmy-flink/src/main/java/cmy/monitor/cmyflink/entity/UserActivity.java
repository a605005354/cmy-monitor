package cmy.monitor.cmyflink.entity;

import lombok.Data;

/**
 * @BelongsProject: cmy-monitor
 * @BelongsPackage: cmy.monitor.cmyflink.entity
 * @Author: 蔡明勇
 * @CreateTime: 2022-10-24  09:55
 * @Description: UserActivity
 * @Version: 1.0
 */
@Data
public class UserActivity {

    private Long id;

    private String message;

    private Integer count;
}
