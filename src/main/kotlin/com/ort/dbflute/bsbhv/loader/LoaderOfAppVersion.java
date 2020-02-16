package com.ort.dbflute.bsbhv.loader;

import java.util.List;

import org.dbflute.bhv.*;
import com.ort.dbflute.exbhv.*;
import com.ort.dbflute.exentity.*;

/**
 * The referrer loader of APP_VERSION as TABLE. <br>
 * <pre>
 * [primary key]
 *     CLIENT_VERSION
 *
 * [column]
 *     CLIENT_VERSION
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
 *     
 *
 * [foreign property]
 *     
 *
 * [referrer property]
 *     
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public class LoaderOfAppVersion {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<AppVersion> _selectedList;
    protected BehaviorSelector _selector;
    protected AppVersionBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfAppVersion ready(List<AppVersion> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected AppVersionBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(AppVersionBhv.class); return _myBhv; } }

    // ===================================================================================
    //                                                                    Pull out Foreign
    //                                                                    ================
    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<AppVersion> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
