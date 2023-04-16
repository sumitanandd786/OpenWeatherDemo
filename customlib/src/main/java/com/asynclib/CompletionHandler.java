package com.asynclib;

import org.json.JSONObject;

import androidx.annotation.Nullable;

public interface CompletionHandler {
    void requestCompleted(@Nullable JSONObject content, @Nullable AlgoliaException error);
}
