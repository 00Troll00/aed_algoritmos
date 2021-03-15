/* ***************************************************************
* Autor: nome(s) do(s) autor(es) do codigo
* Inicio: 13/03/2021 18:58:45
* Ultima alteracao: 13/03/2021 23:08:17
* Nome: Nome do programa
* Funcao: descricao do que eh o programa
*************************************************************** */

package controles;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;


import exception.ObjetoNaoEncontradoException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.ListaEncadeadaSimples;

public class ListaEncadeadaControle implements Initializable{
    @FXML Label labelExibicao;
    @FXML Label labelErro;

    @FXML TextField textFieldEntrada;
    @FXML TextField textFieldDepois;
    @FXML TextField textFieldAntes;
    

    private ListaEncadeadaSimples lista;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lista = new ListaEncadeadaSimples();
        labelExibicao.setText("");
        
        imprimirLabel();
    }
    
    @FXML
    public void adicionarInicio(ActionEvent event){
        try{
            String conteudoLabel = textFieldEntrada.getText();
            Integer inteiro = Integer.parseInt(conteudoLabel);
            lista.inserirInicio(inteiro);
        }
        catch(NumberFormatException e){
            erroEntradaInvalida();
        }

        imprimirLabel();
        textFieldEntrada.setText("");
    }

    @FXML
    public void adicionarFim(ActionEvent event){
        try{
            String conteudoLabel = textFieldEntrada.getText();
            Integer inteiro = Integer.parseInt(conteudoLabel);
            lista.inserirFim(inteiro);
        }
        catch(NumberFormatException e){
            erroEntradaInvalida();
        }

        imprimirLabel();
        textFieldEntrada.setText("");
    }

    @FXML
    public void adicionarDepois(ActionEvent event){
        try{
            Integer inteiro = Integer.parseInt(textFieldDepois.getText());
            ListaEncadeadaSimples.Element elemento = lista.buscar(inteiro);

            inteiro = Integer.parseInt(textFieldEntrada.getText());
            elemento.inserirDepois(inteiro);

            textFieldEntrada.setText("");
            textFieldDepois.setText("");
        }
        catch(ObjetoNaoEncontradoException e){
            erroObjetoNaoEncontrado();
        }
        catch(NumberFormatException e){
            erroEntradaInvalida();
        }

        imprimirLabel();
    }

    @FXML
    public void adicionarAntes(ActionEvent event){
        try{
            Integer inteiro = Integer.parseInt(textFieldAntes.getText());
            ListaEncadeadaSimples.Element elemento = lista.buscar(inteiro);

            inteiro = Integer.parseInt(textFieldEntrada.getText());
            elemento.inserirAntes(inteiro);

            textFieldEntrada.setText("");
            textFieldAntes.setText("");
        }
        catch(ObjetoNaoEncontradoException e){
            erroObjetoNaoEncontrado();
        }
        catch(NumberFormatException e){
            erroEntradaInvalida();
        }

        imprimirLabel();
    }

    @FXML
    public void apagar(ActionEvent event){
        try{
            Integer inteiro = Integer.parseInt(textFieldEntrada.getText());
            lista.extrair(inteiro);

            textFieldEntrada.setText("");
        }
        catch(ObjetoNaoEncontradoException e){
            erroObjetoNaoEncontrado();
        }
        catch(NumberFormatException e){
            erroEntradaInvalida();
        }
        imprimirLabel();
    }

    @FXML
    public void apagarLista(ActionEvent event){
        lista.fazVazia();
        imprimirLabel();
    }

    public void imprimirLabel(){
        labelExibicao.setText(lista.toString());
    }

    private void erroObjetoNaoEncontrado(){
        labelErro.setText("Numero nao encontrado!");
        labelErro.setVisible(true);
        Timer temporizador = new Timer();
        temporizador.schedule(new TimerTask(){
            public void run(){
                Platform.runLater(() -> labelErro.setVisible(false));
                temporizador.cancel();
            }
        }, 1000);
    }

    private void erroEntradaInvalida(){
        labelErro.setText("Voce precisa digitar um numero inteiro!");
        labelErro.setVisible(true);
        Timer temporizador = new Timer();
        temporizador.schedule(new TimerTask(){
            public void run(){
                Platform.runLater(() -> labelErro.setVisible(false));
                temporizador.cancel();
            }
        }, 1000);
    }
}
