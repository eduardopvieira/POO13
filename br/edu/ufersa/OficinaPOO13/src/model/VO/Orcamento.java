package model.VO;

import java.sql.Date;


public class Orcamento {

  private int idOrcamento;
  private Cliente clienteOrcamento;
  private Automovel automovelOrcamento;
  private Pecas pecaOrcamento;
  private Servico servicoOrcamento;
  private Date dataOrcamento;
  private double totalOrcamento;
  private boolean isPago;

  public Orcamento(){}
  public Orcamento(Cliente clienteOrcamento, Automovel automovelOrcamento, Pecas pecaOrcamento, Servico servicoOrcamento, Date dataOrcamento){
      
      setClienteOrcamento(clienteOrcamento);
      setAutomovelOrcamento(automovelOrcamento);
      setDataOrcamento(dataOrcamento);
      setPecaOrcamento(pecaOrcamento);
      setServicoOrcamento(servicoOrcamento);
      setTotalOrcamento(this.servicoOrcamento,this.pecaOrcamento);
      setIsPago(false);
  }
  

//=========================== SET E GET PEÇA DO ORÇAMENTO ===========================
 public void setPecaOrcamento (Pecas p) {
	 this.pecaOrcamento = p;
 }
  
 public Pecas getPecaOrcamento () {return pecaOrcamento;}
  
  
//=========================== SET E GET SERVIÇO DO ORÇAMENTO ===========================
public void setServicoOrcamento (Servico s) {
	this.servicoOrcamento = s;
}
 
public Servico getServicoOrcamento() {return servicoOrcamento;}
 
//=========================== SET E GET TOTAL DO ORÇAMENTO ===========================
public void setTotalOrcamento(Servico s, Pecas p) {
    if (s != null && p != null) {
      this.totalOrcamento = s.getServicoPreco() + p.getPrecoItem();
    } else {
    	if (s!= null && p == null) {
    		this.totalOrcamento = s.getServicoPreco();
    	} else {
    		this.totalOrcamento = p.getPrecoItem();
    	}
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

  public Cliente getClienteOrcamento(){
    return clienteOrcamento;
  }
  public void setClienteOrcamento(Cliente clienteOrcamento){
    this.clienteOrcamento = clienteOrcamento;
  }
//=========================GET E SET AUTOMOVEL NO ORÇAMENTO========================================
  public Automovel getAutomovelOrcamento(){
    return automovelOrcamento;
  }
  public void setAutomovelOrcamento(Automovel automovelOrcamento){
    this.automovelOrcamento = automovelOrcamento;
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