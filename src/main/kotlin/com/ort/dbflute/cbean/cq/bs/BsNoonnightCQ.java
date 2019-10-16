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
 * The base condition-query of noonnight.
 * @author DBFlute(AutoGenerator)
 */
public class BsNoonnightCQ extends AbstractBsNoonnightCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected NoonnightCIQ _inlineQuery;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsNoonnightCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                 InlineView/OrClause
    //                                                                 ===================
    /**
     * Prepare InlineView query. <br>
     * {select ... from ... left outer join (select * from noonnight) where FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">inline()</span>.setFoo...;
     * </pre>
     * @return The condition-query for InlineView query. (NotNull)
     */
    public NoonnightCIQ inline() {
        if (_inlineQuery == null) { _inlineQuery = xcreateCIQ(); }
        _inlineQuery.xsetOnClause(false); return _inlineQuery;
    }

    protected NoonnightCIQ xcreateCIQ() {
        NoonnightCIQ ciq = xnewCIQ();
        ciq.xsetBaseCB(_baseCB);
        return ciq;
    }

    protected NoonnightCIQ xnewCIQ() {
        return new NoonnightCIQ(xgetReferrerQuery(), xgetSqlClause(), xgetAliasName(), xgetNestLevel(), this);
    }

    /**
     * Prepare OnClause query. <br>
     * {select ... from ... left outer join noonnight on ... and FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">on()</span>.setFoo...;
     * </pre>
     * @return The condition-query for OnClause query. (NotNull)
     * @throws IllegalConditionBeanOperationException When this condition-query is base query.
     */
    public NoonnightCIQ on() {
        if (isBaseQuery()) { throw new IllegalConditionBeanOperationException("OnClause for local table is unavailable!"); }
        NoonnightCIQ inlineQuery = inline(); inlineQuery.xsetOnClause(true); return inlineQuery;
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    protected ConditionValue _noonnightCode;
    public ConditionValue xdfgetNoonnightCode()
    { if (_noonnightCode == null) { _noonnightCode = nCV(); }
      return _noonnightCode; }
    protected ConditionValue xgetCValueNoonnightCode() { return xdfgetNoonnightCode(); }

    public Map<String, VillageDayCQ> xdfgetNoonnightCode_ExistsReferrer_VillageDayList() { return xgetSQueMap("noonnightCode_ExistsReferrer_VillageDayList"); }
    public String keepNoonnightCode_ExistsReferrer_VillageDayList(VillageDayCQ sq) { return xkeepSQue("noonnightCode_ExistsReferrer_VillageDayList", sq); }

    public Map<String, VillageDayCQ> xdfgetNoonnightCode_NotExistsReferrer_VillageDayList() { return xgetSQueMap("noonnightCode_NotExistsReferrer_VillageDayList"); }
    public String keepNoonnightCode_NotExistsReferrer_VillageDayList(VillageDayCQ sq) { return xkeepSQue("noonnightCode_NotExistsReferrer_VillageDayList", sq); }

    public Map<String, VillageDayCQ> xdfgetNoonnightCode_SpecifyDerivedReferrer_VillageDayList() { return xgetSQueMap("noonnightCode_SpecifyDerivedReferrer_VillageDayList"); }
    public String keepNoonnightCode_SpecifyDerivedReferrer_VillageDayList(VillageDayCQ sq) { return xkeepSQue("noonnightCode_SpecifyDerivedReferrer_VillageDayList", sq); }

    public Map<String, VillageDayCQ> xdfgetNoonnightCode_QueryDerivedReferrer_VillageDayList() { return xgetSQueMap("noonnightCode_QueryDerivedReferrer_VillageDayList"); }
    public String keepNoonnightCode_QueryDerivedReferrer_VillageDayList(VillageDayCQ sq) { return xkeepSQue("noonnightCode_QueryDerivedReferrer_VillageDayList", sq); }
    public Map<String, Object> xdfgetNoonnightCode_QueryDerivedReferrer_VillageDayListParameter() { return xgetSQuePmMap("noonnightCode_QueryDerivedReferrer_VillageDayList"); }
    public String keepNoonnightCode_QueryDerivedReferrer_VillageDayListParameter(Object pm) { return xkeepSQuePm("noonnightCode_QueryDerivedReferrer_VillageDayList", pm); }

    /** 
     * Add order-by as ascend. <br>
     * NOONNIGHT_CODE: {PK, NotNull, VARCHAR(20)}
     * @return this. (NotNull)
     */
    public BsNoonnightCQ addOrderBy_NoonnightCode_Asc() { regOBA("NOONNIGHT_CODE"); return this; }

    /**
     * Add order-by as descend. <br>
     * NOONNIGHT_CODE: {PK, NotNull, VARCHAR(20)}
     * @return this. (NotNull)
     */
    public BsNoonnightCQ addOrderBy_NoonnightCode_Desc() { regOBD("NOONNIGHT_CODE"); return this; }

    protected ConditionValue _noonnightName;
    public ConditionValue xdfgetNoonnightName()
    { if (_noonnightName == null) { _noonnightName = nCV(); }
      return _noonnightName; }
    protected ConditionValue xgetCValueNoonnightName() { return xdfgetNoonnightName(); }

    /** 
     * Add order-by as ascend. <br>
     * NOONNIGHT_NAME: {NotNull, VARCHAR(20)}
     * @return this. (NotNull)
     */
    public BsNoonnightCQ addOrderBy_NoonnightName_Asc() { regOBA("NOONNIGHT_NAME"); return this; }

    /**
     * Add order-by as descend. <br>
     * NOONNIGHT_NAME: {NotNull, VARCHAR(20)}
     * @return this. (NotNull)
     */
    public BsNoonnightCQ addOrderBy_NoonnightName_Desc() { regOBD("NOONNIGHT_NAME"); return this; }

    protected ConditionValue _dispOrder;
    public ConditionValue xdfgetDispOrder()
    { if (_dispOrder == null) { _dispOrder = nCV(); }
      return _dispOrder; }
    protected ConditionValue xgetCValueDispOrder() { return xdfgetDispOrder(); }

    /** 
     * Add order-by as ascend. <br>
     * DISP_ORDER: {NotNull, INT UNSIGNED(10)}
     * @return this. (NotNull)
     */
    public BsNoonnightCQ addOrderBy_DispOrder_Asc() { regOBA("DISP_ORDER"); return this; }

    /**
     * Add order-by as descend. <br>
     * DISP_ORDER: {NotNull, INT UNSIGNED(10)}
     * @return this. (NotNull)
     */
    public BsNoonnightCQ addOrderBy_DispOrder_Desc() { regOBD("DISP_ORDER"); return this; }

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
    public BsNoonnightCQ addSpecifiedDerivedOrderBy_Asc(String aliasName) { registerSpecifiedDerivedOrderBy_Asc(aliasName); return this; }

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
    public BsNoonnightCQ addSpecifiedDerivedOrderBy_Desc(String aliasName) { registerSpecifiedDerivedOrderBy_Desc(aliasName); return this; }

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
    public Map<String, NoonnightCQ> xdfgetScalarCondition() { return xgetSQueMap("scalarCondition"); }
    public String keepScalarCondition(NoonnightCQ sq) { return xkeepSQue("scalarCondition", sq); }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public Map<String, NoonnightCQ> xdfgetSpecifyMyselfDerived() { return xgetSQueMap("specifyMyselfDerived"); }
    public String keepSpecifyMyselfDerived(NoonnightCQ sq) { return xkeepSQue("specifyMyselfDerived", sq); }

    public Map<String, NoonnightCQ> xdfgetQueryMyselfDerived() { return xgetSQueMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerived(NoonnightCQ sq) { return xkeepSQue("queryMyselfDerived", sq); }
    public Map<String, Object> xdfgetQueryMyselfDerivedParameter() { return xgetSQuePmMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerivedParameter(Object pm) { return xkeepSQuePm("queryMyselfDerived", pm); }

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    protected Map<String, NoonnightCQ> _myselfExistsMap;
    public Map<String, NoonnightCQ> xdfgetMyselfExists() { return xgetSQueMap("myselfExists"); }
    public String keepMyselfExists(NoonnightCQ sq) { return xkeepSQue("myselfExists", sq); }

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    public Map<String, NoonnightCQ> xdfgetMyselfInScope() { return xgetSQueMap("myselfInScope"); }
    public String keepMyselfInScope(NoonnightCQ sq) { return xkeepSQue("myselfInScope", sq); }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xCB() { return NoonnightCB.class.getName(); }
    protected String xCQ() { return NoonnightCQ.class.getName(); }
    protected String xCHp() { return HpQDRFunction.class.getName(); }
    protected String xCOp() { return ConditionOption.class.getName(); }
    protected String xMap() { return Map.class.getName(); }
}
