package com.ort.dbflute.bsentity;

import java.util.List;
import java.util.ArrayList;

import org.dbflute.Entity;
import org.dbflute.dbmeta.DBMeta;
import org.dbflute.dbmeta.AbstractEntity;
import org.dbflute.dbmeta.accessory.DomainEntity;
import org.dbflute.optional.OptionalEntity;
import com.ort.dbflute.allcommon.DBMetaInstanceHandler;
import com.ort.dbflute.exentity.*;

/**
 * The entity of PLAYER_DETAIL as TABLE. <br>
 * プレイヤー詳細
 * <pre>
 * [primary-key]
 *     PLAYER_ID
 *
 * [column]
 *     PLAYER_ID, OTHER_SITE_NAME, INTRODUCTION
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
 *     PLAYER
 *
 * [referrer table]
 *     
 *
 * [foreign property]
 *     player
 *
 * [referrer property]
 *     
 *
 * [get/set template]
 * /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
 * Integer playerId = entity.getPlayerId();
 * String otherSiteName = entity.getOtherSiteName();
 * String introduction = entity.getIntroduction();
 * entity.setPlayerId(playerId);
 * entity.setOtherSiteName(otherSiteName);
 * entity.setIntroduction(introduction);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsPlayerDetail extends AbstractEntity implements DomainEntity {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** The serial version UID for object serialization. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** PLAYER_ID: {PK, NotNull, INT UNSIGNED(10), FK to player} */
    protected Integer _playerId;

    /** OTHER_SITE_NAME: {VARCHAR(20)} */
    protected String _otherSiteName;

    /** INTRODUCTION: {VARCHAR(2000)} */
    protected String _introduction;

    // ===================================================================================
    //                                                                             DB Meta
    //                                                                             =======
    /** {@inheritDoc} */
    public DBMeta asDBMeta() {
        return DBMetaInstanceHandler.findDBMeta(asTableDbName());
    }

    /** {@inheritDoc} */
    public String asTableDbName() {
        return "player_detail";
    }

    // ===================================================================================
    //                                                                        Key Handling
    //                                                                        ============
    /** {@inheritDoc} */
    public boolean hasPrimaryKeyValue() {
        if (_playerId == null) { return false; }
        return true;
    }

    // ===================================================================================
    //                                                                    Foreign Property
    //                                                                    ================
    /** PLAYER by my PLAYER_ID, named 'player'. */
    protected OptionalEntity<Player> _player;

    /**
     * [get] PLAYER by my PLAYER_ID, named 'player'. <br>
     * Optional: alwaysPresent(), ifPresent().orElse(), get(), ...
     * @return The entity of foreign property 'player'. (NotNull, EmptyAllowed: when e.g. null FK column, no setupSelect)
     */
    public OptionalEntity<Player> getPlayer() {
        if (_player == null) { _player = OptionalEntity.relationEmpty(this, "player"); }
        return _player;
    }

    /**
     * [set] PLAYER by my PLAYER_ID, named 'player'.
     * @param player The entity of foreign property 'player'. (NullAllowed)
     */
    public void setPlayer(OptionalEntity<Player> player) {
        _player = player;
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
        if (obj instanceof BsPlayerDetail) {
            BsPlayerDetail other = (BsPlayerDetail)obj;
            if (!xSV(_playerId, other._playerId)) { return false; }
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected int doHashCode(int initial) {
        int hs = initial;
        hs = xCH(hs, asTableDbName());
        hs = xCH(hs, _playerId);
        return hs;
    }

    @Override
    protected String doBuildStringWithRelation(String li) {
        StringBuilder sb = new StringBuilder();
        if (_player != null && _player.isPresent())
        { sb.append(li).append(xbRDS(_player, "player")); }
        return sb.toString();
    }
    protected <ET extends Entity> String xbRDS(org.dbflute.optional.OptionalEntity<ET> et, String name) { // buildRelationDisplayString()
        return et.get().buildDisplayString(name, true, true);
    }

    @Override
    protected String doBuildColumnString(String dm) {
        StringBuilder sb = new StringBuilder();
        sb.append(dm).append(xfND(_playerId));
        sb.append(dm).append(xfND(_otherSiteName));
        sb.append(dm).append(xfND(_introduction));
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length());
        }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }

    @Override
    protected String doBuildRelationString(String dm) {
        StringBuilder sb = new StringBuilder();
        if (_player != null && _player.isPresent())
        { sb.append(dm).append("player"); }
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length()).insert(0, "(").append(")");
        }
        return sb.toString();
    }

    @Override
    public PlayerDetail clone() {
        return (PlayerDetail)super.clone();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] PLAYER_ID: {PK, NotNull, INT UNSIGNED(10), FK to player} <br>
     * プレイヤーID
     * @return The value of the column 'PLAYER_ID'. (basically NotNull if selected: for the constraint)
     */
    public Integer getPlayerId() {
        checkSpecifiedProperty("playerId");
        return _playerId;
    }

    /**
     * [set] PLAYER_ID: {PK, NotNull, INT UNSIGNED(10), FK to player} <br>
     * プレイヤーID
     * @param playerId The value of the column 'PLAYER_ID'. (basically NotNull if update: for the constraint)
     */
    public void setPlayerId(Integer playerId) {
        registerModifiedProperty("playerId");
        _playerId = playerId;
    }

    /**
     * [get] OTHER_SITE_NAME: {VARCHAR(20)} <br>
     * 他サイトでの名前
     * @return The value of the column 'OTHER_SITE_NAME'. (NullAllowed even if selected: for no constraint)
     */
    public String getOtherSiteName() {
        checkSpecifiedProperty("otherSiteName");
        return convertEmptyToNull(_otherSiteName);
    }

    /**
     * [set] OTHER_SITE_NAME: {VARCHAR(20)} <br>
     * 他サイトでの名前
     * @param otherSiteName The value of the column 'OTHER_SITE_NAME'. (NullAllowed: null update allowed for no constraint)
     */
    public void setOtherSiteName(String otherSiteName) {
        registerModifiedProperty("otherSiteName");
        _otherSiteName = otherSiteName;
    }

    /**
     * [get] INTRODUCTION: {VARCHAR(2000)} <br>
     * 自己紹介
     * @return The value of the column 'INTRODUCTION'. (NullAllowed even if selected: for no constraint)
     */
    public String getIntroduction() {
        checkSpecifiedProperty("introduction");
        return convertEmptyToNull(_introduction);
    }

    /**
     * [set] INTRODUCTION: {VARCHAR(2000)} <br>
     * 自己紹介
     * @param introduction The value of the column 'INTRODUCTION'. (NullAllowed: null update allowed for no constraint)
     */
    public void setIntroduction(String introduction) {
        registerModifiedProperty("introduction");
        _introduction = introduction;
    }
}
