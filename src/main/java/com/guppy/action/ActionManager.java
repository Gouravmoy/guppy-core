package com.guppy.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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

	public void executeActions(List<WFAction> wfActions) {
		Map<WFAction, String> actionOutputMap = new HashMap<>();
		for (WFAction wfAction : wfActions) {
			for (Action action : actions) {
				if (action.getName().equals(wfAction.getAction_name())) {
					action.execute();
					actionOutputMap.put(wfAction, action.getOutput());
				}
			}
			System.out.println("Action not found: " + wfAction.getAction_name());
		}
		for (Entry<WFAction, String> entry : actionOutputMap.entrySet()) {
			System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
		}
	}

}
