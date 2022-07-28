package com.ort.dbflute.bsbhv.loader;

import java.util.List;

import org.dbflute.bhv.*;
import com.ort.dbflute.exbhv.*;
import com.ort.dbflute.exentity.*;

/**
 * The referrer loader of PLAYER_INTRODUCE as TABLE. <br>
 * <pre>
 * [primary key]
 *     PLAYER_INTRODUCE_ID
 *
 * [column]
 *     PLAYER_INTRODUCE_ID, FROM_PLAYER_ID, TO_PLAYER_ID, REGISTER_DATETIME, REGISTER_TRACE, UPDATE_DATETIME, UPDATE_TRACE
 *
 * [sequence]
 *     
 *
 * [identity]
 *     PLAYER_INTRODUCE_ID
 *
 * [version-no]
 *     
 *
 * [foreign table]
 *     PLAYER
 *
 * [referrer table]
 *     
 *
 * [foreign property]
 *     playerByFromPlayerId, playerByToPlayerId
 *
 * [referrer property]
 *     
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public class LoaderOfPlayerIntroduce {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<PlayerIntroduce> _selectedList;
    protected BehaviorSelector _selector;
    protected PlayerIntroduceBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfPlayerIntroduce ready(List<PlayerIntroduce> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected PlayerIntroduceBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(PlayerIntroduceBhv.class); return _myBhv; } }

    // ===================================================================================
    //                                                                    Pull out Foreign
    //                                                                    ================
    protected LoaderOfPlayer _foreignPlayerByFromPlayerIdLoader;
    public LoaderOfPlayer pulloutPlayerByFromPlayerId() {
        if (_foreignPlayerByFromPlayerIdLoader == null)
        { _foreignPlayerByFromPlayerIdLoader = new LoaderOfPlayer().ready(myBhv().pulloutPlayerByFromPlayerId(_selectedList), _selector); }
        return _foreignPlayerByFromPlayerIdLoader;
    }

    protected LoaderOfPlayer _foreignPlayerByToPlayerIdLoader;
    public LoaderOfPlayer pulloutPlayerByToPlayerId() {
        if (_foreignPlayerByToPlayerIdLoader == null)
        { _foreignPlayerByToPlayerIdLoader = new LoaderOfPlayer().ready(myBhv().pulloutPlayerByToPlayerId(_selectedList), _selector); }
        return _foreignPlayerByToPlayerIdLoader;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<PlayerIntroduce> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
