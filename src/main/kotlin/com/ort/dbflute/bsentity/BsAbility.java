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
 * <pre>
 * [primary-key]
 *     VILLAGE_ID, DAY, CHARA_ID, ABILITY_TYPE_CODE
 *
 * [column]
 *     VILLAGE_ID, DAY, CHARA_ID, TARGET_CHARA_ID, ABILITY_TYPE_CODE, REGISTER_DATETIME, REGISTER_TRACE, UPDATE_DATETIME, UPDATE_TRACE
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
 *     ABILITY_TYPE, CHARA, VILLAGE_DAY
 *
 * [referrer table]
 *     
 *
 * [foreign property]
 *     abilityType, charaByCharaId, charaByTargetCharaId, villageDay
 *
 * [referrer property]
 *     
 *
 * [get/set template]
 * /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
 * Integer villageId = entity.getVillageId();
 * Integer day = entity.getDay();
 * Integer charaId = entity.getCharaId();
 * Integer targetCharaId = entity.getTargetCharaId();
 * String abilityTypeCode = entity.getAbilityTypeCode();
 * java.time.LocalDateTime registerDatetime = entity.getRegisterDatetime();
 * String registerTrace = entity.getRegisterTrace();
 * java.time.LocalDateTime updateDatetime = entity.getUpdateDatetime();
 * String updateTrace = entity.getUpdateTrace();
 * entity.setVillageId(villageId);
 * entity.setDay(day);
 * entity.setCharaId(charaId);
 * entity.setTargetCharaId(targetCharaId);
 * entity.setAbilityTypeCode(abilityTypeCode);
 * entity.setRegisterDatetime(registerDatetime);
 * entity.setRegisterTrace(registerTrace);
 * entity.setUpdateDatetime(updateDatetime);
 * entity.setUpdateTrace(updateTrace);
 * = = = = = = = = = =/
 * </pre>
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
    /** VILLAGE_ID: {PK, NotNull, INT UNSIGNED(10), FK to village_day} */
    protected Integer _villageId;

    /** DAY: {PK, NotNull, INT UNSIGNED(10), FK to village_day} */
    protected Integer _day;

    /** CHARA_ID: {PK, IX, NotNull, INT UNSIGNED(10), FK to chara} */
    protected Integer _charaId;

    /** TARGET_CHARA_ID: {IX, INT UNSIGNED(10), FK to chara} */
    protected Integer _targetCharaId;

    /** ABILITY_TYPE_CODE: {PK, IX, NotNull, VARCHAR(20), FK to ability_type, classification=AbilityType} */
    protected String _abilityTypeCode;

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
        if (_villageId == null) { return false; }
        if (_day == null) { return false; }
        if (_charaId == null) { return false; }
        if (_abilityTypeCode == null) { return false; }
        return true;
    }

    // ===================================================================================
    //                                                             Classification Property
    //                                                             =======================
    /**
     * Get the value of abilityTypeCode as the classification of AbilityType. <br>
     * ABILITY_TYPE_CODE: {PK, IX, NotNull, VARCHAR(20), FK to ability_type, classification=AbilityType} <br>
     * 能力種別
     * <p>It's treated as case insensitive and if the code value is null, it returns null.</p>
     * @return The instance of classification definition (as ENUM type). (NullAllowed: when the column value is null)
     */
    public CDef.AbilityType getAbilityTypeCodeAsAbilityType() {
        return CDef.AbilityType.codeOf(getAbilityTypeCode());
    }

    /**
     * Set the value of abilityTypeCode as the classification of AbilityType. <br>
     * ABILITY_TYPE_CODE: {PK, IX, NotNull, VARCHAR(20), FK to ability_type, classification=AbilityType} <br>
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

    /**
     * Set the value of abilityTypeCode as 捜査 (INVESTIGATE). <br>
     * 捜査
     */
    public void setAbilityTypeCode_捜査() {
        setAbilityTypeCodeAsAbilityType(CDef.AbilityType.捜査);
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

    /**
     * Is the value of abilityTypeCode 捜査? <br>
     * 捜査
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isAbilityTypeCode捜査() {
        CDef.AbilityType cdef = getAbilityTypeCodeAsAbilityType();
        return cdef != null ? cdef.equals(CDef.AbilityType.捜査) : false;
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

    /** CHARA by my CHARA_ID, named 'charaByCharaId'. */
    protected OptionalEntity<Chara> _charaByCharaId;

    /**
     * [get] CHARA by my CHARA_ID, named 'charaByCharaId'. <br>
     * Optional: alwaysPresent(), ifPresent().orElse(), get(), ...
     * @return The entity of foreign property 'charaByCharaId'. (NotNull, EmptyAllowed: when e.g. null FK column, no setupSelect)
     */
    public OptionalEntity<Chara> getCharaByCharaId() {
        if (_charaByCharaId == null) { _charaByCharaId = OptionalEntity.relationEmpty(this, "charaByCharaId"); }
        return _charaByCharaId;
    }

    /**
     * [set] CHARA by my CHARA_ID, named 'charaByCharaId'.
     * @param charaByCharaId The entity of foreign property 'charaByCharaId'. (NullAllowed)
     */
    public void setCharaByCharaId(OptionalEntity<Chara> charaByCharaId) {
        _charaByCharaId = charaByCharaId;
    }

    /** CHARA by my TARGET_CHARA_ID, named 'charaByTargetCharaId'. */
    protected OptionalEntity<Chara> _charaByTargetCharaId;

    /**
     * [get] CHARA by my TARGET_CHARA_ID, named 'charaByTargetCharaId'. <br>
     * Optional: alwaysPresent(), ifPresent().orElse(), get(), ...
     * @return The entity of foreign property 'charaByTargetCharaId'. (NotNull, EmptyAllowed: when e.g. null FK column, no setupSelect)
     */
    public OptionalEntity<Chara> getCharaByTargetCharaId() {
        if (_charaByTargetCharaId == null) { _charaByTargetCharaId = OptionalEntity.relationEmpty(this, "charaByTargetCharaId"); }
        return _charaByTargetCharaId;
    }

    /**
     * [set] CHARA by my TARGET_CHARA_ID, named 'charaByTargetCharaId'.
     * @param charaByTargetCharaId The entity of foreign property 'charaByTargetCharaId'. (NullAllowed)
     */
    public void setCharaByTargetCharaId(OptionalEntity<Chara> charaByTargetCharaId) {
        _charaByTargetCharaId = charaByTargetCharaId;
    }

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
            if (!xSV(_villageId, other._villageId)) { return false; }
            if (!xSV(_day, other._day)) { return false; }
            if (!xSV(_charaId, other._charaId)) { return false; }
            if (!xSV(_abilityTypeCode, other._abilityTypeCode)) { return false; }
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
        hs = xCH(hs, _charaId);
        hs = xCH(hs, _abilityTypeCode);
        return hs;
    }

    @Override
    protected String doBuildStringWithRelation(String li) {
        StringBuilder sb = new StringBuilder();
        if (_abilityType != null && _abilityType.isPresent())
        { sb.append(li).append(xbRDS(_abilityType, "abilityType")); }
        if (_charaByCharaId != null && _charaByCharaId.isPresent())
        { sb.append(li).append(xbRDS(_charaByCharaId, "charaByCharaId")); }
        if (_charaByTargetCharaId != null && _charaByTargetCharaId.isPresent())
        { sb.append(li).append(xbRDS(_charaByTargetCharaId, "charaByTargetCharaId")); }
        if (_villageDay != null && _villageDay.isPresent())
        { sb.append(li).append(xbRDS(_villageDay, "villageDay")); }
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
        sb.append(dm).append(xfND(_charaId));
        sb.append(dm).append(xfND(_targetCharaId));
        sb.append(dm).append(xfND(_abilityTypeCode));
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
        if (_charaByCharaId != null && _charaByCharaId.isPresent())
        { sb.append(dm).append("charaByCharaId"); }
        if (_charaByTargetCharaId != null && _charaByTargetCharaId.isPresent())
        { sb.append(dm).append("charaByTargetCharaId"); }
        if (_villageDay != null && _villageDay.isPresent())
        { sb.append(dm).append("villageDay"); }
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
     * [get] CHARA_ID: {PK, IX, NotNull, INT UNSIGNED(10), FK to chara} <br>
     * キャラクターID
     * @return The value of the column 'CHARA_ID'. (basically NotNull if selected: for the constraint)
     */
    public Integer getCharaId() {
        checkSpecifiedProperty("charaId");
        return _charaId;
    }

    /**
     * [set] CHARA_ID: {PK, IX, NotNull, INT UNSIGNED(10), FK to chara} <br>
     * キャラクターID
     * @param charaId The value of the column 'CHARA_ID'. (basically NotNull if update: for the constraint)
     */
    public void setCharaId(Integer charaId) {
        registerModifiedProperty("charaId");
        _charaId = charaId;
    }

    /**
     * [get] TARGET_CHARA_ID: {IX, INT UNSIGNED(10), FK to chara} <br>
     * 行使対象キャラID
     * @return The value of the column 'TARGET_CHARA_ID'. (NullAllowed even if selected: for no constraint)
     */
    public Integer getTargetCharaId() {
        checkSpecifiedProperty("targetCharaId");
        return _targetCharaId;
    }

    /**
     * [set] TARGET_CHARA_ID: {IX, INT UNSIGNED(10), FK to chara} <br>
     * 行使対象キャラID
     * @param targetCharaId The value of the column 'TARGET_CHARA_ID'. (NullAllowed: null update allowed for no constraint)
     */
    public void setTargetCharaId(Integer targetCharaId) {
        registerModifiedProperty("targetCharaId");
        _targetCharaId = targetCharaId;
    }

    /**
     * [get] ABILITY_TYPE_CODE: {PK, IX, NotNull, VARCHAR(20), FK to ability_type, classification=AbilityType} <br>
     * 能力種別コード
     * @return The value of the column 'ABILITY_TYPE_CODE'. (basically NotNull if selected: for the constraint)
     */
    public String getAbilityTypeCode() {
        checkSpecifiedProperty("abilityTypeCode");
        return convertEmptyToNull(_abilityTypeCode);
    }

    /**
     * [set] ABILITY_TYPE_CODE: {PK, IX, NotNull, VARCHAR(20), FK to ability_type, classification=AbilityType} <br>
     * 能力種別コード
     * @param abilityTypeCode The value of the column 'ABILITY_TYPE_CODE'. (basically NotNull if update: for the constraint)
     */
    protected void setAbilityTypeCode(String abilityTypeCode) {
        checkClassificationCode("ABILITY_TYPE_CODE", CDef.DefMeta.AbilityType, abilityTypeCode);
        registerModifiedProperty("abilityTypeCode");
        _abilityTypeCode = abilityTypeCode;
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
