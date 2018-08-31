package cl.eficaciait.demobatch;

import org.springframework.context.ApplicationContext;

public class SingletonApplicationContext {

	/**
	 * Instancia unica.
	 */
	private static SingletonApplicationContext instancia;

	/**
	 * puntero a objeto aplication context.
	 */
	ApplicationContext context;

	/**
	 * Obtiene la instancia de la clase.
	 */
	public static SingletonApplicationContext obtenerInstancia() {

		if (instancia == null) {

			crearInstancia();

		}

		return instancia;

	}

	/**
	 * Crea la instancia unica de la clase.
	 */
	private static synchronized void crearInstancia() {

		if (instancia == null) {

			instancia = new SingletonApplicationContext();

		}

	}

	public ApplicationContext getContext() {

		return context;

	}

	public void setContext(ApplicationContext context) {

		this.context = context;

	}

}
