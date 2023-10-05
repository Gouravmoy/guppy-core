package com.guppy.endpoint.dto;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EndpointDTO {
	private Long id;
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
