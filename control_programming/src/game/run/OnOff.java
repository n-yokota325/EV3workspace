package game.run;

import body.control.Wheel;
import body.measure.Course;

public class OnOff {
    private Course course;
    private Wheel wheel;
    
    private float forward;
    private float turn;
    final float INITIAL_TURN = 100.0f;
    
    public OnOff(Course course, Wheel wheel, float forward) {
        this.course = course;
        this.wheel = wheel;
        this.forward = forward;
        this.turn = 0.0f;
    }
    
    /**
     * ���s����
     */
    public void run(){
        // �ڕW�P�x�l���擾����
        float target = course.getTarget();
        
        // �H�ʂ̋P�x�l���v�Z����
        float brightness = course.getBrightness();
        
        // ����p���x���v�Z����
        if (brightness < target) {
            turn = -INITIAL_TURN;
        } else {
            turn = INITIAL_TURN;
        }
        
        // �p���x��ݒ肷��
        wheel.setForward(forward);
        wheel.setTurn(turn);
    }
}
