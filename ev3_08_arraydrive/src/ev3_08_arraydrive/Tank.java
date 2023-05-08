package ev3_08_arraydrive;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.Port;
import lejos.utility.Delay;

public class Tank {
    
    EV3LargeRegulatedMotor leftMotor;
    EV3LargeRegulatedMotor rightMotor;
    
    public Tank(Port lPort, Port rPort) {
        // �|�[�g��ݒ肷��
        leftMotor   = new EV3LargeRegulatedMotor(lPort);
        rightMotor  = new EV3LargeRegulatedMotor(rPort);
    }

    // �O�i����
    public void moveFwd(int lSpeed, int rSpeed) {
        leftMotor.setSpeed(lSpeed);
        rightMotor.setSpeed(rSpeed);
        leftMotor.forward();
        rightMotor.forward();
    }
    
    // ��ނ���
    public void moveBwd(int lSpeed, int rSpeed) {
        leftMotor.setSpeed(lSpeed);
        rightMotor.setSpeed(rSpeed);
        leftMotor.backward();
        rightMotor.backward();
    }
    
    // ��~����
    public void stop(boolean lRtn, boolean rRtn) {
        leftMotor.stop(lRtn);
        rightMotor.stop(rRtn);
    }
    
    // �w�肵���X�s�[�h�ƕb���őO�i����
    public void moveFwdForMs(int lSpeed, int rSpeed, long time) {
        this.moveFwd(lSpeed, rSpeed);
        Delay.msDelay(time);
        this.stop(true, true);
    }
    
    // �w�肵���X�s�[�h�ƕb���Ō�ނ���
    public void moveBwdForMs(int lSpeed, int rSpeed, long time) {
        this.moveBwd(lSpeed, rSpeed);
        Delay.msDelay(time);
        this.stop(true, true);
    }
}
