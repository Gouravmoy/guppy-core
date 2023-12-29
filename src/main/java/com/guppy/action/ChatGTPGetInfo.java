package com.guppy.action;

import lombok.Data;

@Data
public class ChatGTPGetInfo implements Action {

	private String endpointUrl;
	private String topicName;
	private String content;
	public ChatGTPGetInfo(String endPointUrl,String topicName){
		this.endpointUrl = endPointUrl;
		this.topicName = topicName;
	}
	

	@Override
	public void execute() {
		content = "Information fetched from ChatGTP about topic "+topicName;
		System.out.println(content);
	}

	@Override
	public String getName() {
		return "chat_gtp_get_info";
	}
}
