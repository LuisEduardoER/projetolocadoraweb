//Classe LocacaoPJCtrl
package Control.RealizarLocacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

import Model.Condutor;
import Model.Locacao;
import Model.PessoaFisica;
import Model.Veiculo;
import Control.TarifaControladaCtrl;
import Control.ConsultarVeiculo.ConsultarVeiculoCtrl;
import Control.ManterCliente.ConsultarClienteCtrl;
import Control.ManterCliente.ManterClienteCtrl;
import Util.Conversao;
import View.LocacaoPJView;
import View.Mensagens.Mensagem;

public class LocacaoPJCtrl {
	
	private LocacaoPJView view;
	private Condutor condutor;
	private Locacao locacao;
	private DefaultTableModel modelo;  
	
	public LocacaoPJCtrl(){
		view = new LocacaoPJView();
		adicionarListener();
	}
	
	public LocacaoPJCtrl(Locacao locacao){
		this.locacao = locacao;
		view = new LocacaoPJView();
		adicionarListener();
		modelo = (DefaultTableModel) view.getTabela().getModel();
	}
	
	
	
	private void adicionarListener() {
		view.addBtAdicionarMotoristaListener(new AdicionarMotoristaListener());
		view.addBtConcluirListener(new ConcluirListener());
		view.addBtVoltarListener(new VoltarListener());
	}
	
	class AdicionarMotoristaListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			adicionarCliente();
						
		}
	}
	
	class ConcluirListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int op = Mensagem.desejaConcluir();
			if(op == 0){
				if(locacao.getTipoTarifa().equals("livre")){
					CalcularLocacaoCtrl concluirLocacaoCtrl = new CalcularLocacaoCtrl(locacao);
				}else{
					TarifaControladaCtrl tarifaCtrl = new TarifaControladaCtrl(locacao);
				}
				view.dispose();
			}
		}
	}
	
	class VoltarListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			locacao.getCondutores().clear(); //limpa a lista de todos os condutores para depois retornar ao passo anterior
			RealizarLocacaoCtrl locacaoCtrl = new RealizarLocacaoCtrl(locacao);
			view.dispose();
		}
	}
	
	
	public void adicionarCliente(){
		ManterClienteCtrl escolherCliente = new ConsultarClienteCtrl(this);
	}
	
	public void adicionarPF(PessoaFisica pf){
		if(isClienteIncluded(pf)){
			Mensagem.clienteEstaNaLista();
		}else{
			condutor = new Condutor();
			this.condutor.setPf(pf);
			ConsultarVeiculoCtrl consultarVeiculoCtrl = new ConsultarVeiculoCtrl(locacao.getAgenciaRetirada().getCodigo() , this);
		}
	}

	public void adicionarVeiculo(Veiculo veiculo) {
		this.condutor.setVeiculo(veiculo);
		atualiza();
	}
	
	
	private void atualiza() {
		calculaTotal();
		addCondutorTable();
		locacao.addCondutor(condutor);
	}
	
	private void calculaTotal(){
		double total = locacao.getTotal() + calcularSubTotal();
		locacao.setTotal(total);
		view.setTxtTotal(locacao.getTotal());
	}
	
	private double calcularSubTotal(){
		if(locacao.getTipoTarifa().equals("livre")){
			condutor.setTotal(calcularTotalTarifaLivre());
		}
		else{
			condutor.setTotal(calcularTotalTarifaControlada());
		}
		return condutor.getTotal();
	}
	

	private double calcularTotalTarifaLivre() {
//		valor veiculo(s) escolhido(s)
//		qtd de dias
//		tipo de tarifa - ok
		
		double valorVeiculo = condutor.getVeiculo().getGrupo().getTarifaLivre();
//		int qtdDias = calculaQtdDias();
		if(locacao.getQtdDias() < 7){
			valorVeiculo = valorVeiculo * (double) locacao.getQtdDias();
		}else{
			valorVeiculo = condutor.getVeiculo().getGrupo().getDiaExtra() * locacao.getQtdDias();
		}
		valorVeiculo = valorVeiculo + condutor.getVeiculo().getTotalAcessorios();
		return valorVeiculo;
	}

	private double calcularTotalTarifaControlada() {
		
		double valorVeiculo = condutor.getVeiculo().getGrupo().getTarifaControloda();
		valorVeiculo = valorVeiculo * (double) locacao.getQtdDias();
		valorVeiculo = valorVeiculo + condutor.getVeiculo().getTotalAcessorios();
		
		return valorVeiculo;
		
	}
	
	
	public void addCondutorTable(){
		modelo.addRow(new Object [] { condutor.getPf().getNome() ,
										condutor.getVeiculo().getModelo() , 
										Conversao.formatDouble(condutor.getTotal())});
	}
	
//	Método irá verificar se JÁ EXISTE um cliente inserido na tabela
	private boolean isClienteIncluded(PessoaFisica pf){
		for(int i = 0; i < locacao.getCondutores().size(); i++){
			Condutor cond = locacao.getCondutor(i);
			if(cond.getPf().getId() == pf.getId()){
				return true; //Cliente já está na lista
			}
		}
		return false;
	}
}
