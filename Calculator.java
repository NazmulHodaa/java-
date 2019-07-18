package calculator;

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

public class Calculator extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Text format = new Text("MM/dd/yyyy");
        DatePicker dp = new DatePicker();
        dp.setValue(LocalDate.now());
        Button btn = new Button();
        btn.setText("Calculate");
        Text msg = new Text("0 years 0 months 0 days");
        btn.setOnAction((ActionEvent event) -> {
            LocalDate birthday = dp.getValue();
            String str = calculate(birthday);
            msg.setText(str);
        });
        VBox vb = new VBox(10, format, dp, btn, msg);
        vb.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(vb, 300, 250);
        
        primaryStage.setTitle("Age Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    String calculate(LocalDate birthday) {
        Period p = Period.between(birthday, LocalDate.now());
        return p.getYears() + " years " + p.getMonths() + " months " + p.getDays() + " days";
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
