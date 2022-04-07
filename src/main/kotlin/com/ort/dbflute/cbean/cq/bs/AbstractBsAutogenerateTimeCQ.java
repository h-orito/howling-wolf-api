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
 * The abstract condition-query of autogenerate_time.
 * @author DBFlute(AutoGenerator)
 */
public abstract class AbstractBsAutogenerateTimeCQ extends AbstractConditionQuery {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public AbstractBsAutogenerateTimeCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
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
        return "autogenerate_time";
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_ID_MOD: {PK, NotNull, INT(10)}
     * @param villageIdMod The value of villageIdMod as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setVillageIdMod_Equal(Integer villageIdMod) {
        doSetVillageIdMod_Equal(villageIdMod);
    }

    protected void doSetVillageIdMod_Equal(Integer villageIdMod) {
        regVillageIdMod(CK_EQ, villageIdMod);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_ID_MOD: {PK, NotNull, INT(10)}
     * @param villageIdMod The value of villageIdMod as notEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setVillageIdMod_NotEqual(Integer villageIdMod) {
        doSetVillageIdMod_NotEqual(villageIdMod);
    }

    protected void doSetVillageIdMod_NotEqual(Integer villageIdMod) {
        regVillageIdMod(CK_NES, villageIdMod);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_ID_MOD: {PK, NotNull, INT(10)}
     * @param villageIdMod The value of villageIdMod as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setVillageIdMod_GreaterThan(Integer villageIdMod) {
        regVillageIdMod(CK_GT, villageIdMod);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_ID_MOD: {PK, NotNull, INT(10)}
     * @param villageIdMod The value of villageIdMod as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setVillageIdMod_LessThan(Integer villageIdMod) {
        regVillageIdMod(CK_LT, villageIdMod);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_ID_MOD: {PK, NotNull, INT(10)}
     * @param villageIdMod The value of villageIdMod as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setVillageIdMod_GreaterEqual(Integer villageIdMod) {
        regVillageIdMod(CK_GE, villageIdMod);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_ID_MOD: {PK, NotNull, INT(10)}
     * @param villageIdMod The value of villageIdMod as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setVillageIdMod_LessEqual(Integer villageIdMod) {
        regVillageIdMod(CK_LE, villageIdMod);
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_ID_MOD: {PK, NotNull, INT(10)}
     * @param minNumber The min number of villageIdMod. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of villageIdMod. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param opLambda The callback for option of range-of. (NotNull)
     */
    public void setVillageIdMod_RangeOf(Integer minNumber, Integer maxNumber, ConditionOptionCall<RangeOfOption> opLambda) {
        setVillageIdMod_RangeOf(minNumber, maxNumber, xcROOP(opLambda));
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_ID_MOD: {PK, NotNull, INT(10)}
     * @param minNumber The min number of villageIdMod. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of villageIdMod. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    protected void setVillageIdMod_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, xgetCValueVillageIdMod(), "VILLAGE_ID_MOD", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * VILLAGE_ID_MOD: {PK, NotNull, INT(10)}
     * @param villageIdModList The collection of villageIdMod as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setVillageIdMod_InScope(Collection<Integer> villageIdModList) {
        doSetVillageIdMod_InScope(villageIdModList);
    }

    protected void doSetVillageIdMod_InScope(Collection<Integer> villageIdModList) {
        regINS(CK_INS, cTL(villageIdModList), xgetCValueVillageIdMod(), "VILLAGE_ID_MOD");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * VILLAGE_ID_MOD: {PK, NotNull, INT(10)}
     * @param villageIdModList The collection of villageIdMod as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setVillageIdMod_NotInScope(Collection<Integer> villageIdModList) {
        doSetVillageIdMod_NotInScope(villageIdModList);
    }

    protected void doSetVillageIdMod_NotInScope(Collection<Integer> villageIdModList) {
        regINS(CK_NINS, cTL(villageIdModList), xgetCValueVillageIdMod(), "VILLAGE_ID_MOD");
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * VILLAGE_ID_MOD: {PK, NotNull, INT(10)}
     */
    public void setVillageIdMod_IsNull() { regVillageIdMod(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * VILLAGE_ID_MOD: {PK, NotNull, INT(10)}
     */
    public void setVillageIdMod_IsNotNull() { regVillageIdMod(CK_ISNN, DOBJ); }

    protected void regVillageIdMod(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueVillageIdMod(), "VILLAGE_ID_MOD"); }
    protected abstract ConditionValue xgetCValueVillageIdMod();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * START_TIME: {NotNull, CHAR(4)}
     * @param startTime The value of startTime as equal. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setStartTime_Equal(String startTime) {
        doSetStartTime_Equal(fRES(startTime));
    }

    protected void doSetStartTime_Equal(String startTime) {
        regStartTime(CK_EQ, startTime);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * START_TIME: {NotNull, CHAR(4)}
     * @param startTime The value of startTime as notEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setStartTime_NotEqual(String startTime) {
        doSetStartTime_NotEqual(fRES(startTime));
    }

    protected void doSetStartTime_NotEqual(String startTime) {
        regStartTime(CK_NES, startTime);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * START_TIME: {NotNull, CHAR(4)}
     * @param startTime The value of startTime as greaterThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setStartTime_GreaterThan(String startTime) {
        regStartTime(CK_GT, fRES(startTime));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * START_TIME: {NotNull, CHAR(4)}
     * @param startTime The value of startTime as lessThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setStartTime_LessThan(String startTime) {
        regStartTime(CK_LT, fRES(startTime));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * START_TIME: {NotNull, CHAR(4)}
     * @param startTime The value of startTime as greaterEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setStartTime_GreaterEqual(String startTime) {
        regStartTime(CK_GE, fRES(startTime));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * START_TIME: {NotNull, CHAR(4)}
     * @param startTime The value of startTime as lessEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setStartTime_LessEqual(String startTime) {
        regStartTime(CK_LE, fRES(startTime));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * START_TIME: {NotNull, CHAR(4)}
     * @param startTimeList The collection of startTime as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setStartTime_InScope(Collection<String> startTimeList) {
        doSetStartTime_InScope(startTimeList);
    }

    protected void doSetStartTime_InScope(Collection<String> startTimeList) {
        regINS(CK_INS, cTL(startTimeList), xgetCValueStartTime(), "START_TIME");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * START_TIME: {NotNull, CHAR(4)}
     * @param startTimeList The collection of startTime as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setStartTime_NotInScope(Collection<String> startTimeList) {
        doSetStartTime_NotInScope(startTimeList);
    }

    protected void doSetStartTime_NotInScope(Collection<String> startTimeList) {
        regINS(CK_NINS, cTL(startTimeList), xgetCValueStartTime(), "START_TIME");
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * START_TIME: {NotNull, CHAR(4)} <br>
     * <pre>e.g. setStartTime_LikeSearch("xxx", op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">likeContain()</span>);</pre>
     * @param startTime The value of startTime as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setStartTime_LikeSearch(String startTime, ConditionOptionCall<LikeSearchOption> opLambda) {
        setStartTime_LikeSearch(startTime, xcLSOP(opLambda));
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * START_TIME: {NotNull, CHAR(4)} <br>
     * <pre>e.g. setStartTime_LikeSearch("xxx", new <span style="color: #CC4747">LikeSearchOption</span>().likeContain());</pre>
     * @param startTime The value of startTime as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    protected void setStartTime_LikeSearch(String startTime, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(startTime), xgetCValueStartTime(), "START_TIME", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * START_TIME: {NotNull, CHAR(4)}
     * @param startTime The value of startTime as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setStartTime_NotLikeSearch(String startTime, ConditionOptionCall<LikeSearchOption> opLambda) {
        setStartTime_NotLikeSearch(startTime, xcLSOP(opLambda));
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * START_TIME: {NotNull, CHAR(4)}
     * @param startTime The value of startTime as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    protected void setStartTime_NotLikeSearch(String startTime, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(startTime), xgetCValueStartTime(), "START_TIME", likeSearchOption);
    }

    protected void regStartTime(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueStartTime(), "START_TIME"); }
    protected abstract ConditionValue xgetCValueStartTime();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * SILENT_HOURS: {NotNull, INT UNSIGNED(10)}
     * @param silentHours The value of silentHours as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setSilentHours_Equal(Integer silentHours) {
        doSetSilentHours_Equal(silentHours);
    }

    protected void doSetSilentHours_Equal(Integer silentHours) {
        regSilentHours(CK_EQ, silentHours);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * SILENT_HOURS: {NotNull, INT UNSIGNED(10)}
     * @param silentHours The value of silentHours as notEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setSilentHours_NotEqual(Integer silentHours) {
        doSetSilentHours_NotEqual(silentHours);
    }

    protected void doSetSilentHours_NotEqual(Integer silentHours) {
        regSilentHours(CK_NES, silentHours);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * SILENT_HOURS: {NotNull, INT UNSIGNED(10)}
     * @param silentHours The value of silentHours as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setSilentHours_GreaterThan(Integer silentHours) {
        regSilentHours(CK_GT, silentHours);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * SILENT_HOURS: {NotNull, INT UNSIGNED(10)}
     * @param silentHours The value of silentHours as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setSilentHours_LessThan(Integer silentHours) {
        regSilentHours(CK_LT, silentHours);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * SILENT_HOURS: {NotNull, INT UNSIGNED(10)}
     * @param silentHours The value of silentHours as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setSilentHours_GreaterEqual(Integer silentHours) {
        regSilentHours(CK_GE, silentHours);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * SILENT_HOURS: {NotNull, INT UNSIGNED(10)}
     * @param silentHours The value of silentHours as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setSilentHours_LessEqual(Integer silentHours) {
        regSilentHours(CK_LE, silentHours);
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * SILENT_HOURS: {NotNull, INT UNSIGNED(10)}
     * @param minNumber The min number of silentHours. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of silentHours. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param opLambda The callback for option of range-of. (NotNull)
     */
    public void setSilentHours_RangeOf(Integer minNumber, Integer maxNumber, ConditionOptionCall<RangeOfOption> opLambda) {
        setSilentHours_RangeOf(minNumber, maxNumber, xcROOP(opLambda));
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * SILENT_HOURS: {NotNull, INT UNSIGNED(10)}
     * @param minNumber The min number of silentHours. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of silentHours. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    protected void setSilentHours_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, xgetCValueSilentHours(), "SILENT_HOURS", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * SILENT_HOURS: {NotNull, INT UNSIGNED(10)}
     * @param silentHoursList The collection of silentHours as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setSilentHours_InScope(Collection<Integer> silentHoursList) {
        doSetSilentHours_InScope(silentHoursList);
    }

    protected void doSetSilentHours_InScope(Collection<Integer> silentHoursList) {
        regINS(CK_INS, cTL(silentHoursList), xgetCValueSilentHours(), "SILENT_HOURS");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * SILENT_HOURS: {NotNull, INT UNSIGNED(10)}
     * @param silentHoursList The collection of silentHours as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setSilentHours_NotInScope(Collection<Integer> silentHoursList) {
        doSetSilentHours_NotInScope(silentHoursList);
    }

    protected void doSetSilentHours_NotInScope(Collection<Integer> silentHoursList) {
        regINS(CK_NINS, cTL(silentHoursList), xgetCValueSilentHours(), "SILENT_HOURS");
    }

    protected void regSilentHours(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueSilentHours(), "SILENT_HOURS"); }
    protected abstract ConditionValue xgetCValueSilentHours();

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
    public HpSLCFunction<AutogenerateTimeCB> scalar_Equal() {
        return xcreateSLCFunction(CK_EQ, AutogenerateTimeCB.class);
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
    public HpSLCFunction<AutogenerateTimeCB> scalar_NotEqual() {
        return xcreateSLCFunction(CK_NES, AutogenerateTimeCB.class);
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
    public HpSLCFunction<AutogenerateTimeCB> scalar_GreaterThan() {
        return xcreateSLCFunction(CK_GT, AutogenerateTimeCB.class);
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
    public HpSLCFunction<AutogenerateTimeCB> scalar_LessThan() {
        return xcreateSLCFunction(CK_LT, AutogenerateTimeCB.class);
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
    public HpSLCFunction<AutogenerateTimeCB> scalar_GreaterEqual() {
        return xcreateSLCFunction(CK_GE, AutogenerateTimeCB.class);
    }

    /**
     * Prepare ScalarCondition as lessEqual. <br>
     * {where FOO &lt;= (select max(BAR) from ...)}
     * <pre>
     * cb.query().<span style="color: #CC4747">scalar_LessEqual()</span>.max(new SubQuery&lt;AutogenerateTimeCB&gt;() {
     *     public void query(AutogenerateTimeCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<AutogenerateTimeCB> scalar_LessEqual() {
        return xcreateSLCFunction(CK_LE, AutogenerateTimeCB.class);
    }

    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xscalarCondition(String fn, SubQuery<CB> sq, String rd, HpSLCCustomized<CB> cs, ScalarConditionOption op) {
        assertObjectNotNull("subQuery", sq);
        AutogenerateTimeCB cb = xcreateScalarConditionCB(); sq.query((CB)cb);
        String pp = keepScalarCondition(cb.query()); // for saving query-value
        cs.setPartitionByCBean((CB)xcreateScalarConditionPartitionByCB()); // for using partition-by
        registerScalarCondition(fn, cb.query(), pp, rd, cs, op);
    }
    public abstract String keepScalarCondition(AutogenerateTimeCQ sq);

    protected AutogenerateTimeCB xcreateScalarConditionCB() {
        AutogenerateTimeCB cb = newMyCB(); cb.xsetupForScalarCondition(this); return cb;
    }

    protected AutogenerateTimeCB xcreateScalarConditionPartitionByCB() {
        AutogenerateTimeCB cb = newMyCB(); cb.xsetupForScalarConditionPartitionBy(this); return cb;
    }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public void xsmyselfDerive(String fn, SubQuery<AutogenerateTimeCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        AutogenerateTimeCB cb = new AutogenerateTimeCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String pp = keepSpecifyMyselfDerived(cb.query()); String pk = "VILLAGE_ID_MOD";
        registerSpecifyMyselfDerived(fn, cb.query(), pk, pk, pp, "myselfDerived", al, op);
    }
    public abstract String keepSpecifyMyselfDerived(AutogenerateTimeCQ sq);

    /**
     * Prepare for (Query)MyselfDerived (correlated sub-query).
     * @return The object to set up a function for myself table. (NotNull)
     */
    public HpQDRFunction<AutogenerateTimeCB> myselfDerived() {
        return xcreateQDRFunctionMyselfDerived(AutogenerateTimeCB.class);
    }
    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xqderiveMyselfDerived(String fn, SubQuery<CB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        AutogenerateTimeCB cb = new AutogenerateTimeCB(); cb.xsetupForDerivedReferrer(this); sq.query((CB)cb);
        String pk = "VILLAGE_ID_MOD";
        String sqpp = keepQueryMyselfDerived(cb.query()); // for saving query-value.
        String prpp = keepQueryMyselfDerivedParameter(vl);
        registerQueryMyselfDerived(fn, cb.query(), pk, pk, sqpp, "myselfDerived", rd, vl, prpp, op);
    }
    public abstract String keepQueryMyselfDerived(AutogenerateTimeCQ sq);
    public abstract String keepQueryMyselfDerivedParameter(Object vl);

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    /**
     * Prepare for MyselfExists (correlated sub-query).
     * @param subCBLambda The implementation of sub-query. (NotNull)
     */
    public void myselfExists(SubQuery<AutogenerateTimeCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        AutogenerateTimeCB cb = new AutogenerateTimeCB(); cb.xsetupForMyselfExists(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepMyselfExists(cb.query());
        registerMyselfExists(cb.query(), pp);
    }
    public abstract String keepMyselfExists(AutogenerateTimeCQ sq);

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
    protected AutogenerateTimeCB newMyCB() {
        return new AutogenerateTimeCB();
    }
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xabUDT() { return Date.class.getName(); }
    protected String xabCQ() { return AutogenerateTimeCQ.class.getName(); }
    protected String xabLSO() { return LikeSearchOption.class.getName(); }
    protected String xabSLCS() { return HpSLCSetupper.class.getName(); }
    protected String xabSCP() { return SubQuery.class.getName(); }
}
