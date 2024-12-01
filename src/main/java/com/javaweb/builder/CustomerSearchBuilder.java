package com.javaweb.builder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerSearchBuilder {
    private String fullname;
    private String phone;
    private String email;
    private String status;
    private Long staffId;
    private String createdby;

    public CustomerSearchBuilder(Builder builder) {
        this.fullname = builder.fullName;
        this.phone = builder.phone;
        this.status = builder.status;
        this.staffId = builder.staffId;
        this.email = builder.email;
        this.createdby = builder.createdby;
    }

    public static class Builder {
        private String fullName;
        private String phone;
        private String email;
        private String status;
        private Long staffId;
        private String createdby;

        public Builder setFullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public  Builder setEmail(String email){
            this.email = email;
            return this;
        }
        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder setStaffId(Long staffId) {
            this.staffId = staffId;
            return this;
        }

        public Builder setCreatedby(String createdby) {
            this.createdby = createdby;
            return this;
        }

        public CustomerSearchBuilder build() {
            return new CustomerSearchBuilder(this);
        }
    }

}
