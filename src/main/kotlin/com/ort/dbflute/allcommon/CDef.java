package com.ort.dbflute.allcommon;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;

import org.dbflute.exception.ClassificationNotFoundException;
import org.dbflute.jdbc.Classification;
import org.dbflute.jdbc.ClassificationCodeType;
import org.dbflute.jdbc.ClassificationMeta;
import org.dbflute.jdbc.ClassificationUndefinedHandlingType;
import org.dbflute.optional.OptionalThing;

/**
 * The definition of classification.
 * @author DBFlute(AutoGenerator)
 */
public interface CDef extends Classification {

    /**
     * 権限
     */
    public enum Authority implements CDef {
        /** 管理者 */
        管理者("ROLE_ADMIN", "管理者"),
        /** プレイヤー */
        プレイヤー("ROLE_PLAYER", "プレイヤー");
        private static ZzzoneSlimmer<Authority> _slimmer = new ZzzoneSlimmer<>(Authority.class, values());
        private String _code; private String _alias;
        private Authority(String code, String alias) { _code = code; _alias = alias; }
        public String code() { return _code; } public String alias() { return _alias; }
        public Set<String> sisterSet() { return Collections.emptySet(); }
        public Map<String, Object> subItemMap() { return Collections.emptyMap(); }
        public ClassificationMeta meta() { return CDef.DefMeta.Authority; }
        public boolean inGroup(String groupName) { return false; }
        /**
         * Get the classification of the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns empty)
         * @return The optional classification corresponding to the code. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<Authority> of(Object code) { return _slimmer.of(code); }
        /**
         * Find the classification by the name. (CaseInsensitive)
         * @param name The string of name, which is case-insensitive. (NotNull)
         * @return The optional classification corresponding to the name. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<Authority> byName(String name) { return _slimmer.byName(name); }
        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use of(code).</span>
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the code. (NullAllowed: if not found, returns null)
         */
        public static Authority codeOf(Object code) { return _slimmer.codeOf(code); }
        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use byName(name).</span>
         * @param name The string of name, which is case-sensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the name. (NullAllowed: if not found, returns null)
         * @deprecated use byName(name) instead.
         */
        @Deprecated
        public static Authority nameOf(String name) { return _slimmer.nameOf(name, nm -> valueOf(nm)); }
        /**
         * Get the list of all classification elements. (returns new copied list)
         * @return The snapshot list of all classification elements. (NotNull)
         */
        public static List<Authority> listAll() { return _slimmer.listAll(values()); }
        /**
         * Get the list of classification elements in the specified group. (returns new copied list)
         * @param groupName The string of group name, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the group. (NotNull)
         * @throws ClassificationNotFoundException When the group is not found.
         */
        public static List<Authority> listByGroup(String groupName) {
            if (groupName == null) { throw new IllegalArgumentException("The argument 'groupName' should not be null."); }
            throw new ClassificationNotFoundException("Unknown classification group: Authority." + groupName);
        }
        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use e.g. Stream API with of().</span>
         * @param codeList The list of plain code, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the code list. (NotNull, EmptyAllowed: when empty specified)
         * @deprecated use e.g. Stream API with of() instead.
         */
        @Deprecated
        public static List<Authority> listOf(Collection<String> codeList) { return _slimmer.listOf(codeList); }
        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use listByGroup(groupName).</span>
         * @param groupName The string of group name, which is case-sensitive. (NullAllowed: if null, returns empty list)
         * @return The snapshot list of classification elements in the group. (NotNull, EmptyAllowed: if the group is not found)
         * @deprecated use listByGroup(groupName) instead.
         */
        @Deprecated
        public static List<Authority> groupOf(String groupName) { return new ArrayList<>(); }
        @Override public String toString() { return code(); }
    }

    /**
     * 陣営
     */
    public enum Camp implements CDef {
        /** 狐陣営 */
        狐陣営("FOX", "狐陣営"),
        /** 村人陣営 */
        村人陣営("VILLAGER", "村人陣営"),
        /** 人狼陣営 */
        人狼陣営("WEREWOLF", "人狼陣営");
        private static ZzzoneSlimmer<Camp> _slimmer = new ZzzoneSlimmer<>(Camp.class, values());
        private static final Map<String, Map<String, Object>> _subItemMapMap = new HashMap<String, Map<String, Object>>();
        static {
            {
                Map<String, Object> subItemMap = new HashMap<String, Object>();
                subItemMap.put("order", "3");
                _subItemMapMap.put(狐陣営.code(), Collections.unmodifiableMap(subItemMap));
            }
            {
                Map<String, Object> subItemMap = new HashMap<String, Object>();
                subItemMap.put("order", "1");
                _subItemMapMap.put(村人陣営.code(), Collections.unmodifiableMap(subItemMap));
            }
            {
                Map<String, Object> subItemMap = new HashMap<String, Object>();
                subItemMap.put("order", "2");
                _subItemMapMap.put(人狼陣営.code(), Collections.unmodifiableMap(subItemMap));
            }
        }
        private String _code; private String _alias;
        private Camp(String code, String alias) { _code = code; _alias = alias; }
        public String code() { return _code; } public String alias() { return _alias; }
        public Set<String> sisterSet() { return Collections.emptySet(); }
        public Map<String, Object> subItemMap() { return _subItemMapMap.get(code()); }
        public ClassificationMeta meta() { return CDef.DefMeta.Camp; }
        public String order() {
            return (String)subItemMap().get("order");
        }
        public boolean inGroup(String groupName) { return false; }
        /**
         * Get the classification of the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns empty)
         * @return The optional classification corresponding to the code. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<Camp> of(Object code) { return _slimmer.of(code); }
        /**
         * Find the classification by the name. (CaseInsensitive)
         * @param name The string of name, which is case-insensitive. (NotNull)
         * @return The optional classification corresponding to the name. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<Camp> byName(String name) { return _slimmer.byName(name); }
        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use of(code).</span>
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the code. (NullAllowed: if not found, returns null)
         */
        public static Camp codeOf(Object code) { return _slimmer.codeOf(code); }
        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use byName(name).</span>
         * @param name The string of name, which is case-sensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the name. (NullAllowed: if not found, returns null)
         * @deprecated use byName(name) instead.
         */
        @Deprecated
        public static Camp nameOf(String name) { return _slimmer.nameOf(name, nm -> valueOf(nm)); }
        /**
         * Get the list of all classification elements. (returns new copied list)
         * @return The snapshot list of all classification elements. (NotNull)
         */
        public static List<Camp> listAll() { return _slimmer.listAll(values()); }
        /**
         * Get the list of classification elements in the specified group. (returns new copied list)
         * @param groupName The string of group name, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the group. (NotNull)
         * @throws ClassificationNotFoundException When the group is not found.
         */
        public static List<Camp> listByGroup(String groupName) {
            if (groupName == null) { throw new IllegalArgumentException("The argument 'groupName' should not be null."); }
            throw new ClassificationNotFoundException("Unknown classification group: Camp." + groupName);
        }
        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use e.g. Stream API with of().</span>
         * @param codeList The list of plain code, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the code list. (NotNull, EmptyAllowed: when empty specified)
         * @deprecated use e.g. Stream API with of() instead.
         */
        @Deprecated
        public static List<Camp> listOf(Collection<String> codeList) { return _slimmer.listOf(codeList); }
        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use listByGroup(groupName).</span>
         * @param groupName The string of group name, which is case-sensitive. (NullAllowed: if null, returns empty list)
         * @return The snapshot list of classification elements in the group. (NotNull, EmptyAllowed: if the group is not found)
         * @deprecated use listByGroup(groupName) instead.
         */
        @Deprecated
        public static List<Camp> groupOf(String groupName) { return new ArrayList<>(); }
        @Override public String toString() { return code(); }
    }

