package it.polito.tdp.alien;

/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */



import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	
	AlienDictionary ad = new AlienDictionary ();
	
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField txtWord;
    @FXML
    private TextArea txtResult;
    @FXML
    private Button btnTranslate;
    @FXML
    private Button btnReset;
        
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnTranslate != null : "fx:id=\"bntTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";
    	
    }
  
    
    @FXML
    void doTranslate(ActionEvent event) {
    	
    	String[] s =  txtWord.getText().toLowerCase().split(" ");
    	
    	for (String str : s)
    		if (str.matches("[a-zA-Z]*") == false) {
    			this.txtResult.setText("Formato dati non ammesso!");
    			return ;
    		}
            
    	if (s.length == 1) {
    		this.txtResult.clear();
    		String result = ad.translateWord(s[0]);
    		if (result == null) {
        		this.txtResult.setText("Traduzione non presente: inserire una traduzione!");
        		return ;
    		}
    		
    		this.txtResult.setText(result);
    	}
    	else if (s.length == 2) {
    		ad.addWord(s[0], s[1]); 
    		this.txtResult.setText("Traduzione inserita nel dizionario!");
    		this.txtWord.clear();
    	}
    	
    	txtWord.clear();
    }
    
    
    @FXML
    void doReset(ActionEvent event) {
    	ad.getDictionary().clear();
    	txtResult.clear();
    }
    
}
