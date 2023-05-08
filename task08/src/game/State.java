package game;

import java.util.ArrayList;
import game.activity.Activity;
import game.guard.Guard;
import task.Beep;

/**
 * ���Z��ԃN���X
 * �f�U�C���p�^�[����State�p�^�[�����̗p
 * @author �㓡�@����
 *
 */
public abstract class State {
    /** �J�ڏ������X�g */
    protected ArrayList<Guard> guardList;
    /** ���샊�X�g */
    protected ArrayList<Activity> activityList;
    /** ���X�g�̃C���f�b�N�X */
    protected int index;
    /** ��Ԗ� */
    protected String name;

    /**
     * �R���X�g���N�^
     */
    public State() {
        guardList = new ArrayList<>();
        activityList = new ArrayList<>();
        index = 0;
        name = "";
    }

    /**
     * �ǉ�����
     * @param guard �J�ڏ���
     * @param activity�@����
     */
    public void add(Guard guard, Activity activity) {
        guardList.add(guard);
        activityList.add(activity);
    }

    /**
     * �O��������s����
     * ��ԂɑJ�ڂ����Ƃ���1�x�������s����铮��
     * UML�X�e�[�g�}�V���}��entry�A�N�V����
     */
    public void entryAction() {
        activityList.get(index).entryAction();
    }

    /**
     * �p����������s����
     * ��Ԃɂ���ԁA�p�����Ď��s����铮��
     * UML�X�e�[�g�}�V���}��do�A�N�e�B�r�e�B
     * @param game ���Z
     */
    public void doActivity(Game game) {
        if (guardList.get(index).judge()) {
            index++;
            if(index >= guardList.size()){
                changeState(game);
            } else {
                Beep.ring();
            }
        } else {
            activityList.get(index).doActivity();
        }
    }

    /**
     * �㓮������s����
     * ��Ԃ��痣��钼�O��1�x�������s����铮��
     * UML�X�e�[�g�}�V���}��exit�A�N�V����
     */
    public void exitAction() {
        activityList.get(index-1).exitAction();        
    }

    /**
     * ���Z��Ԃ�J�ڂ���
     * @param game ���Z
     */
    public abstract void changeState(Game game);

    /**
     * ���X�g�̃C���f�b�N�X���擾����
     * @return ���X�g�̃C���f�b�N�X
     */
    public int getIndex() {
        return index;
    }
    
    /**
     * ���X�g�̃T�C�Y���擾����
     * @return
     */
    public int getSize() {
        return guardList.size();
    }

    /**
     * �I�u�W�F�N�g�̕�����\�����擾����
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(" ");
        sb.append(getIndex() + 1);
        sb.append("/");
        sb.append(getSize());
        
        return sb.toString();
    }
}
