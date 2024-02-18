package com.guppy.action;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class WFAction {
	
	@JsonProperty("action_id")
    private int action_id;

    @JsonProperty("action_name")
    private String action_name;


}
