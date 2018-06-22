package common.util;

 
import java.util.List;

import common.util.impl.Page;

 
public interface BaseDao<T> extends ConditionHandler<T> {
	List<T> findAll(T condition) throws Exception; 
	T findById(T condition) throws Exception;
	
	int getRows(T condition) throws Exception;
	List<T> findByPaging(Page<T> page,T condition) throws Exception;
	
	int add(T condition) throws Exception;
	int update(T condition) throws Exception;
	int delete(T condition) throws Exception;
}
