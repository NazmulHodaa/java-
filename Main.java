 package agecalculator;

import java.time.LocalDate;
import java.time.Period;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    @SuppressWarnings("empty-statement")
    public void start(Stage primaryStage) {
        Text msg = new Text("0 years 0 months 0 days");
        DatePicker dp = new DatePicker();
        Text format = new Text("MM/dd/yyyy");
        dp.setValue(LocalDate.now());
        Button age = new Button();
        age.setText("Calculate");
        age.setOnAction((ActionEvent event) -> {
            Period p = ageCalculator(dp.getValue());
            msg.setText(p.getYears() + " years " + p.getMonths() + " months " + p.getDays() + " days");
        });
        VBox vb = new VBox(5, format, dp, age, msg);
        vb.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vb, 300, 250);
        primaryStage.setTitle("Age Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    Period ageCalculator(LocalDate birthDay) {
        return Period.between(birthDay, LocalDate.now());
    }

    public static void main(String[] args) {
        launch(args);
    }

}
