package client;

/**
 * The type Session to receive employee role.
 */
public class Session {

    private static int role_id;
    private static String username;

    /**
     * Gets role id.
     *
     * @return the role id
     */
    public static int getRole_id() {
        return role_id;
    }

    /**
     * Sets role id.
     *
     * @param role_id the role id
     */
    public static void setRole_id(int role_id) {
        Session.role_id = role_id;
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public static String getUsername() {
        return username;
    }

    /**
     * Sets username.
     *
     * @param username the username
     */
    public static void setUsername(String username) {
        Session.username = username;
    }
}
