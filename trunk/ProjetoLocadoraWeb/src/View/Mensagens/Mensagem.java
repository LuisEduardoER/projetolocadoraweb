//Classe Mensagem
package View.Mensagens;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import Util.Idioma;

public class Mensagem {
	
//	Método para colocar os nomes dos botões	
	public static void inicializaUIManager(){
		UIManager.put("OptionPane.yesButtonText", Idioma.bn.getString("mensagem.sim"));
		UIManager.put("OptionPane.noButtonText", Idioma.bn.getString("mensagem.nao"));
		UIManager.put("OptionPane.cancelButtonText", Idioma.bn.getString("mensagem.cancelar"));
	}
	
	public static void loginValido(){
		JOptionPane.showMessageDialog(null , Idioma.bn.getString("mensagem.loginValido"));
	}
	
	public static void loginInvalido(){
		JOptionPane.showMessageDialog(null , Idioma.bn.getString("mensagem.loginInvalido"));
	}
		
	public static int desejaCancelar(){
		return JOptionPane.showConfirmDialog(null, Idioma.bn.getString("mensagem.desejaCancelar") , Idioma.bn.getString("mensagem.title") , JOptionPane.YES_NO_CANCEL_OPTION);
	}
	
	public static int desejaSair(){
		return JOptionPane.showConfirmDialog(null, Idioma.bn.getString("mensagem.desejaSair") , Idioma.bn.getString("mensagem.title") , JOptionPane.YES_NO_CANCEL_OPTION);
	}
	
	public static void impossivelConcluir(){
		JOptionPane.showMessageDialog(null,Idioma.bn.getString("mensagem.impossivelConcluir") );
	}
	
	public static void verificaIdadeHabilitacao(){
		JOptionPane.showMessageDialog(null,Idioma.bn.getString("mensagem.verificaIdadeHabilitacao"));
	}
	
	public static int desejaCadastrarCliente(){
		return JOptionPane.showConfirmDialog(null, Idioma.bn.getString("mensagem.desejaCadastrarCliente") , Idioma.bn.getString("mensagem.title") , JOptionPane.YES_NO_CANCEL_OPTION);
	}
	
	public static void cadastroSucesso(){
		JOptionPane.showMessageDialog(null,Idioma.bn.getString("mensagem.cadastroSucesso"));
	}
	
	public static void temCampoBranco(){
		JOptionPane.showMessageDialog(null,Idioma.bn.getString("mensagem.temCampoBranco"));
	}
	
	public static int desejaAlterarCliente(){
		return JOptionPane.showConfirmDialog(null, Idioma.bn.getString("mensagem.desejaAlterarCliente") , Idioma.bn.getString("mensagem.title") , JOptionPane.YES_NO_CANCEL_OPTION);
	}
	
	public static void alteracaoSucesso(){
		JOptionPane.showMessageDialog(null,Idioma.bn.getString("mensagem.alteracaoSucesso"));
	}
	
	public static void impossivelEncontrarCnpj(){
		JOptionPane.showMessageDialog(null,Idioma.bn.getString("mensagem.impossivelEncontrarCnpj"));
	}
	
	public static void impossivelEncontrarCpf(){
		JOptionPane.showMessageDialog(null,Idioma.bn.getString("mensagem.impossivelEncontrarCpf"));
	}
	
	public static void efetuarPesquisa(){
		JOptionPane.showMessageDialog(null,Idioma.bn.getString("mensagem.efetuarPesquisa"));
	}
	
	public static int desejaExcluirCliente(){
		return JOptionPane.showConfirmDialog(null, Idioma.bn.getString("mensagem.desejaExcluirCliente") , Idioma.bn.getString("mensagem.title") , JOptionPane.YES_NO_CANCEL_OPTION);
	}
	
	public static void exclusaoSucesso(){
		JOptionPane.showMessageDialog(null,Idioma.bn.getString("mensagem.exclusaoSucesso"));
	}
	
	public static int desejaInserirPagamento(){
		return JOptionPane.showConfirmDialog(null, Idioma.bn.getString("mensagem.desejaInserirPagamento") , Idioma.bn.getString("mensagem.title") , JOptionPane.YES_NO_CANCEL_OPTION);
	}
	
	public static void pagamentoSucesso(){
		JOptionPane.showMessageDialog(null,Idioma.bn.getString("mensagem.pagamentoSucesso"));
	}
	
	public static void impossivelConcluirCartao(){
		JOptionPane.showMessageDialog(null,Idioma.bn.getString("mensagem.impossivelConcluirCartao"));
	}
	
	public static void impossivelEfetuarLocacaoTelaErrada(){
		JOptionPane.showMessageDialog(null,Idioma.bn.getString("mensagem.impossivelEfetuarLocacaoTelaErrada"));
	}
	
	public static void selecioneVeiculo(){
		JOptionPane.showMessageDialog(null,Idioma.bn.getString("mensagem.selecioneVeiculo"));
	}
	
	public static void devolucaoSucesso(){
		JOptionPane.showMessageDialog(null,Idioma.bn.getString("mensagem.devolucaoSucesso"));
	}
	
	public static void entreCodigoLocacao(){
		JOptionPane.showMessageDialog(null,Idioma.bn.getString("mensagem.entreCodigoLocacao"));
	}
	
	public static void impossivelEncontrarLocacao(){
		JOptionPane.showMessageDialog(null,Idioma.bn.getString("mensagem.impossivelEncontrarLocacao"));
	}
	
	public static void clientePossuiPendenciasSerasa(){
		JOptionPane.showMessageDialog(null,Idioma.bn.getString("mensagem.clientePossuiPendenciasSerasa"));
	}
	
	public static int desejaConcluir(){
		return JOptionPane.showConfirmDialog(null, Idioma.bn.getString("mensagem.desejaConcluir") , Idioma.bn.getString("mensagem.title") , JOptionPane.YES_NO_CANCEL_OPTION);
	}
	
	public static void clienteEstaNaLista(){
		JOptionPane.showMessageDialog(null,Idioma.bn.getString("mensagem.clienteEstaNaLista"));
	}
	
	public static void datahoraDevolucaoIncorreta(){
		JOptionPane.showMessageDialog(null,Idioma.bn.getString("mensagem.datahoraDevolucaoIncorreta"));
	}
	
	public static void datahoraRetiradaIncorreta(){
		JOptionPane.showMessageDialog(null,Idioma.bn.getString("mensagem.datahoraRetiradaIncorreta"));
	}

	public static void impossivelEncontrarLocacaoCPF() {
		JOptionPane.showMessageDialog(null, Idioma.bn.getString("mensagem.impossivelEncontrarLocacaoCPF"));
	}

	public static void impossivelEncontrarLocacaoFinalizada() {
		JOptionPane.showMessageDialog(null, Idioma.bn.getString("mensagem.impossivelEncontrarLocacaoFinalizada"));
	}

	public static void retornarTroco(String valor) {
		JOptionPane.showMessageDialog(null, Idioma.bn.getString("mensagem.retornarTroco") + valor);
	}

	public static void impressaoEfetuadaSucesso() {
		JOptionPane.showMessageDialog(null, Idioma.bn.getString("mensagem.impressaoEfetuadaSucesso"));		
	}

	public static void impressaoNaoEfetuada() {
		JOptionPane.showMessageDialog(null, Idioma.bn.getString("mensagem.impressaoNaoEfetuada"));
	}
	
	
}
