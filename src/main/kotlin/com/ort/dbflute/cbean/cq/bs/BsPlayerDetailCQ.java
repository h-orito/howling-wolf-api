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
 * The base condition-query of PLAYER_DETAIL.
 * @author DBFlute(AutoGenerator)
 */
public class BsPlayerDetailCQ extends AbstractBsPlayerDetailCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected PlayerDetailCIQ _inlineQuery;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsPlayerDetailCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                 InlineView/OrClause
    //                                                                 ===================
    /**
     * Prepare InlineView query. <br>
     * {select ... from ... left outer join (select * from PLAYER_DETAIL) where FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">inline()</span>.setFoo...;
     * </pre>
     * @return The condition-query for InlineView query. (NotNull)
     */
    public PlayerDetailCIQ inline() {
        if (_inlineQuery == null) { _inlineQuery = xcreateCIQ(); }
        _inlineQuery.xsetOnClause(false); return _inlineQuery;
    }

    protected PlayerDetailCIQ xcreateCIQ() {
        PlayerDetailCIQ ciq = xnewCIQ();
        ciq.xsetBaseCB(_baseCB);
        return ciq;
    }

    protected PlayerDetailCIQ xnewCIQ() {
        return new PlayerDetailCIQ(xgetReferrerQuery(), xgetSqlClause(), xgetAliasName(), xgetNestLevel(), this);
    }

    /**
     * Prepare OnClause query. <br>
     * {select ... from ... left outer join PLAYER_DETAIL on ... and FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">on()</span>.setFoo...;
     * </pre>
     * @return The condition-query for OnClause query. (NotNull)
     * @throws IllegalConditionBeanOperationException When this condition-query is base query.
     */
    public PlayerDetailCIQ on() {
        if (isBaseQuery()) { throw new IllegalConditionBeanOperationException("OnClause for local table is unavailable!"); }
        PlayerDetailCIQ inlineQuery = inline(); inlineQuery.xsetOnClause(true); return inlineQuery;
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    protected ConditionValue _playerId;
    public ConditionValue xdfgetPlayerId()
    { if (_playerId == null) { _playerId = nCV(); }
      return _playerId; }
    protected ConditionValue xgetCValuePlayerId() { return xdfgetPlayerId(); }

    /**
     * Add order-by as ascend. <br>
     * PLAYER_ID: {PK, NotNull, INT UNSIGNED(10), FK to PLAYER}
     * @return this. (NotNull)
     */
    public BsPlayerDetailCQ addOrderBy_PlayerId_Asc() { regOBA("PLAYER_ID"); return this; }

    /**
     * Add order-by as descend. <br>
     * PLAYER_ID: {PK, NotNull, INT UNSIGNED(10), FK to PLAYER}
     * @return this. (NotNull)
     */
    public BsPlayerDetailCQ addOrderBy_PlayerId_Desc() { regOBD("PLAYER_ID"); return this; }

    protected ConditionValue _otherSiteName;
    public ConditionValue xdfgetOtherSiteName()
    { if (_otherSiteName == null) { _otherSiteName = nCV(); }
      return _otherSiteName; }
    protected ConditionValue xgetCValueOtherSiteName() { return xdfgetOtherSiteName(); }

    /**
     * Add order-by as ascend. <br>
     * OTHER_SITE_NAME: {VARCHAR(20)}
     * @return this. (NotNull)
     */
    public BsPlayerDetailCQ addOrderBy_OtherSiteName_Asc() { regOBA("OTHER_SITE_NAME"); return this; }

    /**
     * Add order-by as descend. <br>
     * OTHER_SITE_NAME: {VARCHAR(20)}
     * @return this. (NotNull)
     */
    public BsPlayerDetailCQ addOrderBy_OtherSiteName_Desc() { regOBD("OTHER_SITE_NAME"); return this; }

    protected ConditionValue _introduction;
    public ConditionValue xdfgetIntroduction()
    { if (_introduction == null) { _introduction = nCV(); }
      return _introduction; }
    protected ConditionValue xgetCValueIntroduction() { return xdfgetIntroduction(); }

    /**
     * Add order-by as ascend. <br>
     * INTRODUCTION: {VARCHAR(2000)}
     * @return this. (NotNull)
     */
    public BsPlayerDetailCQ addOrderBy_Introduction_Asc() { regOBA("INTRODUCTION"); return this; }

    /**
     * Add order-by as descend. <br>
     * INTRODUCTION: {VARCHAR(2000)}
     * @return this. (NotNull)
     */
    public BsPlayerDetailCQ addOrderBy_Introduction_Desc() { regOBD("INTRODUCTION"); return this; }

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
    public BsPlayerDetailCQ addSpecifiedDerivedOrderBy_Asc(String aliasName) { registerSpecifiedDerivedOrderBy_Asc(aliasName); return this; }

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
    public BsPlayerDetailCQ addSpecifiedDerivedOrderBy_Desc(String aliasName) { registerSpecifiedDerivedOrderBy_Desc(aliasName); return this; }

    // ===================================================================================
    //                                                                         Union Query
    //                                                                         ===========
    public void reflectRelationOnUnionQuery(ConditionQuery bqs, ConditionQuery uqs) {
        PlayerDetailCQ bq = (PlayerDetailCQ)bqs;
        PlayerDetailCQ uq = (PlayerDetailCQ)uqs;
        if (bq.hasConditionQueryPlayer()) {
            uq.queryPlayer().reflectRelationOnUnionQuery(bq.queryPlayer(), uq.queryPlayer());
        }
    }

    // ===================================================================================
    //                                                                       Foreign Query
    //                                                                       =============
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
        String nrp = xresolveNRP("PLAYER_DETAIL", "player"); String jan = xresolveJAN(nrp, xgetNNLvl());
        return xinitRelCQ(new PlayerCQ(this, xgetSqlClause(), jan, xgetNNLvl()), _baseCB, "player", nrp);
    }
    protected void xsetupOuterJoinPlayer() { xregOutJo("player"); }
    public boolean hasConditionQueryPlayer() { return xhasQueRlMap("player"); }

    protected Map<String, Object> xfindFixedConditionDynamicParameterMap(String property) {
        return null;
    }

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    public Map<String, PlayerDetailCQ> xdfgetScalarCondition() { return xgetSQueMap("scalarCondition"); }
    public String keepScalarCondition(PlayerDetailCQ sq) { return xkeepSQue("scalarCondition", sq); }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public Map<String, PlayerDetailCQ> xdfgetSpecifyMyselfDerived() { return xgetSQueMap("specifyMyselfDerived"); }
    public String keepSpecifyMyselfDerived(PlayerDetailCQ sq) { return xkeepSQue("specifyMyselfDerived", sq); }

    public Map<String, PlayerDetailCQ> xdfgetQueryMyselfDerived() { return xgetSQueMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerived(PlayerDetailCQ sq) { return xkeepSQue("queryMyselfDerived", sq); }
    public Map<String, Object> xdfgetQueryMyselfDerivedParameter() { return xgetSQuePmMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerivedParameter(Object pm) { return xkeepSQuePm("queryMyselfDerived", pm); }

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    protected Map<String, PlayerDetailCQ> _myselfExistsMap;
    public Map<String, PlayerDetailCQ> xdfgetMyselfExists() { return xgetSQueMap("myselfExists"); }
    public String keepMyselfExists(PlayerDetailCQ sq) { return xkeepSQue("myselfExists", sq); }

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    public Map<String, PlayerDetailCQ> xdfgetMyselfInScope() { return xgetSQueMap("myselfInScope"); }
    public String keepMyselfInScope(PlayerDetailCQ sq) { return xkeepSQue("myselfInScope", sq); }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xCB() { return PlayerDetailCB.class.getName(); }
    protected String xCQ() { return PlayerDetailCQ.class.getName(); }
    protected String xCHp() { return HpQDRFunction.class.getName(); }
    protected String xCOp() { return ConditionOption.class.getName(); }
    protected String xMap() { return Map.class.getName(); }
}
