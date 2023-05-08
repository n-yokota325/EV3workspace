package ev3_14_p_trace;

import lejos.hardware.port.MotorPort;
import ev3Sensor.ColorSensor;
import ev3Sensor.EV3SensorMode;
import lejos.hardware.port.SensorPort;

public class Ev3PTrace {
    
    // �^���N���쐬
    static Tank tank = new Tank(MotorPort.B, MotorPort.C);
    // �J���[�Z���T�[���쐬�i���ˌ����[�h�j
    static ColorSensor color = new ColorSensor(SensorPort.S3, EV3SensorMode.REFLECTMODE);

    public static void main(String[] args) {
        float center = 0.35f;   // �ڕW
        float kp = 0.75f;       // �Q�C��
        float mv;               // �����
        float mSp = 300;        // ��{�̃��[�^�[�X�s�[�h
        float lSpeed, rSpeed;   // ���E�̃��[�^�[�X�s�[�h
        
        while (true) {
            // ����ʂ��v�Z
            // ���Q�C�� * (�ڕW�l - ���ݒl) * 100
            mv = kp * (center - color.getValue());
            
            // ����ʂ��獶�E���ꂼ��̃��[�^�[�X�s�[�h���v�Z
            if (mv == 0) {
                lSpeed = mSp;
                rSpeed = mSp;
            } else if (mv > 0) {
                lSpeed = mSp;
                rSpeed = mSp - (mSp * Math.abs(mv) * 2);
            } else {
                lSpeed = mSp - (mSp * Math.abs(mv) * 2);
                rSpeed = mSp;
            }
            
            // ���[�^�[�𓮂���
            tank.move((int)lSpeed, (int)rSpeed);
        }
    }

}