    /**
     * 村ステータス
     */
    public enum VillageStatus implements CDef {
        /** 廃村 */
        廃村("CANCEL", "廃村"),
        /** 終了 */
        終了("COMPLETED", "終了"),
        /** エピローグ */
        エピローグ("EPILOGUE", "エピローグ"),
        /** 進行中 */
        進行中("IN_PROGRESS", "進行中"),
        /** プロローグ */
        プロローグ("PROLOGUE", "プロローグ");
        private static ZzzoneSlimmer<VillageStatus> _slimmer = new ZzzoneSlimmer<>(VillageStatus.class, values());
        private String _code; private String _alias;
        private VillageStatus(String code, String alias) { _code = code; _alias = alias; }
        public String code() { return _code; } public String alias() { return _alias; }
        public Set<String> sisterSet() { return Collections.emptySet(); }
        public Map<String, Object> subItemMap() { return Collections.emptyMap(); }
        public ClassificationMeta meta() { return CDef.DefMeta.VillageStatus; }
        /**
         * Is the classification in the group? <br>
         * 決着がついた村 <br>
         * The group elements:[エピローグ, 廃村, 終了]
         * @return The determination, true or false.
         */
        public boolean isSolvedVillage() { return エピローグ.equals(this) || 廃村.equals(this) || 終了.equals(this); }
        /**
         * Is the classification in the group? <br>
         * 終了した村 <br>
         * The group elements:[廃村, 終了]
         * @return The determination, true or false.
         */
        public boolean isFinishedVillage() { return 廃村.equals(this) || 終了.equals(this); }
        public boolean inGroup(String groupName) {
            if ("solvedVillage".equalsIgnoreCase(groupName)) { return isSolvedVillage(); }
            if ("finishedVillage".equalsIgnoreCase(groupName)) { return isFinishedVillage(); }
            return false;
        }
        /**
         * Get the classification of the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns empty)
         * @return The optional classification corresponding to the code. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<VillageStatus> of(Object code) { return _slimmer.of(code); }
        /**
         * Find the classification by the name. (CaseInsensitive)
         * @param name The string of name, which is case-insensitive. (NotNull)
         * @return The optional classification corresponding to the name. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<VillageStatus> byName(String name) { return _slimmer.byName(name); }
        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use of(code).</span>
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the code. (NullAllowed: if not found, returns null)
         */
        public static VillageStatus codeOf(Object code) { return _slimmer.codeOf(code); }
        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use byName(name).</span>
         * @param name The string of name, which is case-sensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the name. (NullAllowed: if not found, returns null)
         * @deprecated use byName(name) instead.
         */
        @Deprecated
        public static VillageStatus nameOf(String name) { return _slimmer.nameOf(name, nm -> valueOf(nm)); }
        /**
         * Get the list of all classification elements. (returns new copied list)
         * @return The snapshot list of all classification elements. (NotNull)
         */
        public static List<VillageStatus> listAll() { return _slimmer.listAll(values()); }
        /**
         * Get the list of classification elements in the specified group. (returns new copied list)
         * @param groupName The string of group name, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the group. (NotNull)
         * @throws ClassificationNotFoundException When the group is not found.
         */
        public static List<VillageStatus> listByGroup(String groupName) {
            if (groupName == null) { throw new IllegalArgumentException("The argument 'groupName' should not be null."); }
            if ("solvedVillage".equalsIgnoreCase(groupName)) { return listOfSolvedVillage(); }
            if ("finishedVillage".equalsIgnoreCase(groupName)) { return listOfFinishedVillage(); }
            throw new ClassificationNotFoundException("Unknown classification group: VillageStatus." + groupName);
        }
        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use e.g. Stream API with of().</span>
         * @param codeList The list of plain code, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the code list. (NotNull, EmptyAllowed: when empty specified)
         * @deprecated use e.g. Stream API with of() instead.
         */
        @Deprecated
        public static List<VillageStatus> listOf(Collection<String> codeList) { return _slimmer.listOf(codeList); }
        /**
         * Get the list of group classification elements. (returns new copied list) <br>
         * 決着がついた村 <br>
         * The group elements:[エピローグ, 廃村, 終了]
         * @return The snapshot list of classification elements in the group. (NotNull)
         */
        public static List<VillageStatus> listOfSolvedVillage() {
            return new ArrayList<>(Arrays.asList(エピローグ, 廃村, 終了));
        }
        /**
         * Get the list of group classification elements. (returns new copied list) <br>
         * 終了した村 <br>
         * The group elements:[廃村, 終了]
         * @return The snapshot list of classification elements in the group. (NotNull)
         */
        public static List<VillageStatus> listOfFinishedVillage() {
            return new ArrayList<>(Arrays.asList(廃村, 終了));
        }
        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use listByGroup(groupName).</span>
         * @param groupName The string of group name, which is case-sensitive. (NullAllowed: if null, returns empty list)
         * @return The snapshot list of classification elements in the group. (NotNull, EmptyAllowed: if the group is not found)
         * @deprecated use listByGroup(groupName) instead.
         */
        @Deprecated
        public static List<VillageStatus> groupOf(String groupName) {
            if ("solvedVillage".equalsIgnoreCase(groupName)) { return listOfSolvedVillage(); }
            if ("finishedVillage".equalsIgnoreCase(groupName)) { return listOfFinishedVillage(); }
            return new ArrayList<>();
        }
        @Override public String toString() { return code(); }
    }

