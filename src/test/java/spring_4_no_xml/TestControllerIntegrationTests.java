package spring_4_no_xml;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.ServletWebRequest;
//这俩包。。。。。。。
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.eiecc.fire.spring_4_no_xml.mvc.service.DemoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@WebAppConfiguration
public class TestControllerIntegrationTests {

	@Autowired
	private DemoService demoService;

	@Autowired
	private WebApplicationContext context;

	private MockMvc mockMvc;

	@Autowired
	WebApplicationContext wac; // cached

	@Autowired
	MockServletContext servletContext; // cached

	@Autowired
	MockHttpSession session;

	@Autowired
	MockHttpServletRequest request;

	@Autowired
	MockHttpServletResponse response;

	@Autowired
	ServletWebRequest webRequest;

	@Before
	public void setup() {

		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	public void testNormalController() throws Exception {
		this.mockMvc.perform(get("/accounts/1"))
				.andExpect(status().isOk()).andExpect(content().contentType("application/json"))
				.andExpect(jsonPath("$.name").value("Lee"));
	}
}
