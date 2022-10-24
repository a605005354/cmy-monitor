package cmy.monitor.cmyflink;

import cmy.monitor.cmyflink.entity.UserActivity;
import cmy.monitor.cmyflink.functions.CmyFilterFunction;
import cmy.monitor.cmyflink.functions.CmyFlatMapFunction;
import cmy.monitor.cmyflink.functions.CmyMapFunction;
import cmy.monitor.cmyflink.sources.KafkaSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.flink.api.common.eventtime.BoundedOutOfOrdernessWatermarks;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.AssignerWithPeriodicWatermarks;
import org.apache.flink.streaming.api.windowing.assigners.TumblingProcessingTimeWindows;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.util.Collector;
import org.springframework.stereotype.Component;

import java.time.Duration;

/**
 * @BelongsProject: cmy-monitor
 * @BelongsPackage: cmy.monitor.cmymonitor
 * @Author: 蔡明勇
 * @CreateTime: 2022-09-08  15:45
 * @Description: WordCountJob
 * @Version: 1.0
 */
@Component
@Slf4j
public class WordCountJob {
    public static void main(String[] args) throws Exception{
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

//        DataStream<Tuple2<String, Integer>> dataStream = env
//                .socketTextStream("localhost", 9999)
//                .filter(new CmyFilterFunction())
//                .map(new CmyMapFunction())
//                .keyBy(key -> key.getMessage())
//                .flatMap(new CmyFlatMapFunction())
//                .window(TumblingProcessingTimeWindows.of(Time.seconds(5)))
//                .sum(1);

        DataStream<UserActivity> dataStream = env
                .socketTextStream("localhost", 9999)
                .filter(new CmyFilterFunction())
                .map(new CmyMapFunction())
                .keyBy(key -> key.getMessage());
//                .flatMap(new CmyFlatMapFunction())
//                .window(TumblingProcessingTimeWindows.of(Time.seconds(5)))
//                .sum(1);

        dataStream.print();
        env.execute("WordCountJob");
    }

    public static class Splitter implements FlatMapFunction<String, Tuple2<String, Integer>> {
        @Override
        public void flatMap(String sentence, Collector<Tuple2<String, Integer>> out) throws Exception {
            for (String word: sentence.split(" ")) {
                out.collect(new Tuple2<String, Integer>(word, 1));
            }
        }
    }
}
