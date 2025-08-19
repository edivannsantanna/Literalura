package com.alura.literalura.modules;

public enum TipoIdioma {
    PORTUGUES("Português", "pt"),
    INGLES("Inglês", "en"),
    FRANCES("Francês", "fr"),
    ESPANHOL("Espanhol", "es");

    private String idiomaPortugues;
    private String idiomaOriginal;

    TipoIdioma(String idiomaPortugues, String idiomaOriginal) {
        this.idiomaPortugues = idiomaPortugues;
        this.idiomaOriginal = idiomaOriginal;
    }

    public static TipoIdioma fromString(String text) {
        for (TipoIdioma idioma : TipoIdioma.values()) {
            if (idioma.idiomaOriginal.equalsIgnoreCase(text)) {
                return idioma;
            }
        }
        throw new IllegalArgumentException("Nenhum idioma encontrado para a string: " + text);
    }
    public static TipoIdioma fromStringPortugues(String text) {
        for (TipoIdioma idioma : TipoIdioma.values()) {
            if (idioma.idiomaPortugues.equalsIgnoreCase(text)) {
                return idioma;
            }
        }
        throw new IllegalArgumentException("Nenhum idioma encontrado para a string: " + text);
    }

}
