/* ***************************************************************
* Autor: nome(s) do(s) autor(es) do codigo
* Inicio: 13/03/2021 16:10:43
* Ultima alteracao: 14/03/2021 15:31:47
* Nome: Nome do programa
* Funcao: descricao do que eh o programa
*************************************************************** */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import controles.MainControle;

public class Main extends Application{
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/main_view.fxml"));
        MainControle controlador = new MainControle();
        loader.setController(controlador);

        Parent root = loader.load();

        Scene scene = new Scene(root);

        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.setTitle("AED algoritmos");
        primaryStage.show();
    }    
}