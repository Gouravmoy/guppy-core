package com.guppy.action;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PresentationGenerator implements Action {

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
		return "text-file-generator";
	}

	public PresentationGenerator(String fileLocation, String fileName) {
		super();
		this.fileLocation = fileLocation;
		this.fileName = fileName;
	}

	@Override
	public String getOutput() {
		return fileLocation + "//"+fileName;
	}

	@Override
	public void setInput(String input) {
		this.content = input;
	}
}
