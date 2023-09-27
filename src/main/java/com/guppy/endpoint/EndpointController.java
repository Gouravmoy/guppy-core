package com.guppy.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.guppy.endpoint.dto.EndpointDTO;

@RestController
public class EndpointController {
	@Autowired
    private EndpointService endpointService;

    @PostMapping("/endpoints")
    public ResponseEntity<String> createEndpoint(@RequestBody EndpointDTO endpointDTO) {
        String endpointId = endpointService.createEndpoint(endpointDTO);
        return ResponseEntity.ok("Endpoint created with ID: " + endpointId);
    }
}
