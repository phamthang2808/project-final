package com.javaweb.model.dto;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class TransactionDTO extends AbstractDTO {

    private Long id;
    private String note;
    @NotNull(message = "Customer ID cannot be null")
    private Long customerId;
    @NotBlank(message = "Transaction type can not be Blank")
    private String code;

}
