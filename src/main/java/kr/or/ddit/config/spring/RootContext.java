package kr.or.ddit.config.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//service, repository 두 @을 대상으로 스캔하겠다
@Configuration	
@ImportResource({
				"classpath:kr/or/ddit/config/spring/application-scheduler.xml",
				"classpath:kr/or/ddit/config/spring/application-batch.xml"
				})
		//설정파일이라는 표시!					//요거 중요! 안하면 bean이 여러개 생김
@ComponentScan(basePackages = "kr.or.ddit", useDefaultFilters = false
						, includeFilters = {@Filter(type = FilterType.ANNOTATION, classes = {Service.class , Repository.class})})
public class RootContext {

}
