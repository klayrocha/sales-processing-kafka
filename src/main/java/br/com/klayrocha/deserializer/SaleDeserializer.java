package br.com.klayrocha.deserializer;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.klayrocha.model.Sale;

public class SaleDeserializer implements Deserializer<Sale> {

	@Override
	public Sale deserialize(String topic, byte[] sale) {
		try {
			return new ObjectMapper().readValue(sale, Sale.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
