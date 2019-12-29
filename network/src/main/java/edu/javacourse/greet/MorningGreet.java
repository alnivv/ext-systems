package edu.javacourse.greet;

import edu.javacourse.net.Greeatable;

public class MorningGreet extends Greeatable {
    @Override
    public String buildResponse(String userName) {
        return "Good Morning, " + userName;
    }
}
