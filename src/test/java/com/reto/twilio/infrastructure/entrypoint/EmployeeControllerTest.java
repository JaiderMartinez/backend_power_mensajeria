package com.reto.twilio.infrastructure.entrypoint;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reto.twilio.application.dto.request.OrderNotificationRequestDto;
import com.reto.twilio.domain.model.TwilioMessageModel;
import com.reto.twilio.domain.spi.ITwilioSmsServiceProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private ITwilioSmsServiceProvider twilioSmsServiceProvider;
    private static final String NOTIFY_CUSTOMER_BY_SMS_MESSAGE_PATH = "/messenger-service/notify";
    private static final String EMAIL_EMPLOYEE = "employee@employee";
    private static final String PASSWORD_EMPLOYEE = "123";
    private static final String ROL_EMPLOYEE = "EMPLEADO";

    @WithMockUser(username = EMAIL_EMPLOYEE, password = PASSWORD_EMPLOYEE, roles = {ROL_EMPLOYEE})
    @Test
    void test_notifyCustomerThatOrderIsReady_withRequestObjectAsOrderNotificationRequestDtoCorrect_shouldReturnCreatedStatus() throws Exception {
        String bodyMessageRequest = " Estimado cliente Roberto su pedido del restaurante Tacos picantes con el pin 12345 esta listo para ser recogido";
        String bodyMessageResponse = "Sent from your Twilio trial account - Estimado cliente Roberto su pedido del restaurante Tacos picantes con el pin 12345 esta listo para ser recogido";
        TwilioMessageModel twilioMessageModelResponse = new TwilioMessageModel(null, "+573982391327", bodyMessageResponse, null, null,
                                                        "Delivered", "Outgoing_API", LocalDate.now(), LocalDate.now());
        when(this.twilioSmsServiceProvider.sendNotification(argThat(twilioMessageRequest -> twilioMessageRequest.getCellPhone().equals("+573982391327") &&
                twilioMessageRequest.getBodyMessage().equals(bodyMessageRequest)
        ))).thenReturn(twilioMessageModelResponse);
        OrderNotificationRequestDto orderNotificationRequest = new OrderNotificationRequestDto(12345L, "Tacos picantes", "Roberto", "3982391327");
        this.mockMvc.perform(MockMvcRequestBuilders.post(NOTIFY_CUSTOMER_BY_SMS_MESSAGE_PATH)
                .content(this.objectMapper.writeValueAsString(orderNotificationRequest))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.status").value("Delivered"))
                .andExpect(jsonPath("$.dateCreated").value(LocalDate.now().toString()))
                .andExpect(jsonPath("$.dateUpdated").value(LocalDate.now().toString()));
    }
}