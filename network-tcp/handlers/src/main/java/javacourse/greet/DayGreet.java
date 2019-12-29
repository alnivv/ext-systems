package javacourse.greet;

import javacourse.net.Greeatable;


public class DayGreet extends Greeatable {

    @Override
    public String buildResponse(String userName) {
        return "Good day, " + userName;
    }
}
