package game.activity;

import body.Body;

/**
 * �����x�L�����u���[�V��������N���X
 * @author �㓡�@����
 *
 */
public class ActivityCalibrationWhite extends Activity{
    
    /**
     * �R���X�g���N�^
     */
    public ActivityCalibrationWhite(){

    }
    
    /**
     * �p����������s����
     */
    @Override
    public void doActivity(){
        
    }
    
    /**
     * �㓮������s����
     * �����x��ݒ肷��
     */
    @Override
    public void exitAction() {
        Body.measure.setWhite(Body.measure.getValue());
    }

}
