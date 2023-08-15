import com.pi4j.io.gpio.*;
import java.util.concurrent.TimeUnit;

public class LedController {

    private final GpioController gpio;
    private final GpioPinDigitalOutput ledPin;

    public LedController() {
        gpio = GpioFactory.getInstance();
        ledPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, "LED", PinState.HIGH);
    }

    public void turnOn() {
        ledPin.high();
    }

    public void turnOff() {
        ledPin.low();
    }

    public void setColor(boolean hasPower, boolean lowPower) {
        if (hasPower) {
            // If there is power, turn the LED blue
            ledPin.setPwm(0);
            ledPin.setPwmRange(255);
            ledPin.setPwm(0); // blue
        } else if (lowPower) {
            // If the power is cut and low power mode, turn the LED yellow
            ledPin.setPwm(0);
            ledPin.setPwmRange(255);
            ledPin.setPwm(127); // yellow (mix of red and green)
        } else {
            // If the power is cut, turn the LED red
            ledPin.setPwm(0);
            ledPin.setPwmRange(255);
            ledPin.setPwm(255); // red
        }
    }

    public static void main(String[] args) throws InterruptedException {
        LedController ledController = new LedController();
        while (true) {
            // Check power status and low power mode
            boolean hasPower = true;
            boolean lowPower = false; // Replace with actual low power detection
            ledController.setColor(hasPower, lowPower);
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
