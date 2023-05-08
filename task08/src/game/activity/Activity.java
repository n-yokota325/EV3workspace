package game.activity;

import task.Beep;

/**
 * ����N���X
 * @author �㓡 ����
 *
 */
public abstract class Activity {
    
    /**
     * �O��������s����
     * ��ԂɑJ�ڂ����Ƃ���1�x�������s����铮��
     * UML�X�e�[�g�}�V���}��entry�A�N�V����
     */
    public void entryAction() {
        Beep.ring();
    }
    
    /**
     * �p����������s����
     * ��Ԃɂ���ԁA�p�����Ď��s����铮��
     * UML�X�e�[�g�}�V���}��do�A�N�e�B�r�e�B
     */
    public abstract void doActivity();
    
    /**
     * �㓮������s����
     * ��Ԃ��痣��钼�O��1�x�������s����铮��
     * UML�X�e�[�g�}�V���}��exit�A�N�V����
     */
    public void exitAction() {
        
    }
}
