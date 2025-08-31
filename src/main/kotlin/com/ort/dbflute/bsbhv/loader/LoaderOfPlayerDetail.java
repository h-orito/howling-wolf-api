package com.ort.dbflute.bsbhv.loader;

import java.util.List;

import org.dbflute.bhv.*;
import com.ort.dbflute.exbhv.*;
import com.ort.dbflute.exentity.*;

/**
 * The referrer loader of PLAYER_DETAIL as TABLE.
 * @author DBFlute(AutoGenerator)
 */
public class LoaderOfPlayerDetail {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<PlayerDetail> _selectedList;
    protected BehaviorSelector _selector;
    protected PlayerDetailBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfPlayerDetail ready(List<PlayerDetail> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected PlayerDetailBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(PlayerDetailBhv.class); return _myBhv; } }

    // ===================================================================================
    //                                                                    Pull out Foreign
    //                                                                    ================
    protected LoaderOfPlayer _foreignPlayerLoader;
    public LoaderOfPlayer pulloutPlayer() {
        if (_foreignPlayerLoader == null)
        { _foreignPlayerLoader = new LoaderOfPlayer().ready(myBhv().pulloutPlayer(_selectedList), _selector); }
        return _foreignPlayerLoader;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<PlayerDetail> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
