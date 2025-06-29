/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package merlijnsmislukkingen.javafxtest;

import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author merlijn
 */
public class Javafxtest extends Application {
// the grid
    private boolean[][] isColored = new boolean[100][100];
    private Rectangle[][] gridVakken = new Rectangle[100][100];
    private int dim = 100;
    private double offset = dim / 2;
    private int cellSize = 980 / dim;
    private int gridMaxOffset = (dim / 2) * cellSize;
    private int rij;
    private int kolom;
    private int sizeside;
    Group gridRectangles;
    // goals
    private int coloredCount = 0;
    // general stats
    int life = 10;
    private int maxlife = 10;
    int whitecoin = 0;
    private double multy = 1;
    private int world = 1;
    private int goal = 100;
    private boolean redsunlocked = false;
    private boolean greenunlocked = false;
    int done = 0;
    private int usize = 1;
    private int uvalueclicked = 0;
    //blue
    double bluecoins = 5000000; // coins
    double newbluecoins;
    double bhealthprice = 10;   // kostprijzen
    double bcoinsprice = 20;
    int bsizeprice = 200;
    int bmultyprice = 1000;
    private int bsize = 1;
    private int bvalue = 1;
    private int bvalueclicked = 0;
    //red
    double redcoins = 0;
    double newredcoins;
    private int rvalue = 1;
    private int rsize = 1;
    private int rvalueclicked = 0;
    double rshieldprice = 100;   // kostprijzen
    double rcoinsprice = 200;
    int rsizeprice = 2000;
    private int rmultyprice = 10000;
    
    //green
    private int gsize = 1;
    double greencoins = 0;
    double newgreencoins;
    private double gvalue=1;
    
