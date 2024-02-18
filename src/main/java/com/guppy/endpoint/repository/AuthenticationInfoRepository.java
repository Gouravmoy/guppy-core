package com.guppy.endpoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guppy.endpoint.entity.AuthenticationInfo;

public interface AuthenticationInfoRepository extends JpaRepository<AuthenticationInfo, Long> {

}
