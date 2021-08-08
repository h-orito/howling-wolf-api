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
 * The base condition-bean of VILLAGE_DAY.
 * @author DBFlute(AutoGenerator)
 */
public class BsVillageDayCB extends AbstractConditionBean {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected VillageDayCQ _conditionQuery;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsVillageDayCB() {
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
        return "VILLAGE_DAY";
    }

    // ===================================================================================
    //                                                                 PrimaryKey Handling
    //                                                                 ===================
    /**
     * Accept the query condition of primary key as equal.
     * @param villageDayId : PK, ID, NotNull, INT UNSIGNED(10). (NotNull)
     * @return this. (NotNull)
     */
    public VillageDayCB acceptPK(Integer villageDayId) {
        assertObjectNotNull("villageDayId", villageDayId);
        BsVillageDayCB cb = this;
        cb.query().setVillageDayId_Equal(villageDayId);
        return (VillageDayCB)this;
    }

    /**
     * Accept the query condition of unique key as equal.
     * @param villageId : UQ+, NotNull, INT UNSIGNED(10), FK to VILLAGE. (NotNull)
     * @param day : +UQ, NotNull, INT UNSIGNED(10). (NotNull)
     * @param noonnightCode : +UQ, IX, NotNull, VARCHAR(20), FK to NOONNIGHT, classification=Noonnight. (NotNull)
     * @return this. (NotNull)
     */
    public VillageDayCB acceptUniqueOf(Integer villageId, Integer day, CDef.Noonnight noonnightCode) {
        assertObjectNotNull("villageId", villageId);assertObjectNotNull("day", day);assertObjectNotNull("noonnightCode", noonnightCode);
        BsVillageDayCB cb = this;
        cb.query().setVillageId_Equal(villageId);cb.query().setDay_Equal(day);cb.query().setNoonnightCode_Equal_AsNoonnight(noonnightCode);
        return (VillageDayCB)this;
    }

    public ConditionBean addOrderBy_PK_Asc() {
        query().addOrderBy_VillageDayId_Asc();
        return this;
    }

