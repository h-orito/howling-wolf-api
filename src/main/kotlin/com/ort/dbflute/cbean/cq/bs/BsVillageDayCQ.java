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
 * The base condition-query of village_day.
 * @author DBFlute(AutoGenerator)
 */
public class BsVillageDayCQ extends AbstractBsVillageDayCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected VillageDayCIQ _inlineQuery;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsVillageDayCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                 InlineView/OrClause
    //                                                                 ===================
    /**
     * Prepare InlineView query. <br>
     * {select ... from ... left outer join (select * from village_day) where FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">inline()</span>.setFoo...;
     * </pre>
     * @return The condition-query for InlineView query. (NotNull)
     */
    public VillageDayCIQ inline() {
        if (_inlineQuery == null) { _inlineQuery = xcreateCIQ(); }
        _inlineQuery.xsetOnClause(false); return _inlineQuery;
    }

    protected VillageDayCIQ xcreateCIQ() {
        VillageDayCIQ ciq = xnewCIQ();
        ciq.xsetBaseCB(_baseCB);
        return ciq;
    }

    protected VillageDayCIQ xnewCIQ() {
        return new VillageDayCIQ(xgetReferrerQuery(), xgetSqlClause(), xgetAliasName(), xgetNestLevel(), this);
    }

    /**
     * Prepare OnClause query. <br>
     * {select ... from ... left outer join village_day on ... and FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #CC4747">on()</span>.setFoo...;
     * </pre>
     * @return The condition-query for OnClause query. (NotNull)
     * @throws IllegalConditionBeanOperationException When this condition-query is base query.
     */
    public VillageDayCIQ on() {
        if (isBaseQuery()) { throw new IllegalConditionBeanOperationException("OnClause for local table is unavailable!"); }
        VillageDayCIQ inlineQuery = inline(); inlineQuery.xsetOnClause(true); return inlineQuery;
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    protected ConditionValue _villageDayId;
    public ConditionValue xdfgetVillageDayId()
    { if (_villageDayId == null) { _villageDayId = nCV(); }
      return _villageDayId; }
    protected ConditionValue xgetCValueVillageDayId() { return xdfgetVillageDayId(); }

    public Map<String, AbilityCQ> xdfgetVillageDayId_ExistsReferrer_AbilityList() { return xgetSQueMap("villageDayId_ExistsReferrer_AbilityList"); }
    public String keepVillageDayId_ExistsReferrer_AbilityList(AbilityCQ sq) { return xkeepSQue("villageDayId_ExistsReferrer_AbilityList", sq); }

    public Map<String, CommitCQ> xdfgetVillageDayId_ExistsReferrer_CommitList() { return xgetSQueMap("villageDayId_ExistsReferrer_CommitList"); }
    public String keepVillageDayId_ExistsReferrer_CommitList(CommitCQ sq) { return xkeepSQue("villageDayId_ExistsReferrer_CommitList", sq); }

    public Map<String, VillagePlayerCQ> xdfgetVillageDayId_ExistsReferrer_VillagePlayerList() { return xgetSQueMap("villageDayId_ExistsReferrer_VillagePlayerList"); }
    public String keepVillageDayId_ExistsReferrer_VillagePlayerList(VillagePlayerCQ sq) { return xkeepSQue("villageDayId_ExistsReferrer_VillagePlayerList", sq); }

    public Map<String, VoteCQ> xdfgetVillageDayId_ExistsReferrer_VoteList() { return xgetSQueMap("villageDayId_ExistsReferrer_VoteList"); }
    public String keepVillageDayId_ExistsReferrer_VoteList(VoteCQ sq) { return xkeepSQue("villageDayId_ExistsReferrer_VoteList", sq); }

    public Map<String, AbilityCQ> xdfgetVillageDayId_NotExistsReferrer_AbilityList() { return xgetSQueMap("villageDayId_NotExistsReferrer_AbilityList"); }
    public String keepVillageDayId_NotExistsReferrer_AbilityList(AbilityCQ sq) { return xkeepSQue("villageDayId_NotExistsReferrer_AbilityList", sq); }

    public Map<String, CommitCQ> xdfgetVillageDayId_NotExistsReferrer_CommitList() { return xgetSQueMap("villageDayId_NotExistsReferrer_CommitList"); }
    public String keepVillageDayId_NotExistsReferrer_CommitList(CommitCQ sq) { return xkeepSQue("villageDayId_NotExistsReferrer_CommitList", sq); }

    public Map<String, VillagePlayerCQ> xdfgetVillageDayId_NotExistsReferrer_VillagePlayerList() { return xgetSQueMap("villageDayId_NotExistsReferrer_VillagePlayerList"); }
    public String keepVillageDayId_NotExistsReferrer_VillagePlayerList(VillagePlayerCQ sq) { return xkeepSQue("villageDayId_NotExistsReferrer_VillagePlayerList", sq); }

    public Map<String, VoteCQ> xdfgetVillageDayId_NotExistsReferrer_VoteList() { return xgetSQueMap("villageDayId_NotExistsReferrer_VoteList"); }
    public String keepVillageDayId_NotExistsReferrer_VoteList(VoteCQ sq) { return xkeepSQue("villageDayId_NotExistsReferrer_VoteList", sq); }

    public Map<String, AbilityCQ> xdfgetVillageDayId_SpecifyDerivedReferrer_AbilityList() { return xgetSQueMap("villageDayId_SpecifyDerivedReferrer_AbilityList"); }
    public String keepVillageDayId_SpecifyDerivedReferrer_AbilityList(AbilityCQ sq) { return xkeepSQue("villageDayId_SpecifyDerivedReferrer_AbilityList", sq); }

    public Map<String, CommitCQ> xdfgetVillageDayId_SpecifyDerivedReferrer_CommitList() { return xgetSQueMap("villageDayId_SpecifyDerivedReferrer_CommitList"); }
    public String keepVillageDayId_SpecifyDerivedReferrer_CommitList(CommitCQ sq) { return xkeepSQue("villageDayId_SpecifyDerivedReferrer_CommitList", sq); }

    public Map<String, VillagePlayerCQ> xdfgetVillageDayId_SpecifyDerivedReferrer_VillagePlayerList() { return xgetSQueMap("villageDayId_SpecifyDerivedReferrer_VillagePlayerList"); }
    public String keepVillageDayId_SpecifyDerivedReferrer_VillagePlayerList(VillagePlayerCQ sq) { return xkeepSQue("villageDayId_SpecifyDerivedReferrer_VillagePlayerList", sq); }

    public Map<String, VoteCQ> xdfgetVillageDayId_SpecifyDerivedReferrer_VoteList() { return xgetSQueMap("villageDayId_SpecifyDerivedReferrer_VoteList"); }
    public String keepVillageDayId_SpecifyDerivedReferrer_VoteList(VoteCQ sq) { return xkeepSQue("villageDayId_SpecifyDerivedReferrer_VoteList", sq); }

    public Map<String, AbilityCQ> xdfgetVillageDayId_QueryDerivedReferrer_AbilityList() { return xgetSQueMap("villageDayId_QueryDerivedReferrer_AbilityList"); }
    public String keepVillageDayId_QueryDerivedReferrer_AbilityList(AbilityCQ sq) { return xkeepSQue("villageDayId_QueryDerivedReferrer_AbilityList", sq); }
    public Map<String, Object> xdfgetVillageDayId_QueryDerivedReferrer_AbilityListParameter() { return xgetSQuePmMap("villageDayId_QueryDerivedReferrer_AbilityList"); }
    public String keepVillageDayId_QueryDerivedReferrer_AbilityListParameter(Object pm) { return xkeepSQuePm("villageDayId_QueryDerivedReferrer_AbilityList", pm); }

    public Map<String, CommitCQ> xdfgetVillageDayId_QueryDerivedReferrer_CommitList() { return xgetSQueMap("villageDayId_QueryDerivedReferrer_CommitList"); }
    public String keepVillageDayId_QueryDerivedReferrer_CommitList(CommitCQ sq) { return xkeepSQue("villageDayId_QueryDerivedReferrer_CommitList", sq); }
    public Map<String, Object> xdfgetVillageDayId_QueryDerivedReferrer_CommitListParameter() { return xgetSQuePmMap("villageDayId_QueryDerivedReferrer_CommitList"); }
    public String keepVillageDayId_QueryDerivedReferrer_CommitListParameter(Object pm) { return xkeepSQuePm("villageDayId_QueryDerivedReferrer_CommitList", pm); }

    public Map<String, VillagePlayerCQ> xdfgetVillageDayId_QueryDerivedReferrer_VillagePlayerList() { return xgetSQueMap("villageDayId_QueryDerivedReferrer_VillagePlayerList"); }
    public String keepVillageDayId_QueryDerivedReferrer_VillagePlayerList(VillagePlayerCQ sq) { return xkeepSQue("villageDayId_QueryDerivedReferrer_VillagePlayerList", sq); }
    public Map<String, Object> xdfgetVillageDayId_QueryDerivedReferrer_VillagePlayerListParameter() { return xgetSQuePmMap("villageDayId_QueryDerivedReferrer_VillagePlayerList"); }
    public String keepVillageDayId_QueryDerivedReferrer_VillagePlayerListParameter(Object pm) { return xkeepSQuePm("villageDayId_QueryDerivedReferrer_VillagePlayerList", pm); }

    public Map<String, VoteCQ> xdfgetVillageDayId_QueryDerivedReferrer_VoteList() { return xgetSQueMap("villageDayId_QueryDerivedReferrer_VoteList"); }
    public String keepVillageDayId_QueryDerivedReferrer_VoteList(VoteCQ sq) { return xkeepSQue("villageDayId_QueryDerivedReferrer_VoteList", sq); }
    public Map<String, Object> xdfgetVillageDayId_QueryDerivedReferrer_VoteListParameter() { return xgetSQuePmMap("villageDayId_QueryDerivedReferrer_VoteList"); }
    public String keepVillageDayId_QueryDerivedReferrer_VoteListParameter(Object pm) { return xkeepSQuePm("villageDayId_QueryDerivedReferrer_VoteList", pm); }

    /**
     * Add order-by as ascend. <br>
     * VILLAGE_DAY_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @return this. (NotNull)
     */
    public BsVillageDayCQ addOrderBy_VillageDayId_Asc() { regOBA("VILLAGE_DAY_ID"); return this; }

    /**
     * Add order-by as descend. <br>
     * VILLAGE_DAY_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
     * @return this. (NotNull)
     */
    public BsVillageDayCQ addOrderBy_VillageDayId_Desc() { regOBD("VILLAGE_DAY_ID"); return this; }

    protected ConditionValue _villageId;
    public ConditionValue xdfgetVillageId()
    { if (_villageId == null) { _villageId = nCV(); }
      return _villageId; }
    protected ConditionValue xgetCValueVillageId() { return xdfgetVillageId(); }

    /**
     * Add order-by as ascend. <br>
     * VILLAGE_ID: {UQ+, NotNull, INT UNSIGNED(10), FK to village}
     * @return this. (NotNull)
     */
    public BsVillageDayCQ addOrderBy_VillageId_Asc() { regOBA("VILLAGE_ID"); return this; }

    /**
     * Add order-by as descend. <br>
     * VILLAGE_ID: {UQ+, NotNull, INT UNSIGNED(10), FK to village}
     * @return this. (NotNull)
     */
    public BsVillageDayCQ addOrderBy_VillageId_Desc() { regOBD("VILLAGE_ID"); return this; }

    protected ConditionValue _day;
    public ConditionValue xdfgetDay()
    { if (_day == null) { _day = nCV(); }
      return _day; }
    protected ConditionValue xgetCValueDay() { return xdfgetDay(); }

    /**
     * Add order-by as ascend. <br>
     * DAY: {+UQ, NotNull, INT UNSIGNED(10)}
     * @return this. (NotNull)
     */
    public BsVillageDayCQ addOrderBy_Day_Asc() { regOBA("DAY"); return this; }

    /**
     * Add order-by as descend. <br>
     * DAY: {+UQ, NotNull, INT UNSIGNED(10)}
     * @return this. (NotNull)
     */
    public BsVillageDayCQ addOrderBy_Day_Desc() { regOBD("DAY"); return this; }

    protected ConditionValue _noonnightCode;
    public ConditionValue xdfgetNoonnightCode()
    { if (_noonnightCode == null) { _noonnightCode = nCV(); }
      return _noonnightCode; }
    protected ConditionValue xgetCValueNoonnightCode() { return xdfgetNoonnightCode(); }

    /**
     * Add order-by as ascend. <br>
     * NOONNIGHT_CODE: {+UQ, IX, NotNull, VARCHAR(20), FK to noonnight, classification=Noonnight}
     * @return this. (NotNull)
     */
    public BsVillageDayCQ addOrderBy_NoonnightCode_Asc() { regOBA("NOONNIGHT_CODE"); return this; }

    /**
     * Add order-by as descend. <br>
     * NOONNIGHT_CODE: {+UQ, IX, NotNull, VARCHAR(20), FK to noonnight, classification=Noonnight}
     * @return this. (NotNull)
     */
    public BsVillageDayCQ addOrderBy_NoonnightCode_Desc() { regOBD("NOONNIGHT_CODE"); return this; }

    protected ConditionValue _daychangeDatetime;
    public ConditionValue xdfgetDaychangeDatetime()
    { if (_daychangeDatetime == null) { _daychangeDatetime = nCV(); }
      return _daychangeDatetime; }
    protected ConditionValue xgetCValueDaychangeDatetime() { return xdfgetDaychangeDatetime(); }

    /**
     * Add order-by as ascend. <br>
     * DAYCHANGE_DATETIME: {NotNull, DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsVillageDayCQ addOrderBy_DaychangeDatetime_Asc() { regOBA("DAYCHANGE_DATETIME"); return this; }

    /**
     * Add order-by as descend. <br>
     * DAYCHANGE_DATETIME: {NotNull, DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsVillageDayCQ addOrderBy_DaychangeDatetime_Desc() { regOBD("DAYCHANGE_DATETIME"); return this; }

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
    public BsVillageDayCQ addOrderBy_RegisterDatetime_Asc() { regOBA("REGISTER_DATETIME"); return this; }

    /**
     * Add order-by as descend. <br>
     * REGISTER_DATETIME: {NotNull, DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsVillageDayCQ addOrderBy_RegisterDatetime_Desc() { regOBD("REGISTER_DATETIME"); return this; }

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
    public BsVillageDayCQ addOrderBy_RegisterTrace_Asc() { regOBA("REGISTER_TRACE"); return this; }

    /**
     * Add order-by as descend. <br>
     * REGISTER_TRACE: {NotNull, VARCHAR(64)}
     * @return this. (NotNull)
     */
    public BsVillageDayCQ addOrderBy_RegisterTrace_Desc() { regOBD("REGISTER_TRACE"); return this; }

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
    public BsVillageDayCQ addOrderBy_UpdateDatetime_Asc() { regOBA("UPDATE_DATETIME"); return this; }

    /**
     * Add order-by as descend. <br>
     * UPDATE_DATETIME: {NotNull, DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsVillageDayCQ addOrderBy_UpdateDatetime_Desc() { regOBD("UPDATE_DATETIME"); return this; }

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
    public BsVillageDayCQ addOrderBy_UpdateTrace_Asc() { regOBA("UPDATE_TRACE"); return this; }

    /**
     * Add order-by as descend. <br>
     * UPDATE_TRACE: {NotNull, VARCHAR(64)}
     * @return this. (NotNull)
     */
    public BsVillageDayCQ addOrderBy_UpdateTrace_Desc() { regOBD("UPDATE_TRACE"); return this; }

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
    public BsVillageDayCQ addSpecifiedDerivedOrderBy_Asc(String aliasName) { registerSpecifiedDerivedOrderBy_Asc(aliasName); return this; }

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
    public BsVillageDayCQ addSpecifiedDerivedOrderBy_Desc(String aliasName) { registerSpecifiedDerivedOrderBy_Desc(aliasName); return this; }

    // ===================================================================================
    //                                                                         Union Query
    //                                                                         ===========
    public void reflectRelationOnUnionQuery(ConditionQuery bqs, ConditionQuery uqs) {
        VillageDayCQ bq = (VillageDayCQ)bqs;
        VillageDayCQ uq = (VillageDayCQ)uqs;
        if (bq.hasConditionQueryNoonnight()) {
            uq.queryNoonnight().reflectRelationOnUnionQuery(bq.queryNoonnight(), uq.queryNoonnight());
        }
        if (bq.hasConditionQueryVillage()) {
            uq.queryVillage().reflectRelationOnUnionQuery(bq.queryVillage(), uq.queryVillage());
        }
    }

    // ===================================================================================
    //                                                                       Foreign Query
    //                                                                       =============
    /**
     * Get the condition-query for relation table. <br>
     * NOONNIGHT by my NOONNIGHT_CODE, named 'noonnight'.
     * @return The instance of condition-query. (NotNull)
     */
    public NoonnightCQ queryNoonnight() {
        return xdfgetConditionQueryNoonnight();
    }
    public NoonnightCQ xdfgetConditionQueryNoonnight() {
        String prop = "noonnight";
        if (!xhasQueRlMap(prop)) { xregQueRl(prop, xcreateQueryNoonnight()); xsetupOuterJoinNoonnight(); }
        return xgetQueRlMap(prop);
    }
    protected NoonnightCQ xcreateQueryNoonnight() {
        String nrp = xresolveNRP("village_day", "noonnight"); String jan = xresolveJAN(nrp, xgetNNLvl());
        return xinitRelCQ(new NoonnightCQ(this, xgetSqlClause(), jan, xgetNNLvl()), _baseCB, "noonnight", nrp);
    }
    protected void xsetupOuterJoinNoonnight() { xregOutJo("noonnight"); }
    public boolean hasConditionQueryNoonnight() { return xhasQueRlMap("noonnight"); }

    /**
     * Get the condition-query for relation table. <br>
     * VILLAGE by my VILLAGE_ID, named 'village'.
     * @return The instance of condition-query. (NotNull)
     */
    public VillageCQ queryVillage() {
        return xdfgetConditionQueryVillage();
    }
    public VillageCQ xdfgetConditionQueryVillage() {
        String prop = "village";
        if (!xhasQueRlMap(prop)) { xregQueRl(prop, xcreateQueryVillage()); xsetupOuterJoinVillage(); }
        return xgetQueRlMap(prop);
    }
    protected VillageCQ xcreateQueryVillage() {
        String nrp = xresolveNRP("village_day", "village"); String jan = xresolveJAN(nrp, xgetNNLvl());
        return xinitRelCQ(new VillageCQ(this, xgetSqlClause(), jan, xgetNNLvl()), _baseCB, "village", nrp);
    }
    protected void xsetupOuterJoinVillage() { xregOutJo("village"); }
    public boolean hasConditionQueryVillage() { return xhasQueRlMap("village"); }

    protected Map<String, Object> xfindFixedConditionDynamicParameterMap(String property) {
        return null;
    }

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    public Map<String, VillageDayCQ> xdfgetScalarCondition() { return xgetSQueMap("scalarCondition"); }
    public String keepScalarCondition(VillageDayCQ sq) { return xkeepSQue("scalarCondition", sq); }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public Map<String, VillageDayCQ> xdfgetSpecifyMyselfDerived() { return xgetSQueMap("specifyMyselfDerived"); }
    public String keepSpecifyMyselfDerived(VillageDayCQ sq) { return xkeepSQue("specifyMyselfDerived", sq); }

    public Map<String, VillageDayCQ> xdfgetQueryMyselfDerived() { return xgetSQueMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerived(VillageDayCQ sq) { return xkeepSQue("queryMyselfDerived", sq); }
    public Map<String, Object> xdfgetQueryMyselfDerivedParameter() { return xgetSQuePmMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerivedParameter(Object pm) { return xkeepSQuePm("queryMyselfDerived", pm); }

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    protected Map<String, VillageDayCQ> _myselfExistsMap;
    public Map<String, VillageDayCQ> xdfgetMyselfExists() { return xgetSQueMap("myselfExists"); }
    public String keepMyselfExists(VillageDayCQ sq) { return xkeepSQue("myselfExists", sq); }

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    public Map<String, VillageDayCQ> xdfgetMyselfInScope() { return xgetSQueMap("myselfInScope"); }
    public String keepMyselfInScope(VillageDayCQ sq) { return xkeepSQue("myselfInScope", sq); }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xCB() { return VillageDayCB.class.getName(); }
    protected String xCQ() { return VillageDayCQ.class.getName(); }
    protected String xCHp() { return HpQDRFunction.class.getName(); }
    protected String xCOp() { return ConditionOption.class.getName(); }
    protected String xMap() { return Map.class.getName(); }
}
