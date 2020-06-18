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
import com.ort.dbflute.allcommon.DBFluteConfig;
import com.ort.dbflute.allcommon.DBMetaInstanceHandler;
import com.ort.dbflute.allcommon.ImplementedInvokerAssistant;
import com.ort.dbflute.allcommon.ImplementedSqlClauseCreator;
import com.ort.dbflute.cbean.*;
import com.ort.dbflute.cbean.cq.*;
import com.ort.dbflute.cbean.nss.*;

/**
 * The base condition-bean of VILLAGE_PLAYER.
 * @author DBFlute(AutoGenerator)
 */
public class BsVillagePlayerCB extends AbstractConditionBean {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected VillagePlayerCQ _conditionQuery;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsVillagePlayerCB() {
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
        return "VILLAGE_PLAYER";
    }

    // ===================================================================================
    //                                                                 PrimaryKey Handling
    //                                                                 ===================
    /**
     * Accept the query condition of primary key as equal.
     * @param villagePlayerId : PK, ID, NotNull, INT UNSIGNED(10). (NotNull)
     * @return this. (NotNull)
     */
    public VillagePlayerCB acceptPK(Integer villagePlayerId) {
        assertObjectNotNull("villagePlayerId", villagePlayerId);
        BsVillagePlayerCB cb = this;
        cb.query().setVillagePlayerId_Equal(villagePlayerId);
        return (VillagePlayerCB)this;
    }

    public ConditionBean addOrderBy_PK_Asc() {
        query().addOrderBy_VillagePlayerId_Asc();
        return this;
    }

