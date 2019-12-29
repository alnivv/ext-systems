package javacourse.greet;

import javacourse.net.Greeatable;


public class EveningGreet extends Greeatable {
    @Override
    public String buildResponse(String userName) {
        return "Good evening, "+ userName;
    }
}
