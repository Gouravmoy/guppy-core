package com.guppy.endpoint;

import com.guppy.endpoint.dto.EndpointDTO;

public interface EndpointService {
	
	String createEndpoint(EndpointDTO endpointDTO);
	
	EndpointDTO getEndpointById(Long id);

    String updateEndpoint(Long id, EndpointDTO updatedEndpointDTO);

    String deleteEndpoint(Long id);

}
