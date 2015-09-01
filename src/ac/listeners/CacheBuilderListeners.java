package ac.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import ac.cache.MyCacheBuilder;


	public class CacheBuilderListeners implements ServletContextListener{
	
		public void contextInitialized(ServletContextEvent sce) {
			MyCacheBuilder cacheBuilder = MyCacheBuilder .getCacheBuilder();
			cacheBuilder.build();
		}
	
		public void contextDestroyed(ServletContextEvent sce) {
			MyCacheBuilder cacheBuilder = MyCacheBuilder .getCacheBuilder();
			cacheBuilder.destroy();
		}
	}

