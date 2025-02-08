/**
 * The `CPUKillerMonitor` class is responsible for monitoring the CPU usage
 * and dynamically starting or stopping a CPU-intensive operation (`Killer()` in the `hehehaMeow` class)
 * based on the current CPU load.

 * ### Key Components:
 * - **CPU_THRESHOLD:** Defines the CPU usage threshold (in percentage) to decide
 *   whether to start or stop the `Killer()` method. The current threshold is set to `1` (interpreted as 1%, which is likely an oversight and should be corrected).
 *
 * - **scheduler:** A `ScheduledExecutorService` instance that repeatedly checks the CPU usage at regular intervals.

 * - **isRunningKiller:** A flag to track whether the `Killer()` method is currently running. This prevents redundant calls to `Killer()` when it is already active.

 * ### How It Works:
 * - The `startMonitoring()` method:
 *   1. Fetches the `OperatingSystemMXBean` instance to monitor system-level CPU usage.
 *   2. Schedules a task to run every 200 milliseconds, checking the current CPU usage.
 *   3. If CPU usage exceeds the threshold, it stops the `Killer()` method.
 *   4. If CPU usage is below the threshold, it starts the `Killer()` method if it isn’t already running.
 *
 * - The `stopMonitoring()` method:
 *   Gracefully shuts down the monitoring by terminating the scheduler.

 * ### Potential Issues:
 * - **CPU_THRESHOLD Misconfiguration:** The current threshold is set to `1`, which is far too low. Typically, this should be set to something like `90` to represent 90% CPU usage.
 * - **Low Monitoring Interval:** The check interval of 200 milliseconds could be too frequent and may lead to unnecessary overhead.
 * - **Redundancy:** The class isn't currently used in the main program (`hehehaMeow`). If it's intended for future use, it should be integrated properly.

 * ### How to Use:
 * - Call `CPUKillerMonitor.startMonitoring(instance)` to begin monitoring CPU usage. Pass the `hehehaMeow` instance to allow the monitor to call its `Killer()` method.
 * - Call `CPUKillerMonitor.stopMonitoring()` to stop the monitoring process.

 * ### Notes:
 * - This class requires the `hehehaMeow` instance to work, as it directly invokes the `Killer()` method from that class.
 * - The class is designed to manage CPU usage intelligently during resource-intensive operations,
 *   but its current implementation may need refinement before practical use.
 */

import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CPUKillerMonitor {
    private static final double CPU_THRESHOLD = 1; // 90%
    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private static boolean isRunningKiller = false;

    public static void startMonitoring(hehehaMeow instance) {
        OperatingSystemMXBean osBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

        scheduler.scheduleAtFixedRate(() -> {
            double cpuLoad = osBean.getSystemCpuLoad(); // Get CPU usage (0.0 to 1.0)
            cpuLoad *= 100; // Convert to percentage

            if (cpuLoad >= CPU_THRESHOLD) {
                System.out.printf("⚠️ CPU Too High (%.2f%%) - Stopping Killer()\n", cpuLoad);
                isRunningKiller = false;
            } else {
                if (!isRunningKiller) {
                    System.out.printf("✅ CPU Normal (%.2f%%) - Running Killer()\n", cpuLoad);
                    instance.Killer(); // Start Killer() if not running
                    isRunningKiller = true;
                }
            }
        }, 0, 200, TimeUnit.MILLISECONDS); // Check every 0.2 seconds
    }

    public static void stopMonitoring() {
        scheduler.shutdown();
    }
}
