package com.guppy.action;

import java.util.ArrayList;
import java.util.List;

public class ActionManager {

	List<Action> actions;

	public ActionManager() {
		actions = new ArrayList<>();
	}

	public void registerAction(Action action) {
		actions.add(action);
	}

	public void executeAction(String actionName) {
		for (Action action : actions) {
			if (action.getName().equals(actionName)) {
				action.execute();
				return;
			}
		}
		System.out.println("Action not found: " + actionName);
	}

}
