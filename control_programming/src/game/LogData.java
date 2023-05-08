package game;

import java.time.Duration;

import game.Game.STATUS;

/**
 * ログデータ（一件分）クラス
 * @author user119
 *
 */
public class LogData {
    long time;
    //private int count;
    private STATUS status;
    private float brightness;
    private float forward;
    private float turn;
    private float leftSpeed;
    

    private float rightSpeed;
    
    public LogData(long time, STATUS status, float brightness, float forward, float turn,float leftSpeed, float rightSpeed) {
        this.time = time;
        this.status = status;
        this.brightness = brightness;
        this.forward = forward;
        this.turn = turn;
        this.leftSpeed = leftSpeed;
        this.rightSpeed = rightSpeed;
    }
    
    public long getTime() {
        return time;
    }
    
    public STATUS getStatus() {
        return status;
    }
    
    public float getBrightness() {
        return brightness;
    }
    
    public float getForward() {
        return forward;
    }
    
    public float getTurn() {
        return turn;
    }
    
    public float getLeftSpeed() {
        return leftSpeed;
    }

    public float getRightSpeed() {
        return rightSpeed;
    }
}
