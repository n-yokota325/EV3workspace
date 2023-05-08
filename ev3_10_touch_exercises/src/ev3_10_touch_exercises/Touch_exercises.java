package ev3_10_touch_exercises;

import ev3Sensor.TouchSensor;
import ev3Sensor.EV3SensorMode;
import lejos.hardware.port.SensorPort;
import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;

public class Touch_exercises {
    
    // �^�b�`�Z���T�[���쐬
    static TouchSensor s1Touch = new TouchSensor(SensorPort.S1, EV3SensorMode.TOUCHMODE); 
    static TouchSensor s2Touch = new TouchSensor(SensorPort.S2, EV3SensorMode.TOUCHMODE);
    
    public static void main(String[] args) {
        float s1Value;
        float s2Value;
        
        while (true) {
            // �Z���T�[�̒l���擾
            s1Value = s1Touch.getValue();
            s2Value = s2Touch.getValue();
            
            // �Z���T�[�̏�Ԃ�\��
            if (s1Value == 1 && s2Value == 1) {
                LCD.drawString("On", 1, 1);
            } else {
                LCD.clear();
            }
            
            // 0.2�b�ҋ@
            Delay.msDelay(200);
        }
    }
}
