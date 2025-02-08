import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StressTest {

    private static final int NUM_CPU_THREADS = Runtime.getRuntime().availableProcessors() * 2;
    private static final long MAX_MEMORY_USAGE_MB = Runtime.getRuntime().maxMemory() / (1024 * 1024);
    private static final int DISK_FILE_SIZE_MB = 1024; // 1GB per file
    private static final int NUM_DISK_THREADS = 5;
    private static final int GPU_WINDOW_SIZE = 1000;
    private static final String TEMP_FILE_PREFIX = "stress_test_file_";



    // **🔥 CPU Overload: Heavy Matrix Multiplication**
    private static void stressCpu() {
        System.out.println("🔥 CPU Stress Started...");
        int size = 100;
        double[][] matrixA = new double[size][size];
        double[][] matrixB = new double[size][size];
        double[][] result = new double[size][size];

        Random rand = new Random();

        // Fill matrices with random values
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrixA[i][j] = rand.nextDouble();
                matrixB[i][j] = rand.nextDouble();
            }
        }

        while (true) {
            // Perform matrix multiplication
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    result[i][j] = 0;
                    for (int k = 0; k < size; k++) {
                        result[i][j] += matrixA[i][k] * matrixB[k][j];
                    }
                }
            }
        }
    }

    // **💾 Memory Overload: Gradually Fills RAM to Avoid Crashes**
    private static void stressMemory() {
    System.out.println("🔥 Memory Stress Started...");
    List<byte[]> memoryBlocks = new ArrayList<>();

    try {
        while (true) {
            // Allocate 10MB chunks for faster memory filling
            byte[] block = new byte[10 * 1024 * 1024]; // 10MB per block
            memoryBlocks.add(block);
            System.out.println("🛑 Allocated: " + memoryBlocks.size() * 10 + "MB");

            if (memoryBlocks.size() * 10 >= MAX_MEMORY_USAGE_MB - 50) {
                System.out.println("🚨 Memory Limit Reached! Holding memory...");
                break;
            }
        }
    } catch (OutOfMemoryError e) {
        System.out.println("🚨 Memory Stress Reached Limit! Holding memory...");
    }

    while (true) {
        // Keep memory occupied without releasing
        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) {
        }
    }
}


    // **💽 Disk Overload: Writes, Reads, and Deletes Large Files**
    private static void stressDisk(int fileIndex) {
        System.out.println("💾 Disk Stress Started on file " + fileIndex);
        Path filePath = Path.of(TEMP_FILE_PREFIX + fileIndex + ".dat");
        byte[] buffer = new byte[1024 * 1024]; // 1MB buffer

        try {
            Files.createFile(filePath);
            for (int i = 0; i < DISK_FILE_SIZE_MB; i++) {
                Files.write(filePath, buffer, StandardOpenOption.APPEND);
            }

            // Continuous read/write
            while (true) {
                Files.readAllBytes(filePath); // Read the whole file
                Files.write(filePath, buffer, StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            System.err.println("⚠ Disk error: " + e.getMessage());
        } finally {
            try {
                Files.deleteIfExists(filePath);
            } catch (IOException ignored) {
            }
        }
    }

    // **🎮 GPU Overload: Full-Screen Rapid Color Switching**
    private static void stressGpu() {
        System.out.println("🎮 GPU Stress Started...");
        JFrame frame = new JFrame("🔥 GPU STRESS TEST 🔥");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(GPU_WINDOW_SIZE, GPU_WINDOW_SIZE);
        frame.setUndecorated(true);
        frame.setVisible(true);

        BufferedImage image = new BufferedImage(GPU_WINDOW_SIZE, GPU_WINDOW_SIZE, BufferedImage.TYPE_INT_RGB);

        Timer timer = new Timer(10, e -> {
            Graphics2D g = image.createGraphics();
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.setColor(new Color(new Random().nextInt(256), new Random().nextInt(256), new Random().nextInt(256)));
            g.fillRect(0, 0, GPU_WINDOW_SIZE, GPU_WINDOW_SIZE);
            g.dispose();
            frame.getGraphics().drawImage(image, 0, 0, null);
        });

        timer.start();
    }
}
