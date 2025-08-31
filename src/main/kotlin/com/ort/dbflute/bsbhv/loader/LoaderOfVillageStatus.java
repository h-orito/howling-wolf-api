package com.ort.dbflute.bsbhv.loader;

import java.util.List;

import org.dbflute.bhv.*;
import org.dbflute.bhv.referrer.*;
import com.ort.dbflute.exbhv.*;
import com.ort.dbflute.exentity.*;
import com.ort.dbflute.cbean.*;

/**
 * The referrer loader of VILLAGE_STATUS as TABLE.
 * @author DBFlute(AutoGenerator)
 */
public class LoaderOfVillageStatus {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<VillageStatus> _selectedList;
    protected BehaviorSelector _selector;
    protected VillageStatusBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfVillageStatus ready(List<VillageStatus> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected VillageStatusBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(VillageStatusBhv.class); return _myBhv; } }

    // ===================================================================================
    //                                                                       Load Referrer
    //                                                                       =============
    protected List<Village> _referrerVillage;

    /**
     * Load referrer of villageList by the set-upper of referrer. <br>
     * VILLAGE by VILLAGE_STATUS_CODE, named 'villageList'.
     * <pre>
     * <span style="color: #0000C0">villageStatusBhv</span>.<span style="color: #994747">load</span>(<span style="color: #553000">villageStatusList</span>, <span style="color: #553000">statusLoader</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">statusLoader</span>.<span style="color: #CC4747">loadVillage</span>(<span style="color: #553000">villageCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *         <span style="color: #553000">villageCB</span>.setupSelect...
     *         <span style="color: #553000">villageCB</span>.query().set...
     *         <span style="color: #553000">villageCB</span>.query().addOrderBy...
     *     }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     *     <span style="color: #3F7E5E">//}).withNestedReferrer(<span style="color: #553000">villageLoader</span> -&gt; {</span>
     *     <span style="color: #3F7E5E">//    villageLoader.load...</span>
     *     <span style="color: #3F7E5E">//});</span>
     * });
     * for (VillageStatus villageStatus : <span style="color: #553000">villageStatusList</span>) {
     *     ... = villageStatus.<span style="color: #CC4747">getVillageList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setVillageStatusCode_InScope(pkList);
     * cb.query().addOrderBy_VillageStatusCode_Asc();
     * </pre>
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerLoaderGateway<LoaderOfVillage> loadVillage(ReferrerConditionSetupper<VillageCB> refCBLambda) {
        myBhv().loadVillage(_selectedList, refCBLambda).withNestedReferrer(refLs -> _referrerVillage = refLs);
        return hd -> hd.handle(new LoaderOfVillage().ready(_referrerVillage, _selector));
    }

    // ===================================================================================
    //                                                                    Pull out Foreign
    //                                                                    ================
    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<VillageStatus> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
