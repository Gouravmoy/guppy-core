package com.guppy.endpoint.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EndpointDTO {
	private String url;
	private String httpMethod;
	private List<HeaderDTO> headers;
	private PayloadDTO payload;
	private AuthenticationInfoDTO authenticationInfo;
	private Integer timeout;
	private RetryPolicyDTO retryPolicy;
	private SSLSecurityInfoDTO sslSecurityInfo;
	private MetadataDTO metadata;
}
