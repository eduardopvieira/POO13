package controller;

import Exceptions.InfoNaoCompativelException;
import Exceptions.InsertException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.BO.AutomovelBO;
import model.VO.Automovel;
import view.Telas;
import view.util.Alerts;

public class CadastrarAutoController {

    @FXML
    private Button botaoCancelar;

    @FXML
    private Button botaoConcluir;

    @FXML
    private TextField textfieldAnoAuto;

    @FXML
    private TextField textfieldCorAuto;

    @FXML
    private TextField textfieldKMAuto;

    @FXML
    private TextField textfieldMarcaAuto;

    @FXML
    private TextField textfieldModeloAuto;

    @FXML
    private TextField textfieldPlacaAuto;

    @FXML
    private TextField textfieldCPF;
    
    @FXML
    void cadastrarAuto(ActionEvent event) throws InsertException {
    	Automovel auto = new Automovel();
        AutomovelBO autoBO = new AutomovelBO();
    	
        try {  
        int id = Integer.valueOf(textfieldAnoAuto.getText());
    	auto.setAno(id);
        auto.setCor(textfieldCorAuto.getText());
        auto.setCPFDono(textfieldCPF.getText());
        int km = Integer.valueOf(textfieldKMAuto.getText());
        auto.setKm(km);
        auto.setMarca(textfieldMarcaAuto.getText());
        auto.setModelo(textfieldModeloAuto.getText());
        auto.setPlaca(textfieldPlacaAuto.getText());
        autoBO.cadastrar(auto);
    	try {
			Telas.telaMenuAutos();
		} catch (Exception e) {
			e.printStackTrace();
		}

        }catch (InfoNaoCompativelException e) {
        	Alerts.showAlert("Erro", "Erro no cadastro", "Alguma informação está inválida.", AlertType.ERROR);
        }
    }
    

    @FXML
    void voltar(ActionEvent event) throws Exception {
    	Telas.telaMenuAutos();
    }

}
