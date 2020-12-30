package spring.controller.bit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Controller
public class MailSendController {
    @Autowired
    JavaMailSender mailSender;

    @GetMapping("/mail")
    public String mailForm() {
        return "/sub/mail/mailform";
    }

    @PostMapping("/mailsend1")
    public ModelAndView mailRead(
            @RequestParam String emailaddr,
            @RequestParam String emailcontent
    ) {
        ModelAndView mview = new ModelAndView();
        MimeMessage message = mailSender.createMimeMessage();
        try {
            message.setSubject("send by spring.");
            message.setText(emailcontent);
            message.setRecipients(MimeMessage.RecipientType.TO, InternetAddress.parse(emailaddr));
            message.setRecipients(MimeMessage.RecipientType.TO, InternetAddress.parse("yangyk7364@gmail.com"));
            mailSender.send(message);
            mview.addObject("msg", emailaddr + " success sending email");
        } catch (MessagingException e) {
            e.printStackTrace();
            mview.addObject("msg", e.getMessage());
        }

        mview.setViewName("/sub/mail/mailresult");
        return mview;
    }
}


