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
 * The base condition-query of chara_group.
 * @author DBFlute(AutoGenerator)
 */
public class BsCharaGroupCQ extends AbstractBsCharaGroupCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected CharaGroupCIQ _inlineQuery;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsCharaGroupCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                 InlineView/OrClause
    //                                                                 ===================
    /**
     * Prepare InlineView query. <br>
     * {select ... from ... left outer join (select * from chara_group) where FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">inline()</span>.setFoo...;
     * </pre>
     * @return The condition-query for InlineView query. (NotNull)
     */
    public CharaGroupCIQ inline() {
        if (_inlineQuery == null) { _inlineQuery = xcreateCIQ(); }
        _inlineQuery.xsetOnClause(false); return _inlineQuery;
    }

    protected CharaGroupCIQ xcreateCIQ() {
        CharaGroupCIQ ciq = xnewCIQ();
        ciq.xsetBaseCB(_baseCB);
        return ciq;
    }

    protected CharaGroupCIQ xnewCIQ() {
        return new CharaGroupCIQ(xgetReferrerQuery(), xgetSqlClause(), xgetAliasName(), xgetNestLevel(), this);
    }

    /**
     * Prepare OnClause query. <br>
     * {select ... from ... left outer join chara_group on ... and FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">on()</span>.setFoo...;
     * </pre>
     * @return The condition-query for OnClause query. (NotNull)
     * @throws IllegalConditionBeanOperationException When this condition-query is base query.
     */
    public CharaGroupCIQ on() {
        if (isBaseQuery()) { throw new IllegalConditionBeanOperationException("OnClause for local table is unavailable!"); }
        CharaGroupCIQ inlineQuery = inline(); inlineQuery.xsetOnClause(true); return inlineQuery;
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    protected ConditionValue _charaGroupId;
    public ConditionValue xdfgetCharaGroupId()
    { if (_charaGroupId == null) { _charaGroupId = nCV(); }
      return _charaGroupId; }
    protected ConditionValue xgetCValueCharaGroupId() { return xdfgetCharaGroupId(); }

    public Map<String, CharaCQ> xdfgetCharaGroupId_ExistsReferrer_CharaList() { return xgetSQueMap("charaGroupId_ExistsReferrer_CharaList"); }
    public String keepCharaGroupId_ExistsReferrer_CharaList(CharaCQ sq) { return xkeepSQue("charaGroupId_ExistsReferrer_CharaList", sq); }

    public Map<String, VillageSettingsCQ> xdfgetCharaGroupId_ExistsReferrer_VillageSettingsList() { return xgetSQueMap("charaGroupId_ExistsReferrer_VillageSettingsList"); }
    public String keepCharaGroupId_ExistsReferrer_VillageSettingsList(VillageSettingsCQ sq) { return xkeepSQue("charaGroupId_ExistsReferrer_VillageSettingsList", sq); }

    public Map<String, CharaCQ> xdfgetCharaGroupId_NotExistsReferrer_CharaList() { return xgetSQueMap("charaGroupId_NotExistsReferrer_CharaList"); }
    public String keepCharaGroupId_NotExistsReferrer_CharaList(CharaCQ sq) { return xkeepSQue("charaGroupId_NotExistsReferrer_CharaList", sq); }

    public Map<String, VillageSettingsCQ> xdfgetCharaGroupId_NotExistsReferrer_VillageSettingsList() { return xgetSQueMap("charaGroupId_NotExistsReferrer_VillageSettingsList"); }
    public String keepCharaGroupId_NotExistsReferrer_VillageSettingsList(VillageSettingsCQ sq) { return xkeepSQue("charaGroupId_NotExistsReferrer_VillageSettingsList", sq); }

    public Map<String, CharaCQ> xdfgetCharaGroupId_SpecifyDerivedReferrer_CharaList() { return xgetSQueMap("charaGroupId_SpecifyDerivedReferrer_CharaList"); }
    public String keepCharaGroupId_SpecifyDerivedReferrer_CharaList(CharaCQ sq) { return xkeepSQue("charaGroupId_SpecifyDerivedReferrer_CharaList", sq); }

    public Map<String, VillageSettingsCQ> xdfgetCharaGroupId_SpecifyDerivedReferrer_VillageSettingsList() { return xgetSQueMap("charaGroupId_SpecifyDerivedReferrer_VillageSettingsList"); }
    public String keepCharaGroupId_SpecifyDerivedReferrer_VillageSettingsList(VillageSettingsCQ sq) { return xkeepSQue("charaGroupId_SpecifyDerivedReferrer_VillageSettingsList", sq); }

    public Map<String, CharaCQ> xdfgetCharaGroupId_QueryDerivedReferrer_CharaList() { return xgetSQueMap("charaGroupId_QueryDerivedReferrer_CharaList"); }
    public String keepCharaGroupId_QueryDerivedReferrer_CharaList(CharaCQ sq) { return xkeepSQue("charaGroupId_QueryDerivedReferrer_CharaList", sq); }
    public Map<String, Object> xdfgetCharaGroupId_QueryDerivedReferrer_CharaListParameter() { return xgetSQuePmMap("charaGroupId_QueryDerivedReferrer_CharaList"); }
    public String keepCharaGroupId_QueryDerivedReferrer_CharaListParameter(Object pm) { return xkeepSQuePm("charaGroupId_QueryDerivedReferrer_CharaList", pm); }

    public Map<String, VillageSettingsCQ> xdfgetCharaGroupId_QueryDerivedReferrer_VillageSettingsList() { return xgetSQueMap("charaGroupId_QueryDerivedReferrer_VillageSettingsList"); }
    public String keepCharaGroupId_QueryDerivedReferrer_VillageSettingsList(VillageSettingsCQ sq) { return xkeepSQue("charaGroupId_QueryDerivedReferrer_VillageSettingsList", sq); }
    public Map<String, Object> xdfgetCharaGroupId_QueryDerivedReferrer_VillageSettingsListParameter() { return xgetSQuePmMap("charaGroupId_QueryDerivedReferrer_VillageSettingsList"); }
    public String keepCharaGroupId_QueryDerivedReferrer_VillageSettingsListParameter(Object pm) { return xkeepSQuePm("charaGroupId_QueryDerivedReferrer_VillageSettingsList", pm); }

    /** 
     * Add order-by as ascend. <br>
     * CHARA_GROUP_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @return this. (NotNull)
     */
    public BsCharaGroupCQ addOrderBy_CharaGroupId_Asc() { regOBA("CHARA_GROUP_ID"); return this; }

    /**
     * Add order-by as descend. <br>
     * CHARA_GROUP_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @return this. (NotNull)
     */
    public BsCharaGroupCQ addOrderBy_CharaGroupId_Desc() { regOBD("CHARA_GROUP_ID"); return this; }

    protected ConditionValue _charaGroupName;
    public ConditionValue xdfgetCharaGroupName()
    { if (_charaGroupName == null) { _charaGroupName = nCV(); }
      return _charaGroupName; }
    protected ConditionValue xgetCValueCharaGroupName() { return xdfgetCharaGroupName(); }

    /** 
     * Add order-by as ascend. <br>
     * CHARA_GROUP_NAME: {NotNull, VARCHAR(40)}
     * @return this. (NotNull)
     */
    public BsCharaGroupCQ addOrderBy_CharaGroupName_Asc() { regOBA("CHARA_GROUP_NAME"); return this; }

    /**
     * Add order-by as descend. <br>
     * CHARA_GROUP_NAME: {NotNull, VARCHAR(40)}
     * @return this. (NotNull)
     */
    public BsCharaGroupCQ addOrderBy_CharaGroupName_Desc() { regOBD("CHARA_GROUP_NAME"); return this; }

    protected ConditionValue _designerId;
    public ConditionValue xdfgetDesignerId()
    { if (_designerId == null) { _designerId = nCV(); }
      return _designerId; }
    protected ConditionValue xgetCValueDesignerId() { return xdfgetDesignerId(); }

    /** 
     * Add order-by as ascend. <br>
     * DESIGNER_ID: {IX, NotNull, INT UNSIGNED(10), FK to designer}
     * @return this. (NotNull)
     */
    public BsCharaGroupCQ addOrderBy_DesignerId_Asc() { regOBA("DESIGNER_ID"); return this; }

    /**
     * Add order-by as descend. <br>
     * DESIGNER_ID: {IX, NotNull, INT UNSIGNED(10), FK to designer}
     * @return this. (NotNull)
     */
    public BsCharaGroupCQ addOrderBy_DesignerId_Desc() { regOBD("DESIGNER_ID"); return this; }

    protected ConditionValue _descriptionUrl;
    public ConditionValue xdfgetDescriptionUrl()
    { if (_descriptionUrl == null) { _descriptionUrl = nCV(); }
      return _descriptionUrl; }
    protected ConditionValue xgetCValueDescriptionUrl() { return xdfgetDescriptionUrl(); }

    /** 
     * Add order-by as ascend. <br>
     * DESCRIPTION_URL: {TEXT(65535)}
     * @return this. (NotNull)
     */
    public BsCharaGroupCQ addOrderBy_DescriptionUrl_Asc() { regOBA("DESCRIPTION_URL"); return this; }

    /**
     * Add order-by as descend. <br>
     * DESCRIPTION_URL: {TEXT(65535)}
     * @return this. (NotNull)
     */
    public BsCharaGroupCQ addOrderBy_DescriptionUrl_Desc() { regOBD("DESCRIPTION_URL"); return this; }

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
    public BsCharaGroupCQ addOrderBy_RegisterDatetime_Asc() { regOBA("REGISTER_DATETIME"); return this; }

    /**
     * Add order-by as descend. <br>
     * REGISTER_DATETIME: {NotNull, DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsCharaGroupCQ addOrderBy_RegisterDatetime_Desc() { regOBD("REGISTER_DATETIME"); return this; }

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
    public BsCharaGroupCQ addOrderBy_RegisterTrace_Asc() { regOBA("REGISTER_TRACE"); return this; }

    /**
     * Add order-by as descend. <br>
     * REGISTER_TRACE: {NotNull, VARCHAR(64)}
     * @return this. (NotNull)
     */
    public BsCharaGroupCQ addOrderBy_RegisterTrace_Desc() { regOBD("REGISTER_TRACE"); return this; }

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
    public BsCharaGroupCQ addOrderBy_UpdateDatetime_Asc() { regOBA("UPDATE_DATETIME"); return this; }

    /**
     * Add order-by as descend. <br>
     * UPDATE_DATETIME: {NotNull, DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsCharaGroupCQ addOrderBy_UpdateDatetime_Desc() { regOBD("UPDATE_DATETIME"); return this; }

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
    public BsCharaGroupCQ addOrderBy_UpdateTrace_Asc() { regOBA("UPDATE_TRACE"); return this; }

    /**
     * Add order-by as descend. <br>
     * UPDATE_TRACE: {NotNull, VARCHAR(64)}
     * @return this. (NotNull)
     */
    public BsCharaGroupCQ addOrderBy_UpdateTrace_Desc() { regOBD("UPDATE_TRACE"); return this; }

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
    public BsCharaGroupCQ addSpecifiedDerivedOrderBy_Asc(String aliasName) { registerSpecifiedDerivedOrderBy_Asc(aliasName); return this; }

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
    public BsCharaGroupCQ addSpecifiedDerivedOrderBy_Desc(String aliasName) { registerSpecifiedDerivedOrderBy_Desc(aliasName); return this; }

    // ===================================================================================
    //                                                                         Union Query
    //                                                                         ===========
    public void reflectRelationOnUnionQuery(ConditionQuery bqs, ConditionQuery uqs) {
        CharaGroupCQ bq = (CharaGroupCQ)bqs;
        CharaGroupCQ uq = (CharaGroupCQ)uqs;
        if (bq.hasConditionQueryDesigner()) {
            uq.queryDesigner().reflectRelationOnUnionQuery(bq.queryDesigner(), uq.queryDesigner());
        }
    }

    // ===================================================================================
    //                                                                       Foreign Query
    //                                                                       =============
    /**
     * Get the condition-query for relation table. <br>
     * DESIGNER by my DESIGNER_ID, named 'designer'.
     * @return The instance of condition-query. (NotNull)
     */
    public DesignerCQ queryDesigner() {
        return xdfgetConditionQueryDesigner();
    }
    public DesignerCQ xdfgetConditionQueryDesigner() {
        String prop = "designer";
        if (!xhasQueRlMap(prop)) { xregQueRl(prop, xcreateQueryDesigner()); xsetupOuterJoinDesigner(); }
        return xgetQueRlMap(prop);
    }
    protected DesignerCQ xcreateQueryDesigner() {
        String nrp = xresolveNRP("chara_group", "designer"); String jan = xresolveJAN(nrp, xgetNNLvl());
        return xinitRelCQ(new DesignerCQ(this, xgetSqlClause(), jan, xgetNNLvl()), _baseCB, "designer", nrp);
    }
    protected void xsetupOuterJoinDesigner() { xregOutJo("designer"); }
    public boolean hasConditionQueryDesigner() { return xhasQueRlMap("designer"); }

    protected Map<String, Object> xfindFixedConditionDynamicParameterMap(String property) {
        return null;
    }

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    public Map<String, CharaGroupCQ> xdfgetScalarCondition() { return xgetSQueMap("scalarCondition"); }
    public String keepScalarCondition(CharaGroupCQ sq) { return xkeepSQue("scalarCondition", sq); }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public Map<String, CharaGroupCQ> xdfgetSpecifyMyselfDerived() { return xgetSQueMap("specifyMyselfDerived"); }
    public String keepSpecifyMyselfDerived(CharaGroupCQ sq) { return xkeepSQue("specifyMyselfDerived", sq); }

    public Map<String, CharaGroupCQ> xdfgetQueryMyselfDerived() { return xgetSQueMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerived(CharaGroupCQ sq) { return xkeepSQue("queryMyselfDerived", sq); }
    public Map<String, Object> xdfgetQueryMyselfDerivedParameter() { return xgetSQuePmMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerivedParameter(Object pm) { return xkeepSQuePm("queryMyselfDerived", pm); }

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    protected Map<String, CharaGroupCQ> _myselfExistsMap;
    public Map<String, CharaGroupCQ> xdfgetMyselfExists() { return xgetSQueMap("myselfExists"); }
    public String keepMyselfExists(CharaGroupCQ sq) { return xkeepSQue("myselfExists", sq); }

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    public Map<String, CharaGroupCQ> xdfgetMyselfInScope() { return xgetSQueMap("myselfInScope"); }
    public String keepMyselfInScope(CharaGroupCQ sq) { return xkeepSQue("myselfInScope", sq); }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xCB() { return CharaGroupCB.class.getName(); }
    protected String xCQ() { return CharaGroupCQ.class.getName(); }
    protected String xCHp() { return HpQDRFunction.class.getName(); }
    protected String xCOp() { return ConditionOption.class.getName(); }
    protected String xMap() { return Map.class.getName(); }
}
