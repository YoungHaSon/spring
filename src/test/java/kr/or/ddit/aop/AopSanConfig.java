package kr.or.ddit.aop;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;

//	<context:annotation-config/> 역할을 @Configuration에서 담당
@Configuration
@ComponentScan(basePackages = {"kr.or.ddit.board"},includeFilters = @ComponentScan.Filter(type=FilterType.ANNOTATION, value=Aspect.class))

//최상위 패키지에 있는 클래스에 Annotation을 적용해서 AOP를 찾을 수 있게 해준다.
@EnableAspectJAutoProxy //까먹지 말자. 요놈 안 넣고 AOP 안 된다고 울지 말자!!!!!!!!!!!!!!!!
public class AopSanConfig {


	
}
