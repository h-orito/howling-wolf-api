package com.ort.dbflute.bsbhv.loader;

import java.util.List;

import org.dbflute.bhv.*;
import org.dbflute.bhv.referrer.*;
import com.ort.dbflute.exbhv.*;
import com.ort.dbflute.exentity.*;
import com.ort.dbflute.cbean.*;

/**
 * The referrer loader of FACE_TYPE as TABLE. <br>
 * <pre>
 * [primary key]
 *     FACE_TYPE_CODE
 *
 * [column]
 *     FACE_TYPE_CODE, FACE_TYPE_NAME, DISP_ORDER
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
 *     CHARA_IMAGE
 *
 * [foreign property]
 *     
 *
 * [referrer property]
 *     charaImageList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public class LoaderOfFaceType {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<FaceType> _selectedList;
    protected BehaviorSelector _selector;
    protected FaceTypeBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfFaceType ready(List<FaceType> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected FaceTypeBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(FaceTypeBhv.class); return _myBhv; } }

    // ===================================================================================
    //                                                                       Load Referrer
    //                                                                       =============
    protected List<CharaImage> _referrerCharaImage;

    /**
     * Load referrer of charaImageList by the set-upper of referrer. <br>
     * CHARA_IMAGE by FACE_TYPE_CODE, named 'charaImageList'.
     * <pre>
     * <span style="color: #0000C0">faceTypeBhv</span>.<span style="color: #994747">load</span>(<span style="color: #553000">faceTypeList</span>, <span style="color: #553000">typeLoader</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">typeLoader</span>.<span style="color: #CC4747">loadCharaImage</span>(<span style="color: #553000">imageCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *         <span style="color: #553000">imageCB</span>.setupSelect...
     *         <span style="color: #553000">imageCB</span>.query().set...
     *         <span style="color: #553000">imageCB</span>.query().addOrderBy...
     *     }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     *     <span style="color: #3F7E5E">//}).withNestedReferrer(<span style="color: #553000">imageLoader</span> -&gt; {</span>
     *     <span style="color: #3F7E5E">//    imageLoader.load...</span>
     *     <span style="color: #3F7E5E">//});</span>
     * });
     * for (FaceType faceType : <span style="color: #553000">faceTypeList</span>) {
     *     ... = faceType.<span style="color: #CC4747">getCharaImageList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br>
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setFaceTypeCode_InScope(pkList);
     * cb.query().addOrderBy_FaceTypeCode_Asc();
     * </pre>
     * @param refCBLambda The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerLoaderGateway<LoaderOfCharaImage> loadCharaImage(ReferrerConditionSetupper<CharaImageCB> refCBLambda) {
        myBhv().loadCharaImage(_selectedList, refCBLambda).withNestedReferrer(refLs -> _referrerCharaImage = refLs);
        return hd -> hd.handle(new LoaderOfCharaImage().ready(_referrerCharaImage, _selector));
    }

    // ===================================================================================
    //                                                                    Pull out Foreign
    //                                                                    ================
    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<FaceType> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
