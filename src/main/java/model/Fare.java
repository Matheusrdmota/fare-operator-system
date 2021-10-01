package model;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public class Fare {
    private UUID id;
    private UUID operatorId;
    private Integer status;
    private Double value;
    private LocalDate creationDate;

    public Fare() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(UUID operatorId) {
        this.operatorId = operatorId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "Fare{" +
                "id=" + id +
                ", operatorId=" + operatorId +
                ", status=" + status +
                ", value=" + value +
                ", creationDate=" + creationDate +
                '}';
    }
}
