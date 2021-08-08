package com.ort.dbflute.bsbhv;

import java.util.List;

import org.dbflute.*;
import org.dbflute.bhv.*;
import org.dbflute.bhv.core.BehaviorCommandInvoker;
import org.dbflute.bhv.readable.*;
import org.dbflute.bhv.writable.*;
import org.dbflute.bhv.referrer.*;
import org.dbflute.cbean.*;
import org.dbflute.cbean.chelper.HpSLSFunction;
import org.dbflute.cbean.result.*;
import org.dbflute.exception.*;
import org.dbflute.hook.CommonColumnAutoSetupper;
import org.dbflute.optional.OptionalEntity;
import org.dbflute.outsidesql.executor.*;
import com.ort.dbflute.exbhv.*;
import com.ort.dbflute.bsbhv.loader.*;
import com.ort.dbflute.exentity.*;
import com.ort.dbflute.bsentity.dbmeta.*;
import com.ort.dbflute.cbean.*;

/**
 * The behavior of VILLAGE_PLAYER as TABLE. <br>
 * <pre>
 * [primary key]
 *     VILLAGE_PLAYER_ID
 *
 * [column]
 *     VILLAGE_PLAYER_ID, VILLAGE_ID, PLAYER_ID, CHARA_ID, SKILL_CODE, REQUEST_SKILL_CODE, SECOND_REQUEST_SKILL_CODE, IS_DEAD, IS_SPECTATOR, DEAD_REASON_CODE, DEAD_VILLAGE_DAY_ID, IS_GONE, REGISTER_DATETIME, REGISTER_TRACE, UPDATE_DATETIME, UPDATE_TRACE
 *
 * [sequence]
 *     
 *
 * [identity]
 *     VILLAGE_PLAYER_ID
 *
 * [version-no]
 *     
 *
 * [foreign table]
 *     CHARA, DEAD_REASON, VILLAGE_DAY, PLAYER, SKILL, VILLAGE
 *
 * [referrer table]
 *     ABILITY, COMING_OUT, COMMIT, VOTE
 *
 * [foreign property]
 *     chara, deadReason, villageDay, player, skillByRequestSkillCode, skillBySecondRequestSkillCode, skillBySkillCode, village
 *
 * [referrer property]
 *     abilityByTargetVillagePlayerIdList, abilityByVillagePlayerIdList, comingOutList, commitList, voteByTargetVillagePlayerIdList, voteByVillagePlayerIdList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsVillagePlayerBhv extends AbstractBehaviorWritable<VillagePlayer, VillagePlayerCB> {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /*df:beginQueryPath*/
    /*df:endQueryPath*/

    // ===================================================================================
    //                                                                             DB Meta
    //                                                                             =======
    /** {@inheritDoc} */
    public VillagePlayerDbm asDBMeta() { return VillagePlayerDbm.getInstance(); }
    /** {@inheritDoc} */
    public String asTableDbName() { return "VILLAGE_PLAYER"; }

    // ===================================================================================
    //                                                                        New Instance
    //                                                                        ============
    /** {@inheritDoc} */
    public VillagePlayerCB newConditionBean() { return new VillagePlayerCB(); }

    // ===================================================================================
    //                                                                        Count Select
    //                                                                        ============
    /**
     * Select the count of uniquely-selected records by the condition-bean. {IgnorePagingCondition, IgnoreSpecifyColumn}<br>
     * SpecifyColumn is ignored but you can use it only to remove text type column for union's distinct.
     * <pre>
     * <span style="color: #70226C">int</span> count = <span style="color: #0000C0">villagePlayerBhv</span>.<span style="color: #CC4747">selectCount</span>(<span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">cb</span>.query().set...
     * });
     * </pre>
     * @param cbLambda The callback for condition-bean of VillagePlayer. (NotNull)
     * @return The count for the condition. (NotMinus)
     */
    public int selectCount(CBCall<VillagePlayerCB> cbLambda) {
        return facadeSelectCount(createCB(cbLambda));
    }

    // ===================================================================================
    //                                                                       Entity Select
    //                                                                       =============
    /**
     * Select the entity by the condition-bean. <br>
     * It returns not-null optional entity, so you should ... <br>
     * <span style="color: #AD4747; font-size: 120%">If the data is always present as your business rule, alwaysPresent().</span> <br>
     * <span style="color: #AD4747; font-size: 120%">If it might be no data, isPresent() and orElse(), ...</span>
     * <pre>
     * <span style="color: #3F7E5E">// if the data always exists as your business rule</span>
     * <span style="color: #0000C0">villagePlayerBhv</span>.<span style="color: #CC4747">selectEntity</span>(<span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">cb</span>.query().set...
     * }).<span style="color: #CC4747">alwaysPresent</span>(<span style="color: #553000">villagePlayer</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #3F7E5E">// called if present, or exception</span>
     *     ... = <span style="color: #553000">villagePlayer</span>.get...
     * });
     *
     * <span style="color: #3F7E5E">// if it might be no data, ...</span>
     * <span style="color: #0000C0">villagePlayerBhv</span>.<span style="color: #CC4747">selectEntity</span>(<span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">cb</span>.query().set...
     * }).<span style="color: #CC4747">ifPresent</span>(<span style="color: #553000">villagePlayer</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #3F7E5E">// called if present</span>
     *     ... = <span style="color: #553000">villagePlayer</span>.get...
     * }).<span style="color: #994747">orElse</span>(() <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #3F7E5E">// called if not present</span>
     * });
     * </pre>
     * @param cbLambda The callback for condition-bean of VillagePlayer. (NotNull)
     * @return The optional entity selected by the condition. (NotNull: if no data, empty entity)
     * @throws EntityAlreadyDeletedException When get(), required() of return value is called and the value is null, which means entity has already been deleted (not found).
     * @throws EntityDuplicatedException When the entity has been duplicated.
     * @throws SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public OptionalEntity<VillagePlayer> selectEntity(CBCall<VillagePlayerCB> cbLambda) {
        return facadeSelectEntity(createCB(cbLambda));
    }

    protected OptionalEntity<VillagePlayer> facadeSelectEntity(VillagePlayerCB cb) {
        return doSelectOptionalEntity(cb, typeOfSelectedEntity());
    }

    protected <ENTITY extends VillagePlayer> OptionalEntity<ENTITY> doSelectOptionalEntity(VillagePlayerCB cb, Class<? extends ENTITY> tp) {
        return createOptionalEntity(doSelectEntity(cb, tp), cb);
    }

    protected Entity doReadEntity(ConditionBean cb) { return facadeSelectEntity(downcast(cb)).orElse(null); }

    /**
     * Select the entity by the condition-bean with deleted check. <br>
     * <span style="color: #AD4747; font-size: 120%">If the data is always present as your business rule, this method is good.</span>
     * <pre>
     * VillagePlayer <span style="color: #553000">villagePlayer</span> = <span style="color: #0000C0">villagePlayerBhv</span>.<span style="color: #CC4747">selectEntityWithDeletedCheck</span>(cb <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> cb.acceptPK(1));
     * ... = <span style="color: #553000">villagePlayer</span>.get...(); <span style="color: #3F7E5E">// the entity always be not null</span>
     * </pre>
     * @param cbLambda The callback for condition-bean of VillagePlayer. (NotNull)
     * @return The entity selected by the condition. (NotNull: if no data, throws exception)
     * @throws EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @throws EntityDuplicatedException When the entity has been duplicated.
     * @throws SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public VillagePlayer selectEntityWithDeletedCheck(CBCall<VillagePlayerCB> cbLambda) {
        return facadeSelectEntityWithDeletedCheck(createCB(cbLambda));
    }

    /**
     * Select the entity by the primary-key value.
     * @param villagePlayerId : PK, ID, NotNull, INT UNSIGNED(10). (NotNull)
     * @return The optional entity selected by the PK. (NotNull: if no data, empty entity)
     * @throws EntityAlreadyDeletedException When get(), required() of return value is called and the value is null, which means entity has already been deleted (not found).
     * @throws EntityDuplicatedException When the entity has been duplicated.
     * @throws SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public OptionalEntity<VillagePlayer> selectByPK(Integer villagePlayerId) {
        return facadeSelectByPK(villagePlayerId);
    }

    protected OptionalEntity<VillagePlayer> facadeSelectByPK(Integer villagePlayerId) {
        return doSelectOptionalByPK(villagePlayerId, typeOfSelectedEntity());
    }

    protected <ENTITY extends VillagePlayer> ENTITY doSelectByPK(Integer villagePlayerId, Class<? extends ENTITY> tp) {
        return doSelectEntity(xprepareCBAsPK(villagePlayerId), tp);
    }

    protected <ENTITY extends VillagePlayer> OptionalEntity<ENTITY> doSelectOptionalByPK(Integer villagePlayerId, Class<? extends ENTITY> tp) {
        return createOptionalEntity(doSelectByPK(villagePlayerId, tp), villagePlayerId);
    }

    protected VillagePlayerCB xprepareCBAsPK(Integer villagePlayerId) {
        assertObjectNotNull("villagePlayerId", villagePlayerId);
        return newConditionBean().acceptPK(villagePlayerId);
    }

    // ===================================================================================
    //                                                                         List Select
    //                                                                         ===========
    /**
     * Select the list as result bean.
     * <pre>
     * ListResultBean&lt;VillagePlayer&gt; <span style="color: #553000">villagePlayerList</span> = <span style="color: #0000C0">villagePlayerBhv</span>.<span style="color: #CC4747">selectList</span>(<span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">cb</span>.query().set...;
     *     <span style="color: #553000">cb</span>.query().addOrderBy...;
     * });
     * <span style="color: #70226C">for</span> (VillagePlayer <span style="color: #553000">villagePlayer</span> : <span style="color: #553000">villagePlayerList</span>) {
     *     ... = <span style="color: #553000">villagePlayer</span>.get...;
     * }
     * </pre>
     * @param cbLambda The callback for condition-bean of VillagePlayer. (NotNull)
     * @return The result bean of selected list. (NotNull: if no data, returns empty list)
     * @throws DangerousResultSizeException When the result size is over the specified safety size.
     */
    public ListResultBean<VillagePlayer> selectList(CBCall<VillagePlayerCB> cbLambda) {
        return facadeSelectList(createCB(cbLambda));
    }

    @Override
    protected boolean isEntityDerivedMappable() { return true; }

    // ===================================================================================
    //                                                                         Page Select
    //                                                                         ===========
    /**
     * Select the page as result bean. <br>
     * (both count-select and paging-select are executed)
     * <pre>
     * PagingResultBean&lt;VillagePlayer&gt; <span style="color: #553000">page</span> = <span style="color: #0000C0">villagePlayerBhv</span>.<span style="color: #CC4747">selectPage</span>(<span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">cb</span>.query().set...
     *     <span style="color: #553000">cb</span>.query().addOrderBy...
     *     <span style="color: #553000">cb</span>.<span style="color: #CC4747">paging</span>(20, 3); <span style="color: #3F7E5E">// 20 records per a page and current page number is 3</span>
     * });
     * <span style="color: #70226C">int</span> allRecordCount = <span style="color: #553000">page</span>.getAllRecordCount();
     * <span style="color: #70226C">int</span> allPageCount = <span style="color: #553000">page</span>.getAllPageCount();
     * <span style="color: #70226C">boolean</span> isExistPrePage = <span style="color: #553000">page</span>.isExistPrePage();
     * <span style="color: #70226C">boolean</span> isExistNextPage = <span style="color: #553000">page</span>.isExistNextPage();
     * ...
     * <span style="color: #70226C">for</span> (VillagePlayer villagePlayer : <span style="color: #553000">page</span>) {
     *     ... = villagePlayer.get...;
     * }
     * </pre>
     * @param cbLambda The callback for condition-bean of VillagePlayer. (NotNull)
     * @return The result bean of selected page. (NotNull: if no data, returns bean as empty list)
     * @throws DangerousResultSizeException When the result size is over the specified safety size.
     */
    public PagingResultBean<VillagePlayer> selectPage(CBCall<VillagePlayerCB> cbLambda) {
        return facadeSelectPage(createCB(cbLambda));
    }

    // ===================================================================================
    //                                                                       Cursor Select
    //                                                                       =============
    /**
     * Select the cursor by the condition-bean.
     * <pre>
     * <span style="color: #0000C0">villagePlayerBhv</span>.<span style="color: #CC4747">selectCursor</span>(<span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">cb</span>.query().set...
     * }, <span style="color: #553000">member</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     ... = <span style="color: #553000">member</span>.getMemberName();
     * });
     * </pre>
     * @param cbLambda The callback for condition-bean of VillagePlayer. (NotNull)
     * @param entityLambda The handler of entity row of VillagePlayer. (NotNull)
     */
    public void selectCursor(CBCall<VillagePlayerCB> cbLambda, EntityRowHandler<VillagePlayer> entityLambda) {
        facadeSelectCursor(createCB(cbLambda), entityLambda);
    }

    // ===================================================================================
    //                                                                       Scalar Select
    //                                                                       =============
    /**
     * Select the scalar value derived by a function from uniquely-selected records. <br>
     * You should call a function method after this method called like as follows:
     * <pre>
     * <span style="color: #0000C0">villagePlayerBhv</span>.<span style="color: #CC4747">selectScalar</span>(Date.class).max(<span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">cb</span>.specify().<span style="color: #CC4747">column...</span>; <span style="color: #3F7E5E">// required for the function</span>
     *     <span style="color: #553000">cb</span>.query().set...
     * });
     * </pre>
     * @param <RESULT> The type of result.
     * @param resultType The type of result. (NotNull)
     * @return The scalar function object to specify function for scalar value. (NotNull)
     */
    public <RESULT> HpSLSFunction<VillagePlayerCB, RESULT> selectScalar(Class<RESULT> resultType) {
        return facadeScalarSelect(resultType);
    }

    // ===================================================================================
    //                                                                            Sequence
    //                                                                            ========
    @Override
    protected Number doReadNextVal() {
        String msg = "This table is NOT related to sequence: " + asTableDbName();
        throw new UnsupportedOperationException(msg);
    }

    // ===================================================================================
    //                                                                       Load Referrer
    //                                                                       =============
    /**
     * Load referrer for the list by the referrer loader.
     * <pre>
     * List&lt;Member&gt; <span style="color: #553000">memberList</span> = <span style="color: #0000C0">memberBhv</span>.selectList(<span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">cb</span>.query().set...
     * });
     * memberBhv.<span style="color: #CC4747">load</span>(<span style="color: #553000">memberList</span>, <span style="color: #553000">memberLoader</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">memberLoader</span>.<span style="color: #CC4747">loadPurchase</span>(<span style="color: #553000">purchaseCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *         <span style="color: #553000">purchaseCB</span>.setupSelect...
     *         <span style="color: #553000">purchaseCB</span>.query().set...
     *         <span style="color: #553000">purchaseCB</span>.query().addOrderBy...
     *     }); <span style="color: #3F7E5E">// you can also load nested referrer from here</span>
     *     <span style="color: #3F7E5E">//}).withNestedReferrer(purchaseLoader -&gt; {</span>
     *     <span style="color: #3F7E5E">//    purchaseLoader.loadPurchasePayment(...);</span>
     *     <span style="color: #3F7E5E">//});</span>
     *
     *     <span style="color: #3F7E5E">// you can also pull out foreign table and load its referrer</span>
     *     <span style="color: #3F7E5E">// (setupSelect of the foreign table should be called)</span>
     *     <span style="color: #3F7E5E">//memberLoader.pulloutMemberStatus().loadMemberLogin(...)</span>
     * });
     * <span style="color: #70226C">for</span> (Member member : <span style="color: #553000">memberList</span>) {
     *     List&lt;Purchase&gt; purchaseList = member.<span style="color: #CC4747">getPurchaseList()</span>;
     *     <span style="color: #70226C">for</span> (Purchase purchase : purchaseList) {
     *         ...
     *     }
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has order by FK before callback.
     * @param villagePlayerList The entity list of villagePlayer. (NotNull)
     * @param loaderLambda The callback to handle the referrer loader for actually loading referrer. (NotNull)
     */
    public void load(List<VillagePlayer> villagePlayerList, ReferrerLoaderHandler<LoaderOfVillagePlayer> loaderLambda) {
        xassLRArg(villagePlayerList, loaderLambda);
        loaderLambda.handle(new LoaderOfVillagePlayer().ready(villagePlayerList, _behaviorSelector));
    }

    /**
     * Load referrer for the entity by the referrer loader.
     * <pre>
     * Member <span style="color: #553000">member</span> = <span style="color: #0000C0">memberBhv</span>.selectEntityWithDeletedCheck(<span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> <span style="color: #553000">cb</span>.acceptPK(1));
     * <span style="color: #0000C0">memberBhv</span>.<span style="color: #CC4747">load</span>(<span style="color: #553000">member</span>, <span style="color: #553000">memberLoader</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">memberLoader</span>.<span style="color: #CC4747">loadPurchase</span>(<span style="color: #553000">purchaseCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *         <span style="color: #553000">purchaseCB</span>.setupSelect...
     *         <span style="color: #553000">purchaseCB</span>.query().set...
     *         <span style="color: #553000">purchaseCB</span>.query().addOrderBy...
     *     }); <span style="color: #3F7E5E">// you can also load nested referrer from here</span>
     *     <span style="color: #3F7E5E">//}).withNestedReferrer(purchaseLoader -&gt; {</span>
     *     <span style="color: #3F7E5E">//    purchaseLoader.loadPurchasePayment(...);</span>
     *     <span style="color: #3F7E5E">//});</span>
     *
     *     <span style="color: #3F7E5E">// you can also pull out foreign table and load its referrer</span>
     *     <span style="color: #3F7E5E">// (setupSelect of the foreign table should be called)</span>
     *     <span style="color: #3F7E5E">//memberLoader.pulloutMemberStatus().loadMemberLogin(...)</span>
     * });
     * List&lt;Purchase&gt; purchaseList = <span style="color: #553000">member</span>.<span style="color: #CC4747">getPurchaseList()</span>;
     * <span style="color: #70226C">for</span> (Purchase purchase : purchaseList) {
     *     ...
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has order by FK before callback.
     * @param villagePlayer The entity of villagePlayer. (NotNull)
     * @param loaderLambda The callback to handle the referrer loader for actually loading referrer. (NotNull)
     */
    public void load(VillagePlayer villagePlayer, ReferrerLoaderHandler<LoaderOfVillagePlayer> loaderLambda) {
        xassLRArg(villagePlayer, loaderLambda);
        loaderLambda.handle(new LoaderOfVillagePlayer().ready(xnewLRAryLs(villagePlayer), _behaviorSelector));
    }

    /**
     * Load referrer of abilityByTargetVillagePlayerIdList by the set-upper of referrer. <br>
     * ABILITY by TARGET_VILLAGE_PLAYER_ID, named 'abilityByTargetVillagePlayerIdList'.
     * <pre>
     * <span style="color: #0000C0">villagePlayerBhv</span>.<span style="color: #CC4747">loadAbilityByTargetVillagePlayerId</span>(<span style="color: #553000">villagePlayerList</span>, <span style="color: #553000">abilityCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">abilityCB</span>.setupSelect...
     *     <span style="color: #553000">abilityCB</span>.query().set...
     *     <span style="color: #553000">abilityCB</span>.query().addOrderBy...
     * }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     * <span style="color: #3F7E5E">//}).withNestedReferrer(referrerList -&gt; {</span>
     * <span style="color: #3F7E5E">//    ...</span>
     * <span style="color: #3F7E5E">//});</span>
     * <span style="color: #70226C">for</span> (VillagePlayer villagePlayer : <span style="color: #553000">villagePlayerList</span>) {
     *     ... = villagePlayer.<span style="color: #CC4747">getAbilityByTargetVillagePlayerIdList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setTargetVillagePlayerId_InScope(pkList);
     * cb.query().addOrderBy_TargetVillagePlayerId_Asc();
     * </pre>
     * @param villagePlayerList The entity list of villagePlayer. (NotNull)
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerListGateway<Ability> loadAbilityByTargetVillagePlayerId(List<VillagePlayer> villagePlayerList, ReferrerConditionSetupper<AbilityCB> refCBLambda) {
        xassLRArg(villagePlayerList, refCBLambda);
        return doLoadAbilityByTargetVillagePlayerId(villagePlayerList, new LoadReferrerOption<AbilityCB, Ability>().xinit(refCBLambda));
    }

    /**
     * Load referrer of abilityByTargetVillagePlayerIdList by the set-upper of referrer. <br>
     * ABILITY by TARGET_VILLAGE_PLAYER_ID, named 'abilityByTargetVillagePlayerIdList'.
     * <pre>
     * <span style="color: #0000C0">villagePlayerBhv</span>.<span style="color: #CC4747">loadAbilityByTargetVillagePlayerId</span>(<span style="color: #553000">villagePlayer</span>, <span style="color: #553000">abilityCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">abilityCB</span>.setupSelect...
     *     <span style="color: #553000">abilityCB</span>.query().set...
     *     <span style="color: #553000">abilityCB</span>.query().addOrderBy...
     * }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     * <span style="color: #3F7E5E">//}).withNestedReferrer(referrerList -&gt; {</span>
     * <span style="color: #3F7E5E">//    ...</span>
     * <span style="color: #3F7E5E">//});</span>
     * ... = <span style="color: #553000">villagePlayer</span>.<span style="color: #CC4747">getAbilityByTargetVillagePlayerIdList()</span>;
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setTargetVillagePlayerId_InScope(pkList);
     * cb.query().addOrderBy_TargetVillagePlayerId_Asc();
     * </pre>
     * @param villagePlayer The entity of villagePlayer. (NotNull)
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerListGateway<Ability> loadAbilityByTargetVillagePlayerId(VillagePlayer villagePlayer, ReferrerConditionSetupper<AbilityCB> refCBLambda) {
        xassLRArg(villagePlayer, refCBLambda);
        return doLoadAbilityByTargetVillagePlayerId(xnewLRLs(villagePlayer), new LoadReferrerOption<AbilityCB, Ability>().xinit(refCBLambda));
    }

    protected NestedReferrerListGateway<Ability> doLoadAbilityByTargetVillagePlayerId(List<VillagePlayer> villagePlayerList, LoadReferrerOption<AbilityCB, Ability> option) {
        return helpLoadReferrerInternally(villagePlayerList, option, "abilityByTargetVillagePlayerIdList");
    }

    /**
     * Load referrer of abilityByVillagePlayerIdList by the set-upper of referrer. <br>
     * ABILITY by VILLAGE_PLAYER_ID, named 'abilityByVillagePlayerIdList'.
     * <pre>
     * <span style="color: #0000C0">villagePlayerBhv</span>.<span style="color: #CC4747">loadAbilityByVillagePlayerId</span>(<span style="color: #553000">villagePlayerList</span>, <span style="color: #553000">abilityCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">abilityCB</span>.setupSelect...
     *     <span style="color: #553000">abilityCB</span>.query().set...
     *     <span style="color: #553000">abilityCB</span>.query().addOrderBy...
     * }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     * <span style="color: #3F7E5E">//}).withNestedReferrer(referrerList -&gt; {</span>
     * <span style="color: #3F7E5E">//    ...</span>
     * <span style="color: #3F7E5E">//});</span>
     * <span style="color: #70226C">for</span> (VillagePlayer villagePlayer : <span style="color: #553000">villagePlayerList</span>) {
     *     ... = villagePlayer.<span style="color: #CC4747">getAbilityByVillagePlayerIdList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setVillagePlayerId_InScope(pkList);
     * cb.query().addOrderBy_VillagePlayerId_Asc();
     * </pre>
     * @param villagePlayerList The entity list of villagePlayer. (NotNull)
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerListGateway<Ability> loadAbilityByVillagePlayerId(List<VillagePlayer> villagePlayerList, ReferrerConditionSetupper<AbilityCB> refCBLambda) {
        xassLRArg(villagePlayerList, refCBLambda);
        return doLoadAbilityByVillagePlayerId(villagePlayerList, new LoadReferrerOption<AbilityCB, Ability>().xinit(refCBLambda));
    }

    /**
     * Load referrer of abilityByVillagePlayerIdList by the set-upper of referrer. <br>
     * ABILITY by VILLAGE_PLAYER_ID, named 'abilityByVillagePlayerIdList'.
     * <pre>
     * <span style="color: #0000C0">villagePlayerBhv</span>.<span style="color: #CC4747">loadAbilityByVillagePlayerId</span>(<span style="color: #553000">villagePlayer</span>, <span style="color: #553000">abilityCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">abilityCB</span>.setupSelect...
     *     <span style="color: #553000">abilityCB</span>.query().set...
     *     <span style="color: #553000">abilityCB</span>.query().addOrderBy...
     * }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     * <span style="color: #3F7E5E">//}).withNestedReferrer(referrerList -&gt; {</span>
     * <span style="color: #3F7E5E">//    ...</span>
     * <span style="color: #3F7E5E">//});</span>
     * ... = <span style="color: #553000">villagePlayer</span>.<span style="color: #CC4747">getAbilityByVillagePlayerIdList()</span>;
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setVillagePlayerId_InScope(pkList);
     * cb.query().addOrderBy_VillagePlayerId_Asc();
     * </pre>
     * @param villagePlayer The entity of villagePlayer. (NotNull)
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerListGateway<Ability> loadAbilityByVillagePlayerId(VillagePlayer villagePlayer, ReferrerConditionSetupper<AbilityCB> refCBLambda) {
        xassLRArg(villagePlayer, refCBLambda);
        return doLoadAbilityByVillagePlayerId(xnewLRLs(villagePlayer), new LoadReferrerOption<AbilityCB, Ability>().xinit(refCBLambda));
    }

    protected NestedReferrerListGateway<Ability> doLoadAbilityByVillagePlayerId(List<VillagePlayer> villagePlayerList, LoadReferrerOption<AbilityCB, Ability> option) {
        return helpLoadReferrerInternally(villagePlayerList, option, "abilityByVillagePlayerIdList");
    }

    /**
     * Load referrer of comingOutList by the set-upper of referrer. <br>
     * COMING_OUT by VILLAGE_PLAYER_ID, named 'comingOutList'.
     * <pre>
     * <span style="color: #0000C0">villagePlayerBhv</span>.<span style="color: #CC4747">loadComingOut</span>(<span style="color: #553000">villagePlayerList</span>, <span style="color: #553000">outCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">outCB</span>.setupSelect...
     *     <span style="color: #553000">outCB</span>.query().set...
     *     <span style="color: #553000">outCB</span>.query().addOrderBy...
     * }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     * <span style="color: #3F7E5E">//}).withNestedReferrer(referrerList -&gt; {</span>
     * <span style="color: #3F7E5E">//    ...</span>
     * <span style="color: #3F7E5E">//});</span>
     * <span style="color: #70226C">for</span> (VillagePlayer villagePlayer : <span style="color: #553000">villagePlayerList</span>) {
     *     ... = villagePlayer.<span style="color: #CC4747">getComingOutList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setVillagePlayerId_InScope(pkList);
     * cb.query().addOrderBy_VillagePlayerId_Asc();
     * </pre>
     * @param villagePlayerList The entity list of villagePlayer. (NotNull)
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerListGateway<ComingOut> loadComingOut(List<VillagePlayer> villagePlayerList, ReferrerConditionSetupper<ComingOutCB> refCBLambda) {
        xassLRArg(villagePlayerList, refCBLambda);
        return doLoadComingOut(villagePlayerList, new LoadReferrerOption<ComingOutCB, ComingOut>().xinit(refCBLambda));
    }

    /**
     * Load referrer of comingOutList by the set-upper of referrer. <br>
     * COMING_OUT by VILLAGE_PLAYER_ID, named 'comingOutList'.
     * <pre>
     * <span style="color: #0000C0">villagePlayerBhv</span>.<span style="color: #CC4747">loadComingOut</span>(<span style="color: #553000">villagePlayer</span>, <span style="color: #553000">outCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">outCB</span>.setupSelect...
     *     <span style="color: #553000">outCB</span>.query().set...
     *     <span style="color: #553000">outCB</span>.query().addOrderBy...
     * }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     * <span style="color: #3F7E5E">//}).withNestedReferrer(referrerList -&gt; {</span>
     * <span style="color: #3F7E5E">//    ...</span>
     * <span style="color: #3F7E5E">//});</span>
     * ... = <span style="color: #553000">villagePlayer</span>.<span style="color: #CC4747">getComingOutList()</span>;
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setVillagePlayerId_InScope(pkList);
     * cb.query().addOrderBy_VillagePlayerId_Asc();
     * </pre>
     * @param villagePlayer The entity of villagePlayer. (NotNull)
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerListGateway<ComingOut> loadComingOut(VillagePlayer villagePlayer, ReferrerConditionSetupper<ComingOutCB> refCBLambda) {
        xassLRArg(villagePlayer, refCBLambda);
        return doLoadComingOut(xnewLRLs(villagePlayer), new LoadReferrerOption<ComingOutCB, ComingOut>().xinit(refCBLambda));
    }

    protected NestedReferrerListGateway<ComingOut> doLoadComingOut(List<VillagePlayer> villagePlayerList, LoadReferrerOption<ComingOutCB, ComingOut> option) {
        return helpLoadReferrerInternally(villagePlayerList, option, "comingOutList");
    }

    /**
     * Load referrer of commitList by the set-upper of referrer. <br>
     * COMMIT by VILLAGE_PLAYER_ID, named 'commitList'.
     * <pre>
     * <span style="color: #0000C0">villagePlayerBhv</span>.<span style="color: #CC4747">loadCommit</span>(<span style="color: #553000">villagePlayerList</span>, <span style="color: #553000">commitCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">commitCB</span>.setupSelect...
     *     <span style="color: #553000">commitCB</span>.query().set...
     *     <span style="color: #553000">commitCB</span>.query().addOrderBy...
     * }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     * <span style="color: #3F7E5E">//}).withNestedReferrer(referrerList -&gt; {</span>
     * <span style="color: #3F7E5E">//    ...</span>
     * <span style="color: #3F7E5E">//});</span>
     * <span style="color: #70226C">for</span> (VillagePlayer villagePlayer : <span style="color: #553000">villagePlayerList</span>) {
     *     ... = villagePlayer.<span style="color: #CC4747">getCommitList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setVillagePlayerId_InScope(pkList);
     * cb.query().addOrderBy_VillagePlayerId_Asc();
     * </pre>
     * @param villagePlayerList The entity list of villagePlayer. (NotNull)
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerListGateway<Commit> loadCommit(List<VillagePlayer> villagePlayerList, ReferrerConditionSetupper<CommitCB> refCBLambda) {
        xassLRArg(villagePlayerList, refCBLambda);
        return doLoadCommit(villagePlayerList, new LoadReferrerOption<CommitCB, Commit>().xinit(refCBLambda));
    }

    /**
     * Load referrer of commitList by the set-upper of referrer. <br>
     * COMMIT by VILLAGE_PLAYER_ID, named 'commitList'.
     * <pre>
     * <span style="color: #0000C0">villagePlayerBhv</span>.<span style="color: #CC4747">loadCommit</span>(<span style="color: #553000">villagePlayer</span>, <span style="color: #553000">commitCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">commitCB</span>.setupSelect...
     *     <span style="color: #553000">commitCB</span>.query().set...
     *     <span style="color: #553000">commitCB</span>.query().addOrderBy...
     * }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     * <span style="color: #3F7E5E">//}).withNestedReferrer(referrerList -&gt; {</span>
     * <span style="color: #3F7E5E">//    ...</span>
     * <span style="color: #3F7E5E">//});</span>
     * ... = <span style="color: #553000">villagePlayer</span>.<span style="color: #CC4747">getCommitList()</span>;
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setVillagePlayerId_InScope(pkList);
     * cb.query().addOrderBy_VillagePlayerId_Asc();
     * </pre>
     * @param villagePlayer The entity of villagePlayer. (NotNull)
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerListGateway<Commit> loadCommit(VillagePlayer villagePlayer, ReferrerConditionSetupper<CommitCB> refCBLambda) {
        xassLRArg(villagePlayer, refCBLambda);
        return doLoadCommit(xnewLRLs(villagePlayer), new LoadReferrerOption<CommitCB, Commit>().xinit(refCBLambda));
    }

    protected NestedReferrerListGateway<Commit> doLoadCommit(List<VillagePlayer> villagePlayerList, LoadReferrerOption<CommitCB, Commit> option) {
        return helpLoadReferrerInternally(villagePlayerList, option, "commitList");
    }

    /**
     * Load referrer of voteByTargetVillagePlayerIdList by the set-upper of referrer. <br>
     * VOTE by TARGET_VILLAGE_PLAYER_ID, named 'voteByTargetVillagePlayerIdList'.
     * <pre>
     * <span style="color: #0000C0">villagePlayerBhv</span>.<span style="color: #CC4747">loadVoteByTargetVillagePlayerId</span>(<span style="color: #553000">villagePlayerList</span>, <span style="color: #553000">voteCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">voteCB</span>.setupSelect...
     *     <span style="color: #553000">voteCB</span>.query().set...
     *     <span style="color: #553000">voteCB</span>.query().addOrderBy...
     * }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     * <span style="color: #3F7E5E">//}).withNestedReferrer(referrerList -&gt; {</span>
     * <span style="color: #3F7E5E">//    ...</span>
     * <span style="color: #3F7E5E">//});</span>
     * <span style="color: #70226C">for</span> (VillagePlayer villagePlayer : <span style="color: #553000">villagePlayerList</span>) {
     *     ... = villagePlayer.<span style="color: #CC4747">getVoteByTargetVillagePlayerIdList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setTargetVillagePlayerId_InScope(pkList);
     * cb.query().addOrderBy_TargetVillagePlayerId_Asc();
     * </pre>
     * @param villagePlayerList The entity list of villagePlayer. (NotNull)
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerListGateway<Vote> loadVoteByTargetVillagePlayerId(List<VillagePlayer> villagePlayerList, ReferrerConditionSetupper<VoteCB> refCBLambda) {
        xassLRArg(villagePlayerList, refCBLambda);
        return doLoadVoteByTargetVillagePlayerId(villagePlayerList, new LoadReferrerOption<VoteCB, Vote>().xinit(refCBLambda));
    }

    /**
     * Load referrer of voteByTargetVillagePlayerIdList by the set-upper of referrer. <br>
     * VOTE by TARGET_VILLAGE_PLAYER_ID, named 'voteByTargetVillagePlayerIdList'.
     * <pre>
     * <span style="color: #0000C0">villagePlayerBhv</span>.<span style="color: #CC4747">loadVoteByTargetVillagePlayerId</span>(<span style="color: #553000">villagePlayer</span>, <span style="color: #553000">voteCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">voteCB</span>.setupSelect...
     *     <span style="color: #553000">voteCB</span>.query().set...
     *     <span style="color: #553000">voteCB</span>.query().addOrderBy...
     * }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     * <span style="color: #3F7E5E">//}).withNestedReferrer(referrerList -&gt; {</span>
     * <span style="color: #3F7E5E">//    ...</span>
     * <span style="color: #3F7E5E">//});</span>
     * ... = <span style="color: #553000">villagePlayer</span>.<span style="color: #CC4747">getVoteByTargetVillagePlayerIdList()</span>;
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setTargetVillagePlayerId_InScope(pkList);
     * cb.query().addOrderBy_TargetVillagePlayerId_Asc();
     * </pre>
     * @param villagePlayer The entity of villagePlayer. (NotNull)
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerListGateway<Vote> loadVoteByTargetVillagePlayerId(VillagePlayer villagePlayer, ReferrerConditionSetupper<VoteCB> refCBLambda) {
        xassLRArg(villagePlayer, refCBLambda);
        return doLoadVoteByTargetVillagePlayerId(xnewLRLs(villagePlayer), new LoadReferrerOption<VoteCB, Vote>().xinit(refCBLambda));
    }

    protected NestedReferrerListGateway<Vote> doLoadVoteByTargetVillagePlayerId(List<VillagePlayer> villagePlayerList, LoadReferrerOption<VoteCB, Vote> option) {
        return helpLoadReferrerInternally(villagePlayerList, option, "voteByTargetVillagePlayerIdList");
    }

    /**
     * Load referrer of voteByVillagePlayerIdList by the set-upper of referrer. <br>
     * VOTE by VILLAGE_PLAYER_ID, named 'voteByVillagePlayerIdList'.
     * <pre>
     * <span style="color: #0000C0">villagePlayerBhv</span>.<span style="color: #CC4747">loadVoteByVillagePlayerId</span>(<span style="color: #553000">villagePlayerList</span>, <span style="color: #553000">voteCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">voteCB</span>.setupSelect...
     *     <span style="color: #553000">voteCB</span>.query().set...
     *     <span style="color: #553000">voteCB</span>.query().addOrderBy...
     * }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     * <span style="color: #3F7E5E">//}).withNestedReferrer(referrerList -&gt; {</span>
     * <span style="color: #3F7E5E">//    ...</span>
     * <span style="color: #3F7E5E">//});</span>
     * <span style="color: #70226C">for</span> (VillagePlayer villagePlayer : <span style="color: #553000">villagePlayerList</span>) {
     *     ... = villagePlayer.<span style="color: #CC4747">getVoteByVillagePlayerIdList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setVillagePlayerId_InScope(pkList);
     * cb.query().addOrderBy_VillagePlayerId_Asc();
     * </pre>
     * @param villagePlayerList The entity list of villagePlayer. (NotNull)
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerListGateway<Vote> loadVoteByVillagePlayerId(List<VillagePlayer> villagePlayerList, ReferrerConditionSetupper<VoteCB> refCBLambda) {
        xassLRArg(villagePlayerList, refCBLambda);
        return doLoadVoteByVillagePlayerId(villagePlayerList, new LoadReferrerOption<VoteCB, Vote>().xinit(refCBLambda));
    }

    /**
     * Load referrer of voteByVillagePlayerIdList by the set-upper of referrer. <br>
     * VOTE by VILLAGE_PLAYER_ID, named 'voteByVillagePlayerIdList'.
     * <pre>
     * <span style="color: #0000C0">villagePlayerBhv</span>.<span style="color: #CC4747">loadVoteByVillagePlayerId</span>(<span style="color: #553000">villagePlayer</span>, <span style="color: #553000">voteCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">voteCB</span>.setupSelect...
     *     <span style="color: #553000">voteCB</span>.query().set...
     *     <span style="color: #553000">voteCB</span>.query().addOrderBy...
     * }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     * <span style="color: #3F7E5E">//}).withNestedReferrer(referrerList -&gt; {</span>
     * <span style="color: #3F7E5E">//    ...</span>
     * <span style="color: #3F7E5E">//});</span>
     * ... = <span style="color: #553000">villagePlayer</span>.<span style="color: #CC4747">getVoteByVillagePlayerIdList()</span>;
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setVillagePlayerId_InScope(pkList);
     * cb.query().addOrderBy_VillagePlayerId_Asc();
     * </pre>
     * @param villagePlayer The entity of villagePlayer. (NotNull)
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerListGateway<Vote> loadVoteByVillagePlayerId(VillagePlayer villagePlayer, ReferrerConditionSetupper<VoteCB> refCBLambda) {
        xassLRArg(villagePlayer, refCBLambda);
        return doLoadVoteByVillagePlayerId(xnewLRLs(villagePlayer), new LoadReferrerOption<VoteCB, Vote>().xinit(refCBLambda));
    }

    protected NestedReferrerListGateway<Vote> doLoadVoteByVillagePlayerId(List<VillagePlayer> villagePlayerList, LoadReferrerOption<VoteCB, Vote> option) {
        return helpLoadReferrerInternally(villagePlayerList, option, "voteByVillagePlayerIdList");
    }

    // ===================================================================================
    //                                                                   Pull out Relation
    //                                                                   =================
    /**
     * Pull out the list of foreign table 'Chara'.
     * @param villagePlayerList The list of villagePlayer. (NotNull, EmptyAllowed)
     * @return The list of foreign table. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<Chara> pulloutChara(List<VillagePlayer> villagePlayerList)
    { return helpPulloutInternally(villagePlayerList, "chara"); }

    /**
     * Pull out the list of foreign table 'DeadReason'.
     * @param villagePlayerList The list of villagePlayer. (NotNull, EmptyAllowed)
     * @return The list of foreign table. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<DeadReason> pulloutDeadReason(List<VillagePlayer> villagePlayerList)
    { return helpPulloutInternally(villagePlayerList, "deadReason"); }

    /**
     * Pull out the list of foreign table 'VillageDay'.
     * @param villagePlayerList The list of villagePlayer. (NotNull, EmptyAllowed)
     * @return The list of foreign table. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<VillageDay> pulloutVillageDay(List<VillagePlayer> villagePlayerList)
    { return helpPulloutInternally(villagePlayerList, "villageDay"); }

    /**
     * Pull out the list of foreign table 'Player'.
     * @param villagePlayerList The list of villagePlayer. (NotNull, EmptyAllowed)
     * @return The list of foreign table. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<Player> pulloutPlayer(List<VillagePlayer> villagePlayerList)
    { return helpPulloutInternally(villagePlayerList, "player"); }

    /**
     * Pull out the list of foreign table 'Skill'.
     * @param villagePlayerList The list of villagePlayer. (NotNull, EmptyAllowed)
     * @return The list of foreign table. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<Skill> pulloutSkillByRequestSkillCode(List<VillagePlayer> villagePlayerList)
    { return helpPulloutInternally(villagePlayerList, "skillByRequestSkillCode"); }

    /**
     * Pull out the list of foreign table 'Skill'.
     * @param villagePlayerList The list of villagePlayer. (NotNull, EmptyAllowed)
     * @return The list of foreign table. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<Skill> pulloutSkillBySecondRequestSkillCode(List<VillagePlayer> villagePlayerList)
    { return helpPulloutInternally(villagePlayerList, "skillBySecondRequestSkillCode"); }

    /**
     * Pull out the list of foreign table 'Skill'.
     * @param villagePlayerList The list of villagePlayer. (NotNull, EmptyAllowed)
     * @return The list of foreign table. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<Skill> pulloutSkillBySkillCode(List<VillagePlayer> villagePlayerList)
    { return helpPulloutInternally(villagePlayerList, "skillBySkillCode"); }

    /**
     * Pull out the list of foreign table 'Village'.
     * @param villagePlayerList The list of villagePlayer. (NotNull, EmptyAllowed)
     * @return The list of foreign table. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<Village> pulloutVillage(List<VillagePlayer> villagePlayerList)
    { return helpPulloutInternally(villagePlayerList, "village"); }

    // ===================================================================================
    //                                                                      Extract Column
    //                                                                      ==============
    /**
     * Extract the value list of (single) primary key villagePlayerId.
     * @param villagePlayerList The list of villagePlayer. (NotNull, EmptyAllowed)
     * @return The list of the column value. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<Integer> extractVillagePlayerIdList(List<VillagePlayer> villagePlayerList)
    { return helpExtractListInternally(villagePlayerList, "villagePlayerId"); }

    // ===================================================================================
    //                                                                       Entity Update
    //                                                                       =============
    /**
     * Insert the entity modified-only. (DefaultConstraintsEnabled)
     * <pre>
     * VillagePlayer villagePlayer = <span style="color: #70226C">new</span> VillagePlayer();
     * <span style="color: #3F7E5E">// if auto-increment, you don't need to set the PK value</span>
     * villagePlayer.setFoo...(value);
     * villagePlayer.setBar...(value);
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//villagePlayer.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//villagePlayer.set...;</span>
     * <span style="color: #0000C0">villagePlayerBhv</span>.<span style="color: #CC4747">insert</span>(villagePlayer);
     * ... = villagePlayer.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * <p>While, when the entity is created by select, all columns are registered.</p>
     * @param villagePlayer The entity of insert. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @throws EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insert(VillagePlayer villagePlayer) {
        doInsert(villagePlayer, null);
    }

    /**
     * Update the entity modified-only. (ZeroUpdateException, NonExclusiveControl) <br>
     * By PK as default, and also you can update by unique keys using entity's uniqueOf().
     * <pre>
     * VillagePlayer villagePlayer = <span style="color: #70226C">new</span> VillagePlayer();
     * villagePlayer.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * villagePlayer.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//villagePlayer.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//villagePlayer.set...;</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of concurrency column is required</span>
     * villagePlayer.<span style="color: #CC4747">setVersionNo</span>(value);
     * <span style="color: #0000C0">villagePlayerBhv</span>.<span style="color: #CC4747">update</span>(villagePlayer);
     * </pre>
     * @param villagePlayer The entity of update. (NotNull, PrimaryKeyNotNull)
     * @throws EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @throws EntityDuplicatedException When the entity has been duplicated.
     * @throws EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void update(VillagePlayer villagePlayer) {
        doUpdate(villagePlayer, null);
    }

    /**
     * Insert or update the entity modified-only. (DefaultConstraintsEnabled, NonExclusiveControl) <br>
     * if (the entity has no PK) { insert() } else { update(), but no data, insert() } <br>
     * <p><span style="color: #994747; font-size: 120%">Also you can update by unique keys using entity's uniqueOf().</span></p>
     * @param villagePlayer The entity of insert or update. (NotNull, ...depends on insert or update)
     * @throws EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @throws EntityDuplicatedException When the entity has been duplicated.
     * @throws EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insertOrUpdate(VillagePlayer villagePlayer) {
        doInsertOrUpdate(villagePlayer, null, null);
    }

    /**
     * Delete the entity. (ZeroUpdateException, NonExclusiveControl) <br>
     * By PK as default, and also you can delete by unique keys using entity's uniqueOf().
     * <pre>
     * VillagePlayer villagePlayer = <span style="color: #70226C">new</span> VillagePlayer();
     * villagePlayer.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of concurrency column is required</span>
     * villagePlayer.<span style="color: #CC4747">setVersionNo</span>(value);
     * <span style="color: #70226C">try</span> {
     *     <span style="color: #0000C0">villagePlayerBhv</span>.<span style="color: #CC4747">delete</span>(villagePlayer);
     * } <span style="color: #70226C">catch</span> (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param villagePlayer The entity of delete. (NotNull, PrimaryKeyNotNull)
     * @throws EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @throws EntityDuplicatedException When the entity has been duplicated.
     */
    public void delete(VillagePlayer villagePlayer) {
        doDelete(villagePlayer, null);
    }

    // ===================================================================================
    //                                                                        Batch Update
    //                                                                        ============
    /**
     * Batch-insert the entity list modified-only of same-set columns. (DefaultConstraintsEnabled) <br>
     * This method uses executeBatch() of java.sql.PreparedStatement. <br>
     * <p><span style="color: #CC4747; font-size: 120%">The columns of least common multiple are registered like this:</span></p>
     * <pre>
     * <span style="color: #70226C">for</span> (... : ...) {
     *     VillagePlayer villagePlayer = <span style="color: #70226C">new</span> VillagePlayer();
     *     villagePlayer.setFooName("foo");
     *     <span style="color: #70226C">if</span> (...) {
     *         villagePlayer.setFooPrice(123);
     *     }
     *     <span style="color: #3F7E5E">// FOO_NAME and FOO_PRICE (and record meta columns) are registered</span>
     *     <span style="color: #3F7E5E">// FOO_PRICE not-called in any entities are registered as null without default value</span>
     *     <span style="color: #3F7E5E">// columns not-called in all entities are registered as null or default value</span>
     *     villagePlayerList.add(villagePlayer);
     * }
     * <span style="color: #0000C0">villagePlayerBhv</span>.<span style="color: #CC4747">batchInsert</span>(villagePlayerList);
     * </pre>
     * <p>While, when the entities are created by select, all columns are registered.</p>
     * <p>And if the table has an identity, entities after the process don't have incremented values.
     * (When you use the (normal) insert(), you can get the incremented value from your entity)</p>
     * @param villagePlayerList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNullAllowed: when auto-increment)
     * @return The array of inserted count. (NotNull, EmptyAllowed)
     */
    public int[] batchInsert(List<VillagePlayer> villagePlayerList) {
        return doBatchInsert(villagePlayerList, null);
    }

    /**
     * Batch-update the entity list modified-only of same-set columns. (NonExclusiveControl) <br>
     * This method uses executeBatch() of java.sql.PreparedStatement. <br>
     * <span style="color: #CC4747; font-size: 120%">You should specify same-set columns to all entities like this:</span>
     * <pre>
     * for (... : ...) {
     *     VillagePlayer villagePlayer = <span style="color: #70226C">new</span> VillagePlayer();
     *     villagePlayer.setFooName("foo");
     *     <span style="color: #70226C">if</span> (...) {
     *         villagePlayer.setFooPrice(123);
     *     } <span style="color: #70226C">else</span> {
     *         villagePlayer.setFooPrice(null); <span style="color: #3F7E5E">// updated as null</span>
     *         <span style="color: #3F7E5E">//villagePlayer.setFooDate(...); // *not allowed, fragmented</span>
     *     }
     *     <span style="color: #3F7E5E">// FOO_NAME and FOO_PRICE (and record meta columns) are updated</span>
     *     <span style="color: #3F7E5E">// (others are not updated: their values are kept)</span>
     *     villagePlayerList.add(villagePlayer);
     * }
     * <span style="color: #0000C0">villagePlayerBhv</span>.<span style="color: #CC4747">batchUpdate</span>(villagePlayerList);
     * </pre>
     * @param villagePlayerList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @throws EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchUpdate(List<VillagePlayer> villagePlayerList) {
        return doBatchUpdate(villagePlayerList, null);
    }

    /**
     * Batch-delete the entity list. (NonExclusiveControl) <br>
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * @param villagePlayerList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     * @throws EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchDelete(List<VillagePlayer> villagePlayerList) {
        return doBatchDelete(villagePlayerList, null);
    }

    // ===================================================================================
    //                                                                        Query Update
    //                                                                        ============
    /**
     * Insert the several entities by query (modified-only for fixed value).
     * <pre>
     * <span style="color: #0000C0">villagePlayerBhv</span>.<span style="color: #CC4747">queryInsert</span>(new QueryInsertSetupper&lt;VillagePlayer, VillagePlayerCB&gt;() {
     *     public ConditionBean setup(VillagePlayer entity, VillagePlayerCB intoCB) {
     *         FooCB cb = FooCB();
     *         cb.setupSelect_Bar();
     *
     *         <span style="color: #3F7E5E">// mapping</span>
     *         intoCB.specify().columnMyName().mappedFrom(cb.specify().columnFooName());
     *         intoCB.specify().columnMyCount().mappedFrom(cb.specify().columnFooCount());
     *         intoCB.specify().columnMyDate().mappedFrom(cb.specify().specifyBar().columnBarDate());
     *         entity.setMyFixedValue("foo"); <span style="color: #3F7E5E">// fixed value</span>
     *         <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     *         <span style="color: #3F7E5E">//entity.setRegisterUser(value);</span>
     *         <span style="color: #3F7E5E">//entity.set...;</span>
     *         <span style="color: #3F7E5E">// you don't need to set a value of concurrency column</span>
     *         <span style="color: #3F7E5E">//entity.setVersionNo(value);</span>
     *
     *         return cb;
     *     }
     * });
     * </pre>
     * @param manyArgLambda The callback to set up query-insert. (NotNull)
     * @return The inserted count.
     */
    public int queryInsert(QueryInsertSetupper<VillagePlayer, VillagePlayerCB> manyArgLambda) {
        return doQueryInsert(manyArgLambda, null);
    }

    /**
     * Update the several entities by query non-strictly modified-only. (NonExclusiveControl)
     * <pre>
     * VillagePlayer villagePlayer = <span style="color: #70226C">new</span> VillagePlayer();
     * <span style="color: #3F7E5E">// you don't need to set PK value</span>
     * <span style="color: #3F7E5E">//villagePlayer.setPK...(value);</span>
     * villagePlayer.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//villagePlayer.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//villagePlayer.set...;</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of concurrency column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//villagePlayer.setVersionNo(value);</span>
     * <span style="color: #0000C0">villagePlayerBhv</span>.<span style="color: #CC4747">queryUpdate</span>(villagePlayer, <span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">cb</span>.query().setFoo...
     * });
     * </pre>
     * @param villagePlayer The entity that contains update values. (NotNull, PrimaryKeyNullAllowed)
     * @param cbLambda The callback for condition-bean of VillagePlayer. (NotNull)
     * @return The updated count.
     * @throws NonQueryUpdateNotAllowedException When the query has no condition.
     */
    public int queryUpdate(VillagePlayer villagePlayer, CBCall<VillagePlayerCB> cbLambda) {
        return doQueryUpdate(villagePlayer, createCB(cbLambda), null);
    }

    /**
     * Delete the several entities by query. (NonExclusiveControl)
     * <pre>
     * <span style="color: #0000C0">villagePlayerBhv</span>.<span style="color: #CC4747">queryDelete</span>(villagePlayer, <span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">cb</span>.query().setFoo...
     * });
     * </pre>
     * @param cbLambda The callback for condition-bean of VillagePlayer. (NotNull)
     * @return The deleted count.
     * @throws NonQueryDeleteNotAllowedException When the query has no condition.
     */
    public int queryDelete(CBCall<VillagePlayerCB> cbLambda) {
        return doQueryDelete(createCB(cbLambda), null);
    }

    // ===================================================================================
    //                                                                      Varying Update
    //                                                                      ==============
    // -----------------------------------------------------
    //                                         Entity Update
    //                                         -------------
    /**
     * Insert the entity with varying requests. <br>
     * For example, disableCommonColumnAutoSetup(), disablePrimaryKeyIdentity(). <br>
     * Other specifications are same as insert(entity).
     * <pre>
     * VillagePlayer villagePlayer = <span style="color: #70226C">new</span> VillagePlayer();
     * <span style="color: #3F7E5E">// if auto-increment, you don't need to set the PK value</span>
     * villagePlayer.setFoo...(value);
     * villagePlayer.setBar...(value);
     * <span style="color: #0000C0">villagePlayerBhv</span>.<span style="color: #CC4747">varyingInsert</span>(villagePlayer, <span style="color: #553000">op</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #3F7E5E">// you can insert by your values for common columns</span>
     *     <span style="color: #553000">op</span>.disableCommonColumnAutoSetup();
     * });
     * ... = villagePlayer.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * @param villagePlayer The entity of insert. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @param opLambda The callback for option of insert for varying requests. (NotNull)
     * @throws EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsert(VillagePlayer villagePlayer, WritableOptionCall<VillagePlayerCB, InsertOption<VillagePlayerCB>> opLambda) {
        doInsert(villagePlayer, createInsertOption(opLambda));
    }

    /**
     * Update the entity with varying requests modified-only. (ZeroUpdateException, NonExclusiveControl) <br>
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification), disableCommonColumnAutoSetup(). <br>
     * Other specifications are same as update(entity).
     * <pre>
     * VillagePlayer villagePlayer = <span style="color: #70226C">new</span> VillagePlayer();
     * villagePlayer.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * villagePlayer.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of concurrency column is required</span>
     * villagePlayer.<span style="color: #CC4747">setVersionNo</span>(value);
     * <span style="color: #3F7E5E">// you can update by self calculation values</span>
     * <span style="color: #0000C0">villagePlayerBhv</span>.<span style="color: #CC4747">varyingUpdate</span>(villagePlayer, <span style="color: #553000">op</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">op</span>.self(<span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *         <span style="color: #553000">cb</span>.specify().<span style="color: #CC4747">columnXxxCount()</span>;
     *     }).plus(1); <span style="color: #3F7E5E">// XXX_COUNT = XXX_COUNT + 1</span>
     * });
     * </pre>
     * @param villagePlayer The entity of update. (NotNull, PrimaryKeyNotNull)
     * @param opLambda The callback for option of update for varying requests. (NotNull)
     * @throws EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @throws EntityDuplicatedException When the entity has been duplicated.
     * @throws EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingUpdate(VillagePlayer villagePlayer, WritableOptionCall<VillagePlayerCB, UpdateOption<VillagePlayerCB>> opLambda) {
        doUpdate(villagePlayer, createUpdateOption(opLambda));
    }

    /**
     * Insert or update the entity with varying requests. (ExclusiveControl: when update) <br>
     * Other specifications are same as insertOrUpdate(entity).
     * @param villagePlayer The entity of insert or update. (NotNull)
     * @param insertOpLambda The callback for option of insert for varying requests. (NotNull)
     * @param updateOpLambda The callback for option of update for varying requests. (NotNull)
     * @throws EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @throws EntityDuplicatedException When the entity has been duplicated.
     * @throws EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsertOrUpdate(VillagePlayer villagePlayer, WritableOptionCall<VillagePlayerCB, InsertOption<VillagePlayerCB>> insertOpLambda, WritableOptionCall<VillagePlayerCB, UpdateOption<VillagePlayerCB>> updateOpLambda) {
        doInsertOrUpdate(villagePlayer, createInsertOption(insertOpLambda), createUpdateOption(updateOpLambda));
    }

    /**
     * Delete the entity with varying requests. (ZeroUpdateException, NonExclusiveControl) <br>
     * Now a valid option does not exist. <br>
     * Other specifications are same as delete(entity).
     * @param villagePlayer The entity of delete. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnNotNull)
     * @param opLambda The callback for option of delete for varying requests. (NotNull)
     * @throws EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @throws EntityDuplicatedException When the entity has been duplicated.
     */
    public void varyingDelete(VillagePlayer villagePlayer, WritableOptionCall<VillagePlayerCB, DeleteOption<VillagePlayerCB>> opLambda) {
        doDelete(villagePlayer, createDeleteOption(opLambda));
    }

    // -----------------------------------------------------
    //                                          Batch Update
    //                                          ------------
    /**
     * Batch-insert the list with varying requests. <br>
     * For example, disableCommonColumnAutoSetup()
     * , disablePrimaryKeyIdentity(), limitBatchInsertLogging(). <br>
     * Other specifications are same as batchInsert(entityList).
     * @param villagePlayerList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param opLambda The callback for option of insert for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchInsert(List<VillagePlayer> villagePlayerList, WritableOptionCall<VillagePlayerCB, InsertOption<VillagePlayerCB>> opLambda) {
        return doBatchInsert(villagePlayerList, createInsertOption(opLambda));
    }

    /**
     * Batch-update the list with varying requests. <br>
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification)
     * , disableCommonColumnAutoSetup(), limitBatchUpdateLogging(). <br>
     * Other specifications are same as batchUpdate(entityList).
     * @param villagePlayerList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param opLambda The callback for option of update for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchUpdate(List<VillagePlayer> villagePlayerList, WritableOptionCall<VillagePlayerCB, UpdateOption<VillagePlayerCB>> opLambda) {
        return doBatchUpdate(villagePlayerList, createUpdateOption(opLambda));
    }

    /**
     * Batch-delete the list with varying requests. <br>
     * For example, limitBatchDeleteLogging(). <br>
     * Other specifications are same as batchDelete(entityList).
     * @param villagePlayerList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param opLambda The callback for option of delete for varying requests. (NotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchDelete(List<VillagePlayer> villagePlayerList, WritableOptionCall<VillagePlayerCB, DeleteOption<VillagePlayerCB>> opLambda) {
        return doBatchDelete(villagePlayerList, createDeleteOption(opLambda));
    }

    // -----------------------------------------------------
    //                                          Query Update
    //                                          ------------
    /**
     * Insert the several entities by query with varying requests (modified-only for fixed value). <br>
     * For example, disableCommonColumnAutoSetup(), disablePrimaryKeyIdentity(). <br>
     * Other specifications are same as queryInsert(entity, setupper).
     * @param manyArgLambda The set-upper of query-insert. (NotNull)
     * @param opLambda The callback for option of insert for varying requests. (NotNull)
     * @return The inserted count.
     */
    public int varyingQueryInsert(QueryInsertSetupper<VillagePlayer, VillagePlayerCB> manyArgLambda, WritableOptionCall<VillagePlayerCB, InsertOption<VillagePlayerCB>> opLambda) {
        return doQueryInsert(manyArgLambda, createInsertOption(opLambda));
    }

    /**
     * Update the several entities by query with varying requests non-strictly modified-only. {NonExclusiveControl} <br>
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification)
     * , disableCommonColumnAutoSetup(), allowNonQueryUpdate(). <br>
     * Other specifications are same as queryUpdate(entity, cb).
     * <pre>
     * <span style="color: #3F7E5E">// ex) you can update by self calculation values</span>
     * VillagePlayer villagePlayer = <span style="color: #70226C">new</span> VillagePlayer();
     * <span style="color: #3F7E5E">// you don't need to set PK value</span>
     * <span style="color: #3F7E5E">//villagePlayer.setPK...(value);</span>
     * villagePlayer.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of concurrency column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//villagePlayer.setVersionNo(value);</span>
     * <span style="color: #0000C0">villagePlayerBhv</span>.<span style="color: #CC4747">varyingQueryUpdate</span>(villagePlayer, <span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">cb</span>.query().setFoo...
     * }, <span style="color: #553000">op</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">op</span>.self(<span style="color: #553000">colCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *         <span style="color: #553000">colCB</span>.specify().<span style="color: #CC4747">columnFooCount()</span>;
     *     }).plus(1); <span style="color: #3F7E5E">// FOO_COUNT = FOO_COUNT + 1</span>
     * });
     * </pre>
     * @param villagePlayer The entity that contains update values. (NotNull) {PrimaryKeyNotRequired}
     * @param cbLambda The callback for condition-bean of VillagePlayer. (NotNull)
     * @param opLambda The callback for option of update for varying requests. (NotNull)
     * @return The updated count.
     * @throws NonQueryUpdateNotAllowedException When the query has no condition (if not allowed).
     */
    public int varyingQueryUpdate(VillagePlayer villagePlayer, CBCall<VillagePlayerCB> cbLambda, WritableOptionCall<VillagePlayerCB, UpdateOption<VillagePlayerCB>> opLambda) {
        return doQueryUpdate(villagePlayer, createCB(cbLambda), createUpdateOption(opLambda));
    }

    /**
     * Delete the several entities by query with varying requests non-strictly. <br>
     * For example, allowNonQueryDelete(). <br>
     * Other specifications are same as queryDelete(cb).
     * <pre>
     * <span style="color: #0000C0">villagePlayerBhv</span>.<span style="color: #CC4747">queryDelete</span>(villagePlayer, <span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">cb</span>.query().setFoo...
     * }, <span style="color: #553000">op</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">op</span>...
     * });
     * </pre>
     * @param cbLambda The callback for condition-bean of VillagePlayer. (NotNull)
     * @param opLambda The callback for option of delete for varying requests. (NotNull)
     * @return The deleted count.
     * @throws NonQueryDeleteNotAllowedException When the query has no condition (if not allowed).
     */
    public int varyingQueryDelete(CBCall<VillagePlayerCB> cbLambda, WritableOptionCall<VillagePlayerCB, DeleteOption<VillagePlayerCB>> opLambda) {
        return doQueryDelete(createCB(cbLambda), createDeleteOption(opLambda));
    }

    // ===================================================================================
    //                                                                          OutsideSql
    //                                                                          ==========
    /**
     * Prepare the all facade executor of outside-SQL to execute it.
     * <pre>
     * <span style="color: #3F7E5E">// main style</span>
     * villagePlayerBhv.outideSql().selectEntity(pmb); <span style="color: #3F7E5E">// optional</span>
     * villagePlayerBhv.outideSql().selectList(pmb); <span style="color: #3F7E5E">// ListResultBean</span>
     * villagePlayerBhv.outideSql().selectPage(pmb); <span style="color: #3F7E5E">// PagingResultBean</span>
     * villagePlayerBhv.outideSql().selectPagedListOnly(pmb); <span style="color: #3F7E5E">// ListResultBean</span>
     * villagePlayerBhv.outideSql().selectCursor(pmb, handler); <span style="color: #3F7E5E">// (by handler)</span>
     * villagePlayerBhv.outideSql().execute(pmb); <span style="color: #3F7E5E">// int (updated count)</span>
     * villagePlayerBhv.outideSql().call(pmb); <span style="color: #3F7E5E">// void (pmb has OUT parameters)</span>
     *
     * <span style="color: #3F7E5E">// traditional style</span>
     * villagePlayerBhv.outideSql().traditionalStyle().selectEntity(path, pmb, entityType);
     * villagePlayerBhv.outideSql().traditionalStyle().selectList(path, pmb, entityType);
     * villagePlayerBhv.outideSql().traditionalStyle().selectPage(path, pmb, entityType);
     * villagePlayerBhv.outideSql().traditionalStyle().selectPagedListOnly(path, pmb, entityType);
     * villagePlayerBhv.outideSql().traditionalStyle().selectCursor(path, pmb, handler);
     * villagePlayerBhv.outideSql().traditionalStyle().execute(path, pmb);
     *
     * <span style="color: #3F7E5E">// options</span>
     * villagePlayerBhv.outideSql().removeBlockComment().selectList()
     * villagePlayerBhv.outideSql().removeLineComment().selectList()
     * villagePlayerBhv.outideSql().formatSql().selectList()
     * </pre>
     * <p>The invoker of behavior command should be not null when you call this method.</p>
     * @return The new-created all facade executor of outside-SQL. (NotNull)
     */
    public OutsideSqlAllFacadeExecutor<VillagePlayerBhv> outsideSql() {
        return doOutsideSql();
    }

    // ===================================================================================
    //                                                                         Type Helper
    //                                                                         ===========
    protected Class<? extends VillagePlayer> typeOfSelectedEntity() { return VillagePlayer.class; }
    protected Class<VillagePlayer> typeOfHandlingEntity() { return VillagePlayer.class; }
    protected Class<VillagePlayerCB> typeOfHandlingConditionBean() { return VillagePlayerCB.class; }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    @Override
    @javax.annotation.Resource(name="behaviorCommandInvoker")
    public void setBehaviorCommandInvoker(BehaviorCommandInvoker behaviorCommandInvoker) {
        super.setBehaviorCommandInvoker(behaviorCommandInvoker);
    }

    @Override
    @javax.annotation.Resource(name="behaviorSelector")
    public void setBehaviorSelector(BehaviorSelector behaviorSelector) {
        super.setBehaviorSelector(behaviorSelector);
    }

    @Override
    @javax.annotation.Resource(name="commonColumnAutoSetupper")
    public void setCommonColumnAutoSetupper(CommonColumnAutoSetupper commonColumnAutoSetupper) {
        super.setCommonColumnAutoSetupper(commonColumnAutoSetupper);
    }
}
