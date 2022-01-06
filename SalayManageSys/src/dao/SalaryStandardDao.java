package dao;

import entity.SalaryStandard;

public interface SalaryStandardDao {
	public void save(SalaryStandard salaryStandard) throws Exception ;
	public void delete( String did) throws Exception ;
}
