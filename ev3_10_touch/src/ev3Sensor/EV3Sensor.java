package ev3Sensor;

import lejos.hardware.port.Port;
import lejos.hardware.sensor.SensorMode;
import lejos.hardware.sensor.BaseSensor;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.hardware.sensor.EV3GyroSensor;

public class EV3Sensor {
    
    BaseSensor ev3Sensor;
    SensorMode sensorMode;
    EV3GyroSensor gyroSensor;
    
    // �Z���T�[�̒l������z��
    float value[];
    
    public EV3Sensor(int sensorType,Port port,int mode) {
        // �Z���T�[���쐬
        switch (sensorType) {
        case 1: // �^�b�`�Z���T�[
            ev3Sensor = new EV3TouchSensor(port);
            break;
        case 2: // �J���[�Z���T�[
            ev3Sensor = new EV3ColorSensor(port);
            break;
        case 3: // �����g�Z���T�[
            ev3Sensor = new EV3UltrasonicSensor(port);
            break;
        case 4: // �W���C���Z���T�[
            gyroSensor = new EV3GyroSensor(port);
            break;
        default:
            break;
        }
        
        // ���[�h��ݒ�
        switch (sensorType) {
        case 4: // �W���C���Z���T�[
            sensorMode = gyroSensor.getMode(mode);
            break;
        default:
            sensorMode = ev3Sensor.getMode(mode);
            break;
        }

        value = new float[sensorMode.sampleSize()];
    }

    // �Z���T�[�̒l���擾
    public float getValue() {
    
        // �Z���T�[�̒l��ǂ݂Ƃ��Ĕz��ɓ����
        sensorMode.fetchSample(value, 0);
        
        // �l��Ԃ�
        return value[0];
    }
}
