package com.messiyang.miaosha.exception;


import com.messiyang.miaosha.result.enums.ResultStatus;

public class GlobalException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private ResultStatus resultStatus;

    public GlobalException(ResultStatus resultStatus) {
        super(resultStatus.toString());
        this.resultStatus = resultStatus;
    }

    public ResultStatus getCm() {
        return resultStatus;
    }

}
