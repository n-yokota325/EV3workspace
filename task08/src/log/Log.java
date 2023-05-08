package log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import body.Body;
import game.Game;
import lejos.hardware.lcd.LCD;

/**
 * ���O�N���X
 * @author �㓡 ����
 *
 */
public class Log {
    /** ���Z */
    Game game;
    
    /** ���O�f�[�^���X�g */
    private List<LogData> logList;

    /**
     * �R���X�g���N�^
     */
    public Log(Game game) {
        this.game = game;
        logList = new ArrayList<LogData>();
    }

    /**
     *�@���s����
     */
    public void run() {
        draw();
        add();
    }

    /**
     * �ǉ�����
     */
    private void add() {
        logList.add(
                new LogData(game.getCount(), game.toString(),
                        Body.measure.getHue(), Body.measure.getSaturation(), Body.measure.getValue(),
                        Body.measure.getLeftRotationSpeed(), Body.measure.getRightRotationSpeed()));
    }

    /**
     * LCD�ɕ`�悷��
     */
    private void draw() {
        LCD.clear();
        LCD.drawString(game.toString(), 0, 0);
        LCD.drawString("White", 0, 2);
        LCD.drawString(Float.toString(Body.measure.getWhite()), 11, 2);
        LCD.drawString("Black", 0, 3);
        LCD.drawString(Float.toString(Body.measure.getBlack()), 11, 3);
        LCD.drawString("Target", 0, 4);
        LCD.drawString(Float.toString(Body.measure.getTarget()), 11, 4);
        LCD.drawString("Value", 0, 5);
        LCD.drawString(Float.toString(Body.measure.getValue()), 11, 5);
    }

    /**
     * �t�@�C���ɕۑ�����
     */
    public void write() {
        try {
            StringBuilder sb = new StringBuilder();

            sb.append("count,status,hue,saturation,value,leftRotationSpeed,rightRotationSpeed\r\n");
            for (LogData data : logList) {
                sb.append(data.toString());
            }

            File file = new File("log.csv");
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(sb.toString());
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
