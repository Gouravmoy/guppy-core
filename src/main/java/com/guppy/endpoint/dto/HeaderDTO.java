package com.guppy.endpoint.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HeaderDTO {
	private String name;
    private String value;
}
