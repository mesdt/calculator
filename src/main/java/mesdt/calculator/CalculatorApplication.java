package mesdt.calculator;

import java.util.List;

import javax.servlet.Filter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.filter.HttpPutFormContentFilter;

@SpringBootApplication
public class CalculatorApplication {

	protected final Log log = LogFactory.getLog(getClass());

	public static void main(String[] args) {
		SpringApplication.run(CalculatorApplication.class, args);
	}

	@Bean
	public HttpMessageConverters httpMessageConverters() {
		HttpMessageConverters hmcs = new HttpMessageConverters() {
			@Override
			protected List<HttpMessageConverter<?>> postProcessConverters(List<HttpMessageConverter<?>> cs) {
				cs.removeIf(hmc -> hmc instanceof StringHttpMessageConverter && false);
				return cs;
			}
		};
		hmcs.forEach(hmc -> log.info("httpMessageConverter: " + hmc));
		return hmcs;
	}

	@Bean
	public Filter httpPutFormContentFilter() {
		return new HttpPutFormContentFilter();
	}

}
