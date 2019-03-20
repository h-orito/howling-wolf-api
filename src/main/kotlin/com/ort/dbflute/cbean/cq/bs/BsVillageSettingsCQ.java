package com.ort.dbflute.cbean.cq.bs;

import java.util.Map;

import org.dbflute.cbean.*;
import org.dbflute.cbean.chelper.*;
import org.dbflute.cbean.coption.*;
import org.dbflute.cbean.cvalue.ConditionValue;
import org.dbflute.cbean.sqlclause.SqlClause;
import org.dbflute.exception.IllegalConditionBeanOperationException;
import com.ort.dbflute.cbean.cq.ciq.*;
import com.ort.dbflute.cbean.*;
import com.ort.dbflute.cbean.cq.*;

/**
 * The base condition-query of village_settings.
 * @author DBFlute(AutoGenerator)
 */
public class BsVillageSettingsCQ extends AbstractBsVillageSettingsCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected VillageSettingsCIQ _inlineQuery;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsVillageSettingsCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                 InlineView/OrClause
    //                                                                 ===================
    /**
     * Prepare InlineView query. <br>
     * {select ... from ... left outer join (select * from village_settings) where FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">inline()</span>.setFoo...;
     * </pre>
     * @return The condition-query for InlineView query. (NotNull)
     */
    public VillageSettingsCIQ inline() {
        if (_inlineQuery == null) { _inlineQuery = xcreateCIQ(); }
        _inlineQuery.xsetOnClause(false); return _inlineQuery;
    }

    protected VillageSettingsCIQ xcreateCIQ() {
        VillageSettingsCIQ ciq = xnewCIQ();
        ciq.xsetBaseCB(_baseCB);
        return ciq;
    }

    protected VillageSettingsCIQ xnewCIQ() {
        return new VillageSettingsCIQ(xgetReferrerQuery(), xgetSqlClause(), xgetAliasName(), xgetNestLevel(), this);
    }

    /**
     * Prepare OnClause query. <br>
     * {select ... from ... left outer join village_settings on ... and FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">on()</span>.setFoo...;
     * </pre>
     * @return The condition-query for OnClause query. (NotNull)
     * @throws IllegalConditionBeanOperationException When this condition-query is base query.
     */
    public VillageSettingsCIQ on() {
        if (isBaseQuery()) { throw new IllegalConditionBeanOperationException("OnClause for local table is unavailable!"); }
        VillageSettingsCIQ inlineQuery = inline(); inlineQuery.xsetOnClause(true); return inlineQuery;
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    protected ConditionValue _villageId;
    public ConditionValue xdfgetVillageId()
    { if (_villageId == null) { _villageId = nCV(); }
      return _villageId; }
    protected ConditionValue xgetCValueVillageId() { return xdfgetVillageId(); }

    /** 
     * Add order-by as ascend. <br>
     * VILLAGE_ID: {PK, NotNull, INT UNSIGNED(10), FK to village}
     * @return this. (NotNull)
     */
    public BsVillageSettingsCQ addOrderBy_VillageId_Asc() { regOBA("VILLAGE_ID"); return this; }

    /**
     * Add order-by as descend. <br>
     * VILLAGE_ID: {PK, NotNull, INT UNSIGNED(10), FK to village}
     * @return this. (NotNull)
     */
    public BsVillageSettingsCQ addOrderBy_VillageId_Desc() { regOBD("VILLAGE_ID"); return this; }

    protected ConditionValue _dummyCharaId;
    public ConditionValue xdfgetDummyCharaId()
    { if (_dummyCharaId == null) { _dummyCharaId = nCV(); }
      return _dummyCharaId; }
    protected ConditionValue xgetCValueDummyCharaId() { return xdfgetDummyCharaId(); }

    /** 
     * Add order-by as ascend. <br>
     * DUMMY_CHARA_ID: {NotNull, INT UNSIGNED(10)}
     * @return this. (NotNull)
     */
    public BsVillageSettingsCQ addOrderBy_DummyCharaId_Asc() { regOBA("DUMMY_CHARA_ID"); return this; }

    /**
     * Add order-by as descend. <br>
     * DUMMY_CHARA_ID: {NotNull, INT UNSIGNED(10)}
     * @return this. (NotNull)
     */
    public BsVillageSettingsCQ addOrderBy_DummyCharaId_Desc() { regOBD("DUMMY_CHARA_ID"); return this; }

    protected ConditionValue _startPersonMinNum;
    public ConditionValue xdfgetStartPersonMinNum()
    { if (_startPersonMinNum == null) { _startPersonMinNum = nCV(); }
      return _startPersonMinNum; }
    protected ConditionValue xgetCValueStartPersonMinNum() { return xdfgetStartPersonMinNum(); }

    /** 
     * Add order-by as ascend. <br>
     * START_PERSON_MIN_NUM: {INT UNSIGNED(10)}
     * @return this. (NotNull)
     */
    public BsVillageSettingsCQ addOrderBy_StartPersonMinNum_Asc() { regOBA("START_PERSON_MIN_NUM"); return this; }

    /**
     * Add order-by as descend. <br>
     * START_PERSON_MIN_NUM: {INT UNSIGNED(10)}
     * @return this. (NotNull)
     */
    public BsVillageSettingsCQ addOrderBy_StartPersonMinNum_Desc() { regOBD("START_PERSON_MIN_NUM"); return this; }

    protected ConditionValue _personMaxNum;
    public ConditionValue xdfgetPersonMaxNum()
    { if (_personMaxNum == null) { _personMaxNum = nCV(); }
      return _personMaxNum; }
    protected ConditionValue xgetCValuePersonMaxNum() { return xdfgetPersonMaxNum(); }

    /** 
     * Add order-by as ascend. <br>
     * PERSON_MAX_NUM: {INT UNSIGNED(10)}
     * @return this. (NotNull)
     */
    public BsVillageSettingsCQ addOrderBy_PersonMaxNum_Asc() { regOBA("PERSON_MAX_NUM"); return this; }

    /**
     * Add order-by as descend. <br>
     * PERSON_MAX_NUM: {INT UNSIGNED(10)}
     * @return this. (NotNull)
     */
    public BsVillageSettingsCQ addOrderBy_PersonMaxNum_Desc() { regOBD("PERSON_MAX_NUM"); return this; }

    protected ConditionValue _startDatetime;
    public ConditionValue xdfgetStartDatetime()
    { if (_startDatetime == null) { _startDatetime = nCV(); }
      return _startDatetime; }
    protected ConditionValue xgetCValueStartDatetime() { return xdfgetStartDatetime(); }

    /** 
     * Add order-by as ascend. <br>
     * START_DATETIME: {DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsVillageSettingsCQ addOrderBy_StartDatetime_Asc() { regOBA("START_DATETIME"); return this; }

    /**
     * Add order-by as descend. <br>
     * START_DATETIME: {DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsVillageSettingsCQ addOrderBy_StartDatetime_Desc() { regOBD("START_DATETIME"); return this; }

    protected ConditionValue _dayChangeIntervalSeconds;
    public ConditionValue xdfgetDayChangeIntervalSeconds()
    { if (_dayChangeIntervalSeconds == null) { _dayChangeIntervalSeconds = nCV(); }
      return _dayChangeIntervalSeconds; }
    protected ConditionValue xgetCValueDayChangeIntervalSeconds() { return xdfgetDayChangeIntervalSeconds(); }

    /** 
     * Add order-by as ascend. <br>
     * DAY_CHANGE_INTERVAL_SECONDS: {NotNull, INT UNSIGNED(10)}
     * @return this. (NotNull)
     */
    public BsVillageSettingsCQ addOrderBy_DayChangeIntervalSeconds_Asc() { regOBA("DAY_CHANGE_INTERVAL_SECONDS"); return this; }

    /**
     * Add order-by as descend. <br>
     * DAY_CHANGE_INTERVAL_SECONDS: {NotNull, INT UNSIGNED(10)}
     * @return this. (NotNull)
     */
    public BsVillageSettingsCQ addOrderBy_DayChangeIntervalSeconds_Desc() { regOBD("DAY_CHANGE_INTERVAL_SECONDS"); return this; }

    protected ConditionValue _isOpenVote;
    public ConditionValue xdfgetIsOpenVote()
    { if (_isOpenVote == null) { _isOpenVote = nCV(); }
      return _isOpenVote; }
    protected ConditionValue xgetCValueIsOpenVote() { return xdfgetIsOpenVote(); }

    /** 
     * Add order-by as ascend. <br>
     * IS_OPEN_VOTE: {NotNull, BIT}
     * @return this. (NotNull)
     */
    public BsVillageSettingsCQ addOrderBy_IsOpenVote_Asc() { regOBA("IS_OPEN_VOTE"); return this; }

    /**
     * Add order-by as descend. <br>
     * IS_OPEN_VOTE: {NotNull, BIT}
     * @return this. (NotNull)
     */
    public BsVillageSettingsCQ addOrderBy_IsOpenVote_Desc() { regOBD("IS_OPEN_VOTE"); return this; }

    protected ConditionValue _isPossibleSkillRequest;
    public ConditionValue xdfgetIsPossibleSkillRequest()
    { if (_isPossibleSkillRequest == null) { _isPossibleSkillRequest = nCV(); }
      return _isPossibleSkillRequest; }
    protected ConditionValue xgetCValueIsPossibleSkillRequest() { return xdfgetIsPossibleSkillRequest(); }

    /** 
     * Add order-by as ascend. <br>
     * IS_POSSIBLE_SKILL_REQUEST: {NotNull, BIT}
     * @return this. (NotNull)
     */
    public BsVillageSettingsCQ addOrderBy_IsPossibleSkillRequest_Asc() { regOBA("IS_POSSIBLE_SKILL_REQUEST"); return this; }

    /**
     * Add order-by as descend. <br>
     * IS_POSSIBLE_SKILL_REQUEST: {NotNull, BIT}
     * @return this. (NotNull)
     */
    public BsVillageSettingsCQ addOrderBy_IsPossibleSkillRequest_Desc() { regOBD("IS_POSSIBLE_SKILL_REQUEST"); return this; }

    protected ConditionValue _isAvailableSpectate;
    public ConditionValue xdfgetIsAvailableSpectate()
    { if (_isAvailableSpectate == null) { _isAvailableSpectate = nCV(); }
      return _isAvailableSpectate; }
    protected ConditionValue xgetCValueIsAvailableSpectate() { return xdfgetIsAvailableSpectate(); }

    /** 
     * Add order-by as ascend. <br>
     * IS_AVAILABLE_SPECTATE: {NotNull, BIT}
     * @return this. (NotNull)
     */
    public BsVillageSettingsCQ addOrderBy_IsAvailableSpectate_Asc() { regOBA("IS_AVAILABLE_SPECTATE"); return this; }

    /**
     * Add order-by as descend. <br>
     * IS_AVAILABLE_SPECTATE: {NotNull, BIT}
     * @return this. (NotNull)
     */
    public BsVillageSettingsCQ addOrderBy_IsAvailableSpectate_Desc() { regOBD("IS_AVAILABLE_SPECTATE"); return this; }

    protected ConditionValue _isAvailableSameWolfAttack;
    public ConditionValue xdfgetIsAvailableSameWolfAttack()
    { if (_isAvailableSameWolfAttack == null) { _isAvailableSameWolfAttack = nCV(); }
      return _isAvailableSameWolfAttack; }
    protected ConditionValue xgetCValueIsAvailableSameWolfAttack() { return xdfgetIsAvailableSameWolfAttack(); }

    /** 
     * Add order-by as ascend. <br>
     * IS_AVAILABLE_SAME_WOLF_ATTACK: {NotNull, BIT}
     * @return this. (NotNull)
     */
    public BsVillageSettingsCQ addOrderBy_IsAvailableSameWolfAttack_Asc() { regOBA("IS_AVAILABLE_SAME_WOLF_ATTACK"); return this; }

    /**
     * Add order-by as descend. <br>
     * IS_AVAILABLE_SAME_WOLF_ATTACK: {NotNull, BIT}
     * @return this. (NotNull)
     */
    public BsVillageSettingsCQ addOrderBy_IsAvailableSameWolfAttack_Desc() { regOBD("IS_AVAILABLE_SAME_WOLF_ATTACK"); return this; }

    protected ConditionValue _isOpenSkillInGrave;
    public ConditionValue xdfgetIsOpenSkillInGrave()
    { if (_isOpenSkillInGrave == null) { _isOpenSkillInGrave = nCV(); }
      return _isOpenSkillInGrave; }
    protected ConditionValue xgetCValueIsOpenSkillInGrave() { return xdfgetIsOpenSkillInGrave(); }

    /** 
     * Add order-by as ascend. <br>
     * IS_OPEN_SKILL_IN_GRAVE: {NotNull, BIT}
     * @return this. (NotNull)
     */
    public BsVillageSettingsCQ addOrderBy_IsOpenSkillInGrave_Asc() { regOBA("IS_OPEN_SKILL_IN_GRAVE"); return this; }

    /**
     * Add order-by as descend. <br>
     * IS_OPEN_SKILL_IN_GRAVE: {NotNull, BIT}
     * @return this. (NotNull)
     */
    public BsVillageSettingsCQ addOrderBy_IsOpenSkillInGrave_Desc() { regOBD("IS_OPEN_SKILL_IN_GRAVE"); return this; }

    protected ConditionValue _isVisibleGraveSpectateMessage;
    public ConditionValue xdfgetIsVisibleGraveSpectateMessage()
    { if (_isVisibleGraveSpectateMessage == null) { _isVisibleGraveSpectateMessage = nCV(); }
      return _isVisibleGraveSpectateMessage; }
    protected ConditionValue xgetCValueIsVisibleGraveSpectateMessage() { return xdfgetIsVisibleGraveSpectateMessage(); }

    /** 
     * Add order-by as ascend. <br>
     * IS_VISIBLE_GRAVE_SPECTATE_MESSAGE: {NotNull, BIT}
     * @return this. (NotNull)
     */
    public BsVillageSettingsCQ addOrderBy_IsVisibleGraveSpectateMessage_Asc() { regOBA("IS_VISIBLE_GRAVE_SPECTATE_MESSAGE"); return this; }

    /**
     * Add order-by as descend. <br>
     * IS_VISIBLE_GRAVE_SPECTATE_MESSAGE: {NotNull, BIT}
     * @return this. (NotNull)
     */
    public BsVillageSettingsCQ addOrderBy_IsVisibleGraveSpectateMessage_Desc() { regOBD("IS_VISIBLE_GRAVE_SPECTATE_MESSAGE"); return this; }

    protected ConditionValue _isAvailableSuddonlyDeath;
    public ConditionValue xdfgetIsAvailableSuddonlyDeath()
    { if (_isAvailableSuddonlyDeath == null) { _isAvailableSuddonlyDeath = nCV(); }
      return _isAvailableSuddonlyDeath; }
    protected ConditionValue xgetCValueIsAvailableSuddonlyDeath() { return xdfgetIsAvailableSuddonlyDeath(); }

    /** 
     * Add order-by as ascend. <br>
     * IS_AVAILABLE_SUDDONLY_DEATH: {NotNull, BIT}
     * @return this. (NotNull)
     */
    public BsVillageSettingsCQ addOrderBy_IsAvailableSuddonlyDeath_Asc() { regOBA("IS_AVAILABLE_SUDDONLY_DEATH"); return this; }

    /**
     * Add order-by as descend. <br>
     * IS_AVAILABLE_SUDDONLY_DEATH: {NotNull, BIT}
     * @return this. (NotNull)
     */
    public BsVillageSettingsCQ addOrderBy_IsAvailableSuddonlyDeath_Desc() { regOBD("IS_AVAILABLE_SUDDONLY_DEATH"); return this; }

    protected ConditionValue _isAvailableCommit;
    public ConditionValue xdfgetIsAvailableCommit()
    { if (_isAvailableCommit == null) { _isAvailableCommit = nCV(); }
      return _isAvailableCommit; }
    protected ConditionValue xgetCValueIsAvailableCommit() { return xdfgetIsAvailableCommit(); }

    /** 
     * Add order-by as ascend. <br>
     * IS_AVAILABLE_COMMIT: {NotNull, BIT}
     * @return this. (NotNull)
     */
    public BsVillageSettingsCQ addOrderBy_IsAvailableCommit_Asc() { regOBA("IS_AVAILABLE_COMMIT"); return this; }

    /**
     * Add order-by as descend. <br>
     * IS_AVAILABLE_COMMIT: {NotNull, BIT}
     * @return this. (NotNull)
     */
    public BsVillageSettingsCQ addOrderBy_IsAvailableCommit_Desc() { regOBD("IS_AVAILABLE_COMMIT"); return this; }

    protected ConditionValue _isAvailableGuardSameTarget;
    public ConditionValue xdfgetIsAvailableGuardSameTarget()
    { if (_isAvailableGuardSameTarget == null) { _isAvailableGuardSameTarget = nCV(); }
      return _isAvailableGuardSameTarget; }
    protected ConditionValue xgetCValueIsAvailableGuardSameTarget() { return xdfgetIsAvailableGuardSameTarget(); }

    /** 
     * Add order-by as ascend. <br>
     * IS_AVAILABLE_GUARD_SAME_TARGET: {NotNull, BIT}
     * @return this. (NotNull)
     */
    public BsVillageSettingsCQ addOrderBy_IsAvailableGuardSameTarget_Asc() { regOBA("IS_AVAILABLE_GUARD_SAME_TARGET"); return this; }

    /**
     * Add order-by as descend. <br>
     * IS_AVAILABLE_GUARD_SAME_TARGET: {NotNull, BIT}
     * @return this. (NotNull)
     */
    public BsVillageSettingsCQ addOrderBy_IsAvailableGuardSameTarget_Desc() { regOBD("IS_AVAILABLE_GUARD_SAME_TARGET"); return this; }

    protected ConditionValue _characterGroupId;
    public ConditionValue xdfgetCharacterGroupId()
    { if (_characterGroupId == null) { _characterGroupId = nCV(); }
      return _characterGroupId; }
    protected ConditionValue xgetCValueCharacterGroupId() { return xdfgetCharacterGroupId(); }

    /** 
     * Add order-by as ascend. <br>
     * CHARACTER_GROUP_ID: {IX, NotNull, INT UNSIGNED(10), FK to chara_group}
     * @return this. (NotNull)
     */
    public BsVillageSettingsCQ addOrderBy_CharacterGroupId_Asc() { regOBA("CHARACTER_GROUP_ID"); return this; }

    /**
     * Add order-by as descend. <br>
     * CHARACTER_GROUP_ID: {IX, NotNull, INT UNSIGNED(10), FK to chara_group}
     * @return this. (NotNull)
     */
    public BsVillageSettingsCQ addOrderBy_CharacterGroupId_Desc() { regOBD("CHARACTER_GROUP_ID"); return this; }

    protected ConditionValue _joinPassword;
    public ConditionValue xdfgetJoinPassword()
    { if (_joinPassword == null) { _joinPassword = nCV(); }
      return _joinPassword; }
    protected ConditionValue xgetCValueJoinPassword() { return xdfgetJoinPassword(); }

    /** 
     * Add order-by as ascend. <br>
     * JOIN_PASSWORD: {VARCHAR(12)}
     * @return this. (NotNull)
     */
    public BsVillageSettingsCQ addOrderBy_JoinPassword_Asc() { regOBA("JOIN_PASSWORD"); return this; }

    /**
     * Add order-by as descend. <br>
     * JOIN_PASSWORD: {VARCHAR(12)}
     * @return this. (NotNull)
     */
    public BsVillageSettingsCQ addOrderBy_JoinPassword_Desc() { regOBD("JOIN_PASSWORD"); return this; }

    protected ConditionValue _organize;
    public ConditionValue xdfgetOrganize()
    { if (_organize == null) { _organize = nCV(); }
      return _organize; }
    protected ConditionValue xgetCValueOrganize() { return xdfgetOrganize(); }

    /** 
     * Add order-by as ascend. <br>
     * ORGANIZE: {NotNull, VARCHAR(400)}
     * @return this. (NotNull)
     */
    public BsVillageSettingsCQ addOrderBy_Organize_Asc() { regOBA("ORGANIZE"); return this; }

    /**
     * Add order-by as descend. <br>
     * ORGANIZE: {NotNull, VARCHAR(400)}
     * @return this. (NotNull)
     */
    public BsVillageSettingsCQ addOrderBy_Organize_Desc() { regOBD("ORGANIZE"); return this; }

    protected ConditionValue _allowedSecretSayCode;
    public ConditionValue xdfgetAllowedSecretSayCode()
    { if (_allowedSecretSayCode == null) { _allowedSecretSayCode = nCV(); }
      return _allowedSecretSayCode; }
    protected ConditionValue xgetCValueAllowedSecretSayCode() { return xdfgetAllowedSecretSayCode(); }

    /** 
     * Add order-by as ascend. <br>
     * ALLOWED_SECRET_SAY_CODE: {IX, NotNull, VARCHAR(20), FK to allowed_secret_say, classification=AllowedSecretSay}
     * @return this. (NotNull)
     */
    public BsVillageSettingsCQ addOrderBy_AllowedSecretSayCode_Asc() { regOBA("ALLOWED_SECRET_SAY_CODE"); return this; }

    /**
     * Add order-by as descend. <br>
     * ALLOWED_SECRET_SAY_CODE: {IX, NotNull, VARCHAR(20), FK to allowed_secret_say, classification=AllowedSecretSay}
     * @return this. (NotNull)
     */
    public BsVillageSettingsCQ addOrderBy_AllowedSecretSayCode_Desc() { regOBD("ALLOWED_SECRET_SAY_CODE"); return this; }

    protected ConditionValue _registerDatetime;
    public ConditionValue xdfgetRegisterDatetime()
    { if (_registerDatetime == null) { _registerDatetime = nCV(); }
      return _registerDatetime; }
    protected ConditionValue xgetCValueRegisterDatetime() { return xdfgetRegisterDatetime(); }

    /** 
     * Add order-by as ascend. <br>
     * REGISTER_DATETIME: {NotNull, DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsVillageSettingsCQ addOrderBy_RegisterDatetime_Asc() { regOBA("REGISTER_DATETIME"); return this; }

    /**
     * Add order-by as descend. <br>
     * REGISTER_DATETIME: {NotNull, DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsVillageSettingsCQ addOrderBy_RegisterDatetime_Desc() { regOBD("REGISTER_DATETIME"); return this; }

    protected ConditionValue _registerTrace;
    public ConditionValue xdfgetRegisterTrace()
    { if (_registerTrace == null) { _registerTrace = nCV(); }
      return _registerTrace; }
    protected ConditionValue xgetCValueRegisterTrace() { return xdfgetRegisterTrace(); }

    /** 
     * Add order-by as ascend. <br>
     * REGISTER_TRACE: {NotNull, VARCHAR(64)}
     * @return this. (NotNull)
     */
    public BsVillageSettingsCQ addOrderBy_RegisterTrace_Asc() { regOBA("REGISTER_TRACE"); return this; }

    /**
     * Add order-by as descend. <br>
     * REGISTER_TRACE: {NotNull, VARCHAR(64)}
     * @return this. (NotNull)
     */
    public BsVillageSettingsCQ addOrderBy_RegisterTrace_Desc() { regOBD("REGISTER_TRACE"); return this; }

    protected ConditionValue _updateDatetime;
    public ConditionValue xdfgetUpdateDatetime()
    { if (_updateDatetime == null) { _updateDatetime = nCV(); }
      return _updateDatetime; }
    protected ConditionValue xgetCValueUpdateDatetime() { return xdfgetUpdateDatetime(); }

    /** 
     * Add order-by as ascend. <br>
     * UPDATE_DATETIME: {NotNull, DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsVillageSettingsCQ addOrderBy_UpdateDatetime_Asc() { regOBA("UPDATE_DATETIME"); return this; }

    /**
     * Add order-by as descend. <br>
     * UPDATE_DATETIME: {NotNull, DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsVillageSettingsCQ addOrderBy_UpdateDatetime_Desc() { regOBD("UPDATE_DATETIME"); return this; }

    protected ConditionValue _updateTrace;
    public ConditionValue xdfgetUpdateTrace()
    { if (_updateTrace == null) { _updateTrace = nCV(); }
      return _updateTrace; }
    protected ConditionValue xgetCValueUpdateTrace() { return xdfgetUpdateTrace(); }

    /** 
     * Add order-by as ascend. <br>
     * UPDATE_TRACE: {NotNull, VARCHAR(64)}
     * @return this. (NotNull)
     */
    public BsVillageSettingsCQ addOrderBy_UpdateTrace_Asc() { regOBA("UPDATE_TRACE"); return this; }

    /**
     * Add order-by as descend. <br>
     * UPDATE_TRACE: {NotNull, VARCHAR(64)}
     * @return this. (NotNull)
     */
    public BsVillageSettingsCQ addOrderBy_UpdateTrace_Desc() { regOBD("UPDATE_TRACE"); return this; }

    // ===================================================================================
    //                                                             SpecifiedDerivedOrderBy
    //                                                             =======================
    /**
     * Add order-by for specified derived column as ascend.
     * <pre>
     * cb.specify().derivedPurchaseList().max(new SubQuery&lt;PurchaseCB&gt;() {
     *     public void query(PurchaseCB subCB) {
     *         subCB.specify().columnPurchaseDatetime();
     *     }
     * }, <span style="color: #CC4747">aliasName</span>);
     * <span style="color: #3F7E5E">// order by [alias-name] asc</span>
     * cb.<span style="color: #CC4747">addSpecifiedDerivedOrderBy_Asc</span>(<span style="color: #CC4747">aliasName</span>);
     * </pre>
     * @param aliasName The alias name specified at (Specify)DerivedReferrer. (NotNull)
     * @return this. (NotNull)
     */
    public BsVillageSettingsCQ addSpecifiedDerivedOrderBy_Asc(String aliasName) { registerSpecifiedDerivedOrderBy_Asc(aliasName); return this; }

    /**
     * Add order-by for specified derived column as descend.
     * <pre>
     * cb.specify().derivedPurchaseList().max(new SubQuery&lt;PurchaseCB&gt;() {
     *     public void query(PurchaseCB subCB) {
     *         subCB.specify().columnPurchaseDatetime();
     *     }
     * }, <span style="color: #CC4747">aliasName</span>);
     * <span style="color: #3F7E5E">// order by [alias-name] desc</span>
     * cb.<span style="color: #CC4747">addSpecifiedDerivedOrderBy_Desc</span>(<span style="color: #CC4747">aliasName</span>);
     * </pre>
     * @param aliasName The alias name specified at (Specify)DerivedReferrer. (NotNull)
     * @return this. (NotNull)
     */
    public BsVillageSettingsCQ addSpecifiedDerivedOrderBy_Desc(String aliasName) { registerSpecifiedDerivedOrderBy_Desc(aliasName); return this; }

    // ===================================================================================
    //                                                                         Union Query
    //                                                                         ===========
    public void reflectRelationOnUnionQuery(ConditionQuery bqs, ConditionQuery uqs) {
        VillageSettingsCQ bq = (VillageSettingsCQ)bqs;
        VillageSettingsCQ uq = (VillageSettingsCQ)uqs;
        if (bq.hasConditionQueryAllowedSecretSay()) {
            uq.queryAllowedSecretSay().reflectRelationOnUnionQuery(bq.queryAllowedSecretSay(), uq.queryAllowedSecretSay());
        }
        if (bq.hasConditionQueryCharaGroup()) {
            uq.queryCharaGroup().reflectRelationOnUnionQuery(bq.queryCharaGroup(), uq.queryCharaGroup());
        }
        if (bq.hasConditionQueryVillage()) {
            uq.queryVillage().reflectRelationOnUnionQuery(bq.queryVillage(), uq.queryVillage());
        }
    }

    // ===================================================================================
    //                                                                       Foreign Query
    //                                                                       =============
    /**
     * Get the condition-query for relation table. <br>
     * ALLOWED_SECRET_SAY by my ALLOWED_SECRET_SAY_CODE, named 'allowedSecretSay'.
     * @return The instance of condition-query. (NotNull)
     */
    public AllowedSecretSayCQ queryAllowedSecretSay() {
        return xdfgetConditionQueryAllowedSecretSay();
    }
    public AllowedSecretSayCQ xdfgetConditionQueryAllowedSecretSay() {
        String prop = "allowedSecretSay";
        if (!xhasQueRlMap(prop)) { xregQueRl(prop, xcreateQueryAllowedSecretSay()); xsetupOuterJoinAllowedSecretSay(); }
        return xgetQueRlMap(prop);
    }
    protected AllowedSecretSayCQ xcreateQueryAllowedSecretSay() {
        String nrp = xresolveNRP("village_settings", "allowedSecretSay"); String jan = xresolveJAN(nrp, xgetNNLvl());
        return xinitRelCQ(new AllowedSecretSayCQ(this, xgetSqlClause(), jan, xgetNNLvl()), _baseCB, "allowedSecretSay", nrp);
    }
    protected void xsetupOuterJoinAllowedSecretSay() { xregOutJo("allowedSecretSay"); }
    public boolean hasConditionQueryAllowedSecretSay() { return xhasQueRlMap("allowedSecretSay"); }

    /**
     * Get the condition-query for relation table. <br>
     * CHARA_GROUP by my CHARACTER_GROUP_ID, named 'charaGroup'.
     * @return The instance of condition-query. (NotNull)
     */
    public CharaGroupCQ queryCharaGroup() {
        return xdfgetConditionQueryCharaGroup();
    }
    public CharaGroupCQ xdfgetConditionQueryCharaGroup() {
        String prop = "charaGroup";
        if (!xhasQueRlMap(prop)) { xregQueRl(prop, xcreateQueryCharaGroup()); xsetupOuterJoinCharaGroup(); }
        return xgetQueRlMap(prop);
    }
    protected CharaGroupCQ xcreateQueryCharaGroup() {
        String nrp = xresolveNRP("village_settings", "charaGroup"); String jan = xresolveJAN(nrp, xgetNNLvl());
        return xinitRelCQ(new CharaGroupCQ(this, xgetSqlClause(), jan, xgetNNLvl()), _baseCB, "charaGroup", nrp);
    }
    protected void xsetupOuterJoinCharaGroup() { xregOutJo("charaGroup"); }
    public boolean hasConditionQueryCharaGroup() { return xhasQueRlMap("charaGroup"); }

    /**
     * Get the condition-query for relation table. <br>
     * VILLAGE by my VILLAGE_ID, named 'village'.
     * @return The instance of condition-query. (NotNull)
     */
    public VillageCQ queryVillage() {
        return xdfgetConditionQueryVillage();
    }
    public VillageCQ xdfgetConditionQueryVillage() {
        String prop = "village";
        if (!xhasQueRlMap(prop)) { xregQueRl(prop, xcreateQueryVillage()); xsetupOuterJoinVillage(); }
        return xgetQueRlMap(prop);
    }
    protected VillageCQ xcreateQueryVillage() {
        String nrp = xresolveNRP("village_settings", "village"); String jan = xresolveJAN(nrp, xgetNNLvl());
        return xinitRelCQ(new VillageCQ(this, xgetSqlClause(), jan, xgetNNLvl()), _baseCB, "village", nrp);
    }
    protected void xsetupOuterJoinVillage() { xregOutJo("village"); }
    public boolean hasConditionQueryVillage() { return xhasQueRlMap("village"); }

    protected Map<String, Object> xfindFixedConditionDynamicParameterMap(String property) {
        return null;
    }

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    public Map<String, VillageSettingsCQ> xdfgetScalarCondition() { return xgetSQueMap("scalarCondition"); }
    public String keepScalarCondition(VillageSettingsCQ sq) { return xkeepSQue("scalarCondition", sq); }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public Map<String, VillageSettingsCQ> xdfgetSpecifyMyselfDerived() { return xgetSQueMap("specifyMyselfDerived"); }
    public String keepSpecifyMyselfDerived(VillageSettingsCQ sq) { return xkeepSQue("specifyMyselfDerived", sq); }

    public Map<String, VillageSettingsCQ> xdfgetQueryMyselfDerived() { return xgetSQueMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerived(VillageSettingsCQ sq) { return xkeepSQue("queryMyselfDerived", sq); }
    public Map<String, Object> xdfgetQueryMyselfDerivedParameter() { return xgetSQuePmMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerivedParameter(Object pm) { return xkeepSQuePm("queryMyselfDerived", pm); }

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    protected Map<String, VillageSettingsCQ> _myselfExistsMap;
    public Map<String, VillageSettingsCQ> xdfgetMyselfExists() { return xgetSQueMap("myselfExists"); }
    public String keepMyselfExists(VillageSettingsCQ sq) { return xkeepSQue("myselfExists", sq); }

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    public Map<String, VillageSettingsCQ> xdfgetMyselfInScope() { return xgetSQueMap("myselfInScope"); }
    public String keepMyselfInScope(VillageSettingsCQ sq) { return xkeepSQue("myselfInScope", sq); }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xCB() { return VillageSettingsCB.class.getName(); }
    protected String xCQ() { return VillageSettingsCQ.class.getName(); }
    protected String xCHp() { return HpQDRFunction.class.getName(); }
    protected String xCOp() { return ConditionOption.class.getName(); }
    protected String xMap() { return Map.class.getName(); }
}
