package body.control;

import body.Body;

/**
 * ����N���X
 * �f�U�C���p�^�[����Facade�p�^�[�����̗p
 * @author �㓡�@����
 *
 */
public class Control {
    /** �ԗ֐��� */
    ControlWheel controlWheel;
    
    /** �ڕW���x(mm/�b) */
    private float forward;
    /** �ڕW��]�p���x(�x/�b) */
    private float turn;
    
    /**
     * �R���X�g���N�^
     * @param controlWheel �ԗ֐���
     */
    public Control(ControlWheel controlWheel) {
        this.controlWheel = controlWheel;
    }
    
    /**
     * ���䂷��
     * �ڕW���x(mm/�b)�ƖڕW��]�p���x(�x/�b)����
     * ���E���[�^�̊p���x(�x/�b)���v�Z���Đݒ肷��
     */
    public void run(){
        turn = (float)Math.toRadians(turn);
        
        float leftRotationSpeed = (float) Math.toDegrees((2.0f * forward - Body.TREAD * turn) / Body.DIAMETER);
        float rightRotationSpeed = (float) Math.toDegrees((2.0f * forward + Body.TREAD * turn) / Body.DIAMETER);
        
        controlWheel.setLeftRotationSpeed(leftRotationSpeed);
        controlWheel.setRightRotationSpeed(rightRotationSpeed);
        controlWheel.run();
    }

    /**
     * �ڕW���x(mm/�b)��ݒ肷��
     * @param forward �ڕW���x(mm/�b)
     */
    public void setForward(float forward) {
        this.forward = forward;
    }

    /**
     * �ڕW��]�p���x(�x/�b)��ݒ肷��
     * @param turn �ڕW��]�p���x(�x/�b)
     */
    public void setTurn(float turn) {
        this.turn = turn;
    }
}
