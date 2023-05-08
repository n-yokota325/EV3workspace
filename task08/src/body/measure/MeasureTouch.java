package body.measure;

import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.sensor.SensorMode;

/**
 * �^�b�`�v���N���X
 * @author �㓡�@����
 *
 */
public class MeasureTouch{
    /** �^�b�`�Z���T */
    private EV3TouchSensor touchSensor;
    private SensorMode sensorMode;
    private float value[];

    /** �����ꂽ���i���̏�ԁj */
    private boolean isPressed;
    /** �����ꂽ���i�O��̏�ԁj */
    private boolean isPressedOld;
    /** �����ꂽ�� */
    private boolean isUpped;
    
    /**
     * �R���X�g���N�^
     * @param touchSensor �^�b�`�Z���T
     */
    public MeasureTouch(EV3TouchSensor touchSensor){
        this.touchSensor = touchSensor;
        sensorMode =  this.touchSensor.getTouchMode();
        value = new float[sensorMode.sampleSize()];
    }

    /**
     * �X�V����
     */
    public void update() {
        // �^�b�`�Z���T�������ꂽ���i���̏�ԁj
        sensorMode.fetchSample(value, 0);
        isPressed = ((int)value[0] != 0);
        
        // �^�b�`�Z���T�������ꂽ���i�O��ƍ��̏�Ԃ��r�j
        if(isPressedOld && !isPressed){
            isUpped = true;
        }else{
            isUpped = false;
        }
        isPressedOld = isPressed;
    }
    
    /**
     * �����ꂽ��
     * @return �����ꂽ�ꍇ��true
     */
    public boolean isPressed(){
        return isPressed;
    }
    
    /**
     * �����ꂽ��
     * @return �����ꂽ�ꍇ��true
     */
    public boolean isUpped() {
        return isUpped;
    }
}
