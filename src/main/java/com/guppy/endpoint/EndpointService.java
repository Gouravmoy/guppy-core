package com.guppy.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guppy.endpoint.dto.EndpointDTO;
import com.guppy.endpoint.entity.AuthenticationInfo;
import com.guppy.endpoint.entity.Endpoint;
import com.guppy.endpoint.entity.Metadata;
import com.guppy.endpoint.entity.Payload;
import com.guppy.endpoint.entity.RetryPolicy;
import com.guppy.endpoint.entity.SSLSecurityInfo;

@Service
public class EndpointService {

	@Autowired
	private EndpointRepository endpointRepository;

	@Autowired
	AuthenticationInfoRepository authenticationInfoRepository;

	public String createEndpoint(EndpointDTO endpointDTO) {
		if (endpointDTO.getUrl() == null || endpointDTO.getHttpMethod() == null) {
			throw new IllegalArgumentException("URL and HTTP method are required.");
		}
		Endpoint endpoint = new Endpoint(endpointDTO.getUrl(), endpointDTO.getHttpMethod());
		Payload payload = (endpointDTO.getPayload() != null) ? new Payload(endpointDTO.getPayload().getPayload())
				: null;
		AuthenticationInfo authenticationInfo = (endpointDTO.getAuthenticationInfo() != null)
				? new AuthenticationInfo(endpointDTO.getAuthenticationInfo().getAuthenticationInfo())
				: null;
		authenticationInfoRepository.save(authenticationInfo);
		RetryPolicy retryPolicy = (endpointDTO.getRetryPolicy() != null) ? new RetryPolicy(
				endpointDTO.getRetryPolicy().getMaxRetries(), endpointDTO.getRetryPolicy().getBackoffIntervalMs())
				: null;
		SSLSecurityInfo sslSecurityInfo = (endpointDTO.getSslSecurityInfo() != null) ? new SSLSecurityInfo(
				endpointDTO.getSslSecurityInfo().getSslEnabled(), endpointDTO.getSslSecurityInfo().getTlsVersion())
				: null;
		Metadata metadata = (endpointDTO.getMetadata() != null) ? new Metadata(endpointDTO.getMetadata().getMetadata())
				: null;

		endpoint.setPayload(payload);
		endpoint.setAuthenticationInfo(authenticationInfo);
		endpoint.setRetryPolicy(retryPolicy);
		endpoint.setSslSecurityInfo(sslSecurityInfo);
		endpoint.setMetadata(metadata);

		endpointRepository.save(endpoint);

		return String.valueOf(endpoint.getId());
	}
}
