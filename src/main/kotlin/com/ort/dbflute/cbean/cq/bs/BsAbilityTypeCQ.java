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
 * The base condition-query of ability_type.
 * @author DBFlute(AutoGenerator)
 */
public class BsAbilityTypeCQ extends AbstractBsAbilityTypeCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected AbilityTypeCIQ _inlineQuery;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsAbilityTypeCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                 InlineView/OrClause
    //                                                                 ===================
    /**
     * Prepare InlineView query. <br>
     * {select ... from ... left outer join (select * from ability_type) where FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">inline()</span>.setFoo...;
     * </pre>
     * @return The condition-query for InlineView query. (NotNull)
     */
    public AbilityTypeCIQ inline() {
        if (_inlineQuery == null) { _inlineQuery = xcreateCIQ(); }
        _inlineQuery.xsetOnClause(false); return _inlineQuery;
    }

    protected AbilityTypeCIQ xcreateCIQ() {
        AbilityTypeCIQ ciq = xnewCIQ();
        ciq.xsetBaseCB(_baseCB);
        return ciq;
    }

    protected AbilityTypeCIQ xnewCIQ() {
        return new AbilityTypeCIQ(xgetReferrerQuery(), xgetSqlClause(), xgetAliasName(), xgetNestLevel(), this);
    }

    /**
     * Prepare OnClause query. <br>
     * {select ... from ... left outer join ability_type on ... and FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">on()</span>.setFoo...;
     * </pre>
     * @return The condition-query for OnClause query. (NotNull)
     * @throws IllegalConditionBeanOperationException When this condition-query is base query.
     */
    public AbilityTypeCIQ on() {
        if (isBaseQuery()) { throw new IllegalConditionBeanOperationException("OnClause for local table is unavailable!"); }
        AbilityTypeCIQ inlineQuery = inline(); inlineQuery.xsetOnClause(true); return inlineQuery;
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    protected ConditionValue _abilityTypeCode;
    public ConditionValue xdfgetAbilityTypeCode()
    { if (_abilityTypeCode == null) { _abilityTypeCode = nCV(); }
      return _abilityTypeCode; }
    protected ConditionValue xgetCValueAbilityTypeCode() { return xdfgetAbilityTypeCode(); }

    public Map<String, AbilityCQ> xdfgetAbilityTypeCode_ExistsReferrer_AbilityList() { return xgetSQueMap("abilityTypeCode_ExistsReferrer_AbilityList"); }
    public String keepAbilityTypeCode_ExistsReferrer_AbilityList(AbilityCQ sq) { return xkeepSQue("abilityTypeCode_ExistsReferrer_AbilityList", sq); }

    public Map<String, AbilityCQ> xdfgetAbilityTypeCode_NotExistsReferrer_AbilityList() { return xgetSQueMap("abilityTypeCode_NotExistsReferrer_AbilityList"); }
    public String keepAbilityTypeCode_NotExistsReferrer_AbilityList(AbilityCQ sq) { return xkeepSQue("abilityTypeCode_NotExistsReferrer_AbilityList", sq); }

    public Map<String, AbilityCQ> xdfgetAbilityTypeCode_SpecifyDerivedReferrer_AbilityList() { return xgetSQueMap("abilityTypeCode_SpecifyDerivedReferrer_AbilityList"); }
    public String keepAbilityTypeCode_SpecifyDerivedReferrer_AbilityList(AbilityCQ sq) { return xkeepSQue("abilityTypeCode_SpecifyDerivedReferrer_AbilityList", sq); }

    public Map<String, AbilityCQ> xdfgetAbilityTypeCode_QueryDerivedReferrer_AbilityList() { return xgetSQueMap("abilityTypeCode_QueryDerivedReferrer_AbilityList"); }
    public String keepAbilityTypeCode_QueryDerivedReferrer_AbilityList(AbilityCQ sq) { return xkeepSQue("abilityTypeCode_QueryDerivedReferrer_AbilityList", sq); }
    public Map<String, Object> xdfgetAbilityTypeCode_QueryDerivedReferrer_AbilityListParameter() { return xgetSQuePmMap("abilityTypeCode_QueryDerivedReferrer_AbilityList"); }
    public String keepAbilityTypeCode_QueryDerivedReferrer_AbilityListParameter(Object pm) { return xkeepSQuePm("abilityTypeCode_QueryDerivedReferrer_AbilityList", pm); }

    /**
     * Add order-by as ascend. <br>
     * ABILITY_TYPE_CODE: {PK, NotNull, VARCHAR(20), classification=AbilityType}
     * @return this. (NotNull)
     */
    public BsAbilityTypeCQ addOrderBy_AbilityTypeCode_Asc() { regOBA("ABILITY_TYPE_CODE"); return this; }

    /**
     * Add order-by as descend. <br>
     * ABILITY_TYPE_CODE: {PK, NotNull, VARCHAR(20), classification=AbilityType}
     * @return this. (NotNull)
     */
    public BsAbilityTypeCQ addOrderBy_AbilityTypeCode_Desc() { regOBD("ABILITY_TYPE_CODE"); return this; }

    protected ConditionValue _abilityTypeName;
    public ConditionValue xdfgetAbilityTypeName()
    { if (_abilityTypeName == null) { _abilityTypeName = nCV(); }
      return _abilityTypeName; }
    protected ConditionValue xgetCValueAbilityTypeName() { return xdfgetAbilityTypeName(); }

    /**
     * Add order-by as ascend. <br>
     * ABILITY_TYPE_NAME: {NotNull, VARCHAR(20)}
     * @return this. (NotNull)
     */
    public BsAbilityTypeCQ addOrderBy_AbilityTypeName_Asc() { regOBA("ABILITY_TYPE_NAME"); return this; }

    /**
     * Add order-by as descend. <br>
     * ABILITY_TYPE_NAME: {NotNull, VARCHAR(20)}
     * @return this. (NotNull)
     */
    public BsAbilityTypeCQ addOrderBy_AbilityTypeName_Desc() { regOBD("ABILITY_TYPE_NAME"); return this; }

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
    public BsAbilityTypeCQ addSpecifiedDerivedOrderBy_Asc(String aliasName) { registerSpecifiedDerivedOrderBy_Asc(aliasName); return this; }

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
    public BsAbilityTypeCQ addSpecifiedDerivedOrderBy_Desc(String aliasName) { registerSpecifiedDerivedOrderBy_Desc(aliasName); return this; }

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
    public Map<String, AbilityTypeCQ> xdfgetScalarCondition() { return xgetSQueMap("scalarCondition"); }
    public String keepScalarCondition(AbilityTypeCQ sq) { return xkeepSQue("scalarCondition", sq); }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public Map<String, AbilityTypeCQ> xdfgetSpecifyMyselfDerived() { return xgetSQueMap("specifyMyselfDerived"); }
    public String keepSpecifyMyselfDerived(AbilityTypeCQ sq) { return xkeepSQue("specifyMyselfDerived", sq); }

    public Map<String, AbilityTypeCQ> xdfgetQueryMyselfDerived() { return xgetSQueMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerived(AbilityTypeCQ sq) { return xkeepSQue("queryMyselfDerived", sq); }
    public Map<String, Object> xdfgetQueryMyselfDerivedParameter() { return xgetSQuePmMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerivedParameter(Object pm) { return xkeepSQuePm("queryMyselfDerived", pm); }

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    protected Map<String, AbilityTypeCQ> _myselfExistsMap;
    public Map<String, AbilityTypeCQ> xdfgetMyselfExists() { return xgetSQueMap("myselfExists"); }
    public String keepMyselfExists(AbilityTypeCQ sq) { return xkeepSQue("myselfExists", sq); }

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    public Map<String, AbilityTypeCQ> xdfgetMyselfInScope() { return xgetSQueMap("myselfInScope"); }
    public String keepMyselfInScope(AbilityTypeCQ sq) { return xkeepSQue("myselfInScope", sq); }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xCB() { return AbilityTypeCB.class.getName(); }
    protected String xCQ() { return AbilityTypeCQ.class.getName(); }
    protected String xCHp() { return HpQDRFunction.class.getName(); }
    protected String xCOp() { return ConditionOption.class.getName(); }
    protected String xMap() { return Map.class.getName(); }
}
