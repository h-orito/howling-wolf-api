package com.ort.dbflute.bsbhv.loader;

import java.util.List;

import org.dbflute.bhv.*;
import org.dbflute.bhv.referrer.*;
import com.ort.dbflute.exbhv.*;
import com.ort.dbflute.exentity.*;
import com.ort.dbflute.cbean.*;

/**
 * The referrer loader of NOONNIGHT as TABLE. <br>
 * <pre>
 * [primary key]
 *     NOONNIGHT_CODE
 *
 * [column]
 *     NOONNIGHT_CODE, NOONNIGHT_NAME, DISP_ORDER
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
 *     VILLAGE_DAY
 *
 * [foreign property]
 *     
 *
 * [referrer property]
 *     villageDayList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public class LoaderOfNoonnight {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<Noonnight> _selectedList;
    protected BehaviorSelector _selector;
    protected NoonnightBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfNoonnight ready(List<Noonnight> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected NoonnightBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(NoonnightBhv.class); return _myBhv; } }

    // ===================================================================================
    //                                                                       Load Referrer
    //                                                                       =============
    protected List<VillageDay> _referrerVillageDay;

    /**
     * Load referrer of villageDayList by the set-upper of referrer. <br>
     * VILLAGE_DAY by NOONNIGHT_CODE, named 'villageDayList'.
     * <pre>
     * <span style="color: #0000C0">noonnightBhv</span>.<span style="color: #994747">load</span>(<span style="color: #553000">noonnightList</span>, <span style="color: #553000">noonnightLoader</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">noonnightLoader</span>.<span style="color: #CC4747">loadVillageDay</span>(<span style="color: #553000">dayCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *         <span style="color: #553000">dayCB</span>.setupSelect...
     *         <span style="color: #553000">dayCB</span>.query().set...
     *         <span style="color: #553000">dayCB</span>.query().addOrderBy...
     *     }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     *     <span style="color: #3F7E5E">//}).withNestedReferrer(<span style="color: #553000">dayLoader</span> -&gt; {</span>
     *     <span style="color: #3F7E5E">//    dayLoader.load...</span>
     *     <span style="color: #3F7E5E">//});</span>
     * });
     * for (Noonnight noonnight : <span style="color: #553000">noonnightList</span>) {
     *     ... = noonnight.<span style="color: #CC4747">getVillageDayList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setNoonnightCode_InScope(pkList);
     * cb.query().addOrderBy_NoonnightCode_Asc();
     * </pre>
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerLoaderGateway<LoaderOfVillageDay> loadVillageDay(ReferrerConditionSetupper<VillageDayCB> refCBLambda) {
        myBhv().loadVillageDay(_selectedList, refCBLambda).withNestedReferrer(refLs -> _referrerVillageDay = refLs);
        return hd -> hd.handle(new LoaderOfVillageDay().ready(_referrerVillageDay, _selector));
    }

    // ===================================================================================
    //                                                                    Pull out Foreign
    //                                                                    ================
    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<Noonnight> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
