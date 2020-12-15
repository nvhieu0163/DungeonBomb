package view;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LayerManager {
    private final Pane root;
    private final Scene scene;
    private final Map<Integer, Canvas> canvasMap;
    private final Map<Integer, GraphicsContext> contextMap;

    private final int canvasWidth;
    private final int canvasHeight;

    public static final int STARTING = 20;
    public static final int STATIC_MAP = 30;
    public static final int DYNAMIC_OBJECT = 40;
    public static final int PAUSING = 50;
    public static final int GAME_OVER = 999;

    private final List<Integer> AVAILABLE_LAYER = List.of(
            STARTING,
            STATIC_MAP,
            DYNAMIC_OBJECT,
            PAUSING,
            GAME_OVER
    );

    public LayerManager(int width, int height) {
        this.canvasWidth = width;
        this.canvasHeight = height;

        this.root = new Pane();
        this.canvasMap = new HashMap<>();
        this.contextMap = new HashMap<>();

        AVAILABLE_LAYER.forEach(layerID -> {
            Canvas canvas = new Canvas(width, height);
            GraphicsContext gc = canvas.getGraphicsContext2D();
            canvasMap.put(layerID, canvas);
            contextMap.put(layerID, gc);
            root.getChildren().add(canvas);
            clear(layerID);
        });

        // PAUSING
        GraphicsContext gc = getGraphicsContext(LayerManager.PAUSING);
        gc.setFont(FontManager.Huge);
        gc.setFill(Color.WHITE);
        gc.fillText("PAUSING...", 100, 550);

        // Game over
        gc = getGraphicsContext(LayerManager.GAME_OVER);
        gc.setFont(FontManager.Huge);
        gc.setFill(Color.WHITE);
        gc.fillText("GAME OVER!", 100, 550);

        this.scene = new Scene(this.root);
    }

    public Pane getRoot() {
        return root;
    }

    public Scene getScene() {
        return scene;
    }

    public GraphicsContext getGraphicsContext(int layerID) {
        return contextMap.get(layerID);
    }

    public void active(int layerID) {
        canvasMap.get(layerID).toFront();
    }

    public void render(Image image, Integer layerID, int x, int y) {
        getGraphicsContext(layerID).drawImage(image, x, y);
    }

    public void clear(Integer layerID) {
        GraphicsContext gc = getGraphicsContext(layerID);
        gc.clearRect(0, 0, canvasWidth, canvasHeight);
        switch (layerID) {
            case STATIC_MAP:
                gc.setFill(new Color(0.145F, 0.075F, 0.102F, 1.0F));
                gc.fillRect(0, 0, canvasWidth, canvasHeight);
                break;
            case STARTING: case PAUSING: case GAME_OVER:
                gc.setFill(new Color(0.0F, 0.0F, 0.0F, 0.5F));
                gc.fillRect(0, 0, canvasWidth, canvasHeight);
                break;
        }
    }
}
