package cmy.monitor.cmyflink.functions;

import org.apache.flink.api.common.functions.FilterFunction;

/**
 * @BelongsProject: cmy-monitor
 * @BelongsPackage: cmy.monitor.cmyflink.functions
 * @Author: 蔡明勇
 * @CreateTime: 2022-10-21  17:13
 * @Description: CmyFilterFunction
 * @Version: 1.0
 */
public class CmyFilterFunction implements FilterFunction<String> {
    @Override
    public boolean filter(String s) throws Exception {

        return true;
    }
}
