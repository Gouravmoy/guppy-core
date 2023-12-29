package com.guppy.action;

public class Main {

	public static void main(String[] args) {
		ActionManager actionManager = new ActionManager();
		TextFileGenerator fileGenerator = new TextFileGenerator("fileLoc", "fileName");
		ChatGTPGetInfo chatGTPGetInfo = new ChatGTPGetInfo("https://api.example.com", "Stephan Hawking");
		actionManager.registerAction(chatGTPGetInfo);
		actionManager.executeAction("chat_gtp_get_info");
		fileGenerator.setContent(chatGTPGetInfo.getContent());
		actionManager.registerAction(fileGenerator);
		actionManager.executeAction("text-file-generator");
	}
}
