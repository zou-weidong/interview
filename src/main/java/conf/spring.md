#Spring
针对面试回顾一下标准答案

##1. Spring框架中bean的生命周期。

划分为几个大类：

1. Bean级生命周期接口方法；BeanNameAware BeanFactoryAware InitializingBean  DisposableBean
2. 容器级生命周期接口方法；InstantiationAwareBeanPostProcessor  BeanPostProcessor 
3. 工厂级处理器接口方法； AspectJWeavingEnabler   CustomAutowireConfigurer
4. Bean自身的方法。 通过配置文件中的初始化和销毁的方法


- Spring容器 从XML 文件中读取bean的定义，并实例化bean。
- Spring根据bean的定义填充所有的属性。
- 如果bean实现了BeanNameAware 接口，Spring 传递bean 的ID 到 setBeanName方法。  （MapperScannerConfigurer）
- 如果实现了BeanFactoryAware 接口，就传递beanFactory给setBeanFactory方法。 （ProxyFactoryBean）
- 如果实现了BeanPostProcessor 类，调用 postProcessBeforeInitialization方法，postProcessAfterInitialization方法。
- 如果实现了IntializingBean接口，调用afterPropertiesSet方法，如果bean声明了初始化方法，就调用次方法
- 如果实现了DisposableBean接口，调用destroy方法

##2. Spring Aop
动态代理指的是通过一个代理对象来创建需要的业务对象，然后在这个代理对象中统一进行各种需求的处理。
场景一般是：日志、事务、鉴权。

分两个方面去表达，一个是aop的实现，另一个是spring的动态代理

1. 实现一般是：只需要关注 InvocationHandler 与 Proxy 对象。   
   
       /**
        目的： 该方法负责集中处理动态代理类上的所有方法调用。
        第一个参数既是代理类实例，
        第二个参数是被调用的方法对象
        第三个方法是调用参数。
        调用处理器根据这三个参数进行预处理或分派到委托类实例上发射执行
       */
        public Object invoke(Object proxy, Method method, Object[] args)
        
       /**
        目的： 创建动态代理对象
        *  loader 类加载器，将字节码加载到JVM并为其定义类对象，然后该类才能使用
        *  Proxy类与普通类的唯一区别就是其字节码是由JVM在运行时动态生成的而非预存在任意一个.class文件中。
        */
        public static Object newProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h)       
        
        流程机制：
        1. 通过实现 InvocationHandler 接口创建自己的调用处理器；
        2. 通过为 Proxy 类指定 ClassLoader 对象和一组 interface 来创建动态代理类；
        3. 通过反射机制获得动态代理类的构造函数，其唯一参数类型是调用处理器接口类型；
        4. 通过构造函数创建动态代理类实例，构造时调用处理器对象作为参数被传入。
        5. 通过代理对象调用目标方法
        
       
        动态代理的类已经 extends Proxy，所以只能实现接口。
        因此才有cglib的需要。
        
2. spring中的动态代理

一：基本的概念：

- Aspect（切面）：通常包含了切入点以及通知
- JointPoint（连接点）：程序执行过程中明确的点，一般是方法的调用
- Advice(通知):AOP在特定的切入点上执行的增强处理，有before,after,afterReturning,afterThrowing,around
- Pointcut(切入点):就是带有通知的连接点，在程序中主要体现为书写切入点表达式
- AOP代理：AOP框架创建的对象，代理就是目标对象的加强。Spring中的AOP代理可以使JDK动态代理，也可以是CGLIB代理，前者基于接口，后者基于子类

二：spring aop

Spring中的AOP代理还是离不开Spring的IOC容器，代理的生成，管理及其依赖关系都是由IOC容器负责。
Spring默认使用JDK动态代理，在需要代理类而不是代理接口的时候，Spring会自动切换为使用CGLIB代理。
不过现在的项目都是面向接口编程，所以JDK动态代理相对来说用的还是多一些。

三：基于注解的aop配置文件

1. 启用@AsjectJ支持    <aop:aspectj-autoproxy />
2. 通知的类型介绍  before,after,afterReturning,afterThrowing,around
3. 通知执行的优先级 Around -> Before -> Around -> AfterReturning -> After
4. 切入点的定义和表达式：

       #  第一个*为任意方法的返回值；(..)标识零个或者多个，标识service包及其子包，第二个*表示所有的类，第三个*表示所有的方法，第二个(..)表示方法的任意参数个数； 
       @Pointcut("execution(* com.aijava.springcode.service..*.*(..))")
        
四：基于XML配置方式
      
    #注意切入点表达式,!bean(logService) 做日志通知的时候，不要给日志本身做日志，否则会造成无限循环！   
    <aop:config>
            <aop:aspect id="loggerAspect" ref="logger">
                <aop:around method="record" pointcut="(execution(* com.aijava.distributed.ssh.service..*.add*(..))
                                                  or   execution(* com.aijava.distributed.ssh.service..*.update*(..))
                                                  or   execution(* com.aijava.distributed.ssh.service..*.delete*(..)))
                                                and !bean(logService)"/>
            </aop:aspect>
    </aop:config>


















    

