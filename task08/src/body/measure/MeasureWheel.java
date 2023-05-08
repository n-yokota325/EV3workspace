package body.measure;

import hardware.KamogawaRegulatedMotor;

/**
 * �ԗ֌v���N���X
 * @author �㓡�@����
 *
 */
public class MeasureWheel {
    /** �����[�^ */
    private KamogawaRegulatedMotor leftMotor;
    /** �E���[�^ */
    private KamogawaRegulatedMotor rightMotor;
    
    /** �����[�^�̊p���x(�x/�b) */
    private float leftRotationSpeed;
    /** �E���[�^�̊p���x(�x/�b) */
    private float rightRotationSpeed;
    
    /**
     * �R���X�g���N�^
     * @param leftMotor �����[�^
     * @param rightMotor �E���[�^ 
     */
    public MeasureWheel(KamogawaRegulatedMotor leftMotor, KamogawaRegulatedMotor rightMotor){
        this.leftMotor = leftMotor;
        this.rightMotor = rightMotor;
    }
    
    /**
     * �X�V����
     */
    public void update() {
        leftRotationSpeed = leftMotor.getRotationSpeed();
        rightRotationSpeed = rightMotor.getRotationSpeed();
    }

    /**
     * �����[�^�̊p���x(�x/�b)���擾����
     * @return leftRotationSpeed �����[�^�̊p���x(�x/�b)
     */
    public float getLeftRotationSpeed() {
        return leftRotationSpeed;
    }

    /**
     * �E���[�^�̊p���x(�x/�b)���擾����
     * @return rightRotationSpeed �E���[�^�̊p���x(�x/�b)
     */
    public float getRightRotationSpeed() {
        return rightRotationSpeed;
    }

}
