package com.ort.dbflute.cbean.nss;

import com.ort.dbflute.cbean.cq.VillagePlayerCQ;

/**
 * The nest select set-upper of village_player.
 * @author DBFlute(AutoGenerator)
 */
public class VillagePlayerNss {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected final VillagePlayerCQ _query;
    public VillagePlayerNss(VillagePlayerCQ query) { _query = query; }
    public boolean hasConditionQuery() { return _query != null; }

    // ===================================================================================
    //                                                                     Nested Relation
    //                                                                     ===============
    /**
     * With nested relation columns to select clause. <br>
     * CHARA by my CHARA_ID, named 'chara'.
     * @return The set-upper of more nested relation. {...with[nested-relation].with[more-nested-relation]} (NotNull)
     */
    public CharaNss withChara() {
        _query.xdoNss(() -> _query.queryChara());
        return new CharaNss(_query.queryChara());
    }
    /**
     * With nested relation columns to select clause. <br>
     * DEAD_REASON by my DEAD_REASON_CODE, named 'deadReason'.
     */
    public void withDeadReason() {
        _query.xdoNss(() -> _query.queryDeadReason());
    }
    /**
     * With nested relation columns to select clause. <br>
     * PLAYER by my PLAYER_ID, named 'player'.
     * @return The set-upper of more nested relation. {...with[nested-relation].with[more-nested-relation]} (NotNull)
     */
    public PlayerNss withPlayer() {
        _query.xdoNss(() -> _query.queryPlayer());
        return new PlayerNss(_query.queryPlayer());
    }
    /**
     * With nested relation columns to select clause. <br>
     * SKILL by my REQUEST_SKILL_CODE, named 'skillByRequestSkillCode'.
     * @return The set-upper of more nested relation. {...with[nested-relation].with[more-nested-relation]} (NotNull)
     */
    public SkillNss withSkillByRequestSkillCode() {
        _query.xdoNss(() -> _query.querySkillByRequestSkillCode());
        return new SkillNss(_query.querySkillByRequestSkillCode());
    }
    /**
     * With nested relation columns to select clause. <br>
     * SKILL by my SECOND_REQUEST_SKILL_CODE, named 'skillBySecondRequestSkillCode'.
     * @return The set-upper of more nested relation. {...with[nested-relation].with[more-nested-relation]} (NotNull)
     */
    public SkillNss withSkillBySecondRequestSkillCode() {
        _query.xdoNss(() -> _query.querySkillBySecondRequestSkillCode());
        return new SkillNss(_query.querySkillBySecondRequestSkillCode());
    }
    /**
     * With nested relation columns to select clause. <br>
     * SKILL by my SKILL_CODE, named 'skillBySkillCode'.
     * @return The set-upper of more nested relation. {...with[nested-relation].with[more-nested-relation]} (NotNull)
     */
    public SkillNss withSkillBySkillCode() {
        _query.xdoNss(() -> _query.querySkillBySkillCode());
        return new SkillNss(_query.querySkillBySkillCode());
    }
    /**
     * With nested relation columns to select clause. <br>
     * VILLAGE by my VILLAGE_ID, named 'village'.
     * @return The set-upper of more nested relation. {...with[nested-relation].with[more-nested-relation]} (NotNull)
     */
    public VillageNss withVillage() {
        _query.xdoNss(() -> _query.queryVillage());
        return new VillageNss(_query.queryVillage());
    }
}
