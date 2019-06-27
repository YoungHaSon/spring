package kr.or.ddit.user.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserVoValidator implements Validator {

	//뭐를 검증할라고? UserVo 객체로 부터
	@Override
	public boolean supports(Class<?> clazz) {
		return UserVo.class.isAssignableFrom(clazz);
	}

	//실제 검증하는 곳!
	@Override			//검증할 객체, 메세지를 담을 객체?
	public void validate(Object target, Errors errors) {
		//데이터 검증
		UserVo userVo = (UserVo)target;
		
		//직접 우리가 구현하는부분
		//ex) 사용자 아이디 길이 4글자 이상
		if(userVo.getUserId().length()<=3) {
			//에러코드 정의하기 나름..
			errors.rejectValue("userId", "length");
		}
		//사용자 이름이 2글자 이상
		if(userVo.getName().length()<2) {
			errors.rejectValue("name", "length");
		}
		
		
	}
}
