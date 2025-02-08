# 😈 AmGood – The Experiment in System Interference Without Admin Privileges 🎭

## ⚠️ Disclaimer
This is **NOT** malware. AmGood is a test to see how much chaos a normal `.exe` can cause **without admin privileges**. It **does not** modify system files, install malicious software, or require elevated permissions. 

However, **this program is extremely annoying**. It pushes Windows to its **absolute limits** at the user level, testing just how disruptive an executable can be **without breaking security barriers**. **Use it responsibly**—I am **not responsible** for any consequences that arise from using this program.

That being said, **this code is an absolute mess**. 💀 Could I have written it better? **Yes.** Did I care? **Not at all.** As long as it works, that’s all that matters.

---

## 🏴‍☠️ What Does AmGood Actually Do?

If you're looking for **clean, optimized code**, you are **in the wrong place**. This is a **hacked-together** mess that simply gets the job done.

### 🎨 Visual Disruption
- Covers your screen with **flashing colors, glitchy text, and fake error messages**.
- **Traps your mouse** in a specific area (so you **can't escape**).
- Generates **fake system warnings** like *"WHO'S WATCHING YOU?"* and *"SYSTEM FAILURE."*
- **Makes it nearly impossible** to use your PC normally.

### 🔊 Forces System Volume to Maximum
- **Continuously forces volume up** (even if you try to lower it).
- Uses **PowerShell key emulation** to **spam Volume Up**.

### 💻 CPU Overload & Stress Test
- **Maxes out CPU usage** whenever it's below 100%.
- Uses brute-force calculations to **make the system slow and unresponsive**.
- On **low-end systems**, this often results in an **automatic system crash**.

### 🚀 Adds Itself to Windows Startup
- **Automatically copies itself** to the Windows Startup folder.
- **Launches on every reboot** until manually removed.

### 🔍 Task Manager Detection
- **Knows when Task Manager is opened**.
- Reacts accordingly when you try to shut it down.

### 🛑 Shutdown Prevention & Secret Escape Sequence
- **AmGood does NOT close easily.**
- There is, however, a **secret shutdown sequence**:
  - **Press A + S** on your keyboard.
  - If entered correctly, **AmGood will stop and exit**.

(Good luck remembering that **while your screen is flashing** like a haunted computer. And also sometimes the program gets overloaded and doesn't accept any keybinds. So don't be suprised that the program doesn't close even if you pressed the sequence)

---

# How to Install and Use the Program

Alright, listen up! This is my first time making software, so don’t come at me saying things are messy or incomplete. I know it’s not perfect, but I’ve included everything you need to run it. You’ll have to do a bit of work yourself because I didn’t provide a compiled JAR or a pre-packaged setup.

---

## What You’ll Need:
1. **Java Development Kit (JDK)**:
   - You need JDK 17 or higher. Download it from [Oracle JDK](https://www.oracle.com/java/technologies/javase-downloads.html) or [OpenJDK](https://openjdk.java.net/).
   - Set up your environment variables (`JAVA_HOME`) and add the `bin` folder of the JDK to your system’s PATH. If you don’t know how to do that, Google it!
NOTE: You can skip through step 2 and 3 if you downloaded the librarys package that i provided 
2. **JavaFX SDK**:
   - Download the JavaFX SDK from [Gluon](https://gluonhq.com/products/javafx/).
   - Extract it somewhere. You’ll need the `lib` folder for compiling and running the program.

3. **The Libraries**:
   - I’ve included all the required JAR files in the project folder. These are the ones you’ll need:
     - `javafx.base.jar`
     - `javafx.controls.jar`
     - `javafx.fxml.jar`
     - `javafx.graphics.jar`
     - `javafx.media.jar`
     - `javafx.swing.jar`
     - `javafx.web.jar`
     - `jna-jpms-5.16.0.jar`
     - `jna-platform-5.16.0.jar`
     - `jnativehook-2.2.2.jar`
   - Put all of these in a folder called `lib` inside the project directory. Don’t mess this up.

4. **Other Files**:
   - These files need to stay in the same directory as the compiled program:
     - `Hamood.wav`
     - `meow.wav`
     - `test.mp4`
     - `you are an idiot!.mp4`
     - `heheicon.ico`

---

## How to Set It Up:
1. **Get the Files**:
   - Download everything and dump it into one folder, like `C:\amGood`. No fancy organization is needed—just make sure you’ve got it all.

2. **Organize the Libraries**:
   - Create a folder named `lib` in the same directory and throw all the JAR files listed above into it.

3. **Compile the Code**:
   - Open Command Prompt, go to your project folder:
     ```cmd
     cd C:\amGood
     ```
   - Run this to compile the program:
     ```cmd
     javac --module-path lib --add-modules javafx.controls,javafx.fxml,javafx.graphics,javafx.media,javafx.swing,javafx.web -d bin *.java
     ```
   - This will create a `bin` folder with all the compiled class files.

4. **Run the Program**:
   - To run it, use this command:
     ```cmd
     java --module-path lib --add-modules javafx.controls,javafx.fxml,javafx.graphics,javafx.media,javafx.swing,javafx.web -cp bin hehehaMeow
     ```
   - If it doesn’t work, double-check that all files are where they’re supposed to be. If it still doesn’t work, well, I tried my best.

---

## Final Notes:
I know this isn’t the cleanest setup, but hey, it works (at least for me). If you run into issues, feel free to scream into the void because I’m probably learning as much as you are. Enjoy!


### ✅ Required Installations
1. **Java Development Kit (JDK) – Version 8 or Higher** 🛠️
   - I will **upload a pre-configured JDK** that works perfectly with AmGood.
   - If installing yourself, **JDK 8 or later** is required.

2. **JavaFX – For Media Playback** 🎥
   - AmGood plays videos as part of its disruption, so **JavaFX is required**.
   - If your JDK **does not** include JavaFX, install it separately.

3. **JNativeHook – For Global Key Listening** 🎹
   - Allows AmGood to detect keyboard shortcuts even **when the window is not in focus**.
   - Can be downloaded from the **JNativeHook GitHub**.

---

## 💡 Why Did I Make This?
The real reason I created AmGood is simple:

- I wanted to **test the boundaries** of what a normal `.exe` can do **without admin rights**.
- I was curious **how much disruption** could be achieved at the **user level**.
- Could I have made a program that **completely locks a computer**? **Yes.**
- Could I have made it **auto-crash Windows** on boot? **Yes.**
- **But that wouldn't be funny.**
- Instead, I wanted **something annoying but functional**—something that **makes people question how it even works**.

I've tested AmGood on **various systems**, and **low-end PCs struggle the most**—some **crash automatically** due to **CPU and GPU overload**.

---

## ⚠️ Important Notes & Final Warning
- **This program is NOT optimized.** It’s a chaotic mess, **but it works, so I don’t care.**
- **No admin rights are required.** Everything runs at **user level**.
- **This is for fun, not for harm.** Don't use this to mess with people **in ways that could cause real issues**.
- **You’ll probably need Task Manager** to kill it if you forget the **shutdown shortcut**.
- **If you use this program, use it responsibly.**  
  **I am NOT responsible for any misuse, data loss, crashes, or unexpected behaviors caused by AmGood.**

---

## 📝 Final Thoughts
AmGood is **ridiculous, chaotic, and inefficient**—but it **proves a point**.

If you’re interested in **exploring the limits** of what a simple Windows program **can do without admin rights**, this project is for you.

Otherwise, you should **probably stay far, far away from it**.

🔻 **You have been warned.** 😈

## 🚧 Possible Improvements & Features 🚧

### 🛠 Bugs & Issues  
- 🐛 **Video Lagging Under Heavy Load** – The "I Am an Idiot!" video sometimes lags or doesn’t play properly when the system is overloaded. It depends on how powerful the PC is and how many CPU cores it has since the program spawns multiple threads.  
- 🖥️ **Multi-Monitor Mayhem** – Right now, the program mostly affects one screen at a time. It could be improved to **spread across all monitors**, making escape even harder.  
- 🔊 **Volume Control Lag** – The PowerShell-based method for increasing volume works, but sometimes there’s a small delay. A more direct approach might be better.  

### ✨ Feature Ideas  
- 🔄 **Self-Replication** – The program could **copy itself all over the PC** (Desktop, Documents, Startup, etc.), making it even harder to stop. Right now, it just places itself in Startup.  
- 🔐 **File Encryption (Like Ransomware, But Not Really)** – I haven’t tested if the program can **encrypt user files**. It would be interesting to see if that’s possible, but that would turn it into actual malware, which I didn’t want.  
- 📡 **Data Theft & Exfiltration** – It might be possible to make AmGood **steal user data and send it somewhere**, but that would make it spyware, which wasn’t my goal.  
- 💾 **Fake System Corruption** – It could be programmed to **pretend Windows is broken**, showing fake system errors, crashing Explorer, or even hiding Task Manager entirely.  
- ⏳ **Delayed Activation** – Instead of running instantly, the program could **wait a random amount of time before starting**, making it harder to detect.  
- 🎭 **Fake Windows Update** – It could **simulate a Windows Update screen**, making it look like the PC is updating while everything goes wrong in the background.  
- 🕵️ **Detect User Activity** – It could track when the user is typing or gaming and **randomly interrupt them** at the worst moments.  
- ⏬ **Slow Motion Mode** – Randomly **slow down mouse and keyboard input**, making everything frustratingly sluggish.  
- 🔁 **Window Cloning** – Whenever the user closes a window, **duplicate it instead**. Close one? Two more pop up.  
- 📢 **Random Creepy Sounds** – Play **distorted whispers or random system sounds** at unpredictable intervals.  
- 🔥 **Fake Blue Screen of Death** – Flash a **realistic BSOD for a few seconds**, then let the program continue running like nothing happened.  
- 🚷 **Disable ALT+TAB & Task Switcher** – Prevent the user from switching between applications, forcing them to deal with the chaos.  
- 🖱️ **Mouse Reverse & Inversion** – Randomly **invert mouse controls** or make the pointer move in the opposite direction.  
- ⏳ **Delayed Mouse Clicks** – Introduce a random delay between clicking and when the action actually happens.  
- 🔄 **Reversed Keyboard Input** – Typing "hello" would appear as "olleh" on the screen.  
- 🛑 **Fake Shutdown Screen** – Make it seem like the computer is shutting down, then go back to normal randomly.  
- 📝 **Replace Clipboard Contents** – Whenever the user copies something, replace it with random weird text.  
- ⏯️ **Randomly Pause/Resume YouTube & Spotify** – If media is playing, randomly **pause or mute it**, making the user think something is broken.  
- 🗑️ **Make Windows Act Drunk** – Randomly minimize/maximize windows, move icons around, or make the Start Menu flicker.  
- 🔗 **Fake Keyboard Lag** – Delay typing randomly or insert extra keystrokes to make typing impossible.  
- 🚫 **Close Important Programs** – Randomly close Notepad, Chrome, or even Steam while gaming just to be annoying.  
- 🎨 **Force Dark Mode or High Contrast Mode** – Change Windows display settings to make it visually unappealing.  
- 🎭 **Swap Desktop Icons** – Move icons around or swap them with fake versions to confuse the user.  
- 💾 **Create Fake Read-Only Files** – Make random files appear "locked" or "in use" to frustrate the user.  
- 🔒 **Random Lock Screen Activation** – Occasionally lock the screen, forcing the user to log back in.  
- 🗿 **Persistent Pop-ups** – Show fake security warnings, software update messages, or annoying reminders that never go away.  
- 🚨 **Flash LED Keyboard Lights** – If using a mechanical keyboard, make the Caps Lock, Num Lock, and Scroll Lock lights flash randomly.  

---

This is just a list of **possible** improvements and ideas that could make AmGood even more frustrating to deal with. If you have ideas of your own, feel free to experiment—but **use it responsibly**.  

I could’ve made this program **completely brick the computer**, but that wouldn’t be funny. The idea was to push the limits of what a normal `.exe` can do without admin rights, **not to actually harm anyone’s system**. That being said, low-end PCs might **struggle hard** and even **crash automatically** from the CPU overload. 

Ill provide a custom jdk to make it easier to use this program without having to add librarys for people that are lazy to test out the program. I did also make an `.exe` realease that works perfectly fine but i am not going to publish that cuz it might cause some choas. 
