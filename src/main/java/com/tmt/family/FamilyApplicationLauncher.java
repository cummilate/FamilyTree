package com.tmt.family;

import com.tmt.family.action.Action;
import com.tmt.family.entity.Family;
import com.tmt.family.entity.Person;
import com.tmt.family.enums.GenderType;
import com.tmt.family.parser.InputParser;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class FamilyApplicationLauncher {
    public static void main(String arg[])  {
        Person husband = FamilyFactory.createPerson("Evan", GenderType.MALE);
        Person wife = FamilyFactory.createPerson("Diana", GenderType.FEMALE);

        husband.setSpouse(wife);
        wife.setSpouse(husband);

        Family family = FamilyFactory.createFamily(husband);

        FamilyRelationManager familyManager = new FamilyRelationManager(family);
        Scanner sc = new Scanner(System.in);
        System.out.print("Input : ");
        //InputStream is = FamilyApplicationLauncher.class.getClassLoader().getResourceAsStream("familyinput.txt");


        String input;
        while (!(input = sc.nextLine()).equalsIgnoreCase("EXIT")) {
            try{
                Action action = InputParser.parse(input);
                familyManager.handleRelation(action);
                System.out.print("Input : ");
            }catch (Exception e){
                System.out.println(e.getMessage());
            }

        }

        System.out.println("Out of loop");

    }
}
