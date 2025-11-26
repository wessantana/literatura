package com.literatura.literal.exceptions;

import java.util.UUID;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(UUID id) {
        super("Book " + id + " not Found");
    }
}
