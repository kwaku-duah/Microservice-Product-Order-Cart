package com.ecommerce.paymentservice.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
/*
usage of mongodb to create entities
very simple and effective
 */

@Document(collection="transactions_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDetails {

    @Id
    private String id; //mongo auto generates Object id stored as a string
    private Long orderId;
    private String paymentMode;
    private String referenceNumber;
    private Instant paymentDate;
    private String paymentStatus;
    private Double amount;


}
