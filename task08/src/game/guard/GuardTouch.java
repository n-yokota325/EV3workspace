package game.guard;

import body.Body;

/**
 * �^�b�`�J�ڏ���
 * @author �㓡�@����
 *
 */
public class GuardTouch extends Guard{
    
    /**
     * ���肷��
     * @return �^�b�`�Z���T�������ꂽ�ꍇ��true�A������Ă��Ȃ��ꍇ��false
     */
    @Override
    public boolean judge(){
        return Body.measure.isUpped();
    }
}
