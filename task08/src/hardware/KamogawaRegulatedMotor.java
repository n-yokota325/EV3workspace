package hardware;

import lejos.hardware.motor.BaseRegulatedMotor;
import lejos.hardware.port.Port;
import lejos.hardware.port.TachoMotorPort;
import lejos.hardware.sensor.EV3SensorConstants;


/**
 * KamogawaRegulatedMotor�N���X
 * EV3LargeRegulatedMotor�N���X�̉��ǔ�
 * ���s���ɑ��s�̂��O��ɂӂ����������
 * EV3LargeRegulatedMotor�N���X�̓����@�\���
 * �iEV3LargeRegulatedMotor�N���X��API���t�@�����X�Q��)
 * @author �㓡�@����
 *
 */
public class KamogawaRegulatedMotor extends BaseRegulatedMotor {

    /* ���ǌ� */
    static final float MOVE_P = 8f;
    static final float MOVE_I = 0.02f;
    static final float MOVE_D = 20f;

    /* ���ǑO
    static final float MOVE_P = 4f;
    static final float MOVE_I = 0.04f;
    static final float MOVE_D = 10f;
    */
    static final float HOLD_P = 2f;
    static final float HOLD_I = 0.02f;
    static final float HOLD_D = 8f;
    static final int OFFSET = 0;
    
    private static final int MAX_SPEED = 175*360/60;
    
    public KamogawaRegulatedMotor(TachoMotorPort port){
        super(port, null, EV3SensorConstants.TYPE_NEWTACHO, MOVE_P, MOVE_I, MOVE_D,
                HOLD_P, HOLD_I, HOLD_D, OFFSET, MAX_SPEED);
    }

    public KamogawaRegulatedMotor(Port port){
        super(port, null, EV3SensorConstants.TYPE_NEWTACHO, MOVE_P, MOVE_I, MOVE_D,
                HOLD_P, HOLD_I, HOLD_D, OFFSET, MAX_SPEED);
    }

}
