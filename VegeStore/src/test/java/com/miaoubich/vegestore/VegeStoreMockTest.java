package com.miaoubich.vegestore;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.miaoubich.vegestore.model.Vegetable;
import com.miaoubich.vegestore.service.VegetableService;

@SpringBootTest
@AutoConfigureMockMvc
public class VegeStoreMockTest {

	@Autowired
	MockMvc mockMvc;
	@Mock
	VegetableService vegetableService;
	
	private ObjectMapper mapper = new ObjectMapper();

	@Test
	public void addnewVegeMockTest() throws Exception {
		Vegetable newVege = buildVege();
		String jsonString = mapper.writeValueAsString(newVege);
		
		when(vegetableService.upsertVege(any(Vegetable.class))).thenReturn(newVege);
		
		this.mockMvc.perform(post("/api/vegetable/upsert").content(jsonString).contentType(MediaType.APPLICATION_JSON))
								.andDo(print())
								.andExpect(status().isCreated())
								.andExpect(jsonPath("$.name").value(newVege.getName()))
								.andExpect(jsonPath("$.price").value(10))
								.andExpect(jsonPath("$.quantity").value(5120))
								.andExpect(content().json(jsonString));
	}

	public Vegetable buildVege() {
		Vegetable vegetable = new Vegetable();
		vegetable.setId(12);
		vegetable.setName("Apple");
		vegetable.setPrice(10);
		vegetable.setQuantity(5120);
		vegetable.setFridge("AA");

		return vegetable;
	}
}
