package ev3_03_drive;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.utility.Delay;

public class Ev3Drive {

    //�@L���[�^�[�̕ϐ���p��
    static EV3LargeRegulatedMotor leftMotor;
    static EV3LargeRegulatedMotor rightMotor;
    
    public static void main(String[] args) {
        // L���[�^�[���쐬
        leftMotor   = new EV3LargeRegulatedMotor(MotorPort.B);
        rightMotor  = new EV3LargeRegulatedMotor(MotorPort.C);
        
        //�@�X�s�[�h��ݒ�
        leftMotor.setSpeed(500);
        rightMotor.setSpeed(500);
        
        // �O�i
        leftMotor.forward();
        rightMotor.forward();
        Delay.msDelay(3000);    // 3�b��
        
        // ��~
        leftMotor.stop(true);
        rightMotor.stop(true);
        
        // ���
        leftMotor.backward();
        rightMotor.backward();
        Delay.msDelay(2000);    // 2�b��
        
        // ��~
        leftMotor.stop(true);
        rightMotor.stop(true);

    }

}
