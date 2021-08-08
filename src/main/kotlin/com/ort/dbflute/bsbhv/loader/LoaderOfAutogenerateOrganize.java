package com.ort.dbflute.bsbhv.loader;

import java.util.List;

import org.dbflute.bhv.*;
import com.ort.dbflute.exbhv.*;
import com.ort.dbflute.exentity.*;

/**
 * The referrer loader of AUTOGENERATE_ORGANIZE as TABLE. <br>
 * <pre>
 * [primary key]
 *     VILLAGE_ID_MOD
 *
 * [column]
 *     VILLAGE_ID_MOD, ORGANIZATION, IS_AVAILABLE_DUMMY_SKILL, REGISTER_DATETIME, REGISTER_TRACE, UPDATE_DATETIME, UPDATE_TRACE
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
public class LoaderOfAutogenerateOrganize {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<AutogenerateOrganize> _selectedList;
    protected BehaviorSelector _selector;
    protected AutogenerateOrganizeBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfAutogenerateOrganize ready(List<AutogenerateOrganize> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected AutogenerateOrganizeBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(AutogenerateOrganizeBhv.class); return _myBhv; } }

    // ===================================================================================
    //                                                                    Pull out Foreign
    //                                                                    ================
    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<AutogenerateOrganize> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
