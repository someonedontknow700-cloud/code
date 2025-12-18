package project;

public class DroneControlSimulation {

    // System One: Sends "Good Morning" every 1 second
    static class SystemOne extends Thread {

        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) { // run 10 times
                    System.out.println(
                        "System One: Good Morning (Health Check)"
                    );
                    Thread.sleep(1000); // 1 second
                }
            } catch (InterruptedException e) {
                System.out.println("System One interrupted.");
            }
        }
    }

    // System Two: Sends "Hello" every 2 seconds
    static class SystemTwo extends Thread {

        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) { // run 10 times
                    System.out.println(
                        "System Two: Hello (Communication with nearby drones)"
                    );
                    Thread.sleep(2000); // 2 seconds
                }
            } catch (InterruptedException e) {
                System.out.println("System Two interrupted.");
            }
        }
    }

    // System Three: Sends "Welcome" every 3 seconds
    static class SystemThree extends Thread {

        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) { // run 10 times
                    System.out.println(
                        "System Three: Welcome (New Airspace Zone Broadcast)"
                    );
                    Thread.sleep(3000); // 3 seconds
                }
            } catch (InterruptedException e) {
                System.out.println("System Three interrupted.");
            }
        }
    }

    public static void main(String[] args) {

        // Create and start threads
        SystemOne systemOne = new SystemOne();
        SystemTwo systemTwo = new SystemTwo();
        SystemThree systemThree = new SystemThree();

        systemOne.start();
        systemTwo.start();
        systemThree.start();
    }
}


