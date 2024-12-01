package com.javaweb.model.request;

import com.javaweb.model.dto.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class CustomerSearchRequest extends AbstractDTO {
    private Long id;
    private String name;
    private String phone;
    private String status;
    private Long staffId;
    private String email;
    private String createdBy;
}
