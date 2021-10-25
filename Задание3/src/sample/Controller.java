package sample;

import Model.ActionChain;
import Model.Player;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public Label Mon;
    public ImageView v1;
    public ImageView v2;
    public ImageView v3;
    public ImageView v4;
    public ImageView v5;
    public Label StGame;
    public Label NamePl;
    ActionChain action=null;
    Player player1;
    public void initialize(URL location, ResourceBundle resources) {
            player1=new Player("Player",1);

    }

    public void viewMc(MouseEvent mouseEvent) {
        ImageView view=(ImageView) mouseEvent.getSource();
        if (action == null) return;//если цепочка обработки отсутствует
        if (action.process(player1,view)) init();//продолжить играть и проверить наличия монетки у игрока
        else {//завершить игру, сделав обработку недоступной
            action = null;
            StGame.setText("Игра не активна");
        }

        Mon.setText(player1.getNumber().toString());
    }



    private boolean init() {
        if(! player1.pay(1)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Средств на счете недостаточно, еще монетку плисс!");
            alert.show();
            action=null;
            StGame.setText("Игра не активна");
            return false;
        }
        else return true;
    }



    public void onPay(ActionEvent actionEvent) {
        player1.addNumber(1);
        Mon.setText(player1.getNumber().toString());
    }

    public void onStart(ActionEvent actionEvent) {
            if(!init()) return;//проверка ликвидности
        v1.setImage(new Image("Img/Sunduk.jpg"));//загрузка автомата
        v2.setImage(new Image("Img/Sunduk.jpg"));
        v3.setImage(new Image("Img/Sunduk.jpg"));
        v4.setImage(new Image("Img/Sunduk.jpg"));
        v5.setImage(new Image("Img/Sunduk.jpg"));
        action=new ActionChain();//запуск механизма розыгрыша
        StGame.setText("Игра активна");
        Mon.setText(player1.getNumber().toString());
    }


}
