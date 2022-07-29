package com.sg.kata.models;
import com.sg.kata.enums.OperationTypeEnum;

import java.io.Serializable;
import java.time.LocalDateTime;

public interface AccountStatement extends Serializable, Cloneable{

    OperationTypeEnum getOperationType();

    LocalDateTime getDate();

    double getAmount();

    double getBalance();
}
