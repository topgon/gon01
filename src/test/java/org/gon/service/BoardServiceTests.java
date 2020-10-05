package org.gon.service;

import org.gon.domain.BoardVO;
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
public class BoardServiceTests {

	@Setter(onMethod_=@Autowired)
	private BoardService service;

	@Test
	public void test() {
		
	BoardVO board = service.get(801L);
	board.setTitle("수수정글");
	board.setContent("수수정글");
	
	log.info("modify.........."+service.modify(board));
		
	}
	
}
