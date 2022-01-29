package pkg;

/**
  interface for how we deal with role assignement.
*/
public interface Strategy {
  public User[] execute(User[] users, String[] roles);
}
