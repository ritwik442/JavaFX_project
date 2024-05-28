package application;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Main extends Application {
	 public static void main(String[] args) {
	        launch(args);
	    }

	
	

    private DoubleProperty subTotal = new SimpleDoubleProperty(0.0);
    private SimpleStringProperty orderText = new SimpleStringProperty("");

   
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Joe's Deli");

        // Create GridPane for layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);

        // Create labels
        Label eatLabel = new Label("Eat:");
        Label drinkLabel = new Label("Drink:");
        Label billLabel = new Label("Bill:");

        // Create buttons
        Button orderButton = new Button("Order");
        Button cancelButton = new Button("Cancel");
        Button confirmButton = new Button("Confirm");

        // Create text area
        TextArea billTextArea = new TextArea();
        billTextArea.setPrefHeight(100);
        billTextArea.setEditable(false);

        // Create checkboxes for food items
        CheckBox eggSandwichCheckBox = new CheckBox("Egg Sandwich ");
        CheckBox chickenSandwichCheckBox = new CheckBox("Chicken Sandwich");
        CheckBox bagelCheckBox = new CheckBox("Bagel");
        CheckBox potatoSaladCheckBox = new CheckBox("Potato Salad");

        // Create checkboxes for drink items
        RadioButton coffeeCheckBox = new RadioButton("Coffee");
        RadioButton greenTeaCheckBox = new RadioButton("Green Tea ");
        RadioButton blackTeaCheckBox = new RadioButton("Black Tea ");
        RadioButton orangeJuiceCheckBox = new RadioButton("Orange Juice");

        // Place elements in GridPane
        grid.add(eatLabel, 0, 0);
        grid.add(drinkLabel, 0, 2);
        grid.add(billLabel, 0, 3);

        grid.add(eggSandwichCheckBox, 1, 0);
        grid.add(chickenSandwichCheckBox, 1, 1);
        grid.add(bagelCheckBox, 2, 0);
        grid.add(potatoSaladCheckBox, 2, 1);

        grid.add(coffeeCheckBox, 1, 2);
        grid.add(greenTeaCheckBox, 2, 2);
        grid.add(blackTeaCheckBox, 3, 2);
        grid.add(orangeJuiceCheckBox, 4, 2);

        grid.add(orderButton, 5, 0);
        grid.add(cancelButton, 5, 1);
        grid.add(confirmButton, 6, 1);
        grid.add(billTextArea, 1, 3, 4, 1);
        
        

        // Set up event handlers
        orderButton.setOnAction(e -> {
        	String billText = "";
        	
            
                
                if (eggSandwichCheckBox.isSelected()) {
                    billText+="Egg Sandwich"+"\n";
                    subTotal.set(subTotal.get()+7.99);
                }
                if (chickenSandwichCheckBox.isSelected()) {
                	billText+="Chicken Sandwich"+"\n";
                	subTotal.set(subTotal.get()+9.99);
                }
                if (bagelCheckBox.isSelected()) {
                	billText+="Bagel"+"\n";
                	subTotal.set(subTotal.get()+2.50);
                }
                if (potatoSaladCheckBox.isSelected()) {
                	billText+="Potato Salad"+"\n";
                	subTotal.set(subTotal.get()+4.49);
                }
                if (coffeeCheckBox.isSelected()) {
                	billText+="Coffee"+"\n";
                	subTotal.set(subTotal.get()+1.99);
                }
                if (greenTeaCheckBox.isSelected()) {
                	billText+="Green Tea"+"\n";
                	subTotal.set(subTotal.get()+0.99);
                }
                if (blackTeaCheckBox.isSelected()) {
                	billText+="Black Tea"+"\n";
                	subTotal.set(subTotal.get()+1.25);
                }
                if (orangeJuiceCheckBox.isSelected()) {
                	billText+="Orange Juice"+"\n";
                	subTotal.set(subTotal.get()+2.99);
                }

                
                
                billText += "\nSubtotal: $" + String.format("%.2f", subTotal.get());
            
            orderText.set(billText);
            billTextArea.setText(billText);
            
        });
        

        cancelButton.setOnAction(e -> {
            subTotal.set(0.0);
            orderText.set("");
            billTextArea.setText("");
            eggSandwichCheckBox.setSelected(false);
            chickenSandwichCheckBox.setSelected(false);
            bagelCheckBox.setSelected(false);
            potatoSaladCheckBox.setSelected(false);
            coffeeCheckBox.setSelected(false);
            greenTeaCheckBox.setSelected(false);
            blackTeaCheckBox.setSelected(false);
            orangeJuiceCheckBox.setSelected(false);
        });

        confirmButton.setOnAction(e -> {
            billTextArea.setText(orderText.get() + "\nTax (7%): $" + String.format("%.2f", subTotal.get() * 0.07) + "\nTotal: $" + String.format("%.2f", subTotal.get() * 1.07));
            eggSandwichCheckBox.setSelected(false);
            chickenSandwichCheckBox.setSelected(false);
            bagelCheckBox.setSelected(false);
            potatoSaladCheckBox.setSelected(false);
            coffeeCheckBox.setSelected(false);
            greenTeaCheckBox.setSelected(false);
            blackTeaCheckBox.setSelected(false);
            orangeJuiceCheckBox.setSelected(false);
        });

        // Set the scene and show the stage
        Scene scene = new Scene(grid, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}