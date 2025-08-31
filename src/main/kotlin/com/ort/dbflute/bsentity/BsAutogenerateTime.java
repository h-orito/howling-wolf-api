package com.ort.dbflute.bsentity;

import java.util.List;
import java.util.ArrayList;

import org.dbflute.dbmeta.DBMeta;
import org.dbflute.dbmeta.AbstractEntity;
import org.dbflute.dbmeta.accessory.DomainEntity;
import com.ort.dbflute.allcommon.EntityDefinedCommonColumn;
import com.ort.dbflute.allcommon.DBMetaInstanceHandler;
import com.ort.dbflute.exentity.*;

/**
 * The entity of AUTOGENERATE_TIME as TABLE. <br>
 * 自動生成編成
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsAutogenerateTime extends AbstractEntity implements DomainEntity, EntityDefinedCommonColumn {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** The serial version UID for object serialization. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** VILLAGE_ID_MOD: {PK, NotNull, INT(10)} */
    protected Integer _villageIdMod;

    /** START_TIME: {NotNull, CHAR(4)} */
    protected String _startTime;

    /** SILENT_HOURS: {NotNull, INT UNSIGNED(10)} */
    protected Integer _silentHours;

    /** REGISTER_DATETIME: {NotNull, DATETIME(19)} */
    protected java.time.LocalDateTime _registerDatetime;

    /** REGISTER_TRACE: {NotNull, VARCHAR(64)} */
    protected String _registerTrace;

    /** UPDATE_DATETIME: {NotNull, DATETIME(19)} */
    protected java.time.LocalDateTime _updateDatetime;

    /** UPDATE_TRACE: {NotNull, VARCHAR(64)} */
    protected String _updateTrace;

    // ===================================================================================
    //                                                                             DB Meta
    //                                                                             =======
    /** {@inheritDoc} */
    public DBMeta asDBMeta() {
        return DBMetaInstanceHandler.findDBMeta(asTableDbName());
    }

    /** {@inheritDoc} */
    public String asTableDbName() {
        return "autogenerate_time";
    }

    // ===================================================================================
    //                                                                        Key Handling
    //                                                                        ============
    /** {@inheritDoc} */
    public boolean hasPrimaryKeyValue() {
        if (_villageIdMod == null) { return false; }
        return true;
    }

    // ===================================================================================
    //                                                                    Foreign Property
    //                                                                    ================
    // ===================================================================================
    //                                                                   Referrer Property
    //                                                                   =================
    protected <ELEMENT> List<ELEMENT> newReferrerList() { // overriding to import
        return new ArrayList<ELEMENT>();
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    @Override
    protected boolean doEquals(Object obj) {
        if (obj instanceof BsAutogenerateTime) {
            BsAutogenerateTime other = (BsAutogenerateTime)obj;
            if (!xSV(_villageIdMod, other._villageIdMod)) { return false; }
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected int doHashCode(int initial) {
        int hs = initial;
        hs = xCH(hs, asTableDbName());
        hs = xCH(hs, _villageIdMod);
        return hs;
    }

    @Override
    protected String doBuildStringWithRelation(String li) {
        return "";
    }

    @Override
    protected String doBuildColumnString(String dm) {
        StringBuilder sb = new StringBuilder();
        sb.append(dm).append(xfND(_villageIdMod));
        sb.append(dm).append(xfND(_startTime));
        sb.append(dm).append(xfND(_silentHours));
        sb.append(dm).append(xfND(_registerDatetime));
        sb.append(dm).append(xfND(_registerTrace));
        sb.append(dm).append(xfND(_updateDatetime));
        sb.append(dm).append(xfND(_updateTrace));
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length());
        }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }

    @Override
    protected String doBuildRelationString(String dm) {
        return "";
    }

    @Override
    public AutogenerateTime clone() {
        return (AutogenerateTime)super.clone();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] VILLAGE_ID_MOD: {PK, NotNull, INT(10)} <br>
     * 余り
     * @return The value of the column 'VILLAGE_ID_MOD'. (basically NotNull if selected: for the constraint)
     */
    public Integer getVillageIdMod() {
        checkSpecifiedProperty("villageIdMod");
        return _villageIdMod;
    }

    /**
     * [set] VILLAGE_ID_MOD: {PK, NotNull, INT(10)} <br>
     * 余り
     * @param villageIdMod The value of the column 'VILLAGE_ID_MOD'. (basically NotNull if update: for the constraint)
     */
    public void setVillageIdMod(Integer villageIdMod) {
        registerModifiedProperty("villageIdMod");
        _villageIdMod = villageIdMod;
    }

    /**
     * [get] START_TIME: {NotNull, CHAR(4)} <br>
     * 開始時間
     * @return The value of the column 'START_TIME'. (basically NotNull if selected: for the constraint)
     */
    public String getStartTime() {
        checkSpecifiedProperty("startTime");
        return convertEmptyToNull(_startTime);
    }

    /**
     * [set] START_TIME: {NotNull, CHAR(4)} <br>
     * 開始時間
     * @param startTime The value of the column 'START_TIME'. (basically NotNull if update: for the constraint)
     */
    public void setStartTime(String startTime) {
        registerModifiedProperty("startTime");
        _startTime = startTime;
    }

    /**
     * [get] SILENT_HOURS: {NotNull, INT UNSIGNED(10)} <br>
     * 沈黙時間
     * @return The value of the column 'SILENT_HOURS'. (basically NotNull if selected: for the constraint)
     */
    public Integer getSilentHours() {
        checkSpecifiedProperty("silentHours");
        return _silentHours;
    }

    /**
     * [set] SILENT_HOURS: {NotNull, INT UNSIGNED(10)} <br>
     * 沈黙時間
     * @param silentHours The value of the column 'SILENT_HOURS'. (basically NotNull if update: for the constraint)
     */
    public void setSilentHours(Integer silentHours) {
        registerModifiedProperty("silentHours");
        _silentHours = silentHours;
    }

    /**
     * [get] REGISTER_DATETIME: {NotNull, DATETIME(19)} <br>
     * 登録日時
     * @return The value of the column 'REGISTER_DATETIME'. (basically NotNull if selected: for the constraint)
     */
    public java.time.LocalDateTime getRegisterDatetime() {
        checkSpecifiedProperty("registerDatetime");
        return _registerDatetime;
    }

    /**
     * [set] REGISTER_DATETIME: {NotNull, DATETIME(19)} <br>
     * 登録日時
     * @param registerDatetime The value of the column 'REGISTER_DATETIME'. (basically NotNull if update: for the constraint)
     */
    public void setRegisterDatetime(java.time.LocalDateTime registerDatetime) {
        registerModifiedProperty("registerDatetime");
        _registerDatetime = registerDatetime;
    }

    /**
     * [get] REGISTER_TRACE: {NotNull, VARCHAR(64)} <br>
     * 登録トレース
     * @return The value of the column 'REGISTER_TRACE'. (basically NotNull if selected: for the constraint)
     */
    public String getRegisterTrace() {
        checkSpecifiedProperty("registerTrace");
        return convertEmptyToNull(_registerTrace);
    }

    /**
     * [set] REGISTER_TRACE: {NotNull, VARCHAR(64)} <br>
     * 登録トレース
     * @param registerTrace The value of the column 'REGISTER_TRACE'. (basically NotNull if update: for the constraint)
     */
    public void setRegisterTrace(String registerTrace) {
        registerModifiedProperty("registerTrace");
        _registerTrace = registerTrace;
    }

    /**
     * [get] UPDATE_DATETIME: {NotNull, DATETIME(19)} <br>
     * 更新日時
     * @return The value of the column 'UPDATE_DATETIME'. (basically NotNull if selected: for the constraint)
     */
    public java.time.LocalDateTime getUpdateDatetime() {
        checkSpecifiedProperty("updateDatetime");
        return _updateDatetime;
    }

    /**
     * [set] UPDATE_DATETIME: {NotNull, DATETIME(19)} <br>
     * 更新日時
     * @param updateDatetime The value of the column 'UPDATE_DATETIME'. (basically NotNull if update: for the constraint)
     */
    public void setUpdateDatetime(java.time.LocalDateTime updateDatetime) {
        registerModifiedProperty("updateDatetime");
        _updateDatetime = updateDatetime;
    }

    /**
     * [get] UPDATE_TRACE: {NotNull, VARCHAR(64)} <br>
     * 更新トレース
     * @return The value of the column 'UPDATE_TRACE'. (basically NotNull if selected: for the constraint)
     */
    public String getUpdateTrace() {
        checkSpecifiedProperty("updateTrace");
        return convertEmptyToNull(_updateTrace);
    }

    /**
     * [set] UPDATE_TRACE: {NotNull, VARCHAR(64)} <br>
     * 更新トレース
     * @param updateTrace The value of the column 'UPDATE_TRACE'. (basically NotNull if update: for the constraint)
     */
    public void setUpdateTrace(String updateTrace) {
        registerModifiedProperty("updateTrace");
        _updateTrace = updateTrace;
    }
}
