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
 * The entity of AUTHORITY as TABLE. <br>
 * 権限
 * <pre>
 * [primary-key]
 *     AUTHORITY_CODE
 *
 * [column]
 *     AUTHORITY_CODE, AUTHORITY_NAME
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
 *     PLAYER
 *
 * [foreign property]
 *     
 *
 * [referrer property]
 *     playerList
 *
 * [get/set template]
 * /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
 * String authorityCode = entity.getAuthorityCode();
 * String authorityName = entity.getAuthorityName();
 * entity.setAuthorityCode(authorityCode);
 * entity.setAuthorityName(authorityName);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsAuthority extends AbstractEntity implements DomainEntity {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** The serial version UID for object serialization. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** AUTHORITY_CODE: {PK, NotNull, VARCHAR(20), classification=Authority} */
    protected String _authorityCode;

    /** AUTHORITY_NAME: {NotNull, VARCHAR(20)} */
    protected String _authorityName;

    // ===================================================================================
    //                                                                             DB Meta
    //                                                                             =======
    /** {@inheritDoc} */
    public DBMeta asDBMeta() {
        return DBMetaInstanceHandler.findDBMeta(asTableDbName());
    }

    /** {@inheritDoc} */
    public String asTableDbName() {
        return "AUTHORITY";
    }

    // ===================================================================================
    //                                                                        Key Handling
    //                                                                        ============
    /** {@inheritDoc} */
    public boolean hasPrimaryKeyValue() {
        if (_authorityCode == null) { return false; }
        return true;
    }

    // ===================================================================================
    //                                                             Classification Property
    //                                                             =======================
    /**
     * Get the value of authorityCode as the classification of Authority. <br>
     * AUTHORITY_CODE: {PK, NotNull, VARCHAR(20), classification=Authority} <br>
     * 権限
     * <p>It's treated as case insensitive and if the code value is null, it returns null.</p>
     * @return The instance of classification definition (as ENUM type). (NullAllowed: when the column value is null)
     */
    public CDef.Authority getAuthorityCodeAsAuthority() {
        return CDef.Authority.codeOf(getAuthorityCode());
    }

    /**
     * Set the value of authorityCode as the classification of Authority. <br>
     * AUTHORITY_CODE: {PK, NotNull, VARCHAR(20), classification=Authority} <br>
     * 権限
     * @param cdef The instance of classification definition (as ENUM type). (NullAllowed: if null, null value is set to the column)
     */
    public void setAuthorityCodeAsAuthority(CDef.Authority cdef) {
        setAuthorityCode(cdef != null ? cdef.code() : null);
    }

    // ===================================================================================
    //                                                              Classification Setting
    //                                                              ======================
    /**
     * Set the value of authorityCode as 管理者 (ROLE_ADMIN). <br>
     * 管理者
     */
    public void setAuthorityCode_管理者() {
        setAuthorityCodeAsAuthority(CDef.Authority.管理者);
    }

    /**
     * Set the value of authorityCode as プレイヤー (ROLE_PLAYER). <br>
     * プレイヤー
     */
    public void setAuthorityCode_プレイヤー() {
        setAuthorityCodeAsAuthority(CDef.Authority.プレイヤー);
    }

    // ===================================================================================
    //                                                        Classification Determination
    //                                                        ============================
    /**
     * Is the value of authorityCode 管理者? <br>
     * 管理者
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isAuthorityCode管理者() {
        CDef.Authority cdef = getAuthorityCodeAsAuthority();
        return cdef != null ? cdef.equals(CDef.Authority.管理者) : false;
    }

    /**
     * Is the value of authorityCode プレイヤー? <br>
     * プレイヤー
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isAuthorityCodeプレイヤー() {
        CDef.Authority cdef = getAuthorityCodeAsAuthority();
        return cdef != null ? cdef.equals(CDef.Authority.プレイヤー) : false;
    }

    // ===================================================================================
    //                                                                    Foreign Property
    //                                                                    ================
    // ===================================================================================
    //                                                                   Referrer Property
    //                                                                   =================
    /** PLAYER by AUTHORITY_CODE, named 'playerList'. */
    protected List<Player> _playerList;

    /**
     * [get] PLAYER by AUTHORITY_CODE, named 'playerList'.
     * @return The entity list of referrer property 'playerList'. (NotNull: even if no loading, returns empty list)
     */
    public List<Player> getPlayerList() {
        if (_playerList == null) { _playerList = newReferrerList(); }
        return _playerList;
    }

    /**
     * [set] PLAYER by AUTHORITY_CODE, named 'playerList'.
     * @param playerList The entity list of referrer property 'playerList'. (NullAllowed)
     */
    public void setPlayerList(List<Player> playerList) {
        _playerList = playerList;
    }

    protected <ELEMENT> List<ELEMENT> newReferrerList() { // overriding to import
        return new ArrayList<ELEMENT>();
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    @Override
    protected boolean doEquals(Object obj) {
        if (obj instanceof BsAuthority) {
            BsAuthority other = (BsAuthority)obj;
            if (!xSV(_authorityCode, other._authorityCode)) { return false; }
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected int doHashCode(int initial) {
        int hs = initial;
        hs = xCH(hs, asTableDbName());
        hs = xCH(hs, _authorityCode);
        return hs;
    }

    @Override
    protected String doBuildStringWithRelation(String li) {
        StringBuilder sb = new StringBuilder();
        if (_playerList != null) { for (Player et : _playerList)
        { if (et != null) { sb.append(li).append(xbRDS(et, "playerList")); } } }
        return sb.toString();
    }

    @Override
    protected String doBuildColumnString(String dm) {
        StringBuilder sb = new StringBuilder();
        sb.append(dm).append(xfND(_authorityCode));
        sb.append(dm).append(xfND(_authorityName));
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length());
        }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }

    @Override
    protected String doBuildRelationString(String dm) {
        StringBuilder sb = new StringBuilder();
        if (_playerList != null && !_playerList.isEmpty())
        { sb.append(dm).append("playerList"); }
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length()).insert(0, "(").append(")");
        }
        return sb.toString();
    }

    @Override
    public Authority clone() {
        return (Authority)super.clone();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] AUTHORITY_CODE: {PK, NotNull, VARCHAR(20), classification=Authority} <br>
     * 権限コード
     * @return The value of the column 'AUTHORITY_CODE'. (basically NotNull if selected: for the constraint)
     */
    public String getAuthorityCode() {
        checkSpecifiedProperty("authorityCode");
        return convertEmptyToNull(_authorityCode);
    }

    /**
     * [set] AUTHORITY_CODE: {PK, NotNull, VARCHAR(20), classification=Authority} <br>
     * 権限コード
     * @param authorityCode The value of the column 'AUTHORITY_CODE'. (basically NotNull if update: for the constraint)
     */
    protected void setAuthorityCode(String authorityCode) {
        checkClassificationCode("AUTHORITY_CODE", CDef.DefMeta.Authority, authorityCode);
        registerModifiedProperty("authorityCode");
        _authorityCode = authorityCode;
    }

    /**
     * [get] AUTHORITY_NAME: {NotNull, VARCHAR(20)} <br>
     * 権限名
     * @return The value of the column 'AUTHORITY_NAME'. (basically NotNull if selected: for the constraint)
     */
    public String getAuthorityName() {
        checkSpecifiedProperty("authorityName");
        return convertEmptyToNull(_authorityName);
    }

    /**
     * [set] AUTHORITY_NAME: {NotNull, VARCHAR(20)} <br>
     * 権限名
     * @param authorityName The value of the column 'AUTHORITY_NAME'. (basically NotNull if update: for the constraint)
     */
    public void setAuthorityName(String authorityName) {
        registerModifiedProperty("authorityName");
        _authorityName = authorityName;
    }

    /**
     * For framework so basically DON'T use this method.
     * @param authorityCode The value of the column 'AUTHORITY_CODE'. (basically NotNull if update: for the constraint)
     */
    public void mynativeMappingAuthorityCode(String authorityCode) {
        setAuthorityCode(authorityCode);
    }
}
