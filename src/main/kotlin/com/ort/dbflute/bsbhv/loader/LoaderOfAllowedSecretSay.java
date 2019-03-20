package com.ort.dbflute.bsbhv.loader;

import java.util.List;

import org.dbflute.bhv.*;
import org.dbflute.bhv.referrer.*;
import com.ort.dbflute.exbhv.*;
import com.ort.dbflute.exentity.*;
import com.ort.dbflute.cbean.*;

/**
 * The referrer loader of ALLOWED_SECRET_SAY as TABLE. <br>
 * <pre>
 * [primary key]
 *     ALLOWED_SECRET_SAY_CODE
 *
 * [column]
 *     ALLOWED_SECRET_SAY_CODE, ALLOWED_SECRET_SAY_NAME
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
 *     VILLAGE_SETTINGS
 *
 * [foreign property]
 *     
 *
 * [referrer property]
 *     villageSettingsList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public class LoaderOfAllowedSecretSay {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<AllowedSecretSay> _selectedList;
    protected BehaviorSelector _selector;
    protected AllowedSecretSayBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfAllowedSecretSay ready(List<AllowedSecretSay> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected AllowedSecretSayBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(AllowedSecretSayBhv.class); return _myBhv; } }

    // ===================================================================================
    //                                                                       Load Referrer
    //                                                                       =============
    protected List<VillageSettings> _referrerVillageSettings;

    /**
     * Load referrer of villageSettingsList by the set-upper of referrer. <br>
     * VILLAGE_SETTINGS by ALLOWED_SECRET_SAY_CODE, named 'villageSettingsList'.
     * <pre>
     * <span style="color: #0000C0">allowedSecretSayBhv</span>.<span style="color: #994747">load</span>(<span style="color: #553000">allowedSecretSayList</span>, <span style="color: #553000">sayLoader</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">sayLoader</span>.<span style="color: #CC4747">loadVillageSettings</span>(<span style="color: #553000">settingsCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *         <span style="color: #553000">settingsCB</span>.setupSelect...
     *         <span style="color: #553000">settingsCB</span>.query().set...
     *         <span style="color: #553000">settingsCB</span>.query().addOrderBy...
     *     }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     *     <span style="color: #3F7E5E">//}).withNestedReferrer(<span style="color: #553000">settingsLoader</span> -&gt; {</span>
     *     <span style="color: #3F7E5E">//    settingsLoader.load...</span>
     *     <span style="color: #3F7E5E">//});</span>
     * });
     * for (AllowedSecretSay allowedSecretSay : <span style="color: #553000">allowedSecretSayList</span>) {
     *     ... = allowedSecretSay.<span style="color: #CC4747">getVillageSettingsList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setAllowedSecretSayCode_InScope(pkList);
     * cb.query().addOrderBy_AllowedSecretSayCode_Asc();
     * </pre>
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerLoaderGateway<LoaderOfVillageSettings> loadVillageSettings(ReferrerConditionSetupper<VillageSettingsCB> refCBLambda) {
        myBhv().loadVillageSettings(_selectedList, refCBLambda).withNestedReferrer(refLs -> _referrerVillageSettings = refLs);
        return hd -> hd.handle(new LoaderOfVillageSettings().ready(_referrerVillageSettings, _selector));
    }

    // ===================================================================================
    //                                                                    Pull out Foreign
    //                                                                    ================
    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<AllowedSecretSay> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
