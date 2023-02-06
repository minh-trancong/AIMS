/**
 * This class is created for manipulate data displayed in Cart Screen
 */
package hust.soict.itep.aims.screen;

import hust.soict.itep.aims.cart.Cart;
import hust.soict.itep.aims.media.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
	private Cart cart;
	
	

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;
	
    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private ToggleGroup filterCategory;
    

    @FXML
    private TableView<Media> tblMedia;
    
    public CartScreenController(Cart cart) {
    	super();
    	this.cart = cart;
    }
    
    @FXML
    // this method performs post-processing on the content of the JFrame
    private void initialize() {
    	/**
    	 * 'PropertyValueFactor' will look up the GET<Property> method inside class
    	 * using passed String 
    	 */
    	colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
    	colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
    	colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
    	tblMedia.setItems(this.cart.getItemsOrdered());
    	
    	// updating buttons based on selected item in tableview
    	btnPlay.setVisible(false);
    	btnRemove.setVisible(false);
    	
    	tblMedia.getSelectionModel().selectedItemProperty().addListener(
    			new ChangeListener<Media>() {
    				@Override
    				public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
    					if(newValue!= null) {
    						updateButtonBar(newValue);
    					}
    				}
    			}
    			);
    }
    
    void updateButtonBar(Media media) {
    	btnRemove.setVisible(true);
    	if(media instanceof Playable) {
    		btnPlay.setVisible(true);
    	}
    	else {
    		btnPlay.setVisible(false);
    	}
    }
    @FXML
    void btnPlayPressed(ActionEvent event) {
    	
    }
   
    @FXML
    void btnRemovePressed(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	cart.removeMedia(media);
    	tblMedia.setItems(this.cart.getItemsOrdered());
    }
}
