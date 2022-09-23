package co.up.tune.webSocket.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class WebSocketController {

	@GetMapping("/chat")
	public String chatGet() {
		log.info("@WebSocketController, chat Get()");
		return "chat";
	}
}
