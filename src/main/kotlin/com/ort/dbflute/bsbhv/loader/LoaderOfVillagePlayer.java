package com.ort.dbflute.bsbhv.loader;

import java.util.List;

import org.dbflute.bhv.*;
import org.dbflute.bhv.referrer.*;
import com.ort.dbflute.exbhv.*;
import com.ort.dbflute.exentity.*;
import com.ort.dbflute.cbean.*;

/**
 * The referrer loader of VILLAGE_PLAYER as TABLE. <br>
 * <pre>
 * [primary key]
 *     VILLAGE_PLAYER_ID
 *
 * [column]
 *     VILLAGE_PLAYER_ID, VILLAGE_ID, PLAYER_ID, CHARA_ID, SKILL_CODE, REQUEST_SKILL_CODE, SECOND_REQUEST_SKILL_CODE, IS_DEAD, IS_SPECTATOR, DEAD_REASON_CODE, DEAD_DAY, IS_GONE, REGISTER_DATETIME, REGISTER_TRACE, UPDATE_DATETIME, UPDATE_TRACE
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
 *     CHARA, DEAD_REASON, PLAYER, SKILL, VILLAGE
 *
 * [referrer table]
 *     ABILITY, COMMIT, VOTE
 *
 * [foreign property]
 *     chara, deadReason, player, skillByRequestSkillCode, skillBySecondRequestSkillCode, skillBySkillCode, village
 *
 * [referrer property]
 *     abilityByTargetVillagePlayerIdList, abilityByVillagePlayerIdList, commitList, voteByTargetVillagePlayerIdList, voteByVillagePlayerIdList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public class LoaderOfVillagePlayer {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<VillagePlayer> _selectedList;
    protected BehaviorSelector _selector;
    protected VillagePlayerBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfVillagePlayer ready(List<VillagePlayer> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected VillagePlayerBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(VillagePlayerBhv.class); return _myBhv; } }

    // ===================================================================================
    //                                                                       Load Referrer
    //                                                                       =============
    protected List<Ability> _referrerAbilityByTargetVillagePlayerId;

    /**
     * Load referrer of abilityByTargetVillagePlayerIdList by the set-upper of referrer. <br>
     * ABILITY by TARGET_VILLAGE_PLAYER_ID, named 'abilityByTargetVillagePlayerIdList'.
     * <pre>
     * <span style="color: #0000C0">villagePlayerBhv</span>.<span style="color: #994747">load</span>(<span style="color: #553000">villagePlayerList</span>, <span style="color: #553000">playerLoader</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">playerLoader</span>.<span style="color: #CC4747">loadAbilityByTargetVillagePlayerId</span>(<span style="color: #553000">abilityCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *         <span style="color: #553000">abilityCB</span>.setupSelect...
     *         <span style="color: #553000">abilityCB</span>.query().set...
     *         <span style="color: #553000">abilityCB</span>.query().addOrderBy...
     *     }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     *     <span style="color: #3F7E5E">//}).withNestedReferrer(<span style="color: #553000">abilityLoader</span> -&gt; {</span>
     *     <span style="color: #3F7E5E">//    abilityLoader.load...</span>
     *     <span style="color: #3F7E5E">//});</span>
     * });
     * for (VillagePlayer villagePlayer : <span style="color: #553000">villagePlayerList</span>) {
     *     ... = villagePlayer.<span style="color: #CC4747">getAbilityByTargetVillagePlayerIdList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setTargetVillagePlayerId_InScope(pkList);
     * cb.query().addOrderBy_TargetVillagePlayerId_Asc();
     * </pre>
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerLoaderGateway<LoaderOfAbility> loadAbilityByTargetVillagePlayerId(ReferrerConditionSetupper<AbilityCB> refCBLambda) {
        myBhv().loadAbilityByTargetVillagePlayerId(_selectedList, refCBLambda).withNestedReferrer(refLs -> _referrerAbilityByTargetVillagePlayerId = refLs);
        return hd -> hd.handle(new LoaderOfAbility().ready(_referrerAbilityByTargetVillagePlayerId, _selector));
    }

    protected List<Ability> _referrerAbilityByVillagePlayerId;

    /**
     * Load referrer of abilityByVillagePlayerIdList by the set-upper of referrer. <br>
     * ABILITY by VILLAGE_PLAYER_ID, named 'abilityByVillagePlayerIdList'.
     * <pre>
     * <span style="color: #0000C0">villagePlayerBhv</span>.<span style="color: #994747">load</span>(<span style="color: #553000">villagePlayerList</span>, <span style="color: #553000">playerLoader</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">playerLoader</span>.<span style="color: #CC4747">loadAbilityByVillagePlayerId</span>(<span style="color: #553000">abilityCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *         <span style="color: #553000">abilityCB</span>.setupSelect...
     *         <span style="color: #553000">abilityCB</span>.query().set...
     *         <span style="color: #553000">abilityCB</span>.query().addOrderBy...
     *     }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     *     <span style="color: #3F7E5E">//}).withNestedReferrer(<span style="color: #553000">abilityLoader</span> -&gt; {</span>
     *     <span style="color: #3F7E5E">//    abilityLoader.load...</span>
     *     <span style="color: #3F7E5E">//});</span>
     * });
     * for (VillagePlayer villagePlayer : <span style="color: #553000">villagePlayerList</span>) {
     *     ... = villagePlayer.<span style="color: #CC4747">getAbilityByVillagePlayerIdList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setVillagePlayerId_InScope(pkList);
     * cb.query().addOrderBy_VillagePlayerId_Asc();
     * </pre>
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerLoaderGateway<LoaderOfAbility> loadAbilityByVillagePlayerId(ReferrerConditionSetupper<AbilityCB> refCBLambda) {
        myBhv().loadAbilityByVillagePlayerId(_selectedList, refCBLambda).withNestedReferrer(refLs -> _referrerAbilityByVillagePlayerId = refLs);
        return hd -> hd.handle(new LoaderOfAbility().ready(_referrerAbilityByVillagePlayerId, _selector));
    }

    protected List<Commit> _referrerCommit;

    /**
     * Load referrer of commitList by the set-upper of referrer. <br>
     * COMMIT by VILLAGE_PLAYER_ID, named 'commitList'.
     * <pre>
     * <span style="color: #0000C0">villagePlayerBhv</span>.<span style="color: #994747">load</span>(<span style="color: #553000">villagePlayerList</span>, <span style="color: #553000">playerLoader</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">playerLoader</span>.<span style="color: #CC4747">loadCommit</span>(<span style="color: #553000">commitCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *         <span style="color: #553000">commitCB</span>.setupSelect...
     *         <span style="color: #553000">commitCB</span>.query().set...
     *         <span style="color: #553000">commitCB</span>.query().addOrderBy...
     *     }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     *     <span style="color: #3F7E5E">//}).withNestedReferrer(<span style="color: #553000">commitLoader</span> -&gt; {</span>
     *     <span style="color: #3F7E5E">//    commitLoader.load...</span>
     *     <span style="color: #3F7E5E">//});</span>
     * });
     * for (VillagePlayer villagePlayer : <span style="color: #553000">villagePlayerList</span>) {
     *     ... = villagePlayer.<span style="color: #CC4747">getCommitList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setVillagePlayerId_InScope(pkList);
     * cb.query().addOrderBy_VillagePlayerId_Asc();
     * </pre>
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerLoaderGateway<LoaderOfCommit> loadCommit(ReferrerConditionSetupper<CommitCB> refCBLambda) {
        myBhv().loadCommit(_selectedList, refCBLambda).withNestedReferrer(refLs -> _referrerCommit = refLs);
        return hd -> hd.handle(new LoaderOfCommit().ready(_referrerCommit, _selector));
    }

    protected List<Vote> _referrerVoteByTargetVillagePlayerId;

    /**
     * Load referrer of voteByTargetVillagePlayerIdList by the set-upper of referrer. <br>
     * VOTE by TARGET_VILLAGE_PLAYER_ID, named 'voteByTargetVillagePlayerIdList'.
     * <pre>
     * <span style="color: #0000C0">villagePlayerBhv</span>.<span style="color: #994747">load</span>(<span style="color: #553000">villagePlayerList</span>, <span style="color: #553000">playerLoader</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">playerLoader</span>.<span style="color: #CC4747">loadVoteByTargetVillagePlayerId</span>(<span style="color: #553000">voteCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *         <span style="color: #553000">voteCB</span>.setupSelect...
     *         <span style="color: #553000">voteCB</span>.query().set...
     *         <span style="color: #553000">voteCB</span>.query().addOrderBy...
     *     }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     *     <span style="color: #3F7E5E">//}).withNestedReferrer(<span style="color: #553000">voteLoader</span> -&gt; {</span>
     *     <span style="color: #3F7E5E">//    voteLoader.load...</span>
     *     <span style="color: #3F7E5E">//});</span>
     * });
     * for (VillagePlayer villagePlayer : <span style="color: #553000">villagePlayerList</span>) {
     *     ... = villagePlayer.<span style="color: #CC4747">getVoteByTargetVillagePlayerIdList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setTargetVillagePlayerId_InScope(pkList);
     * cb.query().addOrderBy_TargetVillagePlayerId_Asc();
     * </pre>
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerLoaderGateway<LoaderOfVote> loadVoteByTargetVillagePlayerId(ReferrerConditionSetupper<VoteCB> refCBLambda) {
        myBhv().loadVoteByTargetVillagePlayerId(_selectedList, refCBLambda).withNestedReferrer(refLs -> _referrerVoteByTargetVillagePlayerId = refLs);
        return hd -> hd.handle(new LoaderOfVote().ready(_referrerVoteByTargetVillagePlayerId, _selector));
    }

    protected List<Vote> _referrerVoteByVillagePlayerId;

    /**
     * Load referrer of voteByVillagePlayerIdList by the set-upper of referrer. <br>
     * VOTE by VILLAGE_PLAYER_ID, named 'voteByVillagePlayerIdList'.
     * <pre>
     * <span style="color: #0000C0">villagePlayerBhv</span>.<span style="color: #994747">load</span>(<span style="color: #553000">villagePlayerList</span>, <span style="color: #553000">playerLoader</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">playerLoader</span>.<span style="color: #CC4747">loadVoteByVillagePlayerId</span>(<span style="color: #553000">voteCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *         <span style="color: #553000">voteCB</span>.setupSelect...
     *         <span style="color: #553000">voteCB</span>.query().set...
     *         <span style="color: #553000">voteCB</span>.query().addOrderBy...
     *     }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     *     <span style="color: #3F7E5E">//}).withNestedReferrer(<span style="color: #553000">voteLoader</span> -&gt; {</span>
     *     <span style="color: #3F7E5E">//    voteLoader.load...</span>
     *     <span style="color: #3F7E5E">//});</span>
     * });
     * for (VillagePlayer villagePlayer : <span style="color: #553000">villagePlayerList</span>) {
     *     ... = villagePlayer.<span style="color: #CC4747">getVoteByVillagePlayerIdList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setVillagePlayerId_InScope(pkList);
     * cb.query().addOrderBy_VillagePlayerId_Asc();
     * </pre>
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerLoaderGateway<LoaderOfVote> loadVoteByVillagePlayerId(ReferrerConditionSetupper<VoteCB> refCBLambda) {
        myBhv().loadVoteByVillagePlayerId(_selectedList, refCBLambda).withNestedReferrer(refLs -> _referrerVoteByVillagePlayerId = refLs);
        return hd -> hd.handle(new LoaderOfVote().ready(_referrerVoteByVillagePlayerId, _selector));
    }

    // ===================================================================================
    //                                                                    Pull out Foreign
    //                                                                    ================
    protected LoaderOfChara _foreignCharaLoader;
    public LoaderOfChara pulloutChara() {
        if (_foreignCharaLoader == null)
        { _foreignCharaLoader = new LoaderOfChara().ready(myBhv().pulloutChara(_selectedList), _selector); }
        return _foreignCharaLoader;
    }

    protected LoaderOfDeadReason _foreignDeadReasonLoader;
    public LoaderOfDeadReason pulloutDeadReason() {
        if (_foreignDeadReasonLoader == null)
        { _foreignDeadReasonLoader = new LoaderOfDeadReason().ready(myBhv().pulloutDeadReason(_selectedList), _selector); }
        return _foreignDeadReasonLoader;
    }

    protected LoaderOfPlayer _foreignPlayerLoader;
    public LoaderOfPlayer pulloutPlayer() {
        if (_foreignPlayerLoader == null)
        { _foreignPlayerLoader = new LoaderOfPlayer().ready(myBhv().pulloutPlayer(_selectedList), _selector); }
        return _foreignPlayerLoader;
    }

    protected LoaderOfSkill _foreignSkillByRequestSkillCodeLoader;
    public LoaderOfSkill pulloutSkillByRequestSkillCode() {
        if (_foreignSkillByRequestSkillCodeLoader == null)
        { _foreignSkillByRequestSkillCodeLoader = new LoaderOfSkill().ready(myBhv().pulloutSkillByRequestSkillCode(_selectedList), _selector); }
        return _foreignSkillByRequestSkillCodeLoader;
    }

    protected LoaderOfSkill _foreignSkillBySecondRequestSkillCodeLoader;
    public LoaderOfSkill pulloutSkillBySecondRequestSkillCode() {
        if (_foreignSkillBySecondRequestSkillCodeLoader == null)
        { _foreignSkillBySecondRequestSkillCodeLoader = new LoaderOfSkill().ready(myBhv().pulloutSkillBySecondRequestSkillCode(_selectedList), _selector); }
        return _foreignSkillBySecondRequestSkillCodeLoader;
    }

    protected LoaderOfSkill _foreignSkillBySkillCodeLoader;
    public LoaderOfSkill pulloutSkillBySkillCode() {
        if (_foreignSkillBySkillCodeLoader == null)
        { _foreignSkillBySkillCodeLoader = new LoaderOfSkill().ready(myBhv().pulloutSkillBySkillCode(_selectedList), _selector); }
        return _foreignSkillBySkillCodeLoader;
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
    public List<VillagePlayer> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
