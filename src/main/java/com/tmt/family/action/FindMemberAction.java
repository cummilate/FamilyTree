package com.tmt.family.action;

import com.sun.deploy.util.StringUtils;
import com.tmt.family.entity.Family;
import com.tmt.family.entity.Person;
import com.tmt.family.relation.action.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FindMemberAction extends Action {

   private static Map<String, RelationAction> relationActionMap;
    private static void init()
    {
        relationActionMap = new HashMap();
        relationActionMap.put("Father", new ParentRelationAction());
        relationActionMap.put("Mother", new ParentRelationAction());
        relationActionMap.put("Sons", new ChildRelationAction());
        relationActionMap.put("Daughters", new ChildRelationAction());
        relationActionMap.put("Brothers", new SiblingRelationAction());
        relationActionMap.put("Sisters", new SiblingRelationAction());
        relationActionMap.put("Wife", new SpouseRelationAction());
        relationActionMap.put("Husband", new SpouseRelationAction());


        relationActionMap.put("GrandFather", new AncestorRelationAction());
        relationActionMap.put("GrandMother", new AncestorRelationAction());
        relationActionMap.put("GrandSons", new SuccessorRelationAction());
        relationActionMap.put("GrandDaughters", new SuccessorRelationAction());
//TODO
        /*relationActionMap.put("Aunts", new OtherRelationAction());
        relationActionMap.put("Uncles", new OtherRelationAction());
        relationActionMap.put("Cousins", new OtherRelationAction());
        */
    }

    public void performAction(Family family) {

        if(relationActionMap == null){init();}

        RelationAction relationAction = relationActionMap.get( getActionTarget().getValue().trim());
        if(relationAction == null){
            throw new RuntimeException("Invalid Relationship!");
        }
        Person actionSourcePerson = family.getPerson(getActionSource().getValue());
        Set<String> relatives = relationAction.findRelation(actionSourcePerson, getActionTarget().getValue());

        System.out.println("Output: " + getActionTarget().getValue() + "=" + StringUtils.join(relatives, ", "));


    }

}
