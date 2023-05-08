package ev3_10_touch_exercises;

import ev3Sensor.TouchSensor;
import ev3Sensor.EV3SensorMode;
import lejos.hardware.port.SensorPort;
import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;

public class Touch_exercises {
    
    // タッチセンサーを作成
    static TouchSensor s1Touch = new TouchSensor(SensorPort.S1, EV3SensorMode.TOUCHMODE); 
    static TouchSensor s2Touch = new TouchSensor(SensorPort.S2, EV3SensorMode.TOUCHMODE);
    
    public static void main(String[] args) {
        float s1Value;
        float s2Value;
        
        while (true) {
            // センサーの値を取得
            s1Value = s1Touch.getValue();
            s2Value = s2Touch.getValue();
            
            // センサーの状態を表示
            if (s1Value == 1 && s2Value == 1) {
                LCD.drawString("On", 1, 1);
            } else {
                LCD.clear();
            }
            
            // 0.2秒待機
            Delay.msDelay(200);
        }
    }
}
