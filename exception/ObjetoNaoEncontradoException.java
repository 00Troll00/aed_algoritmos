/* ***************************************************************
* Autor: nome(s) do(s) autor(es) do codigo
* Inicio: 13/03/2021 17:04:04
* Ultima alteracao: 13/03/2021 17:05:21
* Nome: Nome do programa
* Funcao: descricao do que eh o programa
*************************************************************** */

package exception;

public class ObjetoNaoEncontradoException extends Exception{
    public ObjetoNaoEncontradoException(){}

    public ObjetoNaoEncontradoException(String mensagem){
        super(mensagem);
    }
}
