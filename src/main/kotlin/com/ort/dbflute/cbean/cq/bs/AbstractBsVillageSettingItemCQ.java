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
 * The abstract condition-query of village_setting_item.
 * @author DBFlute(AutoGenerator)
 */
public abstract class AbstractBsVillageSettingItemCQ extends AbstractConditionQuery {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public AbstractBsVillageSettingItemCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
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
        return "village_setting_item";
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_SETTING_ITEM_CODE: {PK, NotNull, VARCHAR(100), classification=VillageSettingItem}
     * @param villageSettingItemCode The value of villageSettingItemCode as equal. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setVillageSettingItemCode_Equal(String villageSettingItemCode) {
        doSetVillageSettingItemCode_Equal(fRES(villageSettingItemCode));
    }

    /**
     * Equal(=). As VillageSettingItem. And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_SETTING_ITEM_CODE: {PK, NotNull, VARCHAR(100), classification=VillageSettingItem} <br>
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
     * VILLAGE_SETTING_ITEM_CODE: {PK, NotNull, VARCHAR(100), classification=VillageSettingItem}
     * @param villageSettingItemCode The value of villageSettingItemCode as notEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setVillageSettingItemCode_NotEqual(String villageSettingItemCode) {
        doSetVillageSettingItemCode_NotEqual(fRES(villageSettingItemCode));
    }

    /**
     * NotEqual(&lt;&gt;). As VillageSettingItem. And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_SETTING_ITEM_CODE: {PK, NotNull, VARCHAR(100), classification=VillageSettingItem} <br>
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
     * VILLAGE_SETTING_ITEM_CODE: {PK, NotNull, VARCHAR(100), classification=VillageSettingItem}
     * @param villageSettingItemCodeList The collection of villageSettingItemCode as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setVillageSettingItemCode_InScope(Collection<String> villageSettingItemCodeList) {
        doSetVillageSettingItemCode_InScope(villageSettingItemCodeList);
    }

    /**
     * InScope {in ('a', 'b')}. As VillageSettingItem. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * VILLAGE_SETTING_ITEM_CODE: {PK, NotNull, VARCHAR(100), classification=VillageSettingItem} <br>
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
     * VILLAGE_SETTING_ITEM_CODE: {PK, NotNull, VARCHAR(100), classification=VillageSettingItem}
     * @param villageSettingItemCodeList The collection of villageSettingItemCode as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    protected void setVillageSettingItemCode_NotInScope(Collection<String> villageSettingItemCodeList) {
        doSetVillageSettingItemCode_NotInScope(villageSettingItemCodeList);
    }

    /**
     * NotInScope {not in ('a', 'b')}. As VillageSettingItem. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * VILLAGE_SETTING_ITEM_CODE: {PK, NotNull, VARCHAR(100), classification=VillageSettingItem} <br>
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
     * Set up ExistsReferrer (correlated sub-query). <br>
     * {exists (select VILLAGE_SETTING_ITEM_CODE from village_setting where ...)} <br>
     * village_setting by VILLAGE_SETTING_ITEM_CODE, named 'villageSettingAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">existsVillageSetting</span>(settingCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     settingCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of VillageSettingList for 'exists'. (NotNull)
     */
    public void existsVillageSetting(SubQuery<VillageSettingCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        VillageSettingCB cb = new VillageSettingCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepVillageSettingItemCode_ExistsReferrer_VillageSettingList(cb.query());
        registerExistsReferrer(cb.query(), "VILLAGE_SETTING_ITEM_CODE", "VILLAGE_SETTING_ITEM_CODE", pp, "villageSettingList");
    }
    public abstract String keepVillageSettingItemCode_ExistsReferrer_VillageSettingList(VillageSettingCQ sq);

