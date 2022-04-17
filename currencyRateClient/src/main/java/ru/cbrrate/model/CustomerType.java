package ru.cbrrate.model;

public enum CustomerType {
    USER("user");

    String userName;

    CustomerType(String serviceName) {
        this.userName = serviceName;
    }

    public String getServiceName() {
        return userName;
    }
}
