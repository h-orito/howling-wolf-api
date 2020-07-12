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
 * The base condition-query of vote.
 * @author DBFlute(AutoGenerator)
 */
public class BsVoteCQ extends AbstractBsVoteCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected VoteCIQ _inlineQuery;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsVoteCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                 InlineView/OrClause
    //                                                                 ===================
    /**
     * Prepare InlineView query. <br>
     * {select ... from ... left outer join (select * from vote) where FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">inline()</span>.setFoo...;
     * </pre>
     * @return The condition-query for InlineView query. (NotNull)
     */
    public VoteCIQ inline() {
        if (_inlineQuery == null) { _inlineQuery = xcreateCIQ(); }
        _inlineQuery.xsetOnClause(false); return _inlineQuery;
    }

    protected VoteCIQ xcreateCIQ() {
        VoteCIQ ciq = xnewCIQ();
        ciq.xsetBaseCB(_baseCB);
        return ciq;
    }

    protected VoteCIQ xnewCIQ() {
        return new VoteCIQ(xgetReferrerQuery(), xgetSqlClause(), xgetAliasName(), xgetNestLevel(), this);
    }

    /**
     * Prepare OnClause query. <br>
     * {select ... from ... left outer join vote on ... and FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">on()</span>.setFoo...;
     * </pre>
     * @return The condition-query for OnClause query. (NotNull)
     * @throws IllegalConditionBeanOperationException When this condition-query is base query.
     */
    public VoteCIQ on() {
        if (isBaseQuery()) { throw new IllegalConditionBeanOperationException("OnClause for local table is unavailable!"); }
        VoteCIQ inlineQuery = inline(); inlineQuery.xsetOnClause(true); return inlineQuery;
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    protected ConditionValue _villageDayId;
    public ConditionValue xdfgetVillageDayId()
    { if (_villageDayId == null) { _villageDayId = nCV(); }
      return _villageDayId; }
    protected ConditionValue xgetCValueVillageDayId() { return xdfgetVillageDayId(); }

    /**
     * Add order-by as ascend. <br>
     * VILLAGE_DAY_ID: {PK, NotNull, INT UNSIGNED(10), FK to village_day}
     * @return this. (NotNull)
     */
    public BsVoteCQ addOrderBy_VillageDayId_Asc() { regOBA("VILLAGE_DAY_ID"); return this; }

    /**
     * Add order-by as descend. <br>
     * VILLAGE_DAY_ID: {PK, NotNull, INT UNSIGNED(10), FK to village_day}
     * @return this. (NotNull)
     */
    public BsVoteCQ addOrderBy_VillageDayId_Desc() { regOBD("VILLAGE_DAY_ID"); return this; }

    protected ConditionValue _villagePlayerId;
    public ConditionValue xdfgetVillagePlayerId()
    { if (_villagePlayerId == null) { _villagePlayerId = nCV(); }
      return _villagePlayerId; }
    protected ConditionValue xgetCValueVillagePlayerId() { return xdfgetVillagePlayerId(); }

    /**
     * Add order-by as ascend. <br>
     * VILLAGE_PLAYER_ID: {PK, IX, NotNull, INT UNSIGNED(10), FK to village_player}
     * @return this. (NotNull)
     */
    public BsVoteCQ addOrderBy_VillagePlayerId_Asc() { regOBA("VILLAGE_PLAYER_ID"); return this; }

    /**
     * Add order-by as descend. <br>
     * VILLAGE_PLAYER_ID: {PK, IX, NotNull, INT UNSIGNED(10), FK to village_player}
     * @return this. (NotNull)
     */
    public BsVoteCQ addOrderBy_VillagePlayerId_Desc() { regOBD("VILLAGE_PLAYER_ID"); return this; }

    protected ConditionValue _targetVillagePlayerId;
    public ConditionValue xdfgetTargetVillagePlayerId()
    { if (_targetVillagePlayerId == null) { _targetVillagePlayerId = nCV(); }
      return _targetVillagePlayerId; }
    protected ConditionValue xgetCValueTargetVillagePlayerId() { return xdfgetTargetVillagePlayerId(); }

    /**
     * Add order-by as ascend. <br>
     * TARGET_VILLAGE_PLAYER_ID: {IX, INT UNSIGNED(10), FK to village_player}
     * @return this. (NotNull)
     */
    public BsVoteCQ addOrderBy_TargetVillagePlayerId_Asc() { regOBA("TARGET_VILLAGE_PLAYER_ID"); return this; }

    /**
     * Add order-by as descend. <br>
     * TARGET_VILLAGE_PLAYER_ID: {IX, INT UNSIGNED(10), FK to village_player}
     * @return this. (NotNull)
     */
    public BsVoteCQ addOrderBy_TargetVillagePlayerId_Desc() { regOBD("TARGET_VILLAGE_PLAYER_ID"); return this; }

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
    public BsVoteCQ addOrderBy_RegisterDatetime_Asc() { regOBA("REGISTER_DATETIME"); return this; }

    /**
     * Add order-by as descend. <br>
     * REGISTER_DATETIME: {NotNull, DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsVoteCQ addOrderBy_RegisterDatetime_Desc() { regOBD("REGISTER_DATETIME"); return this; }

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
    public BsVoteCQ addOrderBy_RegisterTrace_Asc() { regOBA("REGISTER_TRACE"); return this; }

    /**
     * Add order-by as descend. <br>
     * REGISTER_TRACE: {NotNull, VARCHAR(64)}
     * @return this. (NotNull)
     */
    public BsVoteCQ addOrderBy_RegisterTrace_Desc() { regOBD("REGISTER_TRACE"); return this; }

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
    public BsVoteCQ addOrderBy_UpdateDatetime_Asc() { regOBA("UPDATE_DATETIME"); return this; }

    /**
     * Add order-by as descend. <br>
     * UPDATE_DATETIME: {NotNull, DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsVoteCQ addOrderBy_UpdateDatetime_Desc() { regOBD("UPDATE_DATETIME"); return this; }

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
    public BsVoteCQ addOrderBy_UpdateTrace_Asc() { regOBA("UPDATE_TRACE"); return this; }

    /**
     * Add order-by as descend. <br>
     * UPDATE_TRACE: {NotNull, VARCHAR(64)}
     * @return this. (NotNull)
     */
    public BsVoteCQ addOrderBy_UpdateTrace_Desc() { regOBD("UPDATE_TRACE"); return this; }

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
    public BsVoteCQ addSpecifiedDerivedOrderBy_Asc(String aliasName) { registerSpecifiedDerivedOrderBy_Asc(aliasName); return this; }

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
    public BsVoteCQ addSpecifiedDerivedOrderBy_Desc(String aliasName) { registerSpecifiedDerivedOrderBy_Desc(aliasName); return this; }

    // ===================================================================================
    //                                                                         Union Query
    //                                                                         ===========
    public void reflectRelationOnUnionQuery(ConditionQuery bqs, ConditionQuery uqs) {
        VoteCQ bq = (VoteCQ)bqs;
        VoteCQ uq = (VoteCQ)uqs;
        if (bq.hasConditionQueryVillagePlayerByTargetVillagePlayerId()) {
            uq.queryVillagePlayerByTargetVillagePlayerId().reflectRelationOnUnionQuery(bq.queryVillagePlayerByTargetVillagePlayerId(), uq.queryVillagePlayerByTargetVillagePlayerId());
        }
        if (bq.hasConditionQueryVillageDay()) {
            uq.queryVillageDay().reflectRelationOnUnionQuery(bq.queryVillageDay(), uq.queryVillageDay());
        }
        if (bq.hasConditionQueryVillagePlayerByVillagePlayerId()) {
            uq.queryVillagePlayerByVillagePlayerId().reflectRelationOnUnionQuery(bq.queryVillagePlayerByVillagePlayerId(), uq.queryVillagePlayerByVillagePlayerId());
        }
    }

    // ===================================================================================
    //                                                                       Foreign Query
    //                                                                       =============
    /**
     * Get the condition-query for relation table. <br>
     * VILLAGE_PLAYER by my TARGET_VILLAGE_PLAYER_ID, named 'villagePlayerByTargetVillagePlayerId'.
     * @return The instance of condition-query. (NotNull)
     */
    public VillagePlayerCQ queryVillagePlayerByTargetVillagePlayerId() {
        return xdfgetConditionQueryVillagePlayerByTargetVillagePlayerId();
    }
    public VillagePlayerCQ xdfgetConditionQueryVillagePlayerByTargetVillagePlayerId() {
        String prop = "villagePlayerByTargetVillagePlayerId";
        if (!xhasQueRlMap(prop)) { xregQueRl(prop, xcreateQueryVillagePlayerByTargetVillagePlayerId()); xsetupOuterJoinVillagePlayerByTargetVillagePlayerId(); }
        return xgetQueRlMap(prop);
    }
    protected VillagePlayerCQ xcreateQueryVillagePlayerByTargetVillagePlayerId() {
        String nrp = xresolveNRP("vote", "villagePlayerByTargetVillagePlayerId"); String jan = xresolveJAN(nrp, xgetNNLvl());
        return xinitRelCQ(new VillagePlayerCQ(this, xgetSqlClause(), jan, xgetNNLvl()), _baseCB, "villagePlayerByTargetVillagePlayerId", nrp);
    }
    protected void xsetupOuterJoinVillagePlayerByTargetVillagePlayerId() { xregOutJo("villagePlayerByTargetVillagePlayerId"); }
    public boolean hasConditionQueryVillagePlayerByTargetVillagePlayerId() { return xhasQueRlMap("villagePlayerByTargetVillagePlayerId"); }

    /**
     * Get the condition-query for relation table. <br>
     * VILLAGE_DAY by my VILLAGE_DAY_ID, named 'villageDay'.
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
        String nrp = xresolveNRP("vote", "villageDay"); String jan = xresolveJAN(nrp, xgetNNLvl());
        return xinitRelCQ(new VillageDayCQ(this, xgetSqlClause(), jan, xgetNNLvl()), _baseCB, "villageDay", nrp);
    }
    protected void xsetupOuterJoinVillageDay() { xregOutJo("villageDay"); }
    public boolean hasConditionQueryVillageDay() { return xhasQueRlMap("villageDay"); }

    /**
     * Get the condition-query for relation table. <br>
     * VILLAGE_PLAYER by my VILLAGE_PLAYER_ID, named 'villagePlayerByVillagePlayerId'.
     * @return The instance of condition-query. (NotNull)
     */
    public VillagePlayerCQ queryVillagePlayerByVillagePlayerId() {
        return xdfgetConditionQueryVillagePlayerByVillagePlayerId();
    }
    public VillagePlayerCQ xdfgetConditionQueryVillagePlayerByVillagePlayerId() {
        String prop = "villagePlayerByVillagePlayerId";
        if (!xhasQueRlMap(prop)) { xregQueRl(prop, xcreateQueryVillagePlayerByVillagePlayerId()); xsetupOuterJoinVillagePlayerByVillagePlayerId(); }
        return xgetQueRlMap(prop);
    }
    protected VillagePlayerCQ xcreateQueryVillagePlayerByVillagePlayerId() {
        String nrp = xresolveNRP("vote", "villagePlayerByVillagePlayerId"); String jan = xresolveJAN(nrp, xgetNNLvl());
        return xinitRelCQ(new VillagePlayerCQ(this, xgetSqlClause(), jan, xgetNNLvl()), _baseCB, "villagePlayerByVillagePlayerId", nrp);
    }
    protected void xsetupOuterJoinVillagePlayerByVillagePlayerId() { xregOutJo("villagePlayerByVillagePlayerId"); }
    public boolean hasConditionQueryVillagePlayerByVillagePlayerId() { return xhasQueRlMap("villagePlayerByVillagePlayerId"); }

    protected Map<String, Object> xfindFixedConditionDynamicParameterMap(String property) {
        return null;
    }

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    public Map<String, VoteCQ> xdfgetScalarCondition() { return xgetSQueMap("scalarCondition"); }
    public String keepScalarCondition(VoteCQ sq) { return xkeepSQue("scalarCondition", sq); }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xCB() { return VoteCB.class.getName(); }
    protected String xCQ() { return VoteCQ.class.getName(); }
    protected String xCHp() { return HpQDRFunction.class.getName(); }
    protected String xCOp() { return ConditionOption.class.getName(); }
    protected String xMap() { return Map.class.getName(); }
}
