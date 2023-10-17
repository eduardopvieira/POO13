package controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import model.BO.OrcamentoBO;
import model.VO.Orcamento;
import view.Telas;
import view.util.Alerts;

public class EditarOrcamentoController {

    @FXML
    private Button botaoCancelar;

    @FXML
    private Button botaoConcluir;

    @FXML
    private TextField textfieldData;

    @FXML
    private TextField textfieldIdPeca;

    @FXML
    private TextField textfieldIdServico;

    @FXML
    private TextField textfieldPrecoTotal;

    @FXML
    private Label textoCPF;

    @FXML
    private Label textoIdOrc;

    @FXML
    private Label textoPlaca;

public void Initialize(Orcamento orc) {
    	
    	try {
        	textoCPF.setText(orc.getCPFClienteOrcamento());
        	textoIdOrc.setText(Integer.toString(orc.getIdOrcamento())); 
        	textfieldIdPeca.setText(Integer.toString(orc.getIdPecaOrcamento()));
        	textfieldIdServico.setText(Integer.toString(orc.getIdServOrc()));
        	textoPlaca.setText(orc.getPlacaOrc());
        	textfieldPrecoTotal.setText(Double.toString(orc.getTotalOrcamento()));
        	orc.setIsPago(false);
        	
        	Date dataSql = orc.getDataOrcamento();

        	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        	String dataTexto = dateFormat.format(dataSql);

        	textfieldData.setText(dataTexto);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
    @FXML
    void realizarEdicao(ActionEvent event) throws Exception {
    	Orcamento orcPago = new Orcamento();
    	
    	orcPago.setCPFClienteOrcamento(textoCPF.getText());
 
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dataTexto = textfieldData.getText();
        java.util.Date parsedDate = dateFormat.parse(dataTexto);
        Date dataSql = new Date(parsedDate.getTime());
        orcPago.setDataOrcamento(dataSql);
    	
    	orcPago.setIdOrcamento(Integer.valueOf(textoIdOrc.getText()));
    	
    	orcPago.setIdPecaOrcamento(Integer.valueOf(textfieldIdPeca.getText()));
    	
    	orcPago.setIdServOrc(Integer.valueOf(textfieldIdServico.getText()));
    	
    	orcPago.setPlacaOrc(textoPlaca.getText());
    	
    	orcPago.setIsPago(false);	
    	
    	orcPago.setTotalOrcamento(Double.valueOf(textfieldPrecoTotal.getText()));    	
    	
    	try {
    		OrcamentoBO orcBO = new OrcamentoBO();
    		orcBO.alterar(orcPago);
             		
    	} catch (Exception e) {
    		Alerts.showAlert("Erro", "Alteração não efetuada", "Erro ao alterar", AlertType.ERROR);
    	}
    	Telas.telaMenuOrcamentos();
    }


    @FXML
    void voltar(ActionEvent event) throws Exception {
    	Telas.telaMenuOrcamentos();
    }

}
