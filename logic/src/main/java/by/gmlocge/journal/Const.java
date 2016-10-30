package by.gmlocge.journal;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by D4 on 24.12.2015.
 */
public class Const {
    public static final String VER = "2015.12";
    public static final String SCHEMA = "journal";
    public static final String NAME_SIMPLY_ROLE = "simply";
    public static final String NAME_ADMIN_ROLE = "admin";

    public static Set<String> PERMISSIONS_ALL = new HashSet<>();

    public static Set<String> PERMISSIONS_AUTH = new HashSet<>();

    static {
        PERMISSIONS_ALL.add("ROLE_AUTH");
        PERMISSIONS_ALL.add("ROLE_ADMIN");
        PERMISSIONS_ALL.add("ROLE_GUEST");

        PERMISSIONS_AUTH.add("ROLE_GUEST");
        PERMISSIONS_AUTH.add("ROLE_AUTH");

    }


}
