 package com.ifeng.auto.we_provider.common.db;  
 
 import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

 /**
  * 定义动态数据源，实现通过集成Spring提供的AbstractRoutingDataSource，只需要实现determineCurrentLookupKey方法即可
  * 
  * 由于DynamicDataSource是单例的，线程不安全的，所以采用ThreadLocal保证线程安全，由DynamicDataSourceHolder完成。
  * 
  * @author zhijun
  *
  */
 public class DynamicDataSource extends AbstractRoutingDataSource {
     @Override
     protected Object determineCurrentLookupKey() {

         return DynamicDataSourceHolder.getCustomerType();
     }

 }