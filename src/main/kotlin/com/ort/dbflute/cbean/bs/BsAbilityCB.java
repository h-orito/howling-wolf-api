package com.ort.dbflute.cbean.bs;

import org.dbflute.cbean.AbstractConditionBean;
import org.dbflute.cbean.ConditionBean;
import org.dbflute.cbean.ConditionQuery;
import org.dbflute.cbean.chelper.*;
import org.dbflute.cbean.coption.*;
import org.dbflute.cbean.dream.*;
import org.dbflute.cbean.sqlclause.SqlClause;
import org.dbflute.cbean.sqlclause.SqlClauseCreator;
import org.dbflute.cbean.scoping.*;
import org.dbflute.dbmeta.DBMetaProvider;
import org.dbflute.twowaysql.factory.SqlAnalyzerFactory;
import org.dbflute.twowaysql.style.BoundDateDisplayTimeZoneProvider;
import com.ort.dbflute.allcommon.CDef;
import com.ort.dbflute.allcommon.DBFluteConfig;
import com.ort.dbflute.allcommon.DBMetaInstanceHandler;
import com.ort.dbflute.allcommon.ImplementedInvokerAssistant;
import com.ort.dbflute.allcommon.ImplementedSqlClauseCreator;
import com.ort.dbflute.cbean.*;
import com.ort.dbflute.cbean.cq.*;
import com.ort.dbflute.cbean.nss.*;

/**
 * The base condition-bean of ability.
 * @author DBFlute(AutoGenerator)
 */
public class BsAbilityCB extends AbstractConditionBean {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected AbilityCQ _conditionQuery;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsAbilityCB() {
        if (DBFluteConfig.getInstance().isPagingCountLater()) {
            enablePagingCountLater();
        }
        if (DBFluteConfig.getInstance().isPagingCountLeastJoin()) {
            enablePagingCountLeastJoin();
        }
        if (DBFluteConfig.getInstance().isNonSpecifiedColumnAccessAllowed()) {
            enableNonSpecifiedColumnAccess();
        }
        if (DBFluteConfig.getInstance().isSpecifyColumnRequired()) {
            enableSpecifyColumnRequired();
        }
        xsetSpecifyColumnRequiredExceptDeterminer(DBFluteConfig.getInstance().getSpecifyColumnRequiredExceptDeterminer());
        if (DBFluteConfig.getInstance().isSpecifyColumnRequiredWarningOnly()) {
            xenableSpecifyColumnRequiredWarningOnly();
        }
        if (DBFluteConfig.getInstance().isQueryUpdateCountPreCheck()) {
            enableQueryUpdateCountPreCheck();
        }
    }

    // ===================================================================================
    //                                                                           SqlClause
    //                                                                           =========
    @Override
    protected SqlClause createSqlClause() {
        SqlClauseCreator creator = DBFluteConfig.getInstance().getSqlClauseCreator();
        if (creator != null) {
            return creator.createSqlClause(this);
        }
        return new ImplementedSqlClauseCreator().createSqlClause(this); // as default
    }

    // ===================================================================================
    //                                                                             DB Meta
    //                                                                             =======
    @Override
    protected DBMetaProvider getDBMetaProvider() {
        return DBMetaInstanceHandler.getProvider(); // as default
    }

    public String asTableDbName() {
        return "ability";
    }

    // ===================================================================================
    //                                                                 PrimaryKey Handling
    //                                                                 ===================
    /**
     * Accept the query condition of primary key as equal.
     * @param abilityTypeCode : PK, NotNull, VARCHAR(20), FK to ability_type, classification=AbilityType. (NotNull)
     * @param villageDayId : PK, IX, NotNull, INT UNSIGNED(10), FK to village_day. (NotNull)
     * @param villagePlayerId : PK, IX, NotNull, INT UNSIGNED(10), FK to village_player. (NotNull)
     * @return this. (NotNull)
     */
    public AbilityCB acceptPK(CDef.AbilityType abilityTypeCode, Integer villageDayId, Integer villagePlayerId) {
        assertObjectNotNull("abilityTypeCode", abilityTypeCode);assertObjectNotNull("villageDayId", villageDayId);assertObjectNotNull("villagePlayerId", villagePlayerId);
        BsAbilityCB cb = this;
        cb.query().setAbilityTypeCode_Equal_AsAbilityType(abilityTypeCode);cb.query().setVillageDayId_Equal(villageDayId);cb.query().setVillagePlayerId_Equal(villagePlayerId);
        return (AbilityCB)this;
    }

