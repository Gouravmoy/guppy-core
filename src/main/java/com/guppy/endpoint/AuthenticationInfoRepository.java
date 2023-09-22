package com.guppy.endpoint;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guppy.endpoint.entity.AuthenticationInfo;

public interface AuthenticationInfoRepository extends JpaRepository<AuthenticationInfo, Long> {

}
