package com.alibaba.partybusiness.config.mvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

//配置了全局自定义器之后
@Configuration
public class CustomWebMvcConfig extends WebMvcConfigurationSupport{

	
	//自定义拦截器配置的时候要把静态资源隔离在外卖金通过  .addexclude方法去不包括后面的资源
//	@Override
//	protected void addInterceptors(InterceptorRegistry registry) {
//		 registry.addInterceptor(new LoginIntercept()).addPathPatterns("/**").excludePathPatterns("/adminUser/login");
//		super.addInterceptors(registry);
//	 .excludePathPatterns("/static/admin/**", "/static/user/**");
//	}
	
	  //redis配置
		@Bean
		public RedisCacheManager cacheManager(RedisConnectionFactory  redisConnectionFactory) {
		        return RedisCacheManager.create(redisConnectionFactory);
		}
		
		   /**
	     * 添加静态资源文件，外部可以直接访问地址
	     * @param registry
	     */
	    @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        //其他静态资源
//	        registry.addResourceHandler("/upload/**").addResourceLocations("file:"+ TaleUtils.getUplodFilePath()+"upload/");
	        //需要配置1：----------- 需要告知系统，这是要被当成静态文件的！
	        //第一个方法设置访问路径前缀，第二个方法设置资源路径
	        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
	    }
		
		
		
}
