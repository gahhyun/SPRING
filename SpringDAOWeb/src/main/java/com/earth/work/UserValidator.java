package com.earth.work;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

//검증이라는 관심사로 분리
//Validator : 객체를 검증하기 위한 인터페이스
public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {		//이 검증기로 검증가능한 객체인지 알려주는 메서드
		//return User.class.equals(clazz);			//clazz가 User 또는 그 자손인지 확인
		return User.class.isAssignableFrom(clazz);  //equals와 비슷한 메서드
	}

	@Override	
	public void validate(Object target, Errors errors) {	//객체를 검증하는 메서드 - target:검증할 객체, errors:검증시 발생한 에러저장소
		System.out.println("UserValidator의 validate() 호출됨");
		
		User user = (User)target;
		String id = user.getId();
		
		if(id == null | "".equals(id.trim())) {
			errors.rejectValue("id", "requied");
		}
	}

}
