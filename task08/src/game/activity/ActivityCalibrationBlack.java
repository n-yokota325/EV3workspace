package game.activity;

import body.Body;

/**
 * �����x�L�����u���[�V��������N���X
 * @author �㓡�@����
 *
 */
public class ActivityCalibrationBlack extends Activity{
    
    /**
     * �R���X�g���N�^
     */
    public ActivityCalibrationBlack(){

    }
    
    /**
     * �p����������s����
     */
    @Override
    public void doActivity(){

    }

    /**
     * �㓮������s����
     * �����x�ƖڕW���x��ݒ肷��
     */
    @Override
    public void exitAction() {
        Body.measure.setBlack(Body.measure.getValue());
        Body.measure.setTarget((Body.measure.getWhite() + Body.measure.getBlack()) / 2.0f);
    }
}
