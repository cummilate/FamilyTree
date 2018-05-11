package com.tmt.family;

import com.tmt.family.action.Action;
import com.tmt.family.entity.Family;
import com.tmt.family.entity.Person;
import com.tmt.family.enums.GenderType;
import com.tmt.family.parser.InputParser;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringReader;
import java.util.Scanner;

public class FamilyApplicationLauncher {
    public static void main(String arg[])  {
        FamilyApplicationLauncher launcher = new FamilyApplicationLauncher();
        launcher.launch();


    }

    public void launch() {

        Family family = FamilyFactory.getDefaultFamily();
        FamilyRelationManager familyRelationManager = new FamilyRelationManager(family);


        System.out.print("Input : ");
        InputStream is = FamilyApplicationLauncher.class.getClassLoader().getResourceAsStream("default-family-members.txt");
        Scanner sc = new Scanner(is);
        acceptAndProcess(sc,familyRelationManager);
        sc.close();

        sc = new Scanner(System.in);
        acceptAndProcess(sc,familyRelationManager);

    }

    private void acceptAndProcess(Scanner sc, FamilyRelationManager familyRelationManager) {
        String input;
        while (!(input = sc.nextLine()).equalsIgnoreCase("EXIT")) {
            try{
                Action action = InputParser.parse(input);
                familyRelationManager.handleRelation(action);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            System.out.print("Input : ");
        }

    }


}
