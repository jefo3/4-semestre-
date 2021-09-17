package ingredientes;

import sanduiche.ASanduiche;

public abstract class AComplemento extends ASanduiche{
	private ASanduiche aSanduiche;
	private double preco;
	
	public AComplemento(ASanduiche aSanduiche) {
		super();
		this.aSanduiche = aSanduiche;
	}
	
	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public double preco() {
		return (this.getPreco() + this.aSanduiche.preco());
	}
}
