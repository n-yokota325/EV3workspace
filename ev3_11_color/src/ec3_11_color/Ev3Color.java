package ec3_11_color;

import lejos.hardware.port.MotorPort;
import ev3Sensor.ColorSensor;
import ev3Sensor.EV3SensorMode;
import lejos.hardware.port.SensorPort;
import lejos.utility.Delay;

public class Ev3Color {
    
    // タンクを作成
    static Tank tank = new Tank(MotorPort.B, MotorPort.C);
    // カラーセンサーを作成（反射光モード）
    static ColorSensor color = new ColorSensor(SensorPort.S3, EV3SensorMode.REFLECTMODE);

    public static void main(String[] args) {
        float value = 1;
        
        tank.move(300, 300);    //　前進
        
        // 黒い線を見つけるまで繰り返す
        while (value >= 0.4) {
            // センサーの値を取得
            value = color.getValue();
            
            // 0.1秒待機
            Delay.msDelay(100);
        }

        tank.stop(true, true);  // 停止
    }

}
