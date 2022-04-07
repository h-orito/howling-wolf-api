package com.ort.dbflute.bsentity;

import java.util.List;
import java.util.ArrayList;

import org.dbflute.dbmeta.DBMeta;
import org.dbflute.dbmeta.AbstractEntity;
import org.dbflute.dbmeta.accessory.DomainEntity;
import com.ort.dbflute.allcommon.EntityDefinedCommonColumn;
import com.ort.dbflute.allcommon.DBMetaInstanceHandler;
import com.ort.dbflute.exentity.*;

/**
 * The entity of DESIGNER as TABLE. <br>
 * デザイナー
 * <pre>
 * [primary-key]
 *     DESIGNER_ID
 *
 * [column]
 *     DESIGNER_ID, DESIGNER_NAME, REGISTER_DATETIME, REGISTER_TRACE, UPDATE_DATETIME, UPDATE_TRACE
 *
 * [sequence]
 *     
 *
 * [identity]
 *     DESIGNER_ID
 *
 * [version-no]
 *     
 *
 * [foreign table]
 *     
 *
 * [referrer table]
 *     CHARA_GROUP
 *
 * [foreign property]
 *     
 *
 * [referrer property]
 *     charaGroupList
 *
 * [get/set template]
 * /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
 * Integer designerId = entity.getDesignerId();
 * String designerName = entity.getDesignerName();
 * java.time.LocalDateTime registerDatetime = entity.getRegisterDatetime();
 * String registerTrace = entity.getRegisterTrace();
 * java.time.LocalDateTime updateDatetime = entity.getUpdateDatetime();
 * String updateTrace = entity.getUpdateTrace();
 * entity.setDesignerId(designerId);
 * entity.setDesignerName(designerName);
 * entity.setRegisterDatetime(registerDatetime);
 * entity.setRegisterTrace(registerTrace);
 * entity.setUpdateDatetime(updateDatetime);
 * entity.setUpdateTrace(updateTrace);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsDesigner extends AbstractEntity implements DomainEntity, EntityDefinedCommonColumn {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** The serial version UID for object serialization. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** DESIGNER_ID: {PK, ID, NotNull, INT UNSIGNED(10)} */
    protected Integer _designerId;

    /** DESIGNER_NAME: {NotNull, VARCHAR(40)} */
    protected String _designerName;

    /** REGISTER_DATETIME: {NotNull, DATETIME(19)} */
    protected java.time.LocalDateTime _registerDatetime;

    /** REGISTER_TRACE: {NotNull, VARCHAR(64)} */
    protected String _registerTrace;

    /** UPDATE_DATETIME: {NotNull, DATETIME(19)} */
    protected java.time.LocalDateTime _updateDatetime;

    /** UPDATE_TRACE: {NotNull, VARCHAR(64)} */
    protected String _updateTrace;

    // ===================================================================================
    //                                                                             DB Meta
    //                                                                             =======
    /** {@inheritDoc} */
    public DBMeta asDBMeta() {
        return DBMetaInstanceHandler.findDBMeta(asTableDbName());
    }

    /** {@inheritDoc} */
    public String asTableDbName() {
        return "designer";
    }

    // ===================================================================================
    //                                                                        Key Handling
    //                                                                        ============
    /** {@inheritDoc} */
    public boolean hasPrimaryKeyValue() {
        if (_designerId == null) { return false; }
        return true;
    }

    // ===================================================================================
    //                                                                    Foreign Property
    //                                                                    ================
    // ===================================================================================
    //                                                                   Referrer Property
    //                                                                   =================
    /** CHARA_GROUP by DESIGNER_ID, named 'charaGroupList'. */
    protected List<CharaGroup> _charaGroupList;

    /**
     * [get] CHARA_GROUP by DESIGNER_ID, named 'charaGroupList'.
     * @return The entity list of referrer property 'charaGroupList'. (NotNull: even if no loading, returns empty list)
     */
    public List<CharaGroup> getCharaGroupList() {
        if (_charaGroupList == null) { _charaGroupList = newReferrerList(); }
        return _charaGroupList;
    }

    /**
     * [set] CHARA_GROUP by DESIGNER_ID, named 'charaGroupList'.
     * @param charaGroupList The entity list of referrer property 'charaGroupList'. (NullAllowed)
     */
    public void setCharaGroupList(List<CharaGroup> charaGroupList) {
        _charaGroupList = charaGroupList;
    }

    protected <ELEMENT> List<ELEMENT> newReferrerList() { // overriding to import
        return new ArrayList<ELEMENT>();
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    @Override
    protected boolean doEquals(Object obj) {
        if (obj instanceof BsDesigner) {
            BsDesigner other = (BsDesigner)obj;
            if (!xSV(_designerId, other._designerId)) { return false; }
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected int doHashCode(int initial) {
        int hs = initial;
        hs = xCH(hs, asTableDbName());
        hs = xCH(hs, _designerId);
        return hs;
    }

    @Override
    protected String doBuildStringWithRelation(String li) {
        StringBuilder sb = new StringBuilder();
        if (_charaGroupList != null) { for (CharaGroup et : _charaGroupList)
        { if (et != null) { sb.append(li).append(xbRDS(et, "charaGroupList")); } } }
        return sb.toString();
    }

    @Override
    protected String doBuildColumnString(String dm) {
        StringBuilder sb = new StringBuilder();
        sb.append(dm).append(xfND(_designerId));
        sb.append(dm).append(xfND(_designerName));
        sb.append(dm).append(xfND(_registerDatetime));
        sb.append(dm).append(xfND(_registerTrace));
        sb.append(dm).append(xfND(_updateDatetime));
        sb.append(dm).append(xfND(_updateTrace));
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length());
        }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }

    @Override
    protected String doBuildRelationString(String dm) {
        StringBuilder sb = new StringBuilder();
        if (_charaGroupList != null && !_charaGroupList.isEmpty())
        { sb.append(dm).append("charaGroupList"); }
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length()).insert(0, "(").append(")");
        }
        return sb.toString();
    }

    @Override
    public Designer clone() {
        return (Designer)super.clone();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] DESIGNER_ID: {PK, ID, NotNull, INT UNSIGNED(10)} <br>
     * デザイナーID
     * @return The value of the column 'DESIGNER_ID'. (basically NotNull if selected: for the constraint)
     */
    public Integer getDesignerId() {
        checkSpecifiedProperty("designerId");
        return _designerId;
    }

    /**
     * [set] DESIGNER_ID: {PK, ID, NotNull, INT UNSIGNED(10)} <br>
     * デザイナーID
     * @param designerId The value of the column 'DESIGNER_ID'. (basically NotNull if update: for the constraint)
     */
    public void setDesignerId(Integer designerId) {
        registerModifiedProperty("designerId");
        _designerId = designerId;
    }

    /**
     * [get] DESIGNER_NAME: {NotNull, VARCHAR(40)} <br>
     * デザイナー名
     * @return The value of the column 'DESIGNER_NAME'. (basically NotNull if selected: for the constraint)
     */
    public String getDesignerName() {
        checkSpecifiedProperty("designerName");
        return convertEmptyToNull(_designerName);
    }

    /**
     * [set] DESIGNER_NAME: {NotNull, VARCHAR(40)} <br>
     * デザイナー名
     * @param designerName The value of the column 'DESIGNER_NAME'. (basically NotNull if update: for the constraint)
     */
    public void setDesignerName(String designerName) {
        registerModifiedProperty("designerName");
        _designerName = designerName;
    }

    /**
     * [get] REGISTER_DATETIME: {NotNull, DATETIME(19)} <br>
     * 登録日時
     * @return The value of the column 'REGISTER_DATETIME'. (basically NotNull if selected: for the constraint)
     */
    public java.time.LocalDateTime getRegisterDatetime() {
        checkSpecifiedProperty("registerDatetime");
        return _registerDatetime;
    }

    /**
     * [set] REGISTER_DATETIME: {NotNull, DATETIME(19)} <br>
     * 登録日時
     * @param registerDatetime The value of the column 'REGISTER_DATETIME'. (basically NotNull if update: for the constraint)
     */
    public void setRegisterDatetime(java.time.LocalDateTime registerDatetime) {
        registerModifiedProperty("registerDatetime");
        _registerDatetime = registerDatetime;
    }

    /**
     * [get] REGISTER_TRACE: {NotNull, VARCHAR(64)} <br>
     * 登録トレース
     * @return The value of the column 'REGISTER_TRACE'. (basically NotNull if selected: for the constraint)
     */
    public String getRegisterTrace() {
        checkSpecifiedProperty("registerTrace");
        return convertEmptyToNull(_registerTrace);
    }

    /**
     * [set] REGISTER_TRACE: {NotNull, VARCHAR(64)} <br>
     * 登録トレース
     * @param registerTrace The value of the column 'REGISTER_TRACE'. (basically NotNull if update: for the constraint)
     */
    public void setRegisterTrace(String registerTrace) {
        registerModifiedProperty("registerTrace");
        _registerTrace = registerTrace;
    }

    /**
     * [get] UPDATE_DATETIME: {NotNull, DATETIME(19)} <br>
     * 更新日時
     * @return The value of the column 'UPDATE_DATETIME'. (basically NotNull if selected: for the constraint)
     */
    public java.time.LocalDateTime getUpdateDatetime() {
        checkSpecifiedProperty("updateDatetime");
        return _updateDatetime;
    }

    /**
     * [set] UPDATE_DATETIME: {NotNull, DATETIME(19)} <br>
     * 更新日時
     * @param updateDatetime The value of the column 'UPDATE_DATETIME'. (basically NotNull if update: for the constraint)
     */
    public void setUpdateDatetime(java.time.LocalDateTime updateDatetime) {
        registerModifiedProperty("updateDatetime");
        _updateDatetime = updateDatetime;
    }

    /**
     * [get] UPDATE_TRACE: {NotNull, VARCHAR(64)} <br>
     * 更新トレース
     * @return The value of the column 'UPDATE_TRACE'. (basically NotNull if selected: for the constraint)
     */
    public String getUpdateTrace() {
        checkSpecifiedProperty("updateTrace");
        return convertEmptyToNull(_updateTrace);
    }

    /**
     * [set] UPDATE_TRACE: {NotNull, VARCHAR(64)} <br>
     * 更新トレース
     * @param updateTrace The value of the column 'UPDATE_TRACE'. (basically NotNull if update: for the constraint)
     */
    public void setUpdateTrace(String updateTrace) {
        registerModifiedProperty("updateTrace");
        _updateTrace = updateTrace;
    }
}
