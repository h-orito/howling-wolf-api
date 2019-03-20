package com.ort.dbflute.bsentity;

import java.util.List;
import java.util.ArrayList;

import org.dbflute.Entity;
import org.dbflute.dbmeta.DBMeta;
import org.dbflute.dbmeta.AbstractEntity;
import org.dbflute.dbmeta.accessory.DomainEntity;
import org.dbflute.optional.OptionalEntity;
import com.ort.dbflute.allcommon.EntityDefinedCommonColumn;
import com.ort.dbflute.allcommon.DBMetaInstanceHandler;
import com.ort.dbflute.exentity.*;

/**
 * The entity of COMMIT as TABLE. <br>
 * コミット
 * <pre>
 * [primary-key]
 *     VILLAGE_ID, DAY, VILLAGE_PLAYER_ID
 *
 * [column]
 *     VILLAGE_ID, DAY, VILLAGE_PLAYER_ID, REGISTER_DATETIME, REGISTER_TRACE, UPDATE_DATETIME, UPDATE_TRACE
 *
 * [sequence]
 *     
 *
 * [identity]
 *     
 *
 * [version-no]
 *     
 *
 * [foreign table]
 *     VILLAGE_DAY, VILLAGE_PLAYER
 *
 * [referrer table]
 *     
 *
 * [foreign property]
 *     villageDay, villagePlayer
 *
 * [referrer property]
 *     
 *
 * [get/set template]
 * /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
 * Integer villageId = entity.getVillageId();
 * Integer day = entity.getDay();
 * Integer villagePlayerId = entity.getVillagePlayerId();
 * java.time.LocalDateTime registerDatetime = entity.getRegisterDatetime();
 * String registerTrace = entity.getRegisterTrace();
 * java.time.LocalDateTime updateDatetime = entity.getUpdateDatetime();
 * String updateTrace = entity.getUpdateTrace();
 * entity.setVillageId(villageId);
 * entity.setDay(day);
 * entity.setVillagePlayerId(villagePlayerId);
 * entity.setRegisterDatetime(registerDatetime);
 * entity.setRegisterTrace(registerTrace);
 * entity.setUpdateDatetime(updateDatetime);
 * entity.setUpdateTrace(updateTrace);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsCommit extends AbstractEntity implements DomainEntity, EntityDefinedCommonColumn {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** The serial version UID for object serialization. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** VILLAGE_ID: {PK, NotNull, INT UNSIGNED(10), FK to village_day} */
    protected Integer _villageId;

    /** DAY: {PK, NotNull, INT UNSIGNED(10), FK to village_day} */
    protected Integer _day;

    /** VILLAGE_PLAYER_ID: {PK, IX, NotNull, INT UNSIGNED(10), FK to village_player} */
    protected Integer _villagePlayerId;

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
        return "commit";
    }

    // ===================================================================================
    //                                                                        Key Handling
    //                                                                        ============
    /** {@inheritDoc} */
    public boolean hasPrimaryKeyValue() {
        if (_villageId == null) { return false; }
        if (_day == null) { return false; }
        if (_villagePlayerId == null) { return false; }
        return true;
    }

    // ===================================================================================
    //                                                                    Foreign Property
    //                                                                    ================
    /** VILLAGE_DAY by my VILLAGE_ID, DAY, named 'villageDay'. */
    protected OptionalEntity<VillageDay> _villageDay;

    /**
     * [get] VILLAGE_DAY by my VILLAGE_ID, DAY, named 'villageDay'. <br>
     * Optional: alwaysPresent(), ifPresent().orElse(), get(), ...
     * @return The entity of foreign property 'villageDay'. (NotNull, EmptyAllowed: when e.g. null FK column, no setupSelect)
     */
    public OptionalEntity<VillageDay> getVillageDay() {
        if (_villageDay == null) { _villageDay = OptionalEntity.relationEmpty(this, "villageDay"); }
        return _villageDay;
    }

    /**
     * [set] VILLAGE_DAY by my VILLAGE_ID, DAY, named 'villageDay'.
     * @param villageDay The entity of foreign property 'villageDay'. (NullAllowed)
     */
    public void setVillageDay(OptionalEntity<VillageDay> villageDay) {
        _villageDay = villageDay;
    }

    /** VILLAGE_PLAYER by my VILLAGE_PLAYER_ID, named 'villagePlayer'. */
    protected OptionalEntity<VillagePlayer> _villagePlayer;

    /**
     * [get] VILLAGE_PLAYER by my VILLAGE_PLAYER_ID, named 'villagePlayer'. <br>
     * Optional: alwaysPresent(), ifPresent().orElse(), get(), ...
     * @return The entity of foreign property 'villagePlayer'. (NotNull, EmptyAllowed: when e.g. null FK column, no setupSelect)
     */
    public OptionalEntity<VillagePlayer> getVillagePlayer() {
        if (_villagePlayer == null) { _villagePlayer = OptionalEntity.relationEmpty(this, "villagePlayer"); }
        return _villagePlayer;
    }

    /**
     * [set] VILLAGE_PLAYER by my VILLAGE_PLAYER_ID, named 'villagePlayer'.
     * @param villagePlayer The entity of foreign property 'villagePlayer'. (NullAllowed)
     */
    public void setVillagePlayer(OptionalEntity<VillagePlayer> villagePlayer) {
        _villagePlayer = villagePlayer;
    }

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
        if (obj instanceof BsCommit) {
            BsCommit other = (BsCommit)obj;
            if (!xSV(_villageId, other._villageId)) { return false; }
            if (!xSV(_day, other._day)) { return false; }
            if (!xSV(_villagePlayerId, other._villagePlayerId)) { return false; }
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected int doHashCode(int initial) {
        int hs = initial;
        hs = xCH(hs, asTableDbName());
        hs = xCH(hs, _villageId);
        hs = xCH(hs, _day);
        hs = xCH(hs, _villagePlayerId);
        return hs;
    }

    @Override
    protected String doBuildStringWithRelation(String li) {
        StringBuilder sb = new StringBuilder();
        if (_villageDay != null && _villageDay.isPresent())
        { sb.append(li).append(xbRDS(_villageDay, "villageDay")); }
        if (_villagePlayer != null && _villagePlayer.isPresent())
        { sb.append(li).append(xbRDS(_villagePlayer, "villagePlayer")); }
        return sb.toString();
    }
    protected <ET extends Entity> String xbRDS(org.dbflute.optional.OptionalEntity<ET> et, String name) { // buildRelationDisplayString()
        return et.get().buildDisplayString(name, true, true);
    }

    @Override
    protected String doBuildColumnString(String dm) {
        StringBuilder sb = new StringBuilder();
        sb.append(dm).append(xfND(_villageId));
        sb.append(dm).append(xfND(_day));
        sb.append(dm).append(xfND(_villagePlayerId));
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
        StringBuilder sb = new StringBuilder();
        if (_villageDay != null && _villageDay.isPresent())
        { sb.append(dm).append("villageDay"); }
        if (_villagePlayer != null && _villagePlayer.isPresent())
        { sb.append(dm).append("villagePlayer"); }
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length()).insert(0, "(").append(")");
        }
        return sb.toString();
    }

    @Override
    public Commit clone() {
        return (Commit)super.clone();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] VILLAGE_ID: {PK, NotNull, INT UNSIGNED(10), FK to village_day} <br>
     * 村ID
     * @return The value of the column 'VILLAGE_ID'. (basically NotNull if selected: for the constraint)
     */
    public Integer getVillageId() {
        checkSpecifiedProperty("villageId");
        return _villageId;
    }

    /**
     * [set] VILLAGE_ID: {PK, NotNull, INT UNSIGNED(10), FK to village_day} <br>
     * 村ID
     * @param villageId The value of the column 'VILLAGE_ID'. (basically NotNull if update: for the constraint)
     */
    public void setVillageId(Integer villageId) {
        registerModifiedProperty("villageId");
        _villageId = villageId;
    }

    /**
     * [get] DAY: {PK, NotNull, INT UNSIGNED(10), FK to village_day} <br>
     * 何日目か
     * @return The value of the column 'DAY'. (basically NotNull if selected: for the constraint)
     */
    public Integer getDay() {
        checkSpecifiedProperty("day");
        return _day;
    }

    /**
     * [set] DAY: {PK, NotNull, INT UNSIGNED(10), FK to village_day} <br>
     * 何日目か
     * @param day The value of the column 'DAY'. (basically NotNull if update: for the constraint)
     */
    public void setDay(Integer day) {
        registerModifiedProperty("day");
        _day = day;
    }

    /**
     * [get] VILLAGE_PLAYER_ID: {PK, IX, NotNull, INT UNSIGNED(10), FK to village_player} <br>
     * 村参加者ID
     * @return The value of the column 'VILLAGE_PLAYER_ID'. (basically NotNull if selected: for the constraint)
     */
    public Integer getVillagePlayerId() {
        checkSpecifiedProperty("villagePlayerId");
        return _villagePlayerId;
    }

    /**
     * [set] VILLAGE_PLAYER_ID: {PK, IX, NotNull, INT UNSIGNED(10), FK to village_player} <br>
     * 村参加者ID
     * @param villagePlayerId The value of the column 'VILLAGE_PLAYER_ID'. (basically NotNull if update: for the constraint)
     */
    public void setVillagePlayerId(Integer villagePlayerId) {
        registerModifiedProperty("villagePlayerId");
        _villagePlayerId = villagePlayerId;
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
