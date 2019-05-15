package id.bts.PiWebRestIoT.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import id.bts.PiWebRestIoT.services.GpioService;

@RestController
@RequestMapping("/api/v1")
public class GpioController {

	@Autowired
	private GpioService gpioService;
	
	private static int switchStatusRuang1 = 0;
	private static int switchStatusRuang2 = 0;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping(path = {"/ruang1", "/ruang1/"})
	@ResponseStatus(code = HttpStatus.OK)
	public void switchRuang1() {
		if (switchStatusRuang1 == 0) {
			gpioService.switchOnLedRuang1();
			switchStatusRuang1 = 1;
		} else {
			gpioService.switchOffLedRuang1();
			switchStatusRuang1 = 0;
		}
		
		log.debug(Integer.toString(switchStatusRuang1));
	}
	
	@GetMapping(path = {"/ruang2", "/ruang2/"})
	@ResponseStatus(code = HttpStatus.OK)
	public void switchRuang2() {
		if (switchStatusRuang2 == 0) {
			gpioService.switchOnLedRuang1();
			switchStatusRuang2 = 1;
		} else {
			gpioService.switchOffLedRuang1();
			switchStatusRuang2 = 0;
		}
		
		log.debug(Integer.toString(switchStatusRuang2));
	}
}
