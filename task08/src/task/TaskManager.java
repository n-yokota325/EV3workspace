package task;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import body.Body;
import game.Game;
import log.Log;

/**
 * �^�X�N�Ǘ��N���X
 * @author �㓡�@����
 *
 */
public class TaskManager {
    
    // ���Z�^�X�N
    private GameTask gameTask;
    Game game;
    //�@���O�^�X�N
    private LogTask logTask;
    Log log;
    
    // �X�P�W���[��
    private ScheduledExecutorService scheduler;
    private ScheduledFuture<?> futureGame;
    private ScheduledFuture<?> futureLog;
    private CountDownLatch countDownLatch;
    
    /**
     * �R���X�g���N�^
     */
    public TaskManager(){
        // �X�P�W���[������
        scheduler = Executors.newScheduledThreadPool(2);
        countDownLatch = new CountDownLatch(1);

        // �^�X�N����
        game = new Game();
        log = new Log(game);
        gameTask = new GameTask(countDownLatch, Body.measure, game, Body.control);
        gameTask.setPriority(Thread.MAX_PRIORITY);
        logTask = new LogTask(log);
        logTask.setPriority(Thread.NORM_PRIORITY);

        // ����������
        Beep.ring();
    }
    
    /**
     * �^�X�N�̃X�P�W���[�����O
     */
    public void schedule(){
        futureGame = scheduler.scheduleAtFixedRate(gameTask, 0, 10, TimeUnit.MILLISECONDS);
        futureLog = scheduler.scheduleAtFixedRate(logTask, 0, 500, TimeUnit.MILLISECONDS);
    }
    
    /**
     * ���Z�^�X�N���I������܂ő҂�
     */
    public void await(){
        try{
            countDownLatch.await();
        }catch(InterruptedException e){
            
        }
    }
    
    /**
     * �^�X�N�̎��s�̎������ƃX�P�W���[���̃V���b�g�_�E��
     */
    public void shutdown(){
        if(futureLog != null){
            futureLog.cancel(true);
        }
        if(futureGame != null){
            futureGame.cancel(true);
        }
        scheduler.shutdownNow();
        log.write();
    }    
}
