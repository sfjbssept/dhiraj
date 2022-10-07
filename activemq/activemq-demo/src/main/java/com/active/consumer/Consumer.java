package com.active.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

	@JmsListener(destination = "standalone.queue")
	public void consume(String msg) {
		System.out.println("The message that has been publisged is consumed"+msg);
	}
}
