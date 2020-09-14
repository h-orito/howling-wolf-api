package com.ort.dbflute.bsentity;

import java.util.List;
import java.util.ArrayList;

import org.dbflute.dbmeta.DBMeta;
import org.dbflute.dbmeta.AbstractEntity;
import org.dbflute.dbmeta.accessory.DomainEntity;
import com.ort.dbflute.allcommon.DBMetaInstanceHandler;
import com.ort.dbflute.allcommon.CDef;
import com.ort.dbflute.exentity.*;

/**
 * The entity of VILLAGE_SETTING_ITEM as TABLE. <br>
 * 村設定項目
 * <pre>
 * [primary-key]
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
 *
 * [get/set template]
 * /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
 * String villageSettingItemCode = entity.getVillageSettingItemCode();
 * String villageSettingItemName = entity.getVillageSettingItemName();
 * Integer dispOrder = entity.getDispOrder();
 * entity.setVillageSettingItemCode(villageSettingItemCode);
 * entity.setVillageSettingItemName(villageSettingItemName);
 * entity.setDispOrder(dispOrder);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsVillageSettingItem extends AbstractEntity implements DomainEntity {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** The serial version UID for object serialization. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** VILLAGE_SETTING_ITEM_CODE: {PK, NotNull, VARCHAR(100), classification=VillageSettingItem} */
    protected String _villageSettingItemCode;

    /** VILLAGE_SETTING_ITEM_NAME: {NotNull, VARCHAR(20)} */
    protected String _villageSettingItemName;

    /** DISP_ORDER: {NotNull, INT UNSIGNED(10)} */
    protected Integer _dispOrder;

    // ===================================================================================
    //                                                                             DB Meta
    //                                                                             =======
    /** {@inheritDoc} */
    public DBMeta asDBMeta() {
        return DBMetaInstanceHandler.findDBMeta(asTableDbName());
    }

    /** {@inheritDoc} */
    public String asTableDbName() {
        return "village_setting_item";
    }

    // ===================================================================================
    //                                                                        Key Handling
    //                                                                        ============
    /** {@inheritDoc} */
    public boolean hasPrimaryKeyValue() {
        if (_villageSettingItemCode == null) { return false; }
        return true;
    }

    // ===================================================================================
    //                                                             Classification Property
    //                                                             =======================
    /**
     * Get the value of villageSettingItemCode as the classification of VillageSettingItem. <br>
     * VILLAGE_SETTING_ITEM_CODE: {PK, NotNull, VARCHAR(100), classification=VillageSettingItem} <br>
     * 村設定項目
     * <p>It's treated as case insensitive and if the code value is null, it returns null.</p>
     * @return The instance of classification definition (as ENUM type). (NullAllowed: when the column value is null)
     */
    public CDef.VillageSettingItem getVillageSettingItemCodeAsVillageSettingItem() {
        return CDef.VillageSettingItem.codeOf(getVillageSettingItemCode());
    }

    /**
     * Set the value of villageSettingItemCode as the classification of VillageSettingItem. <br>
     * VILLAGE_SETTING_ITEM_CODE: {PK, NotNull, VARCHAR(100), classification=VillageSettingItem} <br>
     * 村設定項目
     * @param cdef The instance of classification definition (as ENUM type). (NullAllowed: if null, null value is set to the column)
     */
    public void setVillageSettingItemCodeAsVillageSettingItem(CDef.VillageSettingItem cdef) {
        setVillageSettingItemCode(cdef != null ? cdef.code() : null);
    }

    // ===================================================================================
    //                                                              Classification Setting
    //                                                              ======================
    /**
     * Set the value of villageSettingItemCode as キャラクターグループid (character_group_id). <br>
     * キャラクターグループID
     */
    public void setVillageSettingItemCode_キャラクターグループid() {
        setVillageSettingItemCodeAsVillageSettingItem(CDef.VillageSettingItem.キャラクターグループid);
    }

    /**
     * Set the value of villageSettingItemCode as 更新間隔秒 (day_change_interval_seconds). <br>
     * 更新間隔秒
     */
    public void setVillageSettingItemCode_更新間隔秒() {
        setVillageSettingItemCodeAsVillageSettingItem(CDef.VillageSettingItem.更新間隔秒);
    }

    /**
     * Set the value of villageSettingItemCode as ダミーキャラid (dummy_chara_id). <br>
     * ダミーキャラID
     */
    public void setVillageSettingItemCode_ダミーキャラid() {
        setVillageSettingItemCodeAsVillageSettingItem(CDef.VillageSettingItem.ダミーキャラid);
    }

    /**
     * Set the value of villageSettingItemCode as 自動生成村か (is_auto_generated). <br>
     * 自動生成村か
     */
    public void setVillageSettingItemCode_自動生成村か() {
        setVillageSettingItemCodeAsVillageSettingItem(CDef.VillageSettingItem.自動生成村か);
    }

    /**
     * Set the value of villageSettingItemCode as コミット可能か (is_available_commit). <br>
     * コミット可能か
     */
    public void setVillageSettingItemCode_コミット可能か() {
        setVillageSettingItemCodeAsVillageSettingItem(CDef.VillageSettingItem.コミット可能か);
    }

    /**
     * Set the value of villageSettingItemCode as 役欠けありか (is_available_dummy_skill). <br>
     * 役欠けありか
     */
    public void setVillageSettingItemCode_役欠けありか() {
        setVillageSettingItemCodeAsVillageSettingItem(CDef.VillageSettingItem.役欠けありか);
    }

    /**
     * Set the value of villageSettingItemCode as 役職希望可能か (is_available_skill_request). <br>
     * 役職希望可能か
     */
    public void setVillageSettingItemCode_役職希望可能か() {
        setVillageSettingItemCodeAsVillageSettingItem(CDef.VillageSettingItem.役職希望可能か);
    }

    /**
     * Set the value of villageSettingItemCode as 見学可能か (is_available_spectate). <br>
     * 見学可能か
     */
    public void setVillageSettingItemCode_見学可能か() {
        setVillageSettingItemCodeAsVillageSettingItem(CDef.VillageSettingItem.見学可能か);
    }

    /**
     * Set the value of villageSettingItemCode as 突然死ありか (is_available_suddenly_death). <br>
     * 突然死ありか
     */
    public void setVillageSettingItemCode_突然死ありか() {
        setVillageSettingItemCodeAsVillageSettingItem(CDef.VillageSettingItem.突然死ありか);
    }

    /**
     * Set the value of villageSettingItemCode as 初心者村か (is_for_beginner). <br>
     * 初心者村か
     */
    public void setVillageSettingItemCode_初心者村か() {
        setVillageSettingItemCodeAsVillageSettingItem(CDef.VillageSettingItem.初心者村か);
    }

    /**
     * Set the value of villageSettingItemCode as 墓下役職公開ありか (is_open_skill_in_grave). <br>
     * 墓下役職公開ありか
     */
    public void setVillageSettingItemCode_墓下役職公開ありか() {
        setVillageSettingItemCodeAsVillageSettingItem(CDef.VillageSettingItem.墓下役職公開ありか);
    }

    /**
     * Set the value of villageSettingItemCode as 記名投票か (is_open_vote). <br>
     * 記名投票か
     */
    public void setVillageSettingItemCode_記名投票か() {
        setVillageSettingItemCodeAsVillageSettingItem(CDef.VillageSettingItem.記名投票か);
    }

    /**
     * Set the value of villageSettingItemCode as 墓下見学発言を生存者が見られるか (is_visible_grave_message). <br>
     * 墓下見学発言を生存者が見られるか
     */
    public void setVillageSettingItemCode_墓下見学発言を生存者が見られるか() {
        setVillageSettingItemCodeAsVillageSettingItem(CDef.VillageSettingItem.墓下見学発言を生存者が見られるか);
    }

    /**
     * Set the value of villageSettingItemCode as 入村パスワード (join_password). <br>
     * 入村パスワード
     */
    public void setVillageSettingItemCode_入村パスワード() {
        setVillageSettingItemCodeAsVillageSettingItem(CDef.VillageSettingItem.入村パスワード);
    }

    /**
     * Set the value of villageSettingItemCode as 構成 (organize). <br>
     * 構成
     */
    public void setVillageSettingItemCode_構成() {
        setVillageSettingItemCodeAsVillageSettingItem(CDef.VillageSettingItem.構成);
    }

    /**
     * Set the value of villageSettingItemCode as 最大人数 (person_max). <br>
     * 最大人数
     */
    public void setVillageSettingItemCode_最大人数() {
        setVillageSettingItemCodeAsVillageSettingItem(CDef.VillageSettingItem.最大人数);
    }

    /**
     * Set the value of villageSettingItemCode as 最低人数 (person_min). <br>
     * 最低人数
     */
    public void setVillageSettingItemCode_最低人数() {
        setVillageSettingItemCodeAsVillageSettingItem(CDef.VillageSettingItem.最低人数);
    }

    /**
     * Set the value of villageSettingItemCode as 沈黙時間 (silent_hours). <br>
     * 沈黙時間
     */
    public void setVillageSettingItemCode_沈黙時間() {
        setVillageSettingItemCodeAsVillageSettingItem(CDef.VillageSettingItem.沈黙時間);
    }

    /**
     * Set the value of villageSettingItemCode as 開始予定日時 (start_datetime). <br>
     * 開始予定日時
     */
    public void setVillageSettingItemCode_開始予定日時() {
        setVillageSettingItemCodeAsVillageSettingItem(CDef.VillageSettingItem.開始予定日時);
    }

    /**
     * Set the value of villageSettingItemCode as 期間形式 (term_type). <br>
     * 期間形式
     */
    public void setVillageSettingItemCode_期間形式() {
        setVillageSettingItemCodeAsVillageSettingItem(CDef.VillageSettingItem.期間形式);
    }

    // ===================================================================================
    //                                                        Classification Determination
    //                                                        ============================
    /**
     * Is the value of villageSettingItemCode キャラクターグループid? <br>
     * キャラクターグループID
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isVillageSettingItemCodeキャラクターグループid() {
        CDef.VillageSettingItem cdef = getVillageSettingItemCodeAsVillageSettingItem();
        return cdef != null ? cdef.equals(CDef.VillageSettingItem.キャラクターグループid) : false;
    }

    /**
     * Is the value of villageSettingItemCode 更新間隔秒? <br>
     * 更新間隔秒
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isVillageSettingItemCode更新間隔秒() {
        CDef.VillageSettingItem cdef = getVillageSettingItemCodeAsVillageSettingItem();
        return cdef != null ? cdef.equals(CDef.VillageSettingItem.更新間隔秒) : false;
    }

    /**
     * Is the value of villageSettingItemCode ダミーキャラid? <br>
     * ダミーキャラID
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isVillageSettingItemCodeダミーキャラid() {
        CDef.VillageSettingItem cdef = getVillageSettingItemCodeAsVillageSettingItem();
        return cdef != null ? cdef.equals(CDef.VillageSettingItem.ダミーキャラid) : false;
    }

    /**
     * Is the value of villageSettingItemCode 自動生成村か? <br>
     * 自動生成村か
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isVillageSettingItemCode自動生成村か() {
        CDef.VillageSettingItem cdef = getVillageSettingItemCodeAsVillageSettingItem();
        return cdef != null ? cdef.equals(CDef.VillageSettingItem.自動生成村か) : false;
    }

    /**
     * Is the value of villageSettingItemCode コミット可能か? <br>
     * コミット可能か
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isVillageSettingItemCodeコミット可能か() {
        CDef.VillageSettingItem cdef = getVillageSettingItemCodeAsVillageSettingItem();
        return cdef != null ? cdef.equals(CDef.VillageSettingItem.コミット可能か) : false;
    }

    /**
     * Is the value of villageSettingItemCode 役欠けありか? <br>
     * 役欠けありか
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isVillageSettingItemCode役欠けありか() {
        CDef.VillageSettingItem cdef = getVillageSettingItemCodeAsVillageSettingItem();
        return cdef != null ? cdef.equals(CDef.VillageSettingItem.役欠けありか) : false;
    }

    /**
     * Is the value of villageSettingItemCode 役職希望可能か? <br>
     * 役職希望可能か
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isVillageSettingItemCode役職希望可能か() {
        CDef.VillageSettingItem cdef = getVillageSettingItemCodeAsVillageSettingItem();
        return cdef != null ? cdef.equals(CDef.VillageSettingItem.役職希望可能か) : false;
    }

    /**
     * Is the value of villageSettingItemCode 見学可能か? <br>
     * 見学可能か
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isVillageSettingItemCode見学可能か() {
        CDef.VillageSettingItem cdef = getVillageSettingItemCodeAsVillageSettingItem();
        return cdef != null ? cdef.equals(CDef.VillageSettingItem.見学可能か) : false;
    }

    /**
     * Is the value of villageSettingItemCode 突然死ありか? <br>
     * 突然死ありか
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isVillageSettingItemCode突然死ありか() {
        CDef.VillageSettingItem cdef = getVillageSettingItemCodeAsVillageSettingItem();
        return cdef != null ? cdef.equals(CDef.VillageSettingItem.突然死ありか) : false;
    }

    /**
     * Is the value of villageSettingItemCode 初心者村か? <br>
     * 初心者村か
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isVillageSettingItemCode初心者村か() {
        CDef.VillageSettingItem cdef = getVillageSettingItemCodeAsVillageSettingItem();
        return cdef != null ? cdef.equals(CDef.VillageSettingItem.初心者村か) : false;
    }

    /**
     * Is the value of villageSettingItemCode 墓下役職公開ありか? <br>
     * 墓下役職公開ありか
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isVillageSettingItemCode墓下役職公開ありか() {
        CDef.VillageSettingItem cdef = getVillageSettingItemCodeAsVillageSettingItem();
        return cdef != null ? cdef.equals(CDef.VillageSettingItem.墓下役職公開ありか) : false;
    }

    /**
     * Is the value of villageSettingItemCode 記名投票か? <br>
     * 記名投票か
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isVillageSettingItemCode記名投票か() {
        CDef.VillageSettingItem cdef = getVillageSettingItemCodeAsVillageSettingItem();
        return cdef != null ? cdef.equals(CDef.VillageSettingItem.記名投票か) : false;
    }

    /**
     * Is the value of villageSettingItemCode 墓下見学発言を生存者が見られるか? <br>
     * 墓下見学発言を生存者が見られるか
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isVillageSettingItemCode墓下見学発言を生存者が見られるか() {
        CDef.VillageSettingItem cdef = getVillageSettingItemCodeAsVillageSettingItem();
        return cdef != null ? cdef.equals(CDef.VillageSettingItem.墓下見学発言を生存者が見られるか) : false;
    }

    /**
     * Is the value of villageSettingItemCode 入村パスワード? <br>
     * 入村パスワード
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isVillageSettingItemCode入村パスワード() {
        CDef.VillageSettingItem cdef = getVillageSettingItemCodeAsVillageSettingItem();
        return cdef != null ? cdef.equals(CDef.VillageSettingItem.入村パスワード) : false;
    }

    /**
     * Is the value of villageSettingItemCode 構成? <br>
     * 構成
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isVillageSettingItemCode構成() {
        CDef.VillageSettingItem cdef = getVillageSettingItemCodeAsVillageSettingItem();
        return cdef != null ? cdef.equals(CDef.VillageSettingItem.構成) : false;
    }

    /**
     * Is the value of villageSettingItemCode 最大人数? <br>
     * 最大人数
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isVillageSettingItemCode最大人数() {
        CDef.VillageSettingItem cdef = getVillageSettingItemCodeAsVillageSettingItem();
        return cdef != null ? cdef.equals(CDef.VillageSettingItem.最大人数) : false;
    }

    /**
     * Is the value of villageSettingItemCode 最低人数? <br>
     * 最低人数
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isVillageSettingItemCode最低人数() {
        CDef.VillageSettingItem cdef = getVillageSettingItemCodeAsVillageSettingItem();
        return cdef != null ? cdef.equals(CDef.VillageSettingItem.最低人数) : false;
    }

    /**
     * Is the value of villageSettingItemCode 沈黙時間? <br>
     * 沈黙時間
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isVillageSettingItemCode沈黙時間() {
        CDef.VillageSettingItem cdef = getVillageSettingItemCodeAsVillageSettingItem();
        return cdef != null ? cdef.equals(CDef.VillageSettingItem.沈黙時間) : false;
    }

    /**
     * Is the value of villageSettingItemCode 開始予定日時? <br>
     * 開始予定日時
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isVillageSettingItemCode開始予定日時() {
        CDef.VillageSettingItem cdef = getVillageSettingItemCodeAsVillageSettingItem();
        return cdef != null ? cdef.equals(CDef.VillageSettingItem.開始予定日時) : false;
    }

    /**
     * Is the value of villageSettingItemCode 期間形式? <br>
     * 期間形式
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isVillageSettingItemCode期間形式() {
        CDef.VillageSettingItem cdef = getVillageSettingItemCodeAsVillageSettingItem();
        return cdef != null ? cdef.equals(CDef.VillageSettingItem.期間形式) : false;
    }

    // ===================================================================================
    //                                                                    Foreign Property
    //                                                                    ================
    // ===================================================================================
    //                                                                   Referrer Property
    //                                                                   =================
    /** VILLAGE_SETTING by VILLAGE_SETTING_ITEM_CODE, named 'villageSettingList'. */
    protected List<VillageSetting> _villageSettingList;

    /**
     * [get] VILLAGE_SETTING by VILLAGE_SETTING_ITEM_CODE, named 'villageSettingList'.
     * @return The entity list of referrer property 'villageSettingList'. (NotNull: even if no loading, returns empty list)
     */
    public List<VillageSetting> getVillageSettingList() {
        if (_villageSettingList == null) { _villageSettingList = newReferrerList(); }
        return _villageSettingList;
    }

    /**
     * [set] VILLAGE_SETTING by VILLAGE_SETTING_ITEM_CODE, named 'villageSettingList'.
     * @param villageSettingList The entity list of referrer property 'villageSettingList'. (NullAllowed)
     */
    public void setVillageSettingList(List<VillageSetting> villageSettingList) {
        _villageSettingList = villageSettingList;
    }

    protected <ELEMENT> List<ELEMENT> newReferrerList() { // overriding to import
        return new ArrayList<ELEMENT>();
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    @Override
    protected boolean doEquals(Object obj) {
        if (obj instanceof BsVillageSettingItem) {
            BsVillageSettingItem other = (BsVillageSettingItem)obj;
            if (!xSV(_villageSettingItemCode, other._villageSettingItemCode)) { return false; }
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected int doHashCode(int initial) {
        int hs = initial;
        hs = xCH(hs, asTableDbName());
        hs = xCH(hs, _villageSettingItemCode);
        return hs;
    }

    @Override
    protected String doBuildStringWithRelation(String li) {
        StringBuilder sb = new StringBuilder();
        if (_villageSettingList != null) { for (VillageSetting et : _villageSettingList)
        { if (et != null) { sb.append(li).append(xbRDS(et, "villageSettingList")); } } }
        return sb.toString();
    }

    @Override
    protected String doBuildColumnString(String dm) {
        StringBuilder sb = new StringBuilder();
        sb.append(dm).append(xfND(_villageSettingItemCode));
        sb.append(dm).append(xfND(_villageSettingItemName));
        sb.append(dm).append(xfND(_dispOrder));
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length());
        }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }

    @Override
    protected String doBuildRelationString(String dm) {
        StringBuilder sb = new StringBuilder();
        if (_villageSettingList != null && !_villageSettingList.isEmpty())
        { sb.append(dm).append("villageSettingList"); }
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length()).insert(0, "(").append(")");
        }
        return sb.toString();
    }

    @Override
    public VillageSettingItem clone() {
        return (VillageSettingItem)super.clone();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] VILLAGE_SETTING_ITEM_CODE: {PK, NotNull, VARCHAR(100), classification=VillageSettingItem} <br>
     * 村設定項目コード
     * @return The value of the column 'VILLAGE_SETTING_ITEM_CODE'. (basically NotNull if selected: for the constraint)
     */
    public String getVillageSettingItemCode() {
        checkSpecifiedProperty("villageSettingItemCode");
        return convertEmptyToNull(_villageSettingItemCode);
    }

    /**
     * [set] VILLAGE_SETTING_ITEM_CODE: {PK, NotNull, VARCHAR(100), classification=VillageSettingItem} <br>
     * 村設定項目コード
     * @param villageSettingItemCode The value of the column 'VILLAGE_SETTING_ITEM_CODE'. (basically NotNull if update: for the constraint)
     */
    protected void setVillageSettingItemCode(String villageSettingItemCode) {
        checkClassificationCode("VILLAGE_SETTING_ITEM_CODE", CDef.DefMeta.VillageSettingItem, villageSettingItemCode);
        registerModifiedProperty("villageSettingItemCode");
        _villageSettingItemCode = villageSettingItemCode;
    }

    /**
     * [get] VILLAGE_SETTING_ITEM_NAME: {NotNull, VARCHAR(20)} <br>
     * 村設定項目名
     * @return The value of the column 'VILLAGE_SETTING_ITEM_NAME'. (basically NotNull if selected: for the constraint)
     */
    public String getVillageSettingItemName() {
        checkSpecifiedProperty("villageSettingItemName");
        return convertEmptyToNull(_villageSettingItemName);
    }

    /**
     * [set] VILLAGE_SETTING_ITEM_NAME: {NotNull, VARCHAR(20)} <br>
     * 村設定項目名
     * @param villageSettingItemName The value of the column 'VILLAGE_SETTING_ITEM_NAME'. (basically NotNull if update: for the constraint)
     */
    public void setVillageSettingItemName(String villageSettingItemName) {
        registerModifiedProperty("villageSettingItemName");
        _villageSettingItemName = villageSettingItemName;
    }

    /**
     * [get] DISP_ORDER: {NotNull, INT UNSIGNED(10)} <br>
     * 並び順
     * @return The value of the column 'DISP_ORDER'. (basically NotNull if selected: for the constraint)
     */
    public Integer getDispOrder() {
        checkSpecifiedProperty("dispOrder");
        return _dispOrder;
    }

    /**
     * [set] DISP_ORDER: {NotNull, INT UNSIGNED(10)} <br>
     * 並び順
     * @param dispOrder The value of the column 'DISP_ORDER'. (basically NotNull if update: for the constraint)
     */
    public void setDispOrder(Integer dispOrder) {
        registerModifiedProperty("dispOrder");
        _dispOrder = dispOrder;
    }

    /**
     * For framework so basically DON'T use this method.
     * @param villageSettingItemCode The value of the column 'VILLAGE_SETTING_ITEM_CODE'. (basically NotNull if update: for the constraint)
     */
    public void mynativeMappingVillageSettingItemCode(String villageSettingItemCode) {
        setVillageSettingItemCode(villageSettingItemCode);
    }
}
