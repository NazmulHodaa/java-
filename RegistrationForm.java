package registrationform;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RegistrationForm extends Application {

    @Override
    public void start(Stage primaryStage) {
        putOnDatabase();
        Text name = new Text("Full Name");
        TextField namef = new TextField();
        Text roll = new Text("Roll No");
        TextField rollf = new TextField();
        Text depertment = new Text("Depertment");
        TextField depertmentf = new TextField();
        Button save = new Button();
        save.setText("save");
        Button exit = new Button();
        exit.setText("exit");

        HBox nameb = new HBox(15, name, namef);
        nameb.setAlignment(Pos.CENTER);
        HBox rollb = new HBox(29, roll, rollf);
        rollb.setAlignment(Pos.CENTER);
        HBox depertmentb = new HBox(6, depertment, depertmentf);
        depertmentb.setAlignment(Pos.CENTER);
        HBox btnb = new HBox(10, save, exit);
        btnb.setAlignment(Pos.CENTER);
        VBox tvb = new VBox(7, nameb, rollb, depertmentb, btnb);
        tvb.setAlignment(Pos.CENTER);
        VBox vb = new VBox(40, new Text("Registation Form"), tvb);
        vb.setAlignment(Pos.TOP_CENTER);
        Scene scene = new Scene(vb, 300, 250);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    void putOnDatabase() {
        try {
            String url = "jdbc:oracle:thin:@localhost:1632:DEVROOT32";

            //properties for creating connection to Oracle database
            Properties props = new Properties();
            props.setProperty("user", "scott");
            props.setProperty("password", "tiger");

            //creating connection to Oracle database using JDBC
            Connection conn = DriverManager.getConnection(url, props);

            String sql = "select sysdate as current_day from dual";

            //creating PreparedStatement object to execute query
            PreparedStatement preStatement = conn.prepareStatement(sql);

            ResultSet result = preStatement.executeQuery();

            while (result.next()) {
                System.out.println("Current Date from Oracle : " + result.getString("current_day"));
            }
            System.out.println("done");
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

}
