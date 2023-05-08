package game.activity;

import body.Body;

/**
 * ���s����N���X
 * @author �㓡�@����
 *
 */
public class ActivityRun extends Activity{
    
    /** �ڕW���x(mm/�b) */
    protected float forward;
    /** �ڕW��]�p���x(�x/�b) */
    protected float turn;

    /**
     * �R���X�g���N�^
     * @param forward �ڕW���x(mm/�b)
     * @param turn �ڕW��]�p���x(�x/�b)
     */
    public ActivityRun(float forward, float turn){
        this.forward = forward;
        this.turn = turn;
    }
    
    /**
     * �p����������s����
     * �ڕW���x�ƖڕW��]�p���x��ݒ肷��
     */
    @Override
    public void doActivity(){
        Body.control.setForward(forward);
        Body.control.setTurn(turn);
    }

}
