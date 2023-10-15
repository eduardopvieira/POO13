package model.VO;

import Exceptions.*;

public class Automovel {

    private String placa;
    private String cor;
    private String modelo;
    private String marca;
    private int ano;
    private int km;
    private String CPFdono;

    public Automovel () {};
   
    public Automovel (String modelo) throws InfoNaoCompativelException {
    	setModelo(modelo);
    }
    
    public Automovel (String placa, String cor, String modelo, String marca, int ano, int km, String dono) throws InfoNaoCompativelException {
        setPlaca(placa);
        setCor(cor);
        setModelo(modelo);
        setMarca(marca);
        setAno(ano);
        setKm(km);
        this.CPFdono = dono;
    }
    
//====================GET E SET PLACA=======================
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) throws InfoNaoCompativelException {
        placa = placa.replaceAll(" ", "");
        //SÓ ACEITA FORMATOS: ABC1234 OU ABC1D23
        if (placa.matches("[A-Za-z]{3}\\d{1}[A-Za-z]\\d{2}") || placa.matches("[A-Za-z]{3}\\d{4}")) {
            this.placa = placa;
        } else {
            throw new InfoNaoCompativelException("Placa inválida");
        }
    }
//=====================GET E SET COR=========================

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) throws InfoNaoCompativelException{
        if (cor.isEmpty() == false) {
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
        if (modelo.isEmpty() == false) {
            this.modelo = modelo;
        } else {
            throw new InfoNaoCompativelException("modelo inválido.");
        }
    }

//=====================GET E SET ANO=========================

    public int getAno() {
        return ano;
    }
    public void setAno(int ano) throws InfoNaoCompativelException {
        if (ano >= 1900 && ano <= 2024) {
            this.ano = ano;
        } else {throw new InfoNaoCompativelException("Ano inválido.");}
    }

//=====================GET E SET COR=========================

    public int getKm() {
        return km;
    }
    public void setKm(int km) throws InfoNaoCompativelException {
        if (km >= 0) {
            this.km = km;
        } else {throw new InfoNaoCompativelException("Quilometragem invalida.");}
    }
//====================================GET E SET DONO====================================================================
public void setCPFDono(String dono) {
    if (dono.isEmpty() == false && dono.length() == 11) {
	this.CPFdono = dono;
    }
}

public String getCPFDono() {
    return CPFdono;
}
//===================================GET E SET MARCA ============================

public void setMarca(String marca) throws InfoNaoCompativelException {
    if (marca.isEmpty() == false) {
        this.marca = marca;
    } else {
        throw new InfoNaoCompativelException("marca inválida.");
    }
}

public String getMarca() {
	return marca;
}

}

