package common.util;

import java.util.List;

import common.util.impl.Page;

public interface BaseAction<T> {
  //查询 
	String findAll() throws Exception; 
	String findByPaging() throws Exception; 
	String findById() throws Exception; 
  //增删改	
	String toAdd() throws Exception;
	String doAdd() throws Exception;
	String toUpdate() throws Exception;
	String doUpdate() throws Exception;
	String delete() throws Exception;
}
