package model.VO;

import Exceptions.InfoNaoCompativelException;

public class Servico {

	private int idServico;
	private String servicoNome, servicoDescricao;
	private double servicoPreco;

  public Servico(){}
  
  public Servico (int id) {
		setServicoId(id);
	}
  
  public Servico (String nome) throws InfoNaoCompativelException {
	  setServicoNome(nome);
  }

  public Servico(String servicoNome, String servicoDescricao, double servicoPreco) throws InfoNaoCompativelException{
    setServicoNome(servicoNome);
    setServicoDescricao(servicoDescricao);
    setServicoPreco(servicoPreco);
    
  }
  
  public Servico(String servicoNome, String servicoDescricao, double servicoPreco, int id) throws InfoNaoCompativelException{
	    setServicoNome(servicoNome);
	    setServicoDescricao(servicoDescricao);
	    setServicoPreco(servicoPreco);
	    setServicoId(id);
	  }

//get id:
public int getServicoId() {
  return idServico;
}

public void setServicoId(int l) {
  if(l > 0)
    this.idServico = l;
  else
    this.idServico = 0;
}

/*==>GET/SET (servicoNome)<==*/
  public String getServicoNome(){
    return servicoNome;
  }
  public void setServicoNome(String servicoNome) throws InfoNaoCompativelException{
    if (servicoNome != null && servicoNome != ""){ /*Verifica se foi passado algo para o servicoNome*/
      this.servicoNome = servicoNome;
    } else {
          throw new InfoNaoCompativelException("Nome de serviço invalido.");
      }
}

/*==>GET/SET (servicoDescricao)<==*/

  public String getServicoDescricao(){
    return servicoDescricao;
  }
  public void setServicoDescricao(String servicoDescricao) throws InfoNaoCompativelException {
    if (servicoDescricao != null && servicoDescricao != ""){ /*Verifica se foi passado algo para o servicoDescricao*/
      this.servicoDescricao = servicoDescricao;
    } else {
        throw new InfoNaoCompativelException("Descrição do serviço incompativel.");
      }
    }
/*<========================>*/

/*==>GET/SET (servico)<==*/
  public double getServicoPreco(){
    return servicoPreco;
  }

  public void setServicoPreco(double servicoPreco)throws InfoNaoCompativelException{
    if (servicoPreco >= 0){
      this.servicoPreco = servicoPreco;
    } else {
        throw new InfoNaoCompativelException("Preço do serviço incompativel.");
      }
    }
  }


