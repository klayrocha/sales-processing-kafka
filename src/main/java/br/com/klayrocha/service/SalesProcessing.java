package br.com.klayrocha.service;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;
import java.util.Random;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import br.com.klayrocha.deserializer.SaleDeserializer;
import br.com.klayrocha.model.Sale;

public class SalesProcessing {

	public static void main(String[] args) {
		Properties properties = new Properties();
		properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, SaleDeserializer.class.getName());
		properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.put(ConsumerConfig.GROUP_ID_CONFIG, "processing-group");
		properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		properties.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, "10");

		try (KafkaConsumer<String, Sale> consumer = new KafkaConsumer<String, Sale>(properties)) {
			consumer.subscribe(Arrays.asList("sell-tickets"));
			while (true) {
				ConsumerRecords<String, Sale> sales = consumer.poll(Duration.ofMillis(200));
				sales.forEach((cr) -> {
					Sale sale = cr.value();
					if (new Random().nextBoolean()) {
						sale.setStatus("Approved");
					} else {
						sale.setStatus("Disapproved");
					}
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(sale);
				});
			}
		}
	}
}
