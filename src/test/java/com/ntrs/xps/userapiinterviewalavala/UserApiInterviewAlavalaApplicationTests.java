package com.ntrs.xps.userapiinterviewalavala;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.ntrs.xps.userapiinterviewalavala.controller.EmployeeController;
import com.ntrs.xps.userapiinterviewalavala.entity.Employee;
import com.ntrs.xps.userapiinterviewalavala.service.EmployeeService;
import com.ntrs.xps.userapiinterviewalavala.service.EmployeeServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class UserApiInterviewAlavalaApplicationTests
{
    @MockBean
    private MockMvc mockMvc;

    @Mock
    private EmployeeServiceImpl employeeServieImpl;

    @InjectMocks
    private EmployeeController controller;



    @Mock
    private EmployeeService service;

    ObjectMapper om = new ObjectMapper();




    @Before
    public void setup() {

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

    }

    @Test
    public void saveEmployee_should_save_employee_to_db_and_return_saved_employee() throws Exception {
        //given

        Employee employee = new Employee();
        employee.setId((long) 1);
        employee.setFirstName("First");
        employee.setLastName("Last");
        String jsonRequest = om.writeValueAsString(employee);

        //when
        when(controller.addEmployee(employee)).thenReturn(employee);

        String url = "/employee/addEmployee";

        mockMvc.perform(MockMvcRequestBuilders
                .post(url).content(jsonRequest)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isCreated())
        ;

        Employee expected = controller.addEmployee(employee);
        //when
        assertEquals(expected , employee);

    }

    @Test
    public void getEmployee_should_return_employee_from_db_which_had_given_first_name_success() throws Exception {
        //given

        Employee employee = new Employee();
        employee.setId((long) 1);
        employee.setFirstName("First");
        employee.setLastName("Last");

        List<Employee> empList = new ArrayList<>();


        controller.addEmployee(employee);
        empList.add(employee);

        //when
        when(controller.getEmployeesByFirstName("First")).thenReturn(empList);

        String url = "/employee/getEmployeesByFirstName/First";

        mockMvc.perform(MockMvcRequestBuilders
                .get(url)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());

        List<Employee> expected = controller.getEmployeesByFirstName("First");


        //when
        assertEquals(expected, empList);

    }
}
