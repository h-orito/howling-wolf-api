package com.ort.dbflute.bsbhv.loader;

import java.util.List;

import org.dbflute.bhv.*;
import org.dbflute.bhv.referrer.*;
import com.ort.dbflute.exbhv.*;
import com.ort.dbflute.exentity.*;
import com.ort.dbflute.cbean.*;

/**
 * The referrer loader of VILLAGE_SETTING_ITEM as TABLE. <br>
 * <pre>
 * [primary key]
 *     VILLAGE_SETTING_ITEM_CODE
 *
 * [column]
 *     VILLAGE_SETTING_ITEM_CODE, VILLAGE_SETTING_ITEM_NAME, DISP_ORDER
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
 *     VILLAGE_SETTING
 *
 * [foreign property]
 *     
 *
 * [referrer property]
 *     villageSettingList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public class LoaderOfVillageSettingItem {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<VillageSettingItem> _selectedList;
    protected BehaviorSelector _selector;
    protected VillageSettingItemBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfVillageSettingItem ready(List<VillageSettingItem> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected VillageSettingItemBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(VillageSettingItemBhv.class); return _myBhv; } }

    // ===================================================================================
    //                                                                       Load Referrer
    //                                                                       =============
    protected List<VillageSetting> _referrerVillageSetting;

    /**
     * Load referrer of villageSettingList by the set-upper of referrer. <br>
     * VILLAGE_SETTING by VILLAGE_SETTING_ITEM_CODE, named 'villageSettingList'.
     * <pre>
     * <span style="color: #0000C0">villageSettingItemBhv</span>.<span style="color: #994747">load</span>(<span style="color: #553000">villageSettingItemList</span>, <span style="color: #553000">itemLoader</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">itemLoader</span>.<span style="color: #CC4747">loadVillageSetting</span>(<span style="color: #553000">settingCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *         <span style="color: #553000">settingCB</span>.setupSelect...
     *         <span style="color: #553000">settingCB</span>.query().set...
     *         <span style="color: #553000">settingCB</span>.query().addOrderBy...
     *     }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     *     <span style="color: #3F7E5E">//}).withNestedReferrer(<span style="color: #553000">settingLoader</span> -&gt; {</span>
     *     <span style="color: #3F7E5E">//    settingLoader.load...</span>
     *     <span style="color: #3F7E5E">//});</span>
     * });
     * for (VillageSettingItem villageSettingItem : <span style="color: #553000">villageSettingItemList</span>) {
     *     ... = villageSettingItem.<span style="color: #CC4747">getVillageSettingList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setVillageSettingItemCode_InScope(pkList);
     * cb.query().addOrderBy_VillageSettingItemCode_Asc();
     * </pre>
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerLoaderGateway<LoaderOfVillageSetting> loadVillageSetting(ReferrerConditionSetupper<VillageSettingCB> refCBLambda) {
        myBhv().loadVillageSetting(_selectedList, refCBLambda).withNestedReferrer(refLs -> _referrerVillageSetting = refLs);
        return hd -> hd.handle(new LoaderOfVillageSetting().ready(_referrerVillageSetting, _selector));
    }

    // ===================================================================================
    //                                                                    Pull out Foreign
    //                                                                    ================
    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<VillageSettingItem> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
