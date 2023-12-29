package com.guppy.action;

import lombok.Data;


@Data
public class TextFileGenerator implements Action {

	String fileLocation;
	String fileName;
	String content;
	

	@Override
	public void execute() {
		System.out
				.println("File " + fileLocation + " createad successfully at " + fileName + " with content " + content);
	}

	@Override
	public String getName() {
		return "text-file-generator";
	}

	public TextFileGenerator(String fileLocation, String fileName) {
		super();
		this.fileLocation = fileLocation;
		this.fileName = fileName;
	}

}
