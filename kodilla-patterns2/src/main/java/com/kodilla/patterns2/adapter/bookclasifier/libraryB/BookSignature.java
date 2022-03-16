package com.kodilla.patterns2.adapter.bookclasifier.libraryB;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BookSignature {

    final private String signature;

    public BookSignature(String signature) {
        this.signature = signature;
    }
}
