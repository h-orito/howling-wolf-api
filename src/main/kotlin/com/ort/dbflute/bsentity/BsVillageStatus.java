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
 * The entity of VILLAGE_STATUS as TABLE. <br>
 * 村ステータス
 * <pre>
 * [primary-key]
 *     VILLAGE_STATUS_CODE
 *
 * [column]
 *     VILLAGE_STATUS_CODE, VILLAGE_STATUS_NAME
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
 *     VILLAGE
 *
 * [foreign property]
 *     
 *
 * [referrer property]
 *     villageList
 *
 * [get/set template]
 * /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
 * String villageStatusCode = entity.getVillageStatusCode();
 * String villageStatusName = entity.getVillageStatusName();
 * entity.setVillageStatusCode(villageStatusCode);
 * entity.setVillageStatusName(villageStatusName);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsVillageStatus extends AbstractEntity implements DomainEntity {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** The serial version UID for object serialization. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** VILLAGE_STATUS_CODE: {PK, NotNull, VARCHAR(20), classification=VillageStatus} */
    protected String _villageStatusCode;

    /** VILLAGE_STATUS_NAME: {NotNull, VARCHAR(20)} */
    protected String _villageStatusName;

    // ===================================================================================
    //                                                                             DB Meta
    //                                                                             =======
    /** {@inheritDoc} */
    public DBMeta asDBMeta() {
        return DBMetaInstanceHandler.findDBMeta(asTableDbName());
    }

    /** {@inheritDoc} */
    public String asTableDbName() {
        return "village_status";
    }

    // ===================================================================================
    //                                                                        Key Handling
    //                                                                        ============
    /** {@inheritDoc} */
    public boolean hasPrimaryKeyValue() {
        if (_villageStatusCode == null) { return false; }
        return true;
    }

    // ===================================================================================
    //                                                             Classification Property
    //                                                             =======================
    /**
     * Get the value of villageStatusCode as the classification of VillageStatus. <br>
     * VILLAGE_STATUS_CODE: {PK, NotNull, VARCHAR(20), classification=VillageStatus} <br>
     * 村ステータス
     * <p>It's treated as case insensitive and if the code value is null, it returns null.</p>
     * @return The instance of classification definition (as ENUM type). (NullAllowed: when the column value is null)
     */
    public CDef.VillageStatus getVillageStatusCodeAsVillageStatus() {
        return CDef.VillageStatus.codeOf(getVillageStatusCode());
    }

    /**
     * Set the value of villageStatusCode as the classification of VillageStatus. <br>
     * VILLAGE_STATUS_CODE: {PK, NotNull, VARCHAR(20), classification=VillageStatus} <br>
     * 村ステータス
     * @param cdef The instance of classification definition (as ENUM type). (NullAllowed: if null, null value is set to the column)
     */
    public void setVillageStatusCodeAsVillageStatus(CDef.VillageStatus cdef) {
        setVillageStatusCode(cdef != null ? cdef.code() : null);
    }

    // ===================================================================================
    //                                                              Classification Setting
    //                                                              ======================
    /**
     * Set the value of villageStatusCode as 廃村 (CANCEL). <br>
     * 廃村
     */
    public void setVillageStatusCode_廃村() {
        setVillageStatusCodeAsVillageStatus(CDef.VillageStatus.廃村);
    }

    /**
     * Set the value of villageStatusCode as 終了 (COMPLETED). <br>
     * 終了
     */
    public void setVillageStatusCode_終了() {
        setVillageStatusCodeAsVillageStatus(CDef.VillageStatus.終了);
    }

    /**
     * Set the value of villageStatusCode as エピローグ (EPILOGUE). <br>
     * エピローグ
     */
    public void setVillageStatusCode_エピローグ() {
        setVillageStatusCodeAsVillageStatus(CDef.VillageStatus.エピローグ);
    }

    /**
     * Set the value of villageStatusCode as 募集中 (IN_PREPARATION). <br>
     * 募集中
     */
    public void setVillageStatusCode_募集中() {
        setVillageStatusCodeAsVillageStatus(CDef.VillageStatus.募集中);
    }

    /**
     * Set the value of villageStatusCode as 進行中 (IN_PROGRESS). <br>
     * 進行中
     */
    public void setVillageStatusCode_進行中() {
        setVillageStatusCodeAsVillageStatus(CDef.VillageStatus.進行中);
    }

    /**
     * Set the value of villageStatusCode as 開始待ち (WAITING). <br>
     * 開始待ち
     */
    public void setVillageStatusCode_開始待ち() {
        setVillageStatusCodeAsVillageStatus(CDef.VillageStatus.開始待ち);
    }

    // ===================================================================================
    //                                                        Classification Determination
    //                                                        ============================
    /**
     * Is the value of villageStatusCode 廃村? <br>
     * 廃村
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isVillageStatusCode廃村() {
        CDef.VillageStatus cdef = getVillageStatusCodeAsVillageStatus();
        return cdef != null ? cdef.equals(CDef.VillageStatus.廃村) : false;
    }

    /**
     * Is the value of villageStatusCode 終了? <br>
     * 終了
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isVillageStatusCode終了() {
        CDef.VillageStatus cdef = getVillageStatusCodeAsVillageStatus();
        return cdef != null ? cdef.equals(CDef.VillageStatus.終了) : false;
    }

    /**
     * Is the value of villageStatusCode エピローグ? <br>
     * エピローグ
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isVillageStatusCodeエピローグ() {
        CDef.VillageStatus cdef = getVillageStatusCodeAsVillageStatus();
        return cdef != null ? cdef.equals(CDef.VillageStatus.エピローグ) : false;
    }

    /**
     * Is the value of villageStatusCode 募集中? <br>
     * 募集中
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isVillageStatusCode募集中() {
        CDef.VillageStatus cdef = getVillageStatusCodeAsVillageStatus();
        return cdef != null ? cdef.equals(CDef.VillageStatus.募集中) : false;
    }

    /**
     * Is the value of villageStatusCode 進行中? <br>
     * 進行中
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isVillageStatusCode進行中() {
        CDef.VillageStatus cdef = getVillageStatusCodeAsVillageStatus();
        return cdef != null ? cdef.equals(CDef.VillageStatus.進行中) : false;
    }

    /**
     * Is the value of villageStatusCode 開始待ち? <br>
     * 開始待ち
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isVillageStatusCode開始待ち() {
        CDef.VillageStatus cdef = getVillageStatusCodeAsVillageStatus();
        return cdef != null ? cdef.equals(CDef.VillageStatus.開始待ち) : false;
    }

    // ===================================================================================
    //                                                                    Foreign Property
    //                                                                    ================
    // ===================================================================================
    //                                                                   Referrer Property
    //                                                                   =================
    /** VILLAGE by VILLAGE_STATUS_CODE, named 'villageList'. */
    protected List<Village> _villageList;

    /**
     * [get] VILLAGE by VILLAGE_STATUS_CODE, named 'villageList'.
     * @return The entity list of referrer property 'villageList'. (NotNull: even if no loading, returns empty list)
     */
    public List<Village> getVillageList() {
        if (_villageList == null) { _villageList = newReferrerList(); }
        return _villageList;
    }

    /**
     * [set] VILLAGE by VILLAGE_STATUS_CODE, named 'villageList'.
     * @param villageList The entity list of referrer property 'villageList'. (NullAllowed)
     */
    public void setVillageList(List<Village> villageList) {
        _villageList = villageList;
    }

    protected <ELEMENT> List<ELEMENT> newReferrerList() { // overriding to import
        return new ArrayList<ELEMENT>();
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    @Override
    protected boolean doEquals(Object obj) {
        if (obj instanceof BsVillageStatus) {
            BsVillageStatus other = (BsVillageStatus)obj;
            if (!xSV(_villageStatusCode, other._villageStatusCode)) { return false; }
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected int doHashCode(int initial) {
        int hs = initial;
        hs = xCH(hs, asTableDbName());
        hs = xCH(hs, _villageStatusCode);
        return hs;
    }

    @Override
    protected String doBuildStringWithRelation(String li) {
        StringBuilder sb = new StringBuilder();
        if (_villageList != null) { for (Village et : _villageList)
        { if (et != null) { sb.append(li).append(xbRDS(et, "villageList")); } } }
        return sb.toString();
    }

    @Override
    protected String doBuildColumnString(String dm) {
        StringBuilder sb = new StringBuilder();
        sb.append(dm).append(xfND(_villageStatusCode));
        sb.append(dm).append(xfND(_villageStatusName));
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length());
        }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }

    @Override
    protected String doBuildRelationString(String dm) {
        StringBuilder sb = new StringBuilder();
        if (_villageList != null && !_villageList.isEmpty())
        { sb.append(dm).append("villageList"); }
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length()).insert(0, "(").append(")");
        }
        return sb.toString();
    }

    @Override
    public VillageStatus clone() {
        return (VillageStatus)super.clone();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] VILLAGE_STATUS_CODE: {PK, NotNull, VARCHAR(20), classification=VillageStatus} <br>
     * 村ステータスコード
     * @return The value of the column 'VILLAGE_STATUS_CODE'. (basically NotNull if selected: for the constraint)
     */
    public String getVillageStatusCode() {
        checkSpecifiedProperty("villageStatusCode");
        return convertEmptyToNull(_villageStatusCode);
    }

    /**
     * [set] VILLAGE_STATUS_CODE: {PK, NotNull, VARCHAR(20), classification=VillageStatus} <br>
     * 村ステータスコード
     * @param villageStatusCode The value of the column 'VILLAGE_STATUS_CODE'. (basically NotNull if update: for the constraint)
     */
    protected void setVillageStatusCode(String villageStatusCode) {
        checkClassificationCode("VILLAGE_STATUS_CODE", CDef.DefMeta.VillageStatus, villageStatusCode);
        registerModifiedProperty("villageStatusCode");
        _villageStatusCode = villageStatusCode;
    }

    /**
     * [get] VILLAGE_STATUS_NAME: {NotNull, VARCHAR(20)} <br>
     * 村ステータス名
     * @return The value of the column 'VILLAGE_STATUS_NAME'. (basically NotNull if selected: for the constraint)
     */
    public String getVillageStatusName() {
        checkSpecifiedProperty("villageStatusName");
        return convertEmptyToNull(_villageStatusName);
    }

    /**
     * [set] VILLAGE_STATUS_NAME: {NotNull, VARCHAR(20)} <br>
     * 村ステータス名
     * @param villageStatusName The value of the column 'VILLAGE_STATUS_NAME'. (basically NotNull if update: for the constraint)
     */
    public void setVillageStatusName(String villageStatusName) {
        registerModifiedProperty("villageStatusName");
        _villageStatusName = villageStatusName;
    }

    /**
     * For framework so basically DON'T use this method.
     * @param villageStatusCode The value of the column 'VILLAGE_STATUS_CODE'. (basically NotNull if update: for the constraint)
     */
    public void mynativeMappingVillageStatusCode(String villageStatusCode) {
        setVillageStatusCode(villageStatusCode);
    }
}
