package com.guppy.action;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TextFileGenerator implements Action {

	String fileLocation;
	String fileName;
	String content;

	@Override
	public void execute() {
		System.out.println("------- Executing - " + getName());
		System.out
				.println("File " + fileLocation + " createad successfully at " + fileName + " with content " + content);
	}

	@Override
	public String getName() {
		return "create-text-file";
	}

	public TextFileGenerator(String fileLocation, String fileName) {
		super();
		this.fileLocation = fileLocation;
		this.fileName = fileName;
	}

	@Override
	public String getOutput() {
		return fileLocation + "//" + fileName;
	}

	@Override
	public void setInput(String input) {
		this.content = input;
		
	}

}
