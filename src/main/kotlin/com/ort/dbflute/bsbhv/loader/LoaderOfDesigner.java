package com.ort.dbflute.bsbhv.loader;

import java.util.List;

import org.dbflute.bhv.*;
import org.dbflute.bhv.referrer.*;
import com.ort.dbflute.exbhv.*;
import com.ort.dbflute.exentity.*;
import com.ort.dbflute.cbean.*;

/**
 * The referrer loader of DESIGNER as TABLE. <br>
 * <pre>
 * [primary key]
 *     DESIGNER_ID
 *
 * [column]
 *     DESIGNER_ID, DESIGNER_NAME, REGISTER_DATETIME, REGISTER_TRACE, UPDATE_DATETIME, UPDATE_TRACE
 *
 * [sequence]
 *     
 *
 * [identity]
 *     DESIGNER_ID
 *
 * [version-no]
 *     
 *
 * [foreign table]
 *     
 *
 * [referrer table]
 *     CHARA_GROUP
 *
 * [foreign property]
 *     
 *
 * [referrer property]
 *     charaGroupList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public class LoaderOfDesigner {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<Designer> _selectedList;
    protected BehaviorSelector _selector;
    protected DesignerBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfDesigner ready(List<Designer> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected DesignerBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(DesignerBhv.class); return _myBhv; } }

    // ===================================================================================
    //                                                                       Load Referrer
    //                                                                       =============
    protected List<CharaGroup> _referrerCharaGroup;

    /**
     * Load referrer of charaGroupList by the set-upper of referrer. <br>
     * CHARA_GROUP by DESIGNER_ID, named 'charaGroupList'.
     * <pre>
     * <span style="color: #0000C0">designerBhv</span>.<span style="color: #994747">load</span>(<span style="color: #553000">designerList</span>, <span style="color: #553000">designerLoader</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">designerLoader</span>.<span style="color: #CC4747">loadCharaGroup</span>(<span style="color: #553000">groupCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *         <span style="color: #553000">groupCB</span>.setupSelect...
     *         <span style="color: #553000">groupCB</span>.query().set...
     *         <span style="color: #553000">groupCB</span>.query().addOrderBy...
     *     }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     *     <span style="color: #3F7E5E">//}).withNestedReferrer(<span style="color: #553000">groupLoader</span> -&gt; {</span>
     *     <span style="color: #3F7E5E">//    groupLoader.load...</span>
     *     <span style="color: #3F7E5E">//});</span>
     * });
     * for (Designer designer : <span style="color: #553000">designerList</span>) {
     *     ... = designer.<span style="color: #CC4747">getCharaGroupList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setDesignerId_InScope(pkList);
     * cb.query().addOrderBy_DesignerId_Asc();
     * </pre>
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerLoaderGateway<LoaderOfCharaGroup> loadCharaGroup(ReferrerConditionSetupper<CharaGroupCB> refCBLambda) {
        myBhv().loadCharaGroup(_selectedList, refCBLambda).withNestedReferrer(refLs -> _referrerCharaGroup = refLs);
        return hd -> hd.handle(new LoaderOfCharaGroup().ready(_referrerCharaGroup, _selector));
    }

    // ===================================================================================
    //                                                                    Pull out Foreign
    //                                                                    ================
    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<Designer> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
