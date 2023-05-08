package ec3_11_color;

import lejos.hardware.port.MotorPort;
import ev3Sensor.ColorSensor;
import ev3Sensor.EV3SensorMode;
import lejos.hardware.port.SensorPort;
import lejos.utility.Delay;

public class Ev3Color {
    
    // �^���N���쐬
    static Tank tank = new Tank(MotorPort.B, MotorPort.C);
    // �J���[�Z���T�[���쐬�i���ˌ����[�h�j
    static ColorSensor color = new ColorSensor(SensorPort.S3, EV3SensorMode.REFLECTMODE);

    public static void main(String[] args) {
        float value = 1;
        
        tank.move(300, 300);    //�@�O�i
        
        // ��������������܂ŌJ��Ԃ�
        while (value >= 0.4) {
            // �Z���T�[�̒l���擾
            value = color.getValue();
            
            // 0.1�b�ҋ@
            Delay.msDelay(100);
        }

        tank.stop(true, true);  // ��~
    }

}
