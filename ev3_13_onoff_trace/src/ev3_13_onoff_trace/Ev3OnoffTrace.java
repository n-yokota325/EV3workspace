package ev3_13_onoff_trace;

import lejos.hardware.port.MotorPort;
import ev3Sensor.ColorSensor;
import ev3Sensor.EV3SensorMode;
import lejos.hardware.port.SensorPort;

public class Ev3OnoffTrace {
    
    // �^���N���쐬
    static Tank tank = new Tank(MotorPort.B, MotorPort.C);
    // �J���[�Z���T�[���쐬�i���ˌ����[�h�j
    static ColorSensor color = new ColorSensor(SensorPort.S3, EV3SensorMode.REFLECTMODE);
    
    public static void main(String[] args) {
        while (true) {
            if (color.getValue() < 0.3) {
                tank.move(300, 100);
            } else {
                tank.move(100, 300);
            }
        }
    }

}
