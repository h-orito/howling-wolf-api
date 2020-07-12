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
 * The entity of NOONNIGHT as TABLE. <br>
 * 昼夜
 * <pre>
 * [primary-key]
 *     NOONNIGHT_CODE
 *
 * [column]
 *     NOONNIGHT_CODE, NOONNIGHT_NAME, DISP_ORDER
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
 *     VILLAGE_DAY
 *
 * [foreign property]
 *     
 *
 * [referrer property]
 *     villageDayList
 *
 * [get/set template]
 * /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
 * String noonnightCode = entity.getNoonnightCode();
 * String noonnightName = entity.getNoonnightName();
 * Integer dispOrder = entity.getDispOrder();
 * entity.setNoonnightCode(noonnightCode);
 * entity.setNoonnightName(noonnightName);
 * entity.setDispOrder(dispOrder);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsNoonnight extends AbstractEntity implements DomainEntity {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** The serial version UID for object serialization. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** NOONNIGHT_CODE: {PK, NotNull, VARCHAR(20), classification=Noonnight} */
    protected String _noonnightCode;

    /** NOONNIGHT_NAME: {NotNull, VARCHAR(20)} */
    protected String _noonnightName;

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
        return "noonnight";
    }

    // ===================================================================================
    //                                                                        Key Handling
    //                                                                        ============
    /** {@inheritDoc} */
    public boolean hasPrimaryKeyValue() {
        if (_noonnightCode == null) { return false; }
        return true;
    }

    // ===================================================================================
    //                                                             Classification Property
    //                                                             =======================
    /**
     * Get the value of noonnightCode as the classification of Noonnight. <br>
     * NOONNIGHT_CODE: {PK, NotNull, VARCHAR(20), classification=Noonnight} <br>
     * 昼夜
     * <p>It's treated as case insensitive and if the code value is null, it returns null.</p>
     * @return The instance of classification definition (as ENUM type). (NullAllowed: when the column value is null)
     */
    public CDef.Noonnight getNoonnightCodeAsNoonnight() {
        return CDef.Noonnight.codeOf(getNoonnightCode());
    }

    /**
     * Set the value of noonnightCode as the classification of Noonnight. <br>
     * NOONNIGHT_CODE: {PK, NotNull, VARCHAR(20), classification=Noonnight} <br>
     * 昼夜
     * @param cdef The instance of classification definition (as ENUM type). (NullAllowed: if null, null value is set to the column)
     */
    public void setNoonnightCodeAsNoonnight(CDef.Noonnight cdef) {
        setNoonnightCode(cdef != null ? cdef.code() : null);
    }

    // ===================================================================================
    //                                                              Classification Setting
    //                                                              ======================
    /**
     * Set the value of noonnightCode as 夜 (NIGHT). <br>
     * 夜
     */
    public void setNoonnightCode_夜() {
        setNoonnightCodeAsNoonnight(CDef.Noonnight.夜);
    }

    /**
     * Set the value of noonnightCode as 昼 (NOON). <br>
     * 昼
     */
    public void setNoonnightCode_昼() {
        setNoonnightCodeAsNoonnight(CDef.Noonnight.昼);
    }

    // ===================================================================================
    //                                                        Classification Determination
    //                                                        ============================
    /**
     * Is the value of noonnightCode 夜? <br>
     * 夜
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isNoonnightCode夜() {
        CDef.Noonnight cdef = getNoonnightCodeAsNoonnight();
        return cdef != null ? cdef.equals(CDef.Noonnight.夜) : false;
    }

    /**
     * Is the value of noonnightCode 昼? <br>
     * 昼
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isNoonnightCode昼() {
        CDef.Noonnight cdef = getNoonnightCodeAsNoonnight();
        return cdef != null ? cdef.equals(CDef.Noonnight.昼) : false;
    }

    // ===================================================================================
    //                                                                    Foreign Property
    //                                                                    ================
    // ===================================================================================
    //                                                                   Referrer Property
    //                                                                   =================
    /** VILLAGE_DAY by NOONNIGHT_CODE, named 'villageDayList'. */
    protected List<VillageDay> _villageDayList;

    /**
     * [get] VILLAGE_DAY by NOONNIGHT_CODE, named 'villageDayList'.
     * @return The entity list of referrer property 'villageDayList'. (NotNull: even if no loading, returns empty list)
     */
    public List<VillageDay> getVillageDayList() {
        if (_villageDayList == null) { _villageDayList = newReferrerList(); }
        return _villageDayList;
    }

    /**
     * [set] VILLAGE_DAY by NOONNIGHT_CODE, named 'villageDayList'.
     * @param villageDayList The entity list of referrer property 'villageDayList'. (NullAllowed)
     */
    public void setVillageDayList(List<VillageDay> villageDayList) {
        _villageDayList = villageDayList;
    }

    protected <ELEMENT> List<ELEMENT> newReferrerList() { // overriding to import
        return new ArrayList<ELEMENT>();
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    @Override
    protected boolean doEquals(Object obj) {
        if (obj instanceof BsNoonnight) {
            BsNoonnight other = (BsNoonnight)obj;
            if (!xSV(_noonnightCode, other._noonnightCode)) { return false; }
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected int doHashCode(int initial) {
        int hs = initial;
        hs = xCH(hs, asTableDbName());
        hs = xCH(hs, _noonnightCode);
        return hs;
    }

    @Override
    protected String doBuildStringWithRelation(String li) {
        StringBuilder sb = new StringBuilder();
        if (_villageDayList != null) { for (VillageDay et : _villageDayList)
        { if (et != null) { sb.append(li).append(xbRDS(et, "villageDayList")); } } }
        return sb.toString();
    }

    @Override
    protected String doBuildColumnString(String dm) {
        StringBuilder sb = new StringBuilder();
        sb.append(dm).append(xfND(_noonnightCode));
        sb.append(dm).append(xfND(_noonnightName));
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
        if (_villageDayList != null && !_villageDayList.isEmpty())
        { sb.append(dm).append("villageDayList"); }
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length()).insert(0, "(").append(")");
        }
        return sb.toString();
    }

    @Override
    public Noonnight clone() {
        return (Noonnight)super.clone();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] NOONNIGHT_CODE: {PK, NotNull, VARCHAR(20), classification=Noonnight} <br>
     * 昼夜コード
     * @return The value of the column 'NOONNIGHT_CODE'. (basically NotNull if selected: for the constraint)
     */
    public String getNoonnightCode() {
        checkSpecifiedProperty("noonnightCode");
        return convertEmptyToNull(_noonnightCode);
    }

    /**
     * [set] NOONNIGHT_CODE: {PK, NotNull, VARCHAR(20), classification=Noonnight} <br>
     * 昼夜コード
     * @param noonnightCode The value of the column 'NOONNIGHT_CODE'. (basically NotNull if update: for the constraint)
     */
    protected void setNoonnightCode(String noonnightCode) {
        checkClassificationCode("NOONNIGHT_CODE", CDef.DefMeta.Noonnight, noonnightCode);
        registerModifiedProperty("noonnightCode");
        _noonnightCode = noonnightCode;
    }

    /**
     * [get] NOONNIGHT_NAME: {NotNull, VARCHAR(20)} <br>
     * 昼夜名
     * @return The value of the column 'NOONNIGHT_NAME'. (basically NotNull if selected: for the constraint)
     */
    public String getNoonnightName() {
        checkSpecifiedProperty("noonnightName");
        return convertEmptyToNull(_noonnightName);
    }

    /**
     * [set] NOONNIGHT_NAME: {NotNull, VARCHAR(20)} <br>
     * 昼夜名
     * @param noonnightName The value of the column 'NOONNIGHT_NAME'. (basically NotNull if update: for the constraint)
     */
    public void setNoonnightName(String noonnightName) {
        registerModifiedProperty("noonnightName");
        _noonnightName = noonnightName;
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
     * @param noonnightCode The value of the column 'NOONNIGHT_CODE'. (basically NotNull if update: for the constraint)
     */
    public void mynativeMappingNoonnightCode(String noonnightCode) {
        setNoonnightCode(noonnightCode);
    }
}