    /**
     * 役職
     */
    public enum Skill implements CDef {
        /** C国狂人 */
        C国狂人("CMADMAN", "C国狂人"),
        /** 狂信者 */
        狂信者("FANATIC", "狂信者"),
        /** 妖狐 */
        妖狐("FOX", "妖狐"),
        /** 狩人 */
        狩人("HUNTER", "狩人"),
        /** 背徳者 */
        背徳者("IMMORAL", "背徳者"),
        /** おまかせ */
        おまかせ("LEFTOVER", "おまかせ"),
        /** 狂人 */
        狂人("MADMAN", "狂人"),
        /** 共有者 */
        共有者("MASON", "共有者"),
        /** 霊能者 */
        霊能者("MEDIUM", "霊能者"),
        /** 猫又 */
        猫又("MONSTERCAT", "猫又"),
        /** 占い師 */
        占い師("SEER", "占い師"),
        /** 聖痕者 */
        聖痕者("STIGMATA", "聖痕者"),
        /** 村人 */
        村人("VILLAGER", "村人"),
        /** おまかせ（村人陣営） */
        おまかせ村人陣営("VILLAGERS", "おまかせ（村人陣営）"),
        /** 人狼 */
        人狼("WEREWOLF", "人狼"),
        /** おまかせ（人狼陣営） */
        おまかせ人狼陣営("WEREWOLFS", "おまかせ（人狼陣営）");
        private static ZzzoneSlimmer<Skill> _slimmer = new ZzzoneSlimmer<>(Skill.class, values());
        private static final Map<String, Map<String, Object>> _subItemMapMap = new HashMap<String, Map<String, Object>>();
        static {
            {
                Map<String, Object> subItemMap = new HashMap<String, Object>();
                subItemMap.put("shortName", "Ｃ");
                subItemMap.put("order", "105");
                subItemMap.put("campCode", "WEREWOLF");
                subItemMap.put("description", "あなたはC国狂人です。人狼系役職とC国狂人同士にしか聞こえない会話が可能で、人狼の勝利があなたの勝利となります。");
                _subItemMapMap.put(C国狂人.code(), Collections.unmodifiableMap(subItemMap));
            }
            {
                Map<String, Object> subItemMap = new HashMap<String, Object>();
                subItemMap.put("shortName", "信");
                subItemMap.put("order", "106");
                subItemMap.put("campCode", "WEREWOLF");
                subItemMap.put("description", "あなたは狂信者です。人狼が誰かを知ることができます（人狼からはあなたが狂信者であることはわかりません）。特別な能力はありませんが、人狼の勝利があなたの勝利となります。");
                _subItemMapMap.put(狂信者.code(), Collections.unmodifiableMap(subItemMap));
            }
            {
                Map<String, Object> subItemMap = new HashMap<String, Object>();
                subItemMap.put("shortName", "狐");
                subItemMap.put("order", "201");
                subItemMap.put("campCode", "FOX");
                subItemMap.put("description", "あなたは妖狐です。最後まで生存するとあなたの勝利となります。人狼に襲撃されても死亡しませんが、占われると死亡します。また、あなたは他の妖狐が誰であるかを知ることができます。");
                _subItemMapMap.put(妖狐.code(), Collections.unmodifiableMap(subItemMap));
            }
            {
                Map<String, Object> subItemMap = new HashMap<String, Object>();
                subItemMap.put("shortName", "狩");
                subItemMap.put("order", "7");
                subItemMap.put("campCode", "VILLAGER");
                subItemMap.put("description", "あなたは狩人です。初日以外の毎晩、自分以外の一人を人狼の襲撃から守ることができます。");
                _subItemMapMap.put(狩人.code(), Collections.unmodifiableMap(subItemMap));
            }
            {
                Map<String, Object> subItemMap = new HashMap<String, Object>();
                subItemMap.put("shortName", "背");
                subItemMap.put("order", "202");
                subItemMap.put("campCode", "FOX");
                subItemMap.put("description", "あなたは背徳者です。特別な能力はありませんが、妖狐の勝利があなたの勝利となります。あなたは、妖狐が全滅すると後追いしてしまいます。また、あなたは妖狐が誰であるかを知ることができます。");
                _subItemMapMap.put(背徳者.code(), Collections.unmodifiableMap(subItemMap));
            }
            {
                Map<String, Object> subItemMap = new HashMap<String, Object>();
                subItemMap.put("shortName", "お");
                subItemMap.put("order", "1001");
                subItemMap.put("campCode", "VILLAGER");
                subItemMap.put("description", "余った役職が割り当てられます。");
                _subItemMapMap.put(おまかせ.code(), Collections.unmodifiableMap(subItemMap));
            }
            {
                Map<String, Object> subItemMap = new HashMap<String, Object>();
                subItemMap.put("shortName", "狂");
                subItemMap.put("order", "104");
                subItemMap.put("campCode", "WEREWOLF");
                subItemMap.put("description", "あなたは狂人です。特別な能力はありませんが、人狼の勝利があなたの勝利となります。");
                _subItemMapMap.put(狂人.code(), Collections.unmodifiableMap(subItemMap));
            }
            {
                Map<String, Object> subItemMap = new HashMap<String, Object>();
                subItemMap.put("shortName", "共");
                subItemMap.put("order", "9");
                subItemMap.put("campCode", "VILLAGER");
                subItemMap.put("description", "あなたは共有者です。他の共有者が誰であるかを知ることができます。");
                _subItemMapMap.put(共有者.code(), Collections.unmodifiableMap(subItemMap));
            }
            {
                Map<String, Object> subItemMap = new HashMap<String, Object>();
                subItemMap.put("shortName", "霊");
                subItemMap.put("order", "4");
                subItemMap.put("campCode", "VILLAGER");
                subItemMap.put("description", "あなたは霊能者です。処刑された・突然死した人物が人狼であったかどうかを知ることができます。");
                _subItemMapMap.put(霊能者.code(), Collections.unmodifiableMap(subItemMap));
            }
            {
                Map<String, Object> subItemMap = new HashMap<String, Object>();
                subItemMap.put("shortName", "猫");
                subItemMap.put("order", "12");
                subItemMap.put("campCode", "VILLAGER");
                subItemMap.put("description", "あなたは猫又です。処刑死したら投票者から1名をランダムで、襲撃死したら襲撃担当者を道連れにすることができます。");
                _subItemMapMap.put(猫又.code(), Collections.unmodifiableMap(subItemMap));
            }
            {
                Map<String, Object> subItemMap = new HashMap<String, Object>();
                subItemMap.put("shortName", "占");
                subItemMap.put("order", "2");
                subItemMap.put("campCode", "VILLAGER");
                subItemMap.put("description", "あなたは占い師です。毎晩一人を占い、人狼かどうかを知ることができます。");
                _subItemMapMap.put(占い師.code(), Collections.unmodifiableMap(subItemMap));
            }
            {
                Map<String, Object> subItemMap = new HashMap<String, Object>();
                subItemMap.put("shortName", "聖");
                subItemMap.put("order", "11");
                subItemMap.put("campCode", "VILLAGER");
                subItemMap.put("description", "あなたは聖痕者です。特別な能力はありませんが、独特の印を持つため、あなたの正体は比較的信用されやすいでしょう。");
                _subItemMapMap.put(聖痕者.code(), Collections.unmodifiableMap(subItemMap));
            }
            {
                Map<String, Object> subItemMap = new HashMap<String, Object>();
                subItemMap.put("shortName", "村");
                subItemMap.put("order", "1");
                subItemMap.put("campCode", "VILLAGER");
                subItemMap.put("description", "あなたは村人です。特別な能力はありません。");
                _subItemMapMap.put(村人.code(), Collections.unmodifiableMap(subItemMap));
            }
            {
                Map<String, Object> subItemMap = new HashMap<String, Object>();
                subItemMap.put("shortName", "お");
                subItemMap.put("order", "1002");
                subItemMap.put("campCode", "VILLAGER");
                subItemMap.put("description", "村人陣営の中で余った役職が割り当てられます。");
                _subItemMapMap.put(おまかせ村人陣営.code(), Collections.unmodifiableMap(subItemMap));
            }
            {
                Map<String, Object> subItemMap = new HashMap<String, Object>();
                subItemMap.put("shortName", "狼");
                subItemMap.put("order", "101");
                subItemMap.put("campCode", "WEREWOLF");
                subItemMap.put("description", "あなたは人狼です。人狼系役職とC国狂人同士にしか聞こえない会話が可能です。また、毎晩一人を襲撃することができます。");
                _subItemMapMap.put(人狼.code(), Collections.unmodifiableMap(subItemMap));
            }
            {
                Map<String, Object> subItemMap = new HashMap<String, Object>();
                subItemMap.put("shortName", "お");
                subItemMap.put("order", "1003");
                subItemMap.put("campCode", "VILLAGER");
                subItemMap.put("description", "人狼陣営の中で余った役職が割り当てられます。");
                _subItemMapMap.put(おまかせ人狼陣営.code(), Collections.unmodifiableMap(subItemMap));
            }
        }
        private String _code; private String _alias;
        private Skill(String code, String alias) { _code = code; _alias = alias; }
        public String code() { return _code; } public String alias() { return _alias; }
        public Set<String> sisterSet() { return Collections.emptySet(); }
        public Map<String, Object> subItemMap() { return _subItemMapMap.get(code()); }
        public ClassificationMeta meta() { return CDef.DefMeta.Skill; }
        public String shortName() {
            return (String)subItemMap().get("shortName");
        }
        public String order() {
            return (String)subItemMap().get("order");
        }
        public String campCode() {
            return (String)subItemMap().get("campCode");
        }
        public String description() {
            return (String)subItemMap().get("description");
        }
        /**
         * Is the classification in the group? <br>
         * 囁きを見られる <br>
         * The group elements:[人狼, C国狂人]
         * @return The determination, true or false.
         */
        public boolean isViewableWerewolfSay() { return 人狼.equals(this) || C国狂人.equals(this); }
        /**
         * Is the classification in the group? <br>
         * 囁き可能 <br>
         * The group elements:[人狼, C国狂人]
         * @return The determination, true or false.
         */
        public boolean isAvailableWerewolfSay() { return 人狼.equals(this) || C国狂人.equals(this); }
        /**
         * Is the classification in the group? <br>
         * 襲撃対象に選べない <br>
         * The group elements:[人狼]
         * @return The determination, true or false.
         */
        public boolean isNotSelectableAttack() { return 人狼.equals(this); }
        /**
         * Is the classification in the group? <br>
         * 占い結果が人狼になる <br>
         * The group elements:[人狼]
         * @return The determination, true or false.
         */
        public boolean isDivineResultWolf() { return 人狼.equals(this); }
        /**
         * Is the classification in the group? <br>
         * 霊能結果が人狼になる <br>
         * The group elements:[人狼]
         * @return The determination, true or false.
         */
        public boolean isPsychicResultWolf() { return 人狼.equals(this); }
        /**
         * Is the classification in the group? <br>
         * 襲撃能力を持つ <br>
         * The group elements:[人狼]
         * @return The determination, true or false.
         */
        public boolean isHasAttackAbility() { return 人狼.equals(this); }
        /**
         * Is the classification in the group? <br>
         * 占い能力を持つ <br>
         * The group elements:[占い師]
         * @return The determination, true or false.
         */
        public boolean isHasDivineAbility() { return 占い師.equals(this); }
        /**
         * Is the classification in the group? <br>
         * 護衛能力を持つ <br>
         * The group elements:[狩人]
         * @return The determination, true or false.
         */
        public boolean isHasGuardAbility() { return 狩人.equals(this); }
        /**
         * Is the classification in the group? <br>
         * 霊能能力を持つ <br>
         * The group elements:[霊能者]
         * @return The determination, true or false.
         */
        public boolean isHasPsychicAbility() { return 霊能者.equals(this); }
        /**
         * Is the classification in the group? <br>
         * 勝敗判定時狼にカウントする <br>
         * The group elements:[人狼]
         * @return The determination, true or false.
         */
        public boolean isCountWolf() { return 人狼.equals(this); }
        /**
         * Is the classification in the group? <br>
         * 勝敗判定時に人間としてカウントしない <br>
         * The group elements:[妖狐]
         * @return The determination, true or false.
         */
        public boolean isNoCount() { return 妖狐.equals(this); }
        /**
         * Is the classification in the group? <br>
         * おまかせ系 <br>
         * The group elements:[おまかせ, おまかせ村人陣営, おまかせ人狼陣営]
         * @return The determination, true or false.
         */
        public boolean isSomeoneSkill() { return おまかせ.equals(this) || おまかせ村人陣営.equals(this) || おまかせ人狼陣営.equals(this); }
        /**
         * Is the classification in the group? <br>
         * 共有系としてお互いに認知できる <br>
         * The group elements:[共有者]
         * @return The determination, true or false.
         */
        public boolean isRecognizableEachMason() { return 共有者.equals(this); }
        /**
         * Is the classification in the group? <br>
         * 人狼を認知できる <br>
         * The group elements:[狂信者]
         * @return The determination, true or false.
         */
        public boolean isRecognizableWolf() { return 狂信者.equals(this); }
        /**
         * Is the classification in the group? <br>
         * 妖狐を認知できる <br>
         * The group elements:[妖狐, 背徳者]
         * @return The determination, true or false.
         */
        public boolean isRecognizableFox() { return 妖狐.equals(this) || 背徳者.equals(this); }
        /**
         * Is the classification in the group? <br>
         * 襲撃耐性を持つ <br>
         * The group elements:[妖狐]
         * @return The determination, true or false.
         */
        public boolean isNoDeadByAttack() { return 妖狐.equals(this); }
        /**
         * Is the classification in the group? <br>
         * 占いにより死亡する <br>
         * The group elements:[妖狐]
         * @return The determination, true or false.
         */
        public boolean isDeadByDivine() { return 妖狐.equals(this); }
        /**
         * Is the classification in the group? <br>
         * 死亡時道連れにする <br>
         * The group elements:[猫又]
         * @return The determination, true or false.
         */
        public boolean isForceDoubleSuicide() { return 猫又.equals(this); }
        public boolean inGroup(String groupName) {
            if ("viewableWerewolfSay".equalsIgnoreCase(groupName)) { return isViewableWerewolfSay(); }
            if ("availableWerewolfSay".equalsIgnoreCase(groupName)) { return isAvailableWerewolfSay(); }
            if ("notSelectableAttack".equalsIgnoreCase(groupName)) { return isNotSelectableAttack(); }
            if ("divineResultWolf".equalsIgnoreCase(groupName)) { return isDivineResultWolf(); }
            if ("psychicResultWolf".equalsIgnoreCase(groupName)) { return isPsychicResultWolf(); }
            if ("hasAttackAbility".equalsIgnoreCase(groupName)) { return isHasAttackAbility(); }
            if ("hasDivineAbility".equalsIgnoreCase(groupName)) { return isHasDivineAbility(); }
            if ("hasGuardAbility".equalsIgnoreCase(groupName)) { return isHasGuardAbility(); }
            if ("hasPsychicAbility".equalsIgnoreCase(groupName)) { return isHasPsychicAbility(); }
            if ("countWolf".equalsIgnoreCase(groupName)) { return isCountWolf(); }
            if ("noCount".equalsIgnoreCase(groupName)) { return isNoCount(); }
            if ("someoneSkill".equalsIgnoreCase(groupName)) { return isSomeoneSkill(); }
            if ("recognizableEachMason".equalsIgnoreCase(groupName)) { return isRecognizableEachMason(); }
            if ("recognizableWolf".equalsIgnoreCase(groupName)) { return isRecognizableWolf(); }
            if ("recognizableFox".equalsIgnoreCase(groupName)) { return isRecognizableFox(); }
            if ("noDeadByAttack".equalsIgnoreCase(groupName)) { return isNoDeadByAttack(); }
            if ("deadByDivine".equalsIgnoreCase(groupName)) { return isDeadByDivine(); }
            if ("forceDoubleSuicide".equalsIgnoreCase(groupName)) { return isForceDoubleSuicide(); }
            return false;
        }
        /**
         * Get the classification of the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns empty)
         * @return The optional classification corresponding to the code. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<Skill> of(Object code) { return _slimmer.of(code); }
        /**
         * Find the classification by the name. (CaseInsensitive)
         * @param name The string of name, which is case-insensitive. (NotNull)
         * @return The optional classification corresponding to the name. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<Skill> byName(String name) { return _slimmer.byName(name); }
        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use of(code).</span>
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the code. (NullAllowed: if not found, returns null)
         */
        public static Skill codeOf(Object code) { return _slimmer.codeOf(code); }
        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use byName(name).</span>
         * @param name The string of name, which is case-sensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the name. (NullAllowed: if not found, returns null)
         * @deprecated use byName(name) instead.
         */
        @Deprecated
        public static Skill nameOf(String name) { return _slimmer.nameOf(name, nm -> valueOf(nm)); }
        /**
         * Get the list of all classification elements. (returns new copied list)
         * @return The snapshot list of all classification elements. (NotNull)
         */
        public static List<Skill> listAll() { return _slimmer.listAll(values()); }
        /**
         * Get the list of classification elements in the specified group. (returns new copied list)
         * @param groupName The string of group name, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the group. (NotNull)
         * @throws ClassificationNotFoundException When the group is not found.
         */
        public static List<Skill> listByGroup(String groupName) {
            if (groupName == null) { throw new IllegalArgumentException("The argument 'groupName' should not be null."); }
            if ("viewableWerewolfSay".equalsIgnoreCase(groupName)) { return listOfViewableWerewolfSay(); }
            if ("availableWerewolfSay".equalsIgnoreCase(groupName)) { return listOfAvailableWerewolfSay(); }
            if ("notSelectableAttack".equalsIgnoreCase(groupName)) { return listOfNotSelectableAttack(); }
            if ("divineResultWolf".equalsIgnoreCase(groupName)) { return listOfDivineResultWolf(); }
            if ("psychicResultWolf".equalsIgnoreCase(groupName)) { return listOfPsychicResultWolf(); }
            if ("hasAttackAbility".equalsIgnoreCase(groupName)) { return listOfHasAttackAbility(); }
            if ("hasDivineAbility".equalsIgnoreCase(groupName)) { return listOfHasDivineAbility(); }
            if ("hasGuardAbility".equalsIgnoreCase(groupName)) { return listOfHasGuardAbility(); }
            if ("hasPsychicAbility".equalsIgnoreCase(groupName)) { return listOfHasPsychicAbility(); }
            if ("countWolf".equalsIgnoreCase(groupName)) { return listOfCountWolf(); }
            if ("noCount".equalsIgnoreCase(groupName)) { return listOfNoCount(); }
            if ("someoneSkill".equalsIgnoreCase(groupName)) { return listOfSomeoneSkill(); }
            if ("recognizableEachMason".equalsIgnoreCase(groupName)) { return listOfRecognizableEachMason(); }
            if ("recognizableWolf".equalsIgnoreCase(groupName)) { return listOfRecognizableWolf(); }
            if ("recognizableFox".equalsIgnoreCase(groupName)) { return listOfRecognizableFox(); }
            if ("noDeadByAttack".equalsIgnoreCase(groupName)) { return listOfNoDeadByAttack(); }
            if ("deadByDivine".equalsIgnoreCase(groupName)) { return listOfDeadByDivine(); }
            if ("forceDoubleSuicide".equalsIgnoreCase(groupName)) { return listOfForceDoubleSuicide(); }
            throw new ClassificationNotFoundException("Unknown classification group: Skill." + groupName);
        }
        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use e.g. Stream API with of().</span>
         * @param codeList The list of plain code, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the code list. (NotNull, EmptyAllowed: when empty specified)
         * @deprecated use e.g. Stream API with of() instead.
         */
        @Deprecated
        public static List<Skill> listOf(Collection<String> codeList) { return _slimmer.listOf(codeList); }
        /**
         * Get the list of group classification elements. (returns new copied list) <br>
         * 囁きを見られる <br>
         * The group elements:[人狼, C国狂人]
         * @return The snapshot list of classification elements in the group. (NotNull)
         */
        public static List<Skill> listOfViewableWerewolfSay() {
            return new ArrayList<>(Arrays.asList(人狼, C国狂人));
        }
        /**
         * Get the list of group classification elements. (returns new copied list) <br>
         * 囁き可能 <br>
         * The group elements:[人狼, C国狂人]
         * @return The snapshot list of classification elements in the group. (NotNull)
         */
        public static List<Skill> listOfAvailableWerewolfSay() {
            return new ArrayList<>(Arrays.asList(人狼, C国狂人));
        }
        /**
         * Get the list of group classification elements. (returns new copied list) <br>
         * 襲撃対象に選べない <br>
         * The group elements:[人狼]
         * @return The snapshot list of classification elements in the group. (NotNull)
         */
        public static List<Skill> listOfNotSelectableAttack() {
            return new ArrayList<>(Arrays.asList(人狼));
        }
        /**
         * Get the list of group classification elements. (returns new copied list) <br>
         * 占い結果が人狼になる <br>
         * The group elements:[人狼]
         * @return The snapshot list of classification elements in the group. (NotNull)
         */
        public static List<Skill> listOfDivineResultWolf() {
            return new ArrayList<>(Arrays.asList(人狼));
        }
        /**
         * Get the list of group classification elements. (returns new copied list) <br>
         * 霊能結果が人狼になる <br>
         * The group elements:[人狼]
         * @return The snapshot list of classification elements in the group. (NotNull)
         */
        public static List<Skill> listOfPsychicResultWolf() {
            return new ArrayList<>(Arrays.asList(人狼));
        }
        /**
         * Get the list of group classification elements. (returns new copied list) <br>
         * 襲撃能力を持つ <br>
         * The group elements:[人狼]
         * @return The snapshot list of classification elements in the group. (NotNull)
         */
        public static List<Skill> listOfHasAttackAbility() {
            return new ArrayList<>(Arrays.asList(人狼));
        }
        /**
         * Get the list of group classification elements. (returns new copied list) <br>
         * 占い能力を持つ <br>
         * The group elements:[占い師]
         * @return The snapshot list of classification elements in the group. (NotNull)
         */
        public static List<Skill> listOfHasDivineAbility() {
            return new ArrayList<>(Arrays.asList(占い師));
        }
        /**
         * Get the list of group classification elements. (returns new copied list) <br>
         * 護衛能力を持つ <br>
         * The group elements:[狩人]
         * @return The snapshot list of classification elements in the group. (NotNull)
         */
        public static List<Skill> listOfHasGuardAbility() {
            return new ArrayList<>(Arrays.asList(狩人));
        }
        /**
         * Get the list of group classification elements. (returns new copied list) <br>
         * 霊能能力を持つ <br>
         * The group elements:[霊能者]
         * @return The snapshot list of classification elements in the group. (NotNull)
         */
        public static List<Skill> listOfHasPsychicAbility() {
            return new ArrayList<>(Arrays.asList(霊能者));
        }
        /**
         * Get the list of group classification elements. (returns new copied list) <br>
         * 勝敗判定時狼にカウントする <br>
         * The group elements:[人狼]
         * @return The snapshot list of classification elements in the group. (NotNull)
         */
        public static List<Skill> listOfCountWolf() {
            return new ArrayList<>(Arrays.asList(人狼));
        }
        /**
         * Get the list of group classification elements. (returns new copied list) <br>
         * 勝敗判定時に人間としてカウントしない <br>
         * The group elements:[妖狐]
         * @return The snapshot list of classification elements in the group. (NotNull)
         */
        public static List<Skill> listOfNoCount() {
            return new ArrayList<>(Arrays.asList(妖狐));
        }
        /**
         * Get the list of group classification elements. (returns new copied list) <br>
         * おまかせ系 <br>
         * The group elements:[おまかせ, おまかせ村人陣営, おまかせ人狼陣営]
         * @return The snapshot list of classification elements in the group. (NotNull)
         */
        public static List<Skill> listOfSomeoneSkill() {
            return new ArrayList<>(Arrays.asList(おまかせ, おまかせ村人陣営, おまかせ人狼陣営));
        }
        /**
         * Get the list of group classification elements. (returns new copied list) <br>
         * 共有系としてお互いに認知できる <br>
         * The group elements:[共有者]
         * @return The snapshot list of classification elements in the group. (NotNull)
         */
        public static List<Skill> listOfRecognizableEachMason() {
            return new ArrayList<>(Arrays.asList(共有者));
        }
        /**
         * Get the list of group classification elements. (returns new copied list) <br>
         * 人狼を認知できる <br>
         * The group elements:[狂信者]
         * @return The snapshot list of classification elements in the group. (NotNull)
         */
        public static List<Skill> listOfRecognizableWolf() {
            return new ArrayList<>(Arrays.asList(狂信者));
        }
        /**
         * Get the list of group classification elements. (returns new copied list) <br>
         * 妖狐を認知できる <br>
         * The group elements:[妖狐, 背徳者]
         * @return The snapshot list of classification elements in the group. (NotNull)
         */
        public static List<Skill> listOfRecognizableFox() {
            return new ArrayList<>(Arrays.asList(妖狐, 背徳者));
        }
        /**
         * Get the list of group classification elements. (returns new copied list) <br>
         * 襲撃耐性を持つ <br>
         * The group elements:[妖狐]
         * @return The snapshot list of classification elements in the group. (NotNull)
         */
        public static List<Skill> listOfNoDeadByAttack() {
            return new ArrayList<>(Arrays.asList(妖狐));
        }
        /**
         * Get the list of group classification elements. (returns new copied list) <br>
         * 占いにより死亡する <br>
         * The group elements:[妖狐]
         * @return The snapshot list of classification elements in the group. (NotNull)
         */
        public static List<Skill> listOfDeadByDivine() {
            return new ArrayList<>(Arrays.asList(妖狐));
        }
        /**
         * Get the list of group classification elements. (returns new copied list) <br>
         * 死亡時道連れにする <br>
         * The group elements:[猫又]
         * @return The snapshot list of classification elements in the group. (NotNull)
         */
        public static List<Skill> listOfForceDoubleSuicide() {
            return new ArrayList<>(Arrays.asList(猫又));
        }
        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use listByGroup(groupName).</span>
         * @param groupName The string of group name, which is case-sensitive. (NullAllowed: if null, returns empty list)
         * @return The snapshot list of classification elements in the group. (NotNull, EmptyAllowed: if the group is not found)
         * @deprecated use listByGroup(groupName) instead.
         */
        @Deprecated
        public static List<Skill> groupOf(String groupName) {
            if ("viewableWerewolfSay".equalsIgnoreCase(groupName)) { return listOfViewableWerewolfSay(); }
            if ("availableWerewolfSay".equalsIgnoreCase(groupName)) { return listOfAvailableWerewolfSay(); }
            if ("notSelectableAttack".equalsIgnoreCase(groupName)) { return listOfNotSelectableAttack(); }
            if ("divineResultWolf".equalsIgnoreCase(groupName)) { return listOfDivineResultWolf(); }
            if ("psychicResultWolf".equalsIgnoreCase(groupName)) { return listOfPsychicResultWolf(); }
            if ("hasAttackAbility".equalsIgnoreCase(groupName)) { return listOfHasAttackAbility(); }
            if ("hasDivineAbility".equalsIgnoreCase(groupName)) { return listOfHasDivineAbility(); }
            if ("hasGuardAbility".equalsIgnoreCase(groupName)) { return listOfHasGuardAbility(); }
            if ("hasPsychicAbility".equalsIgnoreCase(groupName)) { return listOfHasPsychicAbility(); }
            if ("countWolf".equalsIgnoreCase(groupName)) { return listOfCountWolf(); }
            if ("noCount".equalsIgnoreCase(groupName)) { return listOfNoCount(); }
            if ("someoneSkill".equalsIgnoreCase(groupName)) { return listOfSomeoneSkill(); }
            if ("recognizableEachMason".equalsIgnoreCase(groupName)) { return listOfRecognizableEachMason(); }
            if ("recognizableWolf".equalsIgnoreCase(groupName)) { return listOfRecognizableWolf(); }
            if ("recognizableFox".equalsIgnoreCase(groupName)) { return listOfRecognizableFox(); }
            if ("noDeadByAttack".equalsIgnoreCase(groupName)) { return listOfNoDeadByAttack(); }
            if ("deadByDivine".equalsIgnoreCase(groupName)) { return listOfDeadByDivine(); }
            if ("forceDoubleSuicide".equalsIgnoreCase(groupName)) { return listOfForceDoubleSuicide(); }
            return new ArrayList<>();
        }
        @Override public String toString() { return code(); }
    }

