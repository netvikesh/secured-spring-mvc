package net.vikesh.ssm;

/**
 * Created by Vikesh on 24-Dec-16.
 */
public class SSMUtils {
    /**
     * The most basic possible check for an email
     *
     * @param input
     * @return
     */
    public static final boolean isEmail(final String input) {
        return input.matches("^[a-z,A-Z,0-9,_,\\-]((\\.?([a-z,A-Z,0-9,_,\\-])+)?)+@([a-z,A-Z,0-9,_,\\-]+\\.){1,2}[a-z,A-Z]{2,3}$");
    }
}
