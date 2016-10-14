package com.eiecc.fire.spring_4_no_xml.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.eiecc.fire.spring_4_no_xml.email.domain.Order;

@Service
public class SimpleOrderManager {
	
	@Autowired
	private MailSender mailSender;
	
	@Autowired
    private SimpleMailMessage templateMessage;
	
	public void placeOrder(Order order) {

        // Do the business calculations...

        // Call the collaborators to persist the order...

        // Create a thread safe "copy" of the template message and customize it
        SimpleMailMessage msg = new SimpleMailMessage(this.templateMessage);
        msg.setTo(order.getEmail());
        msg.setText(
            "Dear " + order.getFirstName()
                + order.getLastName()
                + ", thank you for placing order. Your order number is "
                + order.getId());
        try{
            this.mailSender.send(msg);
        }
        catch (MailException ex) {
            // simply log it and go on...
            System.err.println(ex.getMessage());
        }
    }

}
