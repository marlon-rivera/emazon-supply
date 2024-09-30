package com.emazon.supply.utils;

public class Constants {

    private Constants() {}

    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_AUTH = "Authorization";
    public static final String ROLE_ = "ROLE_";
    public static final String ROLE = "ROLE";
    public static final String EMAIL = "email";

    public static final String EXCEPTION_SUPPLY_ID_ARTICLE_BLANK = "El id del articulo no puede estar vacio.";
    public static final String EXCEPTION_SUPPLY_QUANTITY_BLANK = "La cantidad del suministro del articulo no puede estar vacio.";
    public static final String EXCEPTION_SUPPLY_ARTICLE_NOT_FOUND = "El articulo al que quiere aumentar el suministro no fue encontrado.";
    public static final String EXCEPTION_SUPPLY_SERVER_ERROR = "En este momento no se pueden guardar suministros.";
    public static final String EXCEPTION_SUPPLY_QUANTITY_ZERO = "La cantidad de suministro no puede ser 0.";
}
