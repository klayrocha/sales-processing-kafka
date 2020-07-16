package br.com.klayrocha.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Sale implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long operation;
	private Long client;
	private Integer numberOfTickets;
	private BigDecimal amount;
	private String status;

	public Sale() {

	}

	public Sale(Long operation, Long client, Integer numberOfTickets, BigDecimal amount) {
		this.operation = operation;
		this.client = client;
		this.numberOfTickets = numberOfTickets;
		this.amount = amount;
	}

	public Long getOperation() {
		return operation;
	}

	public void setOperation(Long operation) {
		this.operation = operation;
	}

	public Long getClient() {
		return client;
	}

	public void setClient(Long client) {
		this.client = client;
	}

	public Integer getNumberOfTickets() {
		return numberOfTickets;
	}

	public void setNumberOfTickets(Integer numberOfTickets) {
		this.numberOfTickets = numberOfTickets;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((numberOfTickets == null) ? 0 : numberOfTickets.hashCode());
		result = prime * result + ((operation == null) ? 0 : operation.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sale other = (Sale) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (numberOfTickets == null) {
			if (other.numberOfTickets != null)
				return false;
		} else if (!numberOfTickets.equals(other.numberOfTickets))
			return false;
		if (operation == null) {
			if (other.operation != null)
				return false;
		} else if (!operation.equals(other.operation))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sale [operation=" + operation + ", client=" + client + ", numberOfTickets=" + numberOfTickets
				+ ", amount=" + amount + ", status=" + status + "]";
	}

}
