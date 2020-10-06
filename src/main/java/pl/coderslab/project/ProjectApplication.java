package pl.coderslab.project;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@EnableScheduling
public class ProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectApplication.class, args);
    }

//        @Autowired(required = false)
//        private JavaMailSender mailSender;
//
//        @Scheduled(cron = "0 * * * * *")
//        public void sendMail() throws MessagingException, IOException, TemplateException {
//            FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
//            freeMarkerConfigurer.setTemplateLoaderPath("classpath:templates/mail/templates");
//            Configuration config = freeMarkerConfigurer.createConfiguration();
//            Template mailTemplate = config.getTemplate("test-mail.ftlh");
//            Map<String, Object> model = new HashMap<>();
//            model.put("username", "joesmith");
//            model.put("today", LocalDate.now());
//            model.put("orders", List.of("Bakłażan", "Kalarepa", "Wężymord"));
//            String mailBody = FreeMarkerTemplateUtils.processTemplateIntoString(mailTemplate, model);
//
//            MimeMessage mimeMessage = mailSender.createMimeMessage();
//            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
//            messageHelper.setFrom("stevejob@apple.com");
//            messageHelper.setSubject("Cudowne życie programisty");
//            messageHelper.setBcc(new String[]{"michal.kupisinski@gmail.com"});
//            messageHelper.setText(mailBody, true);
//            mailSender.send(mimeMessage);
//        }
    }

