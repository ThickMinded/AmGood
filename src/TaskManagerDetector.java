/**
 * The `TaskManagerDetector` class is responsible for **checking whether Task Manager is open** 
 * on a Windows system. This is useful for detecting if the user is trying to terminate processes
 * or monitor system performance.
 *
 * ### Functionality:
 * - **Detects Task Manager** (`taskmgr.exe`) by running the `tasklist.exe` command.
 * - Scans the output of `tasklist.exe` to see if `taskmgr.exe` is listed.
 * - Works **only on Windows** (prints a message if used on another OS).
 *
 * ### Behavior:
 * - Uses `System.getProperty("os.name")` to determine if the system is running Windows.
 * - If Windows is detected, executes `tasklist.exe`, which lists all running processes.
 * - Reads each line of the output, checking for **taskmgr.exe**.
 * - If found, returns `true` (indicating Task Manager is open).
 * - If `taskmgr.exe` is not found, returns `false`.
 *
 * ### Integration:
 * - Used in `hehehaMeow` to monitor whether Task Manager is open.
 * - If Task Manager is detected, `hehehaMeow` can respond accordingly (e.g., display a warning, prevent closure).
 * - Works alongside **CPUKillerMonitor** and **ForceVolume**, ensuring that system modifications are not tampered with.
 *
 * ### Key Methods:
 * - `isTaskManagerOpen()`: Checks if Task Manager is currently running.
 *
 * ### Notes:
 * - **Windows-only**: Relies on `tasklist.exe`, which is only available on Windows.
 * - **Requires execution permissions**: If the application lacks permissions to run `tasklist.exe`, it may fail.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaskManagerDetector {
    public static boolean isTaskManagerOpen() {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            try {
                String line;
                Process process = Runtime.getRuntime().exec(System.getenv("windir") + "\\system32\\tasklist.exe");
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    if (!line.toLowerCase().contains("taskmgr.exe")) continue;
                    return true;
                }
                return false;
            }
            catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        System.out.println("Unsupported operating system.");
        return false;
    }
}