    @Override
    public void start(Stage stage) throws Exception {
        StackPane game = new StackPane();
        SettingsPane upgrades = new SettingsPane();
        game.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        Rectangle square1 = new Rectangle(10, 10);
        square1.setFill(Color.BLUE);
        square1.setTranslateY(0);
        square1.setTranslateX(0);
        square1.setTranslateX(-(980 / dim) / 2);
        square1.setTranslateY(-(980 / dim) / 2);
        //algemeen text
        Font textfont = new Font(18);
        Font bijtextfont = new Font(17);
        //text
        Text bluemoney = new Text("Blue coins: "+bluecoins);
        Text bluecopymoney = new Text("Blue coins: "+bluecoins);
        Text newbluemoney = new Text("+ :"+ newbluecoins);
        Text copynewbluemoney = new Text("+ :"+ newbluecoins);
        Text health = new Text("HP is: " + life);
        Text whitemoney = new Text("White coins: "+whitecoin);
        Text copywhitemoney = new Text("White coins: "+whitecoin);
        Text redmoney = new Text("Red coins: "+redcoins);
        Text redcopymoney = new Text("Red coins: "+redcoins);
        Text newredmoney = new Text("+ :"+ newredcoins);
        Text greenmoney = new Text("Green coins: "+greencoins);
        Text greencopymoney = new Text("Green coins: "+greencoins);
        Text newgreenmoney = new Text("+ :"+ newgreencoins);
        Text greencopynewmoney = new Text("+ :"+ newgreencoins);
        Text redcopynewmoney = new Text("+ :"+ newredcoins);
        //textstyle
        bluemoney.setFont(textfont);
        bluemoney.setTranslateX(-250);
        bluemoney.setTranslateY(-475);
        bluecopymoney.setFont(textfont);
        bluecopymoney.setTranslateX(-250);
        bluecopymoney.setTranslateY(-475);
        newbluemoney.setFont(bijtextfont);
        newbluemoney.setTranslateX(-215);
        newbluemoney.setTranslateY(-458);
        copynewbluemoney.setFont(bijtextfont);
        copynewbluemoney.setTranslateX(-215);
        copynewbluemoney.setTranslateY(-458);
        health.setFont(textfont);
        health.setTranslateX(400);
        health.setTranslateY(-475);
        whitemoney.setFont(textfont);
        whitemoney.setTranslateX(-410);
        whitemoney.setTranslateY(-475);
        copywhitemoney.setFont(textfont);
        copywhitemoney.setTranslateX(-410);
        copywhitemoney.setTranslateY(-475);
        copywhitemoney.setFill(Color.WHITE);
        bluecopymoney.setFill(Color.WHITE);
        copynewbluemoney.setFill(Color.WHITE);
        redmoney.setFont(textfont);
        redmoney.setTranslateX(0);
        redmoney.setTranslateY(-475);
        redcopymoney.setFont(textfont);
        redcopymoney.setTranslateX(0);
        redcopymoney.setTranslateY(-475);
        newredmoney.setFont(bijtextfont);
        newredmoney.setTranslateX(0);
        newredmoney.setTranslateY(-458);
        redcopynewmoney.setFont(bijtextfont);
        redcopynewmoney.setTranslateX(0);
        redcopynewmoney.setTranslateY(-458);
        greenmoney.setFont(textfont);
        greenmoney.setTranslateX(200);
        greenmoney.setTranslateY(-475);
        greencopymoney.setFont(textfont);
        greencopymoney.setTranslateX(200);
        greencopymoney.setTranslateY(-475);
        newgreenmoney.setFont(bijtextfont);
        newgreenmoney.setTranslateX(200);
        newgreenmoney.setTranslateY(-458);
        greencopynewmoney.setFont(bijtextfont);
        greencopynewmoney.setTranslateX(200);
        greencopynewmoney.setTranslateY(-458);
        redcopymoney.setFill(Color.WHITE);
        redcopynewmoney.setFill(Color.WHITE);
        greencopymoney.setFill(Color.WHITE);
        greencopynewmoney.setFill(Color.WHITE);
        //algemeenbuttons
        // buttons
        Button unlockreds = new Button("unlock new currency costs: 1");
        Button upgradecoins = new Button("upgrade coins/fill by 1, price: " + bcoinsprice);
        Button upgradesize = new Button("upgrade size by 1 price: " + bsizeprice);
        Button unlockmultiplier = new Button("get "+(multy+0.25)*100+"% bonus coins: "+ numberFormater(bmultyprice));
        Button worldlvl = new Button("Change color and dificulty you are playing current, world: world "+ world);
        Button getshield = new Button("unlock a 5 second shield, price: " + rshieldprice);
        Button upgraderedcoins = new Button("upgrade coins/fill by 1, price: " + rcoinsprice);
        Button upgraderedsize = new Button("upgrade size by 1 price: " + rsizeprice);
        Button upgrademultiplier = new Button("get "+(multy+0.5)*100+"% bonus coins: "+ numberFormater(rmultyprice));
        // buttonsstyle

        unlockreds.setFont(buttonfont);
        unlockreds.setPrefSize(300, 50);
        unlockreds.setStyle("-fx-background-color: white");
        unlockreds.setTranslateX(0);
        unlockreds.setTranslateY(-400);

        upgradecoins.setFont(buttonfont);
        upgradecoins.setPrefSize(300, 70);
        upgradecoins.setStyle("-fx-background-color: #4A90E2;");
        upgradecoins.setTranslateX(-320);
        upgradecoins.setTranslateY(-200);
        upgradesize.setFont(buttonfont);
        upgradesize.setPrefSize(300, 70);
        upgradesize.setStyle("-fx-background-color: #4A90E2;");
        upgradesize.setTranslateX(-320);
        upgradesize.setTranslateY(-100);
        unlockmultiplier.setFont(buttonfont);
        unlockmultiplier.setPrefSize(300, 70);
        unlockmultiplier.setStyle("-fx-background-color: #4A90E2;");
        unlockmultiplier.setTranslateX(-320);
        unlockmultiplier.setTranslateY(0);
        getshield.setFont(buttonfont);
        getshield.setPrefSize(300, 70);
        getshield.setStyle("-fx-background-color: #4A90E2;");
        getshield.setTranslateX(0);
        getshield.setTranslateY(-300);
        upgraderedcoins.setFont(buttonfont);
        upgraderedcoins.setPrefSize(300, 70);
        upgraderedcoins.setStyle("-fx-background-color: #4A90E2;");
        upgraderedcoins.setTranslateX(0);
        upgraderedcoins.setTranslateY(-200);
        upgraderedsize.setFont(buttonfont);
        upgraderedsize.setPrefSize(300, 70);
        upgraderedsize.setStyle("-fx-background-color: #4A90E2;");
        upgraderedsize.setTranslateX(0);
        upgraderedsize.setTranslateY(-100);
        upgrademultiplier.setFont(buttonfont);
        upgrademultiplier.setPrefSize(300, 70);
        upgrademultiplier.setStyle("-fx-background-color: #4A90E2;");
        upgrademultiplier.setTranslateX(0);
        upgrademultiplier.setTranslateY(0);
        worldlvl.setFont(buttonfont);
        worldlvl.setPrefSize(550, 60);
        worldlvl.setTranslateX(0);
        worldlvl.setTranslateY(250);

        gridRectangles = createRectangles(100);
        //getchildren
        game.getChildren().addAll(gridRectangles, square1, bluemoney, health, whitemoney,newbluemoney, redmoney, newredmoney, greenmoney, newgreenmoney);
        upgrades.getChildren().addAll(bluecopymoney, startgame, upgradehealth, upgradecoins, unlockreds, copywhitemoney, upgradesize,unlockmultiplier, copynewbluemoney,worldlvl, redcopymoney, greencopymoney, greencopynewmoney, redcopynewmoney);
        //scene
        Scene mijnscenario = new Scene(game, 980, 980, Color.YELLOW);
        stage.setTitle("First JavaFX game");
        stage.setScene(mijnscenario);
        stage.setX(3000);
        stage.setY(0);
        mijnscenario.getRoot().setFocusTraversable(true);
        mijnscenario.getRoot().requestFocus();
        //events
        mijnscenario.setOnKeyPressed(event -> {
            //kleuren
            if (done == 0) {
                offset = (dim - 1);
                offset = offset / 2;
                rij = getRij(square1.getTranslateY(),usize);
                kolom = getKolom(square1.getTranslateX(), usize);
                if (event.getCode() == KeyCode.UP && square1.getTranslateY() > -440) {
                    square1.setTranslateY(square1.getTranslateY() - ((980 / dim) * usize));
                }
                if (event.getCode() == KeyCode.DOWN && square1.getTranslateY() < 440) {
                    square1.setTranslateY(square1.getTranslateY() + ((980 / dim) * usize));
                }
                if (event.getCode() == KeyCode.LEFT && square1.getTranslateX() > -440) {
                    square1.setTranslateX(square1.getTranslateX() - ((980 / dim) * usize));
                }
                if (event.getCode() == KeyCode.RIGHT && square1.getTranslateX() < 440) {
                    square1.setTranslateX(square1.getTranslateX() + ((980 / dim) * usize));
                }
                //genoeg levens
                if (life < usize * usize * world*world) {
                    if (world == 1) {
                        newbluecoins = (newbluecoins + (((coloredCount * uvalueclicked) * usize) + life)) * multy;
                        bluecoins = bluecoins + newbluecoins;
                        newbluemoney.setText("+ :" + newbluecoins);
                        copynewbluemoney.setText("+ :" + newbluecoins);
                        bluecopymoney.setText("Blue coins: " + numberFormater(bluecoins));
                    } else if (world == 2) {
                        newredcoins = (newredcoins + (((coloredCount * uvalueclicked) * usize) + life)) * multy;
                        redcoins = redcoins + newredcoins;
                        newredmoney.setText("+ :" + newredcoins);
                        redcopynewmoney.setText("+ :" + newredcoins);
                        redcopymoney.setText("Red coins: " + numberFormater(redcoins));
                    } else {
                        newgreencoins = (newgreencoins + (((coloredCount * uvalueclicked) * usize) + life)) * multy;
                        greencoins = greencoins + newgreencoins;
                        newgreenmoney.setText("+ :" + newgreencoins);
                        greencopynewmoney.setText("+ :" + newgreencoins);
                        greencopymoney.setText("Green coins: " + numberFormater(greencoins));
                    }
                    done = 1;
                    coloredCount = 0;
                    mijnscenario.setRoot(upgrades);
                // vullen
                } else {
                    if (gridVakken[rij][kolom].getFill() != square1.getFill()) {
                        if (world == 1) {
                            newbluecoins = newbluecoins + (bsize * bsize) * bvalue;
                            newbluemoney.setText("+ :"+ newbluecoins);
                        }   else if (world == 2){
                            newredcoins = newredcoins + (rsize * rsize) * rvalue;
                            newredmoney.setText("+ :"+ newredcoins);
                        } else {
                            newgreencoins = newgreencoins + (gsize*gsize) * gvalue;
                            newgreenmoney.setText("+ :"+ newgreencoins);
                        }
                        life = life - usize * usize*world*world;
                        gridVakken[rij][kolom].setFill((Color) square1.getFill());
                        gridVakken[rij][kolom].setStroke((Color) square1.getFill());
                        for (int i = 0; i < usize; i++) {
                            for (int j = 0; j < usize; j++) {
                                int r = rij + i;
                                int k = kolom + j;

                                if (r < gridVakken.length && k < gridVakken[0].length) {
                                    if (!isColored[r][k]) {
                                        isColored[r][k] = true;
                                        coloredCount++;
                                    }
                                    gridVakken[r][k].setFill((Color) square1.getFill());
                                    gridVakken[r][k].setStroke((Color) square1.getFill());
                                }
                            }
                        }
                    }
                    //goal behaald
                    if (coloredCount >= goal) {
                        whitecoin++;
                        goal = goal*10;
                        mijnscenario.setRoot(upgrades);
                        copywhitemoney.setText("White coins: "+whitecoin);
                        newbluecoins = newbluecoins*multy;
                        bluecoins = bluecoins+newbluecoins;
                        newbluemoney.setText("+ :"+ newbluecoins);
                        bluecopymoney.setText("Blue coins: "+numberFormater(bluecoins));
                    }
                }
                
                bluemoney.setText("Blue coins: "+numberFormater(bluecoins));
                health.setText("HP is: " + life);
            }
        });
    //buttons
        startgame.setOnAction(play -> {
            game.getChildren().removeAll(gridRectangles, square1, bluemoney, health);
            gridRectangles = createRectangles(100);
            game.getChildren().addAll(gridRectangles, square1, bluemoney, health);
            mijnscenario.setRoot(game);
            life = maxlife;
            coloredCount = 0;
            newbluecoins = 0;
            done = 0;
            if (world == 1) {
                usize = bsize;
            } else if (world == 2) {
                usize = rsize;
            } else {
                usize = gsize;
            }
            square1.setHeight(usize * (980 / dim));
            square1.setWidth(usize * (980 / dim));
            isColored = new boolean[100][100];
            health.setText("HP is: " + life);
            square1.setTranslateX(-(squareGetMid()));
            square1.setTranslateY(-(squareGetMid()));
            bluemoney.setText("Blue coins: "+numberFormater(bluecoins));
            whitemoney.setText("White coins: "+whitecoin);

        });
        upgradehealth.setOnAction(play -> {
            if  (bluecoins >= bhealthprice) {
                bluecoins = bluecoins - bhealthprice;
                bhealthprice = bhealthprice * 1.35;
                bhealthprice = (int) Math.ceil(bhealthprice);
                maxlife = maxlife + 5;
                bluecopymoney.setText("Blue coins: "+numberFormater(bluecoins));
                upgradehealth.setText("upgrade health by 5, price: " + numberFormater(bhealthprice));
            }
            if (maxlife >= 140) {
                upgradehealth.setText("max lvl");
                upgradehealth.setTextFill(Color.WHITE);
                upgradehealth.setStyle("-fx-background-color: Blue;");
                upgradehealth.setDisable(true);
            }
        });
        upgradecoins.setOnAction(play -> {
            if (bluecoins >= bcoinsprice) {
                bluecoins = bluecoins - bcoinsprice;
                bcoinsprice = bcoinsprice * 1.6;
                bcoinsprice = (int) Math.ceil(bcoinsprice);
                bvalue++;
                bluecopymoney.setText("Blue coins: "+numberFormater(bluecoins));
                upgradecoins.setText("upgrade coins/fill by 1, price: " + numberFormater(bcoinsprice));
            }
            if (bvalue >= 20) {
                upgradecoins.setText("max lvl");
                upgradecoins.setTextFill(Color.WHITE);
                upgradecoins.setStyle("-fx-background-color: Blue;");
                upgradecoins.setDisable(true);
            }
        });
        upgradesize.setOnAction(play -> {
            if (bluecoins >= bsizeprice) {
                bluecoins = bluecoins - bsizeprice;
                bsizeprice = bsizeprice * 2;
                bsize++;
                square1.setHeight(usize * (980 / dim));
                square1.setWidth(usize * (980 / dim));
                bluecopymoney.setText("Blue coins: "+numberFormater(bluecoins));
                upgradesize.setText("upgrade size by 1 price: " + numberFormater(bsizeprice));
            }
            if (bsize >= 8) {
                upgradesize.setText("max lvl");
                upgradesize.setTextFill(Color.WHITE);
                upgradesize.setStyle("-fx-background-color: Blue;");
                upgradesize.setDisable(true);
            }
        });
        unlockmultiplier.setOnAction(play -> {
            if (bluecoins >= bmultyprice) {
                bluecoins = bluecoins - bmultyprice;
                bmultyprice = bmultyprice * 7;
                multy+= 0.25;
                bvalueclicked++;
                bluecopymoney.setText("Blue coins: "+numberFormater(bluecoins));
                unlockmultiplier.setText("get "+(multy+0.25)*100+"% coins: "+ numberFormater(bmultyprice));
                if (multy >= 2.5) {
                    unlockmultiplier.setText("max lvl");
                    unlockmultiplier.setTextFill(Color.WHITE);
                    unlockmultiplier.setStyle("-fx-background-color: Blue;");
                    unlockmultiplier.setDisable(true);
                }
            }
        });
        unlockreds.setOnAction(play -> {
            if (whitecoin >= 1) {
                whitecoin--;
                redsunlocked = true;
                copywhitemoney.setText("White coins: "+whitecoin);
                upgrades.getChildren().remove(unlockreds);
                
            }
        });
        
        worldlvl.setOnAction(play -> {
            if (redsunlocked) {
                if (greenunlocked) {
                    if (world == 3) {
                        world = 1;
                        square1.setFill(Color.BLUE);
                        worldlvl.setStyle("-fx-background-color: #4A90E2;");
                        square1.setHeight(bsize * (980 / dim));
                        square1.setWidth(bsize * (980 / dim));
                    } else if (world == 2) {
                        world = 3;
                        square1.setFill(Color.GREEN);
                        worldlvl.setStyle("-fx-background-color: GREEN;");
                        square1.setHeight(gsize * (980 / dim));
                        square1.setWidth(gsize * (980 / dim));
                    } else {
                        world = 2;
                        square1.setFill(Color.RED);
                        worldlvl.setStyle("-fx-background-color: RED;");
                        square1.setHeight(rsize * (980 / dim));
                        square1.setWidth(rsize * (980 / dim));
                    }
                } else {
                    if (world == 2) {
                        world =1;
                        square1.setFill(Color.BLUE);
                        worldlvl.setStyle("-fx-background-color: #4A90E2;");
                        square1.setHeight(bsize * (980 / dim));
                        square1.setWidth(bsize * (980 / dim));
                    } else {
                        world =2;
                        square1.setFill(Color.RED);
                        worldlvl.setStyle("-fx-background-color: RED;");
                        square1.setHeight(rsize * (980 / dim));
                        square1.setWidth(rsize * (980 / dim));
                    }
                }
            worldlvl.setText("Change color and dificulty you are playing, current world: world "+ world);
            }
        });

        stage.show();
    }

