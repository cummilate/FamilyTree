package com.tmt.family.parser;

import com.tmt.family.action.Action;
import com.tmt.family.action.ActionFactory;
import com.tmt.family.enums.ActionType;
import javafx.util.Pair;

/**
 * Parses the User input and deduces the action commands
 */
public class InputParser {

    private String input;

    private InputParser(String input) {
        this.input = input;
    }



    public static Action parse(String input) throws Exception {
        InputParser parser = new InputParser(input);

        String[] actions = input.trim().split(" ");
        ActionType actionType = parser.getActionType();
        Action af = ActionFactory.getAction(actionType);
        af.setActionSource(parser.getActionInputPair(actions[0].split("=")));
        af.setActionTarget(parser.getActionInputPair(actions[1].split("=")));
        return af;
    }

    private ActionType getActionType() {
        if (input.startsWith("Person")) {
            return ActionType.FIND;
        } else {
            return ActionType.ADD;
        }
    }

    private Pair<String, String> getActionInputPair(String[] actionInput) {
        return new Pair<String, String>(actionInput[0], actionInput[1]);
    }

    public String getInput() {
        return input;
    }

}
