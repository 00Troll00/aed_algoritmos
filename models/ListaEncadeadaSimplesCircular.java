/* ***************************************************************
* Autor: nome(s) do(s) autor(es) do codigo
* Inicio: 19/03/2021 
* Ultima alteracao: 19/03/2021 18:33
* Nome: Nome do programa
* Funcao: descricao do que eh o programa
*************************************************************** */
package models;

import exception.ObjetoNaoEncontradoException;

public class ListaEncadeadaSimplesCircular{
  private Element tail;

  public class Element{
    private Object dado;
    private Element next;

    public Element(Object dado, Element next){
      this.dado = dado;
      this.next = next;
    }

    public void inserirAntes(Object item){
      if(tail==null)
        tail.inserirDepois(item);
      else{
        Element ponteiro = tail;
        while(ponteiro.next != this){
          ponteiro = ponteiro.next;
        }
        ponteiro.inserirDepois(item);
      }

    }//fim metodo

    public void inserirDepois(Object item){
      next = new Element(item, next);
    }//fim metodo

    public void setNext(Element next){
      this.next = next;
    }

    public Element getNext(){
      return this.next;
    }

    public Object getDado(){
      return this.dado;
    } 
  }//fim classe Element

  //insere um objeto na lista
  public void inserir(Object item){
    if(tail == null){
      tail = new Element(item, null);
      tail.setNext(tail);
    }
    else{
      Element novoElement = new Element(item, tail.getNext());
      tail.setNext(novoElement);
    }
  }//fim metodo

  //esvazia a lista
  public void fazVazia(){
    this.tail = null;
  }//fim metodo esvaziar lista

  //retorna true se a lista esta vazia
  public boolean estaVazia(){
    return this.tail == null;
  }//fim metodo estaVazia

  public void apagarItem(Object item) throws ObjetoNaoEncontradoException{
    Element ponteiro = tail;
    Element anteriorPonteiro;
    if(item != tail.getDado()){
      do{
        anteriorPonteiro = ponteiro;
        ponteiro = ponteiro.getNext();
      }while(ponteiro != tail && anteriorPonteiro.getNext().getDado() != item);
      if(ponteiro == tail)
        throw new ObjetoNaoEncontradoException();
      anteriorPonteiro.setNext(ponteiro.getNext());
    }
    else{
      do{
        anteriorPonteiro = ponteiro;
        ponteiro = ponteiro.getNext();
      }while(anteriorPonteiro.getNext() != tail);
      anteriorPonteiro.setNext(ponteiro.getNext());
      tail = anteriorPonteiro;
    }
  }

  public Element buscar(Object item) throws ObjetoNaoEncontradoException{
    if(tail.getDado() == item)
      return tail;
    Element ponteiro = tail;
    do{
      ponteiro=ponteiro.getNext();
      if(ponteiro.getDado() == item)
        return ponteiro;
    }while(ponteiro != tail);

    throw new ObjetoNaoEncontradoException();
  }

  @Override
  public String toString(){
    if(!this.estaVazia()){
      Element ponteiro = tail;
      String conteudo = ponteiro.getDado().toString() + " --> " + ponteiro.getNext().getDado().toString() + "*";
      ponteiro.getNext();
      for(ponteiro = tail.getNext(); ponteiro != tail; ponteiro=ponteiro.getNext()){
        conteudo += "    " +  ponteiro.getDado().toString() + " --> " + ponteiro.getNext().getDado().toString() + "*";
      }
      return conteudo;
    }
    else
      return "A lista esta vazia";
  }
}