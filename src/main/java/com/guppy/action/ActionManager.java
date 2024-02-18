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

//	public void executeActions(List<WFAction> wfActions) {
//		Map<WFAction, String> actionOutputMap = new HashMap<>();
//		for (WFAction wfAction : wfActions) {
//			for (Action action : actions) {
//				if (action.getName().equals(wfAction.getAction_name())) {
//					action.execute();
//					actionOutputMap.put(wfAction, action.getOutput());
//				}
//			}
//		}
//		for (Entry<WFAction, String> entry : actionOutputMap.entrySet()) {
//			System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
//		}
//	}

	public void executeActions(List<WFAction> wfActions) {
		List<Action> actionsToExecute = getActionList(wfActions);
		for (int i = 0; i < actionsToExecute.size(); i++) {
			Action action = actionsToExecute.get(i);
			Action nextAction = null;
			if ((i + 1) < actionsToExecute.size())
				nextAction = actionsToExecute.get(i + 1);
			action.execute();
			if (null != nextAction)
				nextAction.setInput(action.getOutput());
			System.out.println(action);
		}
	}

	private List<Action> getActionList(List<WFAction> wfActions) {
		List<Action> actions = new ArrayList<Action>();
		for (WFAction wfAction : wfActions) {
			for (Action action : this.actions) {
				if (action.getName().equals(wfAction.getAction_name())) {
					actions.add(action);
				}
			}
		}
		return actions;
	}

}
