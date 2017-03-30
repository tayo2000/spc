package com.tayo2000.ssm.test;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.tayo2000.ssm.mapper.ProductMapper;
import com.tayo2000.ssm.po.Product;
import com.tayo2000.ssm.po.ProductQuery;

public class testProductMapper {
	ApplicationContext ctx;
	ProductMapper mapper;
	
	@Before
	public void setUp() throws Exception {
		ctx=new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		mapper=(ProductMapper)ctx.getBean("productMapper");
	}

	@After
	public void tearDown() throws Exception {
		((AbstractApplicationContext) ctx).close();
	}

	@Test
	public void testFind() throws Exception {
		List<Product> products=mapper.findByFno("A0001");
		for(Product product:products)
			System.out.println(product);
		
	}
	
	@Test
	public void testFindByCondition() throws Exception {
		ProductQuery productQuery=new ProductQuery();
		Product p=new Product();
		p.setfNo("A0001");
		productQuery.setProduct(p);
		List<Product> products=mapper.findByCondition(productQuery);
		for(Product product:products)
			System.out.println(product);
		
	}
	
	
	@Test
	public void testAdd() throws Exception{
		Product p=new Product();
		p.setfNo("A0001");
		p.setpNo("F1310305");
		p.setpName("DDDDD");
		p.setpType("XXXXX");
		System.out.println(mapper.add(p));
	}
	
	@Test
	public void testDeleteByCondition() throws Exception{
		Product p=new Product();
		p.setfNo("A0001");
		p.setpNo("F1310305");
		ProductQuery pq=new ProductQuery();
		pq.setProduct(p);
		System.out.println(mapper.deleteByCondition(pq));
	}
	
	@Test
	public void testDelete() throws Exception{
		Product p=new Product();
		p.setfNo("A0001");
		p.setpNo("F1310305");
		System.out.println(mapper.delete(p));
	}
	
	
	@Test
	public void testUpdate() throws Exception{
		Product p=new Product();
		p.setfNo("A0001");
		p.setpNo("F1310305");
		ProductQuery pq=new ProductQuery();
		pq.setProduct(p);
		Product p1=mapper.findByCondition(pq).get(0);
		p1.setpName("ddd");
		System.out.println(mapper.update(p1));
	}
	
	@Test
	public void testTotalRecord() throws Exception{
		Product p=new Product();
		p.setfNo("A0001");
		ProductQuery pq=new ProductQuery();
		pq.setProduct(p);
		System.out.println(mapper.getTotalRecord(pq));
	}
}
