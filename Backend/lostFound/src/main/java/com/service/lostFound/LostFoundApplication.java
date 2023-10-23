package com.service.lostFound;

import com.service.lostFound.Config.TwilioConfig;
import com.twilio.Twilio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LostFoundApplication {

	@Autowired
	private TwilioConfig twilioConfig;
	public  void intTwilio(){
				Twilio.init(twilioConfig.getAccountSid(),twilioConfig.getAuthToken());
	}

	public static void main(String[] args) {
		SpringApplication.run(LostFoundApplication.class, args);
	}


}
