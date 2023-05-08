package body.control;

import lejos.hardware.motor.EV3LargeRegulatedMotor;

/**
 * �ԗ֐���N���X
 * @author user119
 *
 */
public class Wheel {
    private EV3LargeRegulatedMotor leftMotor;
    private EV3LargeRegulatedMotor rightMotor;
    
    private float forward;
    private float turn;
    private float leftSpeed;
    private float rightSpeed;
    
    public Wheel(EV3LargeRegulatedMotor leftMotor, EV3LargeRegulatedMotor rightMotor) {
        this.leftMotor = leftMotor;
        this.rightMotor = rightMotor;
    }
    
    /**
     * ���䂷��
     */
    public void control() {
        leftSpeed = forward - turn;
        rightSpeed = forward + turn;
        leftMotor.setSpeed(leftSpeed);
        rightMotor.setSpeed(rightSpeed);
        if(leftSpeed >= 0){
            leftMotor.forward();
        } else {
            leftMotor.backward();
        }
        if(rightSpeed >= 0){
            rightMotor.forward();
        } else {
            rightMotor.backward();
        }
    }
    
    public void setForward(float forward) {
        this.forward = forward;
    }
    
    public float getForward() {
        return forward;
    }
    
    public void setTurn(float turn) {
        this.turn = turn;
    }
    
    public float getTurn() {
        return turn;
    }
    
    public float getLeftSpeed() {
        return leftSpeed;
    }
    
    public float getRightSpeed() {
        return rightSpeed;
    }
}
