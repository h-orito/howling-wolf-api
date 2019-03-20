package com.ort.dbflute.bsbhv.loader;

import java.util.List;

import org.dbflute.bhv.*;
import org.dbflute.bhv.referrer.*;
import com.ort.dbflute.exbhv.*;
import com.ort.dbflute.exentity.*;
import com.ort.dbflute.cbean.*;

/**
 * The referrer loader of CHARA as TABLE. <br>
 * <pre>
 * [primary key]
 *     CHARA_ID
 *
 * [column]
 *     CHARA_ID, CHARA_NAME, CHARA_SHORT_NAME, CHARA_GROUP_ID, DEFAULT_JOIN_MESSAGE, DEFAULT_FIRSTDAY_MESSAGE, DISPLAY_WIDTH, DISPLAY_HEIGHT, REGISTER_DATETIME, REGISTER_TRACE, UPDATE_DATETIME, UPDATE_TRACE
 *
 * [sequence]
 *     
 *
 * [identity]
 *     CHARA_ID
 *
 * [version-no]
 *     
 *
 * [foreign table]
 *     CHARA_GROUP
 *
 * [referrer table]
 *     ABILITY, CHARA_IMAGE, VILLAGE_PLAYER, VOTE
 *
 * [foreign property]
 *     charaGroup
 *
 * [referrer property]
 *     abilityByCharaIdList, abilityByTargetCharaIdList, charaImageList, villagePlayerList, voteByCharaIdList, voteByVoteCharaIdList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public class LoaderOfChara {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<Chara> _selectedList;
    protected BehaviorSelector _selector;
    protected CharaBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfChara ready(List<Chara> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected CharaBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(CharaBhv.class); return _myBhv; } }

    // ===================================================================================
    //                                                                       Load Referrer
    //                                                                       =============
    protected List<Ability> _referrerAbilityByCharaId;

    /**
     * Load referrer of abilityByCharaIdList by the set-upper of referrer. <br>
     * ABILITY by CHARA_ID, named 'abilityByCharaIdList'.
     * <pre>
     * <span style="color: #0000C0">charaBhv</span>.<span style="color: #994747">load</span>(<span style="color: #553000">charaList</span>, <span style="color: #553000">charaLoader</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">charaLoader</span>.<span style="color: #CC4747">loadAbilityByCharaId</span>(<span style="color: #553000">abilityCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *         <span style="color: #553000">abilityCB</span>.setupSelect...
     *         <span style="color: #553000">abilityCB</span>.query().set...
     *         <span style="color: #553000">abilityCB</span>.query().addOrderBy...
     *     }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     *     <span style="color: #3F7E5E">//}).withNestedReferrer(<span style="color: #553000">abilityLoader</span> -&gt; {</span>
     *     <span style="color: #3F7E5E">//    abilityLoader.load...</span>
     *     <span style="color: #3F7E5E">//});</span>
     * });
     * for (Chara chara : <span style="color: #553000">charaList</span>) {
     *     ... = chara.<span style="color: #CC4747">getAbilityByCharaIdList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setCharaId_InScope(pkList);
     * cb.query().addOrderBy_CharaId_Asc();
     * </pre>
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerLoaderGateway<LoaderOfAbility> loadAbilityByCharaId(ReferrerConditionSetupper<AbilityCB> refCBLambda) {
        myBhv().loadAbilityByCharaId(_selectedList, refCBLambda).withNestedReferrer(refLs -> _referrerAbilityByCharaId = refLs);
        return hd -> hd.handle(new LoaderOfAbility().ready(_referrerAbilityByCharaId, _selector));
    }

    protected List<Ability> _referrerAbilityByTargetCharaId;

    /**
     * Load referrer of abilityByTargetCharaIdList by the set-upper of referrer. <br>
     * ABILITY by TARGET_CHARA_ID, named 'abilityByTargetCharaIdList'.
     * <pre>
     * <span style="color: #0000C0">charaBhv</span>.<span style="color: #994747">load</span>(<span style="color: #553000">charaList</span>, <span style="color: #553000">charaLoader</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">charaLoader</span>.<span style="color: #CC4747">loadAbilityByTargetCharaId</span>(<span style="color: #553000">abilityCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *         <span style="color: #553000">abilityCB</span>.setupSelect...
     *         <span style="color: #553000">abilityCB</span>.query().set...
     *         <span style="color: #553000">abilityCB</span>.query().addOrderBy...
     *     }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     *     <span style="color: #3F7E5E">//}).withNestedReferrer(<span style="color: #553000">abilityLoader</span> -&gt; {</span>
     *     <span style="color: #3F7E5E">//    abilityLoader.load...</span>
     *     <span style="color: #3F7E5E">//});</span>
     * });
     * for (Chara chara : <span style="color: #553000">charaList</span>) {
     *     ... = chara.<span style="color: #CC4747">getAbilityByTargetCharaIdList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setTargetCharaId_InScope(pkList);
     * cb.query().addOrderBy_TargetCharaId_Asc();
     * </pre>
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerLoaderGateway<LoaderOfAbility> loadAbilityByTargetCharaId(ReferrerConditionSetupper<AbilityCB> refCBLambda) {
        myBhv().loadAbilityByTargetCharaId(_selectedList, refCBLambda).withNestedReferrer(refLs -> _referrerAbilityByTargetCharaId = refLs);
        return hd -> hd.handle(new LoaderOfAbility().ready(_referrerAbilityByTargetCharaId, _selector));
    }

    protected List<CharaImage> _referrerCharaImage;

    /**
     * Load referrer of charaImageList by the set-upper of referrer. <br>
     * CHARA_IMAGE by CHARA_ID, named 'charaImageList'.
     * <pre>
     * <span style="color: #0000C0">charaBhv</span>.<span style="color: #994747">load</span>(<span style="color: #553000">charaList</span>, <span style="color: #553000">charaLoader</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">charaLoader</span>.<span style="color: #CC4747">loadCharaImage</span>(<span style="color: #553000">imageCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *         <span style="color: #553000">imageCB</span>.setupSelect...
     *         <span style="color: #553000">imageCB</span>.query().set...
     *         <span style="color: #553000">imageCB</span>.query().addOrderBy...
     *     }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     *     <span style="color: #3F7E5E">//}).withNestedReferrer(<span style="color: #553000">imageLoader</span> -&gt; {</span>
     *     <span style="color: #3F7E5E">//    imageLoader.load...</span>
     *     <span style="color: #3F7E5E">//});</span>
     * });
     * for (Chara chara : <span style="color: #553000">charaList</span>) {
     *     ... = chara.<span style="color: #CC4747">getCharaImageList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setCharaId_InScope(pkList);
     * cb.query().addOrderBy_CharaId_Asc();
     * </pre>
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerLoaderGateway<LoaderOfCharaImage> loadCharaImage(ReferrerConditionSetupper<CharaImageCB> refCBLambda) {
        myBhv().loadCharaImage(_selectedList, refCBLambda).withNestedReferrer(refLs -> _referrerCharaImage = refLs);
        return hd -> hd.handle(new LoaderOfCharaImage().ready(_referrerCharaImage, _selector));
    }

    protected List<VillagePlayer> _referrerVillagePlayer;

    /**
     * Load referrer of villagePlayerList by the set-upper of referrer. <br>
     * VILLAGE_PLAYER by CHARA_ID, named 'villagePlayerList'.
     * <pre>
     * <span style="color: #0000C0">charaBhv</span>.<span style="color: #994747">load</span>(<span style="color: #553000">charaList</span>, <span style="color: #553000">charaLoader</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">charaLoader</span>.<span style="color: #CC4747">loadVillagePlayer</span>(<span style="color: #553000">playerCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *         <span style="color: #553000">playerCB</span>.setupSelect...
     *         <span style="color: #553000">playerCB</span>.query().set...
     *         <span style="color: #553000">playerCB</span>.query().addOrderBy...
     *     }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     *     <span style="color: #3F7E5E">//}).withNestedReferrer(<span style="color: #553000">playerLoader</span> -&gt; {</span>
     *     <span style="color: #3F7E5E">//    playerLoader.load...</span>
     *     <span style="color: #3F7E5E">//});</span>
     * });
     * for (Chara chara : <span style="color: #553000">charaList</span>) {
     *     ... = chara.<span style="color: #CC4747">getVillagePlayerList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setCharaId_InScope(pkList);
     * cb.query().addOrderBy_CharaId_Asc();
     * </pre>
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerLoaderGateway<LoaderOfVillagePlayer> loadVillagePlayer(ReferrerConditionSetupper<VillagePlayerCB> refCBLambda) {
        myBhv().loadVillagePlayer(_selectedList, refCBLambda).withNestedReferrer(refLs -> _referrerVillagePlayer = refLs);
        return hd -> hd.handle(new LoaderOfVillagePlayer().ready(_referrerVillagePlayer, _selector));
    }

    protected List<Vote> _referrerVoteByCharaId;

    /**
     * Load referrer of voteByCharaIdList by the set-upper of referrer. <br>
     * VOTE by CHARA_ID, named 'voteByCharaIdList'.
     * <pre>
     * <span style="color: #0000C0">charaBhv</span>.<span style="color: #994747">load</span>(<span style="color: #553000">charaList</span>, <span style="color: #553000">charaLoader</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">charaLoader</span>.<span style="color: #CC4747">loadVoteByCharaId</span>(<span style="color: #553000">voteCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *         <span style="color: #553000">voteCB</span>.setupSelect...
     *         <span style="color: #553000">voteCB</span>.query().set...
     *         <span style="color: #553000">voteCB</span>.query().addOrderBy...
     *     }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     *     <span style="color: #3F7E5E">//}).withNestedReferrer(<span style="color: #553000">voteLoader</span> -&gt; {</span>
     *     <span style="color: #3F7E5E">//    voteLoader.load...</span>
     *     <span style="color: #3F7E5E">//});</span>
     * });
     * for (Chara chara : <span style="color: #553000">charaList</span>) {
     *     ... = chara.<span style="color: #CC4747">getVoteByCharaIdList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setCharaId_InScope(pkList);
     * cb.query().addOrderBy_CharaId_Asc();
     * </pre>
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerLoaderGateway<LoaderOfVote> loadVoteByCharaId(ReferrerConditionSetupper<VoteCB> refCBLambda) {
        myBhv().loadVoteByCharaId(_selectedList, refCBLambda).withNestedReferrer(refLs -> _referrerVoteByCharaId = refLs);
        return hd -> hd.handle(new LoaderOfVote().ready(_referrerVoteByCharaId, _selector));
    }

    protected List<Vote> _referrerVoteByVoteCharaId;

    /**
     * Load referrer of voteByVoteCharaIdList by the set-upper of referrer. <br>
     * VOTE by VOTE_CHARA_ID, named 'voteByVoteCharaIdList'.
     * <pre>
     * <span style="color: #0000C0">charaBhv</span>.<span style="color: #994747">load</span>(<span style="color: #553000">charaList</span>, <span style="color: #553000">charaLoader</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">charaLoader</span>.<span style="color: #CC4747">loadVoteByVoteCharaId</span>(<span style="color: #553000">voteCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *         <span style="color: #553000">voteCB</span>.setupSelect...
     *         <span style="color: #553000">voteCB</span>.query().set...
     *         <span style="color: #553000">voteCB</span>.query().addOrderBy...
     *     }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     *     <span style="color: #3F7E5E">//}).withNestedReferrer(<span style="color: #553000">voteLoader</span> -&gt; {</span>
     *     <span style="color: #3F7E5E">//    voteLoader.load...</span>
     *     <span style="color: #3F7E5E">//});</span>
     * });
     * for (Chara chara : <span style="color: #553000">charaList</span>) {
     *     ... = chara.<span style="color: #CC4747">getVoteByVoteCharaIdList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setVoteCharaId_InScope(pkList);
     * cb.query().addOrderBy_VoteCharaId_Asc();
     * </pre>
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerLoaderGateway<LoaderOfVote> loadVoteByVoteCharaId(ReferrerConditionSetupper<VoteCB> refCBLambda) {
        myBhv().loadVoteByVoteCharaId(_selectedList, refCBLambda).withNestedReferrer(refLs -> _referrerVoteByVoteCharaId = refLs);
        return hd -> hd.handle(new LoaderOfVote().ready(_referrerVoteByVoteCharaId, _selector));
    }

    // ===================================================================================
    //                                                                    Pull out Foreign
    //                                                                    ================
    protected LoaderOfCharaGroup _foreignCharaGroupLoader;
    public LoaderOfCharaGroup pulloutCharaGroup() {
        if (_foreignCharaGroupLoader == null)
        { _foreignCharaGroupLoader = new LoaderOfCharaGroup().ready(myBhv().pulloutCharaGroup(_selectedList), _selector); }
        return _foreignCharaGroupLoader;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<Chara> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
