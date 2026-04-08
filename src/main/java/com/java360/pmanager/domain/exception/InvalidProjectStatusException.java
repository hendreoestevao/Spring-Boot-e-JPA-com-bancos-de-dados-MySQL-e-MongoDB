package com.java360.pmanager.domain.exception;

import com.java360.pmanager.infrastructure.exception.RequestException;

public class InvalidProjectStatusException extends RequestException {

    public InvalidProjectStatusException(String statusProject) {
        super("InvalidProjectStatus", "Invalid project status: " + statusProject);
    }
}
