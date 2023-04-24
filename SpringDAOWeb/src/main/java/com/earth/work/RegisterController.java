package com.earth.work;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

@Controller
public class RegisterController {
	
	@Autowired	//인잭션
	UserDao userDao;
	
	final int FAIL = 0;
	

	@GetMapping("/register/add")
	public String register() {
		return "registerForm";		
	}
	
	@PostMapping("/register/save")
	public String save(@Valid User user, BindingResult result, Model m) throws UnsupportedEncodingException {
		//유효성 검사  -> 관심사로 분리 , 따로 class만듦
//		if(!isValid(user)) {	//isVaid는 ()개체에 대한 일부 유효성 검사를 수행하고 개체가 유효한지 여부를 나타내는 부울 값을 반환합니다.
//			String msg = URLEncoder.encode("id를 잘못입력했습니다", "UTF-8");
//			return "redirect:/register/add2?msg="+msg;			 //다시 입력받는 화면으로
//		}
		
		System.out.println("user = " + user);
		System.out.println("result = " + result);
		
		// User 객체 검증한 결과 에러가 있으면, 에러를 보여줌
		//DB에 새회원 정보를 저장
		if (!result.hasErrors()) {
			int rowCnt = userDao.insertUser(user);
			if(rowCnt != FAIL) return "registerinfo";
		}
		return "registerForm";
	}
	
	@InitBinder		// WebDataBinder에 검증기(Validator) 등록함
	public void registerValidate(WebDataBinder binder) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
		//UserValidator를 WebDataBinder로 등록함 
		binder.setValidator(new UserValidator());  
		
		//binder에 검증기가 등록되었는지 확인코드
		List<Validator> validatorList = binder.getValidators();
		System.out.println("validatorList = " + validatorList);
	}

	private boolean isValid(User user) {
		

		return false; 
		/*  return false 하면 페이지 안넘어감 */
	}

}
