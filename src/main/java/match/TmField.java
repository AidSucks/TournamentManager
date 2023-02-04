package match;

public class TmField {

  private final int ID;

  public TmField(int ID) throws InvalidIDException {

    if(ID <= 0) throw new InvalidIDException();

    this.ID = ID;
  }

  public int getID() {
    return this.ID;
  }

  public static class InvalidIDException extends RuntimeException {
    public InvalidIDException() {
      super("Field ID must be greater than zero");
    }
  }
}
