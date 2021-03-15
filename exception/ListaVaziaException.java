/* ***************************************************************
* Autor: nome(s) do(s) autor(es) do codigo
* Inicio: 13/03/2021 16:25:36
* Ultima alteracao: 13/03/2021 16:32:48
* Nome: Nome do programa
* Funcao: descricao do que eh o programa
*************************************************************** */

package exception;

public class ListaVaziaException extends Exception{
    public ListaVaziaException(){}

    public ListaVaziaException(String mensagem){
        super(mensagem);
    }
}
