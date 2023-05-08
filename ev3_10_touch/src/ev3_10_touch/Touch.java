package ev3_10_touch;

import ev3Sensor.TouchSensor;
import ev3Sensor.EV3SensorMode;
import lejos.hardware.port.SensorPort;
import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;

public class Touch {
    
    // タッチセンサーを作成
    static TouchSensor touch = new TouchSensor(SensorPort.S1, EV3SensorMode.TOUCHMODE); 

    public static void main(String[] args) {
        float value;
        
        while (true) {
            // センサーの値を取得
            value = touch.getValue();
            
            // センサーの状態を表示
            if (value == 1) {
                LCD.drawString("On", 1, 1);
            } else {
                LCD.clear();
            }
            
            // 0.2秒待機
            Delay.msDelay(200);
        }
    }
}
