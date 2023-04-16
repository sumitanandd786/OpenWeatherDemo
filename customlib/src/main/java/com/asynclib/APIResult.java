package com.asynclib;

import org.json.JSONObject;

import androidx.annotation.NonNull;

class APIResult {
    /** The content returned (in case of success). */
    public final JSONObject content;

    /** The error encountered (in case of failure). */
    public final AlgoliaException error;

    /**
     * Construct a new success result.
     *
     * @param content The content returned.
     */
    public APIResult(@NonNull JSONObject content) {
        this.content = content;
        this.error = null;
    }

    /**
     * Construct a new failure result.
     *
     * @param error The error that was encountered.
     */
    public APIResult(@NonNull AlgoliaException error) {
        this.content = null;
        this.error = error;
    }

    /** Test whether this is a success (true) or failure (false) result. */
    public boolean isSuccess() {
        return error == null;
    }
}
