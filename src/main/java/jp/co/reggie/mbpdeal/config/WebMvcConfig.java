package jp.co.reggie.mbpdeal.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import lombok.extern.slf4j.Slf4j;

/**
 * SpringMVC環境變量配置類
 *
 * @author Administrator
 * @since 1.00beta
 */
@Slf4j
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

	/**
	 * 擴展SpringMVC框架的消息轉換器
	 *
	 * @param converters 轉換器
	 */
	@Override
	protected void extendMessageConverters(final List<HttpMessageConverter<?>> converters) {
		log.info("擴展消息轉換器完畢");
		// 創建消息轉換器對象；
		final MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
		// 設置對象轉換器，底層使用Jackson將Java對象轉為JSON；
		messageConverter.setObjectMapper(new JacksonObjectMapper());
		// 將上述消息轉換器追加到SpringMVC框架的轉換器容器中；
		converters.add(0, messageConverter);
	}

	/**
	 * 設置靜態資源映射
	 *
	 * @param registry 注冊説明
	 */
	@Override
	protected void addResourceHandlers(final ResourceHandlerRegistry registry) {
		log.info("靜態資源映射開始...");
		registry.addResourceHandler("/backend/**").addResourceLocations("classpath:/backend/");
		registry.addResourceHandler("/front/**").addResourceLocations("classpath:/front/");
	}
}
