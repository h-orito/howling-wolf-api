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
 * The base condition-query of village_setting_item.
 * @author DBFlute(AutoGenerator)
 */
public class BsVillageSettingItemCQ extends AbstractBsVillageSettingItemCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected VillageSettingItemCIQ _inlineQuery;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsVillageSettingItemCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                 InlineView/OrClause
    //                                                                 ===================
    /**
     * Prepare InlineView query. <br>
     * {select ... from ... left outer join (select * from village_setting_item) where FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">inline()</span>.setFoo...;
     * </pre>
     * @return The condition-query for InlineView query. (NotNull)
     */
    public VillageSettingItemCIQ inline() {
        if (_inlineQuery == null) { _inlineQuery = xcreateCIQ(); }
        _inlineQuery.xsetOnClause(false); return _inlineQuery;
    }

    protected VillageSettingItemCIQ xcreateCIQ() {
        VillageSettingItemCIQ ciq = xnewCIQ();
        ciq.xsetBaseCB(_baseCB);
        return ciq;
    }

    protected VillageSettingItemCIQ xnewCIQ() {
        return new VillageSettingItemCIQ(xgetReferrerQuery(), xgetSqlClause(), xgetAliasName(), xgetNestLevel(), this);
    }

    /**
     * Prepare OnClause query. <br>
     * {select ... from ... left outer join village_setting_item on ... and FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">on()</span>.setFoo...;
     * </pre>
     * @return The condition-query for OnClause query. (NotNull)
     * @throws IllegalConditionBeanOperationException When this condition-query is base query.
     */
    public VillageSettingItemCIQ on() {
        if (isBaseQuery()) { throw new IllegalConditionBeanOperationException("OnClause for local table is unavailable!"); }
        VillageSettingItemCIQ inlineQuery = inline(); inlineQuery.xsetOnClause(true); return inlineQuery;
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    protected ConditionValue _villageSettingItemCode;
    public ConditionValue xdfgetVillageSettingItemCode()
    { if (_villageSettingItemCode == null) { _villageSettingItemCode = nCV(); }
      return _villageSettingItemCode; }
    protected ConditionValue xgetCValueVillageSettingItemCode() { return xdfgetVillageSettingItemCode(); }

    public Map<String, VillageSettingCQ> xdfgetVillageSettingItemCode_ExistsReferrer_VillageSettingList() { return xgetSQueMap("villageSettingItemCode_ExistsReferrer_VillageSettingList"); }
    public String keepVillageSettingItemCode_ExistsReferrer_VillageSettingList(VillageSettingCQ sq) { return xkeepSQue("villageSettingItemCode_ExistsReferrer_VillageSettingList", sq); }

    public Map<String, VillageSettingCQ> xdfgetVillageSettingItemCode_NotExistsReferrer_VillageSettingList() { return xgetSQueMap("villageSettingItemCode_NotExistsReferrer_VillageSettingList"); }
    public String keepVillageSettingItemCode_NotExistsReferrer_VillageSettingList(VillageSettingCQ sq) { return xkeepSQue("villageSettingItemCode_NotExistsReferrer_VillageSettingList", sq); }

    public Map<String, VillageSettingCQ> xdfgetVillageSettingItemCode_SpecifyDerivedReferrer_VillageSettingList() { return xgetSQueMap("villageSettingItemCode_SpecifyDerivedReferrer_VillageSettingList"); }
    public String keepVillageSettingItemCode_SpecifyDerivedReferrer_VillageSettingList(VillageSettingCQ sq) { return xkeepSQue("villageSettingItemCode_SpecifyDerivedReferrer_VillageSettingList", sq); }

    public Map<String, VillageSettingCQ> xdfgetVillageSettingItemCode_QueryDerivedReferrer_VillageSettingList() { return xgetSQueMap("villageSettingItemCode_QueryDerivedReferrer_VillageSettingList"); }
    public String keepVillageSettingItemCode_QueryDerivedReferrer_VillageSettingList(VillageSettingCQ sq) { return xkeepSQue("villageSettingItemCode_QueryDerivedReferrer_VillageSettingList", sq); }
    public Map<String, Object> xdfgetVillageSettingItemCode_QueryDerivedReferrer_VillageSettingListParameter() { return xgetSQuePmMap("villageSettingItemCode_QueryDerivedReferrer_VillageSettingList"); }
    public String keepVillageSettingItemCode_QueryDerivedReferrer_VillageSettingListParameter(Object pm) { return xkeepSQuePm("villageSettingItemCode_QueryDerivedReferrer_VillageSettingList", pm); }

    /** 
     * Add order-by as ascend. <br>
     * VILLAGE_SETTING_ITEM_CODE: {PK, NotNull, VARCHAR(100), classification=VillageSettingItem}
     * @return this. (NotNull)
     */
    public BsVillageSettingItemCQ addOrderBy_VillageSettingItemCode_Asc() { regOBA("VILLAGE_SETTING_ITEM_CODE"); return this; }

    /**
     * Add order-by as descend. <br>
     * VILLAGE_SETTING_ITEM_CODE: {PK, NotNull, VARCHAR(100), classification=VillageSettingItem}
     * @return this. (NotNull)
     */
    public BsVillageSettingItemCQ addOrderBy_VillageSettingItemCode_Desc() { regOBD("VILLAGE_SETTING_ITEM_CODE"); return this; }

    protected ConditionValue _villageSettingItemName;
    public ConditionValue xdfgetVillageSettingItemName()
    { if (_villageSettingItemName == null) { _villageSettingItemName = nCV(); }
      return _villageSettingItemName; }
    protected ConditionValue xgetCValueVillageSettingItemName() { return xdfgetVillageSettingItemName(); }

    /** 
     * Add order-by as ascend. <br>
     * VILLAGE_SETTING_ITEM_NAME: {NotNull, VARCHAR(20)}
     * @return this. (NotNull)
     */
    public BsVillageSettingItemCQ addOrderBy_VillageSettingItemName_Asc() { regOBA("VILLAGE_SETTING_ITEM_NAME"); return this; }

    /**
     * Add order-by as descend. <br>
     * VILLAGE_SETTING_ITEM_NAME: {NotNull, VARCHAR(20)}
     * @return this. (NotNull)
     */
    public BsVillageSettingItemCQ addOrderBy_VillageSettingItemName_Desc() { regOBD("VILLAGE_SETTING_ITEM_NAME"); return this; }

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
    public BsVillageSettingItemCQ addOrderBy_DispOrder_Asc() { regOBA("DISP_ORDER"); return this; }

    /**
     * Add order-by as descend. <br>
     * DISP_ORDER: {NotNull, INT UNSIGNED(10)}
     * @return this. (NotNull)
     */
    public BsVillageSettingItemCQ addOrderBy_DispOrder_Desc() { regOBD("DISP_ORDER"); return this; }

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
    public BsVillageSettingItemCQ addSpecifiedDerivedOrderBy_Asc(String aliasName) { registerSpecifiedDerivedOrderBy_Asc(aliasName); return this; }

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
    public BsVillageSettingItemCQ addSpecifiedDerivedOrderBy_Desc(String aliasName) { registerSpecifiedDerivedOrderBy_Desc(aliasName); return this; }

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
    public Map<String, VillageSettingItemCQ> xdfgetScalarCondition() { return xgetSQueMap("scalarCondition"); }
    public String keepScalarCondition(VillageSettingItemCQ sq) { return xkeepSQue("scalarCondition", sq); }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public Map<String, VillageSettingItemCQ> xdfgetSpecifyMyselfDerived() { return xgetSQueMap("specifyMyselfDerived"); }
    public String keepSpecifyMyselfDerived(VillageSettingItemCQ sq) { return xkeepSQue("specifyMyselfDerived", sq); }

    public Map<String, VillageSettingItemCQ> xdfgetQueryMyselfDerived() { return xgetSQueMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerived(VillageSettingItemCQ sq) { return xkeepSQue("queryMyselfDerived", sq); }
    public Map<String, Object> xdfgetQueryMyselfDerivedParameter() { return xgetSQuePmMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerivedParameter(Object pm) { return xkeepSQuePm("queryMyselfDerived", pm); }

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    protected Map<String, VillageSettingItemCQ> _myselfExistsMap;
    public Map<String, VillageSettingItemCQ> xdfgetMyselfExists() { return xgetSQueMap("myselfExists"); }
    public String keepMyselfExists(VillageSettingItemCQ sq) { return xkeepSQue("myselfExists", sq); }

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    public Map<String, VillageSettingItemCQ> xdfgetMyselfInScope() { return xgetSQueMap("myselfInScope"); }
    public String keepMyselfInScope(VillageSettingItemCQ sq) { return xkeepSQue("myselfInScope", sq); }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xCB() { return VillageSettingItemCB.class.getName(); }
    protected String xCQ() { return VillageSettingItemCQ.class.getName(); }
    protected String xCHp() { return HpQDRFunction.class.getName(); }
    protected String xCOp() { return ConditionOption.class.getName(); }
    protected String xMap() { return Map.class.getName(); }
}
