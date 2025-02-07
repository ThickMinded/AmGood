/**
 * The `ForceVolume` class is responsible for automatically increasing the system volume
 * on a Windows machine by simulating keypresses for the "Volume Up" button.
 *
 * ### Functionality:
 * - Uses PowerShell to send keypresses through the Windows Script Host (`WScript.Shell`).
 * - Runs in a **separate background thread** to repeatedly increase the volume.
 * - Can be started and stopped programmatically using `startInfiniteVolumeIncrease()` and `stopInfiniteVolumeIncrease()`.
 *
 * ### Behavior:
 * - The infinite volume increase process runs **only one thread at a time** to prevent system overload.
 * - Uses a **daemon thread**, which ensures the process stops automatically when the main application exits.
 * - Adds a **small delay (100ms)** between volume key presses to prevent excessive system resource usage.
 *
 * ### Integration:
 * - This class works alongside other classes in the system, such as `hehehaMeow`,
 *   ensuring that the volume remains high while other disruptive behaviors are active.
 * - Designed to be triggered when needed, especially during program execution.
 *
 * ### Key Methods:
 * - `increaseVolume()`: Executes a PowerShell command to press the "Volume Up" key.
 * - `startInfiniteVolumeIncrease()`: Starts a background thread that continuously increases the volume.
 * - `stopInfiniteVolumeIncrease()`: Stops the background thread, halting the volume increase.
 *
 * ### Notes:
 * - **This class is designed for Windows only**, as it relies on Windows PowerShell and COM objects.
 * - If PowerShell is restricted on the system, this functionality may not work.
 */

import java.io.IOException;

public class ForceVolume {

    private static boolean running = false; // Flag to control the infinite loop

    // Method to simulate increasing the system volume
    public static void increaseVolume() {
        try {
            // Windows PowerShell command to simulate Volume Up keypress
            ProcessBuilder pb = new ProcessBuilder("powershell", "-c",
                    "(New-Object -ComObject WScript.Shell).SendKeys([char]175)");
            pb.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to start the infinite volume increase in a separate thread
    public static void startInfiniteVolumeIncrease() {
        if (running) return; // Prevent starting multiple threads
        running = true;
        Thread volumeThread = new Thread(() -> {
            while (running) {
                increaseVolume();
                try {
                    Thread.sleep(100); // Small delay to avoid overwhelming the system
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        volumeThread.setDaemon(true); // Daemon thread will stop when the main program exits
        volumeThread.start();
    }

    // Method to stop the infinite volume increase
    public static void stopInfiniteVolumeIncrease() {
        running = false;
    }
}
