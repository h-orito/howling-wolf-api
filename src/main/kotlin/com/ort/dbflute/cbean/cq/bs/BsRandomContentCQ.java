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
 * The base condition-query of random_content.
 * @author DBFlute(AutoGenerator)
 */
public class BsRandomContentCQ extends AbstractBsRandomContentCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected RandomContentCIQ _inlineQuery;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsRandomContentCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                 InlineView/OrClause
    //                                                                 ===================
    /**
     * Prepare InlineView query. <br>
     * {select ... from ... left outer join (select * from random_content) where FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">inline()</span>.setFoo...;
     * </pre>
     * @return The condition-query for InlineView query. (NotNull)
     */
    public RandomContentCIQ inline() {
        if (_inlineQuery == null) { _inlineQuery = xcreateCIQ(); }
        _inlineQuery.xsetOnClause(false); return _inlineQuery;
    }

    protected RandomContentCIQ xcreateCIQ() {
        RandomContentCIQ ciq = xnewCIQ();
        ciq.xsetBaseCB(_baseCB);
        return ciq;
    }

    protected RandomContentCIQ xnewCIQ() {
        return new RandomContentCIQ(xgetReferrerQuery(), xgetSqlClause(), xgetAliasName(), xgetNestLevel(), this);
    }

    /**
     * Prepare OnClause query. <br>
     * {select ... from ... left outer join random_content on ... and FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">on()</span>.setFoo...;
     * </pre>
     * @return The condition-query for OnClause query. (NotNull)
     * @throws IllegalConditionBeanOperationException When this condition-query is base query.
     */
    public RandomContentCIQ on() {
        if (isBaseQuery()) { throw new IllegalConditionBeanOperationException("OnClause for local table is unavailable!"); }
        RandomContentCIQ inlineQuery = inline(); inlineQuery.xsetOnClause(true); return inlineQuery;
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    protected ConditionValue _randomContentId;
    public ConditionValue xdfgetRandomContentId()
    { if (_randomContentId == null) { _randomContentId = nCV(); }
      return _randomContentId; }
    protected ConditionValue xgetCValueRandomContentId() { return xdfgetRandomContentId(); }

    /** 
     * Add order-by as ascend. <br>
     * RANDOM_CONTENT_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @return this. (NotNull)
     */
    public BsRandomContentCQ addOrderBy_RandomContentId_Asc() { regOBA("RANDOM_CONTENT_ID"); return this; }

    /**
     * Add order-by as descend. <br>
     * RANDOM_CONTENT_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @return this. (NotNull)
     */
    public BsRandomContentCQ addOrderBy_RandomContentId_Desc() { regOBD("RANDOM_CONTENT_ID"); return this; }

    protected ConditionValue _randomKeywordId;
    public ConditionValue xdfgetRandomKeywordId()
    { if (_randomKeywordId == null) { _randomKeywordId = nCV(); }
      return _randomKeywordId; }
    protected ConditionValue xgetCValueRandomKeywordId() { return xdfgetRandomKeywordId(); }

    /** 
     * Add order-by as ascend. <br>
     * RANDOM_KEYWORD_ID: {IX, NotNull, INT UNSIGNED(10), FK to random_keyword}
     * @return this. (NotNull)
     */
    public BsRandomContentCQ addOrderBy_RandomKeywordId_Asc() { regOBA("RANDOM_KEYWORD_ID"); return this; }

    /**
     * Add order-by as descend. <br>
     * RANDOM_KEYWORD_ID: {IX, NotNull, INT UNSIGNED(10), FK to random_keyword}
     * @return this. (NotNull)
     */
    public BsRandomContentCQ addOrderBy_RandomKeywordId_Desc() { regOBD("RANDOM_KEYWORD_ID"); return this; }

    protected ConditionValue _randomMessage;
    public ConditionValue xdfgetRandomMessage()
    { if (_randomMessage == null) { _randomMessage = nCV(); }
      return _randomMessage; }
    protected ConditionValue xgetCValueRandomMessage() { return xdfgetRandomMessage(); }

    /** 
     * Add order-by as ascend. <br>
     * RANDOM_MESSAGE: {NotNull, VARCHAR(20)}
     * @return this. (NotNull)
     */
    public BsRandomContentCQ addOrderBy_RandomMessage_Asc() { regOBA("RANDOM_MESSAGE"); return this; }

    /**
     * Add order-by as descend. <br>
     * RANDOM_MESSAGE: {NotNull, VARCHAR(20)}
     * @return this. (NotNull)
     */
    public BsRandomContentCQ addOrderBy_RandomMessage_Desc() { regOBD("RANDOM_MESSAGE"); return this; }

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
    public BsRandomContentCQ addSpecifiedDerivedOrderBy_Asc(String aliasName) { registerSpecifiedDerivedOrderBy_Asc(aliasName); return this; }

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
    public BsRandomContentCQ addSpecifiedDerivedOrderBy_Desc(String aliasName) { registerSpecifiedDerivedOrderBy_Desc(aliasName); return this; }

    // ===================================================================================
    //                                                                         Union Query
    //                                                                         ===========
    public void reflectRelationOnUnionQuery(ConditionQuery bqs, ConditionQuery uqs) {
        RandomContentCQ bq = (RandomContentCQ)bqs;
        RandomContentCQ uq = (RandomContentCQ)uqs;
        if (bq.hasConditionQueryRandomKeyword()) {
            uq.queryRandomKeyword().reflectRelationOnUnionQuery(bq.queryRandomKeyword(), uq.queryRandomKeyword());
        }
    }

    // ===================================================================================
    //                                                                       Foreign Query
    //                                                                       =============
    /**
     * Get the condition-query for relation table. <br>
     * RANDOM_KEYWORD by my RANDOM_KEYWORD_ID, named 'randomKeyword'.
     * @return The instance of condition-query. (NotNull)
     */
    public RandomKeywordCQ queryRandomKeyword() {
        return xdfgetConditionQueryRandomKeyword();
    }
    public RandomKeywordCQ xdfgetConditionQueryRandomKeyword() {
        String prop = "randomKeyword";
        if (!xhasQueRlMap(prop)) { xregQueRl(prop, xcreateQueryRandomKeyword()); xsetupOuterJoinRandomKeyword(); }
        return xgetQueRlMap(prop);
    }
    protected RandomKeywordCQ xcreateQueryRandomKeyword() {
        String nrp = xresolveNRP("random_content", "randomKeyword"); String jan = xresolveJAN(nrp, xgetNNLvl());
        return xinitRelCQ(new RandomKeywordCQ(this, xgetSqlClause(), jan, xgetNNLvl()), _baseCB, "randomKeyword", nrp);
    }
    protected void xsetupOuterJoinRandomKeyword() { xregOutJo("randomKeyword"); }
    public boolean hasConditionQueryRandomKeyword() { return xhasQueRlMap("randomKeyword"); }

    protected Map<String, Object> xfindFixedConditionDynamicParameterMap(String property) {
        return null;
    }

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    public Map<String, RandomContentCQ> xdfgetScalarCondition() { return xgetSQueMap("scalarCondition"); }
    public String keepScalarCondition(RandomContentCQ sq) { return xkeepSQue("scalarCondition", sq); }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public Map<String, RandomContentCQ> xdfgetSpecifyMyselfDerived() { return xgetSQueMap("specifyMyselfDerived"); }
    public String keepSpecifyMyselfDerived(RandomContentCQ sq) { return xkeepSQue("specifyMyselfDerived", sq); }

    public Map<String, RandomContentCQ> xdfgetQueryMyselfDerived() { return xgetSQueMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerived(RandomContentCQ sq) { return xkeepSQue("queryMyselfDerived", sq); }
    public Map<String, Object> xdfgetQueryMyselfDerivedParameter() { return xgetSQuePmMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerivedParameter(Object pm) { return xkeepSQuePm("queryMyselfDerived", pm); }

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    protected Map<String, RandomContentCQ> _myselfExistsMap;
    public Map<String, RandomContentCQ> xdfgetMyselfExists() { return xgetSQueMap("myselfExists"); }
    public String keepMyselfExists(RandomContentCQ sq) { return xkeepSQue("myselfExists", sq); }

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    public Map<String, RandomContentCQ> xdfgetMyselfInScope() { return xgetSQueMap("myselfInScope"); }
    public String keepMyselfInScope(RandomContentCQ sq) { return xkeepSQue("myselfInScope", sq); }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xCB() { return RandomContentCB.class.getName(); }
    protected String xCQ() { return RandomContentCQ.class.getName(); }
    protected String xCHp() { return HpQDRFunction.class.getName(); }
    protected String xCOp() { return ConditionOption.class.getName(); }
    protected String xMap() { return Map.class.getName(); }
}
