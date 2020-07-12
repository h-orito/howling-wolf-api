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
 * The behavior of VILLAGE_DAY as TABLE. <br>
 * <pre>
 * [primary key]
 *     VILLAGE_DAY_ID
 *
 * [column]
 *     VILLAGE_DAY_ID, VILLAGE_ID, DAY, NOONNIGHT_CODE, DAYCHANGE_DATETIME, REGISTER_DATETIME, REGISTER_TRACE, UPDATE_DATETIME, UPDATE_TRACE
 *
 * [sequence]
 *     
 *
 * [identity]
 *     VILLAGE_DAY_ID
 *
 * [version-no]
 *     
 *
 * [foreign table]
 *     NOONNIGHT, VILLAGE
 *
 * [referrer table]
 *     ABILITY, COMMIT, VILLAGE_PLAYER, VOTE
 *
 * [foreign property]
 *     noonnight, village
 *
 * [referrer property]
 *     abilityList, commitList, villagePlayerList, voteList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsVillageDayBhv extends AbstractBehaviorWritable<VillageDay, VillageDayCB> {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /*df:beginQueryPath*/
    /*df:endQueryPath*/

    // ===================================================================================
    //                                                                             DB Meta
    //                                                                             =======
    /** {@inheritDoc} */
    public VillageDayDbm asDBMeta() { return VillageDayDbm.getInstance(); }
    /** {@inheritDoc} */
    public String asTableDbName() { return "village_day"; }

    // ===================================================================================
    //                                                                        New Instance
    //                                                                        ============
    /** {@inheritDoc} */
    public VillageDayCB newConditionBean() { return new VillageDayCB(); }

    // ===================================================================================
    //                                                                        Count Select
    //                                                                        ============
    /**
     * Select the count of uniquely-selected records by the condition-bean. {IgnorePagingCondition, IgnoreSpecifyColumn}<br>
     * SpecifyColumn is ignored but you can use it only to remove text type column for union's distinct.
     * <pre>
     * <span style="color: #70226C">int</span> count = <span style="color: #0000C0">villageDayBhv</span>.<span style="color: #CC4747">selectCount</span>(<span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">cb</span>.query().set...
     * });
     * </pre>
     * @param cbLambda The callback for condition-bean of VillageDay. (NotNull)
     * @return The count for the condition. (NotMinus)
     */
    public int selectCount(CBCall<VillageDayCB> cbLambda) {
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
     * <span style="color: #0000C0">villageDayBhv</span>.<span style="color: #CC4747">selectEntity</span>(<span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">cb</span>.query().set...
     * }).<span style="color: #CC4747">alwaysPresent</span>(<span style="color: #553000">villageDay</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #3F7E5E">// called if present, or exception</span>
     *     ... = <span style="color: #553000">villageDay</span>.get...
     * });
     *
     * <span style="color: #3F7E5E">// if it might be no data, ...</span>
     * <span style="color: #0000C0">villageDayBhv</span>.<span style="color: #CC4747">selectEntity</span>(<span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">cb</span>.query().set...
     * }).<span style="color: #CC4747">ifPresent</span>(<span style="color: #553000">villageDay</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #3F7E5E">// called if present</span>
     *     ... = <span style="color: #553000">villageDay</span>.get...
     * }).<span style="color: #994747">orElse</span>(() <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #3F7E5E">// called if not present</span>
     * });
     * </pre>
     * @param cbLambda The callback for condition-bean of VillageDay. (NotNull)
     * @return The optional entity selected by the condition. (NotNull: if no data, empty entity)
     * @throws EntityAlreadyDeletedException When get(), required() of return value is called and the value is null, which means entity has already been deleted (not found).
     * @throws EntityDuplicatedException When the entity has been duplicated.
     * @throws SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public OptionalEntity<VillageDay> selectEntity(CBCall<VillageDayCB> cbLambda) {
        return facadeSelectEntity(createCB(cbLambda));
    }

    protected OptionalEntity<VillageDay> facadeSelectEntity(VillageDayCB cb) {
        return doSelectOptionalEntity(cb, typeOfSelectedEntity());
    }

    protected <ENTITY extends VillageDay> OptionalEntity<ENTITY> doSelectOptionalEntity(VillageDayCB cb, Class<? extends ENTITY> tp) {
        return createOptionalEntity(doSelectEntity(cb, tp), cb);
    }

    protected Entity doReadEntity(ConditionBean cb) { return facadeSelectEntity(downcast(cb)).orElse(null); }

    /**
     * Select the entity by the condition-bean with deleted check. <br>
     * <span style="color: #AD4747; font-size: 120%">If the data is always present as your business rule, this method is good.</span>
     * <pre>
     * VillageDay <span style="color: #553000">villageDay</span> = <span style="color: #0000C0">villageDayBhv</span>.<span style="color: #CC4747">selectEntityWithDeletedCheck</span>(cb <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> cb.acceptPK(1));
     * ... = <span style="color: #553000">villageDay</span>.get...(); <span style="color: #3F7E5E">// the entity always be not null</span>
     * </pre>
     * @param cbLambda The callback for condition-bean of VillageDay. (NotNull)
     * @return The entity selected by the condition. (NotNull: if no data, throws exception)
     * @throws EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @throws EntityDuplicatedException When the entity has been duplicated.
     * @throws SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public VillageDay selectEntityWithDeletedCheck(CBCall<VillageDayCB> cbLambda) {
        return facadeSelectEntityWithDeletedCheck(createCB(cbLambda));
    }

    /**
     * Select the entity by the primary-key value.
     * @param villageDayId : PK, ID, NotNull, INT UNSIGNED(10). (NotNull)
     * @return The optional entity selected by the PK. (NotNull: if no data, empty entity)
     * @throws EntityAlreadyDeletedException When get(), required() of return value is called and the value is null, which means entity has already been deleted (not found).
     * @throws EntityDuplicatedException When the entity has been duplicated.
     * @throws SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public OptionalEntity<VillageDay> selectByPK(Integer villageDayId) {
        return facadeSelectByPK(villageDayId);
    }

    protected OptionalEntity<VillageDay> facadeSelectByPK(Integer villageDayId) {
        return doSelectOptionalByPK(villageDayId, typeOfSelectedEntity());
    }

    protected <ENTITY extends VillageDay> ENTITY doSelectByPK(Integer villageDayId, Class<? extends ENTITY> tp) {
        return doSelectEntity(xprepareCBAsPK(villageDayId), tp);
    }

    protected <ENTITY extends VillageDay> OptionalEntity<ENTITY> doSelectOptionalByPK(Integer villageDayId, Class<? extends ENTITY> tp) {
        return createOptionalEntity(doSelectByPK(villageDayId, tp), villageDayId);
    }

    protected VillageDayCB xprepareCBAsPK(Integer villageDayId) {
        assertObjectNotNull("villageDayId", villageDayId);
        return newConditionBean().acceptPK(villageDayId);
    }

    // ===================================================================================
    //                                                                         List Select
    //                                                                         ===========
    /**
     * Select the list as result bean.
     * <pre>
     * ListResultBean&lt;VillageDay&gt; <span style="color: #553000">villageDayList</span> = <span style="color: #0000C0">villageDayBhv</span>.<span style="color: #CC4747">selectList</span>(<span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">cb</span>.query().set...;
     *     <span style="color: #553000">cb</span>.query().addOrderBy...;
     * });
     * <span style="color: #70226C">for</span> (VillageDay <span style="color: #553000">villageDay</span> : <span style="color: #553000">villageDayList</span>) {
     *     ... = <span style="color: #553000">villageDay</span>.get...;
     * }
     * </pre>
     * @param cbLambda The callback for condition-bean of VillageDay. (NotNull)
     * @return The result bean of selected list. (NotNull: if no data, returns empty list)
     * @throws DangerousResultSizeException When the result size is over the specified safety size.
     */
    public ListResultBean<VillageDay> selectList(CBCall<VillageDayCB> cbLambda) {
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
     * PagingResultBean&lt;VillageDay&gt; <span style="color: #553000">page</span> = <span style="color: #0000C0">villageDayBhv</span>.<span style="color: #CC4747">selectPage</span>(<span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">cb</span>.query().set...
     *     <span style="color: #553000">cb</span>.query().addOrderBy...
     *     <span style="color: #553000">cb</span>.<span style="color: #CC4747">paging</span>(20, 3); <span style="color: #3F7E5E">// 20 records per a page and current page number is 3</span>
     * });
     * <span style="color: #70226C">int</span> allRecordCount = <span style="color: #553000">page</span>.getAllRecordCount();
     * <span style="color: #70226C">int</span> allPageCount = <span style="color: #553000">page</span>.getAllPageCount();
     * <span style="color: #70226C">boolean</span> isExistPrePage = <span style="color: #553000">page</span>.isExistPrePage();
     * <span style="color: #70226C">boolean</span> isExistNextPage = <span style="color: #553000">page</span>.isExistNextPage();
     * ...
     * <span style="color: #70226C">for</span> (VillageDay villageDay : <span style="color: #553000">page</span>) {
     *     ... = villageDay.get...;
     * }
     * </pre>
     * @param cbLambda The callback for condition-bean of VillageDay. (NotNull)
     * @return The result bean of selected page. (NotNull: if no data, returns bean as empty list)
     * @throws DangerousResultSizeException When the result size is over the specified safety size.
     */
    public PagingResultBean<VillageDay> selectPage(CBCall<VillageDayCB> cbLambda) {
        return facadeSelectPage(createCB(cbLambda));
    }

    // ===================================================================================
    //                                                                       Cursor Select
    //                                                                       =============
    /**
     * Select the cursor by the condition-bean.
     * <pre>
     * <span style="color: #0000C0">villageDayBhv</span>.<span style="color: #CC4747">selectCursor</span>(<span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">cb</span>.query().set...
     * }, <span style="color: #553000">member</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     ... = <span style="color: #553000">member</span>.getMemberName();
     * });
     * </pre>
     * @param cbLambda The callback for condition-bean of VillageDay. (NotNull)
     * @param entityLambda The handler of entity row of VillageDay. (NotNull)
     */
    public void selectCursor(CBCall<VillageDayCB> cbLambda, EntityRowHandler<VillageDay> entityLambda) {
        facadeSelectCursor(createCB(cbLambda), entityLambda);
    }

    // ===================================================================================
    //                                                                       Scalar Select
    //                                                                       =============
    /**
     * Select the scalar value derived by a function from uniquely-selected records. <br>
     * You should call a function method after this method called like as follows:
     * <pre>
     * <span style="color: #0000C0">villageDayBhv</span>.<span style="color: #CC4747">selectScalar</span>(Date.class).max(<span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">cb</span>.specify().<span style="color: #CC4747">column...</span>; <span style="color: #3F7E5E">// required for the function</span>
     *     <span style="color: #553000">cb</span>.query().set...
     * });
     * </pre>
     * @param <RESULT> The type of result.
     * @param resultType The type of result. (NotNull)
     * @return The scalar function object to specify function for scalar value. (NotNull)
     */
    public <RESULT> HpSLSFunction<VillageDayCB, RESULT> selectScalar(Class<RESULT> resultType) {
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
     * @param villageDayList The entity list of villageDay. (NotNull)
     * @param loaderLambda The callback to handle the referrer loader for actually loading referrer. (NotNull)
     */
    public void load(List<VillageDay> villageDayList, ReferrerLoaderHandler<LoaderOfVillageDay> loaderLambda) {
        xassLRArg(villageDayList, loaderLambda);
        loaderLambda.handle(new LoaderOfVillageDay().ready(villageDayList, _behaviorSelector));
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
     * @param villageDay The entity of villageDay. (NotNull)
     * @param loaderLambda The callback to handle the referrer loader for actually loading referrer. (NotNull)
     */
    public void load(VillageDay villageDay, ReferrerLoaderHandler<LoaderOfVillageDay> loaderLambda) {
        xassLRArg(villageDay, loaderLambda);
        loaderLambda.handle(new LoaderOfVillageDay().ready(xnewLRAryLs(villageDay), _behaviorSelector));
    }

    /**
     * Load referrer of abilityList by the set-upper of referrer. <br>
     * ABILITY by VILLAGE_DAY_ID, named 'abilityList'.
     * <pre>
     * <span style="color: #0000C0">villageDayBhv</span>.<span style="color: #CC4747">loadAbility</span>(<span style="color: #553000">villageDayList</span>, <span style="color: #553000">abilityCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">abilityCB</span>.setupSelect...
     *     <span style="color: #553000">abilityCB</span>.query().set...
     *     <span style="color: #553000">abilityCB</span>.query().addOrderBy...
     * }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     * <span style="color: #3F7E5E">//}).withNestedReferrer(referrerList -&gt; {</span>
     * <span style="color: #3F7E5E">//    ...</span>
     * <span style="color: #3F7E5E">//});</span>
     * <span style="color: #70226C">for</span> (VillageDay villageDay : <span style="color: #553000">villageDayList</span>) {
     *     ... = villageDay.<span style="color: #CC4747">getAbilityList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setVillageDayId_InScope(pkList);
     * cb.query().addOrderBy_VillageDayId_Asc();
     * </pre>
     * @param villageDayList The entity list of villageDay. (NotNull)
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerListGateway<Ability> loadAbility(List<VillageDay> villageDayList, ReferrerConditionSetupper<AbilityCB> refCBLambda) {
        xassLRArg(villageDayList, refCBLambda);
        return doLoadAbility(villageDayList, new LoadReferrerOption<AbilityCB, Ability>().xinit(refCBLambda));
    }

    /**
     * Load referrer of abilityList by the set-upper of referrer. <br>
     * ABILITY by VILLAGE_DAY_ID, named 'abilityList'.
     * <pre>
     * <span style="color: #0000C0">villageDayBhv</span>.<span style="color: #CC4747">loadAbility</span>(<span style="color: #553000">villageDay</span>, <span style="color: #553000">abilityCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">abilityCB</span>.setupSelect...
     *     <span style="color: #553000">abilityCB</span>.query().set...
     *     <span style="color: #553000">abilityCB</span>.query().addOrderBy...
     * }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     * <span style="color: #3F7E5E">//}).withNestedReferrer(referrerList -&gt; {</span>
     * <span style="color: #3F7E5E">//    ...</span>
     * <span style="color: #3F7E5E">//});</span>
     * ... = <span style="color: #553000">villageDay</span>.<span style="color: #CC4747">getAbilityList()</span>;
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setVillageDayId_InScope(pkList);
     * cb.query().addOrderBy_VillageDayId_Asc();
     * </pre>
     * @param villageDay The entity of villageDay. (NotNull)
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerListGateway<Ability> loadAbility(VillageDay villageDay, ReferrerConditionSetupper<AbilityCB> refCBLambda) {
        xassLRArg(villageDay, refCBLambda);
        return doLoadAbility(xnewLRLs(villageDay), new LoadReferrerOption<AbilityCB, Ability>().xinit(refCBLambda));
    }

    protected NestedReferrerListGateway<Ability> doLoadAbility(List<VillageDay> villageDayList, LoadReferrerOption<AbilityCB, Ability> option) {
        return helpLoadReferrerInternally(villageDayList, option, "abilityList");
    }

    /**
     * Load referrer of commitList by the set-upper of referrer. <br>
     * COMMIT by VILLAGE_DAY_ID, named 'commitList'.
     * <pre>
     * <span style="color: #0000C0">villageDayBhv</span>.<span style="color: #CC4747">loadCommit</span>(<span style="color: #553000">villageDayList</span>, <span style="color: #553000">commitCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">commitCB</span>.setupSelect...
     *     <span style="color: #553000">commitCB</span>.query().set...
     *     <span style="color: #553000">commitCB</span>.query().addOrderBy...
     * }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     * <span style="color: #3F7E5E">//}).withNestedReferrer(referrerList -&gt; {</span>
     * <span style="color: #3F7E5E">//    ...</span>
     * <span style="color: #3F7E5E">//});</span>
     * <span style="color: #70226C">for</span> (VillageDay villageDay : <span style="color: #553000">villageDayList</span>) {
     *     ... = villageDay.<span style="color: #CC4747">getCommitList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setVillageDayId_InScope(pkList);
     * cb.query().addOrderBy_VillageDayId_Asc();
     * </pre>
     * @param villageDayList The entity list of villageDay. (NotNull)
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerListGateway<Commit> loadCommit(List<VillageDay> villageDayList, ReferrerConditionSetupper<CommitCB> refCBLambda) {
        xassLRArg(villageDayList, refCBLambda);
        return doLoadCommit(villageDayList, new LoadReferrerOption<CommitCB, Commit>().xinit(refCBLambda));
    }

    /**
     * Load referrer of commitList by the set-upper of referrer. <br>
     * COMMIT by VILLAGE_DAY_ID, named 'commitList'.
     * <pre>
     * <span style="color: #0000C0">villageDayBhv</span>.<span style="color: #CC4747">loadCommit</span>(<span style="color: #553000">villageDay</span>, <span style="color: #553000">commitCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">commitCB</span>.setupSelect...
     *     <span style="color: #553000">commitCB</span>.query().set...
     *     <span style="color: #553000">commitCB</span>.query().addOrderBy...
     * }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     * <span style="color: #3F7E5E">//}).withNestedReferrer(referrerList -&gt; {</span>
     * <span style="color: #3F7E5E">//    ...</span>
     * <span style="color: #3F7E5E">//});</span>
     * ... = <span style="color: #553000">villageDay</span>.<span style="color: #CC4747">getCommitList()</span>;
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setVillageDayId_InScope(pkList);
     * cb.query().addOrderBy_VillageDayId_Asc();
     * </pre>
     * @param villageDay The entity of villageDay. (NotNull)
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerListGateway<Commit> loadCommit(VillageDay villageDay, ReferrerConditionSetupper<CommitCB> refCBLambda) {
        xassLRArg(villageDay, refCBLambda);
        return doLoadCommit(xnewLRLs(villageDay), new LoadReferrerOption<CommitCB, Commit>().xinit(refCBLambda));
    }

    protected NestedReferrerListGateway<Commit> doLoadCommit(List<VillageDay> villageDayList, LoadReferrerOption<CommitCB, Commit> option) {
        return helpLoadReferrerInternally(villageDayList, option, "commitList");
    }

    /**
     * Load referrer of villagePlayerList by the set-upper of referrer. <br>
     * VILLAGE_PLAYER by DEAD_VILLAGE_DAY_ID, named 'villagePlayerList'.
     * <pre>
     * <span style="color: #0000C0">villageDayBhv</span>.<span style="color: #CC4747">loadVillagePlayer</span>(<span style="color: #553000">villageDayList</span>, <span style="color: #553000">playerCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">playerCB</span>.setupSelect...
     *     <span style="color: #553000">playerCB</span>.query().set...
     *     <span style="color: #553000">playerCB</span>.query().addOrderBy...
     * }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     * <span style="color: #3F7E5E">//}).withNestedReferrer(referrerList -&gt; {</span>
     * <span style="color: #3F7E5E">//    ...</span>
     * <span style="color: #3F7E5E">//});</span>
     * <span style="color: #70226C">for</span> (VillageDay villageDay : <span style="color: #553000">villageDayList</span>) {
     *     ... = villageDay.<span style="color: #CC4747">getVillagePlayerList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setDeadVillageDayId_InScope(pkList);
     * cb.query().addOrderBy_DeadVillageDayId_Asc();
     * </pre>
     * @param villageDayList The entity list of villageDay. (NotNull)
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerListGateway<VillagePlayer> loadVillagePlayer(List<VillageDay> villageDayList, ReferrerConditionSetupper<VillagePlayerCB> refCBLambda) {
        xassLRArg(villageDayList, refCBLambda);
        return doLoadVillagePlayer(villageDayList, new LoadReferrerOption<VillagePlayerCB, VillagePlayer>().xinit(refCBLambda));
    }

    /**
     * Load referrer of villagePlayerList by the set-upper of referrer. <br>
     * VILLAGE_PLAYER by DEAD_VILLAGE_DAY_ID, named 'villagePlayerList'.
     * <pre>
     * <span style="color: #0000C0">villageDayBhv</span>.<span style="color: #CC4747">loadVillagePlayer</span>(<span style="color: #553000">villageDay</span>, <span style="color: #553000">playerCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">playerCB</span>.setupSelect...
     *     <span style="color: #553000">playerCB</span>.query().set...
     *     <span style="color: #553000">playerCB</span>.query().addOrderBy...
     * }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     * <span style="color: #3F7E5E">//}).withNestedReferrer(referrerList -&gt; {</span>
     * <span style="color: #3F7E5E">//    ...</span>
     * <span style="color: #3F7E5E">//});</span>
     * ... = <span style="color: #553000">villageDay</span>.<span style="color: #CC4747">getVillagePlayerList()</span>;
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setDeadVillageDayId_InScope(pkList);
     * cb.query().addOrderBy_DeadVillageDayId_Asc();
     * </pre>
     * @param villageDay The entity of villageDay. (NotNull)
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerListGateway<VillagePlayer> loadVillagePlayer(VillageDay villageDay, ReferrerConditionSetupper<VillagePlayerCB> refCBLambda) {
        xassLRArg(villageDay, refCBLambda);
        return doLoadVillagePlayer(xnewLRLs(villageDay), new LoadReferrerOption<VillagePlayerCB, VillagePlayer>().xinit(refCBLambda));
    }

    protected NestedReferrerListGateway<VillagePlayer> doLoadVillagePlayer(List<VillageDay> villageDayList, LoadReferrerOption<VillagePlayerCB, VillagePlayer> option) {
        return helpLoadReferrerInternally(villageDayList, option, "villagePlayerList");
    }

    /**
     * Load referrer of voteList by the set-upper of referrer. <br>
     * VOTE by VILLAGE_DAY_ID, named 'voteList'.
     * <pre>
     * <span style="color: #0000C0">villageDayBhv</span>.<span style="color: #CC4747">loadVote</span>(<span style="color: #553000">villageDayList</span>, <span style="color: #553000">voteCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">voteCB</span>.setupSelect...
     *     <span style="color: #553000">voteCB</span>.query().set...
     *     <span style="color: #553000">voteCB</span>.query().addOrderBy...
     * }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     * <span style="color: #3F7E5E">//}).withNestedReferrer(referrerList -&gt; {</span>
     * <span style="color: #3F7E5E">//    ...</span>
     * <span style="color: #3F7E5E">//});</span>
     * <span style="color: #70226C">for</span> (VillageDay villageDay : <span style="color: #553000">villageDayList</span>) {
     *     ... = villageDay.<span style="color: #CC4747">getVoteList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setVillageDayId_InScope(pkList);
     * cb.query().addOrderBy_VillageDayId_Asc();
     * </pre>
     * @param villageDayList The entity list of villageDay. (NotNull)
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerListGateway<Vote> loadVote(List<VillageDay> villageDayList, ReferrerConditionSetupper<VoteCB> refCBLambda) {
        xassLRArg(villageDayList, refCBLambda);
        return doLoadVote(villageDayList, new LoadReferrerOption<VoteCB, Vote>().xinit(refCBLambda));
    }

    /**
     * Load referrer of voteList by the set-upper of referrer. <br>
     * VOTE by VILLAGE_DAY_ID, named 'voteList'.
     * <pre>
     * <span style="color: #0000C0">villageDayBhv</span>.<span style="color: #CC4747">loadVote</span>(<span style="color: #553000">villageDay</span>, <span style="color: #553000">voteCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">voteCB</span>.setupSelect...
     *     <span style="color: #553000">voteCB</span>.query().set...
     *     <span style="color: #553000">voteCB</span>.query().addOrderBy...
     * }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     * <span style="color: #3F7E5E">//}).withNestedReferrer(referrerList -&gt; {</span>
     * <span style="color: #3F7E5E">//    ...</span>
     * <span style="color: #3F7E5E">//});</span>
     * ... = <span style="color: #553000">villageDay</span>.<span style="color: #CC4747">getVoteList()</span>;
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setVillageDayId_InScope(pkList);
     * cb.query().addOrderBy_VillageDayId_Asc();
     * </pre>
     * @param villageDay The entity of villageDay. (NotNull)
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerListGateway<Vote> loadVote(VillageDay villageDay, ReferrerConditionSetupper<VoteCB> refCBLambda) {
        xassLRArg(villageDay, refCBLambda);
        return doLoadVote(xnewLRLs(villageDay), new LoadReferrerOption<VoteCB, Vote>().xinit(refCBLambda));
    }

    protected NestedReferrerListGateway<Vote> doLoadVote(List<VillageDay> villageDayList, LoadReferrerOption<VoteCB, Vote> option) {
        return helpLoadReferrerInternally(villageDayList, option, "voteList");
    }

    // ===================================================================================
    //                                                                   Pull out Relation
    //                                                                   =================
    /**
     * Pull out the list of foreign table 'Noonnight'.
     * @param villageDayList The list of villageDay. (NotNull, EmptyAllowed)
     * @return The list of foreign table. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<Noonnight> pulloutNoonnight(List<VillageDay> villageDayList)
    { return helpPulloutInternally(villageDayList, "noonnight"); }

    /**
     * Pull out the list of foreign table 'Village'.
     * @param villageDayList The list of villageDay. (NotNull, EmptyAllowed)
     * @return The list of foreign table. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<Village> pulloutVillage(List<VillageDay> villageDayList)
    { return helpPulloutInternally(villageDayList, "village"); }

    // ===================================================================================
    //                                                                      Extract Column
    //                                                                      ==============
    /**
     * Extract the value list of (single) primary key villageDayId.
     * @param villageDayList The list of villageDay. (NotNull, EmptyAllowed)
     * @return The list of the column value. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<Integer> extractVillageDayIdList(List<VillageDay> villageDayList)
    { return helpExtractListInternally(villageDayList, "villageDayId"); }

    // ===================================================================================
    //                                                                       Entity Update
    //                                                                       =============
    /**
     * Insert the entity modified-only. (DefaultConstraintsEnabled)
     * <pre>
     * VillageDay villageDay = <span style="color: #70226C">new</span> VillageDay();
     * <span style="color: #3F7E5E">// if auto-increment, you don't need to set the PK value</span>
     * villageDay.setFoo...(value);
     * villageDay.setBar...(value);
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//villageDay.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//villageDay.set...;</span>
     * <span style="color: #0000C0">villageDayBhv</span>.<span style="color: #CC4747">insert</span>(villageDay);
     * ... = villageDay.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * <p>While, when the entity is created by select, all columns are registered.</p>
     * @param villageDay The entity of insert. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @throws EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insert(VillageDay villageDay) {
        doInsert(villageDay, null);
    }

    /**
     * Update the entity modified-only. (ZeroUpdateException, NonExclusiveControl) <br>
     * By PK as default, and also you can update by unique keys using entity's uniqueOf().
     * <pre>
     * VillageDay villageDay = <span style="color: #70226C">new</span> VillageDay();
     * villageDay.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * villageDay.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//villageDay.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//villageDay.set...;</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of concurrency column is required</span>
     * villageDay.<span style="color: #CC4747">setVersionNo</span>(value);
     * <span style="color: #0000C0">villageDayBhv</span>.<span style="color: #CC4747">update</span>(villageDay);
     * </pre>
     * @param villageDay The entity of update. (NotNull, PrimaryKeyNotNull)
     * @throws EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @throws EntityDuplicatedException When the entity has been duplicated.
     * @throws EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void update(VillageDay villageDay) {
        doUpdate(villageDay, null);
    }

    /**
     * Insert or update the entity modified-only. (DefaultConstraintsEnabled, NonExclusiveControl) <br>
     * if (the entity has no PK) { insert() } else { update(), but no data, insert() } <br>
     * <p><span style="color: #994747; font-size: 120%">Also you can update by unique keys using entity's uniqueOf().</span></p>
     * @param villageDay The entity of insert or update. (NotNull, ...depends on insert or update)
     * @throws EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @throws EntityDuplicatedException When the entity has been duplicated.
     * @throws EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insertOrUpdate(VillageDay villageDay) {
        doInsertOrUpdate(villageDay, null, null);
    }

    /**
     * Delete the entity. (ZeroUpdateException, NonExclusiveControl) <br>
     * By PK as default, and also you can delete by unique keys using entity's uniqueOf().
     * <pre>
     * VillageDay villageDay = <span style="color: #70226C">new</span> VillageDay();
     * villageDay.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of concurrency column is required</span>
     * villageDay.<span style="color: #CC4747">setVersionNo</span>(value);
     * <span style="color: #70226C">try</span> {
     *     <span style="color: #0000C0">villageDayBhv</span>.<span style="color: #CC4747">delete</span>(villageDay);
     * } <span style="color: #70226C">catch</span> (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param villageDay The entity of delete. (NotNull, PrimaryKeyNotNull)
     * @throws EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @throws EntityDuplicatedException When the entity has been duplicated.
     */
    public void delete(VillageDay villageDay) {
        doDelete(villageDay, null);
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
     *     VillageDay villageDay = <span style="color: #70226C">new</span> VillageDay();
     *     villageDay.setFooName("foo");
     *     <span style="color: #70226C">if</span> (...) {
     *         villageDay.setFooPrice(123);
     *     }
     *     <span style="color: #3F7E5E">// FOO_NAME and FOO_PRICE (and record meta columns) are registered</span>
     *     <span style="color: #3F7E5E">// FOO_PRICE not-called in any entities are registered as null without default value</span>
     *     <span style="color: #3F7E5E">// columns not-called in all entities are registered as null or default value</span>
     *     villageDayList.add(villageDay);
     * }
     * <span style="color: #0000C0">villageDayBhv</span>.<span style="color: #CC4747">batchInsert</span>(villageDayList);
     * </pre>
     * <p>While, when the entities are created by select, all columns are registered.</p>
     * <p>And if the table has an identity, entities after the process don't have incremented values.
     * (When you use the (normal) insert(), you can get the incremented value from your entity)</p>
     * @param villageDayList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNullAllowed: when auto-increment)
     * @return The array of inserted count. (NotNull, EmptyAllowed)
     */
    public int[] batchInsert(List<VillageDay> villageDayList) {
        return doBatchInsert(villageDayList, null);
    }

    /**
     * Batch-update the entity list modified-only of same-set columns. (NonExclusiveControl) <br>
     * This method uses executeBatch() of java.sql.PreparedStatement. <br>
     * <span style="color: #CC4747; font-size: 120%">You should specify same-set columns to all entities like this:</span>
     * <pre>
     * for (... : ...) {
     *     VillageDay villageDay = <span style="color: #70226C">new</span> VillageDay();
     *     villageDay.setFooName("foo");
     *     <span style="color: #70226C">if</span> (...) {
     *         villageDay.setFooPrice(123);
     *     } <span style="color: #70226C">else</span> {
     *         villageDay.setFooPrice(null); <span style="color: #3F7E5E">// updated as null</span>
     *         <span style="color: #3F7E5E">//villageDay.setFooDate(...); // *not allowed, fragmented</span>
     *     }
     *     <span style="color: #3F7E5E">// FOO_NAME and FOO_PRICE (and record meta columns) are updated</span>
     *     <span style="color: #3F7E5E">// (others are not updated: their values are kept)</span>
     *     villageDayList.add(villageDay);
     * }
     * <span style="color: #0000C0">villageDayBhv</span>.<span style="color: #CC4747">batchUpdate</span>(villageDayList);
     * </pre>
     * @param villageDayList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @throws EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchUpdate(List<VillageDay> villageDayList) {
        return doBatchUpdate(villageDayList, null);
    }

    /**
     * Batch-delete the entity list. (NonExclusiveControl) <br>
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * @param villageDayList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     * @throws EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchDelete(List<VillageDay> villageDayList) {
        return doBatchDelete(villageDayList, null);
    }

    // ===================================================================================
    //                                                                        Query Update
    //                                                                        ============
    /**
     * Insert the several entities by query (modified-only for fixed value).
     * <pre>
     * <span style="color: #0000C0">villageDayBhv</span>.<span style="color: #CC4747">queryInsert</span>(new QueryInsertSetupper&lt;VillageDay, VillageDayCB&gt;() {
     *     public ConditionBean setup(VillageDay entity, VillageDayCB intoCB) {
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
    public int queryInsert(QueryInsertSetupper<VillageDay, VillageDayCB> manyArgLambda) {
        return doQueryInsert(manyArgLambda, null);
    }

    /**
     * Update the several entities by query non-strictly modified-only. (NonExclusiveControl)
     * <pre>
     * VillageDay villageDay = <span style="color: #70226C">new</span> VillageDay();
     * <span style="color: #3F7E5E">// you don't need to set PK value</span>
     * <span style="color: #3F7E5E">//villageDay.setPK...(value);</span>
     * villageDay.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//villageDay.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//villageDay.set...;</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of concurrency column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//villageDay.setVersionNo(value);</span>
     * <span style="color: #0000C0">villageDayBhv</span>.<span style="color: #CC4747">queryUpdate</span>(villageDay, <span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">cb</span>.query().setFoo...
     * });
     * </pre>
     * @param villageDay The entity that contains update values. (NotNull, PrimaryKeyNullAllowed)
     * @param cbLambda The callback for condition-bean of VillageDay. (NotNull)
     * @return The updated count.
     * @throws NonQueryUpdateNotAllowedException When the query has no condition.
     */
    public int queryUpdate(VillageDay villageDay, CBCall<VillageDayCB> cbLambda) {
        return doQueryUpdate(villageDay, createCB(cbLambda), null);
    }

    /**
     * Delete the several entities by query. (NonExclusiveControl)
     * <pre>
     * <span style="color: #0000C0">villageDayBhv</span>.<span style="color: #CC4747">queryDelete</span>(villageDay, <span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">cb</span>.query().setFoo...
     * });
     * </pre>
     * @param cbLambda The callback for condition-bean of VillageDay. (NotNull)
     * @return The deleted count.
     * @throws NonQueryDeleteNotAllowedException When the query has no condition.
     */
    public int queryDelete(CBCall<VillageDayCB> cbLambda) {
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
     * VillageDay villageDay = <span style="color: #70226C">new</span> VillageDay();
     * <span style="color: #3F7E5E">// if auto-increment, you don't need to set the PK value</span>
     * villageDay.setFoo...(value);
     * villageDay.setBar...(value);
     * <span style="color: #0000C0">villageDayBhv</span>.<span style="color: #CC4747">varyingInsert</span>(villageDay, <span style="color: #553000">op</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #3F7E5E">// you can insert by your values for common columns</span>
     *     <span style="color: #553000">op</span>.disableCommonColumnAutoSetup();
     * });
     * ... = villageDay.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * @param villageDay The entity of insert. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @param opLambda The callback for option of insert for varying requests. (NotNull)
     * @throws EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsert(VillageDay villageDay, WritableOptionCall<VillageDayCB, InsertOption<VillageDayCB>> opLambda) {
        doInsert(villageDay, createInsertOption(opLambda));
    }

    /**
     * Update the entity with varying requests modified-only. (ZeroUpdateException, NonExclusiveControl) <br>
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification), disableCommonColumnAutoSetup(). <br>
     * Other specifications are same as update(entity).
     * <pre>
     * VillageDay villageDay = <span style="color: #70226C">new</span> VillageDay();
     * villageDay.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * villageDay.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of concurrency column is required</span>
     * villageDay.<span style="color: #CC4747">setVersionNo</span>(value);
     * <span style="color: #3F7E5E">// you can update by self calculation values</span>
     * <span style="color: #0000C0">villageDayBhv</span>.<span style="color: #CC4747">varyingUpdate</span>(villageDay, <span style="color: #553000">op</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">op</span>.self(<span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *         <span style="color: #553000">cb</span>.specify().<span style="color: #CC4747">columnXxxCount()</span>;
     *     }).plus(1); <span style="color: #3F7E5E">// XXX_COUNT = XXX_COUNT + 1</span>
     * });
     * </pre>
     * @param villageDay The entity of update. (NotNull, PrimaryKeyNotNull)
     * @param opLambda The callback for option of update for varying requests. (NotNull)
     * @throws EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @throws EntityDuplicatedException When the entity has been duplicated.
     * @throws EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingUpdate(VillageDay villageDay, WritableOptionCall<VillageDayCB, UpdateOption<VillageDayCB>> opLambda) {
        doUpdate(villageDay, createUpdateOption(opLambda));
    }

    /**
     * Insert or update the entity with varying requests. (ExclusiveControl: when update) <br>
     * Other specifications are same as insertOrUpdate(entity).
     * @param villageDay The entity of insert or update. (NotNull)
     * @param insertOpLambda The callback for option of insert for varying requests. (NotNull)
     * @param updateOpLambda The callback for option of update for varying requests. (NotNull)
     * @throws EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @throws EntityDuplicatedException When the entity has been duplicated.
     * @throws EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsertOrUpdate(VillageDay villageDay, WritableOptionCall<VillageDayCB, InsertOption<VillageDayCB>> insertOpLambda, WritableOptionCall<VillageDayCB, UpdateOption<VillageDayCB>> updateOpLambda) {
        doInsertOrUpdate(villageDay, createInsertOption(insertOpLambda), createUpdateOption(updateOpLambda));
    }

    /**
     * Delete the entity with varying requests. (ZeroUpdateException, NonExclusiveControl) <br>
     * Now a valid option does not exist. <br>
     * Other specifications are same as delete(entity).
     * @param villageDay The entity of delete. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnNotNull)
     * @param opLambda The callback for option of delete for varying requests. (NotNull)
     * @throws EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @throws EntityDuplicatedException When the entity has been duplicated.
     */
    public void varyingDelete(VillageDay villageDay, WritableOptionCall<VillageDayCB, DeleteOption<VillageDayCB>> opLambda) {
        doDelete(villageDay, createDeleteOption(opLambda));
    }

    // -----------------------------------------------------
    //                                          Batch Update
    //                                          ------------
    /**
     * Batch-insert the list with varying requests. <br>
     * For example, disableCommonColumnAutoSetup()
     * , disablePrimaryKeyIdentity(), limitBatchInsertLogging(). <br>
     * Other specifications are same as batchInsert(entityList).
     * @param villageDayList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param opLambda The callback for option of insert for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchInsert(List<VillageDay> villageDayList, WritableOptionCall<VillageDayCB, InsertOption<VillageDayCB>> opLambda) {
        return doBatchInsert(villageDayList, createInsertOption(opLambda));
    }

    /**
     * Batch-update the list with varying requests. <br>
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification)
     * , disableCommonColumnAutoSetup(), limitBatchUpdateLogging(). <br>
     * Other specifications are same as batchUpdate(entityList).
     * @param villageDayList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param opLambda The callback for option of update for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchUpdate(List<VillageDay> villageDayList, WritableOptionCall<VillageDayCB, UpdateOption<VillageDayCB>> opLambda) {
        return doBatchUpdate(villageDayList, createUpdateOption(opLambda));
    }

    /**
     * Batch-delete the list with varying requests. <br>
     * For example, limitBatchDeleteLogging(). <br>
     * Other specifications are same as batchDelete(entityList).
     * @param villageDayList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param opLambda The callback for option of delete for varying requests. (NotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchDelete(List<VillageDay> villageDayList, WritableOptionCall<VillageDayCB, DeleteOption<VillageDayCB>> opLambda) {
        return doBatchDelete(villageDayList, createDeleteOption(opLambda));
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
    public int varyingQueryInsert(QueryInsertSetupper<VillageDay, VillageDayCB> manyArgLambda, WritableOptionCall<VillageDayCB, InsertOption<VillageDayCB>> opLambda) {
        return doQueryInsert(manyArgLambda, createInsertOption(opLambda));
    }

    /**
     * Update the several entities by query with varying requests non-strictly modified-only. {NonExclusiveControl} <br>
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification)
     * , disableCommonColumnAutoSetup(), allowNonQueryUpdate(). <br>
     * Other specifications are same as queryUpdate(entity, cb).
     * <pre>
     * <span style="color: #3F7E5E">// ex) you can update by self calculation values</span>
     * VillageDay villageDay = <span style="color: #70226C">new</span> VillageDay();
     * <span style="color: #3F7E5E">// you don't need to set PK value</span>
     * <span style="color: #3F7E5E">//villageDay.setPK...(value);</span>
     * villageDay.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of concurrency column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//villageDay.setVersionNo(value);</span>
     * <span style="color: #0000C0">villageDayBhv</span>.<span style="color: #CC4747">varyingQueryUpdate</span>(villageDay, <span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">cb</span>.query().setFoo...
     * }, <span style="color: #553000">op</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">op</span>.self(<span style="color: #553000">colCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *         <span style="color: #553000">colCB</span>.specify().<span style="color: #CC4747">columnFooCount()</span>;
     *     }).plus(1); <span style="color: #3F7E5E">// FOO_COUNT = FOO_COUNT + 1</span>
     * });
     * </pre>
     * @param villageDay The entity that contains update values. (NotNull) {PrimaryKeyNotRequired}
     * @param cbLambda The callback for condition-bean of VillageDay. (NotNull)
     * @param opLambda The callback for option of update for varying requests. (NotNull)
     * @return The updated count.
     * @throws NonQueryUpdateNotAllowedException When the query has no condition (if not allowed).
     */
    public int varyingQueryUpdate(VillageDay villageDay, CBCall<VillageDayCB> cbLambda, WritableOptionCall<VillageDayCB, UpdateOption<VillageDayCB>> opLambda) {
        return doQueryUpdate(villageDay, createCB(cbLambda), createUpdateOption(opLambda));
    }

    /**
     * Delete the several entities by query with varying requests non-strictly. <br>
     * For example, allowNonQueryDelete(). <br>
     * Other specifications are same as queryDelete(cb).
     * <pre>
     * <span style="color: #0000C0">villageDayBhv</span>.<span style="color: #CC4747">queryDelete</span>(villageDay, <span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">cb</span>.query().setFoo...
     * }, <span style="color: #553000">op</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">op</span>...
     * });
     * </pre>
     * @param cbLambda The callback for condition-bean of VillageDay. (NotNull)
     * @param opLambda The callback for option of delete for varying requests. (NotNull)
     * @return The deleted count.
     * @throws NonQueryDeleteNotAllowedException When the query has no condition (if not allowed).
     */
    public int varyingQueryDelete(CBCall<VillageDayCB> cbLambda, WritableOptionCall<VillageDayCB, DeleteOption<VillageDayCB>> opLambda) {
        return doQueryDelete(createCB(cbLambda), createDeleteOption(opLambda));
    }

    // ===================================================================================
    //                                                                          OutsideSql
    //                                                                          ==========
    /**
     * Prepare the all facade executor of outside-SQL to execute it.
     * <pre>
     * <span style="color: #3F7E5E">// main style</span>
     * villageDayBhv.outideSql().selectEntity(pmb); <span style="color: #3F7E5E">// optional</span>
     * villageDayBhv.outideSql().selectList(pmb); <span style="color: #3F7E5E">// ListResultBean</span>
     * villageDayBhv.outideSql().selectPage(pmb); <span style="color: #3F7E5E">// PagingResultBean</span>
     * villageDayBhv.outideSql().selectPagedListOnly(pmb); <span style="color: #3F7E5E">// ListResultBean</span>
     * villageDayBhv.outideSql().selectCursor(pmb, handler); <span style="color: #3F7E5E">// (by handler)</span>
     * villageDayBhv.outideSql().execute(pmb); <span style="color: #3F7E5E">// int (updated count)</span>
     * villageDayBhv.outideSql().call(pmb); <span style="color: #3F7E5E">// void (pmb has OUT parameters)</span>
     *
     * <span style="color: #3F7E5E">// traditional style</span>
     * villageDayBhv.outideSql().traditionalStyle().selectEntity(path, pmb, entityType);
     * villageDayBhv.outideSql().traditionalStyle().selectList(path, pmb, entityType);
     * villageDayBhv.outideSql().traditionalStyle().selectPage(path, pmb, entityType);
     * villageDayBhv.outideSql().traditionalStyle().selectPagedListOnly(path, pmb, entityType);
     * villageDayBhv.outideSql().traditionalStyle().selectCursor(path, pmb, handler);
     * villageDayBhv.outideSql().traditionalStyle().execute(path, pmb);
     *
     * <span style="color: #3F7E5E">// options</span>
     * villageDayBhv.outideSql().removeBlockComment().selectList()
     * villageDayBhv.outideSql().removeLineComment().selectList()
     * villageDayBhv.outideSql().formatSql().selectList()
     * </pre>
     * <p>The invoker of behavior command should be not null when you call this method.</p>
     * @return The new-created all facade executor of outside-SQL. (NotNull)
     */
    public OutsideSqlAllFacadeExecutor<VillageDayBhv> outsideSql() {
        return doOutsideSql();
    }

    // ===================================================================================
    //                                                                         Type Helper
    //                                                                         ===========
    protected Class<? extends VillageDay> typeOfSelectedEntity() { return VillageDay.class; }
    protected Class<VillageDay> typeOfHandlingEntity() { return VillageDay.class; }
    protected Class<VillageDayCB> typeOfHandlingConditionBean() { return VillageDayCB.class; }

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
