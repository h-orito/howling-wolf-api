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
 * The base condition-query of skill.
 * @author DBFlute(AutoGenerator)
 */
public class BsSkillCQ extends AbstractBsSkillCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected SkillCIQ _inlineQuery;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsSkillCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                 InlineView/OrClause
    //                                                                 ===================
    /**
     * Prepare InlineView query. <br>
     * {select ... from ... left outer join (select * from skill) where FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">inline()</span>.setFoo...;
     * </pre>
     * @return The condition-query for InlineView query. (NotNull)
     */
    public SkillCIQ inline() {
        if (_inlineQuery == null) { _inlineQuery = xcreateCIQ(); }
        _inlineQuery.xsetOnClause(false); return _inlineQuery;
    }

    protected SkillCIQ xcreateCIQ() {
        SkillCIQ ciq = xnewCIQ();
        ciq.xsetBaseCB(_baseCB);
        return ciq;
    }

    protected SkillCIQ xnewCIQ() {
        return new SkillCIQ(xgetReferrerQuery(), xgetSqlClause(), xgetAliasName(), xgetNestLevel(), this);
    }

    /**
     * Prepare OnClause query. <br>
     * {select ... from ... left outer join skill on ... and FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">on()</span>.setFoo...;
     * </pre>
     * @return The condition-query for OnClause query. (NotNull)
     * @throws IllegalConditionBeanOperationException When this condition-query is base query.
     */
    public SkillCIQ on() {
        if (isBaseQuery()) { throw new IllegalConditionBeanOperationException("OnClause for local table is unavailable!"); }
        SkillCIQ inlineQuery = inline(); inlineQuery.xsetOnClause(true); return inlineQuery;
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    protected ConditionValue _skillCode;
    public ConditionValue xdfgetSkillCode()
    { if (_skillCode == null) { _skillCode = nCV(); }
      return _skillCode; }
    protected ConditionValue xgetCValueSkillCode() { return xdfgetSkillCode(); }

    public Map<String, MessageRestrictionCQ> xdfgetSkillCode_ExistsReferrer_MessageRestrictionList() { return xgetSQueMap("skillCode_ExistsReferrer_MessageRestrictionList"); }
    public String keepSkillCode_ExistsReferrer_MessageRestrictionList(MessageRestrictionCQ sq) { return xkeepSQue("skillCode_ExistsReferrer_MessageRestrictionList", sq); }

    public Map<String, VillagePlayerCQ> xdfgetSkillCode_ExistsReferrer_VillagePlayerByRequestSkillCodeList() { return xgetSQueMap("skillCode_ExistsReferrer_VillagePlayerByRequestSkillCodeList"); }
    public String keepSkillCode_ExistsReferrer_VillagePlayerByRequestSkillCodeList(VillagePlayerCQ sq) { return xkeepSQue("skillCode_ExistsReferrer_VillagePlayerByRequestSkillCodeList", sq); }

    public Map<String, VillagePlayerCQ> xdfgetSkillCode_ExistsReferrer_VillagePlayerBySecondRequestSkillCodeList() { return xgetSQueMap("skillCode_ExistsReferrer_VillagePlayerBySecondRequestSkillCodeList"); }
    public String keepSkillCode_ExistsReferrer_VillagePlayerBySecondRequestSkillCodeList(VillagePlayerCQ sq) { return xkeepSQue("skillCode_ExistsReferrer_VillagePlayerBySecondRequestSkillCodeList", sq); }

    public Map<String, VillagePlayerCQ> xdfgetSkillCode_ExistsReferrer_VillagePlayerBySkillCodeList() { return xgetSQueMap("skillCode_ExistsReferrer_VillagePlayerBySkillCodeList"); }
    public String keepSkillCode_ExistsReferrer_VillagePlayerBySkillCodeList(VillagePlayerCQ sq) { return xkeepSQue("skillCode_ExistsReferrer_VillagePlayerBySkillCodeList", sq); }

    public Map<String, MessageRestrictionCQ> xdfgetSkillCode_NotExistsReferrer_MessageRestrictionList() { return xgetSQueMap("skillCode_NotExistsReferrer_MessageRestrictionList"); }
    public String keepSkillCode_NotExistsReferrer_MessageRestrictionList(MessageRestrictionCQ sq) { return xkeepSQue("skillCode_NotExistsReferrer_MessageRestrictionList", sq); }

    public Map<String, VillagePlayerCQ> xdfgetSkillCode_NotExistsReferrer_VillagePlayerByRequestSkillCodeList() { return xgetSQueMap("skillCode_NotExistsReferrer_VillagePlayerByRequestSkillCodeList"); }
    public String keepSkillCode_NotExistsReferrer_VillagePlayerByRequestSkillCodeList(VillagePlayerCQ sq) { return xkeepSQue("skillCode_NotExistsReferrer_VillagePlayerByRequestSkillCodeList", sq); }

    public Map<String, VillagePlayerCQ> xdfgetSkillCode_NotExistsReferrer_VillagePlayerBySecondRequestSkillCodeList() { return xgetSQueMap("skillCode_NotExistsReferrer_VillagePlayerBySecondRequestSkillCodeList"); }
    public String keepSkillCode_NotExistsReferrer_VillagePlayerBySecondRequestSkillCodeList(VillagePlayerCQ sq) { return xkeepSQue("skillCode_NotExistsReferrer_VillagePlayerBySecondRequestSkillCodeList", sq); }

    public Map<String, VillagePlayerCQ> xdfgetSkillCode_NotExistsReferrer_VillagePlayerBySkillCodeList() { return xgetSQueMap("skillCode_NotExistsReferrer_VillagePlayerBySkillCodeList"); }
    public String keepSkillCode_NotExistsReferrer_VillagePlayerBySkillCodeList(VillagePlayerCQ sq) { return xkeepSQue("skillCode_NotExistsReferrer_VillagePlayerBySkillCodeList", sq); }

    public Map<String, MessageRestrictionCQ> xdfgetSkillCode_SpecifyDerivedReferrer_MessageRestrictionList() { return xgetSQueMap("skillCode_SpecifyDerivedReferrer_MessageRestrictionList"); }
    public String keepSkillCode_SpecifyDerivedReferrer_MessageRestrictionList(MessageRestrictionCQ sq) { return xkeepSQue("skillCode_SpecifyDerivedReferrer_MessageRestrictionList", sq); }

    public Map<String, VillagePlayerCQ> xdfgetSkillCode_SpecifyDerivedReferrer_VillagePlayerByRequestSkillCodeList() { return xgetSQueMap("skillCode_SpecifyDerivedReferrer_VillagePlayerByRequestSkillCodeList"); }
    public String keepSkillCode_SpecifyDerivedReferrer_VillagePlayerByRequestSkillCodeList(VillagePlayerCQ sq) { return xkeepSQue("skillCode_SpecifyDerivedReferrer_VillagePlayerByRequestSkillCodeList", sq); }

    public Map<String, VillagePlayerCQ> xdfgetSkillCode_SpecifyDerivedReferrer_VillagePlayerBySecondRequestSkillCodeList() { return xgetSQueMap("skillCode_SpecifyDerivedReferrer_VillagePlayerBySecondRequestSkillCodeList"); }
    public String keepSkillCode_SpecifyDerivedReferrer_VillagePlayerBySecondRequestSkillCodeList(VillagePlayerCQ sq) { return xkeepSQue("skillCode_SpecifyDerivedReferrer_VillagePlayerBySecondRequestSkillCodeList", sq); }

    public Map<String, VillagePlayerCQ> xdfgetSkillCode_SpecifyDerivedReferrer_VillagePlayerBySkillCodeList() { return xgetSQueMap("skillCode_SpecifyDerivedReferrer_VillagePlayerBySkillCodeList"); }
    public String keepSkillCode_SpecifyDerivedReferrer_VillagePlayerBySkillCodeList(VillagePlayerCQ sq) { return xkeepSQue("skillCode_SpecifyDerivedReferrer_VillagePlayerBySkillCodeList", sq); }

    public Map<String, MessageRestrictionCQ> xdfgetSkillCode_QueryDerivedReferrer_MessageRestrictionList() { return xgetSQueMap("skillCode_QueryDerivedReferrer_MessageRestrictionList"); }
    public String keepSkillCode_QueryDerivedReferrer_MessageRestrictionList(MessageRestrictionCQ sq) { return xkeepSQue("skillCode_QueryDerivedReferrer_MessageRestrictionList", sq); }
    public Map<String, Object> xdfgetSkillCode_QueryDerivedReferrer_MessageRestrictionListParameter() { return xgetSQuePmMap("skillCode_QueryDerivedReferrer_MessageRestrictionList"); }
    public String keepSkillCode_QueryDerivedReferrer_MessageRestrictionListParameter(Object pm) { return xkeepSQuePm("skillCode_QueryDerivedReferrer_MessageRestrictionList", pm); }

    public Map<String, VillagePlayerCQ> xdfgetSkillCode_QueryDerivedReferrer_VillagePlayerByRequestSkillCodeList() { return xgetSQueMap("skillCode_QueryDerivedReferrer_VillagePlayerByRequestSkillCodeList"); }
    public String keepSkillCode_QueryDerivedReferrer_VillagePlayerByRequestSkillCodeList(VillagePlayerCQ sq) { return xkeepSQue("skillCode_QueryDerivedReferrer_VillagePlayerByRequestSkillCodeList", sq); }
    public Map<String, Object> xdfgetSkillCode_QueryDerivedReferrer_VillagePlayerByRequestSkillCodeListParameter() { return xgetSQuePmMap("skillCode_QueryDerivedReferrer_VillagePlayerByRequestSkillCodeList"); }
    public String keepSkillCode_QueryDerivedReferrer_VillagePlayerByRequestSkillCodeListParameter(Object pm) { return xkeepSQuePm("skillCode_QueryDerivedReferrer_VillagePlayerByRequestSkillCodeList", pm); }

    public Map<String, VillagePlayerCQ> xdfgetSkillCode_QueryDerivedReferrer_VillagePlayerBySecondRequestSkillCodeList() { return xgetSQueMap("skillCode_QueryDerivedReferrer_VillagePlayerBySecondRequestSkillCodeList"); }
    public String keepSkillCode_QueryDerivedReferrer_VillagePlayerBySecondRequestSkillCodeList(VillagePlayerCQ sq) { return xkeepSQue("skillCode_QueryDerivedReferrer_VillagePlayerBySecondRequestSkillCodeList", sq); }
    public Map<String, Object> xdfgetSkillCode_QueryDerivedReferrer_VillagePlayerBySecondRequestSkillCodeListParameter() { return xgetSQuePmMap("skillCode_QueryDerivedReferrer_VillagePlayerBySecondRequestSkillCodeList"); }
    public String keepSkillCode_QueryDerivedReferrer_VillagePlayerBySecondRequestSkillCodeListParameter(Object pm) { return xkeepSQuePm("skillCode_QueryDerivedReferrer_VillagePlayerBySecondRequestSkillCodeList", pm); }

    public Map<String, VillagePlayerCQ> xdfgetSkillCode_QueryDerivedReferrer_VillagePlayerBySkillCodeList() { return xgetSQueMap("skillCode_QueryDerivedReferrer_VillagePlayerBySkillCodeList"); }
    public String keepSkillCode_QueryDerivedReferrer_VillagePlayerBySkillCodeList(VillagePlayerCQ sq) { return xkeepSQue("skillCode_QueryDerivedReferrer_VillagePlayerBySkillCodeList", sq); }
    public Map<String, Object> xdfgetSkillCode_QueryDerivedReferrer_VillagePlayerBySkillCodeListParameter() { return xgetSQuePmMap("skillCode_QueryDerivedReferrer_VillagePlayerBySkillCodeList"); }
    public String keepSkillCode_QueryDerivedReferrer_VillagePlayerBySkillCodeListParameter(Object pm) { return xkeepSQuePm("skillCode_QueryDerivedReferrer_VillagePlayerBySkillCodeList", pm); }

    /** 
     * Add order-by as ascend. <br>
     * SKILL_CODE: {PK, NotNull, VARCHAR(20), classification=Skill}
     * @return this. (NotNull)
     */
    public BsSkillCQ addOrderBy_SkillCode_Asc() { regOBA("SKILL_CODE"); return this; }

    /**
     * Add order-by as descend. <br>
     * SKILL_CODE: {PK, NotNull, VARCHAR(20), classification=Skill}
     * @return this. (NotNull)
     */
    public BsSkillCQ addOrderBy_SkillCode_Desc() { regOBD("SKILL_CODE"); return this; }

    protected ConditionValue _skillName;
    public ConditionValue xdfgetSkillName()
    { if (_skillName == null) { _skillName = nCV(); }
      return _skillName; }
    protected ConditionValue xgetCValueSkillName() { return xdfgetSkillName(); }

    /** 
     * Add order-by as ascend. <br>
     * SKILL_NAME: {NotNull, VARCHAR(20)}
     * @return this. (NotNull)
     */
    public BsSkillCQ addOrderBy_SkillName_Asc() { regOBA("SKILL_NAME"); return this; }

    /**
     * Add order-by as descend. <br>
     * SKILL_NAME: {NotNull, VARCHAR(20)}
     * @return this. (NotNull)
     */
    public BsSkillCQ addOrderBy_SkillName_Desc() { regOBD("SKILL_NAME"); return this; }

    protected ConditionValue _campCode;
    public ConditionValue xdfgetCampCode()
    { if (_campCode == null) { _campCode = nCV(); }
      return _campCode; }
    protected ConditionValue xgetCValueCampCode() { return xdfgetCampCode(); }

    /** 
     * Add order-by as ascend. <br>
     * CAMP_CODE: {IX, NotNull, VARCHAR(20), FK to camp, classification=Camp}
     * @return this. (NotNull)
     */
    public BsSkillCQ addOrderBy_CampCode_Asc() { regOBA("CAMP_CODE"); return this; }

    /**
     * Add order-by as descend. <br>
     * CAMP_CODE: {IX, NotNull, VARCHAR(20), FK to camp, classification=Camp}
     * @return this. (NotNull)
     */
    public BsSkillCQ addOrderBy_CampCode_Desc() { regOBD("CAMP_CODE"); return this; }

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
    public BsSkillCQ addOrderBy_DispOrder_Asc() { regOBA("DISP_ORDER"); return this; }

    /**
     * Add order-by as descend. <br>
     * DISP_ORDER: {NotNull, INT UNSIGNED(10)}
     * @return this. (NotNull)
     */
    public BsSkillCQ addOrderBy_DispOrder_Desc() { regOBD("DISP_ORDER"); return this; }

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
    public BsSkillCQ addSpecifiedDerivedOrderBy_Asc(String aliasName) { registerSpecifiedDerivedOrderBy_Asc(aliasName); return this; }

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
    public BsSkillCQ addSpecifiedDerivedOrderBy_Desc(String aliasName) { registerSpecifiedDerivedOrderBy_Desc(aliasName); return this; }

    // ===================================================================================
    //                                                                         Union Query
    //                                                                         ===========
    public void reflectRelationOnUnionQuery(ConditionQuery bqs, ConditionQuery uqs) {
        SkillCQ bq = (SkillCQ)bqs;
        SkillCQ uq = (SkillCQ)uqs;
        if (bq.hasConditionQueryCamp()) {
            uq.queryCamp().reflectRelationOnUnionQuery(bq.queryCamp(), uq.queryCamp());
        }
    }

    // ===================================================================================
    //                                                                       Foreign Query
    //                                                                       =============
    /**
     * Get the condition-query for relation table. <br>
     * CAMP by my CAMP_CODE, named 'camp'.
     * @return The instance of condition-query. (NotNull)
     */
    public CampCQ queryCamp() {
        return xdfgetConditionQueryCamp();
    }
    public CampCQ xdfgetConditionQueryCamp() {
        String prop = "camp";
        if (!xhasQueRlMap(prop)) { xregQueRl(prop, xcreateQueryCamp()); xsetupOuterJoinCamp(); }
        return xgetQueRlMap(prop);
    }
    protected CampCQ xcreateQueryCamp() {
        String nrp = xresolveNRP("skill", "camp"); String jan = xresolveJAN(nrp, xgetNNLvl());
        return xinitRelCQ(new CampCQ(this, xgetSqlClause(), jan, xgetNNLvl()), _baseCB, "camp", nrp);
    }
    protected void xsetupOuterJoinCamp() { xregOutJo("camp"); }
    public boolean hasConditionQueryCamp() { return xhasQueRlMap("camp"); }

    protected Map<String, Object> xfindFixedConditionDynamicParameterMap(String property) {
        return null;
    }

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    public Map<String, SkillCQ> xdfgetScalarCondition() { return xgetSQueMap("scalarCondition"); }
    public String keepScalarCondition(SkillCQ sq) { return xkeepSQue("scalarCondition", sq); }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public Map<String, SkillCQ> xdfgetSpecifyMyselfDerived() { return xgetSQueMap("specifyMyselfDerived"); }
    public String keepSpecifyMyselfDerived(SkillCQ sq) { return xkeepSQue("specifyMyselfDerived", sq); }

    public Map<String, SkillCQ> xdfgetQueryMyselfDerived() { return xgetSQueMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerived(SkillCQ sq) { return xkeepSQue("queryMyselfDerived", sq); }
    public Map<String, Object> xdfgetQueryMyselfDerivedParameter() { return xgetSQuePmMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerivedParameter(Object pm) { return xkeepSQuePm("queryMyselfDerived", pm); }

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    protected Map<String, SkillCQ> _myselfExistsMap;
    public Map<String, SkillCQ> xdfgetMyselfExists() { return xgetSQueMap("myselfExists"); }
    public String keepMyselfExists(SkillCQ sq) { return xkeepSQue("myselfExists", sq); }

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    public Map<String, SkillCQ> xdfgetMyselfInScope() { return xgetSQueMap("myselfInScope"); }
    public String keepMyselfInScope(SkillCQ sq) { return xkeepSQue("myselfInScope", sq); }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xCB() { return SkillCB.class.getName(); }
    protected String xCQ() { return SkillCQ.class.getName(); }
    protected String xCHp() { return HpQDRFunction.class.getName(); }
    protected String xCOp() { return ConditionOption.class.getName(); }
    protected String xMap() { return Map.class.getName(); }
}
