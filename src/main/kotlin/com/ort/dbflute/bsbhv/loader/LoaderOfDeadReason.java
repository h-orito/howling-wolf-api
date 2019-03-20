package com.ort.dbflute.bsbhv.loader;

import java.util.List;

import org.dbflute.bhv.*;
import org.dbflute.bhv.referrer.*;
import com.ort.dbflute.exbhv.*;
import com.ort.dbflute.exentity.*;
import com.ort.dbflute.cbean.*;

/**
 * The referrer loader of DEAD_REASON as TABLE. <br>
 * <pre>
 * [primary key]
 *     DEAD_REASON_CODE
 *
 * [column]
 *     DEAD_REASON_CODE, DEAD_REASON_NAME
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
 *     VILLAGE_PLAYER
 *
 * [foreign property]
 *     
 *
 * [referrer property]
 *     villagePlayerList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public class LoaderOfDeadReason {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<DeadReason> _selectedList;
    protected BehaviorSelector _selector;
    protected DeadReasonBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfDeadReason ready(List<DeadReason> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected DeadReasonBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(DeadReasonBhv.class); return _myBhv; } }

    // ===================================================================================
    //                                                                       Load Referrer
    //                                                                       =============
    protected List<VillagePlayer> _referrerVillagePlayer;

    /**
     * Load referrer of villagePlayerList by the set-upper of referrer. <br>
     * VILLAGE_PLAYER by DEAD_REASON_CODE, named 'villagePlayerList'.
     * <pre>
     * <span style="color: #0000C0">deadReasonBhv</span>.<span style="color: #994747">load</span>(<span style="color: #553000">deadReasonList</span>, <span style="color: #553000">reasonLoader</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">reasonLoader</span>.<span style="color: #CC4747">loadVillagePlayer</span>(<span style="color: #553000">playerCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *         <span style="color: #553000">playerCB</span>.setupSelect...
     *         <span style="color: #553000">playerCB</span>.query().set...
     *         <span style="color: #553000">playerCB</span>.query().addOrderBy...
     *     }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     *     <span style="color: #3F7E5E">//}).withNestedReferrer(<span style="color: #553000">playerLoader</span> -&gt; {</span>
     *     <span style="color: #3F7E5E">//    playerLoader.load...</span>
     *     <span style="color: #3F7E5E">//});</span>
     * });
     * for (DeadReason deadReason : <span style="color: #553000">deadReasonList</span>) {
     *     ... = deadReason.<span style="color: #CC4747">getVillagePlayerList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setDeadReasonCode_InScope(pkList);
     * cb.query().addOrderBy_DeadReasonCode_Asc();
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
    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<DeadReason> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
