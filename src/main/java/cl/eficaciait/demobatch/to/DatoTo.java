package cl.eficaciait.demobatch.to;

import java.io.Serializable;

public class DatoTo implements Serializable {

	/**
	 * Serie.
	 */
	private static final long serialVersionUID = -4505870578669206923L;

	private String campo1;

	private int campo2;

	public String getCampo1() {
		return campo1;
	}

	public void setCampo1(String campo1) {
		this.campo1 = campo1;
	}

	public int getCampo2() {
		return campo2;
	}

	public void setCampo2(int campo2) {
		this.campo2 = campo2;
	}

}
