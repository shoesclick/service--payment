package com.shoesclick.service.payment.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import com.shoesclick.service.payment.enums.TypeLog;
@Entity
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TypeLog typeLog;

    @Size(min = 1, max = 100)
    private String className;

    @Size(min = 5, max = 200)
    private String methodName;

    @Column(length = 700)
    private String details;

    public Long getId() {
        return id;
    }

    public Log setId(Long id) {
        this.id = id;
        return this;
    }

    public TypeLog getTypeLog() {
        return typeLog;
    }

    public Log setTypeLog(TypeLog typeLog) {
        this.typeLog = typeLog;
        return this;
    }

    public String getClassName() {
        return className;
    }

    public Log setClassName(String className) {
        this.className = className;
        return this;
    }

    public String getMethodName() {
        return methodName;
    }

    public Log setMethodName(String methodName) {
        this.methodName = methodName;
        return this;
    }

    public String getDetails() {
        return details;
    }

    public Log setDetails(String details) {
        this.details = details;
        return this;
    }
}
