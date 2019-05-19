#mybatis源码分析
分为三个点：
1. mybatis如何加载数据源
2. mybatis如何获取执行语句
3. mybatis如何用获取的sql语句操作数据库


##1.mybatis如何加载数据源dataSource
首先看配置文件的数据源模块的标签层级结构:
configuration
--> environments
    --> environment 
        --> transactionManager
        --> dataSource
            --> property
    
原理就是：mybatis对数据源的加载就是按照标签这种形式对数据源进行加载，将dataSource存入Environment，进而存入Configuration。

    org.apache.ibatis.session.SqlSessionFactoryBuilder.build(java.io.InputStream)
    -> org.apache.ibatis.builder.xml.XMLConfigBuilder
        -> org.apache.ibatis.builder.xml.XMLConfigBuilder.parseConfiguration
        -> org.apache.ibatis.builder.xml.XMLConfigBuilder.environmentsElement
            -> org.apache.ibatis.builder.xml.XMLConfigBuilder.dataSourceElement
            #加载dataSource的元数据以及子标签，将
            org.apache.ibatis.session.Configuration.setEnvironment
            #将environment设置进configuration
            
##2. mybatis如何获取执行语句

源码分析时和分析数据源是一样，所以在配置文件中会有标签来对应sql语句。
configuration
-> mappers
    -> mapper
    
    org.apache.ibatis.session.SqlSessionFactoryBuilder.build(java.io.InputStream)
    -> org.apache.ibatis.builder.xml.XMLConfigBuilder
        -> org.apache.ibatis.builder.xml.XMLConfigBuilder.parseConfiguration
            -> org.apache.ibatis.builder.xml.XMLConfigBuilder.mapperElement 
            #获取含有sql语句的mapper信息，里面有加载mapper的四种方式，并且只能是一种
                -> org.apache.ibatis.builder.xml.XMLMapperBuilder.parse
                    -> org.apache.ibatis.builder.xml.XMLMapperBuilder.configurationElement
                    #检查namespace
                    -> org.apache.ibatis.builder.xml.XMLStatementBuilder.parseStatementNode
                    #预加载
                        -> org.apache.ibatis.builder.MapperBuilderAssistant.addMappedStatement(java.lang.String, org.apache.ibatis.mapping.SqlSource, org.apache.ibatis.mapping.StatementType, org.apache.ibatis.mapping.SqlCommandType, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.Class<?>, java.lang.String, java.lang.Class<?>, org.apache.ibatis.mapping.ResultSetType, boolean, boolean, boolean, org.apache.ibatis.executor.keygen.KeyGenerator, java.lang.String, java.lang.String, java.lang.String, org.apache.ibatis.scripting.LanguageDriver, java.lang.String)
                        #将mapperdStatement给configuration


##3. mybatis如何用获取的sql语句操作数据库
用SqlSessionFactory打开sqlSession，在sqlSession中操作数据库。










            
    
###mybatis的面试题：
1. mapper有几种方式被加载？
    四种    
        
    
      <!-- 使用相对于类路径的资源引用 -->  
      <mappers>
        <mapper resource="org/mybatis/builder/AuthorMapper.xml"/>
        <mapper resource="org/mybatis/builder/BlogMapper.xml"/>
        <mapper resource="org/mybatis/builder/PostMapper.xml"/>
      </mappers>
      
      <!-- 使用完全限定资源定位符（URL） -->
      <mappers>
        <mapper url="file:///var/mappers/AuthorMapper.xml"/>
        <mapper url="file:///var/mappers/BlogMapper.xml"/>
        <mapper url="file:///var/mappers/PostMapper.xml"/>
      </mappers>
      
      <!-- 使用映射器接口实现类的完全限定类名 -->
      <mappers>
        <mapper class="org.mybatis.builder.AuthorMapper"/>
        <mapper class="org.mybatis.builder.BlogMapper"/>
        <mapper class="org.mybatis.builder.PostMapper"/>
      </mappers>
      
      <!-- 将包内的映射器接口实现全部注册为映射器 -->
      <mappers>
        <package name="org.mybatis.builder"/>
      </mappers> 