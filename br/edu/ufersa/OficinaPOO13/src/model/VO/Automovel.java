package model.VO;

import Exceptions.*;

public class Automovel {

    private String placa;
    private String cor;
    private String modelo;
    private int ano;
    private int km;
    private Cliente dono;

    public Automovel () {};
    public Automovel (String placa, String cor, String modelo, int ano, int km, Cliente dono) throws InfoNaoCompativelException {
        setPlaca(placa);
        setCor(cor);
        setModelo(modelo);
        setAno(ano);
        setKm(km);
        this.dono = dono;
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
//============================GET E SET DONO========
public void setDono(Cliente dono) {
    this.dono = dono;
}

public Cliente getDono() {
    return dono;
}



//======================== METODOS =====================
    public void cadastrarAuto(Automovel auto) {};
    public void excluirAuto(Automovel auto) {};
    public void editarAuto(Automovel auto) {};
    public void buscarPlaca(String placa) {};
    public void buscarModelo(String modelo) {};
}

