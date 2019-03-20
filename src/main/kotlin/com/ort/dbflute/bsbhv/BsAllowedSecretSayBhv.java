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
import com.ort.dbflute.allcommon.CDef;
import com.ort.dbflute.exbhv.*;
import com.ort.dbflute.bsbhv.loader.*;
import com.ort.dbflute.exentity.*;
import com.ort.dbflute.bsentity.dbmeta.*;
import com.ort.dbflute.cbean.*;

/**
 * The behavior of ALLOWED_SECRET_SAY as TABLE. <br>
 * <pre>
 * [primary key]
 *     ALLOWED_SECRET_SAY_CODE
 *
 * [column]
 *     ALLOWED_SECRET_SAY_CODE, ALLOWED_SECRET_SAY_NAME
 *
 * [sequence]
 *     
 *
 * [identity]
 *     
 *
 * [version-no]
 *     
 *
 * [foreign table]
 *     
 *
 * [referrer table]
 *     VILLAGE_SETTINGS
 *
 * [foreign property]
 *     
 *
 * [referrer property]
 *     villageSettingsList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsAllowedSecretSayBhv extends AbstractBehaviorWritable<AllowedSecretSay, AllowedSecretSayCB> {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /*df:beginQueryPath*/
    /*df:endQueryPath*/

    // ===================================================================================
    //                                                                             DB Meta
    //                                                                             =======
    /** {@inheritDoc} */
    public AllowedSecretSayDbm asDBMeta() { return AllowedSecretSayDbm.getInstance(); }
    /** {@inheritDoc} */
    public String asTableDbName() { return "allowed_secret_say"; }

    // ===================================================================================
    //                                                                        New Instance
    //                                                                        ============
    /** {@inheritDoc} */
    public AllowedSecretSayCB newConditionBean() { return new AllowedSecretSayCB(); }

    // ===================================================================================
    //                                                                        Count Select
    //                                                                        ============
    /**
     * Select the count of uniquely-selected records by the condition-bean. {IgnorePagingCondition, IgnoreSpecifyColumn}<br>
     * SpecifyColumn is ignored but you can use it only to remove text type column for union's distinct.
     * <pre>
     * <span style="color: #70226C">int</span> count = <span style="color: #0000C0">allowedSecretSayBhv</span>.<span style="color: #CC4747">selectCount</span>(<span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">cb</span>.query().set...
     * });
     * </pre>
     * @param cbLambda The callback for condition-bean of AllowedSecretSay. (NotNull)
     * @return The count for the condition. (NotMinus)
     */
    public int selectCount(CBCall<AllowedSecretSayCB> cbLambda) {
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
     * <span style="color: #0000C0">allowedSecretSayBhv</span>.<span style="color: #CC4747">selectEntity</span>(<span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">cb</span>.query().set...
     * }).<span style="color: #CC4747">alwaysPresent</span>(<span style="color: #553000">allowedSecretSay</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #3F7E5E">// called if present, or exception</span>
     *     ... = <span style="color: #553000">allowedSecretSay</span>.get...
     * });
     * 
     * <span style="color: #3F7E5E">// if it might be no data, ...</span>
     * <span style="color: #0000C0">allowedSecretSayBhv</span>.<span style="color: #CC4747">selectEntity</span>(<span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">cb</span>.query().set...
     * }).<span style="color: #CC4747">ifPresent</span>(<span style="color: #553000">allowedSecretSay</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #3F7E5E">// called if present</span>
     *     ... = <span style="color: #553000">allowedSecretSay</span>.get...
     * }).<span style="color: #994747">orElse</span>(() <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #3F7E5E">// called if not present</span>
     * });
     * </pre>
     * @param cbLambda The callback for condition-bean of AllowedSecretSay. (NotNull)
     * @return The optional entity selected by the condition. (NotNull: if no data, empty entity)
     * @throws EntityAlreadyDeletedException When get(), required() of return value is called and the value is null, which means entity has already been deleted (not found).
     * @throws EntityDuplicatedException When the entity has been duplicated.
     * @throws SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public OptionalEntity<AllowedSecretSay> selectEntity(CBCall<AllowedSecretSayCB> cbLambda) {
        return facadeSelectEntity(createCB(cbLambda));
    }

    protected OptionalEntity<AllowedSecretSay> facadeSelectEntity(AllowedSecretSayCB cb) {
        return doSelectOptionalEntity(cb, typeOfSelectedEntity());
    }

    protected <ENTITY extends AllowedSecretSay> OptionalEntity<ENTITY> doSelectOptionalEntity(AllowedSecretSayCB cb, Class<? extends ENTITY> tp) {
        return createOptionalEntity(doSelectEntity(cb, tp), cb);
    }

    protected Entity doReadEntity(ConditionBean cb) { return facadeSelectEntity(downcast(cb)).orElse(null); }

    /**
     * Select the entity by the condition-bean with deleted check. <br>
     * <span style="color: #AD4747; font-size: 120%">If the data is always present as your business rule, this method is good.</span>
     * <pre>
     * AllowedSecretSay <span style="color: #553000">allowedSecretSay</span> = <span style="color: #0000C0">allowedSecretSayBhv</span>.<span style="color: #CC4747">selectEntityWithDeletedCheck</span>(cb <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> cb.acceptPK(1));
     * ... = <span style="color: #553000">allowedSecretSay</span>.get...(); <span style="color: #3F7E5E">// the entity always be not null</span>
     * </pre>
     * @param cbLambda The callback for condition-bean of AllowedSecretSay. (NotNull)
     * @return The entity selected by the condition. (NotNull: if no data, throws exception)
     * @throws EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @throws EntityDuplicatedException When the entity has been duplicated.
     * @throws SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public AllowedSecretSay selectEntityWithDeletedCheck(CBCall<AllowedSecretSayCB> cbLambda) {
        return facadeSelectEntityWithDeletedCheck(createCB(cbLambda));
    }

    /**
     * Select the entity by the primary-key value.
     * @param allowedSecretSayCode : PK, NotNull, VARCHAR(20), classification=AllowedSecretSay. (NotNull)
     * @return The optional entity selected by the PK. (NotNull: if no data, empty entity)
     * @throws EntityAlreadyDeletedException When get(), required() of return value is called and the value is null, which means entity has already been deleted (not found).
     * @throws EntityDuplicatedException When the entity has been duplicated.
     * @throws SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public OptionalEntity<AllowedSecretSay> selectByPK(CDef.AllowedSecretSay allowedSecretSayCode) {
        return facadeSelectByPK(allowedSecretSayCode);
    }

    protected OptionalEntity<AllowedSecretSay> facadeSelectByPK(CDef.AllowedSecretSay allowedSecretSayCode) {
        return doSelectOptionalByPK(allowedSecretSayCode, typeOfSelectedEntity());
    }

    protected <ENTITY extends AllowedSecretSay> ENTITY doSelectByPK(CDef.AllowedSecretSay allowedSecretSayCode, Class<? extends ENTITY> tp) {
        return doSelectEntity(xprepareCBAsPK(allowedSecretSayCode), tp);
    }

    protected <ENTITY extends AllowedSecretSay> OptionalEntity<ENTITY> doSelectOptionalByPK(CDef.AllowedSecretSay allowedSecretSayCode, Class<? extends ENTITY> tp) {
        return createOptionalEntity(doSelectByPK(allowedSecretSayCode, tp), allowedSecretSayCode);
    }

    protected AllowedSecretSayCB xprepareCBAsPK(CDef.AllowedSecretSay allowedSecretSayCode) {
        assertObjectNotNull("allowedSecretSayCode", allowedSecretSayCode);
        return newConditionBean().acceptPK(allowedSecretSayCode);
    }

    // ===================================================================================
    //                                                                         List Select
    //                                                                         ===========
    /**
     * Select the list as result bean.
     * <pre>
     * ListResultBean&lt;AllowedSecretSay&gt; <span style="color: #553000">allowedSecretSayList</span> = <span style="color: #0000C0">allowedSecretSayBhv</span>.<span style="color: #CC4747">selectList</span>(<span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">cb</span>.query().set...;
     *     <span style="color: #553000">cb</span>.query().addOrderBy...;
     * });
     * <span style="color: #70226C">for</span> (AllowedSecretSay <span style="color: #553000">allowedSecretSay</span> : <span style="color: #553000">allowedSecretSayList</span>) {
     *     ... = <span style="color: #553000">allowedSecretSay</span>.get...;
     * }
     * </pre>
     * @param cbLambda The callback for condition-bean of AllowedSecretSay. (NotNull)
     * @return The result bean of selected list. (NotNull: if no data, returns empty list)
     * @throws DangerousResultSizeException When the result size is over the specified safety size.
     */
    public ListResultBean<AllowedSecretSay> selectList(CBCall<AllowedSecretSayCB> cbLambda) {
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
     * PagingResultBean&lt;AllowedSecretSay&gt; <span style="color: #553000">page</span> = <span style="color: #0000C0">allowedSecretSayBhv</span>.<span style="color: #CC4747">selectPage</span>(<span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">cb</span>.query().set...
     *     <span style="color: #553000">cb</span>.query().addOrderBy...
     *     <span style="color: #553000">cb</span>.<span style="color: #CC4747">paging</span>(20, 3); <span style="color: #3F7E5E">// 20 records per a page and current page number is 3</span>
     * });
     * <span style="color: #70226C">int</span> allRecordCount = <span style="color: #553000">page</span>.getAllRecordCount();
     * <span style="color: #70226C">int</span> allPageCount = <span style="color: #553000">page</span>.getAllPageCount();
     * <span style="color: #70226C">boolean</span> isExistPrePage = <span style="color: #553000">page</span>.isExistPrePage();
     * <span style="color: #70226C">boolean</span> isExistNextPage = <span style="color: #553000">page</span>.isExistNextPage();
     * ...
     * <span style="color: #70226C">for</span> (AllowedSecretSay allowedSecretSay : <span style="color: #553000">page</span>) {
     *     ... = allowedSecretSay.get...;
     * }
     * </pre>
     * @param cbLambda The callback for condition-bean of AllowedSecretSay. (NotNull)
     * @return The result bean of selected page. (NotNull: if no data, returns bean as empty list)
     * @throws DangerousResultSizeException When the result size is over the specified safety size.
     */
    public PagingResultBean<AllowedSecretSay> selectPage(CBCall<AllowedSecretSayCB> cbLambda) {
        return facadeSelectPage(createCB(cbLambda));
    }

    // ===================================================================================
    //                                                                       Cursor Select
    //                                                                       =============
    /**
     * Select the cursor by the condition-bean.
     * <pre>
     * <span style="color: #0000C0">allowedSecretSayBhv</span>.<span style="color: #CC4747">selectCursor</span>(<span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">cb</span>.query().set...
     * }, <span style="color: #553000">member</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     ... = <span style="color: #553000">member</span>.getMemberName();
     * });
     * </pre>
     * @param cbLambda The callback for condition-bean of AllowedSecretSay. (NotNull)
     * @param entityLambda The handler of entity row of AllowedSecretSay. (NotNull)
     */
    public void selectCursor(CBCall<AllowedSecretSayCB> cbLambda, EntityRowHandler<AllowedSecretSay> entityLambda) {
        facadeSelectCursor(createCB(cbLambda), entityLambda);
    }

    // ===================================================================================
    //                                                                       Scalar Select
    //                                                                       =============
    /**
     * Select the scalar value derived by a function from uniquely-selected records. <br>
     * You should call a function method after this method called like as follows:
     * <pre>
     * <span style="color: #0000C0">allowedSecretSayBhv</span>.<span style="color: #CC4747">selectScalar</span>(Date.class).max(<span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">cb</span>.specify().<span style="color: #CC4747">column...</span>; <span style="color: #3F7E5E">// required for the function</span>
     *     <span style="color: #553000">cb</span>.query().set...
     * });
     * </pre>
     * @param <RESULT> The type of result.
     * @param resultType The type of result. (NotNull)
     * @return The scalar function object to specify function for scalar value. (NotNull)
     */
    public <RESULT> HpSLSFunction<AllowedSecretSayCB, RESULT> selectScalar(Class<RESULT> resultType) {
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
     * @param allowedSecretSayList The entity list of allowedSecretSay. (NotNull)
     * @param loaderLambda The callback to handle the referrer loader for actually loading referrer. (NotNull)
     */
    public void load(List<AllowedSecretSay> allowedSecretSayList, ReferrerLoaderHandler<LoaderOfAllowedSecretSay> loaderLambda) {
        xassLRArg(allowedSecretSayList, loaderLambda);
        loaderLambda.handle(new LoaderOfAllowedSecretSay().ready(allowedSecretSayList, _behaviorSelector));
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
     * @param allowedSecretSay The entity of allowedSecretSay. (NotNull)
     * @param loaderLambda The callback to handle the referrer loader for actually loading referrer. (NotNull)
     */
    public void load(AllowedSecretSay allowedSecretSay, ReferrerLoaderHandler<LoaderOfAllowedSecretSay> loaderLambda) {
        xassLRArg(allowedSecretSay, loaderLambda);
        loaderLambda.handle(new LoaderOfAllowedSecretSay().ready(xnewLRAryLs(allowedSecretSay), _behaviorSelector));
    }

    /**
     * Load referrer of villageSettingsList by the set-upper of referrer. <br>
     * VILLAGE_SETTINGS by ALLOWED_SECRET_SAY_CODE, named 'villageSettingsList'.
     * <pre>
     * <span style="color: #0000C0">allowedSecretSayBhv</span>.<span style="color: #CC4747">loadVillageSettings</span>(<span style="color: #553000">allowedSecretSayList</span>, <span style="color: #553000">settingsCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">settingsCB</span>.setupSelect...
     *     <span style="color: #553000">settingsCB</span>.query().set...
     *     <span style="color: #553000">settingsCB</span>.query().addOrderBy...
     * }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     * <span style="color: #3F7E5E">//}).withNestedReferrer(referrerList -&gt; {</span>
     * <span style="color: #3F7E5E">//    ...</span>
     * <span style="color: #3F7E5E">//});</span>
     * <span style="color: #70226C">for</span> (AllowedSecretSay allowedSecretSay : <span style="color: #553000">allowedSecretSayList</span>) {
     *     ... = allowedSecretSay.<span style="color: #CC4747">getVillageSettingsList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setAllowedSecretSayCode_InScope(pkList);
     * cb.query().addOrderBy_AllowedSecretSayCode_Asc();
     * </pre>
     * @param allowedSecretSayList The entity list of allowedSecretSay. (NotNull)
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerListGateway<VillageSettings> loadVillageSettings(List<AllowedSecretSay> allowedSecretSayList, ReferrerConditionSetupper<VillageSettingsCB> refCBLambda) {
        xassLRArg(allowedSecretSayList, refCBLambda);
        return doLoadVillageSettings(allowedSecretSayList, new LoadReferrerOption<VillageSettingsCB, VillageSettings>().xinit(refCBLambda));
    }

    /**
     * Load referrer of villageSettingsList by the set-upper of referrer. <br>
     * VILLAGE_SETTINGS by ALLOWED_SECRET_SAY_CODE, named 'villageSettingsList'.
     * <pre>
     * <span style="color: #0000C0">allowedSecretSayBhv</span>.<span style="color: #CC4747">loadVillageSettings</span>(<span style="color: #553000">allowedSecretSay</span>, <span style="color: #553000">settingsCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">settingsCB</span>.setupSelect...
     *     <span style="color: #553000">settingsCB</span>.query().set...
     *     <span style="color: #553000">settingsCB</span>.query().addOrderBy...
     * }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     * <span style="color: #3F7E5E">//}).withNestedReferrer(referrerList -&gt; {</span>
     * <span style="color: #3F7E5E">//    ...</span>
     * <span style="color: #3F7E5E">//});</span>
     * ... = <span style="color: #553000">allowedSecretSay</span>.<span style="color: #CC4747">getVillageSettingsList()</span>;
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setAllowedSecretSayCode_InScope(pkList);
     * cb.query().addOrderBy_AllowedSecretSayCode_Asc();
     * </pre>
     * @param allowedSecretSay The entity of allowedSecretSay. (NotNull)
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerListGateway<VillageSettings> loadVillageSettings(AllowedSecretSay allowedSecretSay, ReferrerConditionSetupper<VillageSettingsCB> refCBLambda) {
        xassLRArg(allowedSecretSay, refCBLambda);
        return doLoadVillageSettings(xnewLRLs(allowedSecretSay), new LoadReferrerOption<VillageSettingsCB, VillageSettings>().xinit(refCBLambda));
    }

    protected NestedReferrerListGateway<VillageSettings> doLoadVillageSettings(List<AllowedSecretSay> allowedSecretSayList, LoadReferrerOption<VillageSettingsCB, VillageSettings> option) {
        return helpLoadReferrerInternally(allowedSecretSayList, option, "villageSettingsList");
    }

    // ===================================================================================
    //                                                                   Pull out Relation
    //                                                                   =================
    // ===================================================================================
    //                                                                      Extract Column
    //                                                                      ==============
    /**
     * Extract the value list of (single) primary key allowedSecretSayCode.
     * @param allowedSecretSayList The list of allowedSecretSay. (NotNull, EmptyAllowed)
     * @return The list of the column value. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<String> extractAllowedSecretSayCodeList(List<AllowedSecretSay> allowedSecretSayList)
    { return helpExtractListInternally(allowedSecretSayList, "allowedSecretSayCode"); }

    // ===================================================================================
    //                                                                       Entity Update
    //                                                                       =============
    /**
     * Insert the entity modified-only. (DefaultConstraintsEnabled)
     * <pre>
     * AllowedSecretSay allowedSecretSay = <span style="color: #70226C">new</span> AllowedSecretSay();
     * <span style="color: #3F7E5E">// if auto-increment, you don't need to set the PK value</span>
     * allowedSecretSay.setFoo...(value);
     * allowedSecretSay.setBar...(value);
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//allowedSecretSay.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//allowedSecretSay.set...;</span>
     * <span style="color: #0000C0">allowedSecretSayBhv</span>.<span style="color: #CC4747">insert</span>(allowedSecretSay);
     * ... = allowedSecretSay.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * <p>While, when the entity is created by select, all columns are registered.</p>
     * @param allowedSecretSay The entity of insert. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @throws EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insert(AllowedSecretSay allowedSecretSay) {
        doInsert(allowedSecretSay, null);
    }

    /**
     * Update the entity modified-only. (ZeroUpdateException, NonExclusiveControl) <br>
     * By PK as default, and also you can update by unique keys using entity's uniqueOf().
     * <pre>
     * AllowedSecretSay allowedSecretSay = <span style="color: #70226C">new</span> AllowedSecretSay();
     * allowedSecretSay.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * allowedSecretSay.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//allowedSecretSay.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//allowedSecretSay.set...;</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of concurrency column is required</span>
     * allowedSecretSay.<span style="color: #CC4747">setVersionNo</span>(value);
     * <span style="color: #0000C0">allowedSecretSayBhv</span>.<span style="color: #CC4747">update</span>(allowedSecretSay);
     * </pre>
     * @param allowedSecretSay The entity of update. (NotNull, PrimaryKeyNotNull)
     * @throws EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @throws EntityDuplicatedException When the entity has been duplicated.
     * @throws EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void update(AllowedSecretSay allowedSecretSay) {
        doUpdate(allowedSecretSay, null);
    }

    /**
     * Insert or update the entity modified-only. (DefaultConstraintsEnabled, NonExclusiveControl) <br>
     * if (the entity has no PK) { insert() } else { update(), but no data, insert() } <br>
     * <p><span style="color: #994747; font-size: 120%">Also you can update by unique keys using entity's uniqueOf().</span></p>
     * @param allowedSecretSay The entity of insert or update. (NotNull, ...depends on insert or update)
     * @throws EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @throws EntityDuplicatedException When the entity has been duplicated.
     * @throws EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insertOrUpdate(AllowedSecretSay allowedSecretSay) {
        doInsertOrUpdate(allowedSecretSay, null, null);
    }

    /**
     * Delete the entity. (ZeroUpdateException, NonExclusiveControl) <br>
     * By PK as default, and also you can delete by unique keys using entity's uniqueOf().
     * <pre>
     * AllowedSecretSay allowedSecretSay = <span style="color: #70226C">new</span> AllowedSecretSay();
     * allowedSecretSay.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of concurrency column is required</span>
     * allowedSecretSay.<span style="color: #CC4747">setVersionNo</span>(value);
     * <span style="color: #70226C">try</span> {
     *     <span style="color: #0000C0">allowedSecretSayBhv</span>.<span style="color: #CC4747">delete</span>(allowedSecretSay);
     * } <span style="color: #70226C">catch</span> (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param allowedSecretSay The entity of delete. (NotNull, PrimaryKeyNotNull)
     * @throws EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @throws EntityDuplicatedException When the entity has been duplicated.
     */
    public void delete(AllowedSecretSay allowedSecretSay) {
        doDelete(allowedSecretSay, null);
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
     *     AllowedSecretSay allowedSecretSay = <span style="color: #70226C">new</span> AllowedSecretSay();
     *     allowedSecretSay.setFooName("foo");
     *     <span style="color: #70226C">if</span> (...) {
     *         allowedSecretSay.setFooPrice(123);
     *     }
     *     <span style="color: #3F7E5E">// FOO_NAME and FOO_PRICE (and record meta columns) are registered</span>
     *     <span style="color: #3F7E5E">// FOO_PRICE not-called in any entities are registered as null without default value</span>
     *     <span style="color: #3F7E5E">// columns not-called in all entities are registered as null or default value</span>
     *     allowedSecretSayList.add(allowedSecretSay);
     * }
     * <span style="color: #0000C0">allowedSecretSayBhv</span>.<span style="color: #CC4747">batchInsert</span>(allowedSecretSayList);
     * </pre>
     * <p>While, when the entities are created by select, all columns are registered.</p>
     * <p>And if the table has an identity, entities after the process don't have incremented values.
     * (When you use the (normal) insert(), you can get the incremented value from your entity)</p>
     * @param allowedSecretSayList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNullAllowed: when auto-increment)
     * @return The array of inserted count. (NotNull, EmptyAllowed)
     */
    public int[] batchInsert(List<AllowedSecretSay> allowedSecretSayList) {
        return doBatchInsert(allowedSecretSayList, null);
    }

    /**
     * Batch-update the entity list modified-only of same-set columns. (NonExclusiveControl) <br>
     * This method uses executeBatch() of java.sql.PreparedStatement. <br>
     * <span style="color: #CC4747; font-size: 120%">You should specify same-set columns to all entities like this:</span>
     * <pre>
     * for (... : ...) {
     *     AllowedSecretSay allowedSecretSay = <span style="color: #70226C">new</span> AllowedSecretSay();
     *     allowedSecretSay.setFooName("foo");
     *     <span style="color: #70226C">if</span> (...) {
     *         allowedSecretSay.setFooPrice(123);
     *     } <span style="color: #70226C">else</span> {
     *         allowedSecretSay.setFooPrice(null); <span style="color: #3F7E5E">// updated as null</span>
     *         <span style="color: #3F7E5E">//allowedSecretSay.setFooDate(...); // *not allowed, fragmented</span>
     *     }
     *     <span style="color: #3F7E5E">// FOO_NAME and FOO_PRICE (and record meta columns) are updated</span>
     *     <span style="color: #3F7E5E">// (others are not updated: their values are kept)</span>
     *     allowedSecretSayList.add(allowedSecretSay);
     * }
     * <span style="color: #0000C0">allowedSecretSayBhv</span>.<span style="color: #CC4747">batchUpdate</span>(allowedSecretSayList);
     * </pre>
     * @param allowedSecretSayList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @throws EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchUpdate(List<AllowedSecretSay> allowedSecretSayList) {
        return doBatchUpdate(allowedSecretSayList, null);
    }

    /**
     * Batch-delete the entity list. (NonExclusiveControl) <br>
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * @param allowedSecretSayList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     * @throws EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchDelete(List<AllowedSecretSay> allowedSecretSayList) {
        return doBatchDelete(allowedSecretSayList, null);
    }

    // ===================================================================================
    //                                                                        Query Update
    //                                                                        ============
    /**
     * Insert the several entities by query (modified-only for fixed value).
     * <pre>
     * <span style="color: #0000C0">allowedSecretSayBhv</span>.<span style="color: #CC4747">queryInsert</span>(new QueryInsertSetupper&lt;AllowedSecretSay, AllowedSecretSayCB&gt;() {
     *     public ConditionBean setup(AllowedSecretSay entity, AllowedSecretSayCB intoCB) {
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
    public int queryInsert(QueryInsertSetupper<AllowedSecretSay, AllowedSecretSayCB> manyArgLambda) {
        return doQueryInsert(manyArgLambda, null);
    }

    /**
     * Update the several entities by query non-strictly modified-only. (NonExclusiveControl)
     * <pre>
     * AllowedSecretSay allowedSecretSay = <span style="color: #70226C">new</span> AllowedSecretSay();
     * <span style="color: #3F7E5E">// you don't need to set PK value</span>
     * <span style="color: #3F7E5E">//allowedSecretSay.setPK...(value);</span>
     * allowedSecretSay.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//allowedSecretSay.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//allowedSecretSay.set...;</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of concurrency column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//allowedSecretSay.setVersionNo(value);</span>
     * <span style="color: #0000C0">allowedSecretSayBhv</span>.<span style="color: #CC4747">queryUpdate</span>(allowedSecretSay, <span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">cb</span>.query().setFoo...
     * });
     * </pre>
     * @param allowedSecretSay The entity that contains update values. (NotNull, PrimaryKeyNullAllowed)
     * @param cbLambda The callback for condition-bean of AllowedSecretSay. (NotNull)
     * @return The updated count.
     * @throws NonQueryUpdateNotAllowedException When the query has no condition.
     */
    public int queryUpdate(AllowedSecretSay allowedSecretSay, CBCall<AllowedSecretSayCB> cbLambda) {
        return doQueryUpdate(allowedSecretSay, createCB(cbLambda), null);
    }

    /**
     * Delete the several entities by query. (NonExclusiveControl)
     * <pre>
     * <span style="color: #0000C0">allowedSecretSayBhv</span>.<span style="color: #CC4747">queryDelete</span>(allowedSecretSay, <span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">cb</span>.query().setFoo...
     * });
     * </pre>
     * @param cbLambda The callback for condition-bean of AllowedSecretSay. (NotNull)
     * @return The deleted count.
     * @throws NonQueryDeleteNotAllowedException When the query has no condition.
     */
    public int queryDelete(CBCall<AllowedSecretSayCB> cbLambda) {
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
     * AllowedSecretSay allowedSecretSay = <span style="color: #70226C">new</span> AllowedSecretSay();
     * <span style="color: #3F7E5E">// if auto-increment, you don't need to set the PK value</span>
     * allowedSecretSay.setFoo...(value);
     * allowedSecretSay.setBar...(value);
     * <span style="color: #0000C0">allowedSecretSayBhv</span>.<span style="color: #CC4747">varyingInsert</span>(allowedSecretSay, <span style="color: #553000">op</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #3F7E5E">// you can insert by your values for common columns</span>
     *     <span style="color: #553000">op</span>.disableCommonColumnAutoSetup();
     * });
     * ... = allowedSecretSay.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * @param allowedSecretSay The entity of insert. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @param opLambda The callback for option of insert for varying requests. (NotNull)
     * @throws EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsert(AllowedSecretSay allowedSecretSay, WritableOptionCall<AllowedSecretSayCB, InsertOption<AllowedSecretSayCB>> opLambda) {
        doInsert(allowedSecretSay, createInsertOption(opLambda));
    }

    /**
     * Update the entity with varying requests modified-only. (ZeroUpdateException, NonExclusiveControl) <br>
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification), disableCommonColumnAutoSetup(). <br>
     * Other specifications are same as update(entity).
     * <pre>
     * AllowedSecretSay allowedSecretSay = <span style="color: #70226C">new</span> AllowedSecretSay();
     * allowedSecretSay.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * allowedSecretSay.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of concurrency column is required</span>
     * allowedSecretSay.<span style="color: #CC4747">setVersionNo</span>(value);
     * <span style="color: #3F7E5E">// you can update by self calculation values</span>
     * <span style="color: #0000C0">allowedSecretSayBhv</span>.<span style="color: #CC4747">varyingUpdate</span>(allowedSecretSay, <span style="color: #553000">op</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">op</span>.self(<span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *         <span style="color: #553000">cb</span>.specify().<span style="color: #CC4747">columnXxxCount()</span>;
     *     }).plus(1); <span style="color: #3F7E5E">// XXX_COUNT = XXX_COUNT + 1</span>
     * });
     * </pre>
     * @param allowedSecretSay The entity of update. (NotNull, PrimaryKeyNotNull)
     * @param opLambda The callback for option of update for varying requests. (NotNull)
     * @throws EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @throws EntityDuplicatedException When the entity has been duplicated.
     * @throws EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingUpdate(AllowedSecretSay allowedSecretSay, WritableOptionCall<AllowedSecretSayCB, UpdateOption<AllowedSecretSayCB>> opLambda) {
        doUpdate(allowedSecretSay, createUpdateOption(opLambda));
    }

    /**
     * Insert or update the entity with varying requests. (ExclusiveControl: when update) <br>
     * Other specifications are same as insertOrUpdate(entity).
     * @param allowedSecretSay The entity of insert or update. (NotNull)
     * @param insertOpLambda The callback for option of insert for varying requests. (NotNull)
     * @param updateOpLambda The callback for option of update for varying requests. (NotNull)
     * @throws EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @throws EntityDuplicatedException When the entity has been duplicated.
     * @throws EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsertOrUpdate(AllowedSecretSay allowedSecretSay, WritableOptionCall<AllowedSecretSayCB, InsertOption<AllowedSecretSayCB>> insertOpLambda, WritableOptionCall<AllowedSecretSayCB, UpdateOption<AllowedSecretSayCB>> updateOpLambda) {
        doInsertOrUpdate(allowedSecretSay, createInsertOption(insertOpLambda), createUpdateOption(updateOpLambda));
    }

    /**
     * Delete the entity with varying requests. (ZeroUpdateException, NonExclusiveControl) <br>
     * Now a valid option does not exist. <br>
     * Other specifications are same as delete(entity).
     * @param allowedSecretSay The entity of delete. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnNotNull)
     * @param opLambda The callback for option of delete for varying requests. (NotNull)
     * @throws EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @throws EntityDuplicatedException When the entity has been duplicated.
     */
    public void varyingDelete(AllowedSecretSay allowedSecretSay, WritableOptionCall<AllowedSecretSayCB, DeleteOption<AllowedSecretSayCB>> opLambda) {
        doDelete(allowedSecretSay, createDeleteOption(opLambda));
    }

    // -----------------------------------------------------
    //                                          Batch Update
    //                                          ------------
    /**
     * Batch-insert the list with varying requests. <br>
     * For example, disableCommonColumnAutoSetup()
     * , disablePrimaryKeyIdentity(), limitBatchInsertLogging(). <br>
     * Other specifications are same as batchInsert(entityList).
     * @param allowedSecretSayList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param opLambda The callback for option of insert for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchInsert(List<AllowedSecretSay> allowedSecretSayList, WritableOptionCall<AllowedSecretSayCB, InsertOption<AllowedSecretSayCB>> opLambda) {
        return doBatchInsert(allowedSecretSayList, createInsertOption(opLambda));
    }

    /**
     * Batch-update the list with varying requests. <br>
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification)
     * , disableCommonColumnAutoSetup(), limitBatchUpdateLogging(). <br>
     * Other specifications are same as batchUpdate(entityList).
     * @param allowedSecretSayList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param opLambda The callback for option of update for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchUpdate(List<AllowedSecretSay> allowedSecretSayList, WritableOptionCall<AllowedSecretSayCB, UpdateOption<AllowedSecretSayCB>> opLambda) {
        return doBatchUpdate(allowedSecretSayList, createUpdateOption(opLambda));
    }

    /**
     * Batch-delete the list with varying requests. <br>
     * For example, limitBatchDeleteLogging(). <br>
     * Other specifications are same as batchDelete(entityList).
     * @param allowedSecretSayList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param opLambda The callback for option of delete for varying requests. (NotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchDelete(List<AllowedSecretSay> allowedSecretSayList, WritableOptionCall<AllowedSecretSayCB, DeleteOption<AllowedSecretSayCB>> opLambda) {
        return doBatchDelete(allowedSecretSayList, createDeleteOption(opLambda));
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
    public int varyingQueryInsert(QueryInsertSetupper<AllowedSecretSay, AllowedSecretSayCB> manyArgLambda, WritableOptionCall<AllowedSecretSayCB, InsertOption<AllowedSecretSayCB>> opLambda) {
        return doQueryInsert(manyArgLambda, createInsertOption(opLambda));
    }

    /**
     * Update the several entities by query with varying requests non-strictly modified-only. {NonExclusiveControl} <br>
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification)
     * , disableCommonColumnAutoSetup(), allowNonQueryUpdate(). <br>
     * Other specifications are same as queryUpdate(entity, cb).
     * <pre>
     * <span style="color: #3F7E5E">// ex) you can update by self calculation values</span>
     * AllowedSecretSay allowedSecretSay = <span style="color: #70226C">new</span> AllowedSecretSay();
     * <span style="color: #3F7E5E">// you don't need to set PK value</span>
     * <span style="color: #3F7E5E">//allowedSecretSay.setPK...(value);</span>
     * allowedSecretSay.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of concurrency column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//allowedSecretSay.setVersionNo(value);</span>
     * <span style="color: #0000C0">allowedSecretSayBhv</span>.<span style="color: #CC4747">varyingQueryUpdate</span>(allowedSecretSay, <span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">cb</span>.query().setFoo...
     * }, <span style="color: #553000">op</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">op</span>.self(<span style="color: #553000">colCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *         <span style="color: #553000">colCB</span>.specify().<span style="color: #CC4747">columnFooCount()</span>;
     *     }).plus(1); <span style="color: #3F7E5E">// FOO_COUNT = FOO_COUNT + 1</span>
     * });
     * </pre>
     * @param allowedSecretSay The entity that contains update values. (NotNull) {PrimaryKeyNotRequired}
     * @param cbLambda The callback for condition-bean of AllowedSecretSay. (NotNull)
     * @param opLambda The callback for option of update for varying requests. (NotNull)
     * @return The updated count.
     * @throws NonQueryUpdateNotAllowedException When the query has no condition (if not allowed).
     */
    public int varyingQueryUpdate(AllowedSecretSay allowedSecretSay, CBCall<AllowedSecretSayCB> cbLambda, WritableOptionCall<AllowedSecretSayCB, UpdateOption<AllowedSecretSayCB>> opLambda) {
        return doQueryUpdate(allowedSecretSay, createCB(cbLambda), createUpdateOption(opLambda));
    }

    /**
     * Delete the several entities by query with varying requests non-strictly. <br>
     * For example, allowNonQueryDelete(). <br>
     * Other specifications are same as queryDelete(cb).
     * <pre>
     * <span style="color: #0000C0">allowedSecretSayBhv</span>.<span style="color: #CC4747">queryDelete</span>(allowedSecretSay, <span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">cb</span>.query().setFoo...
     * }, <span style="color: #553000">op</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">op</span>...
     * });
     * </pre>
     * @param cbLambda The callback for condition-bean of AllowedSecretSay. (NotNull)
     * @param opLambda The callback for option of delete for varying requests. (NotNull)
     * @return The deleted count.
     * @throws NonQueryDeleteNotAllowedException When the query has no condition (if not allowed).
     */
    public int varyingQueryDelete(CBCall<AllowedSecretSayCB> cbLambda, WritableOptionCall<AllowedSecretSayCB, DeleteOption<AllowedSecretSayCB>> opLambda) {
        return doQueryDelete(createCB(cbLambda), createDeleteOption(opLambda));
    }

    // ===================================================================================
    //                                                                          OutsideSql
    //                                                                          ==========
    /**
     * Prepare the all facade executor of outside-SQL to execute it.
     * <pre>
     * <span style="color: #3F7E5E">// main style</span> 
     * allowedSecretSayBhv.outideSql().selectEntity(pmb); <span style="color: #3F7E5E">// optional</span> 
     * allowedSecretSayBhv.outideSql().selectList(pmb); <span style="color: #3F7E5E">// ListResultBean</span>
     * allowedSecretSayBhv.outideSql().selectPage(pmb); <span style="color: #3F7E5E">// PagingResultBean</span>
     * allowedSecretSayBhv.outideSql().selectPagedListOnly(pmb); <span style="color: #3F7E5E">// ListResultBean</span>
     * allowedSecretSayBhv.outideSql().selectCursor(pmb, handler); <span style="color: #3F7E5E">// (by handler)</span>
     * allowedSecretSayBhv.outideSql().execute(pmb); <span style="color: #3F7E5E">// int (updated count)</span>
     * allowedSecretSayBhv.outideSql().call(pmb); <span style="color: #3F7E5E">// void (pmb has OUT parameters)</span>
     *
     * <span style="color: #3F7E5E">// traditional style</span> 
     * allowedSecretSayBhv.outideSql().traditionalStyle().selectEntity(path, pmb, entityType);
     * allowedSecretSayBhv.outideSql().traditionalStyle().selectList(path, pmb, entityType);
     * allowedSecretSayBhv.outideSql().traditionalStyle().selectPage(path, pmb, entityType);
     * allowedSecretSayBhv.outideSql().traditionalStyle().selectPagedListOnly(path, pmb, entityType);
     * allowedSecretSayBhv.outideSql().traditionalStyle().selectCursor(path, pmb, handler);
     * allowedSecretSayBhv.outideSql().traditionalStyle().execute(path, pmb);
     *
     * <span style="color: #3F7E5E">// options</span> 
     * allowedSecretSayBhv.outideSql().removeBlockComment().selectList()
     * allowedSecretSayBhv.outideSql().removeLineComment().selectList()
     * allowedSecretSayBhv.outideSql().formatSql().selectList()
     * </pre>
     * <p>The invoker of behavior command should be not null when you call this method.</p>
     * @return The new-created all facade executor of outside-SQL. (NotNull)
     */
    public OutsideSqlAllFacadeExecutor<AllowedSecretSayBhv> outsideSql() {
        return doOutsideSql();
    }

    // ===================================================================================
    //                                                                         Type Helper
    //                                                                         ===========
    protected Class<? extends AllowedSecretSay> typeOfSelectedEntity() { return AllowedSecretSay.class; }
    protected Class<AllowedSecretSay> typeOfHandlingEntity() { return AllowedSecretSay.class; }
    protected Class<AllowedSecretSayCB> typeOfHandlingConditionBean() { return AllowedSecretSayCB.class; }

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
