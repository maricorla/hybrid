package service;

import model.User;

public class UserCreator {
    public static final String USER_NAME = "maricorla";
    public static final String USER_PASSWORD = "Corlatti2005377";

    public static User withCredentialsFromProperty(){
        return new User(USER_NAME,USER_PASSWORD);
    }
    public static User withEmptyUsername(){
        return new User("", USER_PASSWORD);
    }
    public static User withEmptyPassword(){
        return new User (USER_NAME, "");
    }
}
