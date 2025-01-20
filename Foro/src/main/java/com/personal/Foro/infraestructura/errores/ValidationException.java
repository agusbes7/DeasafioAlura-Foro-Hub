package com.personal.Foro.infraestructura.errores;

public class ValidationException extends  RuntimeException{

        public ValidationException(String mensaje) {
            super(mensaje);
        }

}
