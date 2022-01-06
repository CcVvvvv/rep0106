package dao;

import java.util.List;

import entity.AskForLeave;
import entity.WorkOverTime;

public interface WorkOverTimeDao {
	public List<WorkOverTime> findAllInf(int page, int pageSize,String dept,String year,String month) throws Exception;
}
