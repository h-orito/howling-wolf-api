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
 * The base condition-query of allowed_secret_say.
 * @author DBFlute(AutoGenerator)
 */
public class BsAllowedSecretSayCQ extends AbstractBsAllowedSecretSayCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected AllowedSecretSayCIQ _inlineQuery;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsAllowedSecretSayCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                 InlineView/OrClause
    //                                                                 ===================
    /**
     * Prepare InlineView query. <br>
     * {select ... from ... left outer join (select * from allowed_secret_say) where FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">inline()</span>.setFoo...;
     * </pre>
     * @return The condition-query for InlineView query. (NotNull)
     */
    public AllowedSecretSayCIQ inline() {
        if (_inlineQuery == null) { _inlineQuery = xcreateCIQ(); }
        _inlineQuery.xsetOnClause(false); return _inlineQuery;
    }

    protected AllowedSecretSayCIQ xcreateCIQ() {
        AllowedSecretSayCIQ ciq = xnewCIQ();
        ciq.xsetBaseCB(_baseCB);
        return ciq;
    }

    protected AllowedSecretSayCIQ xnewCIQ() {
        return new AllowedSecretSayCIQ(xgetReferrerQuery(), xgetSqlClause(), xgetAliasName(), xgetNestLevel(), this);
    }

    /**
     * Prepare OnClause query. <br>
     * {select ... from ... left outer join allowed_secret_say on ... and FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">on()</span>.setFoo...;
     * </pre>
     * @return The condition-query for OnClause query. (NotNull)
     * @throws IllegalConditionBeanOperationException When this condition-query is base query.
     */
    public AllowedSecretSayCIQ on() {
        if (isBaseQuery()) { throw new IllegalConditionBeanOperationException("OnClause for local table is unavailable!"); }
        AllowedSecretSayCIQ inlineQuery = inline(); inlineQuery.xsetOnClause(true); return inlineQuery;
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    protected ConditionValue _allowedSecretSayCode;
    public ConditionValue xdfgetAllowedSecretSayCode()
    { if (_allowedSecretSayCode == null) { _allowedSecretSayCode = nCV(); }
      return _allowedSecretSayCode; }
    protected ConditionValue xgetCValueAllowedSecretSayCode() { return xdfgetAllowedSecretSayCode(); }

    public Map<String, VillageSettingsCQ> xdfgetAllowedSecretSayCode_ExistsReferrer_VillageSettingsList() { return xgetSQueMap("allowedSecretSayCode_ExistsReferrer_VillageSettingsList"); }
    public String keepAllowedSecretSayCode_ExistsReferrer_VillageSettingsList(VillageSettingsCQ sq) { return xkeepSQue("allowedSecretSayCode_ExistsReferrer_VillageSettingsList", sq); }

    public Map<String, VillageSettingsCQ> xdfgetAllowedSecretSayCode_NotExistsReferrer_VillageSettingsList() { return xgetSQueMap("allowedSecretSayCode_NotExistsReferrer_VillageSettingsList"); }
    public String keepAllowedSecretSayCode_NotExistsReferrer_VillageSettingsList(VillageSettingsCQ sq) { return xkeepSQue("allowedSecretSayCode_NotExistsReferrer_VillageSettingsList", sq); }

    public Map<String, VillageSettingsCQ> xdfgetAllowedSecretSayCode_SpecifyDerivedReferrer_VillageSettingsList() { return xgetSQueMap("allowedSecretSayCode_SpecifyDerivedReferrer_VillageSettingsList"); }
    public String keepAllowedSecretSayCode_SpecifyDerivedReferrer_VillageSettingsList(VillageSettingsCQ sq) { return xkeepSQue("allowedSecretSayCode_SpecifyDerivedReferrer_VillageSettingsList", sq); }

    public Map<String, VillageSettingsCQ> xdfgetAllowedSecretSayCode_QueryDerivedReferrer_VillageSettingsList() { return xgetSQueMap("allowedSecretSayCode_QueryDerivedReferrer_VillageSettingsList"); }
    public String keepAllowedSecretSayCode_QueryDerivedReferrer_VillageSettingsList(VillageSettingsCQ sq) { return xkeepSQue("allowedSecretSayCode_QueryDerivedReferrer_VillageSettingsList", sq); }
    public Map<String, Object> xdfgetAllowedSecretSayCode_QueryDerivedReferrer_VillageSettingsListParameter() { return xgetSQuePmMap("allowedSecretSayCode_QueryDerivedReferrer_VillageSettingsList"); }
    public String keepAllowedSecretSayCode_QueryDerivedReferrer_VillageSettingsListParameter(Object pm) { return xkeepSQuePm("allowedSecretSayCode_QueryDerivedReferrer_VillageSettingsList", pm); }

    /** 
     * Add order-by as ascend. <br>
     * ALLOWED_SECRET_SAY_CODE: {PK, NotNull, VARCHAR(20), classification=AllowedSecretSay}
     * @return this. (NotNull)
     */
    public BsAllowedSecretSayCQ addOrderBy_AllowedSecretSayCode_Asc() { regOBA("ALLOWED_SECRET_SAY_CODE"); return this; }

    /**
     * Add order-by as descend. <br>
     * ALLOWED_SECRET_SAY_CODE: {PK, NotNull, VARCHAR(20), classification=AllowedSecretSay}
     * @return this. (NotNull)
     */
    public BsAllowedSecretSayCQ addOrderBy_AllowedSecretSayCode_Desc() { regOBD("ALLOWED_SECRET_SAY_CODE"); return this; }

    protected ConditionValue _allowedSecretSayName;
    public ConditionValue xdfgetAllowedSecretSayName()
    { if (_allowedSecretSayName == null) { _allowedSecretSayName = nCV(); }
      return _allowedSecretSayName; }
    protected ConditionValue xgetCValueAllowedSecretSayName() { return xdfgetAllowedSecretSayName(); }

    /** 
     * Add order-by as ascend. <br>
     * ALLOWED_SECRET_SAY_NAME: {NotNull, VARCHAR(20)}
     * @return this. (NotNull)
     */
    public BsAllowedSecretSayCQ addOrderBy_AllowedSecretSayName_Asc() { regOBA("ALLOWED_SECRET_SAY_NAME"); return this; }

    /**
     * Add order-by as descend. <br>
     * ALLOWED_SECRET_SAY_NAME: {NotNull, VARCHAR(20)}
     * @return this. (NotNull)
     */
    public BsAllowedSecretSayCQ addOrderBy_AllowedSecretSayName_Desc() { regOBD("ALLOWED_SECRET_SAY_NAME"); return this; }

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
    public BsAllowedSecretSayCQ addSpecifiedDerivedOrderBy_Asc(String aliasName) { registerSpecifiedDerivedOrderBy_Asc(aliasName); return this; }

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
    public BsAllowedSecretSayCQ addSpecifiedDerivedOrderBy_Desc(String aliasName) { registerSpecifiedDerivedOrderBy_Desc(aliasName); return this; }

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
    public Map<String, AllowedSecretSayCQ> xdfgetScalarCondition() { return xgetSQueMap("scalarCondition"); }
    public String keepScalarCondition(AllowedSecretSayCQ sq) { return xkeepSQue("scalarCondition", sq); }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public Map<String, AllowedSecretSayCQ> xdfgetSpecifyMyselfDerived() { return xgetSQueMap("specifyMyselfDerived"); }
    public String keepSpecifyMyselfDerived(AllowedSecretSayCQ sq) { return xkeepSQue("specifyMyselfDerived", sq); }

    public Map<String, AllowedSecretSayCQ> xdfgetQueryMyselfDerived() { return xgetSQueMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerived(AllowedSecretSayCQ sq) { return xkeepSQue("queryMyselfDerived", sq); }
    public Map<String, Object> xdfgetQueryMyselfDerivedParameter() { return xgetSQuePmMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerivedParameter(Object pm) { return xkeepSQuePm("queryMyselfDerived", pm); }

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    protected Map<String, AllowedSecretSayCQ> _myselfExistsMap;
    public Map<String, AllowedSecretSayCQ> xdfgetMyselfExists() { return xgetSQueMap("myselfExists"); }
    public String keepMyselfExists(AllowedSecretSayCQ sq) { return xkeepSQue("myselfExists", sq); }

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    public Map<String, AllowedSecretSayCQ> xdfgetMyselfInScope() { return xgetSQueMap("myselfInScope"); }
    public String keepMyselfInScope(AllowedSecretSayCQ sq) { return xkeepSQue("myselfInScope", sq); }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xCB() { return AllowedSecretSayCB.class.getName(); }
    protected String xCQ() { return AllowedSecretSayCQ.class.getName(); }
    protected String xCHp() { return HpQDRFunction.class.getName(); }
    protected String xCOp() { return ConditionOption.class.getName(); }
    protected String xMap() { return Map.class.getName(); }
}
