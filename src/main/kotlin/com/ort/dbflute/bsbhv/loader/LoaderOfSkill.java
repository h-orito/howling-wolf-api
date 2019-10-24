package com.ort.dbflute.bsbhv.loader;

import java.util.List;

import org.dbflute.bhv.*;
import org.dbflute.bhv.referrer.*;
import com.ort.dbflute.exbhv.*;
import com.ort.dbflute.exentity.*;
import com.ort.dbflute.cbean.*;

/**
 * The referrer loader of SKILL as TABLE. <br>
 * <pre>
 * [primary key]
 *     SKILL_CODE
 *
 * [column]
 *     SKILL_CODE, SKILL_NAME, SKILL_SHORT_NAME, CAMP_CODE, DISP_ORDER
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
public class LoaderOfSkill {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<Skill> _selectedList;
    protected BehaviorSelector _selector;
    protected SkillBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfSkill ready(List<Skill> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected SkillBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(SkillBhv.class); return _myBhv; } }

    // ===================================================================================
    //                                                                       Load Referrer
    //                                                                       =============
    protected List<MessageRestriction> _referrerMessageRestriction;

    /**
     * Load referrer of messageRestrictionList by the set-upper of referrer. <br>
     * MESSAGE_RESTRICTION by SKILL_CODE, named 'messageRestrictionList'.
     * <pre>
     * <span style="color: #0000C0">skillBhv</span>.<span style="color: #994747">load</span>(<span style="color: #553000">skillList</span>, <span style="color: #553000">skillLoader</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">skillLoader</span>.<span style="color: #CC4747">loadMessageRestriction</span>(<span style="color: #553000">restrictionCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *         <span style="color: #553000">restrictionCB</span>.setupSelect...
     *         <span style="color: #553000">restrictionCB</span>.query().set...
     *         <span style="color: #553000">restrictionCB</span>.query().addOrderBy...
     *     }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     *     <span style="color: #3F7E5E">//}).withNestedReferrer(<span style="color: #553000">restrictionLoader</span> -&gt; {</span>
     *     <span style="color: #3F7E5E">//    restrictionLoader.load...</span>
     *     <span style="color: #3F7E5E">//});</span>
     * });
     * for (Skill skill : <span style="color: #553000">skillList</span>) {
     *     ... = skill.<span style="color: #CC4747">getMessageRestrictionList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setSkillCode_InScope(pkList);
     * cb.query().addOrderBy_SkillCode_Asc();
     * </pre>
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerLoaderGateway<LoaderOfMessageRestriction> loadMessageRestriction(ReferrerConditionSetupper<MessageRestrictionCB> refCBLambda) {
        myBhv().loadMessageRestriction(_selectedList, refCBLambda).withNestedReferrer(refLs -> _referrerMessageRestriction = refLs);
        return hd -> hd.handle(new LoaderOfMessageRestriction().ready(_referrerMessageRestriction, _selector));
    }

    protected List<VillagePlayer> _referrerVillagePlayerByRequestSkillCode;

    /**
     * Load referrer of villagePlayerByRequestSkillCodeList by the set-upper of referrer. <br>
     * VILLAGE_PLAYER by REQUEST_SKILL_CODE, named 'villagePlayerByRequestSkillCodeList'.
     * <pre>
     * <span style="color: #0000C0">skillBhv</span>.<span style="color: #994747">load</span>(<span style="color: #553000">skillList</span>, <span style="color: #553000">skillLoader</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">skillLoader</span>.<span style="color: #CC4747">loadVillagePlayerByRequestSkillCode</span>(<span style="color: #553000">playerCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *         <span style="color: #553000">playerCB</span>.setupSelect...
     *         <span style="color: #553000">playerCB</span>.query().set...
     *         <span style="color: #553000">playerCB</span>.query().addOrderBy...
     *     }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     *     <span style="color: #3F7E5E">//}).withNestedReferrer(<span style="color: #553000">playerLoader</span> -&gt; {</span>
     *     <span style="color: #3F7E5E">//    playerLoader.load...</span>
     *     <span style="color: #3F7E5E">//});</span>
     * });
     * for (Skill skill : <span style="color: #553000">skillList</span>) {
     *     ... = skill.<span style="color: #CC4747">getVillagePlayerByRequestSkillCodeList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setRequestSkillCode_InScope(pkList);
     * cb.query().addOrderBy_RequestSkillCode_Asc();
     * </pre>
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerLoaderGateway<LoaderOfVillagePlayer> loadVillagePlayerByRequestSkillCode(ReferrerConditionSetupper<VillagePlayerCB> refCBLambda) {
        myBhv().loadVillagePlayerByRequestSkillCode(_selectedList, refCBLambda).withNestedReferrer(refLs -> _referrerVillagePlayerByRequestSkillCode = refLs);
        return hd -> hd.handle(new LoaderOfVillagePlayer().ready(_referrerVillagePlayerByRequestSkillCode, _selector));
    }

    protected List<VillagePlayer> _referrerVillagePlayerBySecondRequestSkillCode;

    /**
     * Load referrer of villagePlayerBySecondRequestSkillCodeList by the set-upper of referrer. <br>
     * VILLAGE_PLAYER by SECOND_REQUEST_SKILL_CODE, named 'villagePlayerBySecondRequestSkillCodeList'.
     * <pre>
     * <span style="color: #0000C0">skillBhv</span>.<span style="color: #994747">load</span>(<span style="color: #553000">skillList</span>, <span style="color: #553000">skillLoader</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">skillLoader</span>.<span style="color: #CC4747">loadVillagePlayerBySecondRequestSkillCode</span>(<span style="color: #553000">playerCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *         <span style="color: #553000">playerCB</span>.setupSelect...
     *         <span style="color: #553000">playerCB</span>.query().set...
     *         <span style="color: #553000">playerCB</span>.query().addOrderBy...
     *     }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     *     <span style="color: #3F7E5E">//}).withNestedReferrer(<span style="color: #553000">playerLoader</span> -&gt; {</span>
     *     <span style="color: #3F7E5E">//    playerLoader.load...</span>
     *     <span style="color: #3F7E5E">//});</span>
     * });
     * for (Skill skill : <span style="color: #553000">skillList</span>) {
     *     ... = skill.<span style="color: #CC4747">getVillagePlayerBySecondRequestSkillCodeList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setSecondRequestSkillCode_InScope(pkList);
     * cb.query().addOrderBy_SecondRequestSkillCode_Asc();
     * </pre>
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerLoaderGateway<LoaderOfVillagePlayer> loadVillagePlayerBySecondRequestSkillCode(ReferrerConditionSetupper<VillagePlayerCB> refCBLambda) {
        myBhv().loadVillagePlayerBySecondRequestSkillCode(_selectedList, refCBLambda).withNestedReferrer(refLs -> _referrerVillagePlayerBySecondRequestSkillCode = refLs);
        return hd -> hd.handle(new LoaderOfVillagePlayer().ready(_referrerVillagePlayerBySecondRequestSkillCode, _selector));
    }

    protected List<VillagePlayer> _referrerVillagePlayerBySkillCode;

    /**
     * Load referrer of villagePlayerBySkillCodeList by the set-upper of referrer. <br>
     * VILLAGE_PLAYER by SKILL_CODE, named 'villagePlayerBySkillCodeList'.
     * <pre>
     * <span style="color: #0000C0">skillBhv</span>.<span style="color: #994747">load</span>(<span style="color: #553000">skillList</span>, <span style="color: #553000">skillLoader</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">skillLoader</span>.<span style="color: #CC4747">loadVillagePlayerBySkillCode</span>(<span style="color: #553000">playerCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *         <span style="color: #553000">playerCB</span>.setupSelect...
     *         <span style="color: #553000">playerCB</span>.query().set...
     *         <span style="color: #553000">playerCB</span>.query().addOrderBy...
     *     }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     *     <span style="color: #3F7E5E">//}).withNestedReferrer(<span style="color: #553000">playerLoader</span> -&gt; {</span>
     *     <span style="color: #3F7E5E">//    playerLoader.load...</span>
     *     <span style="color: #3F7E5E">//});</span>
     * });
     * for (Skill skill : <span style="color: #553000">skillList</span>) {
     *     ... = skill.<span style="color: #CC4747">getVillagePlayerBySkillCodeList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setSkillCode_InScope(pkList);
     * cb.query().addOrderBy_SkillCode_Asc();
     * </pre>
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerLoaderGateway<LoaderOfVillagePlayer> loadVillagePlayerBySkillCode(ReferrerConditionSetupper<VillagePlayerCB> refCBLambda) {
        myBhv().loadVillagePlayerBySkillCode(_selectedList, refCBLambda).withNestedReferrer(refLs -> _referrerVillagePlayerBySkillCode = refLs);
        return hd -> hd.handle(new LoaderOfVillagePlayer().ready(_referrerVillagePlayerBySkillCode, _selector));
    }

    // ===================================================================================
    //                                                                    Pull out Foreign
    //                                                                    ================
    protected LoaderOfCamp _foreignCampLoader;
    public LoaderOfCamp pulloutCamp() {
        if (_foreignCampLoader == null)
        { _foreignCampLoader = new LoaderOfCamp().ready(myBhv().pulloutCamp(_selectedList), _selector); }
        return _foreignCampLoader;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<Skill> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
