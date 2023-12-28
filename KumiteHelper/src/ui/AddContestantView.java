package ui;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import logic.KumiteHelperLogic;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class AddContestantView {
	
	KumiteHelperLogic kumiteHelperLogic = KumiteHelperLogic.getInstance();
	MainView mainView = new MainView();

	public Parent getView() {
		BorderPane layout = new BorderPane();
		GridPane lowerHalf = new GridPane();
		BorderPane topHalf = new BorderPane();
		Label upperHalfText = new Label("Create contestant");
		Button backToMainView = new Button("Main view");
		backToMainView.setOnMouseClicked((event) -> {
			layout.getChildren().clear();
			layout.setCenter(mainView.getView());
		});
		
		Label firstName = new Label("First name:");
		TextField firstNameText = new TextField();
		Label lastName = new Label("Last name:");
		TextField lastNameText = new TextField();
		Label gender = new Label("Gender:");
		ObservableList<String> options =
				FXCollections.observableArrayList(
						"m",
						"f"
				);
		final ComboBox genderSelect = new ComboBox(options);
		Label weight = new Label("Weight:");
		TextField weightValue = new TextField();
		Label grade = new Label("Grade:");
		TextField gradeText = new TextField();
		
		Button submitButton = new Button("Submit");
		submitButton.setOnMouseClicked((event) -> {
			kumiteHelperLogic.addContestant(firstNameText.getText(), 
					lastNameText.getText(), 
					genderSelect.getValue().toString().charAt(0), 
					Double.valueOf(weightValue.getText()), 
					gradeText.getText());
			firstNameText.clear();
			lastNameText.clear();
			genderSelect.setValue(null);
			weightValue.clear();
			gradeText.clear();
		});
		
		lowerHalf.add(firstName, 0, 0);
		lowerHalf.add(firstNameText, 0, 1);
		lowerHalf.add(lastName, 0, 2);
		lowerHalf.add(lastNameText, 0, 3);
		lowerHalf.add(gender, 0, 4);
		lowerHalf.add(genderSelect, 0, 5);
		lowerHalf.add(weight, 0, 6);
		lowerHalf.add(weightValue, 0, 7);
		lowerHalf.add(grade, 0, 8);
		lowerHalf.add(gradeText, 0, 9);
		lowerHalf.add(submitButton, 0, 10);
		lowerHalf.setPadding(new Insets(20, 20, 20, 20));
		lowerHalf.setHgap(10);
		lowerHalf.setVgap(10);
		
		topHalf.setLeft(upperHalfText);
		topHalf.setRight(backToMainView);
		
		layout.setTop(topHalf);
		layout.setCenter(lowerHalf);
		
		return layout;
	}
}
