package com.revature.message_subscriber;

public class SubscriptionDto {
    private String address;
    private String port;
    private String endpoint;

    public SubscriptionDto(String address, String port, String endpoint) {
        this.address = address;
        this.port = port;
        this.endpoint = endpoint;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }
}
