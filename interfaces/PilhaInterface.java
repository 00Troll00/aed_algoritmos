package interfaces;

public interface PilhaInterface{
  public void fazVazia();
  public boolean estaVazia();
  public Object getTop();
  public void push(Object item);
  public Object pop();
}
