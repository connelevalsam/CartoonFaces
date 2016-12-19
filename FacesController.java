package com.NicksFaces.cb;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

public class FacesController implements Initializable {

    @FXML
    Text txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8;
    @FXML
    Text txtDisplay1, txtDisplay2, txtDisplay3, txtDisplay4;
    @FXML
    ImageView img1, img2, img3, img4;

    Image nForehead = new Image("com/NicksFaces/cb/res/nicks/nForehead.png");
    Image nEyes = new Image("com/NicksFaces/cb/res/nicks/nEyes.jpg");
    Image nNose = new Image("com/NicksFaces/cb/res/nicks/nNose.jpg");
    Image nMouth = new Image("com/NicksFaces/cb/res/nicks/nMouth.jpeg");
    Image nJaw = new Image("com/NicksFaces/cb/res/nicks/nJaw.jpeg");
    Image rForehead = new Image("com/NicksFaces/cb/res/nicks/rForehead.jpeg");
    Image rEyes = new Image("com/NicksFaces/cb/res/nicks/rEyes.jpeg");
    Image rNose = new Image("com/NicksFaces/cb/res/nicks/rNose.jpeg");
    Image rMouth = new Image("com/NicksFaces/cb/res/nicks/rMouth.jpg");
    Image rJaw = new Image("com/NicksFaces/cb/res/nicks/rJaw.jpeg");
    Image sForehead = new Image("com/NicksFaces/cb/res/nicks/sForehead.png");
    Image sEyes = new Image("com/NicksFaces/cb/res/nicks/sEyes.jpg");
    Image sNose = new Image("com/NicksFaces/cb/res/nicks/sNose.jpeg");
    Image sMouth = new Image("com/NicksFaces/cb/res/nicks/sMouth.png");
    Image sJaw = new Image("com/NicksFaces/cb/res/nicks/sJaw.jpg");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setDisplay();
    }

    @FXML
    public void dragger(MouseEvent event) {
        /* drag was detected, start drag-and-drop gesture*/
        System.out.println("onDragDetected");

                /* allow MOVE transfer mode */
        Dragboard db1 = txt1.startDragAndDrop(TransferMode.MOVE);
        Dragboard db2 = txt2.startDragAndDrop(TransferMode.MOVE);
        Dragboard db3 = txt3.startDragAndDrop(TransferMode.MOVE);
        Dragboard db4 = txt4.startDragAndDrop(TransferMode.MOVE);
        Dragboard db5 = txt5.startDragAndDrop(TransferMode.MOVE);
        Dragboard db6 = txt6.startDragAndDrop(TransferMode.MOVE);
        Dragboard db7 = txt7.startDragAndDrop(TransferMode.MOVE);
        Dragboard db8 = txt8.startDragAndDrop(TransferMode.MOVE);

        //
        draggerIndicator("Drop Here");
                /* put a string on dragboard */
//1
        ClipboardContent content1 = new ClipboardContent();
        content1.putString(txt1.getText());
        db1.setContent(content1);
//2
        //ClipboardContent content = new ClipboardContent();
        content1.putString(txt2.getText());
        db1.setContent(content1);
//3
        //ClipboardContent content = new ClipboardContent();
        content1.putString(txt3.getText());
        db1.setContent(content1);
//4
        //ClipboardContent content = new ClipboardContent();
        content1.putString(txt4.getText());
        db1.setContent(content1);
//5
        //ClipboardContent content = new ClipboardContent();
        content1.putString(txt5.getText());
        db1.setContent(content1);
//6
        //ClipboardContent content = new ClipboardContent();
        content1.putString(txt6.getText());
        db1.setContent(content1);
//7
        //ClipboardContent content = new ClipboardContent();
        content1.putString(txt7.getText());
        db1.setContent(content1);
//8
        //ClipboardContent content = new ClipboardContent();
        content1.putString(txt8.getText());
        db1.setContent(content1);

        event.consume();
    }
    public void draggerIndicator(String text){
        txtDisplay1.setText(text);
        txtDisplay2.setText(text);
        txtDisplay3.setText(text);
        txtDisplay4.setText(text);
    }

    public void nterDrag(DragEvent event) {
        /* the drag-and-drop gesture entered the target */
        System.out.println("onDragEntered");
                /* show to the user that it is an actual gesture target */
        if ((event.getGestureSource() != txtDisplay1 && event.getDragboard().hasString())
                || (event.getGestureSource() != txtDisplay2 && event.getDragboard().hasString())
                || (event.getGestureSource() != txtDisplay3 && event.getDragboard().hasString())
                || (event.getGestureSource() != txtDisplay4 && event.getDragboard().hasString())) {
            txtDisplay1.setFill(Color.GREEN);
            txtDisplay2.setFill(Color.GREEN);
            txtDisplay3.setFill(Color.GREEN);
            txtDisplay4.setFill(Color.GREEN);
        }

        event.consume();
    }

    public void exitDragger(DragEvent event) {
        /* mouse moved away, remove the graphical cues */
        txtDisplay1.setFill(Color.GRAY);
        txtDisplay2.setFill(Color.GRAY);
        txtDisplay3.setFill(Color.GRAY);
        txtDisplay4.setFill(Color.GRAY);
        //draggerIndicator("");

        event.consume();
    }

    public void dropper(DragEvent event) {
        /* data dropped */
        System.out.println("onDragDropped");
                /* if there is a string data on dragboard, read it and use it */
        Dragboard db = event.getDragboard();
        boolean success = false;
        if (db.hasString()) {
            if (((img1.getImage() == nForehead) && (db.getString() == "Smongebob\nforehead")) ){
                txtDisplay1.setText(db.getString());
                success = true;
            }
            else success = false;

        }
                /* let the source know whether the string was successfully
                 * transferred and used */
        event.setDropCompleted(success);

        event.consume();
    }

    public void donner(DragEvent event) {
        /* the drag-and-drop gesture ended */
        System.out.println("onDragDone");
                /* if the data was successfully moved, clear it */
        if (event.getTransferMode() == TransferMode.MOVE) {
            txt1.setText("");
        }

        event.consume();
    }
    /*public void dropperIndicator(Object obj){
        txtDisplay1.setText(obj);
        txtDisplay2.setText("Drop here");
        txtDisplay3.setText("Drop here");
        txtDisplay4.setText("Drop here");
    }*/

    public void dragOver(DragEvent event) {
        /* data is dragged over the target */
        System.out.println("onDragOver");

                /* accept it only if it is  not dragged from the same node
                 * and if it has a string data */
        if (event.getGestureSource() != txtDisplay1 &&
                event.getDragboard().hasString()) {
                    /* allow for moving */
            event.acceptTransferModes(TransferMode.MOVE);
        }

        event.consume();
    }

    @FXML
    public void setDisplay(){
        Image[] foreHeads = {nForehead, rForehead, sForehead};
        Image[] eyes      = {nEyes, rEyes, sEyes};
        Image[] noses     = {nNose, rNose, sNose};
        Image[] mouths    = {nMouth, rMouth, sMouth};
        Image[] jaws      = {nJaw, rJaw, sJaw};

        final int INITIAL_CAPACITY = 9;
        List<String> txtElements = new ArrayList<>(INITIAL_CAPACITY);
        List<Image> imgElements = new ArrayList<>(INITIAL_CAPACITY);

        txtElements.add("Smongebob\nforehead");
        txtElements.add("Smongebob\neyes");
        txtElements.add("Smongebob\nnose");
        txtElements.add("Smongebob\nmouth");
        txtElements.add("raph\nforehead");
        txtElements.add("raph\neyes");
        txtElements.add("raph\nnose");
        txtElements.add("raph\nmouth");
        txtElements.add("saraph\nforehead");
        txtElements.add("saraph\neyes");
        txtElements.add("saraph\nnose");
        txtElements.add("saraph\nmouth");

        imgElements.add(foreHeads[0]);
        imgElements.add(foreHeads[1]);
        imgElements.add(foreHeads[2]);
        imgElements.add(eyes[0]);
        imgElements.add(eyes[1]);
        imgElements.add(eyes[2]);
        imgElements.add(noses[0]);
        imgElements.add(noses[1]);
        imgElements.add(noses[2]);
        imgElements.add(mouths[0]);
        imgElements.add(mouths[1]);
        imgElements.add(mouths[2]);

        Collections.shuffle(txtElements);
        Collections.shuffle(imgElements);

        Text[] txtOut = {txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8};
        for (int i = 0; i < txtOut.length; i++){
            txtOut[i].setText(txtElements.get(i));
        }
        ImageView[] views = {img1,img2,img3,img4};
        for (int i = 0; i < views.length; i++){
            views[i].setImage(imgElements.get(i));
        }
    }

}
