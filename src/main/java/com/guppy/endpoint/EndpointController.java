package com.guppy.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guppy.endpoint.dto.EndpointDTO;

@RestController
@RequestMapping("endpoints")
public class EndpointController {
	@Autowired
	private EndpointServiceImpl endpointService;

	@PostMapping
	public ResponseEntity<String> createEndpoint(@RequestBody EndpointDTO endpointDTO) {
		String endpointId = endpointService.createEndpoint(endpointDTO);
		return ResponseEntity.ok("Endpoint created with ID: " + endpointId);
	}

	@GetMapping("/{id}")
	public ResponseEntity<EndpointDTO> getEndpoint(@PathVariable Long id) {
		EndpointDTO endpointDTO = endpointService.getEndpointById(id);
		return ResponseEntity.ok(endpointDTO);
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updateEndpoint(@PathVariable Long id, @RequestBody EndpointDTO updatedEndpointDTO) {
		String result = endpointService.updateEndpoint(id, updatedEndpointDTO);
		return ResponseEntity.ok(result);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEndpoint(@PathVariable Long id) {
		String result = endpointService.deleteEndpoint(id);
		return ResponseEntity.ok(result);
	}
}
