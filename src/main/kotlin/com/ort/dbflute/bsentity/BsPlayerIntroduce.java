package com.ort.dbflute.bsentity;

import java.util.List;
import java.util.ArrayList;

import org.dbflute.Entity;
import org.dbflute.dbmeta.DBMeta;
import org.dbflute.dbmeta.AbstractEntity;
import org.dbflute.dbmeta.accessory.DomainEntity;
import org.dbflute.optional.OptionalEntity;
import com.ort.dbflute.allcommon.EntityDefinedCommonColumn;
import com.ort.dbflute.allcommon.DBMetaInstanceHandler;
import com.ort.dbflute.exentity.*;

/**
 * The entity of PLAYER_INTRODUCE as TABLE. <br>
 * プレイヤー紹介
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsPlayerIntroduce extends AbstractEntity implements DomainEntity, EntityDefinedCommonColumn {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** The serial version UID for object serialization. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** PLAYER_INTRODUCE_ID: {PK, ID, NotNull, INT UNSIGNED(10)} */
    protected Integer _playerIntroduceId;

    /** FROM_PLAYER_ID: {UQ+, NotNull, INT UNSIGNED(10), FK to player} */
    protected Integer _fromPlayerId;

    /** TO_PLAYER_ID: {+UQ, IX, NotNull, INT UNSIGNED(10), FK to player} */
    protected Integer _toPlayerId;

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
        return "player_introduce";
    }

    // ===================================================================================
    //                                                                        Key Handling
    //                                                                        ============
    /** {@inheritDoc} */
    public boolean hasPrimaryKeyValue() {
        if (_playerIntroduceId == null) { return false; }
        return true;
    }

    /**
     * To be unique by the unique column. <br>
     * You can update the entity by the key when entity update (NOT batch update).
     * @param fromPlayerId : UQ+, NotNull, INT UNSIGNED(10), FK to player. (NotNull)
     * @param toPlayerId : +UQ, IX, NotNull, INT UNSIGNED(10), FK to player. (NotNull)
     */
    public void uniqueBy(Integer fromPlayerId, Integer toPlayerId) {
        __uniqueDrivenProperties.clear();
        __uniqueDrivenProperties.addPropertyName("fromPlayerId");
        __uniqueDrivenProperties.addPropertyName("toPlayerId");
        setFromPlayerId(fromPlayerId);setToPlayerId(toPlayerId);
    }

    // ===================================================================================
    //                                                                    Foreign Property
    //                                                                    ================
    /** PLAYER by my FROM_PLAYER_ID, named 'playerByFromPlayerId'. */
    protected OptionalEntity<Player> _playerByFromPlayerId;

    /**
     * [get] PLAYER by my FROM_PLAYER_ID, named 'playerByFromPlayerId'. <br>
     * Optional: alwaysPresent(), ifPresent().orElse(), get(), ...
     * @return The entity of foreign property 'playerByFromPlayerId'. (NotNull, EmptyAllowed: when e.g. null FK column, no setupSelect)
     */
    public OptionalEntity<Player> getPlayerByFromPlayerId() {
        if (_playerByFromPlayerId == null) { _playerByFromPlayerId = OptionalEntity.relationEmpty(this, "playerByFromPlayerId"); }
        return _playerByFromPlayerId;
    }

    /**
     * [set] PLAYER by my FROM_PLAYER_ID, named 'playerByFromPlayerId'.
     * @param playerByFromPlayerId The entity of foreign property 'playerByFromPlayerId'. (NullAllowed)
     */
    public void setPlayerByFromPlayerId(OptionalEntity<Player> playerByFromPlayerId) {
        _playerByFromPlayerId = playerByFromPlayerId;
    }

    /** PLAYER by my TO_PLAYER_ID, named 'playerByToPlayerId'. */
    protected OptionalEntity<Player> _playerByToPlayerId;

    /**
     * [get] PLAYER by my TO_PLAYER_ID, named 'playerByToPlayerId'. <br>
     * Optional: alwaysPresent(), ifPresent().orElse(), get(), ...
     * @return The entity of foreign property 'playerByToPlayerId'. (NotNull, EmptyAllowed: when e.g. null FK column, no setupSelect)
     */
    public OptionalEntity<Player> getPlayerByToPlayerId() {
        if (_playerByToPlayerId == null) { _playerByToPlayerId = OptionalEntity.relationEmpty(this, "playerByToPlayerId"); }
        return _playerByToPlayerId;
    }

    /**
     * [set] PLAYER by my TO_PLAYER_ID, named 'playerByToPlayerId'.
     * @param playerByToPlayerId The entity of foreign property 'playerByToPlayerId'. (NullAllowed)
     */
    public void setPlayerByToPlayerId(OptionalEntity<Player> playerByToPlayerId) {
        _playerByToPlayerId = playerByToPlayerId;
    }

    // ===================================================================================
    //                                                                   Referrer Property
    //                                                                   =================
    protected <ELEMENT> List<ELEMENT> newReferrerList() { // overriding to import
        return new ArrayList<ELEMENT>();
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    @Override
    protected boolean doEquals(Object obj) {
        if (obj instanceof BsPlayerIntroduce) {
            BsPlayerIntroduce other = (BsPlayerIntroduce)obj;
            if (!xSV(_playerIntroduceId, other._playerIntroduceId)) { return false; }
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected int doHashCode(int initial) {
        int hs = initial;
        hs = xCH(hs, asTableDbName());
        hs = xCH(hs, _playerIntroduceId);
        return hs;
    }

    @Override
    protected String doBuildStringWithRelation(String li) {
        StringBuilder sb = new StringBuilder();
        if (_playerByFromPlayerId != null && _playerByFromPlayerId.isPresent())
        { sb.append(li).append(xbRDS(_playerByFromPlayerId, "playerByFromPlayerId")); }
        if (_playerByToPlayerId != null && _playerByToPlayerId.isPresent())
        { sb.append(li).append(xbRDS(_playerByToPlayerId, "playerByToPlayerId")); }
        return sb.toString();
    }
    protected <ET extends Entity> String xbRDS(org.dbflute.optional.OptionalEntity<ET> et, String name) { // buildRelationDisplayString()
        return et.get().buildDisplayString(name, true, true);
    }

    @Override
    protected String doBuildColumnString(String dm) {
        StringBuilder sb = new StringBuilder();
        sb.append(dm).append(xfND(_playerIntroduceId));
        sb.append(dm).append(xfND(_fromPlayerId));
        sb.append(dm).append(xfND(_toPlayerId));
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
        if (_playerByFromPlayerId != null && _playerByFromPlayerId.isPresent())
        { sb.append(dm).append("playerByFromPlayerId"); }
        if (_playerByToPlayerId != null && _playerByToPlayerId.isPresent())
        { sb.append(dm).append("playerByToPlayerId"); }
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length()).insert(0, "(").append(")");
        }
        return sb.toString();
    }

    @Override
    public PlayerIntroduce clone() {
        return (PlayerIntroduce)super.clone();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] PLAYER_INTRODUCE_ID: {PK, ID, NotNull, INT UNSIGNED(10)} <br>
     * プレイヤー紹介ID
     * @return The value of the column 'PLAYER_INTRODUCE_ID'. (basically NotNull if selected: for the constraint)
     */
    public Integer getPlayerIntroduceId() {
        checkSpecifiedProperty("playerIntroduceId");
        return _playerIntroduceId;
    }

    /**
     * [set] PLAYER_INTRODUCE_ID: {PK, ID, NotNull, INT UNSIGNED(10)} <br>
     * プレイヤー紹介ID
     * @param playerIntroduceId The value of the column 'PLAYER_INTRODUCE_ID'. (basically NotNull if update: for the constraint)
     */
    public void setPlayerIntroduceId(Integer playerIntroduceId) {
        registerModifiedProperty("playerIntroduceId");
        _playerIntroduceId = playerIntroduceId;
    }

    /**
     * [get] FROM_PLAYER_ID: {UQ+, NotNull, INT UNSIGNED(10), FK to player} <br>
     * プレイヤーID
     * @return The value of the column 'FROM_PLAYER_ID'. (basically NotNull if selected: for the constraint)
     */
    public Integer getFromPlayerId() {
        checkSpecifiedProperty("fromPlayerId");
        return _fromPlayerId;
    }

    /**
     * [set] FROM_PLAYER_ID: {UQ+, NotNull, INT UNSIGNED(10), FK to player} <br>
     * プレイヤーID
     * @param fromPlayerId The value of the column 'FROM_PLAYER_ID'. (basically NotNull if update: for the constraint)
     */
    public void setFromPlayerId(Integer fromPlayerId) {
        registerModifiedProperty("fromPlayerId");
        _fromPlayerId = fromPlayerId;
    }

    /**
     * [get] TO_PLAYER_ID: {+UQ, IX, NotNull, INT UNSIGNED(10), FK to player} <br>
     * 紹介対象プレイヤーID
     * @return The value of the column 'TO_PLAYER_ID'. (basically NotNull if selected: for the constraint)
     */
    public Integer getToPlayerId() {
        checkSpecifiedProperty("toPlayerId");
        return _toPlayerId;
    }

    /**
     * [set] TO_PLAYER_ID: {+UQ, IX, NotNull, INT UNSIGNED(10), FK to player} <br>
     * 紹介対象プレイヤーID
     * @param toPlayerId The value of the column 'TO_PLAYER_ID'. (basically NotNull if update: for the constraint)
     */
    public void setToPlayerId(Integer toPlayerId) {
        registerModifiedProperty("toPlayerId");
        _toPlayerId = toPlayerId;
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
