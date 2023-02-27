package org.example.controller;

import org.springframework.data.domain.Sort;

public enum GetSortEvents {
    DATE_ASC(Sort.by(Sort.Direction.ASC, "dateCreated")),
    DATE_DESC(Sort.by(Sort.Direction.DESC, "dateCreated"));

    private final Sort sortValue;

    GetSortEvents(Sort sortValue) {
        this.sortValue = sortValue;
    }

    public Sort getSortValue() {
        return sortValue;
    }
}
