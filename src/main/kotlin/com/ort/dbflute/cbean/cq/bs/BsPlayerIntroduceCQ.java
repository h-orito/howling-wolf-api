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
 * The base condition-query of player_introduce.
 * @author DBFlute(AutoGenerator)
 */
public class BsPlayerIntroduceCQ extends AbstractBsPlayerIntroduceCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected PlayerIntroduceCIQ _inlineQuery;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsPlayerIntroduceCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                 InlineView/OrClause
    //                                                                 ===================
    /**
     * Prepare InlineView query. <br>
     * {select ... from ... left outer join (select * from player_introduce) where FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">inline()</span>.setFoo...;
     * </pre>
     * @return The condition-query for InlineView query. (NotNull)
     */
    public PlayerIntroduceCIQ inline() {
        if (_inlineQuery == null) { _inlineQuery = xcreateCIQ(); }
        _inlineQuery.xsetOnClause(false); return _inlineQuery;
    }

    protected PlayerIntroduceCIQ xcreateCIQ() {
        PlayerIntroduceCIQ ciq = xnewCIQ();
        ciq.xsetBaseCB(_baseCB);
        return ciq;
    }

    protected PlayerIntroduceCIQ xnewCIQ() {
        return new PlayerIntroduceCIQ(xgetReferrerQuery(), xgetSqlClause(), xgetAliasName(), xgetNestLevel(), this);
    }

    /**
     * Prepare OnClause query. <br>
     * {select ... from ... left outer join player_introduce on ... and FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">on()</span>.setFoo...;
     * </pre>
     * @return The condition-query for OnClause query. (NotNull)
     * @throws IllegalConditionBeanOperationException When this condition-query is base query.
     */
    public PlayerIntroduceCIQ on() {
        if (isBaseQuery()) { throw new IllegalConditionBeanOperationException("OnClause for local table is unavailable!"); }
        PlayerIntroduceCIQ inlineQuery = inline(); inlineQuery.xsetOnClause(true); return inlineQuery;
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    protected ConditionValue _playerIntroduceId;
    public ConditionValue xdfgetPlayerIntroduceId()
    { if (_playerIntroduceId == null) { _playerIntroduceId = nCV(); }
      return _playerIntroduceId; }
    protected ConditionValue xgetCValuePlayerIntroduceId() { return xdfgetPlayerIntroduceId(); }

    /**
     * Add order-by as ascend. <br>
     * PLAYER_INTRODUCE_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @return this. (NotNull)
     */
    public BsPlayerIntroduceCQ addOrderBy_PlayerIntroduceId_Asc() { regOBA("PLAYER_INTRODUCE_ID"); return this; }

    /**
     * Add order-by as descend. <br>
     * PLAYER_INTRODUCE_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @return this. (NotNull)
     */
    public BsPlayerIntroduceCQ addOrderBy_PlayerIntroduceId_Desc() { regOBD("PLAYER_INTRODUCE_ID"); return this; }

    protected ConditionValue _fromPlayerId;
    public ConditionValue xdfgetFromPlayerId()
    { if (_fromPlayerId == null) { _fromPlayerId = nCV(); }
      return _fromPlayerId; }
    protected ConditionValue xgetCValueFromPlayerId() { return xdfgetFromPlayerId(); }

    /**
     * Add order-by as ascend. <br>
     * FROM_PLAYER_ID: {UQ+, NotNull, INT UNSIGNED(10), FK to player}
     * @return this. (NotNull)
     */
    public BsPlayerIntroduceCQ addOrderBy_FromPlayerId_Asc() { regOBA("FROM_PLAYER_ID"); return this; }

    /**
     * Add order-by as descend. <br>
     * FROM_PLAYER_ID: {UQ+, NotNull, INT UNSIGNED(10), FK to player}
     * @return this. (NotNull)
     */
    public BsPlayerIntroduceCQ addOrderBy_FromPlayerId_Desc() { regOBD("FROM_PLAYER_ID"); return this; }

    protected ConditionValue _toPlayerId;
    public ConditionValue xdfgetToPlayerId()
    { if (_toPlayerId == null) { _toPlayerId = nCV(); }
      return _toPlayerId; }
    protected ConditionValue xgetCValueToPlayerId() { return xdfgetToPlayerId(); }

    /**
     * Add order-by as ascend. <br>
     * TO_PLAYER_ID: {+UQ, IX, NotNull, INT UNSIGNED(10), FK to player}
     * @return this. (NotNull)
     */
    public BsPlayerIntroduceCQ addOrderBy_ToPlayerId_Asc() { regOBA("TO_PLAYER_ID"); return this; }

    /**
     * Add order-by as descend. <br>
     * TO_PLAYER_ID: {+UQ, IX, NotNull, INT UNSIGNED(10), FK to player}
     * @return this. (NotNull)
     */
    public BsPlayerIntroduceCQ addOrderBy_ToPlayerId_Desc() { regOBD("TO_PLAYER_ID"); return this; }

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
    public BsPlayerIntroduceCQ addOrderBy_RegisterDatetime_Asc() { regOBA("REGISTER_DATETIME"); return this; }

    /**
     * Add order-by as descend. <br>
     * REGISTER_DATETIME: {NotNull, DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsPlayerIntroduceCQ addOrderBy_RegisterDatetime_Desc() { regOBD("REGISTER_DATETIME"); return this; }

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
    public BsPlayerIntroduceCQ addOrderBy_RegisterTrace_Asc() { regOBA("REGISTER_TRACE"); return this; }

    /**
     * Add order-by as descend. <br>
     * REGISTER_TRACE: {NotNull, VARCHAR(64)}
     * @return this. (NotNull)
     */
    public BsPlayerIntroduceCQ addOrderBy_RegisterTrace_Desc() { regOBD("REGISTER_TRACE"); return this; }

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
    public BsPlayerIntroduceCQ addOrderBy_UpdateDatetime_Asc() { regOBA("UPDATE_DATETIME"); return this; }

    /**
     * Add order-by as descend. <br>
     * UPDATE_DATETIME: {NotNull, DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsPlayerIntroduceCQ addOrderBy_UpdateDatetime_Desc() { regOBD("UPDATE_DATETIME"); return this; }

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
    public BsPlayerIntroduceCQ addOrderBy_UpdateTrace_Asc() { regOBA("UPDATE_TRACE"); return this; }

    /**
     * Add order-by as descend. <br>
     * UPDATE_TRACE: {NotNull, VARCHAR(64)}
     * @return this. (NotNull)
     */
    public BsPlayerIntroduceCQ addOrderBy_UpdateTrace_Desc() { regOBD("UPDATE_TRACE"); return this; }

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
    public BsPlayerIntroduceCQ addSpecifiedDerivedOrderBy_Asc(String aliasName) { registerSpecifiedDerivedOrderBy_Asc(aliasName); return this; }

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
    public BsPlayerIntroduceCQ addSpecifiedDerivedOrderBy_Desc(String aliasName) { registerSpecifiedDerivedOrderBy_Desc(aliasName); return this; }

    // ===================================================================================
    //                                                                         Union Query
    //                                                                         ===========
    public void reflectRelationOnUnionQuery(ConditionQuery bqs, ConditionQuery uqs) {
        PlayerIntroduceCQ bq = (PlayerIntroduceCQ)bqs;
        PlayerIntroduceCQ uq = (PlayerIntroduceCQ)uqs;
        if (bq.hasConditionQueryPlayerByFromPlayerId()) {
            uq.queryPlayerByFromPlayerId().reflectRelationOnUnionQuery(bq.queryPlayerByFromPlayerId(), uq.queryPlayerByFromPlayerId());
        }
        if (bq.hasConditionQueryPlayerByToPlayerId()) {
            uq.queryPlayerByToPlayerId().reflectRelationOnUnionQuery(bq.queryPlayerByToPlayerId(), uq.queryPlayerByToPlayerId());
        }
    }

    // ===================================================================================
    //                                                                       Foreign Query
    //                                                                       =============
    /**
     * Get the condition-query for relation table. <br>
     * PLAYER by my FROM_PLAYER_ID, named 'playerByFromPlayerId'.
     * @return The instance of condition-query. (NotNull)
     */
    public PlayerCQ queryPlayerByFromPlayerId() {
        return xdfgetConditionQueryPlayerByFromPlayerId();
    }
    public PlayerCQ xdfgetConditionQueryPlayerByFromPlayerId() {
        String prop = "playerByFromPlayerId";
        if (!xhasQueRlMap(prop)) { xregQueRl(prop, xcreateQueryPlayerByFromPlayerId()); xsetupOuterJoinPlayerByFromPlayerId(); }
        return xgetQueRlMap(prop);
    }
    protected PlayerCQ xcreateQueryPlayerByFromPlayerId() {
        String nrp = xresolveNRP("player_introduce", "playerByFromPlayerId"); String jan = xresolveJAN(nrp, xgetNNLvl());
        return xinitRelCQ(new PlayerCQ(this, xgetSqlClause(), jan, xgetNNLvl()), _baseCB, "playerByFromPlayerId", nrp);
    }
    protected void xsetupOuterJoinPlayerByFromPlayerId() { xregOutJo("playerByFromPlayerId"); }
    public boolean hasConditionQueryPlayerByFromPlayerId() { return xhasQueRlMap("playerByFromPlayerId"); }

    /**
     * Get the condition-query for relation table. <br>
     * PLAYER by my TO_PLAYER_ID, named 'playerByToPlayerId'.
     * @return The instance of condition-query. (NotNull)
     */
    public PlayerCQ queryPlayerByToPlayerId() {
        return xdfgetConditionQueryPlayerByToPlayerId();
    }
    public PlayerCQ xdfgetConditionQueryPlayerByToPlayerId() {
        String prop = "playerByToPlayerId";
        if (!xhasQueRlMap(prop)) { xregQueRl(prop, xcreateQueryPlayerByToPlayerId()); xsetupOuterJoinPlayerByToPlayerId(); }
        return xgetQueRlMap(prop);
    }
    protected PlayerCQ xcreateQueryPlayerByToPlayerId() {
        String nrp = xresolveNRP("player_introduce", "playerByToPlayerId"); String jan = xresolveJAN(nrp, xgetNNLvl());
        return xinitRelCQ(new PlayerCQ(this, xgetSqlClause(), jan, xgetNNLvl()), _baseCB, "playerByToPlayerId", nrp);
    }
    protected void xsetupOuterJoinPlayerByToPlayerId() { xregOutJo("playerByToPlayerId"); }
    public boolean hasConditionQueryPlayerByToPlayerId() { return xhasQueRlMap("playerByToPlayerId"); }

    protected Map<String, Object> xfindFixedConditionDynamicParameterMap(String property) {
        return null;
    }

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    public Map<String, PlayerIntroduceCQ> xdfgetScalarCondition() { return xgetSQueMap("scalarCondition"); }
    public String keepScalarCondition(PlayerIntroduceCQ sq) { return xkeepSQue("scalarCondition", sq); }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public Map<String, PlayerIntroduceCQ> xdfgetSpecifyMyselfDerived() { return xgetSQueMap("specifyMyselfDerived"); }
    public String keepSpecifyMyselfDerived(PlayerIntroduceCQ sq) { return xkeepSQue("specifyMyselfDerived", sq); }

    public Map<String, PlayerIntroduceCQ> xdfgetQueryMyselfDerived() { return xgetSQueMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerived(PlayerIntroduceCQ sq) { return xkeepSQue("queryMyselfDerived", sq); }
    public Map<String, Object> xdfgetQueryMyselfDerivedParameter() { return xgetSQuePmMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerivedParameter(Object pm) { return xkeepSQuePm("queryMyselfDerived", pm); }

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    protected Map<String, PlayerIntroduceCQ> _myselfExistsMap;
    public Map<String, PlayerIntroduceCQ> xdfgetMyselfExists() { return xgetSQueMap("myselfExists"); }
    public String keepMyselfExists(PlayerIntroduceCQ sq) { return xkeepSQue("myselfExists", sq); }

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    public Map<String, PlayerIntroduceCQ> xdfgetMyselfInScope() { return xgetSQueMap("myselfInScope"); }
    public String keepMyselfInScope(PlayerIntroduceCQ sq) { return xkeepSQue("myselfInScope", sq); }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xCB() { return PlayerIntroduceCB.class.getName(); }
    protected String xCQ() { return PlayerIntroduceCQ.class.getName(); }
    protected String xCHp() { return HpQDRFunction.class.getName(); }
    protected String xCOp() { return ConditionOption.class.getName(); }
    protected String xMap() { return Map.class.getName(); }
}
