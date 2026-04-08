package com.java360.pmanager.domain.exception;

import com.java360.pmanager.infrastructure.exception.RequestException;

public class DuplicateProjectException extends RequestException {

    public DuplicateProjectException(String projectName) {
        super("ProjectDuplicate", "A project with name already exists: " + projectName);
    }
}
