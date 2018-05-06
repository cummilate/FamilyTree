package com.tmt.family.action;

import com.tmt.family.enums.ActionType;

import java.util.HashMap;
import java.util.Map;

public class ActionFactory {
    private static Map<ActionType, Action> actions;

    private static void init()
    {
        actions = new HashMap<ActionType, Action>();
        actions.put(ActionType.ADD, new AddMemberAction());
        actions.put(ActionType.FIND, new FindMemberAction());
    }

    public static Action getAction(ActionType actionType) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
       if(actions == null){init();}

        return actions.get(actionType);
    }
}
