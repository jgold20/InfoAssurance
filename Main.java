package com.company;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.io.*;


public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Boolean policy_loaded = false;
        String user_string;
        FileReader f;
        String perms;
        String roles;
        String users;
        String ra;
        String pa;

        Path policy_path = Paths.get("C:/Users/j/IdeaProjects/untitled11/src/com/company/policy.txt");
        List<String> lines = null;
        Charset charset = Charset.forName("ISO-8859-1");



        try {
           lines = Files.readAllLines(policy_path, charset);
           policy_loaded = true;
        } catch (IOException e) {
            System.out.println("CRITCAL FAILURE!");
        }


        perms = lines.get(0);
        roles = lines.get(1);
        users = lines.get(2);
        ra = lines.get(3);
        pa = lines.get(4);
        perms = perms.substring(7);
        roles = roles.substring(8);
        users = users.substring(8);
        ra = ra.substring(5);
        pa = pa.substring(5);
        String[] perm_split = perms.split(",");
        String[] role_split = roles.split(",");
        String[] users_split = users.split(",");
        String[] ra_split = ra.split(",");
        String[] pa_split = pa.split(",");
        System.out.println(perm_split[0]);
        System.out.println(perm_split[1]);

        //System.out.println(perms);
        System.out.println(role_split[0]);
        System.out.println(users_split[0]);
        System.out.println(ra_split[0]);
        System.out.println(pa_split[0]);


        while(true) {
            user_string = in.nextLine();
            try {
            if(user_string.substring(0, 11).equals("rbacmonitor")) {
            if(user_string.contains("load-policy")) {
                policy_loaded = true;
                System.out.println(1);
            }else if(user_string.contains("show-policy")) {
                if(policy_loaded) {
                    lines.toString();
                }
                System.out.println(2);
            } else if(user_string.contains("check-permission")) {
                // check permission
                System.out.println(3);
            } else if(user_string.contains("add-user")) {
                // add user
                System.out.println(4);
            } else if(user_string.contains("remove-user")) {
                // remove user
                System.out.println(5);
            } else if(user_string.contains("add-role")) {
                // add role
                System.out.println(6);
            } else if(user_string.contains("remove-roll")) {
                // add user
                System.out.println(7);
            } else if(user_string.contains("add-permission")) {
                // add p
                System.out.println(8);
            } else if(user_string.contains("remove-permission")) {
                // remove p
                System.out.println(9);
            } else if(user_string.contains("add-permission-to-role")) {
                // add p to role
                System.out.println(10);
            } else if(user_string.contains("remove-permission-from-role")) {
                // remove p from role
                System.out.println(11);
            } else if(user_string.contains("add-role-to-user")) {
                // add role to user
                System.out.println(12);
            }
            }} catch (StringIndexOutOfBoundsException e) {
                break;
            }
        }



     /*   // Attempt to read file
        try{
            f = new FileReader("C:/Users/j/IdeaProjects/untitled11/src/com/company/policy.txt");
            int i;
            int count = 0;
            while((i = f.read()) != -1) {
                System.out.print((char) i );

            }

        } catch (IOException e) {
            System.out.println("DEBUG FILE NOT FOUND!");
        }*/

        // Wait for user input
      //

      //  System.out.println(user_string);
        // react based on request
        // load-policy

    }
}
