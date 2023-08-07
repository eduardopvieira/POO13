public class Endereco {
	
	private String rua;
	private String bairro;
	private String cep;
	private int numCasa;
	
	//ÀS PESSOAS DO MEU GRUPO: se forem usar de referencia, nao facam os métodos no modelo dos que
	//estão comentados, gadelha nao quer daquele jeito ainda (mandei email pra ele ´perguntadno)
	
	public Endereco() {};
	
	public Endereco(String rua, String bairro, String cep, int numCasa) {
		setRua(rua);
		setBairro(bairro);
		setCep(cep);
		setNumCasa(numCasa);
	}
	
	//------------------------------------------------------
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		if (rua != null && !rua.isEmpty()) {
		this.rua = rua;
		}
	}
	//------------------------------------------------------
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		if (bairro != null && !bairro.isEmpty()) {
		this.bairro = bairro;
		}		
	}
	//------------------------------------------------------
	public String getCep() {
			return cep;
	}
	public void setCep(String cep) {
		if (cep != null && !cep.isEmpty()) {
			this.cep = cep;
		}
	}
	//------------------------------------------------------
	public int getNumCasa() {
		return numCasa;
	}
	public void setNumCasa(int numCasa) {
		if (numCasa > 0) {
		this.numCasa = numCasa;}
	}
	//------------------------------------------------------
	public void addEndereco()
	{System.out.println("cadastrou endereco");}

	public void excluirEndereco()
	{
		System.out.println("Endereco excluido");
	}
	
	public void editarEndereco()
	{
		System.out.println("Endereco editado");
	}
	
	
	
	public static void main (String args[]) {
	Endereco e = new Endereco("rua foda", "bairro foda", "cep foda", 2469);
	System.out.println(e.getRua());
	e.excluirEndereco();
	System.out.println(e.getRua());
	
	}
	
}


/*public void excluirEndereco() {         
this.bairro = null;
this.rua = null;
this.cep = null;
this.numCasa = 0;
}*/
