package com.chibuisi.springcloudfunctiongcp;

import com.chibuisi.springcloudfunctiongcp.model.Payment;
import com.chibuisi.springcloudfunctiongcp.model.PaymentReport;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.function.Function;

@SpringBootApplication
public class SpringCloudFunctionGcpApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudFunctionGcpApplication.class, args);
    }

    @Bean
    public Function<Payment, PaymentReport> function(){
        return input -> {
            PaymentReport paymentReport = PaymentReport.builder()
                    .uuid(UUID.randomUUID())
                    .payment(input)
                    .localDateTime(LocalDateTime.now())
                    .status("success")
                    .build();
            return paymentReport;
        };
    }

}
