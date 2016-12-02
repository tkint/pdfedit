/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.view.controller.menu;

import app.Config;
import app.Instance;
import javafx.scene.control.ChoiceBox;
import src.view.displayer.PageDisplayer;

/**
 *
 * @author Thomas
 */
public class MenuView implements Config {

    private static final Instance INSTANCE = Instance.getInstance();

    public static void btnZoomIn() {
        int currentZoom = getZoomChoice().getSelectionModel().getSelectedIndex();
        if (currentZoom < ZOOMS.length - 1) {
            getZoomChoice().getSelectionModel().select(currentZoom + 1);
            PageDisplayer.setZoom(ZOOMS[currentZoom + 1]);
            INSTANCE.getDocFileOpened().setZoom(ZOOMS[currentZoom + 1]);
        }
    }

    public static void btnZoomOut() {
        int currentZoom = getZoomChoice().getSelectionModel().getSelectedIndex();
        if (currentZoom > 0) {
            getZoomChoice().getSelectionModel().select(currentZoom - 1);
            PageDisplayer.setZoom(ZOOMS[currentZoom - 1]);
            INSTANCE.getDocFileOpened().setZoom(ZOOMS[currentZoom - 1]);
        }
    }

    public static void chooseZoom(int zoom) {
        if (isZoomAvailable(zoom)) {
            getZoomChoice().getSelectionModel().select(Integer.toString(zoom));
            PageDisplayer.setZoom(zoom);
            INSTANCE.getDocFileOpened().setZoom(zoom);
        }
        System.out.println(zoom);
    }

    private static boolean isZoomAvailable(int zoom) {
        boolean available = false;
        int i = 0;
        while (i < ZOOMS.length && !available) {
            if (ZOOMS[i] == zoom) {
                available = true;
            }
            i++;
        }
        return available;
    }

    private static ChoiceBox getZoomChoice() {
        return (ChoiceBox) INSTANCE.stage.getScene().lookup("#zoomChoice");
    }
}