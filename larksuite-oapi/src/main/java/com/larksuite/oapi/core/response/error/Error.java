package com.larksuite.oapi.core.response.error;

import java.util.Arrays;

public class Error {

    private ErrorDetail[] details;
    private ErrorPermissionViolation[] permissionViolations;
    private ErrorFieldViolation[] fieldViolations;
    private ErrorHelp[] helps;

    public ErrorDetail[] getDetails() {
        return details;
    }

    public void setDetails(ErrorDetail[] details) {
        this.details = details;
    }

    public ErrorPermissionViolation[] getPermissionViolations() {
        return permissionViolations;
    }

    public void setPermissionViolations(ErrorPermissionViolation[] permissionViolations) {
        this.permissionViolations = permissionViolations;
    }

    public ErrorFieldViolation[] getFieldViolations() {
        return fieldViolations;
    }

    public void setFieldViolations(ErrorFieldViolation[] fieldViolations) {
        this.fieldViolations = fieldViolations;
    }

    public ErrorHelp[] getHelps() {
        return helps;
    }

    public void setHelps(ErrorHelp[] helps) {
        this.helps = helps;
    }

    @Override
    public String toString() {
        return "{" +
                "details=" + Arrays.toString(details) +
                ", permissionViolations=" + Arrays.toString(permissionViolations) +
                ", fieldViolations=" + Arrays.toString(fieldViolations) +
                ", helps=" + Arrays.toString(helps) +
                '}';
    }
}
