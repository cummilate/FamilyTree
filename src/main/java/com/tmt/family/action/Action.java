package com.tmt.family.action;

import com.tmt.family.entity.Family;
import javafx.util.Pair;

public abstract class Action {


    private Pair<String, String> actionSource;
    private Pair<String, String> actionTarget;

    public abstract void performAction(Family family);

    public Pair<String, String> getActionSource() {
        return actionSource;
    }

    public void setActionSource(Pair<String, String> actionSource) {
        this.actionSource = actionSource;
    }

    public Pair<String, String> getActionTarget() {
        return actionTarget;
    }

    public void setActionTarget(Pair<String, String> actionTarget) {
        this.actionTarget = actionTarget;
    }
}
