package model.VO;

public class Pecas {

	private int idItem; 
	private String descricaoItem;
	private String fabricante;
	private double precoItem;
	private int estoqueItem;
	private int unidadeMedidaItem;
	
	
	public Pecas(){}
	
	public Pecas(int idItem, String descricaoItem, String fabricante, double precoItem, int estoqueItem, int unidadeMedidaItem){
		setIdItem(idItem);
		setDescricaoItem(descricaoItem);
		setFabricante(fabricante);
		setPrecoItem(precoItem);
		setEstoqueItem(estoqueItem);
		setUnidadeMedidaItem(unidadeMedidaItem);
	}
	
	
	//GETS AND SETS:
	
	public int getIdItem() {
			return idItem;
	}


	public void setIdItem(int idItem) {
		if (idItem >= 0) {
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
	public int getUnidadeMedidaItem() {
		return unidadeMedidaItem;
	}
	public void setUnidadeMedidaItem(int unidadeMedidaItem) {
		if (unidadeMedidaItem >= 0) { 
		this.unidadeMedidaItem = unidadeMedidaItem;}
	}
}