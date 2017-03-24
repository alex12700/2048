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
        end: for (int i = 0; i < x.length; i++) {
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
                            //rectangles[start_positionX][start_positionY].setVisible(true);
                            rectangles[start_positionX][start_positionY].setFill(x[start_positionX][start_positionY]==2?Color.BEIGE:Color.BLUE);
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
                rectangles[i][j].setFill(Color.WHITE);
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

