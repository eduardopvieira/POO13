package model.VO;

import java.sql.Date;


public class Orcamento {

  private int idOrcamento;
  private String cpfClienteOrc;
  private String placaAutoOrc;
  private Date dataOrcamento;
  private double totalOrcamento;
  private boolean isPago;

  public Orcamento(){}
  
  public Orcamento(int idOrcamento) {
	  setIdOrcamento(idOrcamento);
  }
 
  public Orcamento(String cpf, int id) {
	  setCPFClienteOrcamento(cpf);
	  setIdOrcamento(id);
  }
  
  public Orcamento(int id, String clienteOrcamento, String automovelOrcamento, int pecaOrcamento, int servicoOrcamento, Date dataOrcamento, double totalOrcamento, boolean isPago){
      
	  setIdOrcamento(id);
      setCPFClienteOrcamento(clienteOrcamento);
      setPlacaOrc(automovelOrcamento);
      setDataOrcamento(dataOrcamento);
      setTotalOrcamento(totalOrcamento);
      setIsPago(isPago);
  }
  
  public Orcamento(int id, String clienteOrcamento, String automovelOrcamento, int pecaOrcamento, int servicoOrcamento, Date dataOrcamento, double totalOrcamento){
      
	  setIdOrcamento(id);
      setCPFClienteOrcamento(clienteOrcamento);
      setPlacaOrc(automovelOrcamento);
      setDataOrcamento(dataOrcamento);
      setTotalOrcamento(totalOrcamento);
      setIsPago(false);
  }
  
 
//=========================== SET E GET TOTAL DO ORÇAMENTO ==================================================

public void setTotalOrcamento(double preco) {
	if (preco >= 0) {
		this.totalOrcamento = preco;
	}
}

public double getTotalOrcamento() {return this.totalOrcamento;}
//===========================SET E GET DATA ORCAMENTO=========================================================

public void setDataOrcamento(Date data) {
  this.dataOrcamento = data;
}

public Date getDataOrcamento() {
    return dataOrcamento;    
}
//=========================GET E SET CLIENTE NO ORÇAMENTO==========================================================

  public String getCPFClienteOrcamento(){
    return cpfClienteOrc;
  }
  public void setCPFClienteOrcamento(String cpf){
	  if (cpf.isEmpty() == false && cpf.length() == 11) {
		  this.cpfClienteOrc = cpf;
	    }
  }
//=========================GET E SET AUTOMOVEL NO ORÇAMENTO========================================
  public String getPlacaOrc(){
    return placaAutoOrc;
  }
  public void setPlacaOrc(String placa){
    if (placa.isEmpty() == false && placa.length() == 7) {
	  this.placaAutoOrc = placa;
    }
  }
//=========================GET E SET ID DO ORÇAMENTO=====================================
 
  public int getIdOrcamento() {return idOrcamento;}

  public void setIdOrcamento(int id) {
	  if (id >= 0) {
		  this.idOrcamento = id;
	  }
  }
 //========================GET E SET ISPAGO===========================================
  
  public boolean getIsPago() {return isPago;}
  
  public void setIsPago(boolean bool) {
	  this.isPago = bool;
  }
  
}