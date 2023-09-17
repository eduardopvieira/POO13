package model.entity;

import Exceptions.*;

public class Automovel {

    private String placa;
    private String cor;
    private String modelo;
    private Cliente dono;
    private int ano;
    private int km;

    public Automovel () {};
    public Automovel (String placa, String cor, String modelo, Cliente dono, int ano, int km) {
        this.placa = placa;
        this.cor = cor;
        this.modelo = modelo;
        this.dono = dono;
        this.ano = ano;
        this.km = km;
    }
    
//====================GET E SET PLACA=======================
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) throws InfoNaoCompativelException {
        if (placa != null && placa.isEmpty() == false && placa.length() == 7) {
        this.placa = placa;
        } else {
            throw new InfoNaoCompativelException("Placa invalida");
        }
    }
//=====================GET E SET COR=========================

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) throws InfoNaoCompativelException{
        if (cor != null && cor.isEmpty() == false) {
            this.cor = cor;
        } else {
            throw new InfoNaoCompativelException("Cor inválida.");
        }
    }

//=====================GET E SET MODELO=========================

    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) throws InfoNaoCompativelException {
        if (modelo != null && modelo.isEmpty() == false) {
            this.modelo = modelo;
        } else {
            throw new InfoNaoCompativelException("modelo inválido.");
        }
    }

//=====================GET E SET DONO=========================

    public Cliente getDono() {
        return dono;
    }
    public void setDono(Cliente dono) throws InfoNaoCompativelException {
        if (dono != null && dono.getNome().isEmpty() == false) {
            this.dono = dono;
        } else {
            throw new InfoNaoCompativelException("Dono invalido.");
        }
    }

//=====================GET E SET ANO=========================

    public int getAno() {
        return ano;
    }
    public void setAno(int ano) throws InfoNaoCompativelException {
        if (ano <= 1900 && ano >= 2024) {
            this.ano = ano;
        } else {throw new InfoNaoCompativelException("Ano inválido.");}
    }

//=====================GET E SET COR=========================

    public int getKm() {
        return km;
    }
    public void setKm(int km) throws InfoNaoCompativelException {
        if (km < 0) {
            this.km = km;
        } else {throw new InfoNaoCompativelException("Quilometragem invalida.");}
    }

//======================== METODOS =====================
    public void cadastrarAuto(Automovel auto) {};
    public void excluirAuto(Automovel auto) {};
    public void editarAuto(Automovel auto) {};
    public void buscarPlaca(String placa) {};
    public void buscarModelo(String modelo) {};
}
















==============================================Segunda opção ===================================================

package entity;

import exceptions.InformacaoInvalida;

public class Automovel {
	private String placa;
	private String cor;
	private String modelo;
	private int ano;
	private int quilometragem;
	private Cliente dono;
	// =============Construtores ================
	public Automovel() {}
	public Automovel(String placa, String cor, String modelo, int ano, int quilometragem, Cliente dono) throws InformacaoInvalida{
		setPlaca(placa);
		setCor(cor);
		setModelo(modelo);
		setAno(ano);
		setQuilometragem(quilometragem);
		this.dono = dono;
	}
	
	//=========== gets e sets =============
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) throws InformacaoInvalida {
		if(placa != null && placa.length() == 7)
			this.placa = placa;
		else
			throw new InformacaoInvalida("Placa inválida");
	}
	public String getCor() {
		return this.cor;
	}
	public void setCor(String cor) throws InformacaoInvalida {
		if(cor != null && !cor.isEmpty())
			this.cor = cor;
		else
			throw new InformacaoInvalida("Cor inválida");
	}
	public String getModelo() {
		return this.modelo;
	}
	public void setModelo(String modelo) throws InformacaoInvalida{
		if(modelo != null && !modelo.isEmpty())
			this.modelo = modelo;
		else
			throw new InformacaoInvalida("Modelo inválido");
	}
	public int getAno() {
		return this.ano;
	}
	public void setAno(int ano) throws InformacaoInvalida{
		if(ano > 1886)
			this.ano = ano;
		else
			throw new InformacaoInvalida("Ano do veículo inválido");
	}
	public int getQuilometragem() {
		return quilometragem;
	}
	public void setQuilometragem(int quilometragem) throws InformacaoInvalida {
		if(quilometragem >= 0)
			this.quilometragem = quilometragem;
		else
			throw new InformacaoInvalida("quilometragem inválida");
	}
}
    
