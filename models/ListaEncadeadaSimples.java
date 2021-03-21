/* ***************************************************************
* Autor: nome(s) do(s) autor(es) do codigo
* Inicio: 13/03/2021 16:10:56
* Ultima alteracao: 13/03/2021 20:23:31
* Nome: Nome do programa
* Funcao: descricao do que eh o programa
*************************************************************** */

package models;

import exception.ListaVaziaException;
import exception.ObjetoNaoEncontradoException;

public class ListaEncadeadaSimples {
    private Element head;
    private Element tail;

    public class Element{
        private Object data;
        private Element next;

        public Element(Object data, Element next){
            this.data=data;
            this.next=next;
        }

        public Object getData(){
            return this.data;
        }

        public Element getNext(){
            return this.next;
        }

        public void setNext(Element next){
            this.next=next;
        }

        public void inserirAntes(Object item){
            Element temporario = new Element(item, this);
            if(this==head)
                head=temporario;
            else{
                Element anterior = head;
                while(anterior!=null && anterior.getNext()!=this)
                    anterior=anterior.getNext();
                anterior.setNext(temporario);
            }
        }

        public void inserirDepois(Object item){
            next = new Element(item, next);
            if(tail == this)
                tail=next;
        }
    }//fim classe Element

    public void fazVazia(){
        this.head=null;
        this.tail=null;
    }

    public void inserirInicio(Object novo){
        Element temporario = new Element(novo, head);

        if(head==null)
            tail=temporario;
        head=temporario;
    }

    public void inserirFim(Object novo){
        Element temporario = new Element(novo, null);

        if(head==null)
            head=temporario;
        else
            tail.setNext(temporario);
        tail = temporario;
    }

    public Object getPrimeiro() throws ListaVaziaException{
        if(this.head==null)
            throw new ListaVaziaException();
        return this.head.getData();
    }

    public Object getUltimo() throws ListaVaziaException{
        if(this.tail==null)
            throw new ListaVaziaException();
        return this.tail.getData();
    }

    public boolean estaVazia(){
        return this.head==null;
    }

    public void atribuir(ListaEncadeadaSimples lista){
        if(lista != this){
            this.fazVazia();

            for(Element ponteiro=lista.getHead(); ponteiro != null; ponteiro=ponteiro.getNext())
                this.inserirFim(ponteiro);
        }
    }//fim metodo atribuir

    public void extrair(Object item) throws ObjetoNaoEncontradoException{
        Element ponteiro = head;
        Element ponteiroAnterior = null;

        while(ponteiro != null && ponteiro.getData()!=item){
            ponteiroAnterior = ponteiro;
            ponteiro = ponteiro.getNext();
        }
        if(ponteiro == null)
            throw new ObjetoNaoEncontradoException();
        if(ponteiro == head)
            head = ponteiro.getNext();
        else
            ponteiroAnterior.setNext(ponteiro.getNext());
        if(ponteiro==tail)
            tail=ponteiroAnterior;
    }//fim metodo extrair

    public Element buscar(Object item) throws ObjetoNaoEncontradoException{
        Element ponteiro = head;

        while(ponteiro!=null && ponteiro.getData()!=item)
            ponteiro = ponteiro.getNext();
        if(ponteiro == null)
            throw new ObjetoNaoEncontradoException();
        else
            return ponteiro;
    }//fim metodo buscar

    public Element buscaRecursiva(Object item, Element element) throws ObjetoNaoEncontradoException{
        if(element == null)
            throw new ObjetoNaoEncontradoException();
        if(element.getData()==item)
            return element;
        else
            return buscaRecursiva(item, element.getNext());
    }//fim metodo buscaRecursiva

    public Element getTail(){
        return this.tail;
    }

    public Element getHead(){
        return this.head;
    }

    @Override
    public String toString(){
        String conteudo = "a";
        if(!this.estaVazia()){
            for(Element ponteiro=head; ponteiro != null; ponteiro=ponteiro.getNext()){
                if(ponteiro.getNext()!=null){
                    if(ponteiro == head)
                        conteudo = ponteiro.getData().toString() + " --> " + ponteiro.getNext().getData().toString() + "*    ";
                    else
                        conteudo += ponteiro.getData().toString() + " --> " + ponteiro.getNext().getData().toString() + "*    ";
                }
                else{
                    if(ponteiro == head)
                        conteudo = ponteiro.getData().toString() + " --> vazio";
                    else
                        conteudo += ponteiro.getData().toString() + " --> vazio";
                }
            }
        
            return conteudo;
        }
        return "A lista esta vazia";
    }
}//fim classe ListaEncadeadaSimples
