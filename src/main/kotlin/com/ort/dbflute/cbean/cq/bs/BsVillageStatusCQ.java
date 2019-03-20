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
 * The base condition-query of village_status.
 * @author DBFlute(AutoGenerator)
 */
public class BsVillageStatusCQ extends AbstractBsVillageStatusCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected VillageStatusCIQ _inlineQuery;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsVillageStatusCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                 InlineView/OrClause
    //                                                                 ===================
    /**
     * Prepare InlineView query. <br>
     * {select ... from ... left outer join (select * from village_status) where FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">inline()</span>.setFoo...;
     * </pre>
     * @return The condition-query for InlineView query. (NotNull)
     */
    public VillageStatusCIQ inline() {
        if (_inlineQuery == null) { _inlineQuery = xcreateCIQ(); }
        _inlineQuery.xsetOnClause(false); return _inlineQuery;
    }

    protected VillageStatusCIQ xcreateCIQ() {
        VillageStatusCIQ ciq = xnewCIQ();
        ciq.xsetBaseCB(_baseCB);
        return ciq;
    }

    protected VillageStatusCIQ xnewCIQ() {
        return new VillageStatusCIQ(xgetReferrerQuery(), xgetSqlClause(), xgetAliasName(), xgetNestLevel(), this);
    }

    /**
     * Prepare OnClause query. <br>
     * {select ... from ... left outer join village_status on ... and FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">on()</span>.setFoo...;
     * </pre>
     * @return The condition-query for OnClause query. (NotNull)
     * @throws IllegalConditionBeanOperationException When this condition-query is base query.
     */
    public VillageStatusCIQ on() {
        if (isBaseQuery()) { throw new IllegalConditionBeanOperationException("OnClause for local table is unavailable!"); }
        VillageStatusCIQ inlineQuery = inline(); inlineQuery.xsetOnClause(true); return inlineQuery;
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    protected ConditionValue _villageStatusCode;
    public ConditionValue xdfgetVillageStatusCode()
    { if (_villageStatusCode == null) { _villageStatusCode = nCV(); }
      return _villageStatusCode; }
    protected ConditionValue xgetCValueVillageStatusCode() { return xdfgetVillageStatusCode(); }

    public Map<String, VillageCQ> xdfgetVillageStatusCode_ExistsReferrer_VillageList() { return xgetSQueMap("villageStatusCode_ExistsReferrer_VillageList"); }
    public String keepVillageStatusCode_ExistsReferrer_VillageList(VillageCQ sq) { return xkeepSQue("villageStatusCode_ExistsReferrer_VillageList", sq); }

    public Map<String, VillageCQ> xdfgetVillageStatusCode_NotExistsReferrer_VillageList() { return xgetSQueMap("villageStatusCode_NotExistsReferrer_VillageList"); }
    public String keepVillageStatusCode_NotExistsReferrer_VillageList(VillageCQ sq) { return xkeepSQue("villageStatusCode_NotExistsReferrer_VillageList", sq); }

    public Map<String, VillageCQ> xdfgetVillageStatusCode_SpecifyDerivedReferrer_VillageList() { return xgetSQueMap("villageStatusCode_SpecifyDerivedReferrer_VillageList"); }
    public String keepVillageStatusCode_SpecifyDerivedReferrer_VillageList(VillageCQ sq) { return xkeepSQue("villageStatusCode_SpecifyDerivedReferrer_VillageList", sq); }

    public Map<String, VillageCQ> xdfgetVillageStatusCode_QueryDerivedReferrer_VillageList() { return xgetSQueMap("villageStatusCode_QueryDerivedReferrer_VillageList"); }
    public String keepVillageStatusCode_QueryDerivedReferrer_VillageList(VillageCQ sq) { return xkeepSQue("villageStatusCode_QueryDerivedReferrer_VillageList", sq); }
    public Map<String, Object> xdfgetVillageStatusCode_QueryDerivedReferrer_VillageListParameter() { return xgetSQuePmMap("villageStatusCode_QueryDerivedReferrer_VillageList"); }
    public String keepVillageStatusCode_QueryDerivedReferrer_VillageListParameter(Object pm) { return xkeepSQuePm("villageStatusCode_QueryDerivedReferrer_VillageList", pm); }

    /** 
     * Add order-by as ascend. <br>
     * VILLAGE_STATUS_CODE: {PK, NotNull, VARCHAR(20), classification=VillageStatus}
     * @return this. (NotNull)
     */
    public BsVillageStatusCQ addOrderBy_VillageStatusCode_Asc() { regOBA("VILLAGE_STATUS_CODE"); return this; }

    /**
     * Add order-by as descend. <br>
     * VILLAGE_STATUS_CODE: {PK, NotNull, VARCHAR(20), classification=VillageStatus}
     * @return this. (NotNull)
     */
    public BsVillageStatusCQ addOrderBy_VillageStatusCode_Desc() { regOBD("VILLAGE_STATUS_CODE"); return this; }

    protected ConditionValue _villageStatusName;
    public ConditionValue xdfgetVillageStatusName()
    { if (_villageStatusName == null) { _villageStatusName = nCV(); }
      return _villageStatusName; }
    protected ConditionValue xgetCValueVillageStatusName() { return xdfgetVillageStatusName(); }

    /** 
     * Add order-by as ascend. <br>
     * VILLAGE_STATUS_NAME: {NotNull, VARCHAR(20)}
     * @return this. (NotNull)
     */
    public BsVillageStatusCQ addOrderBy_VillageStatusName_Asc() { regOBA("VILLAGE_STATUS_NAME"); return this; }

    /**
     * Add order-by as descend. <br>
     * VILLAGE_STATUS_NAME: {NotNull, VARCHAR(20)}
     * @return this. (NotNull)
     */
    public BsVillageStatusCQ addOrderBy_VillageStatusName_Desc() { regOBD("VILLAGE_STATUS_NAME"); return this; }

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
    public BsVillageStatusCQ addSpecifiedDerivedOrderBy_Asc(String aliasName) { registerSpecifiedDerivedOrderBy_Asc(aliasName); return this; }

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
    public BsVillageStatusCQ addSpecifiedDerivedOrderBy_Desc(String aliasName) { registerSpecifiedDerivedOrderBy_Desc(aliasName); return this; }

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
    public Map<String, VillageStatusCQ> xdfgetScalarCondition() { return xgetSQueMap("scalarCondition"); }
    public String keepScalarCondition(VillageStatusCQ sq) { return xkeepSQue("scalarCondition", sq); }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public Map<String, VillageStatusCQ> xdfgetSpecifyMyselfDerived() { return xgetSQueMap("specifyMyselfDerived"); }
    public String keepSpecifyMyselfDerived(VillageStatusCQ sq) { return xkeepSQue("specifyMyselfDerived", sq); }

    public Map<String, VillageStatusCQ> xdfgetQueryMyselfDerived() { return xgetSQueMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerived(VillageStatusCQ sq) { return xkeepSQue("queryMyselfDerived", sq); }
    public Map<String, Object> xdfgetQueryMyselfDerivedParameter() { return xgetSQuePmMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerivedParameter(Object pm) { return xkeepSQuePm("queryMyselfDerived", pm); }

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    protected Map<String, VillageStatusCQ> _myselfExistsMap;
    public Map<String, VillageStatusCQ> xdfgetMyselfExists() { return xgetSQueMap("myselfExists"); }
    public String keepMyselfExists(VillageStatusCQ sq) { return xkeepSQue("myselfExists", sq); }

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    public Map<String, VillageStatusCQ> xdfgetMyselfInScope() { return xgetSQueMap("myselfInScope"); }
    public String keepMyselfInScope(VillageStatusCQ sq) { return xkeepSQue("myselfInScope", sq); }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xCB() { return VillageStatusCB.class.getName(); }
    protected String xCQ() { return VillageStatusCQ.class.getName(); }
    protected String xCHp() { return HpQDRFunction.class.getName(); }
    protected String xCOp() { return ConditionOption.class.getName(); }
    protected String xMap() { return Map.class.getName(); }
}
