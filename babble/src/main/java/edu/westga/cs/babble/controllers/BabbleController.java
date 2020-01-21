package edu.westga.cs.babble.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import edu.westga.cs.babble.model.EmptyTileBagException;
import edu.westga.cs.babble.model.PlayedWord;
import edu.westga.cs.babble.model.Tile;
import edu.westga.cs.babble.model.TileBag;
import edu.westga.cs.babble.model.TileNotInGroupException;
import edu.westga.cs.babble.model.TileRack;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;

public class BabbleController implements Initializable {
	 
	private TileBag bag;
	private TileRack rack;
	private PlayedWord board;
	private WordDictionary dictionary;
	private StringProperty score; // score string that gets reflected on the score text field
	private int totalScore; // counts running score
	
    @FXML private ListView<Tile> rackListView;
    @FXML private TextArea letterTextArea;
    @FXML private TextField scoreTextField;
   
    /**
     * This method will copy the Strings from the ListView and put them in the text area
     */
    public void listViewLetterSelected() {
    	
    	rackListView.setTooltip(new Tooltip("Click each letter you want in the word"));
        int i = rackListView.getSelectionModel().getSelectedIndex();
        
        
		board.append(rack.tiles().get(i));
		
		try {
			rack.remove(rack.tiles().get(i));
			rackListView.getItems().remove(i);
		}
		catch(TileNotInGroupException tnigex) {
			System.out.println("The alphabet is broken.");
		}
		letterTextArea.setTooltip(new Tooltip("Area where the word is displayed"));
        this.letterTextArea.setText(board.getHand());
    }
    
    
	@Override
	public void initialize(URL resource, ResourceBundle rb) {
		
		rack = new TileRack();
		bag = new TileBag();
		board = new PlayedWord();
		score = new SimpleStringProperty();
		dictionary = new WordDictionary();
		
		
		while(rack.getNumberOfTilesNeeded() > 0) {
			try {
				rack.append(bag.drawTile());
			}
			catch(EmptyTileBagException etbe) {
				System.out.println("GAME OVER!");
				break;
			}
		}
		
		rackListView.getItems().addAll(rack.tiles());
		rackListView.setCellFactory(param -> new ListCell<Tile>() {
		    @Override
		    protected void updateItem(Tile item, boolean empty) {
		        super.updateItem(item, empty);

		        if (empty || item == null) {
		            setText(null);
		        } else {
		            setText(""+item.getLetter());
		            setAccessibleText("" + item.getLetter());
		        }
		    }
		});
	   
		score.bindBidirectional(scoreTextField.textProperty());

		score.set("0");

	     
	}
	
	@FXML
	public void clickPlayWord(ActionEvent event) {
		
		if (dictionary.isValidWord(board.getHand()) == true) {
			int wordPoints = board.getScore();
			totalScore += wordPoints;
			score.set(""+totalScore);
	        
			board.clear();
			
			rackListView.getItems().clear();
			
			while(rack.getNumberOfTilesNeeded() > 0) {
				try {
					rack.append(bag.drawTile());
				}
				catch(EmptyTileBagException etbe) {
					System.out.println("Game over");
					break;
				}
			}
			
			rackListView.getItems().addAll(rack.tiles());
	        
			this.letterTextArea.setText(board.getHand());
	
		} else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Message");
			alert.setHeaderText("Message");
			alert.setContentText("Not a valid word");

			alert.showAndWait();
		}
	}
		
	@FXML
	public void clickReset(ActionEvent event) {
		while(board.tiles().size() > 0) {
			rack.append(board.tiles().remove(0));
		}
		board.clear();
		rackListView.getItems().clear();
		rackListView.getItems().addAll(rack.tiles());
		
		this.letterTextArea.setText(board.getHand());
			
	}


}
	

