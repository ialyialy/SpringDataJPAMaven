package com.preact;



import java.util.Iterator;
import java.util.Map;



import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;


public class dataMaster {
	public static void main(String[] args) {

		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				BeanConfiguration.class);

		SalesRepository repository = context.getBean(SalesRepository.class);

		Iterable<Sales> sales_data = repository.findAll();

		Iterator<Sales> it = sales_data.iterator();
		
		//Data Merge
		Map<String, Long> map = Util.dataMerge(it);

		//Data Output
		Util.writeData2CSV(map, "/Users/csctest/csctest.csv");

		System.out.println("Completed!");

		((AbstractApplicationContext) context).close();
	}
	
	
}