package ev3_14_p_trace;

import lejos.hardware.port.MotorPort;
import ev3Sensor.ColorSensor;
import ev3Sensor.EV3SensorMode;
import lejos.hardware.port.SensorPort;

public class Ev3PTrace {
    
    // タンクを作成
    static Tank tank = new Tank(MotorPort.B, MotorPort.C);
    // カラーセンサーを作成（反射光モード）
    static ColorSensor color = new ColorSensor(SensorPort.S3, EV3SensorMode.REFLECTMODE);

    public static void main(String[] args) {
        float center = 0.35f;   // 目標
        float kp = 0.75f;       // ゲイン
        float mv;               // 操作量
        float mSp = 300;        // 基本のモータースピード
        float lSpeed, rSpeed;   // 左右のモータースピード
        
        while (true) {
            // 操作量を計算
            // 比例ゲイン * (目標値 - 現在値) * 100
            mv = kp * (center - color.getValue());
            
            // 操作量から左右それぞれのモータースピードを計算
            if (mv == 0) {
                lSpeed = mSp;
                rSpeed = mSp;
            } else if (mv > 0) {
                lSpeed = mSp;
                rSpeed = mSp - (mSp * Math.abs(mv) * 2);
            } else {
                lSpeed = mSp - (mSp * Math.abs(mv) * 2);
                rSpeed = mSp;
            }
            
            // モーターを動かす
            tank.move((int)lSpeed, (int)rSpeed);
        }
    }

}
