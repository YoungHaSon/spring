package kr.or.ddit.ioc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//자바 파일을 설정 파일로 만드는 방법!

// DefaultFilters : @Controller, @Service, @Repository, @Componen
// useDefaultFilter를 false로 선언하면 개발자가 원하는 어노테이션만 스캔 가능!
// ex : @Controller만 스캔?

@Configuration
@ComponentScan(basePackages = {"kr.or.ddit"}, useDefaultFilters = true)
public class ApplicationIocBeansScanConfig {

	
}
