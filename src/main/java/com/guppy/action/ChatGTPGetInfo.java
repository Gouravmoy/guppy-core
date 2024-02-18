package com.guppy.action;

import lombok.Data;

@Data
public class ChatGTPGetInfo implements Action {

	private String endpointUrl;
	private String topicName;
	private String response;
	public ChatGTPGetInfo(String endPointUrl,String topicName){
		this.endpointUrl = endPointUrl;
		this.topicName = topicName;
	}
	

	@Override
	public void execute() {
		System.out.println("------- Executing - " + getName());

		System.out.println("endpointUrl - " + endpointUrl);
		System.out.println("Topic name - " + topicName);

		response = GTPAnswer.answerToTopicQuery();

		System.out.println("Output from GTP Topic Search - " + response);
	}

	@Override
	public String getName() {
		return "endpt-call-chatgtp-topic";
	}


	@Override
	public String getOutput() {
		return response;
	}
}
