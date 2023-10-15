package controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.BO.OrcamentoBO;
import model.VO.Orcamento;
import view.Telas;
import view.util.Alerts;

public class CadastrarOrcamentoController {

    @FXML
    private Button botaoCancelar;

    @FXML
    private Button botaoConcluir;

    @FXML
    private TextField textfieldCPF;

    @FXML
    private TextField textfieldData;

    @FXML
    private TextField textfieldID;

    @FXML
    private TextField textfieldIdPeca;

    @FXML
    private TextField textfieldIdServico;

    @FXML
    private TextField textfieldPlaca;
    
    @FXML
    private TextField textfieldPrecoTotal;

    @FXML
    void cadastrarOrcamento(ActionEvent event) throws Exception {
    	Orcamento orc = new Orcamento();
    	OrcamentoBO orcBO = new OrcamentoBO();
    	
    	int id = Integer.valueOf(textfieldID.getText());
    	orc.setIdOrcamento(id);
    	
    	int idPeca = Integer.valueOf(textfieldIdPeca.getText());
    	orc.setIdPecaOrcamento(idPeca);
    	
    	int idServico = Integer.valueOf(textfieldIdServico.getText());
    	orc.setIdServOrc(idServico);
    	
    	double precoTotal = Double.valueOf(textfieldPrecoTotal.getText()); 
    	orc.setTotalOrcamento(precoTotal);
    	
    	orc.setCPFClienteOrcamento(textfieldCPF.getText());
    	
    	String dataTexto = textfieldData.getText();

    	try {
    	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    	    java.util.Date parsedDate = dateFormat.parse(dataTexto);
    	    Date dataSql = new Date(parsedDate.getTime());
    	    orc.setDataOrcamento(dataSql);
    	} catch (ParseException e) {
    	    Alerts.showAlert("ERRO", "Data inválida", "Insira uma data no formato 'AAAA-MM-DD'.", AlertType.INFORMATION);
    	}

    	orc.setCPFClienteOrcamento(textfieldCPF.getText());
    	orc.setIsPago(false);
    	orc.setPlacaOrc(textfieldPlaca.getText());
    	orcBO.cadastrar(orc);
    	Alerts.showAlert("Sucesso", "Orçamento cadastrado com sucesso"," " ,AlertType.INFORMATION);
    	
    	Telas.telaMenuOrcamentos();
    }

    
    
    @FXML
    void voltar(ActionEvent event) throws Exception{
    	Telas.telaMenuOrcamentos();
    }

}