    public ConditionBean addOrderBy_PK_Asc() {
        query().addOrderBy_AbilityTypeCode_Asc();
        query().addOrderBy_VillageDayId_Asc();
        query().addOrderBy_VillagePlayerId_Asc();
        return this;
    }

    public ConditionBean addOrderBy_PK_Desc() {
        query().addOrderBy_AbilityTypeCode_Desc();
        query().addOrderBy_VillageDayId_Desc();
        query().addOrderBy_VillagePlayerId_Desc();
        return this;
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    /**
     * Prepare for various queries. <br>
     * Examples of main functions are following:
     * <pre>
     * <span style="color: #3F7E5E">// Basic Queries</span>
     * cb.query().setMemberId_Equal(value);        <span style="color: #3F7E5E">// =</span>
     * cb.query().setMemberId_NotEqual(value);     <span style="color: #3F7E5E">// !=</span>
     * cb.query().setMemberId_GreaterThan(value);  <span style="color: #3F7E5E">// &gt;</span>
     * cb.query().setMemberId_LessThan(value);     <span style="color: #3F7E5E">// &lt;</span>
     * cb.query().setMemberId_GreaterEqual(value); <span style="color: #3F7E5E">// &gt;=</span>
     * cb.query().setMemberId_LessEqual(value);    <span style="color: #3F7E5E">// &lt;=</span>
     * cb.query().setMemberName_InScope(valueList);    <span style="color: #3F7E5E">// in ('a', 'b')</span>
     * cb.query().setMemberName_NotInScope(valueList); <span style="color: #3F7E5E">// not in ('a', 'b')</span>
     * <span style="color: #3F7E5E">// LikeSearch with various options: (versatile)</span>
     * <span style="color: #3F7E5E">// {like ... [options]}</span>
     * cb.query().setMemberName_LikeSearch(value, option);
     * cb.query().setMemberName_NotLikeSearch(value, option); <span style="color: #3F7E5E">// not like ...</span>
     * <span style="color: #3F7E5E">// FromTo with various options: (versatile)</span>
     * <span style="color: #3F7E5E">// {(default) fromDatetime &lt;= BIRTHDATE &lt;= toDatetime}</span>
     * cb.query().setBirthdate_FromTo(fromDatetime, toDatetime, option);
     * <span style="color: #3F7E5E">// DateFromTo: (Date means yyyy/MM/dd)</span>
     * <span style="color: #3F7E5E">// {fromDate &lt;= BIRTHDATE &lt; toDate + 1 day}</span>
     * cb.query().setBirthdate_IsNull();    <span style="color: #3F7E5E">// is null</span>
     * cb.query().setBirthdate_IsNotNull(); <span style="color: #3F7E5E">// is not null</span>
     *
     * <span style="color: #3F7E5E">// ExistsReferrer: (correlated sub-query)</span>
     * <span style="color: #3F7E5E">// {where exists (select PURCHASE_ID from PURCHASE where ...)}</span>
     * cb.query().existsPurchase(purchaseCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     purchaseCB.query().set... <span style="color: #3F7E5E">// referrer sub-query condition</span>
     * });
     * cb.query().notExistsPurchase...
     *
     * <span style="color: #3F7E5E">// (Query)DerivedReferrer: (correlated sub-query)</span>
     * cb.query().derivedPurchaseList().max(purchaseCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     purchaseCB.specify().columnPurchasePrice(); <span style="color: #3F7E5E">// derived column for function</span>
     *     purchaseCB.query().set... <span style="color: #3F7E5E">// referrer sub-query condition</span>
     * }).greaterEqual(value);
     *
     * <span style="color: #3F7E5E">// ScalarCondition: (self-table sub-query)</span>
     * cb.query().scalar_Equal().max(scalarCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     scalarCB.specify().columnBirthdate(); <span style="color: #3F7E5E">// derived column for function</span>
     *     scalarCB.query().set... <span style="color: #3F7E5E">// scalar sub-query condition</span>
     * });
     *
     * <span style="color: #3F7E5E">// OrderBy</span>
     * cb.query().addOrderBy_MemberName_Asc();
     * cb.query().addOrderBy_MemberName_Desc().withManualOrder(option);
     * cb.query().addOrderBy_MemberName_Desc().withNullsFirst();
     * cb.query().addOrderBy_MemberName_Desc().withNullsLast();
     * cb.query().addSpecifiedDerivedOrderBy_Desc(aliasName);
     *
     * <span style="color: #3F7E5E">// Query(Relation)</span>
     * cb.query().queryMemberStatus()...;
     * cb.query().queryMemberAddressAsValid(targetDate)...;
     * </pre>
     * @return The instance of condition-query for base-point table to set up query. (NotNull)
     */
    public AbilityCQ query() {
        assertQueryPurpose(); // assert only when user-public query
        return doGetConditionQuery();
    }

    public AbilityCQ xdfgetConditionQuery() { // public for parameter comment and internal
        return doGetConditionQuery();
    }

    protected AbilityCQ doGetConditionQuery() {
        if (_conditionQuery == null) {
            _conditionQuery = createLocalCQ();
        }
        return _conditionQuery;
    }

    protected AbilityCQ createLocalCQ() {
        return xcreateCQ(null, getSqlClause(), getSqlClause().getBasePointAliasName(), 0);
    }

    protected AbilityCQ xcreateCQ(ConditionQuery childQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        AbilityCQ cq = xnewCQ(childQuery, sqlClause, aliasName, nestLevel);
        cq.xsetBaseCB(this);
        return cq;
    }

    protected AbilityCQ xnewCQ(ConditionQuery childQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        return new AbilityCQ(childQuery, sqlClause, aliasName, nestLevel);
    }

    /**
     * {@inheritDoc}
     */
    public ConditionQuery localCQ() {
        return doGetConditionQuery();
    }

    // ===================================================================================
    //                                                                               Union
    //                                                                               =====
    /**
     * Set up 'union' for base-point table. <br>
     * You don't need to call SetupSelect in union-query,
     * because it inherits calls before. (Don't call SetupSelect after here)
     * <pre>
     * cb.query().<span style="color: #CC4747">union</span>(<span style="color: #553000">unionCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">unionCB</span>.query().set...
     * });
     * </pre>
     * @param unionCBLambda The callback for query of 'union'. (NotNull)
     */
    public void union(UnionQuery<AbilityCB> unionCBLambda) {
        final AbilityCB cb = new AbilityCB(); cb.xsetupForUnion(this); xsyncUQ(cb);
        try { lock(); unionCBLambda.query(cb); } finally { unlock(); } xsaveUCB(cb);
        final AbilityCQ cq = cb.query(); query().xsetUnionQuery(cq);
    }

    /**
     * Set up 'union all' for base-point table. <br>
     * You don't need to call SetupSelect in union-query,
     * because it inherits calls before. (Don't call SetupSelect after here)
     * <pre>
     * cb.query().<span style="color: #CC4747">unionAll</span>(<span style="color: #553000">unionCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">unionCB</span>.query().set...
     * });
     * </pre>
     * @param unionCBLambda The callback for query of 'union all'. (NotNull)
     */
    public void unionAll(UnionQuery<AbilityCB> unionCBLambda) {
        final AbilityCB cb = new AbilityCB(); cb.xsetupForUnion(this); xsyncUQ(cb);
        try { lock(); unionCBLambda.query(cb); } finally { unlock(); } xsaveUCB(cb);
        final AbilityCQ cq = cb.query(); query().xsetUnionAllQuery(cq);
    }

    // ===================================================================================
    //                                                                         SetupSelect
    //                                                                         ===========
    /**
     * Set up relation columns to select clause. <br>
     * ABILITY_TYPE by my ABILITY_TYPE_CODE, named 'abilityType'.
     * <pre>
     * <span style="color: #0000C0">abilityBhv</span>.selectEntity(<span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">cb</span>.<span style="color: #CC4747">setupSelect_AbilityType()</span>; <span style="color: #3F7E5E">// ...().with[nested-relation]()</span>
     *     <span style="color: #553000">cb</span>.query().set...
     * }).alwaysPresent(<span style="color: #553000">ability</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     ... = <span style="color: #553000">ability</span>.<span style="color: #CC4747">getAbilityType()</span>; <span style="color: #3F7E5E">// you can get by using SetupSelect</span>
     * });
     * </pre>
     */
    public void setupSelect_AbilityType() {
        assertSetupSelectPurpose("abilityType");
        doSetupSelect(() -> query().queryAbilityType());
    }

    protected VillagePlayerNss _nssVillagePlayerByTargetVillagePlayerId;
    public VillagePlayerNss xdfgetNssVillagePlayerByTargetVillagePlayerId() {
        if (_nssVillagePlayerByTargetVillagePlayerId == null) { _nssVillagePlayerByTargetVillagePlayerId = new VillagePlayerNss(null); }
        return _nssVillagePlayerByTargetVillagePlayerId;
    }
    /**
     * Set up relation columns to select clause. <br>
     * VILLAGE_PLAYER by my TARGET_VILLAGE_PLAYER_ID, named 'villagePlayerByTargetVillagePlayerId'.
     * <pre>
     * <span style="color: #0000C0">abilityBhv</span>.selectEntity(<span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">cb</span>.<span style="color: #CC4747">setupSelect_VillagePlayerByTargetVillagePlayerId()</span>; <span style="color: #3F7E5E">// ...().with[nested-relation]()</span>
     *     <span style="color: #553000">cb</span>.query().set...
     * }).alwaysPresent(<span style="color: #553000">ability</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     ... = <span style="color: #553000">ability</span>.<span style="color: #CC4747">getVillagePlayerByTargetVillagePlayerId()</span>; <span style="color: #3F7E5E">// you can get by using SetupSelect</span>
     * });
     * </pre>
     * @return The set-upper of nested relation. {setupSelect...().with[nested-relation]} (NotNull)
     */
    public VillagePlayerNss setupSelect_VillagePlayerByTargetVillagePlayerId() {
        assertSetupSelectPurpose("villagePlayerByTargetVillagePlayerId");
        if (hasSpecifiedLocalColumn()) {
            specify().columnTargetVillagePlayerId();
        }
        doSetupSelect(() -> query().queryVillagePlayerByTargetVillagePlayerId());
        if (_nssVillagePlayerByTargetVillagePlayerId == null || !_nssVillagePlayerByTargetVillagePlayerId.hasConditionQuery())
        { _nssVillagePlayerByTargetVillagePlayerId = new VillagePlayerNss(query().queryVillagePlayerByTargetVillagePlayerId()); }
        return _nssVillagePlayerByTargetVillagePlayerId;
    }

    protected VillageDayNss _nssVillageDay;
    public VillageDayNss xdfgetNssVillageDay() {
        if (_nssVillageDay == null) { _nssVillageDay = new VillageDayNss(null); }
        return _nssVillageDay;
    }
    /**
     * Set up relation columns to select clause. <br>
     * VILLAGE_DAY by my VILLAGE_DAY_ID, named 'villageDay'.
     * <pre>
     * <span style="color: #0000C0">abilityBhv</span>.selectEntity(<span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">cb</span>.<span style="color: #CC4747">setupSelect_VillageDay()</span>; <span style="color: #3F7E5E">// ...().with[nested-relation]()</span>
     *     <span style="color: #553000">cb</span>.query().set...
     * }).alwaysPresent(<span style="color: #553000">ability</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     ... = <span style="color: #553000">ability</span>.<span style="color: #CC4747">getVillageDay()</span>; <span style="color: #3F7E5E">// you can get by using SetupSelect</span>
     * });
     * </pre>
     * @return The set-upper of nested relation. {setupSelect...().with[nested-relation]} (NotNull)
     */
    public VillageDayNss setupSelect_VillageDay() {
        assertSetupSelectPurpose("villageDay");
        doSetupSelect(() -> query().queryVillageDay());
        if (_nssVillageDay == null || !_nssVillageDay.hasConditionQuery())
        { _nssVillageDay = new VillageDayNss(query().queryVillageDay()); }
        return _nssVillageDay;
    }

    protected VillagePlayerNss _nssVillagePlayerByVillagePlayerId;
    public VillagePlayerNss xdfgetNssVillagePlayerByVillagePlayerId() {
        if (_nssVillagePlayerByVillagePlayerId == null) { _nssVillagePlayerByVillagePlayerId = new VillagePlayerNss(null); }
        return _nssVillagePlayerByVillagePlayerId;
    }
    /**
     * Set up relation columns to select clause. <br>
     * VILLAGE_PLAYER by my VILLAGE_PLAYER_ID, named 'villagePlayerByVillagePlayerId'.
     * <pre>
     * <span style="color: #0000C0">abilityBhv</span>.selectEntity(<span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">cb</span>.<span style="color: #CC4747">setupSelect_VillagePlayerByVillagePlayerId()</span>; <span style="color: #3F7E5E">// ...().with[nested-relation]()</span>
     *     <span style="color: #553000">cb</span>.query().set...
     * }).alwaysPresent(<span style="color: #553000">ability</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     ... = <span style="color: #553000">ability</span>.<span style="color: #CC4747">getVillagePlayerByVillagePlayerId()</span>; <span style="color: #3F7E5E">// you can get by using SetupSelect</span>
     * });
     * </pre>
     * @return The set-upper of nested relation. {setupSelect...().with[nested-relation]} (NotNull)
     */
    public VillagePlayerNss setupSelect_VillagePlayerByVillagePlayerId() {
        assertSetupSelectPurpose("villagePlayerByVillagePlayerId");
        doSetupSelect(() -> query().queryVillagePlayerByVillagePlayerId());
        if (_nssVillagePlayerByVillagePlayerId == null || !_nssVillagePlayerByVillagePlayerId.hasConditionQuery())
        { _nssVillagePlayerByVillagePlayerId = new VillagePlayerNss(query().queryVillagePlayerByVillagePlayerId()); }
        return _nssVillagePlayerByVillagePlayerId;
    }

    // [DBFlute-0.7.4]
    // ===================================================================================
    //                                                                             Specify
    //                                                                             =======
    protected HpSpecification _specification;

    /**
     * Prepare for SpecifyColumn, (Specify)DerivedReferrer. <br>
     * This method should be called after SetupSelect.
     * <pre>
     * <span style="color: #0000C0">memberBhv</span>.selectEntity(<span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">cb</span>.setupSelect_MemberStatus(); <span style="color: #3F7E5E">// should be called before specify()</span>
     *     <span style="color: #553000">cb</span>.specify().columnMemberName();
     *     <span style="color: #553000">cb</span>.specify().specifyMemberStatus().columnMemberStatusName();
     *     <span style="color: #553000">cb</span>.specify().derivedPurchaseList().max(<span style="color: #553000">purchaseCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *         <span style="color: #553000">purchaseCB</span>.specify().columnPurchaseDatetime();
     *         <span style="color: #553000">purchaseCB</span>.query().set...
     *     }, aliasName);
     * }).alwaysPresent(<span style="color: #553000">member</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     ...
     * });
     * </pre>
     * @return The instance of specification. (NotNull)
     */
    public HpSpecification specify() {
        assertSpecifyPurpose();
        if (_specification == null) { _specification = new HpSpecification(this
            , xcreateSpQyCall(() -> true, () -> xdfgetConditionQuery())
            , _purpose, getDBMetaProvider(), xcSDRFnFc()); }
        return _specification;
    }

    public HpColumnSpHandler localSp() {
        return specify();
    }

    public boolean hasSpecifiedLocalColumn() {
        return _specification != null && _specification.hasSpecifiedColumn();
    }

    public static class HpSpecification extends HpAbstractSpecification<AbilityCQ> {
        protected AbilityTypeCB.HpSpecification _abilityType;
        protected VillagePlayerCB.HpSpecification _villagePlayerByTargetVillagePlayerId;
        protected VillageDayCB.HpSpecification _villageDay;
        protected VillagePlayerCB.HpSpecification _villagePlayerByVillagePlayerId;
        public HpSpecification(ConditionBean baseCB, HpSpQyCall<AbilityCQ> qyCall
                             , HpCBPurpose purpose, DBMetaProvider dbmetaProvider
                             , HpSDRFunctionFactory sdrFuncFactory)
        { super(baseCB, qyCall, purpose, dbmetaProvider, sdrFuncFactory); }
        /**
         * ABILITY_TYPE_CODE: {PK, NotNull, VARCHAR(20), FK to ability_type, classification=AbilityType}
         * @return The information object of specified column. (NotNull)
         */
        public SpecifiedColumn columnAbilityTypeCode() { return doColumn("ABILITY_TYPE_CODE"); }
        /**
         * VILLAGE_DAY_ID: {PK, IX, NotNull, INT UNSIGNED(10), FK to village_day}
         * @return The information object of specified column. (NotNull)
         */
        public SpecifiedColumn columnVillageDayId() { return doColumn("VILLAGE_DAY_ID"); }
        /**
         * VILLAGE_PLAYER_ID: {PK, IX, NotNull, INT UNSIGNED(10), FK to village_player}
         * @return The information object of specified column. (NotNull)
         */
        public SpecifiedColumn columnVillagePlayerId() { return doColumn("VILLAGE_PLAYER_ID"); }
        /**
         * TARGET_VILLAGE_PLAYER_ID: {IX, INT UNSIGNED(10), FK to village_player}
         * @return The information object of specified column. (NotNull)
         */
        public SpecifiedColumn columnTargetVillagePlayerId() { return doColumn("TARGET_VILLAGE_PLAYER_ID"); }
        /**
         * REGISTER_DATETIME: {NotNull, DATETIME(19)}
         * @return The information object of specified column. (NotNull)
         */
        public SpecifiedColumn columnRegisterDatetime() { return doColumn("REGISTER_DATETIME"); }
        /**
         * REGISTER_TRACE: {NotNull, VARCHAR(64)}
         * @return The information object of specified column. (NotNull)
         */
        public SpecifiedColumn columnRegisterTrace() { return doColumn("REGISTER_TRACE"); }
        /**
         * UPDATE_DATETIME: {NotNull, DATETIME(19)}
         * @return The information object of specified column. (NotNull)
         */
        public SpecifiedColumn columnUpdateDatetime() { return doColumn("UPDATE_DATETIME"); }
        /**
         * UPDATE_TRACE: {NotNull, VARCHAR(64)}
         * @return The information object of specified column. (NotNull)
         */
        public SpecifiedColumn columnUpdateTrace() { return doColumn("UPDATE_TRACE"); }
        public void everyColumn() { doEveryColumn(); }
        public void exceptRecordMetaColumn() { doExceptRecordMetaColumn(); }
        @Override
        protected void doSpecifyRequiredColumn() {
            columnAbilityTypeCode(); // PK
            columnVillageDayId(); // PK
            columnVillagePlayerId(); // PK
            if (qyCall().qy().hasConditionQueryVillagePlayerByTargetVillagePlayerId()
                    || qyCall().qy().xgetReferrerQuery() instanceof VillagePlayerCQ) {
                columnTargetVillagePlayerId(); // FK or one-to-one referrer
            }
        }
        @Override
        protected String getTableDbName() { return "ability"; }
        /**
         * Prepare to specify functions about relation table. <br>
         * ABILITY_TYPE by my ABILITY_TYPE_CODE, named 'abilityType'.
         * @return The instance for specification for relation table to specify. (NotNull)
         */
        public AbilityTypeCB.HpSpecification specifyAbilityType() {
            assertRelation("abilityType");
            if (_abilityType == null) {
                _abilityType = new AbilityTypeCB.HpSpecification(_baseCB
                    , xcreateSpQyCall(() -> _qyCall.has() && _qyCall.qy().hasConditionQueryAbilityType()
                                    , () -> _qyCall.qy().queryAbilityType())
                    , _purpose, _dbmetaProvider, xgetSDRFnFc());
                if (xhasSyncQyCall()) { // inherits it
                    _abilityType.xsetSyncQyCall(xcreateSpQyCall(
                        () -> xsyncQyCall().has() && xsyncQyCall().qy().hasConditionQueryAbilityType()
                      , () -> xsyncQyCall().qy().queryAbilityType()));
                }
            }
            return _abilityType;
        }
        /**
         * Prepare to specify functions about relation table. <br>
         * VILLAGE_PLAYER by my TARGET_VILLAGE_PLAYER_ID, named 'villagePlayerByTargetVillagePlayerId'.
         * @return The instance for specification for relation table to specify. (NotNull)
         */
        public VillagePlayerCB.HpSpecification specifyVillagePlayerByTargetVillagePlayerId() {
            assertRelation("villagePlayerByTargetVillagePlayerId");
            if (_villagePlayerByTargetVillagePlayerId == null) {
                _villagePlayerByTargetVillagePlayerId = new VillagePlayerCB.HpSpecification(_baseCB
                    , xcreateSpQyCall(() -> _qyCall.has() && _qyCall.qy().hasConditionQueryVillagePlayerByTargetVillagePlayerId()
                                    , () -> _qyCall.qy().queryVillagePlayerByTargetVillagePlayerId())
                    , _purpose, _dbmetaProvider, xgetSDRFnFc());
                if (xhasSyncQyCall()) { // inherits it
                    _villagePlayerByTargetVillagePlayerId.xsetSyncQyCall(xcreateSpQyCall(
                        () -> xsyncQyCall().has() && xsyncQyCall().qy().hasConditionQueryVillagePlayerByTargetVillagePlayerId()
                      , () -> xsyncQyCall().qy().queryVillagePlayerByTargetVillagePlayerId()));
                }
            }
            return _villagePlayerByTargetVillagePlayerId;
        }
        /**
         * Prepare to specify functions about relation table. <br>
         * VILLAGE_DAY by my VILLAGE_DAY_ID, named 'villageDay'.
         * @return The instance for specification for relation table to specify. (NotNull)
         */
        public VillageDayCB.HpSpecification specifyVillageDay() {
            assertRelation("villageDay");
            if (_villageDay == null) {
                _villageDay = new VillageDayCB.HpSpecification(_baseCB
                    , xcreateSpQyCall(() -> _qyCall.has() && _qyCall.qy().hasConditionQueryVillageDay()
                                    , () -> _qyCall.qy().queryVillageDay())
                    , _purpose, _dbmetaProvider, xgetSDRFnFc());
                if (xhasSyncQyCall()) { // inherits it
                    _villageDay.xsetSyncQyCall(xcreateSpQyCall(
                        () -> xsyncQyCall().has() && xsyncQyCall().qy().hasConditionQueryVillageDay()
                      , () -> xsyncQyCall().qy().queryVillageDay()));
                }
            }
            return _villageDay;
        }
        /**
         * Prepare to specify functions about relation table. <br>
         * VILLAGE_PLAYER by my VILLAGE_PLAYER_ID, named 'villagePlayerByVillagePlayerId'.
         * @return The instance for specification for relation table to specify. (NotNull)
         */
        public VillagePlayerCB.HpSpecification specifyVillagePlayerByVillagePlayerId() {
            assertRelation("villagePlayerByVillagePlayerId");
            if (_villagePlayerByVillagePlayerId == null) {
                _villagePlayerByVillagePlayerId = new VillagePlayerCB.HpSpecification(_baseCB
                    , xcreateSpQyCall(() -> _qyCall.has() && _qyCall.qy().hasConditionQueryVillagePlayerByVillagePlayerId()
                                    , () -> _qyCall.qy().queryVillagePlayerByVillagePlayerId())
                    , _purpose, _dbmetaProvider, xgetSDRFnFc());
                if (xhasSyncQyCall()) { // inherits it
                    _villagePlayerByVillagePlayerId.xsetSyncQyCall(xcreateSpQyCall(
                        () -> xsyncQyCall().has() && xsyncQyCall().qy().hasConditionQueryVillagePlayerByVillagePlayerId()
                      , () -> xsyncQyCall().qy().queryVillagePlayerByVillagePlayerId()));
                }
            }
            return _villagePlayerByVillagePlayerId;
        }
    }

    // ===================================================================================
    //                                                                        Dream Cruise
    //                                                                        ============
    /**
     * Welcome to the Dream Cruise for condition-bean deep world. <br>
     * This is very specialty so you can get the frontier spirit. Bon voyage!
     * @return The condition-bean for dream cruise, which is linked to main condition-bean.
     */
    public AbilityCB dreamCruiseCB() {
        AbilityCB cb = new AbilityCB();
        cb.xsetupForDreamCruise((AbilityCB) this);
        return cb;
    }

    protected ConditionBean xdoCreateDreamCruiseCB() {
        return dreamCruiseCB();
    }

    // [DBFlute-0.9.5.3]
    // ===================================================================================
    //                                                                        Column Query
    //                                                                        ============
    /**
     * Set up column-query. {column1 = column2}
     * <pre>
     * <span style="color: #3F7E5E">// where FOO &lt; BAR</span>
     * cb.<span style="color: #CC4747">columnQuery</span>(<span style="color: #553000">colCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">colCB</span>.specify().<span style="color: #CC4747">columnFoo()</span>; <span style="color: #3F7E5E">// left column</span>
     * }).lessThan(<span style="color: #553000">colCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">colCB</span>.specify().<span style="color: #CC4747">columnBar()</span>; <span style="color: #3F7E5E">// right column</span>
     * }); <span style="color: #3F7E5E">// you can calculate for right column like '}).plus(3);'</span>
     * </pre>
     * @param colCBLambda The callback for specify-query of left column. (NotNull)
     * @return The object for setting up operand and right column. (NotNull)
     */
    public HpColQyOperand<AbilityCB> columnQuery(final SpecifyQuery<AbilityCB> colCBLambda) {
        return xcreateColQyOperand((rightSp, operand) -> {
            return xcolqy(xcreateColumnQueryCB(), xcreateColumnQueryCB(), colCBLambda, rightSp, operand);
        });
    }

    protected AbilityCB xcreateColumnQueryCB() {
        AbilityCB cb = new AbilityCB();
        cb.xsetupForColumnQuery((AbilityCB)this);
        return cb;
    }

    // [DBFlute-0.9.6.3]
    // ===================================================================================
    //                                                                       OrScope Query
    //                                                                       =============
    /**
     * Set up the query for or-scope. <br>
     * (Same-column-and-same-condition-key conditions are allowed in or-scope)
     * <pre>
     * <span style="color: #3F7E5E">// where (FOO = '...' or BAR = '...')</span>
     * cb.<span style="color: #CC4747">orScopeQuery</span>(<span style="color: #553000">orCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">orCB</span>.query().setFoo...
     *     <span style="color: #553000">orCB</span>.query().setBar...
     * });
     * </pre>
     * @param orCBLambda The callback for query of or-condition. (NotNull)
     */
    public void orScopeQuery(OrQuery<AbilityCB> orCBLambda) {
        xorSQ((AbilityCB)this, orCBLambda);
    }

    /**
     * Set up the and-part of or-scope. <br>
     * (However nested or-scope query and as-or-split of like-search in and-part are unsupported)
     * <pre>
     * <span style="color: #3F7E5E">// where (FOO = '...' or (BAR = '...' and QUX = '...'))</span>
     * cb.<span style="color: #994747">orScopeQuery</span>(<span style="color: #553000">orCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">orCB</span>.query().setFoo...
     *     <span style="color: #553000">orCB</span>.<span style="color: #CC4747">orScopeQueryAndPart</span>(<span style="color: #553000">andCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *         <span style="color: #553000">andCB</span>.query().setBar...
     *         <span style="color: #553000">andCB</span>.query().setQux...
     *     });
     * });
     * </pre>
     * @param andCBLambda The callback for query of and-condition. (NotNull)
     */
    public void orScopeQueryAndPart(AndQuery<AbilityCB> andCBLambda) {
        xorSQAP((AbilityCB)this, andCBLambda);
    }

    // ===================================================================================
    //                                                                          DisplaySQL
    //                                                                          ==========
    @Override
    protected SqlAnalyzerFactory getSqlAnalyzerFactory()
    { return new ImplementedInvokerAssistant().assistSqlAnalyzerFactory(); }
    @Override
    protected String getConfiguredLogDatePattern() { return DBFluteConfig.getInstance().getLogDatePattern(); }
    @Override
    protected String getConfiguredLogTimestampPattern() { return DBFluteConfig.getInstance().getLogTimestampPattern(); }
    @Override
    protected String getConfiguredLogTimePattern() { return DBFluteConfig.getInstance().getLogTimePattern(); }
    @Override
    protected BoundDateDisplayTimeZoneProvider getConfiguredLogTimeZoneProvider() { return DBFluteConfig.getInstance().getLogTimeZoneProvider(); }

    // ===================================================================================
    //                                                                       Meta Handling
    //                                                                       =============
    public boolean hasUnionQueryOrUnionAllQuery() {
        return query().hasUnionQueryOrUnionAllQuery();
    }

    // ===================================================================================
    //                                                                        Purpose Type
    //                                                                        ============
    @Override
    protected void xprepareSyncQyCall(ConditionBean mainCB) {
        final AbilityCB cb;
        if (mainCB != null) {
            cb = (AbilityCB)mainCB;
        } else {
            cb = new AbilityCB();
        }
        specify().xsetSyncQyCall(xcreateSpQyCall(() -> true, () -> cb.query()));
    }

    // ===================================================================================
    //                                                                            Internal
    //                                                                            ========
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xgetConditionBeanClassNameInternally() { return AbilityCB.class.getName(); }
    protected String xgetConditionQueryClassNameInternally() { return AbilityCQ.class.getName(); }
    protected String xgetSubQueryClassNameInternally() { return SubQuery.class.getName(); }
    protected String xgetConditionOptionClassNameInternally() { return ConditionOption.class.getName(); }
}
