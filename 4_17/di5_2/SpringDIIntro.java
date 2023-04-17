package com.earth.di5_2;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.google.common.reflect.ClassPath;

/*
 * 빈(Bean)
 * 	1) Spring (IOC) Container가 관리하는 객체
 *  2) ApplicationContext가 담고 있는 객체
 *  3) 일반적인 객체 생성 방법 만든 객체는 Bean이 아님
 */

/*
 * 5. 객체를 자동 연결하기
 * 	- @AutoWired : Type으로 찾음 (Value)
 * 	- @Resource  : Name으로 찾음 (Key)
 */
@Component class Car{
//	@Autowired		//주석처리하면 null로 나온다
//	Engine engine;
//	@Autowired Door door;
	//혹은
	@Resource(name = "engine")
	Engine engine;
	@Resource Door door;	//(name 설정 안하면 자동으로 됨)
	
	@Override
	public String toString() {
		return "Car [engine=" + engine + ", door=" + door + "]";
	}
}
@Component class SuvCar extends Car{}
@Component class ElectronCar extends Car{}
@Component class Engine {}
@Component class Door{}

//bean객체들의 저장소
//ApplicationContext 정의
class AppContrxt{
	Map map;			//객체 저장소(key-value 형식, car-0x100(주소/위치)...)
	public AppContrxt() {
		//4.객체 찾기
		//@Component 어노테이션이 설정된 클래스들을 Set에 저장한 뒤 이를 통해 Bean을 생성
		map = new HashMap();
		doComponentScan();
		doAutowired();
		doResource();
	}
	
	private void doResource() {
		try {
			// map에 저장된 객체의 인스턴스 변수에 @Resource가 붙어 있으면 map에서 인스턴스 변수의 이름(id)에 맞는 객체를 찾아서 연결(객체의 주소를 변수에 저장)
			// by Name으로 찾음(key)
			for (Object bean : map.values()) {
				for (Field fld : bean.getClass().getDeclaredFields()) {
					if (fld.getAnnotation(Resource.class) != null) 		//by Name
						fld.set(bean, getBean(fld.getName()));			//car.enginr = engine (연결)
				}
			} 
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void doAutowired() {
		try {
			// map에 저장된 객체의 인스턴스 변수에 @Autowired가 붙어 있으면 map에서 인스턴스 변수의 타입에 맞는 객체를 찾아서 연결(객체의 주소를 변수에 저장)
			// by Type으로 찾음(value)
			for (Object bean : map.values()) {
				for (Field fld : bean.getClass().getDeclaredFields()) {
					if (fld.getAnnotation(Autowired.class) != null) 		//by Type
						fld.set(bean, getBean(fld.getType()));				//car.enginr = engine (연결)
				}
			} 
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void doComponentScan() {
		/*
		 * 1) 패키지 내의 클래스 목록을 가져옴
		 * 2) 반복문으로 클래스를 읽으면서 @Component가 붙어있는지 확인
		 * 3) @Component가 붙어있을 경우 객체를 생성, map에 저장
		 */
		ClassLoader classLoader = AppContrxt.class.getClassLoader();
		try {
			ClassPath classPath = ClassPath.from(classLoader);
			Set<ClassPath.ClassInfo> set = classPath.getTopLevelClasses("com.earth.di5_2");
			
			for(ClassPath.ClassInfo classInfo : set) {
				Class clazz = classInfo.load();
				Component component = (Component) clazz.getAnnotation(Component.class);
				
				if(component != null) {
					String id = StringUtils.uncapitalize(classInfo.getSimpleName());	//첫글자 대문자를 소문자로 변경
					map.put(id, clazz.newInstance());
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * 객체 찾기 - by Name, by Type 
	 */
	//이름(id)으로 찾기 - by Name
	public Object getBean(String key) { return map.get(key);}
	
	//타입으로 찾기 - by Type (instanceOf)
	public Object getBean(Class clazz) {
		for(Object obj : map.values()) {
			if(clazz.isInstance(obj))			//obj instanceOf clazz
				return obj;
		}
		return null;
	}
}



//변경에 유리한 코드
public class SpringDIIntro {
	
	public static void main(String[] args) {
		AppContrxt ac = new AppContrxt();
		Car car = (Car) ac.getBean("car");					//by Name으로 객체를 검색
		Car car2 = (Car)ac.getBean(Car.class);				//by Type으로 객체를 검색
		Engine engine = (Engine) ac.getBean("engine");		//by Name으로 객체 검색
		
		Door door = (Door) ac.getBean(Door.class);			//by Type으로 객체를 검색
		
		//  수동으로 객체 참조 (연결)
//		car.engine = engine;
//		car.door = door;
		
		System.out.println("car = " + car);
		System.out.println("car2 = " + car2);
		System.out.println("engine = "+ engine);
		System.out.println("door = "+ door);
	}
}
