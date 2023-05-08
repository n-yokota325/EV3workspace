package body.control;

import hardware.KamogawaRegulatedMotor;

/**
 * �ԗ֐���N���X
 * @author �㓡�@����
 *
 */
public class ControlWheel {
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
     * @param rightMotor�@�E���[�^
     */
    public ControlWheel(KamogawaRegulatedMotor leftMotor, KamogawaRegulatedMotor rightMotor){
        this.leftMotor = leftMotor;
        this.rightMotor = rightMotor;
    }

    /**
     * ���䂷��
     */
    public void run(){
        leftMotor.setSpeed(leftRotationSpeed);
        rightMotor.setSpeed(rightRotationSpeed);
        if(leftRotationSpeed >= 0){
            leftMotor.forward();
        }else{
            leftMotor.backward();
        }
        if(rightRotationSpeed >= 0){
            rightMotor.forward();
        }else{
            rightMotor.backward();
        }
    }

    /**
     * �����[�^�̊p���x(�x/�b)��ݒ肷��
     * @param leftRotationSpeed�@�����[�^�̊p���x(�x/�b)
     */
    public void setLeftRotationSpeed(float leftRotationSpeed) {
        this.leftRotationSpeed = leftRotationSpeed;
    }

    /**
     * �E���[�^�̊p���x(�x/�b)��ݒ肷��
     * @param leftRotationSpeed�@�E���[�^�̊p���x(�x/�b)
     */
    public void setRightRotationSpeed(float rightRotationSpeed) {
        this.rightRotationSpeed = rightRotationSpeed;
    }

}
