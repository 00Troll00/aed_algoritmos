package interfaces;

import exception.ObjetoNaoEncontradoException;

public interface ListaEncadeadaInterface {
  public void inserirFim(Object item);
  public void inserirInicio(Object item);
  public void fazVazia();
  public boolean estaVazia();
  public Object getPrimeiro();
  public Object getUltimo();
  public void extrair(Object item) throws ObjetoNaoEncontradoException;
}