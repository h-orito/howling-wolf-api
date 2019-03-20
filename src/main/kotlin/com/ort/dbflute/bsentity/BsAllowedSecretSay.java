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
 * The entity of ALLOWED_SECRET_SAY as TABLE. <br>
 * 秘話可能な範囲
 * <pre>
 * [primary-key]
 *     ALLOWED_SECRET_SAY_CODE
 *
 * [column]
 *     ALLOWED_SECRET_SAY_CODE, ALLOWED_SECRET_SAY_NAME
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
 *     VILLAGE_SETTINGS
 *
 * [foreign property]
 *     
 *
 * [referrer property]
 *     villageSettingsList
 *
 * [get/set template]
 * /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
 * String allowedSecretSayCode = entity.getAllowedSecretSayCode();
 * String allowedSecretSayName = entity.getAllowedSecretSayName();
 * entity.setAllowedSecretSayCode(allowedSecretSayCode);
 * entity.setAllowedSecretSayName(allowedSecretSayName);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsAllowedSecretSay extends AbstractEntity implements DomainEntity {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** The serial version UID for object serialization. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** ALLOWED_SECRET_SAY_CODE: {PK, NotNull, VARCHAR(20), classification=AllowedSecretSay} */
    protected String _allowedSecretSayCode;

    /** ALLOWED_SECRET_SAY_NAME: {NotNull, VARCHAR(20)} */
    protected String _allowedSecretSayName;

    // ===================================================================================
    //                                                                             DB Meta
    //                                                                             =======
    /** {@inheritDoc} */
    public DBMeta asDBMeta() {
        return DBMetaInstanceHandler.findDBMeta(asTableDbName());
    }

    /** {@inheritDoc} */
    public String asTableDbName() {
        return "allowed_secret_say";
    }

    // ===================================================================================
    //                                                                        Key Handling
    //                                                                        ============
    /** {@inheritDoc} */
    public boolean hasPrimaryKeyValue() {
        if (_allowedSecretSayCode == null) { return false; }
        return true;
    }

    // ===================================================================================
    //                                                             Classification Property
    //                                                             =======================
    /**
     * Get the value of allowedSecretSayCode as the classification of AllowedSecretSay. <br>
     * ALLOWED_SECRET_SAY_CODE: {PK, NotNull, VARCHAR(20), classification=AllowedSecretSay} <br>
     * 秘話可能範囲
     * <p>It's treated as case insensitive and if the code value is null, it returns null.</p>
     * @return The instance of classification definition (as ENUM type). (NullAllowed: when the column value is null)
     */
    public CDef.AllowedSecretSay getAllowedSecretSayCodeAsAllowedSecretSay() {
        return CDef.AllowedSecretSay.codeOf(getAllowedSecretSayCode());
    }

    /**
     * Set the value of allowedSecretSayCode as the classification of AllowedSecretSay. <br>
     * ALLOWED_SECRET_SAY_CODE: {PK, NotNull, VARCHAR(20), classification=AllowedSecretSay} <br>
     * 秘話可能範囲
     * @param cdef The instance of classification definition (as ENUM type). (NullAllowed: if null, null value is set to the column)
     */
    public void setAllowedSecretSayCodeAsAllowedSecretSay(CDef.AllowedSecretSay cdef) {
        setAllowedSecretSayCode(cdef != null ? cdef.code() : null);
    }

    // ===================================================================================
    //                                                              Classification Setting
    //                                                              ======================
    /**
     * Set the value of allowedSecretSayCode as 全員 (EVERYTHING). <br>
     * 全員
     */
    public void setAllowedSecretSayCode_全員() {
        setAllowedSecretSayCodeAsAllowedSecretSay(CDef.AllowedSecretSay.全員);
    }

    /**
     * Set the value of allowedSecretSayCode as なし (NOTHING). <br>
     * なし
     */
    public void setAllowedSecretSayCode_なし() {
        setAllowedSecretSayCodeAsAllowedSecretSay(CDef.AllowedSecretSay.なし);
    }

    /**
     * Set the value of allowedSecretSayCode as 村建てとのみ (ONLY_CREATOR). <br>
     * 村建てとのみ
     */
    public void setAllowedSecretSayCode_村建てとのみ() {
        setAllowedSecretSayCodeAsAllowedSecretSay(CDef.AllowedSecretSay.村建てとのみ);
    }

    // ===================================================================================
    //                                                        Classification Determination
    //                                                        ============================
    /**
     * Is the value of allowedSecretSayCode 全員? <br>
     * 全員
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isAllowedSecretSayCode全員() {
        CDef.AllowedSecretSay cdef = getAllowedSecretSayCodeAsAllowedSecretSay();
        return cdef != null ? cdef.equals(CDef.AllowedSecretSay.全員) : false;
    }

    /**
     * Is the value of allowedSecretSayCode なし? <br>
     * なし
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isAllowedSecretSayCodeなし() {
        CDef.AllowedSecretSay cdef = getAllowedSecretSayCodeAsAllowedSecretSay();
        return cdef != null ? cdef.equals(CDef.AllowedSecretSay.なし) : false;
    }

    /**
     * Is the value of allowedSecretSayCode 村建てとのみ? <br>
     * 村建てとのみ
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isAllowedSecretSayCode村建てとのみ() {
        CDef.AllowedSecretSay cdef = getAllowedSecretSayCodeAsAllowedSecretSay();
        return cdef != null ? cdef.equals(CDef.AllowedSecretSay.村建てとのみ) : false;
    }

    // ===================================================================================
    //                                                                    Foreign Property
    //                                                                    ================
    // ===================================================================================
    //                                                                   Referrer Property
    //                                                                   =================
    /** VILLAGE_SETTINGS by ALLOWED_SECRET_SAY_CODE, named 'villageSettingsList'. */
    protected List<VillageSettings> _villageSettingsList;

    /**
     * [get] VILLAGE_SETTINGS by ALLOWED_SECRET_SAY_CODE, named 'villageSettingsList'.
     * @return The entity list of referrer property 'villageSettingsList'. (NotNull: even if no loading, returns empty list)
     */
    public List<VillageSettings> getVillageSettingsList() {
        if (_villageSettingsList == null) { _villageSettingsList = newReferrerList(); }
        return _villageSettingsList;
    }

    /**
     * [set] VILLAGE_SETTINGS by ALLOWED_SECRET_SAY_CODE, named 'villageSettingsList'.
     * @param villageSettingsList The entity list of referrer property 'villageSettingsList'. (NullAllowed)
     */
    public void setVillageSettingsList(List<VillageSettings> villageSettingsList) {
        _villageSettingsList = villageSettingsList;
    }

    protected <ELEMENT> List<ELEMENT> newReferrerList() { // overriding to import
        return new ArrayList<ELEMENT>();
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    @Override
    protected boolean doEquals(Object obj) {
        if (obj instanceof BsAllowedSecretSay) {
            BsAllowedSecretSay other = (BsAllowedSecretSay)obj;
            if (!xSV(_allowedSecretSayCode, other._allowedSecretSayCode)) { return false; }
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected int doHashCode(int initial) {
        int hs = initial;
        hs = xCH(hs, asTableDbName());
        hs = xCH(hs, _allowedSecretSayCode);
        return hs;
    }

    @Override
    protected String doBuildStringWithRelation(String li) {
        StringBuilder sb = new StringBuilder();
        if (_villageSettingsList != null) { for (VillageSettings et : _villageSettingsList)
        { if (et != null) { sb.append(li).append(xbRDS(et, "villageSettingsList")); } } }
        return sb.toString();
    }

    @Override
    protected String doBuildColumnString(String dm) {
        StringBuilder sb = new StringBuilder();
        sb.append(dm).append(xfND(_allowedSecretSayCode));
        sb.append(dm).append(xfND(_allowedSecretSayName));
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length());
        }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }

    @Override
    protected String doBuildRelationString(String dm) {
        StringBuilder sb = new StringBuilder();
        if (_villageSettingsList != null && !_villageSettingsList.isEmpty())
        { sb.append(dm).append("villageSettingsList"); }
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length()).insert(0, "(").append(")");
        }
        return sb.toString();
    }

    @Override
    public AllowedSecretSay clone() {
        return (AllowedSecretSay)super.clone();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] ALLOWED_SECRET_SAY_CODE: {PK, NotNull, VARCHAR(20), classification=AllowedSecretSay} <br>
     * 秘話可能な範囲コード
     * @return The value of the column 'ALLOWED_SECRET_SAY_CODE'. (basically NotNull if selected: for the constraint)
     */
    public String getAllowedSecretSayCode() {
        checkSpecifiedProperty("allowedSecretSayCode");
        return convertEmptyToNull(_allowedSecretSayCode);
    }

    /**
     * [set] ALLOWED_SECRET_SAY_CODE: {PK, NotNull, VARCHAR(20), classification=AllowedSecretSay} <br>
     * 秘話可能な範囲コード
     * @param allowedSecretSayCode The value of the column 'ALLOWED_SECRET_SAY_CODE'. (basically NotNull if update: for the constraint)
     */
    protected void setAllowedSecretSayCode(String allowedSecretSayCode) {
        checkClassificationCode("ALLOWED_SECRET_SAY_CODE", CDef.DefMeta.AllowedSecretSay, allowedSecretSayCode);
        registerModifiedProperty("allowedSecretSayCode");
        _allowedSecretSayCode = allowedSecretSayCode;
    }

    /**
     * [get] ALLOWED_SECRET_SAY_NAME: {NotNull, VARCHAR(20)} <br>
     * 秘話可能範囲
     * @return The value of the column 'ALLOWED_SECRET_SAY_NAME'. (basically NotNull if selected: for the constraint)
     */
    public String getAllowedSecretSayName() {
        checkSpecifiedProperty("allowedSecretSayName");
        return convertEmptyToNull(_allowedSecretSayName);
    }

    /**
     * [set] ALLOWED_SECRET_SAY_NAME: {NotNull, VARCHAR(20)} <br>
     * 秘話可能範囲
     * @param allowedSecretSayName The value of the column 'ALLOWED_SECRET_SAY_NAME'. (basically NotNull if update: for the constraint)
     */
    public void setAllowedSecretSayName(String allowedSecretSayName) {
        registerModifiedProperty("allowedSecretSayName");
        _allowedSecretSayName = allowedSecretSayName;
    }

    /**
     * For framework so basically DON'T use this method.
     * @param allowedSecretSayCode The value of the column 'ALLOWED_SECRET_SAY_CODE'. (basically NotNull if update: for the constraint)
     */
    public void mynativeMappingAllowedSecretSayCode(String allowedSecretSayCode) {
        setAllowedSecretSayCode(allowedSecretSayCode);
    }
}
