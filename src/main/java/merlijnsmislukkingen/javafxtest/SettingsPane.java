package merlijnsmislukkingen.javafxtest;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author merlijn
 */
public class SettingsPane extends StackPane {

    private Javafxtest hoofdklasse;
    Button startgame;
    Button upgradehealth;
    final Font buttonfont = new Font(16);

    public SettingsPane(Javafxtest hoofd) {
        super();
        this.hoofdklasse = hoofd;
        createButtons();
        Text bluemoney = new Text("Blue coins: " + hoofd.bluecoins);
        Text bluecopymoney = new Text("Blue coins: " + hoofd.bluecoins);
        Text newbluemoney = new Text("+ :" + hoofd.newbluecoins);
        Text copynewbluemoney = new Text("+ :" + hoofd.newbluecoins);
        Text health = new Text("HP is: " + hoofd.life);
        Text whitemoney = new Text("White coins: " + hoofd.whitecoin);
        Text copywhitemoney = new Text("White coins: " + hoofd.whitecoin);
        Text redmoney = new Text("Red coins: " + hoofd.redcoins);
        Text redcopymoney = new Text("Red coins: " + hoofd.redcoins);
        Text newredmoney = new Text("+ :" + hoofd.newredcoins);
        Text greenmoney = new Text("Green coins: " + hoofd.greencoins);
        Text greencopymoney = new Text("Green coins: " + hoofd.greencoins);
        Text newgreenmoney = new Text("+ :" + hoofd.newgreencoins);
        Text greencopynewmoney = new Text("+ :" + hoofd.newgreencoins);
        Text redcopynewmoney = new Text("+ :" + hoofd.newredcoins);

        this.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        this.getChildren().addAll(bluecopymoney, startgame, upgradehealth, upgradecoins, unlockreds, copywhitemoney, upgradesize, unlockmultiplier, copynewbluemoney, worldlvl, redcopymoney, greencopymoney, greencopynewmoney, redcopynewmoney);

    }

    private void createButtons() {
        startgame = new Button("Play again");
        startgame.setFont(new Font(40));
        startgame.setPrefSize(400,100);
        startgame.setTranslateX(0);
        startgame.setTranslateY(360);
        
        upgradehealth = new Button("upgrade health by 5, price: " + hoofdklasse.bhealthprice);
        upgradehealth.setFont(buttonfont);
        upgradehealth.setPrefSize(300, 70);
        upgradehealth.setStyle("-fx-background-color: #4A90E2;");
        upgradehealth.setTranslateX(-320);
        upgradehealth.setTranslateY(-300);
        
    }
    
}
