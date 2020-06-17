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
 * The base condition-query of AUTHORITY.
 * @author DBFlute(AutoGenerator)
 */
public class BsAuthorityCQ extends AbstractBsAuthorityCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected AuthorityCIQ _inlineQuery;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsAuthorityCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                 InlineView/OrClause
    //                                                                 ===================
    /**
     * Prepare InlineView query. <br>
     * {select ... from ... left outer join (select * from AUTHORITY) where FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">inline()</span>.setFoo...;
     * </pre>
     * @return The condition-query for InlineView query. (NotNull)
     */
    public AuthorityCIQ inline() {
        if (_inlineQuery == null) { _inlineQuery = xcreateCIQ(); }
        _inlineQuery.xsetOnClause(false); return _inlineQuery;
    }

    protected AuthorityCIQ xcreateCIQ() {
        AuthorityCIQ ciq = xnewCIQ();
        ciq.xsetBaseCB(_baseCB);
        return ciq;
    }

    protected AuthorityCIQ xnewCIQ() {
        return new AuthorityCIQ(xgetReferrerQuery(), xgetSqlClause(), xgetAliasName(), xgetNestLevel(), this);
    }

    /**
     * Prepare OnClause query. <br>
     * {select ... from ... left outer join AUTHORITY on ... and FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">on()</span>.setFoo...;
     * </pre>
     * @return The condition-query for OnClause query. (NotNull)
     * @throws IllegalConditionBeanOperationException When this condition-query is base query.
     */
    public AuthorityCIQ on() {
        if (isBaseQuery()) { throw new IllegalConditionBeanOperationException("OnClause for local table is unavailable!"); }
        AuthorityCIQ inlineQuery = inline(); inlineQuery.xsetOnClause(true); return inlineQuery;
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    protected ConditionValue _authorityCode;
    public ConditionValue xdfgetAuthorityCode()
    { if (_authorityCode == null) { _authorityCode = nCV(); }
      return _authorityCode; }
    protected ConditionValue xgetCValueAuthorityCode() { return xdfgetAuthorityCode(); }

    public Map<String, PlayerCQ> xdfgetAuthorityCode_ExistsReferrer_PlayerList() { return xgetSQueMap("authorityCode_ExistsReferrer_PlayerList"); }
    public String keepAuthorityCode_ExistsReferrer_PlayerList(PlayerCQ sq) { return xkeepSQue("authorityCode_ExistsReferrer_PlayerList", sq); }

    public Map<String, PlayerCQ> xdfgetAuthorityCode_NotExistsReferrer_PlayerList() { return xgetSQueMap("authorityCode_NotExistsReferrer_PlayerList"); }
    public String keepAuthorityCode_NotExistsReferrer_PlayerList(PlayerCQ sq) { return xkeepSQue("authorityCode_NotExistsReferrer_PlayerList", sq); }

    public Map<String, PlayerCQ> xdfgetAuthorityCode_SpecifyDerivedReferrer_PlayerList() { return xgetSQueMap("authorityCode_SpecifyDerivedReferrer_PlayerList"); }
    public String keepAuthorityCode_SpecifyDerivedReferrer_PlayerList(PlayerCQ sq) { return xkeepSQue("authorityCode_SpecifyDerivedReferrer_PlayerList", sq); }

    public Map<String, PlayerCQ> xdfgetAuthorityCode_QueryDerivedReferrer_PlayerList() { return xgetSQueMap("authorityCode_QueryDerivedReferrer_PlayerList"); }
    public String keepAuthorityCode_QueryDerivedReferrer_PlayerList(PlayerCQ sq) { return xkeepSQue("authorityCode_QueryDerivedReferrer_PlayerList", sq); }
    public Map<String, Object> xdfgetAuthorityCode_QueryDerivedReferrer_PlayerListParameter() { return xgetSQuePmMap("authorityCode_QueryDerivedReferrer_PlayerList"); }
    public String keepAuthorityCode_QueryDerivedReferrer_PlayerListParameter(Object pm) { return xkeepSQuePm("authorityCode_QueryDerivedReferrer_PlayerList", pm); }

    /**
     * Add order-by as ascend. <br>
     * AUTHORITY_CODE: {PK, NotNull, VARCHAR(20), classification=Authority}
     * @return this. (NotNull)
     */
    public BsAuthorityCQ addOrderBy_AuthorityCode_Asc() { regOBA("AUTHORITY_CODE"); return this; }

    /**
     * Add order-by as descend. <br>
     * AUTHORITY_CODE: {PK, NotNull, VARCHAR(20), classification=Authority}
     * @return this. (NotNull)
     */
    public BsAuthorityCQ addOrderBy_AuthorityCode_Desc() { regOBD("AUTHORITY_CODE"); return this; }

    protected ConditionValue _authorityName;
    public ConditionValue xdfgetAuthorityName()
    { if (_authorityName == null) { _authorityName = nCV(); }
      return _authorityName; }
    protected ConditionValue xgetCValueAuthorityName() { return xdfgetAuthorityName(); }

    /**
     * Add order-by as ascend. <br>
     * AUTHORITY_NAME: {NotNull, VARCHAR(20)}
     * @return this. (NotNull)
     */
    public BsAuthorityCQ addOrderBy_AuthorityName_Asc() { regOBA("AUTHORITY_NAME"); return this; }

    /**
     * Add order-by as descend. <br>
     * AUTHORITY_NAME: {NotNull, VARCHAR(20)}
     * @return this. (NotNull)
     */
    public BsAuthorityCQ addOrderBy_AuthorityName_Desc() { regOBD("AUTHORITY_NAME"); return this; }

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
    public BsAuthorityCQ addSpecifiedDerivedOrderBy_Asc(String aliasName) { registerSpecifiedDerivedOrderBy_Asc(aliasName); return this; }

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
    public BsAuthorityCQ addSpecifiedDerivedOrderBy_Desc(String aliasName) { registerSpecifiedDerivedOrderBy_Desc(aliasName); return this; }

    // ===================================================================================
    //                                                                         Union Query
    //                                                                         ===========
    public void reflectRelationOnUnionQuery(ConditionQuery bqs, ConditionQuery uqs) {
    }

    // ===================================================================================
    //                                                                       Foreign Query
    //                                                                       =============
    protected Map<String, Object> xfindFixedConditionDynamicParameterMap(String property) {
        return null;
    }

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    public Map<String, AuthorityCQ> xdfgetScalarCondition() { return xgetSQueMap("scalarCondition"); }
    public String keepScalarCondition(AuthorityCQ sq) { return xkeepSQue("scalarCondition", sq); }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public Map<String, AuthorityCQ> xdfgetSpecifyMyselfDerived() { return xgetSQueMap("specifyMyselfDerived"); }
    public String keepSpecifyMyselfDerived(AuthorityCQ sq) { return xkeepSQue("specifyMyselfDerived", sq); }

    public Map<String, AuthorityCQ> xdfgetQueryMyselfDerived() { return xgetSQueMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerived(AuthorityCQ sq) { return xkeepSQue("queryMyselfDerived", sq); }
    public Map<String, Object> xdfgetQueryMyselfDerivedParameter() { return xgetSQuePmMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerivedParameter(Object pm) { return xkeepSQuePm("queryMyselfDerived", pm); }

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    protected Map<String, AuthorityCQ> _myselfExistsMap;
    public Map<String, AuthorityCQ> xdfgetMyselfExists() { return xgetSQueMap("myselfExists"); }
    public String keepMyselfExists(AuthorityCQ sq) { return xkeepSQue("myselfExists", sq); }

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    public Map<String, AuthorityCQ> xdfgetMyselfInScope() { return xgetSQueMap("myselfInScope"); }
    public String keepMyselfInScope(AuthorityCQ sq) { return xkeepSQue("myselfInScope", sq); }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xCB() { return AuthorityCB.class.getName(); }
    protected String xCQ() { return AuthorityCQ.class.getName(); }
    protected String xCHp() { return HpQDRFunction.class.getName(); }
    protected String xCOp() { return ConditionOption.class.getName(); }
    protected String xMap() { return Map.class.getName(); }
}
