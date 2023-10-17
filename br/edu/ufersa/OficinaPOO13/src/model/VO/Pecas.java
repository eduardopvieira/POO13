package model.VO;

public class Pecas {

	private int idItem; 
	private int idOrcamentoPeca;
	private String descricaoItem;
	private String fabricante;
	private double precoItem;
	private int estoqueItem;
	private int quantidade;
	
	
	public Pecas(){}
	
	public Pecas (String nome) {
		setDescricaoItem(nome);
	}
	
	public Pecas (int id) {
		setIdItem(id);
	}
	
	public Pecas(int idItem, String descricaoItem, String fabricante, double precoItem, int estoqueItem){
		setIdItem(idItem);
		setDescricaoItem(descricaoItem);
		setFabricante(fabricante);
		setPrecoItem(precoItem);
		setEstoqueItem(estoqueItem);
	}
	
	
	
	public Pecas(int idItem, int idOrcamentoPeca, String descricaoItem, int quantidade) {
		setIdItem(idItem);
		setIdOrcamentoPeca(idOrcamentoPeca);
		setDescricaoItem(descricaoItem);
		setQuantidade(quantidade);
	}
	
	

	//GETS AND SETS:
	
	
	
	public int getIdItem() {
			return idItem;
	}


	public int getIdOrcamentoPeca() {
		return idOrcamentoPeca;
	}

	public void setIdOrcamentoPeca(int idOrcamentoPeca) {
		this.idOrcamentoPeca = idOrcamentoPeca;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public void setIdItem(int idItem) {
		if (idItem > 0) {
			this.idItem = idItem;
		}
	}
	//-------------------------------------
	
	public String getDescricaoItem() {
		return descricaoItem;
	}
	public void setDescricaoItem(String descricaoItem) {
		this.descricaoItem = descricaoItem;
	}
	//-------------------------------------
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	//--------------------------------------
	public double getPrecoItem() {
		return precoItem;
	}
	public void setPrecoItem(double precoItem) {
		if (precoItem >= 0) {
			this.precoItem = precoItem;
		}
	}
	
	//---------------------------------------
	public int getEstoqueItem() {
		return estoqueItem;
	}
	public void setEstoqueItem(int estoqueItem) {
		if (estoqueItem >= 0) {
		this.estoqueItem = estoqueItem;}
	}
	//----------------------------------------
}