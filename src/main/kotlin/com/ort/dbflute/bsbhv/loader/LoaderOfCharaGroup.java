package com.ort.dbflute.bsbhv.loader;

import java.util.List;

import org.dbflute.bhv.*;
import org.dbflute.bhv.referrer.*;
import com.ort.dbflute.exbhv.*;
import com.ort.dbflute.exentity.*;
import com.ort.dbflute.cbean.*;

/**
 * The referrer loader of CHARA_GROUP as TABLE. <br>
 * <pre>
 * [primary key]
 *     CHARA_GROUP_ID
 *
 * [column]
 *     CHARA_GROUP_ID, CHARA_GROUP_NAME, DESIGNER_ID, DESCRIPTION_URL, REGISTER_DATETIME, REGISTER_TRACE, UPDATE_DATETIME, UPDATE_TRACE
 *
 * [sequence]
 *     
 *
 * [identity]
 *     CHARA_GROUP_ID
 *
 * [version-no]
 *     
 *
 * [foreign table]
 *     DESIGNER
 *
 * [referrer table]
 *     CHARA, VILLAGE_SETTINGS
 *
 * [foreign property]
 *     designer
 *
 * [referrer property]
 *     charaList, villageSettingsList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public class LoaderOfCharaGroup {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<CharaGroup> _selectedList;
    protected BehaviorSelector _selector;
    protected CharaGroupBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfCharaGroup ready(List<CharaGroup> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected CharaGroupBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(CharaGroupBhv.class); return _myBhv; } }

    // ===================================================================================
    //                                                                       Load Referrer
    //                                                                       =============
    protected List<Chara> _referrerChara;

    /**
     * Load referrer of charaList by the set-upper of referrer. <br>
     * CHARA by CHARA_GROUP_ID, named 'charaList'.
     * <pre>
     * <span style="color: #0000C0">charaGroupBhv</span>.<span style="color: #994747">load</span>(<span style="color: #553000">charaGroupList</span>, <span style="color: #553000">groupLoader</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">groupLoader</span>.<span style="color: #CC4747">loadChara</span>(<span style="color: #553000">charaCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *         <span style="color: #553000">charaCB</span>.setupSelect...
     *         <span style="color: #553000">charaCB</span>.query().set...
     *         <span style="color: #553000">charaCB</span>.query().addOrderBy...
     *     }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     *     <span style="color: #3F7E5E">//}).withNestedReferrer(<span style="color: #553000">charaLoader</span> -&gt; {</span>
     *     <span style="color: #3F7E5E">//    charaLoader.load...</span>
     *     <span style="color: #3F7E5E">//});</span>
     * });
     * for (CharaGroup charaGroup : <span style="color: #553000">charaGroupList</span>) {
     *     ... = charaGroup.<span style="color: #CC4747">getCharaList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setCharaGroupId_InScope(pkList);
     * cb.query().addOrderBy_CharaGroupId_Asc();
     * </pre>
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerLoaderGateway<LoaderOfChara> loadChara(ReferrerConditionSetupper<CharaCB> refCBLambda) {
        myBhv().loadChara(_selectedList, refCBLambda).withNestedReferrer(refLs -> _referrerChara = refLs);
        return hd -> hd.handle(new LoaderOfChara().ready(_referrerChara, _selector));
    }

    protected List<VillageSettings> _referrerVillageSettings;

    /**
     * Load referrer of villageSettingsList by the set-upper of referrer. <br>
     * VILLAGE_SETTINGS by CHARACTER_GROUP_ID, named 'villageSettingsList'.
     * <pre>
     * <span style="color: #0000C0">charaGroupBhv</span>.<span style="color: #994747">load</span>(<span style="color: #553000">charaGroupList</span>, <span style="color: #553000">groupLoader</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">groupLoader</span>.<span style="color: #CC4747">loadVillageSettings</span>(<span style="color: #553000">settingsCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *         <span style="color: #553000">settingsCB</span>.setupSelect...
     *         <span style="color: #553000">settingsCB</span>.query().set...
     *         <span style="color: #553000">settingsCB</span>.query().addOrderBy...
     *     }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     *     <span style="color: #3F7E5E">//}).withNestedReferrer(<span style="color: #553000">settingsLoader</span> -&gt; {</span>
     *     <span style="color: #3F7E5E">//    settingsLoader.load...</span>
     *     <span style="color: #3F7E5E">//});</span>
     * });
     * for (CharaGroup charaGroup : <span style="color: #553000">charaGroupList</span>) {
     *     ... = charaGroup.<span style="color: #CC4747">getVillageSettingsList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setCharacterGroupId_InScope(pkList);
     * cb.query().addOrderBy_CharacterGroupId_Asc();
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
    protected LoaderOfDesigner _foreignDesignerLoader;
    public LoaderOfDesigner pulloutDesigner() {
        if (_foreignDesignerLoader == null)
        { _foreignDesignerLoader = new LoaderOfDesigner().ready(myBhv().pulloutDesigner(_selectedList), _selector); }
        return _foreignDesignerLoader;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<CharaGroup> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
