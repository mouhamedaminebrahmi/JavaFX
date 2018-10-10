/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tahwissa.desktop;

import com.jfoenix.controls.JFXButton;
import entity.email;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import static util.Notification.createNotification;

/**
 *
 * @author Meedoch
 */
public class DrawerController implements Initializable {

    @FXML
    private VBox box;

    @FXML
    private JFXButton boutique;

    @FXML
    private JFXButton evenements;

    @FXML
    private JFXButton publications;

    @FXML
    private JFXButton membre;

    List<Node> boutiqueSubMenu = new ArrayList<Node>();
    List<Node> evenementsSubMenu = new ArrayList<Node>();
    List<Node> publicationsSubMenu = new ArrayList<Node>();
   
    
    @FXML
    private JFXButton contact;
    @FXML
    private JFXButton contact1;

    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        JFXButton test = new JFXButton("test");
        VBox boxx = new VBox();
        initializeBoutiqueMenu();
        initializeEventMenu();
        initializePubMenu();
        contact.addEventHandler(MouseEvent.MOUSE_CLICKED, (ev) -> {
                    goTo(ev, "/tahwissa/desktop/consulterPublication/email.fxml");
               
            
        });
        
        contact1.addEventHandler(MouseEvent.MOUSE_CLICKED, (ev) -> {
                    goTo(ev, "/tahwissa/desktop/consulterPublication/sms.fxml");
               
            
        });
        
    }

    public void initializeBoutiqueMenu() {
        boutique.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
            if (boutique.getAccessibleText().equals("no")) {
                JFXButton consulter = new JFXButton("Consulter");
                JFXButton vendre = new JFXButton("Vendre");
                JFXButton achats = new JFXButton("Achats");
                Separator sp1 = new Separator(Orientation.HORIZONTAL);
                Separator sp2 = new Separator(Orientation.HORIZONTAL);
                Separator sp3 = new Separator(Orientation.HORIZONTAL);
                List<Node> boxChildren = box.getChildren();
                boxChildren.add(boxChildren.indexOf(boutique) + 2, consulter);
                boxChildren.add(boxChildren.indexOf(consulter) + 1, sp1);
                boxChildren.add(boxChildren.indexOf(consulter) + 2, vendre);
                boxChildren.add(boxChildren.indexOf(vendre) + 1, sp2);
                boxChildren.add(boxChildren.indexOf(vendre) + 2, achats);
                boxChildren.add(boxChildren.indexOf(achats) + 1, sp3);
                boutiqueSubMenu.add(consulter);
                boutiqueSubMenu.add(vendre);
                boutiqueSubMenu.add(achats);
                boutiqueSubMenu.add(sp1);
                boutiqueSubMenu.add(sp2);
                boutiqueSubMenu.add(sp3);
                consulter.addEventHandler(MouseEvent.MOUSE_CLICKED, (ev) -> {
                    createNotification("test", "test");
                });
                vendre.addEventHandler(MouseEvent.MOUSE_CLICKED, (ev) -> {
                    System.out.println("Vendre un article");
                });
                achats.addEventHandler(MouseEvent.MOUSE_CLICKED, (ev) -> {
                    System.out.println("Mes achats");
                });
                boutique.setAccessibleText("yes");
            } else {
                boutiqueSubMenu.forEach((t) -> {
                    box.getChildren().remove(t);
                });
                boutiqueSubMenu = new ArrayList<Node>();
                boutique.setAccessibleText("no");
            }
        });
    }

    public void initializeEventMenu() {
        evenements.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
            if (evenements.getAccessibleText().equals("no")) {
                JFXButton consulter = new JFXButton("Consulter");
                JFXButton organiser = new JFXButton("Organiser");
                JFXButton myevents = new JFXButton("Mes évènements");
                Separator sp1 = new Separator(Orientation.HORIZONTAL);
                Separator sp2 = new Separator(Orientation.HORIZONTAL);
                Separator sp3 = new Separator(Orientation.HORIZONTAL);
                List<Node> boxChildren = box.getChildren();
                boxChildren.add(boxChildren.indexOf(evenements) + 2, consulter);
                boxChildren.add(boxChildren.indexOf(consulter) + 1, sp1);
                boxChildren.add(boxChildren.indexOf(consulter) + 2, organiser);
                boxChildren.add(boxChildren.indexOf(organiser) + 1, sp2);
                boxChildren.add(boxChildren.indexOf(organiser) + 2, myevents);
                boxChildren.add(boxChildren.indexOf(myevents) + 1, sp3);
                consulter.addEventHandler(MouseEvent.MOUSE_CLICKED, (ev) -> {
                    goTo(ev, "/tahwissa/desktop/consulterevents/View.fxml");
                });
                organiser.addEventHandler(MouseEvent.MOUSE_CLICKED, (ev) -> {
                    goTo(ev, "/tahwissa/desktop/organiser/View.fxml");
                });
                myevents.addEventHandler(MouseEvent.MOUSE_CLICKED, (ev) -> {
                    goTo(ev, "/tahwissa/desktop/myevents/View.fxml");
                });
                evenementsSubMenu.add(consulter);
                evenementsSubMenu.add(organiser);
                evenementsSubMenu.add(myevents);
                evenementsSubMenu.add(sp1);
                evenementsSubMenu.add(sp2);
                evenementsSubMenu.add(sp3);
                evenements.setAccessibleText("yes");
            } else {
                evenementsSubMenu.forEach((t) -> {
                    box.getChildren().remove(t);
                });
                evenementsSubMenu = new ArrayList<Node>();
                evenements.setAccessibleText("no");
            }
        });
    }

    public void initializePubMenu() {
        publications.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
            if (publications.getAccessibleText().equals("no")) {
                JFXButton consulter = new JFXButton("Consulter");
                JFXButton partager = new JFXButton("Partager");
                JFXButton mypubs = new JFXButton("Mes publications");
                Separator sp1 = new Separator(Orientation.HORIZONTAL);
                Separator sp2 = new Separator(Orientation.HORIZONTAL);
                Separator sp3 = new Separator(Orientation.HORIZONTAL);
                List<Node> boxChildren = box.getChildren();
                boxChildren.add(boxChildren.indexOf(publications) + 2, consulter);
                boxChildren.add(boxChildren.indexOf(consulter) + 1, sp1);
                boxChildren.add(boxChildren.indexOf(consulter) + 2, partager);
                boxChildren.add(boxChildren.indexOf(partager) + 1, sp2);
                boxChildren.add(boxChildren.indexOf(partager) + 2, mypubs);
                boxChildren.add(boxChildren.indexOf(mypubs) + 1, sp3);
                publicationsSubMenu.add(consulter);
                publicationsSubMenu.add(partager);
                publicationsSubMenu.add(mypubs);
                publicationsSubMenu.add(sp1);
                publicationsSubMenu.add(sp2);
                publicationsSubMenu.add(sp3);
                publications.setAccessibleText("yes");
                consulter.addEventHandler(MouseEvent.MOUSE_CLICKED, (ev) -> {
                    goTo(ev, "/tahwissa/desktop/consulterPublication/MainPublications.fxml");
                });
                partager.addEventHandler(MouseEvent.MOUSE_CLICKED, (ev) -> {
                    goTo(ev, "/tahwissa/desktop/consulterPublication/NewPublication.fxml");
                });
                mypubs.addEventHandler(MouseEvent.MOUSE_CLICKED, (ev) -> {
                    goTo(ev, "/tahwissa/desktop/consulterPublication/MainPublications.fxml");
                });
            } else {
                publicationsSubMenu.forEach((t) -> {
                    box.getChildren().remove(t);
                });
                publicationsSubMenu = new ArrayList<Node>();
                publications.setAccessibleText("no");
            }
        });
    }
    
   

   
    public void goTo(MouseEvent ev, String location) {
        try {

            Parent test = FXMLLoader.load(getClass().getResource(location));
            StackPane splashScreen = FXMLLoader.load(getClass().getResource("/tahwissa/desktop/splashScreen.fxml"));
            

            if (test instanceof Pane) {
                Pane p = (Pane) test;
                splashScreen.setPrefSize(p.getPrefWidth(), p.getPrefHeight());
                ImageView bg = (ImageView) splashScreen.getChildren().get(0);
                bg.setFitWidth(p.getPrefWidth()); bg.setFitHeight(p.getPrefHeight());
            } else {
                ScrollPane p = (ScrollPane) test;
                splashScreen.setPrefSize(p.getPrefWidth(), p.getPrefHeight());
                ImageView bg = (ImageView) splashScreen.getChildren().get(0);
                bg.setFitWidth(p.getPrefWidth()); bg.setFitHeight(p.getPrefHeight());
            }
            
            splashScreen.setAlignment(Pos.CENTER);
            Node node = (Node) ev.getSource();
            Scene scenee = new Scene(splashScreen);
            Stage stage = (Stage) node.getScene().getWindow();
            stage.setScene(scenee);

            FadeTransition ft = new FadeTransition(Duration.millis(1500), splashScreen.getChildren().get(1));
            ft.setFromValue(1.0);
            ft.setToValue(0);
            ft.setCycleCount(1);
            ft.setAutoReverse(true);

            FadeTransition ft2 = new FadeTransition(Duration.millis(1500),  splashScreen.getChildren().get(1));
            ft2.setFromValue(0);
            ft2.setToValue(1);
            ft2.setCycleCount(1);
            ft2.setAutoReverse(true);
            ft.setOnFinished((event) -> {
                ft2.play();
            });
            ft2.setOnFinished((event) -> {

                Scene scene = new Scene(test);

                stage.setScene(scene);

            });
            ft.play();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void contactbtn(ActionEvent event) {
    }

    @FXML
    private void contactsms(ActionEvent event) {
    }


}
