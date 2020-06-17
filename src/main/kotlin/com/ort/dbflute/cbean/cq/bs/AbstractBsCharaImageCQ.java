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
 * The abstract condition-query of CHARA_IMAGE.
 * @author DBFlute(AutoGenerator)
 */
public abstract class AbstractBsCharaImageCQ extends AbstractConditionQuery {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public AbstractBsCharaImageCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
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
        return "CHARA_IMAGE";
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * CHARA_ID: {PK, NotNull, INT UNSIGNED(10), FK to CHARA}
     * @param charaId The value of charaId as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setCharaId_Equal(Integer charaId) {
        doSetCharaId_Equal(charaId);
    }

    protected void doSetCharaId_Equal(Integer charaId) {
        regCharaId(CK_EQ, charaId);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * CHARA_ID: {PK, NotNull, INT UNSIGNED(10), FK to CHARA}
     * @param charaId The value of charaId as notEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setCharaId_NotEqual(Integer charaId) {
        doSetCharaId_NotEqual(charaId);
    }

    protected void doSetCharaId_NotEqual(Integer charaId) {
        regCharaId(CK_NES, charaId);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * CHARA_ID: {PK, NotNull, INT UNSIGNED(10), FK to CHARA}
     * @param charaId The value of charaId as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setCharaId_GreaterThan(Integer charaId) {
        regCharaId(CK_GT, charaId);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * CHARA_ID: {PK, NotNull, INT UNSIGNED(10), FK to CHARA}
     * @param charaId The value of charaId as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setCharaId_LessThan(Integer charaId) {
        regCharaId(CK_LT, charaId);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * CHARA_ID: {PK, NotNull, INT UNSIGNED(10), FK to CHARA}
     * @param charaId The value of charaId as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setCharaId_GreaterEqual(Integer charaId) {
        regCharaId(CK_GE, charaId);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * CHARA_ID: {PK, NotNull, INT UNSIGNED(10), FK to CHARA}
     * @param charaId The value of charaId as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setCharaId_LessEqual(Integer charaId) {
        regCharaId(CK_LE, charaId);
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * CHARA_ID: {PK, NotNull, INT UNSIGNED(10), FK to CHARA}
     * @param minNumber The min number of charaId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of charaId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param opLambda The callback for option of range-of. (NotNull)
     */
    public void setCharaId_RangeOf(Integer minNumber, Integer maxNumber, ConditionOptionCall<RangeOfOption> opLambda) {
        setCharaId_RangeOf(minNumber, maxNumber, xcROOP(opLambda));
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * CHARA_ID: {PK, NotNull, INT UNSIGNED(10), FK to CHARA}
     * @param minNumber The min number of charaId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of charaId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    protected void setCharaId_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, xgetCValueCharaId(), "CHARA_ID", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * CHARA_ID: {PK, NotNull, INT UNSIGNED(10), FK to CHARA}
     * @param charaIdList The collection of charaId as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setCharaId_InScope(Collection<Integer> charaIdList) {
        doSetCharaId_InScope(charaIdList);
    }

    protected void doSetCharaId_InScope(Collection<Integer> charaIdList) {
        regINS(CK_INS, cTL(charaIdList), xgetCValueCharaId(), "CHARA_ID");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * CHARA_ID: {PK, NotNull, INT UNSIGNED(10), FK to CHARA}
     * @param charaIdList The collection of charaId as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setCharaId_NotInScope(Collection<Integer> charaIdList) {
        doSetCharaId_NotInScope(charaIdList);
    }

    protected void doSetCharaId_NotInScope(Collection<Integer> charaIdList) {
        regINS(CK_NINS, cTL(charaIdList), xgetCValueCharaId(), "CHARA_ID");
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * CHARA_ID: {PK, NotNull, INT UNSIGNED(10), FK to CHARA}
     */
    public void setCharaId_IsNull() { regCharaId(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * CHARA_ID: {PK, NotNull, INT UNSIGNED(10), FK to CHARA}
     */
    public void setCharaId_IsNotNull() { regCharaId(CK_ISNN, DOBJ); }

    protected void regCharaId(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueCharaId(), "CHARA_ID"); }
    protected abstract ConditionValue xgetCValueCharaId();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * FACE_TYPE_CODE: {PK, IX, NotNull, VARCHAR(20), FK to FACE_TYPE, classification=FaceType}
     * @param faceTypeCode The value of faceTypeCode as equal. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setFaceTypeCode_Equal(String faceTypeCode) {
        doSetFaceTypeCode_Equal(fRES(faceTypeCode));
    }

    /**
     * Equal(=). As FaceType. And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * FACE_TYPE_CODE: {PK, IX, NotNull, VARCHAR(20), FK to FACE_TYPE, classification=FaceType} <br>
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
     * FACE_TYPE_CODE: {PK, IX, NotNull, VARCHAR(20), FK to FACE_TYPE, classification=FaceType}
     * @param faceTypeCode The value of faceTypeCode as notEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setFaceTypeCode_NotEqual(String faceTypeCode) {
        doSetFaceTypeCode_NotEqual(fRES(faceTypeCode));
    }

    /**
     * NotEqual(&lt;&gt;). As FaceType. And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * FACE_TYPE_CODE: {PK, IX, NotNull, VARCHAR(20), FK to FACE_TYPE, classification=FaceType} <br>
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
     * FACE_TYPE_CODE: {PK, IX, NotNull, VARCHAR(20), FK to FACE_TYPE, classification=FaceType}
     * @param faceTypeCodeList The collection of faceTypeCode as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setFaceTypeCode_InScope(Collection<String> faceTypeCodeList) {
        doSetFaceTypeCode_InScope(faceTypeCodeList);
    }

    /**
     * InScope {in ('a', 'b')}. As FaceType. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * FACE_TYPE_CODE: {PK, IX, NotNull, VARCHAR(20), FK to FACE_TYPE, classification=FaceType} <br>
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
     * FACE_TYPE_CODE: {PK, IX, NotNull, VARCHAR(20), FK to FACE_TYPE, classification=FaceType}
     * @param faceTypeCodeList The collection of faceTypeCode as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setFaceTypeCode_NotInScope(Collection<String> faceTypeCodeList) {
        doSetFaceTypeCode_NotInScope(faceTypeCodeList);
    }

    /**
     * NotInScope {not in ('a', 'b')}. As FaceType. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * FACE_TYPE_CODE: {PK, IX, NotNull, VARCHAR(20), FK to FACE_TYPE, classification=FaceType} <br>
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
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * FACE_TYPE_CODE: {PK, IX, NotNull, VARCHAR(20), FK to FACE_TYPE, classification=FaceType}
     */
    public void setFaceTypeCode_IsNull() { regFaceTypeCode(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * FACE_TYPE_CODE: {PK, IX, NotNull, VARCHAR(20), FK to FACE_TYPE, classification=FaceType}
     */
    public void setFaceTypeCode_IsNotNull() { regFaceTypeCode(CK_ISNN, DOBJ); }

    protected void regFaceTypeCode(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueFaceTypeCode(), "FACE_TYPE_CODE"); }
    protected abstract ConditionValue xgetCValueFaceTypeCode();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * CHARA_IMG_URL: {NotNull, VARCHAR(100)}
     * @param charaImgUrl The value of charaImgUrl as equal. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setCharaImgUrl_Equal(String charaImgUrl) {
        doSetCharaImgUrl_Equal(fRES(charaImgUrl));
    }

    protected void doSetCharaImgUrl_Equal(String charaImgUrl) {
        regCharaImgUrl(CK_EQ, charaImgUrl);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * CHARA_IMG_URL: {NotNull, VARCHAR(100)}
     * @param charaImgUrl The value of charaImgUrl as notEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setCharaImgUrl_NotEqual(String charaImgUrl) {
        doSetCharaImgUrl_NotEqual(fRES(charaImgUrl));
    }

    protected void doSetCharaImgUrl_NotEqual(String charaImgUrl) {
        regCharaImgUrl(CK_NES, charaImgUrl);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * CHARA_IMG_URL: {NotNull, VARCHAR(100)}
     * @param charaImgUrl The value of charaImgUrl as greaterThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setCharaImgUrl_GreaterThan(String charaImgUrl) {
        regCharaImgUrl(CK_GT, fRES(charaImgUrl));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * CHARA_IMG_URL: {NotNull, VARCHAR(100)}
     * @param charaImgUrl The value of charaImgUrl as lessThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setCharaImgUrl_LessThan(String charaImgUrl) {
        regCharaImgUrl(CK_LT, fRES(charaImgUrl));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * CHARA_IMG_URL: {NotNull, VARCHAR(100)}
     * @param charaImgUrl The value of charaImgUrl as greaterEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setCharaImgUrl_GreaterEqual(String charaImgUrl) {
        regCharaImgUrl(CK_GE, fRES(charaImgUrl));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * CHARA_IMG_URL: {NotNull, VARCHAR(100)}
     * @param charaImgUrl The value of charaImgUrl as lessEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setCharaImgUrl_LessEqual(String charaImgUrl) {
        regCharaImgUrl(CK_LE, fRES(charaImgUrl));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * CHARA_IMG_URL: {NotNull, VARCHAR(100)}
     * @param charaImgUrlList The collection of charaImgUrl as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setCharaImgUrl_InScope(Collection<String> charaImgUrlList) {
        doSetCharaImgUrl_InScope(charaImgUrlList);
    }

    protected void doSetCharaImgUrl_InScope(Collection<String> charaImgUrlList) {
        regINS(CK_INS, cTL(charaImgUrlList), xgetCValueCharaImgUrl(), "CHARA_IMG_URL");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * CHARA_IMG_URL: {NotNull, VARCHAR(100)}
     * @param charaImgUrlList The collection of charaImgUrl as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setCharaImgUrl_NotInScope(Collection<String> charaImgUrlList) {
        doSetCharaImgUrl_NotInScope(charaImgUrlList);
    }

    protected void doSetCharaImgUrl_NotInScope(Collection<String> charaImgUrlList) {
        regINS(CK_NINS, cTL(charaImgUrlList), xgetCValueCharaImgUrl(), "CHARA_IMG_URL");
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * CHARA_IMG_URL: {NotNull, VARCHAR(100)} <br>
     * <pre>e.g. setCharaImgUrl_LikeSearch("xxx", op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">likeContain()</span>);</pre>
     * @param charaImgUrl The value of charaImgUrl as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setCharaImgUrl_LikeSearch(String charaImgUrl, ConditionOptionCall<LikeSearchOption> opLambda) {
        setCharaImgUrl_LikeSearch(charaImgUrl, xcLSOP(opLambda));
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * CHARA_IMG_URL: {NotNull, VARCHAR(100)} <br>
     * <pre>e.g. setCharaImgUrl_LikeSearch("xxx", new <span style="color: #CC4747">LikeSearchOption</span>().likeContain());</pre>
     * @param charaImgUrl The value of charaImgUrl as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    protected void setCharaImgUrl_LikeSearch(String charaImgUrl, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(charaImgUrl), xgetCValueCharaImgUrl(), "CHARA_IMG_URL", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * CHARA_IMG_URL: {NotNull, VARCHAR(100)}
     * @param charaImgUrl The value of charaImgUrl as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setCharaImgUrl_NotLikeSearch(String charaImgUrl, ConditionOptionCall<LikeSearchOption> opLambda) {
        setCharaImgUrl_NotLikeSearch(charaImgUrl, xcLSOP(opLambda));
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * CHARA_IMG_URL: {NotNull, VARCHAR(100)}
     * @param charaImgUrl The value of charaImgUrl as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    protected void setCharaImgUrl_NotLikeSearch(String charaImgUrl, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(charaImgUrl), xgetCValueCharaImgUrl(), "CHARA_IMG_URL", likeSearchOption);
    }

    protected void regCharaImgUrl(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueCharaImgUrl(), "CHARA_IMG_URL"); }
    protected abstract ConditionValue xgetCValueCharaImgUrl();

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
    public HpSLCFunction<CharaImageCB> scalar_Equal() {
        return xcreateSLCFunction(CK_EQ, CharaImageCB.class);
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
    public HpSLCFunction<CharaImageCB> scalar_NotEqual() {
        return xcreateSLCFunction(CK_NES, CharaImageCB.class);
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
    public HpSLCFunction<CharaImageCB> scalar_GreaterThan() {
        return xcreateSLCFunction(CK_GT, CharaImageCB.class);
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
    public HpSLCFunction<CharaImageCB> scalar_LessThan() {
        return xcreateSLCFunction(CK_LT, CharaImageCB.class);
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
    public HpSLCFunction<CharaImageCB> scalar_GreaterEqual() {
        return xcreateSLCFunction(CK_GE, CharaImageCB.class);
    }

    /**
     * Prepare ScalarCondition as lessEqual. <br>
     * {where FOO &lt;= (select max(BAR) from ...)}
     * <pre>
     * cb.query().<span style="color: #CC4747">scalar_LessEqual()</span>.max(new SubQuery&lt;CharaImageCB&gt;() {
     *     public void query(CharaImageCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<CharaImageCB> scalar_LessEqual() {
        return xcreateSLCFunction(CK_LE, CharaImageCB.class);
    }

    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xscalarCondition(String fn, SubQuery<CB> sq, String rd, HpSLCCustomized<CB> cs, ScalarConditionOption op) {
        assertObjectNotNull("subQuery", sq);
        CharaImageCB cb = xcreateScalarConditionCB(); sq.query((CB)cb);
        String pp = keepScalarCondition(cb.query()); // for saving query-value
        cs.setPartitionByCBean((CB)xcreateScalarConditionPartitionByCB()); // for using partition-by
        registerScalarCondition(fn, cb.query(), pp, rd, cs, op);
    }
    public abstract String keepScalarCondition(CharaImageCQ sq);

    protected CharaImageCB xcreateScalarConditionCB() {
        CharaImageCB cb = newMyCB(); cb.xsetupForScalarCondition(this); return cb;
    }

    protected CharaImageCB xcreateScalarConditionPartitionByCB() {
        CharaImageCB cb = newMyCB(); cb.xsetupForScalarConditionPartitionBy(this); return cb;
    }

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
    protected CharaImageCB newMyCB() {
        return new CharaImageCB();
    }
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xabUDT() { return Date.class.getName(); }
    protected String xabCQ() { return CharaImageCQ.class.getName(); }
    protected String xabLSO() { return LikeSearchOption.class.getName(); }
    protected String xabSLCS() { return HpSLCSetupper.class.getName(); }
    protected String xabSCP() { return SubQuery.class.getName(); }
}
