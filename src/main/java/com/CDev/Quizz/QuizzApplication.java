package com.CDev.Quizz;

import com.CDev.Quizz.utils.Constante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class QuizzApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {

		SpringApplication.run(QuizzApplication.class, args);

	}
	@Value("${adresseSiteAdministration}")
	public void setIpSiteAdmin(String ip) {
		Constante.IpAdresseSiteAdmin = ip;
	}
}
