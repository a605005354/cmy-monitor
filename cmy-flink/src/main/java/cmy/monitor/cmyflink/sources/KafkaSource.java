package cmy.monitor.cmyflink.sources;

import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.source.RichSourceFunction;

/**
 * @BelongsProject: cmy-monitor
 * @BelongsPackage: cmy.monitor.cmyflink.sources
 * @Author: 蔡明勇
 * @CreateTime: 2022-09-22  16:21
 * @Description: Kafka源
 * @Version: 1.0
 */
public class KafkaSource extends RichSourceFunction<String> {

    @Override
    public void open(Configuration parameters){

    }

    @Override
    public void run(SourceContext<String> sourceContext) throws Exception {

    }

    @Override
    public void cancel() {

    }
}