    /**
     * メッセージ種別
     */
    public enum MessageType implements CDef {
        /** 村建て発言 */
        村建て発言("CREATOR_SAY", "村建て発言"),
        /** 死者の呻き */
        死者の呻き("GRAVE_SAY", "死者の呻き"),
        /** 共鳴発言 */
        共鳴発言("MASON_SAY", "共鳴発言"),
        /** 独り言 */
        独り言("MONOLOGUE_SAY", "独り言"),
        /** 通常発言 */
        通常発言("NORMAL_SAY", "通常発言"),
        /** 参加者一覧 */
        参加者一覧("PARTICIPANTS", "参加者一覧"),
        /** 狂信者人狼確認メッセージ */
        狂信者人狼確認メッセージ("PRIVATE_FANATIC", "狂信者人狼確認メッセージ"),
        /** 妖狐メッセージ */
        妖狐メッセージ("PRIVATE_FOX", "妖狐メッセージ"),
        /** 共有相互確認メッセージ */
        共有相互確認メッセージ("PRIVATE_MASON", "共有相互確認メッセージ"),
        /** 白黒霊視結果 */
        白黒霊視結果("PRIVATE_PSYCHIC", "白黒霊視結果"),
        /** 白黒占い結果 */
        白黒占い結果("PRIVATE_SEER", "白黒占い結果"),
        /** 非公開システムメッセージ */
        非公開システムメッセージ("PRIVATE_SYSTEM", "非公開システムメッセージ"),
        /** 襲撃結果 */
        襲撃結果("PRIVATE_WEREWOLF", "襲撃結果"),
        /** 公開システムメッセージ */
        公開システムメッセージ("PUBLIC_SYSTEM", "公開システムメッセージ"),
        /** 秘話 */
        秘話("SECRET_SAY", "秘話"),
        /** 見学発言 */
        見学発言("SPECTATE_SAY", "見学発言"),
        /** 人狼の囁き */
        人狼の囁き("WEREWOLF_SAY", "人狼の囁き");
        private static ZzzoneSlimmer<MessageType> _slimmer = new ZzzoneSlimmer<>(MessageType.class, values());
        private String _code; private String _alias;
        private MessageType(String code, String alias) { _code = code; _alias = alias; }
        public String code() { return _code; } public String alias() { return _alias; }
        public Set<String> sisterSet() { return Collections.emptySet(); }
        public Map<String, Object> subItemMap() { return Collections.emptyMap(); }
        public ClassificationMeta meta() { return CDef.DefMeta.MessageType; }
        public boolean inGroup(String groupName) { return false; }
        /**
         * Get the classification of the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns empty)
         * @return The optional classification corresponding to the code. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<MessageType> of(Object code) { return _slimmer.of(code); }
        /**
         * Find the classification by the name. (CaseInsensitive)
         * @param name The string of name, which is case-insensitive. (NotNull)
         * @return The optional classification corresponding to the name. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<MessageType> byName(String name) { return _slimmer.byName(name); }
        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use of(code).</span>
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the code. (NullAllowed: if not found, returns null)
         */
        public static MessageType codeOf(Object code) { return _slimmer.codeOf(code); }
        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use byName(name).</span>
         * @param name The string of name, which is case-sensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the name. (NullAllowed: if not found, returns null)
         * @deprecated use byName(name) instead.
         */
        @Deprecated
        public static MessageType nameOf(String name) { return _slimmer.nameOf(name, nm -> valueOf(nm)); }
        /**
         * Get the list of all classification elements. (returns new copied list)
         * @return The snapshot list of all classification elements. (NotNull)
         */
        public static List<MessageType> listAll() { return _slimmer.listAll(values()); }
        /**
         * Get the list of classification elements in the specified group. (returns new copied list)
         * @param groupName The string of group name, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the group. (NotNull)
         * @throws ClassificationNotFoundException When the group is not found.
         */
        public static List<MessageType> listByGroup(String groupName) {
            if (groupName == null) { throw new IllegalArgumentException("The argument 'groupName' should not be null."); }
            throw new ClassificationNotFoundException("Unknown classification group: MessageType." + groupName);
        }
        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use e.g. Stream API with of().</span>
         * @param codeList The list of plain code, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the code list. (NotNull, EmptyAllowed: when empty specified)
         * @deprecated use e.g. Stream API with of() instead.
         */
        @Deprecated
        public static List<MessageType> listOf(Collection<String> codeList) { return _slimmer.listOf(codeList); }
        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use listByGroup(groupName).</span>
         * @param groupName The string of group name, which is case-sensitive. (NullAllowed: if null, returns empty list)
         * @return The snapshot list of classification elements in the group. (NotNull, EmptyAllowed: if the group is not found)
         * @deprecated use listByGroup(groupName) instead.
         */
        @Deprecated
        public static List<MessageType> groupOf(String groupName) { return new ArrayList<>(); }
        @Override public String toString() { return code(); }
    }

