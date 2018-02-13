import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Boolean policy_loaded = false;
        String user_string;
        //FileReader f;
        String perms;
        String roles;
        String users;
        String ra;
        String pa;

        Path policy_path = Paths.get("C://Users//joshgold20//IdeaProjects//ControlAccess//src//policy.txt");
        List<String> lines = null;
        Charset charset = Charset.forName("ISO-8859-1");


        // List of users
        ArrayList<user> user_list = new ArrayList<>();
        ArrayList<role> role_list = new ArrayList<>();


        // Set users roles
        // String roler = role_split[0];
        // System.out.println(roler.substring(roler.indexOf(':') + 2, roler.length()-1));

        //   System.out.println(perms);
        // System.out.println(role_split[0]);
        //  System.out.println(users_split[0]);


        while (true) {
            user_string = in.nextLine();
            try {
                if (user_string.contains("load-policy")) {
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
                    ArrayList<String> permissions = new ArrayList<>();
                    String roler, p;

                    // Set user names and roles
                    for (int j = 0; j < users_split.length; j++) {
                        users_split[j] = users_split[j].substring(1, users_split[j].length() - 1);
                        user_list.add(new user());
                        user_list.get(j).name = users_split[j];
                        for (int k = 0; k < ra_split.length; k++) {
                            // Set user roles
                            if (ra_split[k].contains(user_list.get(j).name)) {
                                roler = ra_split[k];
                                roler = roler.substring(roler.indexOf(':') + 2, roler.length() - 1);
                                user_list.get(j).setRole(roler);
                            }
                        }

                        // Set permissions
                        for (int l = 0; l < pa_split.length; l++) {
                            if (pa_split[l].contains(user_list.get(j).role)) {
                                p = pa_split[l];
                                p = p.substring(p.indexOf(":") + 2, p.length() - 1);
                                user_list.get(j).addPermission(p);
                            }
                        }
                        // Add permissions
                    }

                    user_list.get(1).printData();
                    policy_loaded = true;
                } else if (user_string.contains("show-policy")) {
                    if (policy_loaded) {
                        System.out.println(lines);
                    }
                } else if (user_string.contains("check-permission")) {
                    // check permission
                    Boolean check = false;
                    //System.out.println("HERE");
                    String name = user_string.substring(user_string.indexOf("n") + 2, user_string.indexOf(" "));
                    String pm = user_string.substring(user_string.lastIndexOf(" ") + 1);
                    System.out.println(name);
                    for (int i = 0; i < user_list.size(); i++) {
                        if (user_list.get(i).name.contains(name)) {
                            int idx = i;
                            if (user_list.get(i).permissions.contains(pm)) {
                                check = true;
                            }
                        }
                    }
                    if (check) {
                        System.out.println("USER HAS PERMISSION");
                        return;
                    } else {
                        System.out.println("USER DOES NOT HAVE PERMISSION");
                    }

                } else if (user_string.contains("add-user")) {
                    // add user
                    System.out.println(4);
                } else if (user_string.contains("remove-user")) {
                    // remove user
                    System.out.println(5);
                } else if (user_string.contains("add-role")) {
                    // add role

                    System.out.println(6);
                } else if (user_string.contains("remove-roll")) {
                    // add user
                    System.out.println(7);
                } else if (user_string.contains("add-permission")) {
                    // add p
                    System.out.println(8);
                } else if (user_string.contains("remove-permission")) {
                    // remove p
                    System.out.println(9);
                } else if (user_string.contains("add-permission-to-role")) {
                    // add p to role
                    System.out.println(10);
                } else if (user_string.contains("remove-permission-from-role")) {
                    // remove p from role
                    System.out.println("remove-permission-from-role");
                } else if (user_string.contains("add-role-to-user")) {
                    // add role to user
                    System.out.println("add-role-to-user");
                } else {
                    System.out.println("BAD");
                }
            } catch (StringIndexOutOfBoundsException e) {
                break;
            }
        }
    }
}
