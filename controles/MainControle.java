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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/lista_encadeada_view.fxml"));
        ListaEncadeadaControle controlador = new ListaEncadeadaControle();
        loader.setController(controlador);

        Parent root = loader.load();

        Scene scene = new Scene(root);

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Lista Encadeada Simples");
        stage.show();
    }
}