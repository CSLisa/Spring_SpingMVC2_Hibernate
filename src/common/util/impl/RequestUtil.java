package common.util.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class RequestUtil {
	//Request转化为T entity  
	/*
	  Dept dept=requestToBean(request,Dept.class)
	  Dept id,name 必须和request.getParameter() id/name是一致的 add.jsp/update.jsp/list.jsp id,name
	 */
    public static <T> T requestToBean(HttpServletRequest request, Class<T> beanClass) {  
        try {  
            // 创建封装数据的bean  
            T bean = beanClass.newInstance();  
            Map map = request.getParameterMap();  
            BeanUtils.populate(bean, map);  
            return bean;  
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        }  
    }
	//Request转化为List<T> entities
    public static <T> T requestToListBean(HttpServletRequest request, Class<T> beanClass) throws Exception{  
       // 创建封装数据的bean  
          T bean = beanClass.newInstance();  
          BeanUtils.populate(bean, request.getParameterMap());  
          return bean;  
    }
    //setProperty(Object bean, String name, Object value) 
    public <T> List<T> requestToListBean(HttpServletRequest request,int length, Class<T> beanClass) throws Exception{  
       /*
    	//1.声明
        //2.将每个_0的Bean对象放到list
    	//3.返回List<T> list
        */
    	//1.声明
    	 List<T>  list=new ArrayList<T>(); 
        //2.将每个_0的Bean对象放到list
    	for (int i = 0; i <length; i++) {
    		/*
    		//1>创建Bean对象
    		//2>Bean各个字段赋值
        	 //3>将Bean保存到List<T> list中
    		 */
    		//1>创建Bean对象
    		 T bean = beanClass.newInstance(); 
    		//2>Bean各个字段赋值
        	 Field[] fields=beanClass.getDeclaredFields();
        	 for (int j = 0; j < fields.length; j++) { 
        		 /*基本数据类型和String字段赋值*/
        		if(request.getParameter(fields[j].getName()+"_"+i)!=null){
        			if(fields[j].getType().isPrimitive()){
        				 //boolean, byte, char, short, int, long, float, and double
        				if(fields[j].getType().getSimpleName().toLowerCase().contains("boolean")){ 
        						Boolean value=Boolean.valueOf(request.getParameter(fields[j].getName()+"_"+i));
        	        			BeanUtils.setProperty(bean,fields[j].getName(),value);
        				}else if(fields[j].getType().getSimpleName().toLowerCase().contains("byte")){
        						Byte value=Byte.valueOf(request.getParameter(fields[j].getName()+"_"+i));
        	        			BeanUtils.setProperty(bean,fields[j].getName(),value); 
        				}else if(fields[j].getType().getSimpleName().toLowerCase().contains("char")){
        						Character value=Character.valueOf(request.getParameter(fields[j].getName()+"_"+i).charAt(0));
        	        			BeanUtils.setProperty(bean,fields[j].getName(),value);
        				}else if(fields[j].getType().getSimpleName().toLowerCase().contains("short")){
        						Short value=Short.valueOf(request.getParameter(fields[j].getName()+"_"+i));
        	        			BeanUtils.setProperty(bean,fields[j].getName(),value);
        				}else if(fields[j].getType().getSimpleName().toLowerCase().contains("int")){
        						Integer value=Integer.valueOf(request.getParameter(fields[j].getName()+"_"+i));
        	        			BeanUtils.setProperty(bean,fields[j].getName(),value);
        				}else if(fields[j].getType().getSimpleName().toLowerCase().contains("long")){
        						Long value=Long.valueOf(request.getParameter(fields[j].getName()+"_"+i));
        	        			BeanUtils.setProperty(bean,fields[j].getName(),value);
        				}else if(fields[j].getType().getSimpleName().toLowerCase().contains("float")){
        						Float value=Float.valueOf(request.getParameter(fields[j].getName()+"_"+i));
        	        			BeanUtils.setProperty(bean,fields[j].getName(),value);
        				}else if(fields[j].getType().getSimpleName().toLowerCase().contains("double")){
        						Double value=Double.valueOf(request.getParameter(fields[j].getName()+"_"+i));
        	        			BeanUtils.setProperty(bean,fields[j].getName(),value);
        				} 
        			}else if(fields[j].getType().getSimpleName().equalsIgnoreCase("String")){
        				BeanUtils.setProperty(bean,fields[j].getName(),request.getParameter(fields[j].getName()+"_"+i));
        			}  
        		}  
			 }
        	 //3>将Bean保存到List<T> list中
        	 list.add(bean);
		 } 
    	  //3.返回List<T> list
           return list;  
     }
}

