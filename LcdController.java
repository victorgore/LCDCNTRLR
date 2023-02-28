import com.pi4j.component.lcd.impl.GpioLcdDisplay;
        import com.pi4j.io.gpio.*;
        import java.util.concurrent.TimeUnit;

public class LcdController {

    private final GpioController gpio;
    private final GpioPinDigitalInput inputPin;
    private final GpioLcdDisplay lcd;

    public LcdController() {
        gpio = GpioFactory.getInstance();
        inputPin = gpio.provisionDigitalInputPin(RaspiPin.GPIO_02, PinPullResistance.PULL_UP);
        lcd = new GpioLcdDisplay(16, 2, RaspiPin.GPIO_04, RaspiPin.GPIO_17, RaspiPin.GPIO_27, RaspiPin.GPIO_22, RaspiPin.GPIO_10, RaspiPin.GPIO_09, RaspiPin.GPIO_11, RaspiPin.GPIO_05);
        lcd.clear();
    }

    public void displayNoInput() {
        lcd.clear();
        lcd.write(0, "No input found!");
        lcd.setColor(GpioLcdDisplay.Color.BLUE);
    }

    public void displayInput() {
        lcd.clear();
        lcd.write(0, "Input found!");
        lcd.setColor(GpioLcdDisplay.Color.GREEN);
    }

    public static void main(String[] args) throws InterruptedException {
        LcdController lcdController = new LcdController();
        while (true) {
            // check for input status here
            boolean hasInput = false;
            if (hasInput) {
                lcdController.displayInput();
            } else {
                lcdController.displayNoInput();
            }
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
