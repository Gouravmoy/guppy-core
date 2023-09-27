package com.guppy.endpoint.dto;

import lombok.Data;

@Data
public class SSLSecurityInfoDTO {
	private Boolean sslEnabled;
	private String tlsVersion;
}
