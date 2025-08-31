package com.ort.dbflute.bsbhv.loader;

import java.util.List;

import org.dbflute.bhv.*;
import com.ort.dbflute.exbhv.*;
import com.ort.dbflute.exentity.*;

/**
 * The referrer loader of TWITTER_USER as TABLE.
 * @author DBFlute(AutoGenerator)
 */
public class LoaderOfTwitterUser {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<TwitterUser> _selectedList;
    protected BehaviorSelector _selector;
    protected TwitterUserBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfTwitterUser ready(List<TwitterUser> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected TwitterUserBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(TwitterUserBhv.class); return _myBhv; } }

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
    public List<TwitterUser> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
