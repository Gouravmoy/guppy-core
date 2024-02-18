package com.guppy.endpoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guppy.endpoint.entity.AuthenticationInfo;
import com.guppy.endpoint.entity.Endpoint;

public interface EndpointRepository extends JpaRepository<Endpoint, Long> {

}
