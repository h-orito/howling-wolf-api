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
 * The base condition-query of autogenerate_time.
 * @author DBFlute(AutoGenerator)
 */
public class BsAutogenerateTimeCQ extends AbstractBsAutogenerateTimeCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected AutogenerateTimeCIQ _inlineQuery;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsAutogenerateTimeCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                 InlineView/OrClause
    //                                                                 ===================
    /**
     * Prepare InlineView query. <br>
     * {select ... from ... left outer join (select * from autogenerate_time) where FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">inline()</span>.setFoo...;
     * </pre>
     * @return The condition-query for InlineView query. (NotNull)
     */
    public AutogenerateTimeCIQ inline() {
        if (_inlineQuery == null) { _inlineQuery = xcreateCIQ(); }
        _inlineQuery.xsetOnClause(false); return _inlineQuery;
    }

    protected AutogenerateTimeCIQ xcreateCIQ() {
        AutogenerateTimeCIQ ciq = xnewCIQ();
        ciq.xsetBaseCB(_baseCB);
        return ciq;
    }

    protected AutogenerateTimeCIQ xnewCIQ() {
        return new AutogenerateTimeCIQ(xgetReferrerQuery(), xgetSqlClause(), xgetAliasName(), xgetNestLevel(), this);
    }

    /**
     * Prepare OnClause query. <br>
     * {select ... from ... left outer join autogenerate_time on ... and FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">on()</span>.setFoo...;
     * </pre>
     * @return The condition-query for OnClause query. (NotNull)
     * @throws IllegalConditionBeanOperationException When this condition-query is base query.
     */
    public AutogenerateTimeCIQ on() {
        if (isBaseQuery()) { throw new IllegalConditionBeanOperationException("OnClause for local table is unavailable!"); }
        AutogenerateTimeCIQ inlineQuery = inline(); inlineQuery.xsetOnClause(true); return inlineQuery;
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    protected ConditionValue _villageIdMod;
    public ConditionValue xdfgetVillageIdMod()
    { if (_villageIdMod == null) { _villageIdMod = nCV(); }
      return _villageIdMod; }
    protected ConditionValue xgetCValueVillageIdMod() { return xdfgetVillageIdMod(); }

    /**
     * Add order-by as ascend. <br>
     * VILLAGE_ID_MOD: {PK, NotNull, INT(10)}
     * @return this. (NotNull)
     */
    public BsAutogenerateTimeCQ addOrderBy_VillageIdMod_Asc() { regOBA("VILLAGE_ID_MOD"); return this; }

    /**
     * Add order-by as descend. <br>
     * VILLAGE_ID_MOD: {PK, NotNull, INT(10)}
     * @return this. (NotNull)
     */
    public BsAutogenerateTimeCQ addOrderBy_VillageIdMod_Desc() { regOBD("VILLAGE_ID_MOD"); return this; }

    protected ConditionValue _startTime;
    public ConditionValue xdfgetStartTime()
    { if (_startTime == null) { _startTime = nCV(); }
      return _startTime; }
    protected ConditionValue xgetCValueStartTime() { return xdfgetStartTime(); }

    /**
     * Add order-by as ascend. <br>
     * START_TIME: {NotNull, CHAR(4)}
     * @return this. (NotNull)
     */
    public BsAutogenerateTimeCQ addOrderBy_StartTime_Asc() { regOBA("START_TIME"); return this; }

    /**
     * Add order-by as descend. <br>
     * START_TIME: {NotNull, CHAR(4)}
     * @return this. (NotNull)
     */
    public BsAutogenerateTimeCQ addOrderBy_StartTime_Desc() { regOBD("START_TIME"); return this; }

    protected ConditionValue _silentHours;
    public ConditionValue xdfgetSilentHours()
    { if (_silentHours == null) { _silentHours = nCV(); }
      return _silentHours; }
    protected ConditionValue xgetCValueSilentHours() { return xdfgetSilentHours(); }

    /**
     * Add order-by as ascend. <br>
     * SILENT_HOURS: {NotNull, INT UNSIGNED(10)}
     * @return this. (NotNull)
     */
    public BsAutogenerateTimeCQ addOrderBy_SilentHours_Asc() { regOBA("SILENT_HOURS"); return this; }

    /**
     * Add order-by as descend. <br>
     * SILENT_HOURS: {NotNull, INT UNSIGNED(10)}
     * @return this. (NotNull)
     */
    public BsAutogenerateTimeCQ addOrderBy_SilentHours_Desc() { regOBD("SILENT_HOURS"); return this; }

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
    public BsAutogenerateTimeCQ addOrderBy_RegisterDatetime_Asc() { regOBA("REGISTER_DATETIME"); return this; }

    /**
     * Add order-by as descend. <br>
     * REGISTER_DATETIME: {NotNull, DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsAutogenerateTimeCQ addOrderBy_RegisterDatetime_Desc() { regOBD("REGISTER_DATETIME"); return this; }

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
    public BsAutogenerateTimeCQ addOrderBy_RegisterTrace_Asc() { regOBA("REGISTER_TRACE"); return this; }

    /**
     * Add order-by as descend. <br>
     * REGISTER_TRACE: {NotNull, VARCHAR(64)}
     * @return this. (NotNull)
     */
    public BsAutogenerateTimeCQ addOrderBy_RegisterTrace_Desc() { regOBD("REGISTER_TRACE"); return this; }

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
    public BsAutogenerateTimeCQ addOrderBy_UpdateDatetime_Asc() { regOBA("UPDATE_DATETIME"); return this; }

    /**
     * Add order-by as descend. <br>
     * UPDATE_DATETIME: {NotNull, DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsAutogenerateTimeCQ addOrderBy_UpdateDatetime_Desc() { regOBD("UPDATE_DATETIME"); return this; }

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
    public BsAutogenerateTimeCQ addOrderBy_UpdateTrace_Asc() { regOBA("UPDATE_TRACE"); return this; }

    /**
     * Add order-by as descend. <br>
     * UPDATE_TRACE: {NotNull, VARCHAR(64)}
     * @return this. (NotNull)
     */
    public BsAutogenerateTimeCQ addOrderBy_UpdateTrace_Desc() { regOBD("UPDATE_TRACE"); return this; }

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
    public BsAutogenerateTimeCQ addSpecifiedDerivedOrderBy_Asc(String aliasName) { registerSpecifiedDerivedOrderBy_Asc(aliasName); return this; }

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
    public BsAutogenerateTimeCQ addSpecifiedDerivedOrderBy_Desc(String aliasName) { registerSpecifiedDerivedOrderBy_Desc(aliasName); return this; }

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
    public Map<String, AutogenerateTimeCQ> xdfgetScalarCondition() { return xgetSQueMap("scalarCondition"); }
    public String keepScalarCondition(AutogenerateTimeCQ sq) { return xkeepSQue("scalarCondition", sq); }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public Map<String, AutogenerateTimeCQ> xdfgetSpecifyMyselfDerived() { return xgetSQueMap("specifyMyselfDerived"); }
    public String keepSpecifyMyselfDerived(AutogenerateTimeCQ sq) { return xkeepSQue("specifyMyselfDerived", sq); }

    public Map<String, AutogenerateTimeCQ> xdfgetQueryMyselfDerived() { return xgetSQueMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerived(AutogenerateTimeCQ sq) { return xkeepSQue("queryMyselfDerived", sq); }
    public Map<String, Object> xdfgetQueryMyselfDerivedParameter() { return xgetSQuePmMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerivedParameter(Object pm) { return xkeepSQuePm("queryMyselfDerived", pm); }

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    protected Map<String, AutogenerateTimeCQ> _myselfExistsMap;
    public Map<String, AutogenerateTimeCQ> xdfgetMyselfExists() { return xgetSQueMap("myselfExists"); }
    public String keepMyselfExists(AutogenerateTimeCQ sq) { return xkeepSQue("myselfExists", sq); }

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    public Map<String, AutogenerateTimeCQ> xdfgetMyselfInScope() { return xgetSQueMap("myselfInScope"); }
    public String keepMyselfInScope(AutogenerateTimeCQ sq) { return xkeepSQue("myselfInScope", sq); }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xCB() { return AutogenerateTimeCB.class.getName(); }
    protected String xCQ() { return AutogenerateTimeCQ.class.getName(); }
    protected String xCHp() { return HpQDRFunction.class.getName(); }
    protected String xCOp() { return ConditionOption.class.getName(); }
    protected String xMap() { return Map.class.getName(); }
}