    public ConditionBean addOrderBy_PK_Desc() {
        query().addOrderBy_VillageDayId_Desc();
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
    public VillageDayCQ query() {
        assertQueryPurpose(); // assert only when user-public query
        return doGetConditionQuery();
    }

    public VillageDayCQ xdfgetConditionQuery() { // public for parameter comment and internal
        return doGetConditionQuery();
    }

    protected VillageDayCQ doGetConditionQuery() {
        if (_conditionQuery == null) {
            _conditionQuery = createLocalCQ();
        }
        return _conditionQuery;
    }

    protected VillageDayCQ createLocalCQ() {
        return xcreateCQ(null, getSqlClause(), getSqlClause().getBasePointAliasName(), 0);
    }

    protected VillageDayCQ xcreateCQ(ConditionQuery childQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        VillageDayCQ cq = xnewCQ(childQuery, sqlClause, aliasName, nestLevel);
        cq.xsetBaseCB(this);
        return cq;
    }

    protected VillageDayCQ xnewCQ(ConditionQuery childQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        return new VillageDayCQ(childQuery, sqlClause, aliasName, nestLevel);
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
    public void union(UnionQuery<VillageDayCB> unionCBLambda) {
        final VillageDayCB cb = new VillageDayCB(); cb.xsetupForUnion(this); xsyncUQ(cb);
        try { lock(); unionCBLambda.query(cb); } finally { unlock(); } xsaveUCB(cb);
        final VillageDayCQ cq = cb.query(); query().xsetUnionQuery(cq);
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
    public void unionAll(UnionQuery<VillageDayCB> unionCBLambda) {
        final VillageDayCB cb = new VillageDayCB(); cb.xsetupForUnion(this); xsyncUQ(cb);
        try { lock(); unionCBLambda.query(cb); } finally { unlock(); } xsaveUCB(cb);
        final VillageDayCQ cq = cb.query(); query().xsetUnionAllQuery(cq);
    }

    // ===================================================================================
    //                                                                         SetupSelect
    //                                                                         ===========
    /**
     * Set up relation columns to select clause. <br>
     * NOONNIGHT by my NOONNIGHT_CODE, named 'noonnight'.
     * <pre>
     * <span style="color: #0000C0">villageDayBhv</span>.selectEntity(<span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">cb</span>.<span style="color: #CC4747">setupSelect_Noonnight()</span>; <span style="color: #3F7E5E">// ...().with[nested-relation]()</span>
     *     <span style="color: #553000">cb</span>.query().set...
     * }).alwaysPresent(<span style="color: #553000">villageDay</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     ... = <span style="color: #553000">villageDay</span>.<span style="color: #CC4747">getNoonnight()</span>; <span style="color: #3F7E5E">// you can get by using SetupSelect</span>
     * });
     * </pre>
     */
    public void setupSelect_Noonnight() {
        assertSetupSelectPurpose("noonnight");
        if (hasSpecifiedLocalColumn()) {
            specify().columnNoonnightCode();
        }
        doSetupSelect(() -> query().queryNoonnight());
    }

    protected VillageNss _nssVillage;
    public VillageNss xdfgetNssVillage() {
        if (_nssVillage == null) { _nssVillage = new VillageNss(null); }
        return _nssVillage;
    }
    /**
     * Set up relation columns to select clause. <br>
     * VILLAGE by my VILLAGE_ID, named 'village'.
     * <pre>
     * <span style="color: #0000C0">villageDayBhv</span>.selectEntity(<span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">cb</span>.<span style="color: #CC4747">setupSelect_Village()</span>; <span style="color: #3F7E5E">// ...().with[nested-relation]()</span>
     *     <span style="color: #553000">cb</span>.query().set...
     * }).alwaysPresent(<span style="color: #553000">villageDay</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     ... = <span style="color: #553000">villageDay</span>.<span style="color: #CC4747">getVillage()</span>; <span style="color: #3F7E5E">// you can get by using SetupSelect</span>
     * });
     * </pre>
     * @return The set-upper of nested relation. {setupSelect...().with[nested-relation]} (NotNull)
     */
    public VillageNss setupSelect_Village() {
        assertSetupSelectPurpose("village");
        if (hasSpecifiedLocalColumn()) {
            specify().columnVillageId();
        }
        doSetupSelect(() -> query().queryVillage());
        if (_nssVillage == null || !_nssVillage.hasConditionQuery())
        { _nssVillage = new VillageNss(query().queryVillage()); }
        return _nssVillage;
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

    public static class HpSpecification extends HpAbstractSpecification<VillageDayCQ> {
        protected NoonnightCB.HpSpecification _noonnight;
        protected VillageCB.HpSpecification _village;
        public HpSpecification(ConditionBean baseCB, HpSpQyCall<VillageDayCQ> qyCall
                             , HpCBPurpose purpose, DBMetaProvider dbmetaProvider
                             , HpSDRFunctionFactory sdrFuncFactory)
        { super(baseCB, qyCall, purpose, dbmetaProvider, sdrFuncFactory); }
        /**
         * VILLAGE_DAY_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
         * @return The information object of specified column. (NotNull)
         */
        public SpecifiedColumn columnVillageDayId() { return doColumn("VILLAGE_DAY_ID"); }
        /**
         * VILLAGE_ID: {UQ+, NotNull, INT UNSIGNED(10), FK to VILLAGE}
         * @return The information object of specified column. (NotNull)
         */
        public SpecifiedColumn columnVillageId() { return doColumn("VILLAGE_ID"); }
        /**
         * DAY: {+UQ, NotNull, INT UNSIGNED(10)}
         * @return The information object of specified column. (NotNull)
         */
        public SpecifiedColumn columnDay() { return doColumn("DAY"); }
        /**
         * NOONNIGHT_CODE: {+UQ, IX, NotNull, VARCHAR(20), FK to NOONNIGHT, classification=Noonnight}
         * @return The information object of specified column. (NotNull)
         */
        public SpecifiedColumn columnNoonnightCode() { return doColumn("NOONNIGHT_CODE"); }
        /**
         * DAYCHANGE_DATETIME: {NotNull, DATETIME(19)}
         * @return The information object of specified column. (NotNull)
         */
        public SpecifiedColumn columnDaychangeDatetime() { return doColumn("DAYCHANGE_DATETIME"); }
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
            columnVillageDayId(); // PK
            if (qyCall().qy().hasConditionQueryNoonnight()
                    || qyCall().qy().xgetReferrerQuery() instanceof NoonnightCQ) {
                columnNoonnightCode(); // FK or one-to-one referrer
            }
            if (qyCall().qy().hasConditionQueryVillage()
                    || qyCall().qy().xgetReferrerQuery() instanceof VillageCQ) {
                columnVillageId(); // FK or one-to-one referrer
            }
        }
        @Override
        protected String getTableDbName() { return "VILLAGE_DAY"; }
        /**
         * Prepare to specify functions about relation table. <br>
         * NOONNIGHT by my NOONNIGHT_CODE, named 'noonnight'.
         * @return The instance for specification for relation table to specify. (NotNull)
         */
        public NoonnightCB.HpSpecification specifyNoonnight() {
            assertRelation("noonnight");
            if (_noonnight == null) {
                _noonnight = new NoonnightCB.HpSpecification(_baseCB
                    , xcreateSpQyCall(() -> _qyCall.has() && _qyCall.qy().hasConditionQueryNoonnight()
                                    , () -> _qyCall.qy().queryNoonnight())
                    , _purpose, _dbmetaProvider, xgetSDRFnFc());
                if (xhasSyncQyCall()) { // inherits it
                    _noonnight.xsetSyncQyCall(xcreateSpQyCall(
                        () -> xsyncQyCall().has() && xsyncQyCall().qy().hasConditionQueryNoonnight()
                      , () -> xsyncQyCall().qy().queryNoonnight()));
                }
            }
            return _noonnight;
        }
        /**
         * Prepare to specify functions about relation table. <br>
         * VILLAGE by my VILLAGE_ID, named 'village'.
         * @return The instance for specification for relation table to specify. (NotNull)
         */
        public VillageCB.HpSpecification specifyVillage() {
            assertRelation("village");
            if (_village == null) {
                _village = new VillageCB.HpSpecification(_baseCB
                    , xcreateSpQyCall(() -> _qyCall.has() && _qyCall.qy().hasConditionQueryVillage()
                                    , () -> _qyCall.qy().queryVillage())
                    , _purpose, _dbmetaProvider, xgetSDRFnFc());
                if (xhasSyncQyCall()) { // inherits it
                    _village.xsetSyncQyCall(xcreateSpQyCall(
                        () -> xsyncQyCall().has() && xsyncQyCall().qy().hasConditionQueryVillage()
                      , () -> xsyncQyCall().qy().queryVillage()));
                }
            }
            return _village;
        }
        /**
         * Prepare for (Specify)DerivedReferrer (correlated sub-query). <br>
         * {select max(FOO) from ABILITY where ...) as FOO_MAX} <br>
         * ABILITY by VILLAGE_DAY_ID, named 'abilityList'.
         * <pre>
         * cb.specify().<span style="color: #CC4747">derived${relationMethodIdentityName}()</span>.<span style="color: #CC4747">max</span>(abilityCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
         *     abilityCB.specify().<span style="color: #CC4747">column...</span> <span style="color: #3F7E5E">// derived column by function</span>
         *     abilityCB.query().set... <span style="color: #3F7E5E">// referrer condition</span>
         * }, Ability.<span style="color: #CC4747">ALIAS_foo...</span>);
         * </pre>
         * @return The object to set up a function for referrer table. (NotNull)
         */
        public HpSDRFunction<AbilityCB, VillageDayCQ> derivedAbility() {
            assertDerived("abilityList"); if (xhasSyncQyCall()) { xsyncQyCall().qy(); } // for sync (for example, this in ColumnQuery)
            return cHSDRF(_baseCB, _qyCall.qy(), (String fn, SubQuery<AbilityCB> sq, VillageDayCQ cq, String al, DerivedReferrerOption op)
                    -> cq.xsderiveAbilityList(fn, sq, al, op), _dbmetaProvider);
        }
        /**
         * Prepare for (Specify)DerivedReferrer (correlated sub-query). <br>
         * {select max(FOO) from COMMIT where ...) as FOO_MAX} <br>
         * COMMIT by VILLAGE_DAY_ID, named 'commitList'.
         * <pre>
         * cb.specify().<span style="color: #CC4747">derived${relationMethodIdentityName}()</span>.<span style="color: #CC4747">max</span>(commitCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
         *     commitCB.specify().<span style="color: #CC4747">column...</span> <span style="color: #3F7E5E">// derived column by function</span>
         *     commitCB.query().set... <span style="color: #3F7E5E">// referrer condition</span>
         * }, Commit.<span style="color: #CC4747">ALIAS_foo...</span>);
         * </pre>
         * @return The object to set up a function for referrer table. (NotNull)
         */
        public HpSDRFunction<CommitCB, VillageDayCQ> derivedCommit() {
            assertDerived("commitList"); if (xhasSyncQyCall()) { xsyncQyCall().qy(); } // for sync (for example, this in ColumnQuery)
            return cHSDRF(_baseCB, _qyCall.qy(), (String fn, SubQuery<CommitCB> sq, VillageDayCQ cq, String al, DerivedReferrerOption op)
                    -> cq.xsderiveCommitList(fn, sq, al, op), _dbmetaProvider);
        }
        /**
         * Prepare for (Specify)DerivedReferrer (correlated sub-query). <br>
         * {select max(FOO) from VILLAGE_PLAYER where ...) as FOO_MAX} <br>
         * VILLAGE_PLAYER by DEAD_VILLAGE_DAY_ID, named 'villagePlayerList'.
         * <pre>
         * cb.specify().<span style="color: #CC4747">derived${relationMethodIdentityName}()</span>.<span style="color: #CC4747">max</span>(playerCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
         *     playerCB.specify().<span style="color: #CC4747">column...</span> <span style="color: #3F7E5E">// derived column by function</span>
         *     playerCB.query().set... <span style="color: #3F7E5E">// referrer condition</span>
         * }, VillagePlayer.<span style="color: #CC4747">ALIAS_foo...</span>);
         * </pre>
         * @return The object to set up a function for referrer table. (NotNull)
         */
        public HpSDRFunction<VillagePlayerCB, VillageDayCQ> derivedVillagePlayer() {
            assertDerived("villagePlayerList"); if (xhasSyncQyCall()) { xsyncQyCall().qy(); } // for sync (for example, this in ColumnQuery)
            return cHSDRF(_baseCB, _qyCall.qy(), (String fn, SubQuery<VillagePlayerCB> sq, VillageDayCQ cq, String al, DerivedReferrerOption op)
                    -> cq.xsderiveVillagePlayerList(fn, sq, al, op), _dbmetaProvider);
        }
        /**
         * Prepare for (Specify)DerivedReferrer (correlated sub-query). <br>
         * {select max(FOO) from VOTE where ...) as FOO_MAX} <br>
         * VOTE by VILLAGE_DAY_ID, named 'voteList'.
         * <pre>
         * cb.specify().<span style="color: #CC4747">derived${relationMethodIdentityName}()</span>.<span style="color: #CC4747">max</span>(voteCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
         *     voteCB.specify().<span style="color: #CC4747">column...</span> <span style="color: #3F7E5E">// derived column by function</span>
         *     voteCB.query().set... <span style="color: #3F7E5E">// referrer condition</span>
         * }, Vote.<span style="color: #CC4747">ALIAS_foo...</span>);
         * </pre>
         * @return The object to set up a function for referrer table. (NotNull)
         */
        public HpSDRFunction<VoteCB, VillageDayCQ> derivedVote() {
            assertDerived("voteList"); if (xhasSyncQyCall()) { xsyncQyCall().qy(); } // for sync (for example, this in ColumnQuery)
            return cHSDRF(_baseCB, _qyCall.qy(), (String fn, SubQuery<VoteCB> sq, VillageDayCQ cq, String al, DerivedReferrerOption op)
                    -> cq.xsderiveVoteList(fn, sq, al, op), _dbmetaProvider);
        }
        /**
         * Prepare for (Specify)MyselfDerived (SubQuery).
         * @return The object to set up a function for myself table. (NotNull)
         */
        public HpSDRFunction<VillageDayCB, VillageDayCQ> myselfDerived() {
            assertDerived("myselfDerived"); if (xhasSyncQyCall()) { xsyncQyCall().qy(); } // for sync (for example, this in ColumnQuery)
            return cHSDRF(_baseCB, _qyCall.qy(), (String fn, SubQuery<VillageDayCB> sq, VillageDayCQ cq, String al, DerivedReferrerOption op)
                    -> cq.xsmyselfDerive(fn, sq, al, op), _dbmetaProvider);
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
    public VillageDayCB dreamCruiseCB() {
        VillageDayCB cb = new VillageDayCB();
        cb.xsetupForDreamCruise((VillageDayCB) this);
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
    public HpColQyOperand<VillageDayCB> columnQuery(final SpecifyQuery<VillageDayCB> colCBLambda) {
        return xcreateColQyOperand((rightSp, operand) -> {
            return xcolqy(xcreateColumnQueryCB(), xcreateColumnQueryCB(), colCBLambda, rightSp, operand);
        });
    }

    protected VillageDayCB xcreateColumnQueryCB() {
        VillageDayCB cb = new VillageDayCB();
        cb.xsetupForColumnQuery((VillageDayCB)this);
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
    public void orScopeQuery(OrQuery<VillageDayCB> orCBLambda) {
        xorSQ((VillageDayCB)this, orCBLambda);
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
    public void orScopeQueryAndPart(AndQuery<VillageDayCB> andCBLambda) {
        xorSQAP((VillageDayCB)this, andCBLambda);
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
        final VillageDayCB cb;
        if (mainCB != null) {
            cb = (VillageDayCB)mainCB;
        } else {
            cb = new VillageDayCB();
        }
        specify().xsetSyncQyCall(xcreateSpQyCall(() -> true, () -> cb.query()));
    }

    // ===================================================================================
    //                                                                            Internal
    //                                                                            ========
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xgetConditionBeanClassNameInternally() { return VillageDayCB.class.getName(); }
    protected String xgetConditionQueryClassNameInternally() { return VillageDayCQ.class.getName(); }
    protected String xgetSubQueryClassNameInternally() { return SubQuery.class.getName(); }
    protected String xgetConditionOptionClassNameInternally() { return ConditionOption.class.getName(); }
}
