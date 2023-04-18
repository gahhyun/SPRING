package com.earth.rod;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

class Car {}
class Engine {}
class Door {}


public class SpringDITest {

	public static void main(String[] args) {
		
		ApplicationContext ac = new GenericXmlApplicationContext("config.xml");
		Car car = (Car)ac.getBean("car");			//by Name -> 이름으로 검색
		Car car2 = ac.getBean("car", Car.class);	//by Name -> 이름으로 검색
		Car car3 = ac.getBean(Car.class);			//by Type -> 타입으로 검색
		
		Engine engine = (Engine)ac.getBean("engine");
		Engine engine2 = ac.getBean("engine", Engine.class);
		Engine engine3 = ac.getBean(Engine.class);
		
		Door door = (Door)ac.getBean("door");
		Door door2 = ac.getBean("door", Door.class);
		Door door3 = ac.getBean(Door.class);
		
		
		System.out.println("car =" + car); 		//주소값이 똑같으면 싱글톤으로 생성됬다는 것을 알수 있음, 다르면 scope="prototype"으로 지정
		System.out.println("car2 =" + car2);
		System.out.println("car3 =" + car3);
		
		System.out.println("engine =" + engine);
		System.out.println("engine2 =" + engine2);
		System.out.println("engine3 =" + engine3);
		
		System.out.println("door =" + door);
		System.out.println("door2 =" + door2);
		System.out.println("door3 =" + door3);
		
		
	}
}