    /**
     * 死亡理由
     */
    public enum DeadReason implements CDef {
        /** 襲撃 */
        襲撃("ATTACK", "襲撃"),
        /** 呪殺 */
        呪殺("DIVINED", "呪殺"),
        /** 処刑 */
        処刑("EXECUTE", "処刑"),
        /** 突然 */
        突然("SUDDEN", "突然"),
        /** 後追 */
        後追("SUICIDE", "後追");
        private static ZzzoneSlimmer<DeadReason> _slimmer = new ZzzoneSlimmer<>(DeadReason.class, values());
        private String _code; private String _alias;
        private DeadReason(String code, String alias) { _code = code; _alias = alias; }
        public String code() { return _code; } public String alias() { return _alias; }
        public Set<String> sisterSet() { return Collections.emptySet(); }
        public Map<String, Object> subItemMap() { return Collections.emptyMap(); }
        public ClassificationMeta meta() { return CDef.DefMeta.DeadReason; }
        /**
         * Is the classification in the group? <br>
         * 無惨な死 <br>
         * The group elements:[襲撃, 呪殺]
         * @return The determination, true or false.
         */
        public boolean isMiserableDeath() { return 襲撃.equals(this) || 呪殺.equals(this); }
        /**
         * Is the classification in the group? <br>
         * 霊能判定可能な死因 <br>
         * The group elements:[処刑, 突然]
         * @return The determination, true or false.
         */
        public boolean isPsychicableDeath() { return 処刑.equals(this) || 突然.equals(this); }
        public boolean inGroup(String groupName) {
            if ("miserableDeath".equalsIgnoreCase(groupName)) { return isMiserableDeath(); }
            if ("psychicableDeath".equalsIgnoreCase(groupName)) { return isPsychicableDeath(); }
            return false;
        }
        /**
         * Get the classification of the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns empty)
         * @return The optional classification corresponding to the code. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<DeadReason> of(Object code) { return _slimmer.of(code); }
        /**
         * Find the classification by the name. (CaseInsensitive)
         * @param name The string of name, which is case-insensitive. (NotNull)
         * @return The optional classification corresponding to the name. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<DeadReason> byName(String name) { return _slimmer.byName(name); }
        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use of(code).</span>
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the code. (NullAllowed: if not found, returns null)
         */
        public static DeadReason codeOf(Object code) { return _slimmer.codeOf(code); }
        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use byName(name).</span>
         * @param name The string of name, which is case-sensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the name. (NullAllowed: if not found, returns null)
         * @deprecated use byName(name) instead.
         */
        @Deprecated
        public static DeadReason nameOf(String name) { return _slimmer.nameOf(name, nm -> valueOf(nm)); }
        /**
         * Get the list of all classification elements. (returns new copied list)
         * @return The snapshot list of all classification elements. (NotNull)
         */
        public static List<DeadReason> listAll() { return _slimmer.listAll(values()); }
        /**
         * Get the list of classification elements in the specified group. (returns new copied list)
         * @param groupName The string of group name, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the group. (NotNull)
         * @throws ClassificationNotFoundException When the group is not found.
         */
        public static List<DeadReason> listByGroup(String groupName) {
            if (groupName == null) { throw new IllegalArgumentException("The argument 'groupName' should not be null."); }
            if ("miserableDeath".equalsIgnoreCase(groupName)) { return listOfMiserableDeath(); }
            if ("psychicableDeath".equalsIgnoreCase(groupName)) { return listOfPsychicableDeath(); }
            throw new ClassificationNotFoundException("Unknown classification group: DeadReason." + groupName);
        }
        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use e.g. Stream API with of().</span>
         * @param codeList The list of plain code, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the code list. (NotNull, EmptyAllowed: when empty specified)
         * @deprecated use e.g. Stream API with of() instead.
         */
        @Deprecated
        public static List<DeadReason> listOf(Collection<String> codeList) { return _slimmer.listOf(codeList); }
        /**
         * Get the list of group classification elements. (returns new copied list) <br>
         * 無惨な死 <br>
         * The group elements:[襲撃, 呪殺]
         * @return The snapshot list of classification elements in the group. (NotNull)
         */
        public static List<DeadReason> listOfMiserableDeath() {
            return new ArrayList<>(Arrays.asList(襲撃, 呪殺));
        }
        /**
         * Get the list of group classification elements. (returns new copied list) <br>
         * 霊能判定可能な死因 <br>
         * The group elements:[処刑, 突然]
         * @return The snapshot list of classification elements in the group. (NotNull)
         */
        public static List<DeadReason> listOfPsychicableDeath() {
            return new ArrayList<>(Arrays.asList(処刑, 突然));
        }
        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use listByGroup(groupName).</span>
         * @param groupName The string of group name, which is case-sensitive. (NullAllowed: if null, returns empty list)
         * @return The snapshot list of classification elements in the group. (NotNull, EmptyAllowed: if the group is not found)
         * @deprecated use listByGroup(groupName) instead.
         */
        @Deprecated
        public static List<DeadReason> groupOf(String groupName) {
            if ("miserableDeath".equalsIgnoreCase(groupName)) { return listOfMiserableDeath(); }
            if ("psychicableDeath".equalsIgnoreCase(groupName)) { return listOfPsychicableDeath(); }
            return new ArrayList<>();
        }
        @Override public String toString() { return code(); }
    }

