package cmy.monitor.cmyflink;

import cmy.monitor.cmyflink.sources.KafkaSource;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.util.Properties;

/**
 * @BelongsProject: cmy-monitor
 * @BelongsPackage: cmy.monitor.cmyflink
 * @Author: 蔡明勇
 * @CreateTime: 2022-09-27  16:26
 * @Description: Kafka消费者
 * @Version: 1.0
 */
public class KafkaConsumer {
//    public static void main(String[] args){
//        try {
//            StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
//            KafkaSource<String> source = KafkaSource.<String>builder()
//                    .setBootstrapServers(brokers)
//                    .setTopics("input-topic")
//                    .setGroupId("my-group")
//                    .setStartingOffsets(OffsetsInitializer.earliest())
//                    .setValueOnlyDeserializer(new SimpleStringSchema())
//                    .build();
//
//        }
//    }
}
