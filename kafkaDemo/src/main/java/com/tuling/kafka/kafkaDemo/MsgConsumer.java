package com.tuling.kafka.kafkaDemo;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

public class MsgConsumer {
	public static void main(String[] args) {
		Properties props = new Properties();
		props.put("bootstrap.servers", "47.107.171.101:8000,47.107.171.101:8001,47.107.171.101:8002");
		// 消费分组名
		props.put("group.id", "testGroup1");
		// 是否自动提交offset
		props.put("enable.auto.commit", "true");
		// 自动提交offset的间隔时间
		props.put("auto.commit.interval.ms", "1000");
//		props.put("enable.auto.commit", "false");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		KafkaConsumer<String, String> consumer = new KafkaConsumer(props);
		// 消费主题
		consumer.subscribe(Arrays.asList("test1"));
		// 消费指定分区
		//consumer.assign(Arrays.asList(new TopicPartition("topic-replica-zhuge2", 0)));
		while (true) {
			/*
			 * poll() API 是拉取消息的长轮询，主要是判断consumer是否还活着，只要我们持续调用poll()，消费者就会存活在自己所在的group中，
			 * 并且持续的消费指定partition的消息。底层是这么做的：消费者向server持续发送心跳，如果一个时间段（session.
			 * timeout.ms）consumer挂掉或是不能发送心跳，这个消费者会被认为是挂掉了，
			 * 这个Partition也会被重新分配给其他consumer
			 */
			ConsumerRecords<String, String> records = consumer.poll(1000);
			for (ConsumerRecord<String, String> record : records) {
				System.out.printf("***************************************************offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
			}
			
			if (records.count() > 0) { 
				// 提交offset 
//				consumer.commitSync();
			}
			 
		}
	}
}
