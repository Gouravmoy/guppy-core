package com.guppy.endpoint.dto;

import lombok.Data;

@Data
public class RetryPolicyDTO {
	private Integer maxRetries;
    private Integer backoffIntervalMs;
}
