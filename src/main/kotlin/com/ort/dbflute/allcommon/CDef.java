package com.ort.dbflute.allcommon;

import java.util.*;

import org.dbflute.exception.ClassificationNotFoundException;
import org.dbflute.jdbc.Classification;
import org.dbflute.jdbc.ClassificationCodeType;
import org.dbflute.jdbc.ClassificationMeta;
import org.dbflute.jdbc.ClassificationUndefinedHandlingType;
import org.dbflute.optional.OptionalThing;
import static org.dbflute.util.DfTypeUtil.emptyStrings;

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
        管理者("ROLE_ADMIN", "管理者", emptyStrings())
        ,
        /** プレイヤー */
        プレイヤー("ROLE_PLAYER", "プレイヤー", emptyStrings())
        ;
        private static final Map<String, Authority> _codeClsMap = new HashMap<String, Authority>();
        private static final Map<String, Authority> _nameClsMap = new HashMap<String, Authority>();
        static {
            for (Authority value : values()) {
                _codeClsMap.put(value.code().toLowerCase(), value);
                for (String sister : value.sisterSet()) { _codeClsMap.put(sister.toLowerCase(), value); }
                _nameClsMap.put(value.name().toLowerCase(), value);
            }
        }
        private String _code; private String _alias; private Set<String> _sisterSet;
        private Authority(String code, String alias, String[] sisters)
        { _code = code; _alias = alias; _sisterSet = Collections.unmodifiableSet(new LinkedHashSet<String>(Arrays.asList(sisters))); }
        public String code() { return _code; } public String alias() { return _alias; }
        public Set<String> sisterSet() { return _sisterSet; }
        public Map<String, Object> subItemMap() { return Collections.emptyMap(); }
        public ClassificationMeta meta() { return CDef.DefMeta.Authority; }

        public boolean inGroup(String groupName) {
            return false;
        }

        /**
         * Get the classification of the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns empty)
         * @return The optional classification corresponding to the code. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<Authority> of(Object code) {
            if (code == null) { return OptionalThing.ofNullable(null, () -> { throw new ClassificationNotFoundException("null code specified"); }); }
            if (code instanceof Authority) { return OptionalThing.of((Authority)code); }
            if (code instanceof OptionalThing<?>) { return of(((OptionalThing<?>)code).orElse(null)); }
            return OptionalThing.ofNullable(_codeClsMap.get(code.toString().toLowerCase()), () ->{
                throw new ClassificationNotFoundException("Unknown classification code: " + code);
            });
        }

        /**
         * Find the classification by the name. (CaseInsensitive)
         * @param name The string of name, which is case-insensitive. (NotNull)
         * @return The optional classification corresponding to the name. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<Authority> byName(String name) {
            if (name == null) { throw new IllegalArgumentException("The argument 'name' should not be null."); }
            return OptionalThing.ofNullable(_nameClsMap.get(name.toLowerCase()), () ->{
                throw new ClassificationNotFoundException("Unknown classification name: " + name);
            });
        }

        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use of(code).</span> <br>
         * Get the classification by the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the code. (NullAllowed: if not found, returns null)
         */
        public static Authority codeOf(Object code) {
            if (code == null) { return null; }
            if (code instanceof Authority) { return (Authority)code; }
            return _codeClsMap.get(code.toString().toLowerCase());
        }

        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use byName(name).</span> <br>
         * Get the classification by the name (also called 'value' in ENUM world).
         * @param name The string of name, which is case-sensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the name. (NullAllowed: if not found, returns null)
         */
        public static Authority nameOf(String name) {
            if (name == null) { return null; }
            try { return valueOf(name); } catch (RuntimeException ignored) { return null; }
        }

        /**
         * Get the list of all classification elements. (returns new copied list)
         * @return The snapshot list of all classification elements. (NotNull)
         */
        public static List<Authority> listAll() {
            return new ArrayList<Authority>(Arrays.asList(values()));
        }

        /**
         * Get the list of classification elements in the specified group. (returns new copied list) <br>
         * @param groupName The string of group name, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the group. (NotNull, EmptyAllowed: if not found, throws exception)
         */
        public static List<Authority> listByGroup(String groupName) {
            if (groupName == null) { throw new IllegalArgumentException("The argument 'groupName' should not be null."); }
            throw new ClassificationNotFoundException("Unknown classification group: Authority." + groupName);
        }

        /**
         * Get the list of classification elements corresponding to the specified codes. (returns new copied list) <br>
         * @param codeList The list of plain code, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the code list. (NotNull, EmptyAllowed: when empty specified)
         */
        public static List<Authority> listOf(Collection<String> codeList) {
            if (codeList == null) { throw new IllegalArgumentException("The argument 'codeList' should not be null."); }
            List<Authority> clsList = new ArrayList<Authority>(codeList.size());
            for (String code : codeList) { clsList.add(of(code).get()); }
            return clsList;
        }

        /**
         * Get the list of classification elements in the specified group. (returns new copied list) <br>
         * @param groupName The string of group name, which is case-sensitive. (NullAllowed: if null, returns empty list)
         * @return The snapshot list of classification elements in the group. (NotNull, EmptyAllowed: if the group is not found)
         */
        public static List<Authority> groupOf(String groupName) {
            return new ArrayList<Authority>(4);
        }

        @Override public String toString() { return code(); }
    }

    /**
     * 陣営
     */
    public enum Camp implements CDef {
        /** 狐陣営 */
        狐陣営("FOX", "狐陣営", emptyStrings())
        ,
        /** 村人陣営 */
        村人陣営("VILLAGER", "村人陣営", emptyStrings())
        ,
        /** 人狼陣営 */
        人狼陣営("WEREWOLF", "人狼陣営", emptyStrings())
        ;
        private static final Map<String, Camp> _codeClsMap = new HashMap<String, Camp>();
        private static final Map<String, Camp> _nameClsMap = new HashMap<String, Camp>();
        static {
            for (Camp value : values()) {
                _codeClsMap.put(value.code().toLowerCase(), value);
                for (String sister : value.sisterSet()) { _codeClsMap.put(sister.toLowerCase(), value); }
                _nameClsMap.put(value.name().toLowerCase(), value);
            }
        }
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
        private String _code; private String _alias; private Set<String> _sisterSet;
        private Camp(String code, String alias, String[] sisters)
        { _code = code; _alias = alias; _sisterSet = Collections.unmodifiableSet(new LinkedHashSet<String>(Arrays.asList(sisters))); }
        public String code() { return _code; } public String alias() { return _alias; }
        public Set<String> sisterSet() { return _sisterSet; }
        public Map<String, Object> subItemMap() { return _subItemMapMap.get(code()); }
        public ClassificationMeta meta() { return CDef.DefMeta.Camp; }

        public String order() {
            return (String)subItemMap().get("order");
        }

        public boolean inGroup(String groupName) {
            return false;
        }

        /**
         * Get the classification of the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns empty)
         * @return The optional classification corresponding to the code. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<Camp> of(Object code) {
            if (code == null) { return OptionalThing.ofNullable(null, () -> { throw new ClassificationNotFoundException("null code specified"); }); }
            if (code instanceof Camp) { return OptionalThing.of((Camp)code); }
            if (code instanceof OptionalThing<?>) { return of(((OptionalThing<?>)code).orElse(null)); }
            return OptionalThing.ofNullable(_codeClsMap.get(code.toString().toLowerCase()), () ->{
                throw new ClassificationNotFoundException("Unknown classification code: " + code);
            });
        }

        /**
         * Find the classification by the name. (CaseInsensitive)
         * @param name The string of name, which is case-insensitive. (NotNull)
         * @return The optional classification corresponding to the name. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<Camp> byName(String name) {
            if (name == null) { throw new IllegalArgumentException("The argument 'name' should not be null."); }
            return OptionalThing.ofNullable(_nameClsMap.get(name.toLowerCase()), () ->{
                throw new ClassificationNotFoundException("Unknown classification name: " + name);
            });
        }

        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use of(code).</span> <br>
         * Get the classification by the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the code. (NullAllowed: if not found, returns null)
         */
        public static Camp codeOf(Object code) {
            if (code == null) { return null; }
            if (code instanceof Camp) { return (Camp)code; }
            return _codeClsMap.get(code.toString().toLowerCase());
        }

        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use byName(name).</span> <br>
         * Get the classification by the name (also called 'value' in ENUM world).
         * @param name The string of name, which is case-sensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the name. (NullAllowed: if not found, returns null)
         */
        public static Camp nameOf(String name) {
            if (name == null) { return null; }
            try { return valueOf(name); } catch (RuntimeException ignored) { return null; }
        }

        /**
         * Get the list of all classification elements. (returns new copied list)
         * @return The snapshot list of all classification elements. (NotNull)
         */
        public static List<Camp> listAll() {
            return new ArrayList<Camp>(Arrays.asList(values()));
        }

        /**
         * Get the list of classification elements in the specified group. (returns new copied list) <br>
         * @param groupName The string of group name, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the group. (NotNull, EmptyAllowed: if not found, throws exception)
         */
        public static List<Camp> listByGroup(String groupName) {
            if (groupName == null) { throw new IllegalArgumentException("The argument 'groupName' should not be null."); }
            throw new ClassificationNotFoundException("Unknown classification group: Camp." + groupName);
        }

        /**
         * Get the list of classification elements corresponding to the specified codes. (returns new copied list) <br>
         * @param codeList The list of plain code, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the code list. (NotNull, EmptyAllowed: when empty specified)
         */
        public static List<Camp> listOf(Collection<String> codeList) {
            if (codeList == null) { throw new IllegalArgumentException("The argument 'codeList' should not be null."); }
            List<Camp> clsList = new ArrayList<Camp>(codeList.size());
            for (String code : codeList) { clsList.add(of(code).get()); }
            return clsList;
        }

        /**
         * Get the list of classification elements in the specified group. (returns new copied list) <br>
         * @param groupName The string of group name, which is case-sensitive. (NullAllowed: if null, returns empty list)
         * @return The snapshot list of classification elements in the group. (NotNull, EmptyAllowed: if the group is not found)
         */
        public static List<Camp> groupOf(String groupName) {
            return new ArrayList<Camp>(4);
        }

        @Override public String toString() { return code(); }
    }

    /**
     * 村ステータス
     */
    public enum VillageStatus implements CDef {
        /** 廃村 */
        廃村("CANCEL", "廃村", emptyStrings())
        ,
        /** 終了 */
        終了("COMPLETED", "終了", emptyStrings())
        ,
        /** エピローグ */
        エピローグ("EPILOGUE", "エピローグ", emptyStrings())
        ,
        /** 進行中 */
        進行中("IN_PROGRESS", "進行中", emptyStrings())
        ,
        /** プロローグ */
        プロローグ("PROLOGUE", "プロローグ", emptyStrings())
        ;
        private static final Map<String, VillageStatus> _codeClsMap = new HashMap<String, VillageStatus>();
        private static final Map<String, VillageStatus> _nameClsMap = new HashMap<String, VillageStatus>();
        static {
            for (VillageStatus value : values()) {
                _codeClsMap.put(value.code().toLowerCase(), value);
                for (String sister : value.sisterSet()) { _codeClsMap.put(sister.toLowerCase(), value); }
                _nameClsMap.put(value.name().toLowerCase(), value);
            }
        }
        private String _code; private String _alias; private Set<String> _sisterSet;
        private VillageStatus(String code, String alias, String[] sisters)
        { _code = code; _alias = alias; _sisterSet = Collections.unmodifiableSet(new LinkedHashSet<String>(Arrays.asList(sisters))); }
        public String code() { return _code; } public String alias() { return _alias; }
        public Set<String> sisterSet() { return _sisterSet; }
        public Map<String, Object> subItemMap() { return Collections.emptyMap(); }
        public ClassificationMeta meta() { return CDef.DefMeta.VillageStatus; }

        /**
         * Is the classification in the group? <br>
         * 決着がついた村 <br>
         * The group elements:[エピローグ, 廃村, 終了]
         * @return The determination, true or false.
         */
        public boolean isSolvedVillage() {
            return エピローグ.equals(this) || 廃村.equals(this) || 終了.equals(this);
        }

        /**
         * Is the classification in the group? <br>
         * 終了した村 <br>
         * The group elements:[廃村, 終了]
         * @return The determination, true or false.
         */
        public boolean isFinishedVillage() {
            return 廃村.equals(this) || 終了.equals(this);
        }

        public boolean inGroup(String groupName) {
            if ("solvedVillage".equals(groupName)) { return isSolvedVillage(); }
            if ("finishedVillage".equals(groupName)) { return isFinishedVillage(); }
            return false;
        }

        /**
         * Get the classification of the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns empty)
         * @return The optional classification corresponding to the code. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<VillageStatus> of(Object code) {
            if (code == null) { return OptionalThing.ofNullable(null, () -> { throw new ClassificationNotFoundException("null code specified"); }); }
            if (code instanceof VillageStatus) { return OptionalThing.of((VillageStatus)code); }
            if (code instanceof OptionalThing<?>) { return of(((OptionalThing<?>)code).orElse(null)); }
            return OptionalThing.ofNullable(_codeClsMap.get(code.toString().toLowerCase()), () ->{
                throw new ClassificationNotFoundException("Unknown classification code: " + code);
            });
        }

        /**
         * Find the classification by the name. (CaseInsensitive)
         * @param name The string of name, which is case-insensitive. (NotNull)
         * @return The optional classification corresponding to the name. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<VillageStatus> byName(String name) {
            if (name == null) { throw new IllegalArgumentException("The argument 'name' should not be null."); }
            return OptionalThing.ofNullable(_nameClsMap.get(name.toLowerCase()), () ->{
                throw new ClassificationNotFoundException("Unknown classification name: " + name);
            });
        }

        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use of(code).</span> <br>
         * Get the classification by the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the code. (NullAllowed: if not found, returns null)
         */
        public static VillageStatus codeOf(Object code) {
            if (code == null) { return null; }
            if (code instanceof VillageStatus) { return (VillageStatus)code; }
            return _codeClsMap.get(code.toString().toLowerCase());
        }

        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use byName(name).</span> <br>
         * Get the classification by the name (also called 'value' in ENUM world).
         * @param name The string of name, which is case-sensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the name. (NullAllowed: if not found, returns null)
         */
        public static VillageStatus nameOf(String name) {
            if (name == null) { return null; }
            try { return valueOf(name); } catch (RuntimeException ignored) { return null; }
        }

        /**
         * Get the list of all classification elements. (returns new copied list)
         * @return The snapshot list of all classification elements. (NotNull)
         */
        public static List<VillageStatus> listAll() {
            return new ArrayList<VillageStatus>(Arrays.asList(values()));
        }

        /**
         * Get the list of classification elements in the specified group. (returns new copied list) <br>
         * @param groupName The string of group name, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the group. (NotNull, EmptyAllowed: if not found, throws exception)
         */
        public static List<VillageStatus> listByGroup(String groupName) {
            if (groupName == null) { throw new IllegalArgumentException("The argument 'groupName' should not be null."); }
            if ("solvedVillage".equalsIgnoreCase(groupName)) { return listOfSolvedVillage(); }
            if ("finishedVillage".equalsIgnoreCase(groupName)) { return listOfFinishedVillage(); }
            throw new ClassificationNotFoundException("Unknown classification group: VillageStatus." + groupName);
        }

        /**
         * Get the list of classification elements corresponding to the specified codes. (returns new copied list) <br>
         * @param codeList The list of plain code, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the code list. (NotNull, EmptyAllowed: when empty specified)
         */
        public static List<VillageStatus> listOf(Collection<String> codeList) {
            if (codeList == null) { throw new IllegalArgumentException("The argument 'codeList' should not be null."); }
            List<VillageStatus> clsList = new ArrayList<VillageStatus>(codeList.size());
            for (String code : codeList) { clsList.add(of(code).get()); }
            return clsList;
        }

        /**
         * Get the list of group classification elements. (returns new copied list) <br>
         * 決着がついた村 <br>
         * The group elements:[エピローグ, 廃村, 終了]
         * @return The snapshot list of classification elements in the group. (NotNull)
         */
        public static List<VillageStatus> listOfSolvedVillage() {
            return new ArrayList<VillageStatus>(Arrays.asList(エピローグ, 廃村, 終了));
        }

        /**
         * Get the list of group classification elements. (returns new copied list) <br>
         * 終了した村 <br>
         * The group elements:[廃村, 終了]
         * @return The snapshot list of classification elements in the group. (NotNull)
         */
        public static List<VillageStatus> listOfFinishedVillage() {
            return new ArrayList<VillageStatus>(Arrays.asList(廃村, 終了));
        }

        /**
         * Get the list of classification elements in the specified group. (returns new copied list) <br>
         * @param groupName The string of group name, which is case-sensitive. (NullAllowed: if null, returns empty list)
         * @return The snapshot list of classification elements in the group. (NotNull, EmptyAllowed: if the group is not found)
         */
        public static List<VillageStatus> groupOf(String groupName) {
            if ("solvedVillage".equals(groupName)) { return listOfSolvedVillage(); }
            if ("finishedVillage".equals(groupName)) { return listOfFinishedVillage(); }
            return new ArrayList<VillageStatus>(4);
        }

        @Override public String toString() { return code(); }
    }

    /**
     * 役職
     */
    public enum Skill implements CDef {
        /** C国狂人 */
        C国狂人("CMADMAN", "C国狂人", emptyStrings())
        ,
        /** 狂信者 */
        狂信者("FANATIC", "狂信者", emptyStrings())
        ,
        /** 妖狐 */
        妖狐("FOX", "妖狐", emptyStrings())
        ,
        /** 狩人 */
        狩人("HUNTER", "狩人", emptyStrings())
        ,
        /** 背徳者 */
        背徳者("IMMORAL", "背徳者", emptyStrings())
        ,
        /** おまかせ */
        おまかせ("LEFTOVER", "おまかせ", emptyStrings())
        ,
        /** 狂人 */
        狂人("MADMAN", "狂人", emptyStrings())
        ,
        /** 共有者 */
        共有者("MASON", "共有者", emptyStrings())
        ,
        /** 霊能者 */
        霊能者("MEDIUM", "霊能者", emptyStrings())
        ,
        /** 猫又 */
        猫又("MONSTERCAT", "猫又", emptyStrings())
        ,
        /** 占い師 */
        占い師("SEER", "占い師", emptyStrings())
        ,
        /** 聖痕者 */
        聖痕者("STIGMATA", "聖痕者", emptyStrings())
        ,
        /** 村人 */
        村人("VILLAGER", "村人", emptyStrings())
        ,
        /** おまかせ（村人陣営） */
        おまかせ村人陣営("VILLAGERS", "おまかせ（村人陣営）", emptyStrings())
        ,
        /** 人狼 */
        人狼("WEREWOLF", "人狼", emptyStrings())
        ,
        /** おまかせ（人狼陣営） */
        おまかせ人狼陣営("WEREWOLFS", "おまかせ（人狼陣営）", emptyStrings())
        ;
        private static final Map<String, Skill> _codeClsMap = new HashMap<String, Skill>();
        private static final Map<String, Skill> _nameClsMap = new HashMap<String, Skill>();
        static {
            for (Skill value : values()) {
                _codeClsMap.put(value.code().toLowerCase(), value);
                for (String sister : value.sisterSet()) { _codeClsMap.put(sister.toLowerCase(), value); }
                _nameClsMap.put(value.name().toLowerCase(), value);
            }
        }
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
        private String _code; private String _alias; private Set<String> _sisterSet;
        private Skill(String code, String alias, String[] sisters)
        { _code = code; _alias = alias; _sisterSet = Collections.unmodifiableSet(new LinkedHashSet<String>(Arrays.asList(sisters))); }
        public String code() { return _code; } public String alias() { return _alias; }
        public Set<String> sisterSet() { return _sisterSet; }
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
        public boolean isViewableWerewolfSay() {
            return 人狼.equals(this) || C国狂人.equals(this);
        }

        /**
         * Is the classification in the group? <br>
         * 囁き可能 <br>
         * The group elements:[人狼, C国狂人]
         * @return The determination, true or false.
         */
        public boolean isAvailableWerewolfSay() {
            return 人狼.equals(this) || C国狂人.equals(this);
        }

        /**
         * Is the classification in the group? <br>
         * 襲撃対象に選べない <br>
         * The group elements:[人狼]
         * @return The determination, true or false.
         */
        public boolean isNotSelectableAttack() {
            return 人狼.equals(this);
        }

        /**
         * Is the classification in the group? <br>
         * 占い結果が人狼になる <br>
         * The group elements:[人狼]
         * @return The determination, true or false.
         */
        public boolean isDivineResultWolf() {
            return 人狼.equals(this);
        }

        /**
         * Is the classification in the group? <br>
         * 霊能結果が人狼になる <br>
         * The group elements:[人狼]
         * @return The determination, true or false.
         */
        public boolean isPsychicResultWolf() {
            return 人狼.equals(this);
        }

        /**
         * Is the classification in the group? <br>
         * 襲撃能力を持つ <br>
         * The group elements:[人狼]
         * @return The determination, true or false.
         */
        public boolean isHasAttackAbility() {
            return 人狼.equals(this);
        }

        /**
         * Is the classification in the group? <br>
         * 占い能力を持つ <br>
         * The group elements:[占い師]
         * @return The determination, true or false.
         */
        public boolean isHasDivineAbility() {
            return 占い師.equals(this);
        }

        /**
         * Is the classification in the group? <br>
         * 護衛能力を持つ <br>
         * The group elements:[狩人]
         * @return The determination, true or false.
         */
        public boolean isHasGuardAbility() {
            return 狩人.equals(this);
        }

        /**
         * Is the classification in the group? <br>
         * 霊能能力を持つ <br>
         * The group elements:[霊能者]
         * @return The determination, true or false.
         */
        public boolean isHasPsychicAbility() {
            return 霊能者.equals(this);
        }

        /**
         * Is the classification in the group? <br>
         * 勝敗判定時狼にカウントする <br>
         * The group elements:[人狼]
         * @return The determination, true or false.
         */
        public boolean isCountWolf() {
            return 人狼.equals(this);
        }

        /**
         * Is the classification in the group? <br>
         * 勝敗判定時に人間としてカウントしない <br>
         * The group elements:[妖狐]
         * @return The determination, true or false.
         */
        public boolean isNoCount() {
            return 妖狐.equals(this);
        }

        /**
         * Is the classification in the group? <br>
         * おまかせ系 <br>
         * The group elements:[おまかせ, おまかせ村人陣営, おまかせ人狼陣営]
         * @return The determination, true or false.
         */
        public boolean isSomeoneSkill() {
            return おまかせ.equals(this) || おまかせ村人陣営.equals(this) || おまかせ人狼陣営.equals(this);
        }

        /**
         * Is the classification in the group? <br>
         * 共有系としてお互いに認知できる <br>
         * The group elements:[共有者]
         * @return The determination, true or false.
         */
        public boolean isRecognizableEachMason() {
            return 共有者.equals(this);
        }

        /**
         * Is the classification in the group? <br>
         * 人狼を認知できる <br>
         * The group elements:[狂信者]
         * @return The determination, true or false.
         */
        public boolean isRecognizableWolf() {
            return 狂信者.equals(this);
        }

        /**
         * Is the classification in the group? <br>
         * 妖狐を認知できる <br>
         * The group elements:[妖狐, 背徳者]
         * @return The determination, true or false.
         */
        public boolean isRecognizableFox() {
            return 妖狐.equals(this) || 背徳者.equals(this);
        }

        /**
         * Is the classification in the group? <br>
         * 襲撃耐性を持つ <br>
         * The group elements:[妖狐]
         * @return The determination, true or false.
         */
        public boolean isNoDeadByAttack() {
            return 妖狐.equals(this);
        }

        /**
         * Is the classification in the group? <br>
         * 占いにより死亡する <br>
         * The group elements:[妖狐]
         * @return The determination, true or false.
         */
        public boolean isDeadByDivine() {
            return 妖狐.equals(this);
        }

        /**
         * Is the classification in the group? <br>
         * 死亡時道連れにする <br>
         * The group elements:[猫又]
         * @return The determination, true or false.
         */
        public boolean isForceDoubleSuicide() {
            return 猫又.equals(this);
        }

        public boolean inGroup(String groupName) {
            if ("viewableWerewolfSay".equals(groupName)) { return isViewableWerewolfSay(); }
            if ("availableWerewolfSay".equals(groupName)) { return isAvailableWerewolfSay(); }
            if ("notSelectableAttack".equals(groupName)) { return isNotSelectableAttack(); }
            if ("divineResultWolf".equals(groupName)) { return isDivineResultWolf(); }
            if ("psychicResultWolf".equals(groupName)) { return isPsychicResultWolf(); }
            if ("hasAttackAbility".equals(groupName)) { return isHasAttackAbility(); }
            if ("hasDivineAbility".equals(groupName)) { return isHasDivineAbility(); }
            if ("hasGuardAbility".equals(groupName)) { return isHasGuardAbility(); }
            if ("hasPsychicAbility".equals(groupName)) { return isHasPsychicAbility(); }
            if ("countWolf".equals(groupName)) { return isCountWolf(); }
            if ("noCount".equals(groupName)) { return isNoCount(); }
            if ("someoneSkill".equals(groupName)) { return isSomeoneSkill(); }
            if ("recognizableEachMason".equals(groupName)) { return isRecognizableEachMason(); }
            if ("recognizableWolf".equals(groupName)) { return isRecognizableWolf(); }
            if ("recognizableFox".equals(groupName)) { return isRecognizableFox(); }
            if ("noDeadByAttack".equals(groupName)) { return isNoDeadByAttack(); }
            if ("deadByDivine".equals(groupName)) { return isDeadByDivine(); }
            if ("forceDoubleSuicide".equals(groupName)) { return isForceDoubleSuicide(); }
            return false;
        }

        /**
         * Get the classification of the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns empty)
         * @return The optional classification corresponding to the code. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<Skill> of(Object code) {
            if (code == null) { return OptionalThing.ofNullable(null, () -> { throw new ClassificationNotFoundException("null code specified"); }); }
            if (code instanceof Skill) { return OptionalThing.of((Skill)code); }
            if (code instanceof OptionalThing<?>) { return of(((OptionalThing<?>)code).orElse(null)); }
            return OptionalThing.ofNullable(_codeClsMap.get(code.toString().toLowerCase()), () ->{
                throw new ClassificationNotFoundException("Unknown classification code: " + code);
            });
        }

        /**
         * Find the classification by the name. (CaseInsensitive)
         * @param name The string of name, which is case-insensitive. (NotNull)
         * @return The optional classification corresponding to the name. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<Skill> byName(String name) {
            if (name == null) { throw new IllegalArgumentException("The argument 'name' should not be null."); }
            return OptionalThing.ofNullable(_nameClsMap.get(name.toLowerCase()), () ->{
                throw new ClassificationNotFoundException("Unknown classification name: " + name);
            });
        }

        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use of(code).</span> <br>
         * Get the classification by the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the code. (NullAllowed: if not found, returns null)
         */
        public static Skill codeOf(Object code) {
            if (code == null) { return null; }
            if (code instanceof Skill) { return (Skill)code; }
            return _codeClsMap.get(code.toString().toLowerCase());
        }

        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use byName(name).</span> <br>
         * Get the classification by the name (also called 'value' in ENUM world).
         * @param name The string of name, which is case-sensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the name. (NullAllowed: if not found, returns null)
         */
        public static Skill nameOf(String name) {
            if (name == null) { return null; }
            try { return valueOf(name); } catch (RuntimeException ignored) { return null; }
        }

        /**
         * Get the list of all classification elements. (returns new copied list)
         * @return The snapshot list of all classification elements. (NotNull)
         */
        public static List<Skill> listAll() {
            return new ArrayList<Skill>(Arrays.asList(values()));
        }

        /**
         * Get the list of classification elements in the specified group. (returns new copied list) <br>
         * @param groupName The string of group name, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the group. (NotNull, EmptyAllowed: if not found, throws exception)
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
         * Get the list of classification elements corresponding to the specified codes. (returns new copied list) <br>
         * @param codeList The list of plain code, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the code list. (NotNull, EmptyAllowed: when empty specified)
         */
        public static List<Skill> listOf(Collection<String> codeList) {
            if (codeList == null) { throw new IllegalArgumentException("The argument 'codeList' should not be null."); }
            List<Skill> clsList = new ArrayList<Skill>(codeList.size());
            for (String code : codeList) { clsList.add(of(code).get()); }
            return clsList;
        }

        /**
         * Get the list of group classification elements. (returns new copied list) <br>
         * 囁きを見られる <br>
         * The group elements:[人狼, C国狂人]
         * @return The snapshot list of classification elements in the group. (NotNull)
         */
        public static List<Skill> listOfViewableWerewolfSay() {
            return new ArrayList<Skill>(Arrays.asList(人狼, C国狂人));
        }

        /**
         * Get the list of group classification elements. (returns new copied list) <br>
         * 囁き可能 <br>
         * The group elements:[人狼, C国狂人]
         * @return The snapshot list of classification elements in the group. (NotNull)
         */
        public static List<Skill> listOfAvailableWerewolfSay() {
            return new ArrayList<Skill>(Arrays.asList(人狼, C国狂人));
        }

        /**
         * Get the list of group classification elements. (returns new copied list) <br>
         * 襲撃対象に選べない <br>
         * The group elements:[人狼]
         * @return The snapshot list of classification elements in the group. (NotNull)
         */
        public static List<Skill> listOfNotSelectableAttack() {
            return new ArrayList<Skill>(Arrays.asList(人狼));
        }

        /**
         * Get the list of group classification elements. (returns new copied list) <br>
         * 占い結果が人狼になる <br>
         * The group elements:[人狼]
         * @return The snapshot list of classification elements in the group. (NotNull)
         */
        public static List<Skill> listOfDivineResultWolf() {
            return new ArrayList<Skill>(Arrays.asList(人狼));
        }

        /**
         * Get the list of group classification elements. (returns new copied list) <br>
         * 霊能結果が人狼になる <br>
         * The group elements:[人狼]
         * @return The snapshot list of classification elements in the group. (NotNull)
         */
        public static List<Skill> listOfPsychicResultWolf() {
            return new ArrayList<Skill>(Arrays.asList(人狼));
        }

        /**
         * Get the list of group classification elements. (returns new copied list) <br>
         * 襲撃能力を持つ <br>
         * The group elements:[人狼]
         * @return The snapshot list of classification elements in the group. (NotNull)
         */
        public static List<Skill> listOfHasAttackAbility() {
            return new ArrayList<Skill>(Arrays.asList(人狼));
        }

        /**
         * Get the list of group classification elements. (returns new copied list) <br>
         * 占い能力を持つ <br>
         * The group elements:[占い師]
         * @return The snapshot list of classification elements in the group. (NotNull)
         */
        public static List<Skill> listOfHasDivineAbility() {
            return new ArrayList<Skill>(Arrays.asList(占い師));
        }

        /**
         * Get the list of group classification elements. (returns new copied list) <br>
         * 護衛能力を持つ <br>
         * The group elements:[狩人]
         * @return The snapshot list of classification elements in the group. (NotNull)
         */
        public static List<Skill> listOfHasGuardAbility() {
            return new ArrayList<Skill>(Arrays.asList(狩人));
        }

        /**
         * Get the list of group classification elements. (returns new copied list) <br>
         * 霊能能力を持つ <br>
         * The group elements:[霊能者]
         * @return The snapshot list of classification elements in the group. (NotNull)
         */
        public static List<Skill> listOfHasPsychicAbility() {
            return new ArrayList<Skill>(Arrays.asList(霊能者));
        }

        /**
         * Get the list of group classification elements. (returns new copied list) <br>
         * 勝敗判定時狼にカウントする <br>
         * The group elements:[人狼]
         * @return The snapshot list of classification elements in the group. (NotNull)
         */
        public static List<Skill> listOfCountWolf() {
            return new ArrayList<Skill>(Arrays.asList(人狼));
        }

        /**
         * Get the list of group classification elements. (returns new copied list) <br>
         * 勝敗判定時に人間としてカウントしない <br>
         * The group elements:[妖狐]
         * @return The snapshot list of classification elements in the group. (NotNull)
         */
        public static List<Skill> listOfNoCount() {
            return new ArrayList<Skill>(Arrays.asList(妖狐));
        }

        /**
         * Get the list of group classification elements. (returns new copied list) <br>
         * おまかせ系 <br>
         * The group elements:[おまかせ, おまかせ村人陣営, おまかせ人狼陣営]
         * @return The snapshot list of classification elements in the group. (NotNull)
         */
        public static List<Skill> listOfSomeoneSkill() {
            return new ArrayList<Skill>(Arrays.asList(おまかせ, おまかせ村人陣営, おまかせ人狼陣営));
        }

        /**
         * Get the list of group classification elements. (returns new copied list) <br>
         * 共有系としてお互いに認知できる <br>
         * The group elements:[共有者]
         * @return The snapshot list of classification elements in the group. (NotNull)
         */
        public static List<Skill> listOfRecognizableEachMason() {
            return new ArrayList<Skill>(Arrays.asList(共有者));
        }

        /**
         * Get the list of group classification elements. (returns new copied list) <br>
         * 人狼を認知できる <br>
         * The group elements:[狂信者]
         * @return The snapshot list of classification elements in the group. (NotNull)
         */
        public static List<Skill> listOfRecognizableWolf() {
            return new ArrayList<Skill>(Arrays.asList(狂信者));
        }

        /**
         * Get the list of group classification elements. (returns new copied list) <br>
         * 妖狐を認知できる <br>
         * The group elements:[妖狐, 背徳者]
         * @return The snapshot list of classification elements in the group. (NotNull)
         */
        public static List<Skill> listOfRecognizableFox() {
            return new ArrayList<Skill>(Arrays.asList(妖狐, 背徳者));
        }

        /**
         * Get the list of group classification elements. (returns new copied list) <br>
         * 襲撃耐性を持つ <br>
         * The group elements:[妖狐]
         * @return The snapshot list of classification elements in the group. (NotNull)
         */
        public static List<Skill> listOfNoDeadByAttack() {
            return new ArrayList<Skill>(Arrays.asList(妖狐));
        }

        /**
         * Get the list of group classification elements. (returns new copied list) <br>
         * 占いにより死亡する <br>
         * The group elements:[妖狐]
         * @return The snapshot list of classification elements in the group. (NotNull)
         */
        public static List<Skill> listOfDeadByDivine() {
            return new ArrayList<Skill>(Arrays.asList(妖狐));
        }

        /**
         * Get the list of group classification elements. (returns new copied list) <br>
         * 死亡時道連れにする <br>
         * The group elements:[猫又]
         * @return The snapshot list of classification elements in the group. (NotNull)
         */
        public static List<Skill> listOfForceDoubleSuicide() {
            return new ArrayList<Skill>(Arrays.asList(猫又));
        }

        /**
         * Get the list of classification elements in the specified group. (returns new copied list) <br>
         * @param groupName The string of group name, which is case-sensitive. (NullAllowed: if null, returns empty list)
         * @return The snapshot list of classification elements in the group. (NotNull, EmptyAllowed: if the group is not found)
         */
        public static List<Skill> groupOf(String groupName) {
            if ("viewableWerewolfSay".equals(groupName)) { return listOfViewableWerewolfSay(); }
            if ("availableWerewolfSay".equals(groupName)) { return listOfAvailableWerewolfSay(); }
            if ("notSelectableAttack".equals(groupName)) { return listOfNotSelectableAttack(); }
            if ("divineResultWolf".equals(groupName)) { return listOfDivineResultWolf(); }
            if ("psychicResultWolf".equals(groupName)) { return listOfPsychicResultWolf(); }
            if ("hasAttackAbility".equals(groupName)) { return listOfHasAttackAbility(); }
            if ("hasDivineAbility".equals(groupName)) { return listOfHasDivineAbility(); }
            if ("hasGuardAbility".equals(groupName)) { return listOfHasGuardAbility(); }
            if ("hasPsychicAbility".equals(groupName)) { return listOfHasPsychicAbility(); }
            if ("countWolf".equals(groupName)) { return listOfCountWolf(); }
            if ("noCount".equals(groupName)) { return listOfNoCount(); }
            if ("someoneSkill".equals(groupName)) { return listOfSomeoneSkill(); }
            if ("recognizableEachMason".equals(groupName)) { return listOfRecognizableEachMason(); }
            if ("recognizableWolf".equals(groupName)) { return listOfRecognizableWolf(); }
            if ("recognizableFox".equals(groupName)) { return listOfRecognizableFox(); }
            if ("noDeadByAttack".equals(groupName)) { return listOfNoDeadByAttack(); }
            if ("deadByDivine".equals(groupName)) { return listOfDeadByDivine(); }
            if ("forceDoubleSuicide".equals(groupName)) { return listOfForceDoubleSuicide(); }
            return new ArrayList<Skill>(4);
        }

        @Override public String toString() { return code(); }
    }

    /**
     * メッセージ種別
     */
    public enum MessageType implements CDef {
        /** 村建て発言 */
        村建て発言("CREATOR_SAY", "村建て発言", emptyStrings())
        ,
        /** 死者の呻き */
        死者の呻き("GRAVE_SAY", "死者の呻き", emptyStrings())
        ,
        /** 共鳴発言 */
        共鳴発言("MASON_SAY", "共鳴発言", emptyStrings())
        ,
        /** 独り言 */
        独り言("MONOLOGUE_SAY", "独り言", emptyStrings())
        ,
        /** 通常発言 */
        通常発言("NORMAL_SAY", "通常発言", emptyStrings())
        ,
        /** 参加者一覧 */
        参加者一覧("PARTICIPANTS", "参加者一覧", emptyStrings())
        ,
        /** 狂信者人狼確認メッセージ */
        狂信者人狼確認メッセージ("PRIVATE_FANATIC", "狂信者人狼確認メッセージ", emptyStrings())
        ,
        /** 妖狐メッセージ */
        妖狐メッセージ("PRIVATE_FOX", "妖狐メッセージ", emptyStrings())
        ,
        /** 共有相互確認メッセージ */
        共有相互確認メッセージ("PRIVATE_MASON", "共有相互確認メッセージ", emptyStrings())
        ,
        /** 白黒霊視結果 */
        白黒霊視結果("PRIVATE_PSYCHIC", "白黒霊視結果", emptyStrings())
        ,
        /** 白黒占い結果 */
        白黒占い結果("PRIVATE_SEER", "白黒占い結果", emptyStrings())
        ,
        /** 非公開システムメッセージ */
        非公開システムメッセージ("PRIVATE_SYSTEM", "非公開システムメッセージ", emptyStrings())
        ,
        /** 襲撃結果 */
        襲撃結果("PRIVATE_WEREWOLF", "襲撃結果", emptyStrings())
        ,
        /** 公開システムメッセージ */
        公開システムメッセージ("PUBLIC_SYSTEM", "公開システムメッセージ", emptyStrings())
        ,
        /** 秘話 */
        秘話("SECRET_SAY", "秘話", emptyStrings())
        ,
        /** 見学発言 */
        見学発言("SPECTATE_SAY", "見学発言", emptyStrings())
        ,
        /** 人狼の囁き */
        人狼の囁き("WEREWOLF_SAY", "人狼の囁き", emptyStrings())
        ;
        private static final Map<String, MessageType> _codeClsMap = new HashMap<String, MessageType>();
        private static final Map<String, MessageType> _nameClsMap = new HashMap<String, MessageType>();
        static {
            for (MessageType value : values()) {
                _codeClsMap.put(value.code().toLowerCase(), value);
                for (String sister : value.sisterSet()) { _codeClsMap.put(sister.toLowerCase(), value); }
                _nameClsMap.put(value.name().toLowerCase(), value);
            }
        }
        private String _code; private String _alias; private Set<String> _sisterSet;
        private MessageType(String code, String alias, String[] sisters)
        { _code = code; _alias = alias; _sisterSet = Collections.unmodifiableSet(new LinkedHashSet<String>(Arrays.asList(sisters))); }
        public String code() { return _code; } public String alias() { return _alias; }
        public Set<String> sisterSet() { return _sisterSet; }
        public Map<String, Object> subItemMap() { return Collections.emptyMap(); }
        public ClassificationMeta meta() { return CDef.DefMeta.MessageType; }

        public boolean inGroup(String groupName) {
            return false;
        }

        /**
         * Get the classification of the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns empty)
         * @return The optional classification corresponding to the code. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<MessageType> of(Object code) {
            if (code == null) { return OptionalThing.ofNullable(null, () -> { throw new ClassificationNotFoundException("null code specified"); }); }
            if (code instanceof MessageType) { return OptionalThing.of((MessageType)code); }
            if (code instanceof OptionalThing<?>) { return of(((OptionalThing<?>)code).orElse(null)); }
            return OptionalThing.ofNullable(_codeClsMap.get(code.toString().toLowerCase()), () ->{
                throw new ClassificationNotFoundException("Unknown classification code: " + code);
            });
        }

        /**
         * Find the classification by the name. (CaseInsensitive)
         * @param name The string of name, which is case-insensitive. (NotNull)
         * @return The optional classification corresponding to the name. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<MessageType> byName(String name) {
            if (name == null) { throw new IllegalArgumentException("The argument 'name' should not be null."); }
            return OptionalThing.ofNullable(_nameClsMap.get(name.toLowerCase()), () ->{
                throw new ClassificationNotFoundException("Unknown classification name: " + name);
            });
        }

        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use of(code).</span> <br>
         * Get the classification by the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the code. (NullAllowed: if not found, returns null)
         */
        public static MessageType codeOf(Object code) {
            if (code == null) { return null; }
            if (code instanceof MessageType) { return (MessageType)code; }
            return _codeClsMap.get(code.toString().toLowerCase());
        }

        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use byName(name).</span> <br>
         * Get the classification by the name (also called 'value' in ENUM world).
         * @param name The string of name, which is case-sensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the name. (NullAllowed: if not found, returns null)
         */
        public static MessageType nameOf(String name) {
            if (name == null) { return null; }
            try { return valueOf(name); } catch (RuntimeException ignored) { return null; }
        }

        /**
         * Get the list of all classification elements. (returns new copied list)
         * @return The snapshot list of all classification elements. (NotNull)
         */
        public static List<MessageType> listAll() {
            return new ArrayList<MessageType>(Arrays.asList(values()));
        }

        /**
         * Get the list of classification elements in the specified group. (returns new copied list) <br>
         * @param groupName The string of group name, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the group. (NotNull, EmptyAllowed: if not found, throws exception)
         */
        public static List<MessageType> listByGroup(String groupName) {
            if (groupName == null) { throw new IllegalArgumentException("The argument 'groupName' should not be null."); }
            throw new ClassificationNotFoundException("Unknown classification group: MessageType." + groupName);
        }

        /**
         * Get the list of classification elements corresponding to the specified codes. (returns new copied list) <br>
         * @param codeList The list of plain code, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the code list. (NotNull, EmptyAllowed: when empty specified)
         */
        public static List<MessageType> listOf(Collection<String> codeList) {
            if (codeList == null) { throw new IllegalArgumentException("The argument 'codeList' should not be null."); }
            List<MessageType> clsList = new ArrayList<MessageType>(codeList.size());
            for (String code : codeList) { clsList.add(of(code).get()); }
            return clsList;
        }

        /**
         * Get the list of classification elements in the specified group. (returns new copied list) <br>
         * @param groupName The string of group name, which is case-sensitive. (NullAllowed: if null, returns empty list)
         * @return The snapshot list of classification elements in the group. (NotNull, EmptyAllowed: if the group is not found)
         */
        public static List<MessageType> groupOf(String groupName) {
            return new ArrayList<MessageType>(4);
        }

        @Override public String toString() { return code(); }
    }

    /**
     * 死亡理由
     */
    public enum DeadReason implements CDef {
        /** 襲撃 */
        襲撃("ATTACK", "襲撃", emptyStrings())
        ,
        /** 呪殺 */
        呪殺("DIVINED", "呪殺", emptyStrings())
        ,
        /** 処刑 */
        処刑("EXECUTE", "処刑", emptyStrings())
        ,
        /** 突然 */
        突然("SUDDEN", "突然", emptyStrings())
        ,
        /** 後追 */
        後追("SUICIDE", "後追", emptyStrings())
        ;
        private static final Map<String, DeadReason> _codeClsMap = new HashMap<String, DeadReason>();
        private static final Map<String, DeadReason> _nameClsMap = new HashMap<String, DeadReason>();
        static {
            for (DeadReason value : values()) {
                _codeClsMap.put(value.code().toLowerCase(), value);
                for (String sister : value.sisterSet()) { _codeClsMap.put(sister.toLowerCase(), value); }
                _nameClsMap.put(value.name().toLowerCase(), value);
            }
        }
        private String _code; private String _alias; private Set<String> _sisterSet;
        private DeadReason(String code, String alias, String[] sisters)
        { _code = code; _alias = alias; _sisterSet = Collections.unmodifiableSet(new LinkedHashSet<String>(Arrays.asList(sisters))); }
        public String code() { return _code; } public String alias() { return _alias; }
        public Set<String> sisterSet() { return _sisterSet; }
        public Map<String, Object> subItemMap() { return Collections.emptyMap(); }
        public ClassificationMeta meta() { return CDef.DefMeta.DeadReason; }

        /**
         * Is the classification in the group? <br>
         * 無惨な死 <br>
         * The group elements:[襲撃, 呪殺]
         * @return The determination, true or false.
         */
        public boolean isMiserableDeath() {
            return 襲撃.equals(this) || 呪殺.equals(this);
        }

        /**
         * Is the classification in the group? <br>
         * 霊能判定可能な死因 <br>
         * The group elements:[処刑, 突然]
         * @return The determination, true or false.
         */
        public boolean isPsychicableDeath() {
            return 処刑.equals(this) || 突然.equals(this);
        }

        public boolean inGroup(String groupName) {
            if ("miserableDeath".equals(groupName)) { return isMiserableDeath(); }
            if ("psychicableDeath".equals(groupName)) { return isPsychicableDeath(); }
            return false;
        }

        /**
         * Get the classification of the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns empty)
         * @return The optional classification corresponding to the code. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<DeadReason> of(Object code) {
            if (code == null) { return OptionalThing.ofNullable(null, () -> { throw new ClassificationNotFoundException("null code specified"); }); }
            if (code instanceof DeadReason) { return OptionalThing.of((DeadReason)code); }
            if (code instanceof OptionalThing<?>) { return of(((OptionalThing<?>)code).orElse(null)); }
            return OptionalThing.ofNullable(_codeClsMap.get(code.toString().toLowerCase()), () ->{
                throw new ClassificationNotFoundException("Unknown classification code: " + code);
            });
        }

        /**
         * Find the classification by the name. (CaseInsensitive)
         * @param name The string of name, which is case-insensitive. (NotNull)
         * @return The optional classification corresponding to the name. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<DeadReason> byName(String name) {
            if (name == null) { throw new IllegalArgumentException("The argument 'name' should not be null."); }
            return OptionalThing.ofNullable(_nameClsMap.get(name.toLowerCase()), () ->{
                throw new ClassificationNotFoundException("Unknown classification name: " + name);
            });
        }

        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use of(code).</span> <br>
         * Get the classification by the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the code. (NullAllowed: if not found, returns null)
         */
        public static DeadReason codeOf(Object code) {
            if (code == null) { return null; }
            if (code instanceof DeadReason) { return (DeadReason)code; }
            return _codeClsMap.get(code.toString().toLowerCase());
        }

        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use byName(name).</span> <br>
         * Get the classification by the name (also called 'value' in ENUM world).
         * @param name The string of name, which is case-sensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the name. (NullAllowed: if not found, returns null)
         */
        public static DeadReason nameOf(String name) {
            if (name == null) { return null; }
            try { return valueOf(name); } catch (RuntimeException ignored) { return null; }
        }

        /**
         * Get the list of all classification elements. (returns new copied list)
         * @return The snapshot list of all classification elements. (NotNull)
         */
        public static List<DeadReason> listAll() {
            return new ArrayList<DeadReason>(Arrays.asList(values()));
        }

        /**
         * Get the list of classification elements in the specified group. (returns new copied list) <br>
         * @param groupName The string of group name, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the group. (NotNull, EmptyAllowed: if not found, throws exception)
         */
        public static List<DeadReason> listByGroup(String groupName) {
            if (groupName == null) { throw new IllegalArgumentException("The argument 'groupName' should not be null."); }
            if ("miserableDeath".equalsIgnoreCase(groupName)) { return listOfMiserableDeath(); }
            if ("psychicableDeath".equalsIgnoreCase(groupName)) { return listOfPsychicableDeath(); }
            throw new ClassificationNotFoundException("Unknown classification group: DeadReason." + groupName);
        }

        /**
         * Get the list of classification elements corresponding to the specified codes. (returns new copied list) <br>
         * @param codeList The list of plain code, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the code list. (NotNull, EmptyAllowed: when empty specified)
         */
        public static List<DeadReason> listOf(Collection<String> codeList) {
            if (codeList == null) { throw new IllegalArgumentException("The argument 'codeList' should not be null."); }
            List<DeadReason> clsList = new ArrayList<DeadReason>(codeList.size());
            for (String code : codeList) { clsList.add(of(code).get()); }
            return clsList;
        }

        /**
         * Get the list of group classification elements. (returns new copied list) <br>
         * 無惨な死 <br>
         * The group elements:[襲撃, 呪殺]
         * @return The snapshot list of classification elements in the group. (NotNull)
         */
        public static List<DeadReason> listOfMiserableDeath() {
            return new ArrayList<DeadReason>(Arrays.asList(襲撃, 呪殺));
        }

        /**
         * Get the list of group classification elements. (returns new copied list) <br>
         * 霊能判定可能な死因 <br>
         * The group elements:[処刑, 突然]
         * @return The snapshot list of classification elements in the group. (NotNull)
         */
        public static List<DeadReason> listOfPsychicableDeath() {
            return new ArrayList<DeadReason>(Arrays.asList(処刑, 突然));
        }

        /**
         * Get the list of classification elements in the specified group. (returns new copied list) <br>
         * @param groupName The string of group name, which is case-sensitive. (NullAllowed: if null, returns empty list)
         * @return The snapshot list of classification elements in the group. (NotNull, EmptyAllowed: if the group is not found)
         */
        public static List<DeadReason> groupOf(String groupName) {
            if ("miserableDeath".equals(groupName)) { return listOfMiserableDeath(); }
            if ("psychicableDeath".equals(groupName)) { return listOfPsychicableDeath(); }
            return new ArrayList<DeadReason>(4);
        }

        @Override public String toString() { return code(); }
    }

    /**
     * 能力種別
     */
    public enum AbilityType implements CDef {
        /** 襲撃 */
        襲撃("ATTACK", "襲撃", emptyStrings())
        ,
        /** 占い */
        占い("DIVINE", "占い", emptyStrings())
        ,
        /** 護衛 */
        護衛("GUARD", "護衛", emptyStrings())
        ;
        private static final Map<String, AbilityType> _codeClsMap = new HashMap<String, AbilityType>();
        private static final Map<String, AbilityType> _nameClsMap = new HashMap<String, AbilityType>();
        static {
            for (AbilityType value : values()) {
                _codeClsMap.put(value.code().toLowerCase(), value);
                for (String sister : value.sisterSet()) { _codeClsMap.put(sister.toLowerCase(), value); }
                _nameClsMap.put(value.name().toLowerCase(), value);
            }
        }
        private String _code; private String _alias; private Set<String> _sisterSet;
        private AbilityType(String code, String alias, String[] sisters)
        { _code = code; _alias = alias; _sisterSet = Collections.unmodifiableSet(new LinkedHashSet<String>(Arrays.asList(sisters))); }
        public String code() { return _code; } public String alias() { return _alias; }
        public Set<String> sisterSet() { return _sisterSet; }
        public Map<String, Object> subItemMap() { return Collections.emptyMap(); }
        public ClassificationMeta meta() { return CDef.DefMeta.AbilityType; }

        public boolean inGroup(String groupName) {
            return false;
        }

        /**
         * Get the classification of the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns empty)
         * @return The optional classification corresponding to the code. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<AbilityType> of(Object code) {
            if (code == null) { return OptionalThing.ofNullable(null, () -> { throw new ClassificationNotFoundException("null code specified"); }); }
            if (code instanceof AbilityType) { return OptionalThing.of((AbilityType)code); }
            if (code instanceof OptionalThing<?>) { return of(((OptionalThing<?>)code).orElse(null)); }
            return OptionalThing.ofNullable(_codeClsMap.get(code.toString().toLowerCase()), () ->{
                throw new ClassificationNotFoundException("Unknown classification code: " + code);
            });
        }

        /**
         * Find the classification by the name. (CaseInsensitive)
         * @param name The string of name, which is case-insensitive. (NotNull)
         * @return The optional classification corresponding to the name. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<AbilityType> byName(String name) {
            if (name == null) { throw new IllegalArgumentException("The argument 'name' should not be null."); }
            return OptionalThing.ofNullable(_nameClsMap.get(name.toLowerCase()), () ->{
                throw new ClassificationNotFoundException("Unknown classification name: " + name);
            });
        }

        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use of(code).</span> <br>
         * Get the classification by the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the code. (NullAllowed: if not found, returns null)
         */
        public static AbilityType codeOf(Object code) {
            if (code == null) { return null; }
            if (code instanceof AbilityType) { return (AbilityType)code; }
            return _codeClsMap.get(code.toString().toLowerCase());
        }

        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use byName(name).</span> <br>
         * Get the classification by the name (also called 'value' in ENUM world).
         * @param name The string of name, which is case-sensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the name. (NullAllowed: if not found, returns null)
         */
        public static AbilityType nameOf(String name) {
            if (name == null) { return null; }
            try { return valueOf(name); } catch (RuntimeException ignored) { return null; }
        }

        /**
         * Get the list of all classification elements. (returns new copied list)
         * @return The snapshot list of all classification elements. (NotNull)
         */
        public static List<AbilityType> listAll() {
            return new ArrayList<AbilityType>(Arrays.asList(values()));
        }

        /**
         * Get the list of classification elements in the specified group. (returns new copied list) <br>
         * @param groupName The string of group name, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the group. (NotNull, EmptyAllowed: if not found, throws exception)
         */
        public static List<AbilityType> listByGroup(String groupName) {
            if (groupName == null) { throw new IllegalArgumentException("The argument 'groupName' should not be null."); }
            throw new ClassificationNotFoundException("Unknown classification group: AbilityType." + groupName);
        }

        /**
         * Get the list of classification elements corresponding to the specified codes. (returns new copied list) <br>
         * @param codeList The list of plain code, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the code list. (NotNull, EmptyAllowed: when empty specified)
         */
        public static List<AbilityType> listOf(Collection<String> codeList) {
            if (codeList == null) { throw new IllegalArgumentException("The argument 'codeList' should not be null."); }
            List<AbilityType> clsList = new ArrayList<AbilityType>(codeList.size());
            for (String code : codeList) { clsList.add(of(code).get()); }
            return clsList;
        }

        /**
         * Get the list of classification elements in the specified group. (returns new copied list) <br>
         * @param groupName The string of group name, which is case-sensitive. (NullAllowed: if null, returns empty list)
         * @return The snapshot list of classification elements in the group. (NotNull, EmptyAllowed: if the group is not found)
         */
        public static List<AbilityType> groupOf(String groupName) {
            return new ArrayList<AbilityType>(4);
        }

        @Override public String toString() { return code(); }
    }

    /**
     * 表情種別
     */
    public enum FaceType implements CDef {
        /** 墓下 */
        墓下("GRAVE", "墓下", emptyStrings())
        ,
        /** 共鳴 */
        共鳴("MASON", "共鳴", emptyStrings())
        ,
        /** 独り言 */
        独り言("MONOLOGUE", "独り言", emptyStrings())
        ,
        /** 通常 */
        通常("NORMAL", "通常", emptyStrings())
        ,
        /** 秘話 */
        秘話("SECRET", "秘話", emptyStrings())
        ,
        /** 囁き */
        囁き("WEREWOLF", "囁き", emptyStrings())
        ;
        private static final Map<String, FaceType> _codeClsMap = new HashMap<String, FaceType>();
        private static final Map<String, FaceType> _nameClsMap = new HashMap<String, FaceType>();
        static {
            for (FaceType value : values()) {
                _codeClsMap.put(value.code().toLowerCase(), value);
                for (String sister : value.sisterSet()) { _codeClsMap.put(sister.toLowerCase(), value); }
                _nameClsMap.put(value.name().toLowerCase(), value);
            }
        }
        private String _code; private String _alias; private Set<String> _sisterSet;
        private FaceType(String code, String alias, String[] sisters)
        { _code = code; _alias = alias; _sisterSet = Collections.unmodifiableSet(new LinkedHashSet<String>(Arrays.asList(sisters))); }
        public String code() { return _code; } public String alias() { return _alias; }
        public Set<String> sisterSet() { return _sisterSet; }
        public Map<String, Object> subItemMap() { return Collections.emptyMap(); }
        public ClassificationMeta meta() { return CDef.DefMeta.FaceType; }

        public boolean inGroup(String groupName) {
            return false;
        }

        /**
         * Get the classification of the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns empty)
         * @return The optional classification corresponding to the code. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<FaceType> of(Object code) {
            if (code == null) { return OptionalThing.ofNullable(null, () -> { throw new ClassificationNotFoundException("null code specified"); }); }
            if (code instanceof FaceType) { return OptionalThing.of((FaceType)code); }
            if (code instanceof OptionalThing<?>) { return of(((OptionalThing<?>)code).orElse(null)); }
            return OptionalThing.ofNullable(_codeClsMap.get(code.toString().toLowerCase()), () ->{
                throw new ClassificationNotFoundException("Unknown classification code: " + code);
            });
        }

        /**
         * Find the classification by the name. (CaseInsensitive)
         * @param name The string of name, which is case-insensitive. (NotNull)
         * @return The optional classification corresponding to the name. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<FaceType> byName(String name) {
            if (name == null) { throw new IllegalArgumentException("The argument 'name' should not be null."); }
            return OptionalThing.ofNullable(_nameClsMap.get(name.toLowerCase()), () ->{
                throw new ClassificationNotFoundException("Unknown classification name: " + name);
            });
        }

        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use of(code).</span> <br>
         * Get the classification by the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the code. (NullAllowed: if not found, returns null)
         */
        public static FaceType codeOf(Object code) {
            if (code == null) { return null; }
            if (code instanceof FaceType) { return (FaceType)code; }
            return _codeClsMap.get(code.toString().toLowerCase());
        }

        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use byName(name).</span> <br>
         * Get the classification by the name (also called 'value' in ENUM world).
         * @param name The string of name, which is case-sensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the name. (NullAllowed: if not found, returns null)
         */
        public static FaceType nameOf(String name) {
            if (name == null) { return null; }
            try { return valueOf(name); } catch (RuntimeException ignored) { return null; }
        }

        /**
         * Get the list of all classification elements. (returns new copied list)
         * @return The snapshot list of all classification elements. (NotNull)
         */
        public static List<FaceType> listAll() {
            return new ArrayList<FaceType>(Arrays.asList(values()));
        }

        /**
         * Get the list of classification elements in the specified group. (returns new copied list) <br>
         * @param groupName The string of group name, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the group. (NotNull, EmptyAllowed: if not found, throws exception)
         */
        public static List<FaceType> listByGroup(String groupName) {
            if (groupName == null) { throw new IllegalArgumentException("The argument 'groupName' should not be null."); }
            throw new ClassificationNotFoundException("Unknown classification group: FaceType." + groupName);
        }

        /**
         * Get the list of classification elements corresponding to the specified codes. (returns new copied list) <br>
         * @param codeList The list of plain code, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the code list. (NotNull, EmptyAllowed: when empty specified)
         */
        public static List<FaceType> listOf(Collection<String> codeList) {
            if (codeList == null) { throw new IllegalArgumentException("The argument 'codeList' should not be null."); }
            List<FaceType> clsList = new ArrayList<FaceType>(codeList.size());
            for (String code : codeList) { clsList.add(of(code).get()); }
            return clsList;
        }

        /**
         * Get the list of classification elements in the specified group. (returns new copied list) <br>
         * @param groupName The string of group name, which is case-sensitive. (NullAllowed: if null, returns empty list)
         * @return The snapshot list of classification elements in the group. (NotNull, EmptyAllowed: if the group is not found)
         */
        public static List<FaceType> groupOf(String groupName) {
            return new ArrayList<FaceType>(4);
        }

        @Override public String toString() { return code(); }
    }

    /**
     * 村設定項目
     */
    public enum VillageSettingItem implements CDef {
        /** キャラクターグループID */
        キャラクターグループid("character_group_id", "キャラクターグループID", emptyStrings())
        ,
        /** 更新間隔秒 */
        更新間隔秒("day_change_interval_seconds", "更新間隔秒", emptyStrings())
        ,
        /** ダミーキャラID */
        ダミーキャラid("dummy_chara_id", "ダミーキャラID", emptyStrings())
        ,
        /** 自動生成村か */
        自動生成村か("is_auto_generated", "自動生成村か", emptyStrings())
        ,
        /** コミット可能か */
        コミット可能か("is_available_commit", "コミット可能か", emptyStrings())
        ,
        /** 役欠けありか */
        役欠けありか("is_available_dummy_skill", "役欠けありか", emptyStrings())
        ,
        /** 役職希望可能か */
        役職希望可能か("is_available_skill_request", "役職希望可能か", emptyStrings())
        ,
        /** 見学可能か */
        見学可能か("is_available_spectate", "見学可能か", emptyStrings())
        ,
        /** 突然死ありか */
        突然死ありか("is_available_suddenly_death", "突然死ありか", emptyStrings())
        ,
        /** 初心者村か */
        初心者村か("is_for_beginner", "初心者村か", emptyStrings())
        ,
        /** 墓下役職公開ありか */
        墓下役職公開ありか("is_open_skill_in_grave", "墓下役職公開ありか", emptyStrings())
        ,
        /** 記名投票か */
        記名投票か("is_open_vote", "記名投票か", emptyStrings())
        ,
        /** 墓下見学発言を生存者が見られるか */
        墓下見学発言を生存者が見られるか("is_visible_grave_message", "墓下見学発言を生存者が見られるか", emptyStrings())
        ,
        /** 入村パスワード */
        入村パスワード("join_password", "入村パスワード", emptyStrings())
        ,
        /** 構成 */
        構成("organize", "構成", emptyStrings())
        ,
        /** 最大人数 */
        最大人数("person_max", "最大人数", emptyStrings())
        ,
        /** 最低人数 */
        最低人数("person_min", "最低人数", emptyStrings())
        ,
        /** 沈黙時間 */
        沈黙時間("silent_hours", "沈黙時間", emptyStrings())
        ,
        /** 開始予定日時 */
        開始予定日時("start_datetime", "開始予定日時", emptyStrings())
        ,
        /** 期間形式 */
        期間形式("term_type", "期間形式", emptyStrings())
        ;
        private static final Map<String, VillageSettingItem> _codeClsMap = new HashMap<String, VillageSettingItem>();
        private static final Map<String, VillageSettingItem> _nameClsMap = new HashMap<String, VillageSettingItem>();
        static {
            for (VillageSettingItem value : values()) {
                _codeClsMap.put(value.code().toLowerCase(), value);
                for (String sister : value.sisterSet()) { _codeClsMap.put(sister.toLowerCase(), value); }
                _nameClsMap.put(value.name().toLowerCase(), value);
            }
        }
        private String _code; private String _alias; private Set<String> _sisterSet;
        private VillageSettingItem(String code, String alias, String[] sisters)
        { _code = code; _alias = alias; _sisterSet = Collections.unmodifiableSet(new LinkedHashSet<String>(Arrays.asList(sisters))); }
        public String code() { return _code; } public String alias() { return _alias; }
        public Set<String> sisterSet() { return _sisterSet; }
        public Map<String, Object> subItemMap() { return Collections.emptyMap(); }
        public ClassificationMeta meta() { return CDef.DefMeta.VillageSettingItem; }

        public boolean inGroup(String groupName) {
            return false;
        }

        /**
         * Get the classification of the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns empty)
         * @return The optional classification corresponding to the code. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<VillageSettingItem> of(Object code) {
            if (code == null) { return OptionalThing.ofNullable(null, () -> { throw new ClassificationNotFoundException("null code specified"); }); }
            if (code instanceof VillageSettingItem) { return OptionalThing.of((VillageSettingItem)code); }
            if (code instanceof OptionalThing<?>) { return of(((OptionalThing<?>)code).orElse(null)); }
            return OptionalThing.ofNullable(_codeClsMap.get(code.toString().toLowerCase()), () ->{
                throw new ClassificationNotFoundException("Unknown classification code: " + code);
            });
        }

        /**
         * Find the classification by the name. (CaseInsensitive)
         * @param name The string of name, which is case-insensitive. (NotNull)
         * @return The optional classification corresponding to the name. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<VillageSettingItem> byName(String name) {
            if (name == null) { throw new IllegalArgumentException("The argument 'name' should not be null."); }
            return OptionalThing.ofNullable(_nameClsMap.get(name.toLowerCase()), () ->{
                throw new ClassificationNotFoundException("Unknown classification name: " + name);
            });
        }

        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use of(code).</span> <br>
         * Get the classification by the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the code. (NullAllowed: if not found, returns null)
         */
        public static VillageSettingItem codeOf(Object code) {
            if (code == null) { return null; }
            if (code instanceof VillageSettingItem) { return (VillageSettingItem)code; }
            return _codeClsMap.get(code.toString().toLowerCase());
        }

        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use byName(name).</span> <br>
         * Get the classification by the name (also called 'value' in ENUM world).
         * @param name The string of name, which is case-sensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the name. (NullAllowed: if not found, returns null)
         */
        public static VillageSettingItem nameOf(String name) {
            if (name == null) { return null; }
            try { return valueOf(name); } catch (RuntimeException ignored) { return null; }
        }

        /**
         * Get the list of all classification elements. (returns new copied list)
         * @return The snapshot list of all classification elements. (NotNull)
         */
        public static List<VillageSettingItem> listAll() {
            return new ArrayList<VillageSettingItem>(Arrays.asList(values()));
        }

        /**
         * Get the list of classification elements in the specified group. (returns new copied list) <br>
         * @param groupName The string of group name, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the group. (NotNull, EmptyAllowed: if not found, throws exception)
         */
        public static List<VillageSettingItem> listByGroup(String groupName) {
            if (groupName == null) { throw new IllegalArgumentException("The argument 'groupName' should not be null."); }
            throw new ClassificationNotFoundException("Unknown classification group: VillageSettingItem." + groupName);
        }

        /**
         * Get the list of classification elements corresponding to the specified codes. (returns new copied list) <br>
         * @param codeList The list of plain code, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the code list. (NotNull, EmptyAllowed: when empty specified)
         */
        public static List<VillageSettingItem> listOf(Collection<String> codeList) {
            if (codeList == null) { throw new IllegalArgumentException("The argument 'codeList' should not be null."); }
            List<VillageSettingItem> clsList = new ArrayList<VillageSettingItem>(codeList.size());
            for (String code : codeList) { clsList.add(of(code).get()); }
            return clsList;
        }

        /**
         * Get the list of classification elements in the specified group. (returns new copied list) <br>
         * @param groupName The string of group name, which is case-sensitive. (NullAllowed: if null, returns empty list)
         * @return The snapshot list of classification elements in the group. (NotNull, EmptyAllowed: if the group is not found)
         */
        public static List<VillageSettingItem> groupOf(String groupName) {
            return new ArrayList<VillageSettingItem>(4);
        }

        @Override public String toString() { return code(); }
    }

    /**
     * 昼夜
     */
    public enum Noonnight implements CDef {
        /** 夜 */
        夜("NIGHT", "夜", emptyStrings())
        ,
        /** 昼 */
        昼("NOON", "昼", emptyStrings())
        ;
        private static final Map<String, Noonnight> _codeClsMap = new HashMap<String, Noonnight>();
        private static final Map<String, Noonnight> _nameClsMap = new HashMap<String, Noonnight>();
        static {
            for (Noonnight value : values()) {
                _codeClsMap.put(value.code().toLowerCase(), value);
                for (String sister : value.sisterSet()) { _codeClsMap.put(sister.toLowerCase(), value); }
                _nameClsMap.put(value.name().toLowerCase(), value);
            }
        }
        private String _code; private String _alias; private Set<String> _sisterSet;
        private Noonnight(String code, String alias, String[] sisters)
        { _code = code; _alias = alias; _sisterSet = Collections.unmodifiableSet(new LinkedHashSet<String>(Arrays.asList(sisters))); }
        public String code() { return _code; } public String alias() { return _alias; }
        public Set<String> sisterSet() { return _sisterSet; }
        public Map<String, Object> subItemMap() { return Collections.emptyMap(); }
        public ClassificationMeta meta() { return CDef.DefMeta.Noonnight; }

        public boolean inGroup(String groupName) {
            return false;
        }

        /**
         * Get the classification of the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns empty)
         * @return The optional classification corresponding to the code. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<Noonnight> of(Object code) {
            if (code == null) { return OptionalThing.ofNullable(null, () -> { throw new ClassificationNotFoundException("null code specified"); }); }
            if (code instanceof Noonnight) { return OptionalThing.of((Noonnight)code); }
            if (code instanceof OptionalThing<?>) { return of(((OptionalThing<?>)code).orElse(null)); }
            return OptionalThing.ofNullable(_codeClsMap.get(code.toString().toLowerCase()), () ->{
                throw new ClassificationNotFoundException("Unknown classification code: " + code);
            });
        }

        /**
         * Find the classification by the name. (CaseInsensitive)
         * @param name The string of name, which is case-insensitive. (NotNull)
         * @return The optional classification corresponding to the name. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<Noonnight> byName(String name) {
            if (name == null) { throw new IllegalArgumentException("The argument 'name' should not be null."); }
            return OptionalThing.ofNullable(_nameClsMap.get(name.toLowerCase()), () ->{
                throw new ClassificationNotFoundException("Unknown classification name: " + name);
            });
        }

        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use of(code).</span> <br>
         * Get the classification by the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the code. (NullAllowed: if not found, returns null)
         */
        public static Noonnight codeOf(Object code) {
            if (code == null) { return null; }
            if (code instanceof Noonnight) { return (Noonnight)code; }
            return _codeClsMap.get(code.toString().toLowerCase());
        }

        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use byName(name).</span> <br>
         * Get the classification by the name (also called 'value' in ENUM world).
         * @param name The string of name, which is case-sensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the name. (NullAllowed: if not found, returns null)
         */
        public static Noonnight nameOf(String name) {
            if (name == null) { return null; }
            try { return valueOf(name); } catch (RuntimeException ignored) { return null; }
        }

        /**
         * Get the list of all classification elements. (returns new copied list)
         * @return The snapshot list of all classification elements. (NotNull)
         */
        public static List<Noonnight> listAll() {
            return new ArrayList<Noonnight>(Arrays.asList(values()));
        }

        /**
         * Get the list of classification elements in the specified group. (returns new copied list) <br>
         * @param groupName The string of group name, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the group. (NotNull, EmptyAllowed: if not found, throws exception)
         */
        public static List<Noonnight> listByGroup(String groupName) {
            if (groupName == null) { throw new IllegalArgumentException("The argument 'groupName' should not be null."); }
            throw new ClassificationNotFoundException("Unknown classification group: Noonnight." + groupName);
        }

        /**
         * Get the list of classification elements corresponding to the specified codes. (returns new copied list) <br>
         * @param codeList The list of plain code, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the code list. (NotNull, EmptyAllowed: when empty specified)
         */
        public static List<Noonnight> listOf(Collection<String> codeList) {
            if (codeList == null) { throw new IllegalArgumentException("The argument 'codeList' should not be null."); }
            List<Noonnight> clsList = new ArrayList<Noonnight>(codeList.size());
            for (String code : codeList) { clsList.add(of(code).get()); }
            return clsList;
        }

        /**
         * Get the list of classification elements in the specified group. (returns new copied list) <br>
         * @param groupName The string of group name, which is case-sensitive. (NullAllowed: if null, returns empty list)
         * @return The snapshot list of classification elements in the group. (NotNull, EmptyAllowed: if the group is not found)
         */
        public static List<Noonnight> groupOf(String groupName) {
            return new ArrayList<Noonnight>(4);
        }

        @Override public String toString() { return code(); }
    }

    /**
     * 期間
     */
    public enum Term implements CDef {
        /** 長期: 長期人狼 */
        長期("LONG", "長期", emptyStrings())
        ,
        /** 短期: 短期人狼 */
        短期("SHORT", "短期", emptyStrings())
        ;
        private static final Map<String, Term> _codeClsMap = new HashMap<String, Term>();
        private static final Map<String, Term> _nameClsMap = new HashMap<String, Term>();
        static {
            for (Term value : values()) {
                _codeClsMap.put(value.code().toLowerCase(), value);
                for (String sister : value.sisterSet()) { _codeClsMap.put(sister.toLowerCase(), value); }
                _nameClsMap.put(value.name().toLowerCase(), value);
            }
        }
        private String _code; private String _alias; private Set<String> _sisterSet;
        private Term(String code, String alias, String[] sisters)
        { _code = code; _alias = alias; _sisterSet = Collections.unmodifiableSet(new LinkedHashSet<String>(Arrays.asList(sisters))); }
        public String code() { return _code; } public String alias() { return _alias; }
        public Set<String> sisterSet() { return _sisterSet; }
        public Map<String, Object> subItemMap() { return Collections.emptyMap(); }
        public ClassificationMeta meta() { return CDef.DefMeta.Term; }

        public boolean inGroup(String groupName) {
            return false;
        }

        /**
         * Get the classification of the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns empty)
         * @return The optional classification corresponding to the code. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<Term> of(Object code) {
            if (code == null) { return OptionalThing.ofNullable(null, () -> { throw new ClassificationNotFoundException("null code specified"); }); }
            if (code instanceof Term) { return OptionalThing.of((Term)code); }
            if (code instanceof OptionalThing<?>) { return of(((OptionalThing<?>)code).orElse(null)); }
            return OptionalThing.ofNullable(_codeClsMap.get(code.toString().toLowerCase()), () ->{
                throw new ClassificationNotFoundException("Unknown classification code: " + code);
            });
        }

        /**
         * Find the classification by the name. (CaseInsensitive)
         * @param name The string of name, which is case-insensitive. (NotNull)
         * @return The optional classification corresponding to the name. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<Term> byName(String name) {
            if (name == null) { throw new IllegalArgumentException("The argument 'name' should not be null."); }
            return OptionalThing.ofNullable(_nameClsMap.get(name.toLowerCase()), () ->{
                throw new ClassificationNotFoundException("Unknown classification name: " + name);
            });
        }

        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use of(code).</span> <br>
         * Get the classification by the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the code. (NullAllowed: if not found, returns null)
         */
        public static Term codeOf(Object code) {
            if (code == null) { return null; }
            if (code instanceof Term) { return (Term)code; }
            return _codeClsMap.get(code.toString().toLowerCase());
        }

        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use byName(name).</span> <br>
         * Get the classification by the name (also called 'value' in ENUM world).
         * @param name The string of name, which is case-sensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the name. (NullAllowed: if not found, returns null)
         */
        public static Term nameOf(String name) {
            if (name == null) { return null; }
            try { return valueOf(name); } catch (RuntimeException ignored) { return null; }
        }

        /**
         * Get the list of all classification elements. (returns new copied list)
         * @return The snapshot list of all classification elements. (NotNull)
         */
        public static List<Term> listAll() {
            return new ArrayList<Term>(Arrays.asList(values()));
        }

        /**
         * Get the list of classification elements in the specified group. (returns new copied list) <br>
         * @param groupName The string of group name, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the group. (NotNull, EmptyAllowed: if not found, throws exception)
         */
        public static List<Term> listByGroup(String groupName) {
            if (groupName == null) { throw new IllegalArgumentException("The argument 'groupName' should not be null."); }
            throw new ClassificationNotFoundException("Unknown classification group: Term." + groupName);
        }

        /**
         * Get the list of classification elements corresponding to the specified codes. (returns new copied list) <br>
         * @param codeList The list of plain code, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the code list. (NotNull, EmptyAllowed: when empty specified)
         */
        public static List<Term> listOf(Collection<String> codeList) {
            if (codeList == null) { throw new IllegalArgumentException("The argument 'codeList' should not be null."); }
            List<Term> clsList = new ArrayList<Term>(codeList.size());
            for (String code : codeList) { clsList.add(of(code).get()); }
            return clsList;
        }

        /**
         * Get the list of classification elements in the specified group. (returns new copied list) <br>
         * @param groupName The string of group name, which is case-sensitive. (NullAllowed: if null, returns empty list)
         * @return The snapshot list of classification elements in the group. (NotNull, EmptyAllowed: if the group is not found)
         */
        public static List<Term> groupOf(String groupName) {
            return new ArrayList<Term>(4);
        }

        @Override public String toString() { return code(); }
    }

    public enum DefMeta implements ClassificationMeta {
        /** 権限 */
        Authority
        ,
        /** 陣営 */
        Camp
        ,
        /** 村ステータス */
        VillageStatus
        ,
        /** 役職 */
        Skill
        ,
        /** メッセージ種別 */
        MessageType
        ,
        /** 死亡理由 */
        DeadReason
        ,
        /** 能力種別 */
        AbilityType
        ,
        /** 表情種別 */
        FaceType
        ,
        /** 村設定項目 */
        VillageSettingItem
        ,
        /** 昼夜 */
        Noonnight
        ,
        /** 期間 */
        Term
        ;
        public String classificationName() {
            return name(); // same as definition name
        }

        public OptionalThing<? extends Classification> of(Object code) {
            if (Authority.name().equals(name())) { return CDef.Authority.of(code); }
            if (Camp.name().equals(name())) { return CDef.Camp.of(code); }
            if (VillageStatus.name().equals(name())) { return CDef.VillageStatus.of(code); }
            if (Skill.name().equals(name())) { return CDef.Skill.of(code); }
            if (MessageType.name().equals(name())) { return CDef.MessageType.of(code); }
            if (DeadReason.name().equals(name())) { return CDef.DeadReason.of(code); }
            if (AbilityType.name().equals(name())) { return CDef.AbilityType.of(code); }
            if (FaceType.name().equals(name())) { return CDef.FaceType.of(code); }
            if (VillageSettingItem.name().equals(name())) { return CDef.VillageSettingItem.of(code); }
            if (Noonnight.name().equals(name())) { return CDef.Noonnight.of(code); }
            if (Term.name().equals(name())) { return CDef.Term.of(code); }
            throw new IllegalStateException("Unknown definition: " + this); // basically unreachable
        }

        public OptionalThing<? extends Classification> byName(String name) {
            if (Authority.name().equals(name())) { return CDef.Authority.byName(name); }
            if (Camp.name().equals(name())) { return CDef.Camp.byName(name); }
            if (VillageStatus.name().equals(name())) { return CDef.VillageStatus.byName(name); }
            if (Skill.name().equals(name())) { return CDef.Skill.byName(name); }
            if (MessageType.name().equals(name())) { return CDef.MessageType.byName(name); }
            if (DeadReason.name().equals(name())) { return CDef.DeadReason.byName(name); }
            if (AbilityType.name().equals(name())) { return CDef.AbilityType.byName(name); }
            if (FaceType.name().equals(name())) { return CDef.FaceType.byName(name); }
            if (VillageSettingItem.name().equals(name())) { return CDef.VillageSettingItem.byName(name); }
            if (Noonnight.name().equals(name())) { return CDef.Noonnight.byName(name); }
            if (Term.name().equals(name())) { return CDef.Term.byName(name); }
            throw new IllegalStateException("Unknown definition: " + this); // basically unreachable
        }

        public Classification codeOf(Object code) { // null if not found, old style so use of(code)
            if (Authority.name().equals(name())) { return CDef.Authority.codeOf(code); }
            if (Camp.name().equals(name())) { return CDef.Camp.codeOf(code); }
            if (VillageStatus.name().equals(name())) { return CDef.VillageStatus.codeOf(code); }
            if (Skill.name().equals(name())) { return CDef.Skill.codeOf(code); }
            if (MessageType.name().equals(name())) { return CDef.MessageType.codeOf(code); }
            if (DeadReason.name().equals(name())) { return CDef.DeadReason.codeOf(code); }
            if (AbilityType.name().equals(name())) { return CDef.AbilityType.codeOf(code); }
            if (FaceType.name().equals(name())) { return CDef.FaceType.codeOf(code); }
            if (VillageSettingItem.name().equals(name())) { return CDef.VillageSettingItem.codeOf(code); }
            if (Noonnight.name().equals(name())) { return CDef.Noonnight.codeOf(code); }
            if (Term.name().equals(name())) { return CDef.Term.codeOf(code); }
            throw new IllegalStateException("Unknown definition: " + this); // basically unreachable
        }

        public Classification nameOf(String name) { // null if not found, old style so use byName(name)
            if (Authority.name().equals(name())) { return CDef.Authority.valueOf(name); }
            if (Camp.name().equals(name())) { return CDef.Camp.valueOf(name); }
            if (VillageStatus.name().equals(name())) { return CDef.VillageStatus.valueOf(name); }
            if (Skill.name().equals(name())) { return CDef.Skill.valueOf(name); }
            if (MessageType.name().equals(name())) { return CDef.MessageType.valueOf(name); }
            if (DeadReason.name().equals(name())) { return CDef.DeadReason.valueOf(name); }
            if (AbilityType.name().equals(name())) { return CDef.AbilityType.valueOf(name); }
            if (FaceType.name().equals(name())) { return CDef.FaceType.valueOf(name); }
            if (VillageSettingItem.name().equals(name())) { return CDef.VillageSettingItem.valueOf(name); }
            if (Noonnight.name().equals(name())) { return CDef.Noonnight.valueOf(name); }
            if (Term.name().equals(name())) { return CDef.Term.valueOf(name); }
            throw new IllegalStateException("Unknown definition: " + this); // basically unreachable
        }

        public List<Classification> listAll() {
            if (Authority.name().equals(name())) { return toClsList(CDef.Authority.listAll()); }
            if (Camp.name().equals(name())) { return toClsList(CDef.Camp.listAll()); }
            if (VillageStatus.name().equals(name())) { return toClsList(CDef.VillageStatus.listAll()); }
            if (Skill.name().equals(name())) { return toClsList(CDef.Skill.listAll()); }
            if (MessageType.name().equals(name())) { return toClsList(CDef.MessageType.listAll()); }
            if (DeadReason.name().equals(name())) { return toClsList(CDef.DeadReason.listAll()); }
            if (AbilityType.name().equals(name())) { return toClsList(CDef.AbilityType.listAll()); }
            if (FaceType.name().equals(name())) { return toClsList(CDef.FaceType.listAll()); }
            if (VillageSettingItem.name().equals(name())) { return toClsList(CDef.VillageSettingItem.listAll()); }
            if (Noonnight.name().equals(name())) { return toClsList(CDef.Noonnight.listAll()); }
            if (Term.name().equals(name())) { return toClsList(CDef.Term.listAll()); }
            throw new IllegalStateException("Unknown definition: " + this); // basically unreachable
        }

        public List<Classification> listByGroup(String groupName) { // exception if not found
            if (Authority.name().equals(name())) { return toClsList(CDef.Authority.listByGroup(groupName)); }
            if (Camp.name().equals(name())) { return toClsList(CDef.Camp.listByGroup(groupName)); }
            if (VillageStatus.name().equals(name())) { return toClsList(CDef.VillageStatus.listByGroup(groupName)); }
            if (Skill.name().equals(name())) { return toClsList(CDef.Skill.listByGroup(groupName)); }
            if (MessageType.name().equals(name())) { return toClsList(CDef.MessageType.listByGroup(groupName)); }
            if (DeadReason.name().equals(name())) { return toClsList(CDef.DeadReason.listByGroup(groupName)); }
            if (AbilityType.name().equals(name())) { return toClsList(CDef.AbilityType.listByGroup(groupName)); }
            if (FaceType.name().equals(name())) { return toClsList(CDef.FaceType.listByGroup(groupName)); }
            if (VillageSettingItem.name().equals(name())) { return toClsList(CDef.VillageSettingItem.listByGroup(groupName)); }
            if (Noonnight.name().equals(name())) { return toClsList(CDef.Noonnight.listByGroup(groupName)); }
            if (Term.name().equals(name())) { return toClsList(CDef.Term.listByGroup(groupName)); }
            throw new IllegalStateException("Unknown definition: " + this); // basically unreachable
        }

        public List<Classification> listOf(Collection<String> codeList) {
            if (Authority.name().equals(name())) { return toClsList(CDef.Authority.listOf(codeList)); }
            if (Camp.name().equals(name())) { return toClsList(CDef.Camp.listOf(codeList)); }
            if (VillageStatus.name().equals(name())) { return toClsList(CDef.VillageStatus.listOf(codeList)); }
            if (Skill.name().equals(name())) { return toClsList(CDef.Skill.listOf(codeList)); }
            if (MessageType.name().equals(name())) { return toClsList(CDef.MessageType.listOf(codeList)); }
            if (DeadReason.name().equals(name())) { return toClsList(CDef.DeadReason.listOf(codeList)); }
            if (AbilityType.name().equals(name())) { return toClsList(CDef.AbilityType.listOf(codeList)); }
            if (FaceType.name().equals(name())) { return toClsList(CDef.FaceType.listOf(codeList)); }
            if (VillageSettingItem.name().equals(name())) { return toClsList(CDef.VillageSettingItem.listOf(codeList)); }
            if (Noonnight.name().equals(name())) { return toClsList(CDef.Noonnight.listOf(codeList)); }
            if (Term.name().equals(name())) { return toClsList(CDef.Term.listOf(codeList)); }
            throw new IllegalStateException("Unknown definition: " + this); // basically unreachable
        }

        public List<Classification> groupOf(String groupName) { // old style
            if (Authority.name().equals(name())) { return toClsList(CDef.Authority.groupOf(groupName)); }
            if (Camp.name().equals(name())) { return toClsList(CDef.Camp.groupOf(groupName)); }
            if (VillageStatus.name().equals(name())) { return toClsList(CDef.VillageStatus.groupOf(groupName)); }
            if (Skill.name().equals(name())) { return toClsList(CDef.Skill.groupOf(groupName)); }
            if (MessageType.name().equals(name())) { return toClsList(CDef.MessageType.groupOf(groupName)); }
            if (DeadReason.name().equals(name())) { return toClsList(CDef.DeadReason.groupOf(groupName)); }
            if (AbilityType.name().equals(name())) { return toClsList(CDef.AbilityType.groupOf(groupName)); }
            if (FaceType.name().equals(name())) { return toClsList(CDef.FaceType.groupOf(groupName)); }
            if (VillageSettingItem.name().equals(name())) { return toClsList(CDef.VillageSettingItem.groupOf(groupName)); }
            if (Noonnight.name().equals(name())) { return toClsList(CDef.Noonnight.groupOf(groupName)); }
            if (Term.name().equals(name())) { return toClsList(CDef.Term.groupOf(groupName)); }
            throw new IllegalStateException("Unknown definition: " + this); // basically unreachable
        }

        @SuppressWarnings("unchecked")
        private List<Classification> toClsList(List<?> clsList) {
            return (List<Classification>)clsList;
        }

        public ClassificationCodeType codeType() {
            if (Authority.name().equals(name())) { return ClassificationCodeType.String; }
            if (Camp.name().equals(name())) { return ClassificationCodeType.String; }
            if (VillageStatus.name().equals(name())) { return ClassificationCodeType.String; }
            if (Skill.name().equals(name())) { return ClassificationCodeType.String; }
            if (MessageType.name().equals(name())) { return ClassificationCodeType.String; }
            if (DeadReason.name().equals(name())) { return ClassificationCodeType.String; }
            if (AbilityType.name().equals(name())) { return ClassificationCodeType.String; }
            if (FaceType.name().equals(name())) { return ClassificationCodeType.String; }
            if (VillageSettingItem.name().equals(name())) { return ClassificationCodeType.String; }
            if (Noonnight.name().equals(name())) { return ClassificationCodeType.String; }
            if (Term.name().equals(name())) { return ClassificationCodeType.String; }
            return ClassificationCodeType.String; // as default
        }

        public ClassificationUndefinedHandlingType undefinedHandlingType() {
            if (Authority.name().equals(name())) { return ClassificationUndefinedHandlingType.LOGGING; }
            if (Camp.name().equals(name())) { return ClassificationUndefinedHandlingType.LOGGING; }
            if (VillageStatus.name().equals(name())) { return ClassificationUndefinedHandlingType.LOGGING; }
            if (Skill.name().equals(name())) { return ClassificationUndefinedHandlingType.LOGGING; }
            if (MessageType.name().equals(name())) { return ClassificationUndefinedHandlingType.LOGGING; }
            if (DeadReason.name().equals(name())) { return ClassificationUndefinedHandlingType.LOGGING; }
            if (AbilityType.name().equals(name())) { return ClassificationUndefinedHandlingType.LOGGING; }
            if (FaceType.name().equals(name())) { return ClassificationUndefinedHandlingType.LOGGING; }
            if (VillageSettingItem.name().equals(name())) { return ClassificationUndefinedHandlingType.LOGGING; }
            if (Noonnight.name().equals(name())) { return ClassificationUndefinedHandlingType.LOGGING; }
            if (Term.name().equals(name())) { return ClassificationUndefinedHandlingType.LOGGING; }
            return ClassificationUndefinedHandlingType.LOGGING; // as default
        }

        public static OptionalThing<CDef.DefMeta> find(String classificationName) { // instead of valueOf()
            if (classificationName == null) { throw new IllegalArgumentException("The argument 'classificationName' should not be null."); }
            if (Authority.name().equalsIgnoreCase(classificationName)) { return OptionalThing.of(CDef.DefMeta.Authority); }
            if (Camp.name().equalsIgnoreCase(classificationName)) { return OptionalThing.of(CDef.DefMeta.Camp); }
            if (VillageStatus.name().equalsIgnoreCase(classificationName)) { return OptionalThing.of(CDef.DefMeta.VillageStatus); }
            if (Skill.name().equalsIgnoreCase(classificationName)) { return OptionalThing.of(CDef.DefMeta.Skill); }
            if (MessageType.name().equalsIgnoreCase(classificationName)) { return OptionalThing.of(CDef.DefMeta.MessageType); }
            if (DeadReason.name().equalsIgnoreCase(classificationName)) { return OptionalThing.of(CDef.DefMeta.DeadReason); }
            if (AbilityType.name().equalsIgnoreCase(classificationName)) { return OptionalThing.of(CDef.DefMeta.AbilityType); }
            if (FaceType.name().equalsIgnoreCase(classificationName)) { return OptionalThing.of(CDef.DefMeta.FaceType); }
            if (VillageSettingItem.name().equalsIgnoreCase(classificationName)) { return OptionalThing.of(CDef.DefMeta.VillageSettingItem); }
            if (Noonnight.name().equalsIgnoreCase(classificationName)) { return OptionalThing.of(CDef.DefMeta.Noonnight); }
            if (Term.name().equalsIgnoreCase(classificationName)) { return OptionalThing.of(CDef.DefMeta.Term); }
            return OptionalThing.ofNullable(null, () -> {
                throw new ClassificationNotFoundException("Unknown classification: " + classificationName);
            });
        }

        public static CDef.DefMeta meta(String classificationName) { // old style so use find(name)
            if (classificationName == null) { throw new IllegalArgumentException("The argument 'classificationName' should not be null."); }
            if (Authority.name().equalsIgnoreCase(classificationName)) { return CDef.DefMeta.Authority; }
            if (Camp.name().equalsIgnoreCase(classificationName)) { return CDef.DefMeta.Camp; }
            if (VillageStatus.name().equalsIgnoreCase(classificationName)) { return CDef.DefMeta.VillageStatus; }
            if (Skill.name().equalsIgnoreCase(classificationName)) { return CDef.DefMeta.Skill; }
            if (MessageType.name().equalsIgnoreCase(classificationName)) { return CDef.DefMeta.MessageType; }
            if (DeadReason.name().equalsIgnoreCase(classificationName)) { return CDef.DefMeta.DeadReason; }
            if (AbilityType.name().equalsIgnoreCase(classificationName)) { return CDef.DefMeta.AbilityType; }
            if (FaceType.name().equalsIgnoreCase(classificationName)) { return CDef.DefMeta.FaceType; }
            if (VillageSettingItem.name().equalsIgnoreCase(classificationName)) { return CDef.DefMeta.VillageSettingItem; }
            if (Noonnight.name().equalsIgnoreCase(classificationName)) { return CDef.DefMeta.Noonnight; }
            if (Term.name().equalsIgnoreCase(classificationName)) { return CDef.DefMeta.Term; }
            throw new IllegalStateException("Unknown classification: " + classificationName);
        }

        @SuppressWarnings("unused")
        private String[] xinternalEmptyString() {
            return emptyStrings(); // to suppress 'unused' warning of import statement
        }
    }
}
