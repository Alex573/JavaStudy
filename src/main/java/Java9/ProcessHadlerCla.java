package Java9;

import java.io.IOException;

public class ProcessHadlerCla {
    public static void main(String[] args) throws IOException, IllegalAccessException, InterruptedException {
        Process slepper = Runtime.getRuntime().exec("sleep 1h");
        System.out.println("current process id " + ProcessHandle.current().pid());
        System.out.println("sleeper id " +  slepper.pid());

        ProcessHandle processHandle = ProcessHandle.of(slepper.pid()).orElseThrow(IllegalAccessException::new);
        processHandle.onExit().thenRun(()-> System.out.println("process has been closed"));
        System.out.println(processHandle.info().user().orElse("no user"));
        System.out.println(processHandle.info().commandLine().orElse("empty"));

        processHandle.destroy();

        Thread.sleep(100);
    }
}
