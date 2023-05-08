package ev3_12_us;

import lejos.hardware.port.MotorPort;
import ev3Sensor.UltraSonicSensor;
import ev3Sensor.EV3SensorMode;
import lejos.hardware.port.SensorPort;
import lejos.utility.Delay;

public class Ev3Us {
    
    // �^���N���쐬
    static Tank tank = new Tank(MotorPort.B, MotorPort.C);
    // �����g�Z���T�[���쐬
    static UltraSonicSensor us = new UltraSonicSensor(SensorPort.S4, EV3SensorMode.DISTANCEMODE);

    public static void main(String[] args) {
        float value = 1;
        
        tank.move(300, 300);    // �O�i
        
        // ��Q����������܂ŌJ��Ԃ�
        while (value >= 0.2) {
            // �Z���T�[�̒l���擾
            value = us.getValue();
            
            // 0.1�b�ҋ@
            Delay.msDelay(100);
        }

        tank.stop(true, true);  //�@��~
    }

}
