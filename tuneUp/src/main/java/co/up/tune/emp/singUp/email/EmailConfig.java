package co.up.tune.emp.singUp.email;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class EmailConfig {
    @Bean
    public JavaMailSender emailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();

        javaMailSender.setHost("smtp.naver.com");//메인 도메인 서버(smtp 서버 주소)
        javaMailSender.setUsername("gayun0820");
        javaMailSender.setPassword("dudgh042582!@");

        javaMailSender.setPort(465);//메일 인증서버 포트

        javaMailSender.setJavaMailProperties(getMailProperties());//메일 인증서버 정보 가져오기

        return javaMailSender;
    }

    private Properties getMailProperties() {
        Properties properties = new Properties();
        properties.setProperty("mail.transport.protocol", "smtp");//프로토콜 설정
        properties.setProperty("mail.smtp.auth", "true");//smtp 인증
        properties.setProperty("mail.smtp.starttls.enable", "true");//smtp strattles 사용
        properties.setProperty("mail.debug", "true");//디버그 사용
        properties.setProperty("mail.smtp.ssl.trust","smtp.naver.com");//ssl 인증 서버는 smtp.naver.com
        properties.setProperty("mail.smtp.ssl.enable","true");//ssl사용
        return properties;
    }
}