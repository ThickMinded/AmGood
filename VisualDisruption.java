/**
 * The `VisualDisruption` class is designed to **create chaotic on-screen effects** that interfere
 * with normal user interactions. It uses **visual glitches, mouse disruptions, and random color flashes**
 * to achieve this.
 *
 * ### Functionality:
 * - Creates a **fullscreen, borderless JFrame** that overlays the entire screen.
 * - Uses a **ScheduledExecutorService** to run multiple **visual disruption tasks** in parallel.
 * - **Random flashing colors** simulate an unstable environment.
 * - **Glitchy text overlays** create a feeling of system instability.
 * - **A hazard symbol** appears at random locations for dramatic effect.
 * - **Mouse movement interference** adds unpredictability to the user's control.
 *
 * ### Core Components:
 * - **`startVisualDisruption()`** → Initializes the effects, sets up the JFrame, and starts scheduled tasks.
 * - **`startIntenseVisualEffects()`** → Manages the color flashes, hazard symbols, and text overlays.
 * - **`startMouseEffects()`** → Randomly shifts and traps the mouse pointer.
 * - **`drawHazardSymbol(Graphics g, int x, int y, int size)`** → Draws a triangular hazard symbol on the screen.
 * - **`generateScaryText()`** → Generates randomly selected "error" messages to simulate system failure.
 * - **`stopVisualDisruption()`** → Stops all scheduled effects and removes the visual disruption frame.
 *
 * ### Behavior:
 * - **Flashing Colors**: Rapidly alternates background colors in a gradient style.
 * - **Glitchy Text**: Random phrases like *"SYSTEM FAILURE"* or *"HACKED"* appear and disappear.
 * - **Mouse Interference**: Mouse pointer randomly moves or gets trapped at a fixed position.
 * - **Hazard Symbols**: Black-and-yellow symbols resembling a warning appear on-screen.
 *
 * ### Notes:
 * - **Heavy on CPU/GPU** due to constant graphical updates.
 * - Uses **Java Swing & AWT** to manipulate UI and input controls.
 * - Runs **asynchronous tasks** to make visual disruptions feel unpredictable.
 * - Can be stopped with `stopVisualDisruption()`, disposing of the JFrame and terminating tasks.
 */

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class VisualDisruption {
    private ScheduledExecutorService executor;
    private Robot robot;
    private Random random = new Random();
    private JFrame mainFrame;

    public void startVisualDisruption() {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        // Configure main disruption frame
        mainFrame = new JFrame();
        mainFrame.setUndecorated(true);
        mainFrame.setAlwaysOnTop(true);
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout());

        executor = Executors.newScheduledThreadPool(5);

        // Start the effects
        startIntenseVisualEffects();
        startMouseEffects();

        mainFrame.setVisible(true);
    }

    private void startIntenseVisualEffects() {
        // Rapid flashing colors for intense visual disruption
        executor.scheduleAtFixedRate(() -> {
            // Generate a random gradient color effect
            Graphics graphics = mainFrame.getGraphics();
            for (int i = 0; i < mainFrame.getWidth(); i += 50) {
                graphics.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
                graphics.fillRect(i, 0, 50, mainFrame.getHeight());
            }
        }, 0, 20, TimeUnit.MILLISECONDS); // Flashes every 20ms

        // Draw hazard symbol periodically
        executor.scheduleAtFixedRate(() -> {
            Graphics graphics = mainFrame.getGraphics();
            drawHazardSymbol(graphics, random.nextInt(mainFrame.getWidth() - 200), random.nextInt(mainFrame.getHeight() - 200), 200);
        }, 0, 500, TimeUnit.MILLISECONDS);

        // Glitchy overlay text
        executor.scheduleAtFixedRate(() -> {
            JLabel glitchLabel = new JLabel(generateScaryText(), JLabel.CENTER);
            glitchLabel.setFont(new Font("Arial", Font.BOLD, 64));
            glitchLabel.setForeground(new Color(
                random.nextInt(256), random.nextInt(256), random.nextInt(256),
                random.nextInt(150) + 105
            ));
            glitchLabel.setBounds(random.nextInt(800), random.nextInt(600), 800, 100);
            mainFrame.add(glitchLabel);
            mainFrame.repaint();

            new Timer(300, e -> {
                mainFrame.remove(glitchLabel);
                mainFrame.repaint();
            }).start();
        }, 0, 200, TimeUnit.MILLISECONDS);
    }

    private void startMouseEffects() {
        // Interfere with mouse movement
        executor.scheduleAtFixedRate(() -> {
            if (robot != null) {
                Point mouse = MouseInfo.getPointerInfo().getLocation();
                robot.mouseMove(
                    mouse.x + random.nextInt(21) - 10,
                    mouse.y + random.nextInt(21) - 10
                );
            }
        }, 0, 50, TimeUnit.MILLISECONDS);

        // Randomly trap mouse in a specific area
        executor.scheduleAtFixedRate(() -> {
            if (robot != null) {
                robot.mouseMove(500, 500); // Traps the mouse
            }
        }, 5, 10, TimeUnit.SECONDS);
    }

    private void drawHazardSymbol(Graphics g, int x, int y, int size) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);

        // Outer circle
        g2d.fillOval(x, y, size, size);

        // Inner triangles
        int centerX = x + size / 2;
        int centerY = y + size / 2;
        int triangleSize = size / 3;

        // Draw triangles around the circle
        g2d.setColor(Color.YELLOW);
        for (int i = 0; i < 3; i++) {
            double angle = Math.toRadians(i * 120);
            int triangleX = (int) (centerX + Math.cos(angle) * size / 3);
            int triangleY = (int) (centerY + Math.sin(angle) * size / 3);

            Polygon triangle = new Polygon();
            triangle.addPoint(centerX, centerY);
            triangle.addPoint(triangleX, triangleY);
            triangle.addPoint(
                (int) (centerX + Math.cos(angle + Math.PI / 6) * triangleSize),
                (int) (centerY + Math.sin(angle + Math.PI / 6) * triangleSize)
            );

            g2d.fillPolygon(triangle);
        }
    }

    private String generateScaryText() {
        String[] messages = {
            "SYSTEM FAILURE", "DATA LOST", "YOU CAN'T ESCAPE",
            "WHO'S WATCHING YOU?", "ERROR 404", "HACKED", "COMPROMISED", "I'M IN CONTROL"
        };
        return messages[random.nextInt(messages.length)];
    }

    public void stopVisualDisruption() {
        executor.shutdownNow();
        if (mainFrame != null) {
            mainFrame.dispose();
        }
    }
}
