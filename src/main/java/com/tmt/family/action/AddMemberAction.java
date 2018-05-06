package com.tmt.family.action;

import com.tmt.family.entity.Family;
import com.tmt.family.entity.Person;
import com.tmt.family.relation.action.ChildRelationAction;
import com.tmt.family.relation.action.RelationAction;
import com.tmt.family.relation.action.SpouseRelationAction;

import java.util.HashMap;
import java.util.Map;

public class AddMemberAction extends Action {

static Map<String, RelationAction> relationActionMap;
    private static void init(){
        relationActionMap = new HashMap();
        relationActionMap.put("Mother_Son", new ChildRelationAction());
        relationActionMap.put("Mother_Daughter", new ChildRelationAction());
        relationActionMap.put("Husband_Wife", new SpouseRelationAction());
        relationActionMap.put("Wife_Husband", new SpouseRelationAction());
    }

    public void performAction(Family family) {
        if(relationActionMap == null){init();}

        RelationAction relationAction = relationActionMap.get(getActionSource().getKey() + "_" + getActionTarget().getKey());
        if(relationAction == null){
            throw new RuntimeException("Invalid Relationship!");
        }
        Person actionSourcePerson = family.getPerson(getActionSource().getValue());
        relationAction.addRelation(actionSourcePerson,getActionTarget().getKey(), getActionTarget().getValue());
        System.out.println("Output: Welcome to the family, " + getActionTarget().getValue() + "!");

    }
}
