package ntuzy_springboot.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.ntuzy.demo.controller.NtuZyApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= {NtuZyApplication.class})
@AutoConfigureMockMvc
public class MockMvcTestDemo {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void apiTest() throws Exception {
		
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		// 获取状态码
		int status = mvcResult.getResponse().getStatus();
		System.out.println(status);
	} 
	
	
	
}
