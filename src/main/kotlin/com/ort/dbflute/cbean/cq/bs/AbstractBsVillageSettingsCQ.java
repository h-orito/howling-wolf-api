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
 * The abstract condition-query of village_settings.
 * @author DBFlute(AutoGenerator)
 */
public abstract class AbstractBsVillageSettingsCQ extends AbstractConditionQuery {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public AbstractBsVillageSettingsCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
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
        return "village_settings";
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_ID: {PK, NotNull, INT UNSIGNED(10), FK to village}
     * @param villageId The value of villageId as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setVillageId_Equal(Integer villageId) {
        doSetVillageId_Equal(villageId);
    }

    protected void doSetVillageId_Equal(Integer villageId) {
        regVillageId(CK_EQ, villageId);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_ID: {PK, NotNull, INT UNSIGNED(10), FK to village}
     * @param villageId The value of villageId as notEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setVillageId_NotEqual(Integer villageId) {
        doSetVillageId_NotEqual(villageId);
    }

    protected void doSetVillageId_NotEqual(Integer villageId) {
        regVillageId(CK_NES, villageId);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_ID: {PK, NotNull, INT UNSIGNED(10), FK to village}
     * @param villageId The value of villageId as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setVillageId_GreaterThan(Integer villageId) {
        regVillageId(CK_GT, villageId);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_ID: {PK, NotNull, INT UNSIGNED(10), FK to village}
     * @param villageId The value of villageId as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setVillageId_LessThan(Integer villageId) {
        regVillageId(CK_LT, villageId);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_ID: {PK, NotNull, INT UNSIGNED(10), FK to village}
     * @param villageId The value of villageId as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setVillageId_GreaterEqual(Integer villageId) {
        regVillageId(CK_GE, villageId);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_ID: {PK, NotNull, INT UNSIGNED(10), FK to village}
     * @param villageId The value of villageId as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setVillageId_LessEqual(Integer villageId) {
        regVillageId(CK_LE, villageId);
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_ID: {PK, NotNull, INT UNSIGNED(10), FK to village}
     * @param minNumber The min number of villageId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of villageId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param opLambda The callback for option of range-of. (NotNull)
     */
    public void setVillageId_RangeOf(Integer minNumber, Integer maxNumber, ConditionOptionCall<RangeOfOption> opLambda) {
        setVillageId_RangeOf(minNumber, maxNumber, xcROOP(opLambda));
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_ID: {PK, NotNull, INT UNSIGNED(10), FK to village}
     * @param minNumber The min number of villageId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of villageId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    protected void setVillageId_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, xgetCValueVillageId(), "VILLAGE_ID", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * VILLAGE_ID: {PK, NotNull, INT UNSIGNED(10), FK to village}
     * @param villageIdList The collection of villageId as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setVillageId_InScope(Collection<Integer> villageIdList) {
        doSetVillageId_InScope(villageIdList);
    }

    protected void doSetVillageId_InScope(Collection<Integer> villageIdList) {
        regINS(CK_INS, cTL(villageIdList), xgetCValueVillageId(), "VILLAGE_ID");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * VILLAGE_ID: {PK, NotNull, INT UNSIGNED(10), FK to village}
     * @param villageIdList The collection of villageId as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setVillageId_NotInScope(Collection<Integer> villageIdList) {
        doSetVillageId_NotInScope(villageIdList);
    }

    protected void doSetVillageId_NotInScope(Collection<Integer> villageIdList) {
        regINS(CK_NINS, cTL(villageIdList), xgetCValueVillageId(), "VILLAGE_ID");
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * VILLAGE_ID: {PK, NotNull, INT UNSIGNED(10), FK to village}
     */
    public void setVillageId_IsNull() { regVillageId(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * VILLAGE_ID: {PK, NotNull, INT UNSIGNED(10), FK to village}
     */
    public void setVillageId_IsNotNull() { regVillageId(CK_ISNN, DOBJ); }

    protected void regVillageId(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueVillageId(), "VILLAGE_ID"); }
    protected abstract ConditionValue xgetCValueVillageId();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * DUMMY_CHARA_ID: {NotNull, INT UNSIGNED(10)}
     * @param dummyCharaId The value of dummyCharaId as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setDummyCharaId_Equal(Integer dummyCharaId) {
        doSetDummyCharaId_Equal(dummyCharaId);
    }

    protected void doSetDummyCharaId_Equal(Integer dummyCharaId) {
        regDummyCharaId(CK_EQ, dummyCharaId);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * DUMMY_CHARA_ID: {NotNull, INT UNSIGNED(10)}
     * @param dummyCharaId The value of dummyCharaId as notEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setDummyCharaId_NotEqual(Integer dummyCharaId) {
        doSetDummyCharaId_NotEqual(dummyCharaId);
    }

    protected void doSetDummyCharaId_NotEqual(Integer dummyCharaId) {
        regDummyCharaId(CK_NES, dummyCharaId);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * DUMMY_CHARA_ID: {NotNull, INT UNSIGNED(10)}
     * @param dummyCharaId The value of dummyCharaId as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setDummyCharaId_GreaterThan(Integer dummyCharaId) {
        regDummyCharaId(CK_GT, dummyCharaId);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * DUMMY_CHARA_ID: {NotNull, INT UNSIGNED(10)}
     * @param dummyCharaId The value of dummyCharaId as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setDummyCharaId_LessThan(Integer dummyCharaId) {
        regDummyCharaId(CK_LT, dummyCharaId);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * DUMMY_CHARA_ID: {NotNull, INT UNSIGNED(10)}
     * @param dummyCharaId The value of dummyCharaId as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setDummyCharaId_GreaterEqual(Integer dummyCharaId) {
        regDummyCharaId(CK_GE, dummyCharaId);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * DUMMY_CHARA_ID: {NotNull, INT UNSIGNED(10)}
     * @param dummyCharaId The value of dummyCharaId as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setDummyCharaId_LessEqual(Integer dummyCharaId) {
        regDummyCharaId(CK_LE, dummyCharaId);
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * DUMMY_CHARA_ID: {NotNull, INT UNSIGNED(10)}
     * @param minNumber The min number of dummyCharaId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of dummyCharaId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param opLambda The callback for option of range-of. (NotNull)
     */
    public void setDummyCharaId_RangeOf(Integer minNumber, Integer maxNumber, ConditionOptionCall<RangeOfOption> opLambda) {
        setDummyCharaId_RangeOf(minNumber, maxNumber, xcROOP(opLambda));
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * DUMMY_CHARA_ID: {NotNull, INT UNSIGNED(10)}
     * @param minNumber The min number of dummyCharaId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of dummyCharaId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    protected void setDummyCharaId_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, xgetCValueDummyCharaId(), "DUMMY_CHARA_ID", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * DUMMY_CHARA_ID: {NotNull, INT UNSIGNED(10)}
     * @param dummyCharaIdList The collection of dummyCharaId as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setDummyCharaId_InScope(Collection<Integer> dummyCharaIdList) {
        doSetDummyCharaId_InScope(dummyCharaIdList);
    }

    protected void doSetDummyCharaId_InScope(Collection<Integer> dummyCharaIdList) {
        regINS(CK_INS, cTL(dummyCharaIdList), xgetCValueDummyCharaId(), "DUMMY_CHARA_ID");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * DUMMY_CHARA_ID: {NotNull, INT UNSIGNED(10)}
     * @param dummyCharaIdList The collection of dummyCharaId as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setDummyCharaId_NotInScope(Collection<Integer> dummyCharaIdList) {
        doSetDummyCharaId_NotInScope(dummyCharaIdList);
    }

    protected void doSetDummyCharaId_NotInScope(Collection<Integer> dummyCharaIdList) {
        regINS(CK_NINS, cTL(dummyCharaIdList), xgetCValueDummyCharaId(), "DUMMY_CHARA_ID");
    }

    protected void regDummyCharaId(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueDummyCharaId(), "DUMMY_CHARA_ID"); }
    protected abstract ConditionValue xgetCValueDummyCharaId();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * START_PERSON_MIN_NUM: {INT UNSIGNED(10)}
     * @param startPersonMinNum The value of startPersonMinNum as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setStartPersonMinNum_Equal(Integer startPersonMinNum) {
        doSetStartPersonMinNum_Equal(startPersonMinNum);
    }

    protected void doSetStartPersonMinNum_Equal(Integer startPersonMinNum) {
        regStartPersonMinNum(CK_EQ, startPersonMinNum);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * START_PERSON_MIN_NUM: {INT UNSIGNED(10)}
     * @param startPersonMinNum The value of startPersonMinNum as notEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setStartPersonMinNum_NotEqual(Integer startPersonMinNum) {
        doSetStartPersonMinNum_NotEqual(startPersonMinNum);
    }

    protected void doSetStartPersonMinNum_NotEqual(Integer startPersonMinNum) {
        regStartPersonMinNum(CK_NES, startPersonMinNum);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * START_PERSON_MIN_NUM: {INT UNSIGNED(10)}
     * @param startPersonMinNum The value of startPersonMinNum as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setStartPersonMinNum_GreaterThan(Integer startPersonMinNum) {
        regStartPersonMinNum(CK_GT, startPersonMinNum);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * START_PERSON_MIN_NUM: {INT UNSIGNED(10)}
     * @param startPersonMinNum The value of startPersonMinNum as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setStartPersonMinNum_LessThan(Integer startPersonMinNum) {
        regStartPersonMinNum(CK_LT, startPersonMinNum);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * START_PERSON_MIN_NUM: {INT UNSIGNED(10)}
     * @param startPersonMinNum The value of startPersonMinNum as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setStartPersonMinNum_GreaterEqual(Integer startPersonMinNum) {
        regStartPersonMinNum(CK_GE, startPersonMinNum);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * START_PERSON_MIN_NUM: {INT UNSIGNED(10)}
     * @param startPersonMinNum The value of startPersonMinNum as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setStartPersonMinNum_LessEqual(Integer startPersonMinNum) {
        regStartPersonMinNum(CK_LE, startPersonMinNum);
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * START_PERSON_MIN_NUM: {INT UNSIGNED(10)}
     * @param minNumber The min number of startPersonMinNum. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of startPersonMinNum. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param opLambda The callback for option of range-of. (NotNull)
     */
    public void setStartPersonMinNum_RangeOf(Integer minNumber, Integer maxNumber, ConditionOptionCall<RangeOfOption> opLambda) {
        setStartPersonMinNum_RangeOf(minNumber, maxNumber, xcROOP(opLambda));
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * START_PERSON_MIN_NUM: {INT UNSIGNED(10)}
     * @param minNumber The min number of startPersonMinNum. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of startPersonMinNum. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    protected void setStartPersonMinNum_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, xgetCValueStartPersonMinNum(), "START_PERSON_MIN_NUM", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * START_PERSON_MIN_NUM: {INT UNSIGNED(10)}
     * @param startPersonMinNumList The collection of startPersonMinNum as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setStartPersonMinNum_InScope(Collection<Integer> startPersonMinNumList) {
        doSetStartPersonMinNum_InScope(startPersonMinNumList);
    }

    protected void doSetStartPersonMinNum_InScope(Collection<Integer> startPersonMinNumList) {
        regINS(CK_INS, cTL(startPersonMinNumList), xgetCValueStartPersonMinNum(), "START_PERSON_MIN_NUM");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * START_PERSON_MIN_NUM: {INT UNSIGNED(10)}
     * @param startPersonMinNumList The collection of startPersonMinNum as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setStartPersonMinNum_NotInScope(Collection<Integer> startPersonMinNumList) {
        doSetStartPersonMinNum_NotInScope(startPersonMinNumList);
    }

    protected void doSetStartPersonMinNum_NotInScope(Collection<Integer> startPersonMinNumList) {
        regINS(CK_NINS, cTL(startPersonMinNumList), xgetCValueStartPersonMinNum(), "START_PERSON_MIN_NUM");
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * START_PERSON_MIN_NUM: {INT UNSIGNED(10)}
     */
    public void setStartPersonMinNum_IsNull() { regStartPersonMinNum(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * START_PERSON_MIN_NUM: {INT UNSIGNED(10)}
     */
    public void setStartPersonMinNum_IsNotNull() { regStartPersonMinNum(CK_ISNN, DOBJ); }

    protected void regStartPersonMinNum(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueStartPersonMinNum(), "START_PERSON_MIN_NUM"); }
    protected abstract ConditionValue xgetCValueStartPersonMinNum();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * PERSON_MAX_NUM: {INT UNSIGNED(10)}
     * @param personMaxNum The value of personMaxNum as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setPersonMaxNum_Equal(Integer personMaxNum) {
        doSetPersonMaxNum_Equal(personMaxNum);
    }

    protected void doSetPersonMaxNum_Equal(Integer personMaxNum) {
        regPersonMaxNum(CK_EQ, personMaxNum);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * PERSON_MAX_NUM: {INT UNSIGNED(10)}
     * @param personMaxNum The value of personMaxNum as notEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setPersonMaxNum_NotEqual(Integer personMaxNum) {
        doSetPersonMaxNum_NotEqual(personMaxNum);
    }

    protected void doSetPersonMaxNum_NotEqual(Integer personMaxNum) {
        regPersonMaxNum(CK_NES, personMaxNum);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * PERSON_MAX_NUM: {INT UNSIGNED(10)}
     * @param personMaxNum The value of personMaxNum as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setPersonMaxNum_GreaterThan(Integer personMaxNum) {
        regPersonMaxNum(CK_GT, personMaxNum);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * PERSON_MAX_NUM: {INT UNSIGNED(10)}
     * @param personMaxNum The value of personMaxNum as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setPersonMaxNum_LessThan(Integer personMaxNum) {
        regPersonMaxNum(CK_LT, personMaxNum);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * PERSON_MAX_NUM: {INT UNSIGNED(10)}
     * @param personMaxNum The value of personMaxNum as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setPersonMaxNum_GreaterEqual(Integer personMaxNum) {
        regPersonMaxNum(CK_GE, personMaxNum);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * PERSON_MAX_NUM: {INT UNSIGNED(10)}
     * @param personMaxNum The value of personMaxNum as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setPersonMaxNum_LessEqual(Integer personMaxNum) {
        regPersonMaxNum(CK_LE, personMaxNum);
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * PERSON_MAX_NUM: {INT UNSIGNED(10)}
     * @param minNumber The min number of personMaxNum. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of personMaxNum. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param opLambda The callback for option of range-of. (NotNull)
     */
    public void setPersonMaxNum_RangeOf(Integer minNumber, Integer maxNumber, ConditionOptionCall<RangeOfOption> opLambda) {
        setPersonMaxNum_RangeOf(minNumber, maxNumber, xcROOP(opLambda));
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * PERSON_MAX_NUM: {INT UNSIGNED(10)}
     * @param minNumber The min number of personMaxNum. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of personMaxNum. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    protected void setPersonMaxNum_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, xgetCValuePersonMaxNum(), "PERSON_MAX_NUM", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * PERSON_MAX_NUM: {INT UNSIGNED(10)}
     * @param personMaxNumList The collection of personMaxNum as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setPersonMaxNum_InScope(Collection<Integer> personMaxNumList) {
        doSetPersonMaxNum_InScope(personMaxNumList);
    }

    protected void doSetPersonMaxNum_InScope(Collection<Integer> personMaxNumList) {
        regINS(CK_INS, cTL(personMaxNumList), xgetCValuePersonMaxNum(), "PERSON_MAX_NUM");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * PERSON_MAX_NUM: {INT UNSIGNED(10)}
     * @param personMaxNumList The collection of personMaxNum as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setPersonMaxNum_NotInScope(Collection<Integer> personMaxNumList) {
        doSetPersonMaxNum_NotInScope(personMaxNumList);
    }

    protected void doSetPersonMaxNum_NotInScope(Collection<Integer> personMaxNumList) {
        regINS(CK_NINS, cTL(personMaxNumList), xgetCValuePersonMaxNum(), "PERSON_MAX_NUM");
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * PERSON_MAX_NUM: {INT UNSIGNED(10)}
     */
    public void setPersonMaxNum_IsNull() { regPersonMaxNum(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * PERSON_MAX_NUM: {INT UNSIGNED(10)}
     */
    public void setPersonMaxNum_IsNotNull() { regPersonMaxNum(CK_ISNN, DOBJ); }

    protected void regPersonMaxNum(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValuePersonMaxNum(), "PERSON_MAX_NUM"); }
    protected abstract ConditionValue xgetCValuePersonMaxNum();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * START_DATETIME: {DATETIME(19)}
     * @param startDatetime The value of startDatetime as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setStartDatetime_Equal(java.time.LocalDateTime startDatetime) {
        regStartDatetime(CK_EQ,  startDatetime);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * START_DATETIME: {DATETIME(19)}
     * @param startDatetime The value of startDatetime as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setStartDatetime_GreaterThan(java.time.LocalDateTime startDatetime) {
        regStartDatetime(CK_GT,  startDatetime);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * START_DATETIME: {DATETIME(19)}
     * @param startDatetime The value of startDatetime as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setStartDatetime_LessThan(java.time.LocalDateTime startDatetime) {
        regStartDatetime(CK_LT,  startDatetime);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * START_DATETIME: {DATETIME(19)}
     * @param startDatetime The value of startDatetime as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setStartDatetime_GreaterEqual(java.time.LocalDateTime startDatetime) {
        regStartDatetime(CK_GE,  startDatetime);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * START_DATETIME: {DATETIME(19)}
     * @param startDatetime The value of startDatetime as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setStartDatetime_LessEqual(java.time.LocalDateTime startDatetime) {
        regStartDatetime(CK_LE, startDatetime);
    }

    /**
     * FromTo with various options. (versatile) {(default) fromDatetime &lt;= column &lt;= toDatetime} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * START_DATETIME: {DATETIME(19)}
     * <pre>e.g. setStartDatetime_FromTo(fromDate, toDate, op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">compareAsDate()</span>);</pre>
     * @param fromDatetime The from-datetime(yyyy/MM/dd HH:mm:ss.SSS) of startDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param toDatetime The to-datetime(yyyy/MM/dd HH:mm:ss.SSS) of startDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param opLambda The callback for option of from-to. (NotNull)
     */
    public void setStartDatetime_FromTo(java.time.LocalDateTime fromDatetime, java.time.LocalDateTime toDatetime, ConditionOptionCall<FromToOption> opLambda) {
        setStartDatetime_FromTo(fromDatetime, toDatetime, xcFTOP(opLambda));
    }

    /**
     * FromTo with various options. (versatile) {(default) fromDatetime &lt;= column &lt;= toDatetime} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * START_DATETIME: {DATETIME(19)}
     * <pre>e.g. setStartDatetime_FromTo(fromDate, toDate, new <span style="color: #CC4747">FromToOption</span>().compareAsDate());</pre>
     * @param fromDatetime The from-datetime(yyyy/MM/dd HH:mm:ss.SSS) of startDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param toDatetime The to-datetime(yyyy/MM/dd HH:mm:ss.SSS) of startDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param fromToOption The option of from-to. (NotNull)
     */
    protected void setStartDatetime_FromTo(java.time.LocalDateTime fromDatetime, java.time.LocalDateTime toDatetime, FromToOption fromToOption) {
        String nm = "START_DATETIME"; FromToOption op = fromToOption;
        regFTQ(xfFTHD(fromDatetime, nm, op), xfFTHD(toDatetime, nm, op), xgetCValueStartDatetime(), nm, op);
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * START_DATETIME: {DATETIME(19)}
     */
    public void setStartDatetime_IsNull() { regStartDatetime(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * START_DATETIME: {DATETIME(19)}
     */
    public void setStartDatetime_IsNotNull() { regStartDatetime(CK_ISNN, DOBJ); }

    protected void regStartDatetime(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueStartDatetime(), "START_DATETIME"); }
    protected abstract ConditionValue xgetCValueStartDatetime();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * DAY_CHANGE_INTERVAL_SECONDS: {NotNull, INT UNSIGNED(10)}
     * @param dayChangeIntervalSeconds The value of dayChangeIntervalSeconds as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setDayChangeIntervalSeconds_Equal(Integer dayChangeIntervalSeconds) {
        doSetDayChangeIntervalSeconds_Equal(dayChangeIntervalSeconds);
    }

    protected void doSetDayChangeIntervalSeconds_Equal(Integer dayChangeIntervalSeconds) {
        regDayChangeIntervalSeconds(CK_EQ, dayChangeIntervalSeconds);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * DAY_CHANGE_INTERVAL_SECONDS: {NotNull, INT UNSIGNED(10)}
     * @param dayChangeIntervalSeconds The value of dayChangeIntervalSeconds as notEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setDayChangeIntervalSeconds_NotEqual(Integer dayChangeIntervalSeconds) {
        doSetDayChangeIntervalSeconds_NotEqual(dayChangeIntervalSeconds);
    }

    protected void doSetDayChangeIntervalSeconds_NotEqual(Integer dayChangeIntervalSeconds) {
        regDayChangeIntervalSeconds(CK_NES, dayChangeIntervalSeconds);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * DAY_CHANGE_INTERVAL_SECONDS: {NotNull, INT UNSIGNED(10)}
     * @param dayChangeIntervalSeconds The value of dayChangeIntervalSeconds as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setDayChangeIntervalSeconds_GreaterThan(Integer dayChangeIntervalSeconds) {
        regDayChangeIntervalSeconds(CK_GT, dayChangeIntervalSeconds);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * DAY_CHANGE_INTERVAL_SECONDS: {NotNull, INT UNSIGNED(10)}
     * @param dayChangeIntervalSeconds The value of dayChangeIntervalSeconds as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setDayChangeIntervalSeconds_LessThan(Integer dayChangeIntervalSeconds) {
        regDayChangeIntervalSeconds(CK_LT, dayChangeIntervalSeconds);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * DAY_CHANGE_INTERVAL_SECONDS: {NotNull, INT UNSIGNED(10)}
     * @param dayChangeIntervalSeconds The value of dayChangeIntervalSeconds as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setDayChangeIntervalSeconds_GreaterEqual(Integer dayChangeIntervalSeconds) {
        regDayChangeIntervalSeconds(CK_GE, dayChangeIntervalSeconds);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * DAY_CHANGE_INTERVAL_SECONDS: {NotNull, INT UNSIGNED(10)}
     * @param dayChangeIntervalSeconds The value of dayChangeIntervalSeconds as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setDayChangeIntervalSeconds_LessEqual(Integer dayChangeIntervalSeconds) {
        regDayChangeIntervalSeconds(CK_LE, dayChangeIntervalSeconds);
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * DAY_CHANGE_INTERVAL_SECONDS: {NotNull, INT UNSIGNED(10)}
     * @param minNumber The min number of dayChangeIntervalSeconds. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of dayChangeIntervalSeconds. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param opLambda The callback for option of range-of. (NotNull)
     */
    public void setDayChangeIntervalSeconds_RangeOf(Integer minNumber, Integer maxNumber, ConditionOptionCall<RangeOfOption> opLambda) {
        setDayChangeIntervalSeconds_RangeOf(minNumber, maxNumber, xcROOP(opLambda));
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * DAY_CHANGE_INTERVAL_SECONDS: {NotNull, INT UNSIGNED(10)}
     * @param minNumber The min number of dayChangeIntervalSeconds. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of dayChangeIntervalSeconds. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    protected void setDayChangeIntervalSeconds_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, xgetCValueDayChangeIntervalSeconds(), "DAY_CHANGE_INTERVAL_SECONDS", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * DAY_CHANGE_INTERVAL_SECONDS: {NotNull, INT UNSIGNED(10)}
     * @param dayChangeIntervalSecondsList The collection of dayChangeIntervalSeconds as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setDayChangeIntervalSeconds_InScope(Collection<Integer> dayChangeIntervalSecondsList) {
        doSetDayChangeIntervalSeconds_InScope(dayChangeIntervalSecondsList);
    }

    protected void doSetDayChangeIntervalSeconds_InScope(Collection<Integer> dayChangeIntervalSecondsList) {
        regINS(CK_INS, cTL(dayChangeIntervalSecondsList), xgetCValueDayChangeIntervalSeconds(), "DAY_CHANGE_INTERVAL_SECONDS");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * DAY_CHANGE_INTERVAL_SECONDS: {NotNull, INT UNSIGNED(10)}
     * @param dayChangeIntervalSecondsList The collection of dayChangeIntervalSeconds as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setDayChangeIntervalSeconds_NotInScope(Collection<Integer> dayChangeIntervalSecondsList) {
        doSetDayChangeIntervalSeconds_NotInScope(dayChangeIntervalSecondsList);
    }

    protected void doSetDayChangeIntervalSeconds_NotInScope(Collection<Integer> dayChangeIntervalSecondsList) {
        regINS(CK_NINS, cTL(dayChangeIntervalSecondsList), xgetCValueDayChangeIntervalSeconds(), "DAY_CHANGE_INTERVAL_SECONDS");
    }

    protected void regDayChangeIntervalSeconds(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueDayChangeIntervalSeconds(), "DAY_CHANGE_INTERVAL_SECONDS"); }
    protected abstract ConditionValue xgetCValueDayChangeIntervalSeconds();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * IS_OPEN_VOTE: {NotNull, BIT}
     * @param isOpenVote The value of isOpenVote as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setIsOpenVote_Equal(Boolean isOpenVote) {
        regIsOpenVote(CK_EQ, isOpenVote);
    }

    protected void regIsOpenVote(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueIsOpenVote(), "IS_OPEN_VOTE"); }
    protected abstract ConditionValue xgetCValueIsOpenVote();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * IS_POSSIBLE_SKILL_REQUEST: {NotNull, BIT}
     * @param isPossibleSkillRequest The value of isPossibleSkillRequest as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setIsPossibleSkillRequest_Equal(Boolean isPossibleSkillRequest) {
        regIsPossibleSkillRequest(CK_EQ, isPossibleSkillRequest);
    }

    protected void regIsPossibleSkillRequest(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueIsPossibleSkillRequest(), "IS_POSSIBLE_SKILL_REQUEST"); }
    protected abstract ConditionValue xgetCValueIsPossibleSkillRequest();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * IS_AVAILABLE_SPECTATE: {NotNull, BIT}
     * @param isAvailableSpectate The value of isAvailableSpectate as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setIsAvailableSpectate_Equal(Boolean isAvailableSpectate) {
        regIsAvailableSpectate(CK_EQ, isAvailableSpectate);
    }

    protected void regIsAvailableSpectate(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueIsAvailableSpectate(), "IS_AVAILABLE_SPECTATE"); }
    protected abstract ConditionValue xgetCValueIsAvailableSpectate();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * IS_AVAILABLE_SAME_WOLF_ATTACK: {NotNull, BIT}
     * @param isAvailableSameWolfAttack The value of isAvailableSameWolfAttack as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setIsAvailableSameWolfAttack_Equal(Boolean isAvailableSameWolfAttack) {
        regIsAvailableSameWolfAttack(CK_EQ, isAvailableSameWolfAttack);
    }

    protected void regIsAvailableSameWolfAttack(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueIsAvailableSameWolfAttack(), "IS_AVAILABLE_SAME_WOLF_ATTACK"); }
    protected abstract ConditionValue xgetCValueIsAvailableSameWolfAttack();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * IS_OPEN_SKILL_IN_GRAVE: {NotNull, BIT}
     * @param isOpenSkillInGrave The value of isOpenSkillInGrave as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setIsOpenSkillInGrave_Equal(Boolean isOpenSkillInGrave) {
        regIsOpenSkillInGrave(CK_EQ, isOpenSkillInGrave);
    }

    protected void regIsOpenSkillInGrave(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueIsOpenSkillInGrave(), "IS_OPEN_SKILL_IN_GRAVE"); }
    protected abstract ConditionValue xgetCValueIsOpenSkillInGrave();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * IS_VISIBLE_GRAVE_SPECTATE_MESSAGE: {NotNull, BIT}
     * @param isVisibleGraveSpectateMessage The value of isVisibleGraveSpectateMessage as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setIsVisibleGraveSpectateMessage_Equal(Boolean isVisibleGraveSpectateMessage) {
        regIsVisibleGraveSpectateMessage(CK_EQ, isVisibleGraveSpectateMessage);
    }

    protected void regIsVisibleGraveSpectateMessage(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueIsVisibleGraveSpectateMessage(), "IS_VISIBLE_GRAVE_SPECTATE_MESSAGE"); }
    protected abstract ConditionValue xgetCValueIsVisibleGraveSpectateMessage();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * IS_AVAILABLE_SUDDONLY_DEATH: {NotNull, BIT}
     * @param isAvailableSuddonlyDeath The value of isAvailableSuddonlyDeath as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setIsAvailableSuddonlyDeath_Equal(Boolean isAvailableSuddonlyDeath) {
        regIsAvailableSuddonlyDeath(CK_EQ, isAvailableSuddonlyDeath);
    }

    protected void regIsAvailableSuddonlyDeath(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueIsAvailableSuddonlyDeath(), "IS_AVAILABLE_SUDDONLY_DEATH"); }
    protected abstract ConditionValue xgetCValueIsAvailableSuddonlyDeath();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * IS_AVAILABLE_COMMIT: {NotNull, BIT}
     * @param isAvailableCommit The value of isAvailableCommit as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setIsAvailableCommit_Equal(Boolean isAvailableCommit) {
        regIsAvailableCommit(CK_EQ, isAvailableCommit);
    }

    protected void regIsAvailableCommit(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueIsAvailableCommit(), "IS_AVAILABLE_COMMIT"); }
    protected abstract ConditionValue xgetCValueIsAvailableCommit();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * IS_AVAILABLE_GUARD_SAME_TARGET: {NotNull, BIT}
     * @param isAvailableGuardSameTarget The value of isAvailableGuardSameTarget as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setIsAvailableGuardSameTarget_Equal(Boolean isAvailableGuardSameTarget) {
        regIsAvailableGuardSameTarget(CK_EQ, isAvailableGuardSameTarget);
    }

    protected void regIsAvailableGuardSameTarget(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueIsAvailableGuardSameTarget(), "IS_AVAILABLE_GUARD_SAME_TARGET"); }
    protected abstract ConditionValue xgetCValueIsAvailableGuardSameTarget();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * CHARACTER_GROUP_ID: {IX, NotNull, INT UNSIGNED(10), FK to chara_group}
     * @param characterGroupId The value of characterGroupId as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setCharacterGroupId_Equal(Integer characterGroupId) {
        doSetCharacterGroupId_Equal(characterGroupId);
    }

    protected void doSetCharacterGroupId_Equal(Integer characterGroupId) {
        regCharacterGroupId(CK_EQ, characterGroupId);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * CHARACTER_GROUP_ID: {IX, NotNull, INT UNSIGNED(10), FK to chara_group}
     * @param characterGroupId The value of characterGroupId as notEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setCharacterGroupId_NotEqual(Integer characterGroupId) {
        doSetCharacterGroupId_NotEqual(characterGroupId);
    }

    protected void doSetCharacterGroupId_NotEqual(Integer characterGroupId) {
        regCharacterGroupId(CK_NES, characterGroupId);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * CHARACTER_GROUP_ID: {IX, NotNull, INT UNSIGNED(10), FK to chara_group}
     * @param characterGroupId The value of characterGroupId as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setCharacterGroupId_GreaterThan(Integer characterGroupId) {
        regCharacterGroupId(CK_GT, characterGroupId);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * CHARACTER_GROUP_ID: {IX, NotNull, INT UNSIGNED(10), FK to chara_group}
     * @param characterGroupId The value of characterGroupId as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setCharacterGroupId_LessThan(Integer characterGroupId) {
        regCharacterGroupId(CK_LT, characterGroupId);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * CHARACTER_GROUP_ID: {IX, NotNull, INT UNSIGNED(10), FK to chara_group}
     * @param characterGroupId The value of characterGroupId as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setCharacterGroupId_GreaterEqual(Integer characterGroupId) {
        regCharacterGroupId(CK_GE, characterGroupId);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * CHARACTER_GROUP_ID: {IX, NotNull, INT UNSIGNED(10), FK to chara_group}
     * @param characterGroupId The value of characterGroupId as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setCharacterGroupId_LessEqual(Integer characterGroupId) {
        regCharacterGroupId(CK_LE, characterGroupId);
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * CHARACTER_GROUP_ID: {IX, NotNull, INT UNSIGNED(10), FK to chara_group}
     * @param minNumber The min number of characterGroupId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of characterGroupId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param opLambda The callback for option of range-of. (NotNull)
     */
    public void setCharacterGroupId_RangeOf(Integer minNumber, Integer maxNumber, ConditionOptionCall<RangeOfOption> opLambda) {
        setCharacterGroupId_RangeOf(minNumber, maxNumber, xcROOP(opLambda));
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * CHARACTER_GROUP_ID: {IX, NotNull, INT UNSIGNED(10), FK to chara_group}
     * @param minNumber The min number of characterGroupId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of characterGroupId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    protected void setCharacterGroupId_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, xgetCValueCharacterGroupId(), "CHARACTER_GROUP_ID", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * CHARACTER_GROUP_ID: {IX, NotNull, INT UNSIGNED(10), FK to chara_group}
     * @param characterGroupIdList The collection of characterGroupId as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setCharacterGroupId_InScope(Collection<Integer> characterGroupIdList) {
        doSetCharacterGroupId_InScope(characterGroupIdList);
    }

    protected void doSetCharacterGroupId_InScope(Collection<Integer> characterGroupIdList) {
        regINS(CK_INS, cTL(characterGroupIdList), xgetCValueCharacterGroupId(), "CHARACTER_GROUP_ID");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * CHARACTER_GROUP_ID: {IX, NotNull, INT UNSIGNED(10), FK to chara_group}
     * @param characterGroupIdList The collection of characterGroupId as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setCharacterGroupId_NotInScope(Collection<Integer> characterGroupIdList) {
        doSetCharacterGroupId_NotInScope(characterGroupIdList);
    }

    protected void doSetCharacterGroupId_NotInScope(Collection<Integer> characterGroupIdList) {
        regINS(CK_NINS, cTL(characterGroupIdList), xgetCValueCharacterGroupId(), "CHARACTER_GROUP_ID");
    }

    protected void regCharacterGroupId(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueCharacterGroupId(), "CHARACTER_GROUP_ID"); }
    protected abstract ConditionValue xgetCValueCharacterGroupId();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * JOIN_PASSWORD: {VARCHAR(12)}
     * @param joinPassword The value of joinPassword as equal. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setJoinPassword_Equal(String joinPassword) {
        doSetJoinPassword_Equal(fRES(joinPassword));
    }

    protected void doSetJoinPassword_Equal(String joinPassword) {
        regJoinPassword(CK_EQ, joinPassword);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * JOIN_PASSWORD: {VARCHAR(12)}
     * @param joinPassword The value of joinPassword as notEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setJoinPassword_NotEqual(String joinPassword) {
        doSetJoinPassword_NotEqual(fRES(joinPassword));
    }

    protected void doSetJoinPassword_NotEqual(String joinPassword) {
        regJoinPassword(CK_NES, joinPassword);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * JOIN_PASSWORD: {VARCHAR(12)}
     * @param joinPassword The value of joinPassword as greaterThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setJoinPassword_GreaterThan(String joinPassword) {
        regJoinPassword(CK_GT, fRES(joinPassword));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * JOIN_PASSWORD: {VARCHAR(12)}
     * @param joinPassword The value of joinPassword as lessThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setJoinPassword_LessThan(String joinPassword) {
        regJoinPassword(CK_LT, fRES(joinPassword));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * JOIN_PASSWORD: {VARCHAR(12)}
     * @param joinPassword The value of joinPassword as greaterEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setJoinPassword_GreaterEqual(String joinPassword) {
        regJoinPassword(CK_GE, fRES(joinPassword));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * JOIN_PASSWORD: {VARCHAR(12)}
     * @param joinPassword The value of joinPassword as lessEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setJoinPassword_LessEqual(String joinPassword) {
        regJoinPassword(CK_LE, fRES(joinPassword));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * JOIN_PASSWORD: {VARCHAR(12)}
     * @param joinPasswordList The collection of joinPassword as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setJoinPassword_InScope(Collection<String> joinPasswordList) {
        doSetJoinPassword_InScope(joinPasswordList);
    }

    protected void doSetJoinPassword_InScope(Collection<String> joinPasswordList) {
        regINS(CK_INS, cTL(joinPasswordList), xgetCValueJoinPassword(), "JOIN_PASSWORD");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * JOIN_PASSWORD: {VARCHAR(12)}
     * @param joinPasswordList The collection of joinPassword as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setJoinPassword_NotInScope(Collection<String> joinPasswordList) {
        doSetJoinPassword_NotInScope(joinPasswordList);
    }

    protected void doSetJoinPassword_NotInScope(Collection<String> joinPasswordList) {
        regINS(CK_NINS, cTL(joinPasswordList), xgetCValueJoinPassword(), "JOIN_PASSWORD");
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * JOIN_PASSWORD: {VARCHAR(12)} <br>
     * <pre>e.g. setJoinPassword_LikeSearch("xxx", op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">likeContain()</span>);</pre>
     * @param joinPassword The value of joinPassword as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setJoinPassword_LikeSearch(String joinPassword, ConditionOptionCall<LikeSearchOption> opLambda) {
        setJoinPassword_LikeSearch(joinPassword, xcLSOP(opLambda));
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * JOIN_PASSWORD: {VARCHAR(12)} <br>
     * <pre>e.g. setJoinPassword_LikeSearch("xxx", new <span style="color: #CC4747">LikeSearchOption</span>().likeContain());</pre>
     * @param joinPassword The value of joinPassword as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    protected void setJoinPassword_LikeSearch(String joinPassword, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(joinPassword), xgetCValueJoinPassword(), "JOIN_PASSWORD", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * JOIN_PASSWORD: {VARCHAR(12)}
     * @param joinPassword The value of joinPassword as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setJoinPassword_NotLikeSearch(String joinPassword, ConditionOptionCall<LikeSearchOption> opLambda) {
        setJoinPassword_NotLikeSearch(joinPassword, xcLSOP(opLambda));
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * JOIN_PASSWORD: {VARCHAR(12)}
     * @param joinPassword The value of joinPassword as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    protected void setJoinPassword_NotLikeSearch(String joinPassword, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(joinPassword), xgetCValueJoinPassword(), "JOIN_PASSWORD", likeSearchOption);
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * JOIN_PASSWORD: {VARCHAR(12)}
     */
    public void setJoinPassword_IsNull() { regJoinPassword(CK_ISN, DOBJ); }

    /**
     * IsNullOrEmpty {is null or empty}. And OnlyOnceRegistered. <br>
     * JOIN_PASSWORD: {VARCHAR(12)}
     */
    public void setJoinPassword_IsNullOrEmpty() { regJoinPassword(CK_ISNOE, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * JOIN_PASSWORD: {VARCHAR(12)}
     */
    public void setJoinPassword_IsNotNull() { regJoinPassword(CK_ISNN, DOBJ); }

    protected void regJoinPassword(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueJoinPassword(), "JOIN_PASSWORD"); }
    protected abstract ConditionValue xgetCValueJoinPassword();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * ORGANIZE: {NotNull, VARCHAR(400)}
     * @param organize The value of organize as equal. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setOrganize_Equal(String organize) {
        doSetOrganize_Equal(fRES(organize));
    }

    protected void doSetOrganize_Equal(String organize) {
        regOrganize(CK_EQ, organize);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * ORGANIZE: {NotNull, VARCHAR(400)}
     * @param organize The value of organize as notEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setOrganize_NotEqual(String organize) {
        doSetOrganize_NotEqual(fRES(organize));
    }

    protected void doSetOrganize_NotEqual(String organize) {
        regOrganize(CK_NES, organize);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * ORGANIZE: {NotNull, VARCHAR(400)}
     * @param organize The value of organize as greaterThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setOrganize_GreaterThan(String organize) {
        regOrganize(CK_GT, fRES(organize));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * ORGANIZE: {NotNull, VARCHAR(400)}
     * @param organize The value of organize as lessThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setOrganize_LessThan(String organize) {
        regOrganize(CK_LT, fRES(organize));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * ORGANIZE: {NotNull, VARCHAR(400)}
     * @param organize The value of organize as greaterEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setOrganize_GreaterEqual(String organize) {
        regOrganize(CK_GE, fRES(organize));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * ORGANIZE: {NotNull, VARCHAR(400)}
     * @param organize The value of organize as lessEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setOrganize_LessEqual(String organize) {
        regOrganize(CK_LE, fRES(organize));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * ORGANIZE: {NotNull, VARCHAR(400)}
     * @param organizeList The collection of organize as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setOrganize_InScope(Collection<String> organizeList) {
        doSetOrganize_InScope(organizeList);
    }

    protected void doSetOrganize_InScope(Collection<String> organizeList) {
        regINS(CK_INS, cTL(organizeList), xgetCValueOrganize(), "ORGANIZE");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * ORGANIZE: {NotNull, VARCHAR(400)}
     * @param organizeList The collection of organize as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setOrganize_NotInScope(Collection<String> organizeList) {
        doSetOrganize_NotInScope(organizeList);
    }

    protected void doSetOrganize_NotInScope(Collection<String> organizeList) {
        regINS(CK_NINS, cTL(organizeList), xgetCValueOrganize(), "ORGANIZE");
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * ORGANIZE: {NotNull, VARCHAR(400)} <br>
     * <pre>e.g. setOrganize_LikeSearch("xxx", op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">likeContain()</span>);</pre>
     * @param organize The value of organize as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setOrganize_LikeSearch(String organize, ConditionOptionCall<LikeSearchOption> opLambda) {
        setOrganize_LikeSearch(organize, xcLSOP(opLambda));
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * ORGANIZE: {NotNull, VARCHAR(400)} <br>
     * <pre>e.g. setOrganize_LikeSearch("xxx", new <span style="color: #CC4747">LikeSearchOption</span>().likeContain());</pre>
     * @param organize The value of organize as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    protected void setOrganize_LikeSearch(String organize, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(organize), xgetCValueOrganize(), "ORGANIZE", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * ORGANIZE: {NotNull, VARCHAR(400)}
     * @param organize The value of organize as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setOrganize_NotLikeSearch(String organize, ConditionOptionCall<LikeSearchOption> opLambda) {
        setOrganize_NotLikeSearch(organize, xcLSOP(opLambda));
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * ORGANIZE: {NotNull, VARCHAR(400)}
     * @param organize The value of organize as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    protected void setOrganize_NotLikeSearch(String organize, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(organize), xgetCValueOrganize(), "ORGANIZE", likeSearchOption);
    }

    protected void regOrganize(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueOrganize(), "ORGANIZE"); }
    protected abstract ConditionValue xgetCValueOrganize();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * ALLOWED_SECRET_SAY_CODE: {IX, NotNull, VARCHAR(20), FK to allowed_secret_say, classification=AllowedSecretSay}
     * @param allowedSecretSayCode The value of allowedSecretSayCode as equal. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setAllowedSecretSayCode_Equal(String allowedSecretSayCode) {
        doSetAllowedSecretSayCode_Equal(fRES(allowedSecretSayCode));
    }

    /**
     * Equal(=). As AllowedSecretSay. And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * ALLOWED_SECRET_SAY_CODE: {IX, NotNull, VARCHAR(20), FK to allowed_secret_say, classification=AllowedSecretSay} <br>
     * 秘話可能範囲
     * @param cdef The instance of classification definition (as ENUM type). (basically NotNull: error as default, or no condition as option)
     */
    public void setAllowedSecretSayCode_Equal_AsAllowedSecretSay(CDef.AllowedSecretSay cdef) {
        doSetAllowedSecretSayCode_Equal(cdef != null ? cdef.code() : null);
    }

    /**
     * Equal(=). As 全員 (EVERYTHING). And OnlyOnceRegistered. <br>
     * 全員
     */
    public void setAllowedSecretSayCode_Equal_全員() {
        setAllowedSecretSayCode_Equal_AsAllowedSecretSay(CDef.AllowedSecretSay.全員);
    }

    /**
     * Equal(=). As なし (NOTHING). And OnlyOnceRegistered. <br>
     * なし
     */
    public void setAllowedSecretSayCode_Equal_なし() {
        setAllowedSecretSayCode_Equal_AsAllowedSecretSay(CDef.AllowedSecretSay.なし);
    }

    /**
     * Equal(=). As 村建てとのみ (ONLY_CREATOR). And OnlyOnceRegistered. <br>
     * 村建てとのみ
     */
    public void setAllowedSecretSayCode_Equal_村建てとのみ() {
        setAllowedSecretSayCode_Equal_AsAllowedSecretSay(CDef.AllowedSecretSay.村建てとのみ);
    }

    protected void doSetAllowedSecretSayCode_Equal(String allowedSecretSayCode) {
        regAllowedSecretSayCode(CK_EQ, allowedSecretSayCode);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * ALLOWED_SECRET_SAY_CODE: {IX, NotNull, VARCHAR(20), FK to allowed_secret_say, classification=AllowedSecretSay}
     * @param allowedSecretSayCode The value of allowedSecretSayCode as notEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setAllowedSecretSayCode_NotEqual(String allowedSecretSayCode) {
        doSetAllowedSecretSayCode_NotEqual(fRES(allowedSecretSayCode));
    }

    /**
     * NotEqual(&lt;&gt;). As AllowedSecretSay. And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * ALLOWED_SECRET_SAY_CODE: {IX, NotNull, VARCHAR(20), FK to allowed_secret_say, classification=AllowedSecretSay} <br>
     * 秘話可能範囲
     * @param cdef The instance of classification definition (as ENUM type). (basically NotNull: error as default, or no condition as option)
     */
    public void setAllowedSecretSayCode_NotEqual_AsAllowedSecretSay(CDef.AllowedSecretSay cdef) {
        doSetAllowedSecretSayCode_NotEqual(cdef != null ? cdef.code() : null);
    }

    /**
     * NotEqual(&lt;&gt;). As 全員 (EVERYTHING). And OnlyOnceRegistered. <br>
     * 全員
     */
    public void setAllowedSecretSayCode_NotEqual_全員() {
        setAllowedSecretSayCode_NotEqual_AsAllowedSecretSay(CDef.AllowedSecretSay.全員);
    }

    /**
     * NotEqual(&lt;&gt;). As なし (NOTHING). And OnlyOnceRegistered. <br>
     * なし
     */
    public void setAllowedSecretSayCode_NotEqual_なし() {
        setAllowedSecretSayCode_NotEqual_AsAllowedSecretSay(CDef.AllowedSecretSay.なし);
    }

    /**
     * NotEqual(&lt;&gt;). As 村建てとのみ (ONLY_CREATOR). And OnlyOnceRegistered. <br>
     * 村建てとのみ
     */
    public void setAllowedSecretSayCode_NotEqual_村建てとのみ() {
        setAllowedSecretSayCode_NotEqual_AsAllowedSecretSay(CDef.AllowedSecretSay.村建てとのみ);
    }

    protected void doSetAllowedSecretSayCode_NotEqual(String allowedSecretSayCode) {
        regAllowedSecretSayCode(CK_NES, allowedSecretSayCode);
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * ALLOWED_SECRET_SAY_CODE: {IX, NotNull, VARCHAR(20), FK to allowed_secret_say, classification=AllowedSecretSay}
     * @param allowedSecretSayCodeList The collection of allowedSecretSayCode as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setAllowedSecretSayCode_InScope(Collection<String> allowedSecretSayCodeList) {
        doSetAllowedSecretSayCode_InScope(allowedSecretSayCodeList);
    }

    /**
     * InScope {in ('a', 'b')}. As AllowedSecretSay. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * ALLOWED_SECRET_SAY_CODE: {IX, NotNull, VARCHAR(20), FK to allowed_secret_say, classification=AllowedSecretSay} <br>
     * 秘話可能範囲
     * @param cdefList The list of classification definition (as ENUM type). (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setAllowedSecretSayCode_InScope_AsAllowedSecretSay(Collection<CDef.AllowedSecretSay> cdefList) {
        doSetAllowedSecretSayCode_InScope(cTStrL(cdefList));
    }

    protected void doSetAllowedSecretSayCode_InScope(Collection<String> allowedSecretSayCodeList) {
        regINS(CK_INS, cTL(allowedSecretSayCodeList), xgetCValueAllowedSecretSayCode(), "ALLOWED_SECRET_SAY_CODE");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * ALLOWED_SECRET_SAY_CODE: {IX, NotNull, VARCHAR(20), FK to allowed_secret_say, classification=AllowedSecretSay}
     * @param allowedSecretSayCodeList The collection of allowedSecretSayCode as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setAllowedSecretSayCode_NotInScope(Collection<String> allowedSecretSayCodeList) {
        doSetAllowedSecretSayCode_NotInScope(allowedSecretSayCodeList);
    }

    /**
     * NotInScope {not in ('a', 'b')}. As AllowedSecretSay. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * ALLOWED_SECRET_SAY_CODE: {IX, NotNull, VARCHAR(20), FK to allowed_secret_say, classification=AllowedSecretSay} <br>
     * 秘話可能範囲
     * @param cdefList The list of classification definition (as ENUM type). (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setAllowedSecretSayCode_NotInScope_AsAllowedSecretSay(Collection<CDef.AllowedSecretSay> cdefList) {
        doSetAllowedSecretSayCode_NotInScope(cTStrL(cdefList));
    }

    protected void doSetAllowedSecretSayCode_NotInScope(Collection<String> allowedSecretSayCodeList) {
        regINS(CK_NINS, cTL(allowedSecretSayCodeList), xgetCValueAllowedSecretSayCode(), "ALLOWED_SECRET_SAY_CODE");
    }

    protected void regAllowedSecretSayCode(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueAllowedSecretSayCode(), "ALLOWED_SECRET_SAY_CODE"); }
    protected abstract ConditionValue xgetCValueAllowedSecretSayCode();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * REGISTER_DATETIME: {NotNull, DATETIME(19)}
     * @param registerDatetime The value of registerDatetime as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setRegisterDatetime_Equal(java.time.LocalDateTime registerDatetime) {
        regRegisterDatetime(CK_EQ,  registerDatetime);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * REGISTER_DATETIME: {NotNull, DATETIME(19)}
     * @param registerDatetime The value of registerDatetime as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setRegisterDatetime_GreaterThan(java.time.LocalDateTime registerDatetime) {
        regRegisterDatetime(CK_GT,  registerDatetime);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * REGISTER_DATETIME: {NotNull, DATETIME(19)}
     * @param registerDatetime The value of registerDatetime as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setRegisterDatetime_LessThan(java.time.LocalDateTime registerDatetime) {
        regRegisterDatetime(CK_LT,  registerDatetime);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * REGISTER_DATETIME: {NotNull, DATETIME(19)}
     * @param registerDatetime The value of registerDatetime as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setRegisterDatetime_GreaterEqual(java.time.LocalDateTime registerDatetime) {
        regRegisterDatetime(CK_GE,  registerDatetime);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * REGISTER_DATETIME: {NotNull, DATETIME(19)}
     * @param registerDatetime The value of registerDatetime as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setRegisterDatetime_LessEqual(java.time.LocalDateTime registerDatetime) {
        regRegisterDatetime(CK_LE, registerDatetime);
    }

    /**
     * FromTo with various options. (versatile) {(default) fromDatetime &lt;= column &lt;= toDatetime} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * REGISTER_DATETIME: {NotNull, DATETIME(19)}
     * <pre>e.g. setRegisterDatetime_FromTo(fromDate, toDate, op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">compareAsDate()</span>);</pre>
     * @param fromDatetime The from-datetime(yyyy/MM/dd HH:mm:ss.SSS) of registerDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param toDatetime The to-datetime(yyyy/MM/dd HH:mm:ss.SSS) of registerDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param opLambda The callback for option of from-to. (NotNull)
     */
    public void setRegisterDatetime_FromTo(java.time.LocalDateTime fromDatetime, java.time.LocalDateTime toDatetime, ConditionOptionCall<FromToOption> opLambda) {
        setRegisterDatetime_FromTo(fromDatetime, toDatetime, xcFTOP(opLambda));
    }

    /**
     * FromTo with various options. (versatile) {(default) fromDatetime &lt;= column &lt;= toDatetime} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * REGISTER_DATETIME: {NotNull, DATETIME(19)}
     * <pre>e.g. setRegisterDatetime_FromTo(fromDate, toDate, new <span style="color: #CC4747">FromToOption</span>().compareAsDate());</pre>
     * @param fromDatetime The from-datetime(yyyy/MM/dd HH:mm:ss.SSS) of registerDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param toDatetime The to-datetime(yyyy/MM/dd HH:mm:ss.SSS) of registerDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param fromToOption The option of from-to. (NotNull)
     */
    protected void setRegisterDatetime_FromTo(java.time.LocalDateTime fromDatetime, java.time.LocalDateTime toDatetime, FromToOption fromToOption) {
        String nm = "REGISTER_DATETIME"; FromToOption op = fromToOption;
        regFTQ(xfFTHD(fromDatetime, nm, op), xfFTHD(toDatetime, nm, op), xgetCValueRegisterDatetime(), nm, op);
    }

    protected void regRegisterDatetime(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueRegisterDatetime(), "REGISTER_DATETIME"); }
    protected abstract ConditionValue xgetCValueRegisterDatetime();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * REGISTER_TRACE: {NotNull, VARCHAR(64)}
     * @param registerTrace The value of registerTrace as equal. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setRegisterTrace_Equal(String registerTrace) {
        doSetRegisterTrace_Equal(fRES(registerTrace));
    }

    protected void doSetRegisterTrace_Equal(String registerTrace) {
        regRegisterTrace(CK_EQ, registerTrace);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * REGISTER_TRACE: {NotNull, VARCHAR(64)}
     * @param registerTrace The value of registerTrace as notEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setRegisterTrace_NotEqual(String registerTrace) {
        doSetRegisterTrace_NotEqual(fRES(registerTrace));
    }

    protected void doSetRegisterTrace_NotEqual(String registerTrace) {
        regRegisterTrace(CK_NES, registerTrace);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * REGISTER_TRACE: {NotNull, VARCHAR(64)}
     * @param registerTrace The value of registerTrace as greaterThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setRegisterTrace_GreaterThan(String registerTrace) {
        regRegisterTrace(CK_GT, fRES(registerTrace));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * REGISTER_TRACE: {NotNull, VARCHAR(64)}
     * @param registerTrace The value of registerTrace as lessThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setRegisterTrace_LessThan(String registerTrace) {
        regRegisterTrace(CK_LT, fRES(registerTrace));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * REGISTER_TRACE: {NotNull, VARCHAR(64)}
     * @param registerTrace The value of registerTrace as greaterEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setRegisterTrace_GreaterEqual(String registerTrace) {
        regRegisterTrace(CK_GE, fRES(registerTrace));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * REGISTER_TRACE: {NotNull, VARCHAR(64)}
     * @param registerTrace The value of registerTrace as lessEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setRegisterTrace_LessEqual(String registerTrace) {
        regRegisterTrace(CK_LE, fRES(registerTrace));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * REGISTER_TRACE: {NotNull, VARCHAR(64)}
     * @param registerTraceList The collection of registerTrace as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setRegisterTrace_InScope(Collection<String> registerTraceList) {
        doSetRegisterTrace_InScope(registerTraceList);
    }

    protected void doSetRegisterTrace_InScope(Collection<String> registerTraceList) {
        regINS(CK_INS, cTL(registerTraceList), xgetCValueRegisterTrace(), "REGISTER_TRACE");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * REGISTER_TRACE: {NotNull, VARCHAR(64)}
     * @param registerTraceList The collection of registerTrace as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setRegisterTrace_NotInScope(Collection<String> registerTraceList) {
        doSetRegisterTrace_NotInScope(registerTraceList);
    }

    protected void doSetRegisterTrace_NotInScope(Collection<String> registerTraceList) {
        regINS(CK_NINS, cTL(registerTraceList), xgetCValueRegisterTrace(), "REGISTER_TRACE");
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * REGISTER_TRACE: {NotNull, VARCHAR(64)} <br>
     * <pre>e.g. setRegisterTrace_LikeSearch("xxx", op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">likeContain()</span>);</pre>
     * @param registerTrace The value of registerTrace as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setRegisterTrace_LikeSearch(String registerTrace, ConditionOptionCall<LikeSearchOption> opLambda) {
        setRegisterTrace_LikeSearch(registerTrace, xcLSOP(opLambda));
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * REGISTER_TRACE: {NotNull, VARCHAR(64)} <br>
     * <pre>e.g. setRegisterTrace_LikeSearch("xxx", new <span style="color: #CC4747">LikeSearchOption</span>().likeContain());</pre>
     * @param registerTrace The value of registerTrace as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    protected void setRegisterTrace_LikeSearch(String registerTrace, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(registerTrace), xgetCValueRegisterTrace(), "REGISTER_TRACE", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * REGISTER_TRACE: {NotNull, VARCHAR(64)}
     * @param registerTrace The value of registerTrace as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setRegisterTrace_NotLikeSearch(String registerTrace, ConditionOptionCall<LikeSearchOption> opLambda) {
        setRegisterTrace_NotLikeSearch(registerTrace, xcLSOP(opLambda));
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * REGISTER_TRACE: {NotNull, VARCHAR(64)}
     * @param registerTrace The value of registerTrace as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    protected void setRegisterTrace_NotLikeSearch(String registerTrace, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(registerTrace), xgetCValueRegisterTrace(), "REGISTER_TRACE", likeSearchOption);
    }

    protected void regRegisterTrace(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueRegisterTrace(), "REGISTER_TRACE"); }
    protected abstract ConditionValue xgetCValueRegisterTrace();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * UPDATE_DATETIME: {NotNull, DATETIME(19)}
     * @param updateDatetime The value of updateDatetime as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setUpdateDatetime_Equal(java.time.LocalDateTime updateDatetime) {
        regUpdateDatetime(CK_EQ,  updateDatetime);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * UPDATE_DATETIME: {NotNull, DATETIME(19)}
     * @param updateDatetime The value of updateDatetime as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setUpdateDatetime_GreaterThan(java.time.LocalDateTime updateDatetime) {
        regUpdateDatetime(CK_GT,  updateDatetime);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * UPDATE_DATETIME: {NotNull, DATETIME(19)}
     * @param updateDatetime The value of updateDatetime as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setUpdateDatetime_LessThan(java.time.LocalDateTime updateDatetime) {
        regUpdateDatetime(CK_LT,  updateDatetime);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * UPDATE_DATETIME: {NotNull, DATETIME(19)}
     * @param updateDatetime The value of updateDatetime as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setUpdateDatetime_GreaterEqual(java.time.LocalDateTime updateDatetime) {
        regUpdateDatetime(CK_GE,  updateDatetime);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * UPDATE_DATETIME: {NotNull, DATETIME(19)}
     * @param updateDatetime The value of updateDatetime as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setUpdateDatetime_LessEqual(java.time.LocalDateTime updateDatetime) {
        regUpdateDatetime(CK_LE, updateDatetime);
    }

    /**
     * FromTo with various options. (versatile) {(default) fromDatetime &lt;= column &lt;= toDatetime} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * UPDATE_DATETIME: {NotNull, DATETIME(19)}
     * <pre>e.g. setUpdateDatetime_FromTo(fromDate, toDate, op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">compareAsDate()</span>);</pre>
     * @param fromDatetime The from-datetime(yyyy/MM/dd HH:mm:ss.SSS) of updateDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param toDatetime The to-datetime(yyyy/MM/dd HH:mm:ss.SSS) of updateDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param opLambda The callback for option of from-to. (NotNull)
     */
    public void setUpdateDatetime_FromTo(java.time.LocalDateTime fromDatetime, java.time.LocalDateTime toDatetime, ConditionOptionCall<FromToOption> opLambda) {
        setUpdateDatetime_FromTo(fromDatetime, toDatetime, xcFTOP(opLambda));
    }

    /**
     * FromTo with various options. (versatile) {(default) fromDatetime &lt;= column &lt;= toDatetime} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * UPDATE_DATETIME: {NotNull, DATETIME(19)}
     * <pre>e.g. setUpdateDatetime_FromTo(fromDate, toDate, new <span style="color: #CC4747">FromToOption</span>().compareAsDate());</pre>
     * @param fromDatetime The from-datetime(yyyy/MM/dd HH:mm:ss.SSS) of updateDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param toDatetime The to-datetime(yyyy/MM/dd HH:mm:ss.SSS) of updateDatetime. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param fromToOption The option of from-to. (NotNull)
     */
    protected void setUpdateDatetime_FromTo(java.time.LocalDateTime fromDatetime, java.time.LocalDateTime toDatetime, FromToOption fromToOption) {
        String nm = "UPDATE_DATETIME"; FromToOption op = fromToOption;
        regFTQ(xfFTHD(fromDatetime, nm, op), xfFTHD(toDatetime, nm, op), xgetCValueUpdateDatetime(), nm, op);
    }

    protected void regUpdateDatetime(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueUpdateDatetime(), "UPDATE_DATETIME"); }
    protected abstract ConditionValue xgetCValueUpdateDatetime();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * UPDATE_TRACE: {NotNull, VARCHAR(64)}
     * @param updateTrace The value of updateTrace as equal. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setUpdateTrace_Equal(String updateTrace) {
        doSetUpdateTrace_Equal(fRES(updateTrace));
    }

    protected void doSetUpdateTrace_Equal(String updateTrace) {
        regUpdateTrace(CK_EQ, updateTrace);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * UPDATE_TRACE: {NotNull, VARCHAR(64)}
     * @param updateTrace The value of updateTrace as notEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setUpdateTrace_NotEqual(String updateTrace) {
        doSetUpdateTrace_NotEqual(fRES(updateTrace));
    }

    protected void doSetUpdateTrace_NotEqual(String updateTrace) {
        regUpdateTrace(CK_NES, updateTrace);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * UPDATE_TRACE: {NotNull, VARCHAR(64)}
     * @param updateTrace The value of updateTrace as greaterThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setUpdateTrace_GreaterThan(String updateTrace) {
        regUpdateTrace(CK_GT, fRES(updateTrace));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * UPDATE_TRACE: {NotNull, VARCHAR(64)}
     * @param updateTrace The value of updateTrace as lessThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setUpdateTrace_LessThan(String updateTrace) {
        regUpdateTrace(CK_LT, fRES(updateTrace));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * UPDATE_TRACE: {NotNull, VARCHAR(64)}
     * @param updateTrace The value of updateTrace as greaterEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setUpdateTrace_GreaterEqual(String updateTrace) {
        regUpdateTrace(CK_GE, fRES(updateTrace));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * UPDATE_TRACE: {NotNull, VARCHAR(64)}
     * @param updateTrace The value of updateTrace as lessEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setUpdateTrace_LessEqual(String updateTrace) {
        regUpdateTrace(CK_LE, fRES(updateTrace));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * UPDATE_TRACE: {NotNull, VARCHAR(64)}
     * @param updateTraceList The collection of updateTrace as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setUpdateTrace_InScope(Collection<String> updateTraceList) {
        doSetUpdateTrace_InScope(updateTraceList);
    }

    protected void doSetUpdateTrace_InScope(Collection<String> updateTraceList) {
        regINS(CK_INS, cTL(updateTraceList), xgetCValueUpdateTrace(), "UPDATE_TRACE");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * UPDATE_TRACE: {NotNull, VARCHAR(64)}
     * @param updateTraceList The collection of updateTrace as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setUpdateTrace_NotInScope(Collection<String> updateTraceList) {
        doSetUpdateTrace_NotInScope(updateTraceList);
    }

    protected void doSetUpdateTrace_NotInScope(Collection<String> updateTraceList) {
        regINS(CK_NINS, cTL(updateTraceList), xgetCValueUpdateTrace(), "UPDATE_TRACE");
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * UPDATE_TRACE: {NotNull, VARCHAR(64)} <br>
     * <pre>e.g. setUpdateTrace_LikeSearch("xxx", op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">likeContain()</span>);</pre>
     * @param updateTrace The value of updateTrace as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setUpdateTrace_LikeSearch(String updateTrace, ConditionOptionCall<LikeSearchOption> opLambda) {
        setUpdateTrace_LikeSearch(updateTrace, xcLSOP(opLambda));
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * UPDATE_TRACE: {NotNull, VARCHAR(64)} <br>
     * <pre>e.g. setUpdateTrace_LikeSearch("xxx", new <span style="color: #CC4747">LikeSearchOption</span>().likeContain());</pre>
     * @param updateTrace The value of updateTrace as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    protected void setUpdateTrace_LikeSearch(String updateTrace, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(updateTrace), xgetCValueUpdateTrace(), "UPDATE_TRACE", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * UPDATE_TRACE: {NotNull, VARCHAR(64)}
     * @param updateTrace The value of updateTrace as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setUpdateTrace_NotLikeSearch(String updateTrace, ConditionOptionCall<LikeSearchOption> opLambda) {
        setUpdateTrace_NotLikeSearch(updateTrace, xcLSOP(opLambda));
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * UPDATE_TRACE: {NotNull, VARCHAR(64)}
     * @param updateTrace The value of updateTrace as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    protected void setUpdateTrace_NotLikeSearch(String updateTrace, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(updateTrace), xgetCValueUpdateTrace(), "UPDATE_TRACE", likeSearchOption);
    }

    protected void regUpdateTrace(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueUpdateTrace(), "UPDATE_TRACE"); }
    protected abstract ConditionValue xgetCValueUpdateTrace();

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
    public HpSLCFunction<VillageSettingsCB> scalar_Equal() {
        return xcreateSLCFunction(CK_EQ, VillageSettingsCB.class);
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
    public HpSLCFunction<VillageSettingsCB> scalar_NotEqual() {
        return xcreateSLCFunction(CK_NES, VillageSettingsCB.class);
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
    public HpSLCFunction<VillageSettingsCB> scalar_GreaterThan() {
        return xcreateSLCFunction(CK_GT, VillageSettingsCB.class);
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
    public HpSLCFunction<VillageSettingsCB> scalar_LessThan() {
        return xcreateSLCFunction(CK_LT, VillageSettingsCB.class);
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
    public HpSLCFunction<VillageSettingsCB> scalar_GreaterEqual() {
        return xcreateSLCFunction(CK_GE, VillageSettingsCB.class);
    }

    /**
     * Prepare ScalarCondition as lessEqual. <br>
     * {where FOO &lt;= (select max(BAR) from ...)}
     * <pre>
     * cb.query().<span style="color: #CC4747">scalar_LessEqual()</span>.max(new SubQuery&lt;VillageSettingsCB&gt;() {
     *     public void query(VillageSettingsCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<VillageSettingsCB> scalar_LessEqual() {
        return xcreateSLCFunction(CK_LE, VillageSettingsCB.class);
    }

    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xscalarCondition(String fn, SubQuery<CB> sq, String rd, HpSLCCustomized<CB> cs, ScalarConditionOption op) {
        assertObjectNotNull("subQuery", sq);
        VillageSettingsCB cb = xcreateScalarConditionCB(); sq.query((CB)cb);
        String pp = keepScalarCondition(cb.query()); // for saving query-value
        cs.setPartitionByCBean((CB)xcreateScalarConditionPartitionByCB()); // for using partition-by
        registerScalarCondition(fn, cb.query(), pp, rd, cs, op);
    }
    public abstract String keepScalarCondition(VillageSettingsCQ sq);

    protected VillageSettingsCB xcreateScalarConditionCB() {
        VillageSettingsCB cb = newMyCB(); cb.xsetupForScalarCondition(this); return cb;
    }

    protected VillageSettingsCB xcreateScalarConditionPartitionByCB() {
        VillageSettingsCB cb = newMyCB(); cb.xsetupForScalarConditionPartitionBy(this); return cb;
    }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public void xsmyselfDerive(String fn, SubQuery<VillageSettingsCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        VillageSettingsCB cb = new VillageSettingsCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String pp = keepSpecifyMyselfDerived(cb.query()); String pk = "VILLAGE_ID";
        registerSpecifyMyselfDerived(fn, cb.query(), pk, pk, pp, "myselfDerived", al, op);
    }
    public abstract String keepSpecifyMyselfDerived(VillageSettingsCQ sq);

    /**
     * Prepare for (Query)MyselfDerived (correlated sub-query).
     * @return The object to set up a function for myself table. (NotNull)
     */
    public HpQDRFunction<VillageSettingsCB> myselfDerived() {
        return xcreateQDRFunctionMyselfDerived(VillageSettingsCB.class);
    }
    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xqderiveMyselfDerived(String fn, SubQuery<CB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        VillageSettingsCB cb = new VillageSettingsCB(); cb.xsetupForDerivedReferrer(this); sq.query((CB)cb);
        String pk = "VILLAGE_ID";
        String sqpp = keepQueryMyselfDerived(cb.query()); // for saving query-value.
        String prpp = keepQueryMyselfDerivedParameter(vl);
        registerQueryMyselfDerived(fn, cb.query(), pk, pk, sqpp, "myselfDerived", rd, vl, prpp, op);
    }
    public abstract String keepQueryMyselfDerived(VillageSettingsCQ sq);
    public abstract String keepQueryMyselfDerivedParameter(Object vl);

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    /**
     * Prepare for MyselfExists (correlated sub-query).
     * @param subCBLambda The implementation of sub-query. (NotNull)
     */
    public void myselfExists(SubQuery<VillageSettingsCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        VillageSettingsCB cb = new VillageSettingsCB(); cb.xsetupForMyselfExists(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepMyselfExists(cb.query());
        registerMyselfExists(cb.query(), pp);
    }
    public abstract String keepMyselfExists(VillageSettingsCQ sq);

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
     *     <span style="color: #553000">op</span>.<span style="color: #CC4747">when_GreaterEqual</span>(priorityDate); <span style="color: #3F7E5E">// e.g. 2000/01/01</span>
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
    protected VillageSettingsCB newMyCB() {
        return new VillageSettingsCB();
    }
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xabUDT() { return Date.class.getName(); }
    protected String xabCQ() { return VillageSettingsCQ.class.getName(); }
    protected String xabLSO() { return LikeSearchOption.class.getName(); }
    protected String xabSLCS() { return HpSLCSetupper.class.getName(); }
    protected String xabSCP() { return SubQuery.class.getName(); }
}
