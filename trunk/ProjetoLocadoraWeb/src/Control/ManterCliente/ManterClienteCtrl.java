//Classe ManterClienteCtrl
package Control.ManterCliente;


import model.PessoaFisica;
import model.PessoaJuridica;
import Util.Verificacao;
import View.ClienteCadastroPFView;
import View.ClienteCadastroPJView;
import View.ClienteDadosPFView;
import View.ClienteDadosPJView;
import View.ClienteEscolhaView;
import View.Mensagens.Mensagem;

public class ManterClienteCtrl {
	protected ClienteCadastroPFView pfView;
	protected ClienteCadastroPJView pjView;
	protected PessoaFisica pf;
	protected PessoaJuridica pj;
	protected ClienteEscolhaView escolhaView;
		
	
	public ManterClienteCtrl(){
		
	}
	
	
	protected boolean carregarObjetoPF(ClienteDadosPFView viewPF){
		if(viewPF.verificaCamposBranco() == true){ //significa que tem campo em branco
			//retorna mensagem de error
			Mensagem.temCampoBranco();
			return false;
		}
		else{	
						
			pf.setTelefone(viewPF.getTxtFone());
			pf.setEmail(viewPF.getTxtEmail());
			pf.setNome(viewPF.getTxtNome());
			pf.setDtaNascimento(viewPF.getTxtDtaNascimento());
			pf.setSexo(viewPF.getComboSexo());
			pf.setRegistro(viewPF.getTxtCpf());
			pf.setRg(viewPF.getTxtRg());
			pf.setNumHabilitacao(viewPF.getTxtNumHabilitacao());
			pf.setEstadoEmissor(viewPF.getTxtEstadoEmissor());
			pf.setPrimeiraHabilitacao(viewPF.getTxtPrimeiraHabilitacao());
			pf.setValidadeCartMotorista(viewPF.getTxtValidadeCarteira());
			
			return true;
		}
	}
	
	protected boolean carregarObjetoPJ(ClienteDadosPJView viewPJ){
		if(viewPJ.verificaCamposBranco() == true){ //significa que tem campo em branco
			//retorna mensagem de error
			Mensagem.temCampoBranco();
			return false;
		}
		else{	
			pj.setTelefone(viewPJ.getTxtTelefone());
			pj.setEmail(viewPJ.getTxtEmail());
			pj.setRazaoSocial(viewPJ.getTxtRazaoSocial());
			pj.setNome(viewPJ.getTxtNomeFantasia());
			pj.setRegistro(viewPJ.getTxtCnpj());
			
			return true;
		}
	}
	
	
	protected void carregarCamposPF(ClienteDadosPFView viewPF) {
		viewPF.setTxtNome(pf.getNome());
		viewPF.setComboSexo(pf.getSexo());
		viewPF.setTxtDtaNascimento(pf.getDtaNascimento());
		viewPF.setTxtCpf(pf.getRegistro());
		viewPF.setTxtRg(pf.getRg());
		viewPF.setTxtFone(pf.getTelefone());
		viewPF.setTxtEmail(pf.getEmail());
		viewPF.setTxtNumHabilitacao(pf.getNumHabilitacao());
		viewPF.setTxtEstadoEmissor(pf.getEstadoEmissor());
		viewPF.setTxtPrimeiraHabilitacao(pf.getPrimeiraHabilitacao());
		viewPF.setTxtValidadeCarteira(pf.getValidadeCartMotorista());
	}
	
	protected void carregarCamposPJ(ClienteDadosPJView viewPJ){
		viewPJ.setTxtRazaoSocial(pj.getRazaoSocial());
		viewPJ.setTxtNomeFantasia(pj.getNome());
		viewPJ.setTxtCnpj(pj.getRegistro());
		viewPJ.setTxtTelefone(pj.getTelefone());
		viewPJ.setTxtEmail(pj.getEmail());
	}
	
	
	/*Método que irá verificar se o cliente possui idade menor de 21 anos.
	* true - Possui idade maior que 21 anos
	* false - Possui idade menor que 21 anos
	*/
	public boolean verificarIdade(){
		if(Verificacao.getTotalAnos(pf.getDtaNascimento()) <= 21){
			return false; //idade MENOR que 21 anos
		}
		else{
			return true; //idade MAIOR que 21 anos
		}
	}
	
	/*Método que irá verificar se o cliente tem menos de 2 anos de habilitação.
	* true - Cliente tem mais de 2 anos de habilitação
	* false - Cliente não tem menos de 2 anos de habilitação
	*/
	public boolean verificarHabilitacao(){
		
		if(Verificacao.getTotalAnos(pf.getPrimeiraHabilitacao()) < 2){
			return false; //habilitação menor que 2 anos
		}
		else{
			return true; //condutor com mais de 2 anos
		}
	}
}
