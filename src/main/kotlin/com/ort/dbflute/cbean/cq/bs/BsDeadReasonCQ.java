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
 * The base condition-query of DEAD_REASON.
 * @author DBFlute(AutoGenerator)
 */
public class BsDeadReasonCQ extends AbstractBsDeadReasonCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected DeadReasonCIQ _inlineQuery;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsDeadReasonCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                 InlineView/OrClause
    //                                                                 ===================
    /**
     * Prepare InlineView query. <br>
     * {select ... from ... left outer join (select * from DEAD_REASON) where FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">inline()</span>.setFoo...;
     * </pre>
     * @return The condition-query for InlineView query. (NotNull)
     */
    public DeadReasonCIQ inline() {
        if (_inlineQuery == null) { _inlineQuery = xcreateCIQ(); }
        _inlineQuery.xsetOnClause(false); return _inlineQuery;
    }

    protected DeadReasonCIQ xcreateCIQ() {
        DeadReasonCIQ ciq = xnewCIQ();
        ciq.xsetBaseCB(_baseCB);
        return ciq;
    }

    protected DeadReasonCIQ xnewCIQ() {
        return new DeadReasonCIQ(xgetReferrerQuery(), xgetSqlClause(), xgetAliasName(), xgetNestLevel(), this);
    }

    /**
     * Prepare OnClause query. <br>
     * {select ... from ... left outer join DEAD_REASON on ... and FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">on()</span>.setFoo...;
     * </pre>
     * @return The condition-query for OnClause query. (NotNull)
     * @throws IllegalConditionBeanOperationException When this condition-query is base query.
     */
    public DeadReasonCIQ on() {
        if (isBaseQuery()) { throw new IllegalConditionBeanOperationException("OnClause for local table is unavailable!"); }
        DeadReasonCIQ inlineQuery = inline(); inlineQuery.xsetOnClause(true); return inlineQuery;
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    protected ConditionValue _deadReasonCode;
    public ConditionValue xdfgetDeadReasonCode()
    { if (_deadReasonCode == null) { _deadReasonCode = nCV(); }
      return _deadReasonCode; }
    protected ConditionValue xgetCValueDeadReasonCode() { return xdfgetDeadReasonCode(); }

    public Map<String, VillagePlayerCQ> xdfgetDeadReasonCode_ExistsReferrer_VillagePlayerList() { return xgetSQueMap("deadReasonCode_ExistsReferrer_VillagePlayerList"); }
    public String keepDeadReasonCode_ExistsReferrer_VillagePlayerList(VillagePlayerCQ sq) { return xkeepSQue("deadReasonCode_ExistsReferrer_VillagePlayerList", sq); }

    public Map<String, VillagePlayerCQ> xdfgetDeadReasonCode_NotExistsReferrer_VillagePlayerList() { return xgetSQueMap("deadReasonCode_NotExistsReferrer_VillagePlayerList"); }
    public String keepDeadReasonCode_NotExistsReferrer_VillagePlayerList(VillagePlayerCQ sq) { return xkeepSQue("deadReasonCode_NotExistsReferrer_VillagePlayerList", sq); }

    public Map<String, VillagePlayerCQ> xdfgetDeadReasonCode_SpecifyDerivedReferrer_VillagePlayerList() { return xgetSQueMap("deadReasonCode_SpecifyDerivedReferrer_VillagePlayerList"); }
    public String keepDeadReasonCode_SpecifyDerivedReferrer_VillagePlayerList(VillagePlayerCQ sq) { return xkeepSQue("deadReasonCode_SpecifyDerivedReferrer_VillagePlayerList", sq); }

    public Map<String, VillagePlayerCQ> xdfgetDeadReasonCode_QueryDerivedReferrer_VillagePlayerList() { return xgetSQueMap("deadReasonCode_QueryDerivedReferrer_VillagePlayerList"); }
    public String keepDeadReasonCode_QueryDerivedReferrer_VillagePlayerList(VillagePlayerCQ sq) { return xkeepSQue("deadReasonCode_QueryDerivedReferrer_VillagePlayerList", sq); }
    public Map<String, Object> xdfgetDeadReasonCode_QueryDerivedReferrer_VillagePlayerListParameter() { return xgetSQuePmMap("deadReasonCode_QueryDerivedReferrer_VillagePlayerList"); }
    public String keepDeadReasonCode_QueryDerivedReferrer_VillagePlayerListParameter(Object pm) { return xkeepSQuePm("deadReasonCode_QueryDerivedReferrer_VillagePlayerList", pm); }

    /**
     * Add order-by as ascend. <br>
     * DEAD_REASON_CODE: {PK, NotNull, VARCHAR(20), classification=DeadReason}
     * @return this. (NotNull)
     */
    public BsDeadReasonCQ addOrderBy_DeadReasonCode_Asc() { regOBA("DEAD_REASON_CODE"); return this; }

    /**
     * Add order-by as descend. <br>
     * DEAD_REASON_CODE: {PK, NotNull, VARCHAR(20), classification=DeadReason}
     * @return this. (NotNull)
     */
    public BsDeadReasonCQ addOrderBy_DeadReasonCode_Desc() { regOBD("DEAD_REASON_CODE"); return this; }

    protected ConditionValue _deadReasonName;
    public ConditionValue xdfgetDeadReasonName()
    { if (_deadReasonName == null) { _deadReasonName = nCV(); }
      return _deadReasonName; }
    protected ConditionValue xgetCValueDeadReasonName() { return xdfgetDeadReasonName(); }

    /**
     * Add order-by as ascend. <br>
     * DEAD_REASON_NAME: {NotNull, VARCHAR(20)}
     * @return this. (NotNull)
     */
    public BsDeadReasonCQ addOrderBy_DeadReasonName_Asc() { regOBA("DEAD_REASON_NAME"); return this; }

    /**
     * Add order-by as descend. <br>
     * DEAD_REASON_NAME: {NotNull, VARCHAR(20)}
     * @return this. (NotNull)
     */
    public BsDeadReasonCQ addOrderBy_DeadReasonName_Desc() { regOBD("DEAD_REASON_NAME"); return this; }

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
    public BsDeadReasonCQ addSpecifiedDerivedOrderBy_Asc(String aliasName) { registerSpecifiedDerivedOrderBy_Asc(aliasName); return this; }

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
    public BsDeadReasonCQ addSpecifiedDerivedOrderBy_Desc(String aliasName) { registerSpecifiedDerivedOrderBy_Desc(aliasName); return this; }

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
    public Map<String, DeadReasonCQ> xdfgetScalarCondition() { return xgetSQueMap("scalarCondition"); }
    public String keepScalarCondition(DeadReasonCQ sq) { return xkeepSQue("scalarCondition", sq); }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public Map<String, DeadReasonCQ> xdfgetSpecifyMyselfDerived() { return xgetSQueMap("specifyMyselfDerived"); }
    public String keepSpecifyMyselfDerived(DeadReasonCQ sq) { return xkeepSQue("specifyMyselfDerived", sq); }

    public Map<String, DeadReasonCQ> xdfgetQueryMyselfDerived() { return xgetSQueMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerived(DeadReasonCQ sq) { return xkeepSQue("queryMyselfDerived", sq); }
    public Map<String, Object> xdfgetQueryMyselfDerivedParameter() { return xgetSQuePmMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerivedParameter(Object pm) { return xkeepSQuePm("queryMyselfDerived", pm); }

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    protected Map<String, DeadReasonCQ> _myselfExistsMap;
    public Map<String, DeadReasonCQ> xdfgetMyselfExists() { return xgetSQueMap("myselfExists"); }
    public String keepMyselfExists(DeadReasonCQ sq) { return xkeepSQue("myselfExists", sq); }

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    public Map<String, DeadReasonCQ> xdfgetMyselfInScope() { return xgetSQueMap("myselfInScope"); }
    public String keepMyselfInScope(DeadReasonCQ sq) { return xkeepSQue("myselfInScope", sq); }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xCB() { return DeadReasonCB.class.getName(); }
    protected String xCQ() { return DeadReasonCQ.class.getName(); }
    protected String xCHp() { return HpQDRFunction.class.getName(); }
    protected String xCOp() { return ConditionOption.class.getName(); }
    protected String xMap() { return Map.class.getName(); }
}
