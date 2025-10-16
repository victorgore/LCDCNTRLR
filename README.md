Raspberry Pi LCD & LED Controller

Overview
This is a Java-based control for an LCD display and LED indicator on Raspberry Pi, using the Pi4J library to monitor input status and display system information.

Hardware Requirements
- Raspberry Pi (any model with GPIO)
- 16x2 LCD Display
- LED (RGB capable for colour control)
- Push button/switch for input detection
- Breadboard and jumper wires

Wiring Configuration

LCD Connections
- LCD Pins to GPIO Pins:
  - RS: GPIO 4 (BCM 4)
  - EN: GPIO 17 (BCM 17)
  - D4: GPIO 27 (BCM 27)
  - D5: GPIO 22 (BCM 22)
  - D6: GPIO 10 (BCM 10)
  - D7: GPIO 9 (BCM 9)
  - Backlight: GPIO 11 (BCM 11)
  - Backlight Control: GPIO 5 (BCM 5)

LED Connection
- LED: GPIO 0 (BCM 17)

Input Detection
- Input Pin: GPIO 2 (BCM 2) with pull-up resistor

Software Dependencies
- Java JDK 8 or later
- Pi4J library
- Raspberry Pi OS

LcdController
- Controls 16x2 LCD display
- Displays input status messages
- Manages LCD backlight colors (Red/Green)

LedController
- Controls LED with PWM for color mixing
- Supports three color states:
  - Blue: Normal power mode
  - Yellow: Low power mode
  - Red: Power cut mode

MainController
- Main application controller
- Integrates LCD and LED functionality
- Implements blinking logic for visual alerts
- Monitors input status and power conditions

Features

LCD Display Modes
- Input Detected**: Green "Input found!" message
- No Input: Red "No input found!" message

LED Indicator States
- Blue: System has normal power
- Yellow: Low power mode active
- Red: Power failure condition
- Blinking: Visual alert pattern (4 blinks max)

Notes
- Requires running on Raspberry Pi hardware
- GPIO pin numbers use WiringPi numbering scheme
- Adjust PWM values in `LedController` for precise color control
- Consider adding error handling for production use
