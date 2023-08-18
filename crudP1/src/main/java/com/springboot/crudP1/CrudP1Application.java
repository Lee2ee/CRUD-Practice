package com.springboot.crudP1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@EnableJpaAuditing
@SpringBootApplication
public class CrudP1Application {

	public static void main(String[] args) {
		SpringApplication.run(CrudP1Application.class, args);
	}

	@Bean // PutMapping 사용 하기 위함, html form에서는 post,get 요청만 지원
	public HiddenHttpMethodFilter hiddenHttpMethodFilter() { return new HiddenHttpMethodFilter(); }

}
