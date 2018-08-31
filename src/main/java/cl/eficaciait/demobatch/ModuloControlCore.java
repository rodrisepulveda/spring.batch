package cl.eficaciait.demobatch;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.eficaciait.demobatch.service.DemoService;
import cl.eficaciait.demobatch.to.DatoTo;

@Component
public class ModuloControlCore {

	private final Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private DemoService demoService;

	/**
	 * inicia la aplicacion.
	 * 
	 * @param rutSostenedor
	 * 
	 * @param context
	 *            contexto de spring framework.
	 */
	public void start() {

		DatoTo datoTo = new DatoTo();

		datoTo.setCampo1("valor1");

		datoTo.setCampo2(1);

		try {

			demoService.insertarDb1(datoTo);

		} catch (Exception error) {

			logger.error("error: ", error);

		}

		DatoTo datoTo2 = new DatoTo();

		datoTo2.setCampo1("valor2");

		datoTo2.setCampo2(2);

		demoService.insertarDb2(datoTo2);

	}

}
