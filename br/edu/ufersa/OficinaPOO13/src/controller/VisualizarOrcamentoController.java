package controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.BO.OrcamentoBO;
import model.VO.Orcamento;
import view.Telas;
import view.util.Alerts;

public class VisualizarOrcamentoController {

    @FXML
    private Button botaoConcluir;

    @FXML
    private Button botaoPagar;

    @FXML
    private Label textoCPF;

    @FXML
    private Label textoDataOrc;

    @FXML
    private Label textoIdOrc;

    @FXML
    private Label textoIdPeca;

    @FXML
    private Label textoIdServico;

    @FXML
    private Label textoOrcPago;

    @FXML
    private Label textoPlaca;

    @FXML
    private Label textoPreco;
    
    @FXML
    private Label textoIsPago;


    @FXML
    void voltarMenuOrcamento(ActionEvent event) throws Exception {
    	Telas.telaMenuOrcamentos();
    }

    @FXML
    public void Initialize(Orcamento orc) {
        
    	if(orc.getIsPago()) {
    		botaoPagar.setManaged(false);
            botaoPagar.setVisible(false);
            textoOrcPago.setManaged(true);
            textoOrcPago.setVisible(true);
    	}
    	
    	try {
        	textoCPF.setText(orc.getCPFClienteOrcamento());
        	textoIdOrc.setText(Integer.toString(orc.getIdOrcamento())); 
        	textoIdPeca.setText(Integer.toString(orc.getIdPecaOrcamento()));
        	textoIdServico.setText(Integer.toString(orc.getIdServOrc()));
        	textoPlaca.setText(orc.getPlacaOrc());
        	textoPreco.setText(Double.toString(orc.getTotalOrcamento()));
        	textoIsPago.setText(Boolean.toString(orc.getIsPago()));
        	
        	Date dataSql = orc.getDataOrcamento(); // Suponha que você já tenha obtido o objeto Date da sua entidade 'orc'

        	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        	String dataTexto = dateFormat.format(dataSql);

        	textoDataOrc.setText(dataTexto);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    

    @FXML
    void efetuarPagamento(ActionEvent event) throws ParseException {
    	
    	Orcamento orcPago = new Orcamento();
    	
    	orcPago.setCPFClienteOrcamento(textoCPF.getText());
  
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dataTexto = textoDataOrc.getText();
        java.util.Date parsedDate = dateFormat.parse(dataTexto);
        Date dataSql = new Date(parsedDate.getTime());
        orcPago.setDataOrcamento(dataSql);
    	
    	orcPago.setIdOrcamento(Integer.valueOf(textoIdOrc.getText()));
    	
    	orcPago.setIdPecaOrcamento(Integer.valueOf(textoIdPeca.getText()));
    	
    	orcPago.setIdServOrc(Integer.valueOf(textoIdServico.getText()));
    	
    	orcPago.setPlacaOrc(textoPlaca.getText());
    	
    	orcPago.setIsPago(true);	
    	
    	orcPago.setTotalOrcamento(Double.valueOf(textoPreco.getText()));    	
    	
    	System.out.println(orcPago.getDataOrcamento());
    	
    	try {
    		OrcamentoBO orcBO = new OrcamentoBO();
    		orcBO.alterarIsPago(orcPago);
    		Alerts.showAlert("Sucesso!", "Pagamento Concluído", "O orçamento foi pago com sucesso", AlertType.INFORMATION);
            botaoPagar.setManaged(false);
            botaoPagar.setVisible(false);
            textoOrcPago.setManaged(true);
            textoOrcPago.setVisible(true);    		
    	} catch (Exception e) {
    		Alerts.showAlert("Erro", "Pagamento nao efetuado", "Erro ao efetuar pagamento", AlertType.ERROR);
    	}
    }

}
