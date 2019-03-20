package com.ort.dbflute.bsbhv.loader;

import java.util.List;

import org.dbflute.bhv.*;
import org.dbflute.bhv.referrer.*;
import com.ort.dbflute.exbhv.*;
import com.ort.dbflute.exentity.*;
import com.ort.dbflute.cbean.*;

/**
 * The referrer loader of RANDOM_KEYWORD as TABLE. <br>
 * <pre>
 * [primary key]
 *     RANDOM_KEYWORD_ID
 *
 * [column]
 *     RANDOM_KEYWORD_ID, KEYWORD
 *
 * [sequence]
 *     
 *
 * [identity]
 *     RANDOM_KEYWORD_ID
 *
 * [version-no]
 *     
 *
 * [foreign table]
 *     
 *
 * [referrer table]
 *     RANDOM_CONTENT
 *
 * [foreign property]
 *     
 *
 * [referrer property]
 *     randomContentList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public class LoaderOfRandomKeyword {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<RandomKeyword> _selectedList;
    protected BehaviorSelector _selector;
    protected RandomKeywordBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfRandomKeyword ready(List<RandomKeyword> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected RandomKeywordBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(RandomKeywordBhv.class); return _myBhv; } }

    // ===================================================================================
    //                                                                       Load Referrer
    //                                                                       =============
    protected List<RandomContent> _referrerRandomContent;

    /**
     * Load referrer of randomContentList by the set-upper of referrer. <br>
     * RANDOM_CONTENT by RANDOM_KEYWORD_ID, named 'randomContentList'.
     * <pre>
     * <span style="color: #0000C0">randomKeywordBhv</span>.<span style="color: #994747">load</span>(<span style="color: #553000">randomKeywordList</span>, <span style="color: #553000">keywordLoader</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">keywordLoader</span>.<span style="color: #CC4747">loadRandomContent</span>(<span style="color: #553000">contentCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *         <span style="color: #553000">contentCB</span>.setupSelect...
     *         <span style="color: #553000">contentCB</span>.query().set...
     *         <span style="color: #553000">contentCB</span>.query().addOrderBy...
     *     }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     *     <span style="color: #3F7E5E">//}).withNestedReferrer(<span style="color: #553000">contentLoader</span> -&gt; {</span>
     *     <span style="color: #3F7E5E">//    contentLoader.load...</span>
     *     <span style="color: #3F7E5E">//});</span>
     * });
     * for (RandomKeyword randomKeyword : <span style="color: #553000">randomKeywordList</span>) {
     *     ... = randomKeyword.<span style="color: #CC4747">getRandomContentList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setRandomKeywordId_InScope(pkList);
     * cb.query().addOrderBy_RandomKeywordId_Asc();
     * </pre>
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerLoaderGateway<LoaderOfRandomContent> loadRandomContent(ReferrerConditionSetupper<RandomContentCB> refCBLambda) {
        myBhv().loadRandomContent(_selectedList, refCBLambda).withNestedReferrer(refLs -> _referrerRandomContent = refLs);
        return hd -> hd.handle(new LoaderOfRandomContent().ready(_referrerRandomContent, _selector));
    }

    // ===================================================================================
    //                                                                    Pull out Foreign
    //                                                                    ================
    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<RandomKeyword> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
