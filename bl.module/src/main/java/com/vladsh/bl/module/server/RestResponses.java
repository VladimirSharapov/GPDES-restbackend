package com.vladsh.bl.module.server;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.function.Supplier;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

public final class RestResponses {

    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    private final MediaType mediaType;

    private RestResponses(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    public static RestResponses json() {
        return new RestResponses(new MediaType("application", "json", DEFAULT_CHARSET));
    }

    public static RestResponses text() {
        return new RestResponses(MediaType.TEXT_PLAIN);
    }

    public static RestResponses html() {
        return new RestResponses(MediaType.TEXT_HTML);
    }

    public <T> ResponseEntity<T> ok(T result) {
        return response(result, HttpStatus.OK);
    }

    public <T> ResponseEntity<T> okWithHeaders(T result, MultiValueMap<String, String> headers) {
        ResponseEntity<T> responseEntity = new ResponseEntity<T>(result, headers, HttpStatus.OK);
        return responseEntity;
    }

    public <T> ResponseEntity<T> accepted(T result) {
        return response(result, HttpStatus.ACCEPTED);
    }

    public <T> ResponseEntity<T> created(T result) {
        return response(result, HttpStatus.CREATED);
    }

    public ResponseEntity<Void> created(URI resultUri) {
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(resultUri);
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    public <T> ResponseEntity<T> permanantlyMovedOr(String resultUriStr, Supplier<ResponseEntity<T>> f) {

        try {
            return permanantlyMoved(new URI(resultUriStr));
        } catch (URISyntaxException e) {
            return f.get();
        }
    }

    public <T> ResponseEntity<T> permanantlyMoved(URI resultUri) {
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(resultUri);
        return new ResponseEntity<T>(headers, HttpStatus.MOVED_PERMANENTLY);
    }

    public <T> ResponseEntity<T> createdWithHeaders(T result, MultiValueMap<String, String> headers) {
        ResponseEntity<T> responseEntity = new ResponseEntity<T>(result, headers, HttpStatus.CREATED);
        return responseEntity;
    }

    public ResponseEntity<Void> updated() {
        return response(null, HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<Void> deleted() {
        return response(null, HttpStatus.NO_CONTENT);
    }

    public <T> ResponseEntity<T> response(T result, HttpStatus status) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(mediaType);
        return new ResponseEntity<T>(result, headers, status);
    }
}
