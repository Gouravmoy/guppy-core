package com.guppy.endpoint.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RetryPolicyDTO {
	private Integer maxRetries;
    private Integer backoffIntervalMs;
}
