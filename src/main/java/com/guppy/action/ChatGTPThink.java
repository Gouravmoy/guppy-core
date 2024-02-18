package com.guppy.action;

import lombok.Data;

@Data
public class ChatGTPThink implements Action {

	private String endpointUrl;
	private String actions;
	private String responseSchema;
	private String inputTask;
	private String response;

	public ChatGTPThink(String endPointUrl, String actions, String responseSchema, String inputTask) {
		this.endpointUrl = endPointUrl;
		this.actions = actions;
		this.responseSchema = responseSchema;
		this.inputTask = inputTask;
	}

	@Override
	public void execute() {
		System.out.println("------- Executing - " + getName());

		System.out.println("endpointUrl - " + endpointUrl);
		System.out.println("Actions - " + actions);
		System.out.println("responseSchema - " + responseSchema);
		System.out.println("inputTask - " + inputTask);

		response = GTPAnswer.answerToThink();

		System.out.println("Output from GTP Think - " + response);
	}

	@Override
	public String getName() {
		return "chat_gtp_think";
	}

	@Override
	public String getOutput() {
		return response;
	}

}
