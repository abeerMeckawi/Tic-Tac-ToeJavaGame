package Boards;


import Bases.Base;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    static Base root;
    static Scene scene;

    public static Base getRoot() {
        return root;
    }

    public static void setRoot(Base root) {
        Main.root = root;
    }

    public static Scene getScene() {
        return scene;
    }

    public static void setScene(Scene scene) {
        Main.scene = scene;
    }

    public static Stage getpStage() {
        return pStage;
    }

    public static void setpStage(Stage pStage) {
        Main.pStage = pStage;
    }

    static Stage pStage= new Stage();


    @Override
    public void start(Stage primaryStage) throws Exception{



        root = new Base();
        scene = new Scene(root);
        pStage.setScene(scene);
        pStage.setResizable(false);
        pStage.show();
    }


    public static void main(String[] args) {
        launch(args);


    }
}
