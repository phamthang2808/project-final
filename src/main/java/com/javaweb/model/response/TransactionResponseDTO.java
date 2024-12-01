package com.javaweb.model.response;

import com.javaweb.model.dto.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionResponseDTO extends AbstractDTO {
    private Long id;
    private String code;
    private String note;
    private Long customerId;
    private Long staffId;
}
