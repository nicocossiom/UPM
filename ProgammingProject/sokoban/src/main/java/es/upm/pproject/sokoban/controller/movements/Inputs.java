package es.upm.pproject.sokoban.controller.movements;

import es.upm.pproject.sokoban.view.ViewManager;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Inputs {

    
    /** 
     * @param scene
     */
    public static void setInputHandler(Scene scene) {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                ViewManager.updateSceneOnInput(event.getCode());
            }
        });
    }
}
