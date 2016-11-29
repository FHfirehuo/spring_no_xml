package com.eiecc.fire.spring_4_no_xml.email.service;

import java.io.File;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
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
        msg.setSubject("FIREHUO 激活");
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
	
	@Autowired
	private JavaMailSender mailSender2;
	
	public void placeOrder2(final  Order order) {

		// Do the business calculations...

        // Call the collaborators to persist the order...

        MimeMessagePreparator preparator = new MimeMessagePreparator() {

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {

                mimeMessage.setRecipient(Message.RecipientType.TO,
                        new InternetAddress(order.getEmail()));
                mimeMessage.setFrom(new InternetAddress("liu511374191@sina.com"));
                mimeMessage.setText(
                        "Dear " + order.getFirstName() + " "
                            + order.getLastName()
                            + ", thank you for placing order. Your order number is "
                            + order.getId());
            }


           
        };

        try {
            mailSender2.send(preparator);
        }
        catch (MailException ex) {
            // simply log it and go on...
            System.err.println(ex.getMessage());
        }
    }
	
	/***
	 * 带附件
	 * @param order
	 */
	public void placeOrder3(Order order) {
		

		try {
			MimeMessage message = mailSender2.createMimeMessage();

			// use the true flag to indicate you need a multipart message
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setTo(order.getEmail());
			helper.setFrom("liu511374191@sina.com");
			helper.setText("Check out this image!");

			// let's attach the infamous windows Sample file (this time copied to c:/)
			
			FileSystemResource file = new FileSystemResource(new File("D:/user/fire/upload/image/picture/20161108/3f79de1d57824f8b9ce6e5b204eec588.jpg"));
			helper.addAttachment("CoolImage.jpg", file); //附件名称

			mailSender2.send(message);
		} catch (MailException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}
	
	
	/***
	 * 附件显示在正文
	 * @param order
	 * 
	 * 使用指定的Content-ID（上例中的identifier1234）将内联资源添加到mime消息中。 添加文本和资源的顺序非常重要。
	 *  确保首先添加文本，然后添加资源。 如果你反过来做，它不会工作！
	 */
	public void placeOrder4(Order order) {
		

		try {
			MimeMessage message = mailSender2.createMimeMessage();

			// use the true flag to indicate you need a multipart message
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setTo(order.getEmail());
			helper.setFrom("liu511374191@sina.com");

			helper.setText("<html><body><img src='cid:identifier1234'></body></html>", true);
			FileSystemResource res = new FileSystemResource(new File("D:/user/fire/upload/image/picture/20161108/3f79de1d57824f8b9ce6e5b204eec588.jpg"));
			helper.addInline("identifier1234", res);

			mailSender2.send(message);
		} catch (MailException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}
    

}
