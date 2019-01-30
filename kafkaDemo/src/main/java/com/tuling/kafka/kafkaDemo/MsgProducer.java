package com.tuling.kafka.kafkaDemo;

import org.apache.kafka.clients.producer.*;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class MsgProducer {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//***************************参数设置方式1*************************************
		Properties props = new Properties();
		props.put("bootstrap.servers", "47.107.171.101:8000");
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		//1. acks=0   只发数据，不等确认信息
		//2. acks=1   意味着首领在疏导消息并把它写到分区数据问津是会返回确认或者错误响应，还是可能会丢数据
		//3. acks=all 意味着首领在返回确认或错误响应之前，会等待所有同步副本都收到消息。如果和min.insync.replicas参数结合起来，
		// 就可以决定在返回确认前至少有多个副本能够收到消息。但是效率较低。可以通过一部模式和更大的批次来加快速度，但这样做会降低吞吐量。
		//4. 从0到all：性能依次降低，安全性依次增加
		props.put("acks", "all");
		props.put("delivery.timeout.ms", 30000);
		//缓冲区大小，越大表示批量提交的数量越大，但是会消耗更多的内存
		props.put("batch.size", 16384);
		//生产者发送失败后重试次数，默认0 不重试
		props.put("retries",3);
		//我们将逗留时间设置为1毫秒，因此可能会在单个请求中发送所有100条记录。
		// 但是，如果我们没有填满缓冲区，此设置将为我们的请求添加1毫秒的延迟，等待更多记录到达。
		// 请注意，即使在linger.ms = 0的情况下，及时到达的记录通常也会一起批处理，因此在重负载下，
		// 无论延迟配置如何，都会发生批处理;但是，将此设置为大于0的值可以在不受最大负载影响的情况下以较少的延迟为代价导致更少，更有效的请求。
		props.put("linger.ms", 1);
		//buffer.memory控制生产者可用于缓冲的总内存量。如果记录的发送速度快于传输到服务器的速度，则此缓冲区空间将耗尽。
		// 当缓冲区空间耗尽时，其他发送调用将被阻止。阻塞时间的阈值由max.block.ms确定，之后它会抛出TimeoutException。
		props.put("buffer.memory", 33554432);

		//***************************参数设置方式2*************************************
		Properties props1 = new Properties() {{
			put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "47.107.171.101:8000,47.107.171.101:8001,47.107.171.101:8002");
			put(ProducerConfig.ACKS_CONFIG, "all");
			put(ProducerConfig.RETRIES_CONFIG, 3);
			put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
			put(ProducerConfig.LINGER_MS_CONFIG, 1);
			put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432);
			put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
			put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
		}};

		Producer<String, String> producer = new KafkaProducer<String, String>(props1);
		for (int i = 0; i < 5; i++) {

			ProducerRecord<String, String> producerRecord = new ProducerRecord("test1","1111");

			//同步方式发送消息
			/*Future<RecordMetadata> result = producer.send(producerRecord);
			//等待消息发送成功的同步阻塞方法
			RecordMetadata metadata = result.get();
			System.out.println("同步方式发送消息结果：" + "topic-" + metadata.topic() + "|partition-"
			        + metadata.partition() + "|offset-" + metadata.offset());*/


			//异步方式发送消息，回调方法，失败后可以设置重新发送等等操作
			producer.send(producerRecord, new Callback() {
				@Override
				public void onCompletion(RecordMetadata metadata, Exception exception) {
					if (exception != null) {
						System.err.println("发送消息失败：" + exception.getStackTrace());

					}
					if (metadata != null) {
						System.out.println("异步方式发送消息结果：" + "topic-" + metadata.topic() + "|partition-"
						        + metadata.partition() + "|offset-" + metadata.offset());
					}
				}
			});

			
			//送积分
			//fdfddfdasf
		}

		producer.close();
	}
}
