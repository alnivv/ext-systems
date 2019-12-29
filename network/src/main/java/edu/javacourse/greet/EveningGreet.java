package edu.javacourse.greet;

import edu.javacourse.net.Greeatable;

public class EveningGreet extends Greeatable {
    @Override
    public String buildResponse(String userName) {
        return "Good evening, "+ userName;
    }
}
