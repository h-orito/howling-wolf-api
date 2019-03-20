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
 * The base condition-query of commit.
 * @author DBFlute(AutoGenerator)
 */
public class BsCommitCQ extends AbstractBsCommitCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected CommitCIQ _inlineQuery;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsCommitCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                 InlineView/OrClause
    //                                                                 ===================
    /**
     * Prepare InlineView query. <br>
     * {select ... from ... left outer join (select * from commit) where FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">inline()</span>.setFoo...;
     * </pre>
     * @return The condition-query for InlineView query. (NotNull)
     */
    public CommitCIQ inline() {
        if (_inlineQuery == null) { _inlineQuery = xcreateCIQ(); }
        _inlineQuery.xsetOnClause(false); return _inlineQuery;
    }

    protected CommitCIQ xcreateCIQ() {
        CommitCIQ ciq = xnewCIQ();
        ciq.xsetBaseCB(_baseCB);
        return ciq;
    }

    protected CommitCIQ xnewCIQ() {
        return new CommitCIQ(xgetReferrerQuery(), xgetSqlClause(), xgetAliasName(), xgetNestLevel(), this);
    }

    /**
     * Prepare OnClause query. <br>
     * {select ... from ... left outer join commit on ... and FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">on()</span>.setFoo...;
     * </pre>
     * @return The condition-query for OnClause query. (NotNull)
     * @throws IllegalConditionBeanOperationException When this condition-query is base query.
     */
    public CommitCIQ on() {
        if (isBaseQuery()) { throw new IllegalConditionBeanOperationException("OnClause for local table is unavailable!"); }
        CommitCIQ inlineQuery = inline(); inlineQuery.xsetOnClause(true); return inlineQuery;
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
     * VILLAGE_ID: {PK, NotNull, INT UNSIGNED(10), FK to village_day}
     * @return this. (NotNull)
     */
    public BsCommitCQ addOrderBy_VillageId_Asc() { regOBA("VILLAGE_ID"); return this; }

    /**
     * Add order-by as descend. <br>
     * VILLAGE_ID: {PK, NotNull, INT UNSIGNED(10), FK to village_day}
     * @return this. (NotNull)
     */
    public BsCommitCQ addOrderBy_VillageId_Desc() { regOBD("VILLAGE_ID"); return this; }

    protected ConditionValue _day;
    public ConditionValue xdfgetDay()
    { if (_day == null) { _day = nCV(); }
      return _day; }
    protected ConditionValue xgetCValueDay() { return xdfgetDay(); }

    /** 
     * Add order-by as ascend. <br>
     * DAY: {PK, NotNull, INT UNSIGNED(10), FK to village_day}
     * @return this. (NotNull)
     */
    public BsCommitCQ addOrderBy_Day_Asc() { regOBA("DAY"); return this; }

    /**
     * Add order-by as descend. <br>
     * DAY: {PK, NotNull, INT UNSIGNED(10), FK to village_day}
     * @return this. (NotNull)
     */
    public BsCommitCQ addOrderBy_Day_Desc() { regOBD("DAY"); return this; }

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
    public BsCommitCQ addOrderBy_VillagePlayerId_Asc() { regOBA("VILLAGE_PLAYER_ID"); return this; }

    /**
     * Add order-by as descend. <br>
     * VILLAGE_PLAYER_ID: {PK, IX, NotNull, INT UNSIGNED(10), FK to village_player}
     * @return this. (NotNull)
     */
    public BsCommitCQ addOrderBy_VillagePlayerId_Desc() { regOBD("VILLAGE_PLAYER_ID"); return this; }

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
    public BsCommitCQ addOrderBy_RegisterDatetime_Asc() { regOBA("REGISTER_DATETIME"); return this; }

    /**
     * Add order-by as descend. <br>
     * REGISTER_DATETIME: {NotNull, DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsCommitCQ addOrderBy_RegisterDatetime_Desc() { regOBD("REGISTER_DATETIME"); return this; }

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
    public BsCommitCQ addOrderBy_RegisterTrace_Asc() { regOBA("REGISTER_TRACE"); return this; }

    /**
     * Add order-by as descend. <br>
     * REGISTER_TRACE: {NotNull, VARCHAR(64)}
     * @return this. (NotNull)
     */
    public BsCommitCQ addOrderBy_RegisterTrace_Desc() { regOBD("REGISTER_TRACE"); return this; }

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
    public BsCommitCQ addOrderBy_UpdateDatetime_Asc() { regOBA("UPDATE_DATETIME"); return this; }

    /**
     * Add order-by as descend. <br>
     * UPDATE_DATETIME: {NotNull, DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsCommitCQ addOrderBy_UpdateDatetime_Desc() { regOBD("UPDATE_DATETIME"); return this; }

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
    public BsCommitCQ addOrderBy_UpdateTrace_Asc() { regOBA("UPDATE_TRACE"); return this; }

    /**
     * Add order-by as descend. <br>
     * UPDATE_TRACE: {NotNull, VARCHAR(64)}
     * @return this. (NotNull)
     */
    public BsCommitCQ addOrderBy_UpdateTrace_Desc() { regOBD("UPDATE_TRACE"); return this; }

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
    public BsCommitCQ addSpecifiedDerivedOrderBy_Asc(String aliasName) { registerSpecifiedDerivedOrderBy_Asc(aliasName); return this; }

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
    public BsCommitCQ addSpecifiedDerivedOrderBy_Desc(String aliasName) { registerSpecifiedDerivedOrderBy_Desc(aliasName); return this; }

    // ===================================================================================
    //                                                                         Union Query
    //                                                                         ===========
    public void reflectRelationOnUnionQuery(ConditionQuery bqs, ConditionQuery uqs) {
        CommitCQ bq = (CommitCQ)bqs;
        CommitCQ uq = (CommitCQ)uqs;
        if (bq.hasConditionQueryVillageDay()) {
            uq.queryVillageDay().reflectRelationOnUnionQuery(bq.queryVillageDay(), uq.queryVillageDay());
        }
        if (bq.hasConditionQueryVillagePlayer()) {
            uq.queryVillagePlayer().reflectRelationOnUnionQuery(bq.queryVillagePlayer(), uq.queryVillagePlayer());
        }
    }

    // ===================================================================================
    //                                                                       Foreign Query
    //                                                                       =============
    /**
     * Get the condition-query for relation table. <br>
     * VILLAGE_DAY by my VILLAGE_ID, DAY, named 'villageDay'.
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
        String nrp = xresolveNRP("commit", "villageDay"); String jan = xresolveJAN(nrp, xgetNNLvl());
        return xinitRelCQ(new VillageDayCQ(this, xgetSqlClause(), jan, xgetNNLvl()), _baseCB, "villageDay", nrp);
    }
    protected void xsetupOuterJoinVillageDay() { xregOutJo("villageDay"); }
    public boolean hasConditionQueryVillageDay() { return xhasQueRlMap("villageDay"); }

    /**
     * Get the condition-query for relation table. <br>
     * VILLAGE_PLAYER by my VILLAGE_PLAYER_ID, named 'villagePlayer'.
     * @return The instance of condition-query. (NotNull)
     */
    public VillagePlayerCQ queryVillagePlayer() {
        return xdfgetConditionQueryVillagePlayer();
    }
    public VillagePlayerCQ xdfgetConditionQueryVillagePlayer() {
        String prop = "villagePlayer";
        if (!xhasQueRlMap(prop)) { xregQueRl(prop, xcreateQueryVillagePlayer()); xsetupOuterJoinVillagePlayer(); }
        return xgetQueRlMap(prop);
    }
    protected VillagePlayerCQ xcreateQueryVillagePlayer() {
        String nrp = xresolveNRP("commit", "villagePlayer"); String jan = xresolveJAN(nrp, xgetNNLvl());
        return xinitRelCQ(new VillagePlayerCQ(this, xgetSqlClause(), jan, xgetNNLvl()), _baseCB, "villagePlayer", nrp);
    }
    protected void xsetupOuterJoinVillagePlayer() { xregOutJo("villagePlayer"); }
    public boolean hasConditionQueryVillagePlayer() { return xhasQueRlMap("villagePlayer"); }

    protected Map<String, Object> xfindFixedConditionDynamicParameterMap(String property) {
        return null;
    }

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    public Map<String, CommitCQ> xdfgetScalarCondition() { return xgetSQueMap("scalarCondition"); }
    public String keepScalarCondition(CommitCQ sq) { return xkeepSQue("scalarCondition", sq); }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xCB() { return CommitCB.class.getName(); }
    protected String xCQ() { return CommitCQ.class.getName(); }
    protected String xCHp() { return HpQDRFunction.class.getName(); }
    protected String xCOp() { return ConditionOption.class.getName(); }
    protected String xMap() { return Map.class.getName(); }
}
