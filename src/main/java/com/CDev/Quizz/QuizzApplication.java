package com.CDev.Quizz;

import com.CDev.Quizz.security.Encrypte;
import com.CDev.Quizz.utils.Constante;
import com.CDev.Quizz.utils.MethodsTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class QuizzApplication extends SpringBootServletInitializer {

	public static void main(String[] args) throws Exception {

		SpringApplication.run(QuizzApplication.class, args);

		MethodsTools.isPropertiesOk();

		String test = Constante.TOKEN_KEY;
	}
	@Value("${adresseSiteAdministration}")
	public void setIpSiteAdmin(String ip) {
		Constante.IpAdresseSiteAdmin = ip;
	}

	@Value("${TOKEN_KEY}")
	public void setTokenValue(String token) {
		Constante.TOKEN_KEY = token;
	}

	@Value("${secret}")
	public void setSecretKey(String secret) { Encrypte.secret = secret;
	}

	@Value("${spring.mail.username}")
	public void setMailAdresseFrom(String mailAdresseFrom) { Constante.mailAdresseFrom = mailAdresseFrom;
	}
}
