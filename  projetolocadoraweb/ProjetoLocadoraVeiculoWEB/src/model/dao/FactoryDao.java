package model.dao;

public class FactoryDao {
	public static VeiculoDao obterVeiculoDao() {
		return new VeiculoPostgresDao();
	}
}