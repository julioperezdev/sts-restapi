package com.spanishTongueSound.sts.service.implementation;

import com.spanishTongueSound.sts.exception.service.ErrorOccurredWhenSendingEmailException;
import com.spanishTongueSound.sts.model.NotificationEmail;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
class MailServiceImplementation {

    //Logger logger = LoggerFactory.getLogger("");

    private final JavaMailSender mailSender;
    private final MailContentBuilderServiceImplementation mailContentBuilderServiceImplementation;


    @Async
    void sendMail(NotificationEmail notificationEmail) {
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom("gerencia@naturismoysaludintegral.com");
            //messageHelper.setTo(notificationEmail.getRecipient());
            messageHelper.setTo(notificationEmail.getRecipient());
            messageHelper.setSubject(notificationEmail.getSubject());
            messageHelper.setText(notificationEmail.getBody());
            //messageHelper.setText(mailContentBuilder.build(notificationEmail.getBody()));
        };
        try {
            mailSender.send(messagePreparator);
            log.info("Activation email sent!!");
            //logger.info("Activation email sent!!");
        } catch (MailException e) {
            log.error("Exception occurred when sending mail", e);
            //logger.error("Exception occurred when sending mail", e);
            throw new ErrorOccurredWhenSendingEmailException(notificationEmail.getRecipient());
        }
    }

}