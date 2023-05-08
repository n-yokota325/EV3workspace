package ev3_03_drive;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.utility.Delay;

public class Ev3Drive {

    //　Lモーターの変数を用意
    static EV3LargeRegulatedMotor leftMotor;
    static EV3LargeRegulatedMotor rightMotor;
    
    public static void main(String[] args) {
        // Lモーターを作成
        leftMotor   = new EV3LargeRegulatedMotor(MotorPort.B);
        rightMotor  = new EV3LargeRegulatedMotor(MotorPort.C);
        
        //　スピードを設定
        leftMotor.setSpeed(500);
        rightMotor.setSpeed(500);
        
        // 前進
        leftMotor.forward();
        rightMotor.forward();
        Delay.msDelay(3000);    // 3秒間
        
        // 停止
        leftMotor.stop(true);
        rightMotor.stop(true);
        
        // 後退
        leftMotor.backward();
        rightMotor.backward();
        Delay.msDelay(2000);    // 2秒間
        
        // 停止
        leftMotor.stop(true);
        rightMotor.stop(true);

    }

}
