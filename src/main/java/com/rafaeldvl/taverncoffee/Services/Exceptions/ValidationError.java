package com.rafaeldvl.taverncoffee.Services.Exceptions;

import com.rafaeldvl.taverncoffee.Resources.StandardError;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {


    private static final long serialVersionUID = 1L;

    List<FieldMessage> listaErrors = new ArrayList<>();

    public ValidationError() {

    }

    public ValidationError(Long timestamp, Integer status, String error, String message, String path) {
        super(timestamp, status, error, message, path);
    }

    public List<FieldMessage> getListaErrors() {
        return listaErrors;
    }

    public void addListaErrors(String fiedlname, String message) {
        this.listaErrors.add(new FieldMessage(fiedlname,message));
    }
}
