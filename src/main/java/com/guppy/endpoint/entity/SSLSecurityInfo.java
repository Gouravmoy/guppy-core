package com.guppy.endpoint.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ssl_security_info")
@Data
@NoArgsConstructor
public class SSLSecurityInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "ssl_enabled", nullable = false)
	private boolean ssl_enabled;

	@Column(name = "tls_version")
	private String tls_version;

	public SSLSecurityInfo(Boolean sslEnabled, String tlsVersion) {
		this.ssl_enabled = sslEnabled;
		this.tls_version = tlsVersion;
	}

}
