package test;

import task.TaskManager;

/**
 * ‘–sƒvƒƒOƒ‰ƒ€
 * @author Œã“¡ ‘•¶
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
