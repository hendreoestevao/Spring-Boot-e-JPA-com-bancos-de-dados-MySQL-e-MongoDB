package com.java360.pmanager.infrastructure.dto;

import com.java360.pmanager.domain.model.ProjectStatus;

import java.time.LocalDate;

public class SaveProjectDataDTO {

    private String id;

    private String name;

    private String description;

    private LocalDate initialDate;

    private LocalDate finalDate;

    private ProjectStatus status;

}
