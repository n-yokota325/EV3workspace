package task;

import java.util.concurrent.CountDownLatch;

import body.measure.Measure;
import game.Game;
import body.control.Control;
import lejos.hardware.Button;

/**
 * ���Z�^�X�N�N���X
 * @author �㓡�@����
 *
 */
public class GameTask extends Thread {
    
    /** �ق��̃X���b�h�Ŏ��s���̑���Z�b�g����������܂ŁA1�ȏ�̃X���b�h��ҋ@�\�ɂ��铯�����x���@�\ */
    private CountDownLatch countDownLatch;
    
    /** �v���@*/
    Measure measure;
    /** ���Z */
    Game game;
    /** ���� */
    Control control;

    /**
     * �R���X�g���N�^
     * @param countDownLatch �������x���@�\
     * @param measure �v��
     * @param game ���Z
     * @param control ����
     */
    public GameTask(CountDownLatch countDownLatch, Measure measure, Game game, Control control){
        this.countDownLatch = countDownLatch;
        this.measure = measure;
        this.game = game;
        this.control = control;
    }
    
    /**
     * ���s����
     */
    @Override
    public void run() {
        if(Button.ESCAPE.isDown() || game.isOver()){
            countDownLatch.countDown();
        }
        measure.update();
        game.run();
        control.run();
    }

}
