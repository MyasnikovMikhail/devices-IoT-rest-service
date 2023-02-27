package org.example.controller;

import org.springframework.data.domain.Sort;

public enum GetSortDevices {
    TYPEDEVICE_ASC(Sort.by(Sort.Direction.ASC, "typeDevices")),
    TYPEDEVICE_DESC(Sort.by(Sort.Direction.DESC, "typeDevices")),
    DATAADD_ASC(Sort.by(Sort.Direction.ASC, "dataAdd")),
    DATAADD_DESC(Sort.by(Sort.Direction.DESC, "dataAdd"));
    private final Sort sortValue;

    GetSortDevices(Sort sortValue) {
        this.sortValue = sortValue;
    }

    public Sort getSortValue() {
        return sortValue;
    }
}
