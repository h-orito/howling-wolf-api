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
 * The base condition-query of village_player.
 * @author DBFlute(AutoGenerator)
 */
public class BsVillagePlayerCQ extends AbstractBsVillagePlayerCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected VillagePlayerCIQ _inlineQuery;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsVillagePlayerCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                 InlineView/OrClause
    //                                                                 ===================
    /**
     * Prepare InlineView query. <br>
     * {select ... from ... left outer join (select * from village_player) where FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">inline()</span>.setFoo...;
     * </pre>
     * @return The condition-query for InlineView query. (NotNull)
     */
    public VillagePlayerCIQ inline() {
        if (_inlineQuery == null) { _inlineQuery = xcreateCIQ(); }
        _inlineQuery.xsetOnClause(false); return _inlineQuery;
    }

    protected VillagePlayerCIQ xcreateCIQ() {
        VillagePlayerCIQ ciq = xnewCIQ();
        ciq.xsetBaseCB(_baseCB);
        return ciq;
    }

    protected VillagePlayerCIQ xnewCIQ() {
        return new VillagePlayerCIQ(xgetReferrerQuery(), xgetSqlClause(), xgetAliasName(), xgetNestLevel(), this);
    }

    /**
     * Prepare OnClause query. <br>
     * {select ... from ... left outer join village_player on ... and FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">on()</span>.setFoo...;
     * </pre>
     * @return The condition-query for OnClause query. (NotNull)
     * @throws IllegalConditionBeanOperationException When this condition-query is base query.
     */
    public VillagePlayerCIQ on() {
        if (isBaseQuery()) { throw new IllegalConditionBeanOperationException("OnClause for local table is unavailable!"); }
        VillagePlayerCIQ inlineQuery = inline(); inlineQuery.xsetOnClause(true); return inlineQuery;
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    protected ConditionValue _villagePlayerId;
    public ConditionValue xdfgetVillagePlayerId()
    { if (_villagePlayerId == null) { _villagePlayerId = nCV(); }
      return _villagePlayerId; }
    protected ConditionValue xgetCValueVillagePlayerId() { return xdfgetVillagePlayerId(); }

    public Map<String, AbilityCQ> xdfgetVillagePlayerId_ExistsReferrer_AbilityByTargetVillagePlayerIdList() { return xgetSQueMap("villagePlayerId_ExistsReferrer_AbilityByTargetVillagePlayerIdList"); }
    public String keepVillagePlayerId_ExistsReferrer_AbilityByTargetVillagePlayerIdList(AbilityCQ sq) { return xkeepSQue("villagePlayerId_ExistsReferrer_AbilityByTargetVillagePlayerIdList", sq); }

    public Map<String, AbilityCQ> xdfgetVillagePlayerId_ExistsReferrer_AbilityByVillagePlayerIdList() { return xgetSQueMap("villagePlayerId_ExistsReferrer_AbilityByVillagePlayerIdList"); }
    public String keepVillagePlayerId_ExistsReferrer_AbilityByVillagePlayerIdList(AbilityCQ sq) { return xkeepSQue("villagePlayerId_ExistsReferrer_AbilityByVillagePlayerIdList", sq); }

    public Map<String, ComingOutCQ> xdfgetVillagePlayerId_ExistsReferrer_ComingOutList() { return xgetSQueMap("villagePlayerId_ExistsReferrer_ComingOutList"); }
    public String keepVillagePlayerId_ExistsReferrer_ComingOutList(ComingOutCQ sq) { return xkeepSQue("villagePlayerId_ExistsReferrer_ComingOutList", sq); }

    public Map<String, CommitCQ> xdfgetVillagePlayerId_ExistsReferrer_CommitList() { return xgetSQueMap("villagePlayerId_ExistsReferrer_CommitList"); }
    public String keepVillagePlayerId_ExistsReferrer_CommitList(CommitCQ sq) { return xkeepSQue("villagePlayerId_ExistsReferrer_CommitList", sq); }

    public Map<String, VoteCQ> xdfgetVillagePlayerId_ExistsReferrer_VoteByTargetVillagePlayerIdList() { return xgetSQueMap("villagePlayerId_ExistsReferrer_VoteByTargetVillagePlayerIdList"); }
    public String keepVillagePlayerId_ExistsReferrer_VoteByTargetVillagePlayerIdList(VoteCQ sq) { return xkeepSQue("villagePlayerId_ExistsReferrer_VoteByTargetVillagePlayerIdList", sq); }

    public Map<String, VoteCQ> xdfgetVillagePlayerId_ExistsReferrer_VoteByVillagePlayerIdList() { return xgetSQueMap("villagePlayerId_ExistsReferrer_VoteByVillagePlayerIdList"); }
    public String keepVillagePlayerId_ExistsReferrer_VoteByVillagePlayerIdList(VoteCQ sq) { return xkeepSQue("villagePlayerId_ExistsReferrer_VoteByVillagePlayerIdList", sq); }

    public Map<String, AbilityCQ> xdfgetVillagePlayerId_NotExistsReferrer_AbilityByTargetVillagePlayerIdList() { return xgetSQueMap("villagePlayerId_NotExistsReferrer_AbilityByTargetVillagePlayerIdList"); }
    public String keepVillagePlayerId_NotExistsReferrer_AbilityByTargetVillagePlayerIdList(AbilityCQ sq) { return xkeepSQue("villagePlayerId_NotExistsReferrer_AbilityByTargetVillagePlayerIdList", sq); }

    public Map<String, AbilityCQ> xdfgetVillagePlayerId_NotExistsReferrer_AbilityByVillagePlayerIdList() { return xgetSQueMap("villagePlayerId_NotExistsReferrer_AbilityByVillagePlayerIdList"); }
    public String keepVillagePlayerId_NotExistsReferrer_AbilityByVillagePlayerIdList(AbilityCQ sq) { return xkeepSQue("villagePlayerId_NotExistsReferrer_AbilityByVillagePlayerIdList", sq); }

    public Map<String, ComingOutCQ> xdfgetVillagePlayerId_NotExistsReferrer_ComingOutList() { return xgetSQueMap("villagePlayerId_NotExistsReferrer_ComingOutList"); }
    public String keepVillagePlayerId_NotExistsReferrer_ComingOutList(ComingOutCQ sq) { return xkeepSQue("villagePlayerId_NotExistsReferrer_ComingOutList", sq); }

    public Map<String, CommitCQ> xdfgetVillagePlayerId_NotExistsReferrer_CommitList() { return xgetSQueMap("villagePlayerId_NotExistsReferrer_CommitList"); }
    public String keepVillagePlayerId_NotExistsReferrer_CommitList(CommitCQ sq) { return xkeepSQue("villagePlayerId_NotExistsReferrer_CommitList", sq); }

    public Map<String, VoteCQ> xdfgetVillagePlayerId_NotExistsReferrer_VoteByTargetVillagePlayerIdList() { return xgetSQueMap("villagePlayerId_NotExistsReferrer_VoteByTargetVillagePlayerIdList"); }
    public String keepVillagePlayerId_NotExistsReferrer_VoteByTargetVillagePlayerIdList(VoteCQ sq) { return xkeepSQue("villagePlayerId_NotExistsReferrer_VoteByTargetVillagePlayerIdList", sq); }

    public Map<String, VoteCQ> xdfgetVillagePlayerId_NotExistsReferrer_VoteByVillagePlayerIdList() { return xgetSQueMap("villagePlayerId_NotExistsReferrer_VoteByVillagePlayerIdList"); }
    public String keepVillagePlayerId_NotExistsReferrer_VoteByVillagePlayerIdList(VoteCQ sq) { return xkeepSQue("villagePlayerId_NotExistsReferrer_VoteByVillagePlayerIdList", sq); }

    public Map<String, AbilityCQ> xdfgetVillagePlayerId_SpecifyDerivedReferrer_AbilityByTargetVillagePlayerIdList() { return xgetSQueMap("villagePlayerId_SpecifyDerivedReferrer_AbilityByTargetVillagePlayerIdList"); }
    public String keepVillagePlayerId_SpecifyDerivedReferrer_AbilityByTargetVillagePlayerIdList(AbilityCQ sq) { return xkeepSQue("villagePlayerId_SpecifyDerivedReferrer_AbilityByTargetVillagePlayerIdList", sq); }

    public Map<String, AbilityCQ> xdfgetVillagePlayerId_SpecifyDerivedReferrer_AbilityByVillagePlayerIdList() { return xgetSQueMap("villagePlayerId_SpecifyDerivedReferrer_AbilityByVillagePlayerIdList"); }
    public String keepVillagePlayerId_SpecifyDerivedReferrer_AbilityByVillagePlayerIdList(AbilityCQ sq) { return xkeepSQue("villagePlayerId_SpecifyDerivedReferrer_AbilityByVillagePlayerIdList", sq); }

    public Map<String, ComingOutCQ> xdfgetVillagePlayerId_SpecifyDerivedReferrer_ComingOutList() { return xgetSQueMap("villagePlayerId_SpecifyDerivedReferrer_ComingOutList"); }
    public String keepVillagePlayerId_SpecifyDerivedReferrer_ComingOutList(ComingOutCQ sq) { return xkeepSQue("villagePlayerId_SpecifyDerivedReferrer_ComingOutList", sq); }

    public Map<String, CommitCQ> xdfgetVillagePlayerId_SpecifyDerivedReferrer_CommitList() { return xgetSQueMap("villagePlayerId_SpecifyDerivedReferrer_CommitList"); }
    public String keepVillagePlayerId_SpecifyDerivedReferrer_CommitList(CommitCQ sq) { return xkeepSQue("villagePlayerId_SpecifyDerivedReferrer_CommitList", sq); }

    public Map<String, VoteCQ> xdfgetVillagePlayerId_SpecifyDerivedReferrer_VoteByTargetVillagePlayerIdList() { return xgetSQueMap("villagePlayerId_SpecifyDerivedReferrer_VoteByTargetVillagePlayerIdList"); }
    public String keepVillagePlayerId_SpecifyDerivedReferrer_VoteByTargetVillagePlayerIdList(VoteCQ sq) { return xkeepSQue("villagePlayerId_SpecifyDerivedReferrer_VoteByTargetVillagePlayerIdList", sq); }

    public Map<String, VoteCQ> xdfgetVillagePlayerId_SpecifyDerivedReferrer_VoteByVillagePlayerIdList() { return xgetSQueMap("villagePlayerId_SpecifyDerivedReferrer_VoteByVillagePlayerIdList"); }
    public String keepVillagePlayerId_SpecifyDerivedReferrer_VoteByVillagePlayerIdList(VoteCQ sq) { return xkeepSQue("villagePlayerId_SpecifyDerivedReferrer_VoteByVillagePlayerIdList", sq); }

    public Map<String, AbilityCQ> xdfgetVillagePlayerId_QueryDerivedReferrer_AbilityByTargetVillagePlayerIdList() { return xgetSQueMap("villagePlayerId_QueryDerivedReferrer_AbilityByTargetVillagePlayerIdList"); }
    public String keepVillagePlayerId_QueryDerivedReferrer_AbilityByTargetVillagePlayerIdList(AbilityCQ sq) { return xkeepSQue("villagePlayerId_QueryDerivedReferrer_AbilityByTargetVillagePlayerIdList", sq); }
    public Map<String, Object> xdfgetVillagePlayerId_QueryDerivedReferrer_AbilityByTargetVillagePlayerIdListParameter() { return xgetSQuePmMap("villagePlayerId_QueryDerivedReferrer_AbilityByTargetVillagePlayerIdList"); }
    public String keepVillagePlayerId_QueryDerivedReferrer_AbilityByTargetVillagePlayerIdListParameter(Object pm) { return xkeepSQuePm("villagePlayerId_QueryDerivedReferrer_AbilityByTargetVillagePlayerIdList", pm); }

    public Map<String, AbilityCQ> xdfgetVillagePlayerId_QueryDerivedReferrer_AbilityByVillagePlayerIdList() { return xgetSQueMap("villagePlayerId_QueryDerivedReferrer_AbilityByVillagePlayerIdList"); }
    public String keepVillagePlayerId_QueryDerivedReferrer_AbilityByVillagePlayerIdList(AbilityCQ sq) { return xkeepSQue("villagePlayerId_QueryDerivedReferrer_AbilityByVillagePlayerIdList", sq); }
    public Map<String, Object> xdfgetVillagePlayerId_QueryDerivedReferrer_AbilityByVillagePlayerIdListParameter() { return xgetSQuePmMap("villagePlayerId_QueryDerivedReferrer_AbilityByVillagePlayerIdList"); }
    public String keepVillagePlayerId_QueryDerivedReferrer_AbilityByVillagePlayerIdListParameter(Object pm) { return xkeepSQuePm("villagePlayerId_QueryDerivedReferrer_AbilityByVillagePlayerIdList", pm); }

    public Map<String, ComingOutCQ> xdfgetVillagePlayerId_QueryDerivedReferrer_ComingOutList() { return xgetSQueMap("villagePlayerId_QueryDerivedReferrer_ComingOutList"); }
    public String keepVillagePlayerId_QueryDerivedReferrer_ComingOutList(ComingOutCQ sq) { return xkeepSQue("villagePlayerId_QueryDerivedReferrer_ComingOutList", sq); }
    public Map<String, Object> xdfgetVillagePlayerId_QueryDerivedReferrer_ComingOutListParameter() { return xgetSQuePmMap("villagePlayerId_QueryDerivedReferrer_ComingOutList"); }
    public String keepVillagePlayerId_QueryDerivedReferrer_ComingOutListParameter(Object pm) { return xkeepSQuePm("villagePlayerId_QueryDerivedReferrer_ComingOutList", pm); }

    public Map<String, CommitCQ> xdfgetVillagePlayerId_QueryDerivedReferrer_CommitList() { return xgetSQueMap("villagePlayerId_QueryDerivedReferrer_CommitList"); }
    public String keepVillagePlayerId_QueryDerivedReferrer_CommitList(CommitCQ sq) { return xkeepSQue("villagePlayerId_QueryDerivedReferrer_CommitList", sq); }
    public Map<String, Object> xdfgetVillagePlayerId_QueryDerivedReferrer_CommitListParameter() { return xgetSQuePmMap("villagePlayerId_QueryDerivedReferrer_CommitList"); }
    public String keepVillagePlayerId_QueryDerivedReferrer_CommitListParameter(Object pm) { return xkeepSQuePm("villagePlayerId_QueryDerivedReferrer_CommitList", pm); }

    public Map<String, VoteCQ> xdfgetVillagePlayerId_QueryDerivedReferrer_VoteByTargetVillagePlayerIdList() { return xgetSQueMap("villagePlayerId_QueryDerivedReferrer_VoteByTargetVillagePlayerIdList"); }
    public String keepVillagePlayerId_QueryDerivedReferrer_VoteByTargetVillagePlayerIdList(VoteCQ sq) { return xkeepSQue("villagePlayerId_QueryDerivedReferrer_VoteByTargetVillagePlayerIdList", sq); }
    public Map<String, Object> xdfgetVillagePlayerId_QueryDerivedReferrer_VoteByTargetVillagePlayerIdListParameter() { return xgetSQuePmMap("villagePlayerId_QueryDerivedReferrer_VoteByTargetVillagePlayerIdList"); }
    public String keepVillagePlayerId_QueryDerivedReferrer_VoteByTargetVillagePlayerIdListParameter(Object pm) { return xkeepSQuePm("villagePlayerId_QueryDerivedReferrer_VoteByTargetVillagePlayerIdList", pm); }

    public Map<String, VoteCQ> xdfgetVillagePlayerId_QueryDerivedReferrer_VoteByVillagePlayerIdList() { return xgetSQueMap("villagePlayerId_QueryDerivedReferrer_VoteByVillagePlayerIdList"); }
    public String keepVillagePlayerId_QueryDerivedReferrer_VoteByVillagePlayerIdList(VoteCQ sq) { return xkeepSQue("villagePlayerId_QueryDerivedReferrer_VoteByVillagePlayerIdList", sq); }
    public Map<String, Object> xdfgetVillagePlayerId_QueryDerivedReferrer_VoteByVillagePlayerIdListParameter() { return xgetSQuePmMap("villagePlayerId_QueryDerivedReferrer_VoteByVillagePlayerIdList"); }
    public String keepVillagePlayerId_QueryDerivedReferrer_VoteByVillagePlayerIdListParameter(Object pm) { return xkeepSQuePm("villagePlayerId_QueryDerivedReferrer_VoteByVillagePlayerIdList", pm); }

    /**
     * Add order-by as ascend. <br>
     * VILLAGE_PLAYER_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @return this. (NotNull)
     */
    public BsVillagePlayerCQ addOrderBy_VillagePlayerId_Asc() { regOBA("VILLAGE_PLAYER_ID"); return this; }

    /**
     * Add order-by as descend. <br>
     * VILLAGE_PLAYER_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @return this. (NotNull)
     */
    public BsVillagePlayerCQ addOrderBy_VillagePlayerId_Desc() { regOBD("VILLAGE_PLAYER_ID"); return this; }

    protected ConditionValue _villageId;
    public ConditionValue xdfgetVillageId()
    { if (_villageId == null) { _villageId = nCV(); }
      return _villageId; }
    protected ConditionValue xgetCValueVillageId() { return xdfgetVillageId(); }

    /**
     * Add order-by as ascend. <br>
     * VILLAGE_ID: {IX, NotNull, INT UNSIGNED(10), FK to village}
     * @return this. (NotNull)
     */
    public BsVillagePlayerCQ addOrderBy_VillageId_Asc() { regOBA("VILLAGE_ID"); return this; }

    /**
     * Add order-by as descend. <br>
     * VILLAGE_ID: {IX, NotNull, INT UNSIGNED(10), FK to village}
     * @return this. (NotNull)
     */
    public BsVillagePlayerCQ addOrderBy_VillageId_Desc() { regOBD("VILLAGE_ID"); return this; }

    protected ConditionValue _playerId;
    public ConditionValue xdfgetPlayerId()
    { if (_playerId == null) { _playerId = nCV(); }
      return _playerId; }
    protected ConditionValue xgetCValuePlayerId() { return xdfgetPlayerId(); }

    /**
     * Add order-by as ascend. <br>
     * PLAYER_ID: {IX, NotNull, INT UNSIGNED(10), FK to player}
     * @return this. (NotNull)
     */
    public BsVillagePlayerCQ addOrderBy_PlayerId_Asc() { regOBA("PLAYER_ID"); return this; }

    /**
     * Add order-by as descend. <br>
     * PLAYER_ID: {IX, NotNull, INT UNSIGNED(10), FK to player}
     * @return this. (NotNull)
     */
    public BsVillagePlayerCQ addOrderBy_PlayerId_Desc() { regOBD("PLAYER_ID"); return this; }

    protected ConditionValue _charaId;
    public ConditionValue xdfgetCharaId()
    { if (_charaId == null) { _charaId = nCV(); }
      return _charaId; }
    protected ConditionValue xgetCValueCharaId() { return xdfgetCharaId(); }

    /**
     * Add order-by as ascend. <br>
     * CHARA_ID: {IX, NotNull, INT UNSIGNED(10), FK to chara}
     * @return this. (NotNull)
     */
    public BsVillagePlayerCQ addOrderBy_CharaId_Asc() { regOBA("CHARA_ID"); return this; }

    /**
     * Add order-by as descend. <br>
     * CHARA_ID: {IX, NotNull, INT UNSIGNED(10), FK to chara}
     * @return this. (NotNull)
     */
    public BsVillagePlayerCQ addOrderBy_CharaId_Desc() { regOBD("CHARA_ID"); return this; }

    protected ConditionValue _skillCode;
    public ConditionValue xdfgetSkillCode()
    { if (_skillCode == null) { _skillCode = nCV(); }
      return _skillCode; }
    protected ConditionValue xgetCValueSkillCode() { return xdfgetSkillCode(); }

    /**
     * Add order-by as ascend. <br>
     * SKILL_CODE: {IX, VARCHAR(20), FK to skill, classification=Skill}
     * @return this. (NotNull)
     */
    public BsVillagePlayerCQ addOrderBy_SkillCode_Asc() { regOBA("SKILL_CODE"); return this; }

    /**
     * Add order-by as descend. <br>
     * SKILL_CODE: {IX, VARCHAR(20), FK to skill, classification=Skill}
     * @return this. (NotNull)
     */
    public BsVillagePlayerCQ addOrderBy_SkillCode_Desc() { regOBD("SKILL_CODE"); return this; }

    protected ConditionValue _requestSkillCode;
    public ConditionValue xdfgetRequestSkillCode()
    { if (_requestSkillCode == null) { _requestSkillCode = nCV(); }
      return _requestSkillCode; }
    protected ConditionValue xgetCValueRequestSkillCode() { return xdfgetRequestSkillCode(); }

    /**
     * Add order-by as ascend. <br>
     * REQUEST_SKILL_CODE: {IX, VARCHAR(20), FK to skill, classification=Skill}
     * @return this. (NotNull)
     */
    public BsVillagePlayerCQ addOrderBy_RequestSkillCode_Asc() { regOBA("REQUEST_SKILL_CODE"); return this; }

    /**
     * Add order-by as descend. <br>
     * REQUEST_SKILL_CODE: {IX, VARCHAR(20), FK to skill, classification=Skill}
     * @return this. (NotNull)
     */
    public BsVillagePlayerCQ addOrderBy_RequestSkillCode_Desc() { regOBD("REQUEST_SKILL_CODE"); return this; }

    protected ConditionValue _secondRequestSkillCode;
    public ConditionValue xdfgetSecondRequestSkillCode()
    { if (_secondRequestSkillCode == null) { _secondRequestSkillCode = nCV(); }
      return _secondRequestSkillCode; }
    protected ConditionValue xgetCValueSecondRequestSkillCode() { return xdfgetSecondRequestSkillCode(); }

    /**
     * Add order-by as ascend. <br>
     * SECOND_REQUEST_SKILL_CODE: {IX, VARCHAR(20), FK to skill, classification=Skill}
     * @return this. (NotNull)
     */
    public BsVillagePlayerCQ addOrderBy_SecondRequestSkillCode_Asc() { regOBA("SECOND_REQUEST_SKILL_CODE"); return this; }

    /**
     * Add order-by as descend. <br>
     * SECOND_REQUEST_SKILL_CODE: {IX, VARCHAR(20), FK to skill, classification=Skill}
     * @return this. (NotNull)
     */
    public BsVillagePlayerCQ addOrderBy_SecondRequestSkillCode_Desc() { regOBD("SECOND_REQUEST_SKILL_CODE"); return this; }

    protected ConditionValue _isDead;
    public ConditionValue xdfgetIsDead()
    { if (_isDead == null) { _isDead = nCV(); }
      return _isDead; }
    protected ConditionValue xgetCValueIsDead() { return xdfgetIsDead(); }

    /**
     * Add order-by as ascend. <br>
     * IS_DEAD: {NotNull, BIT}
     * @return this. (NotNull)
     */
    public BsVillagePlayerCQ addOrderBy_IsDead_Asc() { regOBA("IS_DEAD"); return this; }

    /**
     * Add order-by as descend. <br>
     * IS_DEAD: {NotNull, BIT}
     * @return this. (NotNull)
     */
    public BsVillagePlayerCQ addOrderBy_IsDead_Desc() { regOBD("IS_DEAD"); return this; }

    protected ConditionValue _isSpectator;
    public ConditionValue xdfgetIsSpectator()
    { if (_isSpectator == null) { _isSpectator = nCV(); }
      return _isSpectator; }
    protected ConditionValue xgetCValueIsSpectator() { return xdfgetIsSpectator(); }

    /**
     * Add order-by as ascend. <br>
     * IS_SPECTATOR: {NotNull, BIT}
     * @return this. (NotNull)
     */
    public BsVillagePlayerCQ addOrderBy_IsSpectator_Asc() { regOBA("IS_SPECTATOR"); return this; }

    /**
     * Add order-by as descend. <br>
     * IS_SPECTATOR: {NotNull, BIT}
     * @return this. (NotNull)
     */
    public BsVillagePlayerCQ addOrderBy_IsSpectator_Desc() { regOBD("IS_SPECTATOR"); return this; }

    protected ConditionValue _deadReasonCode;
    public ConditionValue xdfgetDeadReasonCode()
    { if (_deadReasonCode == null) { _deadReasonCode = nCV(); }
      return _deadReasonCode; }
    protected ConditionValue xgetCValueDeadReasonCode() { return xdfgetDeadReasonCode(); }

    /**
     * Add order-by as ascend. <br>
     * DEAD_REASON_CODE: {IX, VARCHAR(20), FK to dead_reason, classification=DeadReason}
     * @return this. (NotNull)
     */
    public BsVillagePlayerCQ addOrderBy_DeadReasonCode_Asc() { regOBA("DEAD_REASON_CODE"); return this; }

    /**
     * Add order-by as descend. <br>
     * DEAD_REASON_CODE: {IX, VARCHAR(20), FK to dead_reason, classification=DeadReason}
     * @return this. (NotNull)
     */
    public BsVillagePlayerCQ addOrderBy_DeadReasonCode_Desc() { regOBD("DEAD_REASON_CODE"); return this; }

    protected ConditionValue _deadVillageDayId;
    public ConditionValue xdfgetDeadVillageDayId()
    { if (_deadVillageDayId == null) { _deadVillageDayId = nCV(); }
      return _deadVillageDayId; }
    protected ConditionValue xgetCValueDeadVillageDayId() { return xdfgetDeadVillageDayId(); }

    /**
     * Add order-by as ascend. <br>
     * DEAD_VILLAGE_DAY_ID: {IX, INT UNSIGNED(10), FK to village_day}
     * @return this. (NotNull)
     */
    public BsVillagePlayerCQ addOrderBy_DeadVillageDayId_Asc() { regOBA("DEAD_VILLAGE_DAY_ID"); return this; }

    /**
     * Add order-by as descend. <br>
     * DEAD_VILLAGE_DAY_ID: {IX, INT UNSIGNED(10), FK to village_day}
     * @return this. (NotNull)
     */
    public BsVillagePlayerCQ addOrderBy_DeadVillageDayId_Desc() { regOBD("DEAD_VILLAGE_DAY_ID"); return this; }

    protected ConditionValue _isGone;
    public ConditionValue xdfgetIsGone()
    { if (_isGone == null) { _isGone = nCV(); }
      return _isGone; }
    protected ConditionValue xgetCValueIsGone() { return xdfgetIsGone(); }

    /**
     * Add order-by as ascend. <br>
     * IS_GONE: {NotNull, BIT}
     * @return this. (NotNull)
     */
    public BsVillagePlayerCQ addOrderBy_IsGone_Asc() { regOBA("IS_GONE"); return this; }

    /**
     * Add order-by as descend. <br>
     * IS_GONE: {NotNull, BIT}
     * @return this. (NotNull)
     */
    public BsVillagePlayerCQ addOrderBy_IsGone_Desc() { regOBD("IS_GONE"); return this; }

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
    public BsVillagePlayerCQ addOrderBy_RegisterDatetime_Asc() { regOBA("REGISTER_DATETIME"); return this; }

    /**
     * Add order-by as descend. <br>
     * REGISTER_DATETIME: {NotNull, DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsVillagePlayerCQ addOrderBy_RegisterDatetime_Desc() { regOBD("REGISTER_DATETIME"); return this; }

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
    public BsVillagePlayerCQ addOrderBy_RegisterTrace_Asc() { regOBA("REGISTER_TRACE"); return this; }

    /**
     * Add order-by as descend. <br>
     * REGISTER_TRACE: {NotNull, VARCHAR(64)}
     * @return this. (NotNull)
     */
    public BsVillagePlayerCQ addOrderBy_RegisterTrace_Desc() { regOBD("REGISTER_TRACE"); return this; }

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
    public BsVillagePlayerCQ addOrderBy_UpdateDatetime_Asc() { regOBA("UPDATE_DATETIME"); return this; }

    /**
     * Add order-by as descend. <br>
     * UPDATE_DATETIME: {NotNull, DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsVillagePlayerCQ addOrderBy_UpdateDatetime_Desc() { regOBD("UPDATE_DATETIME"); return this; }

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
    public BsVillagePlayerCQ addOrderBy_UpdateTrace_Asc() { regOBA("UPDATE_TRACE"); return this; }

    /**
     * Add order-by as descend. <br>
     * UPDATE_TRACE: {NotNull, VARCHAR(64)}
     * @return this. (NotNull)
     */
    public BsVillagePlayerCQ addOrderBy_UpdateTrace_Desc() { regOBD("UPDATE_TRACE"); return this; }

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
    public BsVillagePlayerCQ addSpecifiedDerivedOrderBy_Asc(String aliasName) { registerSpecifiedDerivedOrderBy_Asc(aliasName); return this; }

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
    public BsVillagePlayerCQ addSpecifiedDerivedOrderBy_Desc(String aliasName) { registerSpecifiedDerivedOrderBy_Desc(aliasName); return this; }

    // ===================================================================================
    //                                                                         Union Query
    //                                                                         ===========
    public void reflectRelationOnUnionQuery(ConditionQuery bqs, ConditionQuery uqs) {
        VillagePlayerCQ bq = (VillagePlayerCQ)bqs;
        VillagePlayerCQ uq = (VillagePlayerCQ)uqs;
        if (bq.hasConditionQueryChara()) {
            uq.queryChara().reflectRelationOnUnionQuery(bq.queryChara(), uq.queryChara());
        }
        if (bq.hasConditionQueryDeadReason()) {
            uq.queryDeadReason().reflectRelationOnUnionQuery(bq.queryDeadReason(), uq.queryDeadReason());
        }
        if (bq.hasConditionQueryVillageDay()) {
            uq.queryVillageDay().reflectRelationOnUnionQuery(bq.queryVillageDay(), uq.queryVillageDay());
        }
        if (bq.hasConditionQueryPlayer()) {
            uq.queryPlayer().reflectRelationOnUnionQuery(bq.queryPlayer(), uq.queryPlayer());
        }
        if (bq.hasConditionQuerySkillByRequestSkillCode()) {
            uq.querySkillByRequestSkillCode().reflectRelationOnUnionQuery(bq.querySkillByRequestSkillCode(), uq.querySkillByRequestSkillCode());
        }
        if (bq.hasConditionQuerySkillBySecondRequestSkillCode()) {
            uq.querySkillBySecondRequestSkillCode().reflectRelationOnUnionQuery(bq.querySkillBySecondRequestSkillCode(), uq.querySkillBySecondRequestSkillCode());
        }
        if (bq.hasConditionQuerySkillBySkillCode()) {
            uq.querySkillBySkillCode().reflectRelationOnUnionQuery(bq.querySkillBySkillCode(), uq.querySkillBySkillCode());
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
     * CHARA by my CHARA_ID, named 'chara'.
     * @return The instance of condition-query. (NotNull)
     */
    public CharaCQ queryChara() {
        return xdfgetConditionQueryChara();
    }
    public CharaCQ xdfgetConditionQueryChara() {
        String prop = "chara";
        if (!xhasQueRlMap(prop)) { xregQueRl(prop, xcreateQueryChara()); xsetupOuterJoinChara(); }
        return xgetQueRlMap(prop);
    }
    protected CharaCQ xcreateQueryChara() {
        String nrp = xresolveNRP("village_player", "chara"); String jan = xresolveJAN(nrp, xgetNNLvl());
        return xinitRelCQ(new CharaCQ(this, xgetSqlClause(), jan, xgetNNLvl()), _baseCB, "chara", nrp);
    }
    protected void xsetupOuterJoinChara() { xregOutJo("chara"); }
    public boolean hasConditionQueryChara() { return xhasQueRlMap("chara"); }

    /**
     * Get the condition-query for relation table. <br>
     * DEAD_REASON by my DEAD_REASON_CODE, named 'deadReason'.
     * @return The instance of condition-query. (NotNull)
     */
    public DeadReasonCQ queryDeadReason() {
        return xdfgetConditionQueryDeadReason();
    }
    public DeadReasonCQ xdfgetConditionQueryDeadReason() {
        String prop = "deadReason";
        if (!xhasQueRlMap(prop)) { xregQueRl(prop, xcreateQueryDeadReason()); xsetupOuterJoinDeadReason(); }
        return xgetQueRlMap(prop);
    }
    protected DeadReasonCQ xcreateQueryDeadReason() {
        String nrp = xresolveNRP("village_player", "deadReason"); String jan = xresolveJAN(nrp, xgetNNLvl());
        return xinitRelCQ(new DeadReasonCQ(this, xgetSqlClause(), jan, xgetNNLvl()), _baseCB, "deadReason", nrp);
    }
    protected void xsetupOuterJoinDeadReason() { xregOutJo("deadReason"); }
    public boolean hasConditionQueryDeadReason() { return xhasQueRlMap("deadReason"); }

    /**
     * Get the condition-query for relation table. <br>
     * VILLAGE_DAY by my DEAD_VILLAGE_DAY_ID, named 'villageDay'.
     * @return The instance of condition-query. (NotNull)
     */
    public VillageDayCQ queryVillageDay() {
        return xdfgetConditionQueryVillageDay();
    }
    public VillageDayCQ xdfgetConditionQueryVillageDay() {
        String prop = "villageDay";
        if (!xhasQueRlMap(prop)) { xregQueRl(prop, xcreateQueryVillageDay()); xsetupOuterJoinVillageDay(); }
        return xgetQueRlMap(prop);
    }
    protected VillageDayCQ xcreateQueryVillageDay() {
        String nrp = xresolveNRP("village_player", "villageDay"); String jan = xresolveJAN(nrp, xgetNNLvl());
        return xinitRelCQ(new VillageDayCQ(this, xgetSqlClause(), jan, xgetNNLvl()), _baseCB, "villageDay", nrp);
    }
    protected void xsetupOuterJoinVillageDay() { xregOutJo("villageDay"); }
    public boolean hasConditionQueryVillageDay() { return xhasQueRlMap("villageDay"); }

    /**
     * Get the condition-query for relation table. <br>
     * PLAYER by my PLAYER_ID, named 'player'.
     * @return The instance of condition-query. (NotNull)
     */
    public PlayerCQ queryPlayer() {
        return xdfgetConditionQueryPlayer();
    }
    public PlayerCQ xdfgetConditionQueryPlayer() {
        String prop = "player";
        if (!xhasQueRlMap(prop)) { xregQueRl(prop, xcreateQueryPlayer()); xsetupOuterJoinPlayer(); }
        return xgetQueRlMap(prop);
    }
    protected PlayerCQ xcreateQueryPlayer() {
        String nrp = xresolveNRP("village_player", "player"); String jan = xresolveJAN(nrp, xgetNNLvl());
        return xinitRelCQ(new PlayerCQ(this, xgetSqlClause(), jan, xgetNNLvl()), _baseCB, "player", nrp);
    }
    protected void xsetupOuterJoinPlayer() { xregOutJo("player"); }
    public boolean hasConditionQueryPlayer() { return xhasQueRlMap("player"); }

    /**
     * Get the condition-query for relation table. <br>
     * SKILL by my REQUEST_SKILL_CODE, named 'skillByRequestSkillCode'.
     * @return The instance of condition-query. (NotNull)
     */
    public SkillCQ querySkillByRequestSkillCode() {
        return xdfgetConditionQuerySkillByRequestSkillCode();
    }
    public SkillCQ xdfgetConditionQuerySkillByRequestSkillCode() {
        String prop = "skillByRequestSkillCode";
        if (!xhasQueRlMap(prop)) { xregQueRl(prop, xcreateQuerySkillByRequestSkillCode()); xsetupOuterJoinSkillByRequestSkillCode(); }
        return xgetQueRlMap(prop);
    }
    protected SkillCQ xcreateQuerySkillByRequestSkillCode() {
        String nrp = xresolveNRP("village_player", "skillByRequestSkillCode"); String jan = xresolveJAN(nrp, xgetNNLvl());
        return xinitRelCQ(new SkillCQ(this, xgetSqlClause(), jan, xgetNNLvl()), _baseCB, "skillByRequestSkillCode", nrp);
    }
    protected void xsetupOuterJoinSkillByRequestSkillCode() { xregOutJo("skillByRequestSkillCode"); }
    public boolean hasConditionQuerySkillByRequestSkillCode() { return xhasQueRlMap("skillByRequestSkillCode"); }

    /**
     * Get the condition-query for relation table. <br>
     * SKILL by my SECOND_REQUEST_SKILL_CODE, named 'skillBySecondRequestSkillCode'.
     * @return The instance of condition-query. (NotNull)
     */
    public SkillCQ querySkillBySecondRequestSkillCode() {
        return xdfgetConditionQuerySkillBySecondRequestSkillCode();
    }
    public SkillCQ xdfgetConditionQuerySkillBySecondRequestSkillCode() {
        String prop = "skillBySecondRequestSkillCode";
        if (!xhasQueRlMap(prop)) { xregQueRl(prop, xcreateQuerySkillBySecondRequestSkillCode()); xsetupOuterJoinSkillBySecondRequestSkillCode(); }
        return xgetQueRlMap(prop);
    }
    protected SkillCQ xcreateQuerySkillBySecondRequestSkillCode() {
        String nrp = xresolveNRP("village_player", "skillBySecondRequestSkillCode"); String jan = xresolveJAN(nrp, xgetNNLvl());
        return xinitRelCQ(new SkillCQ(this, xgetSqlClause(), jan, xgetNNLvl()), _baseCB, "skillBySecondRequestSkillCode", nrp);
    }
    protected void xsetupOuterJoinSkillBySecondRequestSkillCode() { xregOutJo("skillBySecondRequestSkillCode"); }
    public boolean hasConditionQuerySkillBySecondRequestSkillCode() { return xhasQueRlMap("skillBySecondRequestSkillCode"); }

    /**
     * Get the condition-query for relation table. <br>
     * SKILL by my SKILL_CODE, named 'skillBySkillCode'.
     * @return The instance of condition-query. (NotNull)
     */
    public SkillCQ querySkillBySkillCode() {
        return xdfgetConditionQuerySkillBySkillCode();
    }
    public SkillCQ xdfgetConditionQuerySkillBySkillCode() {
        String prop = "skillBySkillCode";
        if (!xhasQueRlMap(prop)) { xregQueRl(prop, xcreateQuerySkillBySkillCode()); xsetupOuterJoinSkillBySkillCode(); }
        return xgetQueRlMap(prop);
    }
    protected SkillCQ xcreateQuerySkillBySkillCode() {
        String nrp = xresolveNRP("village_player", "skillBySkillCode"); String jan = xresolveJAN(nrp, xgetNNLvl());
        return xinitRelCQ(new SkillCQ(this, xgetSqlClause(), jan, xgetNNLvl()), _baseCB, "skillBySkillCode", nrp);
    }
    protected void xsetupOuterJoinSkillBySkillCode() { xregOutJo("skillBySkillCode"); }
    public boolean hasConditionQuerySkillBySkillCode() { return xhasQueRlMap("skillBySkillCode"); }

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
        String nrp = xresolveNRP("village_player", "village"); String jan = xresolveJAN(nrp, xgetNNLvl());
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
    public Map<String, VillagePlayerCQ> xdfgetScalarCondition() { return xgetSQueMap("scalarCondition"); }
    public String keepScalarCondition(VillagePlayerCQ sq) { return xkeepSQue("scalarCondition", sq); }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public Map<String, VillagePlayerCQ> xdfgetSpecifyMyselfDerived() { return xgetSQueMap("specifyMyselfDerived"); }
    public String keepSpecifyMyselfDerived(VillagePlayerCQ sq) { return xkeepSQue("specifyMyselfDerived", sq); }

    public Map<String, VillagePlayerCQ> xdfgetQueryMyselfDerived() { return xgetSQueMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerived(VillagePlayerCQ sq) { return xkeepSQue("queryMyselfDerived", sq); }
    public Map<String, Object> xdfgetQueryMyselfDerivedParameter() { return xgetSQuePmMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerivedParameter(Object pm) { return xkeepSQuePm("queryMyselfDerived", pm); }

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    protected Map<String, VillagePlayerCQ> _myselfExistsMap;
    public Map<String, VillagePlayerCQ> xdfgetMyselfExists() { return xgetSQueMap("myselfExists"); }
    public String keepMyselfExists(VillagePlayerCQ sq) { return xkeepSQue("myselfExists", sq); }

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    public Map<String, VillagePlayerCQ> xdfgetMyselfInScope() { return xgetSQueMap("myselfInScope"); }
    public String keepMyselfInScope(VillagePlayerCQ sq) { return xkeepSQue("myselfInScope", sq); }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xCB() { return VillagePlayerCB.class.getName(); }
    protected String xCQ() { return VillagePlayerCQ.class.getName(); }
    protected String xCHp() { return HpQDRFunction.class.getName(); }
    protected String xCOp() { return ConditionOption.class.getName(); }
    protected String xMap() { return Map.class.getName(); }
}
