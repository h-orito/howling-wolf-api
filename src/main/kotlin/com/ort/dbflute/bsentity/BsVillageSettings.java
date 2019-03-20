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
 * The entity of VILLAGE_SETTINGS as TABLE. <br>
 * 村設定
 * <pre>
 * [primary-key]
 *     VILLAGE_ID
 *
 * [column]
 *     VILLAGE_ID, DUMMY_CHARA_ID, START_PERSON_MIN_NUM, PERSON_MAX_NUM, START_DATETIME, DAY_CHANGE_INTERVAL_SECONDS, IS_OPEN_VOTE, IS_POSSIBLE_SKILL_REQUEST, IS_AVAILABLE_SPECTATE, IS_AVAILABLE_SAME_WOLF_ATTACK, IS_OPEN_SKILL_IN_GRAVE, IS_VISIBLE_GRAVE_SPECTATE_MESSAGE, IS_AVAILABLE_SUDDONLY_DEATH, IS_AVAILABLE_COMMIT, IS_AVAILABLE_GUARD_SAME_TARGET, CHARACTER_GROUP_ID, JOIN_PASSWORD, ORGANIZE, ALLOWED_SECRET_SAY_CODE, REGISTER_DATETIME, REGISTER_TRACE, UPDATE_DATETIME, UPDATE_TRACE
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
 *     ALLOWED_SECRET_SAY, CHARA_GROUP, VILLAGE
 *
 * [referrer table]
 *     
 *
 * [foreign property]
 *     allowedSecretSay, charaGroup, village
 *
 * [referrer property]
 *     
 *
 * [get/set template]
 * /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
 * Integer villageId = entity.getVillageId();
 * Integer dummyCharaId = entity.getDummyCharaId();
 * Integer startPersonMinNum = entity.getStartPersonMinNum();
 * Integer personMaxNum = entity.getPersonMaxNum();
 * java.time.LocalDateTime startDatetime = entity.getStartDatetime();
 * Integer dayChangeIntervalSeconds = entity.getDayChangeIntervalSeconds();
 * Boolean isOpenVote = entity.getIsOpenVote();
 * Boolean isPossibleSkillRequest = entity.getIsPossibleSkillRequest();
 * Boolean isAvailableSpectate = entity.getIsAvailableSpectate();
 * Boolean isAvailableSameWolfAttack = entity.getIsAvailableSameWolfAttack();
 * Boolean isOpenSkillInGrave = entity.getIsOpenSkillInGrave();
 * Boolean isVisibleGraveSpectateMessage = entity.getIsVisibleGraveSpectateMessage();
 * Boolean isAvailableSuddonlyDeath = entity.getIsAvailableSuddonlyDeath();
 * Boolean isAvailableCommit = entity.getIsAvailableCommit();
 * Boolean isAvailableGuardSameTarget = entity.getIsAvailableGuardSameTarget();
 * Integer characterGroupId = entity.getCharacterGroupId();
 * String joinPassword = entity.getJoinPassword();
 * String organize = entity.getOrganize();
 * String allowedSecretSayCode = entity.getAllowedSecretSayCode();
 * java.time.LocalDateTime registerDatetime = entity.getRegisterDatetime();
 * String registerTrace = entity.getRegisterTrace();
 * java.time.LocalDateTime updateDatetime = entity.getUpdateDatetime();
 * String updateTrace = entity.getUpdateTrace();
 * entity.setVillageId(villageId);
 * entity.setDummyCharaId(dummyCharaId);
 * entity.setStartPersonMinNum(startPersonMinNum);
 * entity.setPersonMaxNum(personMaxNum);
 * entity.setStartDatetime(startDatetime);
 * entity.setDayChangeIntervalSeconds(dayChangeIntervalSeconds);
 * entity.setIsOpenVote(isOpenVote);
 * entity.setIsPossibleSkillRequest(isPossibleSkillRequest);
 * entity.setIsAvailableSpectate(isAvailableSpectate);
 * entity.setIsAvailableSameWolfAttack(isAvailableSameWolfAttack);
 * entity.setIsOpenSkillInGrave(isOpenSkillInGrave);
 * entity.setIsVisibleGraveSpectateMessage(isVisibleGraveSpectateMessage);
 * entity.setIsAvailableSuddonlyDeath(isAvailableSuddonlyDeath);
 * entity.setIsAvailableCommit(isAvailableCommit);
 * entity.setIsAvailableGuardSameTarget(isAvailableGuardSameTarget);
 * entity.setCharacterGroupId(characterGroupId);
 * entity.setJoinPassword(joinPassword);
 * entity.setOrganize(organize);
 * entity.setAllowedSecretSayCode(allowedSecretSayCode);
 * entity.setRegisterDatetime(registerDatetime);
 * entity.setRegisterTrace(registerTrace);
 * entity.setUpdateDatetime(updateDatetime);
 * entity.setUpdateTrace(updateTrace);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsVillageSettings extends AbstractEntity implements DomainEntity, EntityDefinedCommonColumn {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** The serial version UID for object serialization. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** VILLAGE_ID: {PK, NotNull, INT UNSIGNED(10), FK to village} */
    protected Integer _villageId;

    /** DUMMY_CHARA_ID: {NotNull, INT UNSIGNED(10)} */
    protected Integer _dummyCharaId;

    /** START_PERSON_MIN_NUM: {INT UNSIGNED(10)} */
    protected Integer _startPersonMinNum;

    /** PERSON_MAX_NUM: {INT UNSIGNED(10)} */
    protected Integer _personMaxNum;

    /** START_DATETIME: {DATETIME(19)} */
    protected java.time.LocalDateTime _startDatetime;

    /** DAY_CHANGE_INTERVAL_SECONDS: {NotNull, INT UNSIGNED(10)} */
    protected Integer _dayChangeIntervalSeconds;

    /** IS_OPEN_VOTE: {NotNull, BIT} */
    protected Boolean _isOpenVote;

    /** IS_POSSIBLE_SKILL_REQUEST: {NotNull, BIT} */
    protected Boolean _isPossibleSkillRequest;

    /** IS_AVAILABLE_SPECTATE: {NotNull, BIT} */
    protected Boolean _isAvailableSpectate;

    /** IS_AVAILABLE_SAME_WOLF_ATTACK: {NotNull, BIT} */
    protected Boolean _isAvailableSameWolfAttack;

    /** IS_OPEN_SKILL_IN_GRAVE: {NotNull, BIT} */
    protected Boolean _isOpenSkillInGrave;

    /** IS_VISIBLE_GRAVE_SPECTATE_MESSAGE: {NotNull, BIT} */
    protected Boolean _isVisibleGraveSpectateMessage;

    /** IS_AVAILABLE_SUDDONLY_DEATH: {NotNull, BIT} */
    protected Boolean _isAvailableSuddonlyDeath;

    /** IS_AVAILABLE_COMMIT: {NotNull, BIT} */
    protected Boolean _isAvailableCommit;

    /** IS_AVAILABLE_GUARD_SAME_TARGET: {NotNull, BIT} */
    protected Boolean _isAvailableGuardSameTarget;

    /** CHARACTER_GROUP_ID: {IX, NotNull, INT UNSIGNED(10), FK to chara_group} */
    protected Integer _characterGroupId;

    /** JOIN_PASSWORD: {VARCHAR(12)} */
    protected String _joinPassword;

    /** ORGANIZE: {NotNull, VARCHAR(400)} */
    protected String _organize;

    /** ALLOWED_SECRET_SAY_CODE: {IX, NotNull, VARCHAR(20), FK to allowed_secret_say, classification=AllowedSecretSay} */
    protected String _allowedSecretSayCode;

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
        return "village_settings";
    }

    // ===================================================================================
    //                                                                        Key Handling
    //                                                                        ============
    /** {@inheritDoc} */
    public boolean hasPrimaryKeyValue() {
        if (_villageId == null) { return false; }
        return true;
    }

    // ===================================================================================
    //                                                             Classification Property
    //                                                             =======================
    /**
     * Get the value of allowedSecretSayCode as the classification of AllowedSecretSay. <br>
     * ALLOWED_SECRET_SAY_CODE: {IX, NotNull, VARCHAR(20), FK to allowed_secret_say, classification=AllowedSecretSay} <br>
     * 秘話可能範囲
     * <p>It's treated as case insensitive and if the code value is null, it returns null.</p>
     * @return The instance of classification definition (as ENUM type). (NullAllowed: when the column value is null)
     */
    public CDef.AllowedSecretSay getAllowedSecretSayCodeAsAllowedSecretSay() {
        return CDef.AllowedSecretSay.codeOf(getAllowedSecretSayCode());
    }

    /**
     * Set the value of allowedSecretSayCode as the classification of AllowedSecretSay. <br>
     * ALLOWED_SECRET_SAY_CODE: {IX, NotNull, VARCHAR(20), FK to allowed_secret_say, classification=AllowedSecretSay} <br>
     * 秘話可能範囲
     * @param cdef The instance of classification definition (as ENUM type). (NullAllowed: if null, null value is set to the column)
     */
    public void setAllowedSecretSayCodeAsAllowedSecretSay(CDef.AllowedSecretSay cdef) {
        setAllowedSecretSayCode(cdef != null ? cdef.code() : null);
    }

    // ===================================================================================
    //                                                              Classification Setting
    //                                                              ======================
    /**
     * Set the value of allowedSecretSayCode as 全員 (EVERYTHING). <br>
     * 全員
     */
    public void setAllowedSecretSayCode_全員() {
        setAllowedSecretSayCodeAsAllowedSecretSay(CDef.AllowedSecretSay.全員);
    }

    /**
     * Set the value of allowedSecretSayCode as なし (NOTHING). <br>
     * なし
     */
    public void setAllowedSecretSayCode_なし() {
        setAllowedSecretSayCodeAsAllowedSecretSay(CDef.AllowedSecretSay.なし);
    }

    /**
     * Set the value of allowedSecretSayCode as 村建てとのみ (ONLY_CREATOR). <br>
     * 村建てとのみ
     */
    public void setAllowedSecretSayCode_村建てとのみ() {
        setAllowedSecretSayCodeAsAllowedSecretSay(CDef.AllowedSecretSay.村建てとのみ);
    }

    // ===================================================================================
    //                                                        Classification Determination
    //                                                        ============================
    /**
     * Is the value of allowedSecretSayCode 全員? <br>
     * 全員
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isAllowedSecretSayCode全員() {
        CDef.AllowedSecretSay cdef = getAllowedSecretSayCodeAsAllowedSecretSay();
        return cdef != null ? cdef.equals(CDef.AllowedSecretSay.全員) : false;
    }

    /**
     * Is the value of allowedSecretSayCode なし? <br>
     * なし
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isAllowedSecretSayCodeなし() {
        CDef.AllowedSecretSay cdef = getAllowedSecretSayCodeAsAllowedSecretSay();
        return cdef != null ? cdef.equals(CDef.AllowedSecretSay.なし) : false;
    }

    /**
     * Is the value of allowedSecretSayCode 村建てとのみ? <br>
     * 村建てとのみ
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isAllowedSecretSayCode村建てとのみ() {
        CDef.AllowedSecretSay cdef = getAllowedSecretSayCodeAsAllowedSecretSay();
        return cdef != null ? cdef.equals(CDef.AllowedSecretSay.村建てとのみ) : false;
    }

    // ===================================================================================
    //                                                                    Foreign Property
    //                                                                    ================
    /** ALLOWED_SECRET_SAY by my ALLOWED_SECRET_SAY_CODE, named 'allowedSecretSay'. */
    protected OptionalEntity<AllowedSecretSay> _allowedSecretSay;

    /**
     * [get] ALLOWED_SECRET_SAY by my ALLOWED_SECRET_SAY_CODE, named 'allowedSecretSay'. <br>
     * Optional: alwaysPresent(), ifPresent().orElse(), get(), ...
     * @return The entity of foreign property 'allowedSecretSay'. (NotNull, EmptyAllowed: when e.g. null FK column, no setupSelect)
     */
    public OptionalEntity<AllowedSecretSay> getAllowedSecretSay() {
        if (_allowedSecretSay == null) { _allowedSecretSay = OptionalEntity.relationEmpty(this, "allowedSecretSay"); }
        return _allowedSecretSay;
    }

    /**
     * [set] ALLOWED_SECRET_SAY by my ALLOWED_SECRET_SAY_CODE, named 'allowedSecretSay'.
     * @param allowedSecretSay The entity of foreign property 'allowedSecretSay'. (NullAllowed)
     */
    public void setAllowedSecretSay(OptionalEntity<AllowedSecretSay> allowedSecretSay) {
        _allowedSecretSay = allowedSecretSay;
    }

    /** CHARA_GROUP by my CHARACTER_GROUP_ID, named 'charaGroup'. */
    protected OptionalEntity<CharaGroup> _charaGroup;

    /**
     * [get] CHARA_GROUP by my CHARACTER_GROUP_ID, named 'charaGroup'. <br>
     * Optional: alwaysPresent(), ifPresent().orElse(), get(), ...
     * @return The entity of foreign property 'charaGroup'. (NotNull, EmptyAllowed: when e.g. null FK column, no setupSelect)
     */
    public OptionalEntity<CharaGroup> getCharaGroup() {
        if (_charaGroup == null) { _charaGroup = OptionalEntity.relationEmpty(this, "charaGroup"); }
        return _charaGroup;
    }

    /**
     * [set] CHARA_GROUP by my CHARACTER_GROUP_ID, named 'charaGroup'.
     * @param charaGroup The entity of foreign property 'charaGroup'. (NullAllowed)
     */
    public void setCharaGroup(OptionalEntity<CharaGroup> charaGroup) {
        _charaGroup = charaGroup;
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
        if (obj instanceof BsVillageSettings) {
            BsVillageSettings other = (BsVillageSettings)obj;
            if (!xSV(_villageId, other._villageId)) { return false; }
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
        return hs;
    }

    @Override
    protected String doBuildStringWithRelation(String li) {
        StringBuilder sb = new StringBuilder();
        if (_allowedSecretSay != null && _allowedSecretSay.isPresent())
        { sb.append(li).append(xbRDS(_allowedSecretSay, "allowedSecretSay")); }
        if (_charaGroup != null && _charaGroup.isPresent())
        { sb.append(li).append(xbRDS(_charaGroup, "charaGroup")); }
        if (_village != null && _village.isPresent())
        { sb.append(li).append(xbRDS(_village, "village")); }
        return sb.toString();
    }
    protected <ET extends Entity> String xbRDS(org.dbflute.optional.OptionalEntity<ET> et, String name) { // buildRelationDisplayString()
        return et.get().buildDisplayString(name, true, true);
    }

    @Override
    protected String doBuildColumnString(String dm) {
        StringBuilder sb = new StringBuilder();
        sb.append(dm).append(xfND(_villageId));
        sb.append(dm).append(xfND(_dummyCharaId));
        sb.append(dm).append(xfND(_startPersonMinNum));
        sb.append(dm).append(xfND(_personMaxNum));
        sb.append(dm).append(xfND(_startDatetime));
        sb.append(dm).append(xfND(_dayChangeIntervalSeconds));
        sb.append(dm).append(xfND(_isOpenVote));
        sb.append(dm).append(xfND(_isPossibleSkillRequest));
        sb.append(dm).append(xfND(_isAvailableSpectate));
        sb.append(dm).append(xfND(_isAvailableSameWolfAttack));
        sb.append(dm).append(xfND(_isOpenSkillInGrave));
        sb.append(dm).append(xfND(_isVisibleGraveSpectateMessage));
        sb.append(dm).append(xfND(_isAvailableSuddonlyDeath));
        sb.append(dm).append(xfND(_isAvailableCommit));
        sb.append(dm).append(xfND(_isAvailableGuardSameTarget));
        sb.append(dm).append(xfND(_characterGroupId));
        sb.append(dm).append(xfND(_joinPassword));
        sb.append(dm).append(xfND(_organize));
        sb.append(dm).append(xfND(_allowedSecretSayCode));
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
        if (_allowedSecretSay != null && _allowedSecretSay.isPresent())
        { sb.append(dm).append("allowedSecretSay"); }
        if (_charaGroup != null && _charaGroup.isPresent())
        { sb.append(dm).append("charaGroup"); }
        if (_village != null && _village.isPresent())
        { sb.append(dm).append("village"); }
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length()).insert(0, "(").append(")");
        }
        return sb.toString();
    }

    @Override
    public VillageSettings clone() {
        return (VillageSettings)super.clone();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] VILLAGE_ID: {PK, NotNull, INT UNSIGNED(10), FK to village} <br>
     * 村ID
     * @return The value of the column 'VILLAGE_ID'. (basically NotNull if selected: for the constraint)
     */
    public Integer getVillageId() {
        checkSpecifiedProperty("villageId");
        return _villageId;
    }

    /**
     * [set] VILLAGE_ID: {PK, NotNull, INT UNSIGNED(10), FK to village} <br>
     * 村ID
     * @param villageId The value of the column 'VILLAGE_ID'. (basically NotNull if update: for the constraint)
     */
    public void setVillageId(Integer villageId) {
        registerModifiedProperty("villageId");
        _villageId = villageId;
    }

    /**
     * [get] DUMMY_CHARA_ID: {NotNull, INT UNSIGNED(10)} <br>
     * ダミーキャラID
     * @return The value of the column 'DUMMY_CHARA_ID'. (basically NotNull if selected: for the constraint)
     */
    public Integer getDummyCharaId() {
        checkSpecifiedProperty("dummyCharaId");
        return _dummyCharaId;
    }

    /**
     * [set] DUMMY_CHARA_ID: {NotNull, INT UNSIGNED(10)} <br>
     * ダミーキャラID
     * @param dummyCharaId The value of the column 'DUMMY_CHARA_ID'. (basically NotNull if update: for the constraint)
     */
    public void setDummyCharaId(Integer dummyCharaId) {
        registerModifiedProperty("dummyCharaId");
        _dummyCharaId = dummyCharaId;
    }

    /**
     * [get] START_PERSON_MIN_NUM: {INT UNSIGNED(10)} <br>
     * 最低開始人数
     * @return The value of the column 'START_PERSON_MIN_NUM'. (NullAllowed even if selected: for no constraint)
     */
    public Integer getStartPersonMinNum() {
        checkSpecifiedProperty("startPersonMinNum");
        return _startPersonMinNum;
    }

    /**
     * [set] START_PERSON_MIN_NUM: {INT UNSIGNED(10)} <br>
     * 最低開始人数
     * @param startPersonMinNum The value of the column 'START_PERSON_MIN_NUM'. (NullAllowed: null update allowed for no constraint)
     */
    public void setStartPersonMinNum(Integer startPersonMinNum) {
        registerModifiedProperty("startPersonMinNum");
        _startPersonMinNum = startPersonMinNum;
    }

    /**
     * [get] PERSON_MAX_NUM: {INT UNSIGNED(10)} <br>
     * 定員
     * @return The value of the column 'PERSON_MAX_NUM'. (NullAllowed even if selected: for no constraint)
     */
    public Integer getPersonMaxNum() {
        checkSpecifiedProperty("personMaxNum");
        return _personMaxNum;
    }

    /**
     * [set] PERSON_MAX_NUM: {INT UNSIGNED(10)} <br>
     * 定員
     * @param personMaxNum The value of the column 'PERSON_MAX_NUM'. (NullAllowed: null update allowed for no constraint)
     */
    public void setPersonMaxNum(Integer personMaxNum) {
        registerModifiedProperty("personMaxNum");
        _personMaxNum = personMaxNum;
    }

    /**
     * [get] START_DATETIME: {DATETIME(19)} <br>
     * 開始日時
     * @return The value of the column 'START_DATETIME'. (NullAllowed even if selected: for no constraint)
     */
    public java.time.LocalDateTime getStartDatetime() {
        checkSpecifiedProperty("startDatetime");
        return _startDatetime;
    }

    /**
     * [set] START_DATETIME: {DATETIME(19)} <br>
     * 開始日時
     * @param startDatetime The value of the column 'START_DATETIME'. (NullAllowed: null update allowed for no constraint)
     */
    public void setStartDatetime(java.time.LocalDateTime startDatetime) {
        registerModifiedProperty("startDatetime");
        _startDatetime = startDatetime;
    }

    /**
     * [get] DAY_CHANGE_INTERVAL_SECONDS: {NotNull, INT UNSIGNED(10)} <br>
     * 更新間隔（秒）
     * @return The value of the column 'DAY_CHANGE_INTERVAL_SECONDS'. (basically NotNull if selected: for the constraint)
     */
    public Integer getDayChangeIntervalSeconds() {
        checkSpecifiedProperty("dayChangeIntervalSeconds");
        return _dayChangeIntervalSeconds;
    }

    /**
     * [set] DAY_CHANGE_INTERVAL_SECONDS: {NotNull, INT UNSIGNED(10)} <br>
     * 更新間隔（秒）
     * @param dayChangeIntervalSeconds The value of the column 'DAY_CHANGE_INTERVAL_SECONDS'. (basically NotNull if update: for the constraint)
     */
    public void setDayChangeIntervalSeconds(Integer dayChangeIntervalSeconds) {
        registerModifiedProperty("dayChangeIntervalSeconds");
        _dayChangeIntervalSeconds = dayChangeIntervalSeconds;
    }

    /**
     * [get] IS_OPEN_VOTE: {NotNull, BIT} <br>
     * 記名投票か
     * @return The value of the column 'IS_OPEN_VOTE'. (basically NotNull if selected: for the constraint)
     */
    public Boolean getIsOpenVote() {
        checkSpecifiedProperty("isOpenVote");
        return _isOpenVote;
    }

    /**
     * [set] IS_OPEN_VOTE: {NotNull, BIT} <br>
     * 記名投票か
     * @param isOpenVote The value of the column 'IS_OPEN_VOTE'. (basically NotNull if update: for the constraint)
     */
    public void setIsOpenVote(Boolean isOpenVote) {
        registerModifiedProperty("isOpenVote");
        _isOpenVote = isOpenVote;
    }

    /**
     * [get] IS_POSSIBLE_SKILL_REQUEST: {NotNull, BIT} <br>
     * 役職希望有効か
     * @return The value of the column 'IS_POSSIBLE_SKILL_REQUEST'. (basically NotNull if selected: for the constraint)
     */
    public Boolean getIsPossibleSkillRequest() {
        checkSpecifiedProperty("isPossibleSkillRequest");
        return _isPossibleSkillRequest;
    }

    /**
     * [set] IS_POSSIBLE_SKILL_REQUEST: {NotNull, BIT} <br>
     * 役職希望有効か
     * @param isPossibleSkillRequest The value of the column 'IS_POSSIBLE_SKILL_REQUEST'. (basically NotNull if update: for the constraint)
     */
    public void setIsPossibleSkillRequest(Boolean isPossibleSkillRequest) {
        registerModifiedProperty("isPossibleSkillRequest");
        _isPossibleSkillRequest = isPossibleSkillRequest;
    }

    /**
     * [get] IS_AVAILABLE_SPECTATE: {NotNull, BIT} <br>
     * 見学可能か
     * @return The value of the column 'IS_AVAILABLE_SPECTATE'. (basically NotNull if selected: for the constraint)
     */
    public Boolean getIsAvailableSpectate() {
        checkSpecifiedProperty("isAvailableSpectate");
        return _isAvailableSpectate;
    }

    /**
     * [set] IS_AVAILABLE_SPECTATE: {NotNull, BIT} <br>
     * 見学可能か
     * @param isAvailableSpectate The value of the column 'IS_AVAILABLE_SPECTATE'. (basically NotNull if update: for the constraint)
     */
    public void setIsAvailableSpectate(Boolean isAvailableSpectate) {
        registerModifiedProperty("isAvailableSpectate");
        _isAvailableSpectate = isAvailableSpectate;
    }

    /**
     * [get] IS_AVAILABLE_SAME_WOLF_ATTACK: {NotNull, BIT} <br>
     * 連続襲撃可能か
     * @return The value of the column 'IS_AVAILABLE_SAME_WOLF_ATTACK'. (basically NotNull if selected: for the constraint)
     */
    public Boolean getIsAvailableSameWolfAttack() {
        checkSpecifiedProperty("isAvailableSameWolfAttack");
        return _isAvailableSameWolfAttack;
    }

    /**
     * [set] IS_AVAILABLE_SAME_WOLF_ATTACK: {NotNull, BIT} <br>
     * 連続襲撃可能か
     * @param isAvailableSameWolfAttack The value of the column 'IS_AVAILABLE_SAME_WOLF_ATTACK'. (basically NotNull if update: for the constraint)
     */
    public void setIsAvailableSameWolfAttack(Boolean isAvailableSameWolfAttack) {
        registerModifiedProperty("isAvailableSameWolfAttack");
        _isAvailableSameWolfAttack = isAvailableSameWolfAttack;
    }

    /**
     * [get] IS_OPEN_SKILL_IN_GRAVE: {NotNull, BIT} <br>
     * 墓下役職公開ありか
     * @return The value of the column 'IS_OPEN_SKILL_IN_GRAVE'. (basically NotNull if selected: for the constraint)
     */
    public Boolean getIsOpenSkillInGrave() {
        checkSpecifiedProperty("isOpenSkillInGrave");
        return _isOpenSkillInGrave;
    }

    /**
     * [set] IS_OPEN_SKILL_IN_GRAVE: {NotNull, BIT} <br>
     * 墓下役職公開ありか
     * @param isOpenSkillInGrave The value of the column 'IS_OPEN_SKILL_IN_GRAVE'. (basically NotNull if update: for the constraint)
     */
    public void setIsOpenSkillInGrave(Boolean isOpenSkillInGrave) {
        registerModifiedProperty("isOpenSkillInGrave");
        _isOpenSkillInGrave = isOpenSkillInGrave;
    }

    /**
     * [get] IS_VISIBLE_GRAVE_SPECTATE_MESSAGE: {NotNull, BIT} <br>
     * 墓下見学発言を生存者が見られるか
     * @return The value of the column 'IS_VISIBLE_GRAVE_SPECTATE_MESSAGE'. (basically NotNull if selected: for the constraint)
     */
    public Boolean getIsVisibleGraveSpectateMessage() {
        checkSpecifiedProperty("isVisibleGraveSpectateMessage");
        return _isVisibleGraveSpectateMessage;
    }

    /**
     * [set] IS_VISIBLE_GRAVE_SPECTATE_MESSAGE: {NotNull, BIT} <br>
     * 墓下見学発言を生存者が見られるか
     * @param isVisibleGraveSpectateMessage The value of the column 'IS_VISIBLE_GRAVE_SPECTATE_MESSAGE'. (basically NotNull if update: for the constraint)
     */
    public void setIsVisibleGraveSpectateMessage(Boolean isVisibleGraveSpectateMessage) {
        registerModifiedProperty("isVisibleGraveSpectateMessage");
        _isVisibleGraveSpectateMessage = isVisibleGraveSpectateMessage;
    }

    /**
     * [get] IS_AVAILABLE_SUDDONLY_DEATH: {NotNull, BIT} <br>
     * 突然死ありか
     * @return The value of the column 'IS_AVAILABLE_SUDDONLY_DEATH'. (basically NotNull if selected: for the constraint)
     */
    public Boolean getIsAvailableSuddonlyDeath() {
        checkSpecifiedProperty("isAvailableSuddonlyDeath");
        return _isAvailableSuddonlyDeath;
    }

    /**
     * [set] IS_AVAILABLE_SUDDONLY_DEATH: {NotNull, BIT} <br>
     * 突然死ありか
     * @param isAvailableSuddonlyDeath The value of the column 'IS_AVAILABLE_SUDDONLY_DEATH'. (basically NotNull if update: for the constraint)
     */
    public void setIsAvailableSuddonlyDeath(Boolean isAvailableSuddonlyDeath) {
        registerModifiedProperty("isAvailableSuddonlyDeath");
        _isAvailableSuddonlyDeath = isAvailableSuddonlyDeath;
    }

    /**
     * [get] IS_AVAILABLE_COMMIT: {NotNull, BIT} <br>
     * コミット可能か
     * @return The value of the column 'IS_AVAILABLE_COMMIT'. (basically NotNull if selected: for the constraint)
     */
    public Boolean getIsAvailableCommit() {
        checkSpecifiedProperty("isAvailableCommit");
        return _isAvailableCommit;
    }

    /**
     * [set] IS_AVAILABLE_COMMIT: {NotNull, BIT} <br>
     * コミット可能か
     * @param isAvailableCommit The value of the column 'IS_AVAILABLE_COMMIT'. (basically NotNull if update: for the constraint)
     */
    public void setIsAvailableCommit(Boolean isAvailableCommit) {
        registerModifiedProperty("isAvailableCommit");
        _isAvailableCommit = isAvailableCommit;
    }

    /**
     * [get] IS_AVAILABLE_GUARD_SAME_TARGET: {NotNull, BIT} <br>
     * 連続護衛可能か
     * @return The value of the column 'IS_AVAILABLE_GUARD_SAME_TARGET'. (basically NotNull if selected: for the constraint)
     */
    public Boolean getIsAvailableGuardSameTarget() {
        checkSpecifiedProperty("isAvailableGuardSameTarget");
        return _isAvailableGuardSameTarget;
    }

    /**
     * [set] IS_AVAILABLE_GUARD_SAME_TARGET: {NotNull, BIT} <br>
     * 連続護衛可能か
     * @param isAvailableGuardSameTarget The value of the column 'IS_AVAILABLE_GUARD_SAME_TARGET'. (basically NotNull if update: for the constraint)
     */
    public void setIsAvailableGuardSameTarget(Boolean isAvailableGuardSameTarget) {
        registerModifiedProperty("isAvailableGuardSameTarget");
        _isAvailableGuardSameTarget = isAvailableGuardSameTarget;
    }

    /**
     * [get] CHARACTER_GROUP_ID: {IX, NotNull, INT UNSIGNED(10), FK to chara_group} <br>
     * キャラクターグループID
     * @return The value of the column 'CHARACTER_GROUP_ID'. (basically NotNull if selected: for the constraint)
     */
    public Integer getCharacterGroupId() {
        checkSpecifiedProperty("characterGroupId");
        return _characterGroupId;
    }

    /**
     * [set] CHARACTER_GROUP_ID: {IX, NotNull, INT UNSIGNED(10), FK to chara_group} <br>
     * キャラクターグループID
     * @param characterGroupId The value of the column 'CHARACTER_GROUP_ID'. (basically NotNull if update: for the constraint)
     */
    public void setCharacterGroupId(Integer characterGroupId) {
        registerModifiedProperty("characterGroupId");
        _characterGroupId = characterGroupId;
    }

    /**
     * [get] JOIN_PASSWORD: {VARCHAR(12)} <br>
     * 入村パスワード
     * @return The value of the column 'JOIN_PASSWORD'. (NullAllowed even if selected: for no constraint)
     */
    public String getJoinPassword() {
        checkSpecifiedProperty("joinPassword");
        return convertEmptyToNull(_joinPassword);
    }

    /**
     * [set] JOIN_PASSWORD: {VARCHAR(12)} <br>
     * 入村パスワード
     * @param joinPassword The value of the column 'JOIN_PASSWORD'. (NullAllowed: null update allowed for no constraint)
     */
    public void setJoinPassword(String joinPassword) {
        registerModifiedProperty("joinPassword");
        _joinPassword = joinPassword;
    }

    /**
     * [get] ORGANIZE: {NotNull, VARCHAR(400)} <br>
     * 構成
     * @return The value of the column 'ORGANIZE'. (basically NotNull if selected: for the constraint)
     */
    public String getOrganize() {
        checkSpecifiedProperty("organize");
        return convertEmptyToNull(_organize);
    }

    /**
     * [set] ORGANIZE: {NotNull, VARCHAR(400)} <br>
     * 構成
     * @param organize The value of the column 'ORGANIZE'. (basically NotNull if update: for the constraint)
     */
    public void setOrganize(String organize) {
        registerModifiedProperty("organize");
        _organize = organize;
    }

    /**
     * [get] ALLOWED_SECRET_SAY_CODE: {IX, NotNull, VARCHAR(20), FK to allowed_secret_say, classification=AllowedSecretSay} <br>
     * 秘話可能な範囲コード
     * @return The value of the column 'ALLOWED_SECRET_SAY_CODE'. (basically NotNull if selected: for the constraint)
     */
    public String getAllowedSecretSayCode() {
        checkSpecifiedProperty("allowedSecretSayCode");
        return convertEmptyToNull(_allowedSecretSayCode);
    }

    /**
     * [set] ALLOWED_SECRET_SAY_CODE: {IX, NotNull, VARCHAR(20), FK to allowed_secret_say, classification=AllowedSecretSay} <br>
     * 秘話可能な範囲コード
     * @param allowedSecretSayCode The value of the column 'ALLOWED_SECRET_SAY_CODE'. (basically NotNull if update: for the constraint)
     */
    protected void setAllowedSecretSayCode(String allowedSecretSayCode) {
        checkClassificationCode("ALLOWED_SECRET_SAY_CODE", CDef.DefMeta.AllowedSecretSay, allowedSecretSayCode);
        registerModifiedProperty("allowedSecretSayCode");
        _allowedSecretSayCode = allowedSecretSayCode;
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
     * @param allowedSecretSayCode The value of the column 'ALLOWED_SECRET_SAY_CODE'. (basically NotNull if update: for the constraint)
     */
    public void mynativeMappingAllowedSecretSayCode(String allowedSecretSayCode) {
        setAllowedSecretSayCode(allowedSecretSayCode);
    }
}
