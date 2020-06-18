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
 * The abstract condition-query of VILLAGE_SETTING.
 * @author DBFlute(AutoGenerator)
 */
public abstract class AbstractBsVillageSettingCQ extends AbstractConditionQuery {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public AbstractBsVillageSettingCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
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
        return "VILLAGE_SETTING";
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_ID: {PK, NotNull, INT UNSIGNED(10), FK to VILLAGE}
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
     * VILLAGE_ID: {PK, NotNull, INT UNSIGNED(10), FK to VILLAGE}
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
     * VILLAGE_ID: {PK, NotNull, INT UNSIGNED(10), FK to VILLAGE}
     * @param villageId The value of villageId as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setVillageId_GreaterThan(Integer villageId) {
        regVillageId(CK_GT, villageId);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_ID: {PK, NotNull, INT UNSIGNED(10), FK to VILLAGE}
     * @param villageId The value of villageId as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setVillageId_LessThan(Integer villageId) {
        regVillageId(CK_LT, villageId);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_ID: {PK, NotNull, INT UNSIGNED(10), FK to VILLAGE}
     * @param villageId The value of villageId as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setVillageId_GreaterEqual(Integer villageId) {
        regVillageId(CK_GE, villageId);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_ID: {PK, NotNull, INT UNSIGNED(10), FK to VILLAGE}
     * @param villageId The value of villageId as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setVillageId_LessEqual(Integer villageId) {
        regVillageId(CK_LE, villageId);
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_ID: {PK, NotNull, INT UNSIGNED(10), FK to VILLAGE}
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
     * VILLAGE_ID: {PK, NotNull, INT UNSIGNED(10), FK to VILLAGE}
     * @param minNumber The min number of villageId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of villageId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    protected void setVillageId_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, xgetCValueVillageId(), "VILLAGE_ID", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * VILLAGE_ID: {PK, NotNull, INT UNSIGNED(10), FK to VILLAGE}
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
     * VILLAGE_ID: {PK, NotNull, INT UNSIGNED(10), FK to VILLAGE}
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
     * VILLAGE_ID: {PK, NotNull, INT UNSIGNED(10), FK to VILLAGE}
     */
    public void setVillageId_IsNull() { regVillageId(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * VILLAGE_ID: {PK, NotNull, INT UNSIGNED(10), FK to VILLAGE}
     */
    public void setVillageId_IsNotNull() { regVillageId(CK_ISNN, DOBJ); }

    protected void regVillageId(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueVillageId(), "VILLAGE_ID"); }
    protected abstract ConditionValue xgetCValueVillageId();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_SETTING_ITEM_CODE: {PK, IX, NotNull, VARCHAR(100), FK to VILLAGE_SETTING_ITEM, classification=VillageSettingItem}
     * @param villageSettingItemCode The value of villageSettingItemCode as equal. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setVillageSettingItemCode_Equal(String villageSettingItemCode) {
        doSetVillageSettingItemCode_Equal(fRES(villageSettingItemCode));
    }

    /**
     * Equal(=). As VillageSettingItem. And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_SETTING_ITEM_CODE: {PK, IX, NotNull, VARCHAR(100), FK to VILLAGE_SETTING_ITEM, classification=VillageSettingItem} <br>
     * 村設定項目
     * @param cdef The instance of classification definition (as ENUM type). (basically NotNull: error as default, or no condition as option)
     */
    public void setVillageSettingItemCode_Equal_AsVillageSettingItem(CDef.VillageSettingItem cdef) {
        doSetVillageSettingItemCode_Equal(cdef != null ? cdef.code() : null);
    }

    /**
     * Equal(=). As キャラクターグループid (character_group_id). And OnlyOnceRegistered. <br>
     * キャラクターグループID
     */
    public void setVillageSettingItemCode_Equal_キャラクターグループid() {
        setVillageSettingItemCode_Equal_AsVillageSettingItem(CDef.VillageSettingItem.キャラクターグループid);
    }

    /**
     * Equal(=). As 更新間隔秒 (day_change_interval_seconds). And OnlyOnceRegistered. <br>
     * 更新間隔秒
     */
    public void setVillageSettingItemCode_Equal_更新間隔秒() {
        setVillageSettingItemCode_Equal_AsVillageSettingItem(CDef.VillageSettingItem.更新間隔秒);
    }

    /**
     * Equal(=). As ダミーキャラid (dummy_chara_id). And OnlyOnceRegistered. <br>
     * ダミーキャラID
     */
    public void setVillageSettingItemCode_Equal_ダミーキャラid() {
        setVillageSettingItemCode_Equal_AsVillageSettingItem(CDef.VillageSettingItem.ダミーキャラid);
    }

    /**
     * Equal(=). As 自動生成村か (is_auto_generated). And OnlyOnceRegistered. <br>
     * 自動生成村か
     */
    public void setVillageSettingItemCode_Equal_自動生成村か() {
        setVillageSettingItemCode_Equal_AsVillageSettingItem(CDef.VillageSettingItem.自動生成村か);
    }

    /**
     * Equal(=). As コミット可能か (is_available_commit). And OnlyOnceRegistered. <br>
     * コミット可能か
     */
    public void setVillageSettingItemCode_Equal_コミット可能か() {
        setVillageSettingItemCode_Equal_AsVillageSettingItem(CDef.VillageSettingItem.コミット可能か);
    }

    /**
     * Equal(=). As 役職希望可能か (is_available_skill_request). And OnlyOnceRegistered. <br>
     * 役職希望可能か
     */
    public void setVillageSettingItemCode_Equal_役職希望可能か() {
        setVillageSettingItemCode_Equal_AsVillageSettingItem(CDef.VillageSettingItem.役職希望可能か);
    }

    /**
     * Equal(=). As 見学可能か (is_available_spectate). And OnlyOnceRegistered. <br>
     * 見学可能か
     */
    public void setVillageSettingItemCode_Equal_見学可能か() {
        setVillageSettingItemCode_Equal_AsVillageSettingItem(CDef.VillageSettingItem.見学可能か);
    }

    /**
     * Equal(=). As 突然死ありか (is_available_suddenly_death). And OnlyOnceRegistered. <br>
     * 突然死ありか
     */
    public void setVillageSettingItemCode_Equal_突然死ありか() {
        setVillageSettingItemCode_Equal_AsVillageSettingItem(CDef.VillageSettingItem.突然死ありか);
    }

    /**
     * Equal(=). As 墓下役職公開ありか (is_open_skill_in_grave). And OnlyOnceRegistered. <br>
     * 墓下役職公開ありか
     */
    public void setVillageSettingItemCode_Equal_墓下役職公開ありか() {
        setVillageSettingItemCode_Equal_AsVillageSettingItem(CDef.VillageSettingItem.墓下役職公開ありか);
    }

    /**
     * Equal(=). As 記名投票か (is_open_vote). And OnlyOnceRegistered. <br>
     * 記名投票か
     */
    public void setVillageSettingItemCode_Equal_記名投票か() {
        setVillageSettingItemCode_Equal_AsVillageSettingItem(CDef.VillageSettingItem.記名投票か);
    }

    /**
     * Equal(=). As 墓下見学発言を生存者が見られるか (is_visible_grave_message). And OnlyOnceRegistered. <br>
     * 墓下見学発言を生存者が見られるか
     */
    public void setVillageSettingItemCode_Equal_墓下見学発言を生存者が見られるか() {
        setVillageSettingItemCode_Equal_AsVillageSettingItem(CDef.VillageSettingItem.墓下見学発言を生存者が見られるか);
    }

    /**
     * Equal(=). As 入村パスワード (join_password). And OnlyOnceRegistered. <br>
     * 入村パスワード
     */
    public void setVillageSettingItemCode_Equal_入村パスワード() {
        setVillageSettingItemCode_Equal_AsVillageSettingItem(CDef.VillageSettingItem.入村パスワード);
    }

    /**
     * Equal(=). As 構成 (organize). And OnlyOnceRegistered. <br>
     * 構成
     */
    public void setVillageSettingItemCode_Equal_構成() {
        setVillageSettingItemCode_Equal_AsVillageSettingItem(CDef.VillageSettingItem.構成);
    }

    /**
     * Equal(=). As 最大人数 (person_max). And OnlyOnceRegistered. <br>
     * 最大人数
     */
    public void setVillageSettingItemCode_Equal_最大人数() {
        setVillageSettingItemCode_Equal_AsVillageSettingItem(CDef.VillageSettingItem.最大人数);
    }

    /**
     * Equal(=). As 最低人数 (person_min). And OnlyOnceRegistered. <br>
     * 最低人数
     */
    public void setVillageSettingItemCode_Equal_最低人数() {
        setVillageSettingItemCode_Equal_AsVillageSettingItem(CDef.VillageSettingItem.最低人数);
    }

    /**
     * Equal(=). As 沈黙時間 (silent_hours). And OnlyOnceRegistered. <br>
     * 沈黙時間
     */
    public void setVillageSettingItemCode_Equal_沈黙時間() {
        setVillageSettingItemCode_Equal_AsVillageSettingItem(CDef.VillageSettingItem.沈黙時間);
    }

    /**
     * Equal(=). As 開始予定日時 (start_datetime). And OnlyOnceRegistered. <br>
     * 開始予定日時
     */
    public void setVillageSettingItemCode_Equal_開始予定日時() {
        setVillageSettingItemCode_Equal_AsVillageSettingItem(CDef.VillageSettingItem.開始予定日時);
    }

    /**
     * Equal(=). As 期間形式 (term_type). And OnlyOnceRegistered. <br>
     * 期間形式
     */
    public void setVillageSettingItemCode_Equal_期間形式() {
        setVillageSettingItemCode_Equal_AsVillageSettingItem(CDef.VillageSettingItem.期間形式);
    }

    protected void doSetVillageSettingItemCode_Equal(String villageSettingItemCode) {
        regVillageSettingItemCode(CK_EQ, villageSettingItemCode);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_SETTING_ITEM_CODE: {PK, IX, NotNull, VARCHAR(100), FK to VILLAGE_SETTING_ITEM, classification=VillageSettingItem}
     * @param villageSettingItemCode The value of villageSettingItemCode as notEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setVillageSettingItemCode_NotEqual(String villageSettingItemCode) {
        doSetVillageSettingItemCode_NotEqual(fRES(villageSettingItemCode));
    }

    /**
     * NotEqual(&lt;&gt;). As VillageSettingItem. And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_SETTING_ITEM_CODE: {PK, IX, NotNull, VARCHAR(100), FK to VILLAGE_SETTING_ITEM, classification=VillageSettingItem} <br>
     * 村設定項目
     * @param cdef The instance of classification definition (as ENUM type). (basically NotNull: error as default, or no condition as option)
     */
    public void setVillageSettingItemCode_NotEqual_AsVillageSettingItem(CDef.VillageSettingItem cdef) {
        doSetVillageSettingItemCode_NotEqual(cdef != null ? cdef.code() : null);
    }

    /**
     * NotEqual(&lt;&gt;). As キャラクターグループid (character_group_id). And OnlyOnceRegistered. <br>
     * キャラクターグループID
     */
    public void setVillageSettingItemCode_NotEqual_キャラクターグループid() {
        setVillageSettingItemCode_NotEqual_AsVillageSettingItem(CDef.VillageSettingItem.キャラクターグループid);
    }

    /**
     * NotEqual(&lt;&gt;). As 更新間隔秒 (day_change_interval_seconds). And OnlyOnceRegistered. <br>
     * 更新間隔秒
     */
    public void setVillageSettingItemCode_NotEqual_更新間隔秒() {
        setVillageSettingItemCode_NotEqual_AsVillageSettingItem(CDef.VillageSettingItem.更新間隔秒);
    }

    /**
     * NotEqual(&lt;&gt;). As ダミーキャラid (dummy_chara_id). And OnlyOnceRegistered. <br>
     * ダミーキャラID
     */
    public void setVillageSettingItemCode_NotEqual_ダミーキャラid() {
        setVillageSettingItemCode_NotEqual_AsVillageSettingItem(CDef.VillageSettingItem.ダミーキャラid);
    }

    /**
     * NotEqual(&lt;&gt;). As 自動生成村か (is_auto_generated). And OnlyOnceRegistered. <br>
     * 自動生成村か
     */
    public void setVillageSettingItemCode_NotEqual_自動生成村か() {
        setVillageSettingItemCode_NotEqual_AsVillageSettingItem(CDef.VillageSettingItem.自動生成村か);
    }

    /**
     * NotEqual(&lt;&gt;). As コミット可能か (is_available_commit). And OnlyOnceRegistered. <br>
     * コミット可能か
     */
    public void setVillageSettingItemCode_NotEqual_コミット可能か() {
        setVillageSettingItemCode_NotEqual_AsVillageSettingItem(CDef.VillageSettingItem.コミット可能か);
    }

    /**
     * NotEqual(&lt;&gt;). As 役職希望可能か (is_available_skill_request). And OnlyOnceRegistered. <br>
     * 役職希望可能か
     */
    public void setVillageSettingItemCode_NotEqual_役職希望可能か() {
        setVillageSettingItemCode_NotEqual_AsVillageSettingItem(CDef.VillageSettingItem.役職希望可能か);
    }

    /**
     * NotEqual(&lt;&gt;). As 見学可能か (is_available_spectate). And OnlyOnceRegistered. <br>
     * 見学可能か
     */
    public void setVillageSettingItemCode_NotEqual_見学可能か() {
        setVillageSettingItemCode_NotEqual_AsVillageSettingItem(CDef.VillageSettingItem.見学可能か);
    }

    /**
     * NotEqual(&lt;&gt;). As 突然死ありか (is_available_suddenly_death). And OnlyOnceRegistered. <br>
     * 突然死ありか
     */
    public void setVillageSettingItemCode_NotEqual_突然死ありか() {
        setVillageSettingItemCode_NotEqual_AsVillageSettingItem(CDef.VillageSettingItem.突然死ありか);
    }

    /**
     * NotEqual(&lt;&gt;). As 墓下役職公開ありか (is_open_skill_in_grave). And OnlyOnceRegistered. <br>
     * 墓下役職公開ありか
     */
    public void setVillageSettingItemCode_NotEqual_墓下役職公開ありか() {
        setVillageSettingItemCode_NotEqual_AsVillageSettingItem(CDef.VillageSettingItem.墓下役職公開ありか);
    }

    /**
     * NotEqual(&lt;&gt;). As 記名投票か (is_open_vote). And OnlyOnceRegistered. <br>
     * 記名投票か
     */
    public void setVillageSettingItemCode_NotEqual_記名投票か() {
        setVillageSettingItemCode_NotEqual_AsVillageSettingItem(CDef.VillageSettingItem.記名投票か);
    }

    /**
     * NotEqual(&lt;&gt;). As 墓下見学発言を生存者が見られるか (is_visible_grave_message). And OnlyOnceRegistered. <br>
     * 墓下見学発言を生存者が見られるか
     */
    public void setVillageSettingItemCode_NotEqual_墓下見学発言を生存者が見られるか() {
        setVillageSettingItemCode_NotEqual_AsVillageSettingItem(CDef.VillageSettingItem.墓下見学発言を生存者が見られるか);
    }

    /**
     * NotEqual(&lt;&gt;). As 入村パスワード (join_password). And OnlyOnceRegistered. <br>
     * 入村パスワード
     */
    public void setVillageSettingItemCode_NotEqual_入村パスワード() {
        setVillageSettingItemCode_NotEqual_AsVillageSettingItem(CDef.VillageSettingItem.入村パスワード);
    }

    /**
     * NotEqual(&lt;&gt;). As 構成 (organize). And OnlyOnceRegistered. <br>
     * 構成
     */
    public void setVillageSettingItemCode_NotEqual_構成() {
        setVillageSettingItemCode_NotEqual_AsVillageSettingItem(CDef.VillageSettingItem.構成);
    }

    /**
     * NotEqual(&lt;&gt;). As 最大人数 (person_max). And OnlyOnceRegistered. <br>
     * 最大人数
     */
    public void setVillageSettingItemCode_NotEqual_最大人数() {
        setVillageSettingItemCode_NotEqual_AsVillageSettingItem(CDef.VillageSettingItem.最大人数);
    }

    /**
     * NotEqual(&lt;&gt;). As 最低人数 (person_min). And OnlyOnceRegistered. <br>
     * 最低人数
     */
    public void setVillageSettingItemCode_NotEqual_最低人数() {
        setVillageSettingItemCode_NotEqual_AsVillageSettingItem(CDef.VillageSettingItem.最低人数);
    }

    /**
     * NotEqual(&lt;&gt;). As 沈黙時間 (silent_hours). And OnlyOnceRegistered. <br>
     * 沈黙時間
     */
    public void setVillageSettingItemCode_NotEqual_沈黙時間() {
        setVillageSettingItemCode_NotEqual_AsVillageSettingItem(CDef.VillageSettingItem.沈黙時間);
    }

    /**
     * NotEqual(&lt;&gt;). As 開始予定日時 (start_datetime). And OnlyOnceRegistered. <br>
     * 開始予定日時
     */
    public void setVillageSettingItemCode_NotEqual_開始予定日時() {
        setVillageSettingItemCode_NotEqual_AsVillageSettingItem(CDef.VillageSettingItem.開始予定日時);
    }

    /**
     * NotEqual(&lt;&gt;). As 期間形式 (term_type). And OnlyOnceRegistered. <br>
     * 期間形式
     */
    public void setVillageSettingItemCode_NotEqual_期間形式() {
        setVillageSettingItemCode_NotEqual_AsVillageSettingItem(CDef.VillageSettingItem.期間形式);
    }

    protected void doSetVillageSettingItemCode_NotEqual(String villageSettingItemCode) {
        regVillageSettingItemCode(CK_NES, villageSettingItemCode);
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * VILLAGE_SETTING_ITEM_CODE: {PK, IX, NotNull, VARCHAR(100), FK to VILLAGE_SETTING_ITEM, classification=VillageSettingItem}
     * @param villageSettingItemCodeList The collection of villageSettingItemCode as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setVillageSettingItemCode_InScope(Collection<String> villageSettingItemCodeList) {
        doSetVillageSettingItemCode_InScope(villageSettingItemCodeList);
    }

    /**
     * InScope {in ('a', 'b')}. As VillageSettingItem. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * VILLAGE_SETTING_ITEM_CODE: {PK, IX, NotNull, VARCHAR(100), FK to VILLAGE_SETTING_ITEM, classification=VillageSettingItem} <br>
     * 村設定項目
     * @param cdefList The list of classification definition (as ENUM type). (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setVillageSettingItemCode_InScope_AsVillageSettingItem(Collection<CDef.VillageSettingItem> cdefList) {
        doSetVillageSettingItemCode_InScope(cTStrL(cdefList));
    }

    protected void doSetVillageSettingItemCode_InScope(Collection<String> villageSettingItemCodeList) {
        regINS(CK_INS, cTL(villageSettingItemCodeList), xgetCValueVillageSettingItemCode(), "VILLAGE_SETTING_ITEM_CODE");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * VILLAGE_SETTING_ITEM_CODE: {PK, IX, NotNull, VARCHAR(100), FK to VILLAGE_SETTING_ITEM, classification=VillageSettingItem}
     * @param villageSettingItemCodeList The collection of villageSettingItemCode as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setVillageSettingItemCode_NotInScope(Collection<String> villageSettingItemCodeList) {
        doSetVillageSettingItemCode_NotInScope(villageSettingItemCodeList);
    }

    /**
     * NotInScope {not in ('a', 'b')}. As VillageSettingItem. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * VILLAGE_SETTING_ITEM_CODE: {PK, IX, NotNull, VARCHAR(100), FK to VILLAGE_SETTING_ITEM, classification=VillageSettingItem} <br>
     * 村設定項目
     * @param cdefList The list of classification definition (as ENUM type). (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setVillageSettingItemCode_NotInScope_AsVillageSettingItem(Collection<CDef.VillageSettingItem> cdefList) {
        doSetVillageSettingItemCode_NotInScope(cTStrL(cdefList));
    }

    protected void doSetVillageSettingItemCode_NotInScope(Collection<String> villageSettingItemCodeList) {
        regINS(CK_NINS, cTL(villageSettingItemCodeList), xgetCValueVillageSettingItemCode(), "VILLAGE_SETTING_ITEM_CODE");
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * VILLAGE_SETTING_ITEM_CODE: {PK, IX, NotNull, VARCHAR(100), FK to VILLAGE_SETTING_ITEM, classification=VillageSettingItem}
     */
    public void setVillageSettingItemCode_IsNull() { regVillageSettingItemCode(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * VILLAGE_SETTING_ITEM_CODE: {PK, IX, NotNull, VARCHAR(100), FK to VILLAGE_SETTING_ITEM, classification=VillageSettingItem}
     */
    public void setVillageSettingItemCode_IsNotNull() { regVillageSettingItemCode(CK_ISNN, DOBJ); }

    protected void regVillageSettingItemCode(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueVillageSettingItemCode(), "VILLAGE_SETTING_ITEM_CODE"); }
    protected abstract ConditionValue xgetCValueVillageSettingItemCode();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_SETTING_TEXT: {VARCHAR(1000)}
     * @param villageSettingText The value of villageSettingText as equal. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setVillageSettingText_Equal(String villageSettingText) {
        doSetVillageSettingText_Equal(fRES(villageSettingText));
    }

    protected void doSetVillageSettingText_Equal(String villageSettingText) {
        regVillageSettingText(CK_EQ, villageSettingText);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_SETTING_TEXT: {VARCHAR(1000)}
     * @param villageSettingText The value of villageSettingText as notEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setVillageSettingText_NotEqual(String villageSettingText) {
        doSetVillageSettingText_NotEqual(fRES(villageSettingText));
    }

    protected void doSetVillageSettingText_NotEqual(String villageSettingText) {
        regVillageSettingText(CK_NES, villageSettingText);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_SETTING_TEXT: {VARCHAR(1000)}
     * @param villageSettingText The value of villageSettingText as greaterThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setVillageSettingText_GreaterThan(String villageSettingText) {
        regVillageSettingText(CK_GT, fRES(villageSettingText));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_SETTING_TEXT: {VARCHAR(1000)}
     * @param villageSettingText The value of villageSettingText as lessThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setVillageSettingText_LessThan(String villageSettingText) {
        regVillageSettingText(CK_LT, fRES(villageSettingText));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_SETTING_TEXT: {VARCHAR(1000)}
     * @param villageSettingText The value of villageSettingText as greaterEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setVillageSettingText_GreaterEqual(String villageSettingText) {
        regVillageSettingText(CK_GE, fRES(villageSettingText));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_SETTING_TEXT: {VARCHAR(1000)}
     * @param villageSettingText The value of villageSettingText as lessEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setVillageSettingText_LessEqual(String villageSettingText) {
        regVillageSettingText(CK_LE, fRES(villageSettingText));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * VILLAGE_SETTING_TEXT: {VARCHAR(1000)}
     * @param villageSettingTextList The collection of villageSettingText as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setVillageSettingText_InScope(Collection<String> villageSettingTextList) {
        doSetVillageSettingText_InScope(villageSettingTextList);
    }

    protected void doSetVillageSettingText_InScope(Collection<String> villageSettingTextList) {
        regINS(CK_INS, cTL(villageSettingTextList), xgetCValueVillageSettingText(), "VILLAGE_SETTING_TEXT");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * VILLAGE_SETTING_TEXT: {VARCHAR(1000)}
     * @param villageSettingTextList The collection of villageSettingText as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setVillageSettingText_NotInScope(Collection<String> villageSettingTextList) {
        doSetVillageSettingText_NotInScope(villageSettingTextList);
    }

    protected void doSetVillageSettingText_NotInScope(Collection<String> villageSettingTextList) {
        regINS(CK_NINS, cTL(villageSettingTextList), xgetCValueVillageSettingText(), "VILLAGE_SETTING_TEXT");
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * VILLAGE_SETTING_TEXT: {VARCHAR(1000)} <br>
     * <pre>e.g. setVillageSettingText_LikeSearch("xxx", op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">likeContain()</span>);</pre>
     * @param villageSettingText The value of villageSettingText as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setVillageSettingText_LikeSearch(String villageSettingText, ConditionOptionCall<LikeSearchOption> opLambda) {
        setVillageSettingText_LikeSearch(villageSettingText, xcLSOP(opLambda));
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * VILLAGE_SETTING_TEXT: {VARCHAR(1000)} <br>
     * <pre>e.g. setVillageSettingText_LikeSearch("xxx", new <span style="color: #CC4747">LikeSearchOption</span>().likeContain());</pre>
     * @param villageSettingText The value of villageSettingText as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    protected void setVillageSettingText_LikeSearch(String villageSettingText, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(villageSettingText), xgetCValueVillageSettingText(), "VILLAGE_SETTING_TEXT", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * VILLAGE_SETTING_TEXT: {VARCHAR(1000)}
     * @param villageSettingText The value of villageSettingText as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setVillageSettingText_NotLikeSearch(String villageSettingText, ConditionOptionCall<LikeSearchOption> opLambda) {
        setVillageSettingText_NotLikeSearch(villageSettingText, xcLSOP(opLambda));
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * VILLAGE_SETTING_TEXT: {VARCHAR(1000)}
     * @param villageSettingText The value of villageSettingText as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    protected void setVillageSettingText_NotLikeSearch(String villageSettingText, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(villageSettingText), xgetCValueVillageSettingText(), "VILLAGE_SETTING_TEXT", likeSearchOption);
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * VILLAGE_SETTING_TEXT: {VARCHAR(1000)}
     */
    public void setVillageSettingText_IsNull() { regVillageSettingText(CK_ISN, DOBJ); }

    /**
     * IsNullOrEmpty {is null or empty}. And OnlyOnceRegistered. <br>
     * VILLAGE_SETTING_TEXT: {VARCHAR(1000)}
     */
    public void setVillageSettingText_IsNullOrEmpty() { regVillageSettingText(CK_ISNOE, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * VILLAGE_SETTING_TEXT: {VARCHAR(1000)}
     */
    public void setVillageSettingText_IsNotNull() { regVillageSettingText(CK_ISNN, DOBJ); }

    protected void regVillageSettingText(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueVillageSettingText(), "VILLAGE_SETTING_TEXT"); }
    protected abstract ConditionValue xgetCValueVillageSettingText();

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
    public HpSLCFunction<VillageSettingCB> scalar_Equal() {
        return xcreateSLCFunction(CK_EQ, VillageSettingCB.class);
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
    public HpSLCFunction<VillageSettingCB> scalar_NotEqual() {
        return xcreateSLCFunction(CK_NES, VillageSettingCB.class);
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
    public HpSLCFunction<VillageSettingCB> scalar_GreaterThan() {
        return xcreateSLCFunction(CK_GT, VillageSettingCB.class);
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
    public HpSLCFunction<VillageSettingCB> scalar_LessThan() {
        return xcreateSLCFunction(CK_LT, VillageSettingCB.class);
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
    public HpSLCFunction<VillageSettingCB> scalar_GreaterEqual() {
        return xcreateSLCFunction(CK_GE, VillageSettingCB.class);
    }

    /**
     * Prepare ScalarCondition as lessEqual. <br>
     * {where FOO &lt;= (select max(BAR) from ...)}
     * <pre>
     * cb.query().<span style="color: #CC4747">scalar_LessEqual()</span>.max(new SubQuery&lt;VillageSettingCB&gt;() {
     *     public void query(VillageSettingCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<VillageSettingCB> scalar_LessEqual() {
        return xcreateSLCFunction(CK_LE, VillageSettingCB.class);
    }

    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xscalarCondition(String fn, SubQuery<CB> sq, String rd, HpSLCCustomized<CB> cs, ScalarConditionOption op) {
        assertObjectNotNull("subQuery", sq);
        VillageSettingCB cb = xcreateScalarConditionCB(); sq.query((CB)cb);
        String pp = keepScalarCondition(cb.query()); // for saving query-value
        cs.setPartitionByCBean((CB)xcreateScalarConditionPartitionByCB()); // for using partition-by
        registerScalarCondition(fn, cb.query(), pp, rd, cs, op);
    }
    public abstract String keepScalarCondition(VillageSettingCQ sq);

    protected VillageSettingCB xcreateScalarConditionCB() {
        VillageSettingCB cb = newMyCB(); cb.xsetupForScalarCondition(this); return cb;
    }

    protected VillageSettingCB xcreateScalarConditionPartitionByCB() {
        VillageSettingCB cb = newMyCB(); cb.xsetupForScalarConditionPartitionBy(this); return cb;
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
    protected VillageSettingCB newMyCB() {
        return new VillageSettingCB();
    }
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xabUDT() { return Date.class.getName(); }
    protected String xabCQ() { return VillageSettingCQ.class.getName(); }
    protected String xabLSO() { return LikeSearchOption.class.getName(); }
    protected String xabSLCS() { return HpSLCSetupper.class.getName(); }
    protected String xabSCP() { return SubQuery.class.getName(); }
}
