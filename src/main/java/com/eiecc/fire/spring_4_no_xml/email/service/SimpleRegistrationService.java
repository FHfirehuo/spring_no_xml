package com.eiecc.fire.spring_4_no_xml.email.service;

import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.eiecc.fire.spring_4_no_xml.email.domain.Order;

@Service
public class SimpleRegistrationService {

	@Autowired
	private JavaMailSender mailSender;

	
	public void register(Order order) {

        // Do the registration logic...

        sendConfirmationEmail(order);
    }

    private void sendConfirmationEmail(final Order order) {
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
                message.setTo(order.getEmail());
                message.setFrom("liu511374191@sina.com"); // could be parameterized...
                Map model = new HashMap();
                model.put("user", order);

            } 
        };
        this.mailSender.send(preparator);
    }
}
