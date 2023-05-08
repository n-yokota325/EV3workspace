package ev3_12_us;

import lejos.hardware.port.MotorPort;
import ev3Sensor.UltraSonicSensor;
import ev3Sensor.EV3SensorMode;
import lejos.hardware.port.SensorPort;
import lejos.utility.Delay;

public class Ev3Us {
    
    // タンクを作成
    static Tank tank = new Tank(MotorPort.B, MotorPort.C);
    // 超音波センサーを作成
    static UltraSonicSensor us = new UltraSonicSensor(SensorPort.S4, EV3SensorMode.DISTANCEMODE);

    public static void main(String[] args) {
        float value = 1;
        
        tank.move(300, 300);    // 前進
        
        // 障害物を見つけるまで繰り返す
        while (value >= 0.2) {
            // センサーの値を取得
            value = us.getValue();
            
            // 0.1秒待機
            Delay.msDelay(100);
        }

        tank.stop(true, true);  //　停止
    }

}
