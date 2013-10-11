//Classe Cartao
package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import model.dao.DaoFactoryDinamico;
import model.dao.FormaPagamentoDao;

public class Cartao extends FormaPagamento{
	
	private String tipo;
	private String nomeCliente;
	private String cpf;
	private String numCartao;
	private Date dtaValidade;
	private String codSeguranca;
	
	
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getNomeCliente() {
		return nomeCliente;
	}
	
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getNumCartao() {
		return numCartao;
	}
	
	public void setNumCartao(String numCartao) {
		this.numCartao = numCartao;
	}
	
	public Date getDtaValidade() {
		return dtaValidade;
	}
	
	public void setDtaValidade(Date dtaValidade) {
		this.dtaValidade = dtaValidade;
	}
	
	public String getCodSeguranca() {
		return codSeguranca;
	}
	
	public void setCodSeguranca(String codSeguranca) {
		this.codSeguranca = codSeguranca;
	}
	
	public String toString(){
		return "Cartao";
	}
	
		
	public String getCartaoStr(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return getTipo() + " " + getNomeCliente() + " " + getCpf() + " " + getNumCartao() + " " + sdf.format(getDtaValidade()) + " " +
				getCodSeguranca();
	}

	@Override
	public void debitar() throws Exception{
		
//		IMPLEMENTAR A LEITURA DE ARQUIVO POSTERIORMENTE
		
//		SistemaCartaoCreditoImpl sistemaCartao = new SistemaCartaoCreditoImpl();
//		if(!sistemaCartao.debitar(cartao)){
//			System.out.println("n�o foi poss�vel debitar o cart�o");
//		}
//		else{
		FormaPagamentoDao dao = DaoFactoryDinamico.obterFormaPagamentoDao();
		dao.inserirFormaPag(this);
		setId(dao.obterUltimoRegistro());
		System.out.println("debitou com sucesso\n" + getId() );
//		}
		
	}
	
}
