package cl.eficaciait.demobatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import cl.eficaciait.demobatch.config.MyBatisDb1Config;
import cl.eficaciait.demobatch.config.MyBatisDb2Config;
import cl.eficaciait.demobatch.config.SpringConfig;

@Component
public class Principal {

	@Autowired
	private ModuloControlCore moduloControlCore;

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.register(MyBatisDb1Config.class, MyBatisDb2Config.class, SpringConfig.class);

		context.refresh();

		Principal principal = context.getBean(Principal.class);

		SingletonApplicationContext.obtenerInstancia().setContext(context);

		principal.start();

	}

	private void start() {

		moduloControlCore.start();

	}

}