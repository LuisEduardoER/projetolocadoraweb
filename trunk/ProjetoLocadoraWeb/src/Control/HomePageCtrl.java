//Classe HomePageCtrl
package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.Agencia;
import Model.Usuario;

import Control.ConsultarVeiculo.ConsultarVeiculoCtrl;
import Control.DevolverVeiculo.DevolverLocacaoCtrl;
import Control.LogarSistema.LoginCtrl;
import Control.ManterCliente.CadastrarClienteCtrl;
import Control.ManterCliente.ConsultarClienteCtrl;
import Control.ManterCliente.ManterClienteCtrl;
import Control.RealizarLocacao.RealizarLocacaoCtrl;
import View.HomePageView;
import View.Mensagens.Mensagem;



public class HomePageCtrl {
	private HomePageView homeView;
	private Agencia agencia;
	private Usuario usuario;
	private ManterClienteCtrl manterClienteCtrl;
	
	
	public HomePageCtrl(){
		LoginCtrl lc = new LoginCtrl(this);
		
	}
	
	public void inicializaHomePage(){
		homeView = new HomePageView();
		adicionandoListeners();
	}
	
	public void inicializaHomePage(Agencia agencia, Usuario user) {
		this.agencia = agencia;
		this.usuario = user;
		homeView = new HomePageView();
		carregaValores();
		adicionandoListeners();
	}
	

	private void carregaValores() {
		homeView.setTxtAgencia(agencia.getNome());
		homeView.setTxtAtendente(usuario.getNome());
	}

	private void adicionandoListeners() {
		homeView.addBtAltClientes(new AlterarClientesListener());
		homeView.addBtCadClientes(new CadastrarClientesListener());
		homeView.addBtConClientes(new ConsultarClientesListener());
		homeView.addBtConLocacao(new ConsultarLocacaoListener());
		homeView.addBtConVeiculo(new ConsultarVeiculoListener());
		homeView.addBtDevVeiculo(new DevolverVeiculoListener());
		homeView.addBtExcClientes(new ExcluirClientesListener());
		homeView.addBtReaLocacao(new RealizarLocacaoListener());
		homeView.addItemSairListener(new SairListener());
		homeView.addItemSobreListener(new SobreListener());
		homeView.addItemConsultaCliListener(new ConsultarClientesListener());
		homeView.addItemConsultaLocListener(new ConsultarLocacaoListener());
		homeView.addItemConsultaVeiListener(new ConsultarVeiculoListener());
	}
	
	class SobreListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JOptionPane.showMessageDialog(null, "Autor: Diego T. dos Santos\nRA: 201108534  Turma: 2ASIN\nVersion: 1.01\n\n" +
					"Para suporte, favor contatar-me no +55 11 9 6661-0229 ou no e-mail: dto.diego@gmail.com");
		}
	}
	
	class SairListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			int i = Mensagem.desejaSair();
			if(i == 0){
				System.exit(0);
			}
		}
	}
	
	class ExcluirClientesListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			manterClienteCtrl = new ConsultarClienteCtrl();
		}
	}
	
	class RealizarLocacaoListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			RealizarLocacaoCtrl realizarLocacao = new RealizarLocacaoCtrl(agencia);
		}
	}
	
		
	class DevolverVeiculoListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			DevolverLocacaoCtrl devolverLocacao = new DevolverLocacaoCtrl(agencia);
		}
	}
	
	class ConsultarVeiculoListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			ConsultarVeiculoCtrl consultarVeiculo = new ConsultarVeiculoCtrl(agencia.getCodigo());
		}
	}
	
	class ConsultarLocacaoListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			DevolverLocacaoCtrl devolverLocacao = new DevolverLocacaoCtrl(agencia);
		}
	}
	
	class ConsultarClientesListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			manterClienteCtrl = new ConsultarClienteCtrl();
		}
	}
	
	class CadastrarClientesListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			manterClienteCtrl = new CadastrarClienteCtrl();
		}
	}
	
	class AlterarClientesListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			manterClienteCtrl = new ConsultarClienteCtrl();
		}
	}		
}
