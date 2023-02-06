package hust.soict.itep.aims.screen;

import hust.soict.itep.aims.cart.*;
import hust.soict.itep.aims.media.DigitalVideoDisc;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

import javax.swing.JFrame;

public class CartScreen extends JFrame{
	private Cart cart;
	
	// constructor
	public CartScreen(Cart cart){
		this.cart = cart;
		
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		
		this.setTitle("Cart");
		this.setVisible(true);
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					//create a loader for FXML file
					FXMLLoader loader = new FXMLLoader(getClass().getResource("cart.fxml"));
					
					// create a controller
					CartScreenController controller = new CartScreenController(cart);
					loader.setController(controller);
					
					// load the root node from the FXML file
					Parent root = loader.load();
					
					// create a new scene on panel with root in Panel
					fxPanel.setScene(new Scene(root, 1024, 768));
				}
				catch(IOException e){
					e.printStackTrace();
				}
			}
		});
	}
}
