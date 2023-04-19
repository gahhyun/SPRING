package com.earth.rod6;

import java.util.Arrays;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component class Engine{}
@Component class SuperEngine extends Engine {}
@Component class TurboEngine extends Engine {}
@Component class Door {}
@Component						//클래스를 객체(Bean)로 등록시 사용
class Car {
	
	//@Value를 사용해서 값을 대입하는 방법
	@Value("blue") private String color;
	@Value("500") private int oil;
	
	@Resource(name = "turboEngine")
	private Engine engine;	//@Autowired : 의존성 주입(DI) - 사용할 객체를 외부에서 주입하는 것. 자동지정함
	
	@Autowired private Door[] doors;
	
	public Car() {}	
	
	public Car(String color, int oil, Engine engine, Door[] doors) {
		//super();
		this.color = color;
		this.oil = oil;
		this.engine = engine;
		this.doors = doors;
	}



	public void setColor(String color) {
		this.color = color;
	}

	public void setOil(int oil) {
		this.oil = oil;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public void setDoors(Door[] doors) {
		this.doors = doors;
	}

	@Override
	public String toString() {
		return "Car [color=" + color + ", oil=" + oil + ", engine=" + engine + ", doors=" + Arrays.toString(doors)
				+ "]";
	}
	
}



public class SpringDITest {
	public static void main(String[] args) {
		
		ApplicationContext ac = new GenericXmlApplicationContext("config6.xml");
		
		Car car = (Car)ac.getBean("car");
		Engine engine = (Engine)ac.getBean("engine");
		Door door = (Door)ac.getBean("door");
		

		System.out.println("car =" + car);
		
		
	}

}
