package laskin;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.util.*;

public class Nollaa extends Komento {
    private TextField tuloskentta;
    private TextField syotekentta;
    private Button nollaa;
    private Button undo;
    private Sovelluslogiikka sovellus;
    private int vanhaArvo;

    public Nollaa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovellus = sovellus;
        this.vanhaArvo = 0;
    }

    @Override
    public void suorita() {
        this.vanhaArvo = Integer.parseInt(tuloskentta.getText());

        sovellus.nollaa();

        syotekentta.setText("");
        tuloskentta.setText("" + 0);  
    }  

    @Override
    public void peru() {
        syotekentta.setText("");
        tuloskentta.setText("" + vanhaArvo);  
    }
}