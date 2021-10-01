package model;

import java.util.UUID;

public class Operator {
    private UUID id;
    private String code;

    public Operator(UUID id, String code) {
        this.id = id;
        this.code = code;
    }

    public Operator() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Operator{" +
                "id=" + id +
                ", code='" + code + '\'' +
                '}';
    }
}
