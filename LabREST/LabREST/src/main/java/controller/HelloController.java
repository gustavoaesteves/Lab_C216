package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
	@GetMapping
	public MyMessage processarGetHello() {
		MyMessage myMessage = new MyMessage();
		myMessage.setInfo("new msg");
	return myMessage;
	
	}	
}
