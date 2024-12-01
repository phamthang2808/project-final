package com.javaweb.enums;

import java.util.LinkedHashMap;
import java.util.Map;

public enum TransactionType {
    CSKH("Chăm sóc khách hàng"),
    DDX("Dẫn đi xem");
    private final String type;

    TransactionType(String statusName) {
        this.type = statusName;
    }

    public String getStatusName() {
        return type;
    }

    public static Map<String, String> transactionType() {
        Map<String, String> code = new LinkedHashMap<>();
        for (TransactionType tr : TransactionType.values()) {
            code.put(tr.toString(), tr.getStatusName());
        }
        return code;
    }
}
