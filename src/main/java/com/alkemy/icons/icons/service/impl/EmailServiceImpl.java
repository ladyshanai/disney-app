package com.alkemy.icons.icons.service.impl;

import com.alkemy.icons.icons.service.EmailService;
import org.apache.coyote.Request;
import org.apache.coyote.Response;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.core.env.Environment;

import java.io.IOException;
import java.lang.reflect.Method;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private Environment env;

    @Value("${alkemy.icons.emai.sender}")
    private String emailSender;
    @Value("${alkemy.icons.emai.enabled}")
    private boolean enabled;

    public void sendWelcomeEmailTo(String to){
        if (!enabled){
            return;
        }
        String apiKey = env.getProperty("EMAIL.APY.KEY");

        Email fromEMail = new Email(emailSender);
        Email toEmail = new  Email(to);
        Content content  = new content(
                "text/plain",
                "Welcome Alkemy Icons"
        );
        String subject = "Alkemy Icons";

        Mail mail = new Mail(fromEmail, subject, toEmail,content);
        SendGrid sg = new SendGrid(apiKey);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);

            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex){
            System.out.println("Error trying to send the email");
        }

    }
}
