package com.guppy.endpoint.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SSLSecurityInfoDTO {
	private Boolean sslEnabled;
	private String tlsVersion;
}
