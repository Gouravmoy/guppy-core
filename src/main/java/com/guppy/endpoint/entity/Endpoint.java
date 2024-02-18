package com.guppy.endpoint.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "endpoint")
@Data
@NoArgsConstructor
public class Endpoint {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "url", nullable = false)
	String url;
	@Column(name = "http_method", nullable = false)
	String httpMethod;
	@Column(name = "headers")
	String headers;
	@Column(name = "timeout")
	int timeout;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "payload_id", referencedColumnName = "id")
	Payload payload;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "authentication_info_id", referencedColumnName = "id")
	AuthenticationInfo authenticationInfo;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "retry_policy_id", referencedColumnName = "id")
	RetryPolicy retryPolicy;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ssl_security_info_id", referencedColumnName = "id")
	SSLSecurityInfo sslSecurityInfo;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "metadata_id", referencedColumnName = "id")
	Metadata metadata;

	public Endpoint(String url, String httpMethod) {
		this.url = url;
		this.httpMethod = httpMethod;
	}

}
