package com.ort.dbflute.bsbhv.loader;

import java.util.List;

import org.dbflute.bhv.*;
import com.ort.dbflute.exbhv.*;
import com.ort.dbflute.exentity.*;

/**
 * The referrer loader of PLAYER_INTRODUCE as TABLE.
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
