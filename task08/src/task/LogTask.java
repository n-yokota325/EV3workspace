package task;

import log.Log;

/**
 * ���O�^�X�N�N���X
 * @author �㓡�@����
 *
 */
public class LogTask extends Thread {

    /** ���O */
    private Log log;
    
    /**
     * �R���X�g���N�^
     * @param log   ���O
     */
    public LogTask(Log log){
        this.log = log;
    }
    
    /**
     * ���s����
     */
    @Override
    public void run() {
        log.run();
    }

}
