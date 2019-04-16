package com.zyt.myblog.backend.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UploadDTO implements Serializable {
    private static final long serialVersionUID = -740245739746775304L;
    private int success;
    private String message;
    private String url;
}
