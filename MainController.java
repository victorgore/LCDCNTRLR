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

            if (hasInput) {
                lcdController.displayInput();
                blinkCount = 0; // Reset blink count if input is detected
            } else {
                if (blinkCount < maxBlinkCount) {
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
}
