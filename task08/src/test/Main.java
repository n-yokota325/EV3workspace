package test;

import task.TaskManager;

/**
 * ���s�v���O����
 * @author �㓡 ����
 *
 */
public class Main {

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        taskManager.schedule();
        taskManager.await();
        taskManager.shutdown();
    }

}