    Group createRectangles(int dim) {
        Group gridRectangles = new Group();
        for (int rij = 0; rij < dim; rij++) {
            for (int kolom = 0; kolom < dim; kolom++) {
                Rectangle vak = new Rectangle((980 / dim), (980 / dim));
                vak.setStroke(Color.BLACK); // Gridlijn
                vak.setFill(Color.TRANSPARENT); // Leeg begin
                vak.setTranslateX((kolom - offset) * (980 / dim)); // Van -400 tot +400
                vak.setTranslateY((rij - offset) * (980 / dim));   // Idem
                gridVakken[rij][kolom] = vak;
                gridRectangles.getChildren().add(vak);
            }
        }
        return gridRectangles;
    }

    public String numberFormater(double amount) {
        if (amount < 1000) {
            return String.format("%.1f", amount);
        } else if (amount < 1000000) {
            return String.format("%.1fK", amount / 1000);
        } else if (amount < 1000000000) {
            return String.format("%.1fM", amount / 1000000);
        } else if (amount < 1000000000000L) {
            return String.format("%.1fB", amount / 1000000000);
        } else {
            return String.format("%.1fT", amount / 1000000000000L);
        }
    }

    public double squareGetMid() {
        if (usize % 2 != 0) {
            double tussenstap = -980.0 /dim;
            double mid = tussenstap/2;
            return mid;
        } else {
            return 0;
        }
    }
    public int getRij(double y, int size) {
        if (size % 2 != 0) {
            sizeside = (size - 1) / 2;
            rij = (int) (y / (980 / dim) + offset);
            rij = rij - sizeside;
        } else {
            sizeside = (size - 2) / 2;
            rij = (int) (y / (980 / dim) + offset);
            rij = rij - sizeside;
        }
        return rij;
    }
    public int getKolom(double x, int size) {
        if (size % 2 != 0) {
            sizeside = (size - 1) / 2;
            kolom = (int) (x / (980 / dim) + offset);
            kolom = kolom - sizeside;
        } else {
            sizeside = (size - 2) / 2;
            kolom = (int) (x / (980 / dim) + offset);
            kolom = kolom - sizeside;
        }
        return kolom;
    }
}