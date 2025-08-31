package com.ort.dbflute.allcommon;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.dbflute.bhv.core.BehaviorCommandInvoker;
import org.dbflute.bhv.core.InvokerAssistant;

/**
 * The Java configuration of DBFlute beans for Spring Framework. <br>
 * You can inject them by importing this class in your auto configuration class.
 * @author DBFlute(AutoGenerator)
 */
@Configuration
@ComponentScan(value="com.ort.dbflute.exbhv", lazyInit=true)
public class DBFluteBeansJavaConfig {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    @Autowired
    protected ApplicationContext _container;

    @Autowired
    @Qualifier("dataSource")
    protected DataSource _dataSource; // name basis here for multiple DB

    // ===================================================================================
    //                                                                   Runtime Component
    //                                                                   =================
    @Bean(name="introduction")
    public DBFluteInitializer createDBFluteInitializer() { // no lazy for initialize-only component
        hookInitialization();
        return newDBFluteInitializer(_dataSource);
    }

    protected void hookInitialization() { // you can override for e.g. DBFluteConfig settings
        // do nothing as default
    }

    protected DBFluteInitializer newDBFluteInitializer(DataSource dataSource) {
        return new com.ort.dbflute.allcommon.DBFluteInitializer(dataSource);
    }

    @Bean(name="invokerAssistant")
    @Lazy
    public InvokerAssistant createImplementedInvokerAssistant() {
        ImplementedInvokerAssistant assistant = newImplementedInvokerAssistant();
        assistant.setDataSource(_dataSource);
        return assistant;
    }

    protected ImplementedInvokerAssistant newImplementedInvokerAssistant() {
        return new com.ort.dbflute.allcommon.ImplementedInvokerAssistant();
    }

    @Bean(name="behaviorCommandInvoker")
    @Lazy
    public BehaviorCommandInvoker createBehaviorCommandInvoker() {
        BehaviorCommandInvoker invoker = newBehaviorCommandInvoker();
        invoker.setInvokerAssistant(createImplementedInvokerAssistant());
        return invoker;
    }

    protected BehaviorCommandInvoker newBehaviorCommandInvoker() {
        return new BehaviorCommandInvoker();
    }

    @Bean(name="behaviorSelector")
    @Lazy
    public ImplementedBehaviorSelector createImplementedBehaviorSelector() {
        ImplementedBehaviorSelector selector = newImplementedBehaviorSelector();
        selector.setContainer(_container);
        return selector;
    }

    protected ImplementedBehaviorSelector newImplementedBehaviorSelector() {
        return new ImplementedBehaviorSelector();
    }

    @Bean(name="commonColumnAutoSetupper")
    @Lazy
    public ImplementedCommonColumnAutoSetupper createImplementedCommonColumnAutoSetupper() {
        return newImplementedCommonColumnAutoSetupper();
    }

    protected ImplementedCommonColumnAutoSetupper newImplementedCommonColumnAutoSetupper() {
        return new ImplementedCommonColumnAutoSetupper();
    }
}
