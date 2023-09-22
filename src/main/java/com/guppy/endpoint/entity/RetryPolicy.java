package com.guppy.endpoint.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "RetryPolicy")
@Data
public class RetryPolicy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "max_retries", nullable = false)
	private Integer max_retries;

	@Column(name = "backoff_interval_ms", nullable = false)
	private Integer backoff_interval_ms;

	public RetryPolicy(Integer maxRetries, Integer backoffIntervalMs) {
		this.backoff_interval_ms = backoffIntervalMs;
		this.max_retries = maxRetries;
	}

}
