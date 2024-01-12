package KumiteHelper;

import ui.TextUI;
import ui.MainView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class Main extends Application {

	public static void main(String[] args) {

		launch(Main.class);
	}
	
	@Override
	public void start(Stage window) {
		MainView mainView = new MainView();
		
		BorderPane layout = new BorderPane();
		
		layout.setCenter(mainView.getView());
		
		Scene scene = new Scene(layout, 640, 480);
		
		window.setScene(scene);
		window.show();
	}

}
