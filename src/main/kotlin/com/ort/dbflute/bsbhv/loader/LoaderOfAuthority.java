package com.ort.dbflute.bsbhv.loader;

import java.util.List;

import org.dbflute.bhv.*;
import org.dbflute.bhv.referrer.*;
import com.ort.dbflute.exbhv.*;
import com.ort.dbflute.exentity.*;
import com.ort.dbflute.cbean.*;

/**
 * The referrer loader of AUTHORITY as TABLE.
 * @author DBFlute(AutoGenerator)
 */
public class LoaderOfAuthority {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<Authority> _selectedList;
    protected BehaviorSelector _selector;
    protected AuthorityBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfAuthority ready(List<Authority> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected AuthorityBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(AuthorityBhv.class); return _myBhv; } }

    // ===================================================================================
    //                                                                       Load Referrer
    //                                                                       =============
    protected List<Player> _referrerPlayer;

    /**
     * Load referrer of playerList by the set-upper of referrer. <br>
     * PLAYER by AUTHORITY_CODE, named 'playerList'.
     * <pre>
     * <span style="color: #0000C0">authorityBhv</span>.<span style="color: #994747">load</span>(<span style="color: #553000">authorityList</span>, <span style="color: #553000">authorityLoader</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">authorityLoader</span>.<span style="color: #CC4747">loadPlayer</span>(<span style="color: #553000">playerCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *         <span style="color: #553000">playerCB</span>.setupSelect...
     *         <span style="color: #553000">playerCB</span>.query().set...
     *         <span style="color: #553000">playerCB</span>.query().addOrderBy...
     *     }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     *     <span style="color: #3F7E5E">//}).withNestedReferrer(<span style="color: #553000">playerLoader</span> -&gt; {</span>
     *     <span style="color: #3F7E5E">//    playerLoader.load...</span>
     *     <span style="color: #3F7E5E">//});</span>
     * });
     * for (Authority authority : <span style="color: #553000">authorityList</span>) {
     *     ... = authority.<span style="color: #CC4747">getPlayerList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setAuthorityCode_InScope(pkList);
     * cb.query().addOrderBy_AuthorityCode_Asc();
     * </pre>
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerLoaderGateway<LoaderOfPlayer> loadPlayer(ReferrerConditionSetupper<PlayerCB> refCBLambda) {
        myBhv().loadPlayer(_selectedList, refCBLambda).withNestedReferrer(refLs -> _referrerPlayer = refLs);
        return hd -> hd.handle(new LoaderOfPlayer().ready(_referrerPlayer, _selector));
    }

    // ===================================================================================
    //                                                                    Pull out Foreign
    //                                                                    ================
    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<Authority> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
