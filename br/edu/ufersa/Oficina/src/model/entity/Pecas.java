package model.entity;

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









==============================SEGUNDA OPCAO ==========================================


package entity;
import exceptions.InformacaoInvalida;

public class Pecas {
	private int idItem;
	private String descricaoItem;
	private double precoItem;
	private int estoqueItem;
	private int unidadeMedidaItem;
	private String fabricante;
	
	//========= construtores ===============
	
	public Pecas() {}
	public Pecas(String descricaoItem, double precoItem, int estoqueItem, int unidadeMedidaItem, String fabricante) throws InformacaoInvalida{
		setDescricaoItem(descricaoItem);
		setPrecoItem(precoItem);
		setEstoqueItem(estoqueItem);
		setUnidadeMedidaItem(unidadeMedidaItem);
		setFabricante(fabricante);
	}
	public String getDescricaoItem() {
		return this.descricaoItem;
	}
	public void setDescricaoItem(String descricaoItem) throws InformacaoInvalida {
		if(descricaoItem != null && !descricaoItem.isEmpty())
			this.descricaoItem = descricaoItem;
		else
			throw new InformacaoInvalida("Descrição inválida");
	}
	public double getPrecoItem() {
		return this.precoItem;
	}
	public void setPrecoItem(double precoItem) throws InformacaoInvalida{
		if(precoItem >= 0)
			this.precoItem = precoItem;
		else
			throw new InformacaoInvalida("O preço de um produto não pode ser negativo");
	}
	public int getEstoqueItem() {
		return this.estoqueItem;
	}
	public void setEstoqueItem(int estoqueItem) throws InformacaoInvalida{
		if(estoqueItem >= 0)
			this.estoqueItem = estoqueItem;
		else
			throw new InformacaoInvalida("O estoque não pode ser negativo");
	}
	public int getUnidadeMedidaItem() {
		return this.unidadeMedidaItem;
	}
	public void setUnidadeMedidaItem(int unidadeMedidaItem) throws InformacaoInvalida{
		if(unidadeMedidaItem >= 0)
			this.unidadeMedidaItem = unidadeMedidaItem;
		else
			throw new InformacaoInvalida("Uma item não pode ter uma unidade de medida negativa");
	}
	public String getFabricante() {
		return this.fabricante;
	}
	public void setFabricante(String fabricante) throws InformacaoInvalida {
		if(fabricante != null && !fabricante.isEmpty())
			this.fabricante = fabricante;
		else
			throw new InformacaoInvalida("O fabricante não pode ser vazio");
	}
}
