package model.dao;


public class FactoryDao {
	
	public static VeiculoDao2 obterVeiculoDao() {
		System.out.println("teste factory");
		return new VeiculoPostgresDao();
	}
	
}

