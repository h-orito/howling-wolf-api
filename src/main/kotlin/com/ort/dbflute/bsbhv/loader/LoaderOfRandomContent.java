package com.ort.dbflute.bsbhv.loader;

import java.util.List;

import org.dbflute.bhv.*;
import com.ort.dbflute.exbhv.*;
import com.ort.dbflute.exentity.*;

/**
 * The referrer loader of RANDOM_CONTENT as TABLE. <br>
 * <pre>
 * [primary key]
 *     RANDOM_CONTENT_ID
 *
 * [column]
 *     RANDOM_CONTENT_ID, RANDOM_KEYWORD_ID, RANDOM_MESSAGE
 *
 * [sequence]
 *     
 *
 * [identity]
 *     RANDOM_CONTENT_ID
 *
 * [version-no]
 *     
 *
 * [foreign table]
 *     RANDOM_KEYWORD
 *
 * [referrer table]
 *     
 *
 * [foreign property]
 *     randomKeyword
 *
 * [referrer property]
 *     
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public class LoaderOfRandomContent {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<RandomContent> _selectedList;
    protected BehaviorSelector _selector;
    protected RandomContentBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfRandomContent ready(List<RandomContent> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected RandomContentBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(RandomContentBhv.class); return _myBhv; } }

    // ===================================================================================
    //                                                                    Pull out Foreign
    //                                                                    ================
    protected LoaderOfRandomKeyword _foreignRandomKeywordLoader;
    public LoaderOfRandomKeyword pulloutRandomKeyword() {
        if (_foreignRandomKeywordLoader == null)
        { _foreignRandomKeywordLoader = new LoaderOfRandomKeyword().ready(myBhv().pulloutRandomKeyword(_selectedList), _selector); }
        return _foreignRandomKeywordLoader;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<RandomContent> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
