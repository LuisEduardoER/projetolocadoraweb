package model.dao;


public class FactoryDao {
	
	public static VeiculoDao obterVeiculoDao() {
		System.out.println("teste factory");
		return new VeiculoPostgresDao();
	}
	
}

