package com.leandro.desafio.controller;

import com.leandro.desafio.dto.ErrorDTO;
import com.leandro.desafio.exception.TaskNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.net.ConnectException;
import java.util.Date;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolationException(Exception exception) {
        return getObjectResponseEntity(exception.getMessage());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return getObjectResponseEntity(ex.getMessage());
    }

    private ResponseEntity<Object> getObjectResponseEntity(String message) {
        ErrorDTO error = new ErrorDTO();
        error.setDescricao(message);
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setTimeStamp(new Date().getTime());
        error.setTitulo("Dados enviados de forma incorreta pelo cliente.");

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConnectException.class)
    public ResponseEntity<ErrorDTO> handleConnectException(Exception exception) {

        ErrorDTO error = new ErrorDTO();
        error.setDescricao(exception.getMessage());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setTimeStamp(new Date().getTime());
        error.setTitulo("Sem conexão com o banco de dados.");

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleTaskNotFoundException(Exception exception) {

        ErrorDTO error = new ErrorDTO();
        error.setDescricao(exception.getMessage());
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setTimeStamp(new Date().getTime());
        error.setTitulo("Tarefa não encontrada. O id informado não existe no banco de dados.");

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
