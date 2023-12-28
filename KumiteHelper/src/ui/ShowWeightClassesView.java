package ui;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import logic.KumiteHelperLogic;

import java.util.List;

import domain.Contestant;
import domain.WeightClass;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

public class ShowWeightClassesView {
	
	KumiteHelperLogic kumiteHelperLogic = KumiteHelperLogic.getInstance();
	MainView mainView = new MainView();

	public Parent getView() {
		BorderPane layout = new BorderPane();
		BorderPane topHalf = new BorderPane();
		ListView<String> listView = new ListView<String>();
		Button backToMainView = new Button("Main view");
		backToMainView.setOnMouseClicked((event) -> {
			layout.getChildren().clear();
			layout.setCenter(mainView.getView());
		});
		
		topHalf.setRight(backToMainView);
		
		List<WeightClass> weightClassList = kumiteHelperLogic.getAllWeightClasses();
		ObservableList<String>  list = FXCollections.observableArrayList();
		
		for (WeightClass c: weightClassList) {
			list.add(c.toString());
		}
		
		listView.setItems(list);
		
		layout.setTop(topHalf);
		layout.setCenter(listView);
		
		return layout;
	}
}
