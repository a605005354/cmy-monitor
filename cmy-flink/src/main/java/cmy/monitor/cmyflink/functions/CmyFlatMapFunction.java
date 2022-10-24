package cmy.monitor.cmyflink.functions;

import cmy.monitor.cmyflink.entity.UserActivity;
import org.apache.catalina.User;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.util.Collector;


/**
 * @BelongsProject: cmy-monitor
 * @BelongsPackage: cmy.monitor.cmyflink.functions
 * @Author: 蔡明勇
 * @CreateTime: 2022-10-24  09:43
 * @Description: CmyMapFunction
 * @Version: 1.0
 */
public class CmyFlatMapFunction implements FlatMapFunction<String, UserActivity> {

    @Override
    public void flatMap(String s, Collector<UserActivity> collector) throws Exception {
        for(String word: s.split(" ")){
            UserActivity userActivity = new UserActivity();
            userActivity.setMessage(word);
            userActivity.setCount(1);
            collector.collect(userActivity);
        }
    }
}
