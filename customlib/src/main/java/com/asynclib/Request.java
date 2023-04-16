package com.asynclib;

public interface Request {
    void cancel();
    boolean isFinished();
    boolean isCancelled();
}
