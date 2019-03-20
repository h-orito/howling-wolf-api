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
 * The behavior of SKILL as TABLE. <br>
 * <pre>
 * [primary key]
 *     SKILL_CODE
 *
 * [column]
 *     SKILL_CODE, SKILL_NAME, CAMP_CODE, DISP_ORDER
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
 *     CAMP
 *
 * [referrer table]
 *     MESSAGE_RESTRICTION, VILLAGE_PLAYER
 *
 * [foreign property]
 *     camp
 *
 * [referrer property]
 *     messageRestrictionList, villagePlayerByRequestSkillCodeList, villagePlayerBySecondRequestSkillCodeList, villagePlayerBySkillCodeList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsSkillBhv extends AbstractBehaviorWritable<Skill, SkillCB> {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /*df:beginQueryPath*/
    /*df:endQueryPath*/

    // ===================================================================================
    //                                                                             DB Meta
    //                                                                             =======
    /** {@inheritDoc} */
    public SkillDbm asDBMeta() { return SkillDbm.getInstance(); }
    /** {@inheritDoc} */
    public String asTableDbName() { return "skill"; }

    // ===================================================================================
    //                                                                        New Instance
    //                                                                        ============
    /** {@inheritDoc} */
    public SkillCB newConditionBean() { return new SkillCB(); }

    // ===================================================================================
    //                                                                        Count Select
    //                                                                        ============
    /**
     * Select the count of uniquely-selected records by the condition-bean. {IgnorePagingCondition, IgnoreSpecifyColumn}<br>
     * SpecifyColumn is ignored but you can use it only to remove text type column for union's distinct.
     * <pre>
     * <span style="color: #70226C">int</span> count = <span style="color: #0000C0">skillBhv</span>.<span style="color: #CC4747">selectCount</span>(<span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">cb</span>.query().set...
     * });
     * </pre>
     * @param cbLambda The callback for condition-bean of Skill. (NotNull)
     * @return The count for the condition. (NotMinus)
     */
    public int selectCount(CBCall<SkillCB> cbLambda) {
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
     * <span style="color: #0000C0">skillBhv</span>.<span style="color: #CC4747">selectEntity</span>(<span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">cb</span>.query().set...
     * }).<span style="color: #CC4747">alwaysPresent</span>(<span style="color: #553000">skill</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #3F7E5E">// called if present, or exception</span>
     *     ... = <span style="color: #553000">skill</span>.get...
     * });
     * 
     * <span style="color: #3F7E5E">// if it might be no data, ...</span>
     * <span style="color: #0000C0">skillBhv</span>.<span style="color: #CC4747">selectEntity</span>(<span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">cb</span>.query().set...
     * }).<span style="color: #CC4747">ifPresent</span>(<span style="color: #553000">skill</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #3F7E5E">// called if present</span>
     *     ... = <span style="color: #553000">skill</span>.get...
     * }).<span style="color: #994747">orElse</span>(() <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #3F7E5E">// called if not present</span>
     * });
     * </pre>
     * @param cbLambda The callback for condition-bean of Skill. (NotNull)
     * @return The optional entity selected by the condition. (NotNull: if no data, empty entity)
     * @throws EntityAlreadyDeletedException When get(), required() of return value is called and the value is null, which means entity has already been deleted (not found).
     * @throws EntityDuplicatedException When the entity has been duplicated.
     * @throws SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public OptionalEntity<Skill> selectEntity(CBCall<SkillCB> cbLambda) {
        return facadeSelectEntity(createCB(cbLambda));
    }

    protected OptionalEntity<Skill> facadeSelectEntity(SkillCB cb) {
        return doSelectOptionalEntity(cb, typeOfSelectedEntity());
    }

    protected <ENTITY extends Skill> OptionalEntity<ENTITY> doSelectOptionalEntity(SkillCB cb, Class<? extends ENTITY> tp) {
        return createOptionalEntity(doSelectEntity(cb, tp), cb);
    }

    protected Entity doReadEntity(ConditionBean cb) { return facadeSelectEntity(downcast(cb)).orElse(null); }

    /**
     * Select the entity by the condition-bean with deleted check. <br>
     * <span style="color: #AD4747; font-size: 120%">If the data is always present as your business rule, this method is good.</span>
     * <pre>
     * Skill <span style="color: #553000">skill</span> = <span style="color: #0000C0">skillBhv</span>.<span style="color: #CC4747">selectEntityWithDeletedCheck</span>(cb <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> cb.acceptPK(1));
     * ... = <span style="color: #553000">skill</span>.get...(); <span style="color: #3F7E5E">// the entity always be not null</span>
     * </pre>
     * @param cbLambda The callback for condition-bean of Skill. (NotNull)
     * @return The entity selected by the condition. (NotNull: if no data, throws exception)
     * @throws EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @throws EntityDuplicatedException When the entity has been duplicated.
     * @throws SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public Skill selectEntityWithDeletedCheck(CBCall<SkillCB> cbLambda) {
        return facadeSelectEntityWithDeletedCheck(createCB(cbLambda));
    }

    /**
     * Select the entity by the primary-key value.
     * @param skillCode : PK, NotNull, VARCHAR(20), classification=Skill. (NotNull)
     * @return The optional entity selected by the PK. (NotNull: if no data, empty entity)
     * @throws EntityAlreadyDeletedException When get(), required() of return value is called and the value is null, which means entity has already been deleted (not found).
     * @throws EntityDuplicatedException When the entity has been duplicated.
     * @throws SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public OptionalEntity<Skill> selectByPK(CDef.Skill skillCode) {
        return facadeSelectByPK(skillCode);
    }

    protected OptionalEntity<Skill> facadeSelectByPK(CDef.Skill skillCode) {
        return doSelectOptionalByPK(skillCode, typeOfSelectedEntity());
    }

    protected <ENTITY extends Skill> ENTITY doSelectByPK(CDef.Skill skillCode, Class<? extends ENTITY> tp) {
        return doSelectEntity(xprepareCBAsPK(skillCode), tp);
    }

    protected <ENTITY extends Skill> OptionalEntity<ENTITY> doSelectOptionalByPK(CDef.Skill skillCode, Class<? extends ENTITY> tp) {
        return createOptionalEntity(doSelectByPK(skillCode, tp), skillCode);
    }

    protected SkillCB xprepareCBAsPK(CDef.Skill skillCode) {
        assertObjectNotNull("skillCode", skillCode);
        return newConditionBean().acceptPK(skillCode);
    }

    // ===================================================================================
    //                                                                         List Select
    //                                                                         ===========
    /**
     * Select the list as result bean.
     * <pre>
     * ListResultBean&lt;Skill&gt; <span style="color: #553000">skillList</span> = <span style="color: #0000C0">skillBhv</span>.<span style="color: #CC4747">selectList</span>(<span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">cb</span>.query().set...;
     *     <span style="color: #553000">cb</span>.query().addOrderBy...;
     * });
     * <span style="color: #70226C">for</span> (Skill <span style="color: #553000">skill</span> : <span style="color: #553000">skillList</span>) {
     *     ... = <span style="color: #553000">skill</span>.get...;
     * }
     * </pre>
     * @param cbLambda The callback for condition-bean of Skill. (NotNull)
     * @return The result bean of selected list. (NotNull: if no data, returns empty list)
     * @throws DangerousResultSizeException When the result size is over the specified safety size.
     */
    public ListResultBean<Skill> selectList(CBCall<SkillCB> cbLambda) {
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
     * PagingResultBean&lt;Skill&gt; <span style="color: #553000">page</span> = <span style="color: #0000C0">skillBhv</span>.<span style="color: #CC4747">selectPage</span>(<span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">cb</span>.query().set...
     *     <span style="color: #553000">cb</span>.query().addOrderBy...
     *     <span style="color: #553000">cb</span>.<span style="color: #CC4747">paging</span>(20, 3); <span style="color: #3F7E5E">// 20 records per a page and current page number is 3</span>
     * });
     * <span style="color: #70226C">int</span> allRecordCount = <span style="color: #553000">page</span>.getAllRecordCount();
     * <span style="color: #70226C">int</span> allPageCount = <span style="color: #553000">page</span>.getAllPageCount();
     * <span style="color: #70226C">boolean</span> isExistPrePage = <span style="color: #553000">page</span>.isExistPrePage();
     * <span style="color: #70226C">boolean</span> isExistNextPage = <span style="color: #553000">page</span>.isExistNextPage();
     * ...
     * <span style="color: #70226C">for</span> (Skill skill : <span style="color: #553000">page</span>) {
     *     ... = skill.get...;
     * }
     * </pre>
     * @param cbLambda The callback for condition-bean of Skill. (NotNull)
     * @return The result bean of selected page. (NotNull: if no data, returns bean as empty list)
     * @throws DangerousResultSizeException When the result size is over the specified safety size.
     */
    public PagingResultBean<Skill> selectPage(CBCall<SkillCB> cbLambda) {
        return facadeSelectPage(createCB(cbLambda));
    }

    // ===================================================================================
    //                                                                       Cursor Select
    //                                                                       =============
    /**
     * Select the cursor by the condition-bean.
     * <pre>
     * <span style="color: #0000C0">skillBhv</span>.<span style="color: #CC4747">selectCursor</span>(<span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">cb</span>.query().set...
     * }, <span style="color: #553000">member</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     ... = <span style="color: #553000">member</span>.getMemberName();
     * });
     * </pre>
     * @param cbLambda The callback for condition-bean of Skill. (NotNull)
     * @param entityLambda The handler of entity row of Skill. (NotNull)
     */
    public void selectCursor(CBCall<SkillCB> cbLambda, EntityRowHandler<Skill> entityLambda) {
        facadeSelectCursor(createCB(cbLambda), entityLambda);
    }

    // ===================================================================================
    //                                                                       Scalar Select
    //                                                                       =============
    /**
     * Select the scalar value derived by a function from uniquely-selected records. <br>
     * You should call a function method after this method called like as follows:
     * <pre>
     * <span style="color: #0000C0">skillBhv</span>.<span style="color: #CC4747">selectScalar</span>(Date.class).max(<span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">cb</span>.specify().<span style="color: #CC4747">column...</span>; <span style="color: #3F7E5E">// required for the function</span>
     *     <span style="color: #553000">cb</span>.query().set...
     * });
     * </pre>
     * @param <RESULT> The type of result.
     * @param resultType The type of result. (NotNull)
     * @return The scalar function object to specify function for scalar value. (NotNull)
     */
    public <RESULT> HpSLSFunction<SkillCB, RESULT> selectScalar(Class<RESULT> resultType) {
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
     * @param skillList The entity list of skill. (NotNull)
     * @param loaderLambda The callback to handle the referrer loader for actually loading referrer. (NotNull)
     */
    public void load(List<Skill> skillList, ReferrerLoaderHandler<LoaderOfSkill> loaderLambda) {
        xassLRArg(skillList, loaderLambda);
        loaderLambda.handle(new LoaderOfSkill().ready(skillList, _behaviorSelector));
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
     * @param skill The entity of skill. (NotNull)
     * @param loaderLambda The callback to handle the referrer loader for actually loading referrer. (NotNull)
     */
    public void load(Skill skill, ReferrerLoaderHandler<LoaderOfSkill> loaderLambda) {
        xassLRArg(skill, loaderLambda);
        loaderLambda.handle(new LoaderOfSkill().ready(xnewLRAryLs(skill), _behaviorSelector));
    }

    /**
     * Load referrer of messageRestrictionList by the set-upper of referrer. <br>
     * MESSAGE_RESTRICTION by SKILL_CODE, named 'messageRestrictionList'.
     * <pre>
     * <span style="color: #0000C0">skillBhv</span>.<span style="color: #CC4747">loadMessageRestriction</span>(<span style="color: #553000">skillList</span>, <span style="color: #553000">restrictionCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">restrictionCB</span>.setupSelect...
     *     <span style="color: #553000">restrictionCB</span>.query().set...
     *     <span style="color: #553000">restrictionCB</span>.query().addOrderBy...
     * }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     * <span style="color: #3F7E5E">//}).withNestedReferrer(referrerList -&gt; {</span>
     * <span style="color: #3F7E5E">//    ...</span>
     * <span style="color: #3F7E5E">//});</span>
     * <span style="color: #70226C">for</span> (Skill skill : <span style="color: #553000">skillList</span>) {
     *     ... = skill.<span style="color: #CC4747">getMessageRestrictionList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setSkillCode_InScope(pkList);
     * cb.query().addOrderBy_SkillCode_Asc();
     * </pre>
     * @param skillList The entity list of skill. (NotNull)
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerListGateway<MessageRestriction> loadMessageRestriction(List<Skill> skillList, ReferrerConditionSetupper<MessageRestrictionCB> refCBLambda) {
        xassLRArg(skillList, refCBLambda);
        return doLoadMessageRestriction(skillList, new LoadReferrerOption<MessageRestrictionCB, MessageRestriction>().xinit(refCBLambda));
    }

    /**
     * Load referrer of messageRestrictionList by the set-upper of referrer. <br>
     * MESSAGE_RESTRICTION by SKILL_CODE, named 'messageRestrictionList'.
     * <pre>
     * <span style="color: #0000C0">skillBhv</span>.<span style="color: #CC4747">loadMessageRestriction</span>(<span style="color: #553000">skill</span>, <span style="color: #553000">restrictionCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">restrictionCB</span>.setupSelect...
     *     <span style="color: #553000">restrictionCB</span>.query().set...
     *     <span style="color: #553000">restrictionCB</span>.query().addOrderBy...
     * }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     * <span style="color: #3F7E5E">//}).withNestedReferrer(referrerList -&gt; {</span>
     * <span style="color: #3F7E5E">//    ...</span>
     * <span style="color: #3F7E5E">//});</span>
     * ... = <span style="color: #553000">skill</span>.<span style="color: #CC4747">getMessageRestrictionList()</span>;
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setSkillCode_InScope(pkList);
     * cb.query().addOrderBy_SkillCode_Asc();
     * </pre>
     * @param skill The entity of skill. (NotNull)
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerListGateway<MessageRestriction> loadMessageRestriction(Skill skill, ReferrerConditionSetupper<MessageRestrictionCB> refCBLambda) {
        xassLRArg(skill, refCBLambda);
        return doLoadMessageRestriction(xnewLRLs(skill), new LoadReferrerOption<MessageRestrictionCB, MessageRestriction>().xinit(refCBLambda));
    }

    protected NestedReferrerListGateway<MessageRestriction> doLoadMessageRestriction(List<Skill> skillList, LoadReferrerOption<MessageRestrictionCB, MessageRestriction> option) {
        return helpLoadReferrerInternally(skillList, option, "messageRestrictionList");
    }

    /**
     * Load referrer of villagePlayerByRequestSkillCodeList by the set-upper of referrer. <br>
     * VILLAGE_PLAYER by REQUEST_SKILL_CODE, named 'villagePlayerByRequestSkillCodeList'.
     * <pre>
     * <span style="color: #0000C0">skillBhv</span>.<span style="color: #CC4747">loadVillagePlayerByRequestSkillCode</span>(<span style="color: #553000">skillList</span>, <span style="color: #553000">playerCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">playerCB</span>.setupSelect...
     *     <span style="color: #553000">playerCB</span>.query().set...
     *     <span style="color: #553000">playerCB</span>.query().addOrderBy...
     * }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     * <span style="color: #3F7E5E">//}).withNestedReferrer(referrerList -&gt; {</span>
     * <span style="color: #3F7E5E">//    ...</span>
     * <span style="color: #3F7E5E">//});</span>
     * <span style="color: #70226C">for</span> (Skill skill : <span style="color: #553000">skillList</span>) {
     *     ... = skill.<span style="color: #CC4747">getVillagePlayerByRequestSkillCodeList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setRequestSkillCode_InScope(pkList);
     * cb.query().addOrderBy_RequestSkillCode_Asc();
     * </pre>
     * @param skillList The entity list of skill. (NotNull)
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerListGateway<VillagePlayer> loadVillagePlayerByRequestSkillCode(List<Skill> skillList, ReferrerConditionSetupper<VillagePlayerCB> refCBLambda) {
        xassLRArg(skillList, refCBLambda);
        return doLoadVillagePlayerByRequestSkillCode(skillList, new LoadReferrerOption<VillagePlayerCB, VillagePlayer>().xinit(refCBLambda));
    }

    /**
     * Load referrer of villagePlayerByRequestSkillCodeList by the set-upper of referrer. <br>
     * VILLAGE_PLAYER by REQUEST_SKILL_CODE, named 'villagePlayerByRequestSkillCodeList'.
     * <pre>
     * <span style="color: #0000C0">skillBhv</span>.<span style="color: #CC4747">loadVillagePlayerByRequestSkillCode</span>(<span style="color: #553000">skill</span>, <span style="color: #553000">playerCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">playerCB</span>.setupSelect...
     *     <span style="color: #553000">playerCB</span>.query().set...
     *     <span style="color: #553000">playerCB</span>.query().addOrderBy...
     * }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     * <span style="color: #3F7E5E">//}).withNestedReferrer(referrerList -&gt; {</span>
     * <span style="color: #3F7E5E">//    ...</span>
     * <span style="color: #3F7E5E">//});</span>
     * ... = <span style="color: #553000">skill</span>.<span style="color: #CC4747">getVillagePlayerByRequestSkillCodeList()</span>;
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setRequestSkillCode_InScope(pkList);
     * cb.query().addOrderBy_RequestSkillCode_Asc();
     * </pre>
     * @param skill The entity of skill. (NotNull)
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerListGateway<VillagePlayer> loadVillagePlayerByRequestSkillCode(Skill skill, ReferrerConditionSetupper<VillagePlayerCB> refCBLambda) {
        xassLRArg(skill, refCBLambda);
        return doLoadVillagePlayerByRequestSkillCode(xnewLRLs(skill), new LoadReferrerOption<VillagePlayerCB, VillagePlayer>().xinit(refCBLambda));
    }

    protected NestedReferrerListGateway<VillagePlayer> doLoadVillagePlayerByRequestSkillCode(List<Skill> skillList, LoadReferrerOption<VillagePlayerCB, VillagePlayer> option) {
        return helpLoadReferrerInternally(skillList, option, "villagePlayerByRequestSkillCodeList");
    }

    /**
     * Load referrer of villagePlayerBySecondRequestSkillCodeList by the set-upper of referrer. <br>
     * VILLAGE_PLAYER by SECOND_REQUEST_SKILL_CODE, named 'villagePlayerBySecondRequestSkillCodeList'.
     * <pre>
     * <span style="color: #0000C0">skillBhv</span>.<span style="color: #CC4747">loadVillagePlayerBySecondRequestSkillCode</span>(<span style="color: #553000">skillList</span>, <span style="color: #553000">playerCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">playerCB</span>.setupSelect...
     *     <span style="color: #553000">playerCB</span>.query().set...
     *     <span style="color: #553000">playerCB</span>.query().addOrderBy...
     * }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     * <span style="color: #3F7E5E">//}).withNestedReferrer(referrerList -&gt; {</span>
     * <span style="color: #3F7E5E">//    ...</span>
     * <span style="color: #3F7E5E">//});</span>
     * <span style="color: #70226C">for</span> (Skill skill : <span style="color: #553000">skillList</span>) {
     *     ... = skill.<span style="color: #CC4747">getVillagePlayerBySecondRequestSkillCodeList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setSecondRequestSkillCode_InScope(pkList);
     * cb.query().addOrderBy_SecondRequestSkillCode_Asc();
     * </pre>
     * @param skillList The entity list of skill. (NotNull)
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerListGateway<VillagePlayer> loadVillagePlayerBySecondRequestSkillCode(List<Skill> skillList, ReferrerConditionSetupper<VillagePlayerCB> refCBLambda) {
        xassLRArg(skillList, refCBLambda);
        return doLoadVillagePlayerBySecondRequestSkillCode(skillList, new LoadReferrerOption<VillagePlayerCB, VillagePlayer>().xinit(refCBLambda));
    }

    /**
     * Load referrer of villagePlayerBySecondRequestSkillCodeList by the set-upper of referrer. <br>
     * VILLAGE_PLAYER by SECOND_REQUEST_SKILL_CODE, named 'villagePlayerBySecondRequestSkillCodeList'.
     * <pre>
     * <span style="color: #0000C0">skillBhv</span>.<span style="color: #CC4747">loadVillagePlayerBySecondRequestSkillCode</span>(<span style="color: #553000">skill</span>, <span style="color: #553000">playerCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">playerCB</span>.setupSelect...
     *     <span style="color: #553000">playerCB</span>.query().set...
     *     <span style="color: #553000">playerCB</span>.query().addOrderBy...
     * }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     * <span style="color: #3F7E5E">//}).withNestedReferrer(referrerList -&gt; {</span>
     * <span style="color: #3F7E5E">//    ...</span>
     * <span style="color: #3F7E5E">//});</span>
     * ... = <span style="color: #553000">skill</span>.<span style="color: #CC4747">getVillagePlayerBySecondRequestSkillCodeList()</span>;
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setSecondRequestSkillCode_InScope(pkList);
     * cb.query().addOrderBy_SecondRequestSkillCode_Asc();
     * </pre>
     * @param skill The entity of skill. (NotNull)
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerListGateway<VillagePlayer> loadVillagePlayerBySecondRequestSkillCode(Skill skill, ReferrerConditionSetupper<VillagePlayerCB> refCBLambda) {
        xassLRArg(skill, refCBLambda);
        return doLoadVillagePlayerBySecondRequestSkillCode(xnewLRLs(skill), new LoadReferrerOption<VillagePlayerCB, VillagePlayer>().xinit(refCBLambda));
    }

    protected NestedReferrerListGateway<VillagePlayer> doLoadVillagePlayerBySecondRequestSkillCode(List<Skill> skillList, LoadReferrerOption<VillagePlayerCB, VillagePlayer> option) {
        return helpLoadReferrerInternally(skillList, option, "villagePlayerBySecondRequestSkillCodeList");
    }

    /**
     * Load referrer of villagePlayerBySkillCodeList by the set-upper of referrer. <br>
     * VILLAGE_PLAYER by SKILL_CODE, named 'villagePlayerBySkillCodeList'.
     * <pre>
     * <span style="color: #0000C0">skillBhv</span>.<span style="color: #CC4747">loadVillagePlayerBySkillCode</span>(<span style="color: #553000">skillList</span>, <span style="color: #553000">playerCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">playerCB</span>.setupSelect...
     *     <span style="color: #553000">playerCB</span>.query().set...
     *     <span style="color: #553000">playerCB</span>.query().addOrderBy...
     * }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     * <span style="color: #3F7E5E">//}).withNestedReferrer(referrerList -&gt; {</span>
     * <span style="color: #3F7E5E">//    ...</span>
     * <span style="color: #3F7E5E">//});</span>
     * <span style="color: #70226C">for</span> (Skill skill : <span style="color: #553000">skillList</span>) {
     *     ... = skill.<span style="color: #CC4747">getVillagePlayerBySkillCodeList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setSkillCode_InScope(pkList);
     * cb.query().addOrderBy_SkillCode_Asc();
     * </pre>
     * @param skillList The entity list of skill. (NotNull)
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerListGateway<VillagePlayer> loadVillagePlayerBySkillCode(List<Skill> skillList, ReferrerConditionSetupper<VillagePlayerCB> refCBLambda) {
        xassLRArg(skillList, refCBLambda);
        return doLoadVillagePlayerBySkillCode(skillList, new LoadReferrerOption<VillagePlayerCB, VillagePlayer>().xinit(refCBLambda));
    }

    /**
     * Load referrer of villagePlayerBySkillCodeList by the set-upper of referrer. <br>
     * VILLAGE_PLAYER by SKILL_CODE, named 'villagePlayerBySkillCodeList'.
     * <pre>
     * <span style="color: #0000C0">skillBhv</span>.<span style="color: #CC4747">loadVillagePlayerBySkillCode</span>(<span style="color: #553000">skill</span>, <span style="color: #553000">playerCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">playerCB</span>.setupSelect...
     *     <span style="color: #553000">playerCB</span>.query().set...
     *     <span style="color: #553000">playerCB</span>.query().addOrderBy...
     * }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     * <span style="color: #3F7E5E">//}).withNestedReferrer(referrerList -&gt; {</span>
     * <span style="color: #3F7E5E">//    ...</span>
     * <span style="color: #3F7E5E">//});</span>
     * ... = <span style="color: #553000">skill</span>.<span style="color: #CC4747">getVillagePlayerBySkillCodeList()</span>;
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setSkillCode_InScope(pkList);
     * cb.query().addOrderBy_SkillCode_Asc();
     * </pre>
     * @param skill The entity of skill. (NotNull)
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerListGateway<VillagePlayer> loadVillagePlayerBySkillCode(Skill skill, ReferrerConditionSetupper<VillagePlayerCB> refCBLambda) {
        xassLRArg(skill, refCBLambda);
        return doLoadVillagePlayerBySkillCode(xnewLRLs(skill), new LoadReferrerOption<VillagePlayerCB, VillagePlayer>().xinit(refCBLambda));
    }

    protected NestedReferrerListGateway<VillagePlayer> doLoadVillagePlayerBySkillCode(List<Skill> skillList, LoadReferrerOption<VillagePlayerCB, VillagePlayer> option) {
        return helpLoadReferrerInternally(skillList, option, "villagePlayerBySkillCodeList");
    }

    // ===================================================================================
    //                                                                   Pull out Relation
    //                                                                   =================
    /**
     * Pull out the list of foreign table 'Camp'.
     * @param skillList The list of skill. (NotNull, EmptyAllowed)
     * @return The list of foreign table. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<Camp> pulloutCamp(List<Skill> skillList)
    { return helpPulloutInternally(skillList, "camp"); }

    // ===================================================================================
    //                                                                      Extract Column
    //                                                                      ==============
    /**
     * Extract the value list of (single) primary key skillCode.
     * @param skillList The list of skill. (NotNull, EmptyAllowed)
     * @return The list of the column value. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<String> extractSkillCodeList(List<Skill> skillList)
    { return helpExtractListInternally(skillList, "skillCode"); }

    // ===================================================================================
    //                                                                       Entity Update
    //                                                                       =============
    /**
     * Insert the entity modified-only. (DefaultConstraintsEnabled)
     * <pre>
     * Skill skill = <span style="color: #70226C">new</span> Skill();
     * <span style="color: #3F7E5E">// if auto-increment, you don't need to set the PK value</span>
     * skill.setFoo...(value);
     * skill.setBar...(value);
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//skill.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//skill.set...;</span>
     * <span style="color: #0000C0">skillBhv</span>.<span style="color: #CC4747">insert</span>(skill);
     * ... = skill.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * <p>While, when the entity is created by select, all columns are registered.</p>
     * @param skill The entity of insert. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @throws EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insert(Skill skill) {
        doInsert(skill, null);
    }

    /**
     * Update the entity modified-only. (ZeroUpdateException, NonExclusiveControl) <br>
     * By PK as default, and also you can update by unique keys using entity's uniqueOf().
     * <pre>
     * Skill skill = <span style="color: #70226C">new</span> Skill();
     * skill.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * skill.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//skill.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//skill.set...;</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of concurrency column is required</span>
     * skill.<span style="color: #CC4747">setVersionNo</span>(value);
     * <span style="color: #0000C0">skillBhv</span>.<span style="color: #CC4747">update</span>(skill);
     * </pre>
     * @param skill The entity of update. (NotNull, PrimaryKeyNotNull)
     * @throws EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @throws EntityDuplicatedException When the entity has been duplicated.
     * @throws EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void update(Skill skill) {
        doUpdate(skill, null);
    }

    /**
     * Insert or update the entity modified-only. (DefaultConstraintsEnabled, NonExclusiveControl) <br>
     * if (the entity has no PK) { insert() } else { update(), but no data, insert() } <br>
     * <p><span style="color: #994747; font-size: 120%">Also you can update by unique keys using entity's uniqueOf().</span></p>
     * @param skill The entity of insert or update. (NotNull, ...depends on insert or update)
     * @throws EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @throws EntityDuplicatedException When the entity has been duplicated.
     * @throws EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insertOrUpdate(Skill skill) {
        doInsertOrUpdate(skill, null, null);
    }

    /**
     * Delete the entity. (ZeroUpdateException, NonExclusiveControl) <br>
     * By PK as default, and also you can delete by unique keys using entity's uniqueOf().
     * <pre>
     * Skill skill = <span style="color: #70226C">new</span> Skill();
     * skill.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of concurrency column is required</span>
     * skill.<span style="color: #CC4747">setVersionNo</span>(value);
     * <span style="color: #70226C">try</span> {
     *     <span style="color: #0000C0">skillBhv</span>.<span style="color: #CC4747">delete</span>(skill);
     * } <span style="color: #70226C">catch</span> (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param skill The entity of delete. (NotNull, PrimaryKeyNotNull)
     * @throws EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @throws EntityDuplicatedException When the entity has been duplicated.
     */
    public void delete(Skill skill) {
        doDelete(skill, null);
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
     *     Skill skill = <span style="color: #70226C">new</span> Skill();
     *     skill.setFooName("foo");
     *     <span style="color: #70226C">if</span> (...) {
     *         skill.setFooPrice(123);
     *     }
     *     <span style="color: #3F7E5E">// FOO_NAME and FOO_PRICE (and record meta columns) are registered</span>
     *     <span style="color: #3F7E5E">// FOO_PRICE not-called in any entities are registered as null without default value</span>
     *     <span style="color: #3F7E5E">// columns not-called in all entities are registered as null or default value</span>
     *     skillList.add(skill);
     * }
     * <span style="color: #0000C0">skillBhv</span>.<span style="color: #CC4747">batchInsert</span>(skillList);
     * </pre>
     * <p>While, when the entities are created by select, all columns are registered.</p>
     * <p>And if the table has an identity, entities after the process don't have incremented values.
     * (When you use the (normal) insert(), you can get the incremented value from your entity)</p>
     * @param skillList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNullAllowed: when auto-increment)
     * @return The array of inserted count. (NotNull, EmptyAllowed)
     */
    public int[] batchInsert(List<Skill> skillList) {
        return doBatchInsert(skillList, null);
    }

    /**
     * Batch-update the entity list modified-only of same-set columns. (NonExclusiveControl) <br>
     * This method uses executeBatch() of java.sql.PreparedStatement. <br>
     * <span style="color: #CC4747; font-size: 120%">You should specify same-set columns to all entities like this:</span>
     * <pre>
     * for (... : ...) {
     *     Skill skill = <span style="color: #70226C">new</span> Skill();
     *     skill.setFooName("foo");
     *     <span style="color: #70226C">if</span> (...) {
     *         skill.setFooPrice(123);
     *     } <span style="color: #70226C">else</span> {
     *         skill.setFooPrice(null); <span style="color: #3F7E5E">// updated as null</span>
     *         <span style="color: #3F7E5E">//skill.setFooDate(...); // *not allowed, fragmented</span>
     *     }
     *     <span style="color: #3F7E5E">// FOO_NAME and FOO_PRICE (and record meta columns) are updated</span>
     *     <span style="color: #3F7E5E">// (others are not updated: their values are kept)</span>
     *     skillList.add(skill);
     * }
     * <span style="color: #0000C0">skillBhv</span>.<span style="color: #CC4747">batchUpdate</span>(skillList);
     * </pre>
     * @param skillList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @throws EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchUpdate(List<Skill> skillList) {
        return doBatchUpdate(skillList, null);
    }

    /**
     * Batch-delete the entity list. (NonExclusiveControl) <br>
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * @param skillList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     * @throws EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchDelete(List<Skill> skillList) {
        return doBatchDelete(skillList, null);
    }

    // ===================================================================================
    //                                                                        Query Update
    //                                                                        ============
    /**
     * Insert the several entities by query (modified-only for fixed value).
     * <pre>
     * <span style="color: #0000C0">skillBhv</span>.<span style="color: #CC4747">queryInsert</span>(new QueryInsertSetupper&lt;Skill, SkillCB&gt;() {
     *     public ConditionBean setup(Skill entity, SkillCB intoCB) {
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
    public int queryInsert(QueryInsertSetupper<Skill, SkillCB> manyArgLambda) {
        return doQueryInsert(manyArgLambda, null);
    }

    /**
     * Update the several entities by query non-strictly modified-only. (NonExclusiveControl)
     * <pre>
     * Skill skill = <span style="color: #70226C">new</span> Skill();
     * <span style="color: #3F7E5E">// you don't need to set PK value</span>
     * <span style="color: #3F7E5E">//skill.setPK...(value);</span>
     * skill.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//skill.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//skill.set...;</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of concurrency column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//skill.setVersionNo(value);</span>
     * <span style="color: #0000C0">skillBhv</span>.<span style="color: #CC4747">queryUpdate</span>(skill, <span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">cb</span>.query().setFoo...
     * });
     * </pre>
     * @param skill The entity that contains update values. (NotNull, PrimaryKeyNullAllowed)
     * @param cbLambda The callback for condition-bean of Skill. (NotNull)
     * @return The updated count.
     * @throws NonQueryUpdateNotAllowedException When the query has no condition.
     */
    public int queryUpdate(Skill skill, CBCall<SkillCB> cbLambda) {
        return doQueryUpdate(skill, createCB(cbLambda), null);
    }

    /**
     * Delete the several entities by query. (NonExclusiveControl)
     * <pre>
     * <span style="color: #0000C0">skillBhv</span>.<span style="color: #CC4747">queryDelete</span>(skill, <span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">cb</span>.query().setFoo...
     * });
     * </pre>
     * @param cbLambda The callback for condition-bean of Skill. (NotNull)
     * @return The deleted count.
     * @throws NonQueryDeleteNotAllowedException When the query has no condition.
     */
    public int queryDelete(CBCall<SkillCB> cbLambda) {
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
     * Skill skill = <span style="color: #70226C">new</span> Skill();
     * <span style="color: #3F7E5E">// if auto-increment, you don't need to set the PK value</span>
     * skill.setFoo...(value);
     * skill.setBar...(value);
     * <span style="color: #0000C0">skillBhv</span>.<span style="color: #CC4747">varyingInsert</span>(skill, <span style="color: #553000">op</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #3F7E5E">// you can insert by your values for common columns</span>
     *     <span style="color: #553000">op</span>.disableCommonColumnAutoSetup();
     * });
     * ... = skill.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * @param skill The entity of insert. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @param opLambda The callback for option of insert for varying requests. (NotNull)
     * @throws EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsert(Skill skill, WritableOptionCall<SkillCB, InsertOption<SkillCB>> opLambda) {
        doInsert(skill, createInsertOption(opLambda));
    }

    /**
     * Update the entity with varying requests modified-only. (ZeroUpdateException, NonExclusiveControl) <br>
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification), disableCommonColumnAutoSetup(). <br>
     * Other specifications are same as update(entity).
     * <pre>
     * Skill skill = <span style="color: #70226C">new</span> Skill();
     * skill.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * skill.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of concurrency column is required</span>
     * skill.<span style="color: #CC4747">setVersionNo</span>(value);
     * <span style="color: #3F7E5E">// you can update by self calculation values</span>
     * <span style="color: #0000C0">skillBhv</span>.<span style="color: #CC4747">varyingUpdate</span>(skill, <span style="color: #553000">op</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">op</span>.self(<span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *         <span style="color: #553000">cb</span>.specify().<span style="color: #CC4747">columnXxxCount()</span>;
     *     }).plus(1); <span style="color: #3F7E5E">// XXX_COUNT = XXX_COUNT + 1</span>
     * });
     * </pre>
     * @param skill The entity of update. (NotNull, PrimaryKeyNotNull)
     * @param opLambda The callback for option of update for varying requests. (NotNull)
     * @throws EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @throws EntityDuplicatedException When the entity has been duplicated.
     * @throws EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingUpdate(Skill skill, WritableOptionCall<SkillCB, UpdateOption<SkillCB>> opLambda) {
        doUpdate(skill, createUpdateOption(opLambda));
    }

    /**
     * Insert or update the entity with varying requests. (ExclusiveControl: when update) <br>
     * Other specifications are same as insertOrUpdate(entity).
     * @param skill The entity of insert or update. (NotNull)
     * @param insertOpLambda The callback for option of insert for varying requests. (NotNull)
     * @param updateOpLambda The callback for option of update for varying requests. (NotNull)
     * @throws EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @throws EntityDuplicatedException When the entity has been duplicated.
     * @throws EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsertOrUpdate(Skill skill, WritableOptionCall<SkillCB, InsertOption<SkillCB>> insertOpLambda, WritableOptionCall<SkillCB, UpdateOption<SkillCB>> updateOpLambda) {
        doInsertOrUpdate(skill, createInsertOption(insertOpLambda), createUpdateOption(updateOpLambda));
    }

    /**
     * Delete the entity with varying requests. (ZeroUpdateException, NonExclusiveControl) <br>
     * Now a valid option does not exist. <br>
     * Other specifications are same as delete(entity).
     * @param skill The entity of delete. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnNotNull)
     * @param opLambda The callback for option of delete for varying requests. (NotNull)
     * @throws EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @throws EntityDuplicatedException When the entity has been duplicated.
     */
    public void varyingDelete(Skill skill, WritableOptionCall<SkillCB, DeleteOption<SkillCB>> opLambda) {
        doDelete(skill, createDeleteOption(opLambda));
    }

    // -----------------------------------------------------
    //                                          Batch Update
    //                                          ------------
    /**
     * Batch-insert the list with varying requests. <br>
     * For example, disableCommonColumnAutoSetup()
     * , disablePrimaryKeyIdentity(), limitBatchInsertLogging(). <br>
     * Other specifications are same as batchInsert(entityList).
     * @param skillList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param opLambda The callback for option of insert for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchInsert(List<Skill> skillList, WritableOptionCall<SkillCB, InsertOption<SkillCB>> opLambda) {
        return doBatchInsert(skillList, createInsertOption(opLambda));
    }

    /**
     * Batch-update the list with varying requests. <br>
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification)
     * , disableCommonColumnAutoSetup(), limitBatchUpdateLogging(). <br>
     * Other specifications are same as batchUpdate(entityList).
     * @param skillList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param opLambda The callback for option of update for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchUpdate(List<Skill> skillList, WritableOptionCall<SkillCB, UpdateOption<SkillCB>> opLambda) {
        return doBatchUpdate(skillList, createUpdateOption(opLambda));
    }

    /**
     * Batch-delete the list with varying requests. <br>
     * For example, limitBatchDeleteLogging(). <br>
     * Other specifications are same as batchDelete(entityList).
     * @param skillList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param opLambda The callback for option of delete for varying requests. (NotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchDelete(List<Skill> skillList, WritableOptionCall<SkillCB, DeleteOption<SkillCB>> opLambda) {
        return doBatchDelete(skillList, createDeleteOption(opLambda));
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
    public int varyingQueryInsert(QueryInsertSetupper<Skill, SkillCB> manyArgLambda, WritableOptionCall<SkillCB, InsertOption<SkillCB>> opLambda) {
        return doQueryInsert(manyArgLambda, createInsertOption(opLambda));
    }

    /**
     * Update the several entities by query with varying requests non-strictly modified-only. {NonExclusiveControl} <br>
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification)
     * , disableCommonColumnAutoSetup(), allowNonQueryUpdate(). <br>
     * Other specifications are same as queryUpdate(entity, cb).
     * <pre>
     * <span style="color: #3F7E5E">// ex) you can update by self calculation values</span>
     * Skill skill = <span style="color: #70226C">new</span> Skill();
     * <span style="color: #3F7E5E">// you don't need to set PK value</span>
     * <span style="color: #3F7E5E">//skill.setPK...(value);</span>
     * skill.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of concurrency column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//skill.setVersionNo(value);</span>
     * <span style="color: #0000C0">skillBhv</span>.<span style="color: #CC4747">varyingQueryUpdate</span>(skill, <span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">cb</span>.query().setFoo...
     * }, <span style="color: #553000">op</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">op</span>.self(<span style="color: #553000">colCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *         <span style="color: #553000">colCB</span>.specify().<span style="color: #CC4747">columnFooCount()</span>;
     *     }).plus(1); <span style="color: #3F7E5E">// FOO_COUNT = FOO_COUNT + 1</span>
     * });
     * </pre>
     * @param skill The entity that contains update values. (NotNull) {PrimaryKeyNotRequired}
     * @param cbLambda The callback for condition-bean of Skill. (NotNull)
     * @param opLambda The callback for option of update for varying requests. (NotNull)
     * @return The updated count.
     * @throws NonQueryUpdateNotAllowedException When the query has no condition (if not allowed).
     */
    public int varyingQueryUpdate(Skill skill, CBCall<SkillCB> cbLambda, WritableOptionCall<SkillCB, UpdateOption<SkillCB>> opLambda) {
        return doQueryUpdate(skill, createCB(cbLambda), createUpdateOption(opLambda));
    }

    /**
     * Delete the several entities by query with varying requests non-strictly. <br>
     * For example, allowNonQueryDelete(). <br>
     * Other specifications are same as queryDelete(cb).
     * <pre>
     * <span style="color: #0000C0">skillBhv</span>.<span style="color: #CC4747">queryDelete</span>(skill, <span style="color: #553000">cb</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">cb</span>.query().setFoo...
     * }, <span style="color: #553000">op</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">op</span>...
     * });
     * </pre>
     * @param cbLambda The callback for condition-bean of Skill. (NotNull)
     * @param opLambda The callback for option of delete for varying requests. (NotNull)
     * @return The deleted count.
     * @throws NonQueryDeleteNotAllowedException When the query has no condition (if not allowed).
     */
    public int varyingQueryDelete(CBCall<SkillCB> cbLambda, WritableOptionCall<SkillCB, DeleteOption<SkillCB>> opLambda) {
        return doQueryDelete(createCB(cbLambda), createDeleteOption(opLambda));
    }

    // ===================================================================================
    //                                                                          OutsideSql
    //                                                                          ==========
    /**
     * Prepare the all facade executor of outside-SQL to execute it.
     * <pre>
     * <span style="color: #3F7E5E">// main style</span> 
     * skillBhv.outideSql().selectEntity(pmb); <span style="color: #3F7E5E">// optional</span> 
     * skillBhv.outideSql().selectList(pmb); <span style="color: #3F7E5E">// ListResultBean</span>
     * skillBhv.outideSql().selectPage(pmb); <span style="color: #3F7E5E">// PagingResultBean</span>
     * skillBhv.outideSql().selectPagedListOnly(pmb); <span style="color: #3F7E5E">// ListResultBean</span>
     * skillBhv.outideSql().selectCursor(pmb, handler); <span style="color: #3F7E5E">// (by handler)</span>
     * skillBhv.outideSql().execute(pmb); <span style="color: #3F7E5E">// int (updated count)</span>
     * skillBhv.outideSql().call(pmb); <span style="color: #3F7E5E">// void (pmb has OUT parameters)</span>
     *
     * <span style="color: #3F7E5E">// traditional style</span> 
     * skillBhv.outideSql().traditionalStyle().selectEntity(path, pmb, entityType);
     * skillBhv.outideSql().traditionalStyle().selectList(path, pmb, entityType);
     * skillBhv.outideSql().traditionalStyle().selectPage(path, pmb, entityType);
     * skillBhv.outideSql().traditionalStyle().selectPagedListOnly(path, pmb, entityType);
     * skillBhv.outideSql().traditionalStyle().selectCursor(path, pmb, handler);
     * skillBhv.outideSql().traditionalStyle().execute(path, pmb);
     *
     * <span style="color: #3F7E5E">// options</span> 
     * skillBhv.outideSql().removeBlockComment().selectList()
     * skillBhv.outideSql().removeLineComment().selectList()
     * skillBhv.outideSql().formatSql().selectList()
     * </pre>
     * <p>The invoker of behavior command should be not null when you call this method.</p>
     * @return The new-created all facade executor of outside-SQL. (NotNull)
     */
    public OutsideSqlAllFacadeExecutor<SkillBhv> outsideSql() {
        return doOutsideSql();
    }

    // ===================================================================================
    //                                                                         Type Helper
    //                                                                         ===========
    protected Class<? extends Skill> typeOfSelectedEntity() { return Skill.class; }
    protected Class<Skill> typeOfHandlingEntity() { return Skill.class; }
    protected Class<SkillCB> typeOfHandlingConditionBean() { return SkillCB.class; }

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
