package com.tmt.family;

import com.tmt.family.action.Action;
import com.tmt.family.entity.Family;

public class FamilyRelationManager {

    private Family family;

    public FamilyRelationManager(Family family) {
        this.family = family;
    }

    public void handleRelation(Action action) {
        action.performAction(family);

    }

}
