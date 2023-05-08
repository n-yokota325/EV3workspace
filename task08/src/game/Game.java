package game;

import game.activity.ActivityCalibrationBlack;
import game.activity.ActivityCalibrationWhite;
import game.activity.ActivityRunOnOff;
import game.guard.GuardTouch;
import game.activity.ActivityRun;

/**
 * ���Z�N���X
 * @author �㓡 ����
 *
 */
public class Game {
    /** �^�X�N�ďo�� */
    private int count = 0;

    /** ���Z��� */
    private State state;

    /** ���Z���I�������� */
    private boolean isOver = false;

    /**
     * �R���X�g���N�^
     */
    public Game() {
        StateCalibrationWhite.getInstance().add(new GuardTouch(), new ActivityCalibrationWhite());
        
        StateCalibrationBlack.getInstance().add(new GuardTouch(), new ActivityCalibrationBlack());
        
        StateWaitStart.getInstance().add(new GuardTouch(), new ActivityRun(0, 0));

        StateRun.getInstance().add(new GuardTouch(), new ActivityRunOnOff(100, 30.0f));
        StateRun.getInstance().add(new GuardTouch(), new ActivityRunOnOff(100, 60.0f));
        StateRun.getInstance().add(new GuardTouch(), new ActivityRunOnOff(100, 90.0f));
        StateRun.getInstance().add(new GuardTouch(), new ActivityRun(100, 90.0f));
        StateRun.getInstance().add(new GuardTouch(), new ActivityRun(100, -90.0f));
        
        StateEnd.getInstance().add(new GuardTouch(), new ActivityRun(0, 0));

        changeState(null, StateCalibrationWhite.getInstance());
    }
    
    /**
     * ���{����
     */
    public void run() {
        if(isOver == false){
            count++;
            if (state instanceof StateEnd) {
                isOver = true;
            } else {
                state.doActivity(this);
            }
        }
    }

    /**
     * �^�X�N�ďo�񐔂��擾����
     * @return �^�X�N�ďo��
     */
    public int getCount() {
        return count;
    }
    
    /**
     * ���Z��Ԃ�J�ڂ���
     * @param oldState �O���
     * @param newState�@����
     */
    public void changeState(State oldState, State newState) {
        this.state = newState;

        if(oldState != null){
            oldState.exitAction();
        }
        if(newState != null){
            newState.entryAction();;
        }
    }

    /**
     * ���Z���I��������
     * @return ���Z���I�������ꍇ��true
     */
    public boolean isOver() {
        return isOver;
    }
    
    /**
     * �I�u�W�F�N�g�̕�����\�����擾����
     */
    @Override
    public String toString() {
        return state.toString();
    }

}
