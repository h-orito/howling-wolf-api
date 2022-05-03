package com.ort.dbflute.cbean.cq.bs;

import java.util.*;

import org.dbflute.cbean.*;
import org.dbflute.cbean.chelper.*;
import org.dbflute.cbean.ckey.*;
import org.dbflute.cbean.coption.*;
import org.dbflute.cbean.cvalue.ConditionValue;
import org.dbflute.cbean.ordering.*;
import org.dbflute.cbean.scoping.*;
import org.dbflute.cbean.sqlclause.SqlClause;
import org.dbflute.dbmeta.DBMetaProvider;
import com.ort.dbflute.allcommon.*;
import com.ort.dbflute.cbean.*;
import com.ort.dbflute.cbean.cq.*;

/**
 * The abstract condition-query of face_type.
 * @author DBFlute(AutoGenerator)
 */
public abstract class AbstractBsFaceTypeCQ extends AbstractConditionQuery {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public AbstractBsFaceTypeCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                             DB Meta
    //                                                                             =======
    @Override
    protected DBMetaProvider xgetDBMetaProvider() {
        return DBMetaInstanceHandler.getProvider();
    }

    public String asTableDbName() {
        return "face_type";
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * FACE_TYPE_CODE: {PK, NotNull, VARCHAR(20), classification=FaceType}
     * @param faceTypeCode The value of faceTypeCode as equal. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setFaceTypeCode_Equal(String faceTypeCode) {
        doSetFaceTypeCode_Equal(fRES(faceTypeCode));
    }

    /**
     * Equal(=). As FaceType. And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * FACE_TYPE_CODE: {PK, NotNull, VARCHAR(20), classification=FaceType} <br>
     * 表情種別
     * @param cdef The instance of classification definition (as ENUM type). (basically NotNull: error as default, or no condition as option)
     */
    public void setFaceTypeCode_Equal_AsFaceType(CDef.FaceType cdef) {
        doSetFaceTypeCode_Equal(cdef != null ? cdef.code() : null);
    }

    /**
     * Equal(=). As 墓下 (GRAVE). And OnlyOnceRegistered. <br>
     * 墓下
     */
    public void setFaceTypeCode_Equal_墓下() {
        setFaceTypeCode_Equal_AsFaceType(CDef.FaceType.墓下);
    }

    /**
     * Equal(=). As 恋人 (LOVER). And OnlyOnceRegistered. <br>
     * 恋人
     */
    public void setFaceTypeCode_Equal_恋人() {
        setFaceTypeCode_Equal_AsFaceType(CDef.FaceType.恋人);
    }

    /**
     * Equal(=). As 共鳴 (MASON). And OnlyOnceRegistered. <br>
     * 共鳴
     */
    public void setFaceTypeCode_Equal_共鳴() {
        setFaceTypeCode_Equal_AsFaceType(CDef.FaceType.共鳴);
    }

    /**
     * Equal(=). As 独り言 (MONOLOGUE). And OnlyOnceRegistered. <br>
     * 独り言
     */
    public void setFaceTypeCode_Equal_独り言() {
        setFaceTypeCode_Equal_AsFaceType(CDef.FaceType.独り言);
    }

    /**
     * Equal(=). As 通常 (NORMAL). And OnlyOnceRegistered. <br>
     * 通常
     */
    public void setFaceTypeCode_Equal_通常() {
        setFaceTypeCode_Equal_AsFaceType(CDef.FaceType.通常);
    }

    /**
     * Equal(=). As 秘話 (SECRET). And OnlyOnceRegistered. <br>
     * 秘話
     */
    public void setFaceTypeCode_Equal_秘話() {
        setFaceTypeCode_Equal_AsFaceType(CDef.FaceType.秘話);
    }

    /**
     * Equal(=). As 囁き (WEREWOLF). And OnlyOnceRegistered. <br>
     * 囁き
     */
    public void setFaceTypeCode_Equal_囁き() {
        setFaceTypeCode_Equal_AsFaceType(CDef.FaceType.囁き);
    }

    protected void doSetFaceTypeCode_Equal(String faceTypeCode) {
        regFaceTypeCode(CK_EQ, faceTypeCode);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * FACE_TYPE_CODE: {PK, NotNull, VARCHAR(20), classification=FaceType}
     * @param faceTypeCode The value of faceTypeCode as notEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setFaceTypeCode_NotEqual(String faceTypeCode) {
        doSetFaceTypeCode_NotEqual(fRES(faceTypeCode));
    }

    /**
     * NotEqual(&lt;&gt;). As FaceType. And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * FACE_TYPE_CODE: {PK, NotNull, VARCHAR(20), classification=FaceType} <br>
     * 表情種別
     * @param cdef The instance of classification definition (as ENUM type). (basically NotNull: error as default, or no condition as option)
     */
    public void setFaceTypeCode_NotEqual_AsFaceType(CDef.FaceType cdef) {
        doSetFaceTypeCode_NotEqual(cdef != null ? cdef.code() : null);
    }

    /**
     * NotEqual(&lt;&gt;). As 墓下 (GRAVE). And OnlyOnceRegistered. <br>
     * 墓下
     */
    public void setFaceTypeCode_NotEqual_墓下() {
        setFaceTypeCode_NotEqual_AsFaceType(CDef.FaceType.墓下);
    }

    /**
     * NotEqual(&lt;&gt;). As 恋人 (LOVER). And OnlyOnceRegistered. <br>
     * 恋人
     */
    public void setFaceTypeCode_NotEqual_恋人() {
        setFaceTypeCode_NotEqual_AsFaceType(CDef.FaceType.恋人);
    }

    /**
     * NotEqual(&lt;&gt;). As 共鳴 (MASON). And OnlyOnceRegistered. <br>
     * 共鳴
     */
    public void setFaceTypeCode_NotEqual_共鳴() {
        setFaceTypeCode_NotEqual_AsFaceType(CDef.FaceType.共鳴);
    }

    /**
     * NotEqual(&lt;&gt;). As 独り言 (MONOLOGUE). And OnlyOnceRegistered. <br>
     * 独り言
     */
    public void setFaceTypeCode_NotEqual_独り言() {
        setFaceTypeCode_NotEqual_AsFaceType(CDef.FaceType.独り言);
    }

    /**
     * NotEqual(&lt;&gt;). As 通常 (NORMAL). And OnlyOnceRegistered. <br>
     * 通常
     */
    public void setFaceTypeCode_NotEqual_通常() {
        setFaceTypeCode_NotEqual_AsFaceType(CDef.FaceType.通常);
    }

    /**
     * NotEqual(&lt;&gt;). As 秘話 (SECRET). And OnlyOnceRegistered. <br>
     * 秘話
     */
    public void setFaceTypeCode_NotEqual_秘話() {
        setFaceTypeCode_NotEqual_AsFaceType(CDef.FaceType.秘話);
    }

    /**
     * NotEqual(&lt;&gt;). As 囁き (WEREWOLF). And OnlyOnceRegistered. <br>
     * 囁き
     */
    public void setFaceTypeCode_NotEqual_囁き() {
        setFaceTypeCode_NotEqual_AsFaceType(CDef.FaceType.囁き);
    }

    protected void doSetFaceTypeCode_NotEqual(String faceTypeCode) {
        regFaceTypeCode(CK_NES, faceTypeCode);
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * FACE_TYPE_CODE: {PK, NotNull, VARCHAR(20), classification=FaceType}
     * @param faceTypeCodeList The collection of faceTypeCode as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setFaceTypeCode_InScope(Collection<String> faceTypeCodeList) {
        doSetFaceTypeCode_InScope(faceTypeCodeList);
    }

    /**
     * InScope {in ('a', 'b')}. As FaceType. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * FACE_TYPE_CODE: {PK, NotNull, VARCHAR(20), classification=FaceType} <br>
     * 表情種別
     * @param cdefList The list of classification definition (as ENUM type). (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setFaceTypeCode_InScope_AsFaceType(Collection<CDef.FaceType> cdefList) {
        doSetFaceTypeCode_InScope(cTStrL(cdefList));
    }

    protected void doSetFaceTypeCode_InScope(Collection<String> faceTypeCodeList) {
        regINS(CK_INS, cTL(faceTypeCodeList), xgetCValueFaceTypeCode(), "FACE_TYPE_CODE");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * FACE_TYPE_CODE: {PK, NotNull, VARCHAR(20), classification=FaceType}
     * @param faceTypeCodeList The collection of faceTypeCode as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setFaceTypeCode_NotInScope(Collection<String> faceTypeCodeList) {
        doSetFaceTypeCode_NotInScope(faceTypeCodeList);
    }

    /**
     * NotInScope {not in ('a', 'b')}. As FaceType. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * FACE_TYPE_CODE: {PK, NotNull, VARCHAR(20), classification=FaceType} <br>
     * 表情種別
     * @param cdefList The list of classification definition (as ENUM type). (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setFaceTypeCode_NotInScope_AsFaceType(Collection<CDef.FaceType> cdefList) {
        doSetFaceTypeCode_NotInScope(cTStrL(cdefList));
    }

    protected void doSetFaceTypeCode_NotInScope(Collection<String> faceTypeCodeList) {
        regINS(CK_NINS, cTL(faceTypeCodeList), xgetCValueFaceTypeCode(), "FACE_TYPE_CODE");
    }

    /**
     * Set up ExistsReferrer (correlated sub-query). <br>
     * {exists (select FACE_TYPE_CODE from chara_image where ...)} <br>
     * chara_image by FACE_TYPE_CODE, named 'charaImageAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">existsCharaImage</span>(imageCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     imageCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of CharaImageList for 'exists'. (NotNull)
     */
    public void existsCharaImage(SubQuery<CharaImageCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        CharaImageCB cb = new CharaImageCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepFaceTypeCode_ExistsReferrer_CharaImageList(cb.query());
        registerExistsReferrer(cb.query(), "FACE_TYPE_CODE", "FACE_TYPE_CODE", pp, "charaImageList");
    }
    public abstract String keepFaceTypeCode_ExistsReferrer_CharaImageList(CharaImageCQ sq);

    /**
     * Set up NotExistsReferrer (correlated sub-query). <br>
     * {not exists (select FACE_TYPE_CODE from chara_image where ...)} <br>
     * chara_image by FACE_TYPE_CODE, named 'charaImageAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">notExistsCharaImage</span>(imageCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     imageCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of FaceTypeCode_NotExistsReferrer_CharaImageList for 'not exists'. (NotNull)
     */
    public void notExistsCharaImage(SubQuery<CharaImageCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        CharaImageCB cb = new CharaImageCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepFaceTypeCode_NotExistsReferrer_CharaImageList(cb.query());
        registerNotExistsReferrer(cb.query(), "FACE_TYPE_CODE", "FACE_TYPE_CODE", pp, "charaImageList");
    }
    public abstract String keepFaceTypeCode_NotExistsReferrer_CharaImageList(CharaImageCQ sq);

    public void xsderiveCharaImageList(String fn, SubQuery<CharaImageCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        CharaImageCB cb = new CharaImageCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String pp = keepFaceTypeCode_SpecifyDerivedReferrer_CharaImageList(cb.query());
        registerSpecifyDerivedReferrer(fn, cb.query(), "FACE_TYPE_CODE", "FACE_TYPE_CODE", pp, "charaImageList", al, op);
    }
    public abstract String keepFaceTypeCode_SpecifyDerivedReferrer_CharaImageList(CharaImageCQ sq);

    /**
     * Prepare for (Query)DerivedReferrer (correlated sub-query). <br>
     * {FOO &lt;= (select max(BAR) from chara_image where ...)} <br>
     * chara_image by FACE_TYPE_CODE, named 'charaImageAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">derivedCharaImage()</span>.<span style="color: #CC4747">max</span>(imageCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     imageCB.specify().<span style="color: #CC4747">columnFoo...</span> <span style="color: #3F7E5E">// derived column by function</span>
     *     imageCB.query().setBar... <span style="color: #3F7E5E">// referrer condition</span>
     * }).<span style="color: #CC4747">greaterEqual</span>(123); <span style="color: #3F7E5E">// condition to derived column</span>
     * </pre>
     * @return The object to set up a function for referrer table. (NotNull)
     */
    public HpQDRFunction<CharaImageCB> derivedCharaImage() {
        return xcreateQDRFunctionCharaImageList();
    }
    protected HpQDRFunction<CharaImageCB> xcreateQDRFunctionCharaImageList() {
        return xcQDRFunc((fn, sq, rd, vl, op) -> xqderiveCharaImageList(fn, sq, rd, vl, op));
    }
    public void xqderiveCharaImageList(String fn, SubQuery<CharaImageCB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        CharaImageCB cb = new CharaImageCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String sqpp = keepFaceTypeCode_QueryDerivedReferrer_CharaImageList(cb.query()); String prpp = keepFaceTypeCode_QueryDerivedReferrer_CharaImageListParameter(vl);
        registerQueryDerivedReferrer(fn, cb.query(), "FACE_TYPE_CODE", "FACE_TYPE_CODE", sqpp, "charaImageList", rd, vl, prpp, op);
    }
    public abstract String keepFaceTypeCode_QueryDerivedReferrer_CharaImageList(CharaImageCQ sq);
    public abstract String keepFaceTypeCode_QueryDerivedReferrer_CharaImageListParameter(Object vl);

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * FACE_TYPE_CODE: {PK, NotNull, VARCHAR(20), classification=FaceType}
     */
    public void setFaceTypeCode_IsNull() { regFaceTypeCode(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * FACE_TYPE_CODE: {PK, NotNull, VARCHAR(20), classification=FaceType}
     */
    public void setFaceTypeCode_IsNotNull() { regFaceTypeCode(CK_ISNN, DOBJ); }

    protected void regFaceTypeCode(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueFaceTypeCode(), "FACE_TYPE_CODE"); }
    protected abstract ConditionValue xgetCValueFaceTypeCode();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * FACE_TYPE_NAME: {NotNull, VARCHAR(20)}
     * @param faceTypeName The value of faceTypeName as equal. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setFaceTypeName_Equal(String faceTypeName) {
        doSetFaceTypeName_Equal(fRES(faceTypeName));
    }

    protected void doSetFaceTypeName_Equal(String faceTypeName) {
        regFaceTypeName(CK_EQ, faceTypeName);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * FACE_TYPE_NAME: {NotNull, VARCHAR(20)}
     * @param faceTypeName The value of faceTypeName as notEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setFaceTypeName_NotEqual(String faceTypeName) {
        doSetFaceTypeName_NotEqual(fRES(faceTypeName));
    }

    protected void doSetFaceTypeName_NotEqual(String faceTypeName) {
        regFaceTypeName(CK_NES, faceTypeName);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * FACE_TYPE_NAME: {NotNull, VARCHAR(20)}
     * @param faceTypeName The value of faceTypeName as greaterThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setFaceTypeName_GreaterThan(String faceTypeName) {
        regFaceTypeName(CK_GT, fRES(faceTypeName));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * FACE_TYPE_NAME: {NotNull, VARCHAR(20)}
     * @param faceTypeName The value of faceTypeName as lessThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setFaceTypeName_LessThan(String faceTypeName) {
        regFaceTypeName(CK_LT, fRES(faceTypeName));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * FACE_TYPE_NAME: {NotNull, VARCHAR(20)}
     * @param faceTypeName The value of faceTypeName as greaterEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setFaceTypeName_GreaterEqual(String faceTypeName) {
        regFaceTypeName(CK_GE, fRES(faceTypeName));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * FACE_TYPE_NAME: {NotNull, VARCHAR(20)}
     * @param faceTypeName The value of faceTypeName as lessEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setFaceTypeName_LessEqual(String faceTypeName) {
        regFaceTypeName(CK_LE, fRES(faceTypeName));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * FACE_TYPE_NAME: {NotNull, VARCHAR(20)}
     * @param faceTypeNameList The collection of faceTypeName as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setFaceTypeName_InScope(Collection<String> faceTypeNameList) {
        doSetFaceTypeName_InScope(faceTypeNameList);
    }

    protected void doSetFaceTypeName_InScope(Collection<String> faceTypeNameList) {
        regINS(CK_INS, cTL(faceTypeNameList), xgetCValueFaceTypeName(), "FACE_TYPE_NAME");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * FACE_TYPE_NAME: {NotNull, VARCHAR(20)}
     * @param faceTypeNameList The collection of faceTypeName as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setFaceTypeName_NotInScope(Collection<String> faceTypeNameList) {
        doSetFaceTypeName_NotInScope(faceTypeNameList);
    }

    protected void doSetFaceTypeName_NotInScope(Collection<String> faceTypeNameList) {
        regINS(CK_NINS, cTL(faceTypeNameList), xgetCValueFaceTypeName(), "FACE_TYPE_NAME");
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * FACE_TYPE_NAME: {NotNull, VARCHAR(20)} <br>
     * <pre>e.g. setFaceTypeName_LikeSearch("xxx", op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">likeContain()</span>);</pre>
     * @param faceTypeName The value of faceTypeName as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setFaceTypeName_LikeSearch(String faceTypeName, ConditionOptionCall<LikeSearchOption> opLambda) {
        setFaceTypeName_LikeSearch(faceTypeName, xcLSOP(opLambda));
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * FACE_TYPE_NAME: {NotNull, VARCHAR(20)} <br>
     * <pre>e.g. setFaceTypeName_LikeSearch("xxx", new <span style="color: #CC4747">LikeSearchOption</span>().likeContain());</pre>
     * @param faceTypeName The value of faceTypeName as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    protected void setFaceTypeName_LikeSearch(String faceTypeName, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(faceTypeName), xgetCValueFaceTypeName(), "FACE_TYPE_NAME", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * FACE_TYPE_NAME: {NotNull, VARCHAR(20)}
     * @param faceTypeName The value of faceTypeName as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setFaceTypeName_NotLikeSearch(String faceTypeName, ConditionOptionCall<LikeSearchOption> opLambda) {
        setFaceTypeName_NotLikeSearch(faceTypeName, xcLSOP(opLambda));
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * FACE_TYPE_NAME: {NotNull, VARCHAR(20)}
     * @param faceTypeName The value of faceTypeName as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    protected void setFaceTypeName_NotLikeSearch(String faceTypeName, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(faceTypeName), xgetCValueFaceTypeName(), "FACE_TYPE_NAME", likeSearchOption);
    }

    protected void regFaceTypeName(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueFaceTypeName(), "FACE_TYPE_NAME"); }
    protected abstract ConditionValue xgetCValueFaceTypeName();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * DISP_ORDER: {NotNull, INT UNSIGNED(10)}
     * @param dispOrder The value of dispOrder as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setDispOrder_Equal(Integer dispOrder) {
        doSetDispOrder_Equal(dispOrder);
    }

    protected void doSetDispOrder_Equal(Integer dispOrder) {
        regDispOrder(CK_EQ, dispOrder);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * DISP_ORDER: {NotNull, INT UNSIGNED(10)}
     * @param dispOrder The value of dispOrder as notEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setDispOrder_NotEqual(Integer dispOrder) {
        doSetDispOrder_NotEqual(dispOrder);
    }

    protected void doSetDispOrder_NotEqual(Integer dispOrder) {
        regDispOrder(CK_NES, dispOrder);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * DISP_ORDER: {NotNull, INT UNSIGNED(10)}
     * @param dispOrder The value of dispOrder as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setDispOrder_GreaterThan(Integer dispOrder) {
        regDispOrder(CK_GT, dispOrder);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * DISP_ORDER: {NotNull, INT UNSIGNED(10)}
     * @param dispOrder The value of dispOrder as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setDispOrder_LessThan(Integer dispOrder) {
        regDispOrder(CK_LT, dispOrder);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * DISP_ORDER: {NotNull, INT UNSIGNED(10)}
     * @param dispOrder The value of dispOrder as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setDispOrder_GreaterEqual(Integer dispOrder) {
        regDispOrder(CK_GE, dispOrder);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * DISP_ORDER: {NotNull, INT UNSIGNED(10)}
     * @param dispOrder The value of dispOrder as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setDispOrder_LessEqual(Integer dispOrder) {
        regDispOrder(CK_LE, dispOrder);
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * DISP_ORDER: {NotNull, INT UNSIGNED(10)}
     * @param minNumber The min number of dispOrder. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of dispOrder. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param opLambda The callback for option of range-of. (NotNull)
     */
    public void setDispOrder_RangeOf(Integer minNumber, Integer maxNumber, ConditionOptionCall<RangeOfOption> opLambda) {
        setDispOrder_RangeOf(minNumber, maxNumber, xcROOP(opLambda));
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * DISP_ORDER: {NotNull, INT UNSIGNED(10)}
     * @param minNumber The min number of dispOrder. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of dispOrder. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    protected void setDispOrder_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, xgetCValueDispOrder(), "DISP_ORDER", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * DISP_ORDER: {NotNull, INT UNSIGNED(10)}
     * @param dispOrderList The collection of dispOrder as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setDispOrder_InScope(Collection<Integer> dispOrderList) {
        doSetDispOrder_InScope(dispOrderList);
    }

    protected void doSetDispOrder_InScope(Collection<Integer> dispOrderList) {
        regINS(CK_INS, cTL(dispOrderList), xgetCValueDispOrder(), "DISP_ORDER");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * DISP_ORDER: {NotNull, INT UNSIGNED(10)}
     * @param dispOrderList The collection of dispOrder as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setDispOrder_NotInScope(Collection<Integer> dispOrderList) {
        doSetDispOrder_NotInScope(dispOrderList);
    }

    protected void doSetDispOrder_NotInScope(Collection<Integer> dispOrderList) {
        regINS(CK_NINS, cTL(dispOrderList), xgetCValueDispOrder(), "DISP_ORDER");
    }

    protected void regDispOrder(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueDispOrder(), "DISP_ORDER"); }
    protected abstract ConditionValue xgetCValueDispOrder();

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    /**
     * Prepare ScalarCondition as equal. <br>
     * {where FOO = (select max(BAR) from ...)}
     * <pre>
     * cb.query().scalar_Equal().<span style="color: #CC4747">avg</span>(<span style="color: #553000">purchaseCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">purchaseCB</span>.specify().<span style="color: #CC4747">columnPurchasePrice</span>(); <span style="color: #3F7E5E">// *Point!</span>
     *     <span style="color: #553000">purchaseCB</span>.query().setPaymentCompleteFlg_Equal_True();
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<FaceTypeCB> scalar_Equal() {
        return xcreateSLCFunction(CK_EQ, FaceTypeCB.class);
    }

    /**
     * Prepare ScalarCondition as equal. <br>
     * {where FOO &lt;&gt; (select max(BAR) from ...)}
     * <pre>
     * cb.query().scalar_Equal().<span style="color: #CC4747">avg</span>(<span style="color: #553000">purchaseCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">purchaseCB</span>.specify().<span style="color: #CC4747">columnPurchasePrice</span>(); <span style="color: #3F7E5E">// *Point!</span>
     *     <span style="color: #553000">purchaseCB</span>.query().setPaymentCompleteFlg_Equal_True();
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<FaceTypeCB> scalar_NotEqual() {
        return xcreateSLCFunction(CK_NES, FaceTypeCB.class);
    }

    /**
     * Prepare ScalarCondition as greaterThan. <br>
     * {where FOO &gt; (select max(BAR) from ...)}
     * <pre>
     * cb.query().scalar_Equal().<span style="color: #CC4747">avg</span>(<span style="color: #553000">purchaseCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">purchaseCB</span>.specify().<span style="color: #CC4747">columnPurchasePrice</span>(); <span style="color: #3F7E5E">// *Point!</span>
     *     <span style="color: #553000">purchaseCB</span>.query().setPaymentCompleteFlg_Equal_True();
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<FaceTypeCB> scalar_GreaterThan() {
        return xcreateSLCFunction(CK_GT, FaceTypeCB.class);
    }

    /**
     * Prepare ScalarCondition as lessThan. <br>
     * {where FOO &lt; (select max(BAR) from ...)}
     * <pre>
     * cb.query().scalar_Equal().<span style="color: #CC4747">avg</span>(<span style="color: #553000">purchaseCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">purchaseCB</span>.specify().<span style="color: #CC4747">columnPurchasePrice</span>(); <span style="color: #3F7E5E">// *Point!</span>
     *     <span style="color: #553000">purchaseCB</span>.query().setPaymentCompleteFlg_Equal_True();
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<FaceTypeCB> scalar_LessThan() {
        return xcreateSLCFunction(CK_LT, FaceTypeCB.class);
    }

    /**
     * Prepare ScalarCondition as greaterEqual. <br>
     * {where FOO &gt;= (select max(BAR) from ...)}
     * <pre>
     * cb.query().scalar_Equal().<span style="color: #CC4747">avg</span>(<span style="color: #553000">purchaseCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">purchaseCB</span>.specify().<span style="color: #CC4747">columnPurchasePrice</span>(); <span style="color: #3F7E5E">// *Point!</span>
     *     <span style="color: #553000">purchaseCB</span>.query().setPaymentCompleteFlg_Equal_True();
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<FaceTypeCB> scalar_GreaterEqual() {
        return xcreateSLCFunction(CK_GE, FaceTypeCB.class);
    }

    /**
     * Prepare ScalarCondition as lessEqual. <br>
     * {where FOO &lt;= (select max(BAR) from ...)}
     * <pre>
     * cb.query().<span style="color: #CC4747">scalar_LessEqual()</span>.max(new SubQuery&lt;FaceTypeCB&gt;() {
     *     public void query(FaceTypeCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<FaceTypeCB> scalar_LessEqual() {
        return xcreateSLCFunction(CK_LE, FaceTypeCB.class);
    }

    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xscalarCondition(String fn, SubQuery<CB> sq, String rd, HpSLCCustomized<CB> cs, ScalarConditionOption op) {
        assertObjectNotNull("subQuery", sq);
        FaceTypeCB cb = xcreateScalarConditionCB(); sq.query((CB)cb);
        String pp = keepScalarCondition(cb.query()); // for saving query-value
        cs.setPartitionByCBean((CB)xcreateScalarConditionPartitionByCB()); // for using partition-by
        registerScalarCondition(fn, cb.query(), pp, rd, cs, op);
    }
    public abstract String keepScalarCondition(FaceTypeCQ sq);

    protected FaceTypeCB xcreateScalarConditionCB() {
        FaceTypeCB cb = newMyCB(); cb.xsetupForScalarCondition(this); return cb;
    }

    protected FaceTypeCB xcreateScalarConditionPartitionByCB() {
        FaceTypeCB cb = newMyCB(); cb.xsetupForScalarConditionPartitionBy(this); return cb;
    }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public void xsmyselfDerive(String fn, SubQuery<FaceTypeCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        FaceTypeCB cb = new FaceTypeCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String pp = keepSpecifyMyselfDerived(cb.query()); String pk = "FACE_TYPE_CODE";
        registerSpecifyMyselfDerived(fn, cb.query(), pk, pk, pp, "myselfDerived", al, op);
    }
    public abstract String keepSpecifyMyselfDerived(FaceTypeCQ sq);

    /**
     * Prepare for (Query)MyselfDerived (correlated sub-query).
     * @return The object to set up a function for myself table. (NotNull)
     */
    public HpQDRFunction<FaceTypeCB> myselfDerived() {
        return xcreateQDRFunctionMyselfDerived(FaceTypeCB.class);
    }
    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xqderiveMyselfDerived(String fn, SubQuery<CB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        FaceTypeCB cb = new FaceTypeCB(); cb.xsetupForDerivedReferrer(this); sq.query((CB)cb);
        String pk = "FACE_TYPE_CODE";
        String sqpp = keepQueryMyselfDerived(cb.query()); // for saving query-value.
        String prpp = keepQueryMyselfDerivedParameter(vl);
        registerQueryMyselfDerived(fn, cb.query(), pk, pk, sqpp, "myselfDerived", rd, vl, prpp, op);
    }
    public abstract String keepQueryMyselfDerived(FaceTypeCQ sq);
    public abstract String keepQueryMyselfDerivedParameter(Object vl);

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    /**
     * Prepare for MyselfExists (correlated sub-query).
     * @param subCBLambda The implementation of sub-query. (NotNull)
     */
    public void myselfExists(SubQuery<FaceTypeCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        FaceTypeCB cb = new FaceTypeCB(); cb.xsetupForMyselfExists(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepMyselfExists(cb.query());
        registerMyselfExists(cb.query(), pp);
    }
    public abstract String keepMyselfExists(FaceTypeCQ sq);

    // ===================================================================================
    //                                                                        Manual Order
    //                                                                        ============
    /**
     * Order along manual ordering information.
     * <pre>
     * cb.query().addOrderBy_Birthdate_Asc().<span style="color: #CC4747">withManualOrder</span>(<span style="color: #553000">op</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">op</span>.<span style="color: #CC4747">when_GreaterEqual</span>(priorityDate); <span style="color: #3F7E5E">// e.g. 2000/01/01</span>
     * });
     * <span style="color: #3F7E5E">// order by </span>
     * <span style="color: #3F7E5E">//   case</span>
     * <span style="color: #3F7E5E">//     when BIRTHDATE &gt;= '2000/01/01' then 0</span>
     * <span style="color: #3F7E5E">//     else 1</span>
     * <span style="color: #3F7E5E">//   end asc, ...</span>
     *
     * cb.query().addOrderBy_MemberStatusCode_Asc().<span style="color: #CC4747">withManualOrder</span>(<span style="color: #553000">op</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">op</span>.<span style="color: #CC4747">when_Equal</span>(CDef.MemberStatus.Withdrawal);
     *     <span style="color: #553000">op</span>.<span style="color: #CC4747">when_Equal</span>(CDef.MemberStatus.Formalized);
     *     <span style="color: #553000">op</span>.<span style="color: #CC4747">when_Equal</span>(CDef.MemberStatus.Provisional);
     * });
     * <span style="color: #3F7E5E">// order by </span>
     * <span style="color: #3F7E5E">//   case</span>
     * <span style="color: #3F7E5E">//     when MEMBER_STATUS_CODE = 'WDL' then 0</span>
     * <span style="color: #3F7E5E">//     when MEMBER_STATUS_CODE = 'FML' then 1</span>
     * <span style="color: #3F7E5E">//     when MEMBER_STATUS_CODE = 'PRV' then 2</span>
     * <span style="color: #3F7E5E">//     else 3</span>
     * <span style="color: #3F7E5E">//   end asc, ...</span>
     * </pre>
     * <p>This function with Union is unsupported!</p>
     * <p>The order values are bound (treated as bind parameter).</p>
     * @param opLambda The callback for option of manual-order containing order values. (NotNull)
     */
    public void withManualOrder(ManualOrderOptionCall opLambda) { // is user public!
        xdoWithManualOrder(cMOO(opLambda));
    }

    // ===================================================================================
    //                                                                    Small Adjustment
    //                                                                    ================
    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    protected FaceTypeCB newMyCB() {
        return new FaceTypeCB();
    }
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xabUDT() { return Date.class.getName(); }
    protected String xabCQ() { return FaceTypeCQ.class.getName(); }
    protected String xabLSO() { return LikeSearchOption.class.getName(); }
    protected String xabSLCS() { return HpSLCSetupper.class.getName(); }
    protected String xabSCP() { return SubQuery.class.getName(); }
}
