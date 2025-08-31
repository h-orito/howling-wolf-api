package com.ort.dbflute.bsbhv.loader;

import java.util.List;

import org.dbflute.bhv.*;
import com.ort.dbflute.exbhv.*;
import com.ort.dbflute.exentity.*;

/**
 * The referrer loader of AUTOGENERATE_TIME as TABLE.
 * @author DBFlute(AutoGenerator)
 */
public class LoaderOfAutogenerateTime {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<AutogenerateTime> _selectedList;
    protected BehaviorSelector _selector;
    protected AutogenerateTimeBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfAutogenerateTime ready(List<AutogenerateTime> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected AutogenerateTimeBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(AutogenerateTimeBhv.class); return _myBhv; } }

    // ===================================================================================
    //                                                                    Pull out Foreign
    //                                                                    ================
    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<AutogenerateTime> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
