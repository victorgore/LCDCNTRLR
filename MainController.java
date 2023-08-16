public class MainController {

    public static void main(String[] args) throws InterruptedException {
        LedController ledController = new LedController();
        LcdController lcdController = new LcdController();

        boolean hasInput = false;
        int blinkCount = 0;
        int maxBlinkCount = 4;

        while (true) {
            // Check power status
            boolean hasPower = true; // Replace with actual power status detection
            ledController.setColor(hasPower);

            // Check input status
            hasInput = false; // Replace with actual input status detection

            // Check low power status
            boolean lowPower = checkLowPowerStatus(); // Replace with your low power detection logic

            if (hasInput) {
                lcdController.displayInput();
                blinkCount = 0; // Reset blink count if input is detected
            } else {
                if (lowPower) {
                    ledController.setColor(false, true); // LED in yellow low power mode
                } else if (blinkCount < maxBlinkCount) {
                    ledController.turnOn();
                    TimeUnit.MILLISECONDS.sleep(500); // LED on for 500 milliseconds
                    ledController.turnOff();
                    TimeUnit.MILLISECONDS.sleep(500); // LED off for 500 milliseconds
                    blinkCount++;
                } else {
                    lcdController.displayNoInput();
                }
            }

            TimeUnit.SECONDS.sleep(3);
        }
    }

    // Replace this method with your actual low power detection logic
    private static boolean checkLowPowerStatus() {
        // Replace with code to check if the system is in low power mode
        return false; // For demonstration purposes, assuming not in low power mode
    }
}
