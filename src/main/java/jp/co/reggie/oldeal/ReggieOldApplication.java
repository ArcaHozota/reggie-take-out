package jp.co.reggie.oldeal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Administrator
 * @date 2022-11-08
 */
@Slf4j
@SpringBootApplication
@ServletComponentScan
@EnableTransactionManagement
public class ReggieOldApplication {
	public static void main(String[] args) {
		SpringApplication.run(ReggieOldApplication.class, args);
		log.info("本工程啓動成功......");
	}
}
