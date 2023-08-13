public class MainController {

    public static void main(String[] args) throws InterruptedException {
        LedController ledController = new LedController();
        LcdController lcdController = new LcdController();

        while (true) {
            // Check power status
            boolean hasPower = true; // Replace with actual power status detection
            ledController.setColor(hasPower);

            // Check input status
            boolean hasInput = false; // Replace with actual input status detection
            if (hasInput) {
                lcdController.displayInput();
            } else {
                lcdController.displayNoInput();
            }

            TimeUnit.SECONDS.sleep(1);
        }
    }
}
