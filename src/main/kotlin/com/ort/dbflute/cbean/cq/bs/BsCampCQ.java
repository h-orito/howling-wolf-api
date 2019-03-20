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
 * The base condition-query of camp.
 * @author DBFlute(AutoGenerator)
 */
public class BsCampCQ extends AbstractBsCampCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected CampCIQ _inlineQuery;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsCampCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                 InlineView/OrClause
    //                                                                 ===================
    /**
     * Prepare InlineView query. <br>
     * {select ... from ... left outer join (select * from camp) where FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">inline()</span>.setFoo...;
     * </pre>
     * @return The condition-query for InlineView query. (NotNull)
     */
    public CampCIQ inline() {
        if (_inlineQuery == null) { _inlineQuery = xcreateCIQ(); }
        _inlineQuery.xsetOnClause(false); return _inlineQuery;
    }

    protected CampCIQ xcreateCIQ() {
        CampCIQ ciq = xnewCIQ();
        ciq.xsetBaseCB(_baseCB);
        return ciq;
    }

    protected CampCIQ xnewCIQ() {
        return new CampCIQ(xgetReferrerQuery(), xgetSqlClause(), xgetAliasName(), xgetNestLevel(), this);
    }

    /**
     * Prepare OnClause query. <br>
     * {select ... from ... left outer join camp on ... and FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">on()</span>.setFoo...;
     * </pre>
     * @return The condition-query for OnClause query. (NotNull)
     * @throws IllegalConditionBeanOperationException When this condition-query is base query.
     */
    public CampCIQ on() {
        if (isBaseQuery()) { throw new IllegalConditionBeanOperationException("OnClause for local table is unavailable!"); }
        CampCIQ inlineQuery = inline(); inlineQuery.xsetOnClause(true); return inlineQuery;
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    protected ConditionValue _campCode;
    public ConditionValue xdfgetCampCode()
    { if (_campCode == null) { _campCode = nCV(); }
      return _campCode; }
    protected ConditionValue xgetCValueCampCode() { return xdfgetCampCode(); }

    public Map<String, SkillCQ> xdfgetCampCode_ExistsReferrer_SkillList() { return xgetSQueMap("campCode_ExistsReferrer_SkillList"); }
    public String keepCampCode_ExistsReferrer_SkillList(SkillCQ sq) { return xkeepSQue("campCode_ExistsReferrer_SkillList", sq); }

    public Map<String, VillageCQ> xdfgetCampCode_ExistsReferrer_VillageList() { return xgetSQueMap("campCode_ExistsReferrer_VillageList"); }
    public String keepCampCode_ExistsReferrer_VillageList(VillageCQ sq) { return xkeepSQue("campCode_ExistsReferrer_VillageList", sq); }

    public Map<String, SkillCQ> xdfgetCampCode_NotExistsReferrer_SkillList() { return xgetSQueMap("campCode_NotExistsReferrer_SkillList"); }
    public String keepCampCode_NotExistsReferrer_SkillList(SkillCQ sq) { return xkeepSQue("campCode_NotExistsReferrer_SkillList", sq); }

    public Map<String, VillageCQ> xdfgetCampCode_NotExistsReferrer_VillageList() { return xgetSQueMap("campCode_NotExistsReferrer_VillageList"); }
    public String keepCampCode_NotExistsReferrer_VillageList(VillageCQ sq) { return xkeepSQue("campCode_NotExistsReferrer_VillageList", sq); }

    public Map<String, SkillCQ> xdfgetCampCode_SpecifyDerivedReferrer_SkillList() { return xgetSQueMap("campCode_SpecifyDerivedReferrer_SkillList"); }
    public String keepCampCode_SpecifyDerivedReferrer_SkillList(SkillCQ sq) { return xkeepSQue("campCode_SpecifyDerivedReferrer_SkillList", sq); }

    public Map<String, VillageCQ> xdfgetCampCode_SpecifyDerivedReferrer_VillageList() { return xgetSQueMap("campCode_SpecifyDerivedReferrer_VillageList"); }
    public String keepCampCode_SpecifyDerivedReferrer_VillageList(VillageCQ sq) { return xkeepSQue("campCode_SpecifyDerivedReferrer_VillageList", sq); }

    public Map<String, SkillCQ> xdfgetCampCode_QueryDerivedReferrer_SkillList() { return xgetSQueMap("campCode_QueryDerivedReferrer_SkillList"); }
    public String keepCampCode_QueryDerivedReferrer_SkillList(SkillCQ sq) { return xkeepSQue("campCode_QueryDerivedReferrer_SkillList", sq); }
    public Map<String, Object> xdfgetCampCode_QueryDerivedReferrer_SkillListParameter() { return xgetSQuePmMap("campCode_QueryDerivedReferrer_SkillList"); }
    public String keepCampCode_QueryDerivedReferrer_SkillListParameter(Object pm) { return xkeepSQuePm("campCode_QueryDerivedReferrer_SkillList", pm); }

    public Map<String, VillageCQ> xdfgetCampCode_QueryDerivedReferrer_VillageList() { return xgetSQueMap("campCode_QueryDerivedReferrer_VillageList"); }
    public String keepCampCode_QueryDerivedReferrer_VillageList(VillageCQ sq) { return xkeepSQue("campCode_QueryDerivedReferrer_VillageList", sq); }
    public Map<String, Object> xdfgetCampCode_QueryDerivedReferrer_VillageListParameter() { return xgetSQuePmMap("campCode_QueryDerivedReferrer_VillageList"); }
    public String keepCampCode_QueryDerivedReferrer_VillageListParameter(Object pm) { return xkeepSQuePm("campCode_QueryDerivedReferrer_VillageList", pm); }

    /** 
     * Add order-by as ascend. <br>
     * CAMP_CODE: {PK, NotNull, VARCHAR(20), classification=Camp}
     * @return this. (NotNull)
     */
    public BsCampCQ addOrderBy_CampCode_Asc() { regOBA("CAMP_CODE"); return this; }

    /**
     * Add order-by as descend. <br>
     * CAMP_CODE: {PK, NotNull, VARCHAR(20), classification=Camp}
     * @return this. (NotNull)
     */
    public BsCampCQ addOrderBy_CampCode_Desc() { regOBD("CAMP_CODE"); return this; }

    protected ConditionValue _campName;
    public ConditionValue xdfgetCampName()
    { if (_campName == null) { _campName = nCV(); }
      return _campName; }
    protected ConditionValue xgetCValueCampName() { return xdfgetCampName(); }

    /** 
     * Add order-by as ascend. <br>
     * CAMP_NAME: {NotNull, VARCHAR(20)}
     * @return this. (NotNull)
     */
    public BsCampCQ addOrderBy_CampName_Asc() { regOBA("CAMP_NAME"); return this; }

    /**
     * Add order-by as descend. <br>
     * CAMP_NAME: {NotNull, VARCHAR(20)}
     * @return this. (NotNull)
     */
    public BsCampCQ addOrderBy_CampName_Desc() { regOBD("CAMP_NAME"); return this; }

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
    public BsCampCQ addSpecifiedDerivedOrderBy_Asc(String aliasName) { registerSpecifiedDerivedOrderBy_Asc(aliasName); return this; }

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
    public BsCampCQ addSpecifiedDerivedOrderBy_Desc(String aliasName) { registerSpecifiedDerivedOrderBy_Desc(aliasName); return this; }

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
    public Map<String, CampCQ> xdfgetScalarCondition() { return xgetSQueMap("scalarCondition"); }
    public String keepScalarCondition(CampCQ sq) { return xkeepSQue("scalarCondition", sq); }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public Map<String, CampCQ> xdfgetSpecifyMyselfDerived() { return xgetSQueMap("specifyMyselfDerived"); }
    public String keepSpecifyMyselfDerived(CampCQ sq) { return xkeepSQue("specifyMyselfDerived", sq); }

    public Map<String, CampCQ> xdfgetQueryMyselfDerived() { return xgetSQueMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerived(CampCQ sq) { return xkeepSQue("queryMyselfDerived", sq); }
    public Map<String, Object> xdfgetQueryMyselfDerivedParameter() { return xgetSQuePmMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerivedParameter(Object pm) { return xkeepSQuePm("queryMyselfDerived", pm); }

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    protected Map<String, CampCQ> _myselfExistsMap;
    public Map<String, CampCQ> xdfgetMyselfExists() { return xgetSQueMap("myselfExists"); }
    public String keepMyselfExists(CampCQ sq) { return xkeepSQue("myselfExists", sq); }

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    public Map<String, CampCQ> xdfgetMyselfInScope() { return xgetSQueMap("myselfInScope"); }
    public String keepMyselfInScope(CampCQ sq) { return xkeepSQue("myselfInScope", sq); }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xCB() { return CampCB.class.getName(); }
    protected String xCQ() { return CampCQ.class.getName(); }
    protected String xCHp() { return HpQDRFunction.class.getName(); }
    protected String xCOp() { return ConditionOption.class.getName(); }
    protected String xMap() { return Map.class.getName(); }
}
