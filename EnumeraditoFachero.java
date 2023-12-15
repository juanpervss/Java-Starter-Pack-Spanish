package segondoTrimestre;

public enum EnumeraditoFachero {
	AGREGAR("agregar"), BUSCAR("buscar"), ELIMINAR("eliminar"), ACTUALIZAR("actualizar"), SALIR("salir");

	String valor;

	EnumeraditoFachero(String string) {
		this.valor = string;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
}