    /**
     * 能力種別
     */
    public enum AbilityType implements CDef {
        /** 襲撃 */
        襲撃("ATTACK", "襲撃"),
        /** 占い */
        占い("DIVINE", "占い"),
        /** 護衛 */
        護衛("GUARD", "護衛");
        private static ZzzoneSlimmer<AbilityType> _slimmer = new ZzzoneSlimmer<>(AbilityType.class, values());
        private String _code; private String _alias;
        private AbilityType(String code, String alias) { _code = code; _alias = alias; }
        public String code() { return _code; } public String alias() { return _alias; }
        public Set<String> sisterSet() { return Collections.emptySet(); }
        public Map<String, Object> subItemMap() { return Collections.emptyMap(); }
        public ClassificationMeta meta() { return CDef.DefMeta.AbilityType; }
        public boolean inGroup(String groupName) { return false; }
        /**
         * Get the classification of the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns empty)
         * @return The optional classification corresponding to the code. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<AbilityType> of(Object code) { return _slimmer.of(code); }
        /**
         * Find the classification by the name. (CaseInsensitive)
         * @param name The string of name, which is case-insensitive. (NotNull)
         * @return The optional classification corresponding to the name. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<AbilityType> byName(String name) { return _slimmer.byName(name); }
        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use of(code).</span>
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the code. (NullAllowed: if not found, returns null)
         */
        public static AbilityType codeOf(Object code) { return _slimmer.codeOf(code); }
        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use byName(name).</span>
         * @param name The string of name, which is case-sensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the name. (NullAllowed: if not found, returns null)
         * @deprecated use byName(name) instead.
         */
        @Deprecated
        public static AbilityType nameOf(String name) { return _slimmer.nameOf(name, nm -> valueOf(nm)); }
        /**
         * Get the list of all classification elements. (returns new copied list)
         * @return The snapshot list of all classification elements. (NotNull)
         */
        public static List<AbilityType> listAll() { return _slimmer.listAll(values()); }
        /**
         * Get the list of classification elements in the specified group. (returns new copied list)
         * @param groupName The string of group name, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the group. (NotNull)
         * @throws ClassificationNotFoundException When the group is not found.
         */
        public static List<AbilityType> listByGroup(String groupName) {
            if (groupName == null) { throw new IllegalArgumentException("The argument 'groupName' should not be null."); }
            throw new ClassificationNotFoundException("Unknown classification group: AbilityType." + groupName);
        }
        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use e.g. Stream API with of().</span>
         * @param codeList The list of plain code, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the code list. (NotNull, EmptyAllowed: when empty specified)
         * @deprecated use e.g. Stream API with of() instead.
         */
        @Deprecated
        public static List<AbilityType> listOf(Collection<String> codeList) { return _slimmer.listOf(codeList); }
        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use listByGroup(groupName).</span>
         * @param groupName The string of group name, which is case-sensitive. (NullAllowed: if null, returns empty list)
         * @return The snapshot list of classification elements in the group. (NotNull, EmptyAllowed: if the group is not found)
         * @deprecated use listByGroup(groupName) instead.
         */
        @Deprecated
        public static List<AbilityType> groupOf(String groupName) { return new ArrayList<>(); }
        @Override public String toString() { return code(); }
    }

    /**
     * 表情種別
     */
    public enum FaceType implements CDef {
        /** 墓下 */
        墓下("GRAVE", "墓下"),
        /** 恋人 */
        恋人("LOVER", "恋人"),
        /** 共鳴 */
        共鳴("MASON", "共鳴"),
        /** 独り言 */
        独り言("MONOLOGUE", "独り言"),
        /** 通常 */
        通常("NORMAL", "通常"),
        /** 秘話 */
        秘話("SECRET", "秘話"),
        /** 囁き */
        囁き("WEREWOLF", "囁き");
        private static ZzzoneSlimmer<FaceType> _slimmer = new ZzzoneSlimmer<>(FaceType.class, values());
        private String _code; private String _alias;
        private FaceType(String code, String alias) { _code = code; _alias = alias; }
        public String code() { return _code; } public String alias() { return _alias; }
        public Set<String> sisterSet() { return Collections.emptySet(); }
        public Map<String, Object> subItemMap() { return Collections.emptyMap(); }
        public ClassificationMeta meta() { return CDef.DefMeta.FaceType; }
        public boolean inGroup(String groupName) { return false; }
        /**
         * Get the classification of the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns empty)
         * @return The optional classification corresponding to the code. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<FaceType> of(Object code) { return _slimmer.of(code); }
        /**
         * Find the classification by the name. (CaseInsensitive)
         * @param name The string of name, which is case-insensitive. (NotNull)
         * @return The optional classification corresponding to the name. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<FaceType> byName(String name) { return _slimmer.byName(name); }
        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use of(code).</span>
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the code. (NullAllowed: if not found, returns null)
         */
        public static FaceType codeOf(Object code) { return _slimmer.codeOf(code); }
        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use byName(name).</span>
         * @param name The string of name, which is case-sensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the name. (NullAllowed: if not found, returns null)
         * @deprecated use byName(name) instead.
         */
        @Deprecated
        public static FaceType nameOf(String name) { return _slimmer.nameOf(name, nm -> valueOf(nm)); }
        /**
         * Get the list of all classification elements. (returns new copied list)
         * @return The snapshot list of all classification elements. (NotNull)
         */
        public static List<FaceType> listAll() { return _slimmer.listAll(values()); }
        /**
         * Get the list of classification elements in the specified group. (returns new copied list)
         * @param groupName The string of group name, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the group. (NotNull)
         * @throws ClassificationNotFoundException When the group is not found.
         */
        public static List<FaceType> listByGroup(String groupName) {
            if (groupName == null) { throw new IllegalArgumentException("The argument 'groupName' should not be null."); }
            throw new ClassificationNotFoundException("Unknown classification group: FaceType." + groupName);
        }
        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use e.g. Stream API with of().</span>
         * @param codeList The list of plain code, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the code list. (NotNull, EmptyAllowed: when empty specified)
         * @deprecated use e.g. Stream API with of() instead.
         */
        @Deprecated
        public static List<FaceType> listOf(Collection<String> codeList) { return _slimmer.listOf(codeList); }
        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use listByGroup(groupName).</span>
         * @param groupName The string of group name, which is case-sensitive. (NullAllowed: if null, returns empty list)
         * @return The snapshot list of classification elements in the group. (NotNull, EmptyAllowed: if the group is not found)
         * @deprecated use listByGroup(groupName) instead.
         */
        @Deprecated
        public static List<FaceType> groupOf(String groupName) { return new ArrayList<>(); }
        @Override public String toString() { return code(); }
    }

