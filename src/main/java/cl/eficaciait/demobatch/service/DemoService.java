package cl.eficaciait.demobatch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cl.eficaciait.demobatch.mapper.db1.DemoMapper1;
import cl.eficaciait.demobatch.mapper.db2.DemoMapper2;
import cl.eficaciait.demobatch.to.DatoTo;

@Service
public class DemoService {

	@Autowired
	private DemoMapper1 demoMapper1;

	@Autowired
	private DemoMapper2 demoMapper2;

	@Transactional(propagation = Propagation.REQUIRED, transactionManager = "db1_tm", rollbackFor = Exception.class)
	public void insertarDb1(DatoTo datoTo) throws Exception {

		demoMapper1.insertarDb1(datoTo);

		//throw new Exception("Un error.");

	}

	@Transactional(propagation = Propagation.REQUIRED, transactionManager = "db2_tm")
	public void insertarDb2(DatoTo datoTo2) {

		demoMapper2.insertarDb2(datoTo2);

	}

}
