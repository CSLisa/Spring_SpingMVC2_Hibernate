# Spring_SpingMVC2_Hibernate
基于ssh的商业设备巡检项目，仅有一个company模块，只是作为框架学习和联系使用的项目，hibernate刚接触不久，以供学习使用，还有mybatis和structs的整合。。。。

更多的是想表达一种编程思想，设计模式之类的，设计了很多扩展接口，很大程度上提升本身的扩展性，尽可能的提取出通用功能作为通用工具类。

框架在很大程度上方便了很多，重要的还是要自己整理属于自己的整合流程，很多框架本身默认的东西有时候并不是我们需要的东西。




(注解配置项目市场当前重点)添加Hibernate 框架—Entity/Dao层修改 

     /*注意同一个Web项目中,当Hibernate注解配置和XML配置都存在,注解生效,XML配置报错
        1>命令定位
        
2>选择Hibernate版本(5.1)和运行时间环境(Tomcat85)   

3>Hibernate在Spring中applicationContext.xml配置sessionFactory

4>描述hibernate数据库连接细节

5>添加Hibernate的jar包库到项目

6>修改hibernate.cfg.xml—调整顺序更自然

7>复制applicationContext.xml创建applicationContext05-$15Hibernate.xml

      修改applicationContext.xml自动生成中的错误sessionFactory中的为hibernate4
      
      剪切到applicationContext05-$15Hibernate.xml
      
8>基本原理到综合项目Dao层实现(复制并修改Entity/Dao层，保留UsersDao接口)

      /*
   <1>使用Hibernate逆向工程工具创建注解格式化的实体类Users
       /*
       
       1)创建scott数据库连接(略)
       
           2)打开scottConnected to scottSCOTTtable找到表Functions 
           
       3)执行Hibernate逆向工程，从表Functions生成实体类Functions及注解实现
       
            /*
            (1)命令定位
            
            (2)配置类型映射细节(默认)
            
            (3)创建表的产品(artifacts)
            
            (4)执行逆向工程
            
            (5)修改实体类—多单词名称注意符合java命名规范
            */
        */
        
   <2>(基本原理实现)main测试实现—参见concept. HibernateAnnotationTest.java
   
      /*
       <1>源代码
       
       <2>显示效果
      */
      
   <3>(综合项目定位Dao实现—基于基本原理Hibernate父类和模块子类实现)
   
       /*
       1)开发HibernateDaoImpl公用设施
       
       2)模块Dao实现类—FunctionsDaoImpl
       
       3)web测试实现
       
      */
*/