    /**
     * 村設定項目
     */
    public enum VillageSettingItem implements CDef {
        /** キャラクターグループID */
        キャラクターグループid("character_group_id", "キャラクターグループID"),
        /** 更新間隔秒 */
        更新間隔秒("day_change_interval_seconds", "更新間隔秒"),
        /** ダミーキャラID */
        ダミーキャラid("dummy_chara_id", "ダミーキャラID"),
        /** 自動生成村か */
        自動生成村か("is_auto_generated", "自動生成村か"),
        /** コミット可能か */
        コミット可能か("is_available_commit", "コミット可能か"),
        /** 役欠けありか */
        役欠けありか("is_available_dummy_skill", "役欠けありか"),
        /** 役職希望可能か */
        役職希望可能か("is_available_skill_request", "役職希望可能か"),
        /** 見学可能か */
        見学可能か("is_available_spectate", "見学可能か"),
        /** 突然死ありか */
        突然死ありか("is_available_suddenly_death", "突然死ありか"),
        /** 初心者村か */
        初心者村か("is_for_beginner", "初心者村か"),
        /** 墓下役職公開ありか */
        墓下役職公開ありか("is_open_skill_in_grave", "墓下役職公開ありか"),
        /** 記名投票か */
        記名投票か("is_open_vote", "記名投票か"),
        /** 墓下見学発言を生存者が見られるか */
        墓下見学発言を生存者が見られるか("is_visible_grave_message", "墓下見学発言を生存者が見られるか"),
        /** 入村パスワード */
        入村パスワード("join_password", "入村パスワード"),
        /** 構成 */
        構成("organize", "構成"),
        /** 最大人数 */
        最大人数("person_max", "最大人数"),
        /** 最低人数 */
        最低人数("person_min", "最低人数"),
        /** 沈黙時間 */
        沈黙時間("silent_hours", "沈黙時間"),
        /** 開始予定日時 */
        開始予定日時("start_datetime", "開始予定日時"),
        /** 期間形式 */
        期間形式("term_type", "期間形式");
        private static ZzzoneSlimmer<VillageSettingItem> _slimmer = new ZzzoneSlimmer<>(VillageSettingItem.class, values());
        private String _code; private String _alias;
        private VillageSettingItem(String code, String alias) { _code = code; _alias = alias; }
        public String code() { return _code; } public String alias() { return _alias; }
        public Set<String> sisterSet() { return Collections.emptySet(); }
        public Map<String, Object> subItemMap() { return Collections.emptyMap(); }
        public ClassificationMeta meta() { return CDef.DefMeta.VillageSettingItem; }
        public boolean inGroup(String groupName) { return false; }
        /**
         * Get the classification of the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns empty)
         * @return The optional classification corresponding to the code. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<VillageSettingItem> of(Object code) { return _slimmer.of(code); }
        /**
         * Find the classification by the name. (CaseInsensitive)
         * @param name The string of name, which is case-insensitive. (NotNull)
         * @return The optional classification corresponding to the name. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<VillageSettingItem> byName(String name) { return _slimmer.byName(name); }
        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use of(code).</span>
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the code. (NullAllowed: if not found, returns null)
         */
        public static VillageSettingItem codeOf(Object code) { return _slimmer.codeOf(code); }
        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use byName(name).</span>
         * @param name The string of name, which is case-sensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the name. (NullAllowed: if not found, returns null)
         * @deprecated use byName(name) instead.
         */
        @Deprecated
        public static VillageSettingItem nameOf(String name) { return _slimmer.nameOf(name, nm -> valueOf(nm)); }
        /**
         * Get the list of all classification elements. (returns new copied list)
         * @return The snapshot list of all classification elements. (NotNull)
         */
        public static List<VillageSettingItem> listAll() { return _slimmer.listAll(values()); }
        /**
         * Get the list of classification elements in the specified group. (returns new copied list)
         * @param groupName The string of group name, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the group. (NotNull)
         * @throws ClassificationNotFoundException When the group is not found.
         */
        public static List<VillageSettingItem> listByGroup(String groupName) {
            if (groupName == null) { throw new IllegalArgumentException("The argument 'groupName' should not be null."); }
            throw new ClassificationNotFoundException("Unknown classification group: VillageSettingItem." + groupName);
        }
        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use e.g. Stream API with of().</span>
         * @param codeList The list of plain code, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the code list. (NotNull, EmptyAllowed: when empty specified)
         * @deprecated use e.g. Stream API with of() instead.
         */
        @Deprecated
        public static List<VillageSettingItem> listOf(Collection<String> codeList) { return _slimmer.listOf(codeList); }
        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use listByGroup(groupName).</span>
         * @param groupName The string of group name, which is case-sensitive. (NullAllowed: if null, returns empty list)
         * @return The snapshot list of classification elements in the group. (NotNull, EmptyAllowed: if the group is not found)
         * @deprecated use listByGroup(groupName) instead.
         */
        @Deprecated
        public static List<VillageSettingItem> groupOf(String groupName) { return new ArrayList<>(); }
        @Override public String toString() { return code(); }
    }

    /**
     * 昼夜
     */
    public enum Noonnight implements CDef {
        /** 夜 */
        夜("NIGHT", "夜"),
        /** 昼 */
        昼("NOON", "昼");
        private static ZzzoneSlimmer<Noonnight> _slimmer = new ZzzoneSlimmer<>(Noonnight.class, values());
        private String _code; private String _alias;
        private Noonnight(String code, String alias) { _code = code; _alias = alias; }
        public String code() { return _code; } public String alias() { return _alias; }
        public Set<String> sisterSet() { return Collections.emptySet(); }
        public Map<String, Object> subItemMap() { return Collections.emptyMap(); }
        public ClassificationMeta meta() { return CDef.DefMeta.Noonnight; }
        public boolean inGroup(String groupName) { return false; }
        /**
         * Get the classification of the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns empty)
         * @return The optional classification corresponding to the code. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<Noonnight> of(Object code) { return _slimmer.of(code); }
        /**
         * Find the classification by the name. (CaseInsensitive)
         * @param name The string of name, which is case-insensitive. (NotNull)
         * @return The optional classification corresponding to the name. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<Noonnight> byName(String name) { return _slimmer.byName(name); }
        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use of(code).</span>
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the code. (NullAllowed: if not found, returns null)
         */
        public static Noonnight codeOf(Object code) { return _slimmer.codeOf(code); }
        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use byName(name).</span>
         * @param name The string of name, which is case-sensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the name. (NullAllowed: if not found, returns null)
         * @deprecated use byName(name) instead.
         */
        @Deprecated
        public static Noonnight nameOf(String name) { return _slimmer.nameOf(name, nm -> valueOf(nm)); }
        /**
         * Get the list of all classification elements. (returns new copied list)
         * @return The snapshot list of all classification elements. (NotNull)
         */
        public static List<Noonnight> listAll() { return _slimmer.listAll(values()); }
        /**
         * Get the list of classification elements in the specified group. (returns new copied list)
         * @param groupName The string of group name, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the group. (NotNull)
         * @throws ClassificationNotFoundException When the group is not found.
         */
        public static List<Noonnight> listByGroup(String groupName) {
            if (groupName == null) { throw new IllegalArgumentException("The argument 'groupName' should not be null."); }
            throw new ClassificationNotFoundException("Unknown classification group: Noonnight." + groupName);
        }
        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use e.g. Stream API with of().</span>
         * @param codeList The list of plain code, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the code list. (NotNull, EmptyAllowed: when empty specified)
         * @deprecated use e.g. Stream API with of() instead.
         */
        @Deprecated
        public static List<Noonnight> listOf(Collection<String> codeList) { return _slimmer.listOf(codeList); }
        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use listByGroup(groupName).</span>
         * @param groupName The string of group name, which is case-sensitive. (NullAllowed: if null, returns empty list)
         * @return The snapshot list of classification elements in the group. (NotNull, EmptyAllowed: if the group is not found)
         * @deprecated use listByGroup(groupName) instead.
         */
        @Deprecated
        public static List<Noonnight> groupOf(String groupName) { return new ArrayList<>(); }
        @Override public String toString() { return code(); }
    }

    /**
     * 期間
     */
    public enum Term implements CDef {
        /** 長期: 長期人狼 */
        長期("LONG", "長期"),
        /** 短期: 短期人狼 */
        短期("SHORT", "短期");
        private static ZzzoneSlimmer<Term> _slimmer = new ZzzoneSlimmer<>(Term.class, values());
        private String _code; private String _alias;
        private Term(String code, String alias) { _code = code; _alias = alias; }
        public String code() { return _code; } public String alias() { return _alias; }
        public Set<String> sisterSet() { return Collections.emptySet(); }
        public Map<String, Object> subItemMap() { return Collections.emptyMap(); }
        public ClassificationMeta meta() { return CDef.DefMeta.Term; }
        public boolean inGroup(String groupName) { return false; }
        /**
         * Get the classification of the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns empty)
         * @return The optional classification corresponding to the code. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<Term> of(Object code) { return _slimmer.of(code); }
        /**
         * Find the classification by the name. (CaseInsensitive)
         * @param name The string of name, which is case-insensitive. (NotNull)
         * @return The optional classification corresponding to the name. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<Term> byName(String name) { return _slimmer.byName(name); }
        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use of(code).</span>
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the code. (NullAllowed: if not found, returns null)
         */
        public static Term codeOf(Object code) { return _slimmer.codeOf(code); }
        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use byName(name).</span>
         * @param name The string of name, which is case-sensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the name. (NullAllowed: if not found, returns null)
         * @deprecated use byName(name) instead.
         */
        @Deprecated
        public static Term nameOf(String name) { return _slimmer.nameOf(name, nm -> valueOf(nm)); }
        /**
         * Get the list of all classification elements. (returns new copied list)
         * @return The snapshot list of all classification elements. (NotNull)
         */
        public static List<Term> listAll() { return _slimmer.listAll(values()); }
        /**
         * Get the list of classification elements in the specified group. (returns new copied list)
         * @param groupName The string of group name, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the group. (NotNull)
         * @throws ClassificationNotFoundException When the group is not found.
         */
        public static List<Term> listByGroup(String groupName) {
            if (groupName == null) { throw new IllegalArgumentException("The argument 'groupName' should not be null."); }
            throw new ClassificationNotFoundException("Unknown classification group: Term." + groupName);
        }
        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use e.g. Stream API with of().</span>
         * @param codeList The list of plain code, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the code list. (NotNull, EmptyAllowed: when empty specified)
         * @deprecated use e.g. Stream API with of() instead.
         */
        @Deprecated
        public static List<Term> listOf(Collection<String> codeList) { return _slimmer.listOf(codeList); }
        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use listByGroup(groupName).</span>
         * @param groupName The string of group name, which is case-sensitive. (NullAllowed: if null, returns empty list)
         * @return The snapshot list of classification elements in the group. (NotNull, EmptyAllowed: if the group is not found)
         * @deprecated use listByGroup(groupName) instead.
         */
        @Deprecated
        public static List<Term> groupOf(String groupName) { return new ArrayList<>(); }
        @Override public String toString() { return code(); }
    }

    public enum DefMeta implements ClassificationMeta {
        /** 権限 */
        Authority(cd -> CDef.Authority.of(cd), nm -> CDef.Authority.byName(nm)
        , () -> CDef.Authority.listAll(), gp -> CDef.Authority.listByGroup(gp)
        , ClassificationCodeType.String, ClassificationUndefinedHandlingType.LOGGING),

