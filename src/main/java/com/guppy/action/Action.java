package com.guppy.action;

public interface Action {
	
	void execute();
	String getName();
	String getOutput();
	void setInput(String input);

}
