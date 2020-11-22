package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.net.URL;

public class FxmlLoader {
    private Pane view;
    public Pane switchPage(String fName){
        try{
            URL fileURL= Main.class.getResource(fName+ ".fxml");
            if(fileURL == null)
                throw new java.io.FileNotFoundException("FXML file not found");
            view = new FXMLLoader().load(fileURL);
        }
        catch (Exception e){
            System.out.println("No Page found");
        }
        return view;
    }
}