        /** 陣営 */
        Camp(cd -> CDef.Camp.of(cd), nm -> CDef.Camp.byName(nm)
        , () -> CDef.Camp.listAll(), gp -> CDef.Camp.listByGroup(gp)
        , ClassificationCodeType.String, ClassificationUndefinedHandlingType.LOGGING),

        /** 村ステータス */
        VillageStatus(cd -> CDef.VillageStatus.of(cd), nm -> CDef.VillageStatus.byName(nm)
        , () -> CDef.VillageStatus.listAll(), gp -> CDef.VillageStatus.listByGroup(gp)
        , ClassificationCodeType.String, ClassificationUndefinedHandlingType.LOGGING),

        /** 役職 */
        Skill(cd -> CDef.Skill.of(cd), nm -> CDef.Skill.byName(nm)
        , () -> CDef.Skill.listAll(), gp -> CDef.Skill.listByGroup(gp)
        , ClassificationCodeType.String, ClassificationUndefinedHandlingType.LOGGING),

        /** メッセージ種別 */
        MessageType(cd -> CDef.MessageType.of(cd), nm -> CDef.MessageType.byName(nm)
        , () -> CDef.MessageType.listAll(), gp -> CDef.MessageType.listByGroup(gp)
        , ClassificationCodeType.String, ClassificationUndefinedHandlingType.LOGGING),

        /** 死亡理由 */
        DeadReason(cd -> CDef.DeadReason.of(cd), nm -> CDef.DeadReason.byName(nm)
        , () -> CDef.DeadReason.listAll(), gp -> CDef.DeadReason.listByGroup(gp)
        , ClassificationCodeType.String, ClassificationUndefinedHandlingType.LOGGING),

        /** 能力種別 */
        AbilityType(cd -> CDef.AbilityType.of(cd), nm -> CDef.AbilityType.byName(nm)
        , () -> CDef.AbilityType.listAll(), gp -> CDef.AbilityType.listByGroup(gp)
        , ClassificationCodeType.String, ClassificationUndefinedHandlingType.LOGGING),

        /** 表情種別 */
        FaceType(cd -> CDef.FaceType.of(cd), nm -> CDef.FaceType.byName(nm)
        , () -> CDef.FaceType.listAll(), gp -> CDef.FaceType.listByGroup(gp)
        , ClassificationCodeType.String, ClassificationUndefinedHandlingType.LOGGING),

        /** 村設定項目 */
        VillageSettingItem(cd -> CDef.VillageSettingItem.of(cd), nm -> CDef.VillageSettingItem.byName(nm)
        , () -> CDef.VillageSettingItem.listAll(), gp -> CDef.VillageSettingItem.listByGroup(gp)
        , ClassificationCodeType.String, ClassificationUndefinedHandlingType.LOGGING),

        /** 昼夜 */
        Noonnight(cd -> CDef.Noonnight.of(cd), nm -> CDef.Noonnight.byName(nm)
        , () -> CDef.Noonnight.listAll(), gp -> CDef.Noonnight.listByGroup(gp)
        , ClassificationCodeType.String, ClassificationUndefinedHandlingType.LOGGING),

        /** 期間 */
        Term(cd -> CDef.Term.of(cd), nm -> CDef.Term.byName(nm)
        , () -> CDef.Term.listAll(), gp -> CDef.Term.listByGroup(gp)
        , ClassificationCodeType.String, ClassificationUndefinedHandlingType.LOGGING);

        private static final Map<String, DefMeta> _nameMetaMap = new HashMap<>();
        static {
            for (DefMeta value : values()) {
                _nameMetaMap.put(value.name().toLowerCase(), value);
            }
        }
        private final Function<Object, OptionalThing<? extends Classification>> _ofCall;
        private final Function<String, OptionalThing<? extends Classification>> _byNameCall;
        private final Supplier<List<? extends Classification>> _listAllCall;
        private final Function<String, List<? extends Classification>> _listByGroupCall;
        private final ClassificationCodeType _codeType;
        private final ClassificationUndefinedHandlingType _undefinedHandlingType;
        private DefMeta(Function<Object, OptionalThing<? extends Classification>> ofCall
                      , Function<String, OptionalThing<? extends Classification>> byNameCall
                      , Supplier<List<? extends Classification>> listAllCall
                      , Function<String, List<? extends Classification>> listByGroupCall
                      , ClassificationCodeType codeType
                      , ClassificationUndefinedHandlingType undefinedHandlingType
                ) {
            _ofCall = ofCall;
            _byNameCall = byNameCall;
            _listAllCall = listAllCall;
            _listByGroupCall = listByGroupCall;
            _codeType = codeType;
            _undefinedHandlingType = undefinedHandlingType;
        }
        public String classificationName() { return name(); } // same as definition name

        public OptionalThing<? extends Classification> of(Object code) { return _ofCall.apply(code); }
        public OptionalThing<? extends Classification> byName(String name) { return _byNameCall.apply(name); }

        public Classification codeOf(Object code) // null allowed, old style
        { return of(code).orElse(null); }
        public Classification nameOf(String name) { // null allowed, old style
            if (name == null) { return null; } // for compatible
            return byName(name).orElse(null); // case insensitive
        }

        public List<Classification> listAll()
        { return toClsList(_listAllCall.get()); }
        public List<Classification> listByGroup(String groupName) // exception if not found
        { return toClsList(_listByGroupCall.apply(groupName)); }

        @SuppressWarnings("unchecked")
        private List<Classification> toClsList(List<?> clsList) { return (List<Classification>)clsList; }

        public List<Classification> listOf(Collection<String> codeList) { // copied from slimmer, old style
            if (codeList == null) {
                throw new IllegalArgumentException("The argument 'codeList' should not be null.");
            }
            List<Classification> clsList = new ArrayList<>(codeList.size());
            for (String code : codeList) {
                clsList.add(of(code).get());
            }
            return clsList;
        }
        public List<Classification> groupOf(String groupName) { // empty if not found, old style
            try {
                return listByGroup(groupName); // case insensitive
            } catch (IllegalArgumentException | ClassificationNotFoundException e) {
                return new ArrayList<>(); // null or not found
            }
        }

        public ClassificationCodeType codeType() { return _codeType; }
        public ClassificationUndefinedHandlingType undefinedHandlingType() { return _undefinedHandlingType; }

        public static OptionalThing<CDef.DefMeta> find(String classificationName) { // instead of valueOf()
            if (classificationName == null) { throw new IllegalArgumentException("The argument 'classificationName' should not be null."); }
            return OptionalThing.ofNullable(_nameMetaMap.get(classificationName.toLowerCase()), () -> {
                throw new ClassificationNotFoundException("Unknown classification: " + classificationName);
            });
        }
        public static CDef.DefMeta meta(String classificationName) { // old style so use find(name)
            return find(classificationName).orElseTranslatingThrow(cause -> {
                return new IllegalStateException("Unknown classification: " + classificationName);
            });
        }
    }

    public static class ZzzoneSlimmer<CLS extends CDef> {

        public static Set<String> toSisterSet(String[] sisters) { // used by initializer so static
            return Collections.unmodifiableSet(new LinkedHashSet<String>(Arrays.asList(sisters)));
        }

        private final Class<CLS> _clsType;
        private final Map<String, CLS> _codeClsMap = new HashMap<>();
        private final Map<String, CLS> _nameClsMap = new HashMap<>();

        public ZzzoneSlimmer(Class<CLS> clsType, CLS[] values) {
            _clsType = clsType;
            initMap(values);
        }

        private void initMap(CLS[] values) {
            for (CLS value : values) {
                _codeClsMap.put(value.code().toLowerCase(), value);
                for (String sister : value.sisterSet()) {
                    _codeClsMap.put(sister.toLowerCase(), value);
                }
                _nameClsMap.put(value.name().toLowerCase(), value);
            }
        }

        public OptionalThing<CLS> of(Object code) {
            if (code == null) {
                return OptionalThing.ofNullable(null, () -> {
                    throw new ClassificationNotFoundException("null code specified");
                });
            }
            if (_clsType.isAssignableFrom(code.getClass())) {
                @SuppressWarnings("unchecked")
                CLS cls = (CLS) code;
                return OptionalThing.of(cls);
            }
            if (code instanceof OptionalThing<?>) {
                return of(((OptionalThing<?>) code).orElse(null));
            }
            return OptionalThing.ofNullable(_codeClsMap.get(code.toString().toLowerCase()), () -> {
                throw new ClassificationNotFoundException("Unknown classification code: " + code);
            });
        }

        public OptionalThing<CLS> byName(String name) {
            if (name == null) {
                throw new IllegalArgumentException("The argument 'name' should not be null.");
            }
            return OptionalThing.ofNullable(_nameClsMap.get(name.toLowerCase()), () -> {
                throw new ClassificationNotFoundException("Unknown classification name: " + name);
            });
        }

        public CLS codeOf(Object code) {
            if (code == null) {
                return null;
            }
            if (_clsType.isAssignableFrom(code.getClass())) {
                @SuppressWarnings("unchecked")
                CLS cls = (CLS) code;
                return cls;
            }
            return _codeClsMap.get(code.toString().toLowerCase());
        }

        public CLS nameOf(String name, java.util.function.Function<String, CLS> valueOfCall) {
            if (name == null) {
                return null;
            }
            try {
                return valueOfCall.apply(name);
            } catch (RuntimeException ignored) { // not found
                return null;
            }
        }

        public List<CLS> listAll(CLS[] clss) {
            return new ArrayList<>(Arrays.asList(clss));
        }

        public List<CLS> listOf(Collection<String> codeList) {
            if (codeList == null) {
                throw new IllegalArgumentException("The argument 'codeList' should not be null.");
            }
            List<CLS> clsList = new ArrayList<>(codeList.size());
            for (String code : codeList) {
                clsList.add(of(code).get());
            }
            return clsList;
        }
    }
}
