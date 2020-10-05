package org.gon.mapper;

import org.gon.domain.Criteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

	@Setter(onMethod_=@Autowired)
	private BoardMapper mapper;
	
	@Test
	public void test() {
		
		Criteria cri = new Criteria();
		cri.setPageNum(5);
		cri.setAmount(10);
		
		mapper.getListWithPaging(cri).forEach(board -> log.info(board));
		
//		mapper.getList().forEach(board -> log.info(board));
		
//		BoardVO board = new BoardVO();
//		board.setTitle("새글");
//		board.setContent("새글");
//		board.setWriter("작성자");
//		
//		mapper.insertSelectKey(board);
//		
//		log.info(board);
		
//	mapper.read(801L);
		
//		int result = mapper.delete(800L);
//		log.info("delete result ............"+result);

//		BoardVO board = mapper.read(801L);
//		board.setContent("변경글");
//		board.setWriter("변경자");
//		
//		mapper.update(board);
		
	}
	
}
