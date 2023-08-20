package cc.robotdreams;

public class WrongException extends RuntimeException
{
    public WrongException(String s, Throwable e) {

    }

    public WrongException(String message) {
        super("Something went wrong " + message);
    }
}
