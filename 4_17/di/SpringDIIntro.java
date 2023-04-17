package com.earth.di;

import java.util.HashMap;
import java.util.Map;

/*
 * 빈(Bean)
 * 	1) Spring (IOC) Container가 관리하는 객체
 *  2) ApplicationContext가 담고 있는 객체
 *  3) 일반적인 객체 생성 방법 만든 객체는 Bean이 아님
 */
class Car{}
class SuvCar extends Car{}
class ElectronCar extends Car{}
class Engine {}

//bean객체들의 저장소
//변경에 유리한 코드
//ApplicationContext 정의
class AppContrxt{
	Map map;			//객체 저장소(key-value 형식, car-0x100(주소/위치)...)
	
	public AppContrxt() {	//생성자
		//1.하드 코딩 (하드코딩은 상수나 변수에 들어가는 값을 소스코드에 직접 쓰는 방식을 말한다. )
		map = new HashMap();
		map.put("car", new SuvCar());		//HashMap에 데이터를 넣어주려면 put 메소드를 사용 (key, value)
		map.put("engine", new Engine());
	}
	
	public Object getBean(String key) { return map.get(key);}
}



//변경에 유리한 코드
public class SpringDIIntro {
	
	public static void main(String[] args) {
		AppContrxt ac = new AppContrxt();
		Car car = (Car) ac.getBean("car");
		Engine engine = (Engine) ac.getBean("engine");
		
		System.out.println("car = " + car);
		System.out.println("engine = "+ engine);
	}
}
