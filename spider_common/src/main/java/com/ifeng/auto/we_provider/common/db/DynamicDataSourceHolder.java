 package com.ifeng.auto.we_provider.common.db;  

 /**
  * 
  * 使用ThreadLocal技术来记录当前线程中的数据源的key
  * 
  * @author zhijun
  *
  */
 public class DynamicDataSourceHolder {
     public static final String DATA_SOURCE_DEFAULT = "spiderDataSource";
     public static final String DATA_SOURCE_B = "deptcodeDataSource";
     public static final String DATA_SOURCE_LAR = "larDataSource";
     public static final String DATA_SOURCE_CHL = "chlDataSource";
     public static final String DATA_SOURCE_DEFAULT_LAR = "spiderLarDataSource";
     private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();
     public static void setCustomerType(String customerType) {
         contextHolder.set(customerType);
     }
     public static String getCustomerType() {
         return contextHolder.get();
     }
     public static void clearCustomerType() {
         contextHolder.remove();
     }

 }