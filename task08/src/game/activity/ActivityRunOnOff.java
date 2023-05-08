package game.activity;

import body.Body;

/**
 * OnOff���s����N���X
 * @author �㓡�@����
 *
 */
public class ActivityRunOnOff extends ActivityRun{
    
    /** ��]�p���x(�x/�b)�̏����l */
    private float initialTurn;
    
    /**
     * �R���X�g���N�^
     * @param forward �ڕW���x(mm/�b)
     * @param turn �ڕW��]�p���x(�x/�b)
     */
    public ActivityRunOnOff(float forward, float turn){
        super(forward, 0.0f);
        initialTurn = turn;
    }
    
    /**
     * �p����������s����
     * �H�ʖ��x�ƖڕW���x���r���ĖڕW��]�p���x���v�Z���A
     * �ڕW���x�ƖڕW��]�p���x��ݒ肷��
     */
    @Override
    public void doActivity(){
        // �H�ʖ��x���擾����
        float brightness = Body.measure.getValue();

        // �ڕW���x���擾����
        float target = Body.measure.getTarget(); 
        
        // �ڕW��]�p���x���v�Z����
        if(brightness < target){
            turn = initialTurn;
        }else{
            turn = -initialTurn;
        }
        
        // ���x��ݒ肷��
        Body.control.setForward(forward);
        Body.control.setTurn(turn);
    }

}
