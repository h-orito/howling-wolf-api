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
import com.ort.dbflute.allcommon.CDef;
import com.ort.dbflute.exentity.*;

/**
 * The entity of ABILITY as TABLE. <br>
 * 能力行使
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsAbility extends AbstractEntity implements DomainEntity, EntityDefinedCommonColumn {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** The serial version UID for object serialization. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** ABILITY_TYPE_CODE: {PK, NotNull, VARCHAR(20), FK to ability_type, classification=AbilityType} */
    protected String _abilityTypeCode;

    /** VILLAGE_DAY_ID: {PK, IX, NotNull, INT UNSIGNED(10), FK to village_day} */
    protected Integer _villageDayId;

    /** VILLAGE_PLAYER_ID: {PK, IX, NotNull, INT UNSIGNED(10), FK to village_player} */
    protected Integer _villagePlayerId;

    /** TARGET_VILLAGE_PLAYER_ID: {IX, INT UNSIGNED(10), FK to village_player} */
    protected Integer _targetVillagePlayerId;

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
        return "ability";
    }

    // ===================================================================================
    //                                                                        Key Handling
    //                                                                        ============
    /** {@inheritDoc} */
    public boolean hasPrimaryKeyValue() {
        if (_abilityTypeCode == null) { return false; }
        if (_villageDayId == null) { return false; }
        if (_villagePlayerId == null) { return false; }
        return true;
    }

    // ===================================================================================
    //                                                             Classification Property
    //                                                             =======================
    /**
     * Get the value of abilityTypeCode as the classification of AbilityType. <br>
     * ABILITY_TYPE_CODE: {PK, NotNull, VARCHAR(20), FK to ability_type, classification=AbilityType} <br>
     * 能力種別
     * <p>It's treated as case insensitive and if the code value is null, it returns null.</p>
     * @return The instance of classification definition (as ENUM type). (NullAllowed: when the column value is null)
     */
    public CDef.AbilityType getAbilityTypeCodeAsAbilityType() {
        return CDef.AbilityType.of(getAbilityTypeCode()).orElse(null);
    }

    /**
     * Set the value of abilityTypeCode as the classification of AbilityType. <br>
     * ABILITY_TYPE_CODE: {PK, NotNull, VARCHAR(20), FK to ability_type, classification=AbilityType} <br>
     * 能力種別
     * @param cdef The instance of classification definition (as ENUM type). (NullAllowed: if null, null value is set to the column)
     */
    public void setAbilityTypeCodeAsAbilityType(CDef.AbilityType cdef) {
        setAbilityTypeCode(cdef != null ? cdef.code() : null);
    }

    // ===================================================================================
    //                                                              Classification Setting
    //                                                              ======================
    /**
     * Set the value of abilityTypeCode as 襲撃 (ATTACK). <br>
     * 襲撃
     */
    public void setAbilityTypeCode_襲撃() {
        setAbilityTypeCodeAsAbilityType(CDef.AbilityType.襲撃);
    }

    /**
     * Set the value of abilityTypeCode as 占い (DIVINE). <br>
     * 占い
     */
    public void setAbilityTypeCode_占い() {
        setAbilityTypeCodeAsAbilityType(CDef.AbilityType.占い);
    }

    /**
     * Set the value of abilityTypeCode as 護衛 (GUARD). <br>
     * 護衛
     */
    public void setAbilityTypeCode_護衛() {
        setAbilityTypeCodeAsAbilityType(CDef.AbilityType.護衛);
    }

    // ===================================================================================
    //                                                        Classification Determination
    //                                                        ============================
    /**
     * Is the value of abilityTypeCode 襲撃? <br>
     * 襲撃
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isAbilityTypeCode襲撃() {
        CDef.AbilityType cdef = getAbilityTypeCodeAsAbilityType();
        return cdef != null ? cdef.equals(CDef.AbilityType.襲撃) : false;
    }

    /**
     * Is the value of abilityTypeCode 占い? <br>
     * 占い
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isAbilityTypeCode占い() {
        CDef.AbilityType cdef = getAbilityTypeCodeAsAbilityType();
        return cdef != null ? cdef.equals(CDef.AbilityType.占い) : false;
    }

    /**
     * Is the value of abilityTypeCode 護衛? <br>
     * 護衛
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isAbilityTypeCode護衛() {
        CDef.AbilityType cdef = getAbilityTypeCodeAsAbilityType();
        return cdef != null ? cdef.equals(CDef.AbilityType.護衛) : false;
    }

    // ===================================================================================
    //                                                                    Foreign Property
    //                                                                    ================
    /** ABILITY_TYPE by my ABILITY_TYPE_CODE, named 'abilityType'. */
    protected OptionalEntity<AbilityType> _abilityType;

    /**
     * [get] ABILITY_TYPE by my ABILITY_TYPE_CODE, named 'abilityType'. <br>
     * Optional: alwaysPresent(), ifPresent().orElse(), get(), ...
     * @return The entity of foreign property 'abilityType'. (NotNull, EmptyAllowed: when e.g. null FK column, no setupSelect)
     */
    public OptionalEntity<AbilityType> getAbilityType() {
        if (_abilityType == null) { _abilityType = OptionalEntity.relationEmpty(this, "abilityType"); }
        return _abilityType;
    }

    /**
     * [set] ABILITY_TYPE by my ABILITY_TYPE_CODE, named 'abilityType'.
     * @param abilityType The entity of foreign property 'abilityType'. (NullAllowed)
     */
    public void setAbilityType(OptionalEntity<AbilityType> abilityType) {
        _abilityType = abilityType;
    }

    /** VILLAGE_PLAYER by my TARGET_VILLAGE_PLAYER_ID, named 'villagePlayerByTargetVillagePlayerId'. */
    protected OptionalEntity<VillagePlayer> _villagePlayerByTargetVillagePlayerId;

    /**
     * [get] VILLAGE_PLAYER by my TARGET_VILLAGE_PLAYER_ID, named 'villagePlayerByTargetVillagePlayerId'. <br>
     * Optional: alwaysPresent(), ifPresent().orElse(), get(), ...
     * @return The entity of foreign property 'villagePlayerByTargetVillagePlayerId'. (NotNull, EmptyAllowed: when e.g. null FK column, no setupSelect)
     */
    public OptionalEntity<VillagePlayer> getVillagePlayerByTargetVillagePlayerId() {
        if (_villagePlayerByTargetVillagePlayerId == null) { _villagePlayerByTargetVillagePlayerId = OptionalEntity.relationEmpty(this, "villagePlayerByTargetVillagePlayerId"); }
        return _villagePlayerByTargetVillagePlayerId;
    }

    /**
     * [set] VILLAGE_PLAYER by my TARGET_VILLAGE_PLAYER_ID, named 'villagePlayerByTargetVillagePlayerId'.
     * @param villagePlayerByTargetVillagePlayerId The entity of foreign property 'villagePlayerByTargetVillagePlayerId'. (NullAllowed)
     */
    public void setVillagePlayerByTargetVillagePlayerId(OptionalEntity<VillagePlayer> villagePlayerByTargetVillagePlayerId) {
        _villagePlayerByTargetVillagePlayerId = villagePlayerByTargetVillagePlayerId;
    }

    /** VILLAGE_DAY by my VILLAGE_DAY_ID, named 'villageDay'. */
    protected OptionalEntity<VillageDay> _villageDay;

    /**
     * [get] VILLAGE_DAY by my VILLAGE_DAY_ID, named 'villageDay'. <br>
     * Optional: alwaysPresent(), ifPresent().orElse(), get(), ...
     * @return The entity of foreign property 'villageDay'. (NotNull, EmptyAllowed: when e.g. null FK column, no setupSelect)
     */
    public OptionalEntity<VillageDay> getVillageDay() {
        if (_villageDay == null) { _villageDay = OptionalEntity.relationEmpty(this, "villageDay"); }
        return _villageDay;
    }

    /**
     * [set] VILLAGE_DAY by my VILLAGE_DAY_ID, named 'villageDay'.
     * @param villageDay The entity of foreign property 'villageDay'. (NullAllowed)
     */
    public void setVillageDay(OptionalEntity<VillageDay> villageDay) {
        _villageDay = villageDay;
    }

    /** VILLAGE_PLAYER by my VILLAGE_PLAYER_ID, named 'villagePlayerByVillagePlayerId'. */
    protected OptionalEntity<VillagePlayer> _villagePlayerByVillagePlayerId;

    /**
     * [get] VILLAGE_PLAYER by my VILLAGE_PLAYER_ID, named 'villagePlayerByVillagePlayerId'. <br>
     * Optional: alwaysPresent(), ifPresent().orElse(), get(), ...
     * @return The entity of foreign property 'villagePlayerByVillagePlayerId'. (NotNull, EmptyAllowed: when e.g. null FK column, no setupSelect)
     */
    public OptionalEntity<VillagePlayer> getVillagePlayerByVillagePlayerId() {
        if (_villagePlayerByVillagePlayerId == null) { _villagePlayerByVillagePlayerId = OptionalEntity.relationEmpty(this, "villagePlayerByVillagePlayerId"); }
        return _villagePlayerByVillagePlayerId;
    }

    /**
     * [set] VILLAGE_PLAYER by my VILLAGE_PLAYER_ID, named 'villagePlayerByVillagePlayerId'.
     * @param villagePlayerByVillagePlayerId The entity of foreign property 'villagePlayerByVillagePlayerId'. (NullAllowed)
     */
    public void setVillagePlayerByVillagePlayerId(OptionalEntity<VillagePlayer> villagePlayerByVillagePlayerId) {
        _villagePlayerByVillagePlayerId = villagePlayerByVillagePlayerId;
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
        if (obj instanceof BsAbility) {
            BsAbility other = (BsAbility)obj;
            if (!xSV(_abilityTypeCode, other._abilityTypeCode)) { return false; }
            if (!xSV(_villageDayId, other._villageDayId)) { return false; }
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
        hs = xCH(hs, _abilityTypeCode);
        hs = xCH(hs, _villageDayId);
        hs = xCH(hs, _villagePlayerId);
        return hs;
    }

    @Override
    protected String doBuildStringWithRelation(String li) {
        StringBuilder sb = new StringBuilder();
        if (_abilityType != null && _abilityType.isPresent())
        { sb.append(li).append(xbRDS(_abilityType, "abilityType")); }
        if (_villagePlayerByTargetVillagePlayerId != null && _villagePlayerByTargetVillagePlayerId.isPresent())
        { sb.append(li).append(xbRDS(_villagePlayerByTargetVillagePlayerId, "villagePlayerByTargetVillagePlayerId")); }
        if (_villageDay != null && _villageDay.isPresent())
        { sb.append(li).append(xbRDS(_villageDay, "villageDay")); }
        if (_villagePlayerByVillagePlayerId != null && _villagePlayerByVillagePlayerId.isPresent())
        { sb.append(li).append(xbRDS(_villagePlayerByVillagePlayerId, "villagePlayerByVillagePlayerId")); }
        return sb.toString();
    }
    protected <ET extends Entity> String xbRDS(org.dbflute.optional.OptionalEntity<ET> et, String name) { // buildRelationDisplayString()
        return et.get().buildDisplayString(name, true, true);
    }

    @Override
    protected String doBuildColumnString(String dm) {
        StringBuilder sb = new StringBuilder();
        sb.append(dm).append(xfND(_abilityTypeCode));
        sb.append(dm).append(xfND(_villageDayId));
        sb.append(dm).append(xfND(_villagePlayerId));
        sb.append(dm).append(xfND(_targetVillagePlayerId));
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
        if (_abilityType != null && _abilityType.isPresent())
        { sb.append(dm).append("abilityType"); }
        if (_villagePlayerByTargetVillagePlayerId != null && _villagePlayerByTargetVillagePlayerId.isPresent())
        { sb.append(dm).append("villagePlayerByTargetVillagePlayerId"); }
        if (_villageDay != null && _villageDay.isPresent())
        { sb.append(dm).append("villageDay"); }
        if (_villagePlayerByVillagePlayerId != null && _villagePlayerByVillagePlayerId.isPresent())
        { sb.append(dm).append("villagePlayerByVillagePlayerId"); }
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length()).insert(0, "(").append(")");
        }
        return sb.toString();
    }

    @Override
    public Ability clone() {
        return (Ability)super.clone();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] ABILITY_TYPE_CODE: {PK, NotNull, VARCHAR(20), FK to ability_type, classification=AbilityType} <br>
     * 能力種別コード
     * @return The value of the column 'ABILITY_TYPE_CODE'. (basically NotNull if selected: for the constraint)
     */
    public String getAbilityTypeCode() {
        checkSpecifiedProperty("abilityTypeCode");
        return convertEmptyToNull(_abilityTypeCode);
    }

    /**
     * [set] ABILITY_TYPE_CODE: {PK, NotNull, VARCHAR(20), FK to ability_type, classification=AbilityType} <br>
     * 能力種別コード
     * @param abilityTypeCode The value of the column 'ABILITY_TYPE_CODE'. (basically NotNull if update: for the constraint)
     */
    protected void setAbilityTypeCode(String abilityTypeCode) {
        checkClassificationCode("ABILITY_TYPE_CODE", CDef.DefMeta.AbilityType, abilityTypeCode);
        registerModifiedProperty("abilityTypeCode");
        _abilityTypeCode = abilityTypeCode;
    }

    /**
     * [get] VILLAGE_DAY_ID: {PK, IX, NotNull, INT UNSIGNED(10), FK to village_day} <br>
     * 村日付ID
     * @return The value of the column 'VILLAGE_DAY_ID'. (basically NotNull if selected: for the constraint)
     */
    public Integer getVillageDayId() {
        checkSpecifiedProperty("villageDayId");
        return _villageDayId;
    }

    /**
     * [set] VILLAGE_DAY_ID: {PK, IX, NotNull, INT UNSIGNED(10), FK to village_day} <br>
     * 村日付ID
     * @param villageDayId The value of the column 'VILLAGE_DAY_ID'. (basically NotNull if update: for the constraint)
     */
    public void setVillageDayId(Integer villageDayId) {
        registerModifiedProperty("villageDayId");
        _villageDayId = villageDayId;
    }

    /**
     * [get] VILLAGE_PLAYER_ID: {PK, IX, NotNull, INT UNSIGNED(10), FK to village_player} <br>
     * 行使元村参加者ID
     * @return The value of the column 'VILLAGE_PLAYER_ID'. (basically NotNull if selected: for the constraint)
     */
    public Integer getVillagePlayerId() {
        checkSpecifiedProperty("villagePlayerId");
        return _villagePlayerId;
    }

    /**
     * [set] VILLAGE_PLAYER_ID: {PK, IX, NotNull, INT UNSIGNED(10), FK to village_player} <br>
     * 行使元村参加者ID
     * @param villagePlayerId The value of the column 'VILLAGE_PLAYER_ID'. (basically NotNull if update: for the constraint)
     */
    public void setVillagePlayerId(Integer villagePlayerId) {
        registerModifiedProperty("villagePlayerId");
        _villagePlayerId = villagePlayerId;
    }

    /**
     * [get] TARGET_VILLAGE_PLAYER_ID: {IX, INT UNSIGNED(10), FK to village_player} <br>
     * 行使対象村参加者ID
     * @return The value of the column 'TARGET_VILLAGE_PLAYER_ID'. (NullAllowed even if selected: for no constraint)
     */
    public Integer getTargetVillagePlayerId() {
        checkSpecifiedProperty("targetVillagePlayerId");
        return _targetVillagePlayerId;
    }

    /**
     * [set] TARGET_VILLAGE_PLAYER_ID: {IX, INT UNSIGNED(10), FK to village_player} <br>
     * 行使対象村参加者ID
     * @param targetVillagePlayerId The value of the column 'TARGET_VILLAGE_PLAYER_ID'. (NullAllowed: null update allowed for no constraint)
     */
    public void setTargetVillagePlayerId(Integer targetVillagePlayerId) {
        registerModifiedProperty("targetVillagePlayerId");
        _targetVillagePlayerId = targetVillagePlayerId;
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

    /**
     * For framework so basically DON'T use this method.
     * @param abilityTypeCode The value of the column 'ABILITY_TYPE_CODE'. (basically NotNull if update: for the constraint)
     */
    public void mynativeMappingAbilityTypeCode(String abilityTypeCode) {
        setAbilityTypeCode(abilityTypeCode);
    }
}