    public ConditionBean addOrderBy_PK_Desc() {
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
    public VillagePlayerCQ query() {
        assertQueryPurpose(); // assert only when user-public query
        return doGetConditionQuery();
    }

    public VillagePlayerCQ xdfgetConditionQuery() { // public for parameter comment and internal
        return doGetConditionQuery();
    }

    protected VillagePlayerCQ doGetConditionQuery() {
        if (_conditionQuery == null) {
            _conditionQuery = createLocalCQ();
        }
        return _conditionQuery;
    }

    protected VillagePlayerCQ createLocalCQ() {
        return xcreateCQ(null, getSqlClause(), getSqlClause().getBasePointAliasName(), 0);
    }

    protected VillagePlayerCQ xcreateCQ(ConditionQuery childQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        VillagePlayerCQ cq = xnewCQ(childQuery, sqlClause, aliasName, nestLevel);
        cq.xsetBaseCB(this);
        return cq;
    }

    protected VillagePlayerCQ xnewCQ(ConditionQuery childQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        return new VillagePlayerCQ(childQuery, sqlClause, aliasName, nestLevel);
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
    public void union(UnionQuery<VillagePlayerCB> unionCBLambda) {
        final VillagePlayerCB cb = new VillagePlayerCB(); cb.xsetupForUnion(this); xsyncUQ(cb);
        try { lock(); unionCBLambda.query(cb); } finally { unlock(); } xsaveUCB(cb);
        final VillagePlayerCQ cq = cb.query(); query().xsetUnionQuery(cq);
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
    public void unionAll(UnionQuery<VillagePlayerCB> unionCBLambda) {
        final VillagePlayerCB cb = new VillagePlayerCB(); cb.xsetupForUnion(this); xsyncUQ(cb);
        try { lock(); unionCBLambda.query(cb); } finally { unlock(); } xsaveUCB(cb);
        final VillagePlayerCQ cq = cb.query(); query().xsetUnionAllQuery(cq);
    }

    // ===================================================================================
    //                                                                         SetupSelect
    //                                                                         ===========
    protected CharaNss _nssChara;
    public CharaNss xdfgetNssChara() {
        if (_nssChara == null) { _nssChara = new CharaNss(null); }
        return _nssChara;
    }
    /**
     * Set up relation columns to select clause. <br>
     * CHARA by my CHARA_ID, named 'chara'.
     * <pre>
     * <span style="color: #0000C0">villagePlayerBhv</span>.selectEntity(<span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">cb</span>.<span style="color: #CC4747">setupSelect_Chara()</span>; <span style="color: #3F7E5E">// ...().with[nested-relation]()</span>
     *     <span style="color: #553000">cb</span>.query().set...
     * }).alwaysPresent(<span style="color: #553000">villagePlayer</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     ... = <span style="color: #553000">villagePlayer</span>.<span style="color: #CC4747">getChara()</span>; <span style="color: #3F7E5E">// you can get by using SetupSelect</span>
     * });
     * </pre>
     * @return The set-upper of nested relation. {setupSelect...().with[nested-relation]} (NotNull)
     */
    public CharaNss setupSelect_Chara() {
        assertSetupSelectPurpose("chara");
        if (hasSpecifiedLocalColumn()) {
            specify().columnCharaId();
        }
        doSetupSelect(() -> query().queryChara());
        if (_nssChara == null || !_nssChara.hasConditionQuery())
        { _nssChara = new CharaNss(query().queryChara()); }
        return _nssChara;
    }

    /**
     * Set up relation columns to select clause. <br>
     * DEAD_REASON by my DEAD_REASON_CODE, named 'deadReason'.
     * <pre>
     * <span style="color: #0000C0">villagePlayerBhv</span>.selectEntity(<span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">cb</span>.<span style="color: #CC4747">setupSelect_DeadReason()</span>; <span style="color: #3F7E5E">// ...().with[nested-relation]()</span>
     *     <span style="color: #553000">cb</span>.query().set...
     * }).alwaysPresent(<span style="color: #553000">villagePlayer</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     ... = <span style="color: #553000">villagePlayer</span>.<span style="color: #CC4747">getDeadReason()</span>; <span style="color: #3F7E5E">// you can get by using SetupSelect</span>
     * });
     * </pre>
     */
    public void setupSelect_DeadReason() {
        assertSetupSelectPurpose("deadReason");
        if (hasSpecifiedLocalColumn()) {
            specify().columnDeadReasonCode();
        }
        doSetupSelect(() -> query().queryDeadReason());
    }

    protected VillageDayNss _nssVillageDay;
    public VillageDayNss xdfgetNssVillageDay() {
        if (_nssVillageDay == null) { _nssVillageDay = new VillageDayNss(null); }
        return _nssVillageDay;
    }
    /**
     * Set up relation columns to select clause. <br>
     * VILLAGE_DAY by my DEAD_VILLAGE_DAY_ID, named 'villageDay'.
     * <pre>
     * <span style="color: #0000C0">villagePlayerBhv</span>.selectEntity(<span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">cb</span>.<span style="color: #CC4747">setupSelect_VillageDay()</span>; <span style="color: #3F7E5E">// ...().with[nested-relation]()</span>
     *     <span style="color: #553000">cb</span>.query().set...
     * }).alwaysPresent(<span style="color: #553000">villagePlayer</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     ... = <span style="color: #553000">villagePlayer</span>.<span style="color: #CC4747">getVillageDay()</span>; <span style="color: #3F7E5E">// you can get by using SetupSelect</span>
     * });
     * </pre>
     * @return The set-upper of nested relation. {setupSelect...().with[nested-relation]} (NotNull)
     */
    public VillageDayNss setupSelect_VillageDay() {
        assertSetupSelectPurpose("villageDay");
        if (hasSpecifiedLocalColumn()) {
            specify().columnDeadVillageDayId();
        }
        doSetupSelect(() -> query().queryVillageDay());
        if (_nssVillageDay == null || !_nssVillageDay.hasConditionQuery())
        { _nssVillageDay = new VillageDayNss(query().queryVillageDay()); }
        return _nssVillageDay;
    }

    protected PlayerNss _nssPlayer;
    public PlayerNss xdfgetNssPlayer() {
        if (_nssPlayer == null) { _nssPlayer = new PlayerNss(null); }
        return _nssPlayer;
    }
    /**
     * Set up relation columns to select clause. <br>
     * PLAYER by my PLAYER_ID, named 'player'.
     * <pre>
     * <span style="color: #0000C0">villagePlayerBhv</span>.selectEntity(<span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">cb</span>.<span style="color: #CC4747">setupSelect_Player()</span>; <span style="color: #3F7E5E">// ...().with[nested-relation]()</span>
     *     <span style="color: #553000">cb</span>.query().set...
     * }).alwaysPresent(<span style="color: #553000">villagePlayer</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     ... = <span style="color: #553000">villagePlayer</span>.<span style="color: #CC4747">getPlayer()</span>; <span style="color: #3F7E5E">// you can get by using SetupSelect</span>
     * });
     * </pre>
     * @return The set-upper of nested relation. {setupSelect...().with[nested-relation]} (NotNull)
     */
    public PlayerNss setupSelect_Player() {
        assertSetupSelectPurpose("player");
        if (hasSpecifiedLocalColumn()) {
            specify().columnPlayerId();
        }
        doSetupSelect(() -> query().queryPlayer());
        if (_nssPlayer == null || !_nssPlayer.hasConditionQuery())
        { _nssPlayer = new PlayerNss(query().queryPlayer()); }
        return _nssPlayer;
    }

    protected SkillNss _nssSkillByRequestSkillCode;
    public SkillNss xdfgetNssSkillByRequestSkillCode() {
        if (_nssSkillByRequestSkillCode == null) { _nssSkillByRequestSkillCode = new SkillNss(null); }
        return _nssSkillByRequestSkillCode;
    }
    /**
     * Set up relation columns to select clause. <br>
     * SKILL by my REQUEST_SKILL_CODE, named 'skillByRequestSkillCode'.
     * <pre>
     * <span style="color: #0000C0">villagePlayerBhv</span>.selectEntity(<span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">cb</span>.<span style="color: #CC4747">setupSelect_SkillByRequestSkillCode()</span>; <span style="color: #3F7E5E">// ...().with[nested-relation]()</span>
     *     <span style="color: #553000">cb</span>.query().set...
     * }).alwaysPresent(<span style="color: #553000">villagePlayer</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     ... = <span style="color: #553000">villagePlayer</span>.<span style="color: #CC4747">getSkillByRequestSkillCode()</span>; <span style="color: #3F7E5E">// you can get by using SetupSelect</span>
     * });
     * </pre>
     * @return The set-upper of nested relation. {setupSelect...().with[nested-relation]} (NotNull)
     */
    public SkillNss setupSelect_SkillByRequestSkillCode() {
        assertSetupSelectPurpose("skillByRequestSkillCode");
        if (hasSpecifiedLocalColumn()) {
            specify().columnRequestSkillCode();
        }
        doSetupSelect(() -> query().querySkillByRequestSkillCode());
        if (_nssSkillByRequestSkillCode == null || !_nssSkillByRequestSkillCode.hasConditionQuery())
        { _nssSkillByRequestSkillCode = new SkillNss(query().querySkillByRequestSkillCode()); }
        return _nssSkillByRequestSkillCode;
    }

    protected SkillNss _nssSkillBySecondRequestSkillCode;
    public SkillNss xdfgetNssSkillBySecondRequestSkillCode() {
        if (_nssSkillBySecondRequestSkillCode == null) { _nssSkillBySecondRequestSkillCode = new SkillNss(null); }
        return _nssSkillBySecondRequestSkillCode;
    }
    /**
     * Set up relation columns to select clause. <br>
     * SKILL by my SECOND_REQUEST_SKILL_CODE, named 'skillBySecondRequestSkillCode'.
     * <pre>
     * <span style="color: #0000C0">villagePlayerBhv</span>.selectEntity(<span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">cb</span>.<span style="color: #CC4747">setupSelect_SkillBySecondRequestSkillCode()</span>; <span style="color: #3F7E5E">// ...().with[nested-relation]()</span>
     *     <span style="color: #553000">cb</span>.query().set...
     * }).alwaysPresent(<span style="color: #553000">villagePlayer</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     ... = <span style="color: #553000">villagePlayer</span>.<span style="color: #CC4747">getSkillBySecondRequestSkillCode()</span>; <span style="color: #3F7E5E">// you can get by using SetupSelect</span>
     * });
     * </pre>
     * @return The set-upper of nested relation. {setupSelect...().with[nested-relation]} (NotNull)
     */
    public SkillNss setupSelect_SkillBySecondRequestSkillCode() {
        assertSetupSelectPurpose("skillBySecondRequestSkillCode");
        if (hasSpecifiedLocalColumn()) {
            specify().columnSecondRequestSkillCode();
        }
        doSetupSelect(() -> query().querySkillBySecondRequestSkillCode());
        if (_nssSkillBySecondRequestSkillCode == null || !_nssSkillBySecondRequestSkillCode.hasConditionQuery())
        { _nssSkillBySecondRequestSkillCode = new SkillNss(query().querySkillBySecondRequestSkillCode()); }
        return _nssSkillBySecondRequestSkillCode;
    }

    protected SkillNss _nssSkillBySkillCode;
    public SkillNss xdfgetNssSkillBySkillCode() {
        if (_nssSkillBySkillCode == null) { _nssSkillBySkillCode = new SkillNss(null); }
        return _nssSkillBySkillCode;
    }
    /**
     * Set up relation columns to select clause. <br>
     * SKILL by my SKILL_CODE, named 'skillBySkillCode'.
     * <pre>
     * <span style="color: #0000C0">villagePlayerBhv</span>.selectEntity(<span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">cb</span>.<span style="color: #CC4747">setupSelect_SkillBySkillCode()</span>; <span style="color: #3F7E5E">// ...().with[nested-relation]()</span>
     *     <span style="color: #553000">cb</span>.query().set...
     * }).alwaysPresent(<span style="color: #553000">villagePlayer</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     ... = <span style="color: #553000">villagePlayer</span>.<span style="color: #CC4747">getSkillBySkillCode()</span>; <span style="color: #3F7E5E">// you can get by using SetupSelect</span>
     * });
     * </pre>
     * @return The set-upper of nested relation. {setupSelect...().with[nested-relation]} (NotNull)
     */
    public SkillNss setupSelect_SkillBySkillCode() {
        assertSetupSelectPurpose("skillBySkillCode");
        if (hasSpecifiedLocalColumn()) {
            specify().columnSkillCode();
        }
        doSetupSelect(() -> query().querySkillBySkillCode());
        if (_nssSkillBySkillCode == null || !_nssSkillBySkillCode.hasConditionQuery())
        { _nssSkillBySkillCode = new SkillNss(query().querySkillBySkillCode()); }
        return _nssSkillBySkillCode;
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
     * <span style="color: #0000C0">villagePlayerBhv</span>.selectEntity(<span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">cb</span>.<span style="color: #CC4747">setupSelect_Village()</span>; <span style="color: #3F7E5E">// ...().with[nested-relation]()</span>
     *     <span style="color: #553000">cb</span>.query().set...
     * }).alwaysPresent(<span style="color: #553000">villagePlayer</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     ... = <span style="color: #553000">villagePlayer</span>.<span style="color: #CC4747">getVillage()</span>; <span style="color: #3F7E5E">// you can get by using SetupSelect</span>
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

    public static class HpSpecification extends HpAbstractSpecification<VillagePlayerCQ> {
        protected CharaCB.HpSpecification _chara;
        protected DeadReasonCB.HpSpecification _deadReason;
        protected VillageDayCB.HpSpecification _villageDay;
        protected PlayerCB.HpSpecification _player;
        protected SkillCB.HpSpecification _skillByRequestSkillCode;
        protected SkillCB.HpSpecification _skillBySecondRequestSkillCode;
        protected SkillCB.HpSpecification _skillBySkillCode;
        protected VillageCB.HpSpecification _village;
        public HpSpecification(ConditionBean baseCB, HpSpQyCall<VillagePlayerCQ> qyCall
                             , HpCBPurpose purpose, DBMetaProvider dbmetaProvider
                             , HpSDRFunctionFactory sdrFuncFactory)
        { super(baseCB, qyCall, purpose, dbmetaProvider, sdrFuncFactory); }
        /**
         * VILLAGE_PLAYER_ID: {PK, ID, NotNull, INT UNSIGNED(10)}
         * @return The information object of specified column. (NotNull)
         */
        public SpecifiedColumn columnVillagePlayerId() { return doColumn("VILLAGE_PLAYER_ID"); }
        /**
         * VILLAGE_ID: {IX, NotNull, INT UNSIGNED(10), FK to VILLAGE}
         * @return The information object of specified column. (NotNull)
         */
        public SpecifiedColumn columnVillageId() { return doColumn("VILLAGE_ID"); }
        /**
         * PLAYER_ID: {IX, NotNull, INT UNSIGNED(10), FK to PLAYER}
         * @return The information object of specified column. (NotNull)
         */
        public SpecifiedColumn columnPlayerId() { return doColumn("PLAYER_ID"); }
        /**
         * CHARA_ID: {IX, NotNull, INT UNSIGNED(10), FK to CHARA}
         * @return The information object of specified column. (NotNull)
         */
        public SpecifiedColumn columnCharaId() { return doColumn("CHARA_ID"); }
        /**
         * SKILL_CODE: {IX, VARCHAR(20), FK to SKILL, classification=Skill}
         * @return The information object of specified column. (NotNull)
         */
        public SpecifiedColumn columnSkillCode() { return doColumn("SKILL_CODE"); }
        /**
         * REQUEST_SKILL_CODE: {IX, VARCHAR(20), FK to SKILL, classification=Skill}
         * @return The information object of specified column. (NotNull)
         */
        public SpecifiedColumn columnRequestSkillCode() { return doColumn("REQUEST_SKILL_CODE"); }
        /**
         * SECOND_REQUEST_SKILL_CODE: {IX, VARCHAR(20), FK to SKILL, classification=Skill}
         * @return The information object of specified column. (NotNull)
         */
        public SpecifiedColumn columnSecondRequestSkillCode() { return doColumn("SECOND_REQUEST_SKILL_CODE"); }
        /**
         * IS_DEAD: {NotNull, BIT}
         * @return The information object of specified column. (NotNull)
         */
        public SpecifiedColumn columnIsDead() { return doColumn("IS_DEAD"); }
        /**
         * IS_SPECTATOR: {NotNull, BIT}
         * @return The information object of specified column. (NotNull)
         */
        public SpecifiedColumn columnIsSpectator() { return doColumn("IS_SPECTATOR"); }
        /**
         * DEAD_REASON_CODE: {IX, VARCHAR(20), FK to DEAD_REASON, classification=DeadReason}
         * @return The information object of specified column. (NotNull)
         */
        public SpecifiedColumn columnDeadReasonCode() { return doColumn("DEAD_REASON_CODE"); }
        /**
         * DEAD_VILLAGE_DAY_ID: {IX, INT UNSIGNED(10), FK to VILLAGE_DAY}
         * @return The information object of specified column. (NotNull)
         */
        public SpecifiedColumn columnDeadVillageDayId() { return doColumn("DEAD_VILLAGE_DAY_ID"); }
        /**
         * IS_GONE: {NotNull, BIT}
         * @return The information object of specified column. (NotNull)
         */
        public SpecifiedColumn columnIsGone() { return doColumn("IS_GONE"); }
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
            columnVillagePlayerId(); // PK
            if (qyCall().qy().hasConditionQueryChara()
                    || qyCall().qy().xgetReferrerQuery() instanceof CharaCQ) {
                columnCharaId(); // FK or one-to-one referrer
            }
            if (qyCall().qy().hasConditionQueryDeadReason()
                    || qyCall().qy().xgetReferrerQuery() instanceof DeadReasonCQ) {
                columnDeadReasonCode(); // FK or one-to-one referrer
            }
            if (qyCall().qy().hasConditionQueryVillageDay()
                    || qyCall().qy().xgetReferrerQuery() instanceof VillageDayCQ) {
                columnDeadVillageDayId(); // FK or one-to-one referrer
            }
            if (qyCall().qy().hasConditionQueryPlayer()
                    || qyCall().qy().xgetReferrerQuery() instanceof PlayerCQ) {
                columnPlayerId(); // FK or one-to-one referrer
            }
            if (qyCall().qy().hasConditionQuerySkillByRequestSkillCode()
                    || qyCall().qy().xgetReferrerQuery() instanceof SkillCQ) {
                columnRequestSkillCode(); // FK or one-to-one referrer
            }
            if (qyCall().qy().hasConditionQuerySkillBySecondRequestSkillCode()
                    || qyCall().qy().xgetReferrerQuery() instanceof SkillCQ) {
                columnSecondRequestSkillCode(); // FK or one-to-one referrer
            }
            if (qyCall().qy().hasConditionQuerySkillBySkillCode()
                    || qyCall().qy().xgetReferrerQuery() instanceof SkillCQ) {
                columnSkillCode(); // FK or one-to-one referrer
            }
            if (qyCall().qy().hasConditionQueryVillage()
                    || qyCall().qy().xgetReferrerQuery() instanceof VillageCQ) {
                columnVillageId(); // FK or one-to-one referrer
            }
        }
        @Override
        protected String getTableDbName() { return "VILLAGE_PLAYER"; }
        /**
         * Prepare to specify functions about relation table. <br>
         * CHARA by my CHARA_ID, named 'chara'.
         * @return The instance for specification for relation table to specify. (NotNull)
         */
        public CharaCB.HpSpecification specifyChara() {
            assertRelation("chara");
            if (_chara == null) {
                _chara = new CharaCB.HpSpecification(_baseCB
                    , xcreateSpQyCall(() -> _qyCall.has() && _qyCall.qy().hasConditionQueryChara()
                                    , () -> _qyCall.qy().queryChara())
                    , _purpose, _dbmetaProvider, xgetSDRFnFc());
                if (xhasSyncQyCall()) { // inherits it
                    _chara.xsetSyncQyCall(xcreateSpQyCall(
                        () -> xsyncQyCall().has() && xsyncQyCall().qy().hasConditionQueryChara()
                      , () -> xsyncQyCall().qy().queryChara()));
                }
            }
            return _chara;
        }
        /**
         * Prepare to specify functions about relation table. <br>
         * DEAD_REASON by my DEAD_REASON_CODE, named 'deadReason'.
         * @return The instance for specification for relation table to specify. (NotNull)
         */
        public DeadReasonCB.HpSpecification specifyDeadReason() {
            assertRelation("deadReason");
            if (_deadReason == null) {
                _deadReason = new DeadReasonCB.HpSpecification(_baseCB
                    , xcreateSpQyCall(() -> _qyCall.has() && _qyCall.qy().hasConditionQueryDeadReason()
                                    , () -> _qyCall.qy().queryDeadReason())
                    , _purpose, _dbmetaProvider, xgetSDRFnFc());
                if (xhasSyncQyCall()) { // inherits it
                    _deadReason.xsetSyncQyCall(xcreateSpQyCall(
                        () -> xsyncQyCall().has() && xsyncQyCall().qy().hasConditionQueryDeadReason()
                      , () -> xsyncQyCall().qy().queryDeadReason()));
                }
            }
            return _deadReason;
        }
        /**
         * Prepare to specify functions about relation table. <br>
         * VILLAGE_DAY by my DEAD_VILLAGE_DAY_ID, named 'villageDay'.
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
         * PLAYER by my PLAYER_ID, named 'player'.
         * @return The instance for specification for relation table to specify. (NotNull)
         */
        public PlayerCB.HpSpecification specifyPlayer() {
            assertRelation("player");
            if (_player == null) {
                _player = new PlayerCB.HpSpecification(_baseCB
                    , xcreateSpQyCall(() -> _qyCall.has() && _qyCall.qy().hasConditionQueryPlayer()
                                    , () -> _qyCall.qy().queryPlayer())
                    , _purpose, _dbmetaProvider, xgetSDRFnFc());
                if (xhasSyncQyCall()) { // inherits it
                    _player.xsetSyncQyCall(xcreateSpQyCall(
                        () -> xsyncQyCall().has() && xsyncQyCall().qy().hasConditionQueryPlayer()
                      , () -> xsyncQyCall().qy().queryPlayer()));
                }
            }
            return _player;
        }
        /**
         * Prepare to specify functions about relation table. <br>
         * SKILL by my REQUEST_SKILL_CODE, named 'skillByRequestSkillCode'.
         * @return The instance for specification for relation table to specify. (NotNull)
         */
        public SkillCB.HpSpecification specifySkillByRequestSkillCode() {
            assertRelation("skillByRequestSkillCode");
            if (_skillByRequestSkillCode == null) {
                _skillByRequestSkillCode = new SkillCB.HpSpecification(_baseCB
                    , xcreateSpQyCall(() -> _qyCall.has() && _qyCall.qy().hasConditionQuerySkillByRequestSkillCode()
                                    , () -> _qyCall.qy().querySkillByRequestSkillCode())
                    , _purpose, _dbmetaProvider, xgetSDRFnFc());
                if (xhasSyncQyCall()) { // inherits it
                    _skillByRequestSkillCode.xsetSyncQyCall(xcreateSpQyCall(
                        () -> xsyncQyCall().has() && xsyncQyCall().qy().hasConditionQuerySkillByRequestSkillCode()
                      , () -> xsyncQyCall().qy().querySkillByRequestSkillCode()));
                }
            }
            return _skillByRequestSkillCode;
        }
        /**
         * Prepare to specify functions about relation table. <br>
         * SKILL by my SECOND_REQUEST_SKILL_CODE, named 'skillBySecondRequestSkillCode'.
         * @return The instance for specification for relation table to specify. (NotNull)
         */
        public SkillCB.HpSpecification specifySkillBySecondRequestSkillCode() {
            assertRelation("skillBySecondRequestSkillCode");
            if (_skillBySecondRequestSkillCode == null) {
                _skillBySecondRequestSkillCode = new SkillCB.HpSpecification(_baseCB
                    , xcreateSpQyCall(() -> _qyCall.has() && _qyCall.qy().hasConditionQuerySkillBySecondRequestSkillCode()
                                    , () -> _qyCall.qy().querySkillBySecondRequestSkillCode())
                    , _purpose, _dbmetaProvider, xgetSDRFnFc());
                if (xhasSyncQyCall()) { // inherits it
                    _skillBySecondRequestSkillCode.xsetSyncQyCall(xcreateSpQyCall(
                        () -> xsyncQyCall().has() && xsyncQyCall().qy().hasConditionQuerySkillBySecondRequestSkillCode()
                      , () -> xsyncQyCall().qy().querySkillBySecondRequestSkillCode()));
                }
            }
            return _skillBySecondRequestSkillCode;
        }
        /**
         * Prepare to specify functions about relation table. <br>
         * SKILL by my SKILL_CODE, named 'skillBySkillCode'.
         * @return The instance for specification for relation table to specify. (NotNull)
         */
        public SkillCB.HpSpecification specifySkillBySkillCode() {
            assertRelation("skillBySkillCode");
            if (_skillBySkillCode == null) {
                _skillBySkillCode = new SkillCB.HpSpecification(_baseCB
                    , xcreateSpQyCall(() -> _qyCall.has() && _qyCall.qy().hasConditionQuerySkillBySkillCode()
                                    , () -> _qyCall.qy().querySkillBySkillCode())
                    , _purpose, _dbmetaProvider, xgetSDRFnFc());
                if (xhasSyncQyCall()) { // inherits it
                    _skillBySkillCode.xsetSyncQyCall(xcreateSpQyCall(
                        () -> xsyncQyCall().has() && xsyncQyCall().qy().hasConditionQuerySkillBySkillCode()
                      , () -> xsyncQyCall().qy().querySkillBySkillCode()));
                }
            }
            return _skillBySkillCode;
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
         * ABILITY by TARGET_VILLAGE_PLAYER_ID, named 'abilityByTargetVillagePlayerIdList'.
         * <pre>
         * cb.specify().<span style="color: #CC4747">derived${relationMethodIdentityName}()</span>.<span style="color: #CC4747">max</span>(abilityCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
         *     abilityCB.specify().<span style="color: #CC4747">column...</span> <span style="color: #3F7E5E">// derived column by function</span>
         *     abilityCB.query().set... <span style="color: #3F7E5E">// referrer condition</span>
         * }, Ability.<span style="color: #CC4747">ALIAS_foo...</span>);
         * </pre>
         * @return The object to set up a function for referrer table. (NotNull)
         */
        public HpSDRFunction<AbilityCB, VillagePlayerCQ> derivedAbilityByTargetVillagePlayerId() {
            assertDerived("abilityByTargetVillagePlayerIdList"); if (xhasSyncQyCall()) { xsyncQyCall().qy(); } // for sync (for example, this in ColumnQuery)
            return cHSDRF(_baseCB, _qyCall.qy(), (String fn, SubQuery<AbilityCB> sq, VillagePlayerCQ cq, String al, DerivedReferrerOption op)
                    -> cq.xsderiveAbilityByTargetVillagePlayerIdList(fn, sq, al, op), _dbmetaProvider);
        }
        /**
         * Prepare for (Specify)DerivedReferrer (correlated sub-query). <br>
         * {select max(FOO) from ABILITY where ...) as FOO_MAX} <br>
         * ABILITY by VILLAGE_PLAYER_ID, named 'abilityByVillagePlayerIdList'.
         * <pre>
         * cb.specify().<span style="color: #CC4747">derived${relationMethodIdentityName}()</span>.<span style="color: #CC4747">max</span>(abilityCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
         *     abilityCB.specify().<span style="color: #CC4747">column...</span> <span style="color: #3F7E5E">// derived column by function</span>
         *     abilityCB.query().set... <span style="color: #3F7E5E">// referrer condition</span>
         * }, Ability.<span style="color: #CC4747">ALIAS_foo...</span>);
         * </pre>
         * @return The object to set up a function for referrer table. (NotNull)
         */
        public HpSDRFunction<AbilityCB, VillagePlayerCQ> derivedAbilityByVillagePlayerId() {
            assertDerived("abilityByVillagePlayerIdList"); if (xhasSyncQyCall()) { xsyncQyCall().qy(); } // for sync (for example, this in ColumnQuery)
            return cHSDRF(_baseCB, _qyCall.qy(), (String fn, SubQuery<AbilityCB> sq, VillagePlayerCQ cq, String al, DerivedReferrerOption op)
                    -> cq.xsderiveAbilityByVillagePlayerIdList(fn, sq, al, op), _dbmetaProvider);
        }
        /**
         * Prepare for (Specify)DerivedReferrer (correlated sub-query). <br>
         * {select max(FOO) from COMMIT where ...) as FOO_MAX} <br>
         * COMMIT by VILLAGE_PLAYER_ID, named 'commitList'.
         * <pre>
         * cb.specify().<span style="color: #CC4747">derived${relationMethodIdentityName}()</span>.<span style="color: #CC4747">max</span>(commitCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
         *     commitCB.specify().<span style="color: #CC4747">column...</span> <span style="color: #3F7E5E">// derived column by function</span>
         *     commitCB.query().set... <span style="color: #3F7E5E">// referrer condition</span>
         * }, Commit.<span style="color: #CC4747">ALIAS_foo...</span>);
         * </pre>
         * @return The object to set up a function for referrer table. (NotNull)
         */
        public HpSDRFunction<CommitCB, VillagePlayerCQ> derivedCommit() {
            assertDerived("commitList"); if (xhasSyncQyCall()) { xsyncQyCall().qy(); } // for sync (for example, this in ColumnQuery)
            return cHSDRF(_baseCB, _qyCall.qy(), (String fn, SubQuery<CommitCB> sq, VillagePlayerCQ cq, String al, DerivedReferrerOption op)
                    -> cq.xsderiveCommitList(fn, sq, al, op), _dbmetaProvider);
        }
        /**
         * Prepare for (Specify)DerivedReferrer (correlated sub-query). <br>
         * {select max(FOO) from VOTE where ...) as FOO_MAX} <br>
         * VOTE by TARGET_VILLAGE_PLAYER_ID, named 'voteByTargetVillagePlayerIdList'.
         * <pre>
         * cb.specify().<span style="color: #CC4747">derived${relationMethodIdentityName}()</span>.<span style="color: #CC4747">max</span>(voteCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
         *     voteCB.specify().<span style="color: #CC4747">column...</span> <span style="color: #3F7E5E">// derived column by function</span>
         *     voteCB.query().set... <span style="color: #3F7E5E">// referrer condition</span>
         * }, Vote.<span style="color: #CC4747">ALIAS_foo...</span>);
         * </pre>
         * @return The object to set up a function for referrer table. (NotNull)
         */
        public HpSDRFunction<VoteCB, VillagePlayerCQ> derivedVoteByTargetVillagePlayerId() {
            assertDerived("voteByTargetVillagePlayerIdList"); if (xhasSyncQyCall()) { xsyncQyCall().qy(); } // for sync (for example, this in ColumnQuery)
            return cHSDRF(_baseCB, _qyCall.qy(), (String fn, SubQuery<VoteCB> sq, VillagePlayerCQ cq, String al, DerivedReferrerOption op)
                    -> cq.xsderiveVoteByTargetVillagePlayerIdList(fn, sq, al, op), _dbmetaProvider);
        }
        /**
         * Prepare for (Specify)DerivedReferrer (correlated sub-query). <br>
         * {select max(FOO) from VOTE where ...) as FOO_MAX} <br>
         * VOTE by VILLAGE_PLAYER_ID, named 'voteByVillagePlayerIdList'.
         * <pre>
         * cb.specify().<span style="color: #CC4747">derived${relationMethodIdentityName}()</span>.<span style="color: #CC4747">max</span>(voteCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
         *     voteCB.specify().<span style="color: #CC4747">column...</span> <span style="color: #3F7E5E">// derived column by function</span>
         *     voteCB.query().set... <span style="color: #3F7E5E">// referrer condition</span>
         * }, Vote.<span style="color: #CC4747">ALIAS_foo...</span>);
         * </pre>
         * @return The object to set up a function for referrer table. (NotNull)
         */
        public HpSDRFunction<VoteCB, VillagePlayerCQ> derivedVoteByVillagePlayerId() {
            assertDerived("voteByVillagePlayerIdList"); if (xhasSyncQyCall()) { xsyncQyCall().qy(); } // for sync (for example, this in ColumnQuery)
            return cHSDRF(_baseCB, _qyCall.qy(), (String fn, SubQuery<VoteCB> sq, VillagePlayerCQ cq, String al, DerivedReferrerOption op)
                    -> cq.xsderiveVoteByVillagePlayerIdList(fn, sq, al, op), _dbmetaProvider);
        }
        /**
         * Prepare for (Specify)MyselfDerived (SubQuery).
         * @return The object to set up a function for myself table. (NotNull)
         */
        public HpSDRFunction<VillagePlayerCB, VillagePlayerCQ> myselfDerived() {
            assertDerived("myselfDerived"); if (xhasSyncQyCall()) { xsyncQyCall().qy(); } // for sync (for example, this in ColumnQuery)
            return cHSDRF(_baseCB, _qyCall.qy(), (String fn, SubQuery<VillagePlayerCB> sq, VillagePlayerCQ cq, String al, DerivedReferrerOption op)
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
    public VillagePlayerCB dreamCruiseCB() {
        VillagePlayerCB cb = new VillagePlayerCB();
        cb.xsetupForDreamCruise((VillagePlayerCB) this);
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
    public HpColQyOperand<VillagePlayerCB> columnQuery(final SpecifyQuery<VillagePlayerCB> colCBLambda) {
        return xcreateColQyOperand((rightSp, operand) -> {
            return xcolqy(xcreateColumnQueryCB(), xcreateColumnQueryCB(), colCBLambda, rightSp, operand);
        });
    }

    protected VillagePlayerCB xcreateColumnQueryCB() {
        VillagePlayerCB cb = new VillagePlayerCB();
        cb.xsetupForColumnQuery((VillagePlayerCB)this);
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
    public void orScopeQuery(OrQuery<VillagePlayerCB> orCBLambda) {
        xorSQ((VillagePlayerCB)this, orCBLambda);
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
    public void orScopeQueryAndPart(AndQuery<VillagePlayerCB> andCBLambda) {
        xorSQAP((VillagePlayerCB)this, andCBLambda);
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
        final VillagePlayerCB cb;
        if (mainCB != null) {
            cb = (VillagePlayerCB)mainCB;
        } else {
            cb = new VillagePlayerCB();
        }
        specify().xsetSyncQyCall(xcreateSpQyCall(() -> true, () -> cb.query()));
    }

    // ===================================================================================
    //                                                                            Internal
    //                                                                            ========
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xgetConditionBeanClassNameInternally() { return VillagePlayerCB.class.getName(); }
    protected String xgetConditionQueryClassNameInternally() { return VillagePlayerCQ.class.getName(); }
    protected String xgetSubQueryClassNameInternally() { return SubQuery.class.getName(); }
    protected String xgetConditionOptionClassNameInternally() { return ConditionOption.class.getName(); }
}
