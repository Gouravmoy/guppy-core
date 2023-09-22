package com.guppy.http.entity;

import java.util.Map;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Request {
	String URL;
	HTTPRequestType requestType;
	Object requestBody;
	Map<Object, Object> queryParam;
}