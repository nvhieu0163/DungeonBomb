import controller.GameController;
import controller.PlayerController;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.GameConfig;
import model.entity.character.Player;
import view.ImageManager;

import static view.LayerManager.STATIC_MAP;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("DungeonBomber v1.0");

        GameController gc = new GameController();

        primaryStage.setScene(gc.getScene());
        primaryStage.show();

        Player player = PlayerController.createPriest3(0, 0);
        gc.startLevel(gc.getLevel(), player);

    }


    public static void main(String[] args) {
        launch(args);
    }
}
