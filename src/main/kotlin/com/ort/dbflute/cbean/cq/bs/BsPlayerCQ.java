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
 * The base condition-query of player.
 * @author DBFlute(AutoGenerator)
 */
public class BsPlayerCQ extends AbstractBsPlayerCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected PlayerCIQ _inlineQuery;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsPlayerCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                 InlineView/OrClause
    //                                                                 ===================
    /**
     * Prepare InlineView query. <br>
     * {select ... from ... left outer join (select * from player) where FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">inline()</span>.setFoo...;
     * </pre>
     * @return The condition-query for InlineView query. (NotNull)
     */
    public PlayerCIQ inline() {
        if (_inlineQuery == null) { _inlineQuery = xcreateCIQ(); }
        _inlineQuery.xsetOnClause(false); return _inlineQuery;
    }

    protected PlayerCIQ xcreateCIQ() {
        PlayerCIQ ciq = xnewCIQ();
        ciq.xsetBaseCB(_baseCB);
        return ciq;
    }

    protected PlayerCIQ xnewCIQ() {
        return new PlayerCIQ(xgetReferrerQuery(), xgetSqlClause(), xgetAliasName(), xgetNestLevel(), this);
    }

    /**
     * Prepare OnClause query. <br>
     * {select ... from ... left outer join player on ... and FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">on()</span>.setFoo...;
     * </pre>
     * @return The condition-query for OnClause query. (NotNull)
     * @throws IllegalConditionBeanOperationException When this condition-query is base query.
     */
    public PlayerCIQ on() {
        if (isBaseQuery()) { throw new IllegalConditionBeanOperationException("OnClause for local table is unavailable!"); }
        PlayerCIQ inlineQuery = inline(); inlineQuery.xsetOnClause(true); return inlineQuery;
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    protected ConditionValue _playerId;
    public ConditionValue xdfgetPlayerId()
    { if (_playerId == null) { _playerId = nCV(); }
      return _playerId; }
    protected ConditionValue xgetCValuePlayerId() { return xdfgetPlayerId(); }

    public Map<String, VillageCQ> xdfgetPlayerId_ExistsReferrer_VillageList() { return xgetSQueMap("playerId_ExistsReferrer_VillageList"); }
    public String keepPlayerId_ExistsReferrer_VillageList(VillageCQ sq) { return xkeepSQue("playerId_ExistsReferrer_VillageList", sq); }

    public Map<String, VillagePlayerCQ> xdfgetPlayerId_ExistsReferrer_VillagePlayerList() { return xgetSQueMap("playerId_ExistsReferrer_VillagePlayerList"); }
    public String keepPlayerId_ExistsReferrer_VillagePlayerList(VillagePlayerCQ sq) { return xkeepSQue("playerId_ExistsReferrer_VillagePlayerList", sq); }

    public Map<String, VillageCQ> xdfgetPlayerId_NotExistsReferrer_VillageList() { return xgetSQueMap("playerId_NotExistsReferrer_VillageList"); }
    public String keepPlayerId_NotExistsReferrer_VillageList(VillageCQ sq) { return xkeepSQue("playerId_NotExistsReferrer_VillageList", sq); }

    public Map<String, VillagePlayerCQ> xdfgetPlayerId_NotExistsReferrer_VillagePlayerList() { return xgetSQueMap("playerId_NotExistsReferrer_VillagePlayerList"); }
    public String keepPlayerId_NotExistsReferrer_VillagePlayerList(VillagePlayerCQ sq) { return xkeepSQue("playerId_NotExistsReferrer_VillagePlayerList", sq); }

    public Map<String, VillageCQ> xdfgetPlayerId_SpecifyDerivedReferrer_VillageList() { return xgetSQueMap("playerId_SpecifyDerivedReferrer_VillageList"); }
    public String keepPlayerId_SpecifyDerivedReferrer_VillageList(VillageCQ sq) { return xkeepSQue("playerId_SpecifyDerivedReferrer_VillageList", sq); }

    public Map<String, VillagePlayerCQ> xdfgetPlayerId_SpecifyDerivedReferrer_VillagePlayerList() { return xgetSQueMap("playerId_SpecifyDerivedReferrer_VillagePlayerList"); }
    public String keepPlayerId_SpecifyDerivedReferrer_VillagePlayerList(VillagePlayerCQ sq) { return xkeepSQue("playerId_SpecifyDerivedReferrer_VillagePlayerList", sq); }

    public Map<String, VillageCQ> xdfgetPlayerId_QueryDerivedReferrer_VillageList() { return xgetSQueMap("playerId_QueryDerivedReferrer_VillageList"); }
    public String keepPlayerId_QueryDerivedReferrer_VillageList(VillageCQ sq) { return xkeepSQue("playerId_QueryDerivedReferrer_VillageList", sq); }
    public Map<String, Object> xdfgetPlayerId_QueryDerivedReferrer_VillageListParameter() { return xgetSQuePmMap("playerId_QueryDerivedReferrer_VillageList"); }
    public String keepPlayerId_QueryDerivedReferrer_VillageListParameter(Object pm) { return xkeepSQuePm("playerId_QueryDerivedReferrer_VillageList", pm); }

    public Map<String, VillagePlayerCQ> xdfgetPlayerId_QueryDerivedReferrer_VillagePlayerList() { return xgetSQueMap("playerId_QueryDerivedReferrer_VillagePlayerList"); }
    public String keepPlayerId_QueryDerivedReferrer_VillagePlayerList(VillagePlayerCQ sq) { return xkeepSQue("playerId_QueryDerivedReferrer_VillagePlayerList", sq); }
    public Map<String, Object> xdfgetPlayerId_QueryDerivedReferrer_VillagePlayerListParameter() { return xgetSQuePmMap("playerId_QueryDerivedReferrer_VillagePlayerList"); }
    public String keepPlayerId_QueryDerivedReferrer_VillagePlayerListParameter(Object pm) { return xkeepSQuePm("playerId_QueryDerivedReferrer_VillagePlayerList", pm); }

    /**
     * Add order-by as ascend. <br>
     * PLAYER_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @return this. (NotNull)
     */
    public BsPlayerCQ addOrderBy_PlayerId_Asc() { regOBA("PLAYER_ID"); return this; }

    /**
     * Add order-by as descend. <br>
     * PLAYER_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @return this. (NotNull)
     */
    public BsPlayerCQ addOrderBy_PlayerId_Desc() { regOBD("PLAYER_ID"); return this; }

    protected ConditionValue _uid;
    public ConditionValue xdfgetUid()
    { if (_uid == null) { _uid = nCV(); }
      return _uid; }
    protected ConditionValue xgetCValueUid() { return xdfgetUid(); }

    /**
     * Add order-by as ascend. <br>
     * UID: {UQ, NotNull, VARCHAR(100)}
     * @return this. (NotNull)
     */
    public BsPlayerCQ addOrderBy_Uid_Asc() { regOBA("UID"); return this; }

    /**
     * Add order-by as descend. <br>
     * UID: {UQ, NotNull, VARCHAR(100)}
     * @return this. (NotNull)
     */
    public BsPlayerCQ addOrderBy_Uid_Desc() { regOBD("UID"); return this; }

    protected ConditionValue _nickname;
    public ConditionValue xdfgetNickname()
    { if (_nickname == null) { _nickname = nCV(); }
      return _nickname; }
    protected ConditionValue xgetCValueNickname() { return xdfgetNickname(); }

    /**
     * Add order-by as ascend. <br>
     * NICKNAME: {NotNull, VARCHAR(50)}
     * @return this. (NotNull)
     */
    public BsPlayerCQ addOrderBy_Nickname_Asc() { regOBA("NICKNAME"); return this; }

    /**
     * Add order-by as descend. <br>
     * NICKNAME: {NotNull, VARCHAR(50)}
     * @return this. (NotNull)
     */
    public BsPlayerCQ addOrderBy_Nickname_Desc() { regOBD("NICKNAME"); return this; }

    protected ConditionValue _twitterUserName;
    public ConditionValue xdfgetTwitterUserName()
    { if (_twitterUserName == null) { _twitterUserName = nCV(); }
      return _twitterUserName; }
    protected ConditionValue xgetCValueTwitterUserName() { return xdfgetTwitterUserName(); }

    /**
     * Add order-by as ascend. <br>
     * TWITTER_USER_NAME: {NotNull, VARCHAR(15)}
     * @return this. (NotNull)
     */
    public BsPlayerCQ addOrderBy_TwitterUserName_Asc() { regOBA("TWITTER_USER_NAME"); return this; }

    /**
     * Add order-by as descend. <br>
     * TWITTER_USER_NAME: {NotNull, VARCHAR(15)}
     * @return this. (NotNull)
     */
    public BsPlayerCQ addOrderBy_TwitterUserName_Desc() { regOBD("TWITTER_USER_NAME"); return this; }

    protected ConditionValue _authorityCode;
    public ConditionValue xdfgetAuthorityCode()
    { if (_authorityCode == null) { _authorityCode = nCV(); }
      return _authorityCode; }
    protected ConditionValue xgetCValueAuthorityCode() { return xdfgetAuthorityCode(); }

    /**
     * Add order-by as ascend. <br>
     * AUTHORITY_CODE: {IX, NotNull, VARCHAR(20), FK to authority, classification=Authority}
     * @return this. (NotNull)
     */
    public BsPlayerCQ addOrderBy_AuthorityCode_Asc() { regOBA("AUTHORITY_CODE"); return this; }

    /**
     * Add order-by as descend. <br>
     * AUTHORITY_CODE: {IX, NotNull, VARCHAR(20), FK to authority, classification=Authority}
     * @return this. (NotNull)
     */
    public BsPlayerCQ addOrderBy_AuthorityCode_Desc() { regOBD("AUTHORITY_CODE"); return this; }

    protected ConditionValue _isRestrictedParticipation;
    public ConditionValue xdfgetIsRestrictedParticipation()
    { if (_isRestrictedParticipation == null) { _isRestrictedParticipation = nCV(); }
      return _isRestrictedParticipation; }
    protected ConditionValue xgetCValueIsRestrictedParticipation() { return xdfgetIsRestrictedParticipation(); }

    /**
     * Add order-by as ascend. <br>
     * IS_RESTRICTED_PARTICIPATION: {NotNull, BIT}
     * @return this. (NotNull)
     */
    public BsPlayerCQ addOrderBy_IsRestrictedParticipation_Asc() { regOBA("IS_RESTRICTED_PARTICIPATION"); return this; }

    /**
     * Add order-by as descend. <br>
     * IS_RESTRICTED_PARTICIPATION: {NotNull, BIT}
     * @return this. (NotNull)
     */
    public BsPlayerCQ addOrderBy_IsRestrictedParticipation_Desc() { regOBD("IS_RESTRICTED_PARTICIPATION"); return this; }

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
    public BsPlayerCQ addOrderBy_RegisterDatetime_Asc() { regOBA("REGISTER_DATETIME"); return this; }

    /**
     * Add order-by as descend. <br>
     * REGISTER_DATETIME: {NotNull, DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsPlayerCQ addOrderBy_RegisterDatetime_Desc() { regOBD("REGISTER_DATETIME"); return this; }

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
    public BsPlayerCQ addOrderBy_RegisterTrace_Asc() { regOBA("REGISTER_TRACE"); return this; }

    /**
     * Add order-by as descend. <br>
     * REGISTER_TRACE: {NotNull, VARCHAR(64)}
     * @return this. (NotNull)
     */
    public BsPlayerCQ addOrderBy_RegisterTrace_Desc() { regOBD("REGISTER_TRACE"); return this; }

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
    public BsPlayerCQ addOrderBy_UpdateDatetime_Asc() { regOBA("UPDATE_DATETIME"); return this; }

    /**
     * Add order-by as descend. <br>
     * UPDATE_DATETIME: {NotNull, DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsPlayerCQ addOrderBy_UpdateDatetime_Desc() { regOBD("UPDATE_DATETIME"); return this; }

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
    public BsPlayerCQ addOrderBy_UpdateTrace_Asc() { regOBA("UPDATE_TRACE"); return this; }

    /**
     * Add order-by as descend. <br>
     * UPDATE_TRACE: {NotNull, VARCHAR(64)}
     * @return this. (NotNull)
     */
    public BsPlayerCQ addOrderBy_UpdateTrace_Desc() { regOBD("UPDATE_TRACE"); return this; }

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
    public BsPlayerCQ addSpecifiedDerivedOrderBy_Asc(String aliasName) { registerSpecifiedDerivedOrderBy_Asc(aliasName); return this; }

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
    public BsPlayerCQ addSpecifiedDerivedOrderBy_Desc(String aliasName) { registerSpecifiedDerivedOrderBy_Desc(aliasName); return this; }

    // ===================================================================================
    //                                                                         Union Query
    //                                                                         ===========
    public void reflectRelationOnUnionQuery(ConditionQuery bqs, ConditionQuery uqs) {
        PlayerCQ bq = (PlayerCQ)bqs;
        PlayerCQ uq = (PlayerCQ)uqs;
        if (bq.hasConditionQueryAuthority()) {
            uq.queryAuthority().reflectRelationOnUnionQuery(bq.queryAuthority(), uq.queryAuthority());
        }
    }

    // ===================================================================================
    //                                                                       Foreign Query
    //                                                                       =============
    /**
     * Get the condition-query for relation table. <br>
     * AUTHORITY by my AUTHORITY_CODE, named 'authority'.
     * @return The instance of condition-query. (NotNull)
     */
    public AuthorityCQ queryAuthority() {
        return xdfgetConditionQueryAuthority();
    }
    public AuthorityCQ xdfgetConditionQueryAuthority() {
        String prop = "authority";
        if (!xhasQueRlMap(prop)) { xregQueRl(prop, xcreateQueryAuthority()); xsetupOuterJoinAuthority(); }
        return xgetQueRlMap(prop);
    }
    protected AuthorityCQ xcreateQueryAuthority() {
        String nrp = xresolveNRP("player", "authority"); String jan = xresolveJAN(nrp, xgetNNLvl());
        return xinitRelCQ(new AuthorityCQ(this, xgetSqlClause(), jan, xgetNNLvl()), _baseCB, "authority", nrp);
    }
    protected void xsetupOuterJoinAuthority() { xregOutJo("authority"); }
    public boolean hasConditionQueryAuthority() { return xhasQueRlMap("authority"); }

    protected Map<String, Object> xfindFixedConditionDynamicParameterMap(String property) {
        return null;
    }

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    public Map<String, PlayerCQ> xdfgetScalarCondition() { return xgetSQueMap("scalarCondition"); }
    public String keepScalarCondition(PlayerCQ sq) { return xkeepSQue("scalarCondition", sq); }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public Map<String, PlayerCQ> xdfgetSpecifyMyselfDerived() { return xgetSQueMap("specifyMyselfDerived"); }
    public String keepSpecifyMyselfDerived(PlayerCQ sq) { return xkeepSQue("specifyMyselfDerived", sq); }

    public Map<String, PlayerCQ> xdfgetQueryMyselfDerived() { return xgetSQueMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerived(PlayerCQ sq) { return xkeepSQue("queryMyselfDerived", sq); }
    public Map<String, Object> xdfgetQueryMyselfDerivedParameter() { return xgetSQuePmMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerivedParameter(Object pm) { return xkeepSQuePm("queryMyselfDerived", pm); }

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    protected Map<String, PlayerCQ> _myselfExistsMap;
    public Map<String, PlayerCQ> xdfgetMyselfExists() { return xgetSQueMap("myselfExists"); }
    public String keepMyselfExists(PlayerCQ sq) { return xkeepSQue("myselfExists", sq); }

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    public Map<String, PlayerCQ> xdfgetMyselfInScope() { return xgetSQueMap("myselfInScope"); }
    public String keepMyselfInScope(PlayerCQ sq) { return xkeepSQue("myselfInScope", sq); }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xCB() { return PlayerCB.class.getName(); }
    protected String xCQ() { return PlayerCQ.class.getName(); }
    protected String xCHp() { return HpQDRFunction.class.getName(); }
    protected String xCOp() { return ConditionOption.class.getName(); }
    protected String xMap() { return Map.class.getName(); }
}
