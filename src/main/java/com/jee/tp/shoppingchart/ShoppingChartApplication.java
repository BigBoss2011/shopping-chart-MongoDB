package com.jee.tp.shoppingchart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.mongodb.core.index.IndexOperations;
import org.springframework.data.mongodb.core.index.IndexResolver;
import org.springframework.data.mongodb.core.index.MongoPersistentEntityIndexResolver;
import org.springframework.data.mongodb.core.mapping.BasicMongoPersistentEntity;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class}
		//exclude=[DataSourceAutoConfiguration::class]
)
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class ShoppingChartApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingChartApplication.class, args);
	}



	//@EventListener(ApplicationReadyEvent.class)
//	public void initIndicesAfterStartup() {
//
//		//log.info("Mongo InitIndicesAfterStartup init");
//		var init = System.currentTimeMillis();
//
//		var mappingContext = this.mongoConverter.getMappingContext();
//
//		if (mappingContext instanceof MongoMappingContext) {
//			MongoMappingContext mongoMappingContext = (MongoMappingContext) mappingContext;
//
//			for (BasicMongoPersistentEntity<?> persistentEntity : mongoMappingContext.getPersistentEntities()) {
//				var clazz = persistentEntity.getType();
//				if (clazz.isAnnotationPresent(Document.class)) {
//					IndexOperations indexOps = mongoTemplate.indexOps(clazz);
//					IndexResolver resolver = new MongoPersistentEntityIndexResolver(mongoMappingContext);
//					resolver.resolveIndexFor(clazz).forEach(indexOps::ensureIndex);
//				}
//			}
//
//		}
//
//		log.info("Mongo InitIndicesAfterStartup take: {}", (System.currentTimeMillis() - init));
//	}
}
