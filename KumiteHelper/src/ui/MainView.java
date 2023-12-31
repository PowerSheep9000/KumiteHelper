package ui;

import ui.AddContestantView;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import logic.KumiteHelperLogic;

import java.util.ArrayList;
import java.util.List;

import domain.WeightClass;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainView {
	KumiteHelperLogic kumiteHelperLogic = KumiteHelperLogic.getInstance();

	public Parent getView() {
		AddContestantView addContestantView = new AddContestantView();
		ShowContestantView showContestantsView = new ShowContestantView();
		AddWeightClassView addWeightClassView = new AddWeightClassView();
		ShowWeightClassesView showWeightClassesView = new ShowWeightClassesView();
		BorderPane layout = new BorderPane();
		
		VBox menu = new VBox();
		menu.setPadding(new Insets(10, 10, 10, 10));
		menu.setSpacing(10);
		
		Label welcomeText = new Label("Welcome to the Kumite Helper!");
		Label versionText = new Label("Kumite Helper v 0.5");
		Button addContestant = new Button("Add contestant");
		Button addWeightClass = new Button("Add weight class");
		Button showContestants = new Button("Show all contestants");
		Button showWeightClasses = new Button("Show all weight classes");
		Button addContestants = new Button("Add contestants to weight class");
		
		addContestant.setOnMouseClicked((event) -> {
			layout.getChildren().clear();
			layout.setCenter(addContestantView.getView());
		});
		
		showContestants.setOnMouseClicked((event) -> {
			layout.getChildren().clear();
			layout.setCenter(showContestantsView.getView());
		});
		
		addWeightClass.setOnMouseClicked((event) -> {
			layout.getChildren().clear();
			layout.setCenter(addWeightClassView.getView());
		});
		
		showWeightClasses.setOnMouseClicked((event) -> {
			layout.getChildren().clear();
			layout.setCenter(showWeightClassesView.getView());
		});

		addContestants.setOnMouseClicked((event) -> {
			List<WeightClass> toAddContestantsTo = kumiteHelperLogic.getAllWeightClasses();

			for (WeightClass w: toAddContestantsTo) {
				kumiteHelperLogic.addContestantsToWeightClass(w, w.getGenderOfContestants());
			}
		});
		
		menu.getChildren().addAll(welcomeText, 
				addContestant, 
				addWeightClass, 
				showContestants, 
				showWeightClasses,
				addContestants);
		
		layout.setBottom(versionText);
		layout.setCenter(menu);;
		
		return layout;
	}
}
