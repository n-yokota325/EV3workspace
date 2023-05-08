package ev3_04_turn;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.utility.Delay;

public class Ev3Turn {
    
    // LÉÇÅ[É^Å[ÇçÏê¨
    static EV3LargeRegulatedMotor leftMotor
        = new EV3LargeRegulatedMotor(MotorPort.B);
    static EV3LargeRegulatedMotor rightMotor
        = new EV3LargeRegulatedMotor(MotorPort.C);

    public static void main(String[] args) {
        // 2ïbä‘âEÇ÷ã»Ç™ÇÈ
        leftMotor.setSpeed(500);
        rightMotor.setSpeed(400);
        leftMotor.forward();
        rightMotor.forward();
        Delay.msDelay(2000);    // 2ïbä‘
        
        // í‚é~
        leftMotor.stop(true);
        rightMotor.stop(true);
        Delay.msDelay(1000);
        
        // âÒì]äpìxÇãÅÇﬂÇÈ
        float angle = 180 * (9.3f / 5.6f);
        
        // 180ìxç∂ê˘âÒÇ∑ÇÈ
        leftMotor.setSpeed(200);
        rightMotor.setSpeed(200);
        
        leftMotor.rotate((int)-angle, true);
        rightMotor.rotate((int)angle, false);

    }

}
