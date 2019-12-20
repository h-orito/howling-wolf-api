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
 * The entity of VILLAGE_DAY as TABLE. <br>
 * 村日付
 * <pre>
 * [primary-key]
 *     VILLAGE_DAY_ID
 *
 * [column]
 *     VILLAGE_DAY_ID, VILLAGE_ID, DAY, NOONNIGHT_CODE, DAYCHANGE_DATETIME, IS_UPDATING, REGISTER_DATETIME, REGISTER_TRACE, UPDATE_DATETIME, UPDATE_TRACE
 *
 * [sequence]
 *     
 *
 * [identity]
 *     VILLAGE_DAY_ID
 *
 * [version-no]
 *     
 *
 * [foreign table]
 *     NOONNIGHT, VILLAGE, VOTE(AsOne)
 *
 * [referrer table]
 *     ABILITY, COMMIT, VILLAGE_PLAYER, VOTE
 *
 * [foreign property]
 *     noonnight, village, voteAsOne
 *
 * [referrer property]
 *     abilityList, commitList, villagePlayerList
 *
 * [get/set template]
 * /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
 * Integer villageDayId = entity.getVillageDayId();
 * Integer villageId = entity.getVillageId();
 * Integer day = entity.getDay();
 * String noonnightCode = entity.getNoonnightCode();
 * java.time.LocalDateTime daychangeDatetime = entity.getDaychangeDatetime();
 * Boolean isUpdating = entity.getIsUpdating();
 * java.time.LocalDateTime registerDatetime = entity.getRegisterDatetime();
 * String registerTrace = entity.getRegisterTrace();
 * java.time.LocalDateTime updateDatetime = entity.getUpdateDatetime();
 * String updateTrace = entity.getUpdateTrace();
 * entity.setVillageDayId(villageDayId);
 * entity.setVillageId(villageId);
 * entity.setDay(day);
 * entity.setNoonnightCode(noonnightCode);
 * entity.setDaychangeDatetime(daychangeDatetime);
 * entity.setIsUpdating(isUpdating);
 * entity.setRegisterDatetime(registerDatetime);
 * entity.setRegisterTrace(registerTrace);
 * entity.setUpdateDatetime(updateDatetime);
 * entity.setUpdateTrace(updateTrace);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsVillageDay extends AbstractEntity implements DomainEntity, EntityDefinedCommonColumn {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** The serial version UID for object serialization. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** VILLAGE_DAY_ID: {PK, ID, NotNull, INT UNSIGNED(10)} */
    protected Integer _villageDayId;

    /** VILLAGE_ID: {IX, NotNull, INT UNSIGNED(10), FK to village} */
    protected Integer _villageId;

    /** DAY: {NotNull, INT UNSIGNED(10)} */
    protected Integer _day;

    /** NOONNIGHT_CODE: {IX, NotNull, VARCHAR(20), FK to noonnight, classification=Noonnight} */
    protected String _noonnightCode;

    /** DAYCHANGE_DATETIME: {NotNull, DATETIME(19)} */
    protected java.time.LocalDateTime _daychangeDatetime;

    /** IS_UPDATING: {NotNull, BIT} */
    protected Boolean _isUpdating;

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
        return "village_day";
    }

    // ===================================================================================
    //                                                                        Key Handling
    //                                                                        ============
    /** {@inheritDoc} */
    public boolean hasPrimaryKeyValue() {
        if (_villageDayId == null) { return false; }
        return true;
    }

    // ===================================================================================
    //                                                             Classification Property
    //                                                             =======================
    /**
     * Get the value of noonnightCode as the classification of Noonnight. <br>
     * NOONNIGHT_CODE: {IX, NotNull, VARCHAR(20), FK to noonnight, classification=Noonnight} <br>
     * 昼夜
     * <p>It's treated as case insensitive and if the code value is null, it returns null.</p>
     * @return The instance of classification definition (as ENUM type). (NullAllowed: when the column value is null)
     */
    public CDef.Noonnight getNoonnightCodeAsNoonnight() {
        return CDef.Noonnight.codeOf(getNoonnightCode());
    }

    /**
     * Set the value of noonnightCode as the classification of Noonnight. <br>
     * NOONNIGHT_CODE: {IX, NotNull, VARCHAR(20), FK to noonnight, classification=Noonnight} <br>
     * 昼夜
     * @param cdef The instance of classification definition (as ENUM type). (NullAllowed: if null, null value is set to the column)
     */
    public void setNoonnightCodeAsNoonnight(CDef.Noonnight cdef) {
        setNoonnightCode(cdef != null ? cdef.code() : null);
    }

    // ===================================================================================
    //                                                              Classification Setting
    //                                                              ======================
    /**
     * Set the value of noonnightCode as 夜 (NIGHT). <br>
     * 夜
     */
    public void setNoonnightCode_夜() {
        setNoonnightCodeAsNoonnight(CDef.Noonnight.夜);
    }

    /**
     * Set the value of noonnightCode as 昼 (NOON). <br>
     * 昼
     */
    public void setNoonnightCode_昼() {
        setNoonnightCodeAsNoonnight(CDef.Noonnight.昼);
    }

    // ===================================================================================
    //                                                        Classification Determination
    //                                                        ============================
    /**
     * Is the value of noonnightCode 夜? <br>
     * 夜
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isNoonnightCode夜() {
        CDef.Noonnight cdef = getNoonnightCodeAsNoonnight();
        return cdef != null ? cdef.equals(CDef.Noonnight.夜) : false;
    }

    /**
     * Is the value of noonnightCode 昼? <br>
     * 昼
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isNoonnightCode昼() {
        CDef.Noonnight cdef = getNoonnightCodeAsNoonnight();
        return cdef != null ? cdef.equals(CDef.Noonnight.昼) : false;
    }

    // ===================================================================================
    //                                                                    Foreign Property
    //                                                                    ================
    /** NOONNIGHT by my NOONNIGHT_CODE, named 'noonnight'. */
    protected OptionalEntity<Noonnight> _noonnight;

    /**
     * [get] NOONNIGHT by my NOONNIGHT_CODE, named 'noonnight'. <br>
     * Optional: alwaysPresent(), ifPresent().orElse(), get(), ...
     * @return The entity of foreign property 'noonnight'. (NotNull, EmptyAllowed: when e.g. null FK column, no setupSelect)
     */
    public OptionalEntity<Noonnight> getNoonnight() {
        if (_noonnight == null) { _noonnight = OptionalEntity.relationEmpty(this, "noonnight"); }
        return _noonnight;
    }

    /**
     * [set] NOONNIGHT by my NOONNIGHT_CODE, named 'noonnight'.
     * @param noonnight The entity of foreign property 'noonnight'. (NullAllowed)
     */
    public void setNoonnight(OptionalEntity<Noonnight> noonnight) {
        _noonnight = noonnight;
    }

    /** VILLAGE by my VILLAGE_ID, named 'village'. */
    protected OptionalEntity<Village> _village;

    /**
     * [get] VILLAGE by my VILLAGE_ID, named 'village'. <br>
     * Optional: alwaysPresent(), ifPresent().orElse(), get(), ...
     * @return The entity of foreign property 'village'. (NotNull, EmptyAllowed: when e.g. null FK column, no setupSelect)
     */
    public OptionalEntity<Village> getVillage() {
        if (_village == null) { _village = OptionalEntity.relationEmpty(this, "village"); }
        return _village;
    }

    /**
     * [set] VILLAGE by my VILLAGE_ID, named 'village'.
     * @param village The entity of foreign property 'village'. (NullAllowed)
     */
    public void setVillage(OptionalEntity<Village> village) {
        _village = village;
    }

    /** vote by VILLAGE_DAY_ID, named 'voteAsOne'. */
    protected OptionalEntity<Vote> _voteAsOne;

    /**
     * [get] vote by VILLAGE_DAY_ID, named 'voteAsOne'.
     * Optional: alwaysPresent(), ifPresent().orElse(), get(), ...
     * @return the entity of foreign property(referrer-as-one) 'voteAsOne'. (NotNull, EmptyAllowed: when e.g. no data, no setupSelect)
     */
    public OptionalEntity<Vote> getVoteAsOne() {
        if (_voteAsOne == null) { _voteAsOne = OptionalEntity.relationEmpty(this, "voteAsOne"); }
        return _voteAsOne;
    }

    /**
     * [set] vote by VILLAGE_DAY_ID, named 'voteAsOne'.
     * @param voteAsOne The entity of foreign property(referrer-as-one) 'voteAsOne'. (NullAllowed)
     */
    public void setVoteAsOne(OptionalEntity<Vote> voteAsOne) {
        _voteAsOne = voteAsOne;
    }

    // ===================================================================================
    //                                                                   Referrer Property
    //                                                                   =================
    /** ABILITY by VILLAGE_DAY_ID, named 'abilityList'. */
    protected List<Ability> _abilityList;

    /**
     * [get] ABILITY by VILLAGE_DAY_ID, named 'abilityList'.
     * @return The entity list of referrer property 'abilityList'. (NotNull: even if no loading, returns empty list)
     */
    public List<Ability> getAbilityList() {
        if (_abilityList == null) { _abilityList = newReferrerList(); }
        return _abilityList;
    }

    /**
     * [set] ABILITY by VILLAGE_DAY_ID, named 'abilityList'.
     * @param abilityList The entity list of referrer property 'abilityList'. (NullAllowed)
     */
    public void setAbilityList(List<Ability> abilityList) {
        _abilityList = abilityList;
    }

    /** COMMIT by VILLAGE_DAY_ID, named 'commitList'. */
    protected List<Commit> _commitList;

    /**
     * [get] COMMIT by VILLAGE_DAY_ID, named 'commitList'.
     * @return The entity list of referrer property 'commitList'. (NotNull: even if no loading, returns empty list)
     */
    public List<Commit> getCommitList() {
        if (_commitList == null) { _commitList = newReferrerList(); }
        return _commitList;
    }

    /**
     * [set] COMMIT by VILLAGE_DAY_ID, named 'commitList'.
     * @param commitList The entity list of referrer property 'commitList'. (NullAllowed)
     */
    public void setCommitList(List<Commit> commitList) {
        _commitList = commitList;
    }

    /** VILLAGE_PLAYER by DEAD_VILLAGE_DAY_ID, named 'villagePlayerList'. */
    protected List<VillagePlayer> _villagePlayerList;

    /**
     * [get] VILLAGE_PLAYER by DEAD_VILLAGE_DAY_ID, named 'villagePlayerList'.
     * @return The entity list of referrer property 'villagePlayerList'. (NotNull: even if no loading, returns empty list)
     */
    public List<VillagePlayer> getVillagePlayerList() {
        if (_villagePlayerList == null) { _villagePlayerList = newReferrerList(); }
        return _villagePlayerList;
    }

    /**
     * [set] VILLAGE_PLAYER by DEAD_VILLAGE_DAY_ID, named 'villagePlayerList'.
     * @param villagePlayerList The entity list of referrer property 'villagePlayerList'. (NullAllowed)
     */
    public void setVillagePlayerList(List<VillagePlayer> villagePlayerList) {
        _villagePlayerList = villagePlayerList;
    }

    protected <ELEMENT> List<ELEMENT> newReferrerList() { // overriding to import
        return new ArrayList<ELEMENT>();
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    @Override
    protected boolean doEquals(Object obj) {
        if (obj instanceof BsVillageDay) {
            BsVillageDay other = (BsVillageDay)obj;
            if (!xSV(_villageDayId, other._villageDayId)) { return false; }
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected int doHashCode(int initial) {
        int hs = initial;
        hs = xCH(hs, asTableDbName());
        hs = xCH(hs, _villageDayId);
        return hs;
    }

    @Override
    protected String doBuildStringWithRelation(String li) {
        StringBuilder sb = new StringBuilder();
        if (_noonnight != null && _noonnight.isPresent())
        { sb.append(li).append(xbRDS(_noonnight, "noonnight")); }
        if (_village != null && _village.isPresent())
        { sb.append(li).append(xbRDS(_village, "village")); }
        if (_voteAsOne != null && _voteAsOne.isPresent())
        { sb.append(li).append(xbRDS(_voteAsOne, "voteAsOne")); }
        if (_abilityList != null) { for (Ability et : _abilityList)
        { if (et != null) { sb.append(li).append(xbRDS(et, "abilityList")); } } }
        if (_commitList != null) { for (Commit et : _commitList)
        { if (et != null) { sb.append(li).append(xbRDS(et, "commitList")); } } }
        if (_villagePlayerList != null) { for (VillagePlayer et : _villagePlayerList)
        { if (et != null) { sb.append(li).append(xbRDS(et, "villagePlayerList")); } } }
        return sb.toString();
    }
    protected <ET extends Entity> String xbRDS(org.dbflute.optional.OptionalEntity<ET> et, String name) { // buildRelationDisplayString()
        return et.get().buildDisplayString(name, true, true);
    }

    @Override
    protected String doBuildColumnString(String dm) {
        StringBuilder sb = new StringBuilder();
        sb.append(dm).append(xfND(_villageDayId));
        sb.append(dm).append(xfND(_villageId));
        sb.append(dm).append(xfND(_day));
        sb.append(dm).append(xfND(_noonnightCode));
        sb.append(dm).append(xfND(_daychangeDatetime));
        sb.append(dm).append(xfND(_isUpdating));
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
        if (_noonnight != null && _noonnight.isPresent())
        { sb.append(dm).append("noonnight"); }
        if (_village != null && _village.isPresent())
        { sb.append(dm).append("village"); }
        if (_voteAsOne != null && _voteAsOne.isPresent())
        { sb.append(dm).append("voteAsOne"); }
        if (_abilityList != null && !_abilityList.isEmpty())
        { sb.append(dm).append("abilityList"); }
        if (_commitList != null && !_commitList.isEmpty())
        { sb.append(dm).append("commitList"); }
        if (_villagePlayerList != null && !_villagePlayerList.isEmpty())
        { sb.append(dm).append("villagePlayerList"); }
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length()).insert(0, "(").append(")");
        }
        return sb.toString();
    }

    @Override
    public VillageDay clone() {
        return (VillageDay)super.clone();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] VILLAGE_DAY_ID: {PK, ID, NotNull, INT UNSIGNED(10)} <br>
     * 村日付ID
     * @return The value of the column 'VILLAGE_DAY_ID'. (basically NotNull if selected: for the constraint)
     */
    public Integer getVillageDayId() {
        checkSpecifiedProperty("villageDayId");
        return _villageDayId;
    }

    /**
     * [set] VILLAGE_DAY_ID: {PK, ID, NotNull, INT UNSIGNED(10)} <br>
     * 村日付ID
     * @param villageDayId The value of the column 'VILLAGE_DAY_ID'. (basically NotNull if update: for the constraint)
     */
    public void setVillageDayId(Integer villageDayId) {
        registerModifiedProperty("villageDayId");
        _villageDayId = villageDayId;
    }

    /**
     * [get] VILLAGE_ID: {IX, NotNull, INT UNSIGNED(10), FK to village} <br>
     * 村ID
     * @return The value of the column 'VILLAGE_ID'. (basically NotNull if selected: for the constraint)
     */
    public Integer getVillageId() {
        checkSpecifiedProperty("villageId");
        return _villageId;
    }

    /**
     * [set] VILLAGE_ID: {IX, NotNull, INT UNSIGNED(10), FK to village} <br>
     * 村ID
     * @param villageId The value of the column 'VILLAGE_ID'. (basically NotNull if update: for the constraint)
     */
    public void setVillageId(Integer villageId) {
        registerModifiedProperty("villageId");
        _villageId = villageId;
    }

    /**
     * [get] DAY: {NotNull, INT UNSIGNED(10)} <br>
     * 何日目か
     * @return The value of the column 'DAY'. (basically NotNull if selected: for the constraint)
     */
    public Integer getDay() {
        checkSpecifiedProperty("day");
        return _day;
    }

    /**
     * [set] DAY: {NotNull, INT UNSIGNED(10)} <br>
     * 何日目か
     * @param day The value of the column 'DAY'. (basically NotNull if update: for the constraint)
     */
    public void setDay(Integer day) {
        registerModifiedProperty("day");
        _day = day;
    }

    /**
     * [get] NOONNIGHT_CODE: {IX, NotNull, VARCHAR(20), FK to noonnight, classification=Noonnight} <br>
     * 昼夜コード
     * @return The value of the column 'NOONNIGHT_CODE'. (basically NotNull if selected: for the constraint)
     */
    public String getNoonnightCode() {
        checkSpecifiedProperty("noonnightCode");
        return convertEmptyToNull(_noonnightCode);
    }

    /**
     * [set] NOONNIGHT_CODE: {IX, NotNull, VARCHAR(20), FK to noonnight, classification=Noonnight} <br>
     * 昼夜コード
     * @param noonnightCode The value of the column 'NOONNIGHT_CODE'. (basically NotNull if update: for the constraint)
     */
    protected void setNoonnightCode(String noonnightCode) {
        checkClassificationCode("NOONNIGHT_CODE", CDef.DefMeta.Noonnight, noonnightCode);
        registerModifiedProperty("noonnightCode");
        _noonnightCode = noonnightCode;
    }

    /**
     * [get] DAYCHANGE_DATETIME: {NotNull, DATETIME(19)} <br>
     * 日付更新日時
     * @return The value of the column 'DAYCHANGE_DATETIME'. (basically NotNull if selected: for the constraint)
     */
    public java.time.LocalDateTime getDaychangeDatetime() {
        checkSpecifiedProperty("daychangeDatetime");
        return _daychangeDatetime;
    }

    /**
     * [set] DAYCHANGE_DATETIME: {NotNull, DATETIME(19)} <br>
     * 日付更新日時
     * @param daychangeDatetime The value of the column 'DAYCHANGE_DATETIME'. (basically NotNull if update: for the constraint)
     */
    public void setDaychangeDatetime(java.time.LocalDateTime daychangeDatetime) {
        registerModifiedProperty("daychangeDatetime");
        _daychangeDatetime = daychangeDatetime;
    }

    /**
     * [get] IS_UPDATING: {NotNull, BIT} <br>
     * 更新中か
     * @return The value of the column 'IS_UPDATING'. (basically NotNull if selected: for the constraint)
     */
    public Boolean getIsUpdating() {
        checkSpecifiedProperty("isUpdating");
        return _isUpdating;
    }

    /**
     * [set] IS_UPDATING: {NotNull, BIT} <br>
     * 更新中か
     * @param isUpdating The value of the column 'IS_UPDATING'. (basically NotNull if update: for the constraint)
     */
    public void setIsUpdating(Boolean isUpdating) {
        registerModifiedProperty("isUpdating");
        _isUpdating = isUpdating;
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
     * @param noonnightCode The value of the column 'NOONNIGHT_CODE'. (basically NotNull if update: for the constraint)
     */
    public void mynativeMappingNoonnightCode(String noonnightCode) {
        setNoonnightCode(noonnightCode);
    }
}
