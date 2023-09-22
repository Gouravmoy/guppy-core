package com.guppy.endpoint.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "AuthenticationInfo")
@Data
public class AuthenticationInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "authentication_info", nullable = false, columnDefinition = "TEXT")
	String authentication_info;
	
	public AuthenticationInfo(String authenticationInfo) {
		this.authentication_info = authenticationInfo;
	}

}
