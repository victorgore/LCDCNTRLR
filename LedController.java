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

    public void setColor(boolean hasPower) {
        if (hasPower) {
            // If there is power, turn the LED blue
            ledPin.setPwm(0);
            ledPin.setPwmRange(255);
            ledPin.setPwm(0); // blue
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
            // check the power status here
            boolean hasPower = true;
            ledController.setColor(hasPower);
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
