/* ***************************************************************
* Autor: nome(s) do(s) autor(es) do codigo
* Inicio: 23/03/2021
* Ultima alteracao: 27/03/2021
* Nome: Nome do programa
* Funcao: descricao do que eh o programa
*************************************************************** */

package models;

import interfaces.ListaEncadeadaInterface;
import exception.ObjetoNaoEncontradoException;
import exception.ListaVaziaException;

public class ListaEncadeadaDupla implements ListaEncadeadaInterface{
  private Element head;
  private Element tail; 

  public class Element{
    private Object dado;
    private Element previous;
    private Element next;

    public Element(Object dado, Element previous, Element next){
      this.dado = dado;
      this.previous = previous;
      this.next = next;
    }
    
    public void inserirAntes(Object item){
      if(this == head){
        Element temporario = new Element(item, null, this);
        this.setPrevious(temporario);
        head = temporario;
      }
      else{
        Element temporario = new Element(item, this.getPrevious(), this);
        this.getPrevious().setNext(temporario);
        this.setPrevious(temporario);
      }
    }//fim metodo inserirAntes

    public void inserirDepois(Object item){
      if(this == tail){
        Element temporario = new Element(item, this, next);
        this.setNext(temporario);
        tail = temporario;
      }
      else{
        Element temporario = new Element(item, this, this.getNext());
        this.getNext().setPrevious(temporario);
        this.setNext(temporario);
      }
    }//fim metodo inserirDepois

    public Object getDado(){
      return this.dado;
    }

    public Element getPrevious(){
      return this.previous;
    }

    public void setPrevious(Element previous){
      this.previous = previous;
    }

    public Element getNext(){
      return this.next;
    }

    public void setNext(Element next){
      this.next = next;
    }
  }//fim classe Element

  public ListaEncadeadaDupla(){
    this.head = null;
    this.tail = null;
  }

  @Override
  public void inserirFim(Object item){
    Element temporario = new Element(item, tail, null);

    if(head == null)
      head = temporario;
    else
      tail.setNext(temporario);
    tail = temporario;
  }

  @Override
  public void inserirInicio(Object item){
    Element temporario = new Element(item, null, head);

    if(head == null)
      tail = temporario;
    else
      head.setPrevious(temporario);
    head = temporario;
  }

  @Override
  public void fazVazia(){
    this.head = null;
    this.tail = null;
  }

  @Override
  public boolean estaVazia(){
    return this.head == null;
  }

  @Override
  public Object getPrimeiro() throws ListaVaziaException{
    if(estaVazia())
      throw new ListaVaziaException();
    return this.head.getDado();
  }

  @Override
  public Object getUltimo() throws ListaVaziaException{
    if(estaVazia())
      throw new ListaVaziaException();
    return this.tail.getDado();
  }

  @Override
  public void extrair(Object item) throws ObjetoNaoEncontradoException{
    try{
      Element ponteiro = buscar(item, this.head);

      if(ponteiro == head){
        head = ponteiro.getNext();
        head.setPrevious(null);
      }
      else if(ponteiro == tail){
        tail = ponteiro.getPrevious();
        tail.setNext(null);
      }
      else{
        ponteiro.getPrevious().setNext(ponteiro.getNext());
        ponteiro.getNext().setPrevious(ponteiro.getPrevious());
      }
    }
    catch(ObjetoNaoEncontradoException e){
      throw new ObjetoNaoEncontradoException();
    }
  }
  
  public Element buscar(Object item, Element element) throws ObjetoNaoEncontradoException{
    if(element == null)
      throw new ObjetoNaoEncontradoException();
    else{
      if(element.getDado() == item)
        return element;
      else
        return buscar(item, element.getNext());
    }
  }

  public Element getHead(){
    return this.head;
  }

  @Override
  public String toString(){
    if(!estaVazia()){
      String conteudo = "a";
      String primeiraParte = "a";
      String segundaParte = "a";
      //ideia para melhorar o algoritmo
      //executar o for a partir do head.getNext() e parar no ponteiro.getNext == null
      for(Element ponteiro = head; ponteiro!=null; ponteiro = ponteiro.getNext()){
        if(ponteiro.getPrevious() == null)
          primeiraParte = "vazio* <-- ";
        else
          primeiraParte = ponteiro.getPrevious().getDado().toString() + "* <-- ";
        if(ponteiro.getNext() == null)
          segundaParte = " --> vazio*";
        else
          segundaParte = " --> " + ponteiro.getNext().getDado().toString() + "*";
        
        if(ponteiro == head)
          conteudo = primeiraParte + ponteiro.getDado().toString() + segundaParte;
        else
          conteudo += primeiraParte + ponteiro.getDado().toString() + segundaParte;
        conteudo+= "   ";
      }
      return conteudo;
    }
    else
      return "A lista esta vazia!";
  }
}//fim classe ListaEncadeadaDupla