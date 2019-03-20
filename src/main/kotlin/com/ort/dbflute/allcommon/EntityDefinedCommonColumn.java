package com.ort.dbflute.allcommon;

import org.dbflute.Entity;

/**
 * The interface of entity defined common columns.
 * @author DBFlute(AutoGenerator)
 */
public interface EntityDefinedCommonColumn extends Entity {

    /**
     * Get the value of registerDatetime.
     * @return The instance of the property type. (NullAllowed)
     */
    java.time.LocalDateTime getRegisterDatetime();

    /**
     * Set the value of registerDatetime.
     * @param registerDatetime The instance of the property type. (NullAllowed)
     */
    void setRegisterDatetime(java.time.LocalDateTime registerDatetime);

    /**
     * Get the value of registerTrace.
     * @return The instance of the property type. (NullAllowed)
     */
    String getRegisterTrace();

    /**
     * Set the value of registerTrace.
     * @param registerTrace The instance of the property type. (NullAllowed)
     */
    void setRegisterTrace(String registerTrace);

    /**
     * Get the value of updateDatetime.
     * @return The instance of the property type. (NullAllowed)
     */
    java.time.LocalDateTime getUpdateDatetime();

    /**
     * Set the value of updateDatetime.
     * @param updateDatetime The instance of the property type. (NullAllowed)
     */
    void setUpdateDatetime(java.time.LocalDateTime updateDatetime);

    /**
     * Get the value of updateTrace.
     * @return The instance of the property type. (NullAllowed)
     */
    String getUpdateTrace();

    /**
     * Set the value of updateTrace.
     * @param updateTrace The instance of the property type. (NullAllowed)
     */
    void setUpdateTrace(String updateTrace);
}
