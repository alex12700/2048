package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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

    @FXML
    public void start_game() {
        Rectangle[][] rectangles = {{rect1, rect2, rect3, rect4}, {rect5, rect6, rect7, rect8}, {rect9, rect10, rect11, rect12},
                {rect13, rect14, rect15, rect16}};

        Text[][] texts = {{text1, text2, text3, text4}, {text5, text6, text7, text8}, {text9, text10, text11, text12}, {text13,
                text14, text15, text16}};
        Random rand = new Random();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                texts[i][j].setVisible(false);
                cells[i][j] = 0;
            }
        }
        for (int i = 0; i < 2; i++) {
            int two_start = rand.nextBoolean() ? 2 : 4;
            int start_positionX = rand.nextInt(4);
            int start_positionY = rand.nextInt(4);
            cells[start_positionX][start_positionY] = two_start;
            texts[start_positionX][start_positionY].setText(Integer.toString(two_start));
            texts[start_positionX][start_positionY].setVisible(true);
        }
    }

    public void up() {
        Rectangle[][] rectangles = {{rect1, rect2, rect3, rect4}, {rect5, rect6, rect7, rect8}, {rect9, rect10, rect11, rect12},
                {rect13, rect14, rect15, rect16}};

        Text[][] texts = {{text1, text2, text3, text4}, {text5, text6, text7, text8}, {text9, text10, text11, text12}, {text13,
                text14, text15, text16}};

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                cells[0][j] = cells[i][j];
                texts[i][j].setText(String.valueOf(cells[i][j]));
                texts[i][j].setVisible(true);
            }
        }

        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 4; i++) {
                for (int k = i + 1; k < 4; k++) {
                    if (cells[k][j] != 0) {
                        if (cells[i][j] == 0) {
                            cells[i][j] = cells[k][j];
                            cells[k][j] = 0;
                        } else {
                            if (cells[i][j] == cells[k][j]) {
                                cells[i][j] += cells[k][j];
                                cells[k][j] = 0;
                            }
                            break;
                        }
                    }
                }
            }
        }
    }
}

