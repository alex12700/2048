package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.awt.event.ActionEvent;
import java.util.Random;

public class Controller {

    @FXML
    private Rectangle rect1, rect2, rect3, rect4, rect5, rect6, rect7, rect8, rect9, rect10, rect11, rect12, rect13,
            rect14, rect15, rect16;

    @FXML
    private Text text1, text2, text3, text4, text5, text6, text7, text8, text9, text10, text11, text12, text13, text14,
            text15, text16;

    int cells[][] = new int[4][4];

    private void create_new_cells(int[][] x, Text[][] texts, Rectangle[][] rectangles) {
        Random rand = new Random();
        byte brake = 0;
        end:
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                if (x[i][j] == 0) {
                    brake++;
                    byte amount_start = 0;
                    while (amount_start < 1) {
                        int two_start = rand.nextBoolean() ? 2 : 4;
                        int start_positionX = rand.nextInt(4);
                        int start_positionY = rand.nextInt(4);
                        if (x[start_positionX][start_positionY] == 0) {
                            x[start_positionX][start_positionY] = two_start;
                            rectangles[start_positionX][start_positionY].setFill(x[start_positionX][start_positionY] == 2 ?
                                    Color.rgb(255,255,255) : Color.rgb(200,200,200));
                            texts[start_positionX][start_positionY].setText(Integer.toString(two_start));
                            texts[start_positionX][start_positionY].setVisible(true);
                            amount_start++;
                        }
                    }
                    if (brake == 2) break end;
                }
            }
        }
    }

    public void start_game() {
        Rectangle[][] rectangles = {{rect1, rect2, rect3, rect4}, {rect5, rect6, rect7, rect8}, {rect9, rect10, rect11, rect12},
                {rect13, rect14, rect15, rect16}};

        Text[][] texts = {{text1, text2, text3, text4}, {text5, text6, text7, text8}, {text9, text10, text11, text12}, {text13,
                text14, text15, text16}};

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                texts[i][j].setVisible(false);
                rectangles[i][j].setFill(Color.GRAY);
                cells[i][j] = 0;
            }
        }
        create_new_cells(cells, texts, rectangles);
    }

    public void up() {
        Rectangle[][] rectangles = {{rect1, rect2, rect3, rect4}, {rect5, rect6, rect7, rect8}, {rect9, rect10, rect11, rect12},
                {rect13, rect14, rect15, rect16}};

        Text[][] texts = {{text1, text2, text3, text4}, {text5, text6, text7, text8}, {text9, text10, text11, text12}, {text13,
                text14, text15, text16}};

        boolean creation = false;
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 4; i++) {
                for (int k = i + 1; k < 4; k++) {
                    if (cells[k][j] != 0) {
                        if (cells[i][j] == 0) {
                            creation = true;
                            cells[i][j] = cells[k][j];
                            texts[i][j].setText(String.valueOf(cells[i][j]));
                            texts[i][j].setVisible(true);
                            rectangles[i][j].setFill(rectangles[k][j].getFill());
                            cells[k][j] = 0;
                            texts[k][j].setText(String.valueOf(cells[k][j]));
                            texts[k][j].setVisible(false);
                            rectangles[k][j].setFill(Color.GRAY);
                        } else {
                            if (cells[i][j] == cells[k][j]) {
                                creation = true;
                                cells[i][j] += cells[k][j];
                                texts[i][j].setText(String.valueOf(cells[i][j]));
                                texts[i][j].setVisible(true);
                                switch (cells[i][j]){
                                    case 4:     rectangles[i][j].setFill(Color.rgb(200,200,200));break;
                                    case 8:     rectangles[i][j].setFill(Color.rgb(0,255,255));break;
                                    case 16:    rectangles[i][j].setFill(Color.rgb(0,255,0));break;
                                    case 32:    rectangles[i][j].setFill(Color.rgb(0,255,100));break;
                                    case 64:    rectangles[i][j].setFill(Color.rgb(255,0,0));break;
                                    case 128:   rectangles[i][j].setFill(Color.rgb(0,100,255));break;
                                    case 256:   rectangles[i][j].setFill(Color.rgb(255,255,0));break;
                                    case 512:   rectangles[i][j].setFill(Color.rgb(0,0,255));break;
                                    case 1024:  rectangles[i][j].setFill(Color.rgb(255,0,255));break;
                                    case 2048:  rectangles[i][j].setFill(Color.rgb(0,0,0));break;
                                }
                                //        rect1.setFill(Color.rgb(255,255,255));              //2
                                //        rect2.setFill(Color.rgb(200,200,200));              //4
                                //        rect3.setFill(Color.rgb(0,255,255));                //8
                                //        rect4.setFill(Color.rgb(0,255,0));                  //16
                                //        rect5.setFill(Color.rgb(0,255,100));                //32
                                //        rect6.setFill(Color.rgb(255,0,0));                  //64
                                //        rect7.setFill(Color.rgb(0,100,255));                //128
                                //        rect8.setFill(Color.rgb(255,255,0));                //256
                                //        rect9.setFill(Color.rgb(0,0,255));                  //512
                                //        rect10.setFill(Color.rgb(255,0,255));               //1024
                                //        rect11.setFill(Color.rgb(0,0,0));                   //2048
                                cells[k][j] = 0;
                                texts[k][j].setText(String.valueOf(cells[k][j]));
                                texts[k][j].setVisible(false);
                                rectangles[k][j].setFill(Color.GRAY);
                            }
                            break;
                        }
                    }
                }
            }
        }
        if (creation)
            create_new_cells(cells, texts, rectangles);
    }

    public void down() {
        Rectangle[][] rectangles = {{rect1, rect2, rect3, rect4}, {rect5, rect6, rect7, rect8}, {rect9, rect10, rect11, rect12},
                {rect13, rect14, rect15, rect16}};

        Text[][] texts = {{text1, text2, text3, text4}, {text5, text6, text7, text8}, {text9, text10, text11, text12}, {text13,
                text14, text15, text16}};

        boolean creation = false;
        for (int j = 0; j < 4; j++) {
            for (int i = 3; i >= 0; i--) {
                for (int k = i - 1; k >= 0; k--) {
                    if (cells[k][j] != 0) {
                        if (cells[i][j] == 0) {
                            creation = true;
                            cells[i][j] = cells[k][j];
                            texts[i][j].setText(String.valueOf(cells[i][j]));
                            texts[i][j].setVisible(true);
                            cells[k][j] = 0;
                            texts[k][j].setText(String.valueOf(cells[k][j]));
                            texts[k][j].setVisible(false);
                        } else {
                            if (cells[i][j] == cells[k][j]) {
                                creation = true;
                                cells[i][j] += cells[k][j];
                                texts[i][j].setText(String.valueOf(cells[i][j]));
                                texts[i][j].setVisible(true);
                                cells[k][j] = 0;
                                texts[k][j].setText(String.valueOf(cells[k][j]));
                                texts[k][j].setVisible(false);
                            }
                            break;
                        }
                    }
                }
            }
        }
        if (creation)
            create_new_cells(cells, texts, rectangles);
    }

    public void right() {
        Rectangle[][] rectangles = {{rect1, rect2, rect3, rect4}, {rect5, rect6, rect7, rect8}, {rect9, rect10, rect11, rect12},
                {rect13, rect14, rect15, rect16}};

        Text[][] texts = {{text1, text2, text3, text4}, {text5, text6, text7, text8}, {text9, text10, text11, text12}, {text13,
                text14, text15, text16}};

        boolean creation = false;
        for (int i = 0; i < 4; i++) {
            for (int j = 3; j >= 0; j--) {
                for (int k = j - 1; k >= 0; k--) {
                    if (cells[i][k] != 0) {
                        if (cells[i][j] == 0) {
                            creation = true;
                            cells[i][j] = cells[i][k];
                            texts[i][j].setText(String.valueOf(cells[i][j]));
                            texts[i][j].setVisible(true);
                            cells[i][k] = 0;
                            texts[i][k].setText(String.valueOf(cells[i][k]));
                            texts[i][k].setVisible(false);
                        } else {
                            if (cells[i][j] == cells[i][k]) {
                                creation = true;
                                cells[i][j] += cells[i][k];
                                texts[i][j].setText(String.valueOf(cells[i][j]));
                                texts[i][j].setVisible(true);
                                cells[i][k] = 0;
                                texts[i][k].setText(String.valueOf(cells[i][k]));
                                texts[i][k].setVisible(false);
                            }
                            break;
                        }
                    }
                }
            }
        }
        if (creation)
            create_new_cells(cells, texts, rectangles);
    }

    public void left() {
        Rectangle[][] rectangles = {{rect1, rect2, rect3, rect4}, {rect5, rect6, rect7, rect8}, {rect9, rect10, rect11, rect12},
                {rect13, rect14, rect15, rect16}};

        Text[][] texts = {{text1, text2, text3, text4}, {text5, text6, text7, text8}, {text9, text10, text11, text12}, {text13,
                text14, text15, text16}};

        boolean creation = false;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = j + 1; k < 4; k++) {
                    if (cells[i][k] != 0) {
                        if (cells[i][j] == 0) {
                            creation = true;
                            cells[i][j] = cells[i][k];
                            texts[i][j].setText(String.valueOf(cells[i][j]));
                            texts[i][j].setVisible(true);
                            cells[i][k] = 0;
                            texts[i][k].setText(String.valueOf(cells[i][k]));
                            texts[i][k].setVisible(false);
                        } else {
                            if (cells[i][j] == cells[i][k]) {
                                creation = true;
                                cells[i][j] += cells[i][k];
                                texts[i][j].setText(String.valueOf(cells[i][j]));
                                texts[i][j].setVisible(true);
                                cells[i][k] = 0;
                                texts[i][k].setText(String.valueOf(cells[i][k]));
                                texts[i][k].setVisible(false);
                            }
                            break;
                        }
                    }
                }
            }
        }
        if (creation)
            create_new_cells(cells, texts, rectangles);
    }
}

