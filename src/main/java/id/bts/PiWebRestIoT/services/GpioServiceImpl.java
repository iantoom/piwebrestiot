package id.bts.PiWebRestIoT.services;

import org.springframework.stereotype.Service;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.util.CommandArgumentParser;

@Service
public class GpioServiceImpl implements GpioService {

	// create gpio controller instance
	final GpioController gpio = GpioFactory.getInstance();

	// lookup the pin by address
	Pin pinRuang1 = CommandArgumentParser.getPin(RaspiPin.class, // pin provider class to obtain pin instance from
			RaspiPin.GPIO_06); // argument array to search in (pin 06 is based on sample project)

	Pin pinRuang2 = CommandArgumentParser.getPin(RaspiPin.class, // pin provider class to obtain pin instance from
			RaspiPin.GPIO_07); // argument array to search in (pin 06 is based on sample project)

	GpioPinDigitalOutput outputRuang1 = gpio.provisionDigitalOutputPin(pinRuang1, "My Output", PinState.LOW);

	GpioPinDigitalOutput outputRuang2 = gpio.provisionDigitalOutputPin(pinRuang2, "My Output", PinState.LOW);

	@Override
	public void switchOnLedRuang1() {
		outputRuang1.high();
	}

	@Override
	public void switchOnLedRuang2() {
		outputRuang2.high();
	}

	@Override
	public void switchOffLedRuang1() {
		outputRuang1.low();
	}

	@Override
	public void switchOffLedRuang2() {
		outputRuang2.low();
	}

}
