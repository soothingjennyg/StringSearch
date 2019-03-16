import java.io.*;

public class Timer {
        private long startTime, endTime;
        public long totalTime;

        Timer() {
            startTime = 0;
            endTime = 0;
            totalTime = 0;
        }

        public void start() {
            startTime = System.nanoTime();
        }

        public void stop() {
            endTime = System.nanoTime();
            totalTime = endTime - startTime;
        }

        public void saveTime(String fileName) {
            try {
                File times = new File(fileName);
                PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(times, true)));
                System.out.println("time is " + totalTime);
                writer.println(totalTime);
                writer.close();
            } catch (IOException e) {
                System.err.println(e.getLocalizedMessage());
                e.printStackTrace();
            }
        }
        public void saveRunType(String fileName, String runType) {
            try {
                File times = new File(fileName);
                PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(times, true)));
                writer.println(runType);
                writer.close();
            } catch (IOException e) {
                System.err.println(e.getLocalizedMessage());
                e.printStackTrace();
            }
        }


}

