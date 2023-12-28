package ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import logic.KumiteHelperLogic;

public class AddWeightClassView {
	
	KumiteHelperLogic kumiteHelperLogic = KumiteHelperLogic.getInstance();
	MainView mainView = new MainView();
	
	public Parent getView() {
		BorderPane layout = new BorderPane();
		GridPane lowerHalf = new GridPane();
		BorderPane topHalf = new BorderPane();
		Label upperHalfText = new Label("Create weight class");
		Button backToMainView = new Button("Main view");
		backToMainView.setOnMouseClicked((event) -> {
			layout.getChildren().clear();
			layout.setCenter(mainView.getView());
		});
		
		topHalf.setLeft(upperHalfText);
		topHalf.setRight(backToMainView);
		
		//TODO: make combobox for weight (e.g. under 75, under 70 etc)
		Label maxWeight = new Label("Set max weight:");
		
		ObservableList<Double> weightOptions =
				FXCollections.observableArrayList(
						60.0,
						65.0,
						70.0,
						75.0,
						80.0,
						85.0
				);
		final ComboBox weightSelect = new ComboBox(weightOptions);
		
		ObservableList<String> options =
				FXCollections.observableArrayList(
						"m",
						"f"
				);
		final ComboBox genderSelect = new ComboBox(options);
		
		Label gender = new Label("Set gender for weight class:");
		Button submit = new Button("Submit");
		submit.setOnMouseClicked((event) -> {
			kumiteHelperLogic.addWeightClass((Double) weightSelect.getValue(), 
					genderSelect.getValue().toString().charAt(0));
			weightSelect.setValue(null);
			genderSelect.setValue(null);
		});
		
		lowerHalf.add(maxWeight, 0, 0);
		lowerHalf.add(weightSelect, 0, 1);
		lowerHalf.add(gender, 0, 2);
		lowerHalf.add(genderSelect, 0, 3);
		lowerHalf.add(submit, 0, 4);
		lowerHalf.setPadding(new Insets(20, 20, 20, 20));
		lowerHalf.setVgap(10);
		lowerHalf.setHgap(10);
		
		layout.setTop(topHalf);
		layout.setCenter(lowerHalf);
		
		return layout;
	}
}
