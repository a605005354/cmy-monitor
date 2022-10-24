package cmy.monitor.cmyflink.functions;

import cmy.monitor.cmyflink.entity.UserActivity;
import org.apache.flink.api.common.functions.MapFunction;

/**
 * @BelongsProject: cmy-monitor
 * @BelongsPackage: cmy.monitor.cmyflink.functions
 * @Author: 蔡明勇
 * @CreateTime: 2022-10-24  10:33
 * @Description: CmyMapFunction
 * @Version: 1.0
 */
public class CmyMapFunction implements MapFunction<String, UserActivity>{
    @Override
    public UserActivity map(String s) throws Exception {
        UserActivity userActivity = new UserActivity();
        userActivity.setMessage(s);
        userActivity.setCount(1);
        return userActivity;
    }
}
