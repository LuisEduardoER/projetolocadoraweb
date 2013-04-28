package Testes;

import java.awt.Container;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Model.Agencia;
import Model.Cartao;
import Model.Cliente;
import Model.Grupo;
import Model.Locacao;
import Model.SerasaImpl;
import Model.SistemaCartaoCreditoImpl;
import Model.Veiculo;

import Control.*;
import Control.ConsultarVeiculo.ConsultarVeiculoCtrl;
import Control.DevolverVeiculo.DevolverLocacaoCtrl;
import Control.RealizarLocacao.RealizarLocacaoCtrl;

public class TestesCtrl {
	
	public static void main(String []args){

//		====================================================================
//		TESTE CASO DE USO - CONSULTAR VEÍCULO
//		====================================================================
		/*
		Grupo grupo = new Grupo(1 , "Y - Blindado" , 10.3 , 5.5);
		Veiculo v1 = new Veiculo(1 ,"Celta 1.0", "GM", "BJ09432FAÇL3", "BJS-0932", "1.0", "Guarulhos", "São Paulo");
		Veiculo v2 = new Veiculo(2 ,"Gol 1.0", "VW", "FDAEWDSAÇL3", "BJS-0932", "1.0", "Santos", "São Paulo");
		Veiculo v3 = new Veiculo(3 ,"Golf 1.6", "VW", "FDAEWDSAÇL3", "BJS-0932", "1.0", "Paraiba", "Nordeste");
		
		grupo.addVeiculo(v1);
		grupo.addVeiculo(v2);
		grupo.addVeiculo(v3);
		
		Grupo grupo2 = new Grupo(2 , "J - Executivo" , 22.5 , 7.8);
		Veiculo v4 = new Veiculo(1 ,"Pick-up 1.0", "GM", "BJ09432FAÇL3", "BJS-0932", "1.0", "Guarulhos", "São Paulo");
		Veiculo v5 = new Veiculo(2 ,"Uno 1.0", "VW", "FDAEWDSAÇL3", "BJS-0932", "1.0", "Santos", "São Paulo");
//		Veiculo v6 = new Veiculo(3 ,"Golf 1.6", "VW", "FDAEWDSAÇL3", "BJS-0932", "1.0", "Paraiba", "Nordeste");
		
		grupo2.addVeiculo(v4);
		grupo2.addVeiculo(v5);
//		grupo.addVeiculo(v6);
		
		ArrayList<Grupo> grupos = new ArrayList<Grupo>();
		grupos.add(grupo);
		grupos.add(grupo2);
		
		ConsultarVeiculoCtrl app = new ConsultarVeiculoCtrl(grupos);
		*/
		
//		====================================================================
//		FIM
//		====================================================================
		
		/*
//		====================================================================
//		TESTE CASO DE USO - CONSULTAR VEÍCULO C/ ACESSO AO BANCO
//		====================================================================
		ConsultarVeiculoCtrl app = new ConsultarVeiculoCtrl(1);
		*/
//		====================================================================
//		FIM
//		====================================================================
		
//		====================================================================
//		TESTE CASO DE USO - EFETUAR PAGAMENTO C/ ACESSO AO BANCO
//		====================================================================
//		FormaPagamentoCtrl app = new FormaPagamentoCtrl(123.32);
//		====================================================================
//		FIM
//		====================================================================
		
//		====================================================================
//		TESTE CASO DE USO - REALIZAR LOCAÇÃO C/ ACESSO AO BANCO
//		====================================================================
//		Agencia agencia = new Agencia();
//		agencia.setCodigo(1);
//		agencia.setNome("Bela Vista");
//		RealizarLocacaoCtrl app = new RealizarLocacaoCtrl(agencia);
//		RealizarLocacaoCtrl app = new RealizarLocacaoCtrl();
		
//		====================================================================
//		TESTE CASO DE USO - DEVOLVER LOCAÇÃO C/ ACESSO AO BANCO
//		====================================================================
//		DevolverLocacaoCtrl app = new DevolverLocacaoCtrl(agencia);
		
//		Locacao locacao = new Locacao();
//		
//		Cliente cliente = new Cliente("Diego", "123", "123456", "fasdf");
//		Veiculo veiculo = new Veiculo();
//		veiculo.setModelo("Gol 1.0");
//		
//		locacao.setClienteEscolhido(cliente);
//		locacao.setVeiculoEscolhido(veiculo);
//		
//		TarifaControladaCtrl controller = new TarifaControladaCtrl(locacao);
		
//		Cliente cliente = new Cliente("Diego", "134.123.321-01", "123456", "fasdf");
//		SerasaImpl serasa = new SerasaImpl();
////		serasa.validar(cliente);
//		if(serasa.validar(cliente) == true){
//			System.out.println("cliente está com o cpf/cnpj no serasa");
//		}
//		else{
//			System.out.println("cliente está OK!!!");
//		}
		
		SistemaCartaoCreditoImpl app = new SistemaCartaoCreditoImpl();
//		boolean is = app.readRecords();
		Cartao cartao = new Cartao();
		cartao.setTipo("Mastercard");
		cartao.setNomeCliente("João Henrique");
		cartao.setCpf("123.123.123-12");
		cartao.setNumCartao("3892 1023 9212 3321");
		Date dt = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.format(dt);
		
		cartao.setDtaValidade(dt);
		cartao.setCodSegurança("123 ");
		System.out.println(cartao.toString());
		
		if(app.debitar(cartao) == true){
			System.out.println("ok");
		}else{
			System.out.println("NOK");
		}
		
//		String v = cartao.toString().t
//		System.out.println(v);
		
	}
	
}
