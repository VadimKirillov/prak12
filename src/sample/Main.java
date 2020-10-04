package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;




enum Planet{//контейнер перечисления
    EARTH(6,6.4),MARS(0.64,3.4),UPITER(1900,71);
    private final double mass;
    private final double radius;
    //конструктор планеты

    Planet(double mass, double radius){
        this.mass = mass;
        this.radius = radius;
    }
    //геттеры
    public double getMass() {
        return mass;
    }

    public double getRadius() {
        return radius;
    }
}

public class Main extends Application {

    @Override
    public void start(Stage primaryStage){

        Group group = new Group();
        Scene scene = new Scene(group,250,100);//создание окна





        //массив объектов меню планет
        MenuItem itemsOfMenu[]=new MenuItem[]{
                new MenuItem(Planet.EARTH.toString()),
                new MenuItem(Planet.MARS.toString()),
                new MenuItem(Planet.UPITER.toString())
        };

        Text txt = new Text("");
        txt.setLayoutY(60);//расстояние от верха до текста
        Menu planets = new Menu("Планеты");

        for (MenuItem a: itemsOfMenu) {
            planets.getItems().add(a);
            a.setOnAction(actionEvent -> {
                Planet g=Planet.valueOf(a.getText());
                txt.setText("Планета: " + g.toString() + " Радиус:" + g.getRadius() +" Масса:" + g.getMass());
            });
        }

        MenuBar menu = new MenuBar();//создаём менюбар
        menu.getMenus().add(planets);
        BorderPane menuPane = new BorderPane();
        menuPane.setTop(menu);




        group.getChildren().addAll(menuPane,txt);
        primaryStage.setTitle("Перечисление");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}