package com.mali.designPattern.proxy;

import java.nio.file.AccessDeniedException;

public interface InternetConnection {
    String getConnection(String site) throws AccessDeniedException;
}