    /**
     * Set up NotExistsReferrer (correlated sub-query). <br>
     * {not exists (select VILLAGE_SETTING_ITEM_CODE from village_setting where ...)} <br>
     * village_setting by VILLAGE_SETTING_ITEM_CODE, named 'villageSettingAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">notExistsVillageSetting</span>(settingCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     settingCB.query().set...
     * });
     * </pre>
     * @param subCBLambda The callback for sub-query of VillageSettingItemCode_NotExistsReferrer_VillageSettingList for 'not exists'. (NotNull)
     */
    public void notExistsVillageSetting(SubQuery<VillageSettingCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        VillageSettingCB cb = new VillageSettingCB(); cb.xsetupForExistsReferrer(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepVillageSettingItemCode_NotExistsReferrer_VillageSettingList(cb.query());
        registerNotExistsReferrer(cb.query(), "VILLAGE_SETTING_ITEM_CODE", "VILLAGE_SETTING_ITEM_CODE", pp, "villageSettingList");
    }
    public abstract String keepVillageSettingItemCode_NotExistsReferrer_VillageSettingList(VillageSettingCQ sq);

    public void xsderiveVillageSettingList(String fn, SubQuery<VillageSettingCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        VillageSettingCB cb = new VillageSettingCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String pp = keepVillageSettingItemCode_SpecifyDerivedReferrer_VillageSettingList(cb.query());
        registerSpecifyDerivedReferrer(fn, cb.query(), "VILLAGE_SETTING_ITEM_CODE", "VILLAGE_SETTING_ITEM_CODE", pp, "villageSettingList", al, op);
    }
    public abstract String keepVillageSettingItemCode_SpecifyDerivedReferrer_VillageSettingList(VillageSettingCQ sq);

    /**
     * Prepare for (Query)DerivedReferrer (correlated sub-query). <br>
     * {FOO &lt;= (select max(BAR) from village_setting where ...)} <br>
     * village_setting by VILLAGE_SETTING_ITEM_CODE, named 'villageSettingAsOne'.
     * <pre>
     * cb.query().<span style="color: #CC4747">derivedVillageSetting()</span>.<span style="color: #CC4747">max</span>(settingCB <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     settingCB.specify().<span style="color: #CC4747">columnFoo...</span> <span style="color: #3F7E5E">// derived column by function</span>
     *     settingCB.query().setBar... <span style="color: #3F7E5E">// referrer condition</span>
     * }).<span style="color: #CC4747">greaterEqual</span>(123); <span style="color: #3F7E5E">// condition to derived column</span>
     * </pre>
     * @return The object to set up a function for referrer table. (NotNull)
     */
    public HpQDRFunction<VillageSettingCB> derivedVillageSetting() {
        return xcreateQDRFunctionVillageSettingList();
    }
    protected HpQDRFunction<VillageSettingCB> xcreateQDRFunctionVillageSettingList() {
        return xcQDRFunc((fn, sq, rd, vl, op) -> xqderiveVillageSettingList(fn, sq, rd, vl, op));
    }
    public void xqderiveVillageSettingList(String fn, SubQuery<VillageSettingCB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        VillageSettingCB cb = new VillageSettingCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String sqpp = keepVillageSettingItemCode_QueryDerivedReferrer_VillageSettingList(cb.query()); String prpp = keepVillageSettingItemCode_QueryDerivedReferrer_VillageSettingListParameter(vl);
        registerQueryDerivedReferrer(fn, cb.query(), "VILLAGE_SETTING_ITEM_CODE", "VILLAGE_SETTING_ITEM_CODE", sqpp, "villageSettingList", rd, vl, prpp, op);
    }
    public abstract String keepVillageSettingItemCode_QueryDerivedReferrer_VillageSettingList(VillageSettingCQ sq);
    public abstract String keepVillageSettingItemCode_QueryDerivedReferrer_VillageSettingListParameter(Object vl);

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * VILLAGE_SETTING_ITEM_CODE: {PK, NotNull, VARCHAR(100), classification=VillageSettingItem}
     */
    public void setVillageSettingItemCode_IsNull() { regVillageSettingItemCode(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * VILLAGE_SETTING_ITEM_CODE: {PK, NotNull, VARCHAR(100), classification=VillageSettingItem}
     */
    public void setVillageSettingItemCode_IsNotNull() { regVillageSettingItemCode(CK_ISNN, DOBJ); }

    protected void regVillageSettingItemCode(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueVillageSettingItemCode(), "VILLAGE_SETTING_ITEM_CODE"); }
    protected abstract ConditionValue xgetCValueVillageSettingItemCode();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_SETTING_ITEM_NAME: {NotNull, VARCHAR(20)}
     * @param villageSettingItemName The value of villageSettingItemName as equal. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setVillageSettingItemName_Equal(String villageSettingItemName) {
        doSetVillageSettingItemName_Equal(fRES(villageSettingItemName));
    }

    protected void doSetVillageSettingItemName_Equal(String villageSettingItemName) {
        regVillageSettingItemName(CK_EQ, villageSettingItemName);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_SETTING_ITEM_NAME: {NotNull, VARCHAR(20)}
     * @param villageSettingItemName The value of villageSettingItemName as notEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setVillageSettingItemName_NotEqual(String villageSettingItemName) {
        doSetVillageSettingItemName_NotEqual(fRES(villageSettingItemName));
    }

    protected void doSetVillageSettingItemName_NotEqual(String villageSettingItemName) {
        regVillageSettingItemName(CK_NES, villageSettingItemName);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_SETTING_ITEM_NAME: {NotNull, VARCHAR(20)}
     * @param villageSettingItemName The value of villageSettingItemName as greaterThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setVillageSettingItemName_GreaterThan(String villageSettingItemName) {
        regVillageSettingItemName(CK_GT, fRES(villageSettingItemName));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_SETTING_ITEM_NAME: {NotNull, VARCHAR(20)}
     * @param villageSettingItemName The value of villageSettingItemName as lessThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setVillageSettingItemName_LessThan(String villageSettingItemName) {
        regVillageSettingItemName(CK_LT, fRES(villageSettingItemName));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_SETTING_ITEM_NAME: {NotNull, VARCHAR(20)}
     * @param villageSettingItemName The value of villageSettingItemName as greaterEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setVillageSettingItemName_GreaterEqual(String villageSettingItemName) {
        regVillageSettingItemName(CK_GE, fRES(villageSettingItemName));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * VILLAGE_SETTING_ITEM_NAME: {NotNull, VARCHAR(20)}
     * @param villageSettingItemName The value of villageSettingItemName as lessEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setVillageSettingItemName_LessEqual(String villageSettingItemName) {
        regVillageSettingItemName(CK_LE, fRES(villageSettingItemName));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * VILLAGE_SETTING_ITEM_NAME: {NotNull, VARCHAR(20)}
     * @param villageSettingItemNameList The collection of villageSettingItemName as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setVillageSettingItemName_InScope(Collection<String> villageSettingItemNameList) {
        doSetVillageSettingItemName_InScope(villageSettingItemNameList);
    }

    protected void doSetVillageSettingItemName_InScope(Collection<String> villageSettingItemNameList) {
        regINS(CK_INS, cTL(villageSettingItemNameList), xgetCValueVillageSettingItemName(), "VILLAGE_SETTING_ITEM_NAME");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * VILLAGE_SETTING_ITEM_NAME: {NotNull, VARCHAR(20)}
     * @param villageSettingItemNameList The collection of villageSettingItemName as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setVillageSettingItemName_NotInScope(Collection<String> villageSettingItemNameList) {
        doSetVillageSettingItemName_NotInScope(villageSettingItemNameList);
    }

    protected void doSetVillageSettingItemName_NotInScope(Collection<String> villageSettingItemNameList) {
        regINS(CK_NINS, cTL(villageSettingItemNameList), xgetCValueVillageSettingItemName(), "VILLAGE_SETTING_ITEM_NAME");
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * VILLAGE_SETTING_ITEM_NAME: {NotNull, VARCHAR(20)} <br>
     * <pre>e.g. setVillageSettingItemName_LikeSearch("xxx", op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">likeContain()</span>);</pre>
     * @param villageSettingItemName The value of villageSettingItemName as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setVillageSettingItemName_LikeSearch(String villageSettingItemName, ConditionOptionCall<LikeSearchOption> opLambda) {
        setVillageSettingItemName_LikeSearch(villageSettingItemName, xcLSOP(opLambda));
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * VILLAGE_SETTING_ITEM_NAME: {NotNull, VARCHAR(20)} <br>
     * <pre>e.g. setVillageSettingItemName_LikeSearch("xxx", new <span style="color: #CC4747">LikeSearchOption</span>().likeContain());</pre>
     * @param villageSettingItemName The value of villageSettingItemName as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    protected void setVillageSettingItemName_LikeSearch(String villageSettingItemName, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(villageSettingItemName), xgetCValueVillageSettingItemName(), "VILLAGE_SETTING_ITEM_NAME", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * VILLAGE_SETTING_ITEM_NAME: {NotNull, VARCHAR(20)}
     * @param villageSettingItemName The value of villageSettingItemName as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setVillageSettingItemName_NotLikeSearch(String villageSettingItemName, ConditionOptionCall<LikeSearchOption> opLambda) {
        setVillageSettingItemName_NotLikeSearch(villageSettingItemName, xcLSOP(opLambda));
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * VILLAGE_SETTING_ITEM_NAME: {NotNull, VARCHAR(20)}
     * @param villageSettingItemName The value of villageSettingItemName as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    protected void setVillageSettingItemName_NotLikeSearch(String villageSettingItemName, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(villageSettingItemName), xgetCValueVillageSettingItemName(), "VILLAGE_SETTING_ITEM_NAME", likeSearchOption);
    }

    protected void regVillageSettingItemName(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueVillageSettingItemName(), "VILLAGE_SETTING_ITEM_NAME"); }
    protected abstract ConditionValue xgetCValueVillageSettingItemName();

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
    public HpSLCFunction<VillageSettingItemCB> scalar_Equal() {
        return xcreateSLCFunction(CK_EQ, VillageSettingItemCB.class);
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
    public HpSLCFunction<VillageSettingItemCB> scalar_NotEqual() {
        return xcreateSLCFunction(CK_NES, VillageSettingItemCB.class);
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
    public HpSLCFunction<VillageSettingItemCB> scalar_GreaterThan() {
        return xcreateSLCFunction(CK_GT, VillageSettingItemCB.class);
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
    public HpSLCFunction<VillageSettingItemCB> scalar_LessThan() {
        return xcreateSLCFunction(CK_LT, VillageSettingItemCB.class);
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
    public HpSLCFunction<VillageSettingItemCB> scalar_GreaterEqual() {
        return xcreateSLCFunction(CK_GE, VillageSettingItemCB.class);
    }

    /**
     * Prepare ScalarCondition as lessEqual. <br>
     * {where FOO &lt;= (select max(BAR) from ...)}
     * <pre>
     * cb.query().<span style="color: #CC4747">scalar_LessEqual()</span>.max(new SubQuery&lt;VillageSettingItemCB&gt;() {
     *     public void query(VillageSettingItemCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<VillageSettingItemCB> scalar_LessEqual() {
        return xcreateSLCFunction(CK_LE, VillageSettingItemCB.class);
    }

    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xscalarCondition(String fn, SubQuery<CB> sq, String rd, HpSLCCustomized<CB> cs, ScalarConditionOption op) {
        assertObjectNotNull("subQuery", sq);
        VillageSettingItemCB cb = xcreateScalarConditionCB(); sq.query((CB)cb);
        String pp = keepScalarCondition(cb.query()); // for saving query-value
        cs.setPartitionByCBean((CB)xcreateScalarConditionPartitionByCB()); // for using partition-by
        registerScalarCondition(fn, cb.query(), pp, rd, cs, op);
    }
    public abstract String keepScalarCondition(VillageSettingItemCQ sq);

    protected VillageSettingItemCB xcreateScalarConditionCB() {
        VillageSettingItemCB cb = newMyCB(); cb.xsetupForScalarCondition(this); return cb;
    }

    protected VillageSettingItemCB xcreateScalarConditionPartitionByCB() {
        VillageSettingItemCB cb = newMyCB(); cb.xsetupForScalarConditionPartitionBy(this); return cb;
    }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public void xsmyselfDerive(String fn, SubQuery<VillageSettingItemCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        VillageSettingItemCB cb = new VillageSettingItemCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String pp = keepSpecifyMyselfDerived(cb.query()); String pk = "VILLAGE_SETTING_ITEM_CODE";
        registerSpecifyMyselfDerived(fn, cb.query(), pk, pk, pp, "myselfDerived", al, op);
    }
    public abstract String keepSpecifyMyselfDerived(VillageSettingItemCQ sq);

    /**
     * Prepare for (Query)MyselfDerived (correlated sub-query).
     * @return The object to set up a function for myself table. (NotNull)
     */
    public HpQDRFunction<VillageSettingItemCB> myselfDerived() {
        return xcreateQDRFunctionMyselfDerived(VillageSettingItemCB.class);
    }
    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xqderiveMyselfDerived(String fn, SubQuery<CB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        VillageSettingItemCB cb = new VillageSettingItemCB(); cb.xsetupForDerivedReferrer(this); sq.query((CB)cb);
        String pk = "VILLAGE_SETTING_ITEM_CODE";
        String sqpp = keepQueryMyselfDerived(cb.query()); // for saving query-value.
        String prpp = keepQueryMyselfDerivedParameter(vl);
        registerQueryMyselfDerived(fn, cb.query(), pk, pk, sqpp, "myselfDerived", rd, vl, prpp, op);
    }
    public abstract String keepQueryMyselfDerived(VillageSettingItemCQ sq);
    public abstract String keepQueryMyselfDerivedParameter(Object vl);

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    /**
     * Prepare for MyselfExists (correlated sub-query).
     * @param subCBLambda The implementation of sub-query. (NotNull)
     */
    public void myselfExists(SubQuery<VillageSettingItemCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        VillageSettingItemCB cb = new VillageSettingItemCB(); cb.xsetupForMyselfExists(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepMyselfExists(cb.query());
        registerMyselfExists(cb.query(), pp);
    }
    public abstract String keepMyselfExists(VillageSettingItemCQ sq);

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
    protected VillageSettingItemCB newMyCB() {
        return new VillageSettingItemCB();
    }
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xabUDT() { return Date.class.getName(); }
    protected String xabCQ() { return VillageSettingItemCQ.class.getName(); }
    protected String xabLSO() { return LikeSearchOption.class.getName(); }
    protected String xabSLCS() { return HpSLCSetupper.class.getName(); }
    protected String xabSCP() { return SubQuery.class.getName(); }
}
