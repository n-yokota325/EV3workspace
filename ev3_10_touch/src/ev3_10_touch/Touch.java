package ev3_10_touch;

import ev3Sensor.TouchSensor;
import ev3Sensor.EV3SensorMode;
import lejos.hardware.port.SensorPort;
import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;

public class Touch {
    
    // �^�b�`�Z���T�[���쐬
    static TouchSensor touch = new TouchSensor(SensorPort.S1, EV3SensorMode.TOUCHMODE); 

    public static void main(String[] args) {
        float value;
        
        while (true) {
            // �Z���T�[�̒l���擾
            value = touch.getValue();
            
            // �Z���T�[�̏�Ԃ�\��
            if (value == 1) {
                LCD.drawString("On", 1, 1);
            } else {
                LCD.clear();
            }
            
            // 0.2�b�ҋ@
            Delay.msDelay(200);
        }
    }
}
