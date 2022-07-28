package com.ort.dbflute.bsbhv.loader;

import java.util.List;

import org.dbflute.bhv.*;
import org.dbflute.bhv.referrer.*;
import com.ort.dbflute.exbhv.*;
import com.ort.dbflute.exentity.*;
import com.ort.dbflute.cbean.*;

/**
 * The referrer loader of PLAYER as TABLE. <br>
 * <pre>
 * [primary key]
 *     PLAYER_ID
 *
 * [column]
 *     PLAYER_ID, UID, NICKNAME, TWITTER_USER_NAME, AUTHORITY_CODE, IS_RESTRICTED_PARTICIPATION, REGISTER_DATETIME, REGISTER_TRACE, UPDATE_DATETIME, UPDATE_TRACE
 *
 * [sequence]
 *     
 *
 * [identity]
 *     PLAYER_ID
 *
 * [version-no]
 *     
 *
 * [foreign table]
 *     AUTHORITY, PLAYER_DETAIL(AsOne)
 *
 * [referrer table]
 *     BLACKLIST_PLAYER, PLAYER_INTRODUCE, VILLAGE, VILLAGE_PLAYER, PLAYER_DETAIL
 *
 * [foreign property]
 *     authority, playerDetailAsOne
 *
 * [referrer property]
 *     blacklistPlayerByFromPlayerIdList, blacklistPlayerByToPlayerIdList, playerIntroduceByFromPlayerIdList, playerIntroduceByToPlayerIdList, villageList, villagePlayerList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public class LoaderOfPlayer {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<Player> _selectedList;
    protected BehaviorSelector _selector;
    protected PlayerBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfPlayer ready(List<Player> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected PlayerBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(PlayerBhv.class); return _myBhv; } }

    // ===================================================================================
    //                                                                       Load Referrer
    //                                                                       =============
    protected List<BlacklistPlayer> _referrerBlacklistPlayerByFromPlayerId;

    /**
     * Load referrer of blacklistPlayerByFromPlayerIdList by the set-upper of referrer. <br>
     * BLACKLIST_PLAYER by FROM_PLAYER_ID, named 'blacklistPlayerByFromPlayerIdList'.
     * <pre>
     * <span style="color: #0000C0">playerBhv</span>.<span style="color: #994747">load</span>(<span style="color: #553000">playerList</span>, <span style="color: #553000">playerLoader</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">playerLoader</span>.<span style="color: #CC4747">loadBlacklistPlayerByFromPlayerId</span>(<span style="color: #553000">playerCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *         <span style="color: #553000">playerCB</span>.setupSelect...
     *         <span style="color: #553000">playerCB</span>.query().set...
     *         <span style="color: #553000">playerCB</span>.query().addOrderBy...
     *     }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     *     <span style="color: #3F7E5E">//}).withNestedReferrer(<span style="color: #553000">playerLoader</span> -&gt; {</span>
     *     <span style="color: #3F7E5E">//    playerLoader.load...</span>
     *     <span style="color: #3F7E5E">//});</span>
     * });
     * for (Player player : <span style="color: #553000">playerList</span>) {
     *     ... = player.<span style="color: #CC4747">getBlacklistPlayerByFromPlayerIdList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setFromPlayerId_InScope(pkList);
     * cb.query().addOrderBy_FromPlayerId_Asc();
     * </pre>
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerLoaderGateway<LoaderOfBlacklistPlayer> loadBlacklistPlayerByFromPlayerId(ReferrerConditionSetupper<BlacklistPlayerCB> refCBLambda) {
        myBhv().loadBlacklistPlayerByFromPlayerId(_selectedList, refCBLambda).withNestedReferrer(refLs -> _referrerBlacklistPlayerByFromPlayerId = refLs);
        return hd -> hd.handle(new LoaderOfBlacklistPlayer().ready(_referrerBlacklistPlayerByFromPlayerId, _selector));
    }

    protected List<BlacklistPlayer> _referrerBlacklistPlayerByToPlayerId;

    /**
     * Load referrer of blacklistPlayerByToPlayerIdList by the set-upper of referrer. <br>
     * BLACKLIST_PLAYER by TO_PLAYER_ID, named 'blacklistPlayerByToPlayerIdList'.
     * <pre>
     * <span style="color: #0000C0">playerBhv</span>.<span style="color: #994747">load</span>(<span style="color: #553000">playerList</span>, <span style="color: #553000">playerLoader</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">playerLoader</span>.<span style="color: #CC4747">loadBlacklistPlayerByToPlayerId</span>(<span style="color: #553000">playerCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *         <span style="color: #553000">playerCB</span>.setupSelect...
     *         <span style="color: #553000">playerCB</span>.query().set...
     *         <span style="color: #553000">playerCB</span>.query().addOrderBy...
     *     }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     *     <span style="color: #3F7E5E">//}).withNestedReferrer(<span style="color: #553000">playerLoader</span> -&gt; {</span>
     *     <span style="color: #3F7E5E">//    playerLoader.load...</span>
     *     <span style="color: #3F7E5E">//});</span>
     * });
     * for (Player player : <span style="color: #553000">playerList</span>) {
     *     ... = player.<span style="color: #CC4747">getBlacklistPlayerByToPlayerIdList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setToPlayerId_InScope(pkList);
     * cb.query().addOrderBy_ToPlayerId_Asc();
     * </pre>
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerLoaderGateway<LoaderOfBlacklistPlayer> loadBlacklistPlayerByToPlayerId(ReferrerConditionSetupper<BlacklistPlayerCB> refCBLambda) {
        myBhv().loadBlacklistPlayerByToPlayerId(_selectedList, refCBLambda).withNestedReferrer(refLs -> _referrerBlacklistPlayerByToPlayerId = refLs);
        return hd -> hd.handle(new LoaderOfBlacklistPlayer().ready(_referrerBlacklistPlayerByToPlayerId, _selector));
    }

    protected List<PlayerIntroduce> _referrerPlayerIntroduceByFromPlayerId;

    /**
     * Load referrer of playerIntroduceByFromPlayerIdList by the set-upper of referrer. <br>
     * PLAYER_INTRODUCE by FROM_PLAYER_ID, named 'playerIntroduceByFromPlayerIdList'.
     * <pre>
     * <span style="color: #0000C0">playerBhv</span>.<span style="color: #994747">load</span>(<span style="color: #553000">playerList</span>, <span style="color: #553000">playerLoader</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">playerLoader</span>.<span style="color: #CC4747">loadPlayerIntroduceByFromPlayerId</span>(<span style="color: #553000">introduceCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *         <span style="color: #553000">introduceCB</span>.setupSelect...
     *         <span style="color: #553000">introduceCB</span>.query().set...
     *         <span style="color: #553000">introduceCB</span>.query().addOrderBy...
     *     }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     *     <span style="color: #3F7E5E">//}).withNestedReferrer(<span style="color: #553000">introduceLoader</span> -&gt; {</span>
     *     <span style="color: #3F7E5E">//    introduceLoader.load...</span>
     *     <span style="color: #3F7E5E">//});</span>
     * });
     * for (Player player : <span style="color: #553000">playerList</span>) {
     *     ... = player.<span style="color: #CC4747">getPlayerIntroduceByFromPlayerIdList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setFromPlayerId_InScope(pkList);
     * cb.query().addOrderBy_FromPlayerId_Asc();
     * </pre>
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerLoaderGateway<LoaderOfPlayerIntroduce> loadPlayerIntroduceByFromPlayerId(ReferrerConditionSetupper<PlayerIntroduceCB> refCBLambda) {
        myBhv().loadPlayerIntroduceByFromPlayerId(_selectedList, refCBLambda).withNestedReferrer(refLs -> _referrerPlayerIntroduceByFromPlayerId = refLs);
        return hd -> hd.handle(new LoaderOfPlayerIntroduce().ready(_referrerPlayerIntroduceByFromPlayerId, _selector));
    }

    protected List<PlayerIntroduce> _referrerPlayerIntroduceByToPlayerId;

    /**
     * Load referrer of playerIntroduceByToPlayerIdList by the set-upper of referrer. <br>
     * PLAYER_INTRODUCE by TO_PLAYER_ID, named 'playerIntroduceByToPlayerIdList'.
     * <pre>
     * <span style="color: #0000C0">playerBhv</span>.<span style="color: #994747">load</span>(<span style="color: #553000">playerList</span>, <span style="color: #553000">playerLoader</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">playerLoader</span>.<span style="color: #CC4747">loadPlayerIntroduceByToPlayerId</span>(<span style="color: #553000">introduceCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *         <span style="color: #553000">introduceCB</span>.setupSelect...
     *         <span style="color: #553000">introduceCB</span>.query().set...
     *         <span style="color: #553000">introduceCB</span>.query().addOrderBy...
     *     }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     *     <span style="color: #3F7E5E">//}).withNestedReferrer(<span style="color: #553000">introduceLoader</span> -&gt; {</span>
     *     <span style="color: #3F7E5E">//    introduceLoader.load...</span>
     *     <span style="color: #3F7E5E">//});</span>
     * });
     * for (Player player : <span style="color: #553000">playerList</span>) {
     *     ... = player.<span style="color: #CC4747">getPlayerIntroduceByToPlayerIdList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setToPlayerId_InScope(pkList);
     * cb.query().addOrderBy_ToPlayerId_Asc();
     * </pre>
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerLoaderGateway<LoaderOfPlayerIntroduce> loadPlayerIntroduceByToPlayerId(ReferrerConditionSetupper<PlayerIntroduceCB> refCBLambda) {
        myBhv().loadPlayerIntroduceByToPlayerId(_selectedList, refCBLambda).withNestedReferrer(refLs -> _referrerPlayerIntroduceByToPlayerId = refLs);
        return hd -> hd.handle(new LoaderOfPlayerIntroduce().ready(_referrerPlayerIntroduceByToPlayerId, _selector));
    }

    protected List<Village> _referrerVillage;

    /**
     * Load referrer of villageList by the set-upper of referrer. <br>
     * VILLAGE by CREATE_PLAYER_ID, named 'villageList'.
     * <pre>
     * <span style="color: #0000C0">playerBhv</span>.<span style="color: #994747">load</span>(<span style="color: #553000">playerList</span>, <span style="color: #553000">playerLoader</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">playerLoader</span>.<span style="color: #CC4747">loadVillage</span>(<span style="color: #553000">villageCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *         <span style="color: #553000">villageCB</span>.setupSelect...
     *         <span style="color: #553000">villageCB</span>.query().set...
     *         <span style="color: #553000">villageCB</span>.query().addOrderBy...
     *     }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     *     <span style="color: #3F7E5E">//}).withNestedReferrer(<span style="color: #553000">villageLoader</span> -&gt; {</span>
     *     <span style="color: #3F7E5E">//    villageLoader.load...</span>
     *     <span style="color: #3F7E5E">//});</span>
     * });
     * for (Player player : <span style="color: #553000">playerList</span>) {
     *     ... = player.<span style="color: #CC4747">getVillageList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setCreatePlayerId_InScope(pkList);
     * cb.query().addOrderBy_CreatePlayerId_Asc();
     * </pre>
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerLoaderGateway<LoaderOfVillage> loadVillage(ReferrerConditionSetupper<VillageCB> refCBLambda) {
        myBhv().loadVillage(_selectedList, refCBLambda).withNestedReferrer(refLs -> _referrerVillage = refLs);
        return hd -> hd.handle(new LoaderOfVillage().ready(_referrerVillage, _selector));
    }

    protected List<VillagePlayer> _referrerVillagePlayer;

    /**
     * Load referrer of villagePlayerList by the set-upper of referrer. <br>
     * VILLAGE_PLAYER by PLAYER_ID, named 'villagePlayerList'.
     * <pre>
     * <span style="color: #0000C0">playerBhv</span>.<span style="color: #994747">load</span>(<span style="color: #553000">playerList</span>, <span style="color: #553000">playerLoader</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">playerLoader</span>.<span style="color: #CC4747">loadVillagePlayer</span>(<span style="color: #553000">playerCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *         <span style="color: #553000">playerCB</span>.setupSelect...
     *         <span style="color: #553000">playerCB</span>.query().set...
     *         <span style="color: #553000">playerCB</span>.query().addOrderBy...
     *     }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     *     <span style="color: #3F7E5E">//}).withNestedReferrer(<span style="color: #553000">playerLoader</span> -&gt; {</span>
     *     <span style="color: #3F7E5E">//    playerLoader.load...</span>
     *     <span style="color: #3F7E5E">//});</span>
     * });
     * for (Player player : <span style="color: #553000">playerList</span>) {
     *     ... = player.<span style="color: #CC4747">getVillagePlayerList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setPlayerId_InScope(pkList);
     * cb.query().addOrderBy_PlayerId_Asc();
     * </pre>
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerLoaderGateway<LoaderOfVillagePlayer> loadVillagePlayer(ReferrerConditionSetupper<VillagePlayerCB> refCBLambda) {
        myBhv().loadVillagePlayer(_selectedList, refCBLambda).withNestedReferrer(refLs -> _referrerVillagePlayer = refLs);
        return hd -> hd.handle(new LoaderOfVillagePlayer().ready(_referrerVillagePlayer, _selector));
    }

    // ===================================================================================
    //                                                                    Pull out Foreign
    //                                                                    ================
    protected LoaderOfAuthority _foreignAuthorityLoader;
    public LoaderOfAuthority pulloutAuthority() {
        if (_foreignAuthorityLoader == null)
        { _foreignAuthorityLoader = new LoaderOfAuthority().ready(myBhv().pulloutAuthority(_selectedList), _selector); }
        return _foreignAuthorityLoader;
    }

    protected LoaderOfPlayerDetail _foreignPlayerDetailAsOneLoader;
    public LoaderOfPlayerDetail pulloutPlayerDetailAsOne() {
        if (_foreignPlayerDetailAsOneLoader == null)
        { _foreignPlayerDetailAsOneLoader = new LoaderOfPlayerDetail().ready(myBhv().pulloutPlayerDetailAsOne(_selectedList), _selector); }
        return _foreignPlayerDetailAsOneLoader;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<Player> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
