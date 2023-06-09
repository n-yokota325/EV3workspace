package ev3_06_meandering;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.Port;
import lejos.utility.Delay;

public class Tank {
    
    EV3LargeRegulatedMotor leftMotor;
    EV3LargeRegulatedMotor rightMotor;
    
    public Tank(Port lPort, Port rPort) {
        // ポートを設定する
        leftMotor   = new EV3LargeRegulatedMotor(lPort);
        rightMotor  = new EV3LargeRegulatedMotor(rPort);
    }

    // 前進する
    public void moveFwd(int lSpeed, int rSpeed) {
        leftMotor.setSpeed(lSpeed);
        rightMotor.setSpeed(rSpeed);
        leftMotor.forward();
        rightMotor.forward();
    }
    
    // 後退する
    public void moveBwd(int lSpeed, int rSpeed) {
        leftMotor.setSpeed(lSpeed);
        rightMotor.setSpeed(rSpeed);
        leftMotor.backward();
        rightMotor.backward();
    }
    
    // 停止する
    public void stop(boolean lRtn, boolean rRtn) {
        leftMotor.stop(lRtn);
        rightMotor.stop(rRtn);
    }
    
    // 指定したスピードと秒数で前進する
    public void moveFwdForMs(int lSpeed, int rSpeed, long time) {
        this.moveFwd(lSpeed, rSpeed);
        Delay.msDelay(time);
        this.stop(true, true);
    }
    
    // 指定したスピードと秒数で後退する
    public void moveBwdForMs(int lSpeed, int rSpeed, long time) {
        this.moveBwd(lSpeed, rSpeed);
        Delay.msDelay(time);
        this.stop(true, true);
    }
}
