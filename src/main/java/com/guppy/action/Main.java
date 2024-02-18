package com.guppy.action;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ActionManager actionManager = new ActionManager();

		/**
		 * Initilize the action manage with all the tasks it is capable of doing
		 */
		
		String fileLoc = "C:\\Users\\GouravmoyMohanty\\Desktop\\Test\\Personal";

		TextFileGenerator fileGenerator = new TextFileGenerator(fileLoc, "fileName.txt");
		PresentationGenerator presentationGenerator = new PresentationGenerator(fileLoc, "fileName.ppt");
		ChatGTPGetInfo chatGTPGetInfo = new ChatGTPGetInfo("https://api.example.com", "Stephan Hawking");
		actionManager.registerAction(chatGTPGetInfo);
		actionManager.registerAction(fileGenerator);
		actionManager.registerAction(presentationGenerator);

		// This is the input work the user wants to do
		String input = "Create a text file about " + "Stephen Hawkins. Maximum characters 1000 words";

		/**
		 * Then we would want ask the AI to assess that this input can be handled by the
		 * tasks that is avaliable or not
		 * 
		 * For this, we need to let the AI know the below: 1. What tasks are avaliable
		 * 2. What is the json schema in which it should respond 3. The task
		 * 
		 * After this the AI will respond with an workflow. This workflow needs to be
		 * then parsed into a object. Then according to this object, we need to execute
		 * 
		 **/

		String tasksAvaliabe = "{\"actions\":[{\"action_name\":\"endpt-call-chatgtp-topic\",\"action_description\":\"This action is used to make a call to ChatGTP API to get information about any topic\"},{\"action_name\":\"create-text-file\",\"action_description\":\"This action helps in creating a text file\"},{\"action_name\":\"create-presentation-file\",\"action_description\":\"This action helps in creating a Powerpoint presentation\"}]}";
		String jsonSchemaToRespond = "{\"$schema\":\"http://json-schema.org/draft-07/schema#\",\"type\":\"object\",\"properties\":{\"actions_to_perform\":{\"type\":\"array\",\"items\":{\"type\":\"object\",\"properties\":{\"action_id\":{\"type\":\"integer\",\"description\":\"This is the sequence number of a particular action. This is important as this determines the sequence of execution of the associated actions.\"},\"action_name\":{\"type\":\"string\",\"description\":\"This is the name of the action to be executed. This should be derived from the earlier provided list of actions.\"}},\"required\":[\"action_id\",\"action_name\"]},\"description\":\"This array holds the list of actions in the correct sequence which needs to be executed to successfully complete a task.\"}},\"required\":[\"actions_to_perform\"],\"description\":\"Schema for representing a set of actions to be performed.\"}";
		String task = input;

		/**
		 * Once we have this information created, now we need the "think" phase of the
		 * opereation Here, we provide all the above inforamtin to the AI including the
		 * input task and let it come up with a sequence of actions that can be taken to
		 * do the job
		 * 
		 */

		ChatGTPThink getWorflow = new ChatGTPThink("https://api.example.com", tasksAvaliabe, jsonSchemaToRespond, task);
		getWorflow.execute();
		String workflow = getWorflow.getOutput();

		/**
		 * New that we have the workflow, we next need to parse the workflow into a list
		 * of actions Then we need to execute the actions
		 */

		List<WFAction> actions = null;
		try {
			actions = getActionsFromWF(workflow);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		/**
		 * Then we execute the actions
		 */
		
		actionManager.executeActions(actions);
		
		System.out.println("--> Completed");

//		TextFileGenerator fileGenerator = new TextFileGenerator("fileLoc", "fileName");
//		ChatGTPGetInfo chatGTPGetInfo = new ChatGTPGetInfo("https://api.example.com", "Stephan Hawking");
//		actionManager.registerAction(chatGTPGetInfo);
//		actionManager.executeAction("chat_gtp_get_info");
//		fileGenerator.setContent(chatGTPGetInfo.getContent());
//		actionManager.registerAction(fileGenerator);
//		actionManager.executeAction("text-file-generator");
	}

	private static List<WFAction> getActionsFromWF(String workflow)
			throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		WF wf = objectMapper.readValue(workflow, WF.class);
		return wf.getActions_to_perform();
	}
}
