package com.reto.twilio.infrastructure.entrypoint;

import com.reto.twilio.application.dto.request.OrderNotificationRequestDto;
import com.reto.twilio.application.dto.response.OrderNotifiedResponseDto;
import com.reto.twilio.application.handler.IEmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( path = "/messenger-service/")
@RequiredArgsConstructor
public class EmployeeController {

    private final IEmployeeService employeeService;

    @Operation(summary = "Notify the customer about the ready status of his order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Restaurant created"),
            @ApiResponse(responseCode = "403", description = "Role other than employee")
    })
    @PreAuthorize(value = "hasRole('EMPLEADO')")
    @PostMapping( value = "notify")
    public ResponseEntity<OrderNotifiedResponseDto> notifyCustomerThatOrderIsReady(@Parameter(
            description = "Object to form the body of the message to be sent to the customer", required = true,
            schema = @Schema(implementation = OrderNotificationRequestDto.class))
            @RequestBody OrderNotificationRequestDto orderNotificationRequestDto) {
        return new ResponseEntity<>(this.employeeService.notifyThatOrderIsReady(orderNotificationRequestDto), HttpStatus.CREATED);
    }
}
