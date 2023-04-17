package com.earth.di2;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/*
 * 빈(Bean)
 * 	1) Spring (IOC) Container가 관리하는 객체
 *  2) ApplicationContext가 담고 있는 객체
 *  3) 일반적인 객체 생성 방법 만든 객체는 Bean이 아님
 */
//따로 파일를 만들어서 관리
class Car{}
class SuvCar extends Car{}
class ElectronCar extends Car{}
class Engine {}

//bean객체들의 저장소
//ApplicationContext 정의
class AppContrxt{
	Map map;			//객체 저장소(key-value 형식, car-0x100(주소/위치)...)
	public AppContrxt() {
		//2.txt파일만 바꾸면 메서드나 내부 소스를 안 바꾸고 원하는 결과 출력시킬수 있음
		Properties p = new Properties();
		try {
			p.load(new FileReader("config.txt"));
			
			//Properties에 저장된 내용을 Map에 저장
			map = new HashMap(p);
			//클래스 이름의 객체로 변환해서 Map에 저장
			for(Object key : map.keySet()) {
				Class clazz = Class.forName((String)map.get(key));
				map.put(key, clazz.newInstance());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
