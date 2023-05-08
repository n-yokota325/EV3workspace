package game;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import lejos.hardware.lcd.LCD;

/**
 * ログクラス
 * インスタンスを単一にするため、Singletonパターンを採用
 * @author user119
 *
 */
public class Log {
    public static long startTime;
    
    public static void setStartTime() {
        startTime = System.currentTimeMillis();
    }

    // タスクの呼び出し回数
    private int count;
    
    private static Log instance = new Log();
    
    private Game game;
    
    private static List<LogData> logList = new ArrayList<LogData>();
    
    private Log() {

    }
    
    public static Log getInstance() {
        return instance;
    }
    
    public void setGame(Game game) {
        this.game = game;
    }
    
    public void disp() {
        LCD.clear();
        
        switch (game.status) {
        case CALIBRATION_WHITE:
        case CALIBRATION_BLACK:
            dispCalibration();
            break;
        case WAITSTART:
            dispWaitStart();
            break;
        case RUN:
            dispRun();
            break;
        default:
            break;
        }
    }
    
    private void dispCalibration() {
        LCD.drawString("CALIBRATION", 0, 0);
        LCD.drawString("White", 0, 2);
        LCD.drawString(Float.toString(game.course.getWhite()), 11, 2);
        LCD.drawString("Black", 0, 3);
        LCD.drawString(Float.toString(game.course.getBlack()), 11, 3);
        LCD.drawString("Target", 0, 4);
        LCD.drawString(Float.toString(game.course.getTarget()), 11, 4);
        LCD.drawString("Brightness", 0, 5);
        LCD.drawString(Float.toString(game.course.getBrightness()), 11, 5);
    }
    
    private void dispWaitStart() {
        LCD.drawString("WAIT START", 0, 0);
        LCD.drawString("White", 0, 2);
        LCD.drawString(Float.toString(game.course.getWhite()), 11, 2);
        LCD.drawString("Black", 0, 3);
        LCD.drawString(Float.toString(game.course.getBlack()), 11, 3);
        LCD.drawString("Target", 0, 4);
        LCD.drawString(Float.toString(game.course.getTarget()), 11, 4);
        LCD.drawString("Brightness", 0, 5);
        LCD.drawString(Float.toString(game.course.getBrightness()), 11, 5);
    }
    
    private void dispRun() {
        LCD.drawString("RUN", 0, 0);
        LCD.drawString("White", 0, 2);
        LCD.drawString(Float.toString(game.course.getWhite()), 11, 2);
        LCD.drawString("Black", 0, 3);
        LCD.drawString(Float.toString(game.course.getBlack()), 11, 3);
        LCD.drawString("Target", 0, 4);
        LCD.drawString(Float.toString(game.course.getTarget()), 11, 4);
        LCD.drawString("Brightness", 0, 5);
        LCD.drawString(Float.toString(game.course.getBrightness()), 11, 5);
        LCD.drawString("Forward", 0, 6);
        LCD.drawString(Float.toString(game.wheel.getForward()), 11, 6);
        LCD.drawString("Turn", 0, 7);
        LCD.drawString(Float.toString(game.wheel.getTurn()), 11, 7);
    }
    
    public void countUp() {
        count++;
    }
    
    /**
     * 追加する
     */
    public void add() {
        logList.add(new LogData(System.currentTimeMillis()-startTime, game.getStatus(), game.course.getBrightness(),
                game.wheel.getForward(), game.wheel.getTurn(),game.wheel.getLeftSpeed(),game.wheel.getRightSpeed()));
    }
    
    /**
     * ファイルに保存する
     */
    public void write() {
        try{
            StringBuilder sb = new StringBuilder();
            // ヘッダー部
            sb.append("white,black,target\r\n");
            sb.append(Float.toString(game.course.getWhite()));
            sb.append(",");
            sb.append(Float.toString(game.course.getBlack()));
            sb.append(",");
            sb.append(Float.toString(game.course.getTarget()));
            sb.append("\r\n\r\n");
            // レコード部
            sb.append("ms,status,brightness,forward,turn,leftSpeed,rightSpeed\r\n");
            for (LogData data : logList) {
                sb.append(Long.toString(data.getTime()));
                sb.append(",");
                sb.append(data.getStatus().toString());
                sb.append(",");
                sb.append(Float.toString(data.getBrightness()));
                sb.append(",");
                sb.append(Float.toString(data.getForward()));
                sb.append(",");
                sb.append(Float.toString(data.getTurn()));
                sb.append(",");
                sb.append(Float.toString(data.getLeftSpeed()));
                sb.append(",");
                sb.append(Float.toString(data.getRightSpeed()));
                sb.append("\r\n");
            }
            
            File file = new File("log.csv");
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(sb.toString());
            bw.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
