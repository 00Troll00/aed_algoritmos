/* ***************************************************************
* Autor: nome(s) do(s) autor(es) do codigo
* Inicio: 14/03/2021 15:15:03
* Ultima alteracao: 14/03/2021 15:27:54
* Nome: Nome do programa
* Funcao: descricao do que eh o programa
*************************************************************** */

package controles;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainControle implements Initializable{

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub   
    }

    @FXML
    public void abrirListaEncadeadaSimples(ActionEvent event) throws IOException{
        ListaEncadeadaControle controlador = new ListaEncadeadaControle();
        abrirJanela(controlador, "/view/lista_encadeada_view.fxml", "Lista Encadeada Simples");
    }

    @FXML
    public void abrirListaEncadeadaSimplesCircular(ActionEvent event) throws IOException{
        ListaEncadeadaSimplesCircularControle controlador = new ListaEncadeadaSimplesCircularControle();
        abrirJanela(controlador, "/view/lista_encadeada_simples_circular_view.fxml", "Lista Encadeada Simples Circular");
    }

    public void abrirJanela(Object controlador, String url, String titulo) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource(url));
        loader.setController(controlador);

        Parent root = loader.load();

        Scene scene = new Scene(root);

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle(titulo);
        stage.show();
    }
}