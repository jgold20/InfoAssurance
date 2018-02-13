import java.util.ArrayList;
public class user {
    // Fields
    public String name;
    public String role;
    public ArrayList<String> permissions;

    public user(String name, String role, ArrayList<String> Perm) {
        this.name = name;
        this.role = role;
        this.permissions = Perm;
    }

    public user() {
        this.name = null;
        this. role = null;
        this.permissions = new ArrayList<String>();
    }

    public void setRole( String role) {
        this.role = role;
    }

    public user addUser(String name) {
        user usr = new user();
        usr.name = name;
        return usr;
    }

    public void addPermission(String perm) {
        permissions.add(perm);
    }

    public void RevokePermission(String perm) {
        this.permissions.remove(perm);
    }

    public void printData() {
        System.out.println("Name: "+ name);
        System.out.println("Role: " + role );
        System.out.print("Permissions: ");
        System.out.println(permissions.toString());
    }


}
