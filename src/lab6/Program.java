package lab6;

import static lab6.Utils.generateRandomState;
import static lab6.Utils.pause;

public class Program {
    private static final String DAEMON_STATE_MESSAGE = "Daemon state is ";
    private static final String ABSTRACT_PROGRAM_STARTED_MESSAGE = "Abstract program and Demon have been started";
    private static final String SUPERVISOR_STARTED_MESSAGE = "Supervisor started";
    private static final String SUPERVISOR_RUNNING_MESSAGE = "Supervisor is running";
    private static final String SUPERVISOR_REBOOT_MESSAGE = "Supervisor has been rebooted";
    private static final String SUPERVISOR_INTERRUPT_MESSAGE = "Supervisor has been interrupted";
    private static State state = State.UNKNOWN;
    private static final Object lock = new Object();
    private static final Thread abstractProgramThread = new Thread(new AbstractProgram());

    public Program() {
        new Thread(new Supervisor()).start();
    }

    static class AbstractProgram implements Runnable {
        @Override
        public void run() {
            Thread daemon = new Thread(() -> {
                while (!abstractProgramThread.isInterrupted()) {
                    pause(1000, 5000);
                    synchronized (lock) {
                        state = state != State.UNKNOWN ? generateRandomState() : state;
                        System.out.println(DAEMON_STATE_MESSAGE + state);
                        lock.notify();
                    }
                }
            });
            daemon.setDaemon(true);
            daemon.start();
            System.out.println(ABSTRACT_PROGRAM_STARTED_MESSAGE);
        }
    }

    static class Supervisor implements Runnable {

        @Override
        public void run() {
            System.out.println(SUPERVISOR_STARTED_MESSAGE);
            abstractProgramThread.start();
            while (!abstractProgramThread.isInterrupted()) {
                synchronized (lock) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    switch (state) {
                        case FATAL_ERROR -> interruptProgram();
                        case UNKNOWN, STOPPING -> rebootProgram();
                        default -> System.out.println(SUPERVISOR_RUNNING_MESSAGE);
                    }
                }
            }
        }

        private void rebootProgram() {
            state = State.RUNNING;
            System.out.println(SUPERVISOR_REBOOT_MESSAGE);
        }

        private void interruptProgram() {
            abstractProgramThread.interrupt();
            System.out.println(SUPERVISOR_INTERRUPT_MESSAGE);
        }
    }
}
