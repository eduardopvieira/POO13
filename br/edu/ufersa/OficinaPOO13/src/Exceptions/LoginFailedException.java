package Exceptions;

public class LoginFailedException extends Exception{
    public LoginFailedException(String msg){
        super(msg);
    }
}
