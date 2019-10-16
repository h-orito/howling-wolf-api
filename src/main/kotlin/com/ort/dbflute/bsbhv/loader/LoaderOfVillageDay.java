package com.ort.dbflute.bsbhv.loader;

import java.util.List;

import org.dbflute.bhv.*;
import org.dbflute.bhv.referrer.*;
import com.ort.dbflute.exbhv.*;
import com.ort.dbflute.exentity.*;
import com.ort.dbflute.cbean.*;

/**
 * The referrer loader of VILLAGE_DAY as TABLE. <br>
 * <pre>
 * [primary key]
 *     VILLAGE_DAY_ID
 *
 * [column]
 *     VILLAGE_DAY_ID, VILLAGE_ID, DAY, NOONNIGHT_CODE, DAYCHANGE_DATETIME, IS_UPDATING, REGISTER_DATETIME, REGISTER_TRACE, UPDATE_DATETIME, UPDATE_TRACE
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
 *     ABILITY, COMMIT, VOTE
 *
 * [foreign property]
 *     noonnight, village
 *
 * [referrer property]
 *     abilityList, commitList, voteList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public class LoaderOfVillageDay {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<VillageDay> _selectedList;
    protected BehaviorSelector _selector;
    protected VillageDayBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfVillageDay ready(List<VillageDay> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected VillageDayBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(VillageDayBhv.class); return _myBhv; } }

    // ===================================================================================
    //                                                                       Load Referrer
    //                                                                       =============
    protected List<Ability> _referrerAbility;

    /**
     * Load referrer of abilityList by the set-upper of referrer. <br>
     * ABILITY by VILLAGE_DAY_ID, named 'abilityList'.
     * <pre>
     * <span style="color: #0000C0">villageDayBhv</span>.<span style="color: #994747">load</span>(<span style="color: #553000">villageDayList</span>, <span style="color: #553000">dayLoader</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">dayLoader</span>.<span style="color: #CC4747">loadAbility</span>(<span style="color: #553000">abilityCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *         <span style="color: #553000">abilityCB</span>.setupSelect...
     *         <span style="color: #553000">abilityCB</span>.query().set...
     *         <span style="color: #553000">abilityCB</span>.query().addOrderBy...
     *     }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     *     <span style="color: #3F7E5E">//}).withNestedReferrer(<span style="color: #553000">abilityLoader</span> -&gt; {</span>
     *     <span style="color: #3F7E5E">//    abilityLoader.load...</span>
     *     <span style="color: #3F7E5E">//});</span>
     * });
     * for (VillageDay villageDay : <span style="color: #553000">villageDayList</span>) {
     *     ... = villageDay.<span style="color: #CC4747">getAbilityList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setVillageDayId_InScope(pkList);
     * cb.query().addOrderBy_VillageDayId_Asc();
     * </pre>
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerLoaderGateway<LoaderOfAbility> loadAbility(ReferrerConditionSetupper<AbilityCB> refCBLambda) {
        myBhv().loadAbility(_selectedList, refCBLambda).withNestedReferrer(refLs -> _referrerAbility = refLs);
        return hd -> hd.handle(new LoaderOfAbility().ready(_referrerAbility, _selector));
    }

    protected List<Commit> _referrerCommit;

    /**
     * Load referrer of commitList by the set-upper of referrer. <br>
     * COMMIT by VILLAGE_DAY_ID, named 'commitList'.
     * <pre>
     * <span style="color: #0000C0">villageDayBhv</span>.<span style="color: #994747">load</span>(<span style="color: #553000">villageDayList</span>, <span style="color: #553000">dayLoader</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">dayLoader</span>.<span style="color: #CC4747">loadCommit</span>(<span style="color: #553000">commitCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *         <span style="color: #553000">commitCB</span>.setupSelect...
     *         <span style="color: #553000">commitCB</span>.query().set...
     *         <span style="color: #553000">commitCB</span>.query().addOrderBy...
     *     }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     *     <span style="color: #3F7E5E">//}).withNestedReferrer(<span style="color: #553000">commitLoader</span> -&gt; {</span>
     *     <span style="color: #3F7E5E">//    commitLoader.load...</span>
     *     <span style="color: #3F7E5E">//});</span>
     * });
     * for (VillageDay villageDay : <span style="color: #553000">villageDayList</span>) {
     *     ... = villageDay.<span style="color: #CC4747">getCommitList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setVillageDayId_InScope(pkList);
     * cb.query().addOrderBy_VillageDayId_Asc();
     * </pre>
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerLoaderGateway<LoaderOfCommit> loadCommit(ReferrerConditionSetupper<CommitCB> refCBLambda) {
        myBhv().loadCommit(_selectedList, refCBLambda).withNestedReferrer(refLs -> _referrerCommit = refLs);
        return hd -> hd.handle(new LoaderOfCommit().ready(_referrerCommit, _selector));
    }

    protected List<Vote> _referrerVote;

    /**
     * Load referrer of voteList by the set-upper of referrer. <br>
     * VOTE by VILLAGE_DAY_ID, named 'voteList'.
     * <pre>
     * <span style="color: #0000C0">villageDayBhv</span>.<span style="color: #994747">load</span>(<span style="color: #553000">villageDayList</span>, <span style="color: #553000">dayLoader</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">dayLoader</span>.<span style="color: #CC4747">loadVote</span>(<span style="color: #553000">voteCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *         <span style="color: #553000">voteCB</span>.setupSelect...
     *         <span style="color: #553000">voteCB</span>.query().set...
     *         <span style="color: #553000">voteCB</span>.query().addOrderBy...
     *     }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     *     <span style="color: #3F7E5E">//}).withNestedReferrer(<span style="color: #553000">voteLoader</span> -&gt; {</span>
     *     <span style="color: #3F7E5E">//    voteLoader.load...</span>
     *     <span style="color: #3F7E5E">//});</span>
     * });
     * for (VillageDay villageDay : <span style="color: #553000">villageDayList</span>) {
     *     ... = villageDay.<span style="color: #CC4747">getVoteList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setVillageDayId_InScope(pkList);
     * cb.query().addOrderBy_VillageDayId_Asc();
     * </pre>
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerLoaderGateway<LoaderOfVote> loadVote(ReferrerConditionSetupper<VoteCB> refCBLambda) {
        myBhv().loadVote(_selectedList, refCBLambda).withNestedReferrer(refLs -> _referrerVote = refLs);
        return hd -> hd.handle(new LoaderOfVote().ready(_referrerVote, _selector));
    }

    // ===================================================================================
    //                                                                    Pull out Foreign
    //                                                                    ================
    protected LoaderOfNoonnight _foreignNoonnightLoader;
    public LoaderOfNoonnight pulloutNoonnight() {
        if (_foreignNoonnightLoader == null)
        { _foreignNoonnightLoader = new LoaderOfNoonnight().ready(myBhv().pulloutNoonnight(_selectedList), _selector); }
        return _foreignNoonnightLoader;
    }

    protected LoaderOfVillage _foreignVillageLoader;
    public LoaderOfVillage pulloutVillage() {
        if (_foreignVillageLoader == null)
        { _foreignVillageLoader = new LoaderOfVillage().ready(myBhv().pulloutVillage(_selectedList), _selector); }
        return _foreignVillageLoader;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<VillageDay> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
