import java.util.ArrayList;

public class role {
    public String  role_name;
    public ArrayList<String> permissions;

    public role(String n, ArrayList<String> p){
        role_name = n;
        permissions = p;
    }

    // Methods
    //
    public void add_permissio_to_role(String permission) {
        permissions.add(permission);
    }

    public void remove_permission_from_role(String permission) {
        permissions.remove(permission);
    }
}
