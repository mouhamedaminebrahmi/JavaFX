/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tahwissa.desktop;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Meedoch
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private JFXHamburger hamburger;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private JFXDrawer drawer;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            VBox box = FXMLLoader.load(getClass().getResource("/tahwissa/desktop/DrawerContent.fxml"));
            box.setPrefHeight(anchorPane.getPrefHeight());
            drawer.setPrefHeight(anchorPane.getPrefHeight());
            drawer.setSidePane(box);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(hamburger);
        transition.setRate(-1);

        hamburger.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
            transition.setRate(transition.getRate() * -1);
            transition.play();
            //System.out.println(drawer);
            if (drawer.isShown()) {
                drawer.close();
                drawer.setSidePane(new VBox());
            } else {
                try {
                    VBox box = FXMLLoader.load(getClass().getResource("DrawerContent.fxml"));

                    drawer.setSidePane(box);
                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
                drawer.open();
            }
        });

    }
    
    public void initDrawer() {
         try {
            VBox box = FXMLLoader.load(getClass().getResource("/tahwissa/desktop/DrawerContent.fxml"));
            box.setPrefHeight(anchorPane.getPrefHeight());
            drawer.setPrefHeight(anchorPane.getPrefHeight());
            drawer.setSidePane(box);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(hamburger);
        transition.setRate(-1);

        hamburger.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
            transition.setRate(transition.getRate() * -1);
            transition.play();
            //System.out.println(drawer);
            if (drawer.isShown()) {
                drawer.close();
                drawer.setSidePane(new VBox());
            } else {
                try {
                    VBox box = FXMLLoader.load(getClass().getResource("/tahwissa/desktop/DrawerContent.fxml"));

                    drawer.setSidePane(box);
                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
                drawer.open();
            }
        });

    }

}
