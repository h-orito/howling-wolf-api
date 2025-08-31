package com.ort.dbflute.bsbhv.loader;

import java.util.List;

import org.dbflute.bhv.*;
import com.ort.dbflute.exbhv.*;
import com.ort.dbflute.exentity.*;

/**
 * The referrer loader of COMMIT as TABLE.
 * @author DBFlute(AutoGenerator)
 */
public class LoaderOfCommit {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<Commit> _selectedList;
    protected BehaviorSelector _selector;
    protected CommitBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfCommit ready(List<Commit> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected CommitBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(CommitBhv.class); return _myBhv; } }

    // ===================================================================================
    //                                                                    Pull out Foreign
    //                                                                    ================
    protected LoaderOfVillageDay _foreignVillageDayLoader;
    public LoaderOfVillageDay pulloutVillageDay() {
        if (_foreignVillageDayLoader == null)
        { _foreignVillageDayLoader = new LoaderOfVillageDay().ready(myBhv().pulloutVillageDay(_selectedList), _selector); }
        return _foreignVillageDayLoader;
    }

    protected LoaderOfVillagePlayer _foreignVillagePlayerLoader;
    public LoaderOfVillagePlayer pulloutVillagePlayer() {
        if (_foreignVillagePlayerLoader == null)
        { _foreignVillagePlayerLoader = new LoaderOfVillagePlayer().ready(myBhv().pulloutVillagePlayer(_selectedList), _selector); }
        return _foreignVillagePlayerLoader;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<Commit> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
