public class Endereço {
	
	private String rua;
	private String bairro;
	private String cep;
	private int numCasa;
	
	//ÀS PESSOAS DO MEU GRUPO: se forem usar de referencia, nao façam os métodos no modelo dos que
	//estão comentados, gadelha nao quer daquele jeito ainda (mandei email pra ele ´perguntadno)
	
	public Endereço() {};
	
	public Endereço(String rua, String bairro, String cep, int numCasa) {
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
	{System.out.println("cadastrou endereço");}

	public void excluirEndereço()
	{
		System.out.println("Endereço excluido");
	}
	
	public void editarEndereço()
	{
		System.out.println("Endereço editado");
	}
	
	
	
	public static void main (String args[]) {
	Endereço e = new Endereço("rua foda", "bairro foda", "cep foda", 2469);
	System.out.println(e.getRua());
	e.excluirEndereço();
	System.out.println(e.getRua());
	
	}
	
}


/*public void excluirEndereço() {         
this.bairro = null;
this.rua = null;
this.cep = null;
this.numCasa = 0;
}*/